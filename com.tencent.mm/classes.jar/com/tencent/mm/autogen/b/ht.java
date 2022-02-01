package com.tencent.mm.autogen.b;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.storage.IAutoDBItem;
import com.tencent.mm.sdk.storage.IAutoDBItem.MAutoDBInfo;
import com.tencent.mm.sdk.storage.observer.StorageObserverOwner;
import com.tencent.mm.sdk.storage.sql.Column;
import com.tencent.mm.sdk.storage.sql.SingleTable;
import java.lang.reflect.Field;
import java.util.Map;

public abstract class ht
  extends IAutoDBItem
{
  public static final IAutoDBItem.MAutoDBInfo DB_INFO = aJm();
  public static final String[] INDEX_CREATE;
  public static final Column ROWID;
  public static final SingleTable TABLE = new SingleTable("StoryEditorInfo");
  private static final int kIz;
  public static final Column kkd;
  public static final Column lbO;
  public static final Column lbP;
  public static final Column lbQ;
  public static final Column lbR;
  public static final Column lbS;
  private static final int lbT;
  private static final int lbU;
  private static final int lbV;
  private static final int lbW;
  private static final int lbX;
  private static final StorageObserverOwner<ht> observerOwner = new StorageObserverOwner();
  private static final int rowid_HASHCODE;
  public int field_available;
  public byte[] field_baseItemData;
  public int field_mixFlag;
  public int field_mixRetryTime;
  public int field_storyLocalId;
  public long field_timeStamp;
  
  static
  {
    ROWID = new Column("rowid", "long", TABLE.getName(), "");
    lbO = new Column("baseItemData", "byte[]", TABLE.getName(), "");
    kkd = new Column("timeStamp", "long", TABLE.getName(), "");
    lbP = new Column("storyLocalId", "int", TABLE.getName(), "");
    lbQ = new Column("mixFlag", "int", TABLE.getName(), "");
    lbR = new Column("mixRetryTime", "int", TABLE.getName(), "");
    lbS = new Column("available", "int", TABLE.getName(), "");
    INDEX_CREATE = new String[0];
    lbT = "baseItemData".hashCode();
    kIz = "timeStamp".hashCode();
    lbU = "storyLocalId".hashCode();
    lbV = "mixFlag".hashCode();
    lbW = "mixRetryTime".hashCode();
    lbX = "available".hashCode();
    rowid_HASHCODE = "rowid".hashCode();
  }
  
  public static IAutoDBItem.MAutoDBInfo aJm()
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
    if (localMAutoDBInfo.primaryKey == null) {
      localMAutoDBInfo.primaryKey = "rowid";
    }
    return localMAutoDBInfo;
  }
  
  public void convertFrom(ContentValues paramContentValues, boolean paramBoolean)
  {
    if (paramContentValues.containsKey("baseItemData"))
    {
      paramContentValues.getAsByteArray("baseItemData");
      throw null;
    }
    if (paramContentValues.containsKey("timeStamp"))
    {
      paramContentValues.getAsLong("timeStamp").longValue();
      throw null;
    }
    if (paramContentValues.containsKey("storyLocalId"))
    {
      paramContentValues.getAsInteger("storyLocalId").intValue();
      throw null;
    }
    if (paramContentValues.containsKey("mixFlag"))
    {
      paramContentValues.getAsInteger("mixFlag").intValue();
      throw null;
    }
    if (paramContentValues.containsKey("mixRetryTime"))
    {
      paramContentValues.getAsInteger("mixRetryTime").intValue();
      throw null;
    }
    if (paramContentValues.containsKey("available"))
    {
      paramContentValues.getAsInteger("available").intValue();
      throw null;
    }
    if (paramContentValues.containsKey("rowid")) {
      this.systemRowid = paramContentValues.getAsLong("rowid").longValue();
    }
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
        if (lbT == k)
        {
          paramCursor.getBlob(i);
          throw null;
        }
        if (kIz == k)
        {
          paramCursor.getLong(i);
          throw null;
        }
        if (lbU == k)
        {
          paramCursor.getInt(i);
          throw null;
        }
        if (lbV == k)
        {
          paramCursor.getInt(i);
          throw null;
        }
        if (lbW == k)
        {
          paramCursor.getInt(i);
          throw null;
        }
        if (lbX == k)
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
  
  public IAutoDBItem.MAutoDBInfo getDBInfo()
  {
    return DB_INFO;
  }
  
  public String[] getIndexCreateSQL()
  {
    return INDEX_CREATE;
  }
  
  public StorageObserverOwner<? extends ht> getObserverOwner()
  {
    return observerOwner;
  }
  
  public Object getPrimaryKeyValue()
  {
    return Long.valueOf(this.systemRowid);
  }
  
  public SingleTable getTable()
  {
    return TABLE;
  }
  
  public String getTableName()
  {
    return TABLE.getName();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.autogen.b.ht
 * JD-Core Version:    0.7.0.1
 */