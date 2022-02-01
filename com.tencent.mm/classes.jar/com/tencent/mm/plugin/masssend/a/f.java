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
import com.tencent.mm.model.az;
import com.tencent.mm.modelvideo.o;
import com.tencent.mm.modelvideo.t;
import com.tencent.mm.modelvideo.t.b;
import com.tencent.mm.modelvoice.s;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.mm.protocal.protobuf.btp;
import com.tencent.mm.protocal.protobuf.btq;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.storage.ap;
import com.tencent.mm.storage.bk;
import com.tencent.mm.vfs.i;
import junit.framework.Assert;

public final class f
  extends n
  implements k
{
  private com.tencent.mm.ak.g callback;
  boolean gRx;
  f.a gma;
  private int hGP;
  int iaK;
  int retCode;
  public com.tencent.mm.ak.b rr;
  private a uEk;
  
  public f(a parama, boolean paramBoolean)
  {
    this(parama, paramBoolean, 0);
  }
  
  public f(a parama, boolean paramBoolean, int paramInt)
  {
    AppMethodBeat.i(26360);
    this.uEk = null;
    this.gma = null;
    this.retCode = 0;
    this.iaK = 0;
    this.gRx = false;
    this.uEk = parama;
    this.hGP = paramInt;
    parama.createTime = bs.eWj();
    if (parama.msgType == 43)
    {
      parama.status = 104;
      o.aJy();
      parama.uEg = t.DX(t.DW(parama.dbr()));
      o.aJy();
      parama.cGX = t.DX(t.DV(parama.dbr()));
      this.iaK = 2500;
      if (parama.videoSource == 2) {
        this.iaK = 2500;
      }
    }
    Object localObject;
    for (;;)
    {
      localObject = new b.a();
      ((b.a)localObject).hvt = new btp();
      ((b.a)localObject).hvu = new btq();
      ((b.a)localObject).uri = "/cgi-bin/micromsg-bin/masssend";
      ((b.a)localObject).funcId = 193;
      ((b.a)localObject).reqCmdId = 84;
      ((b.a)localObject).respCmdId = 1000000084;
      this.rr = ((b.a)localObject).aAz();
      localObject = (btp)this.rr.hvr.hvw;
      ((btp)localObject).Fiy = com.tencent.mm.b.g.getMessageDigest(parama.dbt().getBytes());
      ((btp)localObject).FiJ = parama.uEd;
      ((btp)localObject).Fix = parama.dbt();
      parama.hTZ = bs.eWj();
      ((btp)localObject).Fiz = parama.dbq();
      ((btp)localObject).tit = parama.msgType;
      ((btp)localObject).FiA = parama.uEe;
      if (!paramBoolean) {
        break label550;
      }
      i = j;
      label302:
      ((btp)localObject).FiK = i;
      ((btp)localObject).ERj = paramInt;
      this.gma = new f.a();
      AppMethodBeat.o(26360);
      return;
      if (parama.msgType != 34) {
        break;
      }
      this.iaK = 40;
      parama.status = 104;
      parama.cGX = com.tencent.mm.modelvoice.q.DX(parama.dbr());
      parama.uEg = 0;
    }
    if (parama.msgType == 3)
    {
      this.iaK = 40;
      if (paramInt != 1) {
        break label556;
      }
      this.iaK = 1250;
    }
    label550:
    label556:
    for (int i = 1;; i = 0)
    {
      parama.uEh = i;
      parama.status = 104;
      parama.uEg = 0;
      localObject = new StringBuilder();
      az.ayM();
      parama.cGX = ((int)i.aSp(com.tencent.mm.model.c.awL() + parama.dbr()));
      break;
      if (parama.msgType == 1)
      {
        this.iaK = 1;
        parama.status = 104;
        parama.cGX = parama.dbr().getBytes().length;
        parama.uEg = 0;
        break;
      }
      ac.d("MicroMsg.NetSceneMasSend", "error msgtype:" + parama.msgType);
      Assert.assertTrue("error msgtype:" + parama.msgType, false);
      break;
      i = 0;
      break label302;
    }
  }
  
  public final void cancel()
  {
    this.gRx = true;
  }
  
  public final int doScene(e parame, com.tencent.mm.ak.g paramg)
  {
    int j = 0;
    int i = 0;
    AppMethodBeat.i(26361);
    this.callback = paramg;
    if (this.gRx)
    {
      ac.d("MicroMsg.NetSceneMasSend", "isCancel");
      this.retCode = (0 - (com.tencent.mm.compatible.util.f.getLine() + 10000));
      AppMethodBeat.o(26361);
      return -1;
    }
    this.iaK -= 1;
    if (this.iaK < 0)
    {
      ac.d("MicroMsg.NetSceneMasSend", "MAX_SEND_TIMES");
      this.retCode = (0 - (com.tencent.mm.compatible.util.f.getLine() + 10000));
      AppMethodBeat.o(26361);
      return -1;
    }
    if (this.uEk == null)
    {
      ac.d("MicroMsg.NetSceneMasSend", "MasSendInfo is null");
      this.retCode = (0 - (com.tencent.mm.compatible.util.f.getLine() + 10000));
      AppMethodBeat.o(26361);
      return -1;
    }
    if (bs.isNullOrNil(this.uEk.dbt()))
    {
      ac.d("MicroMsg.NetSceneMasSend", "MasSendInfo.toList is null");
      this.retCode = (0 - (com.tencent.mm.compatible.util.f.getLine() + 10000));
      AppMethodBeat.o(26361);
      return -1;
    }
    if (this.uEk.uEd == 0)
    {
      ac.d("MicroMsg.NetSceneMasSend", "getTolistCount is 0");
      this.retCode = (0 - (com.tencent.mm.compatible.util.f.getLine() + 10000));
      AppMethodBeat.o(26361);
      return -1;
    }
    if (this.uEk.cGX <= 0)
    {
      ac.d("MicroMsg.NetSceneMasSend", "getDataLen is 0");
      this.retCode = (0 - (com.tencent.mm.compatible.util.f.getLine() + 10000));
      AppMethodBeat.o(26361);
      return -1;
    }
    if ((this.uEk.status == 103) && (this.uEk.uEg <= 0))
    {
      ac.d("MicroMsg.NetSceneMasSend", "getThumbTotalLen is 0");
      this.retCode = (0 - (com.tencent.mm.compatible.util.f.getLine() + 10000));
      AppMethodBeat.o(26361);
      return -1;
    }
    if ((this.uEk.status != 103) && (this.uEk.status != 104))
    {
      ac.d("MicroMsg.NetSceneMasSend", "msg type :" + this.uEk.msgType);
      this.retCode = (0 - (com.tencent.mm.compatible.util.f.getLine() + 10000));
      AppMethodBeat.o(26361);
      return -1;
    }
    paramg = (btp)this.rr.hvr.hvw;
    Object localObject1;
    Object localObject2;
    if (this.uEk.msgType == 43)
    {
      localObject1 = this.uEk.dbr();
      if (bs.isNullOrNil((String)localObject1))
      {
        ac.d("MicroMsg.NetSceneMasSend", "MasSendInfo.fileName is null");
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
        paramg.FiB = new SKBuiltinBuffer_t();
        paramg.FiC = 0;
        paramg.FiG = new SKBuiltinBuffer_t();
        paramg.FiF = 0;
        paramg.FiH = 2;
        paramg.FiA = this.uEk.uEe;
        if (this.uEk.videoSource > 0) {}
        for (i = 2;; i = 0)
        {
          paramg.FiI = i;
          paramg.FiE = this.uEk.uEg;
          paramg.FiD = this.uEk.cGX;
          if (this.uEk.status != 103) {
            break label879;
          }
          o.aJy();
          localObject2 = t.r(t.DW((String)localObject1), this.uEk.iaF, 8000);
          if ((((t.b)localObject2).ret >= 0) && (((t.b)localObject2).cWy != 0)) {
            break label647;
          }
          ac.e("MicroMsg.NetSceneMasSend", "doScene READ THUMB[" + (String)localObject1 + "]  Error ");
          this.retCode = (0 - (com.tencent.mm.compatible.util.f.getLine() + 10000));
          i = -1;
          break;
        }
        label647:
        ac.d("MicroMsg.NetSceneMasSend", "doScene READ THUMB[" + (String)localObject1 + "] read ret:" + ((t.b)localObject2).ret + " readlen:" + ((t.b)localObject2).cWy + " newOff:" + ((t.b)localObject2).ibm + " netOff:" + this.uEk.iaF);
        if (((t.b)localObject2).ibm >= this.uEk.iaF) {
          break;
        }
        ac.e("MicroMsg.NetSceneMasSend", "Err doScene READ THUMB[" + (String)localObject1 + "] newOff:" + ((t.b)localObject2).ibm + " OldtOff:" + this.uEk.iaF);
        this.retCode = (0 - (com.tencent.mm.compatible.util.f.getLine() + 10000));
        i = -1;
      }
      localObject1 = new byte[((t.b)localObject2).cWy];
      System.arraycopy(((t.b)localObject2).buf, 0, localObject1, 0, ((t.b)localObject2).cWy);
      paramg.FiF = this.uEk.iaF;
      localObject2 = new SKBuiltinBuffer_t();
      ((SKBuiltinBuffer_t)localObject2).setBuffer((byte[])localObject1);
      paramg.FiG = ((SKBuiltinBuffer_t)localObject2);
      for (;;)
      {
        i = 0;
        break;
        label879:
        o.aJy();
        localObject2 = t.r(t.DV((String)localObject1), this.uEk.uEf, 8000);
        if ((((t.b)localObject2).ret < 0) || (((t.b)localObject2).cWy == 0))
        {
          ac.e("MicroMsg.NetSceneMasSend", "doScene READ VIDEO[" + (String)localObject1 + "]  Error ");
          this.retCode = (0 - (com.tencent.mm.compatible.util.f.getLine() + 10000));
          i = -1;
          break;
        }
        ac.d("MicroMsg.NetSceneMasSend", "doScene READ VIDEO[" + (String)localObject1 + "] read ret:" + ((t.b)localObject2).ret + " readlen:" + ((t.b)localObject2).cWy + " newOff:" + ((t.b)localObject2).ibm + " netOff:" + this.uEk.uEf);
        if (((t.b)localObject2).ibm < this.uEk.uEf)
        {
          ac.e("MicroMsg.NetSceneMasSend", "Err doScene READ VIDEO[" + (String)localObject1 + "] newOff:" + ((t.b)localObject2).ibm + " OldtOff:" + this.uEk.uEf);
          this.retCode = (0 - (com.tencent.mm.compatible.util.f.getLine() + 10000));
          i = -1;
          break;
        }
        if (((t.b)localObject2).ibm >= com.tencent.mm.modelvideo.c.hYk)
        {
          ac.e("MicroMsg.NetSceneMasSend", "Err doScene READ VIDEO[" + (String)localObject1 + "] maxsize:" + com.tencent.mm.modelvideo.c.hYk);
          this.retCode = (0 - (com.tencent.mm.compatible.util.f.getLine() + 10000));
          i = -1;
          break;
        }
        localObject1 = new byte[((t.b)localObject2).cWy];
        System.arraycopy(((t.b)localObject2).buf, 0, localObject1, 0, ((t.b)localObject2).cWy);
        paramg.FiC = this.uEk.uEf;
        paramg.FiF = this.uEk.iaF;
        localObject2 = new SKBuiltinBuffer_t();
        ((SKBuiltinBuffer_t)localObject2).setBuffer((byte[])localObject1);
        paramg.FiB = ((SKBuiltinBuffer_t)localObject2);
      }
    }
    if (this.uEk.msgType == 34)
    {
      paramg.FiH = 0;
      paramg.FiI = 0;
      paramg.FiB = new SKBuiltinBuffer_t().setBuffer(new byte[0]);
      paramg.FiC = 0;
      paramg.FiG = new SKBuiltinBuffer_t().setBuffer(new byte[0]);
      paramg.FiF = 0;
      paramg.FiE = 0;
      paramg.FiD = this.uEk.cGX;
      localObject1 = s.EC(this.uEk.dbr());
      if (localObject1 == null)
      {
        this.retCode = (0 - (com.tencent.mm.compatible.util.f.getLine() + 10000));
        ac.d("MicroMsg.NetSceneMasSend", "fileop is null");
        i = -1;
      }
      while (i != 0)
      {
        AppMethodBeat.o(26361);
        return -1;
        localObject2 = ((com.tencent.mm.modelvoice.b)localObject1).dp(this.uEk.uEf, 8000);
        if (((com.tencent.mm.modelvoice.g)localObject2).ret < 0)
        {
          ac.e("MicroMsg.NetSceneMasSend", "Err doScene READ file[" + this.uEk.dbr() + "] read ret:" + ((com.tencent.mm.modelvoice.g)localObject2).ret + " readlen:" + ((com.tencent.mm.modelvoice.g)localObject2).cWy + " newOff:" + ((com.tencent.mm.modelvoice.g)localObject2).ibm + " netOff:" + this.uEk.uEf);
          this.retCode = (0 - (com.tencent.mm.compatible.util.f.getLine() + 10000));
          i = -1;
        }
        else if ((((com.tencent.mm.modelvoice.g)localObject2).ibm < this.uEk.uEf) || (((com.tencent.mm.modelvoice.g)localObject2).ibm >= 469000))
        {
          ac.e("MicroMsg.NetSceneMasSend", "Err doScene READ offseterror file[" + this.uEk.dbr() + "] read ret:" + ((com.tencent.mm.modelvoice.g)localObject2).ret + " readlen:" + ((com.tencent.mm.modelvoice.g)localObject2).cWy + " newOff:" + ((com.tencent.mm.modelvoice.g)localObject2).ibm + " netOff:" + this.uEk.uEf);
          this.retCode = (0 - (com.tencent.mm.compatible.util.f.getLine() + 10000));
          i = -1;
        }
        else if (this.uEk.cGX <= 0)
        {
          ac.e("MicroMsg.NetSceneMasSend", "Err doScene READ datalen file[" + this.uEk.dbr() + "] read totalLen:" + this.uEk.cGX);
          this.retCode = (com.tencent.mm.compatible.util.f.getLine() + 10000);
          i = -1;
        }
        else
        {
          byte[] arrayOfByte = new byte[((com.tencent.mm.modelvoice.g)localObject2).cWy];
          System.arraycopy(((com.tencent.mm.modelvoice.g)localObject2).buf, 0, arrayOfByte, 0, ((com.tencent.mm.modelvoice.g)localObject2).cWy);
          paramg.FiB = new SKBuiltinBuffer_t().setBuffer(arrayOfByte);
          paramg.FiA = this.uEk.uEe;
          paramg.FiC = this.uEk.uEf;
          paramg.FiL = ((com.tencent.mm.modelvoice.b)localObject1).getFormat();
        }
      }
    }
    if (this.uEk.msgType == 3)
    {
      if (bs.isNullOrNil(this.uEk.dbr()))
      {
        ac.d("MicroMsg.NetSceneMasSend", "getFilename is null");
        this.retCode = (0 - (com.tencent.mm.compatible.util.f.getLine() + 10000));
        i = -1;
      }
      while (i != 0)
      {
        AppMethodBeat.o(26361);
        return -1;
        paramg.FiH = 0;
        paramg.FiI = 0;
        paramg.FiB = new SKBuiltinBuffer_t().setBuffer(new byte[0]);
        paramg.FiC = 0;
        paramg.FiG = new SKBuiltinBuffer_t().setBuffer(new byte[0]);
        paramg.FiF = 0;
        paramg.FiE = 0;
        paramg.FiA = 0;
        paramg.FiE = this.uEk.uEg;
        paramg.FiD = this.uEk.cGX;
        paramg.ERj = this.hGP;
        localObject1 = new StringBuilder();
        az.ayM();
        localObject1 = com.tencent.mm.model.c.awL() + this.uEk.dbr();
        int k = this.uEk.cGX - this.uEk.uEf;
        i = k;
        if (k > 8000) {
          i = 8000;
        }
        localObject1 = i.aU((String)localObject1, this.uEk.uEf, i);
        if (bs.cv((byte[])localObject1))
        {
          ac.e("MicroMsg.NetSceneMasSend", "doScene READ data[" + this.uEk.dbr() + "]  Error ");
          this.retCode = (0 - (com.tencent.mm.compatible.util.f.getLine() + 10000));
          i = -1;
        }
        else
        {
          paramg.FiC = this.uEk.uEf;
          paramg.FiF = this.uEk.iaF;
          localObject2 = new SKBuiltinBuffer_t();
          ((SKBuiltinBuffer_t)localObject2).setBuffer((byte[])localObject1);
          paramg.FiB = ((SKBuiltinBuffer_t)localObject2);
          i = j;
        }
      }
    }
    if (this.uEk.msgType == 1)
    {
      paramg.FiB = new SKBuiltinBuffer_t().setBuffer(this.uEk.dbr().getBytes());
      paramg.FiD = this.uEk.cGX;
      paramg.FiA = 0;
      paramg.FiC = 0;
      paramg.FiG = new SKBuiltinBuffer_t().setBuffer(new byte[0]);
      paramg.FiF = 0;
      paramg.FiE = 0;
      paramg.FiH = 0;
      paramg.FiI = 0;
      label2254:
      i = dispatch(parame, this.rr, this);
      AppMethodBeat.o(26361);
      return i;
    }
    ac.d("MicroMsg.NetSceneMasSend", "error msgtype:" + this.uEk.msgType);
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
    ac.d("MicroMsg.NetSceneMasSend", "onGYNetEnd  errtype:" + paramInt2 + " errCode:" + paramInt3);
    updateDispatchId(paramInt1);
    if ((paramInt2 != 0) || (paramInt3 != 0))
    {
      ac.e("MicroMsg.NetSceneMasSend", "ERR: onGYNetEnd FAILED errtype:" + paramInt2 + " errCode:" + paramInt3);
      this.retCode = (0 - com.tencent.mm.compatible.util.f.getLine() - 10000);
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(26362);
      return;
    }
    if (this.uEk == null)
    {
      ac.e("MicroMsg.NetSceneMasSend", "ERR: onGYNetEnd Get INFO FAILED :");
      this.retCode = (0 - com.tencent.mm.compatible.util.f.getLine() - 10000);
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(26362);
      return;
    }
    if ((this.uEk.status != 104) && (this.uEk.status != 103))
    {
      ac.e("MicroMsg.NetSceneMasSend", "ERR: onGYNetEnd STATUS ERR: status:" + this.uEk.status);
      this.retCode = (0 - com.tencent.mm.compatible.util.f.getLine() - 10000);
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(26362);
      return;
    }
    paramArrayOfByte = (btq)this.rr.hvs.hvw;
    paramq = (btp)this.rr.hvr.hvw;
    if ((paramq.FiE > 0) && (paramq.FiG != null) && (paramq.FiG.getBuffer() != null) && (!bs.cv(paramq.FiG.getBuffer().toByteArray())) && (paramq.FiF != paramArrayOfByte.FiF - paramq.FiG.getILen()))
    {
      ac.e("MicroMsg.NetSceneMasSend", "onGYNetEnd Err Thumb ");
      this.retCode = (0 - com.tencent.mm.compatible.util.f.getLine() - 10000);
      this.callback.onSceneEnd(3, -1, "doScene failed", this);
      AppMethodBeat.o(26362);
      return;
    }
    if ((paramq.FiD > 0) && (paramq.FiB != null) && (paramq.FiB.getBuffer() != null) && (!bs.cv(paramq.FiB.getBuffer().toByteArray())) && (paramq.FiC != paramArrayOfByte.FiC - paramq.FiB.getILen()))
    {
      ac.e("MicroMsg.NetSceneMasSend", "onGYNetEnd Err Data ");
      this.retCode = (0 - com.tencent.mm.compatible.util.f.getLine() - 10000);
      this.callback.onSceneEnd(3, -1, "doScene failed", this);
      AppMethodBeat.o(26362);
      return;
    }
    this.uEk.iaH = bs.aNx();
    paramInt1 = this.uEk.status;
    if (paramInt1 == 103)
    {
      paramArrayOfByte = this.uEk;
      paramInt1 = paramq.FiF;
      paramArrayOfByte.iaF = (paramq.FiG.getILen() + paramInt1);
      if (this.uEk.iaF >= this.uEk.uEg) {
        this.uEk.status = 199;
      }
    }
    while (this.uEk.status != 199)
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
        paramArrayOfByte = this.uEk;
        paramInt1 = paramq.FiC;
        paramArrayOfByte.uEf = (paramq.FiB.getILen() + paramInt1);
        if (this.uEk.uEf >= this.uEk.cGX) {
          if (this.uEk.uEg > 0) {
            this.uEk.status = 103;
          } else {
            this.uEk.status = 199;
          }
        }
      }
      else
      {
        ac.e("MicroMsg.NetSceneMasSend", "onGYNetEnd ERROR STATUS:".concat(String.valueOf(paramInt1)));
        this.retCode = (0 - com.tencent.mm.compatible.util.f.getLine() - 10000);
        this.callback.onSceneEnd(3, -1, "doScene failed", this);
        AppMethodBeat.o(26362);
        return;
      }
    }
    paramArrayOfByte = h.dbz();
    a locala = this.uEk;
    if (locala != null)
    {
      locala.drx = -1;
      ContentValues localContentValues = new ContentValues();
      if ((locala.drx & 0x1) != 0) {
        localContentValues.put("clientid", locala.dbq());
      }
      if ((locala.drx & 0x2) != 0) {
        localContentValues.put("status", Integer.valueOf(locala.status));
      }
      if ((locala.drx & 0x4) != 0) {
        localContentValues.put("createtime", Long.valueOf(locala.createTime));
      }
      if ((locala.drx & 0x8) != 0) {
        localContentValues.put("lastmodifytime", Long.valueOf(locala.iaH));
      }
      if ((locala.drx & 0x10) != 0) {
        localContentValues.put("filename", locala.dbr());
      }
      if ((locala.drx & 0x20) != 0) {
        localContentValues.put("thumbfilename", locala.dbs());
      }
      if ((locala.drx & 0x40) != 0) {
        localContentValues.put("tolist", locala.dbt());
      }
      if ((locala.drx & 0x80) != 0) {
        localContentValues.put("tolistcount", Integer.valueOf(locala.uEd));
      }
      if ((locala.drx & 0x100) != 0) {
        localContentValues.put("msgtype", Integer.valueOf(locala.msgType));
      }
      if ((locala.drx & 0x200) != 0) {
        localContentValues.put("mediatime", Integer.valueOf(locala.uEe));
      }
      if ((locala.drx & 0x400) != 0) {
        localContentValues.put("datanetoffset", Integer.valueOf(locala.uEf));
      }
      if ((locala.drx & 0x800) != 0) {
        localContentValues.put("datalen", Integer.valueOf(locala.cGX));
      }
      if ((locala.drx & 0x1000) != 0) {
        localContentValues.put("thumbnetoffset", Integer.valueOf(locala.iaF));
      }
      if ((locala.drx & 0x2000) != 0) {
        localContentValues.put("thumbtotallen", Integer.valueOf(locala.uEg));
      }
      if ((locala.drx & 0x4000) != 0) {
        localContentValues.put("reserved1", Integer.valueOf(locala.videoSource));
      }
      if ((locala.drx & 0x8000) != 0) {
        localContentValues.put("reserved2", Integer.valueOf(locala.uEh));
      }
      if ((locala.drx & 0x10000) != 0)
      {
        if (locala.hpv != null) {
          break label1471;
        }
        paramq = "";
        localContentValues.put("reserved3", paramq);
      }
      if ((locala.drx & 0x20000) != 0)
      {
        if (locala.hpw != null) {
          break label1481;
        }
        paramq = "";
        label1294:
        localContentValues.put("reserved4", paramq);
      }
      if ((int)paramArrayOfByte.hpA.a("massendinfo", "clientid", localContentValues) != -1)
      {
        az.ayM();
        if (com.tencent.mm.model.c.awG().aNI("masssendapp") != null) {
          break label1491;
        }
        paramInt1 = 1;
        label1345:
        paramq = new ap();
        paramq.setUsername("masssendapp");
        paramq.setContent(b.a(locala));
        paramq.ou(locala.createTime);
        paramq.jT(0);
        paramq.jR(0);
        if (paramInt1 == 0) {
          break label1496;
        }
        az.ayM();
        com.tencent.mm.model.c.awG().e(paramq);
        label1413:
        paramArrayOfByte.doNotify();
      }
    }
    if (this.gma != null) {}
    for (long l = this.gma.YH();; l = 0L)
    {
      ac.d("MicroMsg.NetSceneMasSend", "!!!FIN: useTime:".concat(String.valueOf(l)));
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(26362);
      return;
      label1471:
      paramq = locala.hpv;
      break;
      label1481:
      paramq = locala.hpw;
      break label1294;
      label1491:
      paramInt1 = 0;
      break label1345;
      label1496:
      az.ayM();
      com.tencent.mm.model.c.awG().a(paramq, "masssendapp");
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
    return n.b.hwa;
  }
  
  public final void setSecurityCheckError(n.a parama) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.masssend.a.f
 * JD-Core Version:    0.7.0.1
 */