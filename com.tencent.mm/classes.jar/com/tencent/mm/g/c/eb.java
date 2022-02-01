package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;

public abstract class eb
  extends c
{
  public static final String[] INDEX_CREATE = new String[0];
  private static final int eRJ = "reqkey".hashCode();
  private static final int eRK = "ack_key".hashCode();
  private static final int eRL = "receive_time".hashCode();
  private static final int ejR = "status".hashCode();
  private static final int rowid_HASHCODE = "rowid".hashCode();
  private boolean eRG = true;
  private boolean eRH = true;
  private boolean eRI = true;
  private boolean ejO = true;
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
      if (eRJ != k) {
        break label65;
      }
      this.field_reqkey = paramCursor.getString(i);
      this.eRG = true;
    }
    for (;;)
    {
      i += 1;
      break label20;
      break;
      label65:
      if (eRK == k) {
        this.field_ack_key = paramCursor.getString(i);
      } else if (ejR == k) {
        this.field_status = paramCursor.getInt(i);
      } else if (eRL == k) {
        this.field_receive_time = paramCursor.getLong(i);
      } else if (rowid_HASHCODE == k) {
        this.systemRowid = paramCursor.getLong(i);
      }
    }
  }
  
  public ContentValues convertTo()
  {
    ContentValues localContentValues = new ContentValues();
    if (this.eRG) {
      localContentValues.put("reqkey", this.field_reqkey);
    }
    if (this.eRH) {
      localContentValues.put("ack_key", this.field_ack_key);
    }
    if (this.ejO) {
      localContentValues.put("status", Integer.valueOf(this.field_status));
    }
    if (this.eRI) {
      localContentValues.put("receive_time", Long.valueOf(this.field_receive_time));
    }
    if (this.systemRowid > 0L) {
      localContentValues.put("rowid", Long.valueOf(this.systemRowid));
    }
    return localContentValues;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.g.c.eb
 * JD-Core Version:    0.7.0.1
 */