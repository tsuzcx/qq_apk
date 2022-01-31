package com.tencent.mm.plugin.account.friend.a;

import android.content.ContentValues;

public final class p
{
  int bcw = -1;
  private int dXk = 0;
  private String dXm = "";
  private String dXn = "";
  public int efI = 0;
  private int emn = 0;
  public int ffY = 0;
  public String username = "";
  
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
      localContentValues.put("friendtype", Integer.valueOf(this.ffY));
    }
    if ((this.bcw & 0x4) != 0) {
      localContentValues.put("updatetime", Integer.valueOf(this.efI));
    }
    if ((this.bcw & 0x8) != 0) {
      localContentValues.put("reserved1", Integer.valueOf(this.dXk));
    }
    if ((this.bcw & 0x10) != 0) {
      localContentValues.put("reserved2", Integer.valueOf(this.emn));
    }
    if ((this.bcw & 0x20) != 0)
    {
      if (this.dXm == null)
      {
        str = "";
        localContentValues.put("reserved3", str);
      }
    }
    else if ((this.bcw & 0x40) != 0) {
      if (this.dXn != null) {
        break label181;
      }
    }
    label181:
    for (String str = "";; str = this.dXn)
    {
      localContentValues.put("reserved4", str);
      return localContentValues;
      str = this.dXm;
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.account.friend.a.p
 * JD-Core Version:    0.7.0.1
 */