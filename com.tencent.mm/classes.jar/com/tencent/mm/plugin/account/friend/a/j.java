package com.tencent.mm.plugin.account.friend.a;

import android.content.ContentValues;

public final class j
{
  int bcw = -1;
  public String cCA = "";
  public String cCB = "";
  public int cCz = 0;
  public int sex = 0;
  public String signature = "";
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
      localContentValues.put("sex", Integer.valueOf(this.sex));
    }
    if ((this.bcw & 0x4) != 0) {
      localContentValues.put("personalcard", Integer.valueOf(this.cCz));
    }
    if ((this.bcw & 0x8) != 0)
    {
      if (this.cCA == null)
      {
        str = "";
        localContentValues.put("province", str);
      }
    }
    else
    {
      if ((this.bcw & 0x10) != 0)
      {
        if (this.cCB != null) {
          break label162;
        }
        str = "";
        label118:
        localContentValues.put("city", str);
      }
      if ((this.bcw & 0x20) != 0) {
        if (this.signature != null) {
          break label170;
        }
      }
    }
    label162:
    label170:
    for (String str = "";; str = this.signature)
    {
      localContentValues.put("signature", str);
      return localContentValues;
      str = this.cCA;
      break;
      str = this.cCB;
      break label118;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.account.friend.a.j
 * JD-Core Version:    0.7.0.1
 */