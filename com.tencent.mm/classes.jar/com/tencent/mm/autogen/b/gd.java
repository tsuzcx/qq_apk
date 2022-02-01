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

public abstract class gd
  extends IAutoDBItem
{
  public static final IAutoDBItem.MAutoDBInfo DB_INFO = aJm();
  public static final String[] INDEX_CREATE;
  public static final Column ROWID;
  public static final SingleTable TABLE = new SingleTable("PendingCardId");
  public static final Column kRr;
  private static final int kRt;
  public static final Column knj;
  private static final int koF;
  private static final StorageObserverOwner<gd> observerOwner = new StorageObserverOwner();
  private static final int rowid_HASHCODE;
  public String field_cardUserId;
  public int field_retryCount;
  private boolean kRs = true;
  private boolean knU = true;
  
  static
  {
    ROWID = new Column("rowid", "long", TABLE.getName(), "");
    kRr = new Column("cardUserId", "string", TABLE.getName(), "");
    knj = new Column("retryCount", "int", TABLE.getName(), "");
    INDEX_CREATE = new String[0];
    kRt = "cardUserId".hashCode();
    koF = "retryCount".hashCode();
    rowid_HASHCODE = "rowid".hashCode();
  }
  
  public static IAutoDBItem.MAutoDBInfo aJm()
  {
    IAutoDBItem.MAutoDBInfo localMAutoDBInfo = new IAutoDBItem.MAutoDBInfo();
    localMAutoDBInfo.fields = new Field[2];
    localMAutoDBInfo.columns = new String[3];
    StringBuilder localStringBuilder = new StringBuilder();
    localMAutoDBInfo.columns[0] = "cardUserId";
    localMAutoDBInfo.colsMap.put("cardUserId", "TEXT PRIMARY KEY ");
    localStringBuilder.append(" cardUserId TEXT PRIMARY KEY ");
    localStringBuilder.append(", ");
    localMAutoDBInfo.primaryKey = "cardUserId";
    localMAutoDBInfo.columns[1] = "retryCount";
    localMAutoDBInfo.colsMap.put("retryCount", "INTEGER");
    localStringBuilder.append(" retryCount INTEGER");
    localMAutoDBInfo.columns[2] = "rowid";
    localMAutoDBInfo.sql = localStringBuilder.toString();
    if (localMAutoDBInfo.primaryKey == null) {
      localMAutoDBInfo.primaryKey = "rowid";
    }
    return localMAutoDBInfo;
  }
  
  public void convertFrom(ContentValues paramContentValues, boolean paramBoolean)
  {
    if (paramContentValues.containsKey("cardUserId"))
    {
      this.field_cardUserId = paramContentValues.getAsString("cardUserId");
      if (paramBoolean) {
        this.kRs = true;
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
      if (kRt != k) {
        break label65;
      }
      this.field_cardUserId = paramCursor.getString(i);
      this.kRs = true;
    }
    for (;;)
    {
      i += 1;
      break label20;
      break;
      label65:
      if (koF == k) {
        this.field_retryCount = paramCursor.getInt(i);
      } else if (rowid_HASHCODE == k) {
        this.systemRowid = paramCursor.getLong(i);
      }
    }
  }
  
  public ContentValues convertTo()
  {
    ContentValues localContentValues = new ContentValues();
    if (this.kRs) {
      localContentValues.put("cardUserId", this.field_cardUserId);
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
  
  public StorageObserverOwner<? extends gd> getObserverOwner()
  {
    return observerOwner;
  }
  
  public Object getPrimaryKeyValue()
  {
    return this.field_cardUserId;
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
 * Qualified Name:     com.tencent.mm.autogen.b.gd
 * JD-Core Version:    0.7.0.1
 */