package com.tencent.mm.at;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;

public final class e
{
  public int bsY = -2;
  public long cFn;
  int cpt;
  public int dGW = 0;
  public long fDL;
  public String fDM = "";
  public String fDN = "";
  public String fDO = "";
  public int fDP;
  public int fDQ;
  public String fDR = "";
  private String fDS = "";
  public int fDT;
  public long fDU;
  int fDV;
  public int fDW = 0;
  public String fDX = "";
  int fDY = 1;
  private boolean fDZ;
  private boolean fEa;
  private boolean fEb;
  private boolean fEc;
  private boolean fEd;
  private boolean fEe;
  private boolean fEf;
  private boolean fEg;
  private boolean fEh;
  private boolean fEi;
  private boolean fEj;
  private boolean fEk;
  private boolean fEl;
  private boolean fEm;
  private boolean fEn;
  private boolean fEo;
  private boolean fEp;
  private boolean fEq;
  private boolean fEr;
  private boolean fEs;
  public int fsd;
  public int offset;
  public int status;
  
  public final boolean ahg()
  {
    return (this.fsd != 0) && (this.fsd == this.offset);
  }
  
  public final boolean ahh()
  {
    return this.fDW > 0;
  }
  
  public final void ahi()
  {
    this.dGW = 1;
    this.fEn = true;
  }
  
  public final void ahj()
  {
    this.fDZ = false;
    this.fEa = false;
    this.fEb = false;
    this.fEc = false;
    this.fEd = false;
    this.fEe = false;
    this.fEf = false;
    this.fEg = false;
    this.fEh = false;
    this.fEi = false;
    this.fEj = false;
    this.fEk = false;
    this.fEl = false;
    this.fEm = false;
    this.fEn = false;
    this.fEo = false;
    this.fEp = false;
    this.fEq = false;
    this.fEr = false;
    this.fEs = false;
  }
  
  public final void convertFrom(Cursor paramCursor)
  {
    AppMethodBeat.i(78194);
    this.fDL = paramCursor.getInt(0);
    this.cFn = paramCursor.getLong(1);
    this.offset = paramCursor.getInt(2);
    this.fsd = paramCursor.getInt(3);
    this.fDM = paramCursor.getString(4);
    this.fDO = paramCursor.getString(5);
    this.fDT = paramCursor.getInt(6);
    this.fDU = paramCursor.getInt(7);
    this.status = paramCursor.getInt(8);
    this.fDV = paramCursor.getInt(9);
    this.fDW = paramCursor.getInt(10);
    this.cpt = paramCursor.getInt(11);
    this.fDX = paramCursor.getString(12);
    this.dGW = paramCursor.getInt(14);
    this.fDY = paramCursor.getInt(15);
    this.fDS = paramCursor.getString(16);
    this.fDP = paramCursor.getInt(17);
    this.fDN = paramCursor.getString(18);
    this.fDQ = paramCursor.getInt(19);
    this.fDR = paramCursor.getString(20);
    AppMethodBeat.o(78194);
  }
  
