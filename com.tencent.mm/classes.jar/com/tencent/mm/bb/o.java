package com.tencent.mm.bb;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class o
{
  int dEu;
  private String dsN;
  public int duK;
  private String hPK;
  private String hPL;
  private int hPM;
  private int hPN;
  public int id;
  String imo;
  String name;
  int size;
  public int status;
  public int version;
  
  public o()
  {
    AppMethodBeat.i(150834);
    this.dEu = -1;
    this.id = 0;
    this.version = 0;
    this.name = "";
    this.size = 0;
    this.imo = "";
    this.status = 0;
    this.duK = 0;
    this.hPK = "";
    this.hPL = "";
    this.hPM = 0;
    this.hPN = 0;
    this.dsN = (this.id + "_" + this.duK);
    AppMethodBeat.o(150834);
  }
  
  public final String aKn()
  {
    if (this.imo == null) {
      return "";
    }
    return this.imo;
  }
  
  public final void convertFrom(Cursor paramCursor)
  {
    AppMethodBeat.i(150835);
    this.version = paramCursor.getInt(2);
    this.name = paramCursor.getString(3);
    this.size = paramCursor.getInt(4);
    this.imo = paramCursor.getString(5);
    this.status = paramCursor.getInt(6);
    this.hPK = paramCursor.getString(8);
    this.hPL = paramCursor.getString(9);
    this.duK = paramCursor.getInt(7);
    this.hPN = paramCursor.getInt(11);
    this.id = paramCursor.getInt(1);
    this.hPM = paramCursor.getInt(10);
    this.dsN = paramCursor.getString(0);
    AppMethodBeat.o(150835);
  }
  
  public final ContentValues convertTo()
  {
    AppMethodBeat.i(150836);
    ContentValues localContentValues = new ContentValues();
    if ((this.dEu & 0x2) != 0) {
      localContentValues.put("id", Integer.valueOf(this.id));
    }
    if ((this.dEu & 0x4) != 0) {
      localContentValues.put("version", Integer.valueOf(this.version));
    }
    if ((this.dEu & 0x8) != 0)
    {
      if (this.name == null)
      {
        str = "";
        localContentValues.put("name", str);
      }
    }
    else
    {
      if ((this.dEu & 0x10) != 0) {
        localContentValues.put("size", Integer.valueOf(this.size));
      }
      if ((this.dEu & 0x20) != 0) {
        localContentValues.put("packname", aKn());
      }
      if ((this.dEu & 0x40) != 0) {
        localContentValues.put("status", Integer.valueOf(this.status));
      }
      if ((this.dEu & 0x80) != 0) {
        localContentValues.put("type", Integer.valueOf(this.duK));
      }
      if ((this.dEu & 0x100) != 0)
      {
        if (this.hPK != null) {
          break label337;
        }
        str = "";
        label195:
        localContentValues.put("reserved1", str);
      }
      if ((this.dEu & 0x200) != 0) {
        if (this.hPL != null) {
          break label345;
        }
      }
    }
    label337:
    label345:
    for (String str = "";; str = this.hPL)
    {
      localContentValues.put("reserved2", str);
      if ((this.dEu & 0x400) != 0) {
        localContentValues.put("reserved3", Integer.valueOf(this.hPM));
      }
      if ((this.dEu & 0x800) != 0) {
        localContentValues.put("reserved4", Integer.valueOf(this.hPN));
      }
      if ((this.dEu & 0x1) != 0) {
        localContentValues.put("localId", this.id + "_" + this.duK);
      }
      AppMethodBeat.o(150836);
      return localContentValues;
      str = this.name;
      break;
      str = this.hPK;
      break label195;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.bb.o
 * JD-Core Version:    0.7.0.1
 */