package com.tencent.mm.aj;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.bu;

public final class i
{
  public int dEu;
  public int eQU;
  public int hPO;
  public String hPP;
  public String hPQ;
  private int hPR;
  int hPS;
  public String username;
  
  public i()
  {
    AppMethodBeat.i(150283);
    this.dEu = -1;
    this.username = "";
    this.eQU = 0;
    this.hPO = 0;
    this.hPP = "";
    this.hPQ = "";
    this.hPR = 0;
    this.hPS = 0;
    AppMethodBeat.o(150283);
  }
  
  public final void DK(String paramString)
  {
    this.hPP = paramString;
  }
  
  public final ContentValues aEF()
  {
    AppMethodBeat.i(150285);
    ContentValues localContentValues = new ContentValues();
    if ((this.dEu & 0x1) != 0) {
      localContentValues.put("username", getUsername());
    }
    if ((this.dEu & 0x2) != 0) {
      localContentValues.put("imgflag", Integer.valueOf(this.eQU));
    }
    if ((this.dEu & 0x4) != 0) {
      localContentValues.put("lastupdatetime", Integer.valueOf(this.hPO));
    }
    if ((this.dEu & 0x8) != 0) {
      localContentValues.put("reserved1", aEG());
    }
    if ((this.dEu & 0x10) != 0) {
      localContentValues.put("reserved2", aEH());
    }
    if ((this.dEu & 0x20) != 0) {
      localContentValues.put("reserved3", Integer.valueOf(this.hPR));
    }
    if ((this.dEu & 0x40) != 0) {
      localContentValues.put("reserved4", Integer.valueOf(this.hPS));
    }
    AppMethodBeat.o(150285);
    return localContentValues;
  }
  
  public final String aEG()
  {
    if (this.hPQ == null) {
      return "";
    }
    return this.hPQ;
  }
  
  public final String aEH()
  {
    if (this.hPP == null) {
      return "";
    }
    return this.hPP;
  }
  
  public final void aEI()
  {
    AppMethodBeat.i(150286);
    this.hPS = ((int)(bu.aRi() / 60L));
    this.dEu |= 0x40;
    AppMethodBeat.o(150286);
  }
  
  public final void convertFrom(Cursor paramCursor)
  {
    AppMethodBeat.i(150284);
    this.username = paramCursor.getString(0);
    this.eQU = paramCursor.getInt(1);
    this.hPO = paramCursor.getInt(2);
    this.hPQ = paramCursor.getString(3);
    this.hPP = paramCursor.getString(4);
    this.hPR = paramCursor.getInt(5);
    this.hPS = paramCursor.getInt(6);
    AppMethodBeat.o(150284);
  }
  
  public final void eD(boolean paramBoolean)
  {
    if (paramBoolean) {}
    for (int i = 1;; i = 0)
    {
      this.hPR = i;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.aj.i
 * JD-Core Version:    0.7.0.1
 */