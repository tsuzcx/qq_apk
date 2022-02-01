package com.tencent.mm.f.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.storage.IAutoDBItem;
import com.tencent.mm.sdk.storage.sql.Column;
import com.tencent.mm.sdk.storage.sql.SingleTable;

public abstract class dt
  extends IAutoDBItem
{
  public static final Column C_ROWID;
  public static final Column C_USERNAME;
  public static final String[] INDEX_CREATE = new String[0];
  public static final SingleTable TABLE = new SingleTable("HardDeviceLikeUser");
  public static final Column hMZ;
  private static final int hNt = "timestamp".hashCode();
  public static final Column ied;
  public static final Column iee;
  public static final Column ief;
  private static final int iej;
  private static final int iek;
  private static final int iel = "liketips".hashCode();
  private static final int rowid_HASHCODE = "rowid".hashCode();
  private static final int username_HASHCODE;
  private boolean __hadSetusername = true;
  public String field_appusername;
  public String field_liketips;
  public String field_rankID;
  public int field_timestamp;
  public String field_username;
  private boolean hNj = true;
  private boolean ieg = true;
  private boolean ieh = true;
  private boolean iei = true;
  
  static
  {
    C_ROWID = new Column("rowid", "long", "HardDeviceLikeUser", "");
    ied = new Column("rankid", "string", "HardDeviceLikeUser", "");
    iee = new Column("appusername", "string", "HardDeviceLikeUser", "");
    C_USERNAME = new Column("username", "string", "HardDeviceLikeUser", "");
    hMZ = new Column("timestamp", "int", "HardDeviceLikeUser", "");
    ief = new Column("liketips", "string", "HardDeviceLikeUser", "");
    iej = "rankID".hashCode();
    iek = "appusername".hashCode();
    username_HASHCODE = "username".hashCode();
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
      if (iej != k) {
        break label60;
      }
      this.field_rankID = paramCursor.getString(i);
    }
    for (;;)
    {
      i += 1;
      break label20;
      break;
      label60:
      if (iek == k) {
        this.field_appusername = paramCursor.getString(i);
      } else if (username_HASHCODE == k) {
        this.field_username = paramCursor.getString(i);
      } else if (hNt == k) {
        this.field_timestamp = paramCursor.getInt(i);
      } else if (iel == k) {
        this.field_liketips = paramCursor.getString(i);
      } else if (rowid_HASHCODE == k) {
        this.systemRowid = paramCursor.getLong(i);
      }
    }
  }
  
  public ContentValues convertTo()
  {
    ContentValues localContentValues = new ContentValues();
    if (this.ieg) {
      localContentValues.put("rankID", this.field_rankID);
    }
    if (this.ieh) {
      localContentValues.put("appusername", this.field_appusername);
    }
    if (this.__hadSetusername) {
      localContentValues.put("username", this.field_username);
    }
    if (this.hNj) {
      localContentValues.put("timestamp", Integer.valueOf(this.field_timestamp));
    }
    if (this.field_liketips == null) {
      this.field_liketips = "";
    }
    if (this.iei) {
      localContentValues.put("liketips", this.field_liketips);
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
    return "HardDeviceLikeUser";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.f.c.dt
 * JD-Core Version:    0.7.0.1
 */