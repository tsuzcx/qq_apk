package com.tencent.mm.modelimage;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.XmlParser;
import java.util.Map;

public final class h
{
  public int createTime;
  public int eQp = -2;
  public long hTh;
  public int kLl = 0;
  public long localId;
  int oGA;
  public int oGB = 0;
  public String oGC = "";
  int oGD = 1;
  private boolean oGE;
  private boolean oGF;
  private boolean oGG;
  private boolean oGH;
  private boolean oGI;
  private boolean oGJ;
  private boolean oGK;
  private boolean oGL;
  private boolean oGM;
  private boolean oGN;
  private boolean oGO;
  private boolean oGP;
  private boolean oGQ;
  private boolean oGR;
  private boolean oGS;
  private boolean oGT;
  private boolean oGU;
  private boolean oGV;
  private boolean oGW;
  private boolean oGX;
  private boolean oGY;
  public String oGr = "";
  public String oGs = "";
  public String oGt = "";
  public int oGu;
  public int oGv;
  public String oGw = "";
  int oGx = 0;
  private String oGy = "";
  public long oGz;
  public int offset;
  public int osy;
  int source;
  public int status;
  
  public final void NP(String paramString)
  {
    this.oGy = paramString;
    this.oGU = true;
  }
  
  public final void NQ(String paramString)
  {
    this.oGr = paramString;
    this.oGI = true;
  }
  
  public final void NR(String paramString)
  {
    this.oGs = paramString;
    this.oGJ = true;
  }
  
  public final void NS(String paramString)
  {
    this.oGt = paramString;
    this.oGK = true;
  }
  
  public final void NT(String paramString)
  {
    AppMethodBeat.i(150551);
    if (((this.oGC == null) && (paramString != null)) || ((this.oGC != null) && (!this.oGC.equals(paramString)))) {
      this.oGR = true;
    }
    this.oGC = paramString;
    AppMethodBeat.o(150551);
  }
  
  public final void NU(String paramString)
  {
    this.oGw = paramString;
    this.oGX = true;
  }
  
  public final boolean bJD()
  {
    return (this.osy != 0) && (this.osy == this.offset);
  }
  
  public final boolean bJE()
  {
    return this.oGB > 0;
  }
  
  public final void bJF()
  {
    this.kLl = 1;
    this.oGS = true;
  }
  
  public final void bJG()
  {
    this.oGE = false;
    this.oGF = false;
    this.oGG = false;
    this.oGH = false;
    this.oGI = false;
    this.oGJ = false;
    this.oGK = false;
    this.oGL = false;
    this.oGM = false;
    this.oGN = false;
    this.oGO = false;
    this.oGP = false;
    this.oGQ = false;
    this.oGR = false;
    this.oGS = false;
    this.oGT = false;
    this.oGU = false;
    this.oGV = false;
    this.oGW = false;
    this.oGX = false;
    this.oGY = false;
  }
  
  public final void convertFrom(Cursor paramCursor)
  {
    AppMethodBeat.i(150552);
    this.localId = paramCursor.getInt(0);
    this.hTh = paramCursor.getLong(1);
    this.offset = paramCursor.getInt(2);
    this.osy = paramCursor.getInt(3);
    this.oGr = paramCursor.getString(4);
    this.oGt = paramCursor.getString(5);
    this.createTime = paramCursor.getInt(6);
    this.oGz = paramCursor.getInt(7);
    this.status = paramCursor.getInt(8);
    this.oGA = paramCursor.getInt(9);
    this.oGB = paramCursor.getInt(10);
    this.source = paramCursor.getInt(11);
    this.oGC = paramCursor.getString(12);
    this.kLl = paramCursor.getInt(14);
    this.oGD = paramCursor.getInt(15);
    this.oGy = paramCursor.getString(16);
    this.oGu = paramCursor.getInt(17);
    this.oGs = paramCursor.getString(18);
    this.oGv = paramCursor.getInt(19);
    this.oGw = paramCursor.getString(20);
    this.oGx = paramCursor.getInt(21);
    AppMethodBeat.o(150552);
  }
  
