package com.tencent.mm.f.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.storage.IAutoDBItem;
import com.tencent.mm.sdk.storage.sql.Column;
import com.tencent.mm.sdk.storage.sql.SingleTable;

public abstract class i
  extends IAutoDBItem
{
  public static final Column C_ROWID;
  public static final Column C_UPDATETIME;
  public static final Column C_USERNAME;
  public static final String[] INDEX_CREATE = { "CREATE INDEX IF NOT EXISTS AppBrandAppLaunchRecordUpdateTimeIndex ON AppBrandAppLaunchUsernameDuplicateRecord2(updateTime)" };
  public static final SingleTable TABLE = new SingleTable("AppBrandAppLaunchUsernameDuplicateRecord2");
  private static final int hoA;
  public static final Column hoy;
  private static final int rowid_HASHCODE = "rowid".hashCode();
  private static final int updateTime_HASHCODE;
  private static final int username_HASHCODE;
  private boolean __hadSetupdateTime = true;
  private boolean __hadSetusername = true;
  public long field_updateTime;
  public String field_username;
  public int field_usernameHash;
  private boolean hoz = true;
  
  static
  {
    C_ROWID = new Column("rowid", "long", "AppBrandAppLaunchUsernameDuplicateRecord2", "");
    hoy = new Column("usernamehash", "int", "AppBrandAppLaunchUsernameDuplicateRecord2", "");
    C_USERNAME = new Column("username", "string", "AppBrandAppLaunchUsernameDuplicateRecord2", "");
    C_UPDATETIME = new Column("updatetime", "long", "AppBrandAppLaunchUsernameDuplicateRecord2", "");
    hoA = "usernameHash".hashCode();
    username_HASHCODE = "username".hashCode();
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
      if (hoA != k) {
        break label65;
      }
      this.field_usernameHash = paramCursor.getInt(i);
      this.hoz = true;
    }
    for (;;)
    {
      i += 1;
      break label20;
      break;
      label65:
      if (username_HASHCODE == k) {
        this.field_username = paramCursor.getString(i);
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
    if (this.hoz) {
      localContentValues.put("usernameHash", Integer.valueOf(this.field_usernameHash));
    }
    if (this.__hadSetusername) {
      localContentValues.put("username", this.field_username);
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
    return "AppBrandAppLaunchUsernameDuplicateRecord2";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.f.c.i
 * JD-Core Version:    0.7.0.1
 */