package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;
import com.tencent.mm.sdk.e.c.a;
import java.lang.reflect.Field;
import java.util.Map;

public abstract class ey
  extends c
{
  public static final String[] INDEX_CREATE = new String[0];
  private static final int eYM = "fileName".hashCode();
  private static final int fnH = "musicId".hashCode();
  private static final int fqb = "musicUrl".hashCode();
  private static final int fqc = "indexBitData".hashCode();
  private static final int fqd = "fileCacheComplete".hashCode();
  private static final int fqe = "pieceFileMIMEType".hashCode();
  private static final int fqf = "removeDirtyBit".hashCode();
  private static final int rowid_HASHCODE = "rowid".hashCode();
  private boolean eYj = true;
  public int field_fileCacheComplete;
  public String field_fileName;
  public byte[] field_indexBitData;
  public String field_musicId;
  public String field_musicUrl;
  public String field_pieceFileMIMEType;
  public int field_removeDirtyBit;
  private boolean fmX = true;
  private boolean fpW = true;
  private boolean fpX = true;
  private boolean fpY = true;
  private boolean fpZ = true;
  private boolean fqa = true;
  
  public static c.a VD()
  {
    c.a locala = new c.a();
    locala.IBL = new Field[7];
    locala.columns = new String[8];
    StringBuilder localStringBuilder = new StringBuilder();
    locala.columns[0] = "musicId";
    locala.IBN.put("musicId", "TEXT PRIMARY KEY ");
    localStringBuilder.append(" musicId TEXT PRIMARY KEY ");
    localStringBuilder.append(", ");
    locala.IBM = "musicId";
    locala.columns[1] = "musicUrl";
    locala.IBN.put("musicUrl", "TEXT");
    localStringBuilder.append(" musicUrl TEXT");
    localStringBuilder.append(", ");
    locala.columns[2] = "fileName";
    locala.IBN.put("fileName", "TEXT");
    localStringBuilder.append(" fileName TEXT");
    localStringBuilder.append(", ");
    locala.columns[3] = "indexBitData";
    locala.IBN.put("indexBitData", "BLOB");
    localStringBuilder.append(" indexBitData BLOB");
    localStringBuilder.append(", ");
    locala.columns[4] = "fileCacheComplete";
    locala.IBN.put("fileCacheComplete", "INTEGER");
    localStringBuilder.append(" fileCacheComplete INTEGER");
    localStringBuilder.append(", ");
    locala.columns[5] = "pieceFileMIMEType";
    locala.IBN.put("pieceFileMIMEType", "TEXT");
    localStringBuilder.append(" pieceFileMIMEType TEXT");
    localStringBuilder.append(", ");
    locala.columns[6] = "removeDirtyBit";
    locala.IBN.put("removeDirtyBit", "INTEGER");
    localStringBuilder.append(" removeDirtyBit INTEGER");
    locala.columns[7] = "rowid";
    locala.sql = localStringBuilder.toString();
    return locala;
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
      if (fnH != k) {
        break label65;
      }
      this.field_musicId = paramCursor.getString(i);
      this.fmX = true;
    }
    for (;;)
    {
      i += 1;
      break label20;
      break;
      label65:
      if (fqb == k) {
        this.field_musicUrl = paramCursor.getString(i);
      } else if (eYM == k) {
        this.field_fileName = paramCursor.getString(i);
      } else if (fqc == k) {
        this.field_indexBitData = paramCursor.getBlob(i);
      } else if (fqd == k) {
        this.field_fileCacheComplete = paramCursor.getInt(i);
      } else if (fqe == k) {
        this.field_pieceFileMIMEType = paramCursor.getString(i);
      } else if (fqf == k) {
        this.field_removeDirtyBit = paramCursor.getInt(i);
      } else if (rowid_HASHCODE == k) {
        this.systemRowid = paramCursor.getLong(i);
      }
    }
  }
  
  public ContentValues convertTo()
  {
    ContentValues localContentValues = new ContentValues();
    if (this.fmX) {
      localContentValues.put("musicId", this.field_musicId);
    }
    if (this.fpW) {
      localContentValues.put("musicUrl", this.field_musicUrl);
    }
    if (this.eYj) {
      localContentValues.put("fileName", this.field_fileName);
    }
    if (this.fpX) {
      localContentValues.put("indexBitData", this.field_indexBitData);
    }
    if (this.fpY) {
      localContentValues.put("fileCacheComplete", Integer.valueOf(this.field_fileCacheComplete));
    }
    if (this.fpZ) {
      localContentValues.put("pieceFileMIMEType", this.field_pieceFileMIMEType);
    }
    if (this.fqa) {
      localContentValues.put("removeDirtyBit", Integer.valueOf(this.field_removeDirtyBit));
    }
    if (this.systemRowid > 0L) {
      localContentValues.put("rowid", Long.valueOf(this.systemRowid));
    }
    return localContentValues;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.g.c.ey
 * JD-Core Version:    0.7.0.1
 */