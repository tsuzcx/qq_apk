package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;
import com.tencent.mm.sdk.e.c.a;
import java.lang.reflect.Field;
import java.util.Map;

public abstract class ek
  extends c
{
  public static final String[] INDEX_CREATE = new String[0];
  private static final int eDj = "fileName".hashCode();
  private static final int eQj = "musicId".hashCode();
  private static final int eSB = "musicUrl".hashCode();
  private static final int eSC = "indexBitData".hashCode();
  private static final int eSD = "fileCacheComplete".hashCode();
  private static final int eSE = "pieceFileMIMEType".hashCode();
  private static final int eSF = "removeDirtyBit".hashCode();
  private static final int rowid_HASHCODE = "rowid".hashCode();
  private boolean eCG = true;
  private boolean ePA = true;
  private boolean eSA = true;
  private boolean eSw = true;
  private boolean eSx = true;
  private boolean eSy = true;
  private boolean eSz = true;
  public int field_fileCacheComplete;
  public String field_fileName;
  public byte[] field_indexBitData;
  public String field_musicId;
  public String field_musicUrl;
  public String field_pieceFileMIMEType;
  public int field_removeDirtyBit;
  
  public static c.a So()
  {
    c.a locala = new c.a();
    locala.EYt = new Field[7];
    locala.columns = new String[8];
    StringBuilder localStringBuilder = new StringBuilder();
    locala.columns[0] = "musicId";
    locala.EYv.put("musicId", "TEXT PRIMARY KEY ");
    localStringBuilder.append(" musicId TEXT PRIMARY KEY ");
    localStringBuilder.append(", ");
    locala.EYu = "musicId";
    locala.columns[1] = "musicUrl";
    locala.EYv.put("musicUrl", "TEXT");
    localStringBuilder.append(" musicUrl TEXT");
    localStringBuilder.append(", ");
    locala.columns[2] = "fileName";
    locala.EYv.put("fileName", "TEXT");
    localStringBuilder.append(" fileName TEXT");
    localStringBuilder.append(", ");
    locala.columns[3] = "indexBitData";
    locala.EYv.put("indexBitData", "BLOB");
    localStringBuilder.append(" indexBitData BLOB");
    localStringBuilder.append(", ");
    locala.columns[4] = "fileCacheComplete";
    locala.EYv.put("fileCacheComplete", "INTEGER");
    localStringBuilder.append(" fileCacheComplete INTEGER");
    localStringBuilder.append(", ");
    locala.columns[5] = "pieceFileMIMEType";
    locala.EYv.put("pieceFileMIMEType", "TEXT");
    localStringBuilder.append(" pieceFileMIMEType TEXT");
    localStringBuilder.append(", ");
    locala.columns[6] = "removeDirtyBit";
    locala.EYv.put("removeDirtyBit", "INTEGER");
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
      if (eQj != k) {
        break label65;
      }
      this.field_musicId = paramCursor.getString(i);
      this.ePA = true;
    }
    for (;;)
    {
      i += 1;
      break label20;
      break;
      label65:
      if (eSB == k) {
        this.field_musicUrl = paramCursor.getString(i);
      } else if (eDj == k) {
        this.field_fileName = paramCursor.getString(i);
      } else if (eSC == k) {
        this.field_indexBitData = paramCursor.getBlob(i);
      } else if (eSD == k) {
        this.field_fileCacheComplete = paramCursor.getInt(i);
      } else if (eSE == k) {
        this.field_pieceFileMIMEType = paramCursor.getString(i);
      } else if (eSF == k) {
        this.field_removeDirtyBit = paramCursor.getInt(i);
      } else if (rowid_HASHCODE == k) {
        this.systemRowid = paramCursor.getLong(i);
      }
    }
  }
  
  public ContentValues convertTo()
  {
    ContentValues localContentValues = new ContentValues();
    if (this.ePA) {
      localContentValues.put("musicId", this.field_musicId);
    }
    if (this.eSw) {
      localContentValues.put("musicUrl", this.field_musicUrl);
    }
    if (this.eCG) {
      localContentValues.put("fileName", this.field_fileName);
    }
    if (this.eSx) {
      localContentValues.put("indexBitData", this.field_indexBitData);
    }
    if (this.eSy) {
      localContentValues.put("fileCacheComplete", Integer.valueOf(this.field_fileCacheComplete));
    }
    if (this.eSz) {
      localContentValues.put("pieceFileMIMEType", this.field_pieceFileMIMEType);
    }
    if (this.eSA) {
      localContentValues.put("removeDirtyBit", Integer.valueOf(this.field_removeDirtyBit));
    }
    if (this.systemRowid > 0L) {
      localContentValues.put("rowid", Long.valueOf(this.systemRowid));
    }
    return localContentValues;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.g.c.ek
 * JD-Core Version:    0.7.0.1
 */