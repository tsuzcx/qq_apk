package com.tencent.mm.f.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.storage.IAutoDBItem;
import com.tencent.mm.sdk.storage.IAutoDBItem.MAutoDBInfo;
import com.tencent.mm.sdk.storage.sql.Column;
import com.tencent.mm.sdk.storage.sql.SingleTable;
import java.lang.reflect.Field;
import java.util.Map;

public abstract class fm
  extends IAutoDBItem
{
  public static final Column C_ROWID;
  public static final String[] INDEX_CREATE = new String[0];
  public static final SingleTable TABLE = new SingleTable("PieceMusicInfo");
  public static final Column hNx;
  private static final int hOF = "fileName".hashCode();
  public static final Column imi;
  private static final int inC;
  public static final Column iqJ;
  public static final Column iqK;
  public static final Column iqL;
  public static final Column iqM;
  public static final Column iqN;
  private static final int iqT;
  private static final int iqU = "indexBitData".hashCode();
  private static final int iqV = "fileCacheComplete".hashCode();
  private static final int iqW = "pieceFileMIMEType".hashCode();
  private static final int iqX = "removeDirtyBit".hashCode();
  private static final int rowid_HASHCODE = "rowid".hashCode();
  public int field_fileCacheComplete;
  public String field_fileName;
  public byte[] field_indexBitData;
  public String field_musicId;
  public String field_musicUrl;
  public String field_pieceFileMIMEType;
  public int field_removeDirtyBit;
  private boolean hOb = true;
  private boolean imS = true;
  private boolean iqO = true;
  private boolean iqP = true;
  private boolean iqQ = true;
  private boolean iqR = true;
  private boolean iqS = true;
  
  static
  {
    C_ROWID = new Column("rowid", "long", "PieceMusicInfo", "");
    imi = new Column("musicid", "string", "PieceMusicInfo", "");
    iqJ = new Column("musicurl", "string", "PieceMusicInfo", "");
    hNx = new Column("filename", "string", "PieceMusicInfo", "");
    iqK = new Column("indexbitdata", "byte[]", "PieceMusicInfo", "");
    iqL = new Column("filecachecomplete", "int", "PieceMusicInfo", "");
    iqM = new Column("piecefilemimetype", "string", "PieceMusicInfo", "");
    iqN = new Column("removedirtybit", "int", "PieceMusicInfo", "");
    inC = "musicId".hashCode();
    iqT = "musicUrl".hashCode();
  }
  
  public static IAutoDBItem.MAutoDBInfo aoY()
  {
    IAutoDBItem.MAutoDBInfo localMAutoDBInfo = new IAutoDBItem.MAutoDBInfo();
    localMAutoDBInfo.fields = new Field[7];
    localMAutoDBInfo.columns = new String[8];
    StringBuilder localStringBuilder = new StringBuilder();
    localMAutoDBInfo.columns[0] = "musicId";
    localMAutoDBInfo.colsMap.put("musicId", "TEXT PRIMARY KEY ");
    localStringBuilder.append(" musicId TEXT PRIMARY KEY ");
    localStringBuilder.append(", ");
    localMAutoDBInfo.primaryKey = "musicId";
    localMAutoDBInfo.columns[1] = "musicUrl";
    localMAutoDBInfo.colsMap.put("musicUrl", "TEXT");
    localStringBuilder.append(" musicUrl TEXT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[2] = "fileName";
    localMAutoDBInfo.colsMap.put("fileName", "TEXT");
    localStringBuilder.append(" fileName TEXT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[3] = "indexBitData";
    localMAutoDBInfo.colsMap.put("indexBitData", "BLOB");
    localStringBuilder.append(" indexBitData BLOB");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[4] = "fileCacheComplete";
    localMAutoDBInfo.colsMap.put("fileCacheComplete", "INTEGER");
    localStringBuilder.append(" fileCacheComplete INTEGER");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[5] = "pieceFileMIMEType";
    localMAutoDBInfo.colsMap.put("pieceFileMIMEType", "TEXT");
    localStringBuilder.append(" pieceFileMIMEType TEXT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[6] = "removeDirtyBit";
    localMAutoDBInfo.colsMap.put("removeDirtyBit", "INTEGER");
    localStringBuilder.append(" removeDirtyBit INTEGER");
    localMAutoDBInfo.columns[7] = "rowid";
    localMAutoDBInfo.sql = localStringBuilder.toString();
    return localMAutoDBInfo;
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
      if (inC != k) {
        break label65;
      }
      this.field_musicId = paramCursor.getString(i);
      this.imS = true;
    }
    for (;;)
    {
      i += 1;
      break label20;
      break;
      label65:
      if (iqT == k) {
        this.field_musicUrl = paramCursor.getString(i);
      } else if (hOF == k) {
        this.field_fileName = paramCursor.getString(i);
      } else if (iqU == k) {
        this.field_indexBitData = paramCursor.getBlob(i);
      } else if (iqV == k) {
        this.field_fileCacheComplete = paramCursor.getInt(i);
      } else if (iqW == k) {
        this.field_pieceFileMIMEType = paramCursor.getString(i);
      } else if (iqX == k) {
        this.field_removeDirtyBit = paramCursor.getInt(i);
      } else if (rowid_HASHCODE == k) {
        this.systemRowid = paramCursor.getLong(i);
      }
    }
  }
  
  public ContentValues convertTo()
  {
    ContentValues localContentValues = new ContentValues();
    if (this.imS) {
      localContentValues.put("musicId", this.field_musicId);
    }
    if (this.iqO) {
      localContentValues.put("musicUrl", this.field_musicUrl);
    }
    if (this.hOb) {
      localContentValues.put("fileName", this.field_fileName);
    }
    if (this.iqP) {
      localContentValues.put("indexBitData", this.field_indexBitData);
    }
    if (this.iqQ) {
      localContentValues.put("fileCacheComplete", Integer.valueOf(this.field_fileCacheComplete));
    }
    if (this.iqR) {
      localContentValues.put("pieceFileMIMEType", this.field_pieceFileMIMEType);
    }
    if (this.iqS) {
      localContentValues.put("removeDirtyBit", Integer.valueOf(this.field_removeDirtyBit));
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
    return "PieceMusicInfo";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.f.c.fm
 * JD-Core Version:    0.7.0.1
 */