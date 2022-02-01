package com.tencent.mm.av;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ac;

public final class e
{
  int dbL;
  public long dcd;
  public long dpl;
  public int drx = -2;
  public int eSg = 0;
  public String hGM = "";
  public String hGN = "";
  public String hGO = "";
  public int hGP;
  public int hGQ;
  public String hGR = "";
  int hGS = 0;
  private String hGT = "";
  public int hGU;
  public long hGV;
  int hGW;
  public int hGX = 0;
  public String hGY = "";
  int hGZ = 1;
  private boolean hHa;
  private boolean hHb;
  private boolean hHc;
  private boolean hHd;
  private boolean hHe;
  private boolean hHf;
  private boolean hHg;
  private boolean hHh;
  private boolean hHi;
  private boolean hHj;
  private boolean hHk;
  private boolean hHl;
  private boolean hHm;
  private boolean hHn;
  private boolean hHo;
  private boolean hHp;
  private boolean hHq;
  private boolean hHr;
  private boolean hHs;
  private boolean hHt;
  private boolean hHu;
  public int hux;
  public int offset;
  public int status;
  
  public final void Cd(String paramString)
  {
    this.hGT = paramString;
    this.hHq = true;
  }
  
  public final void Ce(String paramString)
  {
    this.hGM = paramString;
    this.hHe = true;
  }
  
  public final void Cf(String paramString)
  {
    this.hGN = paramString;
    this.hHf = true;
  }
  
  public final void Cg(String paramString)
  {
    this.hGO = paramString;
    this.hHg = true;
  }
  
  public final void Ch(String paramString)
  {
    AppMethodBeat.i(150551);
    if (((this.hGY == null) && (paramString != null)) || ((this.hGY != null) && (!this.hGY.equals(paramString)))) {
      this.hHn = true;
    }
    this.hGY = paramString;
    AppMethodBeat.o(150551);
  }
  
  public final void Ci(String paramString)
  {
    this.hGR = paramString;
    this.hHt = true;
  }
  
  public final boolean aEZ()
  {
    return (this.hux != 0) && (this.hux == this.offset);
  }
  
  public final boolean aFa()
  {
    return this.hGX > 0;
  }
  
  public final void aFb()
  {
    this.eSg = 1;
    this.hHo = true;
  }
  
  public final void aFc()
  {
    this.hHa = false;
    this.hHb = false;
    this.hHc = false;
    this.hHd = false;
    this.hHe = false;
    this.hHf = false;
    this.hHg = false;
    this.hHh = false;
    this.hHi = false;
    this.hHj = false;
    this.hHk = false;
    this.hHl = false;
    this.hHm = false;
    this.hHn = false;
    this.hHo = false;
    this.hHp = false;
    this.hHq = false;
    this.hHr = false;
    this.hHs = false;
    this.hHt = false;
    this.hHu = false;
  }
  
  public final void convertFrom(Cursor paramCursor)
  {
    AppMethodBeat.i(150552);
    this.dcd = paramCursor.getInt(0);
    this.dpl = paramCursor.getLong(1);
    this.offset = paramCursor.getInt(2);
    this.hux = paramCursor.getInt(3);
    this.hGM = paramCursor.getString(4);
    this.hGO = paramCursor.getString(5);
    this.hGU = paramCursor.getInt(6);
    this.hGV = paramCursor.getInt(7);
    this.status = paramCursor.getInt(8);
    this.hGW = paramCursor.getInt(9);
    this.hGX = paramCursor.getInt(10);
    this.dbL = paramCursor.getInt(11);
    this.hGY = paramCursor.getString(12);
    this.eSg = paramCursor.getInt(14);
    this.hGZ = paramCursor.getInt(15);
    this.hGT = paramCursor.getString(16);
    this.hGP = paramCursor.getInt(17);
    this.hGN = paramCursor.getString(18);
    this.hGQ = paramCursor.getInt(19);
    this.hGR = paramCursor.getString(20);
    this.hGS = paramCursor.getInt(21);
    AppMethodBeat.o(150552);
  }
  
  public final ContentValues convertTo()
  {
    AppMethodBeat.i(150553);
    ContentValues localContentValues = new ContentValues();
    if (this.hHa) {
      localContentValues.put("id", Long.valueOf(this.dcd));
    }
    if (this.hHb) {
      localContentValues.put("msgSvrId", Long.valueOf(this.dpl));
    }
    if (this.hHc) {
      localContentValues.put("offset", Integer.valueOf(this.offset));
    }
    if (this.hHd) {
      localContentValues.put("totalLen", Integer.valueOf(this.hux));
    }
    if (this.hHe) {
      localContentValues.put("bigImgPath", this.hGM);
    }
    if (this.hHf) {
      localContentValues.put("midImgPath", this.hGN);
    }
    if (this.hHg) {
      localContentValues.put("thumbImgPath", this.hGO);
    }
    if (this.hHh) {
      localContentValues.put("createtime", Integer.valueOf(this.hGU));
    }
    if (this.hHi) {
      localContentValues.put("msglocalid", Long.valueOf(this.hGV));
    }
    if (this.hHj) {
      localContentValues.put("status", Integer.valueOf(this.status));
    }
    if (this.hHk) {
      localContentValues.put("nettimes", Integer.valueOf(this.hGW));
    }
    if (this.hHl) {
      localContentValues.put("reserved1", Integer.valueOf(this.hGX));
    }
    if (this.hHm) {
      localContentValues.put("reserved2", Integer.valueOf(this.dbL));
    }
    if (this.hHn) {
      localContentValues.put("reserved3", this.hGY);
    }
    if (this.hHo) {
      localContentValues.put("hashdthumb", Integer.valueOf(this.eSg));
    }
    if (this.hHp) {
      if (this.offset >= this.hux) {
        break label433;
      }
    }
    label433:
    for (int i = 0;; i = 1)
    {
      localContentValues.put("iscomplete", Integer.valueOf(i));
      if (this.hHq) {
        localContentValues.put("origImgMD5", this.hGT);
      }
      if (this.hHr) {
        localContentValues.put("compressType", Integer.valueOf(this.hGP));
      }
      if (this.hHs) {
        localContentValues.put("forwardType", Integer.valueOf(this.hGQ));
      }
      if (this.hHt) {
        localContentValues.put("hevcPath", this.hGR);
      }
      if (this.hHu) {
        localContentValues.put("sendImgType", Integer.valueOf(this.hGS));
      }
      AppMethodBeat.o(150553);
      return localContentValues;
    }
  }
  
  public final void oK(int paramInt)
  {
    this.hGW = paramInt;
    this.hHk = true;
  }
  
  public final void oL(int paramInt)
  {
    this.hux = paramInt;
    this.hHd = true;
  }
  
  public final void oM(int paramInt)
  {
    this.hGX = paramInt;
    this.hHl = true;
  }
  
  public final void oN(int paramInt)
  {
    this.hGQ = paramInt;
    this.hHs = true;
  }
  
  public final void oO(int paramInt)
  {
    this.hGS = paramInt;
    this.hHu = true;
  }
  
  public final void oP(int paramInt)
  {
    if (this.hGZ != paramInt) {
      this.hHp = true;
    }
    this.hGZ = paramInt;
  }
  
  public final void oQ(int paramInt)
  {
    this.hGP = paramInt;
    this.hHr = true;
  }
  
  public final void oz(long paramLong)
  {
    if (this.dpl != paramLong) {
      this.hHb = true;
    }
    this.dpl = paramLong;
  }
  
  public final void qe(long paramLong)
  {
    this.hGV = paramLong;
    this.hHi = true;
  }
  
  public final void setCreateTime(int paramInt)
  {
    this.hGU = paramInt;
    this.hHh = true;
  }
  
  public final void setLocalId(long paramLong)
  {
    this.dcd = paramLong;
    this.hHa = true;
  }
  
  public final void setOffset(int paramInt)
  {
    int i = 0;
    AppMethodBeat.i(150550);
    if (this.offset != paramInt) {
      this.hHc = true;
    }
    this.offset = paramInt;
    ac.e("MicroMsg.Imgfo", "set offset : %d  id:%d total:%d", new Object[] { Integer.valueOf(paramInt), Long.valueOf(this.hGV), Integer.valueOf(this.hux) });
    if (paramInt < this.hux) {}
    for (paramInt = i;; paramInt = 1)
    {
      oP(paramInt);
      AppMethodBeat.o(150550);
      return;
    }
  }
  
  public final void setSource(int paramInt)
  {
    this.dbL = paramInt;
    this.hHm = true;
  }
  
  public final void setStatus(int paramInt)
  {
    this.status = paramInt;
    this.hHj = true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.av.e
 * JD-Core Version:    0.7.0.1
 */