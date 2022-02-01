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
import com.tencent.mm.model.az;
import com.tencent.mm.modelvideo.o;
import com.tencent.mm.modelvideo.t;
import com.tencent.mm.modelvideo.t.b;
import com.tencent.mm.modelvoice.s;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.mm.protocal.protobuf.boz;
import com.tencent.mm.protocal.protobuf.bpa;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.am;
import com.tencent.mm.storage.bh;
import com.tencent.mm.vfs.i;
import junit.framework.Assert;

public final class f
  extends n
  implements k
{
  private com.tencent.mm.al.g callback;
  f.a ghu;
  boolean gqP;
  int hAj;
  private int hgm;
  int retCode;
  public com.tencent.mm.al.b rr;
  private a tvR;
  
  public f(a parama, boolean paramBoolean)
  {
    this(parama, paramBoolean, 0);
  }
  
  public f(a parama, boolean paramBoolean, int paramInt)
  {
    AppMethodBeat.i(26360);
    this.tvR = null;
    this.ghu = null;
    this.retCode = 0;
    this.hAj = 0;
    this.gqP = false;
    this.tvR = parama;
    this.hgm = paramInt;
    parama.createTime = bt.eGO();
    if (parama.msgType == 43)
    {
      parama.status = 104;
      o.aCI();
      parama.tvN = t.zS(t.zR(parama.cNK()));
      o.aCI();
      parama.cJQ = t.zS(t.zQ(parama.cNK()));
      this.hAj = 2500;
      if (parama.videoSource == 2) {
        this.hAj = 2500;
      }
    }
    Object localObject;
    for (;;)
    {
      localObject = new b.a();
      ((b.a)localObject).gUU = new boz();
      ((b.a)localObject).gUV = new bpa();
      ((b.a)localObject).uri = "/cgi-bin/micromsg-bin/masssend";
      ((b.a)localObject).funcId = 193;
      ((b.a)localObject).reqCmdId = 84;
      ((b.a)localObject).respCmdId = 1000000084;
      this.rr = ((b.a)localObject).atI();
      localObject = (boz)this.rr.gUS.gUX;
      ((boz)localObject).DMi = com.tencent.mm.b.g.getMessageDigest(parama.cNM().getBytes());
      ((boz)localObject).DMt = parama.tvK;
      ((boz)localObject).DMh = parama.cNM();
      parama.htx = bt.eGO();
      ((boz)localObject).DMj = parama.cNJ();
      ((boz)localObject).saz = parama.msgType;
      ((boz)localObject).DMk = parama.tvL;
      if (!paramBoolean) {
        break label550;
      }
      i = j;
      label302:
      ((boz)localObject).DMu = i;
      ((boz)localObject).DvO = paramInt;
      this.ghu = new f.a();
      AppMethodBeat.o(26360);
      return;
      if (parama.msgType != 34) {
        break;
      }
      this.hAj = 40;
      parama.status = 104;
      parama.cJQ = com.tencent.mm.modelvoice.q.zS(parama.cNK());
      parama.tvN = 0;
    }
    if (parama.msgType == 3)
    {
      this.hAj = 40;
      if (paramInt != 1) {
        break label556;
      }
      this.hAj = 1250;
    }
    label550:
    label556:
    for (int i = 1;; i = 0)
    {
      parama.tvO = i;
      parama.status = 104;
      parama.tvN = 0;
      localObject = new StringBuilder();
      az.arV();
      parama.cJQ = ((int)i.aMN(com.tencent.mm.model.c.apW() + parama.cNK()));
      break;
      if (parama.msgType == 1)
      {
        this.hAj = 1;
        parama.status = 104;
        parama.cJQ = parama.cNK().getBytes().length;
        parama.tvN = 0;
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
    this.gqP = true;
  }
  
  public final int doScene(e parame, com.tencent.mm.al.g paramg)
  {
    int j = 0;
    int i = 0;
    AppMethodBeat.i(26361);
    this.callback = paramg;
    if (this.gqP)
    {
      ad.d("MicroMsg.NetSceneMasSend", "isCancel");
      this.retCode = (0 - (com.tencent.mm.compatible.util.f.getLine() + 10000));
      AppMethodBeat.o(26361);
      return -1;
    }
    this.hAj -= 1;
    if (this.hAj < 0)
    {
      ad.d("MicroMsg.NetSceneMasSend", "MAX_SEND_TIMES");
      this.retCode = (0 - (com.tencent.mm.compatible.util.f.getLine() + 10000));
      AppMethodBeat.o(26361);
      return -1;
    }
    if (this.tvR == null)
    {
      ad.d("MicroMsg.NetSceneMasSend", "MasSendInfo is null");
      this.retCode = (0 - (com.tencent.mm.compatible.util.f.getLine() + 10000));
      AppMethodBeat.o(26361);
      return -1;
    }
    if (bt.isNullOrNil(this.tvR.cNM()))
    {
      ad.d("MicroMsg.NetSceneMasSend", "MasSendInfo.toList is null");
      this.retCode = (0 - (com.tencent.mm.compatible.util.f.getLine() + 10000));
      AppMethodBeat.o(26361);
      return -1;
    }
    if (this.tvR.tvK == 0)
    {
      ad.d("MicroMsg.NetSceneMasSend", "getTolistCount is 0");
      this.retCode = (0 - (com.tencent.mm.compatible.util.f.getLine() + 10000));
      AppMethodBeat.o(26361);
      return -1;
    }
    if (this.tvR.cJQ <= 0)
    {
      ad.d("MicroMsg.NetSceneMasSend", "getDataLen is 0");
      this.retCode = (0 - (com.tencent.mm.compatible.util.f.getLine() + 10000));
      AppMethodBeat.o(26361);
      return -1;
    }
    if ((this.tvR.status == 103) && (this.tvR.tvN <= 0))
    {
      ad.d("MicroMsg.NetSceneMasSend", "getThumbTotalLen is 0");
      this.retCode = (0 - (com.tencent.mm.compatible.util.f.getLine() + 10000));
      AppMethodBeat.o(26361);
      return -1;
    }
    if ((this.tvR.status != 103) && (this.tvR.status != 104))
    {
      ad.d("MicroMsg.NetSceneMasSend", "msg type :" + this.tvR.msgType);
      this.retCode = (0 - (com.tencent.mm.compatible.util.f.getLine() + 10000));
      AppMethodBeat.o(26361);
      return -1;
    }
    paramg = (boz)this.rr.gUS.gUX;
    Object localObject1;
    Object localObject2;
    if (this.tvR.msgType == 43)
    {
      localObject1 = this.tvR.cNK();
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
        paramg.DMl = new SKBuiltinBuffer_t();
        paramg.DMm = 0;
        paramg.DMq = new SKBuiltinBuffer_t();
        paramg.DMp = 0;
        paramg.DMr = 2;
        paramg.DMk = this.tvR.tvL;
        if (this.tvR.videoSource > 0) {}
        for (i = 2;; i = 0)
        {
          paramg.DMs = i;
          paramg.DMo = this.tvR.tvN;
          paramg.DMn = this.tvR.cJQ;
          if (this.tvR.status != 103) {
            break label879;
          }
          o.aCI();
          localObject2 = t.s(t.zR((String)localObject1), this.tvR.hAe, 8000);
          if ((((t.b)localObject2).ret >= 0) && (((t.b)localObject2).cZc != 0)) {
            break label647;
          }
          ad.e("MicroMsg.NetSceneMasSend", "doScene READ THUMB[" + (String)localObject1 + "]  Error ");
          this.retCode = (0 - (com.tencent.mm.compatible.util.f.getLine() + 10000));
          i = -1;
          break;
        }
        label647:
        ad.d("MicroMsg.NetSceneMasSend", "doScene READ THUMB[" + (String)localObject1 + "] read ret:" + ((t.b)localObject2).ret + " readlen:" + ((t.b)localObject2).cZc + " newOff:" + ((t.b)localObject2).hAL + " netOff:" + this.tvR.hAe);
        if (((t.b)localObject2).hAL >= this.tvR.hAe) {
          break;
        }
        ad.e("MicroMsg.NetSceneMasSend", "Err doScene READ THUMB[" + (String)localObject1 + "] newOff:" + ((t.b)localObject2).hAL + " OldtOff:" + this.tvR.hAe);
        this.retCode = (0 - (com.tencent.mm.compatible.util.f.getLine() + 10000));
        i = -1;
      }
      localObject1 = new byte[((t.b)localObject2).cZc];
      System.arraycopy(((t.b)localObject2).buf, 0, localObject1, 0, ((t.b)localObject2).cZc);
      paramg.DMp = this.tvR.hAe;
      localObject2 = new SKBuiltinBuffer_t();
      ((SKBuiltinBuffer_t)localObject2).setBuffer((byte[])localObject1);
      paramg.DMq = ((SKBuiltinBuffer_t)localObject2);
      for (;;)
      {
        i = 0;
        break;
        label879:
        o.aCI();
        localObject2 = t.s(t.zQ((String)localObject1), this.tvR.tvM, 8000);
        if ((((t.b)localObject2).ret < 0) || (((t.b)localObject2).cZc == 0))
        {
          ad.e("MicroMsg.NetSceneMasSend", "doScene READ VIDEO[" + (String)localObject1 + "]  Error ");
          this.retCode = (0 - (com.tencent.mm.compatible.util.f.getLine() + 10000));
          i = -1;
          break;
        }
        ad.d("MicroMsg.NetSceneMasSend", "doScene READ VIDEO[" + (String)localObject1 + "] read ret:" + ((t.b)localObject2).ret + " readlen:" + ((t.b)localObject2).cZc + " newOff:" + ((t.b)localObject2).hAL + " netOff:" + this.tvR.tvM);
        if (((t.b)localObject2).hAL < this.tvR.tvM)
        {
          ad.e("MicroMsg.NetSceneMasSend", "Err doScene READ VIDEO[" + (String)localObject1 + "] newOff:" + ((t.b)localObject2).hAL + " OldtOff:" + this.tvR.tvM);
          this.retCode = (0 - (com.tencent.mm.compatible.util.f.getLine() + 10000));
          i = -1;
          break;
        }
        if (((t.b)localObject2).hAL >= com.tencent.mm.modelvideo.c.hxJ)
        {
          ad.e("MicroMsg.NetSceneMasSend", "Err doScene READ VIDEO[" + (String)localObject1 + "] maxsize:" + com.tencent.mm.modelvideo.c.hxJ);
          this.retCode = (0 - (com.tencent.mm.compatible.util.f.getLine() + 10000));
          i = -1;
          break;
        }
        localObject1 = new byte[((t.b)localObject2).cZc];
        System.arraycopy(((t.b)localObject2).buf, 0, localObject1, 0, ((t.b)localObject2).cZc);
        paramg.DMm = this.tvR.tvM;
        paramg.DMp = this.tvR.hAe;
        localObject2 = new SKBuiltinBuffer_t();
        ((SKBuiltinBuffer_t)localObject2).setBuffer((byte[])localObject1);
        paramg.DMl = ((SKBuiltinBuffer_t)localObject2);
      }
    }
    if (this.tvR.msgType == 34)
    {
      paramg.DMr = 0;
      paramg.DMs = 0;
      paramg.DMl = new SKBuiltinBuffer_t().setBuffer(new byte[0]);
      paramg.DMm = 0;
      paramg.DMq = new SKBuiltinBuffer_t().setBuffer(new byte[0]);
      paramg.DMp = 0;
      paramg.DMo = 0;
      paramg.DMn = this.tvR.cJQ;
      localObject1 = s.Ax(this.tvR.cNK());
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
        localObject2 = ((com.tencent.mm.modelvoice.b)localObject1).dp(this.tvR.tvM, 8000);
        if (((com.tencent.mm.modelvoice.g)localObject2).ret < 0)
        {
          ad.e("MicroMsg.NetSceneMasSend", "Err doScene READ file[" + this.tvR.cNK() + "] read ret:" + ((com.tencent.mm.modelvoice.g)localObject2).ret + " readlen:" + ((com.tencent.mm.modelvoice.g)localObject2).cZc + " newOff:" + ((com.tencent.mm.modelvoice.g)localObject2).hAL + " netOff:" + this.tvR.tvM);
          this.retCode = (0 - (com.tencent.mm.compatible.util.f.getLine() + 10000));
          i = -1;
        }
        else if ((((com.tencent.mm.modelvoice.g)localObject2).hAL < this.tvR.tvM) || (((com.tencent.mm.modelvoice.g)localObject2).hAL >= 469000))
        {
          ad.e("MicroMsg.NetSceneMasSend", "Err doScene READ offseterror file[" + this.tvR.cNK() + "] read ret:" + ((com.tencent.mm.modelvoice.g)localObject2).ret + " readlen:" + ((com.tencent.mm.modelvoice.g)localObject2).cZc + " newOff:" + ((com.tencent.mm.modelvoice.g)localObject2).hAL + " netOff:" + this.tvR.tvM);
          this.retCode = (0 - (com.tencent.mm.compatible.util.f.getLine() + 10000));
          i = -1;
        }
        else if (this.tvR.cJQ <= 0)
        {
          ad.e("MicroMsg.NetSceneMasSend", "Err doScene READ datalen file[" + this.tvR.cNK() + "] read totalLen:" + this.tvR.cJQ);
          this.retCode = (com.tencent.mm.compatible.util.f.getLine() + 10000);
          i = -1;
        }
        else
        {
          byte[] arrayOfByte = new byte[((com.tencent.mm.modelvoice.g)localObject2).cZc];
          System.arraycopy(((com.tencent.mm.modelvoice.g)localObject2).buf, 0, arrayOfByte, 0, ((com.tencent.mm.modelvoice.g)localObject2).cZc);
          paramg.DMl = new SKBuiltinBuffer_t().setBuffer(arrayOfByte);
          paramg.DMk = this.tvR.tvL;
          paramg.DMm = this.tvR.tvM;
          paramg.DMv = ((com.tencent.mm.modelvoice.b)localObject1).getFormat();
        }
      }
    }
    if (this.tvR.msgType == 3)
    {
      if (bt.isNullOrNil(this.tvR.cNK()))
      {
        ad.d("MicroMsg.NetSceneMasSend", "getFilename is null");
        this.retCode = (0 - (com.tencent.mm.compatible.util.f.getLine() + 10000));
        i = -1;
      }
      while (i != 0)
      {
        AppMethodBeat.o(26361);
        return -1;
        paramg.DMr = 0;
        paramg.DMs = 0;
        paramg.DMl = new SKBuiltinBuffer_t().setBuffer(new byte[0]);
        paramg.DMm = 0;
        paramg.DMq = new SKBuiltinBuffer_t().setBuffer(new byte[0]);
        paramg.DMp = 0;
        paramg.DMo = 0;
        paramg.DMk = 0;
        paramg.DMo = this.tvR.tvN;
        paramg.DMn = this.tvR.cJQ;
        paramg.DvO = this.hgm;
        localObject1 = new StringBuilder();
        az.arV();
        localObject1 = com.tencent.mm.model.c.apW() + this.tvR.cNK();
        int k = this.tvR.cJQ - this.tvR.tvM;
        i = k;
        if (k > 8000) {
          i = 8000;
        }
        localObject1 = i.aR((String)localObject1, this.tvR.tvM, i);
        if (bt.cw((byte[])localObject1))
        {
          ad.e("MicroMsg.NetSceneMasSend", "doScene READ data[" + this.tvR.cNK() + "]  Error ");
          this.retCode = (0 - (com.tencent.mm.compatible.util.f.getLine() + 10000));
          i = -1;
        }
        else
        {
          paramg.DMm = this.tvR.tvM;
          paramg.DMp = this.tvR.hAe;
          localObject2 = new SKBuiltinBuffer_t();
          ((SKBuiltinBuffer_t)localObject2).setBuffer((byte[])localObject1);
          paramg.DMl = ((SKBuiltinBuffer_t)localObject2);
          i = j;
        }
      }
    }
    if (this.tvR.msgType == 1)
    {
      paramg.DMl = new SKBuiltinBuffer_t().setBuffer(this.tvR.cNK().getBytes());
      paramg.DMn = this.tvR.cJQ;
      paramg.DMk = 0;
      paramg.DMm = 0;
      paramg.DMq = new SKBuiltinBuffer_t().setBuffer(new byte[0]);
      paramg.DMp = 0;
      paramg.DMo = 0;
      paramg.DMr = 0;
      paramg.DMs = 0;
      label2254:
      i = dispatch(parame, this.rr, this);
      AppMethodBeat.o(26361);
      return i;
    }
    ad.d("MicroMsg.NetSceneMasSend", "error msgtype:" + this.tvR.msgType);
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
    if (this.tvR == null)
    {
      ad.e("MicroMsg.NetSceneMasSend", "ERR: onGYNetEnd Get INFO FAILED :");
      this.retCode = (0 - com.tencent.mm.compatible.util.f.getLine() - 10000);
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(26362);
      return;
    }
    if ((this.tvR.status != 104) && (this.tvR.status != 103))
    {
      ad.e("MicroMsg.NetSceneMasSend", "ERR: onGYNetEnd STATUS ERR: status:" + this.tvR.status);
      this.retCode = (0 - com.tencent.mm.compatible.util.f.getLine() - 10000);
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(26362);
      return;
    }
    paramArrayOfByte = (bpa)this.rr.gUT.gUX;
    paramq = (boz)this.rr.gUS.gUX;
    if ((paramq.DMo > 0) && (paramq.DMq != null) && (paramq.DMq.getBuffer() != null) && (!bt.cw(paramq.DMq.getBuffer().toByteArray())) && (paramq.DMp != paramArrayOfByte.DMp - paramq.DMq.getILen()))
    {
      ad.e("MicroMsg.NetSceneMasSend", "onGYNetEnd Err Thumb ");
      this.retCode = (0 - com.tencent.mm.compatible.util.f.getLine() - 10000);
      this.callback.onSceneEnd(3, -1, "doScene failed", this);
      AppMethodBeat.o(26362);
      return;
    }
    if ((paramq.DMn > 0) && (paramq.DMl != null) && (paramq.DMl.getBuffer() != null) && (!bt.cw(paramq.DMl.getBuffer().toByteArray())) && (paramq.DMm != paramArrayOfByte.DMm - paramq.DMl.getILen()))
    {
      ad.e("MicroMsg.NetSceneMasSend", "onGYNetEnd Err Data ");
      this.retCode = (0 - com.tencent.mm.compatible.util.f.getLine() - 10000);
      this.callback.onSceneEnd(3, -1, "doScene failed", this);
      AppMethodBeat.o(26362);
      return;
    }
    this.tvR.hAg = bt.aGK();
    paramInt1 = this.tvR.status;
    if (paramInt1 == 103)
    {
      paramArrayOfByte = this.tvR;
      paramInt1 = paramq.DMp;
      paramArrayOfByte.hAe = (paramq.DMq.getILen() + paramInt1);
      if (this.tvR.hAe >= this.tvR.tvN) {
        this.tvR.status = 199;
      }
    }
    while (this.tvR.status != 199)
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
        paramArrayOfByte = this.tvR;
        paramInt1 = paramq.DMm;
        paramArrayOfByte.tvM = (paramq.DMl.getILen() + paramInt1);
        if (this.tvR.tvM >= this.tvR.cJQ) {
          if (this.tvR.tvN > 0) {
            this.tvR.status = 103;
          } else {
            this.tvR.status = 199;
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
    paramArrayOfByte = h.cNS();
    a locala = this.tvR;
    if (locala != null)
    {
      locala.dtM = -1;
      ContentValues localContentValues = new ContentValues();
      if ((locala.dtM & 0x1) != 0) {
        localContentValues.put("clientid", locala.cNJ());
      }
      if ((locala.dtM & 0x2) != 0) {
        localContentValues.put("status", Integer.valueOf(locala.status));
      }
      if ((locala.dtM & 0x4) != 0) {
        localContentValues.put("createtime", Long.valueOf(locala.createTime));
      }
      if ((locala.dtM & 0x8) != 0) {
        localContentValues.put("lastmodifytime", Long.valueOf(locala.hAg));
      }
      if ((locala.dtM & 0x10) != 0) {
        localContentValues.put("filename", locala.cNK());
      }
      if ((locala.dtM & 0x20) != 0) {
        localContentValues.put("thumbfilename", locala.cNL());
      }
      if ((locala.dtM & 0x40) != 0) {
        localContentValues.put("tolist", locala.cNM());
      }
      if ((locala.dtM & 0x80) != 0) {
        localContentValues.put("tolistcount", Integer.valueOf(locala.tvK));
      }
      if ((locala.dtM & 0x100) != 0) {
        localContentValues.put("msgtype", Integer.valueOf(locala.msgType));
      }
      if ((locala.dtM & 0x200) != 0) {
        localContentValues.put("mediatime", Integer.valueOf(locala.tvL));
      }
      if ((locala.dtM & 0x400) != 0) {
        localContentValues.put("datanetoffset", Integer.valueOf(locala.tvM));
      }
      if ((locala.dtM & 0x800) != 0) {
        localContentValues.put("datalen", Integer.valueOf(locala.cJQ));
      }
      if ((locala.dtM & 0x1000) != 0) {
        localContentValues.put("thumbnetoffset", Integer.valueOf(locala.hAe));
      }
      if ((locala.dtM & 0x2000) != 0) {
        localContentValues.put("thumbtotallen", Integer.valueOf(locala.tvN));
      }
      if ((locala.dtM & 0x4000) != 0) {
        localContentValues.put("reserved1", Integer.valueOf(locala.videoSource));
      }
      if ((locala.dtM & 0x8000) != 0) {
        localContentValues.put("reserved2", Integer.valueOf(locala.tvO));
      }
      if ((locala.dtM & 0x10000) != 0)
      {
        if (locala.gOV != null) {
          break label1471;
        }
        paramq = "";
        localContentValues.put("reserved3", paramq);
      }
      if ((locala.dtM & 0x20000) != 0)
      {
        if (locala.gOW != null) {
          break label1481;
        }
        paramq = "";
        label1294:
        localContentValues.put("reserved4", paramq);
      }
      if ((int)paramArrayOfByte.gPa.a("massendinfo", "clientid", localContentValues) != -1)
      {
        az.arV();
        if (com.tencent.mm.model.c.apR().aIn("masssendapp") != null) {
          break label1491;
        }
        paramInt1 = 1;
        label1345:
        paramq = new am();
        paramq.setUsername("masssendapp");
        paramq.setContent(b.a(locala));
        paramq.kS(locala.createTime);
        paramq.jV(0);
        paramq.jT(0);
        if (paramInt1 == 0) {
          break label1496;
        }
        az.arV();
        com.tencent.mm.model.c.apR().e(paramq);
        label1413:
        paramArrayOfByte.doNotify();
      }
    }
    if (this.ghu != null) {}
    for (long l = this.ghu.XK();; l = 0L)
    {
      ad.d("MicroMsg.NetSceneMasSend", "!!!FIN: useTime:".concat(String.valueOf(l)));
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(26362);
      return;
      label1471:
      paramq = locala.gOV;
      break;
      label1481:
      paramq = locala.gOW;
      break label1294;
      label1491:
      paramInt1 = 0;
      break label1345;
      label1496:
      az.arV();
      com.tencent.mm.model.c.apR().a(paramq, "masssendapp");
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
    return n.b.gVB;
  }
  
  public final void setSecurityCheckError(n.a parama) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.masssend.a.f
 * JD-Core Version:    0.7.0.1
 */