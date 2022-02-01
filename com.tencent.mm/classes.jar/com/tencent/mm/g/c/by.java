package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;

public abstract class by
  extends c
{
  public static final String[] INDEX_CREATE = new String[0];
  private static final int eDc = "status".hashCode();
  private static final int eFM;
  private static final int eFq;
  private static final int eFw;
  private static final int eIm = "url".hashCode();
  private static final int eVS;
  private static final int eVT;
  private static final int eVU;
  private static final int eVV = "failNum".hashCode();
  private static final int eVW = "isReport".hashCode();
  private static final int rowid_HASHCODE = "rowid".hashCode();
  private boolean eCZ = true;
  private boolean eFK = true;
  private boolean eFn = true;
  private boolean eFs = true;
  private boolean eIi = true;
  private boolean eVN = true;
  private boolean eVO = true;
  private boolean eVP = true;
  private boolean eVQ = true;
  private boolean eVR = true;
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
    eFM = "size".hashCode();
    eFw = "path".hashCode();
    eVS = "imgDirPath".hashCode();
    eVT = "imgPaths".hashCode();
    eVU = "favTime".hashCode();
    eFq = "updateTime".hashCode();
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
      if (eIm != k) {
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
      if (eFM == k) {
        this.field_size = paramCursor.getLong(i);
      } else if (eFw == k) {
        this.field_path = paramCursor.getString(i);
      } else if (eVS == k) {
        this.field_imgDirPath = paramCursor.getString(i);
      } else if (eVT == k) {
        this.field_imgPaths = paramCursor.getString(i);
      } else if (eVU == k) {
        this.field_favTime = paramCursor.getLong(i);
      } else if (eFq == k) {
        this.field_updateTime = paramCursor.getLong(i);
      } else if (eDc == k) {
        this.field_status = paramCursor.getInt(i);
      } else if (eVV == k) {
        this.field_failNum = paramCursor.getInt(i);
      } else if (eVW == k) {
        this.field_isReport = paramCursor.getInt(i);
      } else if (rowid_HASHCODE == k) {
        this.systemRowid = paramCursor.getLong(i);
      }
    }
  }
  
  public ContentValues convertTo()
  {
    ContentValues localContentValues = new ContentValues();
    if (this.eIi) {
      localContentValues.put("url", this.field_url);
    }
    if (this.eFK) {
      localContentValues.put("size", Long.valueOf(this.field_size));
    }
    if (this.eFs) {
      localContentValues.put("path", this.field_path);
    }
    if (this.eVN) {
      localContentValues.put("imgDirPath", this.field_imgDirPath);
    }
    if (this.eVO) {
      localContentValues.put("imgPaths", this.field_imgPaths);
    }
    if (this.eVP) {
      localContentValues.put("favTime", Long.valueOf(this.field_favTime));
    }
    if (this.eFn) {
      localContentValues.put("updateTime", Long.valueOf(this.field_updateTime));
    }
    if (this.eCZ) {
      localContentValues.put("status", Integer.valueOf(this.field_status));
    }
    if (this.eVQ) {
      localContentValues.put("failNum", Integer.valueOf(this.field_failNum));
    }
    if (this.eVR) {
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