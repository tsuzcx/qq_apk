package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;

public abstract class p
  extends c
{
  public static final String[] INDEX_CREATE = { "CREATE INDEX IF NOT EXISTS AppBrandLauncherLayoutItemUpdateTimeIndex ON AppBrandLauncherLayoutItem(updateTime)", "CREATE INDEX IF NOT EXISTS AppBrandLauncherLayoutItemSceneIndex ON AppBrandLauncherLayoutItem(scene)" };
  private static final int env = "scene".hashCode();
  private static final int eoA;
  private static final int eoK = "recordId".hashCode();
  private static final int eoL = "brandId".hashCode();
  private static final int eol;
  private static final int rowid_HASHCODE = "rowid".hashCode();
  private boolean ent = true;
  private boolean eoI = true;
  private boolean eoJ = true;
  private boolean eoi = true;
  private boolean eow = true;
  public String field_brandId;
  public int field_recordId;
  public int field_scene;
  public long field_updateTime;
  public int field_versionType;
  
  static
  {
    eoA = "versionType".hashCode();
    eol = "updateTime".hashCode();
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
      if (eoK != k) {
        break label65;
      }
      this.field_recordId = paramCursor.getInt(i);
      this.eoI = true;
    }
    for (;;)
    {
      i += 1;
      break label20;
      break;
      label65:
      if (eoL == k) {
        this.field_brandId = paramCursor.getString(i);
      } else if (eoA == k) {
        this.field_versionType = paramCursor.getInt(i);
      } else if (eol == k) {
        this.field_updateTime = paramCursor.getLong(i);
      } else if (env == k) {
        this.field_scene = paramCursor.getInt(i);
      } else if (rowid_HASHCODE == k) {
        this.systemRowid = paramCursor.getLong(i);
      }
    }
  }
  
  public ContentValues convertTo()
  {
    ContentValues localContentValues = new ContentValues();
    if (this.eoI) {
      localContentValues.put("recordId", Integer.valueOf(this.field_recordId));
    }
    if (this.eoJ) {
      localContentValues.put("brandId", this.field_brandId);
    }
    if (this.eow) {
      localContentValues.put("versionType", Integer.valueOf(this.field_versionType));
    }
    if (this.eoi) {
      localContentValues.put("updateTime", Long.valueOf(this.field_updateTime));
    }
    if (this.ent) {
      localContentValues.put("scene", Integer.valueOf(this.field_scene));
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