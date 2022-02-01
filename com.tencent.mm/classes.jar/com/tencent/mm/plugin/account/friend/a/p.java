package com.tencent.mm.plugin.account.friend.a;

import android.content.ContentValues;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class p
{
  int cSx;
  public int dii;
  private int iFr;
  private String iFt;
  private String iFu;
  private int iWj;
  public int keQ;
  public String username;
  
  public p()
  {
    AppMethodBeat.i(131061);
    this.cSx = -1;
    this.username = "";
    this.keQ = 0;
    this.dii = 0;
    this.iFr = 0;
    this.iWj = 0;
    this.iFt = "";
    this.iFu = "";
    AppMethodBeat.o(131061);
  }
  
  public final ContentValues convertTo()
  {
    AppMethodBeat.i(131062);
    ContentValues localContentValues = new ContentValues();
    if ((this.cSx & 0x1) != 0) {
      localContentValues.put("username", getUsername());
    }
    if ((this.cSx & 0x2) != 0) {
      localContentValues.put("friendtype", Integer.valueOf(this.keQ));
    }
    if ((this.cSx & 0x4) != 0) {
      localContentValues.put("updatetime", Integer.valueOf(this.dii));
    }
    if ((this.cSx & 0x8) != 0) {
      localContentValues.put("reserved1", Integer.valueOf(this.iFr));
    }
    if ((this.cSx & 0x10) != 0) {
      localContentValues.put("reserved2", Integer.valueOf(this.iWj));
    }
    if ((this.cSx & 0x20) != 0)
    {
      if (this.iFt == null)
      {
        str = "";
        localContentValues.put("reserved3", str);
      }
    }
    else if ((this.cSx & 0x40) != 0) {
      if (this.iFu != null) {
        break label191;
      }
    }
    label191:
    for (String str = "";; str = this.iFu)
    {
      localContentValues.put("reserved4", str);
      AppMethodBeat.o(131062);
      return localContentValues;
      str = this.iFt;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.account.friend.a.p
 * JD-Core Version:    0.7.0.1
 */