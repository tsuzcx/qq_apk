package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.storage.IAutoDBItem;

public abstract class w
  extends IAutoDBItem
{
  public static final String[] INDEX_CREATE = { "CREATE INDEX IF NOT EXISTS AppBrandWxaPkgManifestRecordPkgPathIndex ON AppBrandWxaPkgManifestRecord(pkgPath)" };
  private static final int createTime_HASHCODE;
  private static final int fjx = "startTime".hashCode();
  private static final int fjy = "endTime".hashCode();
  private static final int fkj = "appId".hashCode();
  private static final int flp;
  private static final int flv = "version".hashCode();
  private static final int flw;
  private static final int flx;
  private static final int fly;
  private static final int flz;
  private static final int rowid_HASHCODE = "rowid".hashCode();
  private boolean __hadSetcreateTime = true;
  public String field_NewMd5;
  public String field_appId;
  public long field_createTime;
  public int field_debugType;
  public String field_downloadURL;
  public long field_endTime;
  public String field_pkgPath;
  public long field_startTime;
  public int field_version;
  public String field_versionMd5;
  private boolean fjS = true;
  private boolean fjq = true;
  private boolean fjr = true;
  private boolean flo = true;
  private boolean flq = true;
  private boolean flr = true;
  private boolean fls = true;
  private boolean flt = true;
  private boolean flu = true;
  
  static
  {
    flp = "versionMd5".hashCode();
    flw = "NewMd5".hashCode();
    flx = "pkgPath".hashCode();
    createTime_HASHCODE = "createTime".hashCode();
    fly = "debugType".hashCode();
    flz = "downloadURL".hashCode();
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
      if (flv == k) {
        this.field_version = paramCursor.getInt(i);
      } else if (flp == k) {
        this.field_versionMd5 = paramCursor.getString(i);
      } else if (flw == k) {
        this.field_NewMd5 = paramCursor.getString(i);
      } else if (flx == k) {
        this.field_pkgPath = paramCursor.getString(i);
      } else if (createTime_HASHCODE == k) {
        this.field_createTime = paramCursor.getLong(i);
      } else if (fly == k) {
        this.field_debugType = paramCursor.getInt(i);
      } else if (flz == k) {
        this.field_downloadURL = paramCursor.getString(i);
      } else if (fjx == k) {
        this.field_startTime = paramCursor.getLong(i);
      } else if (fjy == k) {
        this.field_endTime = paramCursor.getLong(i);
      } else if (rowid_HASHCODE == k) {
        this.systemRowid = paramCursor.getLong(i);
      }
    }
  }
  
  public ContentValues convertTo()
  {
    ContentValues localContentValues = new ContentValues();
    if (this.fjS) {
      localContentValues.put("appId", this.field_appId);
    }
    if (this.flq) {
      localContentValues.put("version", Integer.valueOf(this.field_version));
    }
    if (this.flo) {
      localContentValues.put("versionMd5", this.field_versionMd5);
    }
    if (this.flr) {
      localContentValues.put("NewMd5", this.field_NewMd5);
    }
    if (this.fls) {
      localContentValues.put("pkgPath", this.field_pkgPath);
    }
    if (this.__hadSetcreateTime) {
      localContentValues.put("createTime", Long.valueOf(this.field_createTime));
    }
    if (this.flt) {
      localContentValues.put("debugType", Integer.valueOf(this.field_debugType));
    }
    if (this.flu) {
      localContentValues.put("downloadURL", this.field_downloadURL);
    }
    if (this.fjq) {
      localContentValues.put("startTime", Long.valueOf(this.field_startTime));
    }
    if (this.fjr) {
      localContentValues.put("endTime", Long.valueOf(this.field_endTime));
    }
    if (this.systemRowid > 0L) {
      localContentValues.put("rowid", Long.valueOf(this.systemRowid));
    }
    return localContentValues;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.g.c.w
 * JD-Core Version:    0.7.0.1
 */