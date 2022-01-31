package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;

public abstract class r
  extends c
{
  public static final String[] INDEX_CREATE = { "CREATE INDEX IF NOT EXISTS AppBrandWxaPkgManifestRecordPkgPathIndex ON AppBrandWxaPkgManifestRecord(pkgPath)" };
  private static final int dfV = "startTime".hashCode();
  private static final int dfW = "endTime".hashCode();
  private static final int dgM;
  private static final int dhB = "appId".hashCode();
  private static final int diB = "version".hashCode();
  private static final int diC = "versionMd5".hashCode();
  private static final int diD = "versionState".hashCode();
  private static final int diE = "pkgPath".hashCode();
  private static final int diF;
  private static final int diG;
  private static final int rowid_HASHCODE = "rowid".hashCode();
  private boolean dfO = true;
  private boolean dfP = true;
  private boolean dgp = true;
  private boolean dhk = true;
  private boolean diA = true;
  private boolean div = true;
  private boolean diw = true;
  private boolean dix = true;
  private boolean diy = true;
  private boolean diz = true;
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
    dgM = "createTime".hashCode();
    diF = "debugType".hashCode();
    diG = "downloadURL".hashCode();
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
      if (dhB != k) {
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
      if (diB == k) {
        this.field_version = paramCursor.getInt(i);
      } else if (diC == k) {
        this.field_versionMd5 = paramCursor.getString(i);
      } else if (diD == k) {
        this.field_versionState = paramCursor.getInt(i);
      } else if (diE == k) {
        this.field_pkgPath = paramCursor.getString(i);
      } else if (dgM == k) {
        this.field_createTime = paramCursor.getLong(i);
      } else if (diF == k) {
        this.field_debugType = paramCursor.getInt(i);
      } else if (diG == k) {
        this.field_downloadURL = paramCursor.getString(i);
      } else if (dfV == k) {
        this.field_startTime = paramCursor.getLong(i);
      } else if (dfW == k) {
        this.field_endTime = paramCursor.getLong(i);
      } else if (rowid_HASHCODE == k) {
        this.systemRowid = paramCursor.getLong(i);
      }
    }
  }
  
  public ContentValues convertTo()
  {
    ContentValues localContentValues = new ContentValues();
    if (this.dhk) {
      localContentValues.put("appId", this.field_appId);
    }
    if (this.div) {
      localContentValues.put("version", Integer.valueOf(this.field_version));
    }
    if (this.diw) {
      localContentValues.put("versionMd5", this.field_versionMd5);
    }
    if (this.dix) {
      localContentValues.put("versionState", Integer.valueOf(this.field_versionState));
    }
    if (this.diy) {
      localContentValues.put("pkgPath", this.field_pkgPath);
    }
    if (this.dgp) {
      localContentValues.put("createTime", Long.valueOf(this.field_createTime));
    }
    if (this.diz) {
      localContentValues.put("debugType", Integer.valueOf(this.field_debugType));
    }
    if (this.diA) {
      localContentValues.put("downloadURL", this.field_downloadURL);
    }
    if (this.dfO) {
      localContentValues.put("startTime", Long.valueOf(this.field_startTime));
    }
    if (this.dfP) {
      localContentValues.put("endTime", Long.valueOf(this.field_endTime));
    }
    if (this.systemRowid > 0L) {
      localContentValues.put("rowid", Long.valueOf(this.systemRowid));
    }
    return localContentValues;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.g.c.r
 * JD-Core Version:    0.7.0.1
 */