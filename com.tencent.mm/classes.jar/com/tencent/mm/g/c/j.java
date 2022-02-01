package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.storage.IAutoDBItem;

public abstract class j
  extends IAutoDBItem
{
  public static final String[] INDEX_CREATE = new String[0];
  private static final int fjQ = "scene".hashCode();
  private static final int fkG;
  private static final int fkH;
  private static final int fkI;
  private static final int fkJ = "data".hashCode();
  private static final int rowid_HASHCODE = "rowid".hashCode();
  private static final int updateTime_HASHCODE;
  private static final int username_HASHCODE = "username".hashCode();
  private boolean __hadSetupdateTime = true;
  private boolean __hadSetusername = true;
  public String field_data;
  public int field_fetchType;
  public String field_path;
  public String field_query;
  public int field_scene;
  public long field_updateTime;
  public String field_username;
  private boolean fjO = true;
  private boolean fkC = true;
  private boolean fkD = true;
  private boolean fkE = true;
  private boolean fkF = true;
  
  static
  {
    fkG = "fetchType".hashCode();
    updateTime_HASHCODE = "updateTime".hashCode();
    fkH = "path".hashCode();
    fkI = "query".hashCode();
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
      if (username_HASHCODE != k) {
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
      if (fkG == k) {
        this.field_fetchType = paramCursor.getInt(i);
      } else if (updateTime_HASHCODE == k) {
        this.field_updateTime = paramCursor.getLong(i);
      } else if (fkH == k) {
        this.field_path = paramCursor.getString(i);
      } else if (fkI == k) {
        this.field_query = paramCursor.getString(i);
      } else if (fjQ == k) {
        this.field_scene = paramCursor.getInt(i);
      } else if (fkJ == k) {
        this.field_data = paramCursor.getString(i);
      } else if (rowid_HASHCODE == k) {
        this.systemRowid = paramCursor.getLong(i);
      }
    }
  }
  
  public ContentValues convertTo()
  {
    ContentValues localContentValues = new ContentValues();
    if (this.__hadSetusername) {
      localContentValues.put("username", this.field_username);
    }
    if (this.fkC) {
      localContentValues.put("fetchType", Integer.valueOf(this.field_fetchType));
    }
    if (this.__hadSetupdateTime) {
      localContentValues.put("updateTime", Long.valueOf(this.field_updateTime));
    }
    if (this.fkD) {
      localContentValues.put("path", this.field_path);
    }
    if (this.fkE) {
      localContentValues.put("query", this.field_query);
    }
    if (this.fjO) {
      localContentValues.put("scene", Integer.valueOf(this.field_scene));
    }
    if (this.fkF) {
      localContentValues.put("data", this.field_data);
    }
    if (this.systemRowid > 0L) {
      localContentValues.put("rowid", Long.valueOf(this.systemRowid));
    }
    return localContentValues;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.g.c.j
 * JD-Core Version:    0.7.0.1
 */