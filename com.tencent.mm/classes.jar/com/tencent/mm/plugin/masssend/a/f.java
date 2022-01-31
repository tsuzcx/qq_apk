package com.tencent.mm.plugin.masssend.a;

import android.content.ContentValues;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b.a;
import com.tencent.mm.ai.b.b;
import com.tencent.mm.ai.b.c;
import com.tencent.mm.ai.m;
import com.tencent.mm.ai.m.a;
import com.tencent.mm.ai.m.b;
import com.tencent.mm.compatible.util.g.a;
import com.tencent.mm.model.aw;
import com.tencent.mm.modelvideo.o;
import com.tencent.mm.modelvideo.t;
import com.tencent.mm.modelvideo.t.b;
import com.tencent.mm.modelvoice.s;
import com.tencent.mm.network.k;
import com.tencent.mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.mm.protocal.protobuf.bcn;
import com.tencent.mm.protocal.protobuf.bco;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.ak;
import com.tencent.mm.storage.be;
import junit.framework.Assert;

public final class f
  extends m
  implements k
{
  private com.tencent.mm.ai.f callback;
  g.a eMo;
  boolean eUJ;
  private int fDP;
  int fXz;
  private a oBm;
  int retCode;
  public com.tencent.mm.ai.b rr;
  
  public f(a parama, boolean paramBoolean)
  {
    this(parama, paramBoolean, 0);
  }
  
  public f(a parama, boolean paramBoolean, int paramInt)
  {
    AppMethodBeat.i(22738);
    this.oBm = null;
    this.eMo = null;
    this.retCode = 0;
    this.fXz = 0;
    this.eUJ = false;
    this.oBm = parama;
    this.fDP = paramInt;
    parama.createTime = bo.aoy();
    if (parama.msgType == 43)
    {
      parama.status = 104;
      o.alE();
      parama.oBi = t.vh(t.vg(parama.bOU()));
      o.alE();
      parama.bWt = t.vh(t.vf(parama.bOU()));
      this.fXz = 2500;
      if (parama.videoSource == 2) {
        this.fXz = 2500;
      }
    }
    Object localObject;
    for (;;)
    {
      localObject = new b.a();
      ((b.a)localObject).fsX = new bcn();
      ((b.a)localObject).fsY = new bco();
      ((b.a)localObject).uri = "/cgi-bin/micromsg-bin/masssend";
      ((b.a)localObject).funcId = 193;
      ((b.a)localObject).reqCmdId = 84;
      ((b.a)localObject).respCmdId = 1000000084;
      this.rr = ((b.a)localObject).ado();
      localObject = (bcn)this.rr.fsV.fta;
      ((bcn)localObject).xrx = com.tencent.mm.a.g.w(parama.bOW().getBytes());
      ((bcn)localObject).xrI = parama.oBf;
      ((bcn)localObject).xrw = parama.bOW();
      parama.fQQ = bo.aoy();
      ((bcn)localObject).xry = parama.bOT();
      ((bcn)localObject).nqW = parama.msgType;
      ((bcn)localObject).xrz = parama.oBg;
      if (!paramBoolean) {
        break label550;
      }
      i = j;
      label302:
      ((bcn)localObject).xrJ = i;
      ((bcn)localObject).xdn = paramInt;
      this.eMo = new g.a();
      AppMethodBeat.o(22738);
      return;
      if (parama.msgType != 34) {
        break;
      }
      this.fXz = 40;
      parama.status = 104;
      parama.bWt = com.tencent.mm.modelvoice.q.vh(parama.bOU());
      parama.oBi = 0;
    }
    if (parama.msgType == 3)
    {
      this.fXz = 40;
      if (paramInt != 1) {
        break label556;
      }
      this.fXz = 1250;
    }
    label550:
    label556:
    for (int i = 1;; i = 0)
    {
      parama.oBj = i;
      parama.status = 104;
      parama.oBi = 0;
      localObject = new StringBuilder();
      aw.aaz();
      parama.bWt = ((int)com.tencent.mm.vfs.e.avI(com.tencent.mm.model.c.YK() + parama.bOU()));
      break;
      if (parama.msgType == 1)
      {
        this.fXz = 1;
        parama.status = 104;
        parama.bWt = parama.bOU().getBytes().length;
        parama.oBi = 0;
        break;
      }
      ab.d("MicroMsg.NetSceneMasSend", "error msgtype:" + parama.msgType);
      Assert.assertTrue("error msgtype:" + parama.msgType, false);
      break;
      i = 0;
      break label302;
    }
  }
  
  public final void cancel()
  {
    this.eUJ = true;
  }
  
  public final int doScene(com.tencent.mm.network.e parame, com.tencent.mm.ai.f paramf)
  {
    int j = 0;
    int i = 0;
    AppMethodBeat.i(22739);
    this.callback = paramf;
    if (this.eUJ)
    {
      ab.d("MicroMsg.NetSceneMasSend", "isCancel");
      this.retCode = (0 - (com.tencent.mm.compatible.util.g.getLine() + 10000));
      AppMethodBeat.o(22739);
      return -1;
    }
    this.fXz -= 1;
    if (this.fXz < 0)
    {
      ab.d("MicroMsg.NetSceneMasSend", "MAX_SEND_TIMES");
      this.retCode = (0 - (com.tencent.mm.compatible.util.g.getLine() + 10000));
      AppMethodBeat.o(22739);
      return -1;
    }
    if (this.oBm == null)
    {
      ab.d("MicroMsg.NetSceneMasSend", "MasSendInfo is null");
      this.retCode = (0 - (com.tencent.mm.compatible.util.g.getLine() + 10000));
      AppMethodBeat.o(22739);
      return -1;
    }
    if (bo.isNullOrNil(this.oBm.bOW()))
    {
      ab.d("MicroMsg.NetSceneMasSend", "MasSendInfo.toList is null");
      this.retCode = (0 - (com.tencent.mm.compatible.util.g.getLine() + 10000));
      AppMethodBeat.o(22739);
      return -1;
    }
    if (this.oBm.oBf == 0)
    {
      ab.d("MicroMsg.NetSceneMasSend", "getTolistCount is 0");
      this.retCode = (0 - (com.tencent.mm.compatible.util.g.getLine() + 10000));
      AppMethodBeat.o(22739);
      return -1;
    }
    if (this.oBm.bWt <= 0)
    {
      ab.d("MicroMsg.NetSceneMasSend", "getDataLen is 0");
      this.retCode = (0 - (com.tencent.mm.compatible.util.g.getLine() + 10000));
      AppMethodBeat.o(22739);
      return -1;
    }
    if ((this.oBm.status == 103) && (this.oBm.oBi <= 0))
    {
      ab.d("MicroMsg.NetSceneMasSend", "getThumbTotalLen is 0");
      this.retCode = (0 - (com.tencent.mm.compatible.util.g.getLine() + 10000));
      AppMethodBeat.o(22739);
      return -1;
    }
    if ((this.oBm.status != 103) && (this.oBm.status != 104))
    {
      ab.d("MicroMsg.NetSceneMasSend", "msg type :" + this.oBm.msgType);
      this.retCode = (0 - (com.tencent.mm.compatible.util.g.getLine() + 10000));
      AppMethodBeat.o(22739);
      return -1;
    }
    paramf = (bcn)this.rr.fsV.fta;
    Object localObject1;
    Object localObject2;
    if (this.oBm.msgType == 43)
    {
      localObject1 = this.oBm.bOU();
      if (bo.isNullOrNil((String)localObject1))
      {
        ab.d("MicroMsg.NetSceneMasSend", "MasSendInfo.fileName is null");
        this.retCode = (0 - (com.tencent.mm.compatible.util.g.getLine() + 10000));
        i = -1;
      }
      for (;;)
      {
        if (i == 0) {
          break label2254;
        }
        AppMethodBeat.o(22739);
        return i;
        paramf.xrA = new SKBuiltinBuffer_t();
        paramf.xrB = 0;
        paramf.xrF = new SKBuiltinBuffer_t();
        paramf.xrE = 0;
        paramf.xrG = 2;
        paramf.xrz = this.oBm.oBg;
        if (this.oBm.videoSource > 0) {}
        for (i = 2;; i = 0)
        {
          paramf.xrH = i;
          paramf.xrD = this.oBm.oBi;
          paramf.xrC = this.oBm.bWt;
          if (this.oBm.status != 103) {
            break label879;
          }
          o.alE();
          localObject2 = t.u(t.vg((String)localObject1), this.oBm.fXt, 8000);
          if ((((t.b)localObject2).ret >= 0) && (((t.b)localObject2).ckj != 0)) {
            break label647;
          }
          ab.e("MicroMsg.NetSceneMasSend", "doScene READ THUMB[" + (String)localObject1 + "]  Error ");
          this.retCode = (0 - (com.tencent.mm.compatible.util.g.getLine() + 10000));
          i = -1;
          break;
        }
        label647:
        ab.d("MicroMsg.NetSceneMasSend", "doScene READ THUMB[" + (String)localObject1 + "] read ret:" + ((t.b)localObject2).ret + " readlen:" + ((t.b)localObject2).ckj + " newOff:" + ((t.b)localObject2).fXX + " netOff:" + this.oBm.fXt);
        if (((t.b)localObject2).fXX >= this.oBm.fXt) {
          break;
        }
        ab.e("MicroMsg.NetSceneMasSend", "Err doScene READ THUMB[" + (String)localObject1 + "] newOff:" + ((t.b)localObject2).fXX + " OldtOff:" + this.oBm.fXt);
        this.retCode = (0 - (com.tencent.mm.compatible.util.g.getLine() + 10000));
        i = -1;
      }
      localObject1 = new byte[((t.b)localObject2).ckj];
      System.arraycopy(((t.b)localObject2).buf, 0, localObject1, 0, ((t.b)localObject2).ckj);
      paramf.xrE = this.oBm.fXt;
      localObject2 = new SKBuiltinBuffer_t();
      ((SKBuiltinBuffer_t)localObject2).setBuffer((byte[])localObject1);
      paramf.xrF = ((SKBuiltinBuffer_t)localObject2);
      for (;;)
      {
        i = 0;
        break;
        label879:
        o.alE();
        localObject2 = t.u(t.vf((String)localObject1), this.oBm.oBh, 8000);
        if ((((t.b)localObject2).ret < 0) || (((t.b)localObject2).ckj == 0))
        {
          ab.e("MicroMsg.NetSceneMasSend", "doScene READ VIDEO[" + (String)localObject1 + "]  Error ");
          this.retCode = (0 - (com.tencent.mm.compatible.util.g.getLine() + 10000));
          i = -1;
          break;
        }
        ab.d("MicroMsg.NetSceneMasSend", "doScene READ VIDEO[" + (String)localObject1 + "] read ret:" + ((t.b)localObject2).ret + " readlen:" + ((t.b)localObject2).ckj + " newOff:" + ((t.b)localObject2).fXX + " netOff:" + this.oBm.oBh);
        if (((t.b)localObject2).fXX < this.oBm.oBh)
        {
          ab.e("MicroMsg.NetSceneMasSend", "Err doScene READ VIDEO[" + (String)localObject1 + "] newOff:" + ((t.b)localObject2).fXX + " OldtOff:" + this.oBm.oBh);
          this.retCode = (0 - (com.tencent.mm.compatible.util.g.getLine() + 10000));
          i = -1;
          break;
        }
        if (((t.b)localObject2).fXX >= com.tencent.mm.modelvideo.c.fUY)
        {
          ab.e("MicroMsg.NetSceneMasSend", "Err doScene READ VIDEO[" + (String)localObject1 + "] maxsize:" + com.tencent.mm.modelvideo.c.fUY);
          this.retCode = (0 - (com.tencent.mm.compatible.util.g.getLine() + 10000));
          i = -1;
          break;
        }
        localObject1 = new byte[((t.b)localObject2).ckj];
        System.arraycopy(((t.b)localObject2).buf, 0, localObject1, 0, ((t.b)localObject2).ckj);
        paramf.xrB = this.oBm.oBh;
        paramf.xrE = this.oBm.fXt;
        localObject2 = new SKBuiltinBuffer_t();
        ((SKBuiltinBuffer_t)localObject2).setBuffer((byte[])localObject1);
        paramf.xrA = ((SKBuiltinBuffer_t)localObject2);
      }
    }
    if (this.oBm.msgType == 34)
    {
      paramf.xrG = 0;
      paramf.xrH = 0;
      paramf.xrA = new SKBuiltinBuffer_t().setBuffer(new byte[0]);
      paramf.xrB = 0;
      paramf.xrF = new SKBuiltinBuffer_t().setBuffer(new byte[0]);
      paramf.xrE = 0;
      paramf.xrD = 0;
      paramf.xrC = this.oBm.bWt;
      localObject1 = s.vK(this.oBm.bOU());
      if (localObject1 == null)
      {
        this.retCode = (0 - (com.tencent.mm.compatible.util.g.getLine() + 10000));
        ab.d("MicroMsg.NetSceneMasSend", "fileop is null");
        i = -1;
      }
      while (i != 0)
      {
        AppMethodBeat.o(22739);
        return -1;
        localObject2 = ((com.tencent.mm.modelvoice.b)localObject1).cJ(this.oBm.oBh, 8000);
        if (((com.tencent.mm.modelvoice.g)localObject2).ret < 0)
        {
          ab.e("MicroMsg.NetSceneMasSend", "Err doScene READ file[" + this.oBm.bOU() + "] read ret:" + ((com.tencent.mm.modelvoice.g)localObject2).ret + " readlen:" + ((com.tencent.mm.modelvoice.g)localObject2).ckj + " newOff:" + ((com.tencent.mm.modelvoice.g)localObject2).fXX + " netOff:" + this.oBm.oBh);
          this.retCode = (0 - (com.tencent.mm.compatible.util.g.getLine() + 10000));
          i = -1;
        }
        else if ((((com.tencent.mm.modelvoice.g)localObject2).fXX < this.oBm.oBh) || (((com.tencent.mm.modelvoice.g)localObject2).fXX >= 469000))
        {
          ab.e("MicroMsg.NetSceneMasSend", "Err doScene READ offseterror file[" + this.oBm.bOU() + "] read ret:" + ((com.tencent.mm.modelvoice.g)localObject2).ret + " readlen:" + ((com.tencent.mm.modelvoice.g)localObject2).ckj + " newOff:" + ((com.tencent.mm.modelvoice.g)localObject2).fXX + " netOff:" + this.oBm.oBh);
          this.retCode = (0 - (com.tencent.mm.compatible.util.g.getLine() + 10000));
          i = -1;
        }
        else if (this.oBm.bWt <= 0)
        {
          ab.e("MicroMsg.NetSceneMasSend", "Err doScene READ datalen file[" + this.oBm.bOU() + "] read totalLen:" + this.oBm.bWt);
          this.retCode = (com.tencent.mm.compatible.util.g.getLine() + 10000);
          i = -1;
        }
        else
        {
          byte[] arrayOfByte = new byte[((com.tencent.mm.modelvoice.g)localObject2).ckj];
          System.arraycopy(((com.tencent.mm.modelvoice.g)localObject2).buf, 0, arrayOfByte, 0, ((com.tencent.mm.modelvoice.g)localObject2).ckj);
          paramf.xrA = new SKBuiltinBuffer_t().setBuffer(arrayOfByte);
          paramf.xrz = this.oBm.oBg;
          paramf.xrB = this.oBm.oBh;
          paramf.xrK = ((com.tencent.mm.modelvoice.b)localObject1).getFormat();
        }
      }
    }
    if (this.oBm.msgType == 3)
    {
      if (bo.isNullOrNil(this.oBm.bOU()))
      {
        ab.d("MicroMsg.NetSceneMasSend", "getFilename is null");
        this.retCode = (0 - (com.tencent.mm.compatible.util.g.getLine() + 10000));
        i = -1;
      }
      while (i != 0)
      {
        AppMethodBeat.o(22739);
        return -1;
        paramf.xrG = 0;
        paramf.xrH = 0;
        paramf.xrA = new SKBuiltinBuffer_t().setBuffer(new byte[0]);
        paramf.xrB = 0;
        paramf.xrF = new SKBuiltinBuffer_t().setBuffer(new byte[0]);
        paramf.xrE = 0;
        paramf.xrD = 0;
        paramf.xrz = 0;
        paramf.xrD = this.oBm.oBi;
        paramf.xrC = this.oBm.bWt;
        paramf.xdn = this.fDP;
        localObject1 = new StringBuilder();
        aw.aaz();
        localObject1 = com.tencent.mm.model.c.YK() + this.oBm.bOU();
        int k = this.oBm.bWt - this.oBm.oBh;
        i = k;
        if (k > 8000) {
          i = 8000;
        }
        localObject1 = com.tencent.mm.vfs.e.i((String)localObject1, this.oBm.oBh, i);
        if (bo.ce((byte[])localObject1))
        {
          ab.e("MicroMsg.NetSceneMasSend", "doScene READ data[" + this.oBm.bOU() + "]  Error ");
          this.retCode = (0 - (com.tencent.mm.compatible.util.g.getLine() + 10000));
          i = -1;
        }
        else
        {
          paramf.xrB = this.oBm.oBh;
          paramf.xrE = this.oBm.fXt;
          localObject2 = new SKBuiltinBuffer_t();
          ((SKBuiltinBuffer_t)localObject2).setBuffer((byte[])localObject1);
          paramf.xrA = ((SKBuiltinBuffer_t)localObject2);
          i = j;
        }
      }
    }
    if (this.oBm.msgType == 1)
    {
      paramf.xrA = new SKBuiltinBuffer_t().setBuffer(this.oBm.bOU().getBytes());
      paramf.xrC = this.oBm.bWt;
      paramf.xrz = 0;
      paramf.xrB = 0;
      paramf.xrF = new SKBuiltinBuffer_t().setBuffer(new byte[0]);
      paramf.xrE = 0;
      paramf.xrD = 0;
      paramf.xrG = 0;
      paramf.xrH = 0;
      label2254:
      i = dispatch(parame, this.rr, this);
      AppMethodBeat.o(22739);
      return i;
    }
    ab.d("MicroMsg.NetSceneMasSend", "error msgtype:" + this.oBm.msgType);
    this.retCode = (0 - (com.tencent.mm.compatible.util.g.getLine() + 10000));
    AppMethodBeat.o(22739);
    return -1;
  }
  
  public final int getType()
  {
    return 193;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, com.tencent.mm.network.q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(22740);
    ab.d("MicroMsg.NetSceneMasSend", "onGYNetEnd  errtype:" + paramInt2 + " errCode:" + paramInt3);
    updateDispatchId(paramInt1);
    if ((paramInt2 != 0) || (paramInt3 != 0))
    {
      ab.e("MicroMsg.NetSceneMasSend", "ERR: onGYNetEnd FAILED errtype:" + paramInt2 + " errCode:" + paramInt3);
      this.retCode = (0 - com.tencent.mm.compatible.util.g.getLine() - 10000);
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(22740);
      return;
    }
    if (this.oBm == null)
    {
      ab.e("MicroMsg.NetSceneMasSend", "ERR: onGYNetEnd Get INFO FAILED :");
      this.retCode = (0 - com.tencent.mm.compatible.util.g.getLine() - 10000);
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(22740);
      return;
    }
    if ((this.oBm.status != 104) && (this.oBm.status != 103))
    {
      ab.e("MicroMsg.NetSceneMasSend", "ERR: onGYNetEnd STATUS ERR: status:" + this.oBm.status);
      this.retCode = (0 - com.tencent.mm.compatible.util.g.getLine() - 10000);
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(22740);
      return;
    }
    paramArrayOfByte = (bco)this.rr.fsW.fta;
    paramq = (bcn)this.rr.fsV.fta;
    if ((paramq.xrD > 0) && (paramq.xrF != null) && (paramq.xrF.getBuffer() != null) && (!bo.ce(paramq.xrF.getBuffer().toByteArray())) && (paramq.xrE != paramArrayOfByte.xrE - paramq.xrF.getILen()))
    {
      ab.e("MicroMsg.NetSceneMasSend", "onGYNetEnd Err Thumb ");
      this.retCode = (0 - com.tencent.mm.compatible.util.g.getLine() - 10000);
      this.callback.onSceneEnd(3, -1, "doScene failed", this);
      AppMethodBeat.o(22740);
      return;
    }
    if ((paramq.xrC > 0) && (paramq.xrA != null) && (paramq.xrA.getBuffer() != null) && (!bo.ce(paramq.xrA.getBuffer().toByteArray())) && (paramq.xrB != paramArrayOfByte.xrB - paramq.xrA.getILen()))
    {
      ab.e("MicroMsg.NetSceneMasSend", "onGYNetEnd Err Data ");
      this.retCode = (0 - com.tencent.mm.compatible.util.g.getLine() - 10000);
      this.callback.onSceneEnd(3, -1, "doScene failed", this);
      AppMethodBeat.o(22740);
      return;
    }
    this.oBm.fXv = bo.aox();
    paramInt1 = this.oBm.status;
    if (paramInt1 == 103)
    {
      paramArrayOfByte = this.oBm;
      paramInt1 = paramq.xrE;
      paramArrayOfByte.fXt = (paramq.xrF.getILen() + paramInt1);
      if (this.oBm.fXt >= this.oBm.oBi) {
        this.oBm.status = 199;
      }
    }
    while (this.oBm.status != 199)
    {
      if (doScene(dispatcher(), this.callback) != -1) {
        break label1523;
      }
      this.retCode = (0 - (com.tencent.mm.compatible.util.g.getLine() + 10000));
      this.callback.onSceneEnd(3, -1, "doScene failed", this);
      AppMethodBeat.o(22740);
      return;
      if (paramInt1 == 104)
      {
        paramArrayOfByte = this.oBm;
        paramInt1 = paramq.xrB;
        paramArrayOfByte.oBh = (paramq.xrA.getILen() + paramInt1);
        if (this.oBm.oBh >= this.oBm.bWt) {
          if (this.oBm.oBi > 0) {
            this.oBm.status = 103;
          } else {
            this.oBm.status = 199;
          }
        }
      }
      else
      {
        ab.e("MicroMsg.NetSceneMasSend", "onGYNetEnd ERROR STATUS:".concat(String.valueOf(paramInt1)));
        this.retCode = (0 - com.tencent.mm.compatible.util.g.getLine() - 10000);
        this.callback.onSceneEnd(3, -1, "doScene failed", this);
        AppMethodBeat.o(22740);
        return;
      }
    }
    paramArrayOfByte = h.bPc();
    a locala = this.oBm;
    if (locala != null)
    {
      locala.bsY = -1;
      ContentValues localContentValues = new ContentValues();
      if ((locala.bsY & 0x1) != 0) {
        localContentValues.put("clientid", locala.bOT());
      }
      if ((locala.bsY & 0x2) != 0) {
        localContentValues.put("status", Integer.valueOf(locala.status));
      }
      if ((locala.bsY & 0x4) != 0) {
        localContentValues.put("createtime", Long.valueOf(locala.createTime));
      }
      if ((locala.bsY & 0x8) != 0) {
        localContentValues.put("lastmodifytime", Long.valueOf(locala.fXv));
      }
      if ((locala.bsY & 0x10) != 0) {
        localContentValues.put("filename", locala.bOU());
      }
      if ((locala.bsY & 0x20) != 0) {
        localContentValues.put("thumbfilename", locala.bOV());
      }
      if ((locala.bsY & 0x40) != 0) {
        localContentValues.put("tolist", locala.bOW());
      }
      if ((locala.bsY & 0x80) != 0) {
        localContentValues.put("tolistcount", Integer.valueOf(locala.oBf));
      }
      if ((locala.bsY & 0x100) != 0) {
        localContentValues.put("msgtype", Integer.valueOf(locala.msgType));
      }
      if ((locala.bsY & 0x200) != 0) {
        localContentValues.put("mediatime", Integer.valueOf(locala.oBg));
      }
      if ((locala.bsY & 0x400) != 0) {
        localContentValues.put("datanetoffset", Integer.valueOf(locala.oBh));
      }
      if ((locala.bsY & 0x800) != 0) {
        localContentValues.put("datalen", Integer.valueOf(locala.bWt));
      }
      if ((locala.bsY & 0x1000) != 0) {
        localContentValues.put("thumbnetoffset", Integer.valueOf(locala.fXt));
      }
      if ((locala.bsY & 0x2000) != 0) {
        localContentValues.put("thumbtotallen", Integer.valueOf(locala.oBi));
      }
      if ((locala.bsY & 0x4000) != 0) {
        localContentValues.put("reserved1", Integer.valueOf(locala.videoSource));
      }
      if ((locala.bsY & 0x8000) != 0) {
        localContentValues.put("reserved2", Integer.valueOf(locala.oBj));
      }
      if ((locala.bsY & 0x10000) != 0)
      {
        if (locala.fnu != null) {
          break label1471;
        }
        paramq = "";
        localContentValues.put("reserved3", paramq);
      }
      if ((locala.bsY & 0x20000) != 0)
      {
        if (locala.fnv != null) {
          break label1481;
        }
        paramq = "";
        label1294:
        localContentValues.put("reserved4", paramq);
      }
      if ((int)paramArrayOfByte.fnw.a("massendinfo", "clientid", localContentValues) != -1)
      {
        aw.aaz();
        if (com.tencent.mm.model.c.YF().arH("masssendapp") != null) {
          break label1491;
        }
        paramInt1 = 1;
        label1345:
        paramq = new ak();
        paramq.setUsername("masssendapp");
        paramq.setContent(b.a(locala));
        paramq.fK(locala.createTime);
        paramq.hL(0);
        paramq.hJ(0);
        if (paramInt1 == 0) {
          break label1496;
        }
        aw.aaz();
        com.tencent.mm.model.c.YF().d(paramq);
        label1413:
        paramArrayOfByte.doNotify();
      }
    }
    if (this.eMo != null) {}
    for (long l = this.eMo.Mm();; l = 0L)
    {
      ab.d("MicroMsg.NetSceneMasSend", "!!!FIN: useTime:".concat(String.valueOf(l)));
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(22740);
      return;
      label1471:
      paramq = locala.fnu;
      break;
      label1481:
      paramq = locala.fnv;
      break label1294;
      label1491:
      paramInt1 = 0;
      break label1345;
      label1496:
      aw.aaz();
      com.tencent.mm.model.c.YF().a(paramq, "masssendapp");
      break label1413;
    }
    label1523:
    AppMethodBeat.o(22740);
  }
  
  public final int securityLimitCount()
  {
    return 2500;
  }
  
  public final m.b securityVerificationChecked(com.tencent.mm.network.q paramq)
  {
    return m.b.ftu;
  }
  
  public final void setSecurityCheckError(m.a parama) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.masssend.a.f
 * JD-Core Version:    0.7.0.1
 */