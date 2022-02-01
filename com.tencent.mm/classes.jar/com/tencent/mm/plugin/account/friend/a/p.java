package com.tencent.mm.plugin.account.friend.a;

import android.content.ContentValues;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class p
{
  int cUP;
  public int eZP;
  private int lME;
  private int lvr;
  private String lvt;
  private String lvu;
  public int mWp;
  public String username;
  
  public p()
  {
    AppMethodBeat.i(131061);
    this.cUP = -1;
    this.username = "";
    this.mWp = 0;
    this.eZP = 0;
    this.lvr = 0;
    this.lME = 0;
    this.lvt = "";
    this.lvu = "";
    AppMethodBeat.o(131061);
  }
  
  public final ContentValues convertTo()
  {
    AppMethodBeat.i(131062);
    ContentValues localContentValues = new ContentValues();
    if ((this.cUP & 0x1) != 0) {
      localContentValues.put("username", getUsername());
    }
    if ((this.cUP & 0x2) != 0) {
      localContentValues.put("friendtype", Integer.valueOf(this.mWp));
    }
    if ((this.cUP & 0x4) != 0) {
      localContentValues.put("updatetime", Integer.valueOf(this.eZP));
    }
    if ((this.cUP & 0x8) != 0) {
      localContentValues.put("reserved1", Integer.valueOf(this.lvr));
    }
    if ((this.cUP & 0x10) != 0) {
      localContentValues.put("reserved2", Integer.valueOf(this.lME));
    }
    if ((this.cUP & 0x20) != 0)
    {
      if (this.lvt == null)
      {
        str = "";
        localContentValues.put("reserved3", str);
      }
    }
    else if ((this.cUP & 0x40) != 0) {
      if (this.lvu != null) {
        break label191;
      }
    }
    label191:
    for (String str = "";; str = this.lvu)
    {
      localContentValues.put("reserved4", str);
      AppMethodBeat.o(131062);
      return localContentValues;
      str = this.lvt;
      break;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.account.friend.a.p
 * JD-Core Version:    0.7.0.1
 */