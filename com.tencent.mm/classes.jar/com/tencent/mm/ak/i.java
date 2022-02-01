package com.tencent.mm.ak;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.bt;

public final class i
{
  public int dtM;
  public int evo;
  public int gUe;
  public String gUf;
  public String gUg;
  private int gUh;
  int gUi;
  public String username;
  
  public i()
  {
    AppMethodBeat.i(150283);
    this.dtM = -1;
    this.username = "";
    this.evo = 0;
    this.gUe = 0;
    this.gUf = "";
    this.gUg = "";
    this.gUh = 0;
    this.gUi = 0;
    AppMethodBeat.o(150283);
  }
  
  public final ContentValues auw()
  {
    AppMethodBeat.i(150285);
    ContentValues localContentValues = new ContentValues();
    if ((this.dtM & 0x1) != 0) {
      localContentValues.put("username", getUsername());
    }
    if ((this.dtM & 0x2) != 0) {
      localContentValues.put("imgflag", Integer.valueOf(this.evo));
    }
    if ((this.dtM & 0x4) != 0) {
      localContentValues.put("lastupdatetime", Integer.valueOf(this.gUe));
    }
    if ((this.dtM & 0x8) != 0) {
      localContentValues.put("reserved1", aux());
    }
    if ((this.dtM & 0x10) != 0) {
      localContentValues.put("reserved2", auy());
    }
    if ((this.dtM & 0x20) != 0) {
      localContentValues.put("reserved3", Integer.valueOf(this.gUh));
    }
    if ((this.dtM & 0x40) != 0) {
      localContentValues.put("reserved4", Integer.valueOf(this.gUi));
    }
    AppMethodBeat.o(150285);
    return localContentValues;
  }
  
  public final String aux()
  {
    if (this.gUg == null) {
      return "";
    }
    return this.gUg;
  }
  
  public final String auy()
  {
    if (this.gUf == null) {
      return "";
    }
    return this.gUf;
  }
  
  public final void auz()
  {
    AppMethodBeat.i(150286);
    this.gUi = ((int)(bt.aGK() / 60L));
    this.dtM |= 0x40;
    AppMethodBeat.o(150286);
  }
  
  public final void convertFrom(Cursor paramCursor)
  {
    AppMethodBeat.i(150284);
    this.username = paramCursor.getString(0);
    this.evo = paramCursor.getInt(1);
    this.gUe = paramCursor.getInt(2);
    this.gUg = paramCursor.getString(3);
    this.gUf = paramCursor.getString(4);
    this.gUh = paramCursor.getInt(5);
    this.gUi = paramCursor.getInt(6);
    AppMethodBeat.o(150284);
  }
  
  public final void ee(boolean paramBoolean)
  {
    if (paramBoolean) {}
    for (int i = 1;; i = 0)
    {
      this.gUh = i;
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
  
  public final void wd(String paramString)
  {
    this.gUf = paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.ak.i
 * JD-Core Version:    0.7.0.1
 */