package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;
import com.tencent.mm.sdk.e.c.a;
import java.lang.reflect.Field;
import java.util.Map;

public abstract class gf
  extends c
{
  public static final String[] INDEX_CREATE = new String[0];
  private static final int fjd = "timeStamp".hashCode();
  private static final int fuf = "baseItemData".hashCode();
  private static final int fug = "storyLocalId".hashCode();
  private static final int fuh = "mixFlag".hashCode();
  private static final int fui = "mixRetryTime".hashCode();
  private static final int fuj = "available".hashCode();
  private static final int rowid_HASHCODE = "rowid".hashCode();
  private boolean fiX;
  public int field_available;
  public byte[] field_baseItemData;
  public int field_mixFlag;
  public int field_mixRetryTime;
  public int field_storyLocalId;
  public long field_timeStamp;
  private boolean fua;
  private boolean fub;
  private boolean fuc;
  private boolean fud;
  private boolean fue;
  
  public static c.a Vv()
  {
    c.a locala = new c.a();
    locala.IhA = new Field[6];
    locala.columns = new String[7];
    StringBuilder localStringBuilder = new StringBuilder();
    locala.columns[0] = "baseItemData";
    locala.IhC.put("baseItemData", "BLOB");
    localStringBuilder.append(" baseItemData BLOB");
    localStringBuilder.append(", ");
    locala.columns[1] = "timeStamp";
    locala.IhC.put("timeStamp", "LONG");
    localStringBuilder.append(" timeStamp LONG");
    localStringBuilder.append(", ");
    locala.columns[2] = "storyLocalId";
    locala.IhC.put("storyLocalId", "INTEGER");
    localStringBuilder.append(" storyLocalId INTEGER");
    localStringBuilder.append(", ");
    locala.columns[3] = "mixFlag";
    locala.IhC.put("mixFlag", "INTEGER");
    localStringBuilder.append(" mixFlag INTEGER");
    localStringBuilder.append(", ");
    locala.columns[4] = "mixRetryTime";
    locala.IhC.put("mixRetryTime", "INTEGER");
    localStringBuilder.append(" mixRetryTime INTEGER");
    localStringBuilder.append(", ");
    locala.columns[5] = "available";
    locala.IhC.put("available", "INTEGER");
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
      if (fuf != k) {
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
      if (fjd == k) {
        this.field_timeStamp = paramCursor.getLong(i);
      } else if (fug == k) {
        this.field_storyLocalId = paramCursor.getInt(i);
      } else if (fuh == k) {
        this.field_mixFlag = paramCursor.getInt(i);
      } else if (fui == k) {
        this.field_mixRetryTime = paramCursor.getInt(i);
      } else if (fuj == k) {
        this.field_available = paramCursor.getInt(i);
      } else if (rowid_HASHCODE == k) {
        this.systemRowid = paramCursor.getLong(i);
      }
    }
  }
  
  public ContentValues convertTo()
  {
    ContentValues localContentValues = new ContentValues();
    if (this.fua) {
      localContentValues.put("baseItemData", this.field_baseItemData);
    }
    if (this.fiX) {
      localContentValues.put("timeStamp", Long.valueOf(this.field_timeStamp));
    }
    if (this.fub) {
      localContentValues.put("storyLocalId", Integer.valueOf(this.field_storyLocalId));
    }
    if (this.fuc) {
      localContentValues.put("mixFlag", Integer.valueOf(this.field_mixFlag));
    }
    if (this.fud) {
      localContentValues.put("mixRetryTime", Integer.valueOf(this.field_mixRetryTime));
    }
    if (this.fue) {
      localContentValues.put("available", Integer.valueOf(this.field_available));
    }
    if (this.systemRowid > 0L) {
      localContentValues.put("rowid", Long.valueOf(this.systemRowid));
    }
    return localContentValues;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.g.c.gf
 * JD-Core Version:    0.7.0.1
 */