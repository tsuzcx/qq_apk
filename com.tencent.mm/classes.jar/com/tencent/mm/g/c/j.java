package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;

public abstract class j
  extends c
{
  public static final String[] INDEX_CREATE = new String[0];
  private static final int dhU = "username".hashCode();
  private static final int dhV;
  private static final int dhi = "scene".hashCode();
  private static final int dia = "fetchType".hashCode();
  private static final int dib;
  private static final int dic;
  private static final int did = "data".hashCode();
  private static final int rowid_HASHCODE = "rowid".hashCode();
  private boolean dhS = true;
  private boolean dhT = true;
  private boolean dhW = true;
  private boolean dhX = true;
  private boolean dhY = true;
  private boolean dhZ = true;
  private boolean dhg = true;
  public String field_data;
  public int field_fetchType;
  public String field_path;
  public String field_query;
  public int field_scene;
  public long field_updateTime;
  public String field_username;
  
  static
  {
    dhV = "updateTime".hashCode();
    dib = "path".hashCode();
    dic = "query".hashCode();
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
      if (dhU != k) {
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
      if (dia == k) {
        this.field_fetchType = paramCursor.getInt(i);
      } else if (dhV == k) {
        this.field_updateTime = paramCursor.getLong(i);
      } else if (dib == k) {
        this.field_path = paramCursor.getString(i);
      } else if (dic == k) {
        this.field_query = paramCursor.getString(i);
      } else if (dhi == k) {
        this.field_scene = paramCursor.getInt(i);
      } else if (did == k) {
        this.field_data = paramCursor.getString(i);
      } else if (rowid_HASHCODE == k) {
        this.systemRowid = paramCursor.getLong(i);
      }
    }
  }
  
  public ContentValues convertTo()
  {
    ContentValues localContentValues = new ContentValues();
    if (this.dhS) {
      localContentValues.put("username", this.field_username);
    }
    if (this.dhW) {
      localContentValues.put("fetchType", Integer.valueOf(this.field_fetchType));
    }
    if (this.dhT) {
      localContentValues.put("updateTime", Long.valueOf(this.field_updateTime));
    }
    if (this.dhX) {
      localContentValues.put("path", this.field_path);
    }
    if (this.dhY) {
      localContentValues.put("query", this.field_query);
    }
    if (this.dhg) {
      localContentValues.put("scene", Integer.valueOf(this.field_scene));
    }
    if (this.dhZ) {
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