  public final ContentValues convertTo()
  {
    AppMethodBeat.i(150553);
    ContentValues localContentValues = new ContentValues();
    if (this.oGE) {
      localContentValues.put("id", Long.valueOf(this.localId));
    }
    if (this.oGF) {
      localContentValues.put("msgSvrId", Long.valueOf(this.hTh));
    }
    if (this.oGG) {
      localContentValues.put("offset", Integer.valueOf(this.offset));
    }
    if (this.oGH) {
      localContentValues.put("totalLen", Integer.valueOf(this.osy));
    }
    if (this.oGI) {
      localContentValues.put("bigImgPath", this.oGr);
    }
    if (this.oGJ) {
      localContentValues.put("midImgPath", this.oGs);
    }
    if (this.oGK) {
      localContentValues.put("thumbImgPath", this.oGt);
    }
    if (this.oGL) {
      localContentValues.put("createtime", Integer.valueOf(this.createTime));
    }
    if (this.oGM) {
      localContentValues.put("msglocalid", Long.valueOf(this.oGz));
    }
    if (this.oGN) {
      localContentValues.put("status", Integer.valueOf(this.status));
    }
    if (this.oGO) {
      localContentValues.put("nettimes", Integer.valueOf(this.oGA));
    }
    if (this.oGP) {
      localContentValues.put("reserved1", Integer.valueOf(this.oGB));
    }
    if (this.oGQ) {
      localContentValues.put("reserved2", Integer.valueOf(this.source));
    }
    if (this.oGR) {
      localContentValues.put("reserved3", this.oGC);
    }
    if (this.oGS) {
      localContentValues.put("hashdthumb", Integer.valueOf(this.kLl));
    }
    if (this.oGT) {
      if (this.offset >= this.osy) {
        break label433;
      }
    }
    label433:
    for (int i = 0;; i = 1)
    {
      localContentValues.put("iscomplete", Integer.valueOf(i));
      if (this.oGU) {
        localContentValues.put("origImgMD5", this.oGy);
      }
      if (this.oGV) {
        localContentValues.put("compressType", Integer.valueOf(this.oGu));
      }
      if (this.oGW) {
        localContentValues.put("forwardType", Integer.valueOf(this.oGv));
      }
      if (this.oGX) {
        localContentValues.put("hevcPath", this.oGw);
      }
      if (this.oGY) {
        localContentValues.put("sendImgType", Integer.valueOf(this.oGx));
      }
      AppMethodBeat.o(150553);
      return localContentValues;
    }
  }
  
  public final void gX(long paramLong)
  {
    if (this.hTh != paramLong) {
      this.oGF = true;
    }
    this.hTh = paramLong;
  }
  
  public final String getAesKey()
  {
    AppMethodBeat.i(238995);
    Object localObject = XmlParser.parseXml(this.oGC, "msg", null);
    if (localObject != null)
    {
      localObject = (String)((Map)localObject).get(".msg.img.$aeskey");
      AppMethodBeat.o(238995);
      return localObject;
    }
    AppMethodBeat.o(238995);
    return null;
  }
  
  public final String getFileId()
  {
    AppMethodBeat.i(238993);
    int i = this.oGu;
    Object localObject = XmlParser.parseXml(this.oGC, "msg", null);
    if (localObject == null)
    {
      AppMethodBeat.o(238993);
      return null;
    }
    if (i != 1)
    {
      localObject = (String)((Map)localObject).get(".msg.img.$cdnmidimgurl");
      AppMethodBeat.o(238993);
      return localObject;
    }
    localObject = (String)((Map)localObject).get(".msg.img.$cdnbigimgurl");
    AppMethodBeat.o(238993);
    return localObject;
  }
  
  public final void iP(long paramLong)
  {
    this.oGz = paramLong;
    this.oGM = true;
  }
  
  public final void setCreateTime(int paramInt)
  {
    this.createTime = paramInt;
    this.oGL = true;
  }
  
  public final void setLocalId(long paramLong)
  {
    this.localId = paramLong;
    this.oGE = true;
  }
  
  public final void setSource(int paramInt)
  {
    this.source = paramInt;
    this.oGQ = true;
  }
  
  public final void setStatus(int paramInt)
  {
    this.status = paramInt;
    this.oGN = true;
  }
  
  public final void wi(int paramInt)
  {
    this.oGA = paramInt;
    this.oGO = true;
  }
  
  public final void wj(int paramInt)
  {
    int i = 0;
    AppMethodBeat.i(150550);
    if (this.offset != paramInt) {
      this.oGG = true;
    }
    this.offset = paramInt;
    Log.e("MicroMsg.Imgfo", "set offset : %d  id:%d total:%d", new Object[] { Integer.valueOf(paramInt), Long.valueOf(this.oGz), Integer.valueOf(this.osy) });
    if (paramInt < this.osy) {}
    for (paramInt = i;; paramInt = 1)
    {
      wo(paramInt);
      AppMethodBeat.o(150550);
      return;
    }
  }
  
  public final void wk(int paramInt)
  {
    this.osy = paramInt;
    this.oGH = true;
  }
  
  public final void wl(int paramInt)
  {
    this.oGB = paramInt;
    this.oGP = true;
  }
  
  public final void wm(int paramInt)
  {
    this.oGv = paramInt;
    this.oGW = true;
  }
  
  public final void wn(int paramInt)
  {
    this.oGx = paramInt;
    this.oGY = true;
  }
  
  public final void wo(int paramInt)
  {
    if (this.oGD != paramInt) {
      this.oGT = true;
    }
    this.oGD = paramInt;
  }
  
  public final void wp(int paramInt)
  {
    this.oGu = paramInt;
    this.oGV = true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.modelimage.h
 * JD-Core Version:    0.7.0.1
 */