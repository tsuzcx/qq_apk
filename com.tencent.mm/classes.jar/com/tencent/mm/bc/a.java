package com.tencent.mm.bc;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class a
{
  int dtM;
  private String gUa;
  private String gUb;
  private int gUc;
  private int gUd;
  public int hoW;
  private String path;
  public String username;
  
  public a()
  {
    AppMethodBeat.i(150784);
    this.dtM = -1;
    this.username = "";
    this.hoW = 0;
    this.path = "";
    this.gUa = "";
    this.gUb = "";
    this.gUc = 0;
    this.gUd = 0;
    AppMethodBeat.o(150784);
  }
  
  public final void convertFrom(Cursor paramCursor)
  {
    AppMethodBeat.i(150785);
    this.username = paramCursor.getString(0);
    this.hoW = paramCursor.getInt(1);
    this.path = paramCursor.getString(2);
    this.gUa = paramCursor.getString(3);
    this.gUb = paramCursor.getString(4);
    this.gUc = paramCursor.getInt(5);
    this.gUd = paramCursor.getInt(6);
    AppMethodBeat.o(150785);
  }
  
  public final ContentValues convertTo()
  {
    AppMethodBeat.i(150786);
    ContentValues localContentValues = new ContentValues();
    if ((this.dtM & 0x1) != 0) {
      localContentValues.put("username", getUsername());
    }
    if ((this.dtM & 0x2) != 0) {
      localContentValues.put("bgflag", Integer.valueOf(this.hoW));
    }
    if ((this.dtM & 0x4) != 0)
    {
      if (this.path == null)
      {
        str = "";
        localContentValues.put("path", str);
      }
    }
    else
    {
      if ((this.dtM & 0x8) != 0)
      {
        if (this.gUa != null) {
          break label195;
        }
        str = "";
        label100:
        localContentValues.put("reserved1", str);
      }
      if ((this.dtM & 0x10) != 0) {
        if (this.gUb != null) {
          break label203;
        }
      }
    }
    label195:
    label203:
    for (String str = "";; str = this.gUb)
    {
      localContentValues.put("reserved2", str);
      if ((this.dtM & 0x20) != 0) {
        localContentValues.put("reserved3", Integer.valueOf(this.gUc));
      }
      if ((this.dtM & 0x40) != 0) {
        localContentValues.put("reserved4", Integer.valueOf(this.gUd));
      }
      AppMethodBeat.o(150786);
      return localContentValues;
      str = this.path;
      break;
      str = this.gUa;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.bc.a
 * JD-Core Version:    0.7.0.1
 */