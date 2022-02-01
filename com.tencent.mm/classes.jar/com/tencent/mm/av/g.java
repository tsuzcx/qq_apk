package com.tencent.mm.av;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ae;

public final class g
{
  public long dCd;
  public int dEu = -2;
  public long doE;
  int doj;
  public int fms = 0;
  public int hPI;
  public String icA = "";
  int icB = 1;
  private boolean icC;
  private boolean icD;
  private boolean icE;
  private boolean icF;
  private boolean icG;
  private boolean icH;
  private boolean icI;
  private boolean icJ;
  private boolean icK;
  private boolean icL;
  private boolean icM;
  private boolean icN;
  private boolean icO;
  private boolean icP;
  private boolean icQ;
  private boolean icR;
  private boolean icS;
  private boolean icT;
  private boolean icU;
  private boolean icV;
  private boolean icW;
  public String ico = "";
  public String icp = "";
  public String icq = "";
  public int icr;
  public int ics;
  public String ict = "";
  int icu = 0;
  private String icv = "";
  public int icw;
  public long icx;
  int icy;
  public int icz = 0;
  public int offset;
  public int status;
  
  public final void FE(String paramString)
  {
    this.icv = paramString;
    this.icS = true;
  }
  
  public final void FF(String paramString)
  {
    this.ico = paramString;
    this.icG = true;
  }
  
  public final void FG(String paramString)
  {
    this.icp = paramString;
    this.icH = true;
  }
  
  public final void FH(String paramString)
  {
    this.icq = paramString;
    this.icI = true;
  }
  
  public final void FI(String paramString)
  {
    AppMethodBeat.i(150551);
    if (((this.icA == null) && (paramString != null)) || ((this.icA != null) && (!this.icA.equals(paramString)))) {
      this.icP = true;
    }
    this.icA = paramString;
    AppMethodBeat.o(150551);
  }
  
  public final void FJ(String paramString)
  {
    this.ict = paramString;
    this.icV = true;
  }
  
  public final boolean aIA()
  {
    return (this.hPI != 0) && (this.hPI == this.offset);
  }
  
  public final boolean aIB()
  {
    return this.icz > 0;
  }
  
  public final void aIC()
  {
    this.fms = 1;
    this.icQ = true;
  }
  
  public final void aID()
  {
    this.icC = false;
    this.icD = false;
    this.icE = false;
    this.icF = false;
    this.icG = false;
    this.icH = false;
    this.icI = false;
    this.icJ = false;
    this.icK = false;
    this.icL = false;
    this.icM = false;
    this.icN = false;
    this.icO = false;
    this.icP = false;
    this.icQ = false;
    this.icR = false;
    this.icS = false;
    this.icT = false;
    this.icU = false;
    this.icV = false;
    this.icW = false;
  }
  
  public final int aIw()
  {
    return this.hPI;
  }
  
  public final String aIx()
  {
    return this.ico;
  }
  
  public final String aIy()
  {
    return this.icp;
  }
  
  public final String aIz()
  {
    return this.icq;
  }
  
  public final void convertFrom(Cursor paramCursor)
  {
    AppMethodBeat.i(150552);
    this.doE = paramCursor.getInt(0);
    this.dCd = paramCursor.getLong(1);
    this.offset = paramCursor.getInt(2);
    this.hPI = paramCursor.getInt(3);
    this.ico = paramCursor.getString(4);
    this.icq = paramCursor.getString(5);
    this.icw = paramCursor.getInt(6);
    this.icx = paramCursor.getInt(7);
    this.status = paramCursor.getInt(8);
    this.icy = paramCursor.getInt(9);
    this.icz = paramCursor.getInt(10);
    this.doj = paramCursor.getInt(11);
    this.icA = paramCursor.getString(12);
    this.fms = paramCursor.getInt(14);
    this.icB = paramCursor.getInt(15);
    this.icv = paramCursor.getString(16);
    this.icr = paramCursor.getInt(17);
    this.icp = paramCursor.getString(18);
    this.ics = paramCursor.getInt(19);
    this.ict = paramCursor.getString(20);
    this.icu = paramCursor.getInt(21);
    AppMethodBeat.o(150552);
  }
  
  public final ContentValues convertTo()
  {
    AppMethodBeat.i(150553);
    ContentValues localContentValues = new ContentValues();
    if (this.icC) {
      localContentValues.put("id", Long.valueOf(this.doE));
    }
    if (this.icD) {
      localContentValues.put("msgSvrId", Long.valueOf(this.dCd));
    }
    if (this.icE) {
      localContentValues.put("offset", Integer.valueOf(this.offset));
    }
    if (this.icF) {
      localContentValues.put("totalLen", Integer.valueOf(this.hPI));
    }
    if (this.icG) {
      localContentValues.put("bigImgPath", this.ico);
    }
    if (this.icH) {
      localContentValues.put("midImgPath", this.icp);
    }
    if (this.icI) {
      localContentValues.put("thumbImgPath", this.icq);
    }
    if (this.icJ) {
      localContentValues.put("createtime", Integer.valueOf(this.icw));
    }
    if (this.icK) {
      localContentValues.put("msglocalid", Long.valueOf(this.icx));
    }
    if (this.icL) {
      localContentValues.put("status", Integer.valueOf(this.status));
    }
    if (this.icM) {
      localContentValues.put("nettimes", Integer.valueOf(this.icy));
    }
    if (this.icN) {
      localContentValues.put("reserved1", Integer.valueOf(this.icz));
    }
    if (this.icO) {
      localContentValues.put("reserved2", Integer.valueOf(this.doj));
    }
    if (this.icP) {
      localContentValues.put("reserved3", this.icA);
    }
    if (this.icQ) {
      localContentValues.put("hashdthumb", Integer.valueOf(this.fms));
    }
    if (this.icR) {
      if (this.offset >= this.hPI) {
        break label436;
      }
    }
    label436:
    for (int i = 0;; i = 1)
    {
      localContentValues.put("iscomplete", Integer.valueOf(i));
      if (this.icS) {
        localContentValues.put("origImgMD5", this.icv);
      }
      if (this.icT) {
        localContentValues.put("compressType", Integer.valueOf(this.icr));
      }
      if (this.icU) {
        localContentValues.put("forwardType", Integer.valueOf(this.ics));
      }
      if (this.icV) {
        localContentValues.put("hevcPath", this.ict);
      }
      if (this.icW) {
        localContentValues.put("sendImgType", Integer.valueOf(this.icu));
      }
      AppMethodBeat.o(150553);
      return localContentValues;
    }
  }
  
  public final long getLocalId()
  {
    return this.doE;
  }
  
  public final void pp(int paramInt)
  {
    this.icy = paramInt;
    this.icM = true;
  }
  
  public final void pq(int paramInt)
  {
    this.hPI = paramInt;
    this.icF = true;
  }
  
  public final void pr(int paramInt)
  {
    this.icz = paramInt;
    this.icN = true;
  }
  
  public final void ps(int paramInt)
  {
    this.ics = paramInt;
    this.icU = true;
  }
  
  public final void pt(int paramInt)
  {
    this.icu = paramInt;
    this.icW = true;
  }
  
  public final void pu(int paramInt)
  {
    if (this.icB != paramInt) {
      this.icR = true;
    }
    this.icB = paramInt;
  }
  
  public final void pv(int paramInt)
  {
    this.icr = paramInt;
    this.icT = true;
  }
  
  public final void qM(long paramLong)
  {
    if (this.dCd != paramLong) {
      this.icD = true;
    }
    this.dCd = paramLong;
  }
  
  public final void setCreateTime(int paramInt)
  {
    this.icw = paramInt;
    this.icJ = true;
  }
  
  public final void setLocalId(long paramLong)
  {
    this.doE = paramLong;
    this.icC = true;
  }
  
  public final void setOffset(int paramInt)
  {
    int i = 0;
    AppMethodBeat.i(150550);
    if (this.offset != paramInt) {
      this.icE = true;
    }
    this.offset = paramInt;
    ae.e("MicroMsg.Imgfo", "set offset : %d  id:%d total:%d", new Object[] { Integer.valueOf(paramInt), Long.valueOf(this.icx), Integer.valueOf(this.hPI) });
    if (paramInt < this.hPI) {}
    for (paramInt = i;; paramInt = 1)
    {
      pu(paramInt);
      AppMethodBeat.o(150550);
      return;
    }
  }
  
  public final void setSource(int paramInt)
  {
    this.doj = paramInt;
    this.icO = true;
  }
  
  public final void setStatus(int paramInt)
  {
    this.status = paramInt;
    this.icL = true;
  }
  
  public final void sq(long paramLong)
  {
    this.icx = paramLong;
    this.icK = true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.av.g
 * JD-Core Version:    0.7.0.1
 */