package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;

public abstract class hb
  extends c
{
  public static final String[] INDEX_CREATE = new String[0];
  private static final int eEU = "appId".hashCode();
  private static final int eFM = "size".hashCode();
  private static final int fAs = "appIdKey".hashCode();
  private static final int fAt = "localFile".hashCode();
  private static final int fcQ;
  private static final int fcU;
  private static final int fjd;
  private static final int rowid_HASHCODE = "rowid".hashCode();
  private static final int value_HASHCODE = "value".hashCode();
  private boolean __hadSetvalue = true;
  private boolean eED = true;
  private boolean eFK = true;
  private boolean fAq = true;
  private boolean fAr = true;
  private boolean fcF = true;
  private boolean fcJ = true;
  private boolean fiX = true;
  public String field_appId;
  public String field_appIdKey;
  public long field_expireTime;
  public String field_localFile;
  public long field_size;
  public long field_timeStamp;
  public String field_value;
  public String field_weight;
  
  static
  {
    fcU = "weight".hashCode();
    fcQ = "expireTime".hashCode();
    fjd = "timeStamp".hashCode();
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
      if (eEU != k) {
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
      if (fAs == k)
      {
        this.field_appIdKey = paramCursor.getString(i);
        this.fAq = true;
      }
      else if (value_HASHCODE == k)
      {
        this.field_value = paramCursor.getString(i);
      }
      else if (fcU == k)
      {
        this.field_weight = paramCursor.getString(i);
      }
      else if (fcQ == k)
      {
        this.field_expireTime = paramCursor.getLong(i);
      }
      else if (fjd == k)
      {
        this.field_timeStamp = paramCursor.getLong(i);
      }
      else if (eFM == k)
      {
        this.field_size = paramCursor.getLong(i);
      }
      else if (fAt == k)
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
    if (this.eED) {
      localContentValues.put("appId", this.field_appId);
    }
    if (this.fAq) {
      localContentValues.put("appIdKey", this.field_appIdKey);
    }
    if (this.__hadSetvalue) {
      localContentValues.put("value", this.field_value);
    }
    if (this.fcJ) {
      localContentValues.put("weight", this.field_weight);
    }
    if (this.fcF) {
      localContentValues.put("expireTime", Long.valueOf(this.field_expireTime));
    }
    if (this.fiX) {
      localContentValues.put("timeStamp", Long.valueOf(this.field_timeStamp));
    }
    if (this.eFK) {
      localContentValues.put("size", Long.valueOf(this.field_size));
    }
    if (this.fAr) {
      localContentValues.put("localFile", this.field_localFile);
    }
    if (this.systemRowid > 0L) {
      localContentValues.put("rowid", Long.valueOf(this.systemRowid));
    }
    return localContentValues;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.g.c.hb
 * JD-Core Version:    0.7.0.1
 */