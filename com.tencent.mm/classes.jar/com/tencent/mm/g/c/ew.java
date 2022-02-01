package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;

public abstract class ew
  extends c
{
  public static final String[] INDEX_CREATE = new String[0];
  private static final int eUg = "locaMsgId".hashCode();
  private static final int eUh = "receiveStatus".hashCode();
  private static final int epC = "isSend".hashCode();
  private static final int ewR = "transferId".hashCode();
  private static final int rowid_HASHCODE = "rowid".hashCode();
  private boolean eUe = true;
  private boolean eUf = true;
  private boolean epn = true;
  private boolean ewQ = true;
  public boolean field_isSend;
  public long field_locaMsgId;
  public int field_receiveStatus;
  public String field_transferId;
  
  public void convertFrom(Cursor paramCursor)
  {
    String[] arrayOfString = paramCursor.getColumnNames();
    if (arrayOfString == null) {
      return;
    }
    int j = arrayOfString.length;
    int i = 0;
    label20:
    int k;
    if (i < j)
    {
      k = arrayOfString[i].hashCode();
      if (ewR != k) {
        break label65;
      }
      this.field_transferId = paramCursor.getString(i);
      this.ewQ = true;
    }
    for (;;)
    {
      i += 1;
      break label20;
      break;
      label65:
      if (eUg == k)
      {
        this.field_locaMsgId = paramCursor.getLong(i);
      }
      else if (eUh == k)
      {
        this.field_receiveStatus = paramCursor.getInt(i);
      }
      else
      {
        if (epC == k)
        {
          if (paramCursor.getInt(i) != 0) {}
          for (boolean bool = true;; bool = false)
          {
            this.field_isSend = bool;
            break;
          }
        }
        if (rowid_HASHCODE == k) {
          this.systemRowid = paramCursor.getLong(i);
        }
      }
    }
  }
  
  public ContentValues convertTo()
  {
    ContentValues localContentValues = new ContentValues();
    if (this.ewQ) {
      localContentValues.put("transferId", this.field_transferId);
    }
    if (this.eUe) {
      localContentValues.put("locaMsgId", Long.valueOf(this.field_locaMsgId));
    }
    if (this.eUf) {
      localContentValues.put("receiveStatus", Integer.valueOf(this.field_receiveStatus));
    }
    if (this.epn) {
      localContentValues.put("isSend", Boolean.valueOf(this.field_isSend));
    }
    if (this.systemRowid > 0L) {
      localContentValues.put("rowid", Long.valueOf(this.systemRowid));
    }
    return localContentValues;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.g.c.ew
 * JD-Core Version:    0.7.0.1
 */