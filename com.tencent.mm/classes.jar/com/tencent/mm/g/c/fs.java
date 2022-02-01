package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.storage.IAutoDBItem;

public abstract class fs
  extends IAutoDBItem
{
  public static final String[] INDEX_CREATE = new String[0];
  private static final int fWm;
  private static final int fWn;
  private static final int fWo = "invalidtime".hashCode();
  private static final int foe;
  private static final int fqw;
  private static final int fwc = "transferId".hashCode();
  private static final int rowid_HASHCODE = "rowid".hashCode();
  private boolean fWj = true;
  private boolean fWk = true;
  private boolean fWl = true;
  public long field_invalidtime;
  public boolean field_isSend;
  public long field_locaMsgId;
  public int field_receiveStatus;
  public String field_talker;
  public String field_transferId;
  private boolean fnP = true;
  private boolean fqi = true;
  private boolean fwb = true;
  
  static
  {
    fWm = "locaMsgId".hashCode();
    fWn = "receiveStatus".hashCode();
    foe = "isSend".hashCode();
    fqw = "talker".hashCode();
  }
  
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
      if (fwc != k) {
        break label65;
      }
      this.field_transferId = paramCursor.getString(i);
      this.fwb = true;
    }
    for (;;)
    {
      i += 1;
      break label20;
      break;
      label65:
      if (fWm == k)
      {
        this.field_locaMsgId = paramCursor.getLong(i);
      }
      else if (fWn == k)
      {
        this.field_receiveStatus = paramCursor.getInt(i);
      }
      else
      {
        if (foe == k)
        {
          if (paramCursor.getInt(i) != 0) {}
          for (boolean bool = true;; bool = false)
          {
            this.field_isSend = bool;
            break;
          }
        }
        if (fqw == k) {
          this.field_talker = paramCursor.getString(i);
        } else if (fWo == k) {
          this.field_invalidtime = paramCursor.getLong(i);
        } else if (rowid_HASHCODE == k) {
          this.systemRowid = paramCursor.getLong(i);
        }
      }
    }
  }
  
  public ContentValues convertTo()
  {
    ContentValues localContentValues = new ContentValues();
    if (this.fwb) {
      localContentValues.put("transferId", this.field_transferId);
    }
    if (this.fWj) {
      localContentValues.put("locaMsgId", Long.valueOf(this.field_locaMsgId));
    }
    if (this.fWk) {
      localContentValues.put("receiveStatus", Integer.valueOf(this.field_receiveStatus));
    }
    if (this.fnP) {
      localContentValues.put("isSend", Boolean.valueOf(this.field_isSend));
    }
    if (this.fqi) {
      localContentValues.put("talker", this.field_talker);
    }
    if (this.fWl) {
      localContentValues.put("invalidtime", Long.valueOf(this.field_invalidtime));
    }
    if (this.systemRowid > 0L) {
      localContentValues.put("rowid", Long.valueOf(this.systemRowid));
    }
    return localContentValues;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.g.c.fs
 * JD-Core Version:    0.7.0.1
 */