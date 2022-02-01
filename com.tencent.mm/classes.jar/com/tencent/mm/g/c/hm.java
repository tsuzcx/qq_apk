package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.storage.IAutoDBItem;

public abstract class hm
  extends IAutoDBItem
{
  public static final String[] INDEX_CREATE = new String[0];
  private static final int flv;
  private static final int fss = "downloadUrl".hashCode();
  private static final int fyf;
  private static final int ghj = "pkgId".hashCode();
  private static final int ghk;
  private static final int ghl;
  private static final int ghm = "pkgSize".hashCode();
  private static final int ghn = "downloadNetType".hashCode();
  private static final int rowid_HASHCODE = "rowid".hashCode();
  public int field_downloadNetType;
  public String field_downloadUrl;
  public String field_md5;
  public String field_oldPath;
  public String field_oldVersion;
  public String field_pkgId;
  public int field_pkgSize;
  public String field_version;
  private boolean flq = true;
  private boolean fsk = true;
  private boolean fxt = true;
  private boolean ghe = true;
  private boolean ghf = true;
  private boolean ghg = true;
  private boolean ghh = true;
  private boolean ghi = true;
  
  static
  {
    flv = "version".hashCode();
    ghk = "oldVersion".hashCode();
    ghl = "oldPath".hashCode();
    fyf = "md5".hashCode();
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
      if (ghj != k) {
        break label65;
      }
      this.field_pkgId = paramCursor.getString(i);
      this.ghe = true;
    }
    for (;;)
    {
      i += 1;
      break label20;
      break;
      label65:
      if (flv == k) {
        this.field_version = paramCursor.getString(i);
      } else if (ghk == k) {
        this.field_oldVersion = paramCursor.getString(i);
      } else if (ghl == k) {
        this.field_oldPath = paramCursor.getString(i);
      } else if (fyf == k) {
        this.field_md5 = paramCursor.getString(i);
      } else if (fss == k) {
        this.field_downloadUrl = paramCursor.getString(i);
      } else if (ghm == k) {
        this.field_pkgSize = paramCursor.getInt(i);
      } else if (ghn == k) {
        this.field_downloadNetType = paramCursor.getInt(i);
      } else if (rowid_HASHCODE == k) {
        this.systemRowid = paramCursor.getLong(i);
      }
    }
  }
  
  public ContentValues convertTo()
  {
    ContentValues localContentValues = new ContentValues();
    if (this.ghe) {
      localContentValues.put("pkgId", this.field_pkgId);
    }
    if (this.flq) {
      localContentValues.put("version", this.field_version);
    }
    if (this.ghf) {
      localContentValues.put("oldVersion", this.field_oldVersion);
    }
    if (this.ghg) {
      localContentValues.put("oldPath", this.field_oldPath);
    }
    if (this.fxt) {
      localContentValues.put("md5", this.field_md5);
    }
    if (this.fsk) {
      localContentValues.put("downloadUrl", this.field_downloadUrl);
    }
    if (this.ghh) {
      localContentValues.put("pkgSize", Integer.valueOf(this.field_pkgSize));
    }
    if (this.ghi) {
      localContentValues.put("downloadNetType", Integer.valueOf(this.field_downloadNetType));
    }
    if (this.systemRowid > 0L) {
      localContentValues.put("rowid", Long.valueOf(this.systemRowid));
    }
    return localContentValues;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.g.c.hm
 * JD-Core Version:    0.7.0.1
 */