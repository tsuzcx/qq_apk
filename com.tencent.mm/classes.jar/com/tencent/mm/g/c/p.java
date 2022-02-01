package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.storage.IAutoDBItem;

public abstract class p
  extends IAutoDBItem
{
  public static final String[] INDEX_CREATE = { "CREATE INDEX IF NOT EXISTS AppBrandLauncherLayoutItemUpdateTimeIndex ON AppBrandLauncherLayoutItem(updateTime)", "CREATE INDEX IF NOT EXISTS AppBrandLauncherLayoutItemSceneIndex ON AppBrandLauncherLayoutItem(scene)" };
  private static final int fjQ = "scene".hashCode();
  private static final int fkQ;
  private static final int flc = "recordId".hashCode();
  private static final int fld = "brandId".hashCode();
  private static final int fle = "usedInThirdPartyAppRecently".hashCode();
  private static final int flf = "thirdPartyAppUsingDesc".hashCode();
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
  private boolean fjO = true;
  private boolean fkM = true;
  private boolean fkY = true;
  private boolean fkZ = true;
  private boolean fla = true;
  private boolean flb = true;
  
  static
  {
    fkQ = "versionType".hashCode();
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
      if (flc != k) {
        break label65;
      }
      this.field_recordId = paramCursor.getInt(i);
      this.fkY = true;
    }
    for (;;)
    {
      i += 1;
      break label20;
      break;
      label65:
      if (fld == k)
      {
        this.field_brandId = paramCursor.getString(i);
      }
      else if (fkQ == k)
      {
        this.field_versionType = paramCursor.getInt(i);
      }
      else if (updateTime_HASHCODE == k)
      {
        this.field_updateTime = paramCursor.getLong(i);
      }
      else if (fjQ == k)
      {
        this.field_scene = paramCursor.getInt(i);
      }
      else
      {
        if (fle == k)
        {
          if (paramCursor.getInt(i) != 0) {}
          for (boolean bool = true;; bool = false)
          {
            this.field_usedInThirdPartyAppRecently = bool;
            break;
          }
        }
        if (flf == k) {
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
    if (this.fkY) {
      localContentValues.put("recordId", Integer.valueOf(this.field_recordId));
    }
    if (this.fkZ) {
      localContentValues.put("brandId", this.field_brandId);
    }
    if (this.fkM) {
      localContentValues.put("versionType", Integer.valueOf(this.field_versionType));
    }
    if (this.__hadSetupdateTime) {
      localContentValues.put("updateTime", Long.valueOf(this.field_updateTime));
    }
    if (this.fjO) {
      localContentValues.put("scene", Integer.valueOf(this.field_scene));
    }
    if (this.fla) {
      localContentValues.put("usedInThirdPartyAppRecently", Boolean.valueOf(this.field_usedInThirdPartyAppRecently));
    }
    if (this.flb) {
      localContentValues.put("thirdPartyAppUsingDesc", this.field_thirdPartyAppUsingDesc);
    }
    if (this.systemRowid > 0L) {
      localContentValues.put("rowid", Long.valueOf(this.systemRowid));
    }
    return localContentValues;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.g.c.p
 * JD-Core Version:    0.7.0.1
 */