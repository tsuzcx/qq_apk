package com.tencent.mm.plugin.masssend.a;

import android.content.ContentValues;
import com.tencent.mm.ah.b.a;
import com.tencent.mm.ah.b.b;
import com.tencent.mm.ah.b.c;
import com.tencent.mm.ah.m;
import com.tencent.mm.ah.m.a;
import com.tencent.mm.ah.m.b;
import com.tencent.mm.compatible.util.g.a;
import com.tencent.mm.model.au;
import com.tencent.mm.modelvideo.t;
import com.tencent.mm.modelvideo.t.b;
import com.tencent.mm.network.k;
import com.tencent.mm.protocal.c.avy;
import com.tencent.mm.protocal.c.avz;
import com.tencent.mm.protocal.c.bmk;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.ak;
import com.tencent.mm.storage.be;
import junit.framework.Assert;

public final class f
  extends m
  implements k
{
  public com.tencent.mm.ah.b dmK;
  private com.tencent.mm.ah.f dmL;
  int eHJ = 0;
  boolean edT = false;
  private int ent;
  g.a esm = null;
  private a maN = null;
  int retCode = 0;
  
  public f(a parama, boolean paramBoolean)
  {
    this(parama, paramBoolean, 0);
  }
  
  public f(a parama, boolean paramBoolean, int paramInt)
  {
    this.maN = parama;
    this.ent = paramInt;
    parama.createTime = bk.UY();
    if (parama.msgType == 43)
    {
      parama.status = 104;
      com.tencent.mm.modelvideo.o.Sr();
      parama.maJ = t.nU(t.nT(parama.bgW()));
      com.tencent.mm.modelvideo.o.Sr();
      parama.bvi = t.nU(t.nS(parama.bgW()));
      this.eHJ = 2500;
      if (parama.videoSource == 2) {
        this.eHJ = 2500;
      }
    }
    Object localObject;
    for (;;)
    {
      localObject = new b.a();
      ((b.a)localObject).ecH = new avy();
      ((b.a)localObject).ecI = new avz();
      ((b.a)localObject).uri = "/cgi-bin/micromsg-bin/masssend";
      ((b.a)localObject).ecG = 193;
      ((b.a)localObject).ecJ = 84;
      ((b.a)localObject).ecK = 1000000084;
      this.dmK = ((b.a)localObject).Kt();
      localObject = (avy)this.dmK.ecE.ecN;
      ((avy)localObject).tru = com.tencent.mm.a.g.o(parama.bgY().getBytes());
      ((avy)localObject).trF = parama.maG;
      ((avy)localObject).trt = parama.bgY();
      parama.eAX = bk.UY();
      ((avy)localObject).trv = parama.bgV();
      ((avy)localObject).kSW = parama.msgType;
      ((avy)localObject).trw = parama.maH;
      if (!paramBoolean) {
        break label538;
      }
      i = j;
      label296:
      ((avy)localObject).trG = i;
      ((avy)localObject).tfc = paramInt;
      this.esm = new g.a();
      return;
      if (parama.msgType != 34) {
        break;
      }
      this.eHJ = 40;
      parama.status = 104;
      parama.bvi = com.tencent.mm.modelvoice.o.nU(parama.bgW());
      parama.maJ = 0;
    }
    if (parama.msgType == 3)
    {
      this.eHJ = 40;
      if (paramInt != 1) {
        break label544;
      }
      this.eHJ = 1250;
    }
    label538:
    label544:
    for (int i = 1;; i = 0)
    {
      parama.maK = i;
      parama.status = 104;
      parama.maJ = 0;
      localObject = new StringBuilder();
      au.Hx();
      parama.bvi = ((int)com.tencent.mm.vfs.e.aeQ(com.tencent.mm.model.c.FG() + parama.bgW()));
      break;
      if (parama.msgType == 1)
      {
        this.eHJ = 1;
        parama.status = 104;
        parama.bvi = parama.bgW().getBytes().length;
        parama.maJ = 0;
        break;
      }
      y.d("MicroMsg.NetSceneMasSend", "error msgtype:" + parama.msgType);
      Assert.assertTrue("error msgtype:" + parama.msgType, false);
      break;
      i = 0;
      break label296;
    }
  }
  
  protected final int Ka()
  {
    return 2500;
  }
  
  public final int a(com.tencent.mm.network.e parame, com.tencent.mm.ah.f paramf)
  {
    int i = 2;
    int j = 0;
    int k = 0;
    this.dmL = paramf;
    if (this.edT)
    {
      y.d("MicroMsg.NetSceneMasSend", "isCancel");
      this.retCode = (0 - (com.tencent.mm.compatible.util.g.getLine() + 10000));
      j = -1;
    }
    Object localObject1;
    do
    {
      return j;
      this.eHJ -= 1;
      if (this.eHJ < 0)
      {
        y.d("MicroMsg.NetSceneMasSend", "MAX_SEND_TIMES");
        this.retCode = (0 - (com.tencent.mm.compatible.util.g.getLine() + 10000));
        return -1;
      }
      if (this.maN == null)
      {
        y.d("MicroMsg.NetSceneMasSend", "MasSendInfo is null");
        this.retCode = (0 - (com.tencent.mm.compatible.util.g.getLine() + 10000));
        return -1;
      }
      if (bk.bl(this.maN.bgY()))
      {
        y.d("MicroMsg.NetSceneMasSend", "MasSendInfo.toList is null");
        this.retCode = (0 - (com.tencent.mm.compatible.util.g.getLine() + 10000));
        return -1;
      }
      if (this.maN.maG == 0)
      {
        y.d("MicroMsg.NetSceneMasSend", "getTolistCount is 0");
        this.retCode = (0 - (com.tencent.mm.compatible.util.g.getLine() + 10000));
        return -1;
      }
      if (this.maN.bvi <= 0)
      {
        y.d("MicroMsg.NetSceneMasSend", "getDataLen is 0");
        this.retCode = (0 - (com.tencent.mm.compatible.util.g.getLine() + 10000));
        return -1;
      }
      if ((this.maN.status == 103) && (this.maN.maJ <= 0))
      {
        y.d("MicroMsg.NetSceneMasSend", "getThumbTotalLen is 0");
        this.retCode = (0 - (com.tencent.mm.compatible.util.g.getLine() + 10000));
        return -1;
      }
      if ((this.maN.status != 103) && (this.maN.status != 104))
      {
        y.d("MicroMsg.NetSceneMasSend", "msg type :" + this.maN.msgType);
        this.retCode = (0 - (com.tencent.mm.compatible.util.g.getLine() + 10000));
        return -1;
      }
      paramf = (avy)this.dmK.ecE.ecN;
      if (this.maN.msgType != 43) {
        break label1228;
      }
      localObject1 = this.maN.bgW();
      if (!bk.bl((String)localObject1)) {
        break;
      }
      y.d("MicroMsg.NetSceneMasSend", "MasSendInfo.fileName is null");
      this.retCode = (0 - (com.tencent.mm.compatible.util.g.getLine() + 10000));
      i = -1;
      j = i;
    } while (i != 0);
    for (;;)
    {
      return a(parame, this.dmK, this);
      paramf.trx = new bmk();
      paramf.jdField_try = 0;
      paramf.trC = new bmk();
      paramf.trB = 0;
      paramf.trD = 2;
      paramf.trw = this.maN.maH;
      if (this.maN.videoSource > 0) {}
      for (;;)
      {
        paramf.trE = i;
        paramf.trA = this.maN.maJ;
        paramf.trz = this.maN.bvi;
        if (this.maN.status != 103) {
          break label836;
        }
        com.tencent.mm.modelvideo.o.Sr();
        localObject2 = t.k(t.nT((String)localObject1), this.maN.eHD, 8000);
        if ((((t.b)localObject2).ret >= 0) && (((t.b)localObject2).bDu != 0)) {
          break label604;
        }
        y.e("MicroMsg.NetSceneMasSend", "doScene READ THUMB[" + (String)localObject1 + "]  Error ");
        this.retCode = (0 - (com.tencent.mm.compatible.util.g.getLine() + 10000));
        i = -1;
        break;
        i = 0;
      }
      label604:
      y.d("MicroMsg.NetSceneMasSend", "doScene READ THUMB[" + (String)localObject1 + "] read ret:" + ((t.b)localObject2).ret + " readlen:" + ((t.b)localObject2).bDu + " newOff:" + ((t.b)localObject2).eIh + " netOff:" + this.maN.eHD);
      if (((t.b)localObject2).eIh < this.maN.eHD)
      {
        y.e("MicroMsg.NetSceneMasSend", "Err doScene READ THUMB[" + (String)localObject1 + "] newOff:" + ((t.b)localObject2).eIh + " OldtOff:" + this.maN.eHD);
        this.retCode = (0 - (com.tencent.mm.compatible.util.g.getLine() + 10000));
        i = -1;
        break;
      }
      localObject1 = new byte[((t.b)localObject2).bDu];
      System.arraycopy(((t.b)localObject2).buf, 0, localObject1, 0, ((t.b)localObject2).bDu);
      paramf.trB = this.maN.eHD;
      Object localObject2 = new bmk();
      ((bmk)localObject2).bs((byte[])localObject1);
      paramf.trC = ((bmk)localObject2);
      for (;;)
      {
        i = 0;
        break;
        label836:
        com.tencent.mm.modelvideo.o.Sr();
        localObject2 = t.k(t.nS((String)localObject1), this.maN.maI, 8000);
        if ((((t.b)localObject2).ret < 0) || (((t.b)localObject2).bDu == 0))
        {
          y.e("MicroMsg.NetSceneMasSend", "doScene READ VIDEO[" + (String)localObject1 + "]  Error ");
          this.retCode = (0 - (com.tencent.mm.compatible.util.g.getLine() + 10000));
          i = -1;
          break;
        }
        y.d("MicroMsg.NetSceneMasSend", "doScene READ VIDEO[" + (String)localObject1 + "] read ret:" + ((t.b)localObject2).ret + " readlen:" + ((t.b)localObject2).bDu + " newOff:" + ((t.b)localObject2).eIh + " netOff:" + this.maN.maI);
        if (((t.b)localObject2).eIh < this.maN.maI)
        {
          y.e("MicroMsg.NetSceneMasSend", "Err doScene READ VIDEO[" + (String)localObject1 + "] newOff:" + ((t.b)localObject2).eIh + " OldtOff:" + this.maN.maI);
          this.retCode = (0 - (com.tencent.mm.compatible.util.g.getLine() + 10000));
          i = -1;
          break;
        }
        if (((t.b)localObject2).eIh >= com.tencent.mm.modelvideo.c.eFh)
        {
          y.e("MicroMsg.NetSceneMasSend", "Err doScene READ VIDEO[" + (String)localObject1 + "] maxsize:" + com.tencent.mm.modelvideo.c.eFh);
          this.retCode = (0 - (com.tencent.mm.compatible.util.g.getLine() + 10000));
          i = -1;
          break;
        }
        localObject1 = new byte[((t.b)localObject2).bDu];
        System.arraycopy(((t.b)localObject2).buf, 0, localObject1, 0, ((t.b)localObject2).bDu);
        paramf.jdField_try = this.maN.maI;
        paramf.trB = this.maN.eHD;
        localObject2 = new bmk();
        ((bmk)localObject2).bs((byte[])localObject1);
        paramf.trx = ((bmk)localObject2);
      }
      label1228:
      if (this.maN.msgType == 34)
      {
        paramf.trD = 0;
        paramf.trE = 0;
        paramf.trx = new bmk().bs(new byte[0]);
        paramf.jdField_try = 0;
        paramf.trC = new bmk().bs(new byte[0]);
        paramf.trB = 0;
        paramf.trA = 0;
        paramf.trz = this.maN.bvi;
        localObject1 = com.tencent.mm.modelvoice.q.ox(this.maN.bgW());
        if (localObject1 == null)
        {
          this.retCode = (0 - (com.tencent.mm.compatible.util.g.getLine() + 10000));
          y.d("MicroMsg.NetSceneMasSend", "fileop is null");
          i = -1;
        }
        while (i != 0)
        {
          return -1;
          localObject2 = ((com.tencent.mm.modelvoice.b)localObject1).bz(this.maN.maI, 8000);
          if (((com.tencent.mm.modelvoice.g)localObject2).ret < 0)
          {
            y.e("MicroMsg.NetSceneMasSend", "Err doScene READ file[" + this.maN.bgW() + "] read ret:" + ((com.tencent.mm.modelvoice.g)localObject2).ret + " readlen:" + ((com.tencent.mm.modelvoice.g)localObject2).bDu + " newOff:" + ((com.tencent.mm.modelvoice.g)localObject2).eIh + " netOff:" + this.maN.maI);
            this.retCode = (0 - (com.tencent.mm.compatible.util.g.getLine() + 10000));
            i = -1;
          }
          else if ((((com.tencent.mm.modelvoice.g)localObject2).eIh < this.maN.maI) || (((com.tencent.mm.modelvoice.g)localObject2).eIh >= 469000))
          {
            y.e("MicroMsg.NetSceneMasSend", "Err doScene READ offseterror file[" + this.maN.bgW() + "] read ret:" + ((com.tencent.mm.modelvoice.g)localObject2).ret + " readlen:" + ((com.tencent.mm.modelvoice.g)localObject2).bDu + " newOff:" + ((com.tencent.mm.modelvoice.g)localObject2).eIh + " netOff:" + this.maN.maI);
            this.retCode = (0 - (com.tencent.mm.compatible.util.g.getLine() + 10000));
            i = -1;
          }
          else if (this.maN.bvi <= 0)
          {
            y.e("MicroMsg.NetSceneMasSend", "Err doScene READ datalen file[" + this.maN.bgW() + "] read totalLen:" + this.maN.bvi);
            this.retCode = (com.tencent.mm.compatible.util.g.getLine() + 10000);
            i = -1;
          }
          else
          {
            byte[] arrayOfByte = new byte[((com.tencent.mm.modelvoice.g)localObject2).bDu];
            System.arraycopy(((com.tencent.mm.modelvoice.g)localObject2).buf, 0, arrayOfByte, 0, ((com.tencent.mm.modelvoice.g)localObject2).bDu);
            paramf.trx = new bmk().bs(arrayOfByte);
            paramf.trw = this.maN.maH;
            paramf.jdField_try = this.maN.maI;
            paramf.trH = ((com.tencent.mm.modelvoice.b)localObject1).getFormat();
            i = k;
          }
        }
      }
      else if (this.maN.msgType == 3)
      {
        if (bk.bl(this.maN.bgW()))
        {
          y.d("MicroMsg.NetSceneMasSend", "getFilename is null");
          this.retCode = (0 - (com.tencent.mm.compatible.util.g.getLine() + 10000));
          i = -1;
        }
        while (i != 0)
        {
          return -1;
          paramf.trD = 0;
          paramf.trE = 0;
          paramf.trx = new bmk().bs(new byte[0]);
          paramf.jdField_try = 0;
          paramf.trC = new bmk().bs(new byte[0]);
          paramf.trB = 0;
          paramf.trA = 0;
          paramf.trw = 0;
          paramf.trA = this.maN.maJ;
          paramf.trz = this.maN.bvi;
          paramf.tfc = this.ent;
          localObject1 = new StringBuilder();
          au.Hx();
          localObject1 = com.tencent.mm.model.c.FG() + this.maN.bgW();
          k = this.maN.bvi - this.maN.maI;
          i = k;
          if (k > 8000) {
            i = 8000;
          }
          localObject1 = com.tencent.mm.vfs.e.c((String)localObject1, this.maN.maI, i);
          if (bk.bE((byte[])localObject1))
          {
            y.e("MicroMsg.NetSceneMasSend", "doScene READ data[" + this.maN.bgW() + "]  Error ");
            this.retCode = (0 - (com.tencent.mm.compatible.util.g.getLine() + 10000));
            i = -1;
          }
          else
          {
            paramf.jdField_try = this.maN.maI;
            paramf.trB = this.maN.eHD;
            localObject2 = new bmk();
            ((bmk)localObject2).bs((byte[])localObject1);
            paramf.trx = ((bmk)localObject2);
            i = j;
          }
        }
      }
      else
      {
        if (this.maN.msgType != 1) {
          break label2205;
        }
        paramf.trx = new bmk().bs(this.maN.bgW().getBytes());
        paramf.trz = this.maN.bvi;
        paramf.trw = 0;
        paramf.jdField_try = 0;
        paramf.trC = new bmk().bs(new byte[0]);
        paramf.trB = 0;
        paramf.trA = 0;
        paramf.trD = 0;
        paramf.trE = 0;
      }
    }
    label2205:
    y.d("MicroMsg.NetSceneMasSend", "error msgtype:" + this.maN.msgType);
    this.retCode = (0 - (com.tencent.mm.compatible.util.g.getLine() + 10000));
    return -1;
  }
  
  public final void a(int paramInt1, int paramInt2, int paramInt3, String paramString, com.tencent.mm.network.q paramq, byte[] paramArrayOfByte)
  {
    y.d("MicroMsg.NetSceneMasSend", "onGYNetEnd  errtype:" + paramInt2 + " errCode:" + paramInt3);
    if ((paramInt2 != 0) || (paramInt3 != 0))
    {
      y.e("MicroMsg.NetSceneMasSend", "ERR: onGYNetEnd FAILED errtype:" + paramInt2 + " errCode:" + paramInt3);
      this.retCode = (0 - com.tencent.mm.compatible.util.g.getLine() - 10000);
      this.dmL.onSceneEnd(paramInt2, paramInt3, paramString, this);
      return;
    }
    if (this.maN == null)
    {
      y.e("MicroMsg.NetSceneMasSend", "ERR: onGYNetEnd Get INFO FAILED :");
      this.retCode = (0 - com.tencent.mm.compatible.util.g.getLine() - 10000);
      this.dmL.onSceneEnd(paramInt2, paramInt3, paramString, this);
      return;
    }
    if ((this.maN.status != 104) && (this.maN.status != 103))
    {
      y.e("MicroMsg.NetSceneMasSend", "ERR: onGYNetEnd STATUS ERR: status:" + this.maN.status);
      this.retCode = (0 - com.tencent.mm.compatible.util.g.getLine() - 10000);
      this.dmL.onSceneEnd(paramInt2, paramInt3, paramString, this);
      return;
    }
    paramArrayOfByte = (avz)this.dmK.ecF.ecN;
    paramq = (avy)this.dmK.ecE.ecN;
    if ((paramq.trA > 0) && (paramq.trC != null) && (paramq.trC.tFM != null) && (!bk.bE(paramq.trC.tFM.toByteArray())) && (paramq.trB != paramArrayOfByte.trB - paramq.trC.tFK))
    {
      y.e("MicroMsg.NetSceneMasSend", "onGYNetEnd Err Thumb ");
      this.retCode = (0 - com.tencent.mm.compatible.util.g.getLine() - 10000);
      this.dmL.onSceneEnd(3, -1, "doScene failed", this);
      return;
    }
    if ((paramq.trz > 0) && (paramq.trx != null) && (paramq.trx.tFM != null) && (!bk.bE(paramq.trx.tFM.toByteArray())) && (paramq.jdField_try != paramArrayOfByte.jdField_try - paramq.trx.tFK))
    {
      y.e("MicroMsg.NetSceneMasSend", "onGYNetEnd Err Data ");
      this.retCode = (0 - com.tencent.mm.compatible.util.g.getLine() - 10000);
      this.dmL.onSceneEnd(3, -1, "doScene failed", this);
      return;
    }
    this.maN.eHF = bk.UX();
    paramInt1 = this.maN.status;
    if (paramInt1 == 103)
    {
      paramArrayOfByte = this.maN;
      paramInt1 = paramq.trB;
      paramArrayOfByte.eHD = (paramq.trC.tFK + paramInt1);
      if (this.maN.eHD >= this.maN.maJ) {
        this.maN.status = 199;
      }
    }
    for (;;)
    {
      if (this.maN.status != 199)
      {
        if (a(this.edc, this.dmL) != -1) {
          break;
        }
        this.retCode = (0 - (com.tencent.mm.compatible.util.g.getLine() + 10000));
        this.dmL.onSceneEnd(3, -1, "doScene failed", this);
        return;
        if (paramInt1 == 104)
        {
          paramArrayOfByte = this.maN;
          paramInt1 = paramq.jdField_try;
          paramArrayOfByte.maI = (paramq.trx.tFK + paramInt1);
          if (this.maN.maI >= this.maN.bvi) {
            if (this.maN.maJ > 0) {
              this.maN.status = 103;
            } else {
              this.maN.status = 199;
            }
          }
        }
        else
        {
          y.e("MicroMsg.NetSceneMasSend", "onGYNetEnd ERROR STATUS:" + paramInt1);
          this.retCode = (0 - com.tencent.mm.compatible.util.g.getLine() - 10000);
          this.dmL.onSceneEnd(3, -1, "doScene failed", this);
          return;
        }
      }
    }
    paramArrayOfByte = h.bhd();
    a locala = this.maN;
    if (locala != null)
    {
      locala.bcw = -1;
      ContentValues localContentValues = new ContentValues();
      if ((locala.bcw & 0x1) != 0) {
        localContentValues.put("clientid", locala.bgV());
      }
      if ((locala.bcw & 0x2) != 0) {
        localContentValues.put("status", Integer.valueOf(locala.status));
      }
      if ((locala.bcw & 0x4) != 0) {
        localContentValues.put("createtime", Long.valueOf(locala.createTime));
      }
      if ((locala.bcw & 0x8) != 0) {
        localContentValues.put("lastmodifytime", Long.valueOf(locala.eHF));
      }
      if ((locala.bcw & 0x10) != 0) {
        localContentValues.put("filename", locala.bgW());
      }
      if ((locala.bcw & 0x20) != 0) {
        localContentValues.put("thumbfilename", locala.bgX());
      }
      if ((locala.bcw & 0x40) != 0) {
        localContentValues.put("tolist", locala.bgY());
      }
      if ((locala.bcw & 0x80) != 0) {
        localContentValues.put("tolistcount", Integer.valueOf(locala.maG));
      }
      if ((locala.bcw & 0x100) != 0) {
        localContentValues.put("msgtype", Integer.valueOf(locala.msgType));
      }
      if ((locala.bcw & 0x200) != 0) {
        localContentValues.put("mediatime", Integer.valueOf(locala.maH));
      }
      if ((locala.bcw & 0x400) != 0) {
        localContentValues.put("datanetoffset", Integer.valueOf(locala.maI));
      }
      if ((locala.bcw & 0x800) != 0) {
        localContentValues.put("datalen", Integer.valueOf(locala.bvi));
      }
      if ((locala.bcw & 0x1000) != 0) {
        localContentValues.put("thumbnetoffset", Integer.valueOf(locala.eHD));
      }
      if ((locala.bcw & 0x2000) != 0) {
        localContentValues.put("thumbtotallen", Integer.valueOf(locala.maJ));
      }
      if ((locala.bcw & 0x4000) != 0) {
        localContentValues.put("reserved1", Integer.valueOf(locala.videoSource));
      }
      if ((locala.bcw & 0x8000) != 0) {
        localContentValues.put("reserved2", Integer.valueOf(locala.maK));
      }
      if ((locala.bcw & 0x10000) != 0)
      {
        if (locala.dXm != null) {
          break label1426;
        }
        paramq = "";
        localContentValues.put("reserved3", paramq);
      }
      if ((locala.bcw & 0x20000) != 0)
      {
        if (locala.dXn != null) {
          break label1436;
        }
        paramq = "";
        label1248:
        localContentValues.put("reserved4", paramq);
      }
      if ((int)paramArrayOfByte.dXo.insert("massendinfo", "clientid", localContentValues) != -1)
      {
        au.Hx();
        if (com.tencent.mm.model.c.FB().abv("masssendapp") != null) {
          break label1446;
        }
        paramInt1 = 1;
        label1299:
        paramq = new ak();
        paramq.setUsername("masssendapp");
        paramq.setContent(b.a(locala));
        paramq.ba(locala.createTime);
        paramq.fA(0);
        paramq.fy(0);
        if (paramInt1 == 0) {
          break label1451;
        }
        au.Hx();
        com.tencent.mm.model.c.FB().d(paramq);
        label1367:
        paramArrayOfByte.doNotify();
      }
    }
    if (this.esm != null) {}
    for (long l = this.esm.zJ();; l = 0L)
    {
      y.d("MicroMsg.NetSceneMasSend", "!!!FIN: useTime:" + l);
      this.dmL.onSceneEnd(paramInt2, paramInt3, paramString, this);
      return;
      label1426:
      paramq = locala.dXm;
      break;
      label1436:
      paramq = locala.dXn;
      break label1248;
      label1446:
      paramInt1 = 0;
      break label1299;
      label1451:
      au.Hx();
      com.tencent.mm.model.c.FB().a(paramq, "masssendapp");
      break label1367;
    }
  }
  
  protected final void a(m.a parama) {}
  
  protected final m.b b(com.tencent.mm.network.q paramq)
  {
    return m.b.edr;
  }
  
  public final void cancel()
  {
    this.edT = true;
  }
  
  public final int getType()
  {
    return 193;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.masssend.a.f
 * JD-Core Version:    0.7.0.1
 */