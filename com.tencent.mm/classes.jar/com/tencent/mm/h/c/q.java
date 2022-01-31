package com.tencent.mm.h.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;

public abstract class q
  extends c
{
  public static final String[] cqY = { "CREATE INDEX IF NOT EXISTS AppBrandWxaPkgManifestRecordPkgPathIndex ON AppBrandWxaPkgManifestRecord(pkgPath)" };
  private static final int crB = "startTime".hashCode();
  private static final int crC = "endTime".hashCode();
  private static final int crh = "rowid".hashCode();
  private static final int csv;
  private static final int ctl = "appId".hashCode();
  private static final int cuA;
  private static final int cuv = "version".hashCode();
  private static final int cuw = "versionMd5".hashCode();
  private static final int cux = "versionState".hashCode();
  private static final int cuy = "pkgPath".hashCode();
  private static final int cuz;
  private boolean crX = true;
  private boolean crt = true;
  private boolean cru = true;
  private boolean csU = true;
  private boolean cup = true;
  private boolean cuq = true;
  private boolean cur = true;
  private boolean cus = true;
  private boolean cut = true;
  private boolean cuu = true;
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
    csv = "createTime".hashCode();
    cuz = "debugType".hashCode();
    cuA = "downloadURL".hashCode();
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
      if (ctl != k) {
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
      if (cuv == k) {
        this.field_version = paramCursor.getInt(i);
      } else if (cuw == k) {
        this.field_versionMd5 = paramCursor.getString(i);
      } else if (cux == k) {
        this.field_versionState = paramCursor.getInt(i);
      } else if (cuy == k) {
        this.field_pkgPath = paramCursor.getString(i);
      } else if (csv == k) {
        this.field_createTime = paramCursor.getLong(i);
      } else if (cuz == k) {
        this.field_debugType = paramCursor.getInt(i);
      } else if (cuA == k) {
        this.field_downloadURL = paramCursor.getString(i);
      } else if (crB == k) {
        this.field_startTime = paramCursor.getLong(i);
      } else if (crC == k) {
        this.field_endTime = paramCursor.getLong(i);
      } else if (crh == k) {
        this.ujK = paramCursor.getLong(i);
      }
    }
  }
  
  public final ContentValues vf()
  {
    ContentValues localContentValues = new ContentValues();
    if (this.csU) {
      localContentValues.put("appId", this.field_appId);
    }
    if (this.cup) {
      localContentValues.put("version", Integer.valueOf(this.field_version));
    }
    if (this.cuq) {
      localContentValues.put("versionMd5", this.field_versionMd5);
    }
    if (this.cur) {
      localContentValues.put("versionState", Integer.valueOf(this.field_versionState));
    }
    if (this.cus) {
      localContentValues.put("pkgPath", this.field_pkgPath);
    }
    if (this.crX) {
      localContentValues.put("createTime", Long.valueOf(this.field_createTime));
    }
    if (this.cut) {
      localContentValues.put("debugType", Integer.valueOf(this.field_debugType));
    }
    if (this.cuu) {
      localContentValues.put("downloadURL", this.field_downloadURL);
    }
    if (this.crt) {
      localContentValues.put("startTime", Long.valueOf(this.field_startTime));
    }
    if (this.cru) {
      localContentValues.put("endTime", Long.valueOf(this.field_endTime));
    }
    if (this.ujK > 0L) {
      localContentValues.put("rowid", Long.valueOf(this.ujK));
    }
    return localContentValues;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.h.c.q
 * JD-Core Version:    0.7.0.1
 */