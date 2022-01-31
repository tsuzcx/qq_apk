package com.tencent.mm.plugin.account.friend.a;

import android.content.ContentValues;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class p
{
  int bsY;
  private int fCK;
  private int fns;
  private String fnu;
  private String fnv;
  public int fvK;
  public int gxG;
  public String username;
  
  public p()
  {
    AppMethodBeat.i(108400);
    this.bsY = -1;
    this.username = "";
    this.gxG = 0;
    this.fvK = 0;
    this.fns = 0;
    this.fCK = 0;
    this.fnu = "";
    this.fnv = "";
    AppMethodBeat.o(108400);
  }
  
  public final ContentValues convertTo()
  {
    AppMethodBeat.i(108401);
    ContentValues localContentValues = new ContentValues();
    if ((this.bsY & 0x1) != 0) {
      localContentValues.put("username", getUsername());
    }
    if ((this.bsY & 0x2) != 0) {
      localContentValues.put("friendtype", Integer.valueOf(this.gxG));
    }
    if ((this.bsY & 0x4) != 0) {
      localContentValues.put("updatetime", Integer.valueOf(this.fvK));
    }
    if ((this.bsY & 0x8) != 0) {
      localContentValues.put("reserved1", Integer.valueOf(this.fns));
    }
    if ((this.bsY & 0x10) != 0) {
      localContentValues.put("reserved2", Integer.valueOf(this.fCK));
    }
    if ((this.bsY & 0x20) != 0)
    {
      if (this.fnu == null)
      {
        str = "";
        localContentValues.put("reserved3", str);
      }
    }
    else if ((this.bsY & 0x40) != 0) {
      if (this.fnv != null) {
        break label191;
      }
    }
    label191:
    for (String str = "";; str = this.fnv)
    {
      localContentValues.put("reserved4", str);
      AppMethodBeat.o(108401);
      return localContentValues;
      str = this.fnu;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.account.friend.a.p
 * JD-Core Version:    0.7.0.1
 */