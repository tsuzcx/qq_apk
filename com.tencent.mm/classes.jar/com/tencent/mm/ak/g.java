package com.tencent.mm.ak;

import android.content.ContentValues;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class g
{
  int dDp;
  int dfG;
  int hMM;
  int hMN;
  String hMO;
  int hMP;
  int hMQ;
  String hMR;
  String hMS;
  int hMT;
  int hMU;
  String username;
  
  public g()
  {
    AppMethodBeat.i(150279);
    this.dDp = -1;
    reset();
    AppMethodBeat.o(150279);
  }
  
  public final String aEo()
  {
    if (this.hMO == null) {
      return "";
    }
    return this.hMO;
  }
  
  public final ContentValues convertTo()
  {
    AppMethodBeat.i(150280);
    ContentValues localContentValues = new ContentValues();
    if ((this.dDp & 0x1) != 0)
    {
      if (this.username == null)
      {
        str = "";
        localContentValues.put("username", str);
      }
    }
    else
    {
      if ((this.dDp & 0x2) != 0) {
        localContentValues.put("imgwidth", Integer.valueOf(this.hMM));
      }
      if ((this.dDp & 0x4) != 0) {
        localContentValues.put("imgheigth", Integer.valueOf(this.hMN));
      }
      if ((this.dDp & 0x8) != 0) {
        localContentValues.put("imgformat", aEo());
      }
      if ((this.dDp & 0x10) != 0) {
        localContentValues.put("totallen", Integer.valueOf(this.hMP));
      }
      if ((this.dDp & 0x20) != 0) {
        localContentValues.put("startpos", Integer.valueOf(this.dfG));
      }
      if ((this.dDp & 0x40) != 0) {
        localContentValues.put("headimgtype", Integer.valueOf(this.hMQ));
      }
      if ((this.dDp & 0x80) != 0)
      {
        if (this.hMR != null) {
          break label291;
        }
        str = "";
        label193:
        localContentValues.put("reserved1", str);
      }
      if ((this.dDp & 0x100) != 0) {
        if (this.hMS != null) {
          break label299;
        }
      }
    }
    label291:
    label299:
    for (String str = "";; str = this.hMS)
    {
      localContentValues.put("reserved2", str);
      if ((this.dDp & 0x200) != 0) {
        localContentValues.put("reserved3", Integer.valueOf(this.hMT));
      }
      if ((this.dDp & 0x400) != 0) {
        localContentValues.put("reserved4", Integer.valueOf(this.hMU));
      }
      AppMethodBeat.o(150280);
      return localContentValues;
      str = this.username;
      break;
      str = this.hMR;
      break label193;
    }
  }
  
  public final void reset()
  {
    this.username = "";
    this.hMM = 0;
    this.hMN = 0;
    this.hMO = "";
    this.hMP = 0;
    this.dfG = 0;
    this.hMQ = 0;
    this.hMR = "";
    this.hMS = "";
    this.hMT = 0;
    this.hMU = 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ak.g
 * JD-Core Version:    0.7.0.1
 */