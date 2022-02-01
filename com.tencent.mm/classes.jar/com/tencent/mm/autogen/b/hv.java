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

public abstract class hv
  extends IAutoDBItem
{
  public static final IAutoDBItem.MAutoDBInfo DB_INFO = aJm();
  public static final String[] INDEX_CREATE;
  public static final Column ROWID;
  public static final SingleTable TABLE = new SingleTable("StoryRoomInfo");
  private static final int kBQ;
  public static final Column kwh;
  public static final Column lbY;
  private static final int lcA;
  public static final Column lcO;
  public static final Column lcP;
  public static final Column lcQ;
  private static final int lcU;
  private static final int lcV;
  private static final int lcW;
  private static final StorageObserverOwner<hv> observerOwner = new StorageObserverOwner();
  private static final int rowid_HASHCODE;
  public byte[] field_extbuf;
  public String field_newStoryList;
  public long field_nextSyncTime;
  public String field_roomname;
  public int field_userStoryFlag;
  private boolean kBF = true;
  private boolean lcR = true;
  private boolean lcS = true;
  private boolean lcT = true;
  private boolean lcm = true;
  
  static
  {
    ROWID = new Column("rowid", "long", TABLE.getName(), "");
    kwh = new Column("roomname", "string", TABLE.getName(), "");
    lbY = new Column("userStoryFlag", "int", TABLE.getName(), "");
    lcO = new Column("newStoryList", "string", TABLE.getName(), "");
    lcP = new Column("extbuf", "byte[]", TABLE.getName(), "");
    lcQ = new Column("nextSyncTime", "long", TABLE.getName(), "");
    INDEX_CREATE = new String[0];
    kBQ = "roomname".hashCode();
    lcA = "userStoryFlag".hashCode();
    lcU = "newStoryList".hashCode();
    lcV = "extbuf".hashCode();
    lcW = "nextSyncTime".hashCode();
    rowid_HASHCODE = "rowid".hashCode();
  }
  
  public static IAutoDBItem.MAutoDBInfo aJm()
  {
    IAutoDBItem.MAutoDBInfo localMAutoDBInfo = new IAutoDBItem.MAutoDBInfo();
    localMAutoDBInfo.fields = new Field[5];
    localMAutoDBInfo.columns = new String[6];
    StringBuilder localStringBuilder = new StringBuilder();
    localMAutoDBInfo.columns[0] = "roomname";
    localMAutoDBInfo.colsMap.put("roomname", "TEXT default ''  PRIMARY KEY ");
    localStringBuilder.append(" roomname TEXT default ''  PRIMARY KEY ");
    localStringBuilder.append(", ");
    localMAutoDBInfo.primaryKey = "roomname";
    localMAutoDBInfo.columns[1] = "userStoryFlag";
    localMAutoDBInfo.colsMap.put("userStoryFlag", "INTEGER");
    localStringBuilder.append(" userStoryFlag INTEGER");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[2] = "newStoryList";
    localMAutoDBInfo.colsMap.put("newStoryList", "TEXT");
    localStringBuilder.append(" newStoryList TEXT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[3] = "extbuf";
    localMAutoDBInfo.colsMap.put("extbuf", "BLOB");
    localStringBuilder.append(" extbuf BLOB");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[4] = "nextSyncTime";
    localMAutoDBInfo.colsMap.put("nextSyncTime", "LONG");
    localStringBuilder.append(" nextSyncTime LONG");
    localMAutoDBInfo.columns[5] = "rowid";
    localMAutoDBInfo.sql = localStringBuilder.toString();
    if (localMAutoDBInfo.primaryKey == null) {
      localMAutoDBInfo.primaryKey = "rowid";
    }
    return localMAutoDBInfo;
  }
  
  public void convertFrom(ContentValues paramContentValues, boolean paramBoolean)
  {
    if (paramContentValues.containsKey("roomname"))
    {
      this.field_roomname = paramContentValues.getAsString("roomname");
      if (paramBoolean) {
        this.kBF = true;
      }
    }
    if (paramContentValues.containsKey("userStoryFlag"))
    {
      this.field_userStoryFlag = paramContentValues.getAsInteger("userStoryFlag").intValue();
      if (paramBoolean) {
        this.lcm = true;
      }
    }
    if (paramContentValues.containsKey("newStoryList"))
    {
      this.field_newStoryList = paramContentValues.getAsString("newStoryList");
      if (paramBoolean) {
        this.lcR = true;
      }
    }
    if (paramContentValues.containsKey("extbuf"))
    {
      this.field_extbuf = paramContentValues.getAsByteArray("extbuf");
      if (paramBoolean) {
        this.lcS = true;
      }
    }
    if (paramContentValues.containsKey("nextSyncTime"))
    {
      this.field_nextSyncTime = paramContentValues.getAsLong("nextSyncTime").longValue();
      if (paramBoolean) {
        this.lcT = true;
      }
    }
    if (paramContentValues.containsKey("rowid")) {
      this.systemRowid = paramContentValues.getAsLong("rowid").longValue();
    }
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
      if (kBQ != k) {
        break label65;
      }
      this.field_roomname = paramCursor.getString(i);
      this.kBF = true;
    }
    for (;;)
    {
      i += 1;
      break label20;
      break;
      label65:
      if (lcA == k) {
        this.field_userStoryFlag = paramCursor.getInt(i);
      } else if (lcU == k) {
        this.field_newStoryList = paramCursor.getString(i);
      } else if (lcV == k) {
        this.field_extbuf = paramCursor.getBlob(i);
      } else if (lcW == k) {
        this.field_nextSyncTime = paramCursor.getLong(i);
      } else if (rowid_HASHCODE == k) {
        this.systemRowid = paramCursor.getLong(i);
      }
    }
  }
  
  public ContentValues convertTo()
  {
    ContentValues localContentValues = new ContentValues();
    if (this.field_roomname == null) {
      this.field_roomname = "";
    }
    if (this.kBF) {
      localContentValues.put("roomname", this.field_roomname);
    }
    if (this.lcm) {
      localContentValues.put("userStoryFlag", Integer.valueOf(this.field_userStoryFlag));
    }
    if (this.lcR) {
      localContentValues.put("newStoryList", this.field_newStoryList);
    }
    if (this.lcS) {
      localContentValues.put("extbuf", this.field_extbuf);
    }
    if (this.lcT) {
      localContentValues.put("nextSyncTime", Long.valueOf(this.field_nextSyncTime));
    }
    if (this.systemRowid > 0L) {
      localContentValues.put("rowid", Long.valueOf(this.systemRowid));
    }
    return localContentValues;
  }
  
  public IAutoDBItem.MAutoDBInfo getDBInfo()
  {
    return DB_INFO;
  }
  
  public String[] getIndexCreateSQL()
  {
    return INDEX_CREATE;
  }
  
  public StorageObserverOwner<? extends hv> getObserverOwner()
  {
    return observerOwner;
  }
  
  public Object getPrimaryKeyValue()
  {
    return this.field_roomname;
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
 * Qualified Name:     com.tencent.mm.autogen.b.hv
 * JD-Core Version:    0.7.0.1
 */