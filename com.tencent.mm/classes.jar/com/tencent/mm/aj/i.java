package com.tencent.mm.aj;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.bs;

public final class i
{
  public int drx;
  public int exK;
  public int huD;
  public String huE;
  public String huF;
  private int huG;
  int huH;
  public String username;
  
  public i()
  {
    AppMethodBeat.i(150283);
    this.drx = -1;
    this.username = "";
    this.exK = 0;
    this.huD = 0;
    this.huE = "";
    this.huF = "";
    this.huG = 0;
    this.huH = 0;
    AppMethodBeat.o(150283);
  }
  
  public final void Aj(String paramString)
  {
    this.huE = paramString;
  }
  
  public final ContentValues aBn()
  {
    AppMethodBeat.i(150285);
    ContentValues localContentValues = new ContentValues();
    if ((this.drx & 0x1) != 0) {
      localContentValues.put("username", getUsername());
    }
    if ((this.drx & 0x2) != 0) {
      localContentValues.put("imgflag", Integer.valueOf(this.exK));
    }
    if ((this.drx & 0x4) != 0) {
      localContentValues.put("lastupdatetime", Integer.valueOf(this.huD));
    }
    if ((this.drx & 0x8) != 0) {
      localContentValues.put("reserved1", aBo());
    }
    if ((this.drx & 0x10) != 0) {
      localContentValues.put("reserved2", aBp());
    }
    if ((this.drx & 0x20) != 0) {
      localContentValues.put("reserved3", Integer.valueOf(this.huG));
    }
    if ((this.drx & 0x40) != 0) {
      localContentValues.put("reserved4", Integer.valueOf(this.huH));
    }
    AppMethodBeat.o(150285);
    return localContentValues;
  }
  
  public final String aBo()
  {
    if (this.huF == null) {
      return "";
    }
    return this.huF;
  }
  
  public final String aBp()
  {
    if (this.huE == null) {
      return "";
    }
    return this.huE;
  }
  
  public final void aBq()
  {
    AppMethodBeat.i(150286);
    this.huH = ((int)(bs.aNx() / 60L));
    this.drx |= 0x40;
    AppMethodBeat.o(150286);
  }
  
  public final void convertFrom(Cursor paramCursor)
  {
    AppMethodBeat.i(150284);
    this.username = paramCursor.getString(0);
    this.exK = paramCursor.getInt(1);
    this.huD = paramCursor.getInt(2);
    this.huF = paramCursor.getString(3);
    this.huE = paramCursor.getString(4);
    this.huG = paramCursor.getInt(5);
    this.huH = paramCursor.getInt(6);
    AppMethodBeat.o(150284);
  }
  
  public final void ez(boolean paramBoolean)
  {
    if (paramBoolean) {}
    for (int i = 1;; i = 0)
    {
      this.huG = i;
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