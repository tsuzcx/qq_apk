package com.tencent.mm.h.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;

public abstract class dk
  extends c
{
  private static final int cUe;
  public static final String[] cqY = new String[0];
  private static final int crh = "rowid".hashCode();
  private static final int csy;
  private static final int ctl = "appId".hashCode();
  private static final int cuv = "version".hashCode();
  private static final int cuy;
  private boolean cTX = true;
  private boolean csU = true;
  private boolean csa = true;
  private boolean cup = true;
  private boolean cus = true;
  public String field_appId;
  public String field_pkgMd5;
  public String field_pkgPath;
  public int field_type;
  public int field_version;
  
  static
  {
    csy = "type".hashCode();
    cUe = "pkgMd5".hashCode();
    cuy = "pkgPath".hashCode();
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
      if (cuv == k) {
        this.field_version = paramCursor.getInt(i);
      } else if (csy == k) {
        this.field_type = paramCursor.getInt(i);
      } else if (cUe == k) {
        this.field_pkgMd5 = paramCursor.getString(i);
      } else if (cuy == k) {
        this.field_pkgPath = paramCursor.getString(i);
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
    if (this.cup) {
      localContentValues.put("version", Integer.valueOf(this.field_version));
    }
    if (this.csa) {
      localContentValues.put("type", Integer.valueOf(this.field_type));
    }
    if (this.cTX) {
      localContentValues.put("pkgMd5", this.field_pkgMd5);
    }
    if (this.cus) {
      localContentValues.put("pkgPath", this.field_pkgPath);
    }
    if (this.ujK > 0L) {
      localContentValues.put("rowid", Long.valueOf(this.ujK));
    }
    return localContentValues;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.h.c.dk
 * JD-Core Version:    0.7.0.1
 */