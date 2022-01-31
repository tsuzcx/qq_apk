package com.tencent.mm.modelvoice;

import android.content.ContentValues;
import android.database.Cursor;

public final class p
{
  public String bVI = "";
  public long bXr = 0L;
  public int bcw = -1;
  public String clientId = "";
  public long createTime = 0L;
  int czq = 0;
  String czr = "";
  public int eGk = 0;
  public String eHA = "";
  public int eHC = 0;
  public long eHF = 0L;
  public int eHI = 0;
  int eHJ = 0;
  String eJP = "";
  int eJW = 0;
  public int eKW = 0;
  int eKX = 0;
  long eKY = 0L;
  int eKZ = 0;
  public int ebK = 0;
  public String fileName = "";
  public int status = 0;
  
  public final boolean Tj()
  {
    return (this.status == 5) || (this.status == 6);
  }
  
  public final boolean Tk()
  {
    return ((this.status > 1) && (this.status <= 3)) || (this.status == 8);
  }
  
  public final void d(Cursor paramCursor)
  {
    this.fileName = paramCursor.getString(0);
    this.bVI = paramCursor.getString(1);
    this.bXr = paramCursor.getLong(2);
    this.eGk = paramCursor.getInt(3);
    this.eHC = paramCursor.getInt(4);
    this.ebK = paramCursor.getInt(5);
    this.status = paramCursor.getInt(6);
    this.createTime = paramCursor.getLong(7);
    this.eHF = paramCursor.getLong(8);
    this.clientId = paramCursor.getString(9);
    this.eKW = paramCursor.getInt(10);
    this.eHI = paramCursor.getInt(11);
    this.eHA = paramCursor.getString(12);
    this.eHJ = paramCursor.getInt(13);
    this.eJP = paramCursor.getString(14);
    this.czr = paramCursor.getString(15);
    this.czq = paramCursor.getInt(16);
    this.eKX = paramCursor.getInt(17);
    this.eKY = paramCursor.getLong(18);
    this.eKZ = paramCursor.getInt(19);
  }
  
  public final ContentValues vf()
  {
    ContentValues localContentValues = new ContentValues();
    if ((this.bcw & 0x1) != 0) {
      localContentValues.put("FileName", this.fileName);
    }
    if ((this.bcw & 0x2) != 0) {
      localContentValues.put("User", this.bVI);
    }
    if ((this.bcw & 0x4) != 0) {
      localContentValues.put("MsgId", Long.valueOf(this.bXr));
    }
    if ((this.bcw & 0x8) != 0) {
      localContentValues.put("NetOffset", Integer.valueOf(this.eGk));
    }
    if ((this.bcw & 0x10) != 0) {
      localContentValues.put("FileNowSize", Integer.valueOf(this.eHC));
    }
    if ((this.bcw & 0x20) != 0) {
      localContentValues.put("TotalLen", Integer.valueOf(this.ebK));
    }
    if ((this.bcw & 0x40) != 0) {
      localContentValues.put("Status", Integer.valueOf(this.status));
    }
    if ((this.bcw & 0x80) != 0) {
      localContentValues.put("CreateTime", Long.valueOf(this.createTime));
    }
    if ((this.bcw & 0x100) != 0) {
      localContentValues.put("LastModifyTime", Long.valueOf(this.eHF));
    }
    if ((this.bcw & 0x200) != 0) {
      localContentValues.put("ClientId", this.clientId);
    }
    if ((this.bcw & 0x400) != 0) {
      localContentValues.put("VoiceLength", Integer.valueOf(this.eKW));
    }
    if ((this.bcw & 0x800) != 0) {
      localContentValues.put("MsgLocalId", Integer.valueOf(this.eHI));
    }
    if ((this.bcw & 0x1000) != 0) {
      localContentValues.put("Human", this.eHA);
    }
    if ((this.bcw & 0x2000) != 0) {
      localContentValues.put("reserved1", Integer.valueOf(this.eHJ));
    }
    if ((this.bcw & 0x4000) != 0) {
      localContentValues.put("reserved2", this.eJP);
    }
    if ((this.bcw & 0x8000) != 0) {
      localContentValues.put("MsgSource", this.czr);
    }
    if ((this.bcw & 0x10000) != 0) {
      localContentValues.put("MsgFlag", Integer.valueOf(this.czq));
    }
    if ((this.bcw & 0x20000) != 0) {
      localContentValues.put("MsgSeq", Integer.valueOf(this.eKX));
    }
    if ((this.bcw & 0x40000) != 0) {
      localContentValues.put("MasterBufId", Long.valueOf(this.eKY));
    }
    if ((this.bcw & 0x80000) != 0) {
      localContentValues.put("checksum", Integer.valueOf(this.eKZ));
    }
    return localContentValues;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.modelvoice.p
 * JD-Core Version:    0.7.0.1
 */