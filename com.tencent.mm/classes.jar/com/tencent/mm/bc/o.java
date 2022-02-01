package com.tencent.mm.bc;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class o
{
  int dDp;
  private String drH;
  public int dtF;
  private String hMR;
  private String hMS;
  private int hMT;
  private int hMU;
  public int id;
  String ijv;
  String name;
  int size;
  public int status;
  public int version;
  
  public o()
  {
    AppMethodBeat.i(150834);
    this.dDp = -1;
    this.id = 0;
    this.version = 0;
    this.name = "";
    this.size = 0;
    this.ijv = "";
    this.status = 0;
    this.dtF = 0;
    this.hMR = "";
    this.hMS = "";
    this.hMT = 0;
    this.hMU = 0;
    this.drH = (this.id + "_" + this.dtF);
    AppMethodBeat.o(150834);
  }
  
  public final String aJU()
  {
    if (this.ijv == null) {
      return "";
    }
    return this.ijv;
  }
  
  public final void convertFrom(Cursor paramCursor)
  {
    AppMethodBeat.i(150835);
    this.version = paramCursor.getInt(2);
    this.name = paramCursor.getString(3);
    this.size = paramCursor.getInt(4);
    this.ijv = paramCursor.getString(5);
    this.status = paramCursor.getInt(6);
    this.hMR = paramCursor.getString(8);
    this.hMS = paramCursor.getString(9);
    this.dtF = paramCursor.getInt(7);
    this.hMU = paramCursor.getInt(11);
    this.id = paramCursor.getInt(1);
    this.hMT = paramCursor.getInt(10);
    this.drH = paramCursor.getString(0);
    AppMethodBeat.o(150835);
  }
  
  public final ContentValues convertTo()
  {
    AppMethodBeat.i(150836);
    ContentValues localContentValues = new ContentValues();
    if ((this.dDp & 0x2) != 0) {
      localContentValues.put("id", Integer.valueOf(this.id));
    }
    if ((this.dDp & 0x4) != 0) {
      localContentValues.put("version", Integer.valueOf(this.version));
    }
    if ((this.dDp & 0x8) != 0)
    {
      if (this.name == null)
      {
        str = "";
        localContentValues.put("name", str);
      }
    }
    else
    {
      if ((this.dDp & 0x10) != 0) {
        localContentValues.put("size", Integer.valueOf(this.size));
      }
      if ((this.dDp & 0x20) != 0) {
        localContentValues.put("packname", aJU());
      }
      if ((this.dDp & 0x40) != 0) {
        localContentValues.put("status", Integer.valueOf(this.status));
      }
      if ((this.dDp & 0x80) != 0) {
        localContentValues.put("type", Integer.valueOf(this.dtF));
      }
      if ((this.dDp & 0x100) != 0)
      {
        if (this.hMR != null) {
          break label337;
        }
        str = "";
        label195:
        localContentValues.put("reserved1", str);
      }
      if ((this.dDp & 0x200) != 0) {
        if (this.hMS != null) {
          break label345;
        }
      }
    }
    label337:
    label345:
    for (String str = "";; str = this.hMS)
    {
      localContentValues.put("reserved2", str);
      if ((this.dDp & 0x400) != 0) {
        localContentValues.put("reserved3", Integer.valueOf(this.hMT));
      }
      if ((this.dDp & 0x800) != 0) {
        localContentValues.put("reserved4", Integer.valueOf(this.hMU));
      }
      if ((this.dDp & 0x1) != 0) {
        localContentValues.put("localId", this.id + "_" + this.dtF);
      }
      AppMethodBeat.o(150836);
      return localContentValues;
      str = this.name;
      break;
      str = this.hMR;
      break label195;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.bc.o
 * JD-Core Version:    0.7.0.1
 */