package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;

public abstract class ha
  extends c
{
  public static final String[] INDEX_CREATE = new String[0];
  private static final int eGk;
  private static final int eNa = "downloadUrl".hashCode();
  private static final int eSP;
  private static final int fAl = "pkgId".hashCode();
  private static final int fAm;
  private static final int fAn;
  private static final int fAo = "pkgSize".hashCode();
  private static final int fAp = "downloadNetType".hashCode();
  private static final int rowid_HASHCODE = "rowid".hashCode();
  private boolean eGf = true;
  private boolean eMS = true;
  private boolean eSd = true;
  private boolean fAg = true;
  private boolean fAh = true;
  private boolean fAi = true;
  private boolean fAj = true;
  private boolean fAk = true;
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
    eGk = "version".hashCode();
    fAm = "oldVersion".hashCode();
    fAn = "oldPath".hashCode();
    eSP = "md5".hashCode();
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
      if (fAl != k) {
        break label65;
      }
      this.field_pkgId = paramCursor.getString(i);
      this.fAg = true;
    }
    for (;;)
    {
      i += 1;
      break label20;
      break;
      label65:
      if (eGk == k) {
        this.field_version = paramCursor.getString(i);
      } else if (fAm == k) {
        this.field_oldVersion = paramCursor.getString(i);
      } else if (fAn == k) {
        this.field_oldPath = paramCursor.getString(i);
      } else if (eSP == k) {
        this.field_md5 = paramCursor.getString(i);
      } else if (eNa == k) {
        this.field_downloadUrl = paramCursor.getString(i);
      } else if (fAo == k) {
        this.field_pkgSize = paramCursor.getInt(i);
      } else if (fAp == k) {
        this.field_downloadNetType = paramCursor.getInt(i);
      } else if (rowid_HASHCODE == k) {
        this.systemRowid = paramCursor.getLong(i);
      }
    }
  }
  
  public ContentValues convertTo()
  {
    ContentValues localContentValues = new ContentValues();
    if (this.fAg) {
      localContentValues.put("pkgId", this.field_pkgId);
    }
    if (this.eGf) {
      localContentValues.put("version", this.field_version);
    }
    if (this.fAh) {
      localContentValues.put("oldVersion", this.field_oldVersion);
    }
    if (this.fAi) {
      localContentValues.put("oldPath", this.field_oldPath);
    }
    if (this.eSd) {
      localContentValues.put("md5", this.field_md5);
    }
    if (this.eMS) {
      localContentValues.put("downloadUrl", this.field_downloadUrl);
    }
    if (this.fAj) {
      localContentValues.put("pkgSize", Integer.valueOf(this.field_pkgSize));
    }
    if (this.fAk) {
      localContentValues.put("downloadNetType", Integer.valueOf(this.field_downloadNetType));
    }
    if (this.systemRowid > 0L) {
      localContentValues.put("rowid", Long.valueOf(this.systemRowid));
    }
    return localContentValues;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.g.c.ha
 * JD-Core Version:    0.7.0.1
 */