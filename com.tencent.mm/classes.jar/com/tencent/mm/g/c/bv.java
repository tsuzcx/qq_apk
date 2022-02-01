package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;

public abstract class bv
  extends c
{
  public static final String[] INDEX_CREATE = new String[0];
  private static final int eCa;
  private static final int eCb;
  private static final int eCc;
  private static final int eCd = "failNum".hashCode();
  private static final int eCe = "isReport".hashCode();
  private static final int ejR;
  private static final int emB;
  private static final int emf;
  private static final int eml;
  private static final int eoZ = "url".hashCode();
  private static final int rowid_HASHCODE = "rowid".hashCode();
  private boolean eBV = true;
  private boolean eBW = true;
  private boolean eBX = true;
  private boolean eBY = true;
  private boolean eBZ = true;
  private boolean ejO = true;
  private boolean emc = true;
  private boolean emh = true;
  private boolean emz = true;
  private boolean eoV = true;
  public int field_failNum;
  public long field_favTime;
  public String field_imgDirPath;
  public String field_imgPaths;
  public int field_isReport;
  public String field_path;
  public long field_size;
  public int field_status;
  public long field_updateTime;
  public String field_url;
  
  static
  {
    emB = "size".hashCode();
    eml = "path".hashCode();
    eCa = "imgDirPath".hashCode();
    eCb = "imgPaths".hashCode();
    eCc = "favTime".hashCode();
    emf = "updateTime".hashCode();
    ejR = "status".hashCode();
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
      if (eoZ != k) {
        break label60;
      }
      this.field_url = paramCursor.getString(i);
    }
    for (;;)
    {
      i += 1;
      break label20;
      break;
      label60:
      if (emB == k) {
        this.field_size = paramCursor.getLong(i);
      } else if (eml == k) {
        this.field_path = paramCursor.getString(i);
      } else if (eCa == k) {
        this.field_imgDirPath = paramCursor.getString(i);
      } else if (eCb == k) {
        this.field_imgPaths = paramCursor.getString(i);
      } else if (eCc == k) {
        this.field_favTime = paramCursor.getLong(i);
      } else if (emf == k) {
        this.field_updateTime = paramCursor.getLong(i);
      } else if (ejR == k) {
        this.field_status = paramCursor.getInt(i);
      } else if (eCd == k) {
        this.field_failNum = paramCursor.getInt(i);
      } else if (eCe == k) {
        this.field_isReport = paramCursor.getInt(i);
      } else if (rowid_HASHCODE == k) {
        this.systemRowid = paramCursor.getLong(i);
      }
    }
  }
  
  public ContentValues convertTo()
  {
    ContentValues localContentValues = new ContentValues();
    if (this.eoV) {
      localContentValues.put("url", this.field_url);
    }
    if (this.emz) {
      localContentValues.put("size", Long.valueOf(this.field_size));
    }
    if (this.emh) {
      localContentValues.put("path", this.field_path);
    }
    if (this.eBV) {
      localContentValues.put("imgDirPath", this.field_imgDirPath);
    }
    if (this.eBW) {
      localContentValues.put("imgPaths", this.field_imgPaths);
    }
    if (this.eBX) {
      localContentValues.put("favTime", Long.valueOf(this.field_favTime));
    }
    if (this.emc) {
      localContentValues.put("updateTime", Long.valueOf(this.field_updateTime));
    }
    if (this.ejO) {
      localContentValues.put("status", Integer.valueOf(this.field_status));
    }
    if (this.eBY) {
      localContentValues.put("failNum", Integer.valueOf(this.field_failNum));
    }
    if (this.eBZ) {
      localContentValues.put("isReport", Integer.valueOf(this.field_isReport));
    }
    if (this.systemRowid > 0L) {
      localContentValues.put("rowid", Long.valueOf(this.systemRowid));
    }
    return localContentValues;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.g.c.bv
 * JD-Core Version:    0.7.0.1
 */