package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.storage.IAutoDBItem;

public abstract class fp
  extends IAutoDBItem
{
  public static final String[] INDEX_CREATE = new String[0];
  private static final int fVU = "decryptKey".hashCode();
  private static final int fVg = "pkgMd5".hashCode();
  private static final int fkR;
  private static final int fkj = "appId".hashCode();
  private static final int flJ = "reportId".hashCode();
  private static final int rowid_HASHCODE = "rowid".hashCode();
  private boolean fUX = true;
  private boolean fVT = true;
  public String field_appId;
  public int field_appVersion;
  public String field_decryptKey;
  public String field_pkgMd5;
  public int field_reportId;
  private boolean fjS = true;
  private boolean fkN = true;
  private boolean flE = true;
  
  static
  {
    fkR = "appVersion".hashCode();
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
      if (fkj != k) {
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
      if (fkR == k) {
        this.field_appVersion = paramCursor.getInt(i);
      } else if (fVU == k) {
        this.field_decryptKey = paramCursor.getString(i);
      } else if (fVg == k) {
        this.field_pkgMd5 = paramCursor.getString(i);
      } else if (flJ == k) {
        this.field_reportId = paramCursor.getInt(i);
      } else if (rowid_HASHCODE == k) {
        this.systemRowid = paramCursor.getLong(i);
      }
    }
  }
  
  public ContentValues convertTo()
  {
    ContentValues localContentValues = new ContentValues();
    if (this.fjS) {
      localContentValues.put("appId", this.field_appId);
    }
    if (this.fkN) {
      localContentValues.put("appVersion", Integer.valueOf(this.field_appVersion));
    }
    if (this.fVT) {
      localContentValues.put("decryptKey", this.field_decryptKey);
    }
    if (this.fUX) {
      localContentValues.put("pkgMd5", this.field_pkgMd5);
    }
    if (this.flE) {
      localContentValues.put("reportId", Integer.valueOf(this.field_reportId));
    }
    if (this.systemRowid > 0L) {
      localContentValues.put("rowid", Long.valueOf(this.systemRowid));
    }
    return localContentValues;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.g.c.fp
 * JD-Core Version:    0.7.0.1
 */