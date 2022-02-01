package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;
import com.tencent.mm.sdk.e.c.a;
import java.lang.reflect.Field;
import java.util.Map;

public abstract class m
  extends c
{
  public static final String[] INDEX_CREATE = { "CREATE INDEX IF NOT EXISTS AppBrandFakeNativeSplashScreenshotAPPIDINDEX ON AppBrandFakeNativeSplashScreenshot(appId)" };
  private static final int eEU = "appId".hashCode();
  private static final int eFF = "versionType".hashCode();
  private static final int eFG = "appVersion".hashCode();
  private static final int eFH = "isDarkMode".hashCode();
  private static final int eFI = "screenshotFilePath".hashCode();
  private static final int rowid_HASHCODE = "rowid".hashCode();
  private boolean eED = true;
  private boolean eFB = true;
  private boolean eFC = true;
  private boolean eFD = true;
  private boolean eFE = true;
  public String field_appId;
  public int field_appVersion;
  public boolean field_isDarkMode;
  public String field_screenshotFilePath;
  public int field_versionType;
  
  public static c.a Vv()
  {
    c.a locala = new c.a();
    locala.IhA = new Field[5];
    locala.columns = new String[6];
    StringBuilder localStringBuilder = new StringBuilder();
    locala.columns[0] = "appId";
    locala.IhC.put("appId", "TEXT");
    localStringBuilder.append(" appId TEXT");
    localStringBuilder.append(", ");
    locala.columns[1] = "versionType";
    locala.IhC.put("versionType", "INTEGER default '0' ");
    localStringBuilder.append(" versionType INTEGER default '0' ");
    localStringBuilder.append(", ");
    locala.columns[2] = "appVersion";
    locala.IhC.put("appVersion", "INTEGER default '0' ");
    localStringBuilder.append(" appVersion INTEGER default '0' ");
    localStringBuilder.append(", ");
    locala.columns[3] = "isDarkMode";
    locala.IhC.put("isDarkMode", "INTEGER default 'false' ");
    localStringBuilder.append(" isDarkMode INTEGER default 'false' ");
    localStringBuilder.append(", ");
    locala.columns[4] = "screenshotFilePath";
    locala.IhC.put("screenshotFilePath", "TEXT");
    localStringBuilder.append(" screenshotFilePath TEXT");
    locala.columns[5] = "rowid";
    locala.sql = localStringBuilder.toString();
    return locala;
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
      if (eFF == k)
      {
        this.field_versionType = paramCursor.getInt(i);
      }
      else if (eFG == k)
      {
        this.field_appVersion = paramCursor.getInt(i);
      }
      else
      {
        if (eFH == k)
        {
          if (paramCursor.getInt(i) != 0) {}
          for (boolean bool = true;; bool = false)
          {
            this.field_isDarkMode = bool;
            break;
          }
        }
        if (eFI == k) {
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
    if (this.eED) {
      localContentValues.put("appId", this.field_appId);
    }
    if (this.eFB) {
      localContentValues.put("versionType", Integer.valueOf(this.field_versionType));
    }
    if (this.eFC) {
      localContentValues.put("appVersion", Integer.valueOf(this.field_appVersion));
    }
    if (this.eFD) {
      localContentValues.put("isDarkMode", Boolean.valueOf(this.field_isDarkMode));
    }
    if (this.eFE) {
      localContentValues.put("screenshotFilePath", this.field_screenshotFilePath);
    }
    if (this.systemRowid > 0L) {
      localContentValues.put("rowid", Long.valueOf(this.systemRowid));
    }
    return localContentValues;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.g.c.m
 * JD-Core Version:    0.7.0.1
 */