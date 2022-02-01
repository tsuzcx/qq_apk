package com.tencent.mm.plugin.account.friend.a;

import android.content.ContentValues;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class j
{
  int dtM;
  public String evA;
  public int evp;
  public int evy;
  public String evz;
  public String signature;
  public String username;
  
  public j()
  {
    AppMethodBeat.i(131017);
    this.dtM = -1;
    this.username = "";
    this.evp = 0;
    this.evy = 0;
    this.evz = "";
    this.evA = "";
    this.signature = "";
    AppMethodBeat.o(131017);
  }
  
  public final ContentValues convertTo()
  {
    AppMethodBeat.i(131018);
    ContentValues localContentValues = new ContentValues();
    if ((this.dtM & 0x1) != 0) {
      localContentValues.put("username", getUsername());
    }
    if ((this.dtM & 0x2) != 0) {
      localContentValues.put("sex", Integer.valueOf(this.evp));
    }
    if ((this.dtM & 0x4) != 0) {
      localContentValues.put("personalcard", Integer.valueOf(this.evy));
    }
    if ((this.dtM & 0x8) != 0)
    {
      if (this.evz == null)
      {
        str = "";
        localContentValues.put("province", str);
      }
    }
    else
    {
      if ((this.dtM & 0x10) != 0)
      {
        if (this.evA != null) {
          break label172;
        }
        str = "";
        label123:
        localContentValues.put("city", str);
      }
      if ((this.dtM & 0x20) != 0) {
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
      str = this.evz;
      break;
      str = this.evA;
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