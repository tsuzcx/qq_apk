package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;

public abstract class hb
  extends c
{
  public static final String[] INDEX_CREATE = new String[0];
  private static final int eHT;
  private static final int eOL = "downloadUrl".hashCode();
  private static final int eUA;
  private static final int fCl = "pkgId".hashCode();
  private static final int fCm;
  private static final int fCn;
  private static final int fCo = "pkgSize".hashCode();
  private static final int fCp = "downloadNetType".hashCode();
  private static final int rowid_HASHCODE = "rowid".hashCode();
  private boolean eHO = true;
  private boolean eOD = true;
  private boolean eTO = true;
  private boolean fCg = true;
  private boolean fCh = true;
  private boolean fCi = true;
  private boolean fCj = true;
  private boolean fCk = true;
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
    eHT = "version".hashCode();
    fCm = "oldVersion".hashCode();
    fCn = "oldPath".hashCode();
    eUA = "md5".hashCode();
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
      if (fCl != k) {
        break label65;
      }
      this.field_pkgId = paramCursor.getString(i);
      this.fCg = true;
    }
    for (;;)
    {
      i += 1;
      break label20;
      break;
      label65:
      if (eHT == k) {
        this.field_version = paramCursor.getString(i);
      } else if (fCm == k) {
        this.field_oldVersion = paramCursor.getString(i);
      } else if (fCn == k) {
        this.field_oldPath = paramCursor.getString(i);
      } else if (eUA == k) {
        this.field_md5 = paramCursor.getString(i);
      } else if (eOL == k) {
        this.field_downloadUrl = paramCursor.getString(i);
      } else if (fCo == k) {
        this.field_pkgSize = paramCursor.getInt(i);
      } else if (fCp == k) {
        this.field_downloadNetType = paramCursor.getInt(i);
      } else if (rowid_HASHCODE == k) {
        this.systemRowid = paramCursor.getLong(i);
      }
    }
  }
  
  public ContentValues convertTo()
  {
    ContentValues localContentValues = new ContentValues();
    if (this.fCg) {
      localContentValues.put("pkgId", this.field_pkgId);
    }
    if (this.eHO) {
      localContentValues.put("version", this.field_version);
    }
    if (this.fCh) {
      localContentValues.put("oldVersion", this.field_oldVersion);
    }
    if (this.fCi) {
      localContentValues.put("oldPath", this.field_oldPath);
    }
    if (this.eTO) {
      localContentValues.put("md5", this.field_md5);
    }
    if (this.eOD) {
      localContentValues.put("downloadUrl", this.field_downloadUrl);
    }
    if (this.fCj) {
      localContentValues.put("pkgSize", Integer.valueOf(this.field_pkgSize));
    }
    if (this.fCk) {
      localContentValues.put("downloadNetType", Integer.valueOf(this.field_downloadNetType));
    }
    if (this.systemRowid > 0L) {
      localContentValues.put("rowid", Long.valueOf(this.systemRowid));
    }
    return localContentValues;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.g.c.hb
 * JD-Core Version:    0.7.0.1
 */