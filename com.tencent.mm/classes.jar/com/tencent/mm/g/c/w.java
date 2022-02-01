package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;

public abstract class w
  extends c
{
  public static final String[] INDEX_CREATE = { "CREATE INDEX IF NOT EXISTS AppBrandWxaPkgManifestRecordPkgPathIndex ON AppBrandWxaPkgManifestRecord(pkgPath)" };
  private static final int eDo = "startTime".hashCode();
  private static final int eDp = "endTime".hashCode();
  private static final int eEU = "appId".hashCode();
  private static final int eEf;
  private static final int eGe;
  private static final int eGk = "version".hashCode();
  private static final int eGl;
  private static final int eGm;
  private static final int eGn;
  private static final int eGo;
  private static final int rowid_HASHCODE = "rowid".hashCode();
  private boolean eDI = true;
  private boolean eDh = true;
  private boolean eDi = true;
  private boolean eED = true;
  private boolean eGd = true;
  private boolean eGf = true;
  private boolean eGg = true;
  private boolean eGh = true;
  private boolean eGi = true;
  private boolean eGj = true;
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
    eGe = "versionMd5".hashCode();
    eGl = "NewMd5".hashCode();
    eGm = "pkgPath".hashCode();
    eEf = "createTime".hashCode();
    eGn = "debugType".hashCode();
    eGo = "downloadURL".hashCode();
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
      if (eEU != k) {
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
      if (eGk == k) {
        this.field_version = paramCursor.getInt(i);
      } else if (eGe == k) {
        this.field_versionMd5 = paramCursor.getString(i);
      } else if (eGl == k) {
        this.field_NewMd5 = paramCursor.getString(i);
      } else if (eGm == k) {
        this.field_pkgPath = paramCursor.getString(i);
      } else if (eEf == k) {
        this.field_createTime = paramCursor.getLong(i);
      } else if (eGn == k) {
        this.field_debugType = paramCursor.getInt(i);
      } else if (eGo == k) {
        this.field_downloadURL = paramCursor.getString(i);
      } else if (eDo == k) {
        this.field_startTime = paramCursor.getLong(i);
      } else if (eDp == k) {
        this.field_endTime = paramCursor.getLong(i);
      } else if (rowid_HASHCODE == k) {
        this.systemRowid = paramCursor.getLong(i);
      }
    }
  }
  
  public ContentValues convertTo()
  {
    ContentValues localContentValues = new ContentValues();
    if (this.eED) {
      localContentValues.put("appId", this.field_appId);
    }
    if (this.eGf) {
      localContentValues.put("version", Integer.valueOf(this.field_version));
    }
    if (this.eGd) {
      localContentValues.put("versionMd5", this.field_versionMd5);
    }
    if (this.eGg) {
      localContentValues.put("NewMd5", this.field_NewMd5);
    }
    if (this.eGh) {
      localContentValues.put("pkgPath", this.field_pkgPath);
    }
    if (this.eDI) {
      localContentValues.put("createTime", Long.valueOf(this.field_createTime));
    }
    if (this.eGi) {
      localContentValues.put("debugType", Integer.valueOf(this.field_debugType));
    }
    if (this.eGj) {
      localContentValues.put("downloadURL", this.field_downloadURL);
    }
    if (this.eDh) {
      localContentValues.put("startTime", Long.valueOf(this.field_startTime));
    }
    if (this.eDi) {
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