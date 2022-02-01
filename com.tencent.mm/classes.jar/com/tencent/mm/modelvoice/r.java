package com.tencent.mm.modelvoice;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class r
{
  public String clientId;
  public long createTime;
  public long dAY;
  public int dDp;
  public String dDy;
  int eLr;
  String eLs;
  public String fileName;
  public int hMP;
  public int isJ;
  public String itY;
  public int iua;
  public long iud;
  public int iuf;
  int iug;
  String iwb;
  int iwi;
  public int ixm;
  int ixn;
  long ixo;
  int ixp;
  public int status;
  
  public r()
  {
    AppMethodBeat.i(148454);
    this.dDp = -1;
    this.iwi = 0;
    this.fileName = "";
    this.dDy = "";
    this.clientId = "";
    this.dAY = 0L;
    this.isJ = 0;
    this.iua = 0;
    this.hMP = 0;
    this.status = 0;
    this.createTime = 0L;
    this.iud = 0L;
    this.ixm = 0;
    this.iuf = 0;
    this.itY = "";
    this.iug = 0;
    this.iwb = "";
    this.eLs = "";
    this.eLr = 0;
    this.ixn = 0;
    this.ixo = 0L;
    this.ixp = 0;
    AppMethodBeat.o(148454);
  }
  
  public final boolean aNB()
  {
    return (this.status == 5) || (this.status == 6);
  }
  
  public final boolean aNC()
  {
    return ((this.status > 1) && (this.status <= 3)) || (this.status == 8);
  }
  
  public final void convertFrom(Cursor paramCursor)
  {
    AppMethodBeat.i(148453);
    this.fileName = paramCursor.getString(0);
    this.dDy = paramCursor.getString(1);
    this.dAY = paramCursor.getLong(2);
    this.isJ = paramCursor.getInt(3);
    this.iua = paramCursor.getInt(4);
    this.hMP = paramCursor.getInt(5);
    this.status = paramCursor.getInt(6);
    this.createTime = paramCursor.getLong(7);
    this.iud = paramCursor.getLong(8);
    this.clientId = paramCursor.getString(9);
    this.ixm = paramCursor.getInt(10);
    this.iuf = paramCursor.getInt(11);
    this.itY = paramCursor.getString(12);
    this.iug = paramCursor.getInt(13);
    this.iwb = paramCursor.getString(14);
    this.eLs = paramCursor.getString(15);
    this.eLr = paramCursor.getInt(16);
    this.ixn = paramCursor.getInt(17);
    this.ixo = paramCursor.getLong(18);
    this.ixp = paramCursor.getInt(19);
    AppMethodBeat.o(148453);
  }
  
  public final ContentValues convertTo()
  {
    AppMethodBeat.i(148452);
    ContentValues localContentValues = new ContentValues();
    if ((this.dDp & 0x1) != 0) {
      localContentValues.put("FileName", this.fileName);
    }
    if ((this.dDp & 0x2) != 0) {
      localContentValues.put("User", this.dDy);
    }
    if ((this.dDp & 0x4) != 0) {
      localContentValues.put("MsgId", Long.valueOf(this.dAY));
    }
    if ((this.dDp & 0x8) != 0) {
      localContentValues.put("NetOffset", Integer.valueOf(this.isJ));
    }
    if ((this.dDp & 0x10) != 0) {
      localContentValues.put("FileNowSize", Integer.valueOf(this.iua));
    }
    if ((this.dDp & 0x20) != 0) {
      localContentValues.put("TotalLen", Integer.valueOf(this.hMP));
    }
    if ((this.dDp & 0x40) != 0) {
      localContentValues.put("Status", Integer.valueOf(this.status));
    }
    if ((this.dDp & 0x80) != 0) {
      localContentValues.put("CreateTime", Long.valueOf(this.createTime));
    }
    if ((this.dDp & 0x100) != 0) {
      localContentValues.put("LastModifyTime", Long.valueOf(this.iud));
    }
    if ((this.dDp & 0x200) != 0) {
      localContentValues.put("ClientId", this.clientId);
    }
    if ((this.dDp & 0x400) != 0) {
      localContentValues.put("VoiceLength", Integer.valueOf(this.ixm));
    }
    if ((this.dDp & 0x800) != 0) {
      localContentValues.put("MsgLocalId", Integer.valueOf(this.iuf));
    }
    if ((this.dDp & 0x1000) != 0) {
      localContentValues.put("Human", this.itY);
    }
    if ((this.dDp & 0x2000) != 0) {
      localContentValues.put("reserved1", Integer.valueOf(this.iug));
    }
    if ((this.dDp & 0x4000) != 0) {
      localContentValues.put("reserved2", this.iwb);
    }
    if ((this.dDp & 0x8000) != 0) {
      localContentValues.put("MsgSource", this.eLs);
    }
    if ((this.dDp & 0x10000) != 0) {
      localContentValues.put("MsgFlag", Integer.valueOf(this.eLr));
    }
    if ((this.dDp & 0x20000) != 0) {
      localContentValues.put("MsgSeq", Integer.valueOf(this.ixn));
    }
    if ((this.dDp & 0x40000) != 0) {
      localContentValues.put("MasterBufId", Long.valueOf(this.ixo));
    }
    if ((this.dDp & 0x80000) != 0) {
      localContentValues.put("checksum", Integer.valueOf(this.ixp));
    }
    AppMethodBeat.o(148452);
    return localContentValues;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.modelvoice.r
 * JD-Core Version:    0.7.0.1
 */