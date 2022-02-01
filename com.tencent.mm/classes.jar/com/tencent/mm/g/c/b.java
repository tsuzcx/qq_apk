package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;

public abstract class b
  extends c
{
  public static final String[] INDEX_CREATE = new String[0];
  private static final int eED = "insertmsg".hashCode();
  private static final int eEJ = "billNo".hashCode();
  private static final int eEK = "localMsgId".hashCode();
  private static final int eEL = "status".hashCode();
  private static final int rowid_HASHCODE = "rowid".hashCode();
  private boolean eEG = true;
  private boolean eEH = true;
  private boolean eEI = true;
  private boolean eEz = true;
  public String field_billNo;
  public boolean field_insertmsg;
  public long field_localMsgId;
  public int field_status;
  
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
      if (eEJ != k) {
        break label65;
      }
      this.field_billNo = paramCursor.getString(i);
      this.eEG = true;
    }
    for (;;)
    {
      i += 1;
      break label20;
      break;
      label65:
      if (eED == k)
      {
        if (paramCursor.getInt(i) != 0) {}
        for (boolean bool = true;; bool = false)
        {
          this.field_insertmsg = bool;
          break;
        }
      }
      if (eEK == k) {
        this.field_localMsgId = paramCursor.getLong(i);
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
    if (this.eEG) {
      localContentValues.put("billNo", this.field_billNo);
    }
    if (this.eEz) {
      localContentValues.put("insertmsg", Boolean.valueOf(this.field_insertmsg));
    }
    if (this.eEH) {
      localContentValues.put("localMsgId", Long.valueOf(this.field_localMsgId));
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.g.c.b
 * JD-Core Version:    0.7.0.1
 */