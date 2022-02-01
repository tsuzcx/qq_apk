package com.tencent.mm.plugin.masssend.model;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class a
{
  String KNg;
  public String KNh;
  public int KNi;
  public int KNj;
  int KNk;
  int KNl;
  public int KNm;
  public long createTime;
  int eQp;
  public String filename;
  public int heo;
  public int msgType;
  String oUw;
  String omQ;
  String omR;
  int paY;
  long pba;
  int status;
  public int videoSource;
  
  public a()
  {
    AppMethodBeat.i(26343);
    this.eQp = -1;
    this.oUw = "";
    this.status = 0;
    this.createTime = 0L;
    this.pba = 0L;
    this.filename = "";
    this.KNg = "";
    this.KNh = "";
    this.KNi = 0;
    this.msgType = 0;
    this.KNj = 0;
    this.KNk = 0;
    this.heo = 0;
    this.paY = 0;
    this.KNl = 0;
    this.videoSource = 0;
    this.KNm = 0;
    this.omQ = "";
    this.omR = "";
    AppMethodBeat.o(26343);
  }
  
  public final void convertFrom(Cursor paramCursor)
  {
    AppMethodBeat.i(26344);
    this.oUw = paramCursor.getString(0);
    this.status = paramCursor.getInt(1);
    this.createTime = paramCursor.getLong(2);
    this.pba = paramCursor.getLong(3);
    this.filename = paramCursor.getString(4);
    this.KNg = paramCursor.getString(5);
    this.KNh = paramCursor.getString(6);
    this.KNi = paramCursor.getInt(7);
    this.msgType = paramCursor.getInt(8);
    this.KNj = paramCursor.getInt(9);
    this.KNk = paramCursor.getInt(10);
    this.heo = paramCursor.getInt(11);
    this.paY = paramCursor.getInt(12);
    this.KNl = paramCursor.getInt(13);
    this.videoSource = paramCursor.getInt(14);
    this.KNm = paramCursor.getInt(15);
    this.omQ = paramCursor.getString(16);
    this.omR = paramCursor.getString(17);
    AppMethodBeat.o(26344);
  }
  
  public final String fZM()
  {
    if (this.oUw == null) {
      return "";
    }
    return this.oUw;
  }
  
  public final String fZN()
  {
    if (this.filename == null) {
      return "";
    }
    return this.filename;
  }
  
  public final String fZO()
  {
    if (this.KNg == null) {
      return "";
    }
    return this.KNg;
  }
  
  public final String fZP()
  {
    if (this.KNh == null) {
      return "";
    }
    return this.KNh;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.masssend.model.a
 * JD-Core Version:    0.7.0.1
 */