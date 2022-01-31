package com.tencent.mm.h.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;

public abstract class dn
  extends c
{
  private static final int cTS = "reportId".hashCode();
  private static final int cUK;
  private static final int cUe;
  public static final String[] cqY = new String[0];
  private static final int crh = "rowid".hashCode();
  private static final int ctl = "appId".hashCode();
  private static final int cvc = "appVersion".hashCode();
  private boolean cTP = true;
  private boolean cTX = true;
  private boolean cUJ = true;
  private boolean csU = true;
  private boolean cuF = true;
  public String field_appId;
  public int field_appVersion;
  public String field_decryptKey;
  public String field_pkgMd5;
  public int field_reportId;
  
  static
  {
    cUK = "decryptKey".hashCode();
    cUe = "pkgMd5".hashCode();
  }
  
  public final void d(Cursor paramCursor)
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
      if (ctl != k) {
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
      if (cvc == k) {
        this.field_appVersion = paramCursor.getInt(i);
      } else if (cUK == k) {
        this.field_decryptKey = paramCursor.getString(i);
      } else if (cUe == k) {
        this.field_pkgMd5 = paramCursor.getString(i);
      } else if (cTS == k) {
        this.field_reportId = paramCursor.getInt(i);
      } else if (crh == k) {
        this.ujK = paramCursor.getLong(i);
      }
    }
  }
  
  public final ContentValues vf()
  {
    ContentValues localContentValues = new ContentValues();
    if (this.csU) {
      localContentValues.put("appId", this.field_appId);
    }
    if (this.cuF) {
      localContentValues.put("appVersion", Integer.valueOf(this.field_appVersion));
    }
    if (this.cUJ) {
      localContentValues.put("decryptKey", this.field_decryptKey);
    }
    if (this.cTX) {
      localContentValues.put("pkgMd5", this.field_pkgMd5);
    }
    if (this.cTP) {
      localContentValues.put("reportId", Integer.valueOf(this.field_reportId));
    }
    if (this.ujK > 0L) {
      localContentValues.put("rowid", Long.valueOf(this.ujK));
    }
    return localContentValues;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.h.c.dn
 * JD-Core Version:    0.7.0.1
 */