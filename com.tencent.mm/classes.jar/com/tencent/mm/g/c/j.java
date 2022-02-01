package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;

public abstract class j
  extends c
{
  public static final String[] INDEX_CREATE = new String[0];
  private static final int env = "scene".hashCode();
  private static final int eok = "username".hashCode();
  private static final int eol;
  private static final int eoq = "fetchType".hashCode();
  private static final int eor;
  private static final int eos;
  private static final int eot = "data".hashCode();
  private static final int rowid_HASHCODE = "rowid".hashCode();
  private boolean ent = true;
  private boolean eoh = true;
  private boolean eoi = true;
  private boolean eom = true;
  private boolean eon = true;
  private boolean eoo = true;
  private boolean eop = true;
  public String field_data;
  public int field_fetchType;
  public String field_path;
  public String field_query;
  public int field_scene;
  public long field_updateTime;
  public String field_username;
  
  static
  {
    eol = "updateTime".hashCode();
    eor = "path".hashCode();
    eos = "query".hashCode();
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
      if (eok != k) {
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
      if (eoq == k) {
        this.field_fetchType = paramCursor.getInt(i);
      } else if (eol == k) {
        this.field_updateTime = paramCursor.getLong(i);
      } else if (eor == k) {
        this.field_path = paramCursor.getString(i);
      } else if (eos == k) {
        this.field_query = paramCursor.getString(i);
      } else if (env == k) {
        this.field_scene = paramCursor.getInt(i);
      } else if (eot == k) {
        this.field_data = paramCursor.getString(i);
      } else if (rowid_HASHCODE == k) {
        this.systemRowid = paramCursor.getLong(i);
      }
    }
  }
  
  public ContentValues convertTo()
  {
    ContentValues localContentValues = new ContentValues();
    if (this.eoh) {
      localContentValues.put("username", this.field_username);
    }
    if (this.eom) {
      localContentValues.put("fetchType", Integer.valueOf(this.field_fetchType));
    }
    if (this.eoi) {
      localContentValues.put("updateTime", Long.valueOf(this.field_updateTime));
    }
    if (this.eon) {
      localContentValues.put("path", this.field_path);
    }
    if (this.eoo) {
      localContentValues.put("query", this.field_query);
    }
    if (this.ent) {
      localContentValues.put("scene", Integer.valueOf(this.field_scene));
    }
    if (this.eop) {
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