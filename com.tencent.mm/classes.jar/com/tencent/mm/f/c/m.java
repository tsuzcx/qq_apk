package com.tencent.mm.f.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.storage.IAutoDBItem;
import com.tencent.mm.sdk.storage.IAutoDBItem.MAutoDBInfo;
import com.tencent.mm.sdk.storage.sql.Column;
import com.tencent.mm.sdk.storage.sql.SingleTable;
import java.lang.reflect.Field;
import java.util.Map;

public abstract class m
  extends IAutoDBItem
{
  public static final Column C_ROWID;
  public static final String[] INDEX_CREATE = { "CREATE INDEX IF NOT EXISTS AppBrandFakeNativeSplashScreenshotAPPIDINDEX ON AppBrandFakeNativeSplashScreenshot(appId)" };
  public static final SingleTable TABLE = new SingleTable("AppBrandFakeNativeSplashScreenshot");
  public static final Column hnz;
  public static final Column hoQ;
  public static final Column hoR;
  public static final Column hoS;
  public static final Column hoT;
  private static final int hoY = "versionType".hashCode();
  private static final int hoZ = "appVersion".hashCode();
  private static final int hoh;
  private static final int hpa = "isDarkMode".hashCode();
  private static final int hpb = "screenshotFilePath".hashCode();
  private static final int rowid_HASHCODE = "rowid".hashCode();
  public String field_appId;
  public int field_appVersion;
  public boolean field_isDarkMode;
  public String field_screenshotFilePath;
  public int field_versionType;
  private boolean hnQ = true;
  private boolean hoU = true;
  private boolean hoV = true;
  private boolean hoW = true;
  private boolean hoX = true;
  
  static
  {
    C_ROWID = new Column("rowid", "long", "AppBrandFakeNativeSplashScreenshot", "");
    hnz = new Column("appid", "string", "AppBrandFakeNativeSplashScreenshot", "");
    hoQ = new Column("versiontype", "int", "AppBrandFakeNativeSplashScreenshot", "");
    hoR = new Column("appversion", "int", "AppBrandFakeNativeSplashScreenshot", "");
    hoS = new Column("isdarkmode", "boolean", "AppBrandFakeNativeSplashScreenshot", "");
    hoT = new Column("screenshotfilepath", "string", "AppBrandFakeNativeSplashScreenshot", "");
    hoh = "appId".hashCode();
  }
  
  public static IAutoDBItem.MAutoDBInfo aoY()
  {
    IAutoDBItem.MAutoDBInfo localMAutoDBInfo = new IAutoDBItem.MAutoDBInfo();
    localMAutoDBInfo.fields = new Field[5];
    localMAutoDBInfo.columns = new String[6];
    StringBuilder localStringBuilder = new StringBuilder();
    localMAutoDBInfo.columns[0] = "appId";
    localMAutoDBInfo.colsMap.put("appId", "TEXT");
    localStringBuilder.append(" appId TEXT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[1] = "versionType";
    localMAutoDBInfo.colsMap.put("versionType", "INTEGER default '0' ");
    localStringBuilder.append(" versionType INTEGER default '0' ");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[2] = "appVersion";
    localMAutoDBInfo.colsMap.put("appVersion", "INTEGER default '0' ");
    localStringBuilder.append(" appVersion INTEGER default '0' ");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[3] = "isDarkMode";
    localMAutoDBInfo.colsMap.put("isDarkMode", "INTEGER default 'false' ");
    localStringBuilder.append(" isDarkMode INTEGER default 'false' ");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[4] = "screenshotFilePath";
    localMAutoDBInfo.colsMap.put("screenshotFilePath", "TEXT");
    localStringBuilder.append(" screenshotFilePath TEXT");
    localMAutoDBInfo.columns[5] = "rowid";
    localMAutoDBInfo.sql = localStringBuilder.toString();
    return localMAutoDBInfo;
  }
  
  public void convertFrom(Cursor paramCursor)
  {
    String[] arrayOfString = paramCursor.getColumnNames();
    if (arrayOfString == null) {
      return;
    }
    int j = arrayOfString.length;
    int i = 0;
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
      if (hoY == k)
      {
        this.field_versionType = paramCursor.getInt(i);
      }
      else if (hoZ == k)
      {
        this.field_appVersion = paramCursor.getInt(i);
      }
      else
      {
        if (hpa == k)
        {
          if (paramCursor.getInt(i) != 0) {}
          for (boolean bool = true;; bool = false)
          {
            this.field_isDarkMode = bool;
            break;
          }
        }
        if (hpb == k) {
          this.field_screenshotFilePath = paramCursor.getString(i);
        } else if (rowid_HASHCODE == k) {
          this.systemRowid = paramCursor.getLong(i);
        }
      }
    }
  }
  
  public ContentValues convertTo()
  {
    ContentValues localContentValues = new ContentValues();
    if (this.hnQ) {
      localContentValues.put("appId", this.field_appId);
    }
    if (this.hoU) {
      localContentValues.put("versionType", Integer.valueOf(this.field_versionType));
    }
    if (this.hoV) {
      localContentValues.put("appVersion", Integer.valueOf(this.field_appVersion));
    }
    if (this.hoW) {
      localContentValues.put("isDarkMode", Boolean.valueOf(this.field_isDarkMode));
    }
    if (this.hoX) {
      localContentValues.put("screenshotFilePath", this.field_screenshotFilePath);
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
    return "AppBrandFakeNativeSplashScreenshot";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.f.c.m
 * JD-Core Version:    0.7.0.1
 */