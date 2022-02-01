package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;

public abstract class df
  extends c
{
  public static final String[] INDEX_CREATE = new String[0];
  private static final int eGS;
  private static final int eLj = "phonenumber".hashCode();
  private static final int eLk = "calltime".hashCode();
  private static final int eLl = "addressId".hashCode();
  private static final int eLm = "phoneType".hashCode();
  private static final int ejR;
  private static final int rowid_HASHCODE = "rowid".hashCode();
  private boolean eGJ = true;
  private boolean eLf = true;
  private boolean eLg = true;
  private boolean eLh = true;
  private boolean eLi = true;
  private boolean ejO = true;
  public long field_addressId;
  public long field_calltime;
  public long field_duration;
  public int field_phoneType;
  public String field_phonenumber;
  public int field_status;
  
  static
  {
    eGS = "duration".hashCode();
    ejR = "status".hashCode();
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
      if (eLj != k) {
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
      if (eLk == k) {
        this.field_calltime = paramCursor.getLong(i);
      } else if (eGS == k) {
        this.field_duration = paramCursor.getLong(i);
      } else if (ejR == k) {
        this.field_status = paramCursor.getInt(i);
      } else if (eLl == k) {
        this.field_addressId = paramCursor.getLong(i);
      } else if (eLm == k) {
        this.field_phoneType = paramCursor.getInt(i);
      } else if (rowid_HASHCODE == k) {
        this.systemRowid = paramCursor.getLong(i);
      }
    }
  }
  
  public ContentValues convertTo()
  {
    ContentValues localContentValues = new ContentValues();
    if (this.eLf) {
      localContentValues.put("phonenumber", this.field_phonenumber);
    }
    if (this.eLg) {
      localContentValues.put("calltime", Long.valueOf(this.field_calltime));
    }
    if (this.eGJ) {
      localContentValues.put("duration", Long.valueOf(this.field_duration));
    }
    if (this.ejO) {
      localContentValues.put("status", Integer.valueOf(this.field_status));
    }
    if (this.eLh) {
      localContentValues.put("addressId", Long.valueOf(this.field_addressId));
    }
    if (this.eLi) {
      localContentValues.put("phoneType", Integer.valueOf(this.field_phoneType));
    }
    if (this.systemRowid > 0L) {
      localContentValues.put("rowid", Long.valueOf(this.systemRowid));
    }
    return localContentValues;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.g.c.df
 * JD-Core Version:    0.7.0.1
 */