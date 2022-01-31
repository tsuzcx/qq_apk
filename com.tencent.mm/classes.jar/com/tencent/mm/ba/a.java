package com.tencent.mm.ba;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class a
{
  int bsY;
  public int fMk;
  private String fsf;
  private String fsg;
  private int fsh;
  private int fsi;
  private String path;
  public String username;
  
  public a()
  {
    AppMethodBeat.i(78430);
    this.bsY = -1;
    this.username = "";
    this.fMk = 0;
    this.path = "";
    this.fsf = "";
    this.fsg = "";
    this.fsh = 0;
    this.fsi = 0;
    AppMethodBeat.o(78430);
  }
  
  public final void convertFrom(Cursor paramCursor)
  {
    AppMethodBeat.i(78431);
    this.username = paramCursor.getString(0);
    this.fMk = paramCursor.getInt(1);
    this.path = paramCursor.getString(2);
    this.fsf = paramCursor.getString(3);
    this.fsg = paramCursor.getString(4);
    this.fsh = paramCursor.getInt(5);
    this.fsi = paramCursor.getInt(6);
    AppMethodBeat.o(78431);
  }
  
  public final ContentValues convertTo()
  {
    AppMethodBeat.i(78432);
    ContentValues localContentValues = new ContentValues();
    if ((this.bsY & 0x1) != 0) {
      localContentValues.put("username", getUsername());
    }
    if ((this.bsY & 0x2) != 0) {
      localContentValues.put("bgflag", Integer.valueOf(this.fMk));
    }
    if ((this.bsY & 0x4) != 0)
    {
      if (this.path == null)
      {
        str = "";
        localContentValues.put("path", str);
      }
    }
    else
    {
      if ((this.bsY & 0x8) != 0)
      {
        if (this.fsf != null) {
          break label195;
        }
        str = "";
        label100:
        localContentValues.put("reserved1", str);
      }
      if ((this.bsY & 0x10) != 0) {
        if (this.fsg != null) {
          break label203;
        }
      }
    }
    label195:
    label203:
    for (String str = "";; str = this.fsg)
    {
      localContentValues.put("reserved2", str);
      if ((this.bsY & 0x20) != 0) {
        localContentValues.put("reserved3", Integer.valueOf(this.fsh));
      }
      if ((this.bsY & 0x40) != 0) {
        localContentValues.put("reserved4", Integer.valueOf(this.fsi));
      }
      AppMethodBeat.o(78432);
      return localContentValues;
      str = this.path;
      break;
      str = this.fsf;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.ba.a
 * JD-Core Version:    0.7.0.1
 */