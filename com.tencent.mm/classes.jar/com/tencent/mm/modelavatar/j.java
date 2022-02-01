package com.tencent.mm.modelavatar;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Util;

public final class j
{
  public int eQp;
  public int jZY;
  public int osL;
  public String osM;
  public String osN;
  private int osO;
  int osP;
  public String username;
  
  public j()
  {
    AppMethodBeat.i(150283);
    this.eQp = -1;
    this.username = "";
    this.jZY = 0;
    this.osL = 0;
    this.osM = "";
    this.osN = "";
    this.osO = 0;
    this.osP = 0;
    AppMethodBeat.o(150283);
  }
  
  public final ContentValues bFv()
  {
    AppMethodBeat.i(150285);
    ContentValues localContentValues = new ContentValues();
    if ((this.eQp & 0x1) != 0) {
      localContentValues.put("username", getUsername());
    }
    if ((this.eQp & 0x2) != 0) {
      localContentValues.put("imgflag", Integer.valueOf(this.jZY));
    }
    if ((this.eQp & 0x4) != 0) {
      localContentValues.put("lastupdatetime", Integer.valueOf(this.osL));
    }
    if ((this.eQp & 0x8) != 0) {
      localContentValues.put("reserved1", bFw());
    }
    if ((this.eQp & 0x10) != 0) {
      localContentValues.put("reserved2", bFx());
    }
    if ((this.eQp & 0x20) != 0) {
      localContentValues.put("reserved3", Integer.valueOf(this.osO));
    }
    if ((this.eQp & 0x40) != 0) {
      localContentValues.put("reserved4", Integer.valueOf(this.osP));
    }
    AppMethodBeat.o(150285);
    return localContentValues;
  }
  
  public final String bFw()
  {
    if (this.osN == null) {
      return "";
    }
    return this.osN;
  }
  
  public final String bFx()
  {
    if (this.osM == null) {
      return "";
    }
    return this.osM;
  }
  
  public final void bFy()
  {
    AppMethodBeat.i(150286);
    this.osP = ((int)(Util.nowSecond() / 60L));
    this.eQp |= 0x40;
    AppMethodBeat.o(150286);
  }
  
  public final void convertFrom(Cursor paramCursor)
  {
    AppMethodBeat.i(150284);
    this.username = paramCursor.getString(0);
    this.jZY = paramCursor.getInt(1);
    this.osL = paramCursor.getInt(2);
    this.osN = paramCursor.getString(3);
    this.osM = paramCursor.getString(4);
    this.osO = paramCursor.getInt(5);
    this.osP = paramCursor.getInt(6);
    AppMethodBeat.o(150284);
  }
  
  public final void gX(boolean paramBoolean)
  {
    if (paramBoolean) {}
    for (int i = 1;; i = 0)
    {
      this.osO = i;
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.modelavatar.j
 * JD-Core Version:    0.7.0.1
 */