package com.tencent.mm.ay;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.XmlParser;
import java.util.Map;

public final class g
{
  public int cUP = -2;
  public int createTime;
  public long fNu;
  public int ilm = 0;
  public int lAW;
  public String lNH = "";
  public String lNI = "";
  public String lNJ = "";
  public int lNK;
  public int lNL;
  public String lNM = "";
  int lNN = 0;
  private String lNO = "";
  public long lNP;
  int lNQ;
  public int lNR = 0;
  public String lNS = "";
  int lNT = 1;
  private boolean lNU;
  private boolean lNV;
  private boolean lNW;
  private boolean lNX;
  private boolean lNY;
  private boolean lNZ;
  private boolean lOa;
  private boolean lOb;
  private boolean lOc;
  private boolean lOd;
  private boolean lOe;
  private boolean lOf;
  private boolean lOg;
  private boolean lOh;
  private boolean lOi;
  private boolean lOj;
  private boolean lOk;
  private boolean lOl;
  private boolean lOm;
  private boolean lOn;
  private boolean lOo;
  public long localId;
  public int offset;
  int source;
  public int status;
  
  public final void EG(long paramLong)
  {
    if (this.fNu != paramLong) {
      this.lNV = true;
    }
    this.fNu = paramLong;
  }
  
  public final void GE(long paramLong)
  {
    this.lNP = paramLong;
    this.lOc = true;
  }
  
  public final void VM(String paramString)
  {
    this.lNO = paramString;
    this.lOk = true;
  }
  
  public final void VN(String paramString)
  {
    this.lNH = paramString;
    this.lNY = true;
  }
  
  public final void VO(String paramString)
  {
    this.lNI = paramString;
    this.lNZ = true;
  }
  
  public final void VP(String paramString)
  {
    this.lNJ = paramString;
    this.lOa = true;
  }
  
  public final void VQ(String paramString)
  {
    AppMethodBeat.i(150551);
    if (((this.lNS == null) && (paramString != null)) || ((this.lNS != null) && (!this.lNS.equals(paramString)))) {
      this.lOh = true;
    }
    this.lNS = paramString;
    AppMethodBeat.o(150551);
  }
  
  public final void VR(String paramString)
  {
    this.lNM = paramString;
    this.lOn = true;
  }
  
  public final int blF()
  {
    return this.lAW;
  }
  
  public final String blG()
  {
    return this.lNH;
  }
  
  public final String blH()
  {
    return this.lNI;
  }
  
  public final String blI()
  {
    return this.lNJ;
  }
  
  public final boolean blJ()
  {
    return (this.lAW != 0) && (this.lAW == this.offset);
  }
  
  public final boolean blK()
  {
    return this.lNR > 0;
  }
  
  public final String blL()
  {
    return this.lNS;
  }
  
  public final void blM()
  {
    this.ilm = 1;
    this.lOi = true;
  }
  
  public final void blN()
  {
    this.lNU = false;
    this.lNV = false;
    this.lNW = false;
    this.lNX = false;
    this.lNY = false;
    this.lNZ = false;
    this.lOa = false;
    this.lOb = false;
    this.lOc = false;
    this.lOd = false;
    this.lOe = false;
    this.lOf = false;
    this.lOg = false;
    this.lOh = false;
    this.lOi = false;
    this.lOj = false;
    this.lOk = false;
    this.lOl = false;
    this.lOm = false;
    this.lOn = false;
    this.lOo = false;
  }
  
  public final void convertFrom(Cursor paramCursor)
  {
    AppMethodBeat.i(150552);
    this.localId = paramCursor.getInt(0);
    this.fNu = paramCursor.getLong(1);
    this.offset = paramCursor.getInt(2);
    this.lAW = paramCursor.getInt(3);
    this.lNH = paramCursor.getString(4);
    this.lNJ = paramCursor.getString(5);
    this.createTime = paramCursor.getInt(6);
    this.lNP = paramCursor.getInt(7);
    this.status = paramCursor.getInt(8);
    this.lNQ = paramCursor.getInt(9);
    this.lNR = paramCursor.getInt(10);
    this.source = paramCursor.getInt(11);
    this.lNS = paramCursor.getString(12);
    this.ilm = paramCursor.getInt(14);
    this.lNT = paramCursor.getInt(15);
    this.lNO = paramCursor.getString(16);
    this.lNK = paramCursor.getInt(17);
    this.lNI = paramCursor.getString(18);
    this.lNL = paramCursor.getInt(19);
    this.lNM = paramCursor.getString(20);
    this.lNN = paramCursor.getInt(21);
    AppMethodBeat.o(150552);
  }
  
  public final ContentValues convertTo()
  {
    AppMethodBeat.i(150553);
    ContentValues localContentValues = new ContentValues();
    if (this.lNU) {
      localContentValues.put("id", Long.valueOf(this.localId));
    }
    if (this.lNV) {
      localContentValues.put("msgSvrId", Long.valueOf(this.fNu));
    }
    if (this.lNW) {
      localContentValues.put("offset", Integer.valueOf(this.offset));
    }
    if (this.lNX) {
      localContentValues.put("totalLen", Integer.valueOf(this.lAW));
    }
    if (this.lNY) {
      localContentValues.put("bigImgPath", this.lNH);
    }
    if (this.lNZ) {
      localContentValues.put("midImgPath", this.lNI);
    }
    if (this.lOa) {
      localContentValues.put("thumbImgPath", this.lNJ);
    }
    if (this.lOb) {
      localContentValues.put("createtime", Integer.valueOf(this.createTime));
    }
    if (this.lOc) {
      localContentValues.put("msglocalid", Long.valueOf(this.lNP));
    }
    if (this.lOd) {
      localContentValues.put("status", Integer.valueOf(this.status));
    }
    if (this.lOe) {
      localContentValues.put("nettimes", Integer.valueOf(this.lNQ));
    }
    if (this.lOf) {
      localContentValues.put("reserved1", Integer.valueOf(this.lNR));
    }
    if (this.lOg) {
      localContentValues.put("reserved2", Integer.valueOf(this.source));
    }
    if (this.lOh) {
      localContentValues.put("reserved3", this.lNS);
    }
    if (this.lOi) {
      localContentValues.put("hashdthumb", Integer.valueOf(this.ilm));
    }
    if (this.lOj) {
      if (this.offset >= this.lAW) {
        break label438;
      }
    }
    label438:
    for (int i = 0;; i = 1)
    {
      localContentValues.put("iscomplete", Integer.valueOf(i));
      if (this.lOk) {
        localContentValues.put("origImgMD5", this.lNO);
      }
      if (this.lOl) {
        localContentValues.put("compressType", Integer.valueOf(this.lNK));
      }
      if (this.lOm) {
        localContentValues.put("forwardType", Integer.valueOf(this.lNL));
      }
      if (this.lOn) {
        localContentValues.put("hevcPath", this.lNM);
      }
      if (this.lOo) {
        localContentValues.put("sendImgType", Integer.valueOf(this.lNN));
      }
      AppMethodBeat.o(150553);
      return localContentValues;
    }
  }
  
  public final String getAesKey()
  {
    AppMethodBeat.i(223156);
    Object localObject = XmlParser.parseXml(this.lNS, "msg", null);
    if (localObject != null)
    {
      localObject = (String)((Map)localObject).get(".msg.img.$aeskey");
      AppMethodBeat.o(223156);
      return localObject;
    }
    AppMethodBeat.o(223156);
    return null;
  }
  
  public final String getFileId()
  {
    AppMethodBeat.i(223151);
    int i = this.lNK;
    Object localObject = XmlParser.parseXml(this.lNS, "msg", null);
    if (localObject == null)
    {
      AppMethodBeat.o(223151);
      return null;
    }
    if (i != 1)
    {
      localObject = (String)((Map)localObject).get(".msg.img.$cdnmidimgurl");
      AppMethodBeat.o(223151);
      return localObject;
    }
    localObject = (String)((Map)localObject).get(".msg.img.$cdnbigimgurl");
    AppMethodBeat.o(223151);
    return localObject;
  }
  
  public final long getLocalId()
  {
    return this.localId;
  }
  
  public final void setCreateTime(int paramInt)
  {
    this.createTime = paramInt;
    this.lOb = true;
  }
  
  public final void setLocalId(long paramLong)
  {
    this.localId = paramLong;
    this.lNU = true;
  }
  
  public final void setSource(int paramInt)
  {
    this.source = paramInt;
    this.lOg = true;
  }
  
  public final void setStatus(int paramInt)
  {
    this.status = paramInt;
    this.lOd = true;
  }
  
  public final void wd(int paramInt)
  {
    this.lNQ = paramInt;
    this.lOe = true;
  }
  
  public final void we(int paramInt)
  {
    int i = 0;
    AppMethodBeat.i(150550);
    if (this.offset != paramInt) {
      this.lNW = true;
    }
    this.offset = paramInt;
    Log.e("MicroMsg.Imgfo", "set offset : %d  id:%d total:%d", new Object[] { Integer.valueOf(paramInt), Long.valueOf(this.lNP), Integer.valueOf(this.lAW) });
    if (paramInt < this.lAW) {}
    for (paramInt = i;; paramInt = 1)
    {
      wj(paramInt);
      AppMethodBeat.o(150550);
      return;
    }
  }
  
  public final void wf(int paramInt)
  {
    this.lAW = paramInt;
    this.lNX = true;
  }
  
  public final void wg(int paramInt)
  {
    this.lNR = paramInt;
    this.lOf = true;
  }
  
  public final void wh(int paramInt)
  {
    this.lNL = paramInt;
    this.lOm = true;
  }
  
  public final void wi(int paramInt)
  {
    this.lNN = paramInt;
    this.lOo = true;
  }
  
  public final void wj(int paramInt)
  {
    if (this.lNT != paramInt) {
      this.lOj = true;
    }
    this.lNT = paramInt;
  }
  
  public final void wk(int paramInt)
  {
    this.lNK = paramInt;
    this.lOl = true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ay.g
 * JD-Core Version:    0.7.0.1
 */