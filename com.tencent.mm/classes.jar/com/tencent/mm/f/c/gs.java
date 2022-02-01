package com.tencent.mm.f.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.storage.IAutoDBItem;
import com.tencent.mm.sdk.storage.sql.Column;
import com.tencent.mm.sdk.storage.sql.SingleTable;

public abstract class gs
  extends IAutoDBItem
{
  public static final Column C_ROWID;
  public static final Column C_VALUE;
  public static final String[] INDEX_CREATE = { "CREATE INDEX IF NOT EXISTS snsreport_kv_logtime ON SnsReportKv(logtime)" };
  public static final SingleTable TABLE = new SingleTable("SnsReportKv");
  public static final Column hnF;
  private static final int hon;
  private static final int izA;
  public static final Column izs;
  public static final Column izt;
  public static final Column izu;
  private static final int izy;
  private static final int izz;
  private static final int rowid_HASHCODE = "rowid".hashCode();
  private static final int value_HASHCODE;
  private boolean __hadSetvalue = true;
  public int field_errorcount;
  public int field_logsize;
  public long field_logtime;
  public int field_offset;
  public byte[] field_value;
  private boolean hnW = true;
  private boolean izv = true;
  private boolean izw = true;
  private boolean izx = true;
  
  static
  {
    C_ROWID = new Column("rowid", "long", "SnsReportKv", "");
    izs = new Column("logtime", "long", "SnsReportKv", "");
    hnF = new Column("offset", "int", "SnsReportKv", "");
    izt = new Column("logsize", "int", "SnsReportKv", "");
    izu = new Column("errorcount", "int", "SnsReportKv", "");
    C_VALUE = new Column("value", "byte[]", "SnsReportKv", "");
    izy = "logtime".hashCode();
    hon = "offset".hashCode();
    izz = "logsize".hashCode();
    izA = "errorcount".hashCode();
    value_HASHCODE = "value".hashCode();
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
      if (izy != k) {
        break label60;
      }
      this.field_logtime = paramCursor.getLong(i);
    }
    for (;;)
    {
      i += 1;
      break label20;
      break;
      label60:
      if (hon == k) {
        this.field_offset = paramCursor.getInt(i);
      } else if (izz == k) {
        this.field_logsize = paramCursor.getInt(i);
      } else if (izA == k) {
        this.field_errorcount = paramCursor.getInt(i);
      } else if (value_HASHCODE == k) {
        this.field_value = paramCursor.getBlob(i);
      } else if (rowid_HASHCODE == k) {
        this.systemRowid = paramCursor.getLong(i);
      }
    }
  }
  
  public ContentValues convertTo()
  {
    ContentValues localContentValues = new ContentValues();
    if (this.izv) {
      localContentValues.put("logtime", Long.valueOf(this.field_logtime));
    }
    if (this.hnW) {
      localContentValues.put("offset", Integer.valueOf(this.field_offset));
    }
    if (this.izw) {
      localContentValues.put("logsize", Integer.valueOf(this.field_logsize));
    }
    if (this.izx) {
      localContentValues.put("errorcount", Integer.valueOf(this.field_errorcount));
    }
    if (this.__hadSetvalue) {
      localContentValues.put("value", this.field_value);
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
    return "SnsReportKv";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.f.c.gs
 * JD-Core Version:    0.7.0.1
 */