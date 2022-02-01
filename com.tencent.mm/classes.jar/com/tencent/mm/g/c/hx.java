package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.storage.IAutoDBItem;

public abstract class hx
  extends IAutoDBItem
{
  public static final String[] INDEX_CREATE = new String[0];
  private static final int fkj = "appId".hashCode();
  private static final int giQ = "commLibVersionId".hashCode();
  private static final int giR = "appVersionId".hashCode();
  private static final int giS = "pageURL".hashCode();
  private static final int giT = "cacheFilePath".hashCode();
  private static final int gip;
  private static final int rowid_HASHCODE = "rowid".hashCode();
  private static final int updateTime_HASHCODE = "updateTime".hashCode();
  private boolean __hadSetupdateTime = true;
  public long field_accessTime;
  public String field_appId;
  public String field_appVersionId;
  public String field_cacheFilePath;
  public String field_commLibVersionId;
  public String field_pageURL;
  public long field_updateTime;
  private boolean fjS = true;
  private boolean giM = true;
  private boolean giN = true;
  private boolean giO = true;
  private boolean giP = true;
  private boolean gib = true;
  
  static
  {
    gip = "accessTime".hashCode();
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
      if (giQ == k) {
        this.field_commLibVersionId = paramCursor.getString(i);
      } else if (giR == k) {
        this.field_appVersionId = paramCursor.getString(i);
      } else if (giS == k) {
        this.field_pageURL = paramCursor.getString(i);
      } else if (updateTime_HASHCODE == k) {
        this.field_updateTime = paramCursor.getLong(i);
      } else if (gip == k) {
        this.field_accessTime = paramCursor.getLong(i);
      } else if (giT == k) {
        this.field_cacheFilePath = paramCursor.getString(i);
      } else if (rowid_HASHCODE == k) {
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
    if (this.giM) {
      localContentValues.put("commLibVersionId", this.field_commLibVersionId);
    }
    if (this.giN) {
      localContentValues.put("appVersionId", this.field_appVersionId);
    }
    if (this.giO) {
      localContentValues.put("pageURL", this.field_pageURL);
    }
    if (this.__hadSetupdateTime) {
      localContentValues.put("updateTime", Long.valueOf(this.field_updateTime));
    }
    if (this.gib) {
      localContentValues.put("accessTime", Long.valueOf(this.field_accessTime));
    }
    if (this.giP) {
      localContentValues.put("cacheFilePath", this.field_cacheFilePath);
    }
    if (this.systemRowid > 0L) {
      localContentValues.put("rowid", Long.valueOf(this.systemRowid));
    }
    return localContentValues;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.g.c.hx
 * JD-Core Version:    0.7.0.1
 */