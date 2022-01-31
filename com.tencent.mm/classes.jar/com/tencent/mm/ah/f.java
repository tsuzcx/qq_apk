package com.tencent.mm.ah;

import android.content.ContentValues;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class f
{
  int bsY;
  int chT;
  int fsa;
  int fsb;
  String fsc;
  int fsd;
  int fse;
  String fsf;
  String fsg;
  int fsh;
  int fsi;
  String username;
  
  public f()
  {
    AppMethodBeat.i(77915);
    this.bsY = -1;
    reset();
    AppMethodBeat.o(77915);
  }
  
  public final String acV()
  {
    if (this.fsc == null) {
      return "";
    }
    return this.fsc;
  }
  
  public final ContentValues convertTo()
  {
    AppMethodBeat.i(77916);
    ContentValues localContentValues = new ContentValues();
    if ((this.bsY & 0x1) != 0)
    {
      if (this.username == null)
      {
        str = "";
        localContentValues.put("username", str);
      }
    }
    else
    {
      if ((this.bsY & 0x2) != 0) {
        localContentValues.put("imgwidth", Integer.valueOf(this.fsa));
      }
      if ((this.bsY & 0x4) != 0) {
        localContentValues.put("imgheigth", Integer.valueOf(this.fsb));
      }
      if ((this.bsY & 0x8) != 0) {
        localContentValues.put("imgformat", acV());
      }
      if ((this.bsY & 0x10) != 0) {
        localContentValues.put("totallen", Integer.valueOf(this.fsd));
      }
      if ((this.bsY & 0x20) != 0) {
        localContentValues.put("startpos", Integer.valueOf(this.chT));
      }
      if ((this.bsY & 0x40) != 0) {
        localContentValues.put("headimgtype", Integer.valueOf(this.fse));
      }
      if ((this.bsY & 0x80) != 0)
      {
        if (this.fsf != null) {
          break label291;
        }
        str = "";
        label193:
        localContentValues.put("reserved1", str);
      }
      if ((this.bsY & 0x100) != 0) {
        if (this.fsg != null) {
          break label299;
        }
      }
    }
    label291:
    label299:
    for (String str = "";; str = this.fsg)
    {
      localContentValues.put("reserved2", str);
      if ((this.bsY & 0x200) != 0) {
        localContentValues.put("reserved3", Integer.valueOf(this.fsh));
      }
      if ((this.bsY & 0x400) != 0) {
        localContentValues.put("reserved4", Integer.valueOf(this.fsi));
      }
      AppMethodBeat.o(77916);
      return localContentValues;
      str = this.username;
      break;
      str = this.fsf;
      break label193;
    }
  }
  
  public final void reset()
  {
    this.username = "";
    this.fsa = 0;
    this.fsb = 0;
    this.fsc = "";
    this.fsd = 0;
    this.chT = 0;
    this.fse = 0;
    this.fsf = "";
    this.fsg = "";
    this.fsh = 0;
    this.fsi = 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.ah.f
 * JD-Core Version:    0.7.0.1
 */