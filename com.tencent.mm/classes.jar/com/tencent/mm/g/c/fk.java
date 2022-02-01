package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;

public abstract class fk
  extends c
{
  public static final String[] INDEX_CREATE = new String[0];
  private static final int eIP = "isSend".hashCode();
  private static final int eLf = "talker".hashCode();
  private static final int eQM = "transferId".hashCode();
  private static final int fpH = "locaMsgId".hashCode();
  private static final int fpI = "receiveStatus".hashCode();
  private static final int fpJ = "invalidtime".hashCode();
  private static final int rowid_HASHCODE = "rowid".hashCode();
  private boolean eIA = true;
  private boolean eKS = true;
  private boolean eQL = true;
  public long field_invalidtime;
  public boolean field_isSend;
  public long field_locaMsgId;
  public int field_receiveStatus;
  public String field_talker;
  public String field_transferId;
  private boolean fpE = true;
  private boolean fpF = true;
  private boolean fpG = true;
  
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
      if (eQM != k) {
        break label65;
      }
      this.field_transferId = paramCursor.getString(i);
      this.eQL = true;
    }
    for (;;)
    {
      i += 1;
      break label20;
      break;
      label65:
      if (fpH == k)
      {
        this.field_locaMsgId = paramCursor.getLong(i);
      }
      else if (fpI == k)
      {
        this.field_receiveStatus = paramCursor.getInt(i);
      }
      else
      {
        if (eIP == k)
        {
          if (paramCursor.getInt(i) != 0) {}
          for (boolean bool = true;; bool = false)
          {
            this.field_isSend = bool;
            break;
          }
        }
        if (eLf == k) {
          this.field_talker = paramCursor.getString(i);
        } else if (fpJ == k) {
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
    if (this.eQL) {
      localContentValues.put("transferId", this.field_transferId);
    }
    if (this.fpE) {
      localContentValues.put("locaMsgId", Long.valueOf(this.field_locaMsgId));
    }
    if (this.fpF) {
      localContentValues.put("receiveStatus", Integer.valueOf(this.field_receiveStatus));
    }
    if (this.eIA) {
      localContentValues.put("isSend", Boolean.valueOf(this.field_isSend));
    }
    if (this.eKS) {
      localContentValues.put("talker", this.field_talker);
    }
    if (this.fpG) {
      localContentValues.put("invalidtime", Long.valueOf(this.field_invalidtime));
    }
    if (this.systemRowid > 0L) {
      localContentValues.put("rowid", Long.valueOf(this.systemRowid));
    }
    return localContentValues;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.g.c.fk
 * JD-Core Version:    0.7.0.1
 */