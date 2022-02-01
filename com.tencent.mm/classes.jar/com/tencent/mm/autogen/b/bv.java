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

public abstract class bv
  extends IAutoDBItem
{
  public static final IAutoDBItem.MAutoDBInfo DB_INFO = aJm();
  public static final String[] INDEX_CREATE;
  public static final Column ROWID;
  public static final SingleTable TABLE = new SingleTable("ExptKeyMapId");
  public static final Column kha;
  private static final int khk;
  public static final Column khp;
  private static final int khr;
  private static final StorageObserverOwner<bv> observerOwner = new StorageObserverOwner();
  private static final int rowid_HASHCODE;
  public int field_exptId;
  public String field_exptKey;
  private boolean khf = true;
  private boolean khq = true;
  
  static
  {
    ROWID = new Column("rowid", "long", TABLE.getName(), "");
    khp = new Column("exptKey", "string", TABLE.getName(), "");
    kha = new Column("exptId", "int", TABLE.getName(), "");
    INDEX_CREATE = new String[0];
    khr = "exptKey".hashCode();
    khk = "exptId".hashCode();
    rowid_HASHCODE = "rowid".hashCode();
  }
  
  public static IAutoDBItem.MAutoDBInfo aJm()
  {
    IAutoDBItem.MAutoDBInfo localMAutoDBInfo = new IAutoDBItem.MAutoDBInfo();
    localMAutoDBInfo.fields = new Field[2];
    localMAutoDBInfo.columns = new String[3];
    StringBuilder localStringBuilder = new StringBuilder();
    localMAutoDBInfo.columns[0] = "exptKey";
    localMAutoDBInfo.colsMap.put("exptKey", "TEXT PRIMARY KEY ");
    localStringBuilder.append(" exptKey TEXT PRIMARY KEY ");
    localStringBuilder.append(", ");
    localMAutoDBInfo.primaryKey = "exptKey";
    localMAutoDBInfo.columns[1] = "exptId";
    localMAutoDBInfo.colsMap.put("exptId", "INTEGER");
    localStringBuilder.append(" exptId INTEGER");
    localMAutoDBInfo.columns[2] = "rowid";
    localMAutoDBInfo.sql = localStringBuilder.toString();
    if (localMAutoDBInfo.primaryKey == null) {
      localMAutoDBInfo.primaryKey = "rowid";
    }
    return localMAutoDBInfo;
  }
  
  public void convertFrom(ContentValues paramContentValues, boolean paramBoolean)
  {
    if (paramContentValues.containsKey("exptKey"))
    {
      this.field_exptKey = paramContentValues.getAsString("exptKey");
      if (paramBoolean) {
        this.khq = true;
      }
    }
    if (paramContentValues.containsKey("exptId"))
    {
      this.field_exptId = paramContentValues.getAsInteger("exptId").intValue();
      if (paramBoolean) {
        this.khf = true;
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
      if (khr != k) {
        break label65;
      }
      this.field_exptKey = paramCursor.getString(i);
      this.khq = true;
    }
    for (;;)
    {
      i += 1;
      break label20;
      break;
      label65:
      if (khk == k) {
        this.field_exptId = paramCursor.getInt(i);
      } else if (rowid_HASHCODE == k) {
        this.systemRowid = paramCursor.getLong(i);
      }
    }
  }
  
  public ContentValues convertTo()
  {
    ContentValues localContentValues = new ContentValues();
    if (this.khq) {
      localContentValues.put("exptKey", this.field_exptKey);
    }
    if (this.khf) {
      localContentValues.put("exptId", Integer.valueOf(this.field_exptId));
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
  
  public StorageObserverOwner<? extends bv> getObserverOwner()
  {
    return observerOwner;
  }
  
  public Object getPrimaryKeyValue()
  {
    return this.field_exptKey;
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
 * Qualified Name:     com.tencent.mm.autogen.b.bv
 * JD-Core Version:    0.7.0.1
 */