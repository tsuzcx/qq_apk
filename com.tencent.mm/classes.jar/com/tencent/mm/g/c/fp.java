package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;

public abstract class fp
  extends c
{
  public static final String[] INDEX_CREATE = new String[0];
  private static final int dAN = "expireTime".hashCode();
  private static final int dAR;
  private static final int dPO = "timeStamp".hashCode();
  private static final int dVy;
  private static final int dhB = "appId".hashCode();
  private static final int dij = "size".hashCode();
  private static final int rowid_HASHCODE = "rowid".hashCode();
  private static final int value_HASHCODE;
  private boolean __hadSetvalue = true;
  private boolean dAF = true;
  private boolean dAJ = true;
  private boolean dPI = true;
  private boolean dVx = true;
  private boolean dhk = true;
  private boolean dih = true;
  public String field_appId;
  public String field_appIdKey;
  public long field_expireTime;
  public long field_size;
  public long field_timeStamp;
  public String field_value;
  public String field_weight;
  
  static
  {
    dVy = "appIdKey".hashCode();
    value_HASHCODE = "value".hashCode();
    dAR = "weight".hashCode();
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
      if (dhB != k) {
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
      if (dVy == k)
      {
        this.field_appIdKey = paramCursor.getString(i);
        this.dVx = true;
      }
      else if (value_HASHCODE == k)
      {
        this.field_value = paramCursor.getString(i);
      }
      else if (dAR == k)
      {
        this.field_weight = paramCursor.getString(i);
      }
      else if (dAN == k)
      {
        this.field_expireTime = paramCursor.getLong(i);
      }
      else if (dPO == k)
      {
        this.field_timeStamp = paramCursor.getLong(i);
      }
      else if (dij == k)
      {
        this.field_size = paramCursor.getLong(i);
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
    if (this.dhk) {
      localContentValues.put("appId", this.field_appId);
    }
    if (this.dVx) {
      localContentValues.put("appIdKey", this.field_appIdKey);
    }
    if (this.__hadSetvalue) {
      localContentValues.put("value", this.field_value);
    }
    if (this.dAJ) {
      localContentValues.put("weight", this.field_weight);
    }
    if (this.dAF) {
      localContentValues.put("expireTime", Long.valueOf(this.field_expireTime));
    }
    if (this.dPI) {
      localContentValues.put("timeStamp", Long.valueOf(this.field_timeStamp));
    }
    if (this.dih) {
      localContentValues.put("size", Long.valueOf(this.field_size));
    }
    if (this.systemRowid > 0L) {
      localContentValues.put("rowid", Long.valueOf(this.systemRowid));
    }
    return localContentValues;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.g.c.fp
 * JD-Core Version:    0.7.0.1
 */