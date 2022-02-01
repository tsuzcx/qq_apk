package com.tencent.mm.plugin.account.friend.a;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class aq
{
  int dtM;
  String ilA;
  int ilt;
  int ilu;
  int ilv;
  int ilw;
  int ilx;
  int ily;
  String ilz;
  
  public aq()
  {
    AppMethodBeat.i(131154);
    this.dtM = -1;
    this.ilt = 0;
    this.ilu = 0;
    this.ilv = 0;
    this.ilw = 0;
    this.ilx = 0;
    this.ily = 0;
    this.ilz = "";
    this.ilA = "";
    AppMethodBeat.o(131154);
  }
  
  public final ContentValues aJe()
  {
    AppMethodBeat.i(131156);
    ContentValues localContentValues = new ContentValues();
    if ((this.dtM & 0x1) != 0) {
      localContentValues.put("grouopid", Integer.valueOf(this.ilt));
    }
    if ((this.dtM & 0x2) != 0) {
      localContentValues.put("membernum", Integer.valueOf(this.ilu));
    }
    if ((this.dtM & 0x4) != 0) {
      localContentValues.put("weixinnum", Integer.valueOf(this.ilv));
    }
    if ((this.dtM & 0x8) != 0) {
      localContentValues.put("insert_time", Integer.valueOf(this.ilw));
    }
    if ((this.dtM & 0x10) != 0) {
      localContentValues.put("lastupdate_time", Integer.valueOf(this.ilx));
    }
    if ((this.dtM & 0x20) != 0) {
      localContentValues.put("needupdate", Integer.valueOf(this.ily));
    }
    if ((this.dtM & 0x40) != 0) {
      localContentValues.put("updatekey", aJf());
    }
    if ((this.dtM & 0x80) != 0) {
      localContentValues.put("groupname", aJg());
    }
    AppMethodBeat.o(131156);
    return localContentValues;
  }
  
  public final String aJf()
  {
    if (this.ilz == null) {
      return "";
    }
    return this.ilz;
  }
  
  public final String aJg()
  {
    if (this.ilA == null) {
      return "";
    }
    return this.ilA;
  }
  
  public final void convertFrom(Cursor paramCursor)
  {
    AppMethodBeat.i(131155);
    this.ilt = paramCursor.getInt(0);
    this.ilu = paramCursor.getInt(1);
    this.ilv = paramCursor.getInt(2);
    this.ilw = paramCursor.getInt(3);
    this.ilx = paramCursor.getInt(4);
    this.ily = paramCursor.getInt(5);
    this.ilz = paramCursor.getString(6);
    this.ilA = paramCursor.getString(7);
    AppMethodBeat.o(131155);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.account.friend.a.aq
 * JD-Core Version:    0.7.0.1
 */