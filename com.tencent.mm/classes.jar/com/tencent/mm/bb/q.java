package com.tencent.mm.bb;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class q
{
  int cSx;
  private String dJX;
  public int dMe;
  private String iKR;
  private String iKS;
  private int iKT;
  private int iKU;
  public int id;
  String jhw;
  String name;
  int size;
  public int status;
  public int version;
  
  public q()
  {
    AppMethodBeat.i(150834);
    this.cSx = -1;
    this.id = 0;
    this.version = 0;
    this.name = "";
    this.size = 0;
    this.jhw = "";
    this.status = 0;
    this.dMe = 0;
    this.iKR = "";
    this.iKS = "";
    this.iKT = 0;
    this.iKU = 0;
    this.dJX = (this.id + "_" + this.dMe);
    AppMethodBeat.o(150834);
  }
  
  public final String beq()
  {
    if (this.jhw == null) {
      return "";
    }
    return this.jhw;
  }
  
  public final void convertFrom(Cursor paramCursor)
  {
    AppMethodBeat.i(150835);
    this.version = paramCursor.getInt(2);
    this.name = paramCursor.getString(3);
    this.size = paramCursor.getInt(4);
    this.jhw = paramCursor.getString(5);
    this.status = paramCursor.getInt(6);
    this.iKR = paramCursor.getString(8);
    this.iKS = paramCursor.getString(9);
    this.dMe = paramCursor.getInt(7);
    this.iKU = paramCursor.getInt(11);
    this.id = paramCursor.getInt(1);
    this.iKT = paramCursor.getInt(10);
    this.dJX = paramCursor.getString(0);
    AppMethodBeat.o(150835);
  }
  
  public final ContentValues convertTo()
  {
    AppMethodBeat.i(150836);
    ContentValues localContentValues = new ContentValues();
    if ((this.cSx & 0x2) != 0) {
      localContentValues.put("id", Integer.valueOf(this.id));
    }
    if ((this.cSx & 0x4) != 0) {
      localContentValues.put("version", Integer.valueOf(this.version));
    }
    if ((this.cSx & 0x8) != 0)
    {
      if (this.name == null)
      {
        str = "";
        localContentValues.put("name", str);
      }
    }
    else
    {
      if ((this.cSx & 0x10) != 0) {
        localContentValues.put("size", Integer.valueOf(this.size));
      }
      if ((this.cSx & 0x20) != 0) {
        localContentValues.put("packname", beq());
      }
      if ((this.cSx & 0x40) != 0) {
        localContentValues.put("status", Integer.valueOf(this.status));
      }
      if ((this.cSx & 0x80) != 0) {
        localContentValues.put("type", Integer.valueOf(this.dMe));
      }
      if ((this.cSx & 0x100) != 0)
      {
        if (this.iKR != null) {
          break label337;
        }
        str = "";
        label195:
        localContentValues.put("reserved1", str);
      }
      if ((this.cSx & 0x200) != 0) {
        if (this.iKS != null) {
          break label345;
        }
      }
    }
    label337:
    label345:
    for (String str = "";; str = this.iKS)
    {
      localContentValues.put("reserved2", str);
      if ((this.cSx & 0x400) != 0) {
        localContentValues.put("reserved3", Integer.valueOf(this.iKT));
      }
      if ((this.cSx & 0x800) != 0) {
        localContentValues.put("reserved4", Integer.valueOf(this.iKU));
      }
      if ((this.cSx & 0x1) != 0) {
        localContentValues.put("localId", this.id + "_" + this.dMe);
      }
      AppMethodBeat.o(150836);
      return localContentValues;
      str = this.name;
      break;
      str = this.iKR;
      break label195;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.bb.q
 * JD-Core Version:    0.7.0.1
 */