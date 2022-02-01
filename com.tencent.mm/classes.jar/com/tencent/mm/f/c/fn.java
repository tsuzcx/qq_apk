package com.tencent.mm.f.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.storage.IAutoDBItem;
import com.tencent.mm.sdk.storage.sql.Column;
import com.tencent.mm.sdk.storage.sql.SingleTable;

public abstract class fn
  extends IAutoDBItem
{
  public static final Column C_KEY;
  public static final Column C_ROWID;
  public static final Column C_UPDATETIME;
  public static final String[] INDEX_CREATE = new String[0];
  public static final SingleTable TABLE = new SingleTable("PkgUpdateStats");
  public static final Column hnt;
  private static final int hnx;
  public static final Column hpJ;
  private static final int hpT;
  private static final int key_HASHCODE;
  private static final int rowid_HASHCODE = "rowid".hashCode();
  private static final int updateTime_HASHCODE;
  private boolean __hadSetkey = true;
  private boolean __hadSetupdateTime = true;
  public String field_key;
  public int field_scene;
  public long field_updateTime;
  public int field_version;
  private boolean hnv = true;
  private boolean hpO = true;
  
  static
  {
    C_ROWID = new Column("rowid", "long", "PkgUpdateStats", "");
    C_KEY = new Column("key", "string", "PkgUpdateStats", "");
    hpJ = new Column("version", "int", "PkgUpdateStats", "");
    hnt = new Column("scene", "int", "PkgUpdateStats", "");
    C_UPDATETIME = new Column("updatetime", "long", "PkgUpdateStats", "");
    key_HASHCODE = "key".hashCode();
    hpT = "version".hashCode();
    hnx = "scene".hashCode();
    updateTime_HASHCODE = "updateTime".hashCode();
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
      if (hpT == k) {
        this.field_version = paramCursor.getInt(i);
      } else if (hnx == k) {
        this.field_scene = paramCursor.getInt(i);
      } else if (updateTime_HASHCODE == k) {
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
    if (this.hpO) {
      localContentValues.put("version", Integer.valueOf(this.field_version));
    }
    if (this.hnv) {
      localContentValues.put("scene", Integer.valueOf(this.field_scene));
    }
    if (this.__hadSetupdateTime) {
      localContentValues.put("updateTime", Long.valueOf(this.field_updateTime));
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
    return "PkgUpdateStats";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.f.c.fn
 * JD-Core Version:    0.7.0.1
 */