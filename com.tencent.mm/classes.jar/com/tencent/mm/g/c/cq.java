package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;

public abstract class cq
  extends c
{
  public static final String[] INDEX_CREATE = new String[0];
  private static final int dAk;
  private static final int dDF = "phonenumber".hashCode();
  private static final int dDG = "calltime".hashCode();
  private static final int dDH = "addressId".hashCode();
  private static final int dDI = "phoneType".hashCode();
  private static final int dfJ;
  private static final int rowid_HASHCODE = "rowid".hashCode();
  private boolean dAc = true;
  private boolean dDB = true;
  private boolean dDC = true;
  private boolean dDD = true;
  private boolean dDE = true;
  private boolean dfG = true;
  public long field_addressId;
  public long field_calltime;
  public long field_duration;
  public int field_phoneType;
  public String field_phonenumber;
  public int field_status;
  
  static
  {
    dAk = "duration".hashCode();
    dfJ = "status".hashCode();
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
      if (dDF != k) {
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
      if (dDG == k) {
        this.field_calltime = paramCursor.getLong(i);
      } else if (dAk == k) {
        this.field_duration = paramCursor.getLong(i);
      } else if (dfJ == k) {
        this.field_status = paramCursor.getInt(i);
      } else if (dDH == k) {
        this.field_addressId = paramCursor.getLong(i);
      } else if (dDI == k) {
        this.field_phoneType = paramCursor.getInt(i);
      } else if (rowid_HASHCODE == k) {
        this.systemRowid = paramCursor.getLong(i);
      }
    }
  }
  
  public ContentValues convertTo()
  {
    ContentValues localContentValues = new ContentValues();
    if (this.dDB) {
      localContentValues.put("phonenumber", this.field_phonenumber);
    }
    if (this.dDC) {
      localContentValues.put("calltime", Long.valueOf(this.field_calltime));
    }
    if (this.dAc) {
      localContentValues.put("duration", Long.valueOf(this.field_duration));
    }
    if (this.dfG) {
      localContentValues.put("status", Integer.valueOf(this.field_status));
    }
    if (this.dDD) {
      localContentValues.put("addressId", Long.valueOf(this.field_addressId));
    }
    if (this.dDE) {
      localContentValues.put("phoneType", Integer.valueOf(this.field_phoneType));
    }
    if (this.systemRowid > 0L) {
      localContentValues.put("rowid", Long.valueOf(this.systemRowid));
    }
    return localContentValues;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.g.c.cq
 * JD-Core Version:    0.7.0.1
 */