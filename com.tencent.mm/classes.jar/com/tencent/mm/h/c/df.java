package com.tencent.mm.h.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;
import com.tencent.mm.sdk.e.c.a;
import java.lang.reflect.Field;
import java.util.Map;

public abstract class df
  extends c
{
  private static final int cJh = "fileName".hashCode();
  private static final int cRO;
  private static final int cTF;
  private static final int cTG = "indexBitData".hashCode();
  private static final int cTH = "fileCacheComplete".hashCode();
  private static final int cTI = "pieceFileMIMEType".hashCode();
  public static final String[] cqY = new String[0];
  private static final int crh = "rowid".hashCode();
  private boolean cIM = true;
  private boolean cRh = true;
  private boolean cTB = true;
  private boolean cTC = true;
  private boolean cTD = true;
  private boolean cTE = true;
  public int field_fileCacheComplete;
  public String field_fileName;
  public byte[] field_indexBitData;
  public String field_musicId;
  public String field_musicUrl;
  public String field_pieceFileMIMEType;
  
  static
  {
    cRO = "musicId".hashCode();
    cTF = "musicUrl".hashCode();
  }
  
  public static c.a vg()
  {
    c.a locala = new c.a();
    locala.ujL = new Field[6];
    locala.columns = new String[7];
    StringBuilder localStringBuilder = new StringBuilder();
    locala.columns[0] = "musicId";
    locala.ujN.put("musicId", "TEXT PRIMARY KEY ");
    localStringBuilder.append(" musicId TEXT PRIMARY KEY ");
    localStringBuilder.append(", ");
    locala.ujM = "musicId";
    locala.columns[1] = "musicUrl";
    locala.ujN.put("musicUrl", "TEXT");
    localStringBuilder.append(" musicUrl TEXT");
    localStringBuilder.append(", ");
    locala.columns[2] = "fileName";
    locala.ujN.put("fileName", "TEXT");
    localStringBuilder.append(" fileName TEXT");
    localStringBuilder.append(", ");
    locala.columns[3] = "indexBitData";
    locala.ujN.put("indexBitData", "BLOB");
    localStringBuilder.append(" indexBitData BLOB");
    localStringBuilder.append(", ");
    locala.columns[4] = "fileCacheComplete";
    locala.ujN.put("fileCacheComplete", "INTEGER");
    localStringBuilder.append(" fileCacheComplete INTEGER");
    localStringBuilder.append(", ");
    locala.columns[5] = "pieceFileMIMEType";
    locala.ujN.put("pieceFileMIMEType", "TEXT");
    localStringBuilder.append(" pieceFileMIMEType TEXT");
    locala.columns[6] = "rowid";
    locala.sql = localStringBuilder.toString();
    return locala;
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
      if (cRO != k) {
        break label65;
      }
      this.field_musicId = paramCursor.getString(i);
      this.cRh = true;
    }
    for (;;)
    {
      i += 1;
      break label20;
      break;
      label65:
      if (cTF == k) {
        this.field_musicUrl = paramCursor.getString(i);
      } else if (cJh == k) {
        this.field_fileName = paramCursor.getString(i);
      } else if (cTG == k) {
        this.field_indexBitData = paramCursor.getBlob(i);
      } else if (cTH == k) {
        this.field_fileCacheComplete = paramCursor.getInt(i);
      } else if (cTI == k) {
        this.field_pieceFileMIMEType = paramCursor.getString(i);
      } else if (crh == k) {
        this.ujK = paramCursor.getLong(i);
      }
    }
  }
  
  public final ContentValues vf()
  {
    ContentValues localContentValues = new ContentValues();
    if (this.cRh) {
      localContentValues.put("musicId", this.field_musicId);
    }
    if (this.cTB) {
      localContentValues.put("musicUrl", this.field_musicUrl);
    }
    if (this.cIM) {
      localContentValues.put("fileName", this.field_fileName);
    }
    if (this.cTC) {
      localContentValues.put("indexBitData", this.field_indexBitData);
    }
    if (this.cTD) {
      localContentValues.put("fileCacheComplete", Integer.valueOf(this.field_fileCacheComplete));
    }
    if (this.cTE) {
      localContentValues.put("pieceFileMIMEType", this.field_pieceFileMIMEType);
    }
    if (this.ujK > 0L) {
      localContentValues.put("rowid", Long.valueOf(this.ujK));
    }
    return localContentValues;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.h.c.df
 * JD-Core Version:    0.7.0.1
 */