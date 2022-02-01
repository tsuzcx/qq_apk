package com.tencent.mm.f.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.storage.IAutoDBItem;
import com.tencent.mm.sdk.storage.sql.Column;
import com.tencent.mm.sdk.storage.sql.SingleTable;

public abstract class dv
  extends IAutoDBItem
{
  public static final Column C_ROWID;
  public static final Column C_USERNAME;
  public static final String[] INDEX_CREATE = new String[0];
  public static final SingleTable TABLE = new SingleTable("HardDeviceRankFollowInfo");
  public static final Column hFJ;
  private static final int hGJ = "sort".hashCode();
  public static final Column ied;
  public static final Column iee;
  private static final int iej;
  private static final int iek;
  public static final Column ieo;
  private static final int ieq;
  private static final int rowid_HASHCODE = "rowid".hashCode();
  private static final int username_HASHCODE;
  private boolean __hadSetusername = true;
  public String field_appusername;
  public String field_rankID;
  public int field_sort;
  public int field_step;
  public String field_username;
  private boolean hGj = true;
  private boolean ieg = true;
  private boolean ieh = true;
  private boolean iep = true;
  
  static
  {
    C_ROWID = new Column("rowid", "long", "HardDeviceRankFollowInfo", "");
    iee = new Column("appusername", "string", "HardDeviceRankFollowInfo", "");
    ied = new Column("rankid", "string", "HardDeviceRankFollowInfo", "");
    C_USERNAME = new Column("username", "string", "HardDeviceRankFollowInfo", "");
    ieo = new Column("step", "int", "HardDeviceRankFollowInfo", "");
    hFJ = new Column("sort", "int", "HardDeviceRankFollowInfo", "");
    iek = "appusername".hashCode();
    iej = "rankID".hashCode();
    username_HASHCODE = "username".hashCode();
    ieq = "step".hashCode();
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
      if (iek != k) {
        break label60;
      }
      this.field_appusername = paramCursor.getString(i);
    }
    for (;;)
    {
      i += 1;
      break label20;
      break;
      label60:
      if (iej == k) {
        this.field_rankID = paramCursor.getString(i);
      } else if (username_HASHCODE == k) {
        this.field_username = paramCursor.getString(i);
      } else if (ieq == k) {
        this.field_step = paramCursor.getInt(i);
      } else if (hGJ == k) {
        this.field_sort = paramCursor.getInt(i);
      } else if (rowid_HASHCODE == k) {
        this.systemRowid = paramCursor.getLong(i);
      }
    }
  }
  
  public ContentValues convertTo()
  {
    ContentValues localContentValues = new ContentValues();
    if (this.ieh) {
      localContentValues.put("appusername", this.field_appusername);
    }
    if (this.ieg) {
      localContentValues.put("rankID", this.field_rankID);
    }
    if (this.__hadSetusername) {
      localContentValues.put("username", this.field_username);
    }
    if (this.iep) {
      localContentValues.put("step", Integer.valueOf(this.field_step));
    }
    if (this.hGj) {
      localContentValues.put("sort", Integer.valueOf(this.field_sort));
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
    return "HardDeviceRankFollowInfo";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.f.c.dv
 * JD-Core Version:    0.7.0.1
 */