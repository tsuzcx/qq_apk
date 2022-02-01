package com.tencent.mm.plugin.account.friend.a;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class aq
{
  int cSx;
  int kfF;
  int kfG;
  int kfH;
  int kfI;
  int kfJ;
  int kfK;
  String kfL;
  String kfM;
  
  public aq()
  {
    AppMethodBeat.i(131154);
    this.cSx = -1;
    this.kfF = 0;
    this.kfG = 0;
    this.kfH = 0;
    this.kfI = 0;
    this.kfJ = 0;
    this.kfK = 0;
    this.kfL = "";
    this.kfM = "";
    AppMethodBeat.o(131154);
  }
  
  public final ContentValues bos()
  {
    AppMethodBeat.i(131156);
    ContentValues localContentValues = new ContentValues();
    if ((this.cSx & 0x1) != 0) {
      localContentValues.put("grouopid", Integer.valueOf(this.kfF));
    }
    if ((this.cSx & 0x2) != 0) {
      localContentValues.put("membernum", Integer.valueOf(this.kfG));
    }
    if ((this.cSx & 0x4) != 0) {
      localContentValues.put("weixinnum", Integer.valueOf(this.kfH));
    }
    if ((this.cSx & 0x8) != 0) {
      localContentValues.put("insert_time", Integer.valueOf(this.kfI));
    }
    if ((this.cSx & 0x10) != 0) {
      localContentValues.put("lastupdate_time", Integer.valueOf(this.kfJ));
    }
    if ((this.cSx & 0x20) != 0) {
      localContentValues.put("needupdate", Integer.valueOf(this.kfK));
    }
    if ((this.cSx & 0x40) != 0) {
      localContentValues.put("updatekey", bot());
    }
    if ((this.cSx & 0x80) != 0) {
      localContentValues.put("groupname", bou());
    }
    AppMethodBeat.o(131156);
    return localContentValues;
  }
  
  public final String bot()
  {
    if (this.kfL == null) {
      return "";
    }
    return this.kfL;
  }
  
  public final String bou()
  {
    if (this.kfM == null) {
      return "";
    }
    return this.kfM;
  }
  
  public final void convertFrom(Cursor paramCursor)
  {
    AppMethodBeat.i(131155);
    this.kfF = paramCursor.getInt(0);
    this.kfG = paramCursor.getInt(1);
    this.kfH = paramCursor.getInt(2);
    this.kfI = paramCursor.getInt(3);
    this.kfJ = paramCursor.getInt(4);
    this.kfK = paramCursor.getInt(5);
    this.kfL = paramCursor.getString(6);
    this.kfM = paramCursor.getString(7);
    AppMethodBeat.o(131155);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.account.friend.a.aq
 * JD-Core Version:    0.7.0.1
 */