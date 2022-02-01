package com.tencent.mm.aw;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ad;

public final class e
{
  public long deI;
  int dep;
  public long drA;
  public int dtM = -2;
  public int eOY = 0;
  public int gTY;
  private boolean hgA;
  private boolean hgB;
  private boolean hgC;
  private boolean hgD;
  private boolean hgE;
  private boolean hgF;
  private boolean hgG;
  private boolean hgH;
  private boolean hgI;
  private boolean hgJ;
  private boolean hgK;
  private boolean hgL;
  private boolean hgM;
  private boolean hgN;
  private boolean hgO;
  private boolean hgP;
  private boolean hgQ;
  private boolean hgR;
  public String hgj = "";
  public String hgk = "";
  public String hgl = "";
  public int hgm;
  public int hgn;
  public String hgo = "";
  int hgp = 0;
  private String hgq = "";
  public int hgr;
  public long hgs;
  int hgt;
  public int hgu = 0;
  public String hgv = "";
  int hgw = 1;
  private boolean hgx;
  private boolean hgy;
  private boolean hgz;
  public int offset;
  public int status;
  
  public final boolean ayh()
  {
    return (this.gTY != 0) && (this.gTY == this.offset);
  }
  
  public final boolean ayi()
  {
    return this.hgu > 0;
  }
  
  public final void ayj()
  {
    this.eOY = 1;
    this.hgL = true;
  }
  
  public final void ayk()
  {
    this.hgx = false;
    this.hgy = false;
    this.hgz = false;
    this.hgA = false;
    this.hgB = false;
    this.hgC = false;
    this.hgD = false;
    this.hgE = false;
    this.hgF = false;
    this.hgG = false;
    this.hgH = false;
    this.hgI = false;
    this.hgJ = false;
    this.hgK = false;
    this.hgL = false;
    this.hgM = false;
    this.hgN = false;
    this.hgO = false;
    this.hgP = false;
    this.hgQ = false;
    this.hgR = false;
  }
  
  public final void convertFrom(Cursor paramCursor)
  {
    AppMethodBeat.i(150552);
    this.deI = paramCursor.getInt(0);
    this.drA = paramCursor.getLong(1);
    this.offset = paramCursor.getInt(2);
    this.gTY = paramCursor.getInt(3);
    this.hgj = paramCursor.getString(4);
    this.hgl = paramCursor.getString(5);
    this.hgr = paramCursor.getInt(6);
    this.hgs = paramCursor.getInt(7);
    this.status = paramCursor.getInt(8);
    this.hgt = paramCursor.getInt(9);
    this.hgu = paramCursor.getInt(10);
    this.dep = paramCursor.getInt(11);
    this.hgv = paramCursor.getString(12);
    this.eOY = paramCursor.getInt(14);
    this.hgw = paramCursor.getInt(15);
    this.hgq = paramCursor.getString(16);
    this.hgm = paramCursor.getInt(17);
    this.hgk = paramCursor.getString(18);
    this.hgn = paramCursor.getInt(19);
    this.hgo = paramCursor.getString(20);
    this.hgp = paramCursor.getInt(21);
    AppMethodBeat.o(150552);
  }
  
