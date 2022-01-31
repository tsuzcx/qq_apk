package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;

public abstract class fo
  extends c
{
  public static final String[] INDEX_CREATE = new String[0];
  private static final int dVs = "pkgId".hashCode();
  private static final int dVt;
  private static final int dVu;
  private static final int dVv = "pkgSize".hashCode();
  private static final int dVw = "downloadNetType".hashCode();
  private static final int diB = "version".hashCode();
  private static final int doI;
  private static final int dtX;
  private static final int rowid_HASHCODE = "rowid".hashCode();
  private boolean dVn = true;
  private boolean dVo = true;
  private boolean dVp = true;
  private boolean dVq = true;
  private boolean dVr = true;
  private boolean div = true;
  private boolean doA = true;
  private boolean dtk = true;
  public int field_downloadNetType;
  public String field_downloadUrl;
  public String field_md5;
  public String field_oldPath;
  public String field_oldVersion;
  public String field_pkgId;
  public int field_pkgSize;
  public String field_version;
  
  static
  {
    dVt = "oldVersion".hashCode();
    dVu = "oldPath".hashCode();
    dtX = "md5".hashCode();
    doI = "downloadUrl".hashCode();
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
      if (dVs != k) {
        break label65;
      }
      this.field_pkgId = paramCursor.getString(i);
      this.dVn = true;
    }
    for (;;)
    {
      i += 1;
      break label20;
      break;
      label65:
      if (diB == k) {
        this.field_version = paramCursor.getString(i);
      } else if (dVt == k) {
        this.field_oldVersion = paramCursor.getString(i);
      } else if (dVu == k) {
        this.field_oldPath = paramCursor.getString(i);
      } else if (dtX == k) {
        this.field_md5 = paramCursor.getString(i);
      } else if (doI == k) {
        this.field_downloadUrl = paramCursor.getString(i);
      } else if (dVv == k) {
        this.field_pkgSize = paramCursor.getInt(i);
      } else if (dVw == k) {
        this.field_downloadNetType = paramCursor.getInt(i);
      } else if (rowid_HASHCODE == k) {
        this.systemRowid = paramCursor.getLong(i);
      }
    }
  }
  
  public ContentValues convertTo()
  {
    ContentValues localContentValues = new ContentValues();
    if (this.dVn) {
      localContentValues.put("pkgId", this.field_pkgId);
    }
    if (this.div) {
      localContentValues.put("version", this.field_version);
    }
    if (this.dVo) {
      localContentValues.put("oldVersion", this.field_oldVersion);
    }
    if (this.dVp) {
      localContentValues.put("oldPath", this.field_oldPath);
    }
    if (this.dtk) {
      localContentValues.put("md5", this.field_md5);
    }
    if (this.doA) {
      localContentValues.put("downloadUrl", this.field_downloadUrl);
    }
    if (this.dVq) {
      localContentValues.put("pkgSize", Integer.valueOf(this.field_pkgSize));
    }
    if (this.dVr) {
      localContentValues.put("downloadNetType", Integer.valueOf(this.field_downloadNetType));
    }
    if (this.systemRowid > 0L) {
      localContentValues.put("rowid", Long.valueOf(this.systemRowid));
    }
    return localContentValues;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.g.c.fo
 * JD-Core Version:    0.7.0.1
 */