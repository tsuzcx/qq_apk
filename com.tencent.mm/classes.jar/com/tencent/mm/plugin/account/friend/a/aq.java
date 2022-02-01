package com.tencent.mm.plugin.account.friend.a;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class aq
{
  int cUP;
  int mXe;
  int mXf;
  int mXg;
  int mXh;
  int mXi;
  int mXj;
  String mXk;
  String mXl;
  
  public aq()
  {
    AppMethodBeat.i(131154);
    this.cUP = -1;
    this.mXe = 0;
    this.mXf = 0;
    this.mXg = 0;
    this.mXh = 0;
    this.mXi = 0;
    this.mXj = 0;
    this.mXk = "";
    this.mXl = "";
    AppMethodBeat.o(131154);
  }
  
  public final ContentValues byB()
  {
    AppMethodBeat.i(131156);
    ContentValues localContentValues = new ContentValues();
    if ((this.cUP & 0x1) != 0) {
      localContentValues.put("grouopid", Integer.valueOf(this.mXe));
    }
    if ((this.cUP & 0x2) != 0) {
      localContentValues.put("membernum", Integer.valueOf(this.mXf));
    }
    if ((this.cUP & 0x4) != 0) {
      localContentValues.put("weixinnum", Integer.valueOf(this.mXg));
    }
    if ((this.cUP & 0x8) != 0) {
      localContentValues.put("insert_time", Integer.valueOf(this.mXh));
    }
    if ((this.cUP & 0x10) != 0) {
      localContentValues.put("lastupdate_time", Integer.valueOf(this.mXi));
    }
    if ((this.cUP & 0x20) != 0) {
      localContentValues.put("needupdate", Integer.valueOf(this.mXj));
    }
    if ((this.cUP & 0x40) != 0) {
      localContentValues.put("updatekey", byC());
    }
    if ((this.cUP & 0x80) != 0) {
      localContentValues.put("groupname", byD());
    }
    AppMethodBeat.o(131156);
    return localContentValues;
  }
  
  public final String byC()
  {
    if (this.mXk == null) {
      return "";
    }
    return this.mXk;
  }
  
  public final String byD()
  {
    if (this.mXl == null) {
      return "";
    }
    return this.mXl;
  }
  
  public final void convertFrom(Cursor paramCursor)
  {
    AppMethodBeat.i(131155);
    this.mXe = paramCursor.getInt(0);
    this.mXf = paramCursor.getInt(1);
    this.mXg = paramCursor.getInt(2);
    this.mXh = paramCursor.getInt(3);
    this.mXi = paramCursor.getInt(4);
    this.mXj = paramCursor.getInt(5);
    this.mXk = paramCursor.getString(6);
    this.mXl = paramCursor.getString(7);
    AppMethodBeat.o(131155);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.account.friend.a.aq
 * JD-Core Version:    0.7.0.1
 */