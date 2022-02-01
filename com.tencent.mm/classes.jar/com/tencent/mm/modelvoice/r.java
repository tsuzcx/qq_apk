package com.tencent.mm.modelvoice;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class r
{
  public String clientId;
  public long createTime;
  public long dCd;
  public String dED;
  public int dEu;
  int eNc;
  String eNd;
  public String fileName;
  public int hPI;
  public int iAf;
  int iAg;
  long iAh;
  int iAi;
  public int ivD;
  public String iwS;
  public int iwU;
  public long iwX;
  public int iwZ;
  int ixa;
  String iyU;
  int izb;
  public int status;
  
  public r()
  {
    AppMethodBeat.i(148454);
    this.dEu = -1;
    this.izb = 0;
    this.fileName = "";
    this.dED = "";
    this.clientId = "";
    this.dCd = 0L;
    this.ivD = 0;
    this.iwU = 0;
    this.hPI = 0;
    this.status = 0;
    this.createTime = 0L;
    this.iwX = 0L;
    this.iAf = 0;
    this.iwZ = 0;
    this.iwS = "";
    this.ixa = 0;
    this.iyU = "";
    this.eNd = "";
    this.eNc = 0;
    this.iAg = 0;
    this.iAh = 0L;
    this.iAi = 0;
    AppMethodBeat.o(148454);
  }
  
  public final boolean aNZ()
  {
    return (this.status == 5) || (this.status == 6);
  }
  
  public final boolean aOa()
  {
    return ((this.status > 1) && (this.status <= 3)) || (this.status == 8);
  }
  
  public final void convertFrom(Cursor paramCursor)
  {
    AppMethodBeat.i(148453);
    this.fileName = paramCursor.getString(0);
    this.dED = paramCursor.getString(1);
    this.dCd = paramCursor.getLong(2);
    this.ivD = paramCursor.getInt(3);
    this.iwU = paramCursor.getInt(4);
    this.hPI = paramCursor.getInt(5);
    this.status = paramCursor.getInt(6);
    this.createTime = paramCursor.getLong(7);
    this.iwX = paramCursor.getLong(8);
    this.clientId = paramCursor.getString(9);
    this.iAf = paramCursor.getInt(10);
    this.iwZ = paramCursor.getInt(11);
    this.iwS = paramCursor.getString(12);
    this.ixa = paramCursor.getInt(13);
    this.iyU = paramCursor.getString(14);
    this.eNd = paramCursor.getString(15);
    this.eNc = paramCursor.getInt(16);
    this.iAg = paramCursor.getInt(17);
    this.iAh = paramCursor.getLong(18);
    this.iAi = paramCursor.getInt(19);
    AppMethodBeat.o(148453);
  }
  
  public final ContentValues convertTo()
  {
    AppMethodBeat.i(148452);
    ContentValues localContentValues = new ContentValues();
    if ((this.dEu & 0x1) != 0) {
      localContentValues.put("FileName", this.fileName);
    }
    if ((this.dEu & 0x2) != 0) {
      localContentValues.put("User", this.dED);
    }
    if ((this.dEu & 0x4) != 0) {
      localContentValues.put("MsgId", Long.valueOf(this.dCd));
    }
    if ((this.dEu & 0x8) != 0) {
      localContentValues.put("NetOffset", Integer.valueOf(this.ivD));
    }
    if ((this.dEu & 0x10) != 0) {
      localContentValues.put("FileNowSize", Integer.valueOf(this.iwU));
    }
    if ((this.dEu & 0x20) != 0) {
      localContentValues.put("TotalLen", Integer.valueOf(this.hPI));
    }
    if ((this.dEu & 0x40) != 0) {
      localContentValues.put("Status", Integer.valueOf(this.status));
    }
    if ((this.dEu & 0x80) != 0) {
      localContentValues.put("CreateTime", Long.valueOf(this.createTime));
    }
    if ((this.dEu & 0x100) != 0) {
      localContentValues.put("LastModifyTime", Long.valueOf(this.iwX));
    }
    if ((this.dEu & 0x200) != 0) {
      localContentValues.put("ClientId", this.clientId);
    }
    if ((this.dEu & 0x400) != 0) {
      localContentValues.put("VoiceLength", Integer.valueOf(this.iAf));
    }
    if ((this.dEu & 0x800) != 0) {
      localContentValues.put("MsgLocalId", Integer.valueOf(this.iwZ));
    }
    if ((this.dEu & 0x1000) != 0) {
      localContentValues.put("Human", this.iwS);
    }
    if ((this.dEu & 0x2000) != 0) {
      localContentValues.put("reserved1", Integer.valueOf(this.ixa));
    }
    if ((this.dEu & 0x4000) != 0) {
      localContentValues.put("reserved2", this.iyU);
    }
    if ((this.dEu & 0x8000) != 0) {
      localContentValues.put("MsgSource", this.eNd);
    }
    if ((this.dEu & 0x10000) != 0) {
      localContentValues.put("MsgFlag", Integer.valueOf(this.eNc));
    }
    if ((this.dEu & 0x20000) != 0) {
      localContentValues.put("MsgSeq", Integer.valueOf(this.iAg));
    }
    if ((this.dEu & 0x40000) != 0) {
      localContentValues.put("MasterBufId", Long.valueOf(this.iAh));
    }
    if ((this.dEu & 0x80000) != 0) {
      localContentValues.put("checksum", Integer.valueOf(this.iAi));
    }
    AppMethodBeat.o(148452);
    return localContentValues;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.modelvoice.r
 * JD-Core Version:    0.7.0.1
 */