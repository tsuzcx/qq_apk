package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;

public abstract class gv
  extends c
{
  public static final String[] INDEX_CREATE = new String[0];
  private static final int ejL = "msgId".hashCode();
  private static final int emB = "size".hashCode();
  private static final int eme = "username".hashCode();
  private static final int eml;
  private static final int epD = "msgType".hashCode();
  private static final int fga = "msgSubType".hashCode();
  private static final int fgb = "msgtime".hashCode();
  private static final int rowid_HASHCODE = "rowid".hashCode();
  private boolean ejH = true;
  private boolean emb = true;
  private boolean emh = true;
  private boolean emz = true;
  private boolean epo = true;
  private boolean ffY = true;
  private boolean ffZ = true;
  public long field_msgId;
  public int field_msgSubType;
  public int field_msgType;
  public long field_msgtime;
  public String field_path;
  public long field_size;
  public String field_username;
  
  static
  {
    eml = "path".hashCode();
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
      if (eme == k) {
        this.field_username = paramCursor.getString(i);
      } else if (epD == k) {
        this.field_msgType = paramCursor.getInt(i);
      } else if (fga == k) {
        this.field_msgSubType = paramCursor.getInt(i);
      } else if (eml == k) {
        this.field_path = paramCursor.getString(i);
      } else if (emB == k) {
        this.field_size = paramCursor.getLong(i);
      } else if (fgb == k) {
        this.field_msgtime = paramCursor.getLong(i);
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
    if (this.emb) {
      localContentValues.put("username", this.field_username);
    }
    if (this.epo) {
      localContentValues.put("msgType", Integer.valueOf(this.field_msgType));
    }
    if (this.ffY) {
      localContentValues.put("msgSubType", Integer.valueOf(this.field_msgSubType));
    }
    if (this.emh) {
      localContentValues.put("path", this.field_path);
    }
    if (this.emz) {
      localContentValues.put("size", Long.valueOf(this.field_size));
    }
    if (this.ffZ) {
      localContentValues.put("msgtime", Long.valueOf(this.field_msgtime));
    }
    if (this.systemRowid > 0L) {
      localContentValues.put("rowid", Long.valueOf(this.systemRowid));
    }
    return localContentValues;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.g.c.gv
 * JD-Core Version:    0.7.0.1
 */