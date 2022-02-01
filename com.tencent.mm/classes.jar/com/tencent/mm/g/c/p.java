package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;

public abstract class p
  extends c
{
  public static final String[] INDEX_CREATE = { "CREATE INDEX IF NOT EXISTS AppBrandLauncherLayoutItemUpdateTimeIndex ON AppBrandLauncherLayoutItem(updateTime)", "CREATE INDEX IF NOT EXISTS AppBrandLauncherLayoutItemSceneIndex ON AppBrandLauncherLayoutItem(scene)" };
  private static final int eGZ = "updateTime".hashCode();
  private static final int eGk = "scene".hashCode();
  private static final int eHA = "recordId".hashCode();
  private static final int eHB = "brandId".hashCode();
  private static final int eHC = "usedInThirdPartyAppRecently".hashCode();
  private static final int eHD = "thirdPartyAppUsingDesc".hashCode();
  private static final int eHo = "versionType".hashCode();
  private static final int rowid_HASHCODE = "rowid".hashCode();
  private boolean eGW = true;
  private boolean eGi = true;
  private boolean eHk = true;
  private boolean eHw = true;
  private boolean eHx = true;
  private boolean eHy = true;
  private boolean eHz = true;
  public String field_brandId;
  public int field_recordId;
  public int field_scene;
  public String field_thirdPartyAppUsingDesc;
  public long field_updateTime;
  public boolean field_usedInThirdPartyAppRecently;
  public int field_versionType;
  
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
      if (eHA != k) {
        break label65;
      }
      this.field_recordId = paramCursor.getInt(i);
      this.eHw = true;
    }
    for (;;)
    {
      i += 1;
      break label20;
      break;
      label65:
      if (eHB == k)
      {
        this.field_brandId = paramCursor.getString(i);
      }
      else if (eHo == k)
      {
        this.field_versionType = paramCursor.getInt(i);
      }
      else if (eGZ == k)
      {
        this.field_updateTime = paramCursor.getLong(i);
      }
      else if (eGk == k)
      {
        this.field_scene = paramCursor.getInt(i);
      }
      else
      {
        if (eHC == k)
        {
          if (paramCursor.getInt(i) != 0) {}
          for (boolean bool = true;; bool = false)
          {
            this.field_usedInThirdPartyAppRecently = bool;
            break;
          }
        }
        if (eHD == k) {
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
    if (this.eHw) {
      localContentValues.put("recordId", Integer.valueOf(this.field_recordId));
    }
    if (this.eHx) {
      localContentValues.put("brandId", this.field_brandId);
    }
    if (this.eHk) {
      localContentValues.put("versionType", Integer.valueOf(this.field_versionType));
    }
    if (this.eGW) {
      localContentValues.put("updateTime", Long.valueOf(this.field_updateTime));
    }
    if (this.eGi) {
      localContentValues.put("scene", Integer.valueOf(this.field_scene));
    }
    if (this.eHy) {
      localContentValues.put("usedInThirdPartyAppRecently", Boolean.valueOf(this.field_usedInThirdPartyAppRecently));
    }
    if (this.eHz) {
      localContentValues.put("thirdPartyAppUsingDesc", this.field_thirdPartyAppUsingDesc);
    }
    if (this.systemRowid > 0L) {
      localContentValues.put("rowid", Long.valueOf(this.systemRowid));
    }
    return localContentValues;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.g.c.p
 * JD-Core Version:    0.7.0.1
 */