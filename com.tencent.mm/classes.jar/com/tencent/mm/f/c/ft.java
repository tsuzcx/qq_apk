package com.tencent.mm.f.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.storage.IAutoDBItem;
import com.tencent.mm.sdk.storage.sql.Column;
import com.tencent.mm.sdk.storage.sql.SingleTable;

public abstract class ft
  extends IAutoDBItem
{
  public static final Column C_ROWID;
  public static final Column C_TYPE;
  public static final String[] INDEX_CREATE = new String[0];
  public static final SingleTable TABLE = new SingleTable("PredownloadEncryptPkgInfo");
  public static final Column hnz;
  private static final int hoh;
  public static final Column hpJ;
  public static final Column hpL;
  private static final int hpT;
  private static final int hpV = "pkgPath".hashCode();
  private static final int irM;
  public static final Column iru;
  private static final int rowid_HASHCODE = "rowid".hashCode();
  private static final int type_HASHCODE;
  private boolean __hadSettype = true;
  public String field_appId;
  public String field_pkgMd5;
  public String field_pkgPath;
  public int field_type;
  public int field_version;
  private boolean hnQ = true;
  private boolean hpO = true;
  private boolean hpQ = true;
  private boolean irD = true;
  
  static
  {
    C_ROWID = new Column("rowid", "long", "PredownloadEncryptPkgInfo", "");
    hnz = new Column("appid", "string", "PredownloadEncryptPkgInfo", "");
    hpJ = new Column("version", "int", "PredownloadEncryptPkgInfo", "");
    C_TYPE = new Column("type", "int", "PredownloadEncryptPkgInfo", "");
    iru = new Column("pkgmd5", "string", "PredownloadEncryptPkgInfo", "");
    hpL = new Column("pkgpath", "string", "PredownloadEncryptPkgInfo", "");
    hoh = "appId".hashCode();
    hpT = "version".hashCode();
    type_HASHCODE = "type".hashCode();
    irM = "pkgMd5".hashCode();
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
      if (hoh != k) {
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
      if (hpT == k) {
        this.field_version = paramCursor.getInt(i);
      } else if (type_HASHCODE == k) {
        this.field_type = paramCursor.getInt(i);
      } else if (irM == k) {
        this.field_pkgMd5 = paramCursor.getString(i);
      } else if (hpV == k) {
        this.field_pkgPath = paramCursor.getString(i);
      } else if (rowid_HASHCODE == k) {
        this.systemRowid = paramCursor.getLong(i);
      }
    }
  }
  
  public ContentValues convertTo()
  {
    ContentValues localContentValues = new ContentValues();
    if (this.hnQ) {
      localContentValues.put("appId", this.field_appId);
    }
    if (this.hpO) {
      localContentValues.put("version", Integer.valueOf(this.field_version));
    }
    if (this.__hadSettype) {
      localContentValues.put("type", Integer.valueOf(this.field_type));
    }
    if (this.irD) {
      localContentValues.put("pkgMd5", this.field_pkgMd5);
    }
    if (this.hpQ) {
      localContentValues.put("pkgPath", this.field_pkgPath);
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
    return "PredownloadEncryptPkgInfo";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.f.c.ft
 * JD-Core Version:    0.7.0.1
 */