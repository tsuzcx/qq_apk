package com.tencent.mm.modelvoice;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class r
{
  public int cUP;
  public String clientId;
  public long createTime;
  public long fNu;
  public String fPV;
  public String fileName;
  int hxx;
  String hxy;
  public int lAW;
  public int mgq;
  public String mhK;
  public int mhM;
  public long mhP;
  public int mhR;
  int mhS;
  String mjM;
  int mjT;
  public int mkW;
  int mkX;
  long mkY;
  int mkZ;
  public int mla;
  public int status;
  
  public r()
  {
    AppMethodBeat.i(148454);
    this.cUP = -1;
    this.mjT = 0;
    this.fileName = "";
    this.fPV = "";
    this.clientId = "";
    this.fNu = 0L;
    this.mgq = 0;
    this.mhM = 0;
    this.lAW = 0;
    this.status = 0;
    this.createTime = 0L;
    this.mhP = 0L;
    this.mkW = 0;
    this.mhR = 0;
    this.mhK = "";
    this.mhS = 0;
    this.mjM = "";
    this.hxy = "";
    this.hxx = 0;
    this.mkX = 0;
    this.mkY = 0L;
    this.mkZ = 0;
    this.mla = 0;
    AppMethodBeat.o(148454);
  }
  
  public final boolean brD()
  {
    return (this.status == 5) || (this.status == 6);
  }
  
  public final boolean brE()
  {
    return ((this.status > 1) && (this.status <= 3)) || (this.status == 8);
  }
  
  public final boolean brF()
  {
    return (this.mla & 0x1) != 0;
  }
  
  public final void convertFrom(Cursor paramCursor)
  {
    AppMethodBeat.i(148453);
    this.fileName = paramCursor.getString(0);
    this.fPV = paramCursor.getString(1);
    this.fNu = paramCursor.getLong(2);
    this.mgq = paramCursor.getInt(3);
    this.mhM = paramCursor.getInt(4);
    this.lAW = paramCursor.getInt(5);
    this.status = paramCursor.getInt(6);
    this.createTime = paramCursor.getLong(7);
    this.mhP = paramCursor.getLong(8);
    this.clientId = paramCursor.getString(9);
    this.mkW = paramCursor.getInt(10);
    this.mhR = paramCursor.getInt(11);
    this.mhK = paramCursor.getString(12);
    this.mhS = paramCursor.getInt(13);
    this.mjM = paramCursor.getString(14);
    this.hxy = paramCursor.getString(15);
    this.hxx = paramCursor.getInt(16);
    this.mkX = paramCursor.getInt(17);
    this.mkY = paramCursor.getLong(18);
    this.mkZ = paramCursor.getInt(19);
    this.mla = paramCursor.getInt(20);
    AppMethodBeat.o(148453);
  }
  
  public final ContentValues convertTo()
  {
    AppMethodBeat.i(148452);
    ContentValues localContentValues = new ContentValues();
    if ((this.cUP & 0x1) != 0) {
      localContentValues.put("FileName", this.fileName);
    }
    if ((this.cUP & 0x2) != 0) {
      localContentValues.put("User", this.fPV);
    }
    if ((this.cUP & 0x4) != 0) {
      localContentValues.put("MsgId", Long.valueOf(this.fNu));
    }
    if ((this.cUP & 0x8) != 0) {
      localContentValues.put("NetOffset", Integer.valueOf(this.mgq));
    }
    if ((this.cUP & 0x10) != 0) {
      localContentValues.put("FileNowSize", Integer.valueOf(this.mhM));
    }
    if ((this.cUP & 0x20) != 0) {
      localContentValues.put("TotalLen", Integer.valueOf(this.lAW));
    }
    if ((this.cUP & 0x40) != 0) {
      localContentValues.put("Status", Integer.valueOf(this.status));
    }
    if ((this.cUP & 0x80) != 0) {
      localContentValues.put("CreateTime", Long.valueOf(this.createTime));
    }
    if ((this.cUP & 0x100) != 0) {
      localContentValues.put("LastModifyTime", Long.valueOf(this.mhP));
    }
    if ((this.cUP & 0x200) != 0) {
      localContentValues.put("ClientId", this.clientId);
    }
    if ((this.cUP & 0x400) != 0) {
      localContentValues.put("VoiceLength", Integer.valueOf(this.mkW));
    }
    if ((this.cUP & 0x800) != 0) {
      localContentValues.put("MsgLocalId", Integer.valueOf(this.mhR));
    }
    if ((this.cUP & 0x1000) != 0) {
      localContentValues.put("Human", this.mhK);
    }
    if ((this.cUP & 0x2000) != 0) {
      localContentValues.put("reserved1", Integer.valueOf(this.mhS));
    }
    if ((this.cUP & 0x4000) != 0) {
      localContentValues.put("reserved2", this.mjM);
    }
    if ((this.cUP & 0x8000) != 0) {
      localContentValues.put("MsgSource", this.hxy);
    }
    if ((this.cUP & 0x10000) != 0) {
      localContentValues.put("MsgFlag", Integer.valueOf(this.hxx));
    }
    if ((this.cUP & 0x20000) != 0) {
      localContentValues.put("MsgSeq", Integer.valueOf(this.mkX));
    }
    if ((this.cUP & 0x40000) != 0) {
      localContentValues.put("MasterBufId", Long.valueOf(this.mkY));
    }
    if ((this.cUP & 0x80000) != 0) {
      localContentValues.put("checksum", Integer.valueOf(this.mkZ));
    }
    if ((this.cUP & 0x100000) != 0) {
      localContentValues.put("VoiceFlag", Integer.valueOf(this.mla));
    }
    AppMethodBeat.o(148452);
    return localContentValues;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.modelvoice.r
 * JD-Core Version:    0.7.0.1
 */