package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.storage.IAutoDBItem;

public abstract class dx
  extends IAutoDBItem
{
  public static final String[] INDEX_CREATE = new String[0];
  private static final int fFe;
  private static final int fMZ = "phonenumber".hashCode();
  private static final int fNa = "calltime".hashCode();
  private static final int fNb = "addressId".hashCode();
  private static final int fNc = "phoneType".hashCode();
  private static final int fjl;
  private static final int rowid_HASHCODE = "rowid".hashCode();
  private boolean fES = true;
  private boolean fMV = true;
  private boolean fMW = true;
  private boolean fMX = true;
  private boolean fMY = true;
  public long field_addressId;
  public long field_calltime;
  public long field_duration;
  public int field_phoneType;
  public String field_phonenumber;
  public int field_status;
  private boolean fji = true;
  
  static
  {
    fFe = "duration".hashCode();
    fjl = "status".hashCode();
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
      if (fMZ != k) {
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
      if (fNa == k) {
        this.field_calltime = paramCursor.getLong(i);
      } else if (fFe == k) {
        this.field_duration = paramCursor.getLong(i);
      } else if (fjl == k) {
        this.field_status = paramCursor.getInt(i);
      } else if (fNb == k) {
        this.field_addressId = paramCursor.getLong(i);
      } else if (fNc == k) {
        this.field_phoneType = paramCursor.getInt(i);
      } else if (rowid_HASHCODE == k) {
        this.systemRowid = paramCursor.getLong(i);
      }
    }
  }
  
  public ContentValues convertTo()
  {
    ContentValues localContentValues = new ContentValues();
    if (this.fMV) {
      localContentValues.put("phonenumber", this.field_phonenumber);
    }
    if (this.fMW) {
      localContentValues.put("calltime", Long.valueOf(this.field_calltime));
    }
    if (this.fES) {
      localContentValues.put("duration", Long.valueOf(this.field_duration));
    }
    if (this.fji) {
      localContentValues.put("status", Integer.valueOf(this.field_status));
    }
    if (this.fMX) {
      localContentValues.put("addressId", Long.valueOf(this.field_addressId));
    }
    if (this.fMY) {
      localContentValues.put("phoneType", Integer.valueOf(this.field_phoneType));
    }
    if (this.systemRowid > 0L) {
      localContentValues.put("rowid", Long.valueOf(this.systemRowid));
    }
    return localContentValues;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.g.c.dx
 * JD-Core Version:    0.7.0.1
 */