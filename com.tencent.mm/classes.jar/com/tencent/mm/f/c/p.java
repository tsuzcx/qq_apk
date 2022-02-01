package com.tencent.mm.f.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.storage.IAutoDBItem;
import com.tencent.mm.sdk.storage.sql.Column;
import com.tencent.mm.sdk.storage.sql.SingleTable;

public abstract class p
  extends IAutoDBItem
{
  public static final Column C_ROWID;
  public static final Column C_UPDATETIME;
  public static final String[] INDEX_CREATE = { "CREATE INDEX IF NOT EXISTS AppBrandLauncherLayoutItemUpdateTimeIndex ON AppBrandLauncherLayoutItem(updateTime)", "CREATE INDEX IF NOT EXISTS AppBrandLauncherLayoutItemSceneIndex ON AppBrandLauncherLayoutItem(scene)" };
  public static final SingleTable TABLE = new SingleTable("AppBrandLauncherLayoutItem");
  public static final Column hnt;
  private static final int hnx = "scene".hashCode();
  public static final Column hoQ;
  private static final int hoY;
  public static final Column hpi;
  public static final Column hpj;
  public static final Column hpk;
  public static final Column hpl;
  private static final int hpq;
  private static final int hpr;
  private static final int hps = "usedInThirdPartyAppRecently".hashCode();
  private static final int hpt = "thirdPartyAppUsingDesc".hashCode();
  private static final int rowid_HASHCODE = "rowid".hashCode();
  private static final int updateTime_HASHCODE;
  private boolean __hadSetupdateTime = true;
  public String field_brandId;
  public int field_recordId;
  public int field_scene;
  public String field_thirdPartyAppUsingDesc;
  public long field_updateTime;
  public boolean field_usedInThirdPartyAppRecently;
  public int field_versionType;
  private boolean hnv = true;
  private boolean hoU = true;
  private boolean hpm = true;
  private boolean hpn = true;
  private boolean hpo = true;
  private boolean hpp = true;
  
  static
  {
    C_ROWID = new Column("rowid", "long", "AppBrandLauncherLayoutItem", "");
    hpi = new Column("recordid", "int", "AppBrandLauncherLayoutItem", "");
    hpj = new Column("brandid", "string", "AppBrandLauncherLayoutItem", "");
    hoQ = new Column("versiontype", "int", "AppBrandLauncherLayoutItem", "");
    C_UPDATETIME = new Column("updatetime", "long", "AppBrandLauncherLayoutItem", "");
    hnt = new Column("scene", "int", "AppBrandLauncherLayoutItem", "");
    hpk = new Column("usedinthirdpartyapprecently", "boolean", "AppBrandLauncherLayoutItem", "");
    hpl = new Column("thirdpartyappusingdesc", "string", "AppBrandLauncherLayoutItem", "");
    hpq = "recordId".hashCode();
    hpr = "brandId".hashCode();
    hoY = "versionType".hashCode();
    updateTime_HASHCODE = "updateTime".hashCode();
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
      if (hpq != k) {
        break label65;
      }
      this.field_recordId = paramCursor.getInt(i);
      this.hpm = true;
    }
    for (;;)
    {
      i += 1;
      break label20;
      break;
      label65:
      if (hpr == k)
      {
        this.field_brandId = paramCursor.getString(i);
      }
      else if (hoY == k)
      {
        this.field_versionType = paramCursor.getInt(i);
      }
      else if (updateTime_HASHCODE == k)
      {
        this.field_updateTime = paramCursor.getLong(i);
      }
      else if (hnx == k)
      {
        this.field_scene = paramCursor.getInt(i);
      }
      else
      {
        if (hps == k)
        {
          if (paramCursor.getInt(i) != 0) {}
          for (boolean bool = true;; bool = false)
          {
            this.field_usedInThirdPartyAppRecently = bool;
            break;
          }
        }
        if (hpt == k) {
          this.field_thirdPartyAppUsingDesc = paramCursor.getString(i);
        } else if (rowid_HASHCODE == k) {
          this.systemRowid = paramCursor.getLong(i);
        }
      }
    }
  }
  
  public ContentValues convertTo()
  {
    ContentValues localContentValues = new ContentValues();
    if (this.hpm) {
      localContentValues.put("recordId", Integer.valueOf(this.field_recordId));
    }
    if (this.hpn) {
      localContentValues.put("brandId", this.field_brandId);
    }
    if (this.hoU) {
      localContentValues.put("versionType", Integer.valueOf(this.field_versionType));
    }
    if (this.__hadSetupdateTime) {
      localContentValues.put("updateTime", Long.valueOf(this.field_updateTime));
    }
    if (this.hnv) {
      localContentValues.put("scene", Integer.valueOf(this.field_scene));
    }
    if (this.hpo) {
      localContentValues.put("usedInThirdPartyAppRecently", Boolean.valueOf(this.field_usedInThirdPartyAppRecently));
    }
    if (this.hpp) {
      localContentValues.put("thirdPartyAppUsingDesc", this.field_thirdPartyAppUsingDesc);
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
    return "AppBrandLauncherLayoutItem";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.f.c.p
 * JD-Core Version:    0.7.0.1
 */