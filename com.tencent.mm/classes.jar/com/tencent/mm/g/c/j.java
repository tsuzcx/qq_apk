package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;

public abstract class j
  extends c
{
  public static final String[] INDEX_CREATE = new String[0];
  private static final int eEB = "scene".hashCode();
  private static final int eFp = "username".hashCode();
  private static final int eFq;
  private static final int eFv = "fetchType".hashCode();
  private static final int eFw;
  private static final int eFx;
  private static final int eFy = "data".hashCode();
  private static final int rowid_HASHCODE = "rowid".hashCode();
  private boolean eEz = true;
  private boolean eFm = true;
  private boolean eFn = true;
  private boolean eFr = true;
  private boolean eFs = true;
  private boolean eFt = true;
  private boolean eFu = true;
  public String field_data;
  public int field_fetchType;
  public String field_path;
  public String field_query;
  public int field_scene;
  public long field_updateTime;
  public String field_username;
  
  static
  {
    eFq = "updateTime".hashCode();
    eFw = "path".hashCode();
    eFx = "query".hashCode();
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
      if (eFp != k) {
        break label60;
      }
      this.field_username = paramCursor.getString(i);
    }
    for (;;)
    {
      i += 1;
      break label20;
      break;
      label60:
      if (eFv == k) {
        this.field_fetchType = paramCursor.getInt(i);
      } else if (eFq == k) {
        this.field_updateTime = paramCursor.getLong(i);
      } else if (eFw == k) {
        this.field_path = paramCursor.getString(i);
      } else if (eFx == k) {
        this.field_query = paramCursor.getString(i);
      } else if (eEB == k) {
        this.field_scene = paramCursor.getInt(i);
      } else if (eFy == k) {
        this.field_data = paramCursor.getString(i);
      } else if (rowid_HASHCODE == k) {
        this.systemRowid = paramCursor.getLong(i);
      }
    }
  }
  
  public ContentValues convertTo()
  {
    ContentValues localContentValues = new ContentValues();
    if (this.eFm) {
      localContentValues.put("username", this.field_username);
    }
    if (this.eFr) {
      localContentValues.put("fetchType", Integer.valueOf(this.field_fetchType));
    }
    if (this.eFn) {
      localContentValues.put("updateTime", Long.valueOf(this.field_updateTime));
    }
    if (this.eFs) {
      localContentValues.put("path", this.field_path);
    }
    if (this.eFt) {
      localContentValues.put("query", this.field_query);
    }
    if (this.eEz) {
      localContentValues.put("scene", Integer.valueOf(this.field_scene));
    }
    if (this.eFu) {
      localContentValues.put("data", this.field_data);
    }
    if (this.systemRowid > 0L) {
      localContentValues.put("rowid", Long.valueOf(this.systemRowid));
    }
    return localContentValues;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.g.c.j
 * JD-Core Version:    0.7.0.1
 */