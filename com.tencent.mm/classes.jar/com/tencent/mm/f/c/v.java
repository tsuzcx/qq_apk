package com.tencent.mm.f.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.storage.IAutoDBItem;
import com.tencent.mm.sdk.storage.sql.Column;
import com.tencent.mm.sdk.storage.sql.SingleTable;

public abstract class v
  extends IAutoDBItem
{
  public static final Column C_ROWID;
  public static final String[] INDEX_CREATE = new String[0];
  public static final SingleTable TABLE = new SingleTable("AppBrandTestCodeVersionMarkTable");
  public static final Column hnz;
  public static final Column hoQ;
  private static final int hoY = "versionType".hashCode();
  private static final int hoh;
  public static final Column hpG;
  private static final int hpI = "versionMd5".hashCode();
  private static final int rowid_HASHCODE = "rowid".hashCode();
  public String field_appId;
  public String field_versionMd5;
  public int field_versionType;
  private boolean hnQ = true;
  private boolean hoU = true;
  private boolean hpH = true;
  
  static
  {
    C_ROWID = new Column("rowid", "long", "AppBrandTestCodeVersionMarkTable", "");
    hnz = new Column("appid", "string", "AppBrandTestCodeVersionMarkTable", "");
    hoQ = new Column("versiontype", "int", "AppBrandTestCodeVersionMarkTable", "");
    hpG = new Column("versionmd5", "string", "AppBrandTestCodeVersionMarkTable", "");
    hoh = "appId".hashCode();
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
      } else if (hpI == k) {
        this.field_versionMd5 = paramCursor.getString(i);
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
    if (this.hpH) {
      localContentValues.put("versionMd5", this.field_versionMd5);
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
    return "AppBrandTestCodeVersionMarkTable";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.f.c.v
 * JD-Core Version:    0.7.0.1
 */