package com.tencent.mm.f.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.storage.IAutoDBItem;
import com.tencent.mm.sdk.storage.IAutoDBItem.MAutoDBInfo;
import com.tencent.mm.sdk.storage.sql.Column;
import com.tencent.mm.sdk.storage.sql.SingleTable;
import java.lang.reflect.Field;
import java.util.Map;

public abstract class gy
  extends IAutoDBItem
{
  public static final Column C_ROWID;
  public static final String[] INDEX_CREATE = new String[0];
  public static final SingleTable TABLE = new SingleTable("StoryEditorInfo");
  public static final Column hMZ;
  public static final Column iAl;
  public static final Column iAm;
  public static final Column iAn;
  public static final Column iAo;
  public static final Column iAp;
  private static final int iAq;
  private static final int iAr = "storyLocalId".hashCode();
  private static final int iAs = "mixFlag".hashCode();
  private static final int iAt = "mixRetryTime".hashCode();
  private static final int iAu = "available".hashCode();
  private static final int ijb;
  private static final int rowid_HASHCODE = "rowid".hashCode();
  public int field_available;
  public byte[] field_baseItemData;
  public int field_mixFlag;
  public int field_mixRetryTime;
  public int field_storyLocalId;
  public long field_timeStamp;
  
  static
  {
    C_ROWID = new Column("rowid", "long", "StoryEditorInfo", "");
    iAl = new Column("baseitemdata", "byte[]", "StoryEditorInfo", "");
    hMZ = new Column("timestamp", "long", "StoryEditorInfo", "");
    iAm = new Column("storylocalid", "int", "StoryEditorInfo", "");
    iAn = new Column("mixflag", "int", "StoryEditorInfo", "");
    iAo = new Column("mixretrytime", "int", "StoryEditorInfo", "");
    iAp = new Column("available", "int", "StoryEditorInfo", "");
    iAq = "baseItemData".hashCode();
    ijb = "timeStamp".hashCode();
  }
  
  public static IAutoDBItem.MAutoDBInfo aoY()
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
    if (arrayOfString == null) {}
    for (;;)
    {
      return;
      int i = 0;
      int j = arrayOfString.length;
      while (i < j)
      {
        int k = arrayOfString[i].hashCode();
        if (iAq == k)
        {
          paramCursor.getBlob(i);
          throw null;
        }
        if (ijb == k)
        {
          paramCursor.getLong(i);
          throw null;
        }
        if (iAr == k)
        {
          paramCursor.getInt(i);
          throw null;
        }
        if (iAs == k)
        {
          paramCursor.getInt(i);
          throw null;
        }
        if (iAt == k)
        {
          paramCursor.getInt(i);
          throw null;
        }
        if (iAu == k)
        {
          paramCursor.getInt(i);
          throw null;
        }
        if (rowid_HASHCODE == k) {
          this.systemRowid = paramCursor.getLong(i);
        }
        i += 1;
      }
    }
  }
  
  public ContentValues convertTo()
  {
    new ContentValues();
    throw null;
  }
  
  public String[] getIndexCreateSQL()
  {
    return INDEX_CREATE;
  }
  
  public String getTableName()
  {
    return "StoryEditorInfo";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.f.c.gy
 * JD-Core Version:    0.7.0.1
 */