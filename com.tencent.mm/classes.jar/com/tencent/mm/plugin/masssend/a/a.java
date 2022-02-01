package com.tencent.mm.plugin.masssend.a;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class a
{
  String ESC;
  public String ESD;
  public int ESE;
  public int ESF;
  int ESG;
  int ESH;
  public int ESI;
  int cUP;
  public long createTime;
  public int faO;
  public String filename;
  String lvt;
  String lvu;
  String mbB;
  int mhN;
  long mhP;
  public int msgType;
  int status;
  public int videoSource;
  
  public a()
  {
    AppMethodBeat.i(26343);
    this.cUP = -1;
    this.mbB = "";
    this.status = 0;
    this.createTime = 0L;
    this.mhP = 0L;
    this.filename = "";
    this.ESC = "";
    this.ESD = "";
    this.ESE = 0;
    this.msgType = 0;
    this.ESF = 0;
    this.ESG = 0;
    this.faO = 0;
    this.mhN = 0;
    this.ESH = 0;
    this.videoSource = 0;
    this.ESI = 0;
    this.lvt = "";
    this.lvu = "";
    AppMethodBeat.o(26343);
  }
  
  public final void convertFrom(Cursor paramCursor)
  {
    AppMethodBeat.i(26344);
    this.mbB = paramCursor.getString(0);
    this.status = paramCursor.getInt(1);
    this.createTime = paramCursor.getLong(2);
    this.mhP = paramCursor.getLong(3);
    this.filename = paramCursor.getString(4);
    this.ESC = paramCursor.getString(5);
    this.ESD = paramCursor.getString(6);
    this.ESE = paramCursor.getInt(7);
    this.msgType = paramCursor.getInt(8);
    this.ESF = paramCursor.getInt(9);
    this.ESG = paramCursor.getInt(10);
    this.faO = paramCursor.getInt(11);
    this.mhN = paramCursor.getInt(12);
    this.ESH = paramCursor.getInt(13);
    this.videoSource = paramCursor.getInt(14);
    this.ESI = paramCursor.getInt(15);
    this.lvt = paramCursor.getString(16);
    this.lvu = paramCursor.getString(17);
    AppMethodBeat.o(26344);
  }
  
  public final String eRd()
  {
    if (this.mbB == null) {
      return "";
    }
    return this.mbB;
  }
  
  public final String eRe()
  {
    if (this.filename == null) {
      return "";
    }
    return this.filename;
  }
  
  public final String eRf()
  {
    if (this.ESC == null) {
      return "";
    }
    return this.ESC;
  }
  
  public final String eRg()
  {
    if (this.ESD == null) {
      return "";
    }
    return this.ESD;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.masssend.a.a
 * JD-Core Version:    0.7.0.1
 */