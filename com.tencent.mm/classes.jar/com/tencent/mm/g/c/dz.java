package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;

public abstract class dz
  extends c
{
  public static final String[] INDEX_CREATE = new String[0];
  private static final int eSs = "quotedMsgId".hashCode();
  private static final int eSt = "quotedMsgSvrId".hashCode();
  private static final int elP = "msgId".hashCode();
  private static final int elV = "status".hashCode();
  private static final int etW = "msgSvrId".hashCode();
  private static final int rowid_HASHCODE = "rowid".hashCode();
  private boolean eSq = true;
  private boolean eSr = true;
  private boolean elL = true;
  private boolean elS = true;
  private boolean etI = true;
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
      if (elP != k) {
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
      if (etW == k) {
        this.field_msgSvrId = paramCursor.getLong(i);
      } else if (eSs == k) {
        this.field_quotedMsgId = paramCursor.getLong(i);
      } else if (eSt == k) {
        this.field_quotedMsgSvrId = paramCursor.getLong(i);
      } else if (elV == k) {
        this.field_status = paramCursor.getInt(i);
      } else if (rowid_HASHCODE == k) {
        this.systemRowid = paramCursor.getLong(i);
      }
    }
  }
  
  public ContentValues convertTo()
  {
    ContentValues localContentValues = new ContentValues();
    if (this.elL) {
      localContentValues.put("msgId", Long.valueOf(this.field_msgId));
    }
    if (this.etI) {
      localContentValues.put("msgSvrId", Long.valueOf(this.field_msgSvrId));
    }
    if (this.eSq) {
      localContentValues.put("quotedMsgId", Long.valueOf(this.field_quotedMsgId));
    }
    if (this.eSr) {
      localContentValues.put("quotedMsgSvrId", Long.valueOf(this.field_quotedMsgSvrId));
    }
    if (this.elS) {
      localContentValues.put("status", Integer.valueOf(this.field_status));
    }
    if (this.systemRowid > 0L) {
      localContentValues.put("rowid", Long.valueOf(this.systemRowid));
    }
    return localContentValues;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.g.c.dz
 * JD-Core Version:    0.7.0.1
 */