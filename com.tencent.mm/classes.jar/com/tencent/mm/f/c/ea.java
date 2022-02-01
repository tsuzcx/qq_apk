package com.tencent.mm.f.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.storage.IAutoDBItem;
import com.tencent.mm.sdk.storage.sql.Column;
import com.tencent.mm.sdk.storage.sql.SingleTable;

public abstract class ea
  extends IAutoDBItem
{
  public static final Column C_ROWID = new Column("rowid", "long", "IPCallPopularCountry", "");
  public static final String[] INDEX_CREATE = new String[0];
  public static final SingleTable TABLE = new SingleTable("IPCallPopularCountry");
  public static final Column ieW = new Column("countrycode", "int", "IPCallPopularCountry", "");
  public static final Column ieX = new Column("calltimecount", "long", "IPCallPopularCountry", "");
  public static final Column ieY = new Column("lastcalltime", "long", "IPCallPopularCountry", "");
  private static final int ifc = "countryCode".hashCode();
  private static final int ifd = "callTimeCount".hashCode();
  private static final int ife = "lastCallTime".hashCode();
  private static final int rowid_HASHCODE = "rowid".hashCode();
  public long field_callTimeCount;
  public int field_countryCode;
  public long field_lastCallTime;
  private boolean ieZ = true;
  private boolean ifa = true;
  private boolean ifb = true;
  
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
      if (ifc != k) {
        break label65;
      }
      this.field_countryCode = paramCursor.getInt(i);
      this.ieZ = true;
    }
    for (;;)
    {
      i += 1;
      break label20;
      break;
      label65:
      if (ifd == k) {
        this.field_callTimeCount = paramCursor.getLong(i);
      } else if (ife == k) {
        this.field_lastCallTime = paramCursor.getLong(i);
      } else if (rowid_HASHCODE == k) {
        this.systemRowid = paramCursor.getLong(i);
      }
    }
  }
  
  public ContentValues convertTo()
  {
    ContentValues localContentValues = new ContentValues();
    if (this.ieZ) {
      localContentValues.put("countryCode", Integer.valueOf(this.field_countryCode));
    }
    if (this.ifa) {
      localContentValues.put("callTimeCount", Long.valueOf(this.field_callTimeCount));
    }
    if (this.ifb) {
      localContentValues.put("lastCallTime", Long.valueOf(this.field_lastCallTime));
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
    return "IPCallPopularCountry";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.f.c.ea
 * JD-Core Version:    0.7.0.1
 */