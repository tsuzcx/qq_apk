package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;
import com.tencent.mm.sdk.e.c.a;
import java.lang.reflect.Field;
import java.util.Map;

public abstract class fr
  extends c
{
  public static final String[] INDEX_CREATE = new String[0];
  private static final int eYE = "baseItemData".hashCode();
  private static final int eYF = "timeStamp".hashCode();
  private static final int eYG = "storyLocalId".hashCode();
  private static final int eYH = "mixFlag".hashCode();
  private static final int eYI = "mixRetryTime".hashCode();
  private static final int eYJ = "available".hashCode();
  private static final int rowid_HASHCODE = "rowid".hashCode();
  private boolean eYA;
  private boolean eYB;
  private boolean eYC;
  private boolean eYD;
  private boolean eYy;
  private boolean eYz;
  public int field_available;
  public byte[] field_baseItemData;
  public int field_mixFlag;
  public int field_mixRetryTime;
  public int field_storyLocalId;
  public long field_timeStamp;
  
  public static c.a So()
  {
    c.a locala = new c.a();
    locala.EYt = new Field[6];
    locala.columns = new String[7];
    StringBuilder localStringBuilder = new StringBuilder();
    locala.columns[0] = "baseItemData";
    locala.EYv.put("baseItemData", "BLOB");
    localStringBuilder.append(" baseItemData BLOB");
    localStringBuilder.append(", ");
    locala.columns[1] = "timeStamp";
    locala.EYv.put("timeStamp", "LONG");
    localStringBuilder.append(" timeStamp LONG");
    localStringBuilder.append(", ");
    locala.columns[2] = "storyLocalId";
    locala.EYv.put("storyLocalId", "INTEGER");
    localStringBuilder.append(" storyLocalId INTEGER");
    localStringBuilder.append(", ");
    locala.columns[3] = "mixFlag";
    locala.EYv.put("mixFlag", "INTEGER");
    localStringBuilder.append(" mixFlag INTEGER");
    localStringBuilder.append(", ");
    locala.columns[4] = "mixRetryTime";
    locala.EYv.put("mixRetryTime", "INTEGER");
    localStringBuilder.append(" mixRetryTime INTEGER");
    localStringBuilder.append(", ");
    locala.columns[5] = "available";
    locala.EYv.put("available", "INTEGER");
    localStringBuilder.append(" available INTEGER");
    locala.columns[6] = "rowid";
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
      if (eYE != k) {
        break label60;
      }
      this.field_baseItemData = paramCursor.getBlob(i);
    }
    for (;;)
    {
      i += 1;
      break label20;
      break;
      label60:
      if (eYF == k) {
        this.field_timeStamp = paramCursor.getLong(i);
      } else if (eYG == k) {
        this.field_storyLocalId = paramCursor.getInt(i);
      } else if (eYH == k) {
        this.field_mixFlag = paramCursor.getInt(i);
      } else if (eYI == k) {
        this.field_mixRetryTime = paramCursor.getInt(i);
      } else if (eYJ == k) {
        this.field_available = paramCursor.getInt(i);
      } else if (rowid_HASHCODE == k) {
        this.systemRowid = paramCursor.getLong(i);
      }
    }
  }
  
  public ContentValues convertTo()
  {
    ContentValues localContentValues = new ContentValues();
    if (this.eYy) {
      localContentValues.put("baseItemData", this.field_baseItemData);
    }
    if (this.eYz) {
      localContentValues.put("timeStamp", Long.valueOf(this.field_timeStamp));
    }
    if (this.eYA) {
      localContentValues.put("storyLocalId", Integer.valueOf(this.field_storyLocalId));
    }
    if (this.eYB) {
      localContentValues.put("mixFlag", Integer.valueOf(this.field_mixFlag));
    }
    if (this.eYC) {
      localContentValues.put("mixRetryTime", Integer.valueOf(this.field_mixRetryTime));
    }
    if (this.eYD) {
      localContentValues.put("available", Integer.valueOf(this.field_available));
    }
    if (this.systemRowid > 0L) {
      localContentValues.put("rowid", Long.valueOf(this.systemRowid));
    }
    return localContentValues;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.g.c.fr
 * JD-Core Version:    0.7.0.1
 */