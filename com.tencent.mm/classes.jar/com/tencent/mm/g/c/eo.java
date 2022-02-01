package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;
import com.tencent.mm.sdk.e.c.a;
import java.lang.reflect.Field;
import java.util.Map;

public abstract class eo
  extends c
{
  public static final String[] INDEX_CREATE = new String[0];
  private static final int eFD = "fileName".hashCode();
  private static final int eTs = "musicId".hashCode();
  private static final int eVL = "musicUrl".hashCode();
  private static final int eVM = "indexBitData".hashCode();
  private static final int eVN = "fileCacheComplete".hashCode();
  private static final int eVO = "pieceFileMIMEType".hashCode();
  private static final int eVP = "removeDirtyBit".hashCode();
  private static final int rowid_HASHCODE = "rowid".hashCode();
  private boolean eFa = true;
  private boolean eSI = true;
  private boolean eVG = true;
  private boolean eVH = true;
  private boolean eVI = true;
  private boolean eVJ = true;
  private boolean eVK = true;
  public int field_fileCacheComplete;
  public String field_fileName;
  public byte[] field_indexBitData;
  public String field_musicId;
  public String field_musicUrl;
  public String field_pieceFileMIMEType;
  public int field_removeDirtyBit;
  
  public static c.a Th()
  {
    c.a locala = new c.a();
    locala.GvF = new Field[7];
    locala.columns = new String[8];
    StringBuilder localStringBuilder = new StringBuilder();
    locala.columns[0] = "musicId";
    locala.GvH.put("musicId", "TEXT PRIMARY KEY ");
    localStringBuilder.append(" musicId TEXT PRIMARY KEY ");
    localStringBuilder.append(", ");
    locala.GvG = "musicId";
    locala.columns[1] = "musicUrl";
    locala.GvH.put("musicUrl", "TEXT");
    localStringBuilder.append(" musicUrl TEXT");
    localStringBuilder.append(", ");
    locala.columns[2] = "fileName";
    locala.GvH.put("fileName", "TEXT");
    localStringBuilder.append(" fileName TEXT");
    localStringBuilder.append(", ");
    locala.columns[3] = "indexBitData";
    locala.GvH.put("indexBitData", "BLOB");
    localStringBuilder.append(" indexBitData BLOB");
    localStringBuilder.append(", ");
    locala.columns[4] = "fileCacheComplete";
    locala.GvH.put("fileCacheComplete", "INTEGER");
    localStringBuilder.append(" fileCacheComplete INTEGER");
    localStringBuilder.append(", ");
    locala.columns[5] = "pieceFileMIMEType";
    locala.GvH.put("pieceFileMIMEType", "TEXT");
    localStringBuilder.append(" pieceFileMIMEType TEXT");
    localStringBuilder.append(", ");
    locala.columns[6] = "removeDirtyBit";
    locala.GvH.put("removeDirtyBit", "INTEGER");
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
      if (eTs != k) {
        break label65;
      }
      this.field_musicId = paramCursor.getString(i);
      this.eSI = true;
    }
    for (;;)
    {
      i += 1;
      break label20;
      break;
      label65:
      if (eVL == k) {
        this.field_musicUrl = paramCursor.getString(i);
      } else if (eFD == k) {
        this.field_fileName = paramCursor.getString(i);
      } else if (eVM == k) {
        this.field_indexBitData = paramCursor.getBlob(i);
      } else if (eVN == k) {
        this.field_fileCacheComplete = paramCursor.getInt(i);
      } else if (eVO == k) {
        this.field_pieceFileMIMEType = paramCursor.getString(i);
      } else if (eVP == k) {
        this.field_removeDirtyBit = paramCursor.getInt(i);
      } else if (rowid_HASHCODE == k) {
        this.systemRowid = paramCursor.getLong(i);
      }
    }
  }
  
  public ContentValues convertTo()
  {
    ContentValues localContentValues = new ContentValues();
    if (this.eSI) {
      localContentValues.put("musicId", this.field_musicId);
    }
    if (this.eVG) {
      localContentValues.put("musicUrl", this.field_musicUrl);
    }
    if (this.eFa) {
      localContentValues.put("fileName", this.field_fileName);
    }
    if (this.eVH) {
      localContentValues.put("indexBitData", this.field_indexBitData);
    }
    if (this.eVI) {
      localContentValues.put("fileCacheComplete", Integer.valueOf(this.field_fileCacheComplete));
    }
    if (this.eVJ) {
      localContentValues.put("pieceFileMIMEType", this.field_pieceFileMIMEType);
    }
    if (this.eVK) {
      localContentValues.put("removeDirtyBit", Integer.valueOf(this.field_removeDirtyBit));
    }
    if (this.systemRowid > 0L) {
      localContentValues.put("rowid", Long.valueOf(this.systemRowid));
    }
    return localContentValues;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.g.c.eo
 * JD-Core Version:    0.7.0.1
 */