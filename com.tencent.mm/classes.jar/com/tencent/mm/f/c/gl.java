package com.tencent.mm.f.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.storage.IAutoDBItem;
import com.tencent.mm.sdk.storage.sql.Column;
import com.tencent.mm.sdk.storage.sql.SingleTable;

public abstract class gl
  extends IAutoDBItem
{
  public static final Column C_CREATETIME;
  public static final Column C_LOCALID;
  public static final Column C_ROWID;
  public static final String[] INDEX_CREATE = { "CREATE INDEX IF NOT EXISTS file_name_hash_index ON SightDraftInfo(fileNameHash)" };
  public static final SingleTable TABLE = new SingleTable("SightDraftInfo");
  private static final int createTime_HASHCODE = "createTime".hashCode();
  public static final Column hNx;
  private static final int hOF;
  private static final int ixA;
  public static final Column ixm;
  public static final Column ixn;
  public static final Column ixo;
  public static final Column ixp;
  public static final Column ixq;
  private static final int ixw;
  private static final int ixx;
  private static final int ixy;
  private static final int ixz;
  private static final int localId_HASHCODE;
  private static final int rowid_HASHCODE = "rowid".hashCode();
  private boolean __hadSetcreateTime = true;
  private boolean __hadSetlocalId = true;
  public long field_createTime;
  public int field_fileDuration;
  public long field_fileLength;
  public String field_fileMd5;
  public String field_fileName;
  public int field_fileNameHash;
  public int field_fileStatus;
  public int field_localId;
  private boolean hOb = true;
  private boolean ixr = true;
  private boolean ixs = true;
  private boolean ixt = true;
  private boolean ixu = true;
  private boolean ixv = true;
  
  static
  {
    C_ROWID = new Column("rowid", "long", "SightDraftInfo", "");
    C_LOCALID = new Column("localid", "int", "SightDraftInfo", "");
    hNx = new Column("filename", "string", "SightDraftInfo", "");
    ixm = new Column("filenamehash", "int", "SightDraftInfo", "");
    ixn = new Column("filemd5", "string", "SightDraftInfo", "");
    ixo = new Column("filelength", "long", "SightDraftInfo", "");
    ixp = new Column("filestatus", "int", "SightDraftInfo", "");
    ixq = new Column("fileduration", "int", "SightDraftInfo", "");
    C_CREATETIME = new Column("createtime", "long", "SightDraftInfo", "");
    localId_HASHCODE = "localId".hashCode();
    hOF = "fileName".hashCode();
    ixw = "fileNameHash".hashCode();
    ixx = "fileMd5".hashCode();
    ixy = "fileLength".hashCode();
    ixz = "fileStatus".hashCode();
    ixA = "fileDuration".hashCode();
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
      if (hOF == k) {
        this.field_fileName = paramCursor.getString(i);
      } else if (ixw == k) {
        this.field_fileNameHash = paramCursor.getInt(i);
      } else if (ixx == k) {
        this.field_fileMd5 = paramCursor.getString(i);
      } else if (ixy == k) {
        this.field_fileLength = paramCursor.getLong(i);
      } else if (ixz == k) {
        this.field_fileStatus = paramCursor.getInt(i);
      } else if (ixA == k) {
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
    if (this.hOb) {
      localContentValues.put("fileName", this.field_fileName);
    }
    if (this.ixr) {
      localContentValues.put("fileNameHash", Integer.valueOf(this.field_fileNameHash));
    }
    if (this.field_fileMd5 == null) {
      this.field_fileMd5 = "";
    }
    if (this.ixs) {
      localContentValues.put("fileMd5", this.field_fileMd5);
    }
    if (this.ixt) {
      localContentValues.put("fileLength", Long.valueOf(this.field_fileLength));
    }
    if (this.ixu) {
      localContentValues.put("fileStatus", Integer.valueOf(this.field_fileStatus));
    }
    if (this.ixv) {
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
  
  public String[] getIndexCreateSQL()
  {
    return INDEX_CREATE;
  }
  
  public String getTableName()
  {
    return "SightDraftInfo";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.f.c.gl
 * JD-Core Version:    0.7.0.1
 */