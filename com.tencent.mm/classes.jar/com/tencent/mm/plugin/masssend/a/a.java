package com.tencent.mm.plugin.masssend.a;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class a
{
  int cSx;
  public long createTime;
  public int djh;
  public String filename;
  String iFt;
  String iFu;
  String jlz;
  int jsk;
  long jsm;
  public int msgType;
  int status;
  public int videoSource;
  String znl;
  public String znm;
  public int znn;
  public int zno;
  int znp;
  int znq;
  public int znr;
  
  public a()
  {
    AppMethodBeat.i(26343);
    this.cSx = -1;
    this.jlz = "";
    this.status = 0;
    this.createTime = 0L;
    this.jsm = 0L;
    this.filename = "";
    this.znl = "";
    this.znm = "";
    this.znn = 0;
    this.msgType = 0;
    this.zno = 0;
    this.znp = 0;
    this.djh = 0;
    this.jsk = 0;
    this.znq = 0;
    this.videoSource = 0;
    this.znr = 0;
    this.iFt = "";
    this.iFu = "";
    AppMethodBeat.o(26343);
  }
  
  public final void convertFrom(Cursor paramCursor)
  {
    AppMethodBeat.i(26344);
    this.jlz = paramCursor.getString(0);
    this.status = paramCursor.getInt(1);
    this.createTime = paramCursor.getLong(2);
    this.jsm = paramCursor.getLong(3);
    this.filename = paramCursor.getString(4);
    this.znl = paramCursor.getString(5);
    this.znm = paramCursor.getString(6);
    this.znn = paramCursor.getInt(7);
    this.msgType = paramCursor.getInt(8);
    this.zno = paramCursor.getInt(9);
    this.znp = paramCursor.getInt(10);
    this.djh = paramCursor.getInt(11);
    this.jsk = paramCursor.getInt(12);
    this.znq = paramCursor.getInt(13);
    this.videoSource = paramCursor.getInt(14);
    this.znr = paramCursor.getInt(15);
    this.iFt = paramCursor.getString(16);
    this.iFu = paramCursor.getString(17);
    AppMethodBeat.o(26344);
  }
  
  public final String ehw()
  {
    if (this.jlz == null) {
      return "";
    }
    return this.jlz;
  }
  
  public final String ehx()
  {
    if (this.filename == null) {
      return "";
    }
    return this.filename;
  }
  
  public final String ehy()
  {
    if (this.znl == null) {
      return "";
    }
    return this.znl;
  }
  
  public final String ehz()
  {
    if (this.znm == null) {
      return "";
    }
    return this.znm;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.masssend.a.a
 * JD-Core Version:    0.7.0.1
 */