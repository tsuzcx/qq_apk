package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;

public abstract class gm
  extends c
{
  public static final String[] INDEX_CREATE = new String[0];
  private static final int emV;
  private static final int etz = "downloadUrl".hashCode();
  private static final int eyX;
  private static final int feL = "pkgId".hashCode();
  private static final int feM;
  private static final int feN;
  private static final int feO = "pkgSize".hashCode();
  private static final int feP = "downloadNetType".hashCode();
  private static final int rowid_HASHCODE = "rowid".hashCode();
  private boolean emQ = true;
  private boolean etr = true;
  private boolean eyl = true;
  private boolean feG = true;
  private boolean feH = true;
  private boolean feI = true;
  private boolean feJ = true;
  private boolean feK = true;
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
    emV = "version".hashCode();
    feM = "oldVersion".hashCode();
    feN = "oldPath".hashCode();
    eyX = "md5".hashCode();
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
      if (feL != k) {
        break label65;
      }
      this.field_pkgId = paramCursor.getString(i);
      this.feG = true;
    }
    for (;;)
    {
      i += 1;
      break label20;
      break;
      label65:
      if (emV == k) {
        this.field_version = paramCursor.getString(i);
      } else if (feM == k) {
        this.field_oldVersion = paramCursor.getString(i);
      } else if (feN == k) {
        this.field_oldPath = paramCursor.getString(i);
      } else if (eyX == k) {
        this.field_md5 = paramCursor.getString(i);
      } else if (etz == k) {
        this.field_downloadUrl = paramCursor.getString(i);
      } else if (feO == k) {
        this.field_pkgSize = paramCursor.getInt(i);
      } else if (feP == k) {
        this.field_downloadNetType = paramCursor.getInt(i);
      } else if (rowid_HASHCODE == k) {
        this.systemRowid = paramCursor.getLong(i);
      }
    }
  }
  
  public ContentValues convertTo()
  {
    ContentValues localContentValues = new ContentValues();
    if (this.feG) {
      localContentValues.put("pkgId", this.field_pkgId);
    }
    if (this.emQ) {
      localContentValues.put("version", this.field_version);
    }
    if (this.feH) {
      localContentValues.put("oldVersion", this.field_oldVersion);
    }
    if (this.feI) {
      localContentValues.put("oldPath", this.field_oldPath);
    }
    if (this.eyl) {
      localContentValues.put("md5", this.field_md5);
    }
    if (this.etr) {
      localContentValues.put("downloadUrl", this.field_downloadUrl);
    }
    if (this.feJ) {
      localContentValues.put("pkgSize", Integer.valueOf(this.field_pkgSize));
    }
    if (this.feK) {
      localContentValues.put("downloadNetType", Integer.valueOf(this.field_downloadNetType));
    }
    if (this.systemRowid > 0L) {
      localContentValues.put("rowid", Long.valueOf(this.systemRowid));
    }
    return localContentValues;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.g.c.gm
 * JD-Core Version:    0.7.0.1
 */