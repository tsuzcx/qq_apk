package com.tencent.mm.aj;

import android.content.ContentValues;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class g
{
  int dEu;
  int dgI;
  int hPF;
  int hPG;
  String hPH;
  int hPI;
  int hPJ;
  String hPK;
  String hPL;
  int hPM;
  int hPN;
  String username;
  
  public g()
  {
    AppMethodBeat.i(150279);
    this.dEu = -1;
    reset();
    AppMethodBeat.o(150279);
  }
  
  public final String aEE()
  {
    if (this.hPH == null) {
      return "";
    }
    return this.hPH;
  }
  
  public final ContentValues convertTo()
  {
    AppMethodBeat.i(150280);
    ContentValues localContentValues = new ContentValues();
    if ((this.dEu & 0x1) != 0)
    {
      if (this.username == null)
      {
        str = "";
        localContentValues.put("username", str);
      }
    }
    else
    {
      if ((this.dEu & 0x2) != 0) {
        localContentValues.put("imgwidth", Integer.valueOf(this.hPF));
      }
      if ((this.dEu & 0x4) != 0) {
        localContentValues.put("imgheigth", Integer.valueOf(this.hPG));
      }
      if ((this.dEu & 0x8) != 0) {
        localContentValues.put("imgformat", aEE());
      }
      if ((this.dEu & 0x10) != 0) {
        localContentValues.put("totallen", Integer.valueOf(this.hPI));
      }
      if ((this.dEu & 0x20) != 0) {
        localContentValues.put("startpos", Integer.valueOf(this.dgI));
      }
      if ((this.dEu & 0x40) != 0) {
        localContentValues.put("headimgtype", Integer.valueOf(this.hPJ));
      }
      if ((this.dEu & 0x80) != 0)
      {
        if (this.hPK != null) {
          break label291;
        }
        str = "";
        label193:
        localContentValues.put("reserved1", str);
      }
      if ((this.dEu & 0x100) != 0) {
        if (this.hPL != null) {
          break label299;
        }
      }
    }
    label291:
    label299:
    for (String str = "";; str = this.hPL)
    {
      localContentValues.put("reserved2", str);
      if ((this.dEu & 0x200) != 0) {
        localContentValues.put("reserved3", Integer.valueOf(this.hPM));
      }
      if ((this.dEu & 0x400) != 0) {
        localContentValues.put("reserved4", Integer.valueOf(this.hPN));
      }
      AppMethodBeat.o(150280);
      return localContentValues;
      str = this.username;
      break;
      str = this.hPK;
      break label193;
    }
  }
  
  public final void reset()
  {
    this.username = "";
    this.hPF = 0;
    this.hPG = 0;
    this.hPH = "";
    this.hPI = 0;
    this.dgI = 0;
    this.hPJ = 0;
    this.hPK = "";
    this.hPL = "";
    this.hPM = 0;
    this.hPN = 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.aj.g
 * JD-Core Version:    0.7.0.1
 */