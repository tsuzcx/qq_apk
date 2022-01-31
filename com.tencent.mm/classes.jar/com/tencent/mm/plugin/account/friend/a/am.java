package com.tencent.mm.plugin.account.friend.a;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class am
{
  int bsY;
  int gyA;
  int gyB;
  String gyC;
  String gyD;
  int gyw;
  int gyx;
  int gyy;
  int gyz;
  
  public am()
  {
    AppMethodBeat.i(108493);
    this.bsY = -1;
    this.gyw = 0;
    this.gyx = 0;
    this.gyy = 0;
    this.gyz = 0;
    this.gyA = 0;
    this.gyB = 0;
    this.gyC = "";
    this.gyD = "";
    AppMethodBeat.o(108493);
  }
  
  public final ContentValues aqI()
  {
    AppMethodBeat.i(108495);
    ContentValues localContentValues = new ContentValues();
    if ((this.bsY & 0x1) != 0) {
      localContentValues.put("grouopid", Integer.valueOf(this.gyw));
    }
    if ((this.bsY & 0x2) != 0) {
      localContentValues.put("membernum", Integer.valueOf(this.gyx));
    }
    if ((this.bsY & 0x4) != 0) {
      localContentValues.put("weixinnum", Integer.valueOf(this.gyy));
    }
    if ((this.bsY & 0x8) != 0) {
      localContentValues.put("insert_time", Integer.valueOf(this.gyz));
    }
    if ((this.bsY & 0x10) != 0) {
      localContentValues.put("lastupdate_time", Integer.valueOf(this.gyA));
    }
    if ((this.bsY & 0x20) != 0) {
      localContentValues.put("needupdate", Integer.valueOf(this.gyB));
    }
    if ((this.bsY & 0x40) != 0) {
      localContentValues.put("updatekey", aqJ());
    }
    if ((this.bsY & 0x80) != 0) {
      localContentValues.put("groupname", aqK());
    }
    AppMethodBeat.o(108495);
    return localContentValues;
  }
  
  public final String aqJ()
  {
    if (this.gyC == null) {
      return "";
    }
    return this.gyC;
  }
  
  public final String aqK()
  {
    if (this.gyD == null) {
      return "";
    }
    return this.gyD;
  }
  
  public final void convertFrom(Cursor paramCursor)
  {
    AppMethodBeat.i(108494);
    this.gyw = paramCursor.getInt(0);
    this.gyx = paramCursor.getInt(1);
    this.gyy = paramCursor.getInt(2);
    this.gyz = paramCursor.getInt(3);
    this.gyA = paramCursor.getInt(4);
    this.gyB = paramCursor.getInt(5);
    this.gyC = paramCursor.getString(6);
    this.gyD = paramCursor.getString(7);
    AppMethodBeat.o(108494);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.account.friend.a.am
 * JD-Core Version:    0.7.0.1
 */