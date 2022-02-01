package com.tencent.mm.plugin.account.friend.a;

import android.content.ContentValues;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class j
{
  int dEu;
  public int eQV;
  public int eRe;
  public String eRf;
  public String eRg;
  public String signature;
  public String username;
  
  public j()
  {
    AppMethodBeat.i(131017);
    this.dEu = -1;
    this.username = "";
    this.eQV = 0;
    this.eRe = 0;
    this.eRf = "";
    this.eRg = "";
    this.signature = "";
    AppMethodBeat.o(131017);
  }
  
  public final ContentValues convertTo()
  {
    AppMethodBeat.i(131018);
    ContentValues localContentValues = new ContentValues();
    if ((this.dEu & 0x1) != 0) {
      localContentValues.put("username", getUsername());
    }
    if ((this.dEu & 0x2) != 0) {
      localContentValues.put("sex", Integer.valueOf(this.eQV));
    }
    if ((this.dEu & 0x4) != 0) {
      localContentValues.put("personalcard", Integer.valueOf(this.eRe));
    }
    if ((this.dEu & 0x8) != 0)
    {
      if (this.eRf == null)
      {
        str = "";
        localContentValues.put("province", str);
      }
    }
    else
    {
      if ((this.dEu & 0x10) != 0)
      {
        if (this.eRg != null) {
          break label172;
        }
        str = "";
        label123:
        localContentValues.put("city", str);
      }
      if ((this.dEu & 0x20) != 0) {
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
      str = this.eRf;
      break;
      str = this.eRg;
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