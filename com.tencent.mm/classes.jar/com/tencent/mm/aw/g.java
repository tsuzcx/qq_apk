package com.tencent.mm.aw;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ad;

public final class g
{
  public long dAY;
  public int dDp = -2;
  int dnh;
  public long dnz;
  public int fkv = 0;
  public int hMP;
  public int hZA;
  public String hZB = "";
  int hZC = 0;
  private String hZD = "";
  public int hZE;
  public long hZF;
  int hZG;
  public int hZH = 0;
  public String hZI = "";
  int hZJ = 1;
  private boolean hZK;
  private boolean hZL;
  private boolean hZM;
  private boolean hZN;
  private boolean hZO;
  private boolean hZP;
  private boolean hZQ;
  private boolean hZR;
  private boolean hZS;
  private boolean hZT;
  private boolean hZU;
  private boolean hZV;
  private boolean hZW;
  private boolean hZX;
  private boolean hZY;
  private boolean hZZ;
  public String hZw = "";
  public String hZx = "";
  public String hZy = "";
  public int hZz;
  private boolean iaa;
  private boolean iab;
  private boolean iac;
  private boolean iad;
  private boolean iae;
  public int offset;
  public int status;
  
  public final void Fc(String paramString)
  {
    this.hZD = paramString;
    this.iaa = true;
  }
  
  public final void Fd(String paramString)
  {
    this.hZw = paramString;
    this.hZO = true;
  }
  
  public final void Fe(String paramString)
  {
    this.hZx = paramString;
    this.hZP = true;
  }
  
  public final void Ff(String paramString)
  {
    this.hZy = paramString;
    this.hZQ = true;
  }
  
  public final void Fg(String paramString)
  {
    AppMethodBeat.i(150551);
    if (((this.hZI == null) && (paramString != null)) || ((this.hZI != null) && (!this.hZI.equals(paramString)))) {
      this.hZX = true;
    }
    this.hZI = paramString;
    AppMethodBeat.o(150551);
  }
  
  public final void Fh(String paramString)
  {
    this.hZB = paramString;
    this.iad = true;
  }
  
  public final String aIf()
  {
    return this.hZw;
  }
  
  public final String aIg()
  {
    return this.hZx;
  }
  
  public final String aIh()
  {
    return this.hZy;
  }
  
  public final boolean aIi()
  {
    return (this.hMP != 0) && (this.hMP == this.offset);
  }
  
  public final boolean aIj()
  {
    return this.hZH > 0;
  }
  
  public final void aIk()
  {
    this.fkv = 1;
    this.hZY = true;
  }
  
  public final void aIl()
  {
    this.hZK = false;
    this.hZL = false;
    this.hZM = false;
    this.hZN = false;
    this.hZO = false;
    this.hZP = false;
    this.hZQ = false;
    this.hZR = false;
    this.hZS = false;
    this.hZT = false;
    this.hZU = false;
    this.hZV = false;
    this.hZW = false;
    this.hZX = false;
    this.hZY = false;
    this.hZZ = false;
    this.iaa = false;
    this.iab = false;
    this.iac = false;
    this.iad = false;
    this.iae = false;
  }
  
  public final void convertFrom(Cursor paramCursor)
  {
    AppMethodBeat.i(150552);
    this.dnz = paramCursor.getInt(0);
    this.dAY = paramCursor.getLong(1);
    this.offset = paramCursor.getInt(2);
    this.hMP = paramCursor.getInt(3);
    this.hZw = paramCursor.getString(4);
    this.hZy = paramCursor.getString(5);
    this.hZE = paramCursor.getInt(6);
    this.hZF = paramCursor.getInt(7);
    this.status = paramCursor.getInt(8);
    this.hZG = paramCursor.getInt(9);
    this.hZH = paramCursor.getInt(10);
    this.dnh = paramCursor.getInt(11);
    this.hZI = paramCursor.getString(12);
    this.fkv = paramCursor.getInt(14);
    this.hZJ = paramCursor.getInt(15);
    this.hZD = paramCursor.getString(16);
    this.hZz = paramCursor.getInt(17);
    this.hZx = paramCursor.getString(18);
    this.hZA = paramCursor.getInt(19);
    this.hZB = paramCursor.getString(20);
    this.hZC = paramCursor.getInt(21);
    AppMethodBeat.o(150552);
  }
  
