package com.tencent.mm.plugin.account.friend.a;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class aq
{
  int drx;
  int iLA;
  int iLB;
  int iLC;
  int iLD;
  int iLE;
  int iLF;
  String iLG;
  String iLH;
  
  public aq()
  {
    AppMethodBeat.i(131154);
    this.drx = -1;
    this.iLA = 0;
    this.iLB = 0;
    this.iLC = 0;
    this.iLD = 0;
    this.iLE = 0;
    this.iLF = 0;
    this.iLG = "";
    this.iLH = "";
    AppMethodBeat.o(131154);
  }
  
  public final ContentValues aPV()
  {
    AppMethodBeat.i(131156);
    ContentValues localContentValues = new ContentValues();
    if ((this.drx & 0x1) != 0) {
      localContentValues.put("grouopid", Integer.valueOf(this.iLA));
    }
    if ((this.drx & 0x2) != 0) {
      localContentValues.put("membernum", Integer.valueOf(this.iLB));
    }
    if ((this.drx & 0x4) != 0) {
      localContentValues.put("weixinnum", Integer.valueOf(this.iLC));
    }
    if ((this.drx & 0x8) != 0) {
      localContentValues.put("insert_time", Integer.valueOf(this.iLD));
    }
    if ((this.drx & 0x10) != 0) {
      localContentValues.put("lastupdate_time", Integer.valueOf(this.iLE));
    }
    if ((this.drx & 0x20) != 0) {
      localContentValues.put("needupdate", Integer.valueOf(this.iLF));
    }
    if ((this.drx & 0x40) != 0) {
      localContentValues.put("updatekey", aPW());
    }
    if ((this.drx & 0x80) != 0) {
      localContentValues.put("groupname", aPX());
    }
    AppMethodBeat.o(131156);
    return localContentValues;
  }
  
  public final String aPW()
  {
    if (this.iLG == null) {
      return "";
    }
    return this.iLG;
  }
  
  public final String aPX()
  {
    if (this.iLH == null) {
      return "";
    }
    return this.iLH;
  }
  
  public final void convertFrom(Cursor paramCursor)
  {
    AppMethodBeat.i(131155);
    this.iLA = paramCursor.getInt(0);
    this.iLB = paramCursor.getInt(1);
    this.iLC = paramCursor.getInt(2);
    this.iLD = paramCursor.getInt(3);
    this.iLE = paramCursor.getInt(4);
    this.iLF = paramCursor.getInt(5);
    this.iLG = paramCursor.getString(6);
    this.iLH = paramCursor.getString(7);
    AppMethodBeat.o(131155);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.account.friend.a.aq
 * JD-Core Version:    0.7.0.1
 */