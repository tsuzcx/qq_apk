package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.storage.IAutoDBItem;

public abstract class gl
  extends IAutoDBItem
{
  public static final String[] INDEX_CREATE = { "CREATE INDEX IF NOT EXISTS snsreport_kv_logtime ON SnsReportKv(logtime)" };
  private static final int fkp;
  private static final int gao = "logtime".hashCode();
  private static final int gaq;
  private static final int gar;
  private static final int rowid_HASHCODE = "rowid".hashCode();
  private static final int value_HASHCODE;
  private boolean __hadSetvalue = true;
  public int field_errorcount;
  public int field_logsize;
  public long field_logtime;
  public int field_offset;
  public byte[] field_value;
  private boolean fjY = true;
  private boolean gal = true;
  private boolean gam = true;
  private boolean gan = true;
  
  static
  {
    fkp = "offset".hashCode();
    gaq = "logsize".hashCode();
    gar = "errorcount".hashCode();
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
      if (gao != k) {
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
      if (fkp == k) {
        this.field_offset = paramCursor.getInt(i);
      } else if (gaq == k) {
        this.field_logsize = paramCursor.getInt(i);
      } else if (gar == k) {
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
    if (this.gal) {
      localContentValues.put("logtime", Long.valueOf(this.field_logtime));
    }
    if (this.fjY) {
      localContentValues.put("offset", Integer.valueOf(this.field_offset));
    }
    if (this.gam) {
      localContentValues.put("logsize", Integer.valueOf(this.field_logsize));
    }
    if (this.gan) {
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.g.c.gl
 * JD-Core Version:    0.7.0.1
 */