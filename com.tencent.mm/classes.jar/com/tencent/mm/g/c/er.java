package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;

public abstract class er
  extends c
{
  public static final String[] INDEX_CREATE = { "CREATE INDEX IF NOT EXISTS snsreport_kv_logtime ON SnsReportKv(logtime)" };
  private static final int dPm = "logtime".hashCode();
  private static final int dPn;
  private static final int dPo;
  private static final int dhH = "offset".hashCode();
  private static final int rowid_HASHCODE = "rowid".hashCode();
  private static final int value_HASHCODE;
  private boolean __hadSetvalue = true;
  private boolean dPj = true;
  private boolean dPk = true;
  private boolean dPl = true;
  private boolean dhq = true;
  public int field_errorcount;
  public int field_logsize;
  public long field_logtime;
  public int field_offset;
  public byte[] field_value;
  
  static
  {
    dPn = "logsize".hashCode();
    dPo = "errorcount".hashCode();
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
      if (dPm != k) {
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
      if (dhH == k) {
        this.field_offset = paramCursor.getInt(i);
      } else if (dPn == k) {
        this.field_logsize = paramCursor.getInt(i);
      } else if (dPo == k) {
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
    if (this.dPj) {
      localContentValues.put("logtime", Long.valueOf(this.field_logtime));
    }
    if (this.dhq) {
      localContentValues.put("offset", Integer.valueOf(this.field_offset));
    }
    if (this.dPk) {
      localContentValues.put("logsize", Integer.valueOf(this.field_logsize));
    }
    if (this.dPl) {
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
 * Qualified Name:     com.tencent.mm.g.c.er
 * JD-Core Version:    0.7.0.1
 */