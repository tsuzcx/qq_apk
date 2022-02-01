package com.tencent.mm.modelvoice;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class r
{
  public String clientId;
  public long createTime;
  public long dpl;
  public String drG;
  public int drx;
  int euk;
  String eul;
  public String fileName;
  public int hZn;
  public int hux;
  public String iaC;
  public int iaE;
  public long iaH;
  public int iaJ;
  int iaK;
  String icF;
  int icM;
  public int idR;
  int idS;
  long idT;
  int idU;
  public int status;
  
  public r()
  {
    AppMethodBeat.i(148454);
    this.drx = -1;
    this.icM = 0;
    this.fileName = "";
    this.drG = "";
    this.clientId = "";
    this.dpl = 0L;
    this.hZn = 0;
    this.iaE = 0;
    this.hux = 0;
    this.status = 0;
    this.createTime = 0L;
    this.iaH = 0L;
    this.idR = 0;
    this.iaJ = 0;
    this.iaC = "";
    this.iaK = 0;
    this.icF = "";
    this.eul = "";
    this.euk = 0;
    this.idS = 0;
    this.idT = 0L;
    this.idU = 0;
    AppMethodBeat.o(148454);
  }
  
  public final boolean aKs()
  {
    return (this.status == 5) || (this.status == 6);
  }
  
  public final boolean aKt()
  {
    return ((this.status > 1) && (this.status <= 3)) || (this.status == 8);
  }
  
  public final void convertFrom(Cursor paramCursor)
  {
    AppMethodBeat.i(148453);
    this.fileName = paramCursor.getString(0);
    this.drG = paramCursor.getString(1);
    this.dpl = paramCursor.getLong(2);
    this.hZn = paramCursor.getInt(3);
    this.iaE = paramCursor.getInt(4);
    this.hux = paramCursor.getInt(5);
    this.status = paramCursor.getInt(6);
    this.createTime = paramCursor.getLong(7);
    this.iaH = paramCursor.getLong(8);
    this.clientId = paramCursor.getString(9);
    this.idR = paramCursor.getInt(10);
    this.iaJ = paramCursor.getInt(11);
    this.iaC = paramCursor.getString(12);
    this.iaK = paramCursor.getInt(13);
    this.icF = paramCursor.getString(14);
    this.eul = paramCursor.getString(15);
    this.euk = paramCursor.getInt(16);
    this.idS = paramCursor.getInt(17);
    this.idT = paramCursor.getLong(18);
    this.idU = paramCursor.getInt(19);
    AppMethodBeat.o(148453);
  }
  
  public final ContentValues convertTo()
  {
    AppMethodBeat.i(148452);
    ContentValues localContentValues = new ContentValues();
    if ((this.drx & 0x1) != 0) {
      localContentValues.put("FileName", this.fileName);
    }
    if ((this.drx & 0x2) != 0) {
      localContentValues.put("User", this.drG);
    }
    if ((this.drx & 0x4) != 0) {
      localContentValues.put("MsgId", Long.valueOf(this.dpl));
    }
    if ((this.drx & 0x8) != 0) {
      localContentValues.put("NetOffset", Integer.valueOf(this.hZn));
    }
    if ((this.drx & 0x10) != 0) {
      localContentValues.put("FileNowSize", Integer.valueOf(this.iaE));
    }
    if ((this.drx & 0x20) != 0) {
      localContentValues.put("TotalLen", Integer.valueOf(this.hux));
    }
    if ((this.drx & 0x40) != 0) {
      localContentValues.put("Status", Integer.valueOf(this.status));
    }
    if ((this.drx & 0x80) != 0) {
      localContentValues.put("CreateTime", Long.valueOf(this.createTime));
    }
    if ((this.drx & 0x100) != 0) {
      localContentValues.put("LastModifyTime", Long.valueOf(this.iaH));
    }
    if ((this.drx & 0x200) != 0) {
      localContentValues.put("ClientId", this.clientId);
    }
    if ((this.drx & 0x400) != 0) {
      localContentValues.put("VoiceLength", Integer.valueOf(this.idR));
    }
    if ((this.drx & 0x800) != 0) {
      localContentValues.put("MsgLocalId", Integer.valueOf(this.iaJ));
    }
    if ((this.drx & 0x1000) != 0) {
      localContentValues.put("Human", this.iaC);
    }
    if ((this.drx & 0x2000) != 0) {
      localContentValues.put("reserved1", Integer.valueOf(this.iaK));
    }
    if ((this.drx & 0x4000) != 0) {
      localContentValues.put("reserved2", this.icF);
    }
    if ((this.drx & 0x8000) != 0) {
      localContentValues.put("MsgSource", this.eul);
    }
    if ((this.drx & 0x10000) != 0) {
      localContentValues.put("MsgFlag", Integer.valueOf(this.euk));
    }
    if ((this.drx & 0x20000) != 0) {
      localContentValues.put("MsgSeq", Integer.valueOf(this.idS));
    }
    if ((this.drx & 0x40000) != 0) {
      localContentValues.put("MasterBufId", Long.valueOf(this.idT));
    }
    if ((this.drx & 0x80000) != 0) {
      localContentValues.put("checksum", Integer.valueOf(this.idU));
    }
    AppMethodBeat.o(148452);
    return localContentValues;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.modelvoice.r
 * JD-Core Version:    0.7.0.1
 */