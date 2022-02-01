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

public abstract class fr
  extends IAutoDBItem
{
  public static final IAutoDBItem.MAutoDBInfo DB_INFO = aJm();
  public static final String[] INDEX_CREATE;
  public static final Column ROWID;
  public static final SingleTable TABLE = new SingleTable("OfflineOrderStatus");
  private static final int jIF;
  public static final Column jIz;
  private static final int kPC;
  private static final int kPD;
  private static final int kPE;
  public static final Column kPw;
  public static final Column kPx;
  public static final Column kPy;
  private static final StorageObserverOwner<fr> observerOwner = new StorageObserverOwner();
  private static final int rowid_HASHCODE;
  public String field_ack_key;
  public long field_receive_time;
  public String field_reqkey;
  public int field_status;
  private boolean jIC = true;
  private boolean kPA = true;
  private boolean kPB = true;
  private boolean kPz = true;
  
  static
  {
    ROWID = new Column("rowid", "long", TABLE.getName(), "");
    kPw = new Column("reqkey", "string", TABLE.getName(), "");
    kPx = new Column("ack_key", "string", TABLE.getName(), "");
    jIz = new Column("status", "int", TABLE.getName(), "");
    kPy = new Column("receive_time", "long", TABLE.getName(), "");
    INDEX_CREATE = new String[0];
    kPC = "reqkey".hashCode();
    kPD = "ack_key".hashCode();
    jIF = "status".hashCode();
    kPE = "receive_time".hashCode();
    rowid_HASHCODE = "rowid".hashCode();
  }
  
  public static IAutoDBItem.MAutoDBInfo aJm()
  {
    IAutoDBItem.MAutoDBInfo localMAutoDBInfo = new IAutoDBItem.MAutoDBInfo();
    localMAutoDBInfo.fields = new Field[4];
    localMAutoDBInfo.columns = new String[5];
    StringBuilder localStringBuilder = new StringBuilder();
    localMAutoDBInfo.columns[0] = "reqkey";
    localMAutoDBInfo.colsMap.put("reqkey", "TEXT PRIMARY KEY ");
    localStringBuilder.append(" reqkey TEXT PRIMARY KEY ");
    localStringBuilder.append(", ");
    localMAutoDBInfo.primaryKey = "reqkey";
    localMAutoDBInfo.columns[1] = "ack_key";
    localMAutoDBInfo.colsMap.put("ack_key", "TEXT");
    localStringBuilder.append(" ack_key TEXT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[2] = "status";
    localMAutoDBInfo.colsMap.put("status", "INTEGER");
    localStringBuilder.append(" status INTEGER");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[3] = "receive_time";
    localMAutoDBInfo.colsMap.put("receive_time", "LONG");
    localStringBuilder.append(" receive_time LONG");
    localMAutoDBInfo.columns[4] = "rowid";
    localMAutoDBInfo.sql = localStringBuilder.toString();
    if (localMAutoDBInfo.primaryKey == null) {
      localMAutoDBInfo.primaryKey = "rowid";
    }
    return localMAutoDBInfo;
  }
  
  public void convertFrom(ContentValues paramContentValues, boolean paramBoolean)
  {
    if (paramContentValues.containsKey("reqkey"))
    {
      this.field_reqkey = paramContentValues.getAsString("reqkey");
      if (paramBoolean) {
        this.kPz = true;
      }
    }
    if (paramContentValues.containsKey("ack_key"))
    {
      this.field_ack_key = paramContentValues.getAsString("ack_key");
      if (paramBoolean) {
        this.kPA = true;
      }
    }
    if (paramContentValues.containsKey("status"))
    {
      this.field_status = paramContentValues.getAsInteger("status").intValue();
      if (paramBoolean) {
        this.jIC = true;
      }
    }
    if (paramContentValues.containsKey("receive_time"))
    {
      this.field_receive_time = paramContentValues.getAsLong("receive_time").longValue();
      if (paramBoolean) {
        this.kPB = true;
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
      if (kPC != k) {
        break label65;
      }
      this.field_reqkey = paramCursor.getString(i);
      this.kPz = true;
    }
    for (;;)
    {
      i += 1;
      break label20;
      break;
      label65:
      if (kPD == k) {
        this.field_ack_key = paramCursor.getString(i);
      } else if (jIF == k) {
        this.field_status = paramCursor.getInt(i);
      } else if (kPE == k) {
        this.field_receive_time = paramCursor.getLong(i);
      } else if (rowid_HASHCODE == k) {
        this.systemRowid = paramCursor.getLong(i);
      }
    }
  }
  
  public ContentValues convertTo()
  {
    ContentValues localContentValues = new ContentValues();
    if (this.kPz) {
      localContentValues.put("reqkey", this.field_reqkey);
    }
    if (this.kPA) {
      localContentValues.put("ack_key", this.field_ack_key);
    }
    if (this.jIC) {
      localContentValues.put("status", Integer.valueOf(this.field_status));
    }
    if (this.kPB) {
      localContentValues.put("receive_time", Long.valueOf(this.field_receive_time));
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
  
  public StorageObserverOwner<? extends fr> getObserverOwner()
  {
    return observerOwner;
  }
  
  public Object getPrimaryKeyValue()
  {
    return this.field_reqkey;
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
 * Qualified Name:     com.tencent.mm.autogen.b.fr
 * JD-Core Version:    0.7.0.1
 */