package com.tencent.mm.ah;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.bo;

public final class h
{
  public int bsY;
  public int dqB;
  public int fsj;
  public String fsk;
  public String fsl;
  private int fsm;
  int fsn;
  public String username;
  
  public h()
  {
    AppMethodBeat.i(77919);
    this.bsY = -1;
    this.username = "";
    this.dqB = 0;
    this.fsj = 0;
    this.fsk = "";
    this.fsl = "";
    this.fsm = 0;
    this.fsn = 0;
    AppMethodBeat.o(77919);
  }
  
  public final ContentValues acW()
  {
    AppMethodBeat.i(77921);
    ContentValues localContentValues = new ContentValues();
    if ((this.bsY & 0x1) != 0) {
      localContentValues.put("username", getUsername());
    }
    if ((this.bsY & 0x2) != 0) {
      localContentValues.put("imgflag", Integer.valueOf(this.dqB));
    }
    if ((this.bsY & 0x4) != 0) {
      localContentValues.put("lastupdatetime", Integer.valueOf(this.fsj));
    }
    if ((this.bsY & 0x8) != 0) {
      localContentValues.put("reserved1", acX());
    }
    if ((this.bsY & 0x10) != 0) {
      localContentValues.put("reserved2", acY());
    }
    if ((this.bsY & 0x20) != 0) {
      localContentValues.put("reserved3", Integer.valueOf(this.fsm));
    }
    if ((this.bsY & 0x40) != 0) {
      localContentValues.put("reserved4", Integer.valueOf(this.fsn));
    }
    AppMethodBeat.o(77921);
    return localContentValues;
  }
  
  public final String acX()
  {
    if (this.fsl == null) {
      return "";
    }
    return this.fsl;
  }
  
  public final String acY()
  {
    if (this.fsk == null) {
      return "";
    }
    return this.fsk;
  }
  
  public final void acZ()
  {
    AppMethodBeat.i(77922);
    this.fsn = ((int)(bo.aox() / 60L));
    this.bsY |= 0x40;
    AppMethodBeat.o(77922);
  }
  
  public final void cM(boolean paramBoolean)
  {
    if (paramBoolean) {}
    for (int i = 1;; i = 0)
    {
      this.fsm = i;
      return;
    }
  }
  
  public final void convertFrom(Cursor paramCursor)
  {
    AppMethodBeat.i(77920);
    this.username = paramCursor.getString(0);
    this.dqB = paramCursor.getInt(1);
    this.fsj = paramCursor.getInt(2);
    this.fsl = paramCursor.getString(3);
    this.fsk = paramCursor.getString(4);
    this.fsm = paramCursor.getInt(5);
    this.fsn = paramCursor.getInt(6);
    AppMethodBeat.o(77920);
  }
  
  public final String getUsername()
  {
    if (this.username == null) {
      return "";
    }
    return this.username;
  }
  
  public final void ri(String paramString)
  {
    this.fsk = paramString;
  }
  
  public final void setUsername(String paramString)
  {
    this.username = paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ah.h
 * JD-Core Version:    0.7.0.1
 */