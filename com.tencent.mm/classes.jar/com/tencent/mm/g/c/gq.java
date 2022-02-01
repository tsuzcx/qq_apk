package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;

public abstract class gq
  extends c
{
  public static final String[] INDEX_CREATE = new String[0];
  private static final int eBr = "md5".hashCode();
  private static final int epb;
  private static final int evD = "downloadUrl".hashCode();
  private static final int fid = "pkgId".hashCode();
  private static final int fie;
  private static final int fif;
  private static final int fig = "pkgSize".hashCode();
  private static final int fih = "downloadNetType".hashCode();
  private static final int rowid_HASHCODE = "rowid".hashCode();
  private boolean eAF = true;
  private boolean eoW = true;
  private boolean evv = true;
  private boolean fhY = true;
  private boolean fhZ = true;
  private boolean fia = true;
  private boolean fib = true;
  private boolean fic = true;
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
    epb = "version".hashCode();
    fie = "oldVersion".hashCode();
    fif = "oldPath".hashCode();
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
      if (fid != k) {
        break label65;
      }
      this.field_pkgId = paramCursor.getString(i);
      this.fhY = true;
    }
    for (;;)
    {
      i += 1;
      break label20;
      break;
      label65:
      if (epb == k) {
        this.field_version = paramCursor.getString(i);
      } else if (fie == k) {
        this.field_oldVersion = paramCursor.getString(i);
      } else if (fif == k) {
        this.field_oldPath = paramCursor.getString(i);
      } else if (eBr == k) {
        this.field_md5 = paramCursor.getString(i);
      } else if (evD == k) {
        this.field_downloadUrl = paramCursor.getString(i);
      } else if (fig == k) {
        this.field_pkgSize = paramCursor.getInt(i);
      } else if (fih == k) {
        this.field_downloadNetType = paramCursor.getInt(i);
      } else if (rowid_HASHCODE == k) {
        this.systemRowid = paramCursor.getLong(i);
      }
    }
  }
  
  public ContentValues convertTo()
  {
    ContentValues localContentValues = new ContentValues();
    if (this.fhY) {
      localContentValues.put("pkgId", this.field_pkgId);
    }
    if (this.eoW) {
      localContentValues.put("version", this.field_version);
    }
    if (this.fhZ) {
      localContentValues.put("oldVersion", this.field_oldVersion);
    }
    if (this.fia) {
      localContentValues.put("oldPath", this.field_oldPath);
    }
    if (this.eAF) {
      localContentValues.put("md5", this.field_md5);
    }
    if (this.evv) {
      localContentValues.put("downloadUrl", this.field_downloadUrl);
    }
    if (this.fib) {
      localContentValues.put("pkgSize", Integer.valueOf(this.field_pkgSize));
    }
    if (this.fic) {
      localContentValues.put("downloadNetType", Integer.valueOf(this.field_downloadNetType));
    }
    if (this.systemRowid > 0L) {
      localContentValues.put("rowid", Long.valueOf(this.systemRowid));
    }
    return localContentValues;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.g.c.gq
 * JD-Core Version:    0.7.0.1
 */