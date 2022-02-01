package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;

public abstract class ep
  extends c
{
  public static final String[] INDEX_CREATE = new String[0];
  private static final int eEL = "status".hashCode();
  private static final int fpi = "reqkey".hashCode();
  private static final int fpj = "ack_key".hashCode();
  private static final int fpk = "receive_time".hashCode();
  private static final int rowid_HASHCODE = "rowid".hashCode();
  private boolean eEI = true;
  public String field_ack_key;
  public long field_receive_time;
  public String field_reqkey;
  public int field_status;
  private boolean fpf = true;
  private boolean fpg = true;
  private boolean fph = true;
  
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
      if (fpi != k) {
        break label65;
      }
      this.field_reqkey = paramCursor.getString(i);
      this.fpf = true;
    }
    for (;;)
    {
      i += 1;
      break label20;
      break;
      label65:
      if (fpj == k) {
        this.field_ack_key = paramCursor.getString(i);
      } else if (eEL == k) {
        this.field_status = paramCursor.getInt(i);
      } else if (fpk == k) {
        this.field_receive_time = paramCursor.getLong(i);
      } else if (rowid_HASHCODE == k) {
        this.systemRowid = paramCursor.getLong(i);
      }
    }
  }
  
  public ContentValues convertTo()
  {
    ContentValues localContentValues = new ContentValues();
    if (this.fpf) {
      localContentValues.put("reqkey", this.field_reqkey);
    }
    if (this.fpg) {
      localContentValues.put("ack_key", this.field_ack_key);
    }
    if (this.eEI) {
      localContentValues.put("status", Integer.valueOf(this.field_status));
    }
    if (this.fph) {
      localContentValues.put("receive_time", Long.valueOf(this.field_receive_time));
    }
    if (this.systemRowid > 0L) {
      localContentValues.put("rowid", Long.valueOf(this.systemRowid));
    }
    return localContentValues;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.g.c.ep
 * JD-Core Version:    0.7.0.1
 */