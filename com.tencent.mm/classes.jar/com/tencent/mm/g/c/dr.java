package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;

public abstract class dr
  extends c
{
  public static final String[] INDEX_CREATE = new String[0];
  private static final int eDc;
  private static final int eZm;
  private static final int fgA = "phoneType".hashCode();
  private static final int fgx = "phonenumber".hashCode();
  private static final int fgy = "calltime".hashCode();
  private static final int fgz;
  private static final int rowid_HASHCODE = "rowid".hashCode();
  private boolean eCZ = true;
  private boolean eZa = true;
  private boolean fgt = true;
  private boolean fgu = true;
  private boolean fgv = true;
  private boolean fgw = true;
  public long field_addressId;
  public long field_calltime;
  public long field_duration;
  public int field_phoneType;
  public String field_phonenumber;
  public int field_status;
  
  static
  {
    eZm = "duration".hashCode();
    eDc = "status".hashCode();
    fgz = "addressId".hashCode();
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
      if (fgx != k) {
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
      if (fgy == k) {
        this.field_calltime = paramCursor.getLong(i);
      } else if (eZm == k) {
        this.field_duration = paramCursor.getLong(i);
      } else if (eDc == k) {
        this.field_status = paramCursor.getInt(i);
      } else if (fgz == k) {
        this.field_addressId = paramCursor.getLong(i);
      } else if (fgA == k) {
        this.field_phoneType = paramCursor.getInt(i);
      } else if (rowid_HASHCODE == k) {
        this.systemRowid = paramCursor.getLong(i);
      }
    }
  }
  
  public ContentValues convertTo()
  {
    ContentValues localContentValues = new ContentValues();
    if (this.fgt) {
      localContentValues.put("phonenumber", this.field_phonenumber);
    }
    if (this.fgu) {
      localContentValues.put("calltime", Long.valueOf(this.field_calltime));
    }
    if (this.eZa) {
      localContentValues.put("duration", Long.valueOf(this.field_duration));
    }
    if (this.eCZ) {
      localContentValues.put("status", Integer.valueOf(this.field_status));
    }
    if (this.fgv) {
      localContentValues.put("addressId", Long.valueOf(this.field_addressId));
    }
    if (this.fgw) {
      localContentValues.put("phoneType", Integer.valueOf(this.field_phoneType));
    }
    if (this.systemRowid > 0L) {
      localContentValues.put("rowid", Long.valueOf(this.systemRowid));
    }
    return localContentValues;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.g.c.dr
 * JD-Core Version:    0.7.0.1
 */