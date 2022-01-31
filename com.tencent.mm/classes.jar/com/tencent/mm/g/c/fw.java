package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;

public abstract class fw
  extends c
{
  public static final String[] INDEX_CREATE = new String[0];
  private static final int dWD;
  private static final int dWE = "msgtime".hashCode();
  private static final int dfD = "msgId".hashCode();
  private static final int dhU = "username".hashCode();
  private static final int dib;
  private static final int dij;
  private static final int dlf = "msgType".hashCode();
  private static final int rowid_HASHCODE = "rowid".hashCode();
  private boolean dWB = true;
  private boolean dWC = true;
  private boolean dfz = true;
  private boolean dhS = true;
  private boolean dhX = true;
  private boolean dih = true;
  private boolean dkR = true;
  public long field_msgId;
  public int field_msgSubType;
  public int field_msgType;
  public long field_msgtime;
  public String field_path;
  public long field_size;
  public String field_username;
  
  static
  {
    dWD = "msgSubType".hashCode();
    dib = "path".hashCode();
    dij = "size".hashCode();
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
      if (dfD != k) {
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
      if (dhU == k) {
        this.field_username = paramCursor.getString(i);
      } else if (dlf == k) {
        this.field_msgType = paramCursor.getInt(i);
      } else if (dWD == k) {
        this.field_msgSubType = paramCursor.getInt(i);
      } else if (dib == k) {
        this.field_path = paramCursor.getString(i);
      } else if (dij == k) {
        this.field_size = paramCursor.getLong(i);
      } else if (dWE == k) {
        this.field_msgtime = paramCursor.getLong(i);
      } else if (rowid_HASHCODE == k) {
        this.systemRowid = paramCursor.getLong(i);
      }
    }
  }
  
  public ContentValues convertTo()
  {
    ContentValues localContentValues = new ContentValues();
    if (this.dfz) {
      localContentValues.put("msgId", Long.valueOf(this.field_msgId));
    }
    if (this.dhS) {
      localContentValues.put("username", this.field_username);
    }
    if (this.dkR) {
      localContentValues.put("msgType", Integer.valueOf(this.field_msgType));
    }
    if (this.dWB) {
      localContentValues.put("msgSubType", Integer.valueOf(this.field_msgSubType));
    }
    if (this.dhX) {
      localContentValues.put("path", this.field_path);
    }
    if (this.dih) {
      localContentValues.put("size", Long.valueOf(this.field_size));
    }
    if (this.dWC) {
      localContentValues.put("msgtime", Long.valueOf(this.field_msgtime));
    }
    if (this.systemRowid > 0L) {
      localContentValues.put("rowid", Long.valueOf(this.systemRowid));
    }
    return localContentValues;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.g.c.fw
 * JD-Core Version:    0.7.0.1
 */