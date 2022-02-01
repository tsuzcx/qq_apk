package com.tencent.mm.plugin.account.friend.a;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class aq
{
  int dDp;
  int jeJ;
  int jeK;
  int jeL;
  int jeM;
  int jeN;
  int jeO;
  String jeP;
  String jeQ;
  
  public aq()
  {
    AppMethodBeat.i(131154);
    this.dDp = -1;
    this.jeJ = 0;
    this.jeK = 0;
    this.jeL = 0;
    this.jeM = 0;
    this.jeN = 0;
    this.jeO = 0;
    this.jeP = "";
    this.jeQ = "";
    AppMethodBeat.o(131154);
  }
  
  public final ContentValues aTh()
  {
    AppMethodBeat.i(131156);
    ContentValues localContentValues = new ContentValues();
    if ((this.dDp & 0x1) != 0) {
      localContentValues.put("grouopid", Integer.valueOf(this.jeJ));
    }
    if ((this.dDp & 0x2) != 0) {
      localContentValues.put("membernum", Integer.valueOf(this.jeK));
    }
    if ((this.dDp & 0x4) != 0) {
      localContentValues.put("weixinnum", Integer.valueOf(this.jeL));
    }
    if ((this.dDp & 0x8) != 0) {
      localContentValues.put("insert_time", Integer.valueOf(this.jeM));
    }
    if ((this.dDp & 0x10) != 0) {
      localContentValues.put("lastupdate_time", Integer.valueOf(this.jeN));
    }
    if ((this.dDp & 0x20) != 0) {
      localContentValues.put("needupdate", Integer.valueOf(this.jeO));
    }
    if ((this.dDp & 0x40) != 0) {
      localContentValues.put("updatekey", aTi());
    }
    if ((this.dDp & 0x80) != 0) {
      localContentValues.put("groupname", aTj());
    }
    AppMethodBeat.o(131156);
    return localContentValues;
  }
  
  public final String aTi()
  {
    if (this.jeP == null) {
      return "";
    }
    return this.jeP;
  }
  
  public final String aTj()
  {
    if (this.jeQ == null) {
      return "";
    }
    return this.jeQ;
  }
  
  public final void convertFrom(Cursor paramCursor)
  {
    AppMethodBeat.i(131155);
    this.jeJ = paramCursor.getInt(0);
    this.jeK = paramCursor.getInt(1);
    this.jeL = paramCursor.getInt(2);
    this.jeM = paramCursor.getInt(3);
    this.jeN = paramCursor.getInt(4);
    this.jeO = paramCursor.getInt(5);
    this.jeP = paramCursor.getString(6);
    this.jeQ = paramCursor.getString(7);
    AppMethodBeat.o(131155);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.account.friend.a.aq
 * JD-Core Version:    0.7.0.1
 */