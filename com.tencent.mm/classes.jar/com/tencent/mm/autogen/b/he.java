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

public abstract class he
  extends IAutoDBItem
{
  public static final IAutoDBItem.MAutoDBInfo DB_INFO = aJm();
  public static final String[] INDEX_CREATE;
  public static final Column ROWID;
  public static final SingleTable TABLE = new SingleTable("ShareCardSyncItemInfo");
  public static final Column jUT;
  private static final int jVF;
  public static final Column kIZ;
  private static final int kJx;
  public static final Column kPI;
  private static final int kPQ;
  public static final Column kXW;
  private static final int kXY;
  public static final Column knj;
  private static final int koF;
  private static final StorageObserverOwner<he> observerOwner = new StorageObserverOwner();
  private static final int rowid_HASHCODE;
  public String field_card_id;
  public int field_retryCount;
  public long field_seq;
  public int field_state_flag;
  public long field_update_time;
  private boolean jVm = true;
  private boolean kJl = true;
  private boolean kPM = true;
  private boolean kXX = true;
  private boolean knU = true;
  
  static
  {
    ROWID = new Column("rowid", "long", TABLE.getName(), "");
    jUT = new Column("card_id", "string", TABLE.getName(), "");
    kXW = new Column("state_flag", "int", TABLE.getName(), "");
    kIZ = new Column("update_time", "long", TABLE.getName(), "");
    kPI = new Column("seq", "long", TABLE.getName(), "");
    knj = new Column("retryCount", "int", TABLE.getName(), "");
    INDEX_CREATE = new String[0];
    jVF = "card_id".hashCode();
    kXY = "state_flag".hashCode();
    kJx = "update_time".hashCode();
    kPQ = "seq".hashCode();
    koF = "retryCount".hashCode();
    rowid_HASHCODE = "rowid".hashCode();
  }
  
  public static IAutoDBItem.MAutoDBInfo aJm()
  {
    IAutoDBItem.MAutoDBInfo localMAutoDBInfo = new IAutoDBItem.MAutoDBInfo();
    localMAutoDBInfo.fields = new Field[5];
    localMAutoDBInfo.columns = new String[6];
    StringBuilder localStringBuilder = new StringBuilder();
    localMAutoDBInfo.columns[0] = "card_id";
    localMAutoDBInfo.colsMap.put("card_id", "TEXT PRIMARY KEY ");
    localStringBuilder.append(" card_id TEXT PRIMARY KEY ");
    localStringBuilder.append(", ");
    localMAutoDBInfo.primaryKey = "card_id";
    localMAutoDBInfo.columns[1] = "state_flag";
    localMAutoDBInfo.colsMap.put("state_flag", "INTEGER");
    localStringBuilder.append(" state_flag INTEGER");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[2] = "update_time";
    localMAutoDBInfo.colsMap.put("update_time", "LONG");
    localStringBuilder.append(" update_time LONG");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[3] = "seq";
    localMAutoDBInfo.colsMap.put("seq", "LONG");
    localStringBuilder.append(" seq LONG");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[4] = "retryCount";
    localMAutoDBInfo.colsMap.put("retryCount", "INTEGER");
    localStringBuilder.append(" retryCount INTEGER");
    localMAutoDBInfo.columns[5] = "rowid";
    localMAutoDBInfo.sql = localStringBuilder.toString();
    if (localMAutoDBInfo.primaryKey == null) {
      localMAutoDBInfo.primaryKey = "rowid";
    }
    return localMAutoDBInfo;
  }
  
  public void convertFrom(ContentValues paramContentValues, boolean paramBoolean)
  {
    if (paramContentValues.containsKey("card_id"))
    {
      this.field_card_id = paramContentValues.getAsString("card_id");
      if (paramBoolean) {
        this.jVm = true;
      }
    }
    if (paramContentValues.containsKey("state_flag"))
    {
      this.field_state_flag = paramContentValues.getAsInteger("state_flag").intValue();
      if (paramBoolean) {
        this.kXX = true;
      }
    }
    if (paramContentValues.containsKey("update_time"))
    {
      this.field_update_time = paramContentValues.getAsLong("update_time").longValue();
      if (paramBoolean) {
        this.kJl = true;
      }
    }
    if (paramContentValues.containsKey("seq"))
    {
      this.field_seq = paramContentValues.getAsLong("seq").longValue();
      if (paramBoolean) {
        this.kPM = true;
      }
    }
    if (paramContentValues.containsKey("retryCount"))
    {
      this.field_retryCount = paramContentValues.getAsInteger("retryCount").intValue();
      if (paramBoolean) {
        this.knU = true;
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
      if (jVF != k) {
        break label65;
      }
      this.field_card_id = paramCursor.getString(i);
      this.jVm = true;
    }
    for (;;)
    {
      i += 1;
      break label20;
      break;
      label65:
      if (kXY == k) {
        this.field_state_flag = paramCursor.getInt(i);
      } else if (kJx == k) {
        this.field_update_time = paramCursor.getLong(i);
      } else if (kPQ == k) {
        this.field_seq = paramCursor.getLong(i);
      } else if (koF == k) {
        this.field_retryCount = paramCursor.getInt(i);
      } else if (rowid_HASHCODE == k) {
        this.systemRowid = paramCursor.getLong(i);
      }
    }
  }
  
  public ContentValues convertTo()
  {
    ContentValues localContentValues = new ContentValues();
    if (this.jVm) {
      localContentValues.put("card_id", this.field_card_id);
    }
    if (this.kXX) {
      localContentValues.put("state_flag", Integer.valueOf(this.field_state_flag));
    }
    if (this.kJl) {
      localContentValues.put("update_time", Long.valueOf(this.field_update_time));
    }
    if (this.kPM) {
      localContentValues.put("seq", Long.valueOf(this.field_seq));
    }
    if (this.knU) {
      localContentValues.put("retryCount", Integer.valueOf(this.field_retryCount));
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
  
  public StorageObserverOwner<? extends he> getObserverOwner()
  {
    return observerOwner;
  }
  
  public Object getPrimaryKeyValue()
  {
    return this.field_card_id;
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
 * Qualified Name:     com.tencent.mm.autogen.b.he
 * JD-Core Version:    0.7.0.1
 */