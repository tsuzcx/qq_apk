package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.storage.IAutoDBItem;

public abstract class bz
  extends IAutoDBItem
{
  public static final String[] INDEX_CREATE = new String[0];
  private static final int fBg;
  private static final int fBh;
  private static final int fBi;
  private static final int fBj = "failNum".hashCode();
  private static final int fBk = "isReport".hashCode();
  private static final int fjl;
  private static final int fkH;
  private static final int fkX;
  private static final int fnB = "url".hashCode();
  private static final int rowid_HASHCODE = "rowid".hashCode();
  private static final int updateTime_HASHCODE;
  private boolean __hadSetupdateTime = true;
  private boolean fBb = true;
  private boolean fBc = true;
  private boolean fBd = true;
  private boolean fBe = true;
  private boolean fBf = true;
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
  private boolean fji = true;
  private boolean fkD = true;
  private boolean fkV = true;
  private boolean fnx = true;
  
  static
  {
    fkX = "size".hashCode();
    fkH = "path".hashCode();
    fBg = "imgDirPath".hashCode();
    fBh = "imgPaths".hashCode();
    fBi = "favTime".hashCode();
    updateTime_HASHCODE = "updateTime".hashCode();
    fjl = "status".hashCode();
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
      if (fnB != k) {
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
      if (fkX == k) {
        this.field_size = paramCursor.getLong(i);
      } else if (fkH == k) {
        this.field_path = paramCursor.getString(i);
      } else if (fBg == k) {
        this.field_imgDirPath = paramCursor.getString(i);
      } else if (fBh == k) {
        this.field_imgPaths = paramCursor.getString(i);
      } else if (fBi == k) {
        this.field_favTime = paramCursor.getLong(i);
      } else if (updateTime_HASHCODE == k) {
        this.field_updateTime = paramCursor.getLong(i);
      } else if (fjl == k) {
        this.field_status = paramCursor.getInt(i);
      } else if (fBj == k) {
        this.field_failNum = paramCursor.getInt(i);
      } else if (fBk == k) {
        this.field_isReport = paramCursor.getInt(i);
      } else if (rowid_HASHCODE == k) {
        this.systemRowid = paramCursor.getLong(i);
      }
    }
  }
  
  public ContentValues convertTo()
  {
    ContentValues localContentValues = new ContentValues();
    if (this.fnx) {
      localContentValues.put("url", this.field_url);
    }
    if (this.fkV) {
      localContentValues.put("size", Long.valueOf(this.field_size));
    }
    if (this.fkD) {
      localContentValues.put("path", this.field_path);
    }
    if (this.fBb) {
      localContentValues.put("imgDirPath", this.field_imgDirPath);
    }
    if (this.fBc) {
      localContentValues.put("imgPaths", this.field_imgPaths);
    }
    if (this.fBd) {
      localContentValues.put("favTime", Long.valueOf(this.field_favTime));
    }
    if (this.__hadSetupdateTime) {
      localContentValues.put("updateTime", Long.valueOf(this.field_updateTime));
    }
    if (this.fji) {
      localContentValues.put("status", Integer.valueOf(this.field_status));
    }
    if (this.fBe) {
      localContentValues.put("failNum", Integer.valueOf(this.field_failNum));
    }
    if (this.fBf) {
      localContentValues.put("isReport", Integer.valueOf(this.field_isReport));
    }
    if (this.systemRowid > 0L) {
      localContentValues.put("rowid", Long.valueOf(this.systemRowid));
    }
    return localContentValues;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.g.c.bz
 * JD-Core Version:    0.7.0.1
 */