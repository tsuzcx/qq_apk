package com.tencent.mm.autogen.b;

import android.content.ContentValues;
import android.database.Cursor;
import androidx.lifecycle.q;
import com.tencent.mm.sdk.storage.IAutoDBItem;
import com.tencent.mm.sdk.storage.IAutoDBItem.MAutoDBInfo;
import com.tencent.mm.sdk.storage.ISQLiteDatabase;
import com.tencent.mm.sdk.storage.executor.DeleteExecutor;
import com.tencent.mm.sdk.storage.executor.InsertExecutor;
import com.tencent.mm.sdk.storage.executor.ReplaceExecutor;
import com.tencent.mm.sdk.storage.executor.UpdateExecutor;
import com.tencent.mm.sdk.storage.observer.IStorageObserver;
import com.tencent.mm.sdk.storage.observer.StorageEventId;
import com.tencent.mm.sdk.storage.observer.StorageObserverEvent;
import com.tencent.mm.sdk.storage.observer.StorageObserverOwner;
import com.tencent.mm.sdk.storage.sql.Column;
import com.tencent.mm.sdk.storage.sql.SelectSql;
import com.tencent.mm.sdk.storage.sql.SelectSql.Builder;
import com.tencent.mm.sdk.storage.sql.SingleTable;
import java.lang.reflect.Field;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public abstract class er
  extends IAutoDBItem
{
  public static final String COL_EXPIRE_AT = "expire_at";
  public static final String COL_KEY = "key";
  public static final String COL_VALUE = "value";
  public static final IAutoDBItem.MAutoDBInfo DB_INFO = initAutoDBInfo(er.class);
  public static final Column EXPIRE_AT;
  public static final String[] INDEX_CREATE;
  public static final Column KEY;
  public static final Column ROWID;
  public static final SingleTable TABLE = new SingleTable("KindaCacheTable");
  public static final String TABLE_NAME = "KindaCacheTable";
  private static final String TAG_ = "MicroMsg.SDK.BaseKindaCacheTable";
  public static final Column VALUE;
  private static final int expire_at_HASHCODE;
  private static final int key_HASHCODE;
  private static final StorageObserverOwner<er> observerOwner = new StorageObserverOwner();
  private static final int rowid_HASHCODE;
  private static final int value_HASHCODE;
  private boolean __hadSetexpire_at = true;
  private boolean __hadSetkey = true;
  private boolean __hadSetvalue = true;
  public long field_expire_at;
  public String field_key;
  public byte[] field_value;
  
  static
  {
    ROWID = new Column("rowid", "long", TABLE.getName(), "");
    KEY = new Column("key", "string", TABLE.getName(), "");
    VALUE = new Column("value", "byte[]", TABLE.getName(), "");
    EXPIRE_AT = new Column("expire_at", "long", TABLE.getName(), "");
    INDEX_CREATE = new String[0];
    key_HASHCODE = "key".hashCode();
    value_HASHCODE = "value".hashCode();
    expire_at_HASHCODE = "expire_at".hashCode();
    rowid_HASHCODE = "rowid".hashCode();
  }
  
  private final void buildBuff() {}
  
  public static void createTable(ISQLiteDatabase paramISQLiteDatabase)
  {
    Object localObject = new LinkedList();
    ((List)localObject).add(getCreateSQLs());
    String[] arrayOfString = INDEX_CREATE;
    int j = arrayOfString.length;
    int i = 0;
    while (i < j)
    {
      ((List)localObject).add(arrayOfString[i]);
      i += 1;
    }
    localObject = ((List)localObject).iterator();
    while (((Iterator)localObject).hasNext()) {
      paramISQLiteDatabase.execSQL("KindaCacheTable", (String)((Iterator)localObject).next());
    }
  }
  
  public static final er.a cvBuilder()
  {
    return new er.a();
  }
  
  public static final b delete()
  {
    return new b();
  }
  
  public static final DeleteExecutor delete(er paramer, boolean paramBoolean)
  {
    if (paramBoolean) {
      return new DeleteExecutor(paramer, paramer.createDeleteEvent(), observerOwner, "MicroMsg.SDK.BaseKindaCacheTable");
    }
    return new DeleteExecutor(paramer, null, null, "MicroMsg.SDK.BaseKindaCacheTable");
  }
  
  private static String getCreateSQLs()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("CREATE TABLE IF NOT EXISTS KindaCacheTable ( ");
    localStringBuilder.append(DB_INFO.sql);
    localStringBuilder.append(");");
    return localStringBuilder.toString();
  }
  
  public static IAutoDBItem.MAutoDBInfo initAutoDBInfo(Class<?> paramClass)
  {
    paramClass = new IAutoDBItem.MAutoDBInfo();
    paramClass.fields = new Field[3];
    paramClass.columns = new String[4];
    StringBuilder localStringBuilder = new StringBuilder();
    paramClass.columns[0] = "key";
    paramClass.colsMap.put("key", "TEXT PRIMARY KEY ");
    localStringBuilder.append(" key TEXT PRIMARY KEY ");
    localStringBuilder.append(", ");
    paramClass.primaryKey = "key";
    paramClass.columns[1] = "value";
    paramClass.colsMap.put("value", "BLOB");
    localStringBuilder.append(" value BLOB");
    localStringBuilder.append(", ");
    paramClass.columns[2] = "expire_at";
    paramClass.colsMap.put("expire_at", "LONG");
    localStringBuilder.append(" expire_at LONG");
    paramClass.columns[3] = "rowid";
    paramClass.sql = localStringBuilder.toString();
    if (paramClass.primaryKey == null) {
      paramClass.primaryKey = "rowid";
    }
    return paramClass;
  }
  
  public static final InsertExecutor insert(er paramer, boolean paramBoolean)
  {
    if (paramBoolean) {
      return new InsertExecutor(paramer, true, paramer.createInsertEvent(), observerOwner, "MicroMsg.SDK.BaseKindaCacheTable");
    }
    return new InsertExecutor(paramer, true, null, null, "MicroMsg.SDK.BaseKindaCacheTable");
  }
  
  public static final InsertExecutor insertOrThrow(er paramer, boolean paramBoolean)
  {
    if (paramBoolean) {
      return new InsertExecutor(paramer, false, paramer.createInsertEvent(), observerOwner, "MicroMsg.SDK.BaseKindaCacheTable");
    }
    return new InsertExecutor(paramer, false, null, null, "MicroMsg.SDK.BaseKindaCacheTable");
  }
  
  public static final SelectSql isExistByKey(String paramString)
  {
    return TABLE.select(KEY).where(KEY.equal(paramString)).log("MicroMsg.SDK.BaseKindaCacheTable").limit(1, 0).build();
  }
  
  public static final void observe(q paramq, IStorageObserver<? extends er> paramIStorageObserver)
  {
    observerOwner.observe(paramq, paramIStorageObserver);
  }
  
  private final void parseBuff() {}
  
  public static final void removeObserve(IStorageObserver<? extends er> paramIStorageObserver)
  {
    observerOwner.removeObserver(paramIStorageObserver);
  }
  
  public static final ReplaceExecutor replace(er paramer, boolean paramBoolean)
  {
    if (paramBoolean) {
      return new ReplaceExecutor(paramer, paramer.createReplaceEvent(), observerOwner, "MicroMsg.SDK.BaseKindaCacheTable");
    }
    return new ReplaceExecutor(paramer, null, null, "MicroMsg.SDK.BaseKindaCacheTable");
  }
  
  public static final er.c select()
  {
    return new er.c();
  }
  
  public static final SelectSql selectByExpire_at(long paramLong)
  {
    return TABLE.selectAll().where(EXPIRE_AT.equal(Long.valueOf(paramLong))).log("MicroMsg.SDK.BaseKindaCacheTable").build();
  }
  
  public static final SelectSql selectByExpire_atList(List<Long> paramList)
  {
    return TABLE.selectAll().where(EXPIRE_AT.inNumber(paramList)).log("MicroMsg.SDK.BaseKindaCacheTable").build();
  }
  
  public static final SelectSql selectByKey(String paramString)
  {
    return TABLE.selectAll().where(KEY.equal(paramString)).log("MicroMsg.SDK.BaseKindaCacheTable").build();
  }
  
  public static final SelectSql selectByKeyList(List<String> paramList)
  {
    return TABLE.selectAll().where(KEY.inString(paramList)).log("MicroMsg.SDK.BaseKindaCacheTable").build();
  }
  
  public static final SelectSql selectExistListByKey(List<String> paramList)
  {
    return TABLE.select(KEY).where(KEY.inString(paramList)).log("MicroMsg.SDK.BaseKindaCacheTable").build();
  }
  
  public static final er.d update()
  {
    return new er.d();
  }
  
  public static final UpdateExecutor update(er paramer, boolean paramBoolean)
  {
    if (paramBoolean) {
      return new UpdateExecutor(paramer, paramer.createUpdateEvent(), observerOwner, "MicroMsg.SDK.BaseKindaCacheTable");
    }
    return new UpdateExecutor(paramer, null, null, "MicroMsg.SDK.BaseKindaCacheTable");
  }
  
  public void convertFrom(ContentValues paramContentValues, boolean paramBoolean)
  {
    if (paramContentValues.containsKey("key"))
    {
      this.field_key = paramContentValues.getAsString("key");
      if (paramBoolean) {
        this.__hadSetkey = true;
      }
    }
    if (paramContentValues.containsKey("value"))
    {
      this.field_value = paramContentValues.getAsByteArray("value");
      if (paramBoolean) {
        this.__hadSetvalue = true;
      }
    }
    if (paramContentValues.containsKey("expire_at"))
    {
      this.field_expire_at = paramContentValues.getAsLong("expire_at").longValue();
      if (paramBoolean) {
        this.__hadSetexpire_at = true;
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
      if (key_HASHCODE != k) {
        break label65;
      }
      this.field_key = paramCursor.getString(i);
      this.__hadSetkey = true;
    }
    for (;;)
    {
      i += 1;
      break label20;
      break;
      label65:
      if (value_HASHCODE == k) {
        this.field_value = paramCursor.getBlob(i);
      } else if (expire_at_HASHCODE == k) {
        this.field_expire_at = paramCursor.getLong(i);
      } else if (rowid_HASHCODE == k) {
        this.systemRowid = paramCursor.getLong(i);
      }
    }
  }
  
  public ContentValues convertTo()
  {
    buildBuff();
    ContentValues localContentValues = new ContentValues();
    if (this.__hadSetkey) {
      localContentValues.put("key", this.field_key);
    }
    if (this.__hadSetvalue) {
      localContentValues.put("value", this.field_value);
    }
    if (this.__hadSetexpire_at) {
      localContentValues.put("expire_at", Long.valueOf(this.field_expire_at));
    }
    if (this.systemRowid > 0L) {
      localContentValues.put("rowid", Long.valueOf(this.systemRowid));
    }
    return localContentValues;
  }
  
  protected StorageObserverEvent<? extends er> createDeleteEvent()
  {
    StorageObserverEvent localStorageObserverEvent = new StorageObserverEvent(StorageEventId.getUPDATE(), "MicroMsg.SDK.BaseKindaCacheTable");
    localStorageObserverEvent.setObj(this);
    localStorageObserverEvent.setPendingKey(String.valueOf(getPrimaryKeyValue()));
    return localStorageObserverEvent;
  }
  
  protected StorageObserverEvent<? extends er> createInsertEvent()
  {
    StorageObserverEvent localStorageObserverEvent = new StorageObserverEvent(StorageEventId.getINSERT(), "MicroMsg.SDK.BaseKindaCacheTable");
    localStorageObserverEvent.setObj(this);
    localStorageObserverEvent.setPendingKey(String.valueOf(getPrimaryKeyValue()));
    return localStorageObserverEvent;
  }
  
  protected StorageObserverEvent<? extends er> createReplaceEvent()
  {
    StorageObserverEvent localStorageObserverEvent = new StorageObserverEvent(StorageEventId.getUPDATE(), "MicroMsg.SDK.BaseKindaCacheTable");
    localStorageObserverEvent.setObj(this);
    localStorageObserverEvent.setPendingKey(String.valueOf(getPrimaryKeyValue()));
    return localStorageObserverEvent;
  }
  
  protected StorageObserverEvent<? extends er> createUpdateEvent()
  {
    StorageObserverEvent localStorageObserverEvent = new StorageObserverEvent(StorageEventId.getUPDATE(), "MicroMsg.SDK.BaseKindaCacheTable");
    localStorageObserverEvent.setObj(this);
    localStorageObserverEvent.setPendingKey(String.valueOf(getPrimaryKeyValue()));
    return localStorageObserverEvent;
  }
  
  public int deleteFromDB(ISQLiteDatabase paramISQLiteDatabase, boolean paramBoolean)
  {
    return delete(this, paramBoolean).execute(paramISQLiteDatabase);
  }
  
  public IAutoDBItem.MAutoDBInfo getDBInfo()
  {
    return DB_INFO;
  }
  
  public String[] getIndexCreateSQL()
  {
    return INDEX_CREATE;
  }
  
  public StorageObserverOwner<? extends er> getObserverOwner()
  {
    return observerOwner;
  }
  
  public Object getPrimaryKeyValue()
  {
    return this.field_key;
  }
  
  public SingleTable getTable()
  {
    return TABLE;
  }
  
  public String getTableName()
  {
    return TABLE.getName();
  }
  
  public long insertOrThrowToDB(ISQLiteDatabase paramISQLiteDatabase, boolean paramBoolean)
  {
    return insertOrThrow(this, paramBoolean).execute(paramISQLiteDatabase);
  }
  
  public long insertToDB(ISQLiteDatabase paramISQLiteDatabase, boolean paramBoolean)
  {
    return insert(this, paramBoolean).execute(paramISQLiteDatabase);
  }
  
  public boolean isExistByKeyInDB(ISQLiteDatabase paramISQLiteDatabase)
  {
    return isExistByKey(this.field_key).isExist(paramISQLiteDatabase);
  }
  
  public long replaceToDB(ISQLiteDatabase paramISQLiteDatabase, boolean paramBoolean)
  {
    return replace(this, paramBoolean).execute(paramISQLiteDatabase);
  }
  
  public void reset() {}
  
  public SelectSql selectByExpire_at()
  {
    return selectByExpire_at(this.field_expire_at);
  }
  
  public SelectSql selectByKey()
  {
    return selectByKey(this.field_key);
  }
  
  public int updateToDB(ISQLiteDatabase paramISQLiteDatabase, boolean paramBoolean)
  {
    return update(this, paramBoolean).execute(paramISQLiteDatabase);
  }
  
  public static class b {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes12.jar
 * Qualified Name:     com.tencent.mm.autogen.b.er
 * JD-Core Version:    0.7.0.1
 */