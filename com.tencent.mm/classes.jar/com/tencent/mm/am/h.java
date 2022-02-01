package com.tencent.mm.am;

import android.content.ContentValues;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class h
{
  int bPt;
  int cUP;
  int lAT;
  int lAU;
  String lAV;
  int lAW;
  int lAX;
  String lAY;
  String lAZ;
  int lBa;
  int lBb;
  String username;
  
  public h()
  {
    AppMethodBeat.i(150279);
    this.cUP = -1;
    reset();
    AppMethodBeat.o(150279);
  }
  
  public final String bhD()
  {
    if (this.lAV == null) {
      return "";
    }
    return this.lAV;
  }
  
  public final ContentValues convertTo()
  {
    AppMethodBeat.i(150280);
    ContentValues localContentValues = new ContentValues();
    if ((this.cUP & 0x1) != 0)
    {
      if (this.username == null)
      {
        str = "";
        localContentValues.put("username", str);
      }
    }
    else
    {
      if ((this.cUP & 0x2) != 0) {
        localContentValues.put("imgwidth", Integer.valueOf(this.lAT));
      }
      if ((this.cUP & 0x4) != 0) {
        localContentValues.put("imgheigth", Integer.valueOf(this.lAU));
      }
      if ((this.cUP & 0x8) != 0) {
        localContentValues.put("imgformat", bhD());
      }
      if ((this.cUP & 0x10) != 0) {
        localContentValues.put("totallen", Integer.valueOf(this.lAW));
      }
      if ((this.cUP & 0x20) != 0) {
        localContentValues.put("startpos", Integer.valueOf(this.bPt));
      }
      if ((this.cUP & 0x40) != 0) {
        localContentValues.put("headimgtype", Integer.valueOf(this.lAX));
      }
      if ((this.cUP & 0x80) != 0)
      {
        if (this.lAY != null) {
          break label291;
        }
        str = "";
        label193:
        localContentValues.put("reserved1", str);
      }
      if ((this.cUP & 0x100) != 0) {
        if (this.lAZ != null) {
          break label299;
        }
      }
    }
    label291:
    label299:
    for (String str = "";; str = this.lAZ)
    {
      localContentValues.put("reserved2", str);
      if ((this.cUP & 0x200) != 0) {
        localContentValues.put("reserved3", Integer.valueOf(this.lBa));
      }
      if ((this.cUP & 0x400) != 0) {
        localContentValues.put("reserved4", Integer.valueOf(this.lBb));
      }
      AppMethodBeat.o(150280);
      return localContentValues;
      str = this.username;
      break;
      str = this.lAY;
      break label193;
    }
  }
  
  public final void reset()
  {
    this.username = "";
    this.lAT = 0;
    this.lAU = 0;
    this.lAV = "";
    this.lAW = 0;
    this.bPt = 0;
    this.lAX = 0;
    this.lAY = "";
    this.lAZ = "";
    this.lBa = 0;
    this.lBb = 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.am.h
 * JD-Core Version:    0.7.0.1
 */