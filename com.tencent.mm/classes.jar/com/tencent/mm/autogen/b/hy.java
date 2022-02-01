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

public abstract class hy
  extends IAutoDBItem
{
  public static final IAutoDBItem.MAutoDBInfo DB_INFO = aJm();
  public static final String[] INDEX_CREATE;
  public static final Column ROWID;
  public static final SingleTable TABLE = new SingleTable("TablesVersion");
  public static final Column ldg;
  public static final Column ldh;
  private static final int ldk;
  private static final int ldl;
  private static final StorageObserverOwner<hy> observerOwner = new StorageObserverOwner();
  private static final int rowid_HASHCODE;
  public int field_tableHash;
  public String field_tableSQLMD5;
  private boolean ldi = true;
  private boolean ldj = true;
  
  static
  {
    ROWID = new Column("rowid", "long", TABLE.getName(), "");
    ldg = new Column("tableHash", "int", TABLE.getName(), "");
    ldh = new Column("tableSQLMD5", "string", TABLE.getName(), "");
    INDEX_CREATE = new String[0];
    ldk = "tableHash".hashCode();
    ldl = "tableSQLMD5".hashCode();
    rowid_HASHCODE = "rowid".hashCode();
  }
  
  public static IAutoDBItem.MAutoDBInfo aJm()
  {
    IAutoDBItem.MAutoDBInfo localMAutoDBInfo = new IAutoDBItem.MAutoDBInfo();
    localMAutoDBInfo.fields = new Field[2];
    localMAutoDBInfo.columns = new String[3];
    StringBuilder localStringBuilder = new StringBuilder();
    localMAutoDBInfo.columns[0] = "tableHash";
    localMAutoDBInfo.colsMap.put("tableHash", "INTEGER PRIMARY KEY ");
    localStringBuilder.append(" tableHash INTEGER PRIMARY KEY ");
    localStringBuilder.append(", ");
    localMAutoDBInfo.primaryKey = "tableHash";
    localMAutoDBInfo.columns[1] = "tableSQLMD5";
    localMAutoDBInfo.colsMap.put("tableSQLMD5", "TEXT");
    localStringBuilder.append(" tableSQLMD5 TEXT");
    localMAutoDBInfo.columns[2] = "rowid";
    localMAutoDBInfo.sql = localStringBuilder.toString();
    if (localMAutoDBInfo.primaryKey == null) {
      localMAutoDBInfo.primaryKey = "rowid";
    }
    return localMAutoDBInfo;
  }
  
  public void convertFrom(ContentValues paramContentValues, boolean paramBoolean)
  {
    if (paramContentValues.containsKey("tableHash"))
    {
      this.field_tableHash = paramContentValues.getAsInteger("tableHash").intValue();
      if (paramBoolean) {
        this.ldi = true;
      }
    }
    if (paramContentValues.containsKey("tableSQLMD5"))
    {
      this.field_tableSQLMD5 = paramContentValues.getAsString("tableSQLMD5");
      if (paramBoolean) {
        this.ldj = true;
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
      if (ldk != k) {
        break label65;
      }
      this.field_tableHash = paramCursor.getInt(i);
      this.ldi = true;
    }
    for (;;)
    {
      i += 1;
      break label20;
      break;
      label65:
      if (ldl == k) {
        this.field_tableSQLMD5 = paramCursor.getString(i);
      } else if (rowid_HASHCODE == k) {
        this.systemRowid = paramCursor.getLong(i);
      }
    }
  }
  
  public ContentValues convertTo()
  {
    ContentValues localContentValues = new ContentValues();
    if (this.ldi) {
      localContentValues.put("tableHash", Integer.valueOf(this.field_tableHash));
    }
    if (this.ldj) {
      localContentValues.put("tableSQLMD5", this.field_tableSQLMD5);
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
  
  public StorageObserverOwner<? extends hy> getObserverOwner()
  {
    return observerOwner;
  }
  
  public Object getPrimaryKeyValue()
  {
    return Integer.valueOf(this.field_tableHash);
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
 * Qualified Name:     com.tencent.mm.autogen.b.hy
 * JD-Core Version:    0.7.0.1
 */