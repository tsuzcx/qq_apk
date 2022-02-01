package com.tencent.mm.plugin.account.friend.a;

import android.content.ContentValues;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class p
{
  public int cIT;
  int dtM;
  private int gOT;
  private String gOV;
  private String gOW;
  private int hfl;
  public int ikD;
  public String username;
  
  public p()
  {
    AppMethodBeat.i(131061);
    this.dtM = -1;
    this.username = "";
    this.ikD = 0;
    this.cIT = 0;
    this.gOT = 0;
    this.hfl = 0;
    this.gOV = "";
    this.gOW = "";
    AppMethodBeat.o(131061);
  }
  
  public final ContentValues convertTo()
  {
    AppMethodBeat.i(131062);
    ContentValues localContentValues = new ContentValues();
    if ((this.dtM & 0x1) != 0) {
      localContentValues.put("username", getUsername());
    }
    if ((this.dtM & 0x2) != 0) {
      localContentValues.put("friendtype", Integer.valueOf(this.ikD));
    }
    if ((this.dtM & 0x4) != 0) {
      localContentValues.put("updatetime", Integer.valueOf(this.cIT));
    }
    if ((this.dtM & 0x8) != 0) {
      localContentValues.put("reserved1", Integer.valueOf(this.gOT));
    }
    if ((this.dtM & 0x10) != 0) {
      localContentValues.put("reserved2", Integer.valueOf(this.hfl));
    }
    if ((this.dtM & 0x20) != 0)
    {
      if (this.gOV == null)
      {
        str = "";
        localContentValues.put("reserved3", str);
      }
    }
    else if ((this.dtM & 0x40) != 0) {
      if (this.gOW != null) {
        break label191;
      }
    }
    label191:
    for (String str = "";; str = this.gOW)
    {
      localContentValues.put("reserved4", str);
      AppMethodBeat.o(131062);
      return localContentValues;
      str = this.gOV;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.account.friend.a.p
 * JD-Core Version:    0.7.0.1
 */