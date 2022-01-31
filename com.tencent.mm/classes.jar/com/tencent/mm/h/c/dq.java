package com.tencent.mm.h.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;

public abstract class dq
  extends c
{
  private static final int cDM;
  private static final int cVb;
  private static final int cVc;
  public static final String[] cqY = new String[0];
  private static final int crh = "rowid".hashCode();
  private static final int cxd;
  private boolean cDL = true;
  private boolean cUZ = true;
  private boolean cVa = true;
  private boolean cwP = true;
  public boolean field_isSend;
  public long field_locaMsgId;
  public int field_receiveStatus;
  public String field_transferId;
  
  static
  {
    cDM = "transferId".hashCode();
    cVb = "locaMsgId".hashCode();
    cVc = "receiveStatus".hashCode();
    cxd = "isSend".hashCode();
  }
  
  public final void d(Cursor paramCursor)
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
      if (cDM != k) {
        break label65;
      }
      this.field_transferId = paramCursor.getString(i);
      this.cDL = true;
    }
    for (;;)
    {
      i += 1;
      break label20;
      break;
      label65:
      if (cVb == k)
      {
        this.field_locaMsgId = paramCursor.getLong(i);
      }
      else if (cVc == k)
      {
        this.field_receiveStatus = paramCursor.getInt(i);
      }
      else
      {
        if (cxd == k)
        {
          if (paramCursor.getInt(i) != 0) {}
          for (boolean bool = true;; bool = false)
          {
            this.field_isSend = bool;
            break;
          }
        }
        if (crh == k) {
          this.ujK = paramCursor.getLong(i);
        }
      }
    }
  }
  
  public final ContentValues vf()
  {
    ContentValues localContentValues = new ContentValues();
    if (this.cDL) {
      localContentValues.put("transferId", this.field_transferId);
    }
    if (this.cUZ) {
      localContentValues.put("locaMsgId", Long.valueOf(this.field_locaMsgId));
    }
    if (this.cVa) {
      localContentValues.put("receiveStatus", Integer.valueOf(this.field_receiveStatus));
    }
    if (this.cwP) {
      localContentValues.put("isSend", Boolean.valueOf(this.field_isSend));
    }
    if (this.ujK > 0L) {
      localContentValues.put("rowid", Long.valueOf(this.ujK));
    }
    return localContentValues;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.h.c.dq
 * JD-Core Version:    0.7.0.1
 */