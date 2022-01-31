package com.tencent.mm.plugin.masssend.a;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class a
{
  public int bWt;
  int bsY;
  public long createTime;
  String fQQ;
  int fXt;
  long fXv;
  public String filename;
  String fnu;
  String fnv;
  public int msgType;
  String oBd;
  public String oBe;
  public int oBf;
  public int oBg;
  int oBh;
  int oBi;
  public int oBj;
  int status;
  public int videoSource;
  
  public a()
  {
    AppMethodBeat.i(22721);
    this.bsY = -1;
    this.fQQ = "";
    this.status = 0;
    this.createTime = 0L;
    this.fXv = 0L;
    this.filename = "";
    this.oBd = "";
    this.oBe = "";
    this.oBf = 0;
    this.msgType = 0;
    this.oBg = 0;
    this.oBh = 0;
    this.bWt = 0;
    this.fXt = 0;
    this.oBi = 0;
    this.videoSource = 0;
    this.oBj = 0;
    this.fnu = "";
    this.fnv = "";
    AppMethodBeat.o(22721);
  }
  
  public final String bOT()
  {
    if (this.fQQ == null) {
      return "";
    }
    return this.fQQ;
  }
  
  public final String bOU()
  {
    if (this.filename == null) {
      return "";
    }
    return this.filename;
  }
  
  public final String bOV()
  {
    if (this.oBd == null) {
      return "";
    }
    return this.oBd;
  }
  
  public final String bOW()
  {
    if (this.oBe == null) {
      return "";
    }
    return this.oBe;
  }
  
  public final void convertFrom(Cursor paramCursor)
  {
    AppMethodBeat.i(22722);
    this.fQQ = paramCursor.getString(0);
    this.status = paramCursor.getInt(1);
    this.createTime = paramCursor.getLong(2);
    this.fXv = paramCursor.getLong(3);
    this.filename = paramCursor.getString(4);
    this.oBd = paramCursor.getString(5);
    this.oBe = paramCursor.getString(6);
    this.oBf = paramCursor.getInt(7);
    this.msgType = paramCursor.getInt(8);
    this.oBg = paramCursor.getInt(9);
    this.oBh = paramCursor.getInt(10);
    this.bWt = paramCursor.getInt(11);
    this.fXt = paramCursor.getInt(12);
    this.oBi = paramCursor.getInt(13);
    this.videoSource = paramCursor.getInt(14);
    this.oBj = paramCursor.getInt(15);
    this.fnu = paramCursor.getString(16);
    this.fnv = paramCursor.getString(17);
    AppMethodBeat.o(22722);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.masssend.a.a
 * JD-Core Version:    0.7.0.1
 */