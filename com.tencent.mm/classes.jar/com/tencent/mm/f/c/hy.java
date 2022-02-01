package com.tencent.mm.f.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.storage.IAutoDBItem;
import com.tencent.mm.sdk.storage.sql.Column;
import com.tencent.mm.sdk.storage.sql.SingleTable;

public abstract class hy
  extends IAutoDBItem
{
  public static final Column C_ROWID = new Column("rowid", "long", "WechatAppHistory", "");
  public static final String[] INDEX_CREATE = new String[0];
  public static final SingleTable TABLE = new SingleTable("WechatAppHistory");
  public static final Column iKf = new Column("appds", "int", "WechatAppHistory", "");
  public static final Column iKg = new Column("apphour", "int", "WechatAppHistory", "");
  public static final Column iKh = new Column("apptbe", "long", "WechatAppHistory", "");
  public static final Column iKi = new Column("appten", "long", "WechatAppHistory", "");
  public static final Column iKj = new Column("appin", "long", "WechatAppHistory", "");
  public static final Column iKk = new Column("appinbg", "long", "WechatAppHistory", "");
  private static final int iKr = "appDs".hashCode();
  private static final int iKs = "appHour".hashCode();
  private static final int iKt = "appTbe".hashCode();
  private static final int iKu = "appTen".hashCode();
  private static final int iKv = "appIn".hashCode();
  private static final int iKw = "appInbg".hashCode();
  private static final int rowid_HASHCODE = "rowid".hashCode();
  public int field_appDs;
  public int field_appHour;
  public long field_appIn;
  public long field_appInbg;
  public long field_appTbe;
  public long field_appTen;
  private boolean iKl = true;
  private boolean iKm = true;
  private boolean iKn = true;
  private boolean iKo = true;
  private boolean iKp = true;
  private boolean iKq = true;
  
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
      if (iKr != k) {
        break label60;
      }
      this.field_appDs = paramCursor.getInt(i);
    }
    for (;;)
    {
      i += 1;
      break label20;
      break;
      label60:
      if (iKs == k) {
        this.field_appHour = paramCursor.getInt(i);
      } else if (iKt == k) {
        this.field_appTbe = paramCursor.getLong(i);
      } else if (iKu == k) {
        this.field_appTen = paramCursor.getLong(i);
      } else if (iKv == k) {
        this.field_appIn = paramCursor.getLong(i);
      } else if (iKw == k) {
        this.field_appInbg = paramCursor.getLong(i);
      } else if (rowid_HASHCODE == k) {
        this.systemRowid = paramCursor.getLong(i);
      }
    }
  }
  
  public ContentValues convertTo()
  {
    ContentValues localContentValues = new ContentValues();
    if (this.iKl) {
      localContentValues.put("appDs", Integer.valueOf(this.field_appDs));
    }
    if (this.iKm) {
      localContentValues.put("appHour", Integer.valueOf(this.field_appHour));
    }
    if (this.iKn) {
      localContentValues.put("appTbe", Long.valueOf(this.field_appTbe));
    }
    if (this.iKo) {
      localContentValues.put("appTen", Long.valueOf(this.field_appTen));
    }
    if (this.iKp) {
      localContentValues.put("appIn", Long.valueOf(this.field_appIn));
    }
    if (this.iKq) {
      localContentValues.put("appInbg", Long.valueOf(this.field_appInbg));
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
    return "WechatAppHistory";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.f.c.hy
 * JD-Core Version:    0.7.0.1
 */