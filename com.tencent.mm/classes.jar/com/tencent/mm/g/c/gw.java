package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;

public abstract class gw
  extends c
{
  public static final String[] INDEX_CREATE = new String[0];
  private static final int elJ = "appId".hashCode();
  private static final int emf = "updateTime".hashCode();
  private static final int ffF = "accessTime".hashCode();
  private static final int fgg = "commLibVersionId".hashCode();
  private static final int fgh = "appVersionId".hashCode();
  private static final int fgi = "pageURL".hashCode();
  private static final int fgj = "cacheFilePath".hashCode();
  private static final int rowid_HASHCODE = "rowid".hashCode();
  private boolean els = true;
  private boolean emc = true;
  private boolean ffr = true;
  private boolean fgc = true;
  private boolean fgd = true;
  private boolean fge = true;
  private boolean fgf = true;
  public long field_accessTime;
  public String field_appId;
  public String field_appVersionId;
  public String field_cacheFilePath;
  public String field_commLibVersionId;
  public String field_pageURL;
  public long field_updateTime;
  
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
      if (elJ != k) {
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
      if (fgg == k) {
        this.field_commLibVersionId = paramCursor.getString(i);
      } else if (fgh == k) {
        this.field_appVersionId = paramCursor.getString(i);
      } else if (fgi == k) {
        this.field_pageURL = paramCursor.getString(i);
      } else if (emf == k) {
        this.field_updateTime = paramCursor.getLong(i);
      } else if (ffF == k) {
        this.field_accessTime = paramCursor.getLong(i);
      } else if (fgj == k) {
        this.field_cacheFilePath = paramCursor.getString(i);
      } else if (rowid_HASHCODE == k) {
        this.systemRowid = paramCursor.getLong(i);
      }
    }
  }
  
  public ContentValues convertTo()
  {
    ContentValues localContentValues = new ContentValues();
    if (this.els) {
      localContentValues.put("appId", this.field_appId);
    }
    if (this.fgc) {
      localContentValues.put("commLibVersionId", this.field_commLibVersionId);
    }
    if (this.fgd) {
      localContentValues.put("appVersionId", this.field_appVersionId);
    }
    if (this.fge) {
      localContentValues.put("pageURL", this.field_pageURL);
    }
    if (this.emc) {
      localContentValues.put("updateTime", Long.valueOf(this.field_updateTime));
    }
    if (this.ffr) {
      localContentValues.put("accessTime", Long.valueOf(this.field_accessTime));
    }
    if (this.fgf) {
      localContentValues.put("cacheFilePath", this.field_cacheFilePath);
    }
    if (this.systemRowid > 0L) {
      localContentValues.put("rowid", Long.valueOf(this.systemRowid));
    }
    return localContentValues;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.g.c.gw
 * JD-Core Version:    0.7.0.1
 */