  public final ContentValues convertTo()
  {
    AppMethodBeat.i(78195);
    ContentValues localContentValues = new ContentValues();
    if (this.fDZ) {
      localContentValues.put("id", Long.valueOf(this.fDL));
    }
    if (this.fEa) {
      localContentValues.put("msgSvrId", Long.valueOf(this.cFn));
    }
    if (this.fEb) {
      localContentValues.put("offset", Integer.valueOf(this.offset));
    }
    if (this.fEc) {
      localContentValues.put("totalLen", Integer.valueOf(this.fsd));
    }
    if (this.fEd) {
      localContentValues.put("bigImgPath", this.fDM);
    }
    if (this.fEe) {
      localContentValues.put("midImgPath", this.fDN);
    }
    if (this.fEf) {
      localContentValues.put("thumbImgPath", this.fDO);
    }
    if (this.fEg) {
      localContentValues.put("createtime", Integer.valueOf(this.fDT));
    }
    if (this.fEh) {
      localContentValues.put("msglocalid", Long.valueOf(this.fDU));
    }
    if (this.fEi) {
      localContentValues.put("status", Integer.valueOf(this.status));
    }
    if (this.fEj) {
      localContentValues.put("nettimes", Integer.valueOf(this.fDV));
    }
    if (this.fEk) {
      localContentValues.put("reserved1", Integer.valueOf(this.fDW));
    }
    if (this.fEl) {
      localContentValues.put("reserved2", Integer.valueOf(this.cpt));
    }
    if (this.fEm) {
      localContentValues.put("reserved3", this.fDX);
    }
    if (this.fEn) {
      localContentValues.put("hashdthumb", Integer.valueOf(this.dGW));
    }
    if (this.fEo) {
      if (this.offset >= this.fsd) {
        break label412;
      }
    }
    label412:
    for (int i = 0;; i = 1)
    {
      localContentValues.put("iscomplete", Integer.valueOf(i));
      if (this.fEp) {
        localContentValues.put("origImgMD5", this.fDS);
      }
      if (this.fEq) {
        localContentValues.put("compressType", Integer.valueOf(this.fDP));
      }
      if (this.fEr) {
        localContentValues.put("forwardType", Integer.valueOf(this.fDQ));
      }
      if (this.fEs) {
        localContentValues.put("hevcPath", this.fDR);
      }
      AppMethodBeat.o(78195);
      return localContentValues;
    }
  }
  
  public final void fP(long paramLong)
  {
    if (this.cFn != paramLong) {
      this.fEa = true;
    }
    this.cFn = paramLong;
  }
  
  public final void gQ(long paramLong)
  {
    this.fDU = paramLong;
    this.fEh = true;
  }
  
  public final void gR(long paramLong)
  {
    this.fDL = paramLong;
    this.fDZ = true;
  }
  
  public final void lo(int paramInt)
  {
    this.fDV = paramInt;
    this.fEj = true;
  }
  
  public final void lp(int paramInt)
  {
    this.fDT = paramInt;
    this.fEg = true;
  }
  
  public final void lq(int paramInt)
  {
    this.fsd = paramInt;
    this.fEc = true;
  }
  
  public final void lr(int paramInt)
  {
    this.fDW = paramInt;
    this.fEk = true;
  }
  
  public final void ls(int paramInt)
  {
    this.fDQ = paramInt;
    this.fEr = true;
  }
  
  public final void lt(int paramInt)
  {
    if (this.fDY != paramInt) {
      this.fEo = true;
    }
    this.fDY = paramInt;
  }
  
  public final void lu(int paramInt)
  {
    this.fDP = paramInt;
    this.fEq = true;
  }
  
  public final void sV(String paramString)
  {
    this.fDS = paramString;
    this.fEp = true;
  }
  
  public final void sW(String paramString)
  {
    this.fDM = paramString;
    this.fEd = true;
  }
  
  public final void sX(String paramString)
  {
    this.fDN = paramString;
    this.fEe = true;
  }
  
  public final void sY(String paramString)
  {
    this.fDO = paramString;
    this.fEf = true;
  }
  
  public final void sZ(String paramString)
  {
    AppMethodBeat.i(78193);
    if (((this.fDX == null) && (paramString != null)) || ((this.fDX != null) && (!this.fDX.equals(paramString)))) {
      this.fEm = true;
    }
    this.fDX = paramString;
    AppMethodBeat.o(78193);
  }
  
  public final void setOffset(int paramInt)
  {
    int i = 0;
    AppMethodBeat.i(78192);
    if (this.offset != paramInt) {
      this.fEb = true;
    }
    this.offset = paramInt;
    ab.e("MicroMsg.Imgfo", "set offset : %d  id:%d total:%d", new Object[] { Integer.valueOf(paramInt), Long.valueOf(this.fDU), Integer.valueOf(this.fsd) });
    if (paramInt < this.fsd) {}
    for (paramInt = i;; paramInt = 1)
    {
      lt(paramInt);
      AppMethodBeat.o(78192);
      return;
    }
  }
  
  public final void setSource(int paramInt)
  {
    this.cpt = paramInt;
    this.fEl = true;
  }
  
  public final void setStatus(int paramInt)
  {
    this.status = paramInt;
    this.fEi = true;
  }
  
  public final void ta(String paramString)
  {
    this.fDR = paramString;
    this.fEs = true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.at.e
 * JD-Core Version:    0.7.0.1
 */