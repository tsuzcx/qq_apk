package com.tencent.mm.plugin.masssend.a;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class a
{
  public int cSb;
  public long createTime;
  int dDp;
  public String filename;
  String hHN;
  String hHO;
  String inu;
  int iub;
  long iud;
  public int msgType;
  int status;
  String vHb;
  public String vHc;
  public int vHd;
  public int vHe;
  int vHf;
  int vHg;
  public int vHh;
  public int videoSource;
  
  public a()
  {
    AppMethodBeat.i(26343);
    this.dDp = -1;
    this.inu = "";
    this.status = 0;
    this.createTime = 0L;
    this.iud = 0L;
    this.filename = "";
    this.vHb = "";
    this.vHc = "";
    this.vHd = 0;
    this.msgType = 0;
    this.vHe = 0;
    this.vHf = 0;
    this.cSb = 0;
    this.iub = 0;
    this.vHg = 0;
    this.videoSource = 0;
    this.vHh = 0;
    this.hHN = "";
    this.hHO = "";
    AppMethodBeat.o(26343);
  }
  
  public final void convertFrom(Cursor paramCursor)
  {
    AppMethodBeat.i(26344);
    this.inu = paramCursor.getString(0);
    this.status = paramCursor.getInt(1);
    this.createTime = paramCursor.getLong(2);
    this.iud = paramCursor.getLong(3);
    this.filename = paramCursor.getString(4);
    this.vHb = paramCursor.getString(5);
    this.vHc = paramCursor.getString(6);
    this.vHd = paramCursor.getInt(7);
    this.msgType = paramCursor.getInt(8);
    this.vHe = paramCursor.getInt(9);
    this.vHf = paramCursor.getInt(10);
    this.cSb = paramCursor.getInt(11);
    this.iub = paramCursor.getInt(12);
    this.vHg = paramCursor.getInt(13);
    this.videoSource = paramCursor.getInt(14);
    this.vHh = paramCursor.getInt(15);
    this.hHN = paramCursor.getString(16);
    this.hHO = paramCursor.getString(17);
    AppMethodBeat.o(26344);
  }
  
  public final String dkK()
  {
    if (this.inu == null) {
      return "";
    }
    return this.inu;
  }
  
  public final String dkL()
  {
    if (this.filename == null) {
      return "";
    }
    return this.filename;
  }
  
  public final String dkM()
  {
    if (this.vHb == null) {
      return "";
    }
    return this.vHb;
  }
  
  public final String dkN()
  {
    if (this.vHc == null) {
      return "";
    }
    return this.vHc;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.masssend.a.a
 * JD-Core Version:    0.7.0.1
 */