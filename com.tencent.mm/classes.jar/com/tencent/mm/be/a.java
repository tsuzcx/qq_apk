package com.tencent.mm.be;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class a
{
  int cUP;
  private String lAY;
  private String lAZ;
  private int lBa;
  private int lBb;
  public int lXh;
  private String path;
  public String username;
  
  public a()
  {
    AppMethodBeat.i(150784);
    this.cUP = -1;
    this.username = "";
    this.lXh = 0;
    this.path = "";
    this.lAY = "";
    this.lAZ = "";
    this.lBa = 0;
    this.lBb = 0;
    AppMethodBeat.o(150784);
  }
  
  public final void convertFrom(Cursor paramCursor)
  {
    AppMethodBeat.i(150785);
    this.username = paramCursor.getString(0);
    this.lXh = paramCursor.getInt(1);
    this.path = paramCursor.getString(2);
    this.lAY = paramCursor.getString(3);
    this.lAZ = paramCursor.getString(4);
    this.lBa = paramCursor.getInt(5);
    this.lBb = paramCursor.getInt(6);
    AppMethodBeat.o(150785);
  }
  
  public final ContentValues convertTo()
  {
    AppMethodBeat.i(150786);
    ContentValues localContentValues = new ContentValues();
    if ((this.cUP & 0x1) != 0) {
      localContentValues.put("username", getUsername());
    }
    if ((this.cUP & 0x2) != 0) {
      localContentValues.put("bgflag", Integer.valueOf(this.lXh));
    }
    if ((this.cUP & 0x4) != 0)
    {
      if (this.path == null)
      {
        str = "";
        localContentValues.put("path", str);
      }
    }
    else
    {
      if ((this.cUP & 0x8) != 0)
      {
        if (this.lAY != null) {
          break label195;
        }
        str = "";
        label100:
        localContentValues.put("reserved1", str);
      }
      if ((this.cUP & 0x10) != 0) {
        if (this.lAZ != null) {
          break label203;
        }
      }
    }
    label195:
    label203:
    for (String str = "";; str = this.lAZ)
    {
      localContentValues.put("reserved2", str);
      if ((this.cUP & 0x20) != 0) {
        localContentValues.put("reserved3", Integer.valueOf(this.lBa));
      }
      if ((this.cUP & 0x40) != 0) {
        localContentValues.put("reserved4", Integer.valueOf(this.lBb));
      }
      AppMethodBeat.o(150786);
      return localContentValues;
      str = this.path;
      break;
      str = this.lAY;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.be.a
 * JD-Core Version:    0.7.0.1
 */