package com.tencent.mm.az;

import android.content.ContentValues;
import android.database.Cursor;

public final class a
{
  int bcw = -1;
  private String ebN = "";
  private String ebO = "";
  private int ebP = 0;
  private int ebQ = 0;
  public int ewu = 0;
  private String path = "";
  public String username = "";
  
  public final void d(Cursor paramCursor)
  {
    this.username = paramCursor.getString(0);
    this.ewu = paramCursor.getInt(1);
    this.path = paramCursor.getString(2);
    this.ebN = paramCursor.getString(3);
    this.ebO = paramCursor.getString(4);
    this.ebP = paramCursor.getInt(5);
    this.ebQ = paramCursor.getInt(6);
  }
  
  public final String getUsername()
  {
    if (this.username == null) {
      return "";
    }
    return this.username;
  }
  
  public final ContentValues vf()
  {
    ContentValues localContentValues = new ContentValues();
    if ((this.bcw & 0x1) != 0) {
      localContentValues.put("username", getUsername());
    }
    if ((this.bcw & 0x2) != 0) {
      localContentValues.put("bgflag", Integer.valueOf(this.ewu));
    }
    if ((this.bcw & 0x4) != 0)
    {
      if (this.path == null)
      {
        str = "";
        localContentValues.put("path", str);
      }
    }
    else
    {
      if ((this.bcw & 0x8) != 0)
      {
        if (this.ebN != null) {
          break label185;
        }
        str = "";
        label95:
        localContentValues.put("reserved1", str);
      }
      if ((this.bcw & 0x10) != 0) {
        if (this.ebO != null) {
          break label193;
        }
      }
    }
    label185:
    label193:
    for (String str = "";; str = this.ebO)
    {
      localContentValues.put("reserved2", str);
      if ((this.bcw & 0x20) != 0) {
        localContentValues.put("reserved3", Integer.valueOf(this.ebP));
      }
      if ((this.bcw & 0x40) != 0) {
        localContentValues.put("reserved4", Integer.valueOf(this.ebQ));
      }
      return localContentValues;
      str = this.path;
      break;
      str = this.ebN;
      break label95;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.az.a
 * JD-Core Version:    0.7.0.1
 */