package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;

public abstract class gi
  extends c
{
  public static final String[] INDEX_CREATE = new String[0];
  private static final int eHJ = "receiveTime".hashCode();
  private static final int eUh = "receiveStatus".hashCode();
  private static final int fdc = "mNativeUrl".hashCode();
  private static final int fdd = "hbType".hashCode();
  private static final int fde = "receiveAmount".hashCode();
  private static final int fdf = "hbStatus".hashCode();
  private static final int rowid_HASHCODE = "rowid".hashCode();
  private boolean eHy = true;
  private boolean eUf = true;
  private boolean fcY = true;
  private boolean fcZ = true;
  private boolean fda = true;
  private boolean fdb = true;
  public int field_hbStatus;
  public int field_hbType;
  public String field_mNativeUrl;
  public long field_receiveAmount;
  public int field_receiveStatus;
  public long field_receiveTime;
  
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
      if (fdc != k) {
        break label65;
      }
      this.field_mNativeUrl = paramCursor.getString(i);
      this.fcY = true;
    }
    for (;;)
    {
      i += 1;
      break label20;
      break;
      label65:
      if (fdd == k) {
        this.field_hbType = paramCursor.getInt(i);
      } else if (fde == k) {
        this.field_receiveAmount = paramCursor.getLong(i);
      } else if (eHJ == k) {
        this.field_receiveTime = paramCursor.getLong(i);
      } else if (eUh == k) {
        this.field_receiveStatus = paramCursor.getInt(i);
      } else if (fdf == k) {
        this.field_hbStatus = paramCursor.getInt(i);
      } else if (rowid_HASHCODE == k) {
        this.systemRowid = paramCursor.getLong(i);
      }
    }
  }
  
  public ContentValues convertTo()
  {
    ContentValues localContentValues = new ContentValues();
    if (this.fcY) {
      localContentValues.put("mNativeUrl", this.field_mNativeUrl);
    }
    if (this.fcZ) {
      localContentValues.put("hbType", Integer.valueOf(this.field_hbType));
    }
    if (this.fda) {
      localContentValues.put("receiveAmount", Long.valueOf(this.field_receiveAmount));
    }
    if (this.eHy) {
      localContentValues.put("receiveTime", Long.valueOf(this.field_receiveTime));
    }
    if (this.eUf) {
      localContentValues.put("receiveStatus", Integer.valueOf(this.field_receiveStatus));
    }
    if (this.fdb) {
      localContentValues.put("hbStatus", Integer.valueOf(this.field_hbStatus));
    }
    if (this.systemRowid > 0L) {
      localContentValues.put("rowid", Long.valueOf(this.systemRowid));
    }
    return localContentValues;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.g.c.gi
 * JD-Core Version:    0.7.0.1
 */