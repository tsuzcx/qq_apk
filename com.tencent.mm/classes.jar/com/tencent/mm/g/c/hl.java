package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;

public abstract class hl
  extends c
{
  public static final String[] INDEX_CREATE = new String[0];
  private static final int eGD = "appId".hashCode();
  private static final int eGZ;
  private static final int fDG = "commLibVersionId".hashCode();
  private static final int fDH = "appVersionId".hashCode();
  private static final int fDI = "pageURL".hashCode();
  private static final int fDJ = "cacheFilePath".hashCode();
  private static final int fDf;
  private static final int rowid_HASHCODE = "rowid".hashCode();
  private boolean eGW = true;
  private boolean eGm = true;
  private boolean fCR = true;
  private boolean fDC = true;
  private boolean fDD = true;
  private boolean fDE = true;
  private boolean fDF = true;
  public long field_accessTime;
  public String field_appId;
  public String field_appVersionId;
  public String field_cacheFilePath;
  public String field_commLibVersionId;
  public String field_pageURL;
  public long field_updateTime;
  
  static
  {
    eGZ = "updateTime".hashCode();
    fDf = "accessTime".hashCode();
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
      if (eGD != k) {
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
      if (fDG == k) {
        this.field_commLibVersionId = paramCursor.getString(i);
      } else if (fDH == k) {
        this.field_appVersionId = paramCursor.getString(i);
      } else if (fDI == k) {
        this.field_pageURL = paramCursor.getString(i);
      } else if (eGZ == k) {
        this.field_updateTime = paramCursor.getLong(i);
      } else if (fDf == k) {
        this.field_accessTime = paramCursor.getLong(i);
      } else if (fDJ == k) {
        this.field_cacheFilePath = paramCursor.getString(i);
      } else if (rowid_HASHCODE == k) {
        this.systemRowid = paramCursor.getLong(i);
      }
    }
  }
  
  public ContentValues convertTo()
  {
    ContentValues localContentValues = new ContentValues();
    if (this.eGm) {
      localContentValues.put("appId", this.field_appId);
    }
    if (this.fDC) {
      localContentValues.put("commLibVersionId", this.field_commLibVersionId);
    }
    if (this.fDD) {
      localContentValues.put("appVersionId", this.field_appVersionId);
    }
    if (this.fDE) {
      localContentValues.put("pageURL", this.field_pageURL);
    }
    if (this.eGW) {
      localContentValues.put("updateTime", Long.valueOf(this.field_updateTime));
    }
    if (this.fCR) {
      localContentValues.put("accessTime", Long.valueOf(this.field_accessTime));
    }
    if (this.fDF) {
      localContentValues.put("cacheFilePath", this.field_cacheFilePath);
    }
    if (this.systemRowid > 0L) {
      localContentValues.put("rowid", Long.valueOf(this.systemRowid));
    }
    return localContentValues;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.g.c.hl
 * JD-Core Version:    0.7.0.1
 */