package com.tencent.mm.modelvoice;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class r
{
  public int cSx;
  public String clientId;
  public long createTime;
  public long dTS;
  public String dWq;
  public String fileName;
  int fqJ;
  String fqK;
  public int iKP;
  public int jqP;
  public String jsh;
  public int jsj;
  public long jsm;
  public int jso;
  int jsp;
  String jui;
  int jup;
  public int jvt;
  int jvu;
  long jvv;
  int jvw;
  public int jvx;
  public int status;
  
  public r()
  {
    AppMethodBeat.i(148454);
    this.cSx = -1;
    this.jup = 0;
    this.fileName = "";
    this.dWq = "";
    this.clientId = "";
    this.dTS = 0L;
    this.jqP = 0;
    this.jsj = 0;
    this.iKP = 0;
    this.status = 0;
    this.createTime = 0L;
    this.jsm = 0L;
    this.jvt = 0;
    this.jso = 0;
    this.jsh = "";
    this.jsp = 0;
    this.jui = "";
    this.fqK = "";
    this.fqJ = 0;
    this.jvu = 0;
    this.jvv = 0L;
    this.jvw = 0;
    this.jvx = 0;
    AppMethodBeat.o(148454);
  }
  
  public final boolean bif()
  {
    return (this.status == 5) || (this.status == 6);
  }
  
  public final boolean big()
  {
    return ((this.status > 1) && (this.status <= 3)) || (this.status == 8);
  }
  
  public final boolean bih()
  {
    return (this.jvx & 0x1) != 0;
  }
  
  public final void convertFrom(Cursor paramCursor)
  {
    AppMethodBeat.i(148453);
    this.fileName = paramCursor.getString(0);
    this.dWq = paramCursor.getString(1);
    this.dTS = paramCursor.getLong(2);
    this.jqP = paramCursor.getInt(3);
    this.jsj = paramCursor.getInt(4);
    this.iKP = paramCursor.getInt(5);
    this.status = paramCursor.getInt(6);
    this.createTime = paramCursor.getLong(7);
    this.jsm = paramCursor.getLong(8);
    this.clientId = paramCursor.getString(9);
    this.jvt = paramCursor.getInt(10);
    this.jso = paramCursor.getInt(11);
    this.jsh = paramCursor.getString(12);
    this.jsp = paramCursor.getInt(13);
    this.jui = paramCursor.getString(14);
    this.fqK = paramCursor.getString(15);
    this.fqJ = paramCursor.getInt(16);
    this.jvu = paramCursor.getInt(17);
    this.jvv = paramCursor.getLong(18);
    this.jvw = paramCursor.getInt(19);
    this.jvx = paramCursor.getInt(20);
    AppMethodBeat.o(148453);
  }
  
  public final ContentValues convertTo()
  {
    AppMethodBeat.i(148452);
    ContentValues localContentValues = new ContentValues();
    if ((this.cSx & 0x1) != 0) {
      localContentValues.put("FileName", this.fileName);
    }
    if ((this.cSx & 0x2) != 0) {
      localContentValues.put("User", this.dWq);
    }
    if ((this.cSx & 0x4) != 0) {
      localContentValues.put("MsgId", Long.valueOf(this.dTS));
    }
    if ((this.cSx & 0x8) != 0) {
      localContentValues.put("NetOffset", Integer.valueOf(this.jqP));
    }
    if ((this.cSx & 0x10) != 0) {
      localContentValues.put("FileNowSize", Integer.valueOf(this.jsj));
    }
    if ((this.cSx & 0x20) != 0) {
      localContentValues.put("TotalLen", Integer.valueOf(this.iKP));
    }
    if ((this.cSx & 0x40) != 0) {
      localContentValues.put("Status", Integer.valueOf(this.status));
    }
    if ((this.cSx & 0x80) != 0) {
      localContentValues.put("CreateTime", Long.valueOf(this.createTime));
    }
    if ((this.cSx & 0x100) != 0) {
      localContentValues.put("LastModifyTime", Long.valueOf(this.jsm));
    }
    if ((this.cSx & 0x200) != 0) {
      localContentValues.put("ClientId", this.clientId);
    }
    if ((this.cSx & 0x400) != 0) {
      localContentValues.put("VoiceLength", Integer.valueOf(this.jvt));
    }
    if ((this.cSx & 0x800) != 0) {
      localContentValues.put("MsgLocalId", Integer.valueOf(this.jso));
    }
    if ((this.cSx & 0x1000) != 0) {
      localContentValues.put("Human", this.jsh);
    }
    if ((this.cSx & 0x2000) != 0) {
      localContentValues.put("reserved1", Integer.valueOf(this.jsp));
    }
    if ((this.cSx & 0x4000) != 0) {
      localContentValues.put("reserved2", this.jui);
    }
    if ((this.cSx & 0x8000) != 0) {
      localContentValues.put("MsgSource", this.fqK);
    }
    if ((this.cSx & 0x10000) != 0) {
      localContentValues.put("MsgFlag", Integer.valueOf(this.fqJ));
    }
    if ((this.cSx & 0x20000) != 0) {
      localContentValues.put("MsgSeq", Integer.valueOf(this.jvu));
    }
    if ((this.cSx & 0x40000) != 0) {
      localContentValues.put("MasterBufId", Long.valueOf(this.jvv));
    }
    if ((this.cSx & 0x80000) != 0) {
      localContentValues.put("checksum", Integer.valueOf(this.jvw));
    }
    if ((this.cSx & 0x100000) != 0) {
      localContentValues.put("VoiceFlag", Integer.valueOf(this.jvx));
    }
    AppMethodBeat.o(148452);
    return localContentValues;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.modelvoice.r
 * JD-Core Version:    0.7.0.1
 */