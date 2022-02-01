package com.tencent.mm.plugin.masssend.a;

import android.content.ContentValues;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.d.a;
import com.tencent.mm.ak.d.b;
import com.tencent.mm.ak.d.c;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q.a;
import com.tencent.mm.ak.q.b;
import com.tencent.mm.compatible.util.f.a;
import com.tencent.mm.model.bg;
import com.tencent.mm.modelvideo.o;
import com.tencent.mm.modelvideo.t;
import com.tencent.mm.modelvideo.t.b;
import com.tencent.mm.network.m;
import com.tencent.mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.mm.protocal.protobuf.cmp;
import com.tencent.mm.protocal.protobuf.cmq;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.az;
import com.tencent.mm.storage.bw;
import junit.framework.Assert;

public final class f
  extends com.tencent.mm.ak.q
  implements m
{
  private i callback;
  f.a hvh;
  private int iXp;
  boolean ifz;
  int jsp;
  int retCode;
  public d rr;
  private a znu;
  
  public f(a parama, boolean paramBoolean)
  {
    this(parama, paramBoolean, 0);
  }
  
  public f(a parama, boolean paramBoolean, int paramInt)
  {
    AppMethodBeat.i(26360);
    this.znu = null;
    this.hvh = null;
    this.retCode = 0;
    this.jsp = 0;
    this.ifz = false;
    this.znu = parama;
    this.iXp = paramInt;
    parama.createTime = Util.nowMilliSecond();
    if (parama.msgType == 43)
    {
      parama.status = 104;
      o.bhj();
      parama.znq = t.Qy(t.Qx(parama.ehx()));
      o.bhj();
      parama.djh = t.Qy(t.Qw(parama.ehx()));
      this.jsp = 2500;
      if (parama.videoSource == 2) {
        this.jsp = 2500;
      }
    }
    Object localObject;
    for (;;)
    {
      localObject = new d.a();
      ((d.a)localObject).iLN = new cmp();
      ((d.a)localObject).iLO = new cmq();
      ((d.a)localObject).uri = "/cgi-bin/micromsg-bin/masssend";
      ((d.a)localObject).funcId = 193;
      ((d.a)localObject).iLP = 84;
      ((d.a)localObject).respCmdId = 1000000084;
      this.rr = ((d.a)localObject).aXF();
      localObject = (cmp)this.rr.iLK.iLR;
      ((cmp)localObject).MrN = com.tencent.mm.b.g.getMessageDigest(parama.ehz().getBytes());
      ((cmp)localObject).MrY = parama.znn;
      ((cmp)localObject).MrM = parama.ehz();
      parama.jlz = Util.nowMilliSecond();
      ((cmp)localObject).MrO = parama.ehw();
      ((cmp)localObject).xKb = parama.msgType;
      ((cmp)localObject).MrP = parama.zno;
      if (!paramBoolean) {
        break label550;
      }
      i = j;
      label302:
      ((cmp)localObject).MrZ = i;
      ((cmp)localObject).LYt = paramInt;
      this.hvh = new f.a();
      AppMethodBeat.o(26360);
      return;
      if (parama.msgType != 34) {
        break;
      }
      this.jsp = 40;
      parama.status = 104;
      parama.djh = com.tencent.mm.modelvoice.q.Qy(parama.ehx());
      parama.znq = 0;
    }
    if (parama.msgType == 3)
    {
      this.jsp = 40;
      if (paramInt != 1) {
        break label556;
      }
      this.jsp = 1250;
    }
    label550:
    label556:
    for (int i = 1;; i = 0)
    {
      parama.znr = i;
      parama.status = 104;
      parama.znq = 0;
      localObject = new StringBuilder();
      bg.aVF();
      parama.djh = ((int)com.tencent.mm.vfs.s.boW(com.tencent.mm.model.c.aSY() + parama.ehx()));
      break;
      if (parama.msgType == 1)
      {
        this.jsp = 1;
        parama.status = 104;
        parama.djh = parama.ehx().getBytes().length;
        parama.znq = 0;
        break;
      }
      Log.d("MicroMsg.NetSceneMasSend", "error msgtype:" + parama.msgType);
      Assert.assertTrue("error msgtype:" + parama.msgType, false);
      break;
      i = 0;
      break label302;
    }
  }
  
  public final void cancel()
  {
    this.ifz = true;
  }
  
  public final int doScene(com.tencent.mm.network.g paramg, i parami)
  {
    int j = 0;
    int i = 0;
    AppMethodBeat.i(26361);
    this.callback = parami;
    if (this.ifz)
    {
      Log.d("MicroMsg.NetSceneMasSend", "isCancel");
      this.retCode = (0 - (com.tencent.mm.compatible.util.f.getLine() + 10000));
      AppMethodBeat.o(26361);
      return -1;
    }
    this.jsp -= 1;
    if (this.jsp < 0)
    {
      Log.d("MicroMsg.NetSceneMasSend", "MAX_SEND_TIMES");
      this.retCode = (0 - (com.tencent.mm.compatible.util.f.getLine() + 10000));
      AppMethodBeat.o(26361);
      return -1;
    }
    if (this.znu == null)
    {
      Log.d("MicroMsg.NetSceneMasSend", "MasSendInfo is null");
      this.retCode = (0 - (com.tencent.mm.compatible.util.f.getLine() + 10000));
      AppMethodBeat.o(26361);
      return -1;
    }
    if (Util.isNullOrNil(this.znu.ehz()))
    {
      Log.d("MicroMsg.NetSceneMasSend", "MasSendInfo.toList is null");
      this.retCode = (0 - (com.tencent.mm.compatible.util.f.getLine() + 10000));
      AppMethodBeat.o(26361);
      return -1;
    }
    if (this.znu.znn == 0)
    {
      Log.d("MicroMsg.NetSceneMasSend", "getTolistCount is 0");
      this.retCode = (0 - (com.tencent.mm.compatible.util.f.getLine() + 10000));
      AppMethodBeat.o(26361);
      return -1;
    }
    if (this.znu.djh <= 0)
    {
      Log.d("MicroMsg.NetSceneMasSend", "getDataLen is 0");
      this.retCode = (0 - (com.tencent.mm.compatible.util.f.getLine() + 10000));
      AppMethodBeat.o(26361);
      return -1;
    }
    if ((this.znu.status == 103) && (this.znu.znq <= 0))
    {
      Log.d("MicroMsg.NetSceneMasSend", "getThumbTotalLen is 0");
      this.retCode = (0 - (com.tencent.mm.compatible.util.f.getLine() + 10000));
      AppMethodBeat.o(26361);
      return -1;
    }
    if ((this.znu.status != 103) && (this.znu.status != 104))
    {
      Log.d("MicroMsg.NetSceneMasSend", "msg type :" + this.znu.msgType);
      this.retCode = (0 - (com.tencent.mm.compatible.util.f.getLine() + 10000));
      AppMethodBeat.o(26361);
      return -1;
    }
    parami = (cmp)this.rr.iLK.iLR;
    Object localObject1;
    Object localObject2;
    if (this.znu.msgType == 43)
    {
      localObject1 = this.znu.ehx();
      if (Util.isNullOrNil((String)localObject1))
      {
        Log.d("MicroMsg.NetSceneMasSend", "MasSendInfo.fileName is null");
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
        parami.MrQ = new SKBuiltinBuffer_t();
        parami.MrR = 0;
        parami.MrV = new SKBuiltinBuffer_t();
        parami.MrU = 0;
        parami.MrW = 2;
        parami.MrP = this.znu.zno;
        if (this.znu.videoSource > 0) {}
        for (i = 2;; i = 0)
        {
          parami.MrX = i;
          parami.MrT = this.znu.znq;
          parami.MrS = this.znu.djh;
          if (this.znu.status != 103) {
            break label879;
          }
          o.bhj();
          localObject2 = t.t(t.Qx((String)localObject1), this.znu.jsk, 8000);
          if ((((t.b)localObject2).ret >= 0) && (((t.b)localObject2).dAc != 0)) {
            break label647;
          }
          Log.e("MicroMsg.NetSceneMasSend", "doScene READ THUMB[" + (String)localObject1 + "]  Error ");
          this.retCode = (0 - (com.tencent.mm.compatible.util.f.getLine() + 10000));
          i = -1;
          break;
        }
        label647:
        Log.d("MicroMsg.NetSceneMasSend", "doScene READ THUMB[" + (String)localObject1 + "] read ret:" + ((t.b)localObject2).ret + " readlen:" + ((t.b)localObject2).dAc + " newOff:" + ((t.b)localObject2).jsR + " netOff:" + this.znu.jsk);
        if (((t.b)localObject2).jsR >= this.znu.jsk) {
          break;
        }
        Log.e("MicroMsg.NetSceneMasSend", "Err doScene READ THUMB[" + (String)localObject1 + "] newOff:" + ((t.b)localObject2).jsR + " OldtOff:" + this.znu.jsk);
        this.retCode = (0 - (com.tencent.mm.compatible.util.f.getLine() + 10000));
        i = -1;
      }
      localObject1 = new byte[((t.b)localObject2).dAc];
      System.arraycopy(((t.b)localObject2).buf, 0, localObject1, 0, ((t.b)localObject2).dAc);
      parami.MrU = this.znu.jsk;
      localObject2 = new SKBuiltinBuffer_t();
      ((SKBuiltinBuffer_t)localObject2).setBuffer((byte[])localObject1);
      parami.MrV = ((SKBuiltinBuffer_t)localObject2);
      for (;;)
      {
        i = 0;
        break;
        label879:
        o.bhj();
        localObject2 = t.t(t.Qw((String)localObject1), this.znu.znp, 8000);
        if ((((t.b)localObject2).ret < 0) || (((t.b)localObject2).dAc == 0))
        {
          Log.e("MicroMsg.NetSceneMasSend", "doScene READ VIDEO[" + (String)localObject1 + "]  Error ");
          this.retCode = (0 - (com.tencent.mm.compatible.util.f.getLine() + 10000));
          i = -1;
          break;
        }
        Log.d("MicroMsg.NetSceneMasSend", "doScene READ VIDEO[" + (String)localObject1 + "] read ret:" + ((t.b)localObject2).ret + " readlen:" + ((t.b)localObject2).dAc + " newOff:" + ((t.b)localObject2).jsR + " netOff:" + this.znu.znp);
        if (((t.b)localObject2).jsR < this.znu.znp)
        {
          Log.e("MicroMsg.NetSceneMasSend", "Err doScene READ VIDEO[" + (String)localObject1 + "] newOff:" + ((t.b)localObject2).jsR + " OldtOff:" + this.znu.znp);
          this.retCode = (0 - (com.tencent.mm.compatible.util.f.getLine() + 10000));
          i = -1;
          break;
        }
        if (((t.b)localObject2).jsR >= com.tencent.mm.modelvideo.c.jpN)
        {
          Log.e("MicroMsg.NetSceneMasSend", "Err doScene READ VIDEO[" + (String)localObject1 + "] maxsize:" + com.tencent.mm.modelvideo.c.jpN);
          this.retCode = (0 - (com.tencent.mm.compatible.util.f.getLine() + 10000));
          i = -1;
          break;
        }
        localObject1 = new byte[((t.b)localObject2).dAc];
        System.arraycopy(((t.b)localObject2).buf, 0, localObject1, 0, ((t.b)localObject2).dAc);
        parami.MrR = this.znu.znp;
        parami.MrU = this.znu.jsk;
        localObject2 = new SKBuiltinBuffer_t();
        ((SKBuiltinBuffer_t)localObject2).setBuffer((byte[])localObject1);
        parami.MrQ = ((SKBuiltinBuffer_t)localObject2);
      }
    }
    if (this.znu.msgType == 34)
    {
      parami.MrW = 0;
      parami.MrX = 0;
      parami.MrQ = new SKBuiltinBuffer_t().setBuffer(new byte[0]);
      parami.MrR = 0;
      parami.MrV = new SKBuiltinBuffer_t().setBuffer(new byte[0]);
      parami.MrU = 0;
      parami.MrT = 0;
      parami.MrS = this.znu.djh;
      localObject1 = com.tencent.mm.modelvoice.s.Rf(this.znu.ehx());
      if (localObject1 == null)
      {
        this.retCode = (0 - (com.tencent.mm.compatible.util.f.getLine() + 10000));
        Log.d("MicroMsg.NetSceneMasSend", "fileop is null");
        i = -1;
      }
      while (i != 0)
      {
        AppMethodBeat.o(26361);
        return -1;
        localObject2 = ((com.tencent.mm.modelvoice.b)localObject1).dB(this.znu.znp, 8000);
        if (((com.tencent.mm.modelvoice.g)localObject2).ret < 0)
        {
          Log.e("MicroMsg.NetSceneMasSend", "Err doScene READ file[" + this.znu.ehx() + "] read ret:" + ((com.tencent.mm.modelvoice.g)localObject2).ret + " readlen:" + ((com.tencent.mm.modelvoice.g)localObject2).dAc + " newOff:" + ((com.tencent.mm.modelvoice.g)localObject2).jsR + " netOff:" + this.znu.znp);
          this.retCode = (0 - (com.tencent.mm.compatible.util.f.getLine() + 10000));
          i = -1;
        }
        else if ((((com.tencent.mm.modelvoice.g)localObject2).jsR < this.znu.znp) || (((com.tencent.mm.modelvoice.g)localObject2).jsR >= 469000))
        {
          Log.e("MicroMsg.NetSceneMasSend", "Err doScene READ offseterror file[" + this.znu.ehx() + "] read ret:" + ((com.tencent.mm.modelvoice.g)localObject2).ret + " readlen:" + ((com.tencent.mm.modelvoice.g)localObject2).dAc + " newOff:" + ((com.tencent.mm.modelvoice.g)localObject2).jsR + " netOff:" + this.znu.znp);
          this.retCode = (0 - (com.tencent.mm.compatible.util.f.getLine() + 10000));
          i = -1;
        }
        else if (this.znu.djh <= 0)
        {
          Log.e("MicroMsg.NetSceneMasSend", "Err doScene READ datalen file[" + this.znu.ehx() + "] read totalLen:" + this.znu.djh);
          this.retCode = (com.tencent.mm.compatible.util.f.getLine() + 10000);
          i = -1;
        }
        else
        {
          byte[] arrayOfByte = new byte[((com.tencent.mm.modelvoice.g)localObject2).dAc];
          System.arraycopy(((com.tencent.mm.modelvoice.g)localObject2).buf, 0, arrayOfByte, 0, ((com.tencent.mm.modelvoice.g)localObject2).dAc);
          parami.MrQ = new SKBuiltinBuffer_t().setBuffer(arrayOfByte);
          parami.MrP = this.znu.zno;
          parami.MrR = this.znu.znp;
          parami.Msa = ((com.tencent.mm.modelvoice.b)localObject1).getFormat();
        }
      }
    }
    if (this.znu.msgType == 3)
    {
      if (Util.isNullOrNil(this.znu.ehx()))
      {
        Log.d("MicroMsg.NetSceneMasSend", "getFilename is null");
        this.retCode = (0 - (com.tencent.mm.compatible.util.f.getLine() + 10000));
        i = -1;
      }
      while (i != 0)
      {
        AppMethodBeat.o(26361);
        return -1;
        parami.MrW = 0;
        parami.MrX = 0;
        parami.MrQ = new SKBuiltinBuffer_t().setBuffer(new byte[0]);
        parami.MrR = 0;
        parami.MrV = new SKBuiltinBuffer_t().setBuffer(new byte[0]);
        parami.MrU = 0;
        parami.MrT = 0;
        parami.MrP = 0;
        parami.MrT = this.znu.znq;
        parami.MrS = this.znu.djh;
        parami.LYt = this.iXp;
        localObject1 = new StringBuilder();
        bg.aVF();
        localObject1 = com.tencent.mm.model.c.aSY() + this.znu.ehx();
        int k = this.znu.djh - this.znu.znp;
        i = k;
        if (k > 8000) {
          i = 8000;
        }
        localObject1 = com.tencent.mm.vfs.s.aW((String)localObject1, this.znu.znp, i);
        if (Util.isNullOrNil((byte[])localObject1))
        {
          Log.e("MicroMsg.NetSceneMasSend", "doScene READ data[" + this.znu.ehx() + "]  Error ");
          this.retCode = (0 - (com.tencent.mm.compatible.util.f.getLine() + 10000));
          i = -1;
        }
        else
        {
          parami.MrR = this.znu.znp;
          parami.MrU = this.znu.jsk;
          localObject2 = new SKBuiltinBuffer_t();
          ((SKBuiltinBuffer_t)localObject2).setBuffer((byte[])localObject1);
          parami.MrQ = ((SKBuiltinBuffer_t)localObject2);
          i = j;
        }
      }
    }
    if (this.znu.msgType == 1)
    {
      parami.MrQ = new SKBuiltinBuffer_t().setBuffer(this.znu.ehx().getBytes());
      parami.MrS = this.znu.djh;
      parami.MrP = 0;
      parami.MrR = 0;
      parami.MrV = new SKBuiltinBuffer_t().setBuffer(new byte[0]);
      parami.MrU = 0;
      parami.MrT = 0;
      parami.MrW = 0;
      parami.MrX = 0;
      label2254:
      i = dispatch(paramg, this.rr, this);
      AppMethodBeat.o(26361);
      return i;
    }
    Log.d("MicroMsg.NetSceneMasSend", "error msgtype:" + this.znu.msgType);
    this.retCode = (0 - (com.tencent.mm.compatible.util.f.getLine() + 10000));
    AppMethodBeat.o(26361);
    return -1;
  }
  
  public final int getType()
  {
    return 193;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, com.tencent.mm.network.s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(26362);
    Log.d("MicroMsg.NetSceneMasSend", "onGYNetEnd  errtype:" + paramInt2 + " errCode:" + paramInt3);
    updateDispatchId(paramInt1);
    if ((paramInt2 != 0) || (paramInt3 != 0))
    {
      Log.e("MicroMsg.NetSceneMasSend", "ERR: onGYNetEnd FAILED errtype:" + paramInt2 + " errCode:" + paramInt3);
      this.retCode = (0 - com.tencent.mm.compatible.util.f.getLine() - 10000);
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(26362);
      return;
    }
    if (this.znu == null)
    {
      Log.e("MicroMsg.NetSceneMasSend", "ERR: onGYNetEnd Get INFO FAILED :");
      this.retCode = (0 - com.tencent.mm.compatible.util.f.getLine() - 10000);
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(26362);
      return;
    }
    if ((this.znu.status != 104) && (this.znu.status != 103))
    {
      Log.e("MicroMsg.NetSceneMasSend", "ERR: onGYNetEnd STATUS ERR: status:" + this.znu.status);
      this.retCode = (0 - com.tencent.mm.compatible.util.f.getLine() - 10000);
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(26362);
      return;
    }
    paramArrayOfByte = (cmq)this.rr.iLL.iLR;
    params = (cmp)this.rr.iLK.iLR;
    if ((params.MrT > 0) && (params.MrV != null) && (params.MrV.getBuffer() != null) && (!Util.isNullOrNil(params.MrV.getBuffer().toByteArray())) && (params.MrU != paramArrayOfByte.MrU - params.MrV.getILen()))
    {
      Log.e("MicroMsg.NetSceneMasSend", "onGYNetEnd Err Thumb ");
      this.retCode = (0 - com.tencent.mm.compatible.util.f.getLine() - 10000);
      this.callback.onSceneEnd(3, -1, "doScene failed", this);
      AppMethodBeat.o(26362);
      return;
    }
    if ((params.MrS > 0) && (params.MrQ != null) && (params.MrQ.getBuffer() != null) && (!Util.isNullOrNil(params.MrQ.getBuffer().toByteArray())) && (params.MrR != paramArrayOfByte.MrR - params.MrQ.getILen()))
    {
      Log.e("MicroMsg.NetSceneMasSend", "onGYNetEnd Err Data ");
      this.retCode = (0 - com.tencent.mm.compatible.util.f.getLine() - 10000);
      this.callback.onSceneEnd(3, -1, "doScene failed", this);
      AppMethodBeat.o(26362);
      return;
    }
    this.znu.jsm = Util.nowSecond();
    paramInt1 = this.znu.status;
    if (paramInt1 == 103)
    {
      paramArrayOfByte = this.znu;
      paramInt1 = params.MrU;
      paramArrayOfByte.jsk = (params.MrV.getILen() + paramInt1);
      if (this.znu.jsk >= this.znu.znq) {
        this.znu.status = 199;
      }
    }
    while (this.znu.status != 199)
    {
      if (doScene(dispatcher(), this.callback) != -1) {
        break label1529;
      }
      this.retCode = (0 - (com.tencent.mm.compatible.util.f.getLine() + 10000));
      this.callback.onSceneEnd(3, -1, "doScene failed", this);
      AppMethodBeat.o(26362);
      return;
      if (paramInt1 == 104)
      {
        paramArrayOfByte = this.znu;
        paramInt1 = params.MrR;
        paramArrayOfByte.znp = (params.MrQ.getILen() + paramInt1);
        if (this.znu.znp >= this.znu.djh) {
          if (this.znu.znq > 0) {
            this.znu.status = 103;
          } else {
            this.znu.status = 199;
          }
        }
      }
      else
      {
        Log.e("MicroMsg.NetSceneMasSend", "onGYNetEnd ERROR STATUS:".concat(String.valueOf(paramInt1)));
        this.retCode = (0 - com.tencent.mm.compatible.util.f.getLine() - 10000);
        this.callback.onSceneEnd(3, -1, "doScene failed", this);
        AppMethodBeat.o(26362);
        return;
      }
    }
    paramArrayOfByte = h.ehF();
    a locala = this.znu;
    if (locala != null)
    {
      locala.cSx = -1;
      ContentValues localContentValues = new ContentValues();
      if ((locala.cSx & 0x1) != 0) {
        localContentValues.put("clientid", locala.ehw());
      }
      if ((locala.cSx & 0x2) != 0) {
        localContentValues.put("status", Integer.valueOf(locala.status));
      }
      if ((locala.cSx & 0x4) != 0) {
        localContentValues.put("createtime", Long.valueOf(locala.createTime));
      }
      if ((locala.cSx & 0x8) != 0) {
        localContentValues.put("lastmodifytime", Long.valueOf(locala.jsm));
      }
      if ((locala.cSx & 0x10) != 0) {
        localContentValues.put("filename", locala.ehx());
      }
      if ((locala.cSx & 0x20) != 0) {
        localContentValues.put("thumbfilename", locala.ehy());
      }
      if ((locala.cSx & 0x40) != 0) {
        localContentValues.put("tolist", locala.ehz());
      }
      if ((locala.cSx & 0x80) != 0) {
        localContentValues.put("tolistcount", Integer.valueOf(locala.znn));
      }
      if ((locala.cSx & 0x100) != 0) {
        localContentValues.put("msgtype", Integer.valueOf(locala.msgType));
      }
      if ((locala.cSx & 0x200) != 0) {
        localContentValues.put("mediatime", Integer.valueOf(locala.zno));
      }
      if ((locala.cSx & 0x400) != 0) {
        localContentValues.put("datanetoffset", Integer.valueOf(locala.znp));
      }
      if ((locala.cSx & 0x800) != 0) {
        localContentValues.put("datalen", Integer.valueOf(locala.djh));
      }
      if ((locala.cSx & 0x1000) != 0) {
        localContentValues.put("thumbnetoffset", Integer.valueOf(locala.jsk));
      }
      if ((locala.cSx & 0x2000) != 0) {
        localContentValues.put("thumbtotallen", Integer.valueOf(locala.znq));
      }
      if ((locala.cSx & 0x4000) != 0) {
        localContentValues.put("reserved1", Integer.valueOf(locala.videoSource));
      }
      if ((locala.cSx & 0x8000) != 0) {
        localContentValues.put("reserved2", Integer.valueOf(locala.znr));
      }
      if ((locala.cSx & 0x10000) != 0)
      {
        if (locala.iFt != null) {
          break label1477;
        }
        params = "";
        localContentValues.put("reserved3", params);
      }
      if ((locala.cSx & 0x20000) != 0)
      {
        if (locala.iFu != null) {
          break label1487;
        }
        params = "";
        label1294:
        localContentValues.put("reserved4", params);
      }
      if ((int)paramArrayOfByte.iFy.insert("massendinfo", "clientid", localContentValues) != -1)
      {
        bg.aVF();
        if (com.tencent.mm.model.c.aST().bjY("masssendapp") != null) {
          break label1497;
        }
        paramInt1 = 1;
        label1345:
        params = new az();
        params.setUsername("masssendapp");
        params.setContent(b.a(locala));
        params.yA(locala.createTime);
        params.nv(0);
        params.nt(0);
        params.Co(null);
        if (paramInt1 == 0) {
          break label1502;
        }
        bg.aVF();
        com.tencent.mm.model.c.aST().e(params);
        label1419:
        paramArrayOfByte.doNotify();
      }
    }
    if (this.hvh != null) {}
    for (long l = this.hvh.apr();; l = 0L)
    {
      Log.d("MicroMsg.NetSceneMasSend", "!!!FIN: useTime:".concat(String.valueOf(l)));
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(26362);
      return;
      label1477:
      params = locala.iFt;
      break;
      label1487:
      params = locala.iFu;
      break label1294;
      label1497:
      paramInt1 = 0;
      break label1345;
      label1502:
      bg.aVF();
      com.tencent.mm.model.c.aST().a(params, "masssendapp");
      break label1419;
    }
    label1529:
    AppMethodBeat.o(26362);
  }
  
  public final int securityLimitCount()
  {
    return 2500;
  }
  
  public final q.b securityVerificationChecked(com.tencent.mm.network.s params)
  {
    return q.b.iMq;
  }
  
  public final void setSecurityCheckError(q.a parama) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.masssend.a.f
 * JD-Core Version:    0.7.0.1
 */