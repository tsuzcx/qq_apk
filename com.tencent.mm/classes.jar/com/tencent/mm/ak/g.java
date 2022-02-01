package com.tencent.mm.ak;

import android.content.ContentValues;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class g
{
  int cWU;
  int dtM;
  int gTV;
  int gTW;
  String gTX;
  int gTY;
  int gTZ;
  String gUa;
  String gUb;
  int gUc;
  int gUd;
  String username;
  
  public g()
  {
    AppMethodBeat.i(150279);
    this.dtM = -1;
    reset();
    AppMethodBeat.o(150279);
  }
  
  public final String auv()
  {
    if (this.gTX == null) {
      return "";
    }
    return this.gTX;
  }
  
  public final ContentValues convertTo()
  {
    AppMethodBeat.i(150280);
    ContentValues localContentValues = new ContentValues();
    if ((this.dtM & 0x1) != 0)
    {
      if (this.username == null)
      {
        str = "";
        localContentValues.put("username", str);
      }
    }
    else
    {
      if ((this.dtM & 0x2) != 0) {
        localContentValues.put("imgwidth", Integer.valueOf(this.gTV));
      }
      if ((this.dtM & 0x4) != 0) {
        localContentValues.put("imgheigth", Integer.valueOf(this.gTW));
      }
      if ((this.dtM & 0x8) != 0) {
        localContentValues.put("imgformat", auv());
      }
      if ((this.dtM & 0x10) != 0) {
        localContentValues.put("totallen", Integer.valueOf(this.gTY));
      }
      if ((this.dtM & 0x20) != 0) {
        localContentValues.put("startpos", Integer.valueOf(this.cWU));
      }
      if ((this.dtM & 0x40) != 0) {
        localContentValues.put("headimgtype", Integer.valueOf(this.gTZ));
      }
      if ((this.dtM & 0x80) != 0)
      {
        if (this.gUa != null) {
          break label291;
        }
        str = "";
        label193:
        localContentValues.put("reserved1", str);
      }
      if ((this.dtM & 0x100) != 0) {
        if (this.gUb != null) {
          break label299;
        }
      }
    }
    label291:
    label299:
    for (String str = "";; str = this.gUb)
    {
      localContentValues.put("reserved2", str);
      if ((this.dtM & 0x200) != 0) {
        localContentValues.put("reserved3", Integer.valueOf(this.gUc));
      }
      if ((this.dtM & 0x400) != 0) {
        localContentValues.put("reserved4", Integer.valueOf(this.gUd));
      }
      AppMethodBeat.o(150280);
      return localContentValues;
      str = this.username;
      break;
      str = this.gUa;
      break label193;
    }
  }
  
  public final void reset()
  {
    this.username = "";
    this.gTV = 0;
    this.gTW = 0;
    this.gTX = "";
    this.gTY = 0;
    this.cWU = 0;
    this.gTZ = 0;
    this.gUa = "";
    this.gUb = "";
    this.gUc = 0;
    this.gUd = 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.ak.g
 * JD-Core Version:    0.7.0.1
 */