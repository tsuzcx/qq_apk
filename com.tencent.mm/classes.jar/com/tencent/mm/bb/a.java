package com.tencent.mm.bb;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class a
{
  int drx;
  public int hPy;
  private String huA;
  private int huB;
  private int huC;
  private String huz;
  private String path;
  public String username;
  
  public a()
  {
    AppMethodBeat.i(150784);
    this.drx = -1;
    this.username = "";
    this.hPy = 0;
    this.path = "";
    this.huz = "";
    this.huA = "";
    this.huB = 0;
    this.huC = 0;
    AppMethodBeat.o(150784);
  }
  
  public final void convertFrom(Cursor paramCursor)
  {
    AppMethodBeat.i(150785);
    this.username = paramCursor.getString(0);
    this.hPy = paramCursor.getInt(1);
    this.path = paramCursor.getString(2);
    this.huz = paramCursor.getString(3);
    this.huA = paramCursor.getString(4);
    this.huB = paramCursor.getInt(5);
    this.huC = paramCursor.getInt(6);
    AppMethodBeat.o(150785);
  }
  
  public final ContentValues convertTo()
  {
    AppMethodBeat.i(150786);
    ContentValues localContentValues = new ContentValues();
    if ((this.drx & 0x1) != 0) {
      localContentValues.put("username", getUsername());
    }
    if ((this.drx & 0x2) != 0) {
      localContentValues.put("bgflag", Integer.valueOf(this.hPy));
    }
    if ((this.drx & 0x4) != 0)
    {
      if (this.path == null)
      {
        str = "";
        localContentValues.put("path", str);
      }
    }
    else
    {
      if ((this.drx & 0x8) != 0)
      {
        if (this.huz != null) {
          break label195;
        }
        str = "";
        label100:
        localContentValues.put("reserved1", str);
      }
      if ((this.drx & 0x10) != 0) {
        if (this.huA != null) {
          break label203;
        }
      }
    }
    label195:
    label203:
    for (String str = "";; str = this.huA)
    {
      localContentValues.put("reserved2", str);
      if ((this.drx & 0x20) != 0) {
        localContentValues.put("reserved3", Integer.valueOf(this.huB));
      }
      if ((this.drx & 0x40) != 0) {
        localContentValues.put("reserved4", Integer.valueOf(this.huC));
      }
      AppMethodBeat.o(150786);
      return localContentValues;
      str = this.path;
      break;
      str = this.huz;
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