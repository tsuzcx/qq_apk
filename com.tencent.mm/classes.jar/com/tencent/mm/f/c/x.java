package com.tencent.mm.f.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.storage.IAutoDBItem;
import com.tencent.mm.sdk.storage.sql.Column;
import com.tencent.mm.sdk.storage.sql.SingleTable;

public abstract class x
  extends IAutoDBItem
{
  public static final Column C_ROWID;
  public static final String[] INDEX_CREATE = new String[0];
  public static final SingleTable TABLE = new SingleTable("AppBrandWxaPkgPreDownloadStatistics2");
  public static final Column hnz;
  private static final int hoh = "appId".hashCode();
  public static final Column hpJ;
  private static final int hpT = "version".hashCode();
  public static final Column hpY;
  public static final Column hpZ;
  public static final Column hqa;
  public static final Column hqb;
  public static final Column hqc;
  private static final int hqi = "packageType".hashCode();
  private static final int hqj = "packageKey".hashCode();
  private static final int hqk = "source".hashCode();
  private static final int hql = "hitCount".hashCode();
  private static final int hqm = "reportId".hashCode();
  private static final int rowid_HASHCODE = "rowid".hashCode();
  public String field_appId;
  public int field_hitCount;
  public String field_packageKey;
  public int field_packageType;
  public int field_reportId;
  public int field_source;
  public int field_version;
  private boolean hnQ = true;
  private boolean hpO = true;
  private boolean hqd = true;
  private boolean hqe = true;
  private boolean hqf = true;
  private boolean hqg = true;
  private boolean hqh = true;
  
  static
  {
    C_ROWID = new Column("rowid", "long", "AppBrandWxaPkgPreDownloadStatistics2", "");
    hnz = new Column("appid", "string", "AppBrandWxaPkgPreDownloadStatistics2", "");
    hpJ = new Column("version", "int", "AppBrandWxaPkgPreDownloadStatistics2", "");
    hpY = new Column("packagetype", "int", "AppBrandWxaPkgPreDownloadStatistics2", "");
    hpZ = new Column("packagekey", "string", "AppBrandWxaPkgPreDownloadStatistics2", "");
    hqa = new Column("source", "int", "AppBrandWxaPkgPreDownloadStatistics2", "");
    hqb = new Column("hitcount", "int", "AppBrandWxaPkgPreDownloadStatistics2", "");
    hqc = new Column("reportid", "int", "AppBrandWxaPkgPreDownloadStatistics2", "");
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
      if (hpT == k) {
        this.field_version = paramCursor.getInt(i);
      } else if (hqi == k) {
        this.field_packageType = paramCursor.getInt(i);
      } else if (hqj == k) {
        this.field_packageKey = paramCursor.getString(i);
      } else if (hqk == k) {
        this.field_source = paramCursor.getInt(i);
      } else if (hql == k) {
        this.field_hitCount = paramCursor.getInt(i);
      } else if (hqm == k) {
        this.field_reportId = paramCursor.getInt(i);
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
    if (this.hpO) {
      localContentValues.put("version", Integer.valueOf(this.field_version));
    }
    if (this.hqd) {
      localContentValues.put("packageType", Integer.valueOf(this.field_packageType));
    }
    if (this.hqe) {
      localContentValues.put("packageKey", this.field_packageKey);
    }
    if (this.hqf) {
      localContentValues.put("source", Integer.valueOf(this.field_source));
    }
    if (this.hqg) {
      localContentValues.put("hitCount", Integer.valueOf(this.field_hitCount));
    }
    if (this.hqh) {
      localContentValues.put("reportId", Integer.valueOf(this.field_reportId));
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
    return "AppBrandWxaPkgPreDownloadStatistics2";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.f.c.x
 * JD-Core Version:    0.7.0.1
 */