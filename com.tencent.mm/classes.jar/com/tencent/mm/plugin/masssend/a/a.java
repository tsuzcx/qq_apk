package com.tencent.mm.plugin.masssend.a;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class a
{
  public int cSL;
  public long createTime;
  int dEu;
  public String filename;
  String hKF;
  String hKG;
  String iqo;
  int iwV;
  long iwX;
  public int msgType;
  int status;
  String vTf;
  public String vTg;
  public int vTh;
  public int vTi;
  int vTj;
  int vTk;
  public int vTl;
  public int videoSource;
  
  public a()
  {
    AppMethodBeat.i(26343);
    this.dEu = -1;
    this.iqo = "";
    this.status = 0;
    this.createTime = 0L;
    this.iwX = 0L;
    this.filename = "";
    this.vTf = "";
    this.vTg = "";
    this.vTh = 0;
    this.msgType = 0;
    this.vTi = 0;
    this.vTj = 0;
    this.cSL = 0;
    this.iwV = 0;
    this.vTk = 0;
    this.videoSource = 0;
    this.vTl = 0;
    this.hKF = "";
    this.hKG = "";
    AppMethodBeat.o(26343);
  }
  
  public final void convertFrom(Cursor paramCursor)
  {
    AppMethodBeat.i(26344);
    this.iqo = paramCursor.getString(0);
    this.status = paramCursor.getInt(1);
    this.createTime = paramCursor.getLong(2);
    this.iwX = paramCursor.getLong(3);
    this.filename = paramCursor.getString(4);
    this.vTf = paramCursor.getString(5);
    this.vTg = paramCursor.getString(6);
    this.vTh = paramCursor.getInt(7);
    this.msgType = paramCursor.getInt(8);
    this.vTi = paramCursor.getInt(9);
    this.vTj = paramCursor.getInt(10);
    this.cSL = paramCursor.getInt(11);
    this.iwV = paramCursor.getInt(12);
    this.vTk = paramCursor.getInt(13);
    this.videoSource = paramCursor.getInt(14);
    this.vTl = paramCursor.getInt(15);
    this.hKF = paramCursor.getString(16);
    this.hKG = paramCursor.getString(17);
    AppMethodBeat.o(26344);
  }
  
  public final String dnK()
  {
    if (this.iqo == null) {
      return "";
    }
    return this.iqo;
  }
  
  public final String dnL()
  {
    if (this.filename == null) {
      return "";
    }
    return this.filename;
  }
  
  public final String dnM()
  {
    if (this.vTf == null) {
      return "";
    }
    return this.vTf;
  }
  
  public final String dnN()
  {
    if (this.vTg == null) {
      return "";
    }
    return this.vTg;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.masssend.a.a
 * JD-Core Version:    0.7.0.1
 */