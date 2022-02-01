package com.tencent.mm.plugin.masssend.a;

import android.content.ContentValues;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.b.b;
import com.tencent.mm.ak.b.c;
import com.tencent.mm.ak.n;
import com.tencent.mm.ak.n.a;
import com.tencent.mm.ak.n.b;
import com.tencent.mm.compatible.util.f.a;
import com.tencent.mm.model.bc;
import com.tencent.mm.modelvideo.t;
import com.tencent.mm.modelvideo.t.b;
import com.tencent.mm.modelvoice.s;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.mm.protocal.protobuf.byx;
import com.tencent.mm.protocal.protobuf.byy;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.storage.au;
import com.tencent.mm.storage.br;
import junit.framework.Assert;

public final class f
  extends n
  implements k
{
  private com.tencent.mm.ak.f callback;
  f.a gIr;
  boolean hmD;
  private int icr;
  int ixa;
  int retCode;
  public com.tencent.mm.ak.b rr;
  private a vTo;
  
  public f(a parama, boolean paramBoolean)
  {
    this(parama, paramBoolean, 0);
  }
  
  public f(a parama, boolean paramBoolean, int paramInt)
  {
    AppMethodBeat.i(26360);
    this.vTo = null;
    this.gIr = null;
    this.retCode = 0;
    this.ixa = 0;
    this.hmD = false;
    this.vTo = parama;
    this.icr = paramInt;
    parama.createTime = bu.fpO();
    if (parama.msgType == 43)
    {
      parama.status = 104;
      com.tencent.mm.modelvideo.o.aNh();
      parama.vTk = t.HL(t.HK(parama.dnL()));
      com.tencent.mm.modelvideo.o.aNh();
      parama.cSL = t.HL(t.HJ(parama.dnL()));
      this.ixa = 2500;
      if (parama.videoSource == 2) {
        this.ixa = 2500;
      }
    }
    Object localObject;
    for (;;)
    {
      localObject = new b.a();
      ((b.a)localObject).hQF = new byx();
      ((b.a)localObject).hQG = new byy();
      ((b.a)localObject).uri = "/cgi-bin/micromsg-bin/masssend";
      ((b.a)localObject).funcId = 193;
      ((b.a)localObject).hQH = 84;
      ((b.a)localObject).respCmdId = 1000000084;
      this.rr = ((b.a)localObject).aDS();
      localObject = (byx)this.rr.hQD.hQJ;
      ((byx)localObject).HlA = com.tencent.mm.b.g.getMessageDigest(parama.dnN().getBytes());
      ((byx)localObject).HlL = parama.vTh;
      ((byx)localObject).Hlz = parama.dnN();
      parama.iqo = bu.fpO();
      ((byx)localObject).HlB = parama.dnK();
      ((byx)localObject).urJ = parama.msgType;
      ((byx)localObject).HlC = parama.vTi;
      if (!paramBoolean) {
        break label550;
      }
      i = j;
      label302:
      ((byx)localObject).HlM = i;
      ((byx)localObject).GUb = paramInt;
      this.gIr = new f.a();
      AppMethodBeat.o(26360);
      return;
      if (parama.msgType != 34) {
        break;
      }
      this.ixa = 40;
      parama.status = 104;
      parama.cSL = com.tencent.mm.modelvoice.q.HL(parama.dnL());
      parama.vTk = 0;
    }
    if (parama.msgType == 3)
    {
      this.ixa = 40;
      if (paramInt != 1) {
        break label556;
      }
      this.ixa = 1250;
    }
    label550:
    label556:
    for (int i = 1;; i = 0)
    {
      parama.vTl = i;
      parama.status = 104;
      parama.vTk = 0;
      localObject = new StringBuilder();
      bc.aCg();
      parama.cSL = ((int)com.tencent.mm.vfs.o.aZR(com.tencent.mm.model.c.azQ() + parama.dnL()));
      break;
      if (parama.msgType == 1)
      {
        this.ixa = 1;
        parama.status = 104;
        parama.cSL = parama.dnL().getBytes().length;
        parama.vTk = 0;
        break;
      }
      ae.d("MicroMsg.NetSceneMasSend", "error msgtype:" + parama.msgType);
      Assert.assertTrue("error msgtype:" + parama.msgType, false);
      break;
      i = 0;
      break label302;
    }
  }
  
  public final void cancel()
  {
    this.hmD = true;
  }
  
  public final int doScene(e parame, com.tencent.mm.ak.f paramf)
  {
    int j = 0;
    int i = 0;
    AppMethodBeat.i(26361);
    this.callback = paramf;
    if (this.hmD)
    {
      ae.d("MicroMsg.NetSceneMasSend", "isCancel");
      this.retCode = (0 - (com.tencent.mm.compatible.util.f.getLine() + 10000));
      AppMethodBeat.o(26361);
      return -1;
    }
    this.ixa -= 1;
    if (this.ixa < 0)
    {
      ae.d("MicroMsg.NetSceneMasSend", "MAX_SEND_TIMES");
      this.retCode = (0 - (com.tencent.mm.compatible.util.f.getLine() + 10000));
      AppMethodBeat.o(26361);
      return -1;
    }
    if (this.vTo == null)
    {
      ae.d("MicroMsg.NetSceneMasSend", "MasSendInfo is null");
      this.retCode = (0 - (com.tencent.mm.compatible.util.f.getLine() + 10000));
      AppMethodBeat.o(26361);
      return -1;
    }
    if (bu.isNullOrNil(this.vTo.dnN()))
    {
      ae.d("MicroMsg.NetSceneMasSend", "MasSendInfo.toList is null");
      this.retCode = (0 - (com.tencent.mm.compatible.util.f.getLine() + 10000));
      AppMethodBeat.o(26361);
      return -1;
    }
    if (this.vTo.vTh == 0)
    {
      ae.d("MicroMsg.NetSceneMasSend", "getTolistCount is 0");
      this.retCode = (0 - (com.tencent.mm.compatible.util.f.getLine() + 10000));
      AppMethodBeat.o(26361);
      return -1;
    }
    if (this.vTo.cSL <= 0)
    {
      ae.d("MicroMsg.NetSceneMasSend", "getDataLen is 0");
      this.retCode = (0 - (com.tencent.mm.compatible.util.f.getLine() + 10000));
      AppMethodBeat.o(26361);
      return -1;
    }
    if ((this.vTo.status == 103) && (this.vTo.vTk <= 0))
    {
      ae.d("MicroMsg.NetSceneMasSend", "getThumbTotalLen is 0");
      this.retCode = (0 - (com.tencent.mm.compatible.util.f.getLine() + 10000));
      AppMethodBeat.o(26361);
      return -1;
    }
    if ((this.vTo.status != 103) && (this.vTo.status != 104))
    {
      ae.d("MicroMsg.NetSceneMasSend", "msg type :" + this.vTo.msgType);
      this.retCode = (0 - (com.tencent.mm.compatible.util.f.getLine() + 10000));
      AppMethodBeat.o(26361);
      return -1;
    }
    paramf = (byx)this.rr.hQD.hQJ;
    Object localObject1;
    Object localObject2;
    if (this.vTo.msgType == 43)
    {
      localObject1 = this.vTo.dnL();
      if (bu.isNullOrNil((String)localObject1))
      {
        ae.d("MicroMsg.NetSceneMasSend", "MasSendInfo.fileName is null");
        this.retCode = (0 - (com.tencent.mm.compatible.util.f.getLine() + 10000));
        i = -1;
      }
      for (;;)
      {
        if (i == 0) {
          break label2254;
        }
        AppMethodBeat.o(26361);
        return i;
        paramf.HlD = new SKBuiltinBuffer_t();
        paramf.HlE = 0;
        paramf.HlI = new SKBuiltinBuffer_t();
        paramf.HlH = 0;
        paramf.HlJ = 2;
        paramf.HlC = this.vTo.vTi;
        if (this.vTo.videoSource > 0) {}
        for (i = 2;; i = 0)
        {
          paramf.HlK = i;
          paramf.HlG = this.vTo.vTk;
          paramf.HlF = this.vTo.cSL;
          if (this.vTo.status != 103) {
            break label879;
          }
          com.tencent.mm.modelvideo.o.aNh();
          localObject2 = t.t(t.HK((String)localObject1), this.vTo.iwV, 8000);
          if ((((t.b)localObject2).ret >= 0) && (((t.b)localObject2).diR != 0)) {
            break label647;
          }
          ae.e("MicroMsg.NetSceneMasSend", "doScene READ THUMB[" + (String)localObject1 + "]  Error ");
          this.retCode = (0 - (com.tencent.mm.compatible.util.f.getLine() + 10000));
          i = -1;
          break;
        }
        label647:
        ae.d("MicroMsg.NetSceneMasSend", "doScene READ THUMB[" + (String)localObject1 + "] read ret:" + ((t.b)localObject2).ret + " readlen:" + ((t.b)localObject2).diR + " newOff:" + ((t.b)localObject2).ixC + " netOff:" + this.vTo.iwV);
        if (((t.b)localObject2).ixC >= this.vTo.iwV) {
          break;
        }
        ae.e("MicroMsg.NetSceneMasSend", "Err doScene READ THUMB[" + (String)localObject1 + "] newOff:" + ((t.b)localObject2).ixC + " OldtOff:" + this.vTo.iwV);
        this.retCode = (0 - (com.tencent.mm.compatible.util.f.getLine() + 10000));
        i = -1;
      }
      localObject1 = new byte[((t.b)localObject2).diR];
      System.arraycopy(((t.b)localObject2).buf, 0, localObject1, 0, ((t.b)localObject2).diR);
      paramf.HlH = this.vTo.iwV;
      localObject2 = new SKBuiltinBuffer_t();
      ((SKBuiltinBuffer_t)localObject2).setBuffer((byte[])localObject1);
      paramf.HlI = ((SKBuiltinBuffer_t)localObject2);
      for (;;)
      {
        i = 0;
        break;
        label879:
        com.tencent.mm.modelvideo.o.aNh();
        localObject2 = t.t(t.HJ((String)localObject1), this.vTo.vTj, 8000);
        if ((((t.b)localObject2).ret < 0) || (((t.b)localObject2).diR == 0))
        {
          ae.e("MicroMsg.NetSceneMasSend", "doScene READ VIDEO[" + (String)localObject1 + "]  Error ");
          this.retCode = (0 - (com.tencent.mm.compatible.util.f.getLine() + 10000));
          i = -1;
          break;
        }
        ae.d("MicroMsg.NetSceneMasSend", "doScene READ VIDEO[" + (String)localObject1 + "] read ret:" + ((t.b)localObject2).ret + " readlen:" + ((t.b)localObject2).diR + " newOff:" + ((t.b)localObject2).ixC + " netOff:" + this.vTo.vTj);
        if (((t.b)localObject2).ixC < this.vTo.vTj)
        {
          ae.e("MicroMsg.NetSceneMasSend", "Err doScene READ VIDEO[" + (String)localObject1 + "] newOff:" + ((t.b)localObject2).ixC + " OldtOff:" + this.vTo.vTj);
          this.retCode = (0 - (com.tencent.mm.compatible.util.f.getLine() + 10000));
          i = -1;
          break;
        }
        if (((t.b)localObject2).ixC >= com.tencent.mm.modelvideo.c.iuA)
        {
          ae.e("MicroMsg.NetSceneMasSend", "Err doScene READ VIDEO[" + (String)localObject1 + "] maxsize:" + com.tencent.mm.modelvideo.c.iuA);
          this.retCode = (0 - (com.tencent.mm.compatible.util.f.getLine() + 10000));
          i = -1;
          break;
        }
        localObject1 = new byte[((t.b)localObject2).diR];
        System.arraycopy(((t.b)localObject2).buf, 0, localObject1, 0, ((t.b)localObject2).diR);
        paramf.HlE = this.vTo.vTj;
        paramf.HlH = this.vTo.iwV;
        localObject2 = new SKBuiltinBuffer_t();
        ((SKBuiltinBuffer_t)localObject2).setBuffer((byte[])localObject1);
        paramf.HlD = ((SKBuiltinBuffer_t)localObject2);
      }
    }
    if (this.vTo.msgType == 34)
    {
      paramf.HlJ = 0;
      paramf.HlK = 0;
      paramf.HlD = new SKBuiltinBuffer_t().setBuffer(new byte[0]);
      paramf.HlE = 0;
      paramf.HlI = new SKBuiltinBuffer_t().setBuffer(new byte[0]);
      paramf.HlH = 0;
      paramf.HlG = 0;
      paramf.HlF = this.vTo.cSL;
      localObject1 = s.It(this.vTo.dnL());
      if (localObject1 == null)
      {
        this.retCode = (0 - (com.tencent.mm.compatible.util.f.getLine() + 10000));
        ae.d("MicroMsg.NetSceneMasSend", "fileop is null");
        i = -1;
      }
      while (i != 0)
      {
        AppMethodBeat.o(26361);
        return -1;
        localObject2 = ((com.tencent.mm.modelvoice.b)localObject1).dr(this.vTo.vTj, 8000);
        if (((com.tencent.mm.modelvoice.g)localObject2).ret < 0)
        {
          ae.e("MicroMsg.NetSceneMasSend", "Err doScene READ file[" + this.vTo.dnL() + "] read ret:" + ((com.tencent.mm.modelvoice.g)localObject2).ret + " readlen:" + ((com.tencent.mm.modelvoice.g)localObject2).diR + " newOff:" + ((com.tencent.mm.modelvoice.g)localObject2).ixC + " netOff:" + this.vTo.vTj);
          this.retCode = (0 - (com.tencent.mm.compatible.util.f.getLine() + 10000));
          i = -1;
        }
        else if ((((com.tencent.mm.modelvoice.g)localObject2).ixC < this.vTo.vTj) || (((com.tencent.mm.modelvoice.g)localObject2).ixC >= 469000))
        {
          ae.e("MicroMsg.NetSceneMasSend", "Err doScene READ offseterror file[" + this.vTo.dnL() + "] read ret:" + ((com.tencent.mm.modelvoice.g)localObject2).ret + " readlen:" + ((com.tencent.mm.modelvoice.g)localObject2).diR + " newOff:" + ((com.tencent.mm.modelvoice.g)localObject2).ixC + " netOff:" + this.vTo.vTj);
          this.retCode = (0 - (com.tencent.mm.compatible.util.f.getLine() + 10000));
          i = -1;
        }
        else if (this.vTo.cSL <= 0)
        {
          ae.e("MicroMsg.NetSceneMasSend", "Err doScene READ datalen file[" + this.vTo.dnL() + "] read totalLen:" + this.vTo.cSL);
          this.retCode = (com.tencent.mm.compatible.util.f.getLine() + 10000);
          i = -1;
        }
        else
        {
          byte[] arrayOfByte = new byte[((com.tencent.mm.modelvoice.g)localObject2).diR];
          System.arraycopy(((com.tencent.mm.modelvoice.g)localObject2).buf, 0, arrayOfByte, 0, ((com.tencent.mm.modelvoice.g)localObject2).diR);
          paramf.HlD = new SKBuiltinBuffer_t().setBuffer(arrayOfByte);
          paramf.HlC = this.vTo.vTi;
          paramf.HlE = this.vTo.vTj;
          paramf.HlN = ((com.tencent.mm.modelvoice.b)localObject1).getFormat();
        }
      }
    }
    if (this.vTo.msgType == 3)
    {
      if (bu.isNullOrNil(this.vTo.dnL()))
      {
        ae.d("MicroMsg.NetSceneMasSend", "getFilename is null");
        this.retCode = (0 - (com.tencent.mm.compatible.util.f.getLine() + 10000));
        i = -1;
      }
      while (i != 0)
      {
        AppMethodBeat.o(26361);
        return -1;
        paramf.HlJ = 0;
        paramf.HlK = 0;
        paramf.HlD = new SKBuiltinBuffer_t().setBuffer(new byte[0]);
        paramf.HlE = 0;
        paramf.HlI = new SKBuiltinBuffer_t().setBuffer(new byte[0]);
        paramf.HlH = 0;
        paramf.HlG = 0;
        paramf.HlC = 0;
        paramf.HlG = this.vTo.vTk;
        paramf.HlF = this.vTo.cSL;
        paramf.GUb = this.icr;
        localObject1 = new StringBuilder();
        bc.aCg();
        localObject1 = com.tencent.mm.model.c.azQ() + this.vTo.dnL();
        int k = this.vTo.cSL - this.vTo.vTj;
        i = k;
        if (k > 8000) {
          i = 8000;
        }
        localObject1 = com.tencent.mm.vfs.o.bb((String)localObject1, this.vTo.vTj, i);
        if (bu.cF((byte[])localObject1))
        {
          ae.e("MicroMsg.NetSceneMasSend", "doScene READ data[" + this.vTo.dnL() + "]  Error ");
          this.retCode = (0 - (com.tencent.mm.compatible.util.f.getLine() + 10000));
          i = -1;
        }
        else
        {
          paramf.HlE = this.vTo.vTj;
          paramf.HlH = this.vTo.iwV;
          localObject2 = new SKBuiltinBuffer_t();
          ((SKBuiltinBuffer_t)localObject2).setBuffer((byte[])localObject1);
          paramf.HlD = ((SKBuiltinBuffer_t)localObject2);
          i = j;
        }
      }
    }
    if (this.vTo.msgType == 1)
    {
      paramf.HlD = new SKBuiltinBuffer_t().setBuffer(this.vTo.dnL().getBytes());
      paramf.HlF = this.vTo.cSL;
      paramf.HlC = 0;
      paramf.HlE = 0;
      paramf.HlI = new SKBuiltinBuffer_t().setBuffer(new byte[0]);
      paramf.HlH = 0;
      paramf.HlG = 0;
      paramf.HlJ = 0;
      paramf.HlK = 0;
      label2254:
      i = dispatch(parame, this.rr, this);
      AppMethodBeat.o(26361);
      return i;
    }
    ae.d("MicroMsg.NetSceneMasSend", "error msgtype:" + this.vTo.msgType);
    this.retCode = (0 - (com.tencent.mm.compatible.util.f.getLine() + 10000));
    AppMethodBeat.o(26361);
    return -1;
  }
  
  public final int getType()
  {
    return 193;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, com.tencent.mm.network.q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(26362);
    ae.d("MicroMsg.NetSceneMasSend", "onGYNetEnd  errtype:" + paramInt2 + " errCode:" + paramInt3);
    updateDispatchId(paramInt1);
    if ((paramInt2 != 0) || (paramInt3 != 0))
    {
      ae.e("MicroMsg.NetSceneMasSend", "ERR: onGYNetEnd FAILED errtype:" + paramInt2 + " errCode:" + paramInt3);
      this.retCode = (0 - com.tencent.mm.compatible.util.f.getLine() - 10000);
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(26362);
      return;
    }
    if (this.vTo == null)
    {
      ae.e("MicroMsg.NetSceneMasSend", "ERR: onGYNetEnd Get INFO FAILED :");
      this.retCode = (0 - com.tencent.mm.compatible.util.f.getLine() - 10000);
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(26362);
      return;
    }
    if ((this.vTo.status != 104) && (this.vTo.status != 103))
    {
      ae.e("MicroMsg.NetSceneMasSend", "ERR: onGYNetEnd STATUS ERR: status:" + this.vTo.status);
      this.retCode = (0 - com.tencent.mm.compatible.util.f.getLine() - 10000);
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(26362);
      return;
    }
    paramArrayOfByte = (byy)this.rr.hQE.hQJ;
    paramq = (byx)this.rr.hQD.hQJ;
    if ((paramq.HlG > 0) && (paramq.HlI != null) && (paramq.HlI.getBuffer() != null) && (!bu.cF(paramq.HlI.getBuffer().toByteArray())) && (paramq.HlH != paramArrayOfByte.HlH - paramq.HlI.getILen()))
    {
      ae.e("MicroMsg.NetSceneMasSend", "onGYNetEnd Err Thumb ");
      this.retCode = (0 - com.tencent.mm.compatible.util.f.getLine() - 10000);
      this.callback.onSceneEnd(3, -1, "doScene failed", this);
      AppMethodBeat.o(26362);
      return;
    }
    if ((paramq.HlF > 0) && (paramq.HlD != null) && (paramq.HlD.getBuffer() != null) && (!bu.cF(paramq.HlD.getBuffer().toByteArray())) && (paramq.HlE != paramArrayOfByte.HlE - paramq.HlD.getILen()))
    {
      ae.e("MicroMsg.NetSceneMasSend", "onGYNetEnd Err Data ");
      this.retCode = (0 - com.tencent.mm.compatible.util.f.getLine() - 10000);
      this.callback.onSceneEnd(3, -1, "doScene failed", this);
      AppMethodBeat.o(26362);
      return;
    }
    this.vTo.iwX = bu.aRi();
    paramInt1 = this.vTo.status;
    if (paramInt1 == 103)
    {
      paramArrayOfByte = this.vTo;
      paramInt1 = paramq.HlH;
      paramArrayOfByte.iwV = (paramq.HlI.getILen() + paramInt1);
      if (this.vTo.iwV >= this.vTo.vTk) {
        this.vTo.status = 199;
      }
    }
    while (this.vTo.status != 199)
    {
      if (doScene(dispatcher(), this.callback) != -1) {
        break label1523;
      }
      this.retCode = (0 - (com.tencent.mm.compatible.util.f.getLine() + 10000));
      this.callback.onSceneEnd(3, -1, "doScene failed", this);
      AppMethodBeat.o(26362);
      return;
      if (paramInt1 == 104)
      {
        paramArrayOfByte = this.vTo;
        paramInt1 = paramq.HlE;
        paramArrayOfByte.vTj = (paramq.HlD.getILen() + paramInt1);
        if (this.vTo.vTj >= this.vTo.cSL) {
          if (this.vTo.vTk > 0) {
            this.vTo.status = 103;
          } else {
            this.vTo.status = 199;
          }
        }
      }
      else
      {
        ae.e("MicroMsg.NetSceneMasSend", "onGYNetEnd ERROR STATUS:".concat(String.valueOf(paramInt1)));
        this.retCode = (0 - com.tencent.mm.compatible.util.f.getLine() - 10000);
        this.callback.onSceneEnd(3, -1, "doScene failed", this);
        AppMethodBeat.o(26362);
        return;
      }
    }
    paramArrayOfByte = h.dnT();
    a locala = this.vTo;
    if (locala != null)
    {
      locala.dEu = -1;
      ContentValues localContentValues = new ContentValues();
      if ((locala.dEu & 0x1) != 0) {
        localContentValues.put("clientid", locala.dnK());
      }
      if ((locala.dEu & 0x2) != 0) {
        localContentValues.put("status", Integer.valueOf(locala.status));
      }
      if ((locala.dEu & 0x4) != 0) {
        localContentValues.put("createtime", Long.valueOf(locala.createTime));
      }
      if ((locala.dEu & 0x8) != 0) {
        localContentValues.put("lastmodifytime", Long.valueOf(locala.iwX));
      }
      if ((locala.dEu & 0x10) != 0) {
        localContentValues.put("filename", locala.dnL());
      }
      if ((locala.dEu & 0x20) != 0) {
        localContentValues.put("thumbfilename", locala.dnM());
      }
      if ((locala.dEu & 0x40) != 0) {
        localContentValues.put("tolist", locala.dnN());
      }
      if ((locala.dEu & 0x80) != 0) {
        localContentValues.put("tolistcount", Integer.valueOf(locala.vTh));
      }
      if ((locala.dEu & 0x100) != 0) {
        localContentValues.put("msgtype", Integer.valueOf(locala.msgType));
      }
      if ((locala.dEu & 0x200) != 0) {
        localContentValues.put("mediatime", Integer.valueOf(locala.vTi));
      }
      if ((locala.dEu & 0x400) != 0) {
        localContentValues.put("datanetoffset", Integer.valueOf(locala.vTj));
      }
      if ((locala.dEu & 0x800) != 0) {
        localContentValues.put("datalen", Integer.valueOf(locala.cSL));
      }
      if ((locala.dEu & 0x1000) != 0) {
        localContentValues.put("thumbnetoffset", Integer.valueOf(locala.iwV));
      }
      if ((locala.dEu & 0x2000) != 0) {
        localContentValues.put("thumbtotallen", Integer.valueOf(locala.vTk));
      }
      if ((locala.dEu & 0x4000) != 0) {
        localContentValues.put("reserved1", Integer.valueOf(locala.videoSource));
      }
      if ((locala.dEu & 0x8000) != 0) {
        localContentValues.put("reserved2", Integer.valueOf(locala.vTl));
      }
      if ((locala.dEu & 0x10000) != 0)
      {
        if (locala.hKF != null) {
          break label1471;
        }
        paramq = "";
        localContentValues.put("reserved3", paramq);
      }
      if ((locala.dEu & 0x20000) != 0)
      {
        if (locala.hKG != null) {
          break label1481;
        }
        paramq = "";
        label1294:
        localContentValues.put("reserved4", paramq);
      }
      if ((int)paramArrayOfByte.hKK.a("massendinfo", "clientid", localContentValues) != -1)
      {
        bc.aCg();
        if (com.tencent.mm.model.c.azL().aVa("masssendapp") != null) {
          break label1491;
        }
        paramInt1 = 1;
        label1345:
        paramq = new au();
        paramq.setUsername("masssendapp");
        paramq.setContent(b.a(locala));
        paramq.qH(locala.createTime);
        paramq.kt(0);
        paramq.kr(0);
        if (paramInt1 == 0) {
          break label1496;
        }
        bc.aCg();
        com.tencent.mm.model.c.azL().e(paramq);
        label1413:
        paramArrayOfByte.doNotify();
      }
    }
    if (this.gIr != null) {}
    for (long l = this.gIr.abs();; l = 0L)
    {
      ae.d("MicroMsg.NetSceneMasSend", "!!!FIN: useTime:".concat(String.valueOf(l)));
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(26362);
      return;
      label1471:
      paramq = locala.hKF;
      break;
      label1481:
      paramq = locala.hKG;
      break label1294;
      label1491:
      paramInt1 = 0;
      break label1345;
      label1496:
      bc.aCg();
      com.tencent.mm.model.c.azL().a(paramq, "masssendapp");
      break label1413;
    }
    label1523:
    AppMethodBeat.o(26362);
  }
  
  public final int securityLimitCount()
  {
    return 2500;
  }
  
  public final n.b securityVerificationChecked(com.tencent.mm.network.q paramq)
  {
    return n.b.hRi;
  }
  
  public final void setSecurityCheckError(n.a parama) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.masssend.a.f
 * JD-Core Version:    0.7.0.1
 */