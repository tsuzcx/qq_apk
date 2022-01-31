package com.tencent.mm.as;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.platformtools.y;

public final class e
{
  public long bXr;
  public int bcw = -2;
  int cQK = 0;
  public int ebK;
  public String enA = "";
  int enB = 1;
  private boolean enC;
  private boolean enD;
  private boolean enE;
  private boolean enF;
  private boolean enG;
  private boolean enH;
  private boolean enI;
  private boolean enJ;
  private boolean enK;
  private boolean enL;
  private boolean enM;
  private boolean enN;
  boolean enO;
  private boolean enP;
  boolean enQ;
  private boolean enR;
  private boolean enS;
  private boolean enT;
  private boolean enU;
  public long enp;
  public String enq = "";
  public String enr = "";
  public String ens = "";
  public int ent;
  public int enu;
  private String env = "";
  public int enw;
  public long enx;
  int eny;
  public int enz = 0;
  public int offset;
  int source;
  public int status;
  
  public final boolean Oq()
  {
    return (this.ebK != 0) && (this.ebK == this.offset);
  }
  
  public final boolean Or()
  {
    return this.enz > 0;
  }
  
  public final void Os()
  {
    this.enC = false;
    this.enD = false;
    this.enE = false;
    this.enF = false;
    this.enG = false;
    this.enH = false;
    this.enI = false;
    this.enJ = false;
    this.enK = false;
    this.enL = false;
    this.enM = false;
    this.enN = false;
    this.enO = false;
    this.enP = false;
    this.enQ = false;
    this.enR = false;
    this.enS = false;
    this.enT = false;
    this.enU = false;
  }
  
  public final void bV(long paramLong)
  {
    this.enx = paramLong;
    this.enK = true;
  }
  
  public final void bW(long paramLong)
  {
    this.enp = paramLong;
    this.enC = true;
  }
  
  public final void bf(long paramLong)
  {
    if (this.bXr != paramLong) {
      this.enD = true;
    }
    this.bXr = paramLong;
  }
  
  public final void d(Cursor paramCursor)
  {
    this.enp = paramCursor.getInt(0);
    this.bXr = paramCursor.getLong(1);
    this.offset = paramCursor.getInt(2);
    this.ebK = paramCursor.getInt(3);
    this.enq = paramCursor.getString(4);
    this.ens = paramCursor.getString(5);
    this.enw = paramCursor.getInt(6);
    this.enx = paramCursor.getInt(7);
    this.status = paramCursor.getInt(8);
    this.eny = paramCursor.getInt(9);
    this.enz = paramCursor.getInt(10);
    this.source = paramCursor.getInt(11);
    this.enA = paramCursor.getString(12);
    this.cQK = paramCursor.getInt(14);
    this.enB = paramCursor.getInt(15);
    this.env = paramCursor.getString(16);
    this.ent = paramCursor.getInt(17);
    this.enr = paramCursor.getString(18);
    this.enu = paramCursor.getInt(19);
  }
  
  public final void iA(int paramInt)
  {
    this.eny = paramInt;
    this.enM = true;
  }
  
  public final void iB(int paramInt)
  {
    this.enw = paramInt;
    this.enJ = true;
  }
  
  public final void iC(int paramInt)
  {
    this.ebK = paramInt;
    this.enF = true;
  }
  
  public final void iD(int paramInt)
  {
    this.enz = paramInt;
    this.enN = true;
  }
  
  public final void iE(int paramInt)
  {
    this.enu = paramInt;
    this.enU = true;
  }
  
  public final void iF(int paramInt)
  {
    if (this.enB != paramInt) {
      this.enR = true;
    }
    this.enB = paramInt;
  }
  
  public final void iG(int paramInt)
  {
    this.ent = paramInt;
    this.enT = true;
  }
  
  public final void lW(String paramString)
  {
    this.env = paramString;
    this.enS = true;
  }
  
  public final void lX(String paramString)
  {
    this.enq = paramString;
    this.enG = true;
  }
  
  public final void lY(String paramString)
  {
    this.enr = paramString;
    this.enH = true;
  }
  
  public final void lZ(String paramString)
  {
    this.ens = paramString;
    this.enI = true;
  }
  
  public final void ma(String paramString)
  {
    if (((this.enA == null) && (paramString != null)) || ((this.enA != null) && (!this.enA.equals(paramString)))) {
      this.enP = true;
    }
    this.enA = paramString;
  }
  
  public final void setOffset(int paramInt)
  {
    int i = 0;
    if (this.offset != paramInt) {
      this.enE = true;
    }
    this.offset = paramInt;
    y.e("MicroMsg.Imgfo", "set offset : %d  id:%d total:%d", new Object[] { Integer.valueOf(paramInt), Long.valueOf(this.enx), Integer.valueOf(this.ebK) });
    if (paramInt < this.ebK) {}
    for (paramInt = i;; paramInt = 1)
    {
      iF(paramInt);
      return;
    }
  }
  
  public final void setStatus(int paramInt)
  {
    this.status = paramInt;
    this.enL = true;
  }
  
  public final ContentValues vf()
  {
    ContentValues localContentValues = new ContentValues();
    if (this.enC) {
      localContentValues.put("id", Long.valueOf(this.enp));
    }
    if (this.enD) {
      localContentValues.put("msgSvrId", Long.valueOf(this.bXr));
    }
    if (this.enE) {
      localContentValues.put("offset", Integer.valueOf(this.offset));
    }
    if (this.enF) {
      localContentValues.put("totalLen", Integer.valueOf(this.ebK));
    }
    if (this.enG) {
      localContentValues.put("bigImgPath", this.enq);
    }
    if (this.enH) {
      localContentValues.put("midImgPath", this.enr);
    }
    if (this.enI) {
      localContentValues.put("thumbImgPath", this.ens);
    }
    if (this.enJ) {
      localContentValues.put("createtime", Integer.valueOf(this.enw));
    }
    if (this.enK) {
      localContentValues.put("msglocalid", Long.valueOf(this.enx));
    }
    if (this.enL) {
      localContentValues.put("status", Integer.valueOf(this.status));
    }
    if (this.enM) {
      localContentValues.put("nettimes", Integer.valueOf(this.eny));
    }
    if (this.enN) {
      localContentValues.put("reserved1", Integer.valueOf(this.enz));
    }
    if (this.enO) {
      localContentValues.put("reserved2", Integer.valueOf(this.source));
    }
    if (this.enP) {
      localContentValues.put("reserved3", this.enA);
    }
    if (this.enQ) {
      localContentValues.put("hashdthumb", Integer.valueOf(this.cQK));
    }
    if (this.enR) {
      if (this.offset >= this.ebK) {
        break label385;
      }
    }
    label385:
    for (int i = 0;; i = 1)
    {
      localContentValues.put("iscomplete", Integer.valueOf(i));
      if (this.enS) {
        localContentValues.put("origImgMD5", this.env);
      }
      if (this.enT) {
        localContentValues.put("compressType", Integer.valueOf(this.ent));
      }
      if (this.enU) {
        localContentValues.put("forwardType", Integer.valueOf(this.enu));
      }
      return localContentValues;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.as.e
 * JD-Core Version:    0.7.0.1
 */