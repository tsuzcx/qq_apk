package com.tencent.mm.modelpackage;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class a
{
  int eQp;
  public int oQj;
  private String osA;
  private String osB;
  private int osC;
  private int osD;
  private String path;
  public String username;
  
  public a()
  {
    AppMethodBeat.i(150784);
    this.eQp = -1;
    this.username = "";
    this.oQj = 0;
    this.path = "";
    this.osA = "";
    this.osB = "";
    this.osC = 0;
    this.osD = 0;
    AppMethodBeat.o(150784);
  }
  
  public final void convertFrom(Cursor paramCursor)
  {
    AppMethodBeat.i(150785);
    this.username = paramCursor.getString(0);
    this.oQj = paramCursor.getInt(1);
    this.path = paramCursor.getString(2);
    this.osA = paramCursor.getString(3);
    this.osB = paramCursor.getString(4);
    this.osC = paramCursor.getInt(5);
    this.osD = paramCursor.getInt(6);
    AppMethodBeat.o(150785);
  }
  
  public final ContentValues convertTo()
  {
    AppMethodBeat.i(150786);
    ContentValues localContentValues = new ContentValues();
    if ((this.eQp & 0x1) != 0) {
      localContentValues.put("username", getUsername());
    }
    if ((this.eQp & 0x2) != 0) {
      localContentValues.put("bgflag", Integer.valueOf(this.oQj));
    }
    if ((this.eQp & 0x4) != 0)
    {
      if (this.path == null)
      {
        str = "";
        localContentValues.put("path", str);
      }
    }
    else
    {
      if ((this.eQp & 0x8) != 0)
      {
        if (this.osA != null) {
          break label195;
        }
        str = "";
        label100:
        localContentValues.put("reserved1", str);
      }
      if ((this.eQp & 0x10) != 0) {
        if (this.osB != null) {
          break label203;
        }
      }
    }
    label195:
    label203:
    for (String str = "";; str = this.osB)
    {
      localContentValues.put("reserved2", str);
      if ((this.eQp & 0x20) != 0) {
        localContentValues.put("reserved3", Integer.valueOf(this.osC));
      }
      if ((this.eQp & 0x40) != 0) {
        localContentValues.put("reserved4", Integer.valueOf(this.osD));
      }
      AppMethodBeat.o(150786);
      return localContentValues;
      str = this.path;
      break;
      str = this.osA;
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
 * Qualified Name:     com.tencent.mm.modelpackage.a
 * JD-Core Version:    0.7.0.1
 */