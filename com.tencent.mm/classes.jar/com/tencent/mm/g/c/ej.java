package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;

public abstract class ej
  extends c
{
  public static final String[] INDEX_CREATE = new String[0];
  private static final int eEF = "msgId".hashCode();
  private static final int eEL = "status".hashCode();
  private static final int eMO = "msgSvrId".hashCode();
  private static final int fmF = "quotedMsgId".hashCode();
  private static final int fmG = "quotedMsgSvrId".hashCode();
  private static final int rowid_HASHCODE = "rowid".hashCode();
  private boolean eEB = true;
  private boolean eEI = true;
  private boolean eMA = true;
  public long field_msgId;
  public long field_msgSvrId;
  public long field_quotedMsgId;
  public long field_quotedMsgSvrId;
  public int field_status;
  private boolean fmD = true;
  private boolean fmE = true;
  
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
      if (eEF != k) {
        break label60;
      }
      this.field_msgId = paramCursor.getLong(i);
    }
    for (;;)
    {
      i += 1;
      break label20;
      break;
      label60:
      if (eMO == k) {
        this.field_msgSvrId = paramCursor.getLong(i);
      } else if (fmF == k) {
        this.field_quotedMsgId = paramCursor.getLong(i);
      } else if (fmG == k) {
        this.field_quotedMsgSvrId = paramCursor.getLong(i);
      } else if (eEL == k) {
        this.field_status = paramCursor.getInt(i);
      } else if (rowid_HASHCODE == k) {
        this.systemRowid = paramCursor.getLong(i);
      }
    }
  }
  
  public ContentValues convertTo()
  {
    ContentValues localContentValues = new ContentValues();
    if (this.eEB) {
      localContentValues.put("msgId", Long.valueOf(this.field_msgId));
    }
    if (this.eMA) {
      localContentValues.put("msgSvrId", Long.valueOf(this.field_msgSvrId));
    }
    if (this.fmD) {
      localContentValues.put("quotedMsgId", Long.valueOf(this.field_quotedMsgId));
    }
    if (this.fmE) {
      localContentValues.put("quotedMsgSvrId", Long.valueOf(this.field_quotedMsgSvrId));
    }
    if (this.eEI) {
      localContentValues.put("status", Integer.valueOf(this.field_status));
    }
    if (this.systemRowid > 0L) {
      localContentValues.put("rowid", Long.valueOf(this.systemRowid));
    }
    return localContentValues;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.g.c.ej
 * JD-Core Version:    0.7.0.1
 */