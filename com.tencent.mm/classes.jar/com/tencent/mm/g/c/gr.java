package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;

public abstract class gr
  extends c
{
  public static final String[] INDEX_CREATE = new String[0];
  private static final int eKA = "weight".hashCode();
  private static final int eKw = "expireTime".hashCode();
  private static final int eQG = "timeStamp".hashCode();
  private static final int enO = "appId".hashCode();
  private static final int eoH = "size".hashCode();
  private static final int fik = "appIdKey".hashCode();
  private static final int fil = "localFile".hashCode();
  private static final int rowid_HASHCODE = "rowid".hashCode();
  private static final int value_HASHCODE = "value".hashCode();
  private boolean __hadSetvalue = true;
  private boolean eKl = true;
  private boolean eKp = true;
  private boolean eQA = true;
  private boolean enx = true;
  private boolean eoF = true;
  public String field_appId;
  public String field_appIdKey;
  public long field_expireTime;
  public String field_localFile;
  public long field_size;
  public long field_timeStamp;
  public String field_value;
  public String field_weight;
  private boolean fii = true;
  private boolean fij = true;
  
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
      if (enO != k) {
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
      if (fik == k)
      {
        this.field_appIdKey = paramCursor.getString(i);
        this.fii = true;
      }
      else if (value_HASHCODE == k)
      {
        this.field_value = paramCursor.getString(i);
      }
      else if (eKA == k)
      {
        this.field_weight = paramCursor.getString(i);
      }
      else if (eKw == k)
      {
        this.field_expireTime = paramCursor.getLong(i);
      }
      else if (eQG == k)
      {
        this.field_timeStamp = paramCursor.getLong(i);
      }
      else if (eoH == k)
      {
        this.field_size = paramCursor.getLong(i);
      }
      else if (fil == k)
      {
        this.field_localFile = paramCursor.getString(i);
      }
      else if (rowid_HASHCODE == k)
      {
        this.systemRowid = paramCursor.getLong(i);
      }
    }
  }
  
  public ContentValues convertTo()
  {
    ContentValues localContentValues = new ContentValues();
    if (this.enx) {
      localContentValues.put("appId", this.field_appId);
    }
    if (this.fii) {
      localContentValues.put("appIdKey", this.field_appIdKey);
    }
    if (this.__hadSetvalue) {
      localContentValues.put("value", this.field_value);
    }
    if (this.eKp) {
      localContentValues.put("weight", this.field_weight);
    }
    if (this.eKl) {
      localContentValues.put("expireTime", Long.valueOf(this.field_expireTime));
    }
    if (this.eQA) {
      localContentValues.put("timeStamp", Long.valueOf(this.field_timeStamp));
    }
    if (this.eoF) {
      localContentValues.put("size", Long.valueOf(this.field_size));
    }
    if (this.fij) {
      localContentValues.put("localFile", this.field_localFile);
    }
    if (this.systemRowid > 0L) {
      localContentValues.put("rowid", Long.valueOf(this.systemRowid));
    }
    return localContentValues;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.g.c.gr
 * JD-Core Version:    0.7.0.1
 */