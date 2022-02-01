package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;

public abstract class dr
  extends c
{
  public static final String[] INDEX_CREATE = new String[0];
  private static final int eEL = "status".hashCode();
  private static final int faZ;
  private static final int fiv = "phonenumber".hashCode();
  private static final int fiw = "calltime".hashCode();
  private static final int fix = "addressId".hashCode();
  private static final int fiy = "phoneType".hashCode();
  private static final int rowid_HASHCODE = "rowid".hashCode();
  private boolean eEI = true;
  private boolean faN = true;
  public long field_addressId;
  public long field_calltime;
  public long field_duration;
  public int field_phoneType;
  public String field_phonenumber;
  public int field_status;
  private boolean fiq = true;
  private boolean fir = true;
  private boolean fit = true;
  private boolean fiu = true;
  
  static
  {
    faZ = "duration".hashCode();
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
      if (fiv != k) {
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
      if (fiw == k) {
        this.field_calltime = paramCursor.getLong(i);
      } else if (faZ == k) {
        this.field_duration = paramCursor.getLong(i);
      } else if (eEL == k) {
        this.field_status = paramCursor.getInt(i);
      } else if (fix == k) {
        this.field_addressId = paramCursor.getLong(i);
      } else if (fiy == k) {
        this.field_phoneType = paramCursor.getInt(i);
      } else if (rowid_HASHCODE == k) {
        this.systemRowid = paramCursor.getLong(i);
      }
    }
  }
  
  public ContentValues convertTo()
  {
    ContentValues localContentValues = new ContentValues();
    if (this.fiq) {
      localContentValues.put("phonenumber", this.field_phonenumber);
    }
    if (this.fir) {
      localContentValues.put("calltime", Long.valueOf(this.field_calltime));
    }
    if (this.faN) {
      localContentValues.put("duration", Long.valueOf(this.field_duration));
    }
    if (this.eEI) {
      localContentValues.put("status", Integer.valueOf(this.field_status));
    }
    if (this.fit) {
      localContentValues.put("addressId", Long.valueOf(this.field_addressId));
    }
    if (this.fiu) {
      localContentValues.put("phoneType", Integer.valueOf(this.field_phoneType));
    }
    if (this.systemRowid > 0L) {
      localContentValues.put("rowid", Long.valueOf(this.systemRowid));
    }
    return localContentValues;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.g.c.dr
 * JD-Core Version:    0.7.0.1
 */