  public final ContentValues convertTo()
  {
    AppMethodBeat.i(150553);
    ContentValues localContentValues = new ContentValues();
    if (this.hZK) {
      localContentValues.put("id", Long.valueOf(this.dnz));
    }
    if (this.hZL) {
      localContentValues.put("msgSvrId", Long.valueOf(this.dAY));
    }
    if (this.hZM) {
      localContentValues.put("offset", Integer.valueOf(this.offset));
    }
    if (this.hZN) {
      localContentValues.put("totalLen", Integer.valueOf(this.hMP));
    }
    if (this.hZO) {
      localContentValues.put("bigImgPath", this.hZw);
    }
    if (this.hZP) {
      localContentValues.put("midImgPath", this.hZx);
    }
    if (this.hZQ) {
      localContentValues.put("thumbImgPath", this.hZy);
    }
    if (this.hZR) {
      localContentValues.put("createtime", Integer.valueOf(this.hZE));
    }
    if (this.hZS) {
      localContentValues.put("msglocalid", Long.valueOf(this.hZF));
    }
    if (this.hZT) {
      localContentValues.put("status", Integer.valueOf(this.status));
    }
    if (this.hZU) {
      localContentValues.put("nettimes", Integer.valueOf(this.hZG));
    }
    if (this.hZV) {
      localContentValues.put("reserved1", Integer.valueOf(this.hZH));
    }
    if (this.hZW) {
      localContentValues.put("reserved2", Integer.valueOf(this.dnh));
    }
    if (this.hZX) {
      localContentValues.put("reserved3", this.hZI);
    }
    if (this.hZY) {
      localContentValues.put("hashdthumb", Integer.valueOf(this.fkv));
    }
    if (this.hZZ) {
      if (this.offset >= this.hMP) {
        break label435;
      }
    }
    label435:
    for (int i = 0;; i = 1)
    {
      localContentValues.put("iscomplete", Integer.valueOf(i));
      if (this.iaa) {
        localContentValues.put("origImgMD5", this.hZD);
      }
      if (this.iab) {
        localContentValues.put("compressType", Integer.valueOf(this.hZz));
      }
      if (this.iac) {
        localContentValues.put("forwardType", Integer.valueOf(this.hZA));
      }
      if (this.iad) {
        localContentValues.put("hevcPath", this.hZB);
      }
      if (this.iae) {
        localContentValues.put("sendImgType", Integer.valueOf(this.hZC));
      }
      AppMethodBeat.o(150553);
      return localContentValues;
    }
  }
  
  public final void pm(int paramInt)
  {
    this.hZG = paramInt;
    this.hZU = true;
  }
  
  public final void pn(int paramInt)
  {
    this.hMP = paramInt;
    this.hZN = true;
  }
  
  public final void po(int paramInt)
  {
    this.hZH = paramInt;
    this.hZV = true;
  }
  
  public final void pp(int paramInt)
  {
    this.hZA = paramInt;
    this.iac = true;
  }
  
  public final void pq(int paramInt)
  {
    this.hZC = paramInt;
    this.iae = true;
  }
  
  public final void pr(int paramInt)
  {
    if (this.hZJ != paramInt) {
      this.hZZ = true;
    }
    this.hZJ = paramInt;
  }
  
  public final void ps(int paramInt)
  {
    this.hZz = paramInt;
    this.iab = true;
  }
  
  public final void qz(long paramLong)
  {
    if (this.dAY != paramLong) {
      this.hZL = true;
    }
    this.dAY = paramLong;
  }
  
  public final void sd(long paramLong)
  {
    this.hZF = paramLong;
    this.hZS = true;
  }
  
  public final void setCreateTime(int paramInt)
  {
    this.hZE = paramInt;
    this.hZR = true;
  }
  
  public final void setLocalId(long paramLong)
  {
    this.dnz = paramLong;
    this.hZK = true;
  }
  
  public final void setOffset(int paramInt)
  {
    int i = 0;
    AppMethodBeat.i(150550);
    if (this.offset != paramInt) {
      this.hZM = true;
    }
    this.offset = paramInt;
    ad.e("MicroMsg.Imgfo", "set offset : %d  id:%d total:%d", new Object[] { Integer.valueOf(paramInt), Long.valueOf(this.hZF), Integer.valueOf(this.hMP) });
    if (paramInt < this.hMP) {}
    for (paramInt = i;; paramInt = 1)
    {
      pr(paramInt);
      AppMethodBeat.o(150550);
      return;
    }
  }
  
  public final void setSource(int paramInt)
  {
    this.dnh = paramInt;
    this.hZW = true;
  }
  
  public final void setStatus(int paramInt)
  {
    this.status = paramInt;
    this.hZT = true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.aw.g
 * JD-Core Version:    0.7.0.1
 */