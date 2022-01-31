package com.tencent.mm.h.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;

public abstract class ek
  extends c
{
  private static final int cAF = "downloadUrl".hashCode();
  private static final int cAH;
  private static final int cFC;
  private static final int cTS = "reportId".hashCode();
  private static final int cZr;
  private static final int cZs;
  private static final int cZt = "FullVersion".hashCode();
  private static final int cZu = "downloadTime".hashCode();
  public static final String[] cqY = new String[0];
  private static final int crh = "rowid".hashCode();
  private static final int cuv;
  private boolean cAx = true;
  private boolean cAz = true;
  private boolean cEZ = true;
  private boolean cTP = true;
  private boolean cZn = true;
  private boolean cZo = true;
  private boolean cZp = true;
  private boolean cZq = true;
  private boolean cup = true;
  public String field_FullVersion;
  public long field_downloadTime;
  public String field_downloadUrl;
  public String field_filePath;
  public String field_md5;
  public int field_reportId;
  public String field_tmplName;
  public int field_version;
  public int field_versionLowerBound;
  
  static
  {
    cZr = "tmplName".hashCode();
    cuv = "version".hashCode();
    cFC = "md5".hashCode();
    cAH = "filePath".hashCode();
    cZs = "versionLowerBound".hashCode();
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
      if (cZr != k) {
        break label65;
      }
      this.field_tmplName = paramCursor.getString(i);
      this.cZn = true;
    }
    for (;;)
    {
      i += 1;
      break label20;
      break;
      label65:
      if (cuv == k) {
        this.field_version = paramCursor.getInt(i);
      } else if (cFC == k) {
        this.field_md5 = paramCursor.getString(i);
      } else if (cAH == k) {
        this.field_filePath = paramCursor.getString(i);
      } else if (cZs == k) {
        this.field_versionLowerBound = paramCursor.getInt(i);
      } else if (cAF == k) {
        this.field_downloadUrl = paramCursor.getString(i);
      } else if (cTS == k) {
        this.field_reportId = paramCursor.getInt(i);
      } else if (cZt == k) {
        this.field_FullVersion = paramCursor.getString(i);
      } else if (cZu == k) {
        this.field_downloadTime = paramCursor.getLong(i);
      } else if (crh == k) {
        this.ujK = paramCursor.getLong(i);
      }
    }
  }
  
  public final ContentValues vf()
  {
    ContentValues localContentValues = new ContentValues();
    if (this.cZn) {
      localContentValues.put("tmplName", this.field_tmplName);
    }
    if (this.cup) {
      localContentValues.put("version", Integer.valueOf(this.field_version));
    }
    if (this.cEZ) {
      localContentValues.put("md5", this.field_md5);
    }
    if (this.cAz) {
      localContentValues.put("filePath", this.field_filePath);
    }
    if (this.cZo) {
      localContentValues.put("versionLowerBound", Integer.valueOf(this.field_versionLowerBound));
    }
    if (this.cAx) {
      localContentValues.put("downloadUrl", this.field_downloadUrl);
    }
    if (this.cTP) {
      localContentValues.put("reportId", Integer.valueOf(this.field_reportId));
    }
    if (this.cZp) {
      localContentValues.put("FullVersion", this.field_FullVersion);
    }
    if (this.cZq) {
      localContentValues.put("downloadTime", Long.valueOf(this.field_downloadTime));
    }
    if (this.ujK > 0L) {
      localContentValues.put("rowid", Long.valueOf(this.ujK));
    }
    return localContentValues;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.h.c.ek
 * JD-Core Version:    0.7.0.1
 */