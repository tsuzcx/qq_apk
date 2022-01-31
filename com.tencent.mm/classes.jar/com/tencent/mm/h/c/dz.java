package com.tencent.mm.h.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;

public abstract class dz
  extends c
{
  private static final int cHJ;
  private static final int cJh;
  private static final int cXE;
  private static final int cXF;
  private static final int cXG;
  private static final int cXH;
  private static final int cXI;
  public static final String[] cqY = { "CREATE INDEX IF NOT EXISTS file_name_hash_index ON SightDraftInfo(fileNameHash)" };
  private static final int crh = "rowid".hashCode();
  private static final int csv;
  private boolean cHH = true;
  private boolean cIM = true;
  private boolean cXA = true;
  private boolean cXB = true;
  private boolean cXC = true;
  private boolean cXD = true;
  private boolean cXz = true;
  private boolean crX = true;
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
    cHJ = "localId".hashCode();
    cJh = "fileName".hashCode();
    cXE = "fileNameHash".hashCode();
    cXF = "fileMd5".hashCode();
    cXG = "fileLength".hashCode();
    cXH = "fileStatus".hashCode();
    cXI = "fileDuration".hashCode();
    csv = "createTime".hashCode();
  }
  
  public final void d(Cursor paramCursor)
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
      if (cHJ != k) {
        break label65;
      }
      this.field_localId = paramCursor.getInt(i);
      this.cHH = true;
    }
    for (;;)
    {
      i += 1;
      break label20;
      break;
      label65:
      if (cJh == k) {
        this.field_fileName = paramCursor.getString(i);
      } else if (cXE == k) {
        this.field_fileNameHash = paramCursor.getInt(i);
      } else if (cXF == k) {
        this.field_fileMd5 = paramCursor.getString(i);
      } else if (cXG == k) {
        this.field_fileLength = paramCursor.getLong(i);
      } else if (cXH == k) {
        this.field_fileStatus = paramCursor.getInt(i);
      } else if (cXI == k) {
        this.field_fileDuration = paramCursor.getInt(i);
      } else if (csv == k) {
        this.field_createTime = paramCursor.getLong(i);
      } else if (crh == k) {
        this.ujK = paramCursor.getLong(i);
      }
    }
  }
  
  public final ContentValues vf()
  {
    ContentValues localContentValues = new ContentValues();
    if (this.cHH) {
      localContentValues.put("localId", Integer.valueOf(this.field_localId));
    }
    if (this.cIM) {
      localContentValues.put("fileName", this.field_fileName);
    }
    if (this.cXz) {
      localContentValues.put("fileNameHash", Integer.valueOf(this.field_fileNameHash));
    }
    if (this.field_fileMd5 == null) {
      this.field_fileMd5 = "";
    }
    if (this.cXA) {
      localContentValues.put("fileMd5", this.field_fileMd5);
    }
    if (this.cXB) {
      localContentValues.put("fileLength", Long.valueOf(this.field_fileLength));
    }
    if (this.cXC) {
      localContentValues.put("fileStatus", Integer.valueOf(this.field_fileStatus));
    }
    if (this.cXD) {
      localContentValues.put("fileDuration", Integer.valueOf(this.field_fileDuration));
    }
    if (this.crX) {
      localContentValues.put("createTime", Long.valueOf(this.field_createTime));
    }
    if (this.ujK > 0L) {
      localContentValues.put("rowid", Long.valueOf(this.ujK));
    }
    return localContentValues;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.h.c.dz
 * JD-Core Version:    0.7.0.1
 */