package com.tencent.mm.f.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.storage.IAutoDBItem;
import com.tencent.mm.sdk.storage.sql.Column;
import com.tencent.mm.sdk.storage.sql.SingleTable;

public abstract class id
  extends IAutoDBItem
{
  public static final Column C_ROWID;
  public static final String[] INDEX_CREATE = new String[0];
  public static final SingleTable TABLE = new SingleTable("WidgetSafeMode");
  public static final Column hnz;
  public static final Column iLW;
  public static final Column iLX;
  public static final Column iLY;
  public static final Column iLZ;
  private static final int iMe = "jsExceptionCount".hashCode();
  private static final int iMf = "crashCount".hashCode();
  private static final int iMg = "beginTimestamp".hashCode();
  private static final int iMh = "pkgVersion".hashCode();
  private static final int iqb;
  private static final int rowid_HASHCODE = "rowid".hashCode();
  public String field_appid;
  public long field_beginTimestamp;
  public int field_crashCount;
  public int field_jsExceptionCount;
  public int field_pkgVersion;
  private boolean iMa = true;
  private boolean iMb = true;
  private boolean iMc = true;
  private boolean iMd = true;
  private boolean ipZ = true;
  
  static
  {
    C_ROWID = new Column("rowid", "long", "WidgetSafeMode", "");
    hnz = new Column("appid", "string", "WidgetSafeMode", "");
    iLW = new Column("jsexceptioncount", "int", "WidgetSafeMode", "");
    iLX = new Column("crashcount", "int", "WidgetSafeMode", "");
    iLY = new Column("begintimestamp", "long", "WidgetSafeMode", "");
    iLZ = new Column("pkgversion", "int", "WidgetSafeMode", "");
    iqb = "appid".hashCode();
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
      if (iqb != k) {
        break label65;
      }
      this.field_appid = paramCursor.getString(i);
      this.ipZ = true;
    }
    for (;;)
    {
      i += 1;
      break label20;
      break;
      label65:
      if (iMe == k) {
        this.field_jsExceptionCount = paramCursor.getInt(i);
      } else if (iMf == k) {
        this.field_crashCount = paramCursor.getInt(i);
      } else if (iMg == k) {
        this.field_beginTimestamp = paramCursor.getLong(i);
      } else if (iMh == k) {
        this.field_pkgVersion = paramCursor.getInt(i);
      } else if (rowid_HASHCODE == k) {
        this.systemRowid = paramCursor.getLong(i);
      }
    }
  }
  
  public ContentValues convertTo()
  {
    ContentValues localContentValues = new ContentValues();
    if (this.ipZ) {
      localContentValues.put("appid", this.field_appid);
    }
    if (this.iMa) {
      localContentValues.put("jsExceptionCount", Integer.valueOf(this.field_jsExceptionCount));
    }
    if (this.iMb) {
      localContentValues.put("crashCount", Integer.valueOf(this.field_crashCount));
    }
    if (this.iMc) {
      localContentValues.put("beginTimestamp", Long.valueOf(this.field_beginTimestamp));
    }
    if (this.iMd) {
      localContentValues.put("pkgVersion", Integer.valueOf(this.field_pkgVersion));
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
    return "WidgetSafeMode";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.f.c.id
 * JD-Core Version:    0.7.0.1
 */