  public final ContentValues convertTo()
  {
    AppMethodBeat.i(150553);
    ContentValues localContentValues = new ContentValues();
    if (this.hgx) {
      localContentValues.put("id", Long.valueOf(this.deI));
    }
    if (this.hgy) {
      localContentValues.put("msgSvrId", Long.valueOf(this.drA));
    }
    if (this.hgz) {
      localContentValues.put("offset", Integer.valueOf(this.offset));
    }
    if (this.hgA) {
      localContentValues.put("totalLen", Integer.valueOf(this.gTY));
    }
    if (this.hgB) {
      localContentValues.put("bigImgPath", this.hgj);
    }
    if (this.hgC) {
      localContentValues.put("midImgPath", this.hgk);
    }
    if (this.hgD) {
      localContentValues.put("thumbImgPath", this.hgl);
    }
    if (this.hgE) {
      localContentValues.put("createtime", Integer.valueOf(this.hgr));
    }
    if (this.hgF) {
      localContentValues.put("msglocalid", Long.valueOf(this.hgs));
    }
    if (this.hgG) {
      localContentValues.put("status", Integer.valueOf(this.status));
    }
    if (this.hgH) {
      localContentValues.put("nettimes", Integer.valueOf(this.hgt));
    }
    if (this.hgI) {
      localContentValues.put("reserved1", Integer.valueOf(this.hgu));
    }
    if (this.hgJ) {
      localContentValues.put("reserved2", Integer.valueOf(this.dep));
    }
    if (this.hgK) {
      localContentValues.put("reserved3", this.hgv);
    }
    if (this.hgL) {
      localContentValues.put("hashdthumb", Integer.valueOf(this.eOY));
    }
    if (this.hgM) {
      if (this.offset >= this.gTY) {
        break label432;
      }
    }
    label432:
    for (int i = 0;; i = 1)
    {
      localContentValues.put("iscomplete", Integer.valueOf(i));
      if (this.hgN) {
        localContentValues.put("origImgMD5", this.hgq);
      }
      if (this.hgO) {
        localContentValues.put("compressType", Integer.valueOf(this.hgm));
      }
      if (this.hgP) {
        localContentValues.put("forwardType", Integer.valueOf(this.hgn));
      }
      if (this.hgQ) {
        localContentValues.put("hevcPath", this.hgo);
      }
      if (this.hgR) {
        localContentValues.put("sendImgType", Integer.valueOf(this.hgp));
      }
      AppMethodBeat.o(150553);
      return localContentValues;
    }
  }
  
  public final void kX(long paramLong)
  {
    if (this.drA != paramLong) {
      this.hgy = true;
    }
    this.drA = paramLong;
  }
  
  public final void mq(long paramLong)
  {
    this.hgs = paramLong;
    this.hgF = true;
  }
  
  public final void nW(int paramInt)
  {
    this.hgt = paramInt;
    this.hgH = true;
  }
  
  public final void nX(int paramInt)
  {
    this.gTY = paramInt;
    this.hgA = true;
  }
  
  public final void nY(int paramInt)
  {
    this.hgu = paramInt;
    this.hgI = true;
  }
  
  public final void nZ(int paramInt)
  {
    this.hgn = paramInt;
    this.hgP = true;
  }
  
  public final void oa(int paramInt)
  {
    this.hgp = paramInt;
    this.hgR = true;
  }
  
  public final void ob(int paramInt)
  {
    if (this.hgw != paramInt) {
      this.hgM = true;
    }
    this.hgw = paramInt;
  }
  
  public final void oc(int paramInt)
  {
    this.hgm = paramInt;
    this.hgO = true;
  }
  
  public final void setCreateTime(int paramInt)
  {
    this.hgr = paramInt;
    this.hgE = true;
  }
  
  public final void setLocalId(long paramLong)
  {
    this.deI = paramLong;
    this.hgx = true;
  }
  
  public final void setOffset(int paramInt)
  {
    int i = 0;
    AppMethodBeat.i(150550);
    if (this.offset != paramInt) {
      this.hgz = true;
    }
    this.offset = paramInt;
    ad.e("MicroMsg.Imgfo", "set offset : %d  id:%d total:%d", new Object[] { Integer.valueOf(paramInt), Long.valueOf(this.hgs), Integer.valueOf(this.gTY) });
    if (paramInt < this.gTY) {}
    for (paramInt = i;; paramInt = 1)
    {
      ob(paramInt);
      AppMethodBeat.o(150550);
      return;
    }
  }
  
  public final void setSource(int paramInt)
  {
    this.dep = paramInt;
    this.hgJ = true;
  }
  
  public final void setStatus(int paramInt)
  {
    this.status = paramInt;
    this.hgG = true;
  }
  
  public final void xY(String paramString)
  {
    this.hgq = paramString;
    this.hgN = true;
  }
  
  public final void xZ(String paramString)
  {
    this.hgj = paramString;
    this.hgB = true;
  }
  
  public final void ya(String paramString)
  {
    this.hgk = paramString;
    this.hgC = true;
  }
  
  public final void yb(String paramString)
  {
    this.hgl = paramString;
    this.hgD = true;
  }
  
  public final void yc(String paramString)
  {
    AppMethodBeat.i(150551);
    if (((this.hgv == null) && (paramString != null)) || ((this.hgv != null) && (!this.hgv.equals(paramString)))) {
      this.hgK = true;
    }
    this.hgv = paramString;
    AppMethodBeat.o(150551);
  }
  
  public final void yd(String paramString)
  {
    this.hgo = paramString;
    this.hgQ = true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.aw.e
 * JD-Core Version:    0.7.0.1
 */