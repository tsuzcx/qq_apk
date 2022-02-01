package com.tencent.mm.bb;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class o
{
  private String dgl;
  public int dib;
  int drx;
  String hQh;
  private String huA;
  private int huB;
  private int huC;
  private String huz;
  public int id;
  String name;
  int size;
  public int status;
  public int version;
  
  public o()
  {
    AppMethodBeat.i(150834);
    this.drx = -1;
    this.id = 0;
    this.version = 0;
    this.name = "";
    this.size = 0;
    this.hQh = "";
    this.status = 0;
    this.dib = 0;
    this.huz = "";
    this.huA = "";
    this.huB = 0;
    this.huC = 0;
    this.dgl = (this.id + "_" + this.dib);
    AppMethodBeat.o(150834);
  }
  
  public final String aGJ()
  {
    if (this.hQh == null) {
      return "";
    }
    return this.hQh;
  }
  
  public final void convertFrom(Cursor paramCursor)
  {
    AppMethodBeat.i(150835);
    this.version = paramCursor.getInt(2);
    this.name = paramCursor.getString(3);
    this.size = paramCursor.getInt(4);
    this.hQh = paramCursor.getString(5);
    this.status = paramCursor.getInt(6);
    this.huz = paramCursor.getString(8);
    this.huA = paramCursor.getString(9);
    this.dib = paramCursor.getInt(7);
    this.huC = paramCursor.getInt(11);
    this.id = paramCursor.getInt(1);
    this.huB = paramCursor.getInt(10);
    this.dgl = paramCursor.getString(0);
    AppMethodBeat.o(150835);
  }
  
  public final ContentValues convertTo()
  {
    AppMethodBeat.i(150836);
    ContentValues localContentValues = new ContentValues();
    if ((this.drx & 0x2) != 0) {
      localContentValues.put("id", Integer.valueOf(this.id));
    }
    if ((this.drx & 0x4) != 0) {
      localContentValues.put("version", Integer.valueOf(this.version));
    }
    if ((this.drx & 0x8) != 0)
    {
      if (this.name == null)
      {
        str = "";
        localContentValues.put("name", str);
      }
    }
    else
    {
      if ((this.drx & 0x10) != 0) {
        localContentValues.put("size", Integer.valueOf(this.size));
      }
      if ((this.drx & 0x20) != 0) {
        localContentValues.put("packname", aGJ());
      }
      if ((this.drx & 0x40) != 0) {
        localContentValues.put("status", Integer.valueOf(this.status));
      }
      if ((this.drx & 0x80) != 0) {
        localContentValues.put("type", Integer.valueOf(this.dib));
      }
      if ((this.drx & 0x100) != 0)
      {
        if (this.huz != null) {
          break label337;
        }
        str = "";
        label195:
        localContentValues.put("reserved1", str);
      }
      if ((this.drx & 0x200) != 0) {
        if (this.huA != null) {
          break label345;
        }
      }
    }
    label337:
    label345:
    for (String str = "";; str = this.huA)
    {
      localContentValues.put("reserved2", str);
      if ((this.drx & 0x400) != 0) {
        localContentValues.put("reserved3", Integer.valueOf(this.huB));
      }
      if ((this.drx & 0x800) != 0) {
        localContentValues.put("reserved4", Integer.valueOf(this.huC));
      }
      if ((this.drx & 0x1) != 0) {
        localContentValues.put("localId", this.id + "_" + this.dib);
      }
      AppMethodBeat.o(150836);
      return localContentValues;
      str = this.name;
      break;
      str = this.huz;
      break label195;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.bb.o
 * JD-Core Version:    0.7.0.1
 */