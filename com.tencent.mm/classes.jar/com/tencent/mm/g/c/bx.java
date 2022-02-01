package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;

public abstract class bx
  extends c
{
  public static final String[] INDEX_CREATE = new String[0];
  private static final int eEu;
  private static final int eEv;
  private static final int eEw;
  private static final int eEx = "failNum".hashCode();
  private static final int eEy = "isReport".hashCode();
  private static final int elV;
  private static final int eoH;
  private static final int eol;
  private static final int eor;
  private static final int erd = "url".hashCode();
  private static final int rowid_HASHCODE = "rowid".hashCode();
  private boolean eEp = true;
  private boolean eEq = true;
  private boolean eEr = true;
  private boolean eEs = true;
  private boolean eEt = true;
  private boolean elS = true;
  private boolean eoF = true;
  private boolean eoi = true;
  private boolean eon = true;
  private boolean eqZ = true;
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
    eoH = "size".hashCode();
    eor = "path".hashCode();
    eEu = "imgDirPath".hashCode();
    eEv = "imgPaths".hashCode();
    eEw = "favTime".hashCode();
    eol = "updateTime".hashCode();
    elV = "status".hashCode();
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
      if (erd != k) {
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
      if (eoH == k) {
        this.field_size = paramCursor.getLong(i);
      } else if (eor == k) {
        this.field_path = paramCursor.getString(i);
      } else if (eEu == k) {
        this.field_imgDirPath = paramCursor.getString(i);
      } else if (eEv == k) {
        this.field_imgPaths = paramCursor.getString(i);
      } else if (eEw == k) {
        this.field_favTime = paramCursor.getLong(i);
      } else if (eol == k) {
        this.field_updateTime = paramCursor.getLong(i);
      } else if (elV == k) {
        this.field_status = paramCursor.getInt(i);
      } else if (eEx == k) {
        this.field_failNum = paramCursor.getInt(i);
      } else if (eEy == k) {
        this.field_isReport = paramCursor.getInt(i);
      } else if (rowid_HASHCODE == k) {
        this.systemRowid = paramCursor.getLong(i);
      }
    }
  }
  
  public ContentValues convertTo()
  {
    ContentValues localContentValues = new ContentValues();
    if (this.eqZ) {
      localContentValues.put("url", this.field_url);
    }
    if (this.eoF) {
      localContentValues.put("size", Long.valueOf(this.field_size));
    }
    if (this.eon) {
      localContentValues.put("path", this.field_path);
    }
    if (this.eEp) {
      localContentValues.put("imgDirPath", this.field_imgDirPath);
    }
    if (this.eEq) {
      localContentValues.put("imgPaths", this.field_imgPaths);
    }
    if (this.eEr) {
      localContentValues.put("favTime", Long.valueOf(this.field_favTime));
    }
    if (this.eoi) {
      localContentValues.put("updateTime", Long.valueOf(this.field_updateTime));
    }
    if (this.elS) {
      localContentValues.put("status", Integer.valueOf(this.field_status));
    }
    if (this.eEs) {
      localContentValues.put("failNum", Integer.valueOf(this.field_failNum));
    }
    if (this.eEt) {
      localContentValues.put("isReport", Integer.valueOf(this.field_isReport));
    }
    if (this.systemRowid > 0L) {
      localContentValues.put("rowid", Long.valueOf(this.systemRowid));
    }
    return localContentValues;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.g.c.bx
 * JD-Core Version:    0.7.0.1
 */