package com.tencent.mm.aj;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Util;

public final class i
{
  public int cSx;
  public int fuz;
  public int iKV;
  public String iKW;
  public String iKX;
  private int iKY;
  int iKZ;
  public String username;
  
  public i()
  {
    AppMethodBeat.i(150283);
    this.cSx = -1;
    this.username = "";
    this.fuz = 0;
    this.iKV = 0;
    this.iKW = "";
    this.iKX = "";
    this.iKY = 0;
    this.iKZ = 0;
    AppMethodBeat.o(150283);
  }
  
  public final void Mv(String paramString)
  {
    this.iKX = paramString;
  }
  
  public final void Mw(String paramString)
  {
    this.iKW = paramString;
  }
  
  public final ContentValues aYq()
  {
    AppMethodBeat.i(150285);
    ContentValues localContentValues = new ContentValues();
    if ((this.cSx & 0x1) != 0) {
      localContentValues.put("username", getUsername());
    }
    if ((this.cSx & 0x2) != 0) {
      localContentValues.put("imgflag", Integer.valueOf(this.fuz));
    }
    if ((this.cSx & 0x4) != 0) {
      localContentValues.put("lastupdatetime", Integer.valueOf(this.iKV));
    }
    if ((this.cSx & 0x8) != 0) {
      localContentValues.put("reserved1", aYt());
    }
    if ((this.cSx & 0x10) != 0) {
      localContentValues.put("reserved2", aYu());
    }
    if ((this.cSx & 0x20) != 0) {
      localContentValues.put("reserved3", Integer.valueOf(this.iKY));
    }
    if ((this.cSx & 0x40) != 0) {
      localContentValues.put("reserved4", Integer.valueOf(this.iKZ));
    }
    AppMethodBeat.o(150285);
    return localContentValues;
  }
  
  public final void aYr()
  {
    this.cSx = -1;
  }
  
  public final void aYs()
  {
    this.fuz = 3;
  }
  
  public final String aYt()
  {
    if (this.iKX == null) {
      return "";
    }
    return this.iKX;
  }
  
  public final String aYu()
  {
    if (this.iKW == null) {
      return "";
    }
    return this.iKW;
  }
  
  public final void aYv()
  {
    AppMethodBeat.i(150286);
    this.iKZ = ((int)(Util.nowSecond() / 60L));
    this.cSx |= 0x40;
    AppMethodBeat.o(150286);
  }
  
  public final void convertFrom(Cursor paramCursor)
  {
    AppMethodBeat.i(150284);
    this.username = paramCursor.getString(0);
    this.fuz = paramCursor.getInt(1);
    this.iKV = paramCursor.getInt(2);
    this.iKX = paramCursor.getString(3);
    this.iKW = paramCursor.getString(4);
    this.iKY = paramCursor.getInt(5);
    this.iKZ = paramCursor.getInt(6);
    AppMethodBeat.o(150284);
  }
  
  public final void fv(boolean paramBoolean)
  {
    if (paramBoolean) {}
    for (int i = 1;; i = 0)
    {
      this.iKY = i;
      return;
    }
  }
  
  public final String getUsername()
  {
    if (this.username == null) {
      return "";
    }
    return this.username;
  }
  
  public final void setUsername(String paramString)
  {
    this.username = paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.aj.i
 * JD-Core Version:    0.7.0.1
 */