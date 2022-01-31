package com.tencent.mm.az;

import android.content.ContentValues;
import android.database.Cursor;

public final class m
{
  private String bMB = this.id + "_" + this.bOa;
  public int bOa = 0;
  int bcw = -1;
  private String ebN = "";
  private String ebO = "";
  private int ebP = 0;
  private int ebQ = 0;
  String ewT = "";
  public int id = 0;
  String name = "";
  int size = 0;
  public int status = 0;
  public int version = 0;
  
  public final String PG()
  {
    if (this.ewT == null) {
      return "";
    }
    return this.ewT;
  }
  
  public final void d(Cursor paramCursor)
  {
    this.version = paramCursor.getInt(2);
    this.name = paramCursor.getString(3);
    this.size = paramCursor.getInt(4);
    this.ewT = paramCursor.getString(5);
    this.status = paramCursor.getInt(6);
    this.ebN = paramCursor.getString(8);
    this.ebO = paramCursor.getString(9);
    this.bOa = paramCursor.getInt(7);
    this.ebQ = paramCursor.getInt(11);
    this.id = paramCursor.getInt(1);
    this.ebP = paramCursor.getInt(10);
    this.bMB = paramCursor.getString(0);
  }
  
  public final ContentValues vf()
  {
    ContentValues localContentValues = new ContentValues();
    if ((this.bcw & 0x2) != 0) {
      localContentValues.put("id", Integer.valueOf(this.id));
    }
    if ((this.bcw & 0x4) != 0) {
      localContentValues.put("version", Integer.valueOf(this.version));
    }
    if ((this.bcw & 0x8) != 0)
    {
      if (this.name == null)
      {
        str = "";
        localContentValues.put("name", str);
      }
    }
    else
    {
      if ((this.bcw & 0x10) != 0) {
        localContentValues.put("size", Integer.valueOf(this.size));
      }
      if ((this.bcw & 0x20) != 0) {
        localContentValues.put("packname", PG());
      }
      if ((this.bcw & 0x40) != 0) {
        localContentValues.put("status", Integer.valueOf(this.status));
      }
      if ((this.bcw & 0x80) != 0) {
        localContentValues.put("type", Integer.valueOf(this.bOa));
      }
      if ((this.bcw & 0x100) != 0)
      {
        if (this.ebN != null) {
          break label327;
        }
        str = "";
        label190:
        localContentValues.put("reserved1", str);
      }
      if ((this.bcw & 0x200) != 0) {
        if (this.ebO != null) {
          break label335;
        }
      }
    }
    label327:
    label335:
    for (String str = "";; str = this.ebO)
    {
      localContentValues.put("reserved2", str);
      if ((this.bcw & 0x400) != 0) {
        localContentValues.put("reserved3", Integer.valueOf(this.ebP));
      }
      if ((this.bcw & 0x800) != 0) {
        localContentValues.put("reserved4", Integer.valueOf(this.ebQ));
      }
      if ((this.bcw & 0x1) != 0) {
        localContentValues.put("localId", this.id + "_" + this.bOa);
      }
      return localContentValues;
      str = this.name;
      break;
      str = this.ebN;
      break label190;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.az.m
 * JD-Core Version:    0.7.0.1
 */