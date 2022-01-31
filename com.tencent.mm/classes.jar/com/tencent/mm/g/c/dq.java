package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;
import com.tencent.mm.sdk.e.c.a;
import java.lang.reflect.Field;
import java.util.Map;

public abstract class dq
  extends c
{
  public static final String[] INDEX_CREATE = new String[0];
  private static final int dHY = "musicId".hashCode();
  private static final int dJQ = "musicUrl".hashCode();
  private static final int dJR = "indexBitData".hashCode();
  private static final int dJS = "fileCacheComplete".hashCode();
  private static final int dJT = "pieceFileMIMEType".hashCode();
  private static final int dJU = "removeDirtyBit".hashCode();
  private static final int dxX = "fileName".hashCode();
  private static final int rowid_HASHCODE = "rowid".hashCode();
  private boolean dHr = true;
  private boolean dJL = true;
  private boolean dJM = true;
  private boolean dJN = true;
  private boolean dJO = true;
  private boolean dJP = true;
  private boolean dxw = true;
  public int field_fileCacheComplete;
  public String field_fileName;
  public byte[] field_indexBitData;
  public String field_musicId;
  public String field_musicUrl;
  public String field_pieceFileMIMEType;
  public int field_removeDirtyBit;
  
  public static c.a Hm()
  {
    c.a locala = new c.a();
    locala.yrK = new Field[7];
    locala.columns = new String[8];
    StringBuilder localStringBuilder = new StringBuilder();
    locala.columns[0] = "musicId";
    locala.yrM.put("musicId", "TEXT PRIMARY KEY ");
    localStringBuilder.append(" musicId TEXT PRIMARY KEY ");
    localStringBuilder.append(", ");
    locala.yrL = "musicId";
    locala.columns[1] = "musicUrl";
    locala.yrM.put("musicUrl", "TEXT");
    localStringBuilder.append(" musicUrl TEXT");
    localStringBuilder.append(", ");
    locala.columns[2] = "fileName";
    locala.yrM.put("fileName", "TEXT");
    localStringBuilder.append(" fileName TEXT");
    localStringBuilder.append(", ");
    locala.columns[3] = "indexBitData";
    locala.yrM.put("indexBitData", "BLOB");
    localStringBuilder.append(" indexBitData BLOB");
    localStringBuilder.append(", ");
    locala.columns[4] = "fileCacheComplete";
    locala.yrM.put("fileCacheComplete", "INTEGER");
    localStringBuilder.append(" fileCacheComplete INTEGER");
    localStringBuilder.append(", ");
    locala.columns[5] = "pieceFileMIMEType";
    locala.yrM.put("pieceFileMIMEType", "TEXT");
    localStringBuilder.append(" pieceFileMIMEType TEXT");
    localStringBuilder.append(", ");
    locala.columns[6] = "removeDirtyBit";
    locala.yrM.put("removeDirtyBit", "INTEGER");
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
      if (dHY != k) {
        break label65;
      }
      this.field_musicId = paramCursor.getString(i);
      this.dHr = true;
    }
    for (;;)
    {
      i += 1;
      break label20;
      break;
      label65:
      if (dJQ == k) {
        this.field_musicUrl = paramCursor.getString(i);
      } else if (dxX == k) {
        this.field_fileName = paramCursor.getString(i);
      } else if (dJR == k) {
        this.field_indexBitData = paramCursor.getBlob(i);
      } else if (dJS == k) {
        this.field_fileCacheComplete = paramCursor.getInt(i);
      } else if (dJT == k) {
        this.field_pieceFileMIMEType = paramCursor.getString(i);
      } else if (dJU == k) {
        this.field_removeDirtyBit = paramCursor.getInt(i);
      } else if (rowid_HASHCODE == k) {
        this.systemRowid = paramCursor.getLong(i);
      }
    }
  }
  
  public ContentValues convertTo()
  {
    ContentValues localContentValues = new ContentValues();
    if (this.dHr) {
      localContentValues.put("musicId", this.field_musicId);
    }
    if (this.dJL) {
      localContentValues.put("musicUrl", this.field_musicUrl);
    }
    if (this.dxw) {
      localContentValues.put("fileName", this.field_fileName);
    }
    if (this.dJM) {
      localContentValues.put("indexBitData", this.field_indexBitData);
    }
    if (this.dJN) {
      localContentValues.put("fileCacheComplete", Integer.valueOf(this.field_fileCacheComplete));
    }
    if (this.dJO) {
      localContentValues.put("pieceFileMIMEType", this.field_pieceFileMIMEType);
    }
    if (this.dJP) {
      localContentValues.put("removeDirtyBit", Integer.valueOf(this.field_removeDirtyBit));
    }
    if (this.systemRowid > 0L) {
      localContentValues.put("rowid", Long.valueOf(this.systemRowid));
    }
    return localContentValues;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.g.c.dq
 * JD-Core Version:    0.7.0.1
 */