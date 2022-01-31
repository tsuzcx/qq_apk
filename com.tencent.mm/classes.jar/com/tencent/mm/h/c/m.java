package com.tencent.mm.h.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;

public abstract class m
  extends c
{
  public static final String[] cqY = { "CREATE INDEX IF NOT EXISTS AppBrandLauncherLayoutItemUpdateTimeIndex ON AppBrandLauncherLayoutItem(updateTime)", "CREATE INDEX IF NOT EXISTS AppBrandLauncherLayoutItemSceneIndex ON AppBrandLauncherLayoutItem(scene)" };
  private static final int crh = "rowid".hashCode();
  private static final int csS;
  private static final int ctG;
  private static final int ctW = "recordId".hashCode();
  private static final int ctX = "brandId".hashCode();
  private static final int ctY = "versionType".hashCode();
  private boolean csQ = true;
  private boolean ctE = true;
  private boolean ctT = true;
  private boolean ctU = true;
  private boolean ctV = true;
  public String field_brandId;
  public int field_recordId;
  public int field_scene;
  public long field_updateTime;
  public int field_versionType;
  
  static
  {
    ctG = "updateTime".hashCode();
    csS = "scene".hashCode();
  }
  
  public final void d(Cursor paramCursor)
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
      if (ctW != k) {
        break label65;
      }
      this.field_recordId = paramCursor.getInt(i);
      this.ctT = true;
    }
    for (;;)
    {
      i += 1;
      break label20;
      break;
      label65:
      if (ctX == k) {
        this.field_brandId = paramCursor.getString(i);
      } else if (ctY == k) {
        this.field_versionType = paramCursor.getInt(i);
      } else if (ctG == k) {
        this.field_updateTime = paramCursor.getLong(i);
      } else if (csS == k) {
        this.field_scene = paramCursor.getInt(i);
      } else if (crh == k) {
        this.ujK = paramCursor.getLong(i);
      }
    }
  }
  
  public ContentValues vf()
  {
    ContentValues localContentValues = new ContentValues();
    if (this.ctT) {
      localContentValues.put("recordId", Integer.valueOf(this.field_recordId));
    }
    if (this.ctU) {
      localContentValues.put("brandId", this.field_brandId);
    }
    if (this.ctV) {
      localContentValues.put("versionType", Integer.valueOf(this.field_versionType));
    }
    if (this.ctE) {
      localContentValues.put("updateTime", Long.valueOf(this.field_updateTime));
    }
    if (this.csQ) {
      localContentValues.put("scene", Integer.valueOf(this.field_scene));
    }
    if (this.ujK > 0L) {
      localContentValues.put("rowid", Long.valueOf(this.ujK));
    }
    return localContentValues;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.h.c.m
 * JD-Core Version:    0.7.0.1
 */