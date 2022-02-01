package com.tencent.mm.bb;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class a
{
  int dEu;
  private String hPK;
  private String hPL;
  private int hPM;
  private int hPN;
  public int ilF;
  private String path;
  public String username;
  
  public a()
  {
    AppMethodBeat.i(150784);
    this.dEu = -1;
    this.username = "";
    this.ilF = 0;
    this.path = "";
    this.hPK = "";
    this.hPL = "";
    this.hPM = 0;
    this.hPN = 0;
    AppMethodBeat.o(150784);
  }
  
  public final void convertFrom(Cursor paramCursor)
  {
    AppMethodBeat.i(150785);
    this.username = paramCursor.getString(0);
    this.ilF = paramCursor.getInt(1);
    this.path = paramCursor.getString(2);
    this.hPK = paramCursor.getString(3);
    this.hPL = paramCursor.getString(4);
    this.hPM = paramCursor.getInt(5);
    this.hPN = paramCursor.getInt(6);
    AppMethodBeat.o(150785);
  }
  
  public final ContentValues convertTo()
  {
    AppMethodBeat.i(150786);
    ContentValues localContentValues = new ContentValues();
    if ((this.dEu & 0x1) != 0) {
      localContentValues.put("username", getUsername());
    }
    if ((this.dEu & 0x2) != 0) {
      localContentValues.put("bgflag", Integer.valueOf(this.ilF));
    }
    if ((this.dEu & 0x4) != 0)
    {
      if (this.path == null)
      {
        str = "";
        localContentValues.put("path", str);
      }
    }
    else
    {
      if ((this.dEu & 0x8) != 0)
      {
        if (this.hPK != null) {
          break label195;
        }
        str = "";
        label100:
        localContentValues.put("reserved1", str);
      }
      if ((this.dEu & 0x10) != 0) {
        if (this.hPL != null) {
          break label203;
        }
      }
    }
    label195:
    label203:
    for (String str = "";; str = this.hPL)
    {
      localContentValues.put("reserved2", str);
      if ((this.dEu & 0x20) != 0) {
        localContentValues.put("reserved3", Integer.valueOf(this.hPM));
      }
      if ((this.dEu & 0x40) != 0) {
        localContentValues.put("reserved4", Integer.valueOf(this.hPN));
      }
      AppMethodBeat.o(150786);
      return localContentValues;
      str = this.path;
      break;
      str = this.hPK;
      break label100;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.bb.a
 * JD-Core Version:    0.7.0.1
 */