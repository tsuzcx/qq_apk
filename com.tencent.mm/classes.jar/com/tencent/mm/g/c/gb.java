package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;

public abstract class gb
  extends c
{
  public static final String[] INDEX_CREATE = { "CREATE INDEX IF NOT EXISTS snsreport_kv_logtime ON SnsReportKv(logtime)" };
  private static final int eFa;
  private static final int ftF = "logtime".hashCode();
  private static final int ftG;
  private static final int ftH;
  private static final int rowid_HASHCODE = "rowid".hashCode();
  private static final int value_HASHCODE;
  private boolean __hadSetvalue = true;
  private boolean eEJ = true;
  public int field_errorcount;
  public int field_logsize;
  public long field_logtime;
  public int field_offset;
  public byte[] field_value;
  private boolean ftC = true;
  private boolean ftD = true;
  private boolean ftE = true;
  
  static
  {
    eFa = "offset".hashCode();
    ftG = "logsize".hashCode();
    ftH = "errorcount".hashCode();
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
      if (ftF != k) {
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
      if (eFa == k) {
        this.field_offset = paramCursor.getInt(i);
      } else if (ftG == k) {
        this.field_logsize = paramCursor.getInt(i);
      } else if (ftH == k) {
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
    if (this.ftC) {
      localContentValues.put("logtime", Long.valueOf(this.field_logtime));
    }
    if (this.eEJ) {
      localContentValues.put("offset", Integer.valueOf(this.field_offset));
    }
    if (this.ftD) {
      localContentValues.put("logsize", Integer.valueOf(this.field_logsize));
    }
    if (this.ftE) {
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.g.c.gb
 * JD-Core Version:    0.7.0.1
 */