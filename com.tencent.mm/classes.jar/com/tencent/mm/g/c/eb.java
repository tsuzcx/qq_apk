package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;

public abstract class eb
  extends c
{
  public static final String[] INDEX_CREATE = new String[0];
  private static final int dLn = "locaMsgId".hashCode();
  private static final int dLo = "receiveStatus".hashCode();
  private static final int dle = "isSend".hashCode();
  private static final int drW = "transferId".hashCode();
  private static final int rowid_HASHCODE = "rowid".hashCode();
  private boolean dLl = true;
  private boolean dLm = true;
  private boolean dkQ = true;
  private boolean drV = true;
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
      if (drW != k) {
        break label65;
      }
      this.field_transferId = paramCursor.getString(i);
      this.drV = true;
    }
    for (;;)
    {
      i += 1;
      break label20;
      break;
      label65:
      if (dLn == k)
      {
        this.field_locaMsgId = paramCursor.getLong(i);
      }
      else if (dLo == k)
      {
        this.field_receiveStatus = paramCursor.getInt(i);
      }
      else
      {
        if (dle == k)
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
    if (this.drV) {
      localContentValues.put("transferId", this.field_transferId);
    }
    if (this.dLl) {
      localContentValues.put("locaMsgId", Long.valueOf(this.field_locaMsgId));
    }
    if (this.dLm) {
      localContentValues.put("receiveStatus", Integer.valueOf(this.field_receiveStatus));
    }
    if (this.dkQ) {
      localContentValues.put("isSend", Boolean.valueOf(this.field_isSend));
    }
    if (this.systemRowid > 0L) {
      localContentValues.put("rowid", Long.valueOf(this.systemRowid));
    }
    return localContentValues;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.g.c.eb
 * JD-Core Version:    0.7.0.1
 */