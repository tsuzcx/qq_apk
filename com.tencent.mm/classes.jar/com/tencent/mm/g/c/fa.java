package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;

public abstract class fa
  extends c
{
  public static final String[] INDEX_CREATE = new String[0];
  private static final int eXr;
  private static final int eXs;
  private static final int eXt = "invalidtime".hashCode();
  private static final int erG;
  private static final int etX;
  private static final int ezo = "transferId".hashCode();
  private static final int rowid_HASHCODE = "rowid".hashCode();
  private boolean eXo = true;
  private boolean eXp = true;
  private boolean eXq = true;
  private boolean err = true;
  private boolean etJ = true;
  private boolean ezn = true;
  public long field_invalidtime;
  public boolean field_isSend;
  public long field_locaMsgId;
  public int field_receiveStatus;
  public String field_talker;
  public String field_transferId;
  
  static
  {
    eXr = "locaMsgId".hashCode();
    eXs = "receiveStatus".hashCode();
    erG = "isSend".hashCode();
    etX = "talker".hashCode();
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
      if (ezo != k) {
        break label65;
      }
      this.field_transferId = paramCursor.getString(i);
      this.ezn = true;
    }
    for (;;)
    {
      i += 1;
      break label20;
      break;
      label65:
      if (eXr == k)
      {
        this.field_locaMsgId = paramCursor.getLong(i);
      }
      else if (eXs == k)
      {
        this.field_receiveStatus = paramCursor.getInt(i);
      }
      else
      {
        if (erG == k)
        {
          if (paramCursor.getInt(i) != 0) {}
          for (boolean bool = true;; bool = false)
          {
            this.field_isSend = bool;
            break;
          }
        }
        if (etX == k) {
          this.field_talker = paramCursor.getString(i);
        } else if (eXt == k) {
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
    if (this.ezn) {
      localContentValues.put("transferId", this.field_transferId);
    }
    if (this.eXo) {
      localContentValues.put("locaMsgId", Long.valueOf(this.field_locaMsgId));
    }
    if (this.eXp) {
      localContentValues.put("receiveStatus", Integer.valueOf(this.field_receiveStatus));
    }
    if (this.err) {
      localContentValues.put("isSend", Boolean.valueOf(this.field_isSend));
    }
    if (this.etJ) {
      localContentValues.put("talker", this.field_talker);
    }
    if (this.eXq) {
      localContentValues.put("invalidtime", Long.valueOf(this.field_invalidtime));
    }
    if (this.systemRowid > 0L) {
      localContentValues.put("rowid", Long.valueOf(this.systemRowid));
    }
    return localContentValues;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.g.c.fa
 * JD-Core Version:    0.7.0.1
 */