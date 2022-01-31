package com.tencent.mm.ag;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.platformtools.bk;

public final class h
{
  public int bcw = -1;
  public int cCq = 0;
  int ebR = 0;
  public String ebS = "";
  public String ebT = "";
  private int ebU = 0;
  int ebV = 0;
  public String username = "";
  
  public final ContentValues JW()
  {
    ContentValues localContentValues = new ContentValues();
    if ((this.bcw & 0x1) != 0) {
      localContentValues.put("username", getUsername());
    }
    if ((this.bcw & 0x2) != 0) {
      localContentValues.put("imgflag", Integer.valueOf(this.cCq));
    }
    if ((this.bcw & 0x4) != 0) {
      localContentValues.put("lastupdatetime", Integer.valueOf(this.ebR));
    }
    if ((this.bcw & 0x8) != 0) {
      localContentValues.put("reserved1", JX());
    }
    if ((this.bcw & 0x10) != 0) {
      localContentValues.put("reserved2", JY());
    }
    if ((this.bcw & 0x20) != 0) {
      localContentValues.put("reserved3", Integer.valueOf(this.ebU));
    }
    if ((this.bcw & 0x40) != 0) {
      localContentValues.put("reserved4", Integer.valueOf(this.ebV));
    }
    return localContentValues;
  }
  
  public final String JX()
  {
    if (this.ebT == null) {
      return "";
    }
    return this.ebT;
  }
  
  public final String JY()
  {
    if (this.ebS == null) {
      return "";
    }
    return this.ebS;
  }
  
  public final void JZ()
  {
    this.ebV = ((int)(bk.UX() / 60L));
    this.bcw |= 0x40;
  }
  
  public final void bK(boolean paramBoolean)
  {
    if (paramBoolean) {}
    for (int i = 1;; i = 0)
    {
      this.ebU = i;
      return;
    }
  }
  
  public final void d(Cursor paramCursor)
  {
    this.username = paramCursor.getString(0);
    this.cCq = paramCursor.getInt(1);
    this.ebR = paramCursor.getInt(2);
    this.ebT = paramCursor.getString(3);
    this.ebS = paramCursor.getString(4);
    this.ebU = paramCursor.getInt(5);
    this.ebV = paramCursor.getInt(6);
  }
  
  public final String getUsername()
  {
    if (this.username == null) {
      return "";
    }
    return this.username;
  }
  
  public final void ko(String paramString)
  {
    this.ebS = paramString;
  }
  
  public final void setUsername(String paramString)
  {
    this.username = paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.ag.h
 * JD-Core Version:    0.7.0.1
 */