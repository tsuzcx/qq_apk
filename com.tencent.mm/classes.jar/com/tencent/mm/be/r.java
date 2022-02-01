package com.tencent.mm.be;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class r
{
  int cUP;
  private String fCM;
  public int fES;
  public int id;
  private String lAY;
  private String lAZ;
  private int lBa;
  private int lBb;
  String lXZ;
  String name;
  int size;
  public int status;
  public int version;
  
  public r()
  {
    AppMethodBeat.i(150834);
    this.cUP = -1;
    this.id = 0;
    this.version = 0;
    this.name = "";
    this.size = 0;
    this.lXZ = "";
    this.status = 0;
    this.fES = 0;
    this.lAY = "";
    this.lAZ = "";
    this.lBa = 0;
    this.lBb = 0;
    this.fCM = (this.id + "_" + this.fES);
    AppMethodBeat.o(150834);
  }
  
  public final String bnP()
  {
    if (this.lXZ == null) {
      return "";
    }
    return this.lXZ;
  }
  
  public final void convertFrom(Cursor paramCursor)
  {
    AppMethodBeat.i(150835);
    this.version = paramCursor.getInt(2);
    this.name = paramCursor.getString(3);
    this.size = paramCursor.getInt(4);
    this.lXZ = paramCursor.getString(5);
    this.status = paramCursor.getInt(6);
    this.lAY = paramCursor.getString(8);
    this.lAZ = paramCursor.getString(9);
    this.fES = paramCursor.getInt(7);
    this.lBb = paramCursor.getInt(11);
    this.id = paramCursor.getInt(1);
    this.lBa = paramCursor.getInt(10);
    this.fCM = paramCursor.getString(0);
    AppMethodBeat.o(150835);
  }
  
  public final ContentValues convertTo()
  {
    AppMethodBeat.i(150836);
    ContentValues localContentValues = new ContentValues();
    if ((this.cUP & 0x2) != 0) {
      localContentValues.put("id", Integer.valueOf(this.id));
    }
    if ((this.cUP & 0x4) != 0) {
      localContentValues.put("version", Integer.valueOf(this.version));
    }
    if ((this.cUP & 0x8) != 0)
    {
      if (this.name == null)
      {
        str = "";
        localContentValues.put("name", str);
      }
    }
    else
    {
      if ((this.cUP & 0x10) != 0) {
        localContentValues.put("size", Integer.valueOf(this.size));
      }
      if ((this.cUP & 0x20) != 0) {
        localContentValues.put("packname", bnP());
      }
      if ((this.cUP & 0x40) != 0) {
        localContentValues.put("status", Integer.valueOf(this.status));
      }
      if ((this.cUP & 0x80) != 0) {
        localContentValues.put("type", Integer.valueOf(this.fES));
      }
      if ((this.cUP & 0x100) != 0)
      {
        if (this.lAY != null) {
          break label337;
        }
        str = "";
        label195:
        localContentValues.put("reserved1", str);
      }
      if ((this.cUP & 0x200) != 0) {
        if (this.lAZ != null) {
          break label345;
        }
      }
    }
    label337:
    label345:
    for (String str = "";; str = this.lAZ)
    {
      localContentValues.put("reserved2", str);
      if ((this.cUP & 0x400) != 0) {
        localContentValues.put("reserved3", Integer.valueOf(this.lBa));
      }
      if ((this.cUP & 0x800) != 0) {
        localContentValues.put("reserved4", Integer.valueOf(this.lBb));
      }
      if ((this.cUP & 0x1) != 0) {
        localContentValues.put("localId", this.id + "_" + this.fES);
      }
      AppMethodBeat.o(150836);
      return localContentValues;
      str = this.name;
      break;
      str = this.lAY;
      break label195;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.be.r
 * JD-Core Version:    0.7.0.1
 */