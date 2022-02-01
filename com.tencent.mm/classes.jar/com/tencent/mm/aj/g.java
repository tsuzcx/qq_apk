package com.tencent.mm.aj;

import android.content.ContentValues;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class g
{
  int cUq;
  int drx;
  String huA;
  int huB;
  int huC;
  int huu;
  int huv;
  String huw;
  int hux;
  int huy;
  String huz;
  String username;
  
  public g()
  {
    AppMethodBeat.i(150279);
    this.drx = -1;
    reset();
    AppMethodBeat.o(150279);
  }
  
  public final String aBm()
  {
    if (this.huw == null) {
      return "";
    }
    return this.huw;
  }
  
  public final ContentValues convertTo()
  {
    AppMethodBeat.i(150280);
    ContentValues localContentValues = new ContentValues();
    if ((this.drx & 0x1) != 0)
    {
      if (this.username == null)
      {
        str = "";
        localContentValues.put("username", str);
      }
    }
    else
    {
      if ((this.drx & 0x2) != 0) {
        localContentValues.put("imgwidth", Integer.valueOf(this.huu));
      }
      if ((this.drx & 0x4) != 0) {
        localContentValues.put("imgheigth", Integer.valueOf(this.huv));
      }
      if ((this.drx & 0x8) != 0) {
        localContentValues.put("imgformat", aBm());
      }
      if ((this.drx & 0x10) != 0) {
        localContentValues.put("totallen", Integer.valueOf(this.hux));
      }
      if ((this.drx & 0x20) != 0) {
        localContentValues.put("startpos", Integer.valueOf(this.cUq));
      }
      if ((this.drx & 0x40) != 0) {
        localContentValues.put("headimgtype", Integer.valueOf(this.huy));
      }
      if ((this.drx & 0x80) != 0)
      {
        if (this.huz != null) {
          break label291;
        }
        str = "";
        label193:
        localContentValues.put("reserved1", str);
      }
      if ((this.drx & 0x100) != 0) {
        if (this.huA != null) {
          break label299;
        }
      }
    }
    label291:
    label299:
    for (String str = "";; str = this.huA)
    {
      localContentValues.put("reserved2", str);
      if ((this.drx & 0x200) != 0) {
        localContentValues.put("reserved3", Integer.valueOf(this.huB));
      }
      if ((this.drx & 0x400) != 0) {
        localContentValues.put("reserved4", Integer.valueOf(this.huC));
      }
      AppMethodBeat.o(150280);
      return localContentValues;
      str = this.username;
      break;
      str = this.huz;
      break label193;
    }
  }
  
  public final void reset()
  {
    this.username = "";
    this.huu = 0;
    this.huv = 0;
    this.huw = "";
    this.hux = 0;
    this.cUq = 0;
    this.huy = 0;
    this.huz = "";
    this.huA = "";
    this.huB = 0;
    this.huC = 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.aj.g
 * JD-Core Version:    0.7.0.1
 */