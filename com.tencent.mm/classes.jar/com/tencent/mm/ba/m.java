package com.tencent.mm.ba;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class m
{
  int bsY;
  private String ctV;
  public int cvs;
  String fMJ;
  private String fsf;
  private String fsg;
  private int fsh;
  private int fsi;
  public int id;
  String name;
  int size;
  public int status;
  public int version;
  
  public m()
  {
    AppMethodBeat.i(78480);
    this.bsY = -1;
    this.id = 0;
    this.version = 0;
    this.name = "";
    this.size = 0;
    this.fMJ = "";
    this.status = 0;
    this.cvs = 0;
    this.fsf = "";
    this.fsg = "";
    this.fsh = 0;
    this.fsi = 0;
    this.ctV = (this.id + "_" + this.cvs);
    AppMethodBeat.o(78480);
  }
  
  public final String aiK()
  {
    if (this.fMJ == null) {
      return "";
    }
    return this.fMJ;
  }
  
  public final void convertFrom(Cursor paramCursor)
  {
    AppMethodBeat.i(78481);
    this.version = paramCursor.getInt(2);
    this.name = paramCursor.getString(3);
    this.size = paramCursor.getInt(4);
    this.fMJ = paramCursor.getString(5);
    this.status = paramCursor.getInt(6);
    this.fsf = paramCursor.getString(8);
    this.fsg = paramCursor.getString(9);
    this.cvs = paramCursor.getInt(7);
    this.fsi = paramCursor.getInt(11);
    this.id = paramCursor.getInt(1);
    this.fsh = paramCursor.getInt(10);
    this.ctV = paramCursor.getString(0);
    AppMethodBeat.o(78481);
  }
  
  public final ContentValues convertTo()
  {
    AppMethodBeat.i(78482);
    ContentValues localContentValues = new ContentValues();
    if ((this.bsY & 0x2) != 0) {
      localContentValues.put("id", Integer.valueOf(this.id));
    }
    if ((this.bsY & 0x4) != 0) {
      localContentValues.put("version", Integer.valueOf(this.version));
    }
    if ((this.bsY & 0x8) != 0)
    {
      if (this.name == null)
      {
        str = "";
        localContentValues.put("name", str);
      }
    }
    else
    {
      if ((this.bsY & 0x10) != 0) {
        localContentValues.put("size", Integer.valueOf(this.size));
      }
      if ((this.bsY & 0x20) != 0) {
        localContentValues.put("packname", aiK());
      }
      if ((this.bsY & 0x40) != 0) {
        localContentValues.put("status", Integer.valueOf(this.status));
      }
      if ((this.bsY & 0x80) != 0) {
        localContentValues.put("type", Integer.valueOf(this.cvs));
      }
      if ((this.bsY & 0x100) != 0)
      {
        if (this.fsf != null) {
          break label337;
        }
        str = "";
        label195:
        localContentValues.put("reserved1", str);
      }
      if ((this.bsY & 0x200) != 0) {
        if (this.fsg != null) {
          break label345;
        }
      }
    }
    label337:
    label345:
    for (String str = "";; str = this.fsg)
    {
      localContentValues.put("reserved2", str);
      if ((this.bsY & 0x400) != 0) {
        localContentValues.put("reserved3", Integer.valueOf(this.fsh));
      }
      if ((this.bsY & 0x800) != 0) {
        localContentValues.put("reserved4", Integer.valueOf(this.fsi));
      }
      if ((this.bsY & 0x1) != 0) {
        localContentValues.put("localId", this.id + "_" + this.cvs);
      }
      AppMethodBeat.o(78482);
      return localContentValues;
      str = this.name;
      break;
      str = this.fsf;
      break label195;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.ba.m
 * JD-Core Version:    0.7.0.1
 */