package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;

public abstract class dv
  extends c
{
  public static final String[] INDEX_CREATE = new String[0];
  private static final int ePk = "quotedMsgId".hashCode();
  private static final int ePl = "quotedMsgSvrId".hashCode();
  private static final int ejL = "msgId".hashCode();
  private static final int ejR = "status".hashCode();
  private static final int erS = "msgSvrId".hashCode();
  private static final int rowid_HASHCODE = "rowid".hashCode();
  private boolean ePi = true;
  private boolean ePj = true;
  private boolean ejH = true;
  private boolean ejO = true;
  private boolean erE = true;
  public long field_msgId;
  public long field_msgSvrId;
  public long field_quotedMsgId;
  public long field_quotedMsgSvrId;
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
      if (ejL != k) {
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
      if (erS == k) {
        this.field_msgSvrId = paramCursor.getLong(i);
      } else if (ePk == k) {
        this.field_quotedMsgId = paramCursor.getLong(i);
      } else if (ePl == k) {
        this.field_quotedMsgSvrId = paramCursor.getLong(i);
      } else if (ejR == k) {
        this.field_status = paramCursor.getInt(i);
      } else if (rowid_HASHCODE == k) {
        this.systemRowid = paramCursor.getLong(i);
      }
    }
  }
  
  public ContentValues convertTo()
  {
    ContentValues localContentValues = new ContentValues();
    if (this.ejH) {
      localContentValues.put("msgId", Long.valueOf(this.field_msgId));
    }
    if (this.erE) {
      localContentValues.put("msgSvrId", Long.valueOf(this.field_msgSvrId));
    }
    if (this.ePi) {
      localContentValues.put("quotedMsgId", Long.valueOf(this.field_quotedMsgId));
    }
    if (this.ePj) {
      localContentValues.put("quotedMsgSvrId", Long.valueOf(this.field_quotedMsgSvrId));
    }
    if (this.ejO) {
      localContentValues.put("status", Integer.valueOf(this.field_status));
    }
    if (this.systemRowid > 0L) {
      localContentValues.put("rowid", Long.valueOf(this.systemRowid));
    }
    return localContentValues;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.g.c.dv
 * JD-Core Version:    0.7.0.1
 */