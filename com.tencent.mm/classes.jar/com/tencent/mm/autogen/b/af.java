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

public abstract class af
  extends IAutoDBItem
{
  public static final IAutoDBItem.MAutoDBInfo DB_INFO = aJm();
  public static final String[] INDEX_CREATE;
  public static final Column ROWID;
  public static final SingleTable TABLE = new SingleTable("BizAdInfo");
  public static final Column jIo;
  private static final int jIw;
  public static final Column jPn;
  public static final Column jPo;
  private static final int jPr;
  private static final int jPs;
  private static final StorageObserverOwner<af> observerOwner = new StorageObserverOwner();
  private static final int rowid_HASHCODE;
  public String field_aId;
  public long field_exposeTime;
  public long field_msgId;
  private boolean jIs = true;
  private boolean jPp = true;
  private boolean jPq = true;
  
  static
  {
    ROWID = new Column("rowid", "long", TABLE.getName(), "");
    jPn = new Column("aId", "string", TABLE.getName(), "");
    jIo = new Column("msgId", "long", TABLE.getName(), "");
    jPo = new Column("exposeTime", "long", TABLE.getName(), "");
    INDEX_CREATE = new String[0];
    jPr = "aId".hashCode();
    jIw = "msgId".hashCode();
    jPs = "exposeTime".hashCode();
    rowid_HASHCODE = "rowid".hashCode();
  }
  
  public static IAutoDBItem.MAutoDBInfo aJm()
  {
    IAutoDBItem.MAutoDBInfo localMAutoDBInfo = new IAutoDBItem.MAutoDBInfo();
    localMAutoDBInfo.fields = new Field[3];
    localMAutoDBInfo.columns = new String[4];
    StringBuilder localStringBuilder = new StringBuilder();
    localMAutoDBInfo.columns[0] = "aId";
    localMAutoDBInfo.colsMap.put("aId", "TEXT PRIMARY KEY ");
    localStringBuilder.append(" aId TEXT PRIMARY KEY ");
    localStringBuilder.append(", ");
    localMAutoDBInfo.primaryKey = "aId";
    localMAutoDBInfo.columns[1] = "msgId";
    localMAutoDBInfo.colsMap.put("msgId", "LONG");
    localStringBuilder.append(" msgId LONG");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[2] = "exposeTime";
    localMAutoDBInfo.colsMap.put("exposeTime", "LONG");
    localStringBuilder.append(" exposeTime LONG");
    localMAutoDBInfo.columns[3] = "rowid";
    localMAutoDBInfo.sql = localStringBuilder.toString();
    if (localMAutoDBInfo.primaryKey == null) {
      localMAutoDBInfo.primaryKey = "rowid";
    }
    return localMAutoDBInfo;
  }
  
  public void convertFrom(ContentValues paramContentValues, boolean paramBoolean)
  {
    if (paramContentValues.containsKey("aId"))
    {
      this.field_aId = paramContentValues.getAsString("aId");
      if (paramBoolean) {
        this.jPp = true;
      }
    }
    if (paramContentValues.containsKey("msgId"))
    {
      this.field_msgId = paramContentValues.getAsLong("msgId").longValue();
      if (paramBoolean) {
        this.jIs = true;
      }
    }
    if (paramContentValues.containsKey("exposeTime"))
    {
      this.field_exposeTime = paramContentValues.getAsLong("exposeTime").longValue();
      if (paramBoolean) {
        this.jPq = true;
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
      if (jPr != k) {
        break label65;
      }
      this.field_aId = paramCursor.getString(i);
      this.jPp = true;
    }
    for (;;)
    {
      i += 1;
      break label20;
      break;
      label65:
      if (jIw == k) {
        this.field_msgId = paramCursor.getLong(i);
      } else if (jPs == k) {
        this.field_exposeTime = paramCursor.getLong(i);
      } else if (rowid_HASHCODE == k) {
        this.systemRowid = paramCursor.getLong(i);
      }
    }
  }
  
  public ContentValues convertTo()
  {
    ContentValues localContentValues = new ContentValues();
    if (this.jPp) {
      localContentValues.put("aId", this.field_aId);
    }
    if (this.jIs) {
      localContentValues.put("msgId", Long.valueOf(this.field_msgId));
    }
    if (this.jPq) {
      localContentValues.put("exposeTime", Long.valueOf(this.field_exposeTime));
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
  
  public StorageObserverOwner<? extends af> getObserverOwner()
  {
    return observerOwner;
  }
  
  public Object getPrimaryKeyValue()
  {
    return this.field_aId;
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
 * Qualified Name:     com.tencent.mm.autogen.b.af
 * JD-Core Version:    0.7.0.1
 */