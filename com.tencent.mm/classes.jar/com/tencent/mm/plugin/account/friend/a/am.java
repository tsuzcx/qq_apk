package com.tencent.mm.plugin.account.friend.a;

import android.content.ContentValues;
import android.database.Cursor;

public final class am
{
  int bcw = -1;
  int fgO = 0;
  int fgP = 0;
  int fgQ = 0;
  int fgR = 0;
  int fgS = 0;
  int fgT = 0;
  String fgU = "";
  String fgV = "";
  
  public final ContentValues Xe()
  {
    ContentValues localContentValues = new ContentValues();
    if ((this.bcw & 0x1) != 0) {
      localContentValues.put("grouopid", Integer.valueOf(this.fgO));
    }
    if ((this.bcw & 0x2) != 0) {
      localContentValues.put("membernum", Integer.valueOf(this.fgP));
    }
    if ((this.bcw & 0x4) != 0) {
      localContentValues.put("weixinnum", Integer.valueOf(this.fgQ));
    }
    if ((this.bcw & 0x8) != 0) {
      localContentValues.put("insert_time", Integer.valueOf(this.fgR));
    }
    if ((this.bcw & 0x10) != 0) {
      localContentValues.put("lastupdate_time", Integer.valueOf(this.fgS));
    }
    if ((this.bcw & 0x20) != 0) {
      localContentValues.put("needupdate", Integer.valueOf(this.fgT));
    }
    if ((this.bcw & 0x40) != 0) {
      localContentValues.put("updatekey", Xf());
    }
    if ((this.bcw & 0x80) != 0) {
      localContentValues.put("groupname", Xg());
    }
    return localContentValues;
  }
  
  public final String Xf()
  {
    if (this.fgU == null) {
      return "";
    }
    return this.fgU;
  }
  
  public final String Xg()
  {
    if (this.fgV == null) {
      return "";
    }
    return this.fgV;
  }
  
  public final void d(Cursor paramCursor)
  {
    this.fgO = paramCursor.getInt(0);
    this.fgP = paramCursor.getInt(1);
    this.fgQ = paramCursor.getInt(2);
    this.fgR = paramCursor.getInt(3);
    this.fgS = paramCursor.getInt(4);
    this.fgT = paramCursor.getInt(5);
    this.fgU = paramCursor.getString(6);
    this.fgV = paramCursor.getString(7);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.account.friend.a.am
 * JD-Core Version:    0.7.0.1
 */