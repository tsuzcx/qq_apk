package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;

public abstract class w
  extends c
{
  public static final String[] INDEX_CREATE = { "CREATE INDEX IF NOT EXISTS AppBrandWxaPkgManifestRecordPkgPathIndex ON AppBrandWxaPkgManifestRecord(pkgPath)" };
  private static final int ekU;
  private static final int ekd = "startTime".hashCode();
  private static final int eke = "endTime".hashCode();
  private static final int elJ = "appId".hashCode();
  private static final int emP;
  private static final int emV = "version".hashCode();
  private static final int emW;
  private static final int emX;
  private static final int emY;
  private static final int emZ;
  private static final int rowid_HASHCODE = "rowid".hashCode();
  private boolean ejW = true;
  private boolean ejX = true;
  private boolean ekx = true;
  private boolean els = true;
  private boolean emO = true;
  private boolean emQ = true;
  private boolean emR = true;
  private boolean emS = true;
  private boolean emT = true;
  private boolean emU = true;
  public String field_appId;
  public long field_createTime;
  public int field_debugType;
  public String field_downloadURL;
  public long field_endTime;
  public String field_pkgPath;
  public long field_startTime;
  public int field_version;
  public String field_versionMd5;
  public int field_versionState;
  
  static
  {
    emP = "versionMd5".hashCode();
    emW = "versionState".hashCode();
    emX = "pkgPath".hashCode();
    ekU = "createTime".hashCode();
    emY = "debugType".hashCode();
    emZ = "downloadURL".hashCode();
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
      if (elJ != k) {
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
      if (emV == k) {
        this.field_version = paramCursor.getInt(i);
      } else if (emP == k) {
        this.field_versionMd5 = paramCursor.getString(i);
      } else if (emW == k) {
        this.field_versionState = paramCursor.getInt(i);
      } else if (emX == k) {
        this.field_pkgPath = paramCursor.getString(i);
      } else if (ekU == k) {
        this.field_createTime = paramCursor.getLong(i);
      } else if (emY == k) {
        this.field_debugType = paramCursor.getInt(i);
      } else if (emZ == k) {
        this.field_downloadURL = paramCursor.getString(i);
      } else if (ekd == k) {
        this.field_startTime = paramCursor.getLong(i);
      } else if (eke == k) {
        this.field_endTime = paramCursor.getLong(i);
      } else if (rowid_HASHCODE == k) {
        this.systemRowid = paramCursor.getLong(i);
      }
    }
  }
  
  public ContentValues convertTo()
  {
    ContentValues localContentValues = new ContentValues();
    if (this.els) {
      localContentValues.put("appId", this.field_appId);
    }
    if (this.emQ) {
      localContentValues.put("version", Integer.valueOf(this.field_version));
    }
    if (this.emO) {
      localContentValues.put("versionMd5", this.field_versionMd5);
    }
    if (this.emR) {
      localContentValues.put("versionState", Integer.valueOf(this.field_versionState));
    }
    if (this.emS) {
      localContentValues.put("pkgPath", this.field_pkgPath);
    }
    if (this.ekx) {
      localContentValues.put("createTime", Long.valueOf(this.field_createTime));
    }
    if (this.emT) {
      localContentValues.put("debugType", Integer.valueOf(this.field_debugType));
    }
    if (this.emU) {
      localContentValues.put("downloadURL", this.field_downloadURL);
    }
    if (this.ejW) {
      localContentValues.put("startTime", Long.valueOf(this.field_startTime));
    }
    if (this.ejX) {
      localContentValues.put("endTime", Long.valueOf(this.field_endTime));
    }
    if (this.systemRowid > 0L) {
      localContentValues.put("rowid", Long.valueOf(this.systemRowid));
    }
    return localContentValues;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.g.c.w
 * JD-Core Version:    0.7.0.1
 */