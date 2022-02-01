package com.tencent.mm.f.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.storage.IAutoDBItem;
import com.tencent.mm.sdk.storage.sql.Column;
import com.tencent.mm.sdk.storage.sql.SingleTable;

public abstract class if
  extends IAutoDBItem
{
  public static final Column C_ROWID;
  public static final Column C_UPDATETIME;
  public static final String[] INDEX_CREATE = new String[0];
  public static final SingleTable TABLE = new SingleTable("WxaAppWebRenderingCacheAccessStatsTable");
  public static final Column hnz;
  private static final int hoh;
  private static final int iLK = "accessTime".hashCode();
  public static final Column iLi;
  public static final Column iMo;
  public static final Column iMp;
  public static final Column iMq;
  public static final Column iMr;
  private static final int iMw;
  private static final int iMx;
  private static final int iMy;
  private static final int iMz = "cacheFilePath".hashCode();
  private static final int rowid_HASHCODE = "rowid".hashCode();
  private static final int updateTime_HASHCODE;
  private boolean __hadSetupdateTime = true;
  public long field_accessTime;
  public String field_appId;
  public String field_appVersionId;
  public String field_cacheFilePath;
  public String field_commLibVersionId;
  public String field_pageURL;
  public long field_updateTime;
  private boolean hnQ = true;
  private boolean iLw = true;
  private boolean iMs = true;
  private boolean iMt = true;
  private boolean iMu = true;
  private boolean iMv = true;
  
  static
  {
    C_ROWID = new Column("rowid", "long", "WxaAppWebRenderingCacheAccessStatsTable", "");
    hnz = new Column("appid", "string", "WxaAppWebRenderingCacheAccessStatsTable", "");
    iMo = new Column("commlibversionid", "string", "WxaAppWebRenderingCacheAccessStatsTable", "");
    iMp = new Column("appversionid", "string", "WxaAppWebRenderingCacheAccessStatsTable", "");
    iMq = new Column("pageurl", "string", "WxaAppWebRenderingCacheAccessStatsTable", "");
    C_UPDATETIME = new Column("updatetime", "long", "WxaAppWebRenderingCacheAccessStatsTable", "");
    iLi = new Column("accesstime", "long", "WxaAppWebRenderingCacheAccessStatsTable", "");
    iMr = new Column("cachefilepath", "string", "WxaAppWebRenderingCacheAccessStatsTable", "");
    hoh = "appId".hashCode();
    iMw = "commLibVersionId".hashCode();
    iMx = "appVersionId".hashCode();
    iMy = "pageURL".hashCode();
    updateTime_HASHCODE = "updateTime".hashCode();
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
      if (hoh != k) {
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
      if (iMw == k) {
        this.field_commLibVersionId = paramCursor.getString(i);
      } else if (iMx == k) {
        this.field_appVersionId = paramCursor.getString(i);
      } else if (iMy == k) {
        this.field_pageURL = paramCursor.getString(i);
      } else if (updateTime_HASHCODE == k) {
        this.field_updateTime = paramCursor.getLong(i);
      } else if (iLK == k) {
        this.field_accessTime = paramCursor.getLong(i);
      } else if (iMz == k) {
        this.field_cacheFilePath = paramCursor.getString(i);
      } else if (rowid_HASHCODE == k) {
        this.systemRowid = paramCursor.getLong(i);
      }
    }
  }
  
  public ContentValues convertTo()
  {
    ContentValues localContentValues = new ContentValues();
    if (this.hnQ) {
      localContentValues.put("appId", this.field_appId);
    }
    if (this.iMs) {
      localContentValues.put("commLibVersionId", this.field_commLibVersionId);
    }
    if (this.iMt) {
      localContentValues.put("appVersionId", this.field_appVersionId);
    }
    if (this.iMu) {
      localContentValues.put("pageURL", this.field_pageURL);
    }
    if (this.__hadSetupdateTime) {
      localContentValues.put("updateTime", Long.valueOf(this.field_updateTime));
    }
    if (this.iLw) {
      localContentValues.put("accessTime", Long.valueOf(this.field_accessTime));
    }
    if (this.iMv) {
      localContentValues.put("cacheFilePath", this.field_cacheFilePath);
    }
    if (this.systemRowid > 0L) {
      localContentValues.put("rowid", Long.valueOf(this.systemRowid));
    }
    return localContentValues;
  }
  
  public String[] getIndexCreateSQL()
  {
    return INDEX_CREATE;
  }
  
  public String getTableName()
  {
    return "WxaAppWebRenderingCacheAccessStatsTable";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.f.c.if
 * JD-Core Version:    0.7.0.1
 */