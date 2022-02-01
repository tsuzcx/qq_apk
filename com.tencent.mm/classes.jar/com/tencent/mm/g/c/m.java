package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.storage.IAutoDBItem;
import com.tencent.mm.sdk.storage.IAutoDBItem.MAutoDBInfo;
import java.lang.reflect.Field;
import java.util.Map;

public abstract class m
  extends IAutoDBItem
{
  public static final String[] INDEX_CREATE = { "CREATE INDEX IF NOT EXISTS AppBrandFakeNativeSplashScreenshotAPPIDINDEX ON AppBrandFakeNativeSplashScreenshot(appId)" };
  private static final int fkQ = "versionType".hashCode();
  private static final int fkR = "appVersion".hashCode();
  private static final int fkS = "isDarkMode".hashCode();
  private static final int fkT = "screenshotFilePath".hashCode();
  private static final int fkj = "appId".hashCode();
  private static final int rowid_HASHCODE = "rowid".hashCode();
  public String field_appId;
  public int field_appVersion;
  public boolean field_isDarkMode;
  public String field_screenshotFilePath;
  public int field_versionType;
  private boolean fjS = true;
  private boolean fkM = true;
  private boolean fkN = true;
  private boolean fkO = true;
  private boolean fkP = true;
  
  public static IAutoDBItem.MAutoDBInfo ajs()
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
      if (fkQ == k)
      {
        this.field_versionType = paramCursor.getInt(i);
      }
      else if (fkR == k)
      {
        this.field_appVersion = paramCursor.getInt(i);
      }
      else
      {
        if (fkS == k)
        {
          if (paramCursor.getInt(i) != 0) {}
          for (boolean bool = true;; bool = false)
          {
            this.field_isDarkMode = bool;
            break;
          }
        }
        if (fkT == k) {
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
    if (this.fjS) {
      localContentValues.put("appId", this.field_appId);
    }
    if (this.fkM) {
      localContentValues.put("versionType", Integer.valueOf(this.field_versionType));
    }
    if (this.fkN) {
      localContentValues.put("appVersion", Integer.valueOf(this.field_appVersion));
    }
    if (this.fkO) {
      localContentValues.put("isDarkMode", Boolean.valueOf(this.field_isDarkMode));
    }
    if (this.fkP) {
      localContentValues.put("screenshotFilePath", this.field_screenshotFilePath);
    }
    if (this.systemRowid > 0L) {
      localContentValues.put("rowid", Long.valueOf(this.systemRowid));
    }
    return localContentValues;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.g.c.m
 * JD-Core Version:    0.7.0.1
 */