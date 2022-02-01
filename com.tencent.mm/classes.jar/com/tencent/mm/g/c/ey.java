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
  private static final int eXb = "fileName".hashCode();
  private static final int flH = "musicId".hashCode();
  private static final int foa = "musicUrl".hashCode();
  private static final int fob = "indexBitData".hashCode();
  private static final int foc = "fileCacheComplete".hashCode();
  private static final int fod = "pieceFileMIMEType".hashCode();
  private static final int foe = "removeDirtyBit".hashCode();
  private static final int rowid_HASHCODE = "rowid".hashCode();
  private boolean eWy = true;
  public int field_fileCacheComplete;
  public String field_fileName;
  public byte[] field_indexBitData;
  public String field_musicId;
  public String field_musicUrl;
  public String field_pieceFileMIMEType;
  public int field_removeDirtyBit;
  private boolean fkX = true;
  private boolean fnV = true;
  private boolean fnW = true;
  private boolean fnX = true;
  private boolean fnY = true;
  private boolean fnZ = true;
  
  public static c.a Vv()
  {
    c.a locala = new c.a();
    locala.IhA = new Field[7];
    locala.columns = new String[8];
    StringBuilder localStringBuilder = new StringBuilder();
    locala.columns[0] = "musicId";
    locala.IhC.put("musicId", "TEXT PRIMARY KEY ");
    localStringBuilder.append(" musicId TEXT PRIMARY KEY ");
    localStringBuilder.append(", ");
    locala.IhB = "musicId";
    locala.columns[1] = "musicUrl";
    locala.IhC.put("musicUrl", "TEXT");
    localStringBuilder.append(" musicUrl TEXT");
    localStringBuilder.append(", ");
    locala.columns[2] = "fileName";
    locala.IhC.put("fileName", "TEXT");
    localStringBuilder.append(" fileName TEXT");
    localStringBuilder.append(", ");
    locala.columns[3] = "indexBitData";
    locala.IhC.put("indexBitData", "BLOB");
    localStringBuilder.append(" indexBitData BLOB");
    localStringBuilder.append(", ");
    locala.columns[4] = "fileCacheComplete";
    locala.IhC.put("fileCacheComplete", "INTEGER");
    localStringBuilder.append(" fileCacheComplete INTEGER");
    localStringBuilder.append(", ");
    locala.columns[5] = "pieceFileMIMEType";
    locala.IhC.put("pieceFileMIMEType", "TEXT");
    localStringBuilder.append(" pieceFileMIMEType TEXT");
    localStringBuilder.append(", ");
    locala.columns[6] = "removeDirtyBit";
    locala.IhC.put("removeDirtyBit", "INTEGER");
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
      if (flH != k) {
        break label65;
      }
      this.field_musicId = paramCursor.getString(i);
      this.fkX = true;
    }
    for (;;)
    {
      i += 1;
      break label20;
      break;
      label65:
      if (foa == k) {
        this.field_musicUrl = paramCursor.getString(i);
      } else if (eXb == k) {
        this.field_fileName = paramCursor.getString(i);
      } else if (fob == k) {
        this.field_indexBitData = paramCursor.getBlob(i);
      } else if (foc == k) {
        this.field_fileCacheComplete = paramCursor.getInt(i);
      } else if (fod == k) {
        this.field_pieceFileMIMEType = paramCursor.getString(i);
      } else if (foe == k) {
        this.field_removeDirtyBit = paramCursor.getInt(i);
      } else if (rowid_HASHCODE == k) {
        this.systemRowid = paramCursor.getLong(i);
      }
    }
  }
  
  public ContentValues convertTo()
  {
    ContentValues localContentValues = new ContentValues();
    if (this.fkX) {
      localContentValues.put("musicId", this.field_musicId);
    }
    if (this.fnV) {
      localContentValues.put("musicUrl", this.field_musicUrl);
    }
    if (this.eWy) {
      localContentValues.put("fileName", this.field_fileName);
    }
    if (this.fnW) {
      localContentValues.put("indexBitData", this.field_indexBitData);
    }
    if (this.fnX) {
      localContentValues.put("fileCacheComplete", Integer.valueOf(this.field_fileCacheComplete));
    }
    if (this.fnY) {
      localContentValues.put("pieceFileMIMEType", this.field_pieceFileMIMEType);
    }
    if (this.fnZ) {
      localContentValues.put("removeDirtyBit", Integer.valueOf(this.field_removeDirtyBit));
    }
    if (this.systemRowid > 0L) {
      localContentValues.put("rowid", Long.valueOf(this.systemRowid));
    }
    return localContentValues;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.g.c.ey
 * JD-Core Version:    0.7.0.1
 */