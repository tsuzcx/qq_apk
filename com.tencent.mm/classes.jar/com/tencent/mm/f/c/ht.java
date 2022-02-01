package com.tencent.mm.f.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.storage.IAutoDBItem;
import com.tencent.mm.sdk.storage.sql.Column;
import com.tencent.mm.sdk.storage.sql.SingleTable;

public abstract class ht
  extends IAutoDBItem
{
  public static final Column C_ROWID;
  public static final String[] INDEX_CREATE = new String[0];
  public static final SingleTable TABLE = new SingleTable("WePkgDiffPackage");
  public static final Column hGW;
  private static final int hIy = "md5".hashCode();
  public static final Column hpJ;
  public static final Column hpN;
  private static final int hpT;
  private static final int hzQ = "downloadUrl".hashCode();
  public static final Column iJA;
  public static final Column iJB;
  public static final Column iJC;
  private static final int iJI;
  private static final int iJJ;
  private static final int iJK;
  private static final int iJL = "pkgSize".hashCode();
  private static final int iJM = "downloadNetType".hashCode();
  public static final Column iJy;
  public static final Column iJz;
  private static final int rowid_HASHCODE = "rowid".hashCode();
  public int field_downloadNetType;
  public String field_downloadUrl;
  public String field_md5;
  public String field_oldPath;
  public String field_oldVersion;
  public String field_pkgId;
  public int field_pkgSize;
  public String field_version;
  private boolean hHK = true;
  private boolean hpO = true;
  private boolean hzI = true;
  private boolean iJD = true;
  private boolean iJE = true;
  private boolean iJF = true;
  private boolean iJG = true;
  private boolean iJH = true;
  
  static
  {
    C_ROWID = new Column("rowid", "long", "WePkgDiffPackage", "");
    iJy = new Column("pkgid", "string", "WePkgDiffPackage", "");
    hpJ = new Column("version", "string", "WePkgDiffPackage", "");
    iJz = new Column("oldversion", "string", "WePkgDiffPackage", "");
    iJA = new Column("oldpath", "string", "WePkgDiffPackage", "");
    hGW = new Column("md5", "string", "WePkgDiffPackage", "");
    hpN = new Column("downloadurl", "string", "WePkgDiffPackage", "");
    iJB = new Column("pkgsize", "int", "WePkgDiffPackage", "");
    iJC = new Column("downloadnettype", "int", "WePkgDiffPackage", "");
    iJI = "pkgId".hashCode();
    hpT = "version".hashCode();
    iJJ = "oldVersion".hashCode();
    iJK = "oldPath".hashCode();
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
      if (iJI != k) {
        break label65;
      }
      this.field_pkgId = paramCursor.getString(i);
      this.iJD = true;
    }
    for (;;)
    {
      i += 1;
      break label20;
      break;
      label65:
      if (hpT == k) {
        this.field_version = paramCursor.getString(i);
      } else if (iJJ == k) {
        this.field_oldVersion = paramCursor.getString(i);
      } else if (iJK == k) {
        this.field_oldPath = paramCursor.getString(i);
      } else if (hIy == k) {
        this.field_md5 = paramCursor.getString(i);
      } else if (hzQ == k) {
        this.field_downloadUrl = paramCursor.getString(i);
      } else if (iJL == k) {
        this.field_pkgSize = paramCursor.getInt(i);
      } else if (iJM == k) {
        this.field_downloadNetType = paramCursor.getInt(i);
      } else if (rowid_HASHCODE == k) {
        this.systemRowid = paramCursor.getLong(i);
      }
    }
  }
  
  public ContentValues convertTo()
  {
    ContentValues localContentValues = new ContentValues();
    if (this.iJD) {
      localContentValues.put("pkgId", this.field_pkgId);
    }
    if (this.hpO) {
      localContentValues.put("version", this.field_version);
    }
    if (this.iJE) {
      localContentValues.put("oldVersion", this.field_oldVersion);
    }
    if (this.iJF) {
      localContentValues.put("oldPath", this.field_oldPath);
    }
    if (this.hHK) {
      localContentValues.put("md5", this.field_md5);
    }
    if (this.hzI) {
      localContentValues.put("downloadUrl", this.field_downloadUrl);
    }
    if (this.iJG) {
      localContentValues.put("pkgSize", Integer.valueOf(this.field_pkgSize));
    }
    if (this.iJH) {
      localContentValues.put("downloadNetType", Integer.valueOf(this.field_downloadNetType));
    }
    if (this.systemRowid > 0L) {
      localContentValues.put("rowid", Long.valueOf(this.systemRowid));
    }
    return localContentValues;
  }
  
  public String[] getIndexCreateSQL()
  {
    return INDEX_CREATE;
  }
  
  public String getTableName()
  {
    return "WePkgDiffPackage";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.f.c.ht
 * JD-Core Version:    0.7.0.1
 */