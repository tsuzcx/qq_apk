package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;

public abstract class w
  extends c
{
  public static final String[] INDEX_CREATE = { "CREATE INDEX IF NOT EXISTS AppBrandWxaPkgManifestRecordPkgPathIndex ON AppBrandWxaPkgManifestRecord(pkgPath)" };
  private static final int emY;
  private static final int emh = "startTime".hashCode();
  private static final int emi = "endTime".hashCode();
  private static final int enO = "appId".hashCode();
  private static final int eoV;
  private static final int epb = "version".hashCode();
  private static final int epc;
  private static final int epd;
  private static final int epe;
  private static final int epf;
  private static final int rowid_HASHCODE = "rowid".hashCode();
  private boolean emB = true;
  private boolean ema = true;
  private boolean emb = true;
  private boolean enx = true;
  private boolean eoU = true;
  private boolean eoW = true;
  private boolean eoX = true;
  private boolean eoY = true;
  private boolean eoZ = true;
  private boolean epa = true;
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
    eoV = "versionMd5".hashCode();
    epc = "NewMd5".hashCode();
    epd = "pkgPath".hashCode();
    emY = "createTime".hashCode();
    epe = "debugType".hashCode();
    epf = "downloadURL".hashCode();
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
      if (enO != k) {
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
      if (epb == k) {
        this.field_version = paramCursor.getInt(i);
      } else if (eoV == k) {
        this.field_versionMd5 = paramCursor.getString(i);
      } else if (epc == k) {
        this.field_NewMd5 = paramCursor.getString(i);
      } else if (epd == k) {
        this.field_pkgPath = paramCursor.getString(i);
      } else if (emY == k) {
        this.field_createTime = paramCursor.getLong(i);
      } else if (epe == k) {
        this.field_debugType = paramCursor.getInt(i);
      } else if (epf == k) {
        this.field_downloadURL = paramCursor.getString(i);
      } else if (emh == k) {
        this.field_startTime = paramCursor.getLong(i);
      } else if (emi == k) {
        this.field_endTime = paramCursor.getLong(i);
      } else if (rowid_HASHCODE == k) {
        this.systemRowid = paramCursor.getLong(i);
      }
    }
  }
  
  public ContentValues convertTo()
  {
    ContentValues localContentValues = new ContentValues();
    if (this.enx) {
      localContentValues.put("appId", this.field_appId);
    }
    if (this.eoW) {
      localContentValues.put("version", Integer.valueOf(this.field_version));
    }
    if (this.eoU) {
      localContentValues.put("versionMd5", this.field_versionMd5);
    }
    if (this.eoX) {
      localContentValues.put("NewMd5", this.field_NewMd5);
    }
    if (this.eoY) {
      localContentValues.put("pkgPath", this.field_pkgPath);
    }
    if (this.emB) {
      localContentValues.put("createTime", Long.valueOf(this.field_createTime));
    }
    if (this.eoZ) {
      localContentValues.put("debugType", Integer.valueOf(this.field_debugType));
    }
    if (this.epa) {
      localContentValues.put("downloadURL", this.field_downloadURL);
    }
    if (this.ema) {
      localContentValues.put("startTime", Long.valueOf(this.field_startTime));
    }
    if (this.emb) {
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