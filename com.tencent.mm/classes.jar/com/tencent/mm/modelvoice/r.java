package com.tencent.mm.modelvoice;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class r
{
  public String clientId;
  public long createTime;
  public long drA;
  public int dtM;
  public String dtV;
  int esg;
  String esh;
  public String fileName;
  public int gTY;
  public String hAb;
  public int hAd;
  public long hAg;
  public int hAi;
  int hAj;
  String hCe;
  int hCl;
  public int hDp;
  int hDq;
  long hDr;
  int hDs;
  public int hyM;
  public int status;
  
  public r()
  {
    AppMethodBeat.i(148454);
    this.dtM = -1;
    this.hCl = 0;
    this.fileName = "";
    this.dtV = "";
    this.clientId = "";
    this.drA = 0L;
    this.hyM = 0;
    this.hAd = 0;
    this.gTY = 0;
    this.status = 0;
    this.createTime = 0L;
    this.hAg = 0L;
    this.hDp = 0;
    this.hAi = 0;
    this.hAb = "";
    this.hAj = 0;
    this.hCe = "";
    this.esh = "";
    this.esg = 0;
    this.hDq = 0;
    this.hDr = 0L;
    this.hDs = 0;
    AppMethodBeat.o(148454);
  }
  
  public final boolean aDB()
  {
    return (this.status == 5) || (this.status == 6);
  }
  
  public final boolean aDC()
  {
    return ((this.status > 1) && (this.status <= 3)) || (this.status == 8);
  }
  
  public final void convertFrom(Cursor paramCursor)
  {
    AppMethodBeat.i(148453);
    this.fileName = paramCursor.getString(0);
    this.dtV = paramCursor.getString(1);
    this.drA = paramCursor.getLong(2);
    this.hyM = paramCursor.getInt(3);
    this.hAd = paramCursor.getInt(4);
    this.gTY = paramCursor.getInt(5);
    this.status = paramCursor.getInt(6);
    this.createTime = paramCursor.getLong(7);
    this.hAg = paramCursor.getLong(8);
    this.clientId = paramCursor.getString(9);
    this.hDp = paramCursor.getInt(10);
    this.hAi = paramCursor.getInt(11);
    this.hAb = paramCursor.getString(12);
    this.hAj = paramCursor.getInt(13);
    this.hCe = paramCursor.getString(14);
    this.esh = paramCursor.getString(15);
    this.esg = paramCursor.getInt(16);
    this.hDq = paramCursor.getInt(17);
    this.hDr = paramCursor.getLong(18);
    this.hDs = paramCursor.getInt(19);
    AppMethodBeat.o(148453);
  }
  
  public final ContentValues convertTo()
  {
    AppMethodBeat.i(148452);
    ContentValues localContentValues = new ContentValues();
    if ((this.dtM & 0x1) != 0) {
      localContentValues.put("FileName", this.fileName);
    }
    if ((this.dtM & 0x2) != 0) {
      localContentValues.put("User", this.dtV);
    }
    if ((this.dtM & 0x4) != 0) {
      localContentValues.put("MsgId", Long.valueOf(this.drA));
    }
    if ((this.dtM & 0x8) != 0) {
      localContentValues.put("NetOffset", Integer.valueOf(this.hyM));
    }
    if ((this.dtM & 0x10) != 0) {
      localContentValues.put("FileNowSize", Integer.valueOf(this.hAd));
    }
    if ((this.dtM & 0x20) != 0) {
      localContentValues.put("TotalLen", Integer.valueOf(this.gTY));
    }
    if ((this.dtM & 0x40) != 0) {
      localContentValues.put("Status", Integer.valueOf(this.status));
    }
    if ((this.dtM & 0x80) != 0) {
      localContentValues.put("CreateTime", Long.valueOf(this.createTime));
    }
    if ((this.dtM & 0x100) != 0) {
      localContentValues.put("LastModifyTime", Long.valueOf(this.hAg));
    }
    if ((this.dtM & 0x200) != 0) {
      localContentValues.put("ClientId", this.clientId);
    }
    if ((this.dtM & 0x400) != 0) {
      localContentValues.put("VoiceLength", Integer.valueOf(this.hDp));
    }
    if ((this.dtM & 0x800) != 0) {
      localContentValues.put("MsgLocalId", Integer.valueOf(this.hAi));
    }
    if ((this.dtM & 0x1000) != 0) {
      localContentValues.put("Human", this.hAb);
    }
    if ((this.dtM & 0x2000) != 0) {
      localContentValues.put("reserved1", Integer.valueOf(this.hAj));
    }
    if ((this.dtM & 0x4000) != 0) {
      localContentValues.put("reserved2", this.hCe);
    }
    if ((this.dtM & 0x8000) != 0) {
      localContentValues.put("MsgSource", this.esh);
    }
    if ((this.dtM & 0x10000) != 0) {
      localContentValues.put("MsgFlag", Integer.valueOf(this.esg));
    }
    if ((this.dtM & 0x20000) != 0) {
      localContentValues.put("MsgSeq", Integer.valueOf(this.hDq));
    }
    if ((this.dtM & 0x40000) != 0) {
      localContentValues.put("MasterBufId", Long.valueOf(this.hDr));
    }
    if ((this.dtM & 0x80000) != 0) {
      localContentValues.put("checksum", Integer.valueOf(this.hDs));
    }
    AppMethodBeat.o(148452);
    return localContentValues;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.modelvoice.r
 * JD-Core Version:    0.7.0.1
 */