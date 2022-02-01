package com.tencent.mm.plugin.account.friend.a;

import android.content.ContentValues;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class p
{
  public int cRP;
  int dEu;
  private int hKD;
  private String hKF;
  private String hKG;
  private int ibl;
  public int jgM;
  public String username;
  
  public p()
  {
    AppMethodBeat.i(131061);
    this.dEu = -1;
    this.username = "";
    this.jgM = 0;
    this.cRP = 0;
    this.hKD = 0;
    this.ibl = 0;
    this.hKF = "";
    this.hKG = "";
    AppMethodBeat.o(131061);
  }
  
  public final ContentValues convertTo()
  {
    AppMethodBeat.i(131062);
    ContentValues localContentValues = new ContentValues();
    if ((this.dEu & 0x1) != 0) {
      localContentValues.put("username", getUsername());
    }
    if ((this.dEu & 0x2) != 0) {
      localContentValues.put("friendtype", Integer.valueOf(this.jgM));
    }
    if ((this.dEu & 0x4) != 0) {
      localContentValues.put("updatetime", Integer.valueOf(this.cRP));
    }
    if ((this.dEu & 0x8) != 0) {
      localContentValues.put("reserved1", Integer.valueOf(this.hKD));
    }
    if ((this.dEu & 0x10) != 0) {
      localContentValues.put("reserved2", Integer.valueOf(this.ibl));
    }
    if ((this.dEu & 0x20) != 0)
    {
      if (this.hKF == null)
      {
        str = "";
        localContentValues.put("reserved3", str);
      }
    }
    else if ((this.dEu & 0x40) != 0) {
      if (this.hKG != null) {
        break label191;
      }
    }
    label191:
    for (String str = "";; str = this.hKG)
    {
      localContentValues.put("reserved4", str);
      AppMethodBeat.o(131062);
      return localContentValues;
      str = this.hKF;
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