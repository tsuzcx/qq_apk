package com.tencent.mm.plugin.masssend.a;

import android.content.ContentValues;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b.a;
import com.tencent.mm.al.b.b;
import com.tencent.mm.al.b.c;
import com.tencent.mm.al.n;
import com.tencent.mm.al.n.a;
import com.tencent.mm.al.n.b;
import com.tencent.mm.compatible.util.f.a;
import com.tencent.mm.model.ba;
import com.tencent.mm.modelvideo.o;
import com.tencent.mm.modelvideo.t;
import com.tencent.mm.modelvideo.t.b;
import com.tencent.mm.modelvoice.s;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.mm.protocal.protobuf.byd;
import com.tencent.mm.protocal.protobuf.bye;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.at;
import com.tencent.mm.storage.bq;
import com.tencent.mm.vfs.i;
import junit.framework.Assert;

public final class f
  extends n
  implements k
{
  private com.tencent.mm.al.f callback;
  f.a gFK;
  private int hZz;
  boolean hjP;
  int iug;
  int retCode;
  public com.tencent.mm.al.b rr;
  private a vHk;
  
  public f(a parama, boolean paramBoolean)
  {
    this(parama, paramBoolean, 0);
  }
  
  public f(a parama, boolean paramBoolean, int paramInt)
  {
    AppMethodBeat.i(26360);
    this.vHk = null;
    this.gFK = null;
    this.retCode = 0;
    this.iug = 0;
    this.hjP = false;
    this.vHk = parama;
    this.hZz = paramInt;
    parama.createTime = bt.flT();
    if (parama.msgType == 43)
    {
      parama.status = 104;
      o.aMJ();
      parama.vHg = t.Hj(t.Hi(parama.dkL()));
      o.aMJ();
      parama.cSb = t.Hj(t.Hh(parama.dkL()));
      this.iug = 2500;
      if (parama.videoSource == 2) {
        this.iug = 2500;
      }
    }
    Object localObject;
    for (;;)
    {
      localObject = new b.a();
      ((b.a)localObject).hNM = new byd();
      ((b.a)localObject).hNN = new bye();
      ((b.a)localObject).uri = "/cgi-bin/micromsg-bin/masssend";
      ((b.a)localObject).funcId = 193;
      ((b.a)localObject).hNO = 84;
      ((b.a)localObject).respCmdId = 1000000084;
      this.rr = ((b.a)localObject).aDC();
      localObject = (byd)this.rr.hNK.hNQ;
      ((byd)localObject).GRZ = com.tencent.mm.b.g.getMessageDigest(parama.dkN().getBytes());
      ((byd)localObject).GSk = parama.vHd;
      ((byd)localObject).GRY = parama.dkN();
      parama.inu = bt.flT();
      ((byd)localObject).GSa = parama.dkK();
      ((byd)localObject).ugm = parama.msgType;
      ((byd)localObject).GSb = parama.vHe;
      if (!paramBoolean) {
        break label550;
      }
      i = j;
      label302:
      ((byd)localObject).GSl = i;
      ((byd)localObject).GAB = paramInt;
      this.gFK = new f.a();
      AppMethodBeat.o(26360);
      return;
      if (parama.msgType != 34) {
        break;
      }
      this.iug = 40;
      parama.status = 104;
      parama.cSb = com.tencent.mm.modelvoice.q.Hj(parama.dkL());
      parama.vHg = 0;
    }
    if (parama.msgType == 3)
    {
      this.iug = 40;
      if (paramInt != 1) {
        break label556;
      }
      this.iug = 1250;
    }
    label550:
    label556:
    for (int i = 1;; i = 0)
    {
      parama.vHh = i;
      parama.status = 104;
      parama.vHg = 0;
      localObject = new StringBuilder();
      ba.aBQ();
      parama.cSb = ((int)i.aYo(com.tencent.mm.model.c.azA() + parama.dkL()));
      break;
      if (parama.msgType == 1)
      {
        this.iug = 1;
        parama.status = 104;
        parama.cSb = parama.dkL().getBytes().length;
        parama.vHg = 0;
        break;
      }
      ad.d("MicroMsg.NetSceneMasSend", "error msgtype:" + parama.msgType);
      Assert.assertTrue("error msgtype:" + parama.msgType, false);
      break;
      i = 0;
      break label302;
    }
  }
  
  public final void cancel()
  {
    this.hjP = true;
  }
  
  public final int doScene(e parame, com.tencent.mm.al.f paramf)
  {
    int j = 0;
    int i = 0;
    AppMethodBeat.i(26361);
    this.callback = paramf;
    if (this.hjP)
    {
      ad.d("MicroMsg.NetSceneMasSend", "isCancel");
      this.retCode = (0 - (com.tencent.mm.compatible.util.f.getLine() + 10000));
      AppMethodBeat.o(26361);
      return -1;
    }
    this.iug -= 1;
    if (this.iug < 0)
    {
      ad.d("MicroMsg.NetSceneMasSend", "MAX_SEND_TIMES");
      this.retCode = (0 - (com.tencent.mm.compatible.util.f.getLine() + 10000));
      AppMethodBeat.o(26361);
      return -1;
    }
    if (this.vHk == null)
    {
      ad.d("MicroMsg.NetSceneMasSend", "MasSendInfo is null");
      this.retCode = (0 - (com.tencent.mm.compatible.util.f.getLine() + 10000));
      AppMethodBeat.o(26361);
      return -1;
    }
    if (bt.isNullOrNil(this.vHk.dkN()))
    {
      ad.d("MicroMsg.NetSceneMasSend", "MasSendInfo.toList is null");
      this.retCode = (0 - (com.tencent.mm.compatible.util.f.getLine() + 10000));
      AppMethodBeat.o(26361);
      return -1;
    }
    if (this.vHk.vHd == 0)
    {
      ad.d("MicroMsg.NetSceneMasSend", "getTolistCount is 0");
      this.retCode = (0 - (com.tencent.mm.compatible.util.f.getLine() + 10000));
      AppMethodBeat.o(26361);
      return -1;
    }
    if (this.vHk.cSb <= 0)
    {
      ad.d("MicroMsg.NetSceneMasSend", "getDataLen is 0");
      this.retCode = (0 - (com.tencent.mm.compatible.util.f.getLine() + 10000));
      AppMethodBeat.o(26361);
      return -1;
    }
    if ((this.vHk.status == 103) && (this.vHk.vHg <= 0))
    {
      ad.d("MicroMsg.NetSceneMasSend", "getThumbTotalLen is 0");
      this.retCode = (0 - (com.tencent.mm.compatible.util.f.getLine() + 10000));
      AppMethodBeat.o(26361);
      return -1;
    }
    if ((this.vHk.status != 103) && (this.vHk.status != 104))
    {
      ad.d("MicroMsg.NetSceneMasSend", "msg type :" + this.vHk.msgType);
      this.retCode = (0 - (com.tencent.mm.compatible.util.f.getLine() + 10000));
      AppMethodBeat.o(26361);
      return -1;
    }
    paramf = (byd)this.rr.hNK.hNQ;
    Object localObject1;
    Object localObject2;
    if (this.vHk.msgType == 43)
    {
      localObject1 = this.vHk.dkL();
      if (bt.isNullOrNil((String)localObject1))
      {
        ad.d("MicroMsg.NetSceneMasSend", "MasSendInfo.fileName is null");
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
        paramf.GSc = new SKBuiltinBuffer_t();
        paramf.GSd = 0;
        paramf.GSh = new SKBuiltinBuffer_t();
        paramf.GSg = 0;
        paramf.GSi = 2;
        paramf.GSb = this.vHk.vHe;
        if (this.vHk.videoSource > 0) {}
        for (i = 2;; i = 0)
        {
          paramf.GSj = i;
          paramf.GSf = this.vHk.vHg;
          paramf.GSe = this.vHk.cSb;
          if (this.vHk.status != 103) {
            break label879;
          }
          o.aMJ();
          localObject2 = t.t(t.Hi((String)localObject1), this.vHk.iub, 8000);
          if ((((t.b)localObject2).ret >= 0) && (((t.b)localObject2).dhO != 0)) {
            break label647;
          }
          ad.e("MicroMsg.NetSceneMasSend", "doScene READ THUMB[" + (String)localObject1 + "]  Error ");
          this.retCode = (0 - (com.tencent.mm.compatible.util.f.getLine() + 10000));
          i = -1;
          break;
        }
        label647:
        ad.d("MicroMsg.NetSceneMasSend", "doScene READ THUMB[" + (String)localObject1 + "] read ret:" + ((t.b)localObject2).ret + " readlen:" + ((t.b)localObject2).dhO + " newOff:" + ((t.b)localObject2).iuI + " netOff:" + this.vHk.iub);
        if (((t.b)localObject2).iuI >= this.vHk.iub) {
          break;
        }
        ad.e("MicroMsg.NetSceneMasSend", "Err doScene READ THUMB[" + (String)localObject1 + "] newOff:" + ((t.b)localObject2).iuI + " OldtOff:" + this.vHk.iub);
        this.retCode = (0 - (com.tencent.mm.compatible.util.f.getLine() + 10000));
        i = -1;
      }
      localObject1 = new byte[((t.b)localObject2).dhO];
      System.arraycopy(((t.b)localObject2).buf, 0, localObject1, 0, ((t.b)localObject2).dhO);
      paramf.GSg = this.vHk.iub;
      localObject2 = new SKBuiltinBuffer_t();
      ((SKBuiltinBuffer_t)localObject2).setBuffer((byte[])localObject1);
      paramf.GSh = ((SKBuiltinBuffer_t)localObject2);
      for (;;)
      {
        i = 0;
        break;
        label879:
        o.aMJ();
        localObject2 = t.t(t.Hh((String)localObject1), this.vHk.vHf, 8000);
        if ((((t.b)localObject2).ret < 0) || (((t.b)localObject2).dhO == 0))
        {
          ad.e("MicroMsg.NetSceneMasSend", "doScene READ VIDEO[" + (String)localObject1 + "]  Error ");
          this.retCode = (0 - (com.tencent.mm.compatible.util.f.getLine() + 10000));
          i = -1;
          break;
        }
        ad.d("MicroMsg.NetSceneMasSend", "doScene READ VIDEO[" + (String)localObject1 + "] read ret:" + ((t.b)localObject2).ret + " readlen:" + ((t.b)localObject2).dhO + " newOff:" + ((t.b)localObject2).iuI + " netOff:" + this.vHk.vHf);
        if (((t.b)localObject2).iuI < this.vHk.vHf)
        {
          ad.e("MicroMsg.NetSceneMasSend", "Err doScene READ VIDEO[" + (String)localObject1 + "] newOff:" + ((t.b)localObject2).iuI + " OldtOff:" + this.vHk.vHf);
          this.retCode = (0 - (com.tencent.mm.compatible.util.f.getLine() + 10000));
          i = -1;
          break;
        }
        if (((t.b)localObject2).iuI >= com.tencent.mm.modelvideo.c.irG)
        {
          ad.e("MicroMsg.NetSceneMasSend", "Err doScene READ VIDEO[" + (String)localObject1 + "] maxsize:" + com.tencent.mm.modelvideo.c.irG);
          this.retCode = (0 - (com.tencent.mm.compatible.util.f.getLine() + 10000));
          i = -1;
          break;
        }
        localObject1 = new byte[((t.b)localObject2).dhO];
        System.arraycopy(((t.b)localObject2).buf, 0, localObject1, 0, ((t.b)localObject2).dhO);
        paramf.GSd = this.vHk.vHf;
        paramf.GSg = this.vHk.iub;
        localObject2 = new SKBuiltinBuffer_t();
        ((SKBuiltinBuffer_t)localObject2).setBuffer((byte[])localObject1);
        paramf.GSc = ((SKBuiltinBuffer_t)localObject2);
      }
    }
    if (this.vHk.msgType == 34)
    {
      paramf.GSi = 0;
      paramf.GSj = 0;
      paramf.GSc = new SKBuiltinBuffer_t().setBuffer(new byte[0]);
      paramf.GSd = 0;
      paramf.GSh = new SKBuiltinBuffer_t().setBuffer(new byte[0]);
      paramf.GSg = 0;
      paramf.GSf = 0;
      paramf.GSe = this.vHk.cSb;
      localObject1 = s.HR(this.vHk.dkL());
      if (localObject1 == null)
      {
        this.retCode = (0 - (com.tencent.mm.compatible.util.f.getLine() + 10000));
        ad.d("MicroMsg.NetSceneMasSend", "fileop is null");
        i = -1;
      }
      while (i != 0)
      {
        AppMethodBeat.o(26361);
        return -1;
        localObject2 = ((com.tencent.mm.modelvoice.b)localObject1).dr(this.vHk.vHf, 8000);
        if (((com.tencent.mm.modelvoice.g)localObject2).ret < 0)
        {
          ad.e("MicroMsg.NetSceneMasSend", "Err doScene READ file[" + this.vHk.dkL() + "] read ret:" + ((com.tencent.mm.modelvoice.g)localObject2).ret + " readlen:" + ((com.tencent.mm.modelvoice.g)localObject2).dhO + " newOff:" + ((com.tencent.mm.modelvoice.g)localObject2).iuI + " netOff:" + this.vHk.vHf);
          this.retCode = (0 - (com.tencent.mm.compatible.util.f.getLine() + 10000));
          i = -1;
        }
        else if ((((com.tencent.mm.modelvoice.g)localObject2).iuI < this.vHk.vHf) || (((com.tencent.mm.modelvoice.g)localObject2).iuI >= 469000))
        {
          ad.e("MicroMsg.NetSceneMasSend", "Err doScene READ offseterror file[" + this.vHk.dkL() + "] read ret:" + ((com.tencent.mm.modelvoice.g)localObject2).ret + " readlen:" + ((com.tencent.mm.modelvoice.g)localObject2).dhO + " newOff:" + ((com.tencent.mm.modelvoice.g)localObject2).iuI + " netOff:" + this.vHk.vHf);
          this.retCode = (0 - (com.tencent.mm.compatible.util.f.getLine() + 10000));
          i = -1;
        }
        else if (this.vHk.cSb <= 0)
        {
          ad.e("MicroMsg.NetSceneMasSend", "Err doScene READ datalen file[" + this.vHk.dkL() + "] read totalLen:" + this.vHk.cSb);
          this.retCode = (com.tencent.mm.compatible.util.f.getLine() + 10000);
          i = -1;
        }
        else
        {
          byte[] arrayOfByte = new byte[((com.tencent.mm.modelvoice.g)localObject2).dhO];
          System.arraycopy(((com.tencent.mm.modelvoice.g)localObject2).buf, 0, arrayOfByte, 0, ((com.tencent.mm.modelvoice.g)localObject2).dhO);
          paramf.GSc = new SKBuiltinBuffer_t().setBuffer(arrayOfByte);
          paramf.GSb = this.vHk.vHe;
          paramf.GSd = this.vHk.vHf;
          paramf.GSm = ((com.tencent.mm.modelvoice.b)localObject1).getFormat();
        }
      }
    }
    if (this.vHk.msgType == 3)
    {
      if (bt.isNullOrNil(this.vHk.dkL()))
      {
        ad.d("MicroMsg.NetSceneMasSend", "getFilename is null");
        this.retCode = (0 - (com.tencent.mm.compatible.util.f.getLine() + 10000));
        i = -1;
      }
      while (i != 0)
      {
        AppMethodBeat.o(26361);
        return -1;
        paramf.GSi = 0;
        paramf.GSj = 0;
        paramf.GSc = new SKBuiltinBuffer_t().setBuffer(new byte[0]);
        paramf.GSd = 0;
        paramf.GSh = new SKBuiltinBuffer_t().setBuffer(new byte[0]);
        paramf.GSg = 0;
        paramf.GSf = 0;
        paramf.GSb = 0;
        paramf.GSf = this.vHk.vHg;
        paramf.GSe = this.vHk.cSb;
        paramf.GAB = this.hZz;
        localObject1 = new StringBuilder();
        ba.aBQ();
        localObject1 = com.tencent.mm.model.c.azA() + this.vHk.dkL();
        int k = this.vHk.cSb - this.vHk.vHf;
        i = k;
        if (k > 8000) {
          i = 8000;
        }
        localObject1 = i.aY((String)localObject1, this.vHk.vHf, i);
        if (bt.cC((byte[])localObject1))
        {
          ad.e("MicroMsg.NetSceneMasSend", "doScene READ data[" + this.vHk.dkL() + "]  Error ");
          this.retCode = (0 - (com.tencent.mm.compatible.util.f.getLine() + 10000));
          i = -1;
        }
        else
        {
          paramf.GSd = this.vHk.vHf;
          paramf.GSg = this.vHk.iub;
          localObject2 = new SKBuiltinBuffer_t();
          ((SKBuiltinBuffer_t)localObject2).setBuffer((byte[])localObject1);
          paramf.GSc = ((SKBuiltinBuffer_t)localObject2);
          i = j;
        }
      }
    }
    if (this.vHk.msgType == 1)
    {
      paramf.GSc = new SKBuiltinBuffer_t().setBuffer(this.vHk.dkL().getBytes());
      paramf.GSe = this.vHk.cSb;
      paramf.GSb = 0;
      paramf.GSd = 0;
      paramf.GSh = new SKBuiltinBuffer_t().setBuffer(new byte[0]);
      paramf.GSg = 0;
      paramf.GSf = 0;
      paramf.GSi = 0;
      paramf.GSj = 0;
      label2254:
      i = dispatch(parame, this.rr, this);
      AppMethodBeat.o(26361);
      return i;
    }
    ad.d("MicroMsg.NetSceneMasSend", "error msgtype:" + this.vHk.msgType);
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
    ad.d("MicroMsg.NetSceneMasSend", "onGYNetEnd  errtype:" + paramInt2 + " errCode:" + paramInt3);
    updateDispatchId(paramInt1);
    if ((paramInt2 != 0) || (paramInt3 != 0))
    {
      ad.e("MicroMsg.NetSceneMasSend", "ERR: onGYNetEnd FAILED errtype:" + paramInt2 + " errCode:" + paramInt3);
      this.retCode = (0 - com.tencent.mm.compatible.util.f.getLine() - 10000);
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(26362);
      return;
    }
    if (this.vHk == null)
    {
      ad.e("MicroMsg.NetSceneMasSend", "ERR: onGYNetEnd Get INFO FAILED :");
      this.retCode = (0 - com.tencent.mm.compatible.util.f.getLine() - 10000);
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(26362);
      return;
    }
    if ((this.vHk.status != 104) && (this.vHk.status != 103))
    {
      ad.e("MicroMsg.NetSceneMasSend", "ERR: onGYNetEnd STATUS ERR: status:" + this.vHk.status);
      this.retCode = (0 - com.tencent.mm.compatible.util.f.getLine() - 10000);
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(26362);
      return;
    }
    paramArrayOfByte = (bye)this.rr.hNL.hNQ;
    paramq = (byd)this.rr.hNK.hNQ;
    if ((paramq.GSf > 0) && (paramq.GSh != null) && (paramq.GSh.getBuffer() != null) && (!bt.cC(paramq.GSh.getBuffer().toByteArray())) && (paramq.GSg != paramArrayOfByte.GSg - paramq.GSh.getILen()))
    {
      ad.e("MicroMsg.NetSceneMasSend", "onGYNetEnd Err Thumb ");
      this.retCode = (0 - com.tencent.mm.compatible.util.f.getLine() - 10000);
      this.callback.onSceneEnd(3, -1, "doScene failed", this);
      AppMethodBeat.o(26362);
      return;
    }
    if ((paramq.GSe > 0) && (paramq.GSc != null) && (paramq.GSc.getBuffer() != null) && (!bt.cC(paramq.GSc.getBuffer().toByteArray())) && (paramq.GSd != paramArrayOfByte.GSd - paramq.GSc.getILen()))
    {
      ad.e("MicroMsg.NetSceneMasSend", "onGYNetEnd Err Data ");
      this.retCode = (0 - com.tencent.mm.compatible.util.f.getLine() - 10000);
      this.callback.onSceneEnd(3, -1, "doScene failed", this);
      AppMethodBeat.o(26362);
      return;
    }
    this.vHk.iud = bt.aQJ();
    paramInt1 = this.vHk.status;
    if (paramInt1 == 103)
    {
      paramArrayOfByte = this.vHk;
      paramInt1 = paramq.GSg;
      paramArrayOfByte.iub = (paramq.GSh.getILen() + paramInt1);
      if (this.vHk.iub >= this.vHk.vHg) {
        this.vHk.status = 199;
      }
    }
    while (this.vHk.status != 199)
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
        paramArrayOfByte = this.vHk;
        paramInt1 = paramq.GSd;
        paramArrayOfByte.vHf = (paramq.GSc.getILen() + paramInt1);
        if (this.vHk.vHf >= this.vHk.cSb) {
          if (this.vHk.vHg > 0) {
            this.vHk.status = 103;
          } else {
            this.vHk.status = 199;
          }
        }
      }
      else
      {
        ad.e("MicroMsg.NetSceneMasSend", "onGYNetEnd ERROR STATUS:".concat(String.valueOf(paramInt1)));
        this.retCode = (0 - com.tencent.mm.compatible.util.f.getLine() - 10000);
        this.callback.onSceneEnd(3, -1, "doScene failed", this);
        AppMethodBeat.o(26362);
        return;
      }
    }
    paramArrayOfByte = h.dkT();
    a locala = this.vHk;
    if (locala != null)
    {
      locala.dDp = -1;
      ContentValues localContentValues = new ContentValues();
      if ((locala.dDp & 0x1) != 0) {
        localContentValues.put("clientid", locala.dkK());
      }
      if ((locala.dDp & 0x2) != 0) {
        localContentValues.put("status", Integer.valueOf(locala.status));
      }
      if ((locala.dDp & 0x4) != 0) {
        localContentValues.put("createtime", Long.valueOf(locala.createTime));
      }
      if ((locala.dDp & 0x8) != 0) {
        localContentValues.put("lastmodifytime", Long.valueOf(locala.iud));
      }
      if ((locala.dDp & 0x10) != 0) {
        localContentValues.put("filename", locala.dkL());
      }
      if ((locala.dDp & 0x20) != 0) {
        localContentValues.put("thumbfilename", locala.dkM());
      }
      if ((locala.dDp & 0x40) != 0) {
        localContentValues.put("tolist", locala.dkN());
      }
      if ((locala.dDp & 0x80) != 0) {
        localContentValues.put("tolistcount", Integer.valueOf(locala.vHd));
      }
      if ((locala.dDp & 0x100) != 0) {
        localContentValues.put("msgtype", Integer.valueOf(locala.msgType));
      }
      if ((locala.dDp & 0x200) != 0) {
        localContentValues.put("mediatime", Integer.valueOf(locala.vHe));
      }
      if ((locala.dDp & 0x400) != 0) {
        localContentValues.put("datanetoffset", Integer.valueOf(locala.vHf));
      }
      if ((locala.dDp & 0x800) != 0) {
        localContentValues.put("datalen", Integer.valueOf(locala.cSb));
      }
      if ((locala.dDp & 0x1000) != 0) {
        localContentValues.put("thumbnetoffset", Integer.valueOf(locala.iub));
      }
      if ((locala.dDp & 0x2000) != 0) {
        localContentValues.put("thumbtotallen", Integer.valueOf(locala.vHg));
      }
      if ((locala.dDp & 0x4000) != 0) {
        localContentValues.put("reserved1", Integer.valueOf(locala.videoSource));
      }
      if ((locala.dDp & 0x8000) != 0) {
        localContentValues.put("reserved2", Integer.valueOf(locala.vHh));
      }
      if ((locala.dDp & 0x10000) != 0)
      {
        if (locala.hHN != null) {
          break label1471;
        }
        paramq = "";
        localContentValues.put("reserved3", paramq);
      }
      if ((locala.dDp & 0x20000) != 0)
      {
        if (locala.hHO != null) {
          break label1481;
        }
        paramq = "";
        label1294:
        localContentValues.put("reserved4", paramq);
      }
      if ((int)paramArrayOfByte.hHS.a("massendinfo", "clientid", localContentValues) != -1)
      {
        ba.aBQ();
        if (com.tencent.mm.model.c.azv().aTz("masssendapp") != null) {
          break label1491;
        }
        paramInt1 = 1;
        label1345:
        paramq = new at();
        paramq.setUsername("masssendapp");
        paramq.setContent(b.a(locala));
        paramq.qu(locala.createTime);
        paramq.kr(0);
        paramq.kp(0);
        if (paramInt1 == 0) {
          break label1496;
        }
        ba.aBQ();
        com.tencent.mm.model.c.azv().e(paramq);
        label1413:
        paramArrayOfByte.doNotify();
      }
    }
    if (this.gFK != null) {}
    for (long l = this.gFK.abj();; l = 0L)
    {
      ad.d("MicroMsg.NetSceneMasSend", "!!!FIN: useTime:".concat(String.valueOf(l)));
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(26362);
      return;
      label1471:
      paramq = locala.hHN;
      break;
      label1481:
      paramq = locala.hHO;
      break label1294;
      label1491:
      paramInt1 = 0;
      break label1345;
      label1496:
      ba.aBQ();
      com.tencent.mm.model.c.azv().a(paramq, "masssendapp");
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
    return n.b.hOp;
  }
  
  public final void setSecurityCheckError(n.a parama) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.masssend.a.f
 * JD-Core Version:    0.7.0.1
 */