package com.tencent.mm.h.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;

public abstract class cl
  extends c
{
  private static final int cNQ;
  private static final int cNR;
  private static final int cNS;
  private static final int cNT = "addressId".hashCode();
  private static final int cNU = "phoneType".hashCode();
  public static final String[] cqY = new String[0];
  private static final int crh = "rowid".hashCode();
  private static final int crn;
  private boolean cNL = true;
  private boolean cNM = true;
  private boolean cNN = true;
  private boolean cNO = true;
  private boolean cNP = true;
  private boolean crk = true;
  public long field_addressId;
  public long field_calltime;
  public long field_duration;
  public int field_phoneType;
  public String field_phonenumber;
  public int field_status;
  
  static
  {
    cNQ = "phonenumber".hashCode();
    cNR = "calltime".hashCode();
    cNS = "duration".hashCode();
    crn = "status".hashCode();
  }
  
  public final void d(Cursor paramCursor)
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
      if (cNQ != k) {
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
      if (cNR == k) {
        this.field_calltime = paramCursor.getLong(i);
      } else if (cNS == k) {
        this.field_duration = paramCursor.getLong(i);
      } else if (crn == k) {
        this.field_status = paramCursor.getInt(i);
      } else if (cNT == k) {
        this.field_addressId = paramCursor.getLong(i);
      } else if (cNU == k) {
        this.field_phoneType = paramCursor.getInt(i);
      } else if (crh == k) {
        this.ujK = paramCursor.getLong(i);
      }
    }
  }
  
  public final ContentValues vf()
  {
    ContentValues localContentValues = new ContentValues();
    if (this.cNL) {
      localContentValues.put("phonenumber", this.field_phonenumber);
    }
    if (this.cNM) {
      localContentValues.put("calltime", Long.valueOf(this.field_calltime));
    }
    if (this.cNN) {
      localContentValues.put("duration", Long.valueOf(this.field_duration));
    }
    if (this.crk) {
      localContentValues.put("status", Integer.valueOf(this.field_status));
    }
    if (this.cNO) {
      localContentValues.put("addressId", Long.valueOf(this.field_addressId));
    }
    if (this.cNP) {
      localContentValues.put("phoneType", Integer.valueOf(this.field_phoneType));
    }
    if (this.ujK > 0L) {
      localContentValues.put("rowid", Long.valueOf(this.ujK));
    }
    return localContentValues;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.h.c.cl
 * JD-Core Version:    0.7.0.1
 */