package com.tencent.mm.ak;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.bt;

public final class i
{
  public int dDp;
  public int ePj;
  public int hMV;
  public String hMW;
  public String hMX;
  private int hMY;
  int hMZ;
  public String username;
  
  public i()
  {
    AppMethodBeat.i(150283);
    this.dDp = -1;
    this.username = "";
    this.ePj = 0;
    this.hMV = 0;
    this.hMW = "";
    this.hMX = "";
    this.hMY = 0;
    this.hMZ = 0;
    AppMethodBeat.o(150283);
  }
  
  public final void Di(String paramString)
  {
    this.hMW = paramString;
  }
  
  public final ContentValues aEp()
  {
    AppMethodBeat.i(150285);
    ContentValues localContentValues = new ContentValues();
    if ((this.dDp & 0x1) != 0) {
      localContentValues.put("username", getUsername());
    }
    if ((this.dDp & 0x2) != 0) {
      localContentValues.put("imgflag", Integer.valueOf(this.ePj));
    }
    if ((this.dDp & 0x4) != 0) {
      localContentValues.put("lastupdatetime", Integer.valueOf(this.hMV));
    }
    if ((this.dDp & 0x8) != 0) {
      localContentValues.put("reserved1", aEq());
    }
    if ((this.dDp & 0x10) != 0) {
      localContentValues.put("reserved2", aEr());
    }
    if ((this.dDp & 0x20) != 0) {
      localContentValues.put("reserved3", Integer.valueOf(this.hMY));
    }
    if ((this.dDp & 0x40) != 0) {
      localContentValues.put("reserved4", Integer.valueOf(this.hMZ));
    }
    AppMethodBeat.o(150285);
    return localContentValues;
  }
  
  public final String aEq()
  {
    if (this.hMX == null) {
      return "";
    }
    return this.hMX;
  }
  
  public final String aEr()
  {
    if (this.hMW == null) {
      return "";
    }
    return this.hMW;
  }
  
  public final void aEs()
  {
    AppMethodBeat.i(150286);
    this.hMZ = ((int)(bt.aQJ() / 60L));
    this.dDp |= 0x40;
    AppMethodBeat.o(150286);
  }
  
  public final void convertFrom(Cursor paramCursor)
  {
    AppMethodBeat.i(150284);
    this.username = paramCursor.getString(0);
    this.ePj = paramCursor.getInt(1);
    this.hMV = paramCursor.getInt(2);
    this.hMX = paramCursor.getString(3);
    this.hMW = paramCursor.getString(4);
    this.hMY = paramCursor.getInt(5);
    this.hMZ = paramCursor.getInt(6);
    AppMethodBeat.o(150284);
  }
  
  public final void eB(boolean paramBoolean)
  {
    if (paramBoolean) {}
    for (int i = 1;; i = 0)
    {
      this.hMY = i;
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
 * Qualified Name:     com.tencent.mm.ak.i
 * JD-Core Version:    0.7.0.1
 */