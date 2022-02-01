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

public abstract class hq
  extends IAutoDBItem
{
  public static final IAutoDBItem.MAutoDBInfo DB_INFO = aJm();
  public static final String[] INDEX_CREATE;
  public static final Column ROWID;
  public static final SingleTable TABLE = new SingleTable("SnsWsFoldGroupDetail");
  public static final Column kel;
  private static final int kfO;
  public static final Column lbr;
  public static final Column lbt;
  private static final int lbw;
  private static final int lbx;
  private static final StorageObserverOwner<hq> observerOwner = new StorageObserverOwner();
  private static final int rowid_HASHCODE;
  public long field_groupId;
  public byte[] field_groupStrcut;
  public int field_groupTime;
  private boolean kfa = true;
  private boolean lbu = true;
  private boolean lbv = true;
  
  static
  {
    ROWID = new Column("rowid", "long", TABLE.getName(), "");
    kel = new Column("groupId", "long", TABLE.getName(), "");
    lbr = new Column("groupTime", "int", TABLE.getName(), "");
    lbt = new Column("groupStrcut", "byte[]", TABLE.getName(), "");
    INDEX_CREATE = new String[0];
    kfO = "groupId".hashCode();
    lbw = "groupTime".hashCode();
    lbx = "groupStrcut".hashCode();
    rowid_HASHCODE = "rowid".hashCode();
  }
  
  public static IAutoDBItem.MAutoDBInfo aJm()
  {
    IAutoDBItem.MAutoDBInfo localMAutoDBInfo = new IAutoDBItem.MAutoDBInfo();
    localMAutoDBInfo.fields = new Field[3];
    localMAutoDBInfo.columns = new String[4];
    StringBuilder localStringBuilder = new StringBuilder();
    localMAutoDBInfo.columns[0] = "groupId";
    localMAutoDBInfo.colsMap.put("groupId", "LONG PRIMARY KEY ");
    localStringBuilder.append(" groupId LONG PRIMARY KEY ");
    localStringBuilder.append(", ");
    localMAutoDBInfo.primaryKey = "groupId";
    localMAutoDBInfo.columns[1] = "groupTime";
    localMAutoDBInfo.colsMap.put("groupTime", "INTEGER");
    localStringBuilder.append(" groupTime INTEGER");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[2] = "groupStrcut";
    localMAutoDBInfo.colsMap.put("groupStrcut", "BLOB");
    localStringBuilder.append(" groupStrcut BLOB");
    localMAutoDBInfo.columns[3] = "rowid";
    localMAutoDBInfo.sql = localStringBuilder.toString();
    if (localMAutoDBInfo.primaryKey == null) {
      localMAutoDBInfo.primaryKey = "rowid";
    }
    return localMAutoDBInfo;
  }
  
  public void convertFrom(ContentValues paramContentValues, boolean paramBoolean)
  {
    if (paramContentValues.containsKey("groupId"))
    {
      this.field_groupId = paramContentValues.getAsLong("groupId").longValue();
      if (paramBoolean) {
        this.kfa = true;
      }
    }
    if (paramContentValues.containsKey("groupTime"))
    {
      this.field_groupTime = paramContentValues.getAsInteger("groupTime").intValue();
      if (paramBoolean) {
        this.lbu = true;
      }
    }
    if (paramContentValues.containsKey("groupStrcut"))
    {
      this.field_groupStrcut = paramContentValues.getAsByteArray("groupStrcut");
      if (paramBoolean) {
        this.lbv = true;
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
      if (kfO != k) {
        break label65;
      }
      this.field_groupId = paramCursor.getLong(i);
      this.kfa = true;
    }
    for (;;)
    {
      i += 1;
      break label20;
      break;
      label65:
      if (lbw == k) {
        this.field_groupTime = paramCursor.getInt(i);
      } else if (lbx == k) {
        this.field_groupStrcut = paramCursor.getBlob(i);
      } else if (rowid_HASHCODE == k) {
        this.systemRowid = paramCursor.getLong(i);
      }
    }
  }
  
  public ContentValues convertTo()
  {
    ContentValues localContentValues = new ContentValues();
    if (this.kfa) {
      localContentValues.put("groupId", Long.valueOf(this.field_groupId));
    }
    if (this.lbu) {
      localContentValues.put("groupTime", Integer.valueOf(this.field_groupTime));
    }
    if (this.lbv) {
      localContentValues.put("groupStrcut", this.field_groupStrcut);
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
  
  public StorageObserverOwner<? extends hq> getObserverOwner()
  {
    return observerOwner;
  }
  
  public Object getPrimaryKeyValue()
  {
    return Long.valueOf(this.field_groupId);
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
 * Qualified Name:     com.tencent.mm.autogen.b.hq
 * JD-Core Version:    0.7.0.1
 */