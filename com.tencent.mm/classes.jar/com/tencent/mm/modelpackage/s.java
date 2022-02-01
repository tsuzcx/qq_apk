package com.tencent.mm.modelpackage;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class s
{
  int eQp;
  private String hHB;
  public int hJK;
  public int id;
  String name;
  String oRd;
  private String osA;
  private String osB;
  private int osC;
  private int osD;
  int size;
  public int status;
  public int version;
  
  public s()
  {
    AppMethodBeat.i(150834);
    this.eQp = -1;
    this.id = 0;
    this.version = 0;
    this.name = "";
    this.size = 0;
    this.oRd = "";
    this.status = 0;
    this.hJK = 0;
    this.osA = "";
    this.osB = "";
    this.osC = 0;
    this.osD = 0;
    this.hHB = (this.id + "_" + this.hJK);
    AppMethodBeat.o(150834);
  }
  
  public final String bLC()
  {
    if (this.oRd == null) {
      return "";
    }
    return this.oRd;
  }
  
  public final void convertFrom(Cursor paramCursor)
  {
    AppMethodBeat.i(150835);
    this.version = paramCursor.getInt(2);
    this.name = paramCursor.getString(3);
    this.size = paramCursor.getInt(4);
    this.oRd = paramCursor.getString(5);
    this.status = paramCursor.getInt(6);
    this.osA = paramCursor.getString(8);
    this.osB = paramCursor.getString(9);
    this.hJK = paramCursor.getInt(7);
    this.osD = paramCursor.getInt(11);
    this.id = paramCursor.getInt(1);
    this.osC = paramCursor.getInt(10);
    this.hHB = paramCursor.getString(0);
    AppMethodBeat.o(150835);
  }
  
  public final ContentValues convertTo()
  {
    AppMethodBeat.i(150836);
    ContentValues localContentValues = new ContentValues();
    if ((this.eQp & 0x2) != 0) {
      localContentValues.put("id", Integer.valueOf(this.id));
    }
    if ((this.eQp & 0x4) != 0) {
      localContentValues.put("version", Integer.valueOf(this.version));
    }
    if ((this.eQp & 0x8) != 0)
    {
      if (this.name == null)
      {
        str = "";
        localContentValues.put("name", str);
      }
    }
    else
    {
      if ((this.eQp & 0x10) != 0) {
        localContentValues.put("size", Integer.valueOf(this.size));
      }
      if ((this.eQp & 0x20) != 0) {
        localContentValues.put("packname", bLC());
      }
      if ((this.eQp & 0x40) != 0) {
        localContentValues.put("status", Integer.valueOf(this.status));
      }
      if ((this.eQp & 0x80) != 0) {
        localContentValues.put("type", Integer.valueOf(this.hJK));
      }
      if ((this.eQp & 0x100) != 0)
      {
        if (this.osA != null) {
          break label337;
        }
        str = "";
        label195:
        localContentValues.put("reserved1", str);
      }
      if ((this.eQp & 0x200) != 0) {
        if (this.osB != null) {
          break label345;
        }
      }
    }
    label337:
    label345:
    for (String str = "";; str = this.osB)
    {
      localContentValues.put("reserved2", str);
      if ((this.eQp & 0x400) != 0) {
        localContentValues.put("reserved3", Integer.valueOf(this.osC));
      }
      if ((this.eQp & 0x800) != 0) {
        localContentValues.put("reserved4", Integer.valueOf(this.osD));
      }
      if ((this.eQp & 0x1) != 0) {
        localContentValues.put("localId", this.id + "_" + this.hJK);
      }
      AppMethodBeat.o(150836);
      return localContentValues;
      str = this.name;
      break;
      str = this.osA;
      break label195;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.modelpackage.s
 * JD-Core Version:    0.7.0.1
 */