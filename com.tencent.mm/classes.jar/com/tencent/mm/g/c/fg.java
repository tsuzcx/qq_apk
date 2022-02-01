package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.storage.IAutoDBItem;
import com.tencent.mm.sdk.storage.IAutoDBItem.MAutoDBInfo;
import java.lang.reflect.Field;
import java.util.Map;

public abstract class fg
  extends IAutoDBItem
{
  public static final String[] INDEX_CREATE = new String[0];
  private static final int fCq = "fileName".hashCode();
  private static final int fSn = "musicId".hashCode();
  private static final int fUG = "musicUrl".hashCode();
  private static final int fUH = "indexBitData".hashCode();
  private static final int fUI = "fileCacheComplete".hashCode();
  private static final int fUJ = "pieceFileMIMEType".hashCode();
  private static final int fUK = "removeDirtyBit".hashCode();
  private static final int rowid_HASHCODE = "rowid".hashCode();
  private boolean fBM = true;
  private boolean fRD = true;
  private boolean fUB = true;
  private boolean fUC = true;
  private boolean fUD = true;
  private boolean fUE = true;
  private boolean fUF = true;
  public int field_fileCacheComplete;
  public String field_fileName;
  public byte[] field_indexBitData;
  public String field_musicId;
  public String field_musicUrl;
  public String field_pieceFileMIMEType;
  public int field_removeDirtyBit;
  
  public static IAutoDBItem.MAutoDBInfo ajs()
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
      if (fSn != k) {
        break label65;
      }
      this.field_musicId = paramCursor.getString(i);
      this.fRD = true;
    }
    for (;;)
    {
      i += 1;
      break label20;
      break;
      label65:
      if (fUG == k) {
        this.field_musicUrl = paramCursor.getString(i);
      } else if (fCq == k) {
        this.field_fileName = paramCursor.getString(i);
      } else if (fUH == k) {
        this.field_indexBitData = paramCursor.getBlob(i);
      } else if (fUI == k) {
        this.field_fileCacheComplete = paramCursor.getInt(i);
      } else if (fUJ == k) {
        this.field_pieceFileMIMEType = paramCursor.getString(i);
      } else if (fUK == k) {
        this.field_removeDirtyBit = paramCursor.getInt(i);
      } else if (rowid_HASHCODE == k) {
        this.systemRowid = paramCursor.getLong(i);
      }
    }
  }
  
  public ContentValues convertTo()
  {
    ContentValues localContentValues = new ContentValues();
    if (this.fRD) {
      localContentValues.put("musicId", this.field_musicId);
    }
    if (this.fUB) {
      localContentValues.put("musicUrl", this.field_musicUrl);
    }
    if (this.fBM) {
      localContentValues.put("fileName", this.field_fileName);
    }
    if (this.fUC) {
      localContentValues.put("indexBitData", this.field_indexBitData);
    }
    if (this.fUD) {
      localContentValues.put("fileCacheComplete", Integer.valueOf(this.field_fileCacheComplete));
    }
    if (this.fUE) {
      localContentValues.put("pieceFileMIMEType", this.field_pieceFileMIMEType);
    }
    if (this.fUF) {
      localContentValues.put("removeDirtyBit", Integer.valueOf(this.field_removeDirtyBit));
    }
    if (this.systemRowid > 0L) {
      localContentValues.put("rowid", Long.valueOf(this.systemRowid));
    }
    return localContentValues;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.g.c.fg
 * JD-Core Version:    0.7.0.1
 */