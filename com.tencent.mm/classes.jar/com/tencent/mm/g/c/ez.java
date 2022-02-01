package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;

public abstract class ez
  extends c
{
  public static final String[] INDEX_CREATE = new String[0];
  private static final int eEB = "scene".hashCode();
  private static final int eFq = "updateTime".hashCode();
  private static final int eGk;
  private static final int key_HASHCODE = "key".hashCode();
  private static final int rowid_HASHCODE = "rowid".hashCode();
  private boolean __hadSetkey = true;
  private boolean eEz = true;
  private boolean eFn = true;
  private boolean eGf = true;
  public String field_key;
  public int field_scene;
  public long field_updateTime;
  public int field_version;
  
  static
  {
    eGk = "version".hashCode();
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
      if (key_HASHCODE != k) {
        break label60;
      }
      this.field_key = paramCursor.getString(i);
    }
    for (;;)
    {
      i += 1;
      break label20;
      break;
      label60:
      if (eGk == k) {
        this.field_version = paramCursor.getInt(i);
      } else if (eEB == k) {
        this.field_scene = paramCursor.getInt(i);
      } else if (eFq == k) {
        this.field_updateTime = paramCursor.getLong(i);
      } else if (rowid_HASHCODE == k) {
        this.systemRowid = paramCursor.getLong(i);
      }
    }
  }
  
  public ContentValues convertTo()
  {
    ContentValues localContentValues = new ContentValues();
    if (this.__hadSetkey) {
      localContentValues.put("key", this.field_key);
    }
    if (this.eGf) {
      localContentValues.put("version", Integer.valueOf(this.field_version));
    }
    if (this.eEz) {
      localContentValues.put("scene", Integer.valueOf(this.field_scene));
    }
    if (this.eFn) {
      localContentValues.put("updateTime", Long.valueOf(this.field_updateTime));
    }
    if (this.systemRowid > 0L) {
      localContentValues.put("rowid", Long.valueOf(this.systemRowid));
    }
    return localContentValues;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.g.c.ez
 * JD-Core Version:    0.7.0.1
 */