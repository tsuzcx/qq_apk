package com.tencent.mm.h.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;

public abstract class fa
  extends c
{
  private static final int cKZ;
  private static final int cLd;
  public static final String[] cqY = new String[0];
  private static final int crh = "rowid".hashCode();
  private static final int crx;
  private static final int ctS;
  private static final int ctl = "appId".hashCode();
  private static final int ddU = "appIdKey".hashCode();
  private static final int ddV;
  private boolean cKR = true;
  private boolean cKV = true;
  private boolean crp = true;
  private boolean csU = true;
  private boolean ctQ = true;
  private boolean ddS = true;
  private boolean ddT = true;
  public String field_appId;
  public String field_appIdKey;
  public long field_expireTime;
  public long field_size;
  public long field_timeStamp;
  public String field_value;
  public String field_weight;
  
  static
  {
    crx = "value".hashCode();
    cLd = "weight".hashCode();
    cKZ = "expireTime".hashCode();
    ddV = "timeStamp".hashCode();
    ctS = "size".hashCode();
  }
  
  public final void d(Cursor paramCursor)
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
      if (ctl != k) {
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
      if (ddU == k)
      {
        this.field_appIdKey = paramCursor.getString(i);
        this.ddS = true;
      }
      else if (crx == k)
      {
        this.field_value = paramCursor.getString(i);
      }
      else if (cLd == k)
      {
        this.field_weight = paramCursor.getString(i);
      }
      else if (cKZ == k)
      {
        this.field_expireTime = paramCursor.getLong(i);
      }
      else if (ddV == k)
      {
        this.field_timeStamp = paramCursor.getLong(i);
      }
      else if (ctS == k)
      {
        this.field_size = paramCursor.getLong(i);
      }
      else if (crh == k)
      {
        this.ujK = paramCursor.getLong(i);
      }
    }
  }
  
  public final ContentValues vf()
  {
    ContentValues localContentValues = new ContentValues();
    if (this.csU) {
      localContentValues.put("appId", this.field_appId);
    }
    if (this.ddS) {
      localContentValues.put("appIdKey", this.field_appIdKey);
    }
    if (this.crp) {
      localContentValues.put("value", this.field_value);
    }
    if (this.cKV) {
      localContentValues.put("weight", this.field_weight);
    }
    if (this.cKR) {
      localContentValues.put("expireTime", Long.valueOf(this.field_expireTime));
    }
    if (this.ddT) {
      localContentValues.put("timeStamp", Long.valueOf(this.field_timeStamp));
    }
    if (this.ctQ) {
      localContentValues.put("size", Long.valueOf(this.field_size));
    }
    if (this.ujK > 0L) {
      localContentValues.put("rowid", Long.valueOf(this.ujK));
    }
    return localContentValues;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.h.c.fa
 * JD-Core Version:    0.7.0.1
 */