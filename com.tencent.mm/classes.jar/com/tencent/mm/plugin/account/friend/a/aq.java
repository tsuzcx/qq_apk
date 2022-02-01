package com.tencent.mm.plugin.account.friend.a;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class aq
{
  int dEu;
  int jhC;
  int jhD;
  int jhE;
  int jhF;
  int jhG;
  int jhH;
  String jhI;
  String jhJ;
  
  public aq()
  {
    AppMethodBeat.i(131154);
    this.dEu = -1;
    this.jhC = 0;
    this.jhD = 0;
    this.jhE = 0;
    this.jhF = 0;
    this.jhG = 0;
    this.jhH = 0;
    this.jhI = "";
    this.jhJ = "";
    AppMethodBeat.o(131154);
  }
  
  public final ContentValues aTG()
  {
    AppMethodBeat.i(131156);
    ContentValues localContentValues = new ContentValues();
    if ((this.dEu & 0x1) != 0) {
      localContentValues.put("grouopid", Integer.valueOf(this.jhC));
    }
    if ((this.dEu & 0x2) != 0) {
      localContentValues.put("membernum", Integer.valueOf(this.jhD));
    }
    if ((this.dEu & 0x4) != 0) {
      localContentValues.put("weixinnum", Integer.valueOf(this.jhE));
    }
    if ((this.dEu & 0x8) != 0) {
      localContentValues.put("insert_time", Integer.valueOf(this.jhF));
    }
    if ((this.dEu & 0x10) != 0) {
      localContentValues.put("lastupdate_time", Integer.valueOf(this.jhG));
    }
    if ((this.dEu & 0x20) != 0) {
      localContentValues.put("needupdate", Integer.valueOf(this.jhH));
    }
    if ((this.dEu & 0x40) != 0) {
      localContentValues.put("updatekey", aTH());
    }
    if ((this.dEu & 0x80) != 0) {
      localContentValues.put("groupname", aTI());
    }
    AppMethodBeat.o(131156);
    return localContentValues;
  }
  
  public final String aTH()
  {
    if (this.jhI == null) {
      return "";
    }
    return this.jhI;
  }
  
  public final String aTI()
  {
    if (this.jhJ == null) {
      return "";
    }
    return this.jhJ;
  }
  
  public final void convertFrom(Cursor paramCursor)
  {
    AppMethodBeat.i(131155);
    this.jhC = paramCursor.getInt(0);
    this.jhD = paramCursor.getInt(1);
    this.jhE = paramCursor.getInt(2);
    this.jhF = paramCursor.getInt(3);
    this.jhG = paramCursor.getInt(4);
    this.jhH = paramCursor.getInt(5);
    this.jhI = paramCursor.getString(6);
    this.jhJ = paramCursor.getString(7);
    AppMethodBeat.o(131155);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.account.friend.a.aq
 * JD-Core Version:    0.7.0.1
 */