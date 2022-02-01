package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;

public abstract class ej
  extends c
{
  public static final String[] INDEX_CREATE = new String[0];
  private static final int eCW = "msgId".hashCode();
  private static final int eDc = "status".hashCode();
  private static final int eLe = "msgSvrId".hashCode();
  private static final int fkH = "quotedMsgId".hashCode();
  private static final int fkI = "quotedMsgSvrId".hashCode();
  private static final int rowid_HASHCODE = "rowid".hashCode();
  private boolean eCS = true;
  private boolean eCZ = true;
  private boolean eKR = true;
  public long field_msgId;
  public long field_msgSvrId;
  public long field_quotedMsgId;
  public long field_quotedMsgSvrId;
  public int field_status;
  private boolean fkF = true;
  private boolean fkG = true;
  
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
      if (eCW != k) {
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
      if (eLe == k) {
        this.field_msgSvrId = paramCursor.getLong(i);
      } else if (fkH == k) {
        this.field_quotedMsgId = paramCursor.getLong(i);
      } else if (fkI == k) {
        this.field_quotedMsgSvrId = paramCursor.getLong(i);
      } else if (eDc == k) {
        this.field_status = paramCursor.getInt(i);
      } else if (rowid_HASHCODE == k) {
        this.systemRowid = paramCursor.getLong(i);
      }
    }
  }
  
  public ContentValues convertTo()
  {
    ContentValues localContentValues = new ContentValues();
    if (this.eCS) {
      localContentValues.put("msgId", Long.valueOf(this.field_msgId));
    }
    if (this.eKR) {
      localContentValues.put("msgSvrId", Long.valueOf(this.field_msgSvrId));
    }
    if (this.fkF) {
      localContentValues.put("quotedMsgId", Long.valueOf(this.field_quotedMsgId));
    }
    if (this.fkG) {
      localContentValues.put("quotedMsgSvrId", Long.valueOf(this.field_quotedMsgSvrId));
    }
    if (this.eCZ) {
      localContentValues.put("status", Integer.valueOf(this.field_status));
    }
    if (this.systemRowid > 0L) {
      localContentValues.put("rowid", Long.valueOf(this.systemRowid));
    }
    return localContentValues;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.g.c.ej
 * JD-Core Version:    0.7.0.1
 */