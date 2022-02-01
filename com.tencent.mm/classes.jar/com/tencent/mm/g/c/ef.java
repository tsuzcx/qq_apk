package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;

public abstract class ef
  extends c
{
  public static final String[] INDEX_CREATE = new String[0];
  private static final int eUT = "reqkey".hashCode();
  private static final int eUU = "ack_key".hashCode();
  private static final int eUV = "receive_time".hashCode();
  private static final int elV = "status".hashCode();
  private static final int rowid_HASHCODE = "rowid".hashCode();
  private boolean eUQ = true;
  private boolean eUR = true;
  private boolean eUS = true;
  private boolean elS = true;
  public String field_ack_key;
  public long field_receive_time;
  public String field_reqkey;
  public int field_status;
  
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
      if (eUT != k) {
        break label65;
      }
      this.field_reqkey = paramCursor.getString(i);
      this.eUQ = true;
    }
    for (;;)
    {
      i += 1;
      break label20;
      break;
      label65:
      if (eUU == k) {
        this.field_ack_key = paramCursor.getString(i);
      } else if (elV == k) {
        this.field_status = paramCursor.getInt(i);
      } else if (eUV == k) {
        this.field_receive_time = paramCursor.getLong(i);
      } else if (rowid_HASHCODE == k) {
        this.systemRowid = paramCursor.getLong(i);
      }
    }
  }
  
  public ContentValues convertTo()
  {
    ContentValues localContentValues = new ContentValues();
    if (this.eUQ) {
      localContentValues.put("reqkey", this.field_reqkey);
    }
    if (this.eUR) {
      localContentValues.put("ack_key", this.field_ack_key);
    }
    if (this.elS) {
      localContentValues.put("status", Integer.valueOf(this.field_status));
    }
    if (this.eUS) {
      localContentValues.put("receive_time", Long.valueOf(this.field_receive_time));
    }
    if (this.systemRowid > 0L) {
      localContentValues.put("rowid", Long.valueOf(this.systemRowid));
    }
    return localContentValues;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.g.c.ef
 * JD-Core Version:    0.7.0.1
 */