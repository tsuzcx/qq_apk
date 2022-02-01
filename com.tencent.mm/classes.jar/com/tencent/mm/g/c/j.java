package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;

public abstract class j
  extends c
{
  public static final String[] INDEX_CREATE = new String[0];
  private static final int elq = "scene".hashCode();
  private static final int eme = "username".hashCode();
  private static final int emf;
  private static final int emk = "fetchType".hashCode();
  private static final int eml;
  private static final int emm;
  private static final int emn = "data".hashCode();
  private static final int rowid_HASHCODE = "rowid".hashCode();
  private boolean elo = true;
  private boolean emb = true;
  private boolean emc = true;
  private boolean emg = true;
  private boolean emh = true;
  private boolean emi = true;
  private boolean emj = true;
  public String field_data;
  public int field_fetchType;
  public String field_path;
  public String field_query;
  public int field_scene;
  public long field_updateTime;
  public String field_username;
  
  static
  {
    emf = "updateTime".hashCode();
    eml = "path".hashCode();
    emm = "query".hashCode();
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
      if (eme != k) {
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
      if (emk == k) {
        this.field_fetchType = paramCursor.getInt(i);
      } else if (emf == k) {
        this.field_updateTime = paramCursor.getLong(i);
      } else if (eml == k) {
        this.field_path = paramCursor.getString(i);
      } else if (emm == k) {
        this.field_query = paramCursor.getString(i);
      } else if (elq == k) {
        this.field_scene = paramCursor.getInt(i);
      } else if (emn == k) {
        this.field_data = paramCursor.getString(i);
      } else if (rowid_HASHCODE == k) {
        this.systemRowid = paramCursor.getLong(i);
      }
    }
  }
  
  public ContentValues convertTo()
  {
    ContentValues localContentValues = new ContentValues();
    if (this.emb) {
      localContentValues.put("username", this.field_username);
    }
    if (this.emg) {
      localContentValues.put("fetchType", Integer.valueOf(this.field_fetchType));
    }
    if (this.emc) {
      localContentValues.put("updateTime", Long.valueOf(this.field_updateTime));
    }
    if (this.emh) {
      localContentValues.put("path", this.field_path);
    }
    if (this.emi) {
      localContentValues.put("query", this.field_query);
    }
    if (this.elo) {
      localContentValues.put("scene", Integer.valueOf(this.field_scene));
    }
    if (this.emj) {
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