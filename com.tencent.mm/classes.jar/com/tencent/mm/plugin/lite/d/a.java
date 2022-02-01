package com.tencent.mm.plugin.lite.d;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;

public abstract class a
  extends c
{
  public static final String[] INDEX_CREATE = new String[0];
  private static final int eEU = "appId".hashCode();
  private static final int eFq = "updateTime".hashCode();
  private static final int eGm;
  private static final int fiN;
  private static final int rowid_HASHCODE = "rowid".hashCode();
  private static final int uYV = "signatureKey".hashCode();
  private static final int uYW;
  private boolean eED = true;
  private boolean eFn = true;
  private boolean eGh = true;
  private boolean fiI = true;
  public String field_appId;
  public String field_patchId;
  public String field_pkgPath;
  public String field_pkgType;
  public String field_signatureKey;
  public long field_updateTime;
  private boolean uYT = true;
  private boolean uYU = true;
  
  static
  {
    eGm = "pkgPath".hashCode();
    fiN = "pkgType".hashCode();
    uYW = "patchId".hashCode();
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
      if (eEU != k) {
        break label65;
      }
      this.field_appId = paramCursor.getString(i);
      this.eED = true;
    }
    for (;;)
    {
      i += 1;
      break label20;
      break;
      label65:
      if (uYV == k) {
        this.field_signatureKey = paramCursor.getString(i);
      } else if (eGm == k) {
        this.field_pkgPath = paramCursor.getString(i);
      } else if (fiN == k) {
        this.field_pkgType = paramCursor.getString(i);
      } else if (uYW == k) {
        this.field_patchId = paramCursor.getString(i);
      } else if (eFq == k) {
        this.field_updateTime = paramCursor.getLong(i);
      } else if (rowid_HASHCODE == k) {
        this.systemRowid = paramCursor.getLong(i);
      }
    }
  }
  
  public ContentValues convertTo()
  {
    ContentValues localContentValues = new ContentValues();
    if (this.eED) {
      localContentValues.put("appId", this.field_appId);
    }
    if (this.uYT) {
      localContentValues.put("signatureKey", this.field_signatureKey);
    }
    if (this.eGh) {
      localContentValues.put("pkgPath", this.field_pkgPath);
    }
    if (this.fiI) {
      localContentValues.put("pkgType", this.field_pkgType);
    }
    if (this.uYU) {
      localContentValues.put("patchId", this.field_patchId);
    }
    if (this.eFn) {
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