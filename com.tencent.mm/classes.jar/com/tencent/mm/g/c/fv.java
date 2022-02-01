package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;
import com.tencent.mm.sdk.e.c.a;
import java.lang.reflect.Field;
import java.util.Map;

public abstract class fv
  extends c
{
  public static final String[] INDEX_CREATE = new String[0];
  private static final int eQG = "timeStamp".hashCode();
  private static final int fbR = "baseItemData".hashCode();
  private static final int fbS = "storyLocalId".hashCode();
  private static final int fbT = "mixFlag".hashCode();
  private static final int fbU = "mixRetryTime".hashCode();
  private static final int fbV = "available".hashCode();
  private static final int rowid_HASHCODE = "rowid".hashCode();
  private boolean eQA;
  private boolean fbM;
  private boolean fbN;
  private boolean fbO;
  private boolean fbP;
  private boolean fbQ;
  public int field_available;
  public byte[] field_baseItemData;
  public int field_mixFlag;
  public int field_mixRetryTime;
  public int field_storyLocalId;
  public long field_timeStamp;
  
  public static c.a Th()
  {
    c.a locala = new c.a();
    locala.GvF = new Field[6];
    locala.columns = new String[7];
    StringBuilder localStringBuilder = new StringBuilder();
    locala.columns[0] = "baseItemData";
    locala.GvH.put("baseItemData", "BLOB");
    localStringBuilder.append(" baseItemData BLOB");
    localStringBuilder.append(", ");
    locala.columns[1] = "timeStamp";
    locala.GvH.put("timeStamp", "LONG");
    localStringBuilder.append(" timeStamp LONG");
    localStringBuilder.append(", ");
    locala.columns[2] = "storyLocalId";
    locala.GvH.put("storyLocalId", "INTEGER");
    localStringBuilder.append(" storyLocalId INTEGER");
    localStringBuilder.append(", ");
    locala.columns[3] = "mixFlag";
    locala.GvH.put("mixFlag", "INTEGER");
    localStringBuilder.append(" mixFlag INTEGER");
    localStringBuilder.append(", ");
    locala.columns[4] = "mixRetryTime";
    locala.GvH.put("mixRetryTime", "INTEGER");
    localStringBuilder.append(" mixRetryTime INTEGER");
    localStringBuilder.append(", ");
    locala.columns[5] = "available";
    locala.GvH.put("available", "INTEGER");
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
      if (fbR != k) {
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
      if (eQG == k) {
        this.field_timeStamp = paramCursor.getLong(i);
      } else if (fbS == k) {
        this.field_storyLocalId = paramCursor.getInt(i);
      } else if (fbT == k) {
        this.field_mixFlag = paramCursor.getInt(i);
      } else if (fbU == k) {
        this.field_mixRetryTime = paramCursor.getInt(i);
      } else if (fbV == k) {
        this.field_available = paramCursor.getInt(i);
      } else if (rowid_HASHCODE == k) {
        this.systemRowid = paramCursor.getLong(i);
      }
    }
  }
  
  public ContentValues convertTo()
  {
    ContentValues localContentValues = new ContentValues();
    if (this.fbM) {
      localContentValues.put("baseItemData", this.field_baseItemData);
    }
    if (this.eQA) {
      localContentValues.put("timeStamp", Long.valueOf(this.field_timeStamp));
    }
    if (this.fbN) {
      localContentValues.put("storyLocalId", Integer.valueOf(this.field_storyLocalId));
    }
    if (this.fbO) {
      localContentValues.put("mixFlag", Integer.valueOf(this.field_mixFlag));
    }
    if (this.fbP) {
      localContentValues.put("mixRetryTime", Integer.valueOf(this.field_mixRetryTime));
    }
    if (this.fbQ) {
      localContentValues.put("available", Integer.valueOf(this.field_available));
    }
    if (this.systemRowid > 0L) {
      localContentValues.put("rowid", Long.valueOf(this.systemRowid));
    }
    return localContentValues;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.g.c.fv
 * JD-Core Version:    0.7.0.1
 */