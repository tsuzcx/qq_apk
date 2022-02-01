package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;

public abstract class fk
  extends c
{
  public static final String[] INDEX_CREATE = { "CREATE INDEX IF NOT EXISTS file_name_hash_index ON SightDraftInfo(fileNameHash)" };
  private static final int eDL = "localId".hashCode();
  private static final int eFD = "fileName".hashCode();
  private static final int eZX = "fileNameHash".hashCode();
  private static final int eZY = "fileMd5".hashCode();
  private static final int eZZ = "fileLength".hashCode();
  private static final int emY = "createTime".hashCode();
  private static final int faa = "fileStatus".hashCode();
  private static final int fab = "fileDuration".hashCode();
  private static final int rowid_HASHCODE = "rowid".hashCode();
  private boolean eDJ = true;
  private boolean eFa = true;
  private boolean eZS = true;
  private boolean eZT = true;
  private boolean eZU = true;
  private boolean eZV = true;
  private boolean eZW = true;
  private boolean emB = true;
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
      if (eDL != k) {
        break label65;
      }
      this.field_localId = paramCursor.getInt(i);
      this.eDJ = true;
    }
    for (;;)
    {
      i += 1;
      break label20;
      break;
      label65:
      if (eFD == k) {
        this.field_fileName = paramCursor.getString(i);
      } else if (eZX == k) {
        this.field_fileNameHash = paramCursor.getInt(i);
      } else if (eZY == k) {
        this.field_fileMd5 = paramCursor.getString(i);
      } else if (eZZ == k) {
        this.field_fileLength = paramCursor.getLong(i);
      } else if (faa == k) {
        this.field_fileStatus = paramCursor.getInt(i);
      } else if (fab == k) {
        this.field_fileDuration = paramCursor.getInt(i);
      } else if (emY == k) {
        this.field_createTime = paramCursor.getLong(i);
      } else if (rowid_HASHCODE == k) {
        this.systemRowid = paramCursor.getLong(i);
      }
    }
  }
  
  public ContentValues convertTo()
  {
    ContentValues localContentValues = new ContentValues();
    if (this.eDJ) {
      localContentValues.put("localId", Integer.valueOf(this.field_localId));
    }
    if (this.eFa) {
      localContentValues.put("fileName", this.field_fileName);
    }
    if (this.eZS) {
      localContentValues.put("fileNameHash", Integer.valueOf(this.field_fileNameHash));
    }
    if (this.field_fileMd5 == null) {
      this.field_fileMd5 = "";
    }
    if (this.eZT) {
      localContentValues.put("fileMd5", this.field_fileMd5);
    }
    if (this.eZU) {
      localContentValues.put("fileLength", Long.valueOf(this.field_fileLength));
    }
    if (this.eZV) {
      localContentValues.put("fileStatus", Integer.valueOf(this.field_fileStatus));
    }
    if (this.eZW) {
      localContentValues.put("fileDuration", Integer.valueOf(this.field_fileDuration));
    }
    if (this.emB) {
      localContentValues.put("createTime", Long.valueOf(this.field_createTime));
    }
    if (this.systemRowid > 0L) {
      localContentValues.put("rowid", Long.valueOf(this.systemRowid));
    }
    return localContentValues;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.g.c.fk
 * JD-Core Version:    0.7.0.1
 */