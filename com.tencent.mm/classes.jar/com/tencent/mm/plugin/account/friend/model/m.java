package com.tencent.mm.plugin.account.friend.model;

import android.content.ContentValues;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class m
{
  int eQp;
  public int hdp;
  private int oFl;
  private int omO;
  private String omQ;
  private String omR;
  public int pSV;
  public String username;
  
  public m()
  {
    AppMethodBeat.i(131061);
    this.eQp = -1;
    this.username = "";
    this.pSV = 0;
    this.hdp = 0;
    this.omO = 0;
    this.oFl = 0;
    this.omQ = "";
    this.omR = "";
    AppMethodBeat.o(131061);
  }
  
  public final ContentValues convertTo()
  {
    AppMethodBeat.i(131062);
    ContentValues localContentValues = new ContentValues();
    if ((this.eQp & 0x1) != 0) {
      localContentValues.put("username", getUsername());
    }
    if ((this.eQp & 0x2) != 0) {
      localContentValues.put("friendtype", Integer.valueOf(this.pSV));
    }
    if ((this.eQp & 0x4) != 0) {
      localContentValues.put("updatetime", Integer.valueOf(this.hdp));
    }
    if ((this.eQp & 0x8) != 0) {
      localContentValues.put("reserved1", Integer.valueOf(this.omO));
    }
    if ((this.eQp & 0x10) != 0) {
      localContentValues.put("reserved2", Integer.valueOf(this.oFl));
    }
    if ((this.eQp & 0x20) != 0)
    {
      if (this.omQ == null)
      {
        str = "";
        localContentValues.put("reserved3", str);
      }
    }
    else if ((this.eQp & 0x40) != 0) {
      if (this.omR != null) {
        break label191;
      }
    }
    label191:
    for (String str = "";; str = this.omR)
    {
      localContentValues.put("reserved4", str);
      AppMethodBeat.o(131062);
      return localContentValues;
      str = this.omQ;
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
 * Qualified Name:     com.tencent.mm.plugin.account.friend.model.m
 * JD-Core Version:    0.7.0.1
 */