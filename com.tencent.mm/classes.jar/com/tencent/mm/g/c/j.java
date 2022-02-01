package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;

public abstract class j
  extends c
{
  public static final String[] INDEX_CREATE = new String[0];
  private static final int eGY = "username".hashCode();
  private static final int eGZ;
  private static final int eGk = "scene".hashCode();
  private static final int eHe = "fetchType".hashCode();
  private static final int eHf;
  private static final int eHg;
  private static final int eHh = "data".hashCode();
  private static final int rowid_HASHCODE = "rowid".hashCode();
  private boolean eGV = true;
  private boolean eGW = true;
  private boolean eGi = true;
  private boolean eHa = true;
  private boolean eHb = true;
  private boolean eHc = true;
  private boolean eHd = true;
  public String field_data;
  public int field_fetchType;
  public String field_path;
  public String field_query;
  public int field_scene;
  public long field_updateTime;
  public String field_username;
  
  static
  {
    eGZ = "updateTime".hashCode();
    eHf = "path".hashCode();
    eHg = "query".hashCode();
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
      if (eGY != k) {
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
      if (eHe == k) {
        this.field_fetchType = paramCursor.getInt(i);
      } else if (eGZ == k) {
        this.field_updateTime = paramCursor.getLong(i);
      } else if (eHf == k) {
        this.field_path = paramCursor.getString(i);
      } else if (eHg == k) {
        this.field_query = paramCursor.getString(i);
      } else if (eGk == k) {
        this.field_scene = paramCursor.getInt(i);
      } else if (eHh == k) {
        this.field_data = paramCursor.getString(i);
      } else if (rowid_HASHCODE == k) {
        this.systemRowid = paramCursor.getLong(i);
      }
    }
  }
  
  public ContentValues convertTo()
  {
    ContentValues localContentValues = new ContentValues();
    if (this.eGV) {
      localContentValues.put("username", this.field_username);
    }
    if (this.eHa) {
      localContentValues.put("fetchType", Integer.valueOf(this.field_fetchType));
    }
    if (this.eGW) {
      localContentValues.put("updateTime", Long.valueOf(this.field_updateTime));
    }
    if (this.eHb) {
      localContentValues.put("path", this.field_path);
    }
    if (this.eHc) {
      localContentValues.put("query", this.field_query);
    }
    if (this.eGi) {
      localContentValues.put("scene", Integer.valueOf(this.field_scene));
    }
    if (this.eHd) {
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