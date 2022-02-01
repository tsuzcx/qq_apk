package com.tencent.mm.bc;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class a
{
  int dDp;
  private String hMR;
  private String hMS;
  private int hMT;
  private int hMU;
  public int iiM;
  private String path;
  public String username;
  
  public a()
  {
    AppMethodBeat.i(150784);
    this.dDp = -1;
    this.username = "";
    this.iiM = 0;
    this.path = "";
    this.hMR = "";
    this.hMS = "";
    this.hMT = 0;
    this.hMU = 0;
    AppMethodBeat.o(150784);
  }
  
  public final void convertFrom(Cursor paramCursor)
  {
    AppMethodBeat.i(150785);
    this.username = paramCursor.getString(0);
    this.iiM = paramCursor.getInt(1);
    this.path = paramCursor.getString(2);
    this.hMR = paramCursor.getString(3);
    this.hMS = paramCursor.getString(4);
    this.hMT = paramCursor.getInt(5);
    this.hMU = paramCursor.getInt(6);
    AppMethodBeat.o(150785);
  }
  
  public final ContentValues convertTo()
  {
    AppMethodBeat.i(150786);
    ContentValues localContentValues = new ContentValues();
    if ((this.dDp & 0x1) != 0) {
      localContentValues.put("username", getUsername());
    }
    if ((this.dDp & 0x2) != 0) {
      localContentValues.put("bgflag", Integer.valueOf(this.iiM));
    }
    if ((this.dDp & 0x4) != 0)
    {
      if (this.path == null)
      {
        str = "";
        localContentValues.put("path", str);
      }
    }
    else
    {
      if ((this.dDp & 0x8) != 0)
      {
        if (this.hMR != null) {
          break label195;
        }
        str = "";
        label100:
        localContentValues.put("reserved1", str);
      }
      if ((this.dDp & 0x10) != 0) {
        if (this.hMS != null) {
          break label203;
        }
      }
    }
    label195:
    label203:
    for (String str = "";; str = this.hMS)
    {
      localContentValues.put("reserved2", str);
      if ((this.dDp & 0x20) != 0) {
        localContentValues.put("reserved3", Integer.valueOf(this.hMT));
      }
      if ((this.dDp & 0x40) != 0) {
        localContentValues.put("reserved4", Integer.valueOf(this.hMU));
      }
      AppMethodBeat.o(150786);
      return localContentValues;
      str = this.path;
      break;
      str = this.hMR;
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
 * Qualified Name:     com.tencent.mm.bc.a
 * JD-Core Version:    0.7.0.1
 */