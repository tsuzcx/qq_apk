package com.tencent.mm.bc;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class o
{
  private String diQ;
  public int dkC;
  int dtM;
  private String gUa;
  private String gUb;
  private int gUc;
  private int gUd;
  String hpF;
  public int id;
  String name;
  int size;
  public int status;
  public int version;
  
  public o()
  {
    AppMethodBeat.i(150834);
    this.dtM = -1;
    this.id = 0;
    this.version = 0;
    this.name = "";
    this.size = 0;
    this.hpF = "";
    this.status = 0;
    this.dkC = 0;
    this.gUa = "";
    this.gUb = "";
    this.gUc = 0;
    this.gUd = 0;
    this.diQ = (this.id + "_" + this.dkC);
    AppMethodBeat.o(150834);
  }
  
  public final String azT()
  {
    if (this.hpF == null) {
      return "";
    }
    return this.hpF;
  }
  
  public final void convertFrom(Cursor paramCursor)
  {
    AppMethodBeat.i(150835);
    this.version = paramCursor.getInt(2);
    this.name = paramCursor.getString(3);
    this.size = paramCursor.getInt(4);
    this.hpF = paramCursor.getString(5);
    this.status = paramCursor.getInt(6);
    this.gUa = paramCursor.getString(8);
    this.gUb = paramCursor.getString(9);
    this.dkC = paramCursor.getInt(7);
    this.gUd = paramCursor.getInt(11);
    this.id = paramCursor.getInt(1);
    this.gUc = paramCursor.getInt(10);
    this.diQ = paramCursor.getString(0);
    AppMethodBeat.o(150835);
  }
  
  public final ContentValues convertTo()
  {
    AppMethodBeat.i(150836);
    ContentValues localContentValues = new ContentValues();
    if ((this.dtM & 0x2) != 0) {
      localContentValues.put("id", Integer.valueOf(this.id));
    }
    if ((this.dtM & 0x4) != 0) {
      localContentValues.put("version", Integer.valueOf(this.version));
    }
    if ((this.dtM & 0x8) != 0)
    {
      if (this.name == null)
      {
        str = "";
        localContentValues.put("name", str);
      }
    }
    else
    {
      if ((this.dtM & 0x10) != 0) {
        localContentValues.put("size", Integer.valueOf(this.size));
      }
      if ((this.dtM & 0x20) != 0) {
        localContentValues.put("packname", azT());
      }
      if ((this.dtM & 0x40) != 0) {
        localContentValues.put("status", Integer.valueOf(this.status));
      }
      if ((this.dtM & 0x80) != 0) {
        localContentValues.put("type", Integer.valueOf(this.dkC));
      }
      if ((this.dtM & 0x100) != 0)
      {
        if (this.gUa != null) {
          break label337;
        }
        str = "";
        label195:
        localContentValues.put("reserved1", str);
      }
      if ((this.dtM & 0x200) != 0) {
        if (this.gUb != null) {
          break label345;
        }
      }
    }
    label337:
    label345:
    for (String str = "";; str = this.gUb)
    {
      localContentValues.put("reserved2", str);
      if ((this.dtM & 0x400) != 0) {
        localContentValues.put("reserved3", Integer.valueOf(this.gUc));
      }
      if ((this.dtM & 0x800) != 0) {
        localContentValues.put("reserved4", Integer.valueOf(this.gUd));
      }
      if ((this.dtM & 0x1) != 0) {
        localContentValues.put("localId", this.id + "_" + this.dkC);
      }
      AppMethodBeat.o(150836);
      return localContentValues;
      str = this.name;
      break;
      str = this.gUa;
      break label195;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.bc.o
 * JD-Core Version:    0.7.0.1
 */