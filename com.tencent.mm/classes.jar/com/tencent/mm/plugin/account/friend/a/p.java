package com.tencent.mm.plugin.account.friend.a;

import android.content.ContentValues;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class p
{
  public int cRf;
  int dDp;
  private int hHL;
  private String hHN;
  private String hHO;
  private int hYt;
  public int jdT;
  public String username;
  
  public p()
  {
    AppMethodBeat.i(131061);
    this.dDp = -1;
    this.username = "";
    this.jdT = 0;
    this.cRf = 0;
    this.hHL = 0;
    this.hYt = 0;
    this.hHN = "";
    this.hHO = "";
    AppMethodBeat.o(131061);
  }
  
  public final ContentValues convertTo()
  {
    AppMethodBeat.i(131062);
    ContentValues localContentValues = new ContentValues();
    if ((this.dDp & 0x1) != 0) {
      localContentValues.put("username", getUsername());
    }
    if ((this.dDp & 0x2) != 0) {
      localContentValues.put("friendtype", Integer.valueOf(this.jdT));
    }
    if ((this.dDp & 0x4) != 0) {
      localContentValues.put("updatetime", Integer.valueOf(this.cRf));
    }
    if ((this.dDp & 0x8) != 0) {
      localContentValues.put("reserved1", Integer.valueOf(this.hHL));
    }
    if ((this.dDp & 0x10) != 0) {
      localContentValues.put("reserved2", Integer.valueOf(this.hYt));
    }
    if ((this.dDp & 0x20) != 0)
    {
      if (this.hHN == null)
      {
        str = "";
        localContentValues.put("reserved3", str);
      }
    }
    else if ((this.dDp & 0x40) != 0) {
      if (this.hHO != null) {
        break label191;
      }
    }
    label191:
    for (String str = "";; str = this.hHO)
    {
      localContentValues.put("reserved4", str);
      AppMethodBeat.o(131062);
      return localContentValues;
      str = this.hHN;
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