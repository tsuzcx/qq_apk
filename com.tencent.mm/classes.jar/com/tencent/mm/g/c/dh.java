package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;

public abstract class dh
  extends c
{
  public static final String[] INDEX_CREATE = new String[0];
  private static final int eJK;
  private static final int eOb = "phonenumber".hashCode();
  private static final int eOc = "calltime".hashCode();
  private static final int eOd = "addressId".hashCode();
  private static final int eOe = "phoneType".hashCode();
  private static final int elV;
  private static final int rowid_HASHCODE = "rowid".hashCode();
  private boolean eJB = true;
  private boolean eNX = true;
  private boolean eNY = true;
  private boolean eNZ = true;
  private boolean eOa = true;
  private boolean elS = true;
  public long field_addressId;
  public long field_calltime;
  public long field_duration;
  public int field_phoneType;
  public String field_phonenumber;
  public int field_status;
  
  static
  {
    eJK = "duration".hashCode();
    elV = "status".hashCode();
  }
  
  public void convertFrom(Cursor paramCursor)
  {
    String[] arrayOfString = paramCursor.getColumnNames();
    if (arrayOfString == null) {
      return;
    }
    int i = 0;
    int j = arrayOfString.length;
    label20:
    int k;
    if (i < j)
    {
      k = arrayOfString[i].hashCode();
      if (eOb != k) {
        break label60;
      }
      this.field_phonenumber = paramCursor.getString(i);
    }
    for (;;)
    {
      i += 1;
      break label20;
      break;
      label60:
      if (eOc == k) {
        this.field_calltime = paramCursor.getLong(i);
      } else if (eJK == k) {
        this.field_duration = paramCursor.getLong(i);
      } else if (elV == k) {
        this.field_status = paramCursor.getInt(i);
      } else if (eOd == k) {
        this.field_addressId = paramCursor.getLong(i);
      } else if (eOe == k) {
        this.field_phoneType = paramCursor.getInt(i);
      } else if (rowid_HASHCODE == k) {
        this.systemRowid = paramCursor.getLong(i);
      }
    }
  }
  
  public ContentValues convertTo()
  {
    ContentValues localContentValues = new ContentValues();
    if (this.eNX) {
      localContentValues.put("phonenumber", this.field_phonenumber);
    }
    if (this.eNY) {
      localContentValues.put("calltime", Long.valueOf(this.field_calltime));
    }
    if (this.eJB) {
      localContentValues.put("duration", Long.valueOf(this.field_duration));
    }
    if (this.elS) {
      localContentValues.put("status", Integer.valueOf(this.field_status));
    }
    if (this.eNZ) {
      localContentValues.put("addressId", Long.valueOf(this.field_addressId));
    }
    if (this.eOa) {
      localContentValues.put("phoneType", Integer.valueOf(this.field_phoneType));
    }
    if (this.systemRowid > 0L) {
      localContentValues.put("rowid", Long.valueOf(this.systemRowid));
    }
    return localContentValues;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.g.c.dh
 * JD-Core Version:    0.7.0.1
 */