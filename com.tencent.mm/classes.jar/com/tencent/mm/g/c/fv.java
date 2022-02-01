package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;

public abstract class fv
  extends c
{
  public static final String[] INDEX_CREATE = { "CREATE INDEX IF NOT EXISTS file_name_hash_index ON SightDraftInfo(fileNameHash)" };
  private static final int eFO = "createTime".hashCode();
  private static final int eWU = "localId".hashCode();
  private static final int eYM = "fileName".hashCode();
  private static final int ful = "fileNameHash".hashCode();
  private static final int fum = "fileMd5".hashCode();
  private static final int fun = "fileLength".hashCode();
  private static final int fuo = "fileStatus".hashCode();
  private static final int fup = "fileDuration".hashCode();
  private static final int rowid_HASHCODE = "rowid".hashCode();
  private boolean eFr = true;
  private boolean eWS = true;
  private boolean eYj = true;
  public long field_createTime;
  public int field_fileDuration;
  public long field_fileLength;
  public String field_fileMd5;
  public String field_fileName;
  public int field_fileNameHash;
  public int field_fileStatus;
  public int field_localId;
  private boolean fug = true;
  private boolean fuh = true;
  private boolean fui = true;
  private boolean fuj = true;
  private boolean fuk = true;
  
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
      if (eWU != k) {
        break label65;
      }
      this.field_localId = paramCursor.getInt(i);
      this.eWS = true;
    }
    for (;;)
    {
      i += 1;
      break label20;
      break;
      label65:
      if (eYM == k) {
        this.field_fileName = paramCursor.getString(i);
      } else if (ful == k) {
        this.field_fileNameHash = paramCursor.getInt(i);
      } else if (fum == k) {
        this.field_fileMd5 = paramCursor.getString(i);
      } else if (fun == k) {
        this.field_fileLength = paramCursor.getLong(i);
      } else if (fuo == k) {
        this.field_fileStatus = paramCursor.getInt(i);
      } else if (fup == k) {
        this.field_fileDuration = paramCursor.getInt(i);
      } else if (eFO == k) {
        this.field_createTime = paramCursor.getLong(i);
      } else if (rowid_HASHCODE == k) {
        this.systemRowid = paramCursor.getLong(i);
      }
    }
  }
  
  public ContentValues convertTo()
  {
    ContentValues localContentValues = new ContentValues();
    if (this.eWS) {
      localContentValues.put("localId", Integer.valueOf(this.field_localId));
    }
    if (this.eYj) {
      localContentValues.put("fileName", this.field_fileName);
    }
    if (this.fug) {
      localContentValues.put("fileNameHash", Integer.valueOf(this.field_fileNameHash));
    }
    if (this.field_fileMd5 == null) {
      this.field_fileMd5 = "";
    }
    if (this.fuh) {
      localContentValues.put("fileMd5", this.field_fileMd5);
    }
    if (this.fui) {
      localContentValues.put("fileLength", Long.valueOf(this.field_fileLength));
    }
    if (this.fuj) {
      localContentValues.put("fileStatus", Integer.valueOf(this.field_fileStatus));
    }
    if (this.fuk) {
      localContentValues.put("fileDuration", Integer.valueOf(this.field_fileDuration));
    }
    if (this.eFr) {
      localContentValues.put("createTime", Long.valueOf(this.field_createTime));
    }
    if (this.systemRowid > 0L) {
      localContentValues.put("rowid", Long.valueOf(this.systemRowid));
    }
    return localContentValues;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.g.c.fv
 * JD-Core Version:    0.7.0.1
 */