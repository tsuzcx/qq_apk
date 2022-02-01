package com.tencent.mm.plugin.masssend.a;

import android.content.ContentValues;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.d;
import com.tencent.mm.an.d.a;
import com.tencent.mm.an.d.b;
import com.tencent.mm.an.d.c;
import com.tencent.mm.an.i;
import com.tencent.mm.an.q.a;
import com.tencent.mm.an.q.b;
import com.tencent.mm.compatible.util.f.a;
import com.tencent.mm.model.bh;
import com.tencent.mm.model.c;
import com.tencent.mm.modelvideo.x;
import com.tencent.mm.modelvideo.x.b;
import com.tencent.mm.network.m;
import com.tencent.mm.protocal.protobuf.cvh;
import com.tencent.mm.protocal.protobuf.cvi;
import com.tencent.mm.protocal.protobuf.eae;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.az;
import com.tencent.mm.storage.bw;
import com.tencent.mm.vfs.u;
import junit.framework.Assert;

public final class f
  extends com.tencent.mm.an.q
  implements m
{
  private a ESL;
  private i callback;
  boolean kUn;
  f.a khd;
  private int lNK;
  int mhS;
  int retCode;
  public d rr;
  
  public f(a parama, boolean paramBoolean)
  {
    this(parama, paramBoolean, 0);
  }
  
  public f(a parama, boolean paramBoolean, int paramInt)
  {
    AppMethodBeat.i(26360);
    this.ESL = null;
    this.khd = null;
    this.retCode = 0;
    this.mhS = 0;
    this.kUn = false;
    this.ESL = parama;
    this.lNK = paramInt;
    parama.createTime = Util.nowMilliSecond();
    if (parama.msgType == 43)
    {
      parama.status = 104;
      com.tencent.mm.modelvideo.s.bqB();
      parama.ESH = x.XV(x.XU(parama.eRe()));
      com.tencent.mm.modelvideo.s.bqB();
      parama.faO = x.XV(x.XT(parama.eRe()));
      this.mhS = 2500;
      if (parama.videoSource == 2) {
        this.mhS = 2500;
      }
    }
    Object localObject;
    for (;;)
    {
      localObject = new d.a();
      ((d.a)localObject).lBU = new cvh();
      ((d.a)localObject).lBV = new cvi();
      ((d.a)localObject).uri = "/cgi-bin/micromsg-bin/masssend";
      ((d.a)localObject).funcId = 193;
      ((d.a)localObject).lBW = 84;
      ((d.a)localObject).respCmdId = 1000000084;
      this.rr = ((d.a)localObject).bgN();
      localObject = (cvh)d.b.b(this.rr.lBR);
      ((cvh)localObject).TCT = com.tencent.mm.b.g.getMessageDigest(parama.eRg().getBytes());
      ((cvh)localObject).TDe = parama.ESE;
      ((cvh)localObject).TCS = parama.eRg();
      parama.mbB = Util.nowMilliSecond();
      ((cvh)localObject).TCU = parama.eRd();
      ((cvh)localObject).COi = parama.msgType;
      ((cvh)localObject).TCV = parama.ESF;
      if (!paramBoolean) {
        break label550;
      }
      i = j;
      label302:
      ((cvh)localObject).TDf = i;
      ((cvh)localObject).ThK = paramInt;
      this.khd = new f.a();
      AppMethodBeat.o(26360);
      return;
      if (parama.msgType != 34) {
        break;
      }
      this.mhS = 40;
      parama.status = 104;
      parama.faO = com.tencent.mm.modelvoice.q.XV(parama.eRe());
      parama.ESH = 0;
    }
    if (parama.msgType == 3)
    {
      this.mhS = 40;
      if (paramInt != 1) {
        break label556;
      }
      this.mhS = 1250;
    }
    label550:
    label556:
    for (int i = 1;; i = 0)
    {
      parama.ESI = i;
      parama.status = 104;
      parama.ESH = 0;
      localObject = new StringBuilder();
      bh.beI();
      parama.faO = ((int)u.bBQ(c.bbW() + parama.eRe()));
      break;
      if (parama.msgType == 1)
      {
        this.mhS = 1;
        parama.status = 104;
        parama.faO = parama.eRe().getBytes().length;
        parama.ESH = 0;
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
    this.kUn = true;
  }
  
  public final int doScene(com.tencent.mm.network.g paramg, i parami)
  {
    int j = 0;
    int i = 0;
    AppMethodBeat.i(26361);
    this.callback = parami;
    if (this.kUn)
    {
      Log.d("MicroMsg.NetSceneMasSend", "isCancel");
      this.retCode = (0 - (com.tencent.mm.compatible.util.f.getLine() + 10000));
      AppMethodBeat.o(26361);
      return -1;
    }
    this.mhS -= 1;
    if (this.mhS < 0)
    {
      Log.d("MicroMsg.NetSceneMasSend", "MAX_SEND_TIMES");
      this.retCode = (0 - (com.tencent.mm.compatible.util.f.getLine() + 10000));
      AppMethodBeat.o(26361);
      return -1;
    }
    if (this.ESL == null)
    {
      Log.d("MicroMsg.NetSceneMasSend", "MasSendInfo is null");
      this.retCode = (0 - (com.tencent.mm.compatible.util.f.getLine() + 10000));
      AppMethodBeat.o(26361);
      return -1;
    }
    if (Util.isNullOrNil(this.ESL.eRg()))
    {
      Log.d("MicroMsg.NetSceneMasSend", "MasSendInfo.toList is null");
      this.retCode = (0 - (com.tencent.mm.compatible.util.f.getLine() + 10000));
      AppMethodBeat.o(26361);
      return -1;
    }
    if (this.ESL.ESE == 0)
    {
      Log.d("MicroMsg.NetSceneMasSend", "getTolistCount is 0");
      this.retCode = (0 - (com.tencent.mm.compatible.util.f.getLine() + 10000));
      AppMethodBeat.o(26361);
      return -1;
    }
    if (this.ESL.faO <= 0)
    {
      Log.d("MicroMsg.NetSceneMasSend", "getDataLen is 0");
      this.retCode = (0 - (com.tencent.mm.compatible.util.f.getLine() + 10000));
      AppMethodBeat.o(26361);
      return -1;
    }
    if ((this.ESL.status == 103) && (this.ESL.ESH <= 0))
    {
      Log.d("MicroMsg.NetSceneMasSend", "getThumbTotalLen is 0");
      this.retCode = (0 - (com.tencent.mm.compatible.util.f.getLine() + 10000));
      AppMethodBeat.o(26361);
      return -1;
    }
    if ((this.ESL.status != 103) && (this.ESL.status != 104))
    {
      Log.d("MicroMsg.NetSceneMasSend", "msg type :" + this.ESL.msgType);
      this.retCode = (0 - (com.tencent.mm.compatible.util.f.getLine() + 10000));
      AppMethodBeat.o(26361);
      return -1;
    }
    parami = (cvh)d.b.b(this.rr.lBR);
    Object localObject1;
    Object localObject2;
    if (this.ESL.msgType == 43)
    {
      localObject1 = this.ESL.eRe();
      if (Util.isNullOrNil((String)localObject1))
      {
        Log.d("MicroMsg.NetSceneMasSend", "MasSendInfo.fileName is null");
        this.retCode = (0 - (com.tencent.mm.compatible.util.f.getLine() + 10000));
        i = -1;
      }
      for (;;)
      {
        if (i == 0) {
          break label2256;
        }
        AppMethodBeat.o(26361);
        return i;
        parami.TCW = new eae();
        parami.TCX = 0;
        parami.TDb = new eae();
        parami.TDa = 0;
        parami.TDc = 2;
        parami.TCV = this.ESL.ESF;
        if (this.ESL.videoSource > 0) {}
        for (i = 2;; i = 0)
        {
          parami.TDd = i;
          parami.TCZ = this.ESL.ESH;
          parami.TCY = this.ESL.faO;
          if (this.ESL.status != 103) {
            break label879;
          }
          com.tencent.mm.modelvideo.s.bqB();
          localObject2 = x.u(x.XU((String)localObject1), this.ESL.mhN, 8000);
          if ((((x.b)localObject2).ret >= 0) && (((x.b)localObject2).fsR != 0)) {
            break label647;
          }
          Log.e("MicroMsg.NetSceneMasSend", "doScene READ THUMB[" + (String)localObject1 + "]  Error ");
          this.retCode = (0 - (com.tencent.mm.compatible.util.f.getLine() + 10000));
          i = -1;
          break;
        }
        label647:
        Log.d("MicroMsg.NetSceneMasSend", "doScene READ THUMB[" + (String)localObject1 + "] read ret:" + ((x.b)localObject2).ret + " readlen:" + ((x.b)localObject2).fsR + " newOff:" + ((x.b)localObject2).miv + " netOff:" + this.ESL.mhN);
        if (((x.b)localObject2).miv >= this.ESL.mhN) {
          break;
        }
        Log.e("MicroMsg.NetSceneMasSend", "Err doScene READ THUMB[" + (String)localObject1 + "] newOff:" + ((x.b)localObject2).miv + " OldtOff:" + this.ESL.mhN);
        this.retCode = (0 - (com.tencent.mm.compatible.util.f.getLine() + 10000));
        i = -1;
      }
      localObject1 = new byte[((x.b)localObject2).fsR];
      System.arraycopy(((x.b)localObject2).buf, 0, localObject1, 0, ((x.b)localObject2).fsR);
      parami.TDa = this.ESL.mhN;
      localObject2 = new eae();
      ((eae)localObject2).dc((byte[])localObject1);
      parami.TDb = ((eae)localObject2);
      for (;;)
      {
        i = 0;
        break;
        label879:
        com.tencent.mm.modelvideo.s.bqB();
        localObject2 = x.u(x.XT((String)localObject1), this.ESL.ESG, 8000);
        if ((((x.b)localObject2).ret < 0) || (((x.b)localObject2).fsR == 0))
        {
          Log.e("MicroMsg.NetSceneMasSend", "doScene READ VIDEO[" + (String)localObject1 + "]  Error ");
          this.retCode = (0 - (com.tencent.mm.compatible.util.f.getLine() + 10000));
          i = -1;
          break;
        }
        Log.d("MicroMsg.NetSceneMasSend", "doScene READ VIDEO[" + (String)localObject1 + "] read ret:" + ((x.b)localObject2).ret + " readlen:" + ((x.b)localObject2).fsR + " newOff:" + ((x.b)localObject2).miv + " netOff:" + this.ESL.ESG);
        if (((x.b)localObject2).miv < this.ESL.ESG)
        {
          Log.e("MicroMsg.NetSceneMasSend", "Err doScene READ VIDEO[" + (String)localObject1 + "] newOff:" + ((x.b)localObject2).miv + " OldtOff:" + this.ESL.ESG);
          this.retCode = (0 - (com.tencent.mm.compatible.util.f.getLine() + 10000));
          i = -1;
          break;
        }
        if (((x.b)localObject2).miv >= com.tencent.mm.modelvideo.g.mfo)
        {
          Log.e("MicroMsg.NetSceneMasSend", "Err doScene READ VIDEO[" + (String)localObject1 + "] maxsize:" + com.tencent.mm.modelvideo.g.mfo);
          this.retCode = (0 - (com.tencent.mm.compatible.util.f.getLine() + 10000));
          i = -1;
          break;
        }
        localObject1 = new byte[((x.b)localObject2).fsR];
        System.arraycopy(((x.b)localObject2).buf, 0, localObject1, 0, ((x.b)localObject2).fsR);
        parami.TCX = this.ESL.ESG;
        parami.TDa = this.ESL.mhN;
        localObject2 = new eae();
        ((eae)localObject2).dc((byte[])localObject1);
        parami.TCW = ((eae)localObject2);
      }
    }
    if (this.ESL.msgType == 34)
    {
      parami.TDc = 0;
      parami.TDd = 0;
      parami.TCW = new eae().dc(new byte[0]);
      parami.TCX = 0;
      parami.TDb = new eae().dc(new byte[0]);
      parami.TDa = 0;
      parami.TCZ = 0;
      parami.TCY = this.ESL.faO;
      localObject1 = com.tencent.mm.modelvoice.s.YC(this.ESL.eRe());
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
        localObject2 = ((com.tencent.mm.modelvoice.b)localObject1).dY(this.ESL.ESG, 8000);
        if (((com.tencent.mm.modelvoice.g)localObject2).ret < 0)
        {
          Log.e("MicroMsg.NetSceneMasSend", "Err doScene READ file[" + this.ESL.eRe() + "] read ret:" + ((com.tencent.mm.modelvoice.g)localObject2).ret + " readlen:" + ((com.tencent.mm.modelvoice.g)localObject2).fsR + " newOff:" + ((com.tencent.mm.modelvoice.g)localObject2).miv + " netOff:" + this.ESL.ESG);
          this.retCode = (0 - (com.tencent.mm.compatible.util.f.getLine() + 10000));
          i = -1;
        }
        else if ((((com.tencent.mm.modelvoice.g)localObject2).miv < this.ESL.ESG) || (((com.tencent.mm.modelvoice.g)localObject2).miv >= 469000))
        {
          Log.e("MicroMsg.NetSceneMasSend", "Err doScene READ offseterror file[" + this.ESL.eRe() + "] read ret:" + ((com.tencent.mm.modelvoice.g)localObject2).ret + " readlen:" + ((com.tencent.mm.modelvoice.g)localObject2).fsR + " newOff:" + ((com.tencent.mm.modelvoice.g)localObject2).miv + " netOff:" + this.ESL.ESG);
          this.retCode = (0 - (com.tencent.mm.compatible.util.f.getLine() + 10000));
          i = -1;
        }
        else if (this.ESL.faO <= 0)
        {
          Log.e("MicroMsg.NetSceneMasSend", "Err doScene READ datalen file[" + this.ESL.eRe() + "] read totalLen:" + this.ESL.faO);
          this.retCode = (com.tencent.mm.compatible.util.f.getLine() + 10000);
          i = -1;
        }
        else
        {
          byte[] arrayOfByte = new byte[((com.tencent.mm.modelvoice.g)localObject2).fsR];
          System.arraycopy(((com.tencent.mm.modelvoice.g)localObject2).buf, 0, arrayOfByte, 0, ((com.tencent.mm.modelvoice.g)localObject2).fsR);
          parami.TCW = new eae().dc(arrayOfByte);
          parami.TCV = this.ESL.ESF;
          parami.TCX = this.ESL.ESG;
          parami.TDg = ((com.tencent.mm.modelvoice.b)localObject1).getFormat();
        }
      }
    }
    if (this.ESL.msgType == 3)
    {
      if (Util.isNullOrNil(this.ESL.eRe()))
      {
        Log.d("MicroMsg.NetSceneMasSend", "getFilename is null");
        this.retCode = (0 - (com.tencent.mm.compatible.util.f.getLine() + 10000));
        i = -1;
      }
      while (i != 0)
      {
        AppMethodBeat.o(26361);
        return -1;
        parami.TDc = 0;
        parami.TDd = 0;
        parami.TCW = new eae().dc(new byte[0]);
        parami.TCX = 0;
        parami.TDb = new eae().dc(new byte[0]);
        parami.TDa = 0;
        parami.TCZ = 0;
        parami.TCV = 0;
        parami.TCZ = this.ESL.ESH;
        parami.TCY = this.ESL.faO;
        parami.ThK = this.lNK;
        localObject1 = new StringBuilder();
        bh.beI();
        localObject1 = c.bbW() + this.ESL.eRe();
        int k = this.ESL.faO - this.ESL.ESG;
        i = k;
        if (k > 8000) {
          i = 8000;
        }
        localObject1 = u.aY((String)localObject1, this.ESL.ESG, i);
        if (Util.isNullOrNil((byte[])localObject1))
        {
          Log.e("MicroMsg.NetSceneMasSend", "doScene READ data[" + this.ESL.eRe() + "]  Error ");
          this.retCode = (0 - (com.tencent.mm.compatible.util.f.getLine() + 10000));
          i = -1;
        }
        else
        {
          parami.TCX = this.ESL.ESG;
          parami.TDa = this.ESL.mhN;
          localObject2 = new eae();
          ((eae)localObject2).dc((byte[])localObject1);
          parami.TCW = ((eae)localObject2);
          i = j;
        }
      }
    }
    if (this.ESL.msgType == 1)
    {
      parami.TCW = new eae().dc(this.ESL.eRe().getBytes());
      parami.TCY = this.ESL.faO;
      parami.TCV = 0;
      parami.TCX = 0;
      parami.TDb = new eae().dc(new byte[0]);
      parami.TDa = 0;
      parami.TCZ = 0;
      parami.TDc = 0;
      parami.TDd = 0;
      label2256:
      i = dispatch(paramg, this.rr, this);
      AppMethodBeat.o(26361);
      return i;
    }
    Log.d("MicroMsg.NetSceneMasSend", "error msgtype:" + this.ESL.msgType);
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
    if (this.ESL == null)
    {
      Log.e("MicroMsg.NetSceneMasSend", "ERR: onGYNetEnd Get INFO FAILED :");
      this.retCode = (0 - com.tencent.mm.compatible.util.f.getLine() - 10000);
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(26362);
      return;
    }
    if ((this.ESL.status != 104) && (this.ESL.status != 103))
    {
      Log.e("MicroMsg.NetSceneMasSend", "ERR: onGYNetEnd STATUS ERR: status:" + this.ESL.status);
      this.retCode = (0 - com.tencent.mm.compatible.util.f.getLine() - 10000);
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(26362);
      return;
    }
    paramArrayOfByte = (cvi)d.c.b(this.rr.lBS);
    params = (cvh)d.b.b(this.rr.lBR);
    if ((params.TCZ > 0) && (params.TDb != null) && (params.TDb.Tkb != null) && (!Util.isNullOrNil(params.TDb.Tkb.toByteArray())) && (params.TDa != paramArrayOfByte.TDa - params.TDb.Ufv))
    {
      Log.e("MicroMsg.NetSceneMasSend", "onGYNetEnd Err Thumb ");
      this.retCode = (0 - com.tencent.mm.compatible.util.f.getLine() - 10000);
      this.callback.onSceneEnd(3, -1, "doScene failed", this);
      AppMethodBeat.o(26362);
      return;
    }
    if ((params.TCY > 0) && (params.TCW != null) && (params.TCW.Tkb != null) && (!Util.isNullOrNil(params.TCW.Tkb.toByteArray())) && (params.TCX != paramArrayOfByte.TCX - params.TCW.Ufv))
    {
      Log.e("MicroMsg.NetSceneMasSend", "onGYNetEnd Err Data ");
      this.retCode = (0 - com.tencent.mm.compatible.util.f.getLine() - 10000);
      this.callback.onSceneEnd(3, -1, "doScene failed", this);
      AppMethodBeat.o(26362);
      return;
    }
    this.ESL.mhP = Util.nowSecond();
    paramInt1 = this.ESL.status;
    if (paramInt1 == 103)
    {
      paramArrayOfByte = this.ESL;
      paramInt1 = params.TDa;
      paramArrayOfByte.mhN = (params.TDb.Ufv + paramInt1);
      if (this.ESL.mhN >= this.ESL.ESH) {
        this.ESL.status = 199;
      }
    }
    while (this.ESL.status != 199)
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
        paramArrayOfByte = this.ESL;
        paramInt1 = params.TCX;
        paramArrayOfByte.ESG = (params.TCW.Ufv + paramInt1);
        if (this.ESL.ESG >= this.ESL.faO) {
          if (this.ESL.ESH > 0) {
            this.ESL.status = 103;
          } else {
            this.ESL.status = 199;
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
    paramArrayOfByte = h.eRm();
    a locala = this.ESL;
    if (locala != null)
    {
      locala.cUP = -1;
      ContentValues localContentValues = new ContentValues();
      if ((locala.cUP & 0x1) != 0) {
        localContentValues.put("clientid", locala.eRd());
      }
      if ((locala.cUP & 0x2) != 0) {
        localContentValues.put("status", Integer.valueOf(locala.status));
      }
      if ((locala.cUP & 0x4) != 0) {
        localContentValues.put("createtime", Long.valueOf(locala.createTime));
      }
      if ((locala.cUP & 0x8) != 0) {
        localContentValues.put("lastmodifytime", Long.valueOf(locala.mhP));
      }
      if ((locala.cUP & 0x10) != 0) {
        localContentValues.put("filename", locala.eRe());
      }
      if ((locala.cUP & 0x20) != 0) {
        localContentValues.put("thumbfilename", locala.eRf());
      }
      if ((locala.cUP & 0x40) != 0) {
        localContentValues.put("tolist", locala.eRg());
      }
      if ((locala.cUP & 0x80) != 0) {
        localContentValues.put("tolistcount", Integer.valueOf(locala.ESE));
      }
      if ((locala.cUP & 0x100) != 0) {
        localContentValues.put("msgtype", Integer.valueOf(locala.msgType));
      }
      if ((locala.cUP & 0x200) != 0) {
        localContentValues.put("mediatime", Integer.valueOf(locala.ESF));
      }
      if ((locala.cUP & 0x400) != 0) {
        localContentValues.put("datanetoffset", Integer.valueOf(locala.ESG));
      }
      if ((locala.cUP & 0x800) != 0) {
        localContentValues.put("datalen", Integer.valueOf(locala.faO));
      }
      if ((locala.cUP & 0x1000) != 0) {
        localContentValues.put("thumbnetoffset", Integer.valueOf(locala.mhN));
      }
      if ((locala.cUP & 0x2000) != 0) {
        localContentValues.put("thumbtotallen", Integer.valueOf(locala.ESH));
      }
      if ((locala.cUP & 0x4000) != 0) {
        localContentValues.put("reserved1", Integer.valueOf(locala.videoSource));
      }
      if ((locala.cUP & 0x8000) != 0) {
        localContentValues.put("reserved2", Integer.valueOf(locala.ESI));
      }
      if ((locala.cUP & 0x10000) != 0)
      {
        if (locala.lvt != null) {
          break label1477;
        }
        params = "";
        localContentValues.put("reserved3", params);
      }
      if ((locala.cUP & 0x20000) != 0)
      {
        if (locala.lvu != null) {
          break label1487;
        }
        params = "";
        label1294:
        localContentValues.put("reserved4", params);
      }
      if ((int)paramArrayOfByte.lvy.insert("massendinfo", "clientid", localContentValues) != -1)
      {
        bh.beI();
        if (c.bbR().bwx("masssendapp") != null) {
          break label1497;
        }
        paramInt1 = 1;
        label1345:
        params = new az();
        params.setUsername("masssendapp");
        params.setContent(b.a(locala));
        params.EB(locala.createTime);
        params.pJ(0);
        params.pH(0);
        params.Jc(null);
        if (paramInt1 == 0) {
          break label1502;
        }
        bh.beI();
        c.bbR().e(params);
        label1419:
        paramArrayOfByte.doNotify();
      }
    }
    if (this.khd != null) {}
    for (long l = this.khd.avE();; l = 0L)
    {
      Log.d("MicroMsg.NetSceneMasSend", "!!!FIN: useTime:".concat(String.valueOf(l)));
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(26362);
      return;
      label1477:
      params = locala.lvt;
      break;
      label1487:
      params = locala.lvu;
      break label1294;
      label1497:
      paramInt1 = 0;
      break label1345;
      label1502:
      bh.beI();
      c.bbR().a(params, "masssendapp");
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
    return q.b.lCx;
  }
  
  public final void setSecurityCheckError(q.a parama) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.masssend.a.f
 * JD-Core Version:    0.7.0.1
 */