package com.tencent.mm.f.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.storage.IAutoDBItem;
import com.tencent.mm.sdk.storage.sql.Column;
import com.tencent.mm.sdk.storage.sql.SingleTable;

public abstract class bd
  extends IAutoDBItem
{
  public static final Column C_ROWID;
  public static final String[] INDEX_CREATE = new String[0];
  public static final SingleTable TABLE = new SingleTable("DevPkgLaunchExtInfo");
  public static final Column hFb;
  private static final int hFd = "extJson".hashCode();
  public static final Column hnz;
  public static final Column hoQ;
  private static final int hoY;
  private static final int hoh;
  private static final int rowid_HASHCODE = "rowid".hashCode();
  public String field_appId;
  public String field_extJson;
  public int field_versionType;
  private boolean hFc = true;
  private boolean hnQ = true;
  private boolean hoU = true;
  
  static
  {
    C_ROWID = new Column("rowid", "long", "DevPkgLaunchExtInfo", "");
    hnz = new Column("appid", "string", "DevPkgLaunchExtInfo", "");
    hoQ = new Column("versiontype", "int", "DevPkgLaunchExtInfo", "");
    hFb = new Column("extjson", "string", "DevPkgLaunchExtInfo", "");
    hoh = "appId".hashCode();
    hoY = "versionType".hashCode();
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
      if (hoh != k) {
        break label60;
      }
      this.field_appId = paramCursor.getString(i);
    }
    for (;;)
    {
      i += 1;
      break label20;
      break;
      label60:
      if (hoY == k) {
        this.field_versionType = paramCursor.getInt(i);
      } else if (hFd == k) {
        this.field_extJson = paramCursor.getString(i);
      } else if (rowid_HASHCODE == k) {
        this.systemRowid = paramCursor.getLong(i);
      }
    }
  }
  
  public ContentValues convertTo()
  {
    ContentValues localContentValues = new ContentValues();
    if (this.hnQ) {
      localContentValues.put("appId", this.field_appId);
    }
    if (this.hoU) {
      localContentValues.put("versionType", Integer.valueOf(this.field_versionType));
    }
    if (this.hFc) {
      localContentValues.put("extJson", this.field_extJson);
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
    return "DevPkgLaunchExtInfo";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.f.c.bd
 * JD-Core Version:    0.7.0.1
 */