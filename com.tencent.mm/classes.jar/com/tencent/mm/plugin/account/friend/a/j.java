package com.tencent.mm.plugin.account.friend.a;

import android.content.ContentValues;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class j
{
  int bsY;
  public String city;
  public int dqC;
  public int dqL;
  public String province;
  public String signature;
  public String username;
  
  public j()
  {
    AppMethodBeat.i(108356);
    this.bsY = -1;
    this.username = "";
    this.dqC = 0;
    this.dqL = 0;
    this.province = "";
    this.city = "";
    this.signature = "";
    AppMethodBeat.o(108356);
  }
  
  public final ContentValues convertTo()
  {
    AppMethodBeat.i(108357);
    ContentValues localContentValues = new ContentValues();
    if ((this.bsY & 0x1) != 0) {
      localContentValues.put("username", getUsername());
    }
    if ((this.bsY & 0x2) != 0) {
      localContentValues.put("sex", Integer.valueOf(this.dqC));
    }
    if ((this.bsY & 0x4) != 0) {
      localContentValues.put("personalcard", Integer.valueOf(this.dqL));
    }
    if ((this.bsY & 0x8) != 0)
    {
      if (this.province == null)
      {
        str = "";
        localContentValues.put("province", str);
      }
    }
    else
    {
      if ((this.bsY & 0x10) != 0)
      {
        if (this.city != null) {
          break label172;
        }
        str = "";
        label123:
        localContentValues.put("city", str);
      }
      if ((this.bsY & 0x20) != 0) {
        if (this.signature != null) {
          break label180;
        }
      }
    }
    label172:
    label180:
    for (String str = "";; str = this.signature)
    {
      localContentValues.put("signature", str);
      AppMethodBeat.o(108357);
      return localContentValues;
      str = this.province;
      break;
      str = this.city;
      break label123;
    }
  }
  
  public final String getUsername()
  {
    if (this.username == null) {
      return "";
    }
    return this.username;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.account.friend.a.j
 * JD-Core Version:    0.7.0.1
 */