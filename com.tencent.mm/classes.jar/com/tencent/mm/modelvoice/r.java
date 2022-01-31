package com.tencent.mm.modelvoice;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class r
{
  public int bsY;
  public String cDt;
  public long cFn;
  public String clientId;
  public long createTime;
  int dnr;
  String dns;
  public int fWa;
  public String fXq;
  public int fXs;
  public long fXv;
  public int fXy;
  int fXz;
  String fZr;
  int fZy;
  public String fileName;
  public int fsd;
  public int gaD;
  int gaE;
  long gaF;
  int gaG;
  public int status;
  
  public r()
  {
    AppMethodBeat.i(116613);
    this.bsY = -1;
    this.fZy = 0;
    this.fileName = "";
    this.cDt = "";
    this.clientId = "";
    this.cFn = 0L;
    this.fWa = 0;
    this.fXs = 0;
    this.fsd = 0;
    this.status = 0;
    this.createTime = 0L;
    this.fXv = 0L;
    this.gaD = 0;
    this.fXy = 0;
    this.fXq = "";
    this.fXz = 0;
    this.fZr = "";
    this.dns = "";
    this.dnr = 0;
    this.gaE = 0;
    this.gaF = 0L;
    this.gaG = 0;
    AppMethodBeat.o(116613);
  }
  
  public final boolean amv()
  {
    return (this.status == 5) || (this.status == 6);
  }
  
  public final boolean amw()
  {
    return ((this.status > 1) && (this.status <= 3)) || (this.status == 8);
  }
  
  public final void convertFrom(Cursor paramCursor)
  {
    AppMethodBeat.i(116612);
    this.fileName = paramCursor.getString(0);
    this.cDt = paramCursor.getString(1);
    this.cFn = paramCursor.getLong(2);
    this.fWa = paramCursor.getInt(3);
    this.fXs = paramCursor.getInt(4);
    this.fsd = paramCursor.getInt(5);
    this.status = paramCursor.getInt(6);
    this.createTime = paramCursor.getLong(7);
    this.fXv = paramCursor.getLong(8);
    this.clientId = paramCursor.getString(9);
    this.gaD = paramCursor.getInt(10);
    this.fXy = paramCursor.getInt(11);
    this.fXq = paramCursor.getString(12);
    this.fXz = paramCursor.getInt(13);
    this.fZr = paramCursor.getString(14);
    this.dns = paramCursor.getString(15);
    this.dnr = paramCursor.getInt(16);
    this.gaE = paramCursor.getInt(17);
    this.gaF = paramCursor.getLong(18);
    this.gaG = paramCursor.getInt(19);
    AppMethodBeat.o(116612);
  }
  
  public final ContentValues convertTo()
  {
    AppMethodBeat.i(116611);
    ContentValues localContentValues = new ContentValues();
    if ((this.bsY & 0x1) != 0) {
      localContentValues.put("FileName", this.fileName);
    }
    if ((this.bsY & 0x2) != 0) {
      localContentValues.put("User", this.cDt);
    }
    if ((this.bsY & 0x4) != 0) {
      localContentValues.put("MsgId", Long.valueOf(this.cFn));
    }
    if ((this.bsY & 0x8) != 0) {
      localContentValues.put("NetOffset", Integer.valueOf(this.fWa));
    }
    if ((this.bsY & 0x10) != 0) {
      localContentValues.put("FileNowSize", Integer.valueOf(this.fXs));
    }
    if ((this.bsY & 0x20) != 0) {
      localContentValues.put("TotalLen", Integer.valueOf(this.fsd));
    }
    if ((this.bsY & 0x40) != 0) {
      localContentValues.put("Status", Integer.valueOf(this.status));
    }
    if ((this.bsY & 0x80) != 0) {
      localContentValues.put("CreateTime", Long.valueOf(this.createTime));
    }
    if ((this.bsY & 0x100) != 0) {
      localContentValues.put("LastModifyTime", Long.valueOf(this.fXv));
    }
    if ((this.bsY & 0x200) != 0) {
      localContentValues.put("ClientId", this.clientId);
    }
    if ((this.bsY & 0x400) != 0) {
      localContentValues.put("VoiceLength", Integer.valueOf(this.gaD));
    }
    if ((this.bsY & 0x800) != 0) {
      localContentValues.put("MsgLocalId", Integer.valueOf(this.fXy));
    }
    if ((this.bsY & 0x1000) != 0) {
      localContentValues.put("Human", this.fXq);
    }
    if ((this.bsY & 0x2000) != 0) {
      localContentValues.put("reserved1", Integer.valueOf(this.fXz));
    }
    if ((this.bsY & 0x4000) != 0) {
      localContentValues.put("reserved2", this.fZr);
    }
    if ((this.bsY & 0x8000) != 0) {
      localContentValues.put("MsgSource", this.dns);
    }
    if ((this.bsY & 0x10000) != 0) {
      localContentValues.put("MsgFlag", Integer.valueOf(this.dnr));
    }
    if ((this.bsY & 0x20000) != 0) {
      localContentValues.put("MsgSeq", Integer.valueOf(this.gaE));
    }
    if ((this.bsY & 0x40000) != 0) {
      localContentValues.put("MasterBufId", Long.valueOf(this.gaF));
    }
    if ((this.bsY & 0x80000) != 0) {
      localContentValues.put("checksum", Integer.valueOf(this.gaG));
    }
    AppMethodBeat.o(116611);
    return localContentValues;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.modelvoice.r
 * JD-Core Version:    0.7.0.1
 */