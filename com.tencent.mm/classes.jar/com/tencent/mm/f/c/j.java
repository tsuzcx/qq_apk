package com.tencent.mm.f.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.storage.IAutoDBItem;
import com.tencent.mm.sdk.storage.sql.Column;
import com.tencent.mm.sdk.storage.sql.SingleTable;

public abstract class j
  extends IAutoDBItem
{
  public static final Column C_ROWID;
  public static final Column C_UPDATETIME;
  public static final Column C_USERNAME;
  public static final String[] INDEX_CREATE = new String[0];
  public static final SingleTable TABLE = new SingleTable("AppBrandBackgroundFetchData");
  public static final Column hnt;
  private static final int hnx = "scene".hashCode();
  public static final Column hoB;
  public static final Column hoC;
  public static final Column hoD;
  public static final Column hoE;
  private static final int hoJ;
  private static final int hoK;
  private static final int hoL;
  private static final int hoM = "data".hashCode();
  private static final int rowid_HASHCODE = "rowid".hashCode();
  private static final int updateTime_HASHCODE;
  private static final int username_HASHCODE;
  private boolean __hadSetupdateTime = true;
  private boolean __hadSetusername = true;
  public String field_data;
  public int field_fetchType;
  public String field_path;
  public String field_query;
  public int field_scene;
  public long field_updateTime;
  public String field_username;
  private boolean hnv = true;
  private boolean hoF = true;
  private boolean hoG = true;
  private boolean hoH = true;
  private boolean hoI = true;
  
  static
  {
    C_ROWID = new Column("rowid", "long", "AppBrandBackgroundFetchData", "");
    C_USERNAME = new Column("username", "string", "AppBrandBackgroundFetchData", "");
    hoB = new Column("fetchtype", "int", "AppBrandBackgroundFetchData", "");
    C_UPDATETIME = new Column("updatetime", "long", "AppBrandBackgroundFetchData", "");
    hoC = new Column("path", "string", "AppBrandBackgroundFetchData", "");
    hoD = new Column("query", "string", "AppBrandBackgroundFetchData", "");
    hnt = new Column("scene", "int", "AppBrandBackgroundFetchData", "");
    hoE = new Column("data", "string", "AppBrandBackgroundFetchData", "");
    username_HASHCODE = "username".hashCode();
    hoJ = "fetchType".hashCode();
    updateTime_HASHCODE = "updateTime".hashCode();
    hoK = "path".hashCode();
    hoL = "query".hashCode();
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
      if (hoJ == k) {
        this.field_fetchType = paramCursor.getInt(i);
      } else if (updateTime_HASHCODE == k) {
        this.field_updateTime = paramCursor.getLong(i);
      } else if (hoK == k) {
        this.field_path = paramCursor.getString(i);
      } else if (hoL == k) {
        this.field_query = paramCursor.getString(i);
      } else if (hnx == k) {
        this.field_scene = paramCursor.getInt(i);
      } else if (hoM == k) {
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
    if (this.hoF) {
      localContentValues.put("fetchType", Integer.valueOf(this.field_fetchType));
    }
    if (this.__hadSetupdateTime) {
      localContentValues.put("updateTime", Long.valueOf(this.field_updateTime));
    }
    if (this.hoG) {
      localContentValues.put("path", this.field_path);
    }
    if (this.hoH) {
      localContentValues.put("query", this.field_query);
    }
    if (this.hnv) {
      localContentValues.put("scene", Integer.valueOf(this.field_scene));
    }
    if (this.hoI) {
      localContentValues.put("data", this.field_data);
    }
    if (this.systemRowid > 0L) {
      localContentValues.put("rowid", Long.valueOf(this.systemRowid));
    }
    return localContentValues;
  }
  
  public String[] getIndexCreateSQL()
  {
    return INDEX_CREATE;
  }
  
  public String getTableName()
  {
    return "AppBrandBackgroundFetchData";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.f.c.j
 * JD-Core Version:    0.7.0.1
 */