package com.tencent.mm.plugin.masssend.a;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class a
{
  public int cGX;
  public long createTime;
  int drx;
  public String filename;
  String hTZ;
  String hpv;
  String hpw;
  int iaF;
  long iaH;
  public int msgType;
  int status;
  String uEb;
  public String uEc;
  public int uEd;
  public int uEe;
  int uEf;
  int uEg;
  public int uEh;
  public int videoSource;
  
  public a()
  {
    AppMethodBeat.i(26343);
    this.drx = -1;
    this.hTZ = "";
    this.status = 0;
    this.createTime = 0L;
    this.iaH = 0L;
    this.filename = "";
    this.uEb = "";
    this.uEc = "";
    this.uEd = 0;
    this.msgType = 0;
    this.uEe = 0;
    this.uEf = 0;
    this.cGX = 0;
    this.iaF = 0;
    this.uEg = 0;
    this.videoSource = 0;
    this.uEh = 0;
    this.hpv = "";
    this.hpw = "";
    AppMethodBeat.o(26343);
  }
  
  public final void convertFrom(Cursor paramCursor)
  {
    AppMethodBeat.i(26344);
    this.hTZ = paramCursor.getString(0);
    this.status = paramCursor.getInt(1);
    this.createTime = paramCursor.getLong(2);
    this.iaH = paramCursor.getLong(3);
    this.filename = paramCursor.getString(4);
    this.uEb = paramCursor.getString(5);
    this.uEc = paramCursor.getString(6);
    this.uEd = paramCursor.getInt(7);
    this.msgType = paramCursor.getInt(8);
    this.uEe = paramCursor.getInt(9);
    this.uEf = paramCursor.getInt(10);
    this.cGX = paramCursor.getInt(11);
    this.iaF = paramCursor.getInt(12);
    this.uEg = paramCursor.getInt(13);
    this.videoSource = paramCursor.getInt(14);
    this.uEh = paramCursor.getInt(15);
    this.hpv = paramCursor.getString(16);
    this.hpw = paramCursor.getString(17);
    AppMethodBeat.o(26344);
  }
  
  public final String dbq()
  {
    if (this.hTZ == null) {
      return "";
    }
    return this.hTZ;
  }
  
  public final String dbr()
  {
    if (this.filename == null) {
      return "";
    }
    return this.filename;
  }
  
  public final String dbs()
  {
    if (this.uEb == null) {
      return "";
    }
    return this.uEb;
  }
  
  public final String dbt()
  {
    if (this.uEc == null) {
      return "";
    }
    return this.uEc;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.masssend.a.a
 * JD-Core Version:    0.7.0.1
 */