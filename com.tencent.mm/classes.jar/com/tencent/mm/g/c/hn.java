package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.storage.IAutoDBItem;

public abstract class hn
  extends IAutoDBItem
{
  public static final String[] INDEX_CREATE = new String[0];
  private static final int fJb = "expireTime".hashCode();
  private static final int fJf;
  private static final int fPE = "timeStamp".hashCode();
  private static final int fkX = "size".hashCode();
  private static final int fkj = "appId".hashCode();
  private static final int ghq = "appIdKey".hashCode();
  private static final int ghr = "localFile".hashCode();
  private static final int rowid_HASHCODE = "rowid".hashCode();
  private static final int value_HASHCODE = "value".hashCode();
  private boolean __hadSetvalue = true;
  private boolean fIP = true;
  private boolean fIT = true;
  private boolean fPy = true;
  public String field_appId;
  public String field_appIdKey;
  public long field_expireTime;
  public String field_localFile;
  public long field_size;
  public long field_timeStamp;
  public String field_value;
  public String field_weight;
  private boolean fjS = true;
  private boolean fkV = true;
  private boolean gho = true;
  private boolean ghp = true;
  
  static
  {
    fJf = "weight".hashCode();
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
      if (fkj != k) {
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
      if (ghq == k)
      {
        this.field_appIdKey = paramCursor.getString(i);
        this.gho = true;
      }
      else if (value_HASHCODE == k)
      {
        this.field_value = paramCursor.getString(i);
      }
      else if (fJf == k)
      {
        this.field_weight = paramCursor.getString(i);
      }
      else if (fJb == k)
      {
        this.field_expireTime = paramCursor.getLong(i);
      }
      else if (fPE == k)
      {
        this.field_timeStamp = paramCursor.getLong(i);
      }
      else if (fkX == k)
      {
        this.field_size = paramCursor.getLong(i);
      }
      else if (ghr == k)
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
    if (this.fjS) {
      localContentValues.put("appId", this.field_appId);
    }
    if (this.gho) {
      localContentValues.put("appIdKey", this.field_appIdKey);
    }
    if (this.__hadSetvalue) {
      localContentValues.put("value", this.field_value);
    }
    if (this.fIT) {
      localContentValues.put("weight", this.field_weight);
    }
    if (this.fIP) {
      localContentValues.put("expireTime", Long.valueOf(this.field_expireTime));
    }
    if (this.fPy) {
      localContentValues.put("timeStamp", Long.valueOf(this.field_timeStamp));
    }
    if (this.fkV) {
      localContentValues.put("size", Long.valueOf(this.field_size));
    }
    if (this.ghp) {
      localContentValues.put("localFile", this.field_localFile);
    }
    if (this.systemRowid > 0L) {
      localContentValues.put("rowid", Long.valueOf(this.systemRowid));
    }
    return localContentValues;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.g.c.hn
 * JD-Core Version:    0.7.0.1
 */