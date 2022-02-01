package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.storage.IAutoDBItem;
import com.tencent.mm.sdk.storage.IAutoDBItem.MAutoDBInfo;
import java.lang.reflect.Field;
import java.util.Map;

public abstract class gr
  extends IAutoDBItem
{
  public static final String[] INDEX_CREATE = new String[0];
  private static final int fPE = "timeStamp".hashCode();
  private static final int gaX = "baseItemData".hashCode();
  private static final int gaY = "storyLocalId".hashCode();
  private static final int gaZ = "mixFlag".hashCode();
  private static final int gba = "mixRetryTime".hashCode();
  private static final int gbb = "available".hashCode();
  private static final int rowid_HASHCODE = "rowid".hashCode();
  private boolean fPy;
  public int field_available;
  public byte[] field_baseItemData;
  public int field_mixFlag;
  public int field_mixRetryTime;
  public int field_storyLocalId;
  public long field_timeStamp;
  private boolean gaS;
  private boolean gaT;
  private boolean gaU;
  private boolean gaV;
  private boolean gaW;
  
  public static IAutoDBItem.MAutoDBInfo ajs()
  {
    IAutoDBItem.MAutoDBInfo localMAutoDBInfo = new IAutoDBItem.MAutoDBInfo();
    localMAutoDBInfo.fields = new Field[6];
    localMAutoDBInfo.columns = new String[7];
    StringBuilder localStringBuilder = new StringBuilder();
    localMAutoDBInfo.columns[0] = "baseItemData";
    localMAutoDBInfo.colsMap.put("baseItemData", "BLOB");
    localStringBuilder.append(" baseItemData BLOB");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[1] = "timeStamp";
    localMAutoDBInfo.colsMap.put("timeStamp", "LONG");
    localStringBuilder.append(" timeStamp LONG");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[2] = "storyLocalId";
    localMAutoDBInfo.colsMap.put("storyLocalId", "INTEGER");
    localStringBuilder.append(" storyLocalId INTEGER");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[3] = "mixFlag";
    localMAutoDBInfo.colsMap.put("mixFlag", "INTEGER");
    localStringBuilder.append(" mixFlag INTEGER");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[4] = "mixRetryTime";
    localMAutoDBInfo.colsMap.put("mixRetryTime", "INTEGER");
    localStringBuilder.append(" mixRetryTime INTEGER");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[5] = "available";
    localMAutoDBInfo.colsMap.put("available", "INTEGER");
    localStringBuilder.append(" available INTEGER");
    localMAutoDBInfo.columns[6] = "rowid";
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
      if (gaX != k) {
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
      if (fPE == k) {
        this.field_timeStamp = paramCursor.getLong(i);
      } else if (gaY == k) {
        this.field_storyLocalId = paramCursor.getInt(i);
      } else if (gaZ == k) {
        this.field_mixFlag = paramCursor.getInt(i);
      } else if (gba == k) {
        this.field_mixRetryTime = paramCursor.getInt(i);
      } else if (gbb == k) {
        this.field_available = paramCursor.getInt(i);
      } else if (rowid_HASHCODE == k) {
        this.systemRowid = paramCursor.getLong(i);
      }
    }
  }
  
  public ContentValues convertTo()
  {
    ContentValues localContentValues = new ContentValues();
    if (this.gaS) {
      localContentValues.put("baseItemData", this.field_baseItemData);
    }
    if (this.fPy) {
      localContentValues.put("timeStamp", Long.valueOf(this.field_timeStamp));
    }
    if (this.gaT) {
      localContentValues.put("storyLocalId", Integer.valueOf(this.field_storyLocalId));
    }
    if (this.gaU) {
      localContentValues.put("mixFlag", Integer.valueOf(this.field_mixFlag));
    }
    if (this.gaV) {
      localContentValues.put("mixRetryTime", Integer.valueOf(this.field_mixRetryTime));
    }
    if (this.gaW) {
      localContentValues.put("available", Integer.valueOf(this.field_available));
    }
    if (this.systemRowid > 0L) {
      localContentValues.put("rowid", Long.valueOf(this.systemRowid));
    }
    return localContentValues;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.g.c.gr
 * JD-Core Version:    0.7.0.1
 */