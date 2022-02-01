package com.tencent.mm.bb;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class a
{
  int cSx;
  private String iKR;
  private String iKS;
  private int iKT;
  private int iKU;
  public int jgE;
  private String path;
  public String username;
  
  public a()
  {
    AppMethodBeat.i(150784);
    this.cSx = -1;
    this.username = "";
    this.jgE = 0;
    this.path = "";
    this.iKR = "";
    this.iKS = "";
    this.iKT = 0;
    this.iKU = 0;
    AppMethodBeat.o(150784);
  }
  
  public final void convertFrom(Cursor paramCursor)
  {
    AppMethodBeat.i(150785);
    this.username = paramCursor.getString(0);
    this.jgE = paramCursor.getInt(1);
    this.path = paramCursor.getString(2);
    this.iKR = paramCursor.getString(3);
    this.iKS = paramCursor.getString(4);
    this.iKT = paramCursor.getInt(5);
    this.iKU = paramCursor.getInt(6);
    AppMethodBeat.o(150785);
  }
  
  public final ContentValues convertTo()
  {
    AppMethodBeat.i(150786);
    ContentValues localContentValues = new ContentValues();
    if ((this.cSx & 0x1) != 0) {
      localContentValues.put("username", getUsername());
    }
    if ((this.cSx & 0x2) != 0) {
      localContentValues.put("bgflag", Integer.valueOf(this.jgE));
    }
    if ((this.cSx & 0x4) != 0)
    {
      if (this.path == null)
      {
        str = "";
        localContentValues.put("path", str);
      }
    }
    else
    {
      if ((this.cSx & 0x8) != 0)
      {
        if (this.iKR != null) {
          break label195;
        }
        str = "";
        label100:
        localContentValues.put("reserved1", str);
      }
      if ((this.cSx & 0x10) != 0) {
        if (this.iKS != null) {
          break label203;
        }
      }
    }
    label195:
    label203:
    for (String str = "";; str = this.iKS)
    {
      localContentValues.put("reserved2", str);
      if ((this.cSx & 0x20) != 0) {
        localContentValues.put("reserved3", Integer.valueOf(this.iKT));
      }
      if ((this.cSx & 0x40) != 0) {
        localContentValues.put("reserved4", Integer.valueOf(this.iKU));
      }
      AppMethodBeat.o(150786);
      return localContentValues;
      str = this.path;
      break;
      str = this.iKR;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.bb.a
 * JD-Core Version:    0.7.0.1
 */