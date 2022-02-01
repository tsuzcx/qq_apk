package com.tencent.mm.plugin.account.friend.a;

import android.content.ContentValues;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class p
{
  public int cGa;
  int drx;
  private int hFO;
  private int hpt;
  private String hpv;
  private String hpw;
  public int iKK;
  public String username;
  
  public p()
  {
    AppMethodBeat.i(131061);
    this.drx = -1;
    this.username = "";
    this.iKK = 0;
    this.cGa = 0;
    this.hpt = 0;
    this.hFO = 0;
    this.hpv = "";
    this.hpw = "";
    AppMethodBeat.o(131061);
  }
  
  public final ContentValues convertTo()
  {
    AppMethodBeat.i(131062);
    ContentValues localContentValues = new ContentValues();
    if ((this.drx & 0x1) != 0) {
      localContentValues.put("username", getUsername());
    }
    if ((this.drx & 0x2) != 0) {
      localContentValues.put("friendtype", Integer.valueOf(this.iKK));
    }
    if ((this.drx & 0x4) != 0) {
      localContentValues.put("updatetime", Integer.valueOf(this.cGa));
    }
    if ((this.drx & 0x8) != 0) {
      localContentValues.put("reserved1", Integer.valueOf(this.hpt));
    }
    if ((this.drx & 0x10) != 0) {
      localContentValues.put("reserved2", Integer.valueOf(this.hFO));
    }
    if ((this.drx & 0x20) != 0)
    {
      if (this.hpv == null)
      {
        str = "";
        localContentValues.put("reserved3", str);
      }
    }
    else if ((this.drx & 0x40) != 0) {
      if (this.hpw != null) {
        break label191;
      }
    }
    label191:
    for (String str = "";; str = this.hpw)
    {
      localContentValues.put("reserved4", str);
      AppMethodBeat.o(131062);
      return localContentValues;
      str = this.hpv;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.account.friend.a.p
 * JD-Core Version:    0.7.0.1
 */