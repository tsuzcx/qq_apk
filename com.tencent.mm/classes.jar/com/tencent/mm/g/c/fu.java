package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;

public abstract class fu
  extends c
{
  public static final String[] INDEX_CREATE = { "CREATE INDEX IF NOT EXISTS file_name_hash_index ON SightDraftInfo(fileNameHash)" };
  private static final int eEf = "createTime".hashCode();
  private static final int eVj = "localId".hashCode();
  private static final int eXb = "fileName".hashCode();
  private static final int fsl = "fileNameHash".hashCode();
  private static final int fsm = "fileMd5".hashCode();
  private static final int fsn = "fileLength".hashCode();
  private static final int fso = "fileStatus".hashCode();
  private static final int fsp = "fileDuration".hashCode();
  private static final int rowid_HASHCODE = "rowid".hashCode();
  private boolean eDI = true;
  private boolean eVh = true;
  private boolean eWy = true;
  public long field_createTime;
  public int field_fileDuration;
  public long field_fileLength;
  public String field_fileMd5;
  public String field_fileName;
  public int field_fileNameHash;
  public int field_fileStatus;
  public int field_localId;
  private boolean fsg = true;
  private boolean fsh = true;
  private boolean fsi = true;
  private boolean fsj = true;
  private boolean fsk = true;
  
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
      if (eVj != k) {
        break label65;
      }
      this.field_localId = paramCursor.getInt(i);
      this.eVh = true;
    }
    for (;;)
    {
      i += 1;
      break label20;
      break;
      label65:
      if (eXb == k) {
        this.field_fileName = paramCursor.getString(i);
      } else if (fsl == k) {
        this.field_fileNameHash = paramCursor.getInt(i);
      } else if (fsm == k) {
        this.field_fileMd5 = paramCursor.getString(i);
      } else if (fsn == k) {
        this.field_fileLength = paramCursor.getLong(i);
      } else if (fso == k) {
        this.field_fileStatus = paramCursor.getInt(i);
      } else if (fsp == k) {
        this.field_fileDuration = paramCursor.getInt(i);
      } else if (eEf == k) {
        this.field_createTime = paramCursor.getLong(i);
      } else if (rowid_HASHCODE == k) {
        this.systemRowid = paramCursor.getLong(i);
      }
    }
  }
  
  public ContentValues convertTo()
  {
    ContentValues localContentValues = new ContentValues();
    if (this.eVh) {
      localContentValues.put("localId", Integer.valueOf(this.field_localId));
    }
    if (this.eWy) {
      localContentValues.put("fileName", this.field_fileName);
    }
    if (this.fsg) {
      localContentValues.put("fileNameHash", Integer.valueOf(this.field_fileNameHash));
    }
    if (this.field_fileMd5 == null) {
      this.field_fileMd5 = "";
    }
    if (this.fsh) {
      localContentValues.put("fileMd5", this.field_fileMd5);
    }
    if (this.fsi) {
      localContentValues.put("fileLength", Long.valueOf(this.field_fileLength));
    }
    if (this.fsj) {
      localContentValues.put("fileStatus", Integer.valueOf(this.field_fileStatus));
    }
    if (this.fsk) {
      localContentValues.put("fileDuration", Integer.valueOf(this.field_fileDuration));
    }
    if (this.eDI) {
      localContentValues.put("createTime", Long.valueOf(this.field_createTime));
    }
    if (this.systemRowid > 0L) {
      localContentValues.put("rowid", Long.valueOf(this.systemRowid));
    }
    return localContentValues;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.g.c.fu
 * JD-Core Version:    0.7.0.1
 */