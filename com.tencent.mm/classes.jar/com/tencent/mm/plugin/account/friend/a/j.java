package com.tencent.mm.plugin.account.friend.a;

import android.content.ContentValues;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class j
{
  int dDp;
  public int ePk;
  public int ePt;
  public String ePu;
  public String ePv;
  public String signature;
  public String username;
  
  public j()
  {
    AppMethodBeat.i(131017);
    this.dDp = -1;
    this.username = "";
    this.ePk = 0;
    this.ePt = 0;
    this.ePu = "";
    this.ePv = "";
    this.signature = "";
    AppMethodBeat.o(131017);
  }
  
  public final ContentValues convertTo()
  {
    AppMethodBeat.i(131018);
    ContentValues localContentValues = new ContentValues();
    if ((this.dDp & 0x1) != 0) {
      localContentValues.put("username", getUsername());
    }
    if ((this.dDp & 0x2) != 0) {
      localContentValues.put("sex", Integer.valueOf(this.ePk));
    }
    if ((this.dDp & 0x4) != 0) {
      localContentValues.put("personalcard", Integer.valueOf(this.ePt));
    }
    if ((this.dDp & 0x8) != 0)
    {
      if (this.ePu == null)
      {
        str = "";
        localContentValues.put("province", str);
      }
    }
    else
    {
      if ((this.dDp & 0x10) != 0)
      {
        if (this.ePv != null) {
          break label172;
        }
        str = "";
        label123:
        localContentValues.put("city", str);
      }
      if ((this.dDp & 0x20) != 0) {
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
      str = this.ePu;
      break;
      str = this.ePv;
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