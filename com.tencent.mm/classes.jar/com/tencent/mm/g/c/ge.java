package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.storage.IAutoDBItem;

public abstract class ge
  extends IAutoDBItem
{
  public static final String[] INDEX_CREATE = { "CREATE INDEX IF NOT EXISTS file_name_hash_index ON SightDraftInfo(fileNameHash)" };
  private static final int createTime_HASHCODE = "createTime".hashCode();
  private static final int fCq;
  private static final int fYU;
  private static final int fYV;
  private static final int fYW;
  private static final int fYX;
  private static final int fYY;
  private static final int localId_HASHCODE = "localId".hashCode();
  private static final int rowid_HASHCODE = "rowid".hashCode();
  private boolean __hadSetcreateTime = true;
  private boolean __hadSetlocalId = true;
  private boolean fBM = true;
  private boolean fYP = true;
  private boolean fYQ = true;
  private boolean fYR = true;
  private boolean fYS = true;
  private boolean fYT = true;
  public long field_createTime;
  public int field_fileDuration;
  public long field_fileLength;
  public String field_fileMd5;
  public String field_fileName;
  public int field_fileNameHash;
  public int field_fileStatus;
  public int field_localId;
  
  static
  {
    fCq = "fileName".hashCode();
    fYU = "fileNameHash".hashCode();
    fYV = "fileMd5".hashCode();
    fYW = "fileLength".hashCode();
    fYX = "fileStatus".hashCode();
    fYY = "fileDuration".hashCode();
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
      if (localId_HASHCODE != k) {
        break label65;
      }
      this.field_localId = paramCursor.getInt(i);
      this.__hadSetlocalId = true;
    }
    for (;;)
    {
      i += 1;
      break label20;
      break;
      label65:
      if (fCq == k) {
        this.field_fileName = paramCursor.getString(i);
      } else if (fYU == k) {
        this.field_fileNameHash = paramCursor.getInt(i);
      } else if (fYV == k) {
        this.field_fileMd5 = paramCursor.getString(i);
      } else if (fYW == k) {
        this.field_fileLength = paramCursor.getLong(i);
      } else if (fYX == k) {
        this.field_fileStatus = paramCursor.getInt(i);
      } else if (fYY == k) {
        this.field_fileDuration = paramCursor.getInt(i);
      } else if (createTime_HASHCODE == k) {
        this.field_createTime = paramCursor.getLong(i);
      } else if (rowid_HASHCODE == k) {
        this.systemRowid = paramCursor.getLong(i);
      }
    }
  }
  
  public ContentValues convertTo()
  {
    ContentValues localContentValues = new ContentValues();
    if (this.__hadSetlocalId) {
      localContentValues.put("localId", Integer.valueOf(this.field_localId));
    }
    if (this.fBM) {
      localContentValues.put("fileName", this.field_fileName);
    }
    if (this.fYP) {
      localContentValues.put("fileNameHash", Integer.valueOf(this.field_fileNameHash));
    }
    if (this.field_fileMd5 == null) {
      this.field_fileMd5 = "";
    }
    if (this.fYQ) {
      localContentValues.put("fileMd5", this.field_fileMd5);
    }
    if (this.fYR) {
      localContentValues.put("fileLength", Long.valueOf(this.field_fileLength));
    }
    if (this.fYS) {
      localContentValues.put("fileStatus", Integer.valueOf(this.field_fileStatus));
    }
    if (this.fYT) {
      localContentValues.put("fileDuration", Integer.valueOf(this.field_fileDuration));
    }
    if (this.__hadSetcreateTime) {
      localContentValues.put("createTime", Long.valueOf(this.field_createTime));
    }
    if (this.systemRowid > 0L) {
      localContentValues.put("rowid", Long.valueOf(this.systemRowid));
    }
    return localContentValues;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.g.c.ge
 * JD-Core Version:    0.7.0.1
 */