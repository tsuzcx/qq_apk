package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;

public abstract class w
  extends c
{
  public static final String[] INDEX_CREATE = { "CREATE INDEX IF NOT EXISTS AppBrandWxaPkgManifestRecordPkgPathIndex ON AppBrandWxaPkgManifestRecord(pkgPath)" };
  private static final int eEX = "startTime".hashCode();
  private static final int eEY = "endTime".hashCode();
  private static final int eFO;
  private static final int eGD = "appId".hashCode();
  private static final int eHN;
  private static final int eHT = "version".hashCode();
  private static final int eHU;
  private static final int eHV;
  private static final int eHW;
  private static final int eHX;
  private static final int rowid_HASHCODE = "rowid".hashCode();
  private boolean eEQ = true;
  private boolean eER = true;
  private boolean eFr = true;
  private boolean eGm = true;
  private boolean eHM = true;
  private boolean eHO = true;
  private boolean eHP = true;
  private boolean eHQ = true;
  private boolean eHR = true;
  private boolean eHS = true;
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
  
  static
  {
    eHN = "versionMd5".hashCode();
    eHU = "NewMd5".hashCode();
    eHV = "pkgPath".hashCode();
    eFO = "createTime".hashCode();
    eHW = "debugType".hashCode();
    eHX = "downloadURL".hashCode();
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
      if (eGD != k) {
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
      if (eHT == k) {
        this.field_version = paramCursor.getInt(i);
      } else if (eHN == k) {
        this.field_versionMd5 = paramCursor.getString(i);
      } else if (eHU == k) {
        this.field_NewMd5 = paramCursor.getString(i);
      } else if (eHV == k) {
        this.field_pkgPath = paramCursor.getString(i);
      } else if (eFO == k) {
        this.field_createTime = paramCursor.getLong(i);
      } else if (eHW == k) {
        this.field_debugType = paramCursor.getInt(i);
      } else if (eHX == k) {
        this.field_downloadURL = paramCursor.getString(i);
      } else if (eEX == k) {
        this.field_startTime = paramCursor.getLong(i);
      } else if (eEY == k) {
        this.field_endTime = paramCursor.getLong(i);
      } else if (rowid_HASHCODE == k) {
        this.systemRowid = paramCursor.getLong(i);
      }
    }
  }
  
  public ContentValues convertTo()
  {
    ContentValues localContentValues = new ContentValues();
    if (this.eGm) {
      localContentValues.put("appId", this.field_appId);
    }
    if (this.eHO) {
      localContentValues.put("version", Integer.valueOf(this.field_version));
    }
    if (this.eHM) {
      localContentValues.put("versionMd5", this.field_versionMd5);
    }
    if (this.eHP) {
      localContentValues.put("NewMd5", this.field_NewMd5);
    }
    if (this.eHQ) {
      localContentValues.put("pkgPath", this.field_pkgPath);
    }
    if (this.eFr) {
      localContentValues.put("createTime", Long.valueOf(this.field_createTime));
    }
    if (this.eHR) {
      localContentValues.put("debugType", Integer.valueOf(this.field_debugType));
    }
    if (this.eHS) {
      localContentValues.put("downloadURL", this.field_downloadURL);
    }
    if (this.eEQ) {
      localContentValues.put("startTime", Long.valueOf(this.field_startTime));
    }
    if (this.eER) {
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