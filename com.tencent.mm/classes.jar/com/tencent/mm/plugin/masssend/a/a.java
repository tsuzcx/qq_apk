package com.tencent.mm.plugin.masssend.a;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class a
{
  public int cJQ;
  public long createTime;
  int dtM;
  public String filename;
  String gOV;
  String gOW;
  int hAe;
  long hAg;
  String htx;
  public int msgType;
  int status;
  String tvI;
  public String tvJ;
  public int tvK;
  public int tvL;
  int tvM;
  int tvN;
  public int tvO;
  public int videoSource;
  
  public a()
  {
    AppMethodBeat.i(26343);
    this.dtM = -1;
    this.htx = "";
    this.status = 0;
    this.createTime = 0L;
    this.hAg = 0L;
    this.filename = "";
    this.tvI = "";
    this.tvJ = "";
    this.tvK = 0;
    this.msgType = 0;
    this.tvL = 0;
    this.tvM = 0;
    this.cJQ = 0;
    this.hAe = 0;
    this.tvN = 0;
    this.videoSource = 0;
    this.tvO = 0;
    this.gOV = "";
    this.gOW = "";
    AppMethodBeat.o(26343);
  }
  
  public final String cNJ()
  {
    if (this.htx == null) {
      return "";
    }
    return this.htx;
  }
  
  public final String cNK()
  {
    if (this.filename == null) {
      return "";
    }
    return this.filename;
  }
  
  public final String cNL()
  {
    if (this.tvI == null) {
      return "";
    }
    return this.tvI;
  }
  
  public final String cNM()
  {
    if (this.tvJ == null) {
      return "";
    }
    return this.tvJ;
  }
  
  public final void convertFrom(Cursor paramCursor)
  {
    AppMethodBeat.i(26344);
    this.htx = paramCursor.getString(0);
    this.status = paramCursor.getInt(1);
    this.createTime = paramCursor.getLong(2);
    this.hAg = paramCursor.getLong(3);
    this.filename = paramCursor.getString(4);
    this.tvI = paramCursor.getString(5);
    this.tvJ = paramCursor.getString(6);
    this.tvK = paramCursor.getInt(7);
    this.msgType = paramCursor.getInt(8);
    this.tvL = paramCursor.getInt(9);
    this.tvM = paramCursor.getInt(10);
    this.cJQ = paramCursor.getInt(11);
    this.hAe = paramCursor.getInt(12);
    this.tvN = paramCursor.getInt(13);
    this.videoSource = paramCursor.getInt(14);
    this.tvO = paramCursor.getInt(15);
    this.gOV = paramCursor.getString(16);
    this.gOW = paramCursor.getString(17);
    AppMethodBeat.o(26344);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.masssend.a.a
 * JD-Core Version:    0.7.0.1
 */