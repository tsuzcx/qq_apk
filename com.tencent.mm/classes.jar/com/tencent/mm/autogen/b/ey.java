package com.tencent.mm.autogen.b;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.storage.IAutoDBItem;
import com.tencent.mm.sdk.storage.IAutoDBItem.MAutoDBInfo;
import com.tencent.mm.sdk.storage.observer.StorageObserverOwner;
import com.tencent.mm.sdk.storage.sql.Column;
import com.tencent.mm.sdk.storage.sql.ISqlColumn;
import com.tencent.mm.sdk.storage.sql.IndexSql;
import com.tencent.mm.sdk.storage.sql.IndexSql.Builder;
import com.tencent.mm.sdk.storage.sql.SingleTable;
import java.lang.reflect.Field;
import java.util.Map;

public abstract class ey
  extends IAutoDBItem
{
  public static final IAutoDBItem.MAutoDBInfo DB_INFO = aJm();
  public static final Column ID;
  public static final String[] INDEX_CREATE;
  public static final Column ROWID;
  public static final SingleTable TABLE = new SingleTable("LiveDemoDBInfo");
  private static final int id_HASHCODE;
  public static final Column kIj;
  private static final int kIl;
  public static final Column kkd;
  private static final int kkx;
  private static final StorageObserverOwner<ey> observerOwner = new StorageObserverOwner();
  private static final int rowid_HASHCODE;
  private boolean __hadSetid = false;
  public String field_id = "";
  public String field_info = "";
  public long field_timestamp = 0L;
  private boolean kIk = false;
  private boolean kkn = false;
  
  static
  {
    ROWID = new Column("rowid", "long", TABLE.getName(), "");
    ID = new Column("id", "string", TABLE.getName(), "");
    kIj = new Column("info", "string", TABLE.getName(), "");
    kkd = new Column("timestamp", "long", TABLE.getName(), "");
    INDEX_CREATE = new String[] { "CREATE INDEX IF NOT EXISTS TimestampIndex ON LiveDemoDBInfo(timestamp)", TABLE.index("IdInfoTimestamp").on(new ISqlColumn[] { ID, kIj, kkd }).build().toSql() };
    id_HASHCODE = "id".hashCode();
    kIl = "info".hashCode();
    kkx = "timestamp".hashCode();
    rowid_HASHCODE = "rowid".hashCode();
  }
  
  public static IAutoDBItem.MAutoDBInfo aJm()
  {
    IAutoDBItem.MAutoDBInfo localMAutoDBInfo = new IAutoDBItem.MAutoDBInfo();
    localMAutoDBInfo.fields = new Field[3];
    localMAutoDBInfo.columns = new String[4];
    StringBuilder localStringBuilder = new StringBuilder();
    localMAutoDBInfo.columns[0] = "id";
    localMAutoDBInfo.colsMap.put("id", "TEXT PRIMARY KEY ");
    localStringBuilder.append(" id TEXT PRIMARY KEY ");
    localStringBuilder.append(", ");
    localMAutoDBInfo.primaryKey = "id";
    localMAutoDBInfo.columns[1] = "info";
    localMAutoDBInfo.colsMap.put("info", "TEXT default '' ");
    localStringBuilder.append(" info TEXT default '' ");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[2] = "timestamp";
    localMAutoDBInfo.colsMap.put("timestamp", "LONG default '0' ");
    localStringBuilder.append(" timestamp LONG default '0' ");
    localMAutoDBInfo.columns[3] = "rowid";
    localMAutoDBInfo.sql = localStringBuilder.toString();
    if (localMAutoDBInfo.primaryKey == null) {
      localMAutoDBInfo.primaryKey = "rowid";
    }
    return localMAutoDBInfo;
  }
  
  public final void BR(String paramString)
  {
    this.field_info = paramString;
    this.kIk = true;
  }
  
  public void convertFrom(ContentValues paramContentValues, boolean paramBoolean)
  {
    if (paramContentValues.containsKey("id"))
    {
      this.field_id = paramContentValues.getAsString("id");
      if (paramBoolean) {
        this.__hadSetid = true;
      }
    }
    if (paramContentValues.containsKey("info"))
    {
      this.field_info = paramContentValues.getAsString("info");
      if (paramBoolean) {
        this.kIk = true;
      }
    }
    if (paramContentValues.containsKey("timestamp"))
    {
      this.field_timestamp = paramContentValues.getAsLong("timestamp").longValue();
      if (paramBoolean) {
        this.kkn = true;
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
      if (id_HASHCODE != k) {
        break label65;
      }
      this.field_id = paramCursor.getString(i);
      this.__hadSetid = true;
    }
    for (;;)
    {
      i += 1;
      break label20;
      break;
      label65:
      if (kIl == k) {
        this.field_info = paramCursor.getString(i);
      } else if (kkx == k) {
        this.field_timestamp = paramCursor.getLong(i);
      } else if (rowid_HASHCODE == k) {
        this.systemRowid = paramCursor.getLong(i);
      }
    }
  }
  
  public ContentValues convertTo()
  {
    ContentValues localContentValues = new ContentValues();
    if (this.__hadSetid) {
      localContentValues.put("id", this.field_id);
    }
    if (this.field_info == null) {
      this.field_info = "";
    }
    if (this.kIk) {
      localContentValues.put("info", this.field_info);
    }
    if (this.kkn) {
      localContentValues.put("timestamp", Long.valueOf(this.field_timestamp));
    }
    if (this.systemRowid > 0L) {
      localContentValues.put("rowid", Long.valueOf(this.systemRowid));
    }
    return localContentValues;
  }
  
  public final void gW(long paramLong)
  {
    this.field_timestamp = paramLong;
    this.kkn = true;
  }
  
  public IAutoDBItem.MAutoDBInfo getDBInfo()
  {
    return DB_INFO;
  }
  
  public String[] getIndexCreateSQL()
  {
    return INDEX_CREATE;
  }
  
  public StorageObserverOwner<? extends ey> getObserverOwner()
  {
    return observerOwner;
  }
  
  public Object getPrimaryKeyValue()
  {
    return this.field_id;
  }
  
  public SingleTable getTable()
  {
    return TABLE;
  }
  
  public String getTableName()
  {
    return TABLE.getName();
  }
  
  public final void setId(String paramString)
  {
    this.field_id = paramString;
    this.__hadSetid = true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.autogen.b.ey
 * JD-Core Version:    0.7.0.1
 */