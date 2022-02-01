package com.tencent.mm.am;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Util;

public final class j
{
  public int cUP;
  public int hDc;
  public int lBc;
  public String lBd;
  public String lBe;
  private int lBf;
  int lBg;
  public String username;
  
  public j()
  {
    AppMethodBeat.i(150283);
    this.cUP = -1;
    this.username = "";
    this.hDc = 0;
    this.lBc = 0;
    this.lBd = "";
    this.lBe = "";
    this.lBf = 0;
    this.lBg = 0;
    AppMethodBeat.o(150283);
  }
  
  public final void TQ(String paramString)
  {
    this.lBe = paramString;
  }
  
  public final void TR(String paramString)
  {
    this.lBd = paramString;
  }
  
  public final ContentValues bhE()
  {
    AppMethodBeat.i(150285);
    ContentValues localContentValues = new ContentValues();
    if ((this.cUP & 0x1) != 0) {
      localContentValues.put("username", getUsername());
    }
    if ((this.cUP & 0x2) != 0) {
      localContentValues.put("imgflag", Integer.valueOf(this.hDc));
    }
    if ((this.cUP & 0x4) != 0) {
      localContentValues.put("lastupdatetime", Integer.valueOf(this.lBc));
    }
    if ((this.cUP & 0x8) != 0) {
      localContentValues.put("reserved1", bhH());
    }
    if ((this.cUP & 0x10) != 0) {
      localContentValues.put("reserved2", bhI());
    }
    if ((this.cUP & 0x20) != 0) {
      localContentValues.put("reserved3", Integer.valueOf(this.lBf));
    }
    if ((this.cUP & 0x40) != 0) {
      localContentValues.put("reserved4", Integer.valueOf(this.lBg));
    }
    AppMethodBeat.o(150285);
    return localContentValues;
  }
  
  public final void bhF()
  {
    this.cUP = -1;
  }
  
  public final void bhG()
  {
    this.hDc = 3;
  }
  
  public final String bhH()
  {
    if (this.lBe == null) {
      return "";
    }
    return this.lBe;
  }
  
  public final String bhI()
  {
    if (this.lBd == null) {
      return "";
    }
    return this.lBd;
  }
  
  public final void bhJ()
  {
    AppMethodBeat.i(150286);
    this.lBg = ((int)(Util.nowSecond() / 60L));
    this.cUP |= 0x40;
    AppMethodBeat.o(150286);
  }
  
  public final void convertFrom(Cursor paramCursor)
  {
    AppMethodBeat.i(150284);
    this.username = paramCursor.getString(0);
    this.hDc = paramCursor.getInt(1);
    this.lBc = paramCursor.getInt(2);
    this.lBe = paramCursor.getString(3);
    this.lBd = paramCursor.getString(4);
    this.lBf = paramCursor.getInt(5);
    this.lBg = paramCursor.getInt(6);
    AppMethodBeat.o(150284);
  }
  
  public final String getUsername()
  {
    if (this.username == null) {
      return "";
    }
    return this.username;
  }
  
  public final void gg(boolean paramBoolean)
  {
    if (paramBoolean) {}
    for (int i = 1;; i = 0)
    {
      this.lBf = i;
      return;
    }
  }
  
  public final void setUsername(String paramString)
  {
    this.username = paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.am.j
 * JD-Core Version:    0.7.0.1
 */