package com.tencent.mm.plugin.masssend.model;

import android.content.ContentValues;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.c.a;
import com.tencent.mm.am.c.b;
import com.tencent.mm.am.c.c;
import com.tencent.mm.am.p;
import com.tencent.mm.am.p.a;
import com.tencent.mm.am.p.b;
import com.tencent.mm.compatible.util.f.a;
import com.tencent.mm.model.bh;
import com.tencent.mm.modelvideo.aa;
import com.tencent.mm.modelvideo.aa.b;
import com.tencent.mm.modelvideo.v;
import com.tencent.mm.modelvoice.q;
import com.tencent.mm.network.m;
import com.tencent.mm.protocal.protobuf.dmn;
import com.tencent.mm.protocal.protobuf.dmo;
import com.tencent.mm.protocal.protobuf.gol;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.bb;
import com.tencent.mm.storage.by;
import com.tencent.mm.vfs.y;
import junit.framework.Assert;

public final class f
  extends p
  implements m
{
  private a KNp;
  private com.tencent.mm.am.h callback;
  f.a mHw;
  boolean nzW;
  private int oGu;
  int pbd;
  int retCode;
  public com.tencent.mm.am.c rr;
  
  public f(a parama, boolean paramBoolean)
  {
    this(parama, paramBoolean, 0);
  }
  
  public f(a parama, boolean paramBoolean, int paramInt)
  {
    AppMethodBeat.i(26360);
    this.KNp = null;
    this.mHw = null;
    this.retCode = 0;
    this.pbd = 0;
    this.nzW = false;
    this.KNp = parama;
    this.oGu = paramInt;
    parama.createTime = Util.nowMilliSecond();
    if (parama.msgType == 43)
    {
      parama.status = 104;
      v.bOh();
      parama.KNl = aa.PZ(aa.PY(parama.fZN()));
      v.bOh();
      parama.heo = aa.PZ(aa.PX(parama.fZN()));
      this.pbd = 2500;
      if (parama.videoSource == 2) {
        this.pbd = 2500;
      }
    }
    Object localObject;
    for (;;)
    {
      localObject = new c.a();
      ((c.a)localObject).otE = new dmn();
      ((c.a)localObject).otF = new dmo();
      ((c.a)localObject).uri = "/cgi-bin/micromsg-bin/masssend";
      ((c.a)localObject).funcId = 193;
      ((c.a)localObject).otG = 84;
      ((c.a)localObject).respCmdId = 1000000084;
      this.rr = ((c.a)localObject).bEF();
      localObject = (dmn)c.b.b(this.rr.otB);
      ((dmn)localObject).aaSB = com.tencent.mm.b.g.getMessageDigest(parama.fZP().getBytes());
      ((dmn)localObject).aaSM = parama.KNi;
      ((dmn)localObject).aaSA = parama.fZP();
      parama.oUw = Util.nowMilliSecond();
      ((dmn)localObject).aaSC = parama.fZM();
      ((dmn)localObject).IIs = parama.msgType;
      ((dmn)localObject).aaSD = parama.KNj;
      if (!paramBoolean) {
        break label550;
      }
      i = j;
      label302:
      ((dmn)localObject).aaSN = i;
      ((dmn)localObject).aava = paramInt;
      this.mHw = new f.a();
      AppMethodBeat.o(26360);
      return;
      if (parama.msgType != 34) {
        break;
      }
      this.pbd = 40;
      parama.status = 104;
      parama.heo = q.PZ(parama.fZN());
      parama.KNl = 0;
    }
    if (parama.msgType == 3)
    {
      this.pbd = 40;
      if (paramInt != 1) {
        break label556;
      }
      this.pbd = 1250;
    }
    label550:
    label556:
    for (int i = 1;; i = 0)
    {
      parama.KNm = i;
      parama.status = 104;
      parama.KNl = 0;
      localObject = new StringBuilder();
      bh.bCz();
      parama.heo = ((int)y.bEl(com.tencent.mm.model.c.bzL() + parama.fZN()));
      break;
      if (parama.msgType == 1)
      {
        this.pbd = 1;
        parama.status = 104;
        parama.heo = parama.fZN().getBytes().length;
        parama.KNl = 0;
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
    this.nzW = true;
  }
  
  public final int doScene(com.tencent.mm.network.g paramg, com.tencent.mm.am.h paramh)
  {
    int j = 0;
    int i = 0;
    AppMethodBeat.i(26361);
    this.callback = paramh;
    if (this.nzW)
    {
      Log.d("MicroMsg.NetSceneMasSend", "isCancel");
      this.retCode = (0 - (com.tencent.mm.compatible.util.f.getLine() + 10000));
      AppMethodBeat.o(26361);
      return -1;
    }
    this.pbd -= 1;
    if (this.pbd < 0)
    {
      Log.d("MicroMsg.NetSceneMasSend", "MAX_SEND_TIMES");
      this.retCode = (0 - (com.tencent.mm.compatible.util.f.getLine() + 10000));
      AppMethodBeat.o(26361);
      return -1;
    }
    if (this.KNp == null)
    {
      Log.d("MicroMsg.NetSceneMasSend", "MasSendInfo is null");
      this.retCode = (0 - (com.tencent.mm.compatible.util.f.getLine() + 10000));
      AppMethodBeat.o(26361);
      return -1;
    }
    if (Util.isNullOrNil(this.KNp.fZP()))
    {
      Log.d("MicroMsg.NetSceneMasSend", "MasSendInfo.toList is null");
      this.retCode = (0 - (com.tencent.mm.compatible.util.f.getLine() + 10000));
      AppMethodBeat.o(26361);
      return -1;
    }
    if (this.KNp.KNi == 0)
    {
      Log.d("MicroMsg.NetSceneMasSend", "getTolistCount is 0");
      this.retCode = (0 - (com.tencent.mm.compatible.util.f.getLine() + 10000));
      AppMethodBeat.o(26361);
      return -1;
    }
    if (this.KNp.heo <= 0)
    {
      Log.d("MicroMsg.NetSceneMasSend", "getDataLen is 0");
      this.retCode = (0 - (com.tencent.mm.compatible.util.f.getLine() + 10000));
      AppMethodBeat.o(26361);
      return -1;
    }
    if ((this.KNp.status == 103) && (this.KNp.KNl <= 0))
    {
      Log.d("MicroMsg.NetSceneMasSend", "getThumbTotalLen is 0");
      this.retCode = (0 - (com.tencent.mm.compatible.util.f.getLine() + 10000));
      AppMethodBeat.o(26361);
      return -1;
    }
    if ((this.KNp.status != 103) && (this.KNp.status != 104))
    {
      Log.d("MicroMsg.NetSceneMasSend", "msg type :" + this.KNp.msgType);
      this.retCode = (0 - (com.tencent.mm.compatible.util.f.getLine() + 10000));
      AppMethodBeat.o(26361);
      return -1;
    }
    paramh = (dmn)c.b.b(this.rr.otB);
    Object localObject1;
    Object localObject2;
    if (this.KNp.msgType == 43)
    {
      localObject1 = this.KNp.fZN();
      if (Util.isNullOrNil((String)localObject1))
      {
        Log.d("MicroMsg.NetSceneMasSend", "MasSendInfo.fileName is null");
        this.retCode = (0 - (com.tencent.mm.compatible.util.f.getLine() + 10000));
        i = -1;
      }
      for (;;)
      {
        if (i == 0) {
          break label2297;
        }
        AppMethodBeat.o(26361);
        return i;
        paramh.aaSE = new gol();
        paramh.aaSF = 0;
        paramh.aaSJ = new gol();
        paramh.aaSI = 0;
        paramh.aaSK = 2;
        paramh.aaSD = this.KNp.KNj;
        if (this.KNp.videoSource > 0) {}
        for (i = 2;; i = 0)
        {
          paramh.aaSL = i;
          paramh.aaSH = this.KNp.KNl;
          paramh.aaSG = this.KNp.heo;
          if (this.KNp.status != 103) {
            break label884;
          }
          v.bOh();
          localObject2 = aa.x(aa.PY((String)localObject1), this.KNp.paY, 8000);
          if ((localObject2 != null) && (((aa.b)localObject2).ret >= 0) && (((aa.b)localObject2).hxg != 0)) {
            break label652;
          }
          Log.e("MicroMsg.NetSceneMasSend", "doScene READ THUMB[" + (String)localObject1 + "]  Error ");
          this.retCode = (0 - (com.tencent.mm.compatible.util.f.getLine() + 10000));
          i = -1;
          break;
        }
        label652:
        Log.d("MicroMsg.NetSceneMasSend", "doScene READ THUMB[" + (String)localObject1 + "] read ret:" + ((aa.b)localObject2).ret + " readlen:" + ((aa.b)localObject2).hxg + " newOff:" + ((aa.b)localObject2).pbK + " netOff:" + this.KNp.paY);
        if (((aa.b)localObject2).pbK >= this.KNp.paY) {
          break;
        }
        Log.e("MicroMsg.NetSceneMasSend", "Err doScene READ THUMB[" + (String)localObject1 + "] newOff:" + ((aa.b)localObject2).pbK + " OldtOff:" + this.KNp.paY);
        this.retCode = (0 - (com.tencent.mm.compatible.util.f.getLine() + 10000));
        i = -1;
      }
      localObject1 = new byte[((aa.b)localObject2).hxg];
      System.arraycopy(((aa.b)localObject2).buf, 0, localObject1, 0, ((aa.b)localObject2).hxg);
      paramh.aaSI = this.KNp.paY;
      localObject2 = new gol();
      ((gol)localObject2).df((byte[])localObject1);
      paramh.aaSJ = ((gol)localObject2);
      for (;;)
      {
        i = 0;
        break;
        label884:
        v.bOh();
        localObject2 = aa.x(aa.PX((String)localObject1), this.KNp.KNk, 8000);
        if ((localObject2 == null) || (((aa.b)localObject2).ret < 0) || (((aa.b)localObject2).hxg == 0))
        {
          Log.e("MicroMsg.NetSceneMasSend", "doScene READ VIDEO[" + (String)localObject1 + "]  Error ");
          this.retCode = (0 - (com.tencent.mm.compatible.util.f.getLine() + 10000));
          i = -1;
          break;
        }
        Log.d("MicroMsg.NetSceneMasSend", "doScene READ VIDEO[" + (String)localObject1 + "] read ret:" + ((aa.b)localObject2).ret + " readlen:" + ((aa.b)localObject2).hxg + " newOff:" + ((aa.b)localObject2).pbK + " netOff:" + this.KNp.KNk);
        if (((aa.b)localObject2).pbK < this.KNp.KNk)
        {
          Log.e("MicroMsg.NetSceneMasSend", "Err doScene READ VIDEO[" + (String)localObject1 + "] newOff:" + ((aa.b)localObject2).pbK + " OldtOff:" + this.KNp.KNk);
          this.retCode = (0 - (com.tencent.mm.compatible.util.f.getLine() + 10000));
          i = -1;
          break;
        }
        if (((aa.b)localObject2).pbK >= com.tencent.mm.modelvideo.g.oYh)
        {
          Log.e("MicroMsg.NetSceneMasSend", "Err doScene READ VIDEO[" + (String)localObject1 + "] maxsize:" + com.tencent.mm.modelvideo.g.oYh);
          this.retCode = (0 - (com.tencent.mm.compatible.util.f.getLine() + 10000));
          i = -1;
          break;
        }
        localObject1 = new byte[((aa.b)localObject2).hxg];
        System.arraycopy(((aa.b)localObject2).buf, 0, localObject1, 0, ((aa.b)localObject2).hxg);
        paramh.aaSF = this.KNp.KNk;
        paramh.aaSI = this.KNp.paY;
        localObject2 = new gol();
        ((gol)localObject2).df((byte[])localObject1);
        paramh.aaSE = ((gol)localObject2);
      }
    }
    if (this.KNp.msgType == 34)
    {
      paramh.aaSK = 0;
      paramh.aaSL = 0;
      paramh.aaSE = new gol().df(new byte[0]);
      paramh.aaSF = 0;
      paramh.aaSJ = new gol().df(new byte[0]);
      paramh.aaSI = 0;
      paramh.aaSH = 0;
      paramh.aaSG = this.KNp.heo;
      localObject1 = com.tencent.mm.modelvoice.s.QH(this.KNp.fZN());
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
        localObject2 = ((com.tencent.mm.modelvoice.b)localObject1).eQ(this.KNp.KNk, 8000);
        if (localObject2 == null)
        {
          this.retCode = (0 - (com.tencent.mm.compatible.util.f.getLine() + 10000));
          Log.d("MicroMsg.NetSceneMasSend", "readRes is null");
          i = -1;
        }
        else if (((com.tencent.mm.modelvoice.g)localObject2).ret < 0)
        {
          Log.e("MicroMsg.NetSceneMasSend", "Err doScene READ file[" + this.KNp.fZN() + "] read ret:" + ((com.tencent.mm.modelvoice.g)localObject2).ret + " readlen:" + ((com.tencent.mm.modelvoice.g)localObject2).hxg + " newOff:" + ((com.tencent.mm.modelvoice.g)localObject2).pbK + " netOff:" + this.KNp.KNk);
          this.retCode = (0 - (com.tencent.mm.compatible.util.f.getLine() + 10000));
          i = -1;
        }
        else if ((((com.tencent.mm.modelvoice.g)localObject2).pbK < this.KNp.KNk) || (((com.tencent.mm.modelvoice.g)localObject2).pbK >= 469000))
        {
          Log.e("MicroMsg.NetSceneMasSend", "Err doScene READ offseterror file[" + this.KNp.fZN() + "] read ret:" + ((com.tencent.mm.modelvoice.g)localObject2).ret + " readlen:" + ((com.tencent.mm.modelvoice.g)localObject2).hxg + " newOff:" + ((com.tencent.mm.modelvoice.g)localObject2).pbK + " netOff:" + this.KNp.KNk);
          this.retCode = (0 - (com.tencent.mm.compatible.util.f.getLine() + 10000));
          i = -1;
        }
        else if (this.KNp.heo <= 0)
        {
          Log.e("MicroMsg.NetSceneMasSend", "Err doScene READ datalen file[" + this.KNp.fZN() + "] read totalLen:" + this.KNp.heo);
          this.retCode = (com.tencent.mm.compatible.util.f.getLine() + 10000);
          i = -1;
        }
        else
        {
          byte[] arrayOfByte = new byte[((com.tencent.mm.modelvoice.g)localObject2).hxg];
          System.arraycopy(((com.tencent.mm.modelvoice.g)localObject2).buf, 0, arrayOfByte, 0, ((com.tencent.mm.modelvoice.g)localObject2).hxg);
          paramh.aaSE = new gol().df(arrayOfByte);
          paramh.aaSD = this.KNp.KNj;
          paramh.aaSF = this.KNp.KNk;
          paramh.aaSO = ((com.tencent.mm.modelvoice.b)localObject1).getFormat();
        }
      }
    }
    if (this.KNp.msgType == 3)
    {
      if (Util.isNullOrNil(this.KNp.fZN()))
      {
        Log.d("MicroMsg.NetSceneMasSend", "getFilename is null");
        this.retCode = (0 - (com.tencent.mm.compatible.util.f.getLine() + 10000));
        i = -1;
      }
      while (i != 0)
      {
        AppMethodBeat.o(26361);
        return -1;
        paramh.aaSK = 0;
        paramh.aaSL = 0;
        paramh.aaSE = new gol().df(new byte[0]);
        paramh.aaSF = 0;
        paramh.aaSJ = new gol().df(new byte[0]);
        paramh.aaSI = 0;
        paramh.aaSH = 0;
        paramh.aaSD = 0;
        paramh.aaSH = this.KNp.KNl;
        paramh.aaSG = this.KNp.heo;
        paramh.aava = this.oGu;
        localObject1 = new StringBuilder();
        bh.bCz();
        localObject1 = com.tencent.mm.model.c.bzL() + this.KNp.fZN();
        int k = this.KNp.heo - this.KNp.KNk;
        i = k;
        if (k > 8000) {
          i = 8000;
        }
        localObject1 = y.bi((String)localObject1, this.KNp.KNk, i);
        if (Util.isNullOrNil((byte[])localObject1))
        {
          Log.e("MicroMsg.NetSceneMasSend", "doScene READ data[" + this.KNp.fZN() + "]  Error ");
          this.retCode = (0 - (com.tencent.mm.compatible.util.f.getLine() + 10000));
          i = -1;
        }
        else
        {
          paramh.aaSF = this.KNp.KNk;
          paramh.aaSI = this.KNp.paY;
          localObject2 = new gol();
          ((gol)localObject2).df((byte[])localObject1);
          paramh.aaSE = ((gol)localObject2);
          i = j;
        }
      }
    }
    if (this.KNp.msgType == 1)
    {
      paramh.aaSE = new gol().df(this.KNp.fZN().getBytes());
      paramh.aaSG = this.KNp.heo;
      paramh.aaSD = 0;
      paramh.aaSF = 0;
      paramh.aaSJ = new gol().df(new byte[0]);
      paramh.aaSI = 0;
      paramh.aaSH = 0;
      paramh.aaSK = 0;
      paramh.aaSL = 0;
      label2297:
      i = dispatch(paramg, this.rr, this);
      AppMethodBeat.o(26361);
      return i;
    }
    Log.d("MicroMsg.NetSceneMasSend", "error msgtype:" + this.KNp.msgType);
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
    if (this.KNp == null)
    {
      Log.e("MicroMsg.NetSceneMasSend", "ERR: onGYNetEnd Get INFO FAILED :");
      this.retCode = (0 - com.tencent.mm.compatible.util.f.getLine() - 10000);
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(26362);
      return;
    }
    if ((this.KNp.status != 104) && (this.KNp.status != 103))
    {
      Log.e("MicroMsg.NetSceneMasSend", "ERR: onGYNetEnd STATUS ERR: status:" + this.KNp.status);
      this.retCode = (0 - com.tencent.mm.compatible.util.f.getLine() - 10000);
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(26362);
      return;
    }
    paramArrayOfByte = (dmo)c.c.b(this.rr.otC);
    params = (dmn)c.b.b(this.rr.otB);
    if ((params.aaSH > 0) && (params.aaSJ != null) && (params.aaSJ.aaxD != null) && (!Util.isNullOrNil(params.aaSJ.aaxD.toByteArray())) && (params.aaSI != paramArrayOfByte.aaSI - params.aaSJ.abwJ))
    {
      Log.e("MicroMsg.NetSceneMasSend", "onGYNetEnd Err Thumb ");
      this.retCode = (0 - com.tencent.mm.compatible.util.f.getLine() - 10000);
      this.callback.onSceneEnd(3, -1, "doScene failed", this);
      AppMethodBeat.o(26362);
      return;
    }
    if ((params.aaSG > 0) && (params.aaSE != null) && (params.aaSE.aaxD != null) && (!Util.isNullOrNil(params.aaSE.aaxD.toByteArray())) && (params.aaSF != paramArrayOfByte.aaSF - params.aaSE.abwJ))
    {
      Log.e("MicroMsg.NetSceneMasSend", "onGYNetEnd Err Data ");
      this.retCode = (0 - com.tencent.mm.compatible.util.f.getLine() - 10000);
      this.callback.onSceneEnd(3, -1, "doScene failed", this);
      AppMethodBeat.o(26362);
      return;
    }
    this.KNp.pba = Util.nowSecond();
    paramInt1 = this.KNp.status;
    if (paramInt1 == 103)
    {
      paramArrayOfByte = this.KNp;
      paramInt1 = params.aaSI;
      paramArrayOfByte.paY = (params.aaSJ.abwJ + paramInt1);
      if (this.KNp.paY >= this.KNp.KNl) {
        this.KNp.status = 199;
      }
    }
    while (this.KNp.status != 199)
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
        paramArrayOfByte = this.KNp;
        paramInt1 = params.aaSF;
        paramArrayOfByte.KNk = (params.aaSE.abwJ + paramInt1);
        if (this.KNp.KNk >= this.KNp.heo) {
          if (this.KNp.KNl > 0) {
            this.KNp.status = 103;
          } else {
            this.KNp.status = 199;
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
    paramArrayOfByte = g.fZV();
    a locala = this.KNp;
    if (locala != null)
    {
      locala.eQp = -1;
      ContentValues localContentValues = new ContentValues();
      if ((locala.eQp & 0x1) != 0) {
        localContentValues.put("clientid", locala.fZM());
      }
      if ((locala.eQp & 0x2) != 0) {
        localContentValues.put("status", Integer.valueOf(locala.status));
      }
      if ((locala.eQp & 0x4) != 0) {
        localContentValues.put("createtime", Long.valueOf(locala.createTime));
      }
      if ((locala.eQp & 0x8) != 0) {
        localContentValues.put("lastmodifytime", Long.valueOf(locala.pba));
      }
      if ((locala.eQp & 0x10) != 0) {
        localContentValues.put("filename", locala.fZN());
      }
      if ((locala.eQp & 0x20) != 0) {
        localContentValues.put("thumbfilename", locala.fZO());
      }
      if ((locala.eQp & 0x40) != 0) {
        localContentValues.put("tolist", locala.fZP());
      }
      if ((locala.eQp & 0x80) != 0) {
        localContentValues.put("tolistcount", Integer.valueOf(locala.KNi));
      }
      if ((locala.eQp & 0x100) != 0) {
        localContentValues.put("msgtype", Integer.valueOf(locala.msgType));
      }
      if ((locala.eQp & 0x200) != 0) {
        localContentValues.put("mediatime", Integer.valueOf(locala.KNj));
      }
      if ((locala.eQp & 0x400) != 0) {
        localContentValues.put("datanetoffset", Integer.valueOf(locala.KNk));
      }
      if ((locala.eQp & 0x800) != 0) {
        localContentValues.put("datalen", Integer.valueOf(locala.heo));
      }
      if ((locala.eQp & 0x1000) != 0) {
        localContentValues.put("thumbnetoffset", Integer.valueOf(locala.paY));
      }
      if ((locala.eQp & 0x2000) != 0) {
        localContentValues.put("thumbtotallen", Integer.valueOf(locala.KNl));
      }
      if ((locala.eQp & 0x4000) != 0) {
        localContentValues.put("reserved1", Integer.valueOf(locala.videoSource));
      }
      if ((locala.eQp & 0x8000) != 0) {
        localContentValues.put("reserved2", Integer.valueOf(locala.KNm));
      }
      if ((locala.eQp & 0x10000) != 0)
      {
        if (locala.omQ != null) {
          break label1477;
        }
        params = "";
        localContentValues.put("reserved3", params);
      }
      if ((locala.eQp & 0x20000) != 0)
      {
        if (locala.omR != null) {
          break label1487;
        }
        params = "";
        label1294:
        localContentValues.put("reserved4", params);
      }
      if ((int)paramArrayOfByte.omV.insert("massendinfo", "clientid", localContentValues) != -1)
      {
        bh.bCz();
        if (com.tencent.mm.model.c.bzG().bxM("masssendapp") != null) {
          break label1497;
        }
        paramInt1 = 1;
        label1345:
        params = new bb();
        params.setUsername("masssendapp");
        params.setContent(b.a(locala));
        params.gR(locala.createTime);
        params.pI(0);
        params.pG(0);
        params.BH(null);
        if (paramInt1 == 0) {
          break label1502;
        }
        bh.bCz();
        com.tencent.mm.model.c.bzG().h(params);
        label1419:
        paramArrayOfByte.doNotify();
      }
    }
    if (this.mHw != null) {}
    for (long l = this.mHw.aPY();; l = 0L)
    {
      Log.d("MicroMsg.NetSceneMasSend", "!!!FIN: useTime:".concat(String.valueOf(l)));
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(26362);
      return;
      label1477:
      params = locala.omQ;
      break;
      label1487:
      params = locala.omR;
      break label1294;
      label1497:
      paramInt1 = 0;
      break label1345;
      label1502:
      bh.bCz();
      com.tencent.mm.model.c.bzG().c(params, "masssendapp");
      break label1419;
    }
    label1529:
    AppMethodBeat.o(26362);
  }
  
  public final int securityLimitCount()
  {
    return 2500;
  }
  
  public final p.b securityVerificationChecked(com.tencent.mm.network.s params)
  {
    return p.b.ouh;
  }
  
  public final void setSecurityCheckError(p.a parama) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.masssend.model.f
 * JD-Core Version:    0.7.0.1
 */