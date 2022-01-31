package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;

public abstract class el
  extends c
{
  public static final String[] INDEX_CREATE = { "CREATE INDEX IF NOT EXISTS file_name_hash_index ON SightDraftInfo(fileNameHash)" };
  private static final int dNY = "fileNameHash".hashCode();
  private static final int dNZ = "fileMd5".hashCode();
  private static final int dOa = "fileLength".hashCode();
  private static final int dOb = "fileStatus".hashCode();
  private static final int dOc = "fileDuration".hashCode();
  private static final int dgM = "createTime".hashCode();
  private static final int dwr = "localId".hashCode();
  private static final int dxX = "fileName".hashCode();
  private static final int rowid_HASHCODE = "rowid".hashCode();
  private boolean dNT = true;
  private boolean dNU = true;
  private boolean dNV = true;
  private boolean dNW = true;
  private boolean dNX = true;
  private boolean dgp = true;
  private boolean dwp = true;
  private boolean dxw = true;
  public long field_createTime;
  public int field_fileDuration;
  public long field_fileLength;
  public String field_fileMd5;
  public String field_fileName;
  public int field_fileNameHash;
  public int field_fileStatus;
  public int field_localId;
  
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
      if (dwr != k) {
        break label65;
      }
      this.field_localId = paramCursor.getInt(i);
      this.dwp = true;
    }
    for (;;)
    {
      i += 1;
      break label20;
      break;
      label65:
      if (dxX == k) {
        this.field_fileName = paramCursor.getString(i);
      } else if (dNY == k) {
        this.field_fileNameHash = paramCursor.getInt(i);
      } else if (dNZ == k) {
        this.field_fileMd5 = paramCursor.getString(i);
      } else if (dOa == k) {
        this.field_fileLength = paramCursor.getLong(i);
      } else if (dOb == k) {
        this.field_fileStatus = paramCursor.getInt(i);
      } else if (dOc == k) {
        this.field_fileDuration = paramCursor.getInt(i);
      } else if (dgM == k) {
        this.field_createTime = paramCursor.getLong(i);
      } else if (rowid_HASHCODE == k) {
        this.systemRowid = paramCursor.getLong(i);
      }
    }
  }
  
  public ContentValues convertTo()
  {
    ContentValues localContentValues = new ContentValues();
    if (this.dwp) {
      localContentValues.put("localId", Integer.valueOf(this.field_localId));
    }
    if (this.dxw) {
      localContentValues.put("fileName", this.field_fileName);
    }
    if (this.dNT) {
      localContentValues.put("fileNameHash", Integer.valueOf(this.field_fileNameHash));
    }
    if (this.field_fileMd5 == null) {
      this.field_fileMd5 = "";
    }
    if (this.dNU) {
      localContentValues.put("fileMd5", this.field_fileMd5);
    }
    if (this.dNV) {
      localContentValues.put("fileLength", Long.valueOf(this.field_fileLength));
    }
    if (this.dNW) {
      localContentValues.put("fileStatus", Integer.valueOf(this.field_fileStatus));
    }
    if (this.dNX) {
      localContentValues.put("fileDuration", Integer.valueOf(this.field_fileDuration));
    }
    if (this.dgp) {
      localContentValues.put("createTime", Long.valueOf(this.field_createTime));
    }
    if (this.systemRowid > 0L) {
      localContentValues.put("rowid", Long.valueOf(this.systemRowid));
    }
    return localContentValues;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.g.c.el
 * JD-Core Version:    0.7.0.1
 */