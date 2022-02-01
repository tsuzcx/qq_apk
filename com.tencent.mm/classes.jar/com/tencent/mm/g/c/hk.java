package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;

public abstract class hk
  extends c
{
  public static final String[] INDEX_CREATE = new String[0];
  private static final int eEU = "appId".hashCode();
  private static final int eFq;
  private static final int fBG = "commLibVersionId".hashCode();
  private static final int fBH = "appVersionId".hashCode();
  private static final int fBI = "pageURL".hashCode();
  private static final int fBJ = "cacheFilePath".hashCode();
  private static final int fBf;
  private static final int rowid_HASHCODE = "rowid".hashCode();
  private boolean eED = true;
  private boolean eFn = true;
  private boolean fAR = true;
  private boolean fBC = true;
  private boolean fBD = true;
  private boolean fBE = true;
  private boolean fBF = true;
  public long field_accessTime;
  public String field_appId;
  public String field_appVersionId;
  public String field_cacheFilePath;
  public String field_commLibVersionId;
  public String field_pageURL;
  public long field_updateTime;
  
  static
  {
    eFq = "updateTime".hashCode();
    fBf = "accessTime".hashCode();
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
      if (fBG == k) {
        this.field_commLibVersionId = paramCursor.getString(i);
      } else if (fBH == k) {
        this.field_appVersionId = paramCursor.getString(i);
      } else if (fBI == k) {
        this.field_pageURL = paramCursor.getString(i);
      } else if (eFq == k) {
        this.field_updateTime = paramCursor.getLong(i);
      } else if (fBf == k) {
        this.field_accessTime = paramCursor.getLong(i);
      } else if (fBJ == k) {
        this.field_cacheFilePath = paramCursor.getString(i);
      } else if (rowid_HASHCODE == k) {
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
    if (this.fBC) {
      localContentValues.put("commLibVersionId", this.field_commLibVersionId);
    }
    if (this.fBD) {
      localContentValues.put("appVersionId", this.field_appVersionId);
    }
    if (this.fBE) {
      localContentValues.put("pageURL", this.field_pageURL);
    }
    if (this.eFn) {
      localContentValues.put("updateTime", Long.valueOf(this.field_updateTime));
    }
    if (this.fAR) {
      localContentValues.put("accessTime", Long.valueOf(this.field_accessTime));
    }
    if (this.fBF) {
      localContentValues.put("cacheFilePath", this.field_cacheFilePath);
    }
    if (this.systemRowid > 0L) {
      localContentValues.put("rowid", Long.valueOf(this.systemRowid));
    }
    return localContentValues;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.g.c.hk
 * JD-Core Version:    0.7.0.1
 */