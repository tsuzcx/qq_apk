package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;

public abstract class ha
  extends c
{
  public static final String[] INDEX_CREATE = new String[0];
  private static final int enO = "appId".hashCode();
  private static final int eol = "updateTime".hashCode();
  private static final int fiY = "accessTime".hashCode();
  private static final int fjA;
  private static final int fjB;
  private static final int fjC = "cacheFilePath".hashCode();
  private static final int fjz = "commLibVersionId".hashCode();
  private static final int rowid_HASHCODE = "rowid".hashCode();
  private boolean enx = true;
  private boolean eoi = true;
  private boolean fiK = true;
  public long field_accessTime;
  public String field_appId;
  public String field_appVersionId;
  public String field_cacheFilePath;
  public String field_commLibVersionId;
  public String field_pageURL;
  public long field_updateTime;
  private boolean fjv = true;
  private boolean fjw = true;
  private boolean fjx = true;
  private boolean fjy = true;
  
  static
  {
    fjA = "appVersionId".hashCode();
    fjB = "pageURL".hashCode();
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
      if (fjz == k) {
        this.field_commLibVersionId = paramCursor.getString(i);
      } else if (fjA == k) {
        this.field_appVersionId = paramCursor.getString(i);
      } else if (fjB == k) {
        this.field_pageURL = paramCursor.getString(i);
      } else if (eol == k) {
        this.field_updateTime = paramCursor.getLong(i);
      } else if (fiY == k) {
        this.field_accessTime = paramCursor.getLong(i);
      } else if (fjC == k) {
        this.field_cacheFilePath = paramCursor.getString(i);
      } else if (rowid_HASHCODE == k) {
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
    if (this.fjv) {
      localContentValues.put("commLibVersionId", this.field_commLibVersionId);
    }
    if (this.fjw) {
      localContentValues.put("appVersionId", this.field_appVersionId);
    }
    if (this.fjx) {
      localContentValues.put("pageURL", this.field_pageURL);
    }
    if (this.eoi) {
      localContentValues.put("updateTime", Long.valueOf(this.field_updateTime));
    }
    if (this.fiK) {
      localContentValues.put("accessTime", Long.valueOf(this.field_accessTime));
    }
    if (this.fjy) {
      localContentValues.put("cacheFilePath", this.field_cacheFilePath);
    }
    if (this.systemRowid > 0L) {
      localContentValues.put("rowid", Long.valueOf(this.systemRowid));
    }
    return localContentValues;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.g.c.ha
 * JD-Core Version:    0.7.0.1
 */