package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;

public abstract class gn
  extends c
{
  public static final String[] INDEX_CREATE = new String[0];
  private static final int eHE = "expireTime".hashCode();
  private static final int eHI;
  private static final int eYF = "timeStamp".hashCode();
  private static final int elJ = "appId".hashCode();
  private static final int emB = "size".hashCode();
  private static final int feS = "appIdKey".hashCode();
  private static final int feT = "localFile".hashCode();
  private static final int rowid_HASHCODE = "rowid".hashCode();
  private static final int value_HASHCODE = "value".hashCode();
  private boolean __hadSetvalue = true;
  private boolean eHt = true;
  private boolean eHx = true;
  private boolean eYz = true;
  private boolean els = true;
  private boolean emz = true;
  private boolean feQ = true;
  private boolean feR = true;
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
    eHI = "weight".hashCode();
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
      if (elJ != k) {
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
      if (feS == k)
      {
        this.field_appIdKey = paramCursor.getString(i);
        this.feQ = true;
      }
      else if (value_HASHCODE == k)
      {
        this.field_value = paramCursor.getString(i);
      }
      else if (eHI == k)
      {
        this.field_weight = paramCursor.getString(i);
      }
      else if (eHE == k)
      {
        this.field_expireTime = paramCursor.getLong(i);
      }
      else if (eYF == k)
      {
        this.field_timeStamp = paramCursor.getLong(i);
      }
      else if (emB == k)
      {
        this.field_size = paramCursor.getLong(i);
      }
      else if (feT == k)
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
    if (this.els) {
      localContentValues.put("appId", this.field_appId);
    }
    if (this.feQ) {
      localContentValues.put("appIdKey", this.field_appIdKey);
    }
    if (this.__hadSetvalue) {
      localContentValues.put("value", this.field_value);
    }
    if (this.eHx) {
      localContentValues.put("weight", this.field_weight);
    }
    if (this.eHt) {
      localContentValues.put("expireTime", Long.valueOf(this.field_expireTime));
    }
    if (this.eYz) {
      localContentValues.put("timeStamp", Long.valueOf(this.field_timeStamp));
    }
    if (this.emz) {
      localContentValues.put("size", Long.valueOf(this.field_size));
    }
    if (this.feR) {
      localContentValues.put("localFile", this.field_localFile);
    }
    if (this.systemRowid > 0L) {
      localContentValues.put("rowid", Long.valueOf(this.systemRowid));
    }
    return localContentValues;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.g.c.gn
 * JD-Core Version:    0.7.0.1
 */