package com.tencent.mm.plugin.lite.d;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;

public abstract class a
  extends c
{
  public static final String[] INDEX_CREATE = new String[0];
  private static final int eQq;
  private static final int enO = "appId".hashCode();
  private static final int eol = "updateTime".hashCode();
  private static final int epd;
  private static final int rowid_HASHCODE = "rowid".hashCode();
  private static final int tWm = "signatureKey".hashCode();
  private static final int tWn;
  private boolean eQl = true;
  private boolean enx = true;
  private boolean eoY = true;
  private boolean eoi = true;
  public String field_appId;
  public String field_patchId;
  public String field_pkgPath;
  public String field_pkgType;
  public String field_signatureKey;
  public long field_updateTime;
  private boolean tWk = true;
  private boolean tWl = true;
  
  static
  {
    epd = "pkgPath".hashCode();
    eQq = "pkgType".hashCode();
    tWn = "patchId".hashCode();
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
      if (enO != k) {
        break label65;
      }
      this.field_appId = paramCursor.getString(i);
      this.enx = true;
    }
    for (;;)
    {
      i += 1;
      break label20;
      break;
      label65:
      if (tWm == k) {
        this.field_signatureKey = paramCursor.getString(i);
      } else if (epd == k) {
        this.field_pkgPath = paramCursor.getString(i);
      } else if (eQq == k) {
        this.field_pkgType = paramCursor.getString(i);
      } else if (tWn == k) {
        this.field_patchId = paramCursor.getString(i);
      } else if (eol == k) {
        this.field_updateTime = paramCursor.getLong(i);
      } else if (rowid_HASHCODE == k) {
        this.systemRowid = paramCursor.getLong(i);
      }
    }
  }
  
  public ContentValues convertTo()
  {
    ContentValues localContentValues = new ContentValues();
    if (this.enx) {
      localContentValues.put("appId", this.field_appId);
    }
    if (this.tWk) {
      localContentValues.put("signatureKey", this.field_signatureKey);
    }
    if (this.eoY) {
      localContentValues.put("pkgPath", this.field_pkgPath);
    }
    if (this.eQl) {
      localContentValues.put("pkgType", this.field_pkgType);
    }
    if (this.tWl) {
      localContentValues.put("patchId", this.field_patchId);
    }
    if (this.eoi) {
      localContentValues.put("updateTime", Long.valueOf(this.field_updateTime));
    }
    if (this.systemRowid > 0L) {
      localContentValues.put("rowid", Long.valueOf(this.systemRowid));
    }
    return localContentValues;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.lite.d.a
 * JD-Core Version:    0.7.0.1
 */