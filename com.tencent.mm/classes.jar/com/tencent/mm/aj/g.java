package com.tencent.mm.aj;

import android.content.ContentValues;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class g
{
  int bNu;
  int cSx;
  int iKM;
  int iKN;
  String iKO;
  int iKP;
  int iKQ;
  String iKR;
  String iKS;
  int iKT;
  int iKU;
  String username;
  
  public g()
  {
    AppMethodBeat.i(150279);
    this.cSx = -1;
    reset();
    AppMethodBeat.o(150279);
  }
  
  public final String aYp()
  {
    if (this.iKO == null) {
      return "";
    }
    return this.iKO;
  }
  
  public final ContentValues convertTo()
  {
    AppMethodBeat.i(150280);
    ContentValues localContentValues = new ContentValues();
    if ((this.cSx & 0x1) != 0)
    {
      if (this.username == null)
      {
        str = "";
        localContentValues.put("username", str);
      }
    }
    else
    {
      if ((this.cSx & 0x2) != 0) {
        localContentValues.put("imgwidth", Integer.valueOf(this.iKM));
      }
      if ((this.cSx & 0x4) != 0) {
        localContentValues.put("imgheigth", Integer.valueOf(this.iKN));
      }
      if ((this.cSx & 0x8) != 0) {
        localContentValues.put("imgformat", aYp());
      }
      if ((this.cSx & 0x10) != 0) {
        localContentValues.put("totallen", Integer.valueOf(this.iKP));
      }
      if ((this.cSx & 0x20) != 0) {
        localContentValues.put("startpos", Integer.valueOf(this.bNu));
      }
      if ((this.cSx & 0x40) != 0) {
        localContentValues.put("headimgtype", Integer.valueOf(this.iKQ));
      }
      if ((this.cSx & 0x80) != 0)
      {
        if (this.iKR != null) {
          break label291;
        }
        str = "";
        label193:
        localContentValues.put("reserved1", str);
      }
      if ((this.cSx & 0x100) != 0) {
        if (this.iKS != null) {
          break label299;
        }
      }
    }
    label291:
    label299:
    for (String str = "";; str = this.iKS)
    {
      localContentValues.put("reserved2", str);
      if ((this.cSx & 0x200) != 0) {
        localContentValues.put("reserved3", Integer.valueOf(this.iKT));
      }
      if ((this.cSx & 0x400) != 0) {
        localContentValues.put("reserved4", Integer.valueOf(this.iKU));
      }
      AppMethodBeat.o(150280);
      return localContentValues;
      str = this.username;
      break;
      str = this.iKR;
      break label193;
    }
  }
  
  public final void reset()
  {
    this.username = "";
    this.iKM = 0;
    this.iKN = 0;
    this.iKO = "";
    this.iKP = 0;
    this.bNu = 0;
    this.iKQ = 0;
    this.iKR = "";
    this.iKS = "";
    this.iKT = 0;
    this.iKU = 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.aj.g
 * JD-Core Version:    0.7.0.1
 */