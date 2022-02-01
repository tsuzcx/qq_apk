package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;

public abstract class hj
  extends c
{
  public static final String[] INDEX_CREATE = new String[0];
  private static final int eCW = "msgId".hashCode();
  private static final int eFM = "size".hashCode();
  private static final int eFp = "username".hashCode();
  private static final int eFw;
  private static final int eIQ = "msgType".hashCode();
  private static final int fBA = "msgSubType".hashCode();
  private static final int fBB = "msgtime".hashCode();
  private static final int rowid_HASHCODE = "rowid".hashCode();
  private boolean eCS = true;
  private boolean eFK = true;
  private boolean eFm = true;
  private boolean eFs = true;
  private boolean eIB = true;
  private boolean fBy = true;
  private boolean fBz = true;
  public long field_msgId;
  public int field_msgSubType;
  public int field_msgType;
  public long field_msgtime;
  public String field_path;
  public long field_size;
  public String field_username;
  
  static
  {
    eFw = "path".hashCode();
  }
  
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
      if (eFp == k) {
        this.field_username = paramCursor.getString(i);
      } else if (eIQ == k) {
        this.field_msgType = paramCursor.getInt(i);
      } else if (fBA == k) {
        this.field_msgSubType = paramCursor.getInt(i);
      } else if (eFw == k) {
        this.field_path = paramCursor.getString(i);
      } else if (eFM == k) {
        this.field_size = paramCursor.getLong(i);
      } else if (fBB == k) {
        this.field_msgtime = paramCursor.getLong(i);
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
    if (this.eFm) {
      localContentValues.put("username", this.field_username);
    }
    if (this.eIB) {
      localContentValues.put("msgType", Integer.valueOf(this.field_msgType));
    }
    if (this.fBy) {
      localContentValues.put("msgSubType", Integer.valueOf(this.field_msgSubType));
    }
    if (this.eFs) {
      localContentValues.put("path", this.field_path);
    }
    if (this.eFK) {
      localContentValues.put("size", Long.valueOf(this.field_size));
    }
    if (this.fBz) {
      localContentValues.put("msgtime", Long.valueOf(this.field_msgtime));
    }
    if (this.systemRowid > 0L) {
      localContentValues.put("rowid", Long.valueOf(this.systemRowid));
    }
    return localContentValues;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.g.c.hj
 * JD-Core Version:    0.7.0.1
 */