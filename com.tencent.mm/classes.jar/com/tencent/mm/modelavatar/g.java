package com.tencent.mm.modelavatar;

import android.content.ContentValues;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class g
{
  int dIY;
  int eQp;
  String osA;
  String osB;
  int osC;
  int osD;
  int osv;
  int osw;
  String osx;
  int osy;
  int osz;
  String username;
  
  public g()
  {
    AppMethodBeat.i(150279);
    this.eQp = -1;
    reset();
    AppMethodBeat.o(150279);
  }
  
  public final String bFt()
  {
    if (this.osx == null) {
      return "";
    }
    return this.osx;
  }
  
  public final ContentValues convertTo()
  {
    AppMethodBeat.i(150280);
    ContentValues localContentValues = new ContentValues();
    if ((this.eQp & 0x1) != 0)
    {
      if (this.username == null)
      {
        str = "";
        localContentValues.put("username", str);
      }
    }
    else
    {
      if ((this.eQp & 0x2) != 0) {
        localContentValues.put("imgwidth", Integer.valueOf(this.osv));
      }
      if ((this.eQp & 0x4) != 0) {
        localContentValues.put("imgheigth", Integer.valueOf(this.osw));
      }
      if ((this.eQp & 0x8) != 0) {
        localContentValues.put("imgformat", bFt());
      }
      if ((this.eQp & 0x10) != 0) {
        localContentValues.put("totallen", Integer.valueOf(this.osy));
      }
      if ((this.eQp & 0x20) != 0) {
        localContentValues.put("startpos", Integer.valueOf(this.dIY));
      }
      if ((this.eQp & 0x40) != 0) {
        localContentValues.put("headimgtype", Integer.valueOf(this.osz));
      }
      if ((this.eQp & 0x80) != 0)
      {
        if (this.osA != null) {
          break label291;
        }
        str = "";
        label193:
        localContentValues.put("reserved1", str);
      }
      if ((this.eQp & 0x100) != 0) {
        if (this.osB != null) {
          break label299;
        }
      }
    }
    label291:
    label299:
    for (String str = "";; str = this.osB)
    {
      localContentValues.put("reserved2", str);
      if ((this.eQp & 0x200) != 0) {
        localContentValues.put("reserved3", Integer.valueOf(this.osC));
      }
      if ((this.eQp & 0x400) != 0) {
        localContentValues.put("reserved4", Integer.valueOf(this.osD));
      }
      AppMethodBeat.o(150280);
      return localContentValues;
      str = this.username;
      break;
      str = this.osA;
      break label193;
    }
  }
  
  public final void reset()
  {
    this.username = "";
    this.osv = 0;
    this.osw = 0;
    this.osx = "";
    this.osy = 0;
    this.dIY = 0;
    this.osz = 0;
    this.osA = "";
    this.osB = "";
    this.osC = 0;
    this.osD = 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.modelavatar.g
 * JD-Core Version:    0.7.0.1
 */