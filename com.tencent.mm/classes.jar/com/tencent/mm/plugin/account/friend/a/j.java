package com.tencent.mm.plugin.account.friend.a;

import android.content.ContentValues;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class j
{
  int drx;
  public int exL;
  public int exU;
  public String exV;
  public String exW;
  public String signature;
  public String username;
  
  public j()
  {
    AppMethodBeat.i(131017);
    this.drx = -1;
    this.username = "";
    this.exL = 0;
    this.exU = 0;
    this.exV = "";
    this.exW = "";
    this.signature = "";
    AppMethodBeat.o(131017);
  }
  
  public final ContentValues convertTo()
  {
    AppMethodBeat.i(131018);
    ContentValues localContentValues = new ContentValues();
    if ((this.drx & 0x1) != 0) {
      localContentValues.put("username", getUsername());
    }
    if ((this.drx & 0x2) != 0) {
      localContentValues.put("sex", Integer.valueOf(this.exL));
    }
    if ((this.drx & 0x4) != 0) {
      localContentValues.put("personalcard", Integer.valueOf(this.exU));
    }
    if ((this.drx & 0x8) != 0)
    {
      if (this.exV == null)
      {
        str = "";
        localContentValues.put("province", str);
      }
    }
    else
    {
      if ((this.drx & 0x10) != 0)
      {
        if (this.exW != null) {
          break label172;
        }
        str = "";
        label123:
        localContentValues.put("city", str);
      }
      if ((this.drx & 0x20) != 0) {
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
      AppMethodBeat.o(131018);
      return localContentValues;
      str = this.exV;
      break;
      str = this.exW;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.account.friend.a.j
 * JD-Core Version:    0.7.0.1
 */