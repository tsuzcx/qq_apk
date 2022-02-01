package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;

public abstract class fk
  extends c
{
  public static final String[] INDEX_CREATE = new String[0];
  private static final int eKy = "isSend".hashCode();
  private static final int eMP = "talker".hashCode();
  private static final int eSx = "transferId".hashCode();
  private static final int frH = "locaMsgId".hashCode();
  private static final int frI = "receiveStatus".hashCode();
  private static final int frJ = "invalidtime".hashCode();
  private static final int rowid_HASHCODE = "rowid".hashCode();
  private boolean eKj = true;
  private boolean eMB = true;
  private boolean eSw = true;
  public long field_invalidtime;
  public boolean field_isSend;
  public long field_locaMsgId;
  public int field_receiveStatus;
  public String field_talker;
  public String field_transferId;
  private boolean frE = true;
  private boolean frF = true;
  private boolean frG = true;
  
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
      if (eSx != k) {
        break label65;
      }
      this.field_transferId = paramCursor.getString(i);
      this.eSw = true;
    }
    for (;;)
    {
      i += 1;
      break label20;
      break;
      label65:
      if (frH == k)
      {
        this.field_locaMsgId = paramCursor.getLong(i);
      }
      else if (frI == k)
      {
        this.field_receiveStatus = paramCursor.getInt(i);
      }
      else
      {
        if (eKy == k)
        {
          if (paramCursor.getInt(i) != 0) {}
          for (boolean bool = true;; bool = false)
          {
            this.field_isSend = bool;
            break;
          }
        }
        if (eMP == k) {
          this.field_talker = paramCursor.getString(i);
        } else if (frJ == k) {
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
    if (this.eSw) {
      localContentValues.put("transferId", this.field_transferId);
    }
    if (this.frE) {
      localContentValues.put("locaMsgId", Long.valueOf(this.field_locaMsgId));
    }
    if (this.frF) {
      localContentValues.put("receiveStatus", Integer.valueOf(this.field_receiveStatus));
    }
    if (this.eKj) {
      localContentValues.put("isSend", Boolean.valueOf(this.field_isSend));
    }
    if (this.eMB) {
      localContentValues.put("talker", this.field_talker);
    }
    if (this.frG) {
      localContentValues.put("invalidtime", Long.valueOf(this.field_invalidtime));
    }
    if (this.systemRowid > 0L) {
      localContentValues.put("rowid", Long.valueOf(this.systemRowid));
    }
    return localContentValues;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.g.c.fk
 * JD-Core Version:    0.7.0.1
 */