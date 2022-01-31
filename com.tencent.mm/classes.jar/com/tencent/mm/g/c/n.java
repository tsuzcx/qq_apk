package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;

public abstract class n
  extends c
{
  public static final String[] INDEX_CREATE = { "CREATE INDEX IF NOT EXISTS AppBrandLauncherLayoutItemUpdateTimeIndex ON AppBrandLauncherLayoutItem(updateTime)", "CREATE INDEX IF NOT EXISTS AppBrandLauncherLayoutItemSceneIndex ON AppBrandLauncherLayoutItem(scene)" };
  private static final int dhV = "updateTime".hashCode();
  private static final int dhi = "scene".hashCode();
  private static final int din = "recordId".hashCode();
  private static final int dio = "brandId".hashCode();
  private static final int dip = "versionType".hashCode();
  private static final int rowid_HASHCODE = "rowid".hashCode();
  private boolean dhT = true;
  private boolean dhg = true;
  private boolean dik = true;
  private boolean dil = true;
  private boolean dim = true;
  public String field_brandId;
  public int field_recordId;
  public int field_scene;
  public long field_updateTime;
  public int field_versionType;
  
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
      if (din != k) {
        break label65;
      }
      this.field_recordId = paramCursor.getInt(i);
      this.dik = true;
    }
    for (;;)
    {
      i += 1;
      break label20;
      break;
      label65:
      if (dio == k) {
        this.field_brandId = paramCursor.getString(i);
      } else if (dip == k) {
        this.field_versionType = paramCursor.getInt(i);
      } else if (dhV == k) {
        this.field_updateTime = paramCursor.getLong(i);
      } else if (dhi == k) {
        this.field_scene = paramCursor.getInt(i);
      } else if (rowid_HASHCODE == k) {
        this.systemRowid = paramCursor.getLong(i);
      }
    }
  }
  
  public ContentValues convertTo()
  {
    ContentValues localContentValues = new ContentValues();
    if (this.dik) {
      localContentValues.put("recordId", Integer.valueOf(this.field_recordId));
    }
    if (this.dil) {
      localContentValues.put("brandId", this.field_brandId);
    }
    if (this.dim) {
      localContentValues.put("versionType", Integer.valueOf(this.field_versionType));
    }
    if (this.dhT) {
      localContentValues.put("updateTime", Long.valueOf(this.field_updateTime));
    }
    if (this.dhg) {
      localContentValues.put("scene", Integer.valueOf(this.field_scene));
    }
    if (this.systemRowid > 0L) {
      localContentValues.put("rowid", Long.valueOf(this.systemRowid));
    }
    return localContentValues;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.g.c.n
 * JD-Core Version:    0.7.0.1
 */