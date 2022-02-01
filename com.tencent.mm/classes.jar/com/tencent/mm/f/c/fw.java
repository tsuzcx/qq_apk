package com.tencent.mm.f.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.storage.IAutoDBItem;
import com.tencent.mm.sdk.storage.sql.Column;
import com.tencent.mm.sdk.storage.sql.SingleTable;

public abstract class fw
  extends IAutoDBItem
{
  public static final Column C_ROWID;
  public static final String[] INDEX_CREATE = new String[0];
  public static final SingleTable TABLE = new SingleTable("PushWxaPkgDecryptKeyTable");
  public static final Column hnz;
  public static final Column hoR;
  private static final int hoZ;
  private static final int hoh;
  public static final Column hqc;
  private static final int hqm = "reportId".hashCode();
  private static final int irM;
  public static final Column iru;
  public static final Column isN;
  private static final int isP;
  private static final int rowid_HASHCODE = "rowid".hashCode();
  public String field_appId;
  public int field_appVersion;
  public String field_decryptKey;
  public String field_pkgMd5;
  public int field_reportId;
  private boolean hnQ = true;
  private boolean hoV = true;
  private boolean hqh = true;
  private boolean irD = true;
  private boolean isO = true;
  
  static
  {
    C_ROWID = new Column("rowid", "long", "PushWxaPkgDecryptKeyTable", "");
    hnz = new Column("appid", "string", "PushWxaPkgDecryptKeyTable", "");
    hoR = new Column("appversion", "int", "PushWxaPkgDecryptKeyTable", "");
    isN = new Column("decryptkey", "string", "PushWxaPkgDecryptKeyTable", "");
    iru = new Column("pkgmd5", "string", "PushWxaPkgDecryptKeyTable", "");
    hqc = new Column("reportid", "int", "PushWxaPkgDecryptKeyTable", "");
    hoh = "appId".hashCode();
    hoZ = "appVersion".hashCode();
    isP = "decryptKey".hashCode();
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
      if (hoZ == k) {
        this.field_appVersion = paramCursor.getInt(i);
      } else if (isP == k) {
        this.field_decryptKey = paramCursor.getString(i);
      } else if (irM == k) {
        this.field_pkgMd5 = paramCursor.getString(i);
      } else if (hqm == k) {
        this.field_reportId = paramCursor.getInt(i);
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
    if (this.hoV) {
      localContentValues.put("appVersion", Integer.valueOf(this.field_appVersion));
    }
    if (this.isO) {
      localContentValues.put("decryptKey", this.field_decryptKey);
    }
    if (this.irD) {
      localContentValues.put("pkgMd5", this.field_pkgMd5);
    }
    if (this.hqh) {
      localContentValues.put("reportId", Integer.valueOf(this.field_reportId));
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
    return "PushWxaPkgDecryptKeyTable";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.f.c.fw
 * JD-Core Version:    0.7.0.1
 */