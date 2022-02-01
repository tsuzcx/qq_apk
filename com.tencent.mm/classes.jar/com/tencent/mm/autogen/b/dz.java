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

public abstract class dz
  extends IAutoDBItem
{
  public static final IAutoDBItem.MAutoDBInfo DB_INFO = aJm();
  public static final String[] INDEX_CREATE;
  public static final Column ROWID;
  public static final SingleTable TABLE = new SingleTable("GroupBindApp");
  public static final Column jWQ;
  public static final Column kBc;
  private static final int kBf;
  private static final int kBg;
  private static final StorageObserverOwner<dz> observerOwner = new StorageObserverOwner();
  private static final int rowid_HASHCODE;
  public byte[] field_BindAppData;
  public String field_chatRoomName;
  private boolean kBd = true;
  private boolean kBe = true;
  
  static
  {
    ROWID = new Column("rowid", "long", TABLE.getName(), "");
    jWQ = new Column("chatRoomName", "string", TABLE.getName(), "");
    kBc = new Column("BindAppData", "byte[]", TABLE.getName(), "");
    INDEX_CREATE = new String[0];
    kBf = "chatRoomName".hashCode();
    kBg = "BindAppData".hashCode();
    rowid_HASHCODE = "rowid".hashCode();
  }
  
  public static IAutoDBItem.MAutoDBInfo aJm()
  {
    IAutoDBItem.MAutoDBInfo localMAutoDBInfo = new IAutoDBItem.MAutoDBInfo();
    localMAutoDBInfo.fields = new Field[2];
    localMAutoDBInfo.columns = new String[3];
    StringBuilder localStringBuilder = new StringBuilder();
    localMAutoDBInfo.columns[0] = "chatRoomName";
    localMAutoDBInfo.colsMap.put("chatRoomName", "TEXT default '群username'  PRIMARY KEY ");
    localStringBuilder.append(" chatRoomName TEXT default '群username'  PRIMARY KEY ");
    localStringBuilder.append(", ");
    localMAutoDBInfo.primaryKey = "chatRoomName";
    localMAutoDBInfo.columns[1] = "BindAppData";
    localMAutoDBInfo.colsMap.put("BindAppData", "BLOB");
    localStringBuilder.append(" BindAppData BLOB");
    localMAutoDBInfo.columns[2] = "rowid";
    localMAutoDBInfo.sql = localStringBuilder.toString();
    if (localMAutoDBInfo.primaryKey == null) {
      localMAutoDBInfo.primaryKey = "rowid";
    }
    return localMAutoDBInfo;
  }
  
  public void convertFrom(ContentValues paramContentValues, boolean paramBoolean)
  {
    if (paramContentValues.containsKey("chatRoomName"))
    {
      this.field_chatRoomName = paramContentValues.getAsString("chatRoomName");
      if (paramBoolean) {
        this.kBd = true;
      }
    }
    if (paramContentValues.containsKey("BindAppData"))
    {
      this.field_BindAppData = paramContentValues.getAsByteArray("BindAppData");
      if (paramBoolean) {
        this.kBe = true;
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
      if (kBf != k) {
        break label65;
      }
      this.field_chatRoomName = paramCursor.getString(i);
      this.kBd = true;
    }
    for (;;)
    {
      i += 1;
      break label20;
      break;
      label65:
      if (kBg == k) {
        this.field_BindAppData = paramCursor.getBlob(i);
      } else if (rowid_HASHCODE == k) {
        this.systemRowid = paramCursor.getLong(i);
      }
    }
  }
  
  public ContentValues convertTo()
  {
    ContentValues localContentValues = new ContentValues();
    if (this.field_chatRoomName == null) {
      this.field_chatRoomName = "群username";
    }
    if (this.kBd) {
      localContentValues.put("chatRoomName", this.field_chatRoomName);
    }
    if (this.kBe) {
      localContentValues.put("BindAppData", this.field_BindAppData);
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
  
  public StorageObserverOwner<? extends dz> getObserverOwner()
  {
    return observerOwner;
  }
  
  public Object getPrimaryKeyValue()
  {
    return this.field_chatRoomName;
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
 * Qualified Name:     com.tencent.mm.autogen.b.dz
 * JD-Core Version:    0.7.0.1
 */