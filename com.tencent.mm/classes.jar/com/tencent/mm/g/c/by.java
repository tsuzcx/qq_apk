package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;

public abstract class by
  extends c
{
  public static final String[] INDEX_CREATE = new String[0];
  private static final int eEL = "status".hashCode();
  private static final int eGZ;
  private static final int eHf;
  private static final int eHv;
  private static final int eJV = "url".hashCode();
  private static final int eXD;
  private static final int eXE;
  private static final int eXF;
  private static final int eXG = "failNum".hashCode();
  private static final int eXH = "isReport".hashCode();
  private static final int rowid_HASHCODE = "rowid".hashCode();
  private boolean eEI = true;
  private boolean eGW = true;
  private boolean eHb = true;
  private boolean eHt = true;
  private boolean eJR = true;
  private boolean eXA = true;
  private boolean eXB = true;
  private boolean eXC = true;
  private boolean eXy = true;
  private boolean eXz = true;
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
    eHv = "size".hashCode();
    eHf = "path".hashCode();
    eXD = "imgDirPath".hashCode();
    eXE = "imgPaths".hashCode();
    eXF = "favTime".hashCode();
    eGZ = "updateTime".hashCode();
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
      if (eJV != k) {
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
      if (eHv == k) {
        this.field_size = paramCursor.getLong(i);
      } else if (eHf == k) {
        this.field_path = paramCursor.getString(i);
      } else if (eXD == k) {
        this.field_imgDirPath = paramCursor.getString(i);
      } else if (eXE == k) {
        this.field_imgPaths = paramCursor.getString(i);
      } else if (eXF == k) {
        this.field_favTime = paramCursor.getLong(i);
      } else if (eGZ == k) {
        this.field_updateTime = paramCursor.getLong(i);
      } else if (eEL == k) {
        this.field_status = paramCursor.getInt(i);
      } else if (eXG == k) {
        this.field_failNum = paramCursor.getInt(i);
      } else if (eXH == k) {
        this.field_isReport = paramCursor.getInt(i);
      } else if (rowid_HASHCODE == k) {
        this.systemRowid = paramCursor.getLong(i);
      }
    }
  }
  
  public ContentValues convertTo()
  {
    ContentValues localContentValues = new ContentValues();
    if (this.eJR) {
      localContentValues.put("url", this.field_url);
    }
    if (this.eHt) {
      localContentValues.put("size", Long.valueOf(this.field_size));
    }
    if (this.eHb) {
      localContentValues.put("path", this.field_path);
    }
    if (this.eXy) {
      localContentValues.put("imgDirPath", this.field_imgDirPath);
    }
    if (this.eXz) {
      localContentValues.put("imgPaths", this.field_imgPaths);
    }
    if (this.eXA) {
      localContentValues.put("favTime", Long.valueOf(this.field_favTime));
    }
    if (this.eGW) {
      localContentValues.put("updateTime", Long.valueOf(this.field_updateTime));
    }
    if (this.eEI) {
      localContentValues.put("status", Integer.valueOf(this.field_status));
    }
    if (this.eXB) {
      localContentValues.put("failNum", Integer.valueOf(this.field_failNum));
    }
    if (this.eXC) {
      localContentValues.put("isReport", Integer.valueOf(this.field_isReport));
    }
    if (this.systemRowid > 0L) {
      localContentValues.put("rowid", Long.valueOf(this.systemRowid));
    }
    return localContentValues;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.g.c.by
 * JD-Core Version:    0.7.0.1
 */