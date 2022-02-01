package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.storage.IAutoDBItem;

public abstract class hw
  extends IAutoDBItem
{
  public static final String[] INDEX_CREATE = new String[0];
  private static final int fjf = "msgId".hashCode();
  private static final int fkH = "path".hashCode();
  private static final int fkX = "size".hashCode();
  private static final int fof;
  private static final int giK;
  private static final int giL = "msgtime".hashCode();
  private static final int rowid_HASHCODE = "rowid".hashCode();
  private static final int username_HASHCODE = "username".hashCode();
  private boolean __hadSetusername = true;
  public long field_msgId;
  public int field_msgSubType;
  public int field_msgType;
  public long field_msgtime;
  public String field_path;
  public long field_size;
  public String field_username;
  private boolean fjb = true;
  private boolean fkD = true;
  private boolean fkV = true;
  private boolean fnQ = true;
  private boolean giI = true;
  private boolean giJ = true;
  
  static
  {
    fof = "msgType".hashCode();
    giK = "msgSubType".hashCode();
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
      if (fjf != k) {
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
      if (username_HASHCODE == k) {
        this.field_username = paramCursor.getString(i);
      } else if (fof == k) {
        this.field_msgType = paramCursor.getInt(i);
      } else if (giK == k) {
        this.field_msgSubType = paramCursor.getInt(i);
      } else if (fkH == k) {
        this.field_path = paramCursor.getString(i);
      } else if (fkX == k) {
        this.field_size = paramCursor.getLong(i);
      } else if (giL == k) {
        this.field_msgtime = paramCursor.getLong(i);
      } else if (rowid_HASHCODE == k) {
        this.systemRowid = paramCursor.getLong(i);
      }
    }
  }
  
  public ContentValues convertTo()
  {
    ContentValues localContentValues = new ContentValues();
    if (this.fjb) {
      localContentValues.put("msgId", Long.valueOf(this.field_msgId));
    }
    if (this.__hadSetusername) {
      localContentValues.put("username", this.field_username);
    }
    if (this.fnQ) {
      localContentValues.put("msgType", Integer.valueOf(this.field_msgType));
    }
    if (this.giI) {
      localContentValues.put("msgSubType", Integer.valueOf(this.field_msgSubType));
    }
    if (this.fkD) {
      localContentValues.put("path", this.field_path);
    }
    if (this.fkV) {
      localContentValues.put("size", Long.valueOf(this.field_size));
    }
    if (this.giJ) {
      localContentValues.put("msgtime", Long.valueOf(this.field_msgtime));
    }
    if (this.systemRowid > 0L) {
      localContentValues.put("rowid", Long.valueOf(this.systemRowid));
    }
    return localContentValues;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.g.c.hw
 * JD-Core Version:    0.7.0.1
 */