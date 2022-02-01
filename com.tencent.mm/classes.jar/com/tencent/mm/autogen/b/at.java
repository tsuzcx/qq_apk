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

public abstract class at
  extends IAutoDBItem
{
  public static final IAutoDBItem.MAutoDBInfo DB_INFO = aJm();
  public static final String[] INDEX_CREATE;
  public static final Column ROWID;
  public static final SingleTable TABLE = new SingleTable("CardQrCodeConfi");
  public static final Column jUT;
  private static final int jVF;
  public static final Column jVV;
  public static final Column jVW;
  public static final Column jVX;
  public static final Column jVY;
  public static final Column jVZ;
  public static final Column jWa;
  private static final int jWh;
  private static final int jWi;
  private static final int jWj;
  private static final int jWk;
  private static final int jWl;
  private static final int jWm;
  private static final StorageObserverOwner<at> observerOwner = new StorageObserverOwner();
  private static final int rowid_HASHCODE;
  public String field_card_id;
  public int field_expire_time_interval;
  public long field_fetch_time;
  public int field_lower_bound;
  public boolean field_need_insert_show_timestamp;
  public int field_show_expire_interval;
  public String field_show_timestamp_encrypt_key;
  private boolean jVm = true;
  private boolean jWb = true;
  private boolean jWc = true;
  private boolean jWd = true;
  private boolean jWe = true;
  private boolean jWf = true;
  private boolean jWg = true;
  
  static
  {
    ROWID = new Column("rowid", "long", TABLE.getName(), "");
    jUT = new Column("card_id", "string", TABLE.getName(), "");
    jVV = new Column("lower_bound", "int", TABLE.getName(), "");
    jVW = new Column("need_insert_show_timestamp", "boolean", TABLE.getName(), "");
    jVX = new Column("show_timestamp_encrypt_key", "string", TABLE.getName(), "");
    jVY = new Column("expire_time_interval", "int", TABLE.getName(), "");
    jVZ = new Column("show_expire_interval", "int", TABLE.getName(), "");
    jWa = new Column("fetch_time", "long", TABLE.getName(), "");
    INDEX_CREATE = new String[0];
    jVF = "card_id".hashCode();
    jWh = "lower_bound".hashCode();
    jWi = "need_insert_show_timestamp".hashCode();
    jWj = "show_timestamp_encrypt_key".hashCode();
    jWk = "expire_time_interval".hashCode();
    jWl = "show_expire_interval".hashCode();
    jWm = "fetch_time".hashCode();
    rowid_HASHCODE = "rowid".hashCode();
  }
  
  public static IAutoDBItem.MAutoDBInfo aJm()
  {
    IAutoDBItem.MAutoDBInfo localMAutoDBInfo = new IAutoDBItem.MAutoDBInfo();
    localMAutoDBInfo.fields = new Field[7];
    localMAutoDBInfo.columns = new String[8];
    StringBuilder localStringBuilder = new StringBuilder();
    localMAutoDBInfo.columns[0] = "card_id";
    localMAutoDBInfo.colsMap.put("card_id", "TEXT PRIMARY KEY ");
    localStringBuilder.append(" card_id TEXT PRIMARY KEY ");
    localStringBuilder.append(", ");
    localMAutoDBInfo.primaryKey = "card_id";
    localMAutoDBInfo.columns[1] = "lower_bound";
    localMAutoDBInfo.colsMap.put("lower_bound", "INTEGER");
    localStringBuilder.append(" lower_bound INTEGER");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[2] = "need_insert_show_timestamp";
    localMAutoDBInfo.colsMap.put("need_insert_show_timestamp", "INTEGER default 'false' ");
    localStringBuilder.append(" need_insert_show_timestamp INTEGER default 'false' ");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[3] = "show_timestamp_encrypt_key";
    localMAutoDBInfo.colsMap.put("show_timestamp_encrypt_key", "TEXT");
    localStringBuilder.append(" show_timestamp_encrypt_key TEXT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[4] = "expire_time_interval";
    localMAutoDBInfo.colsMap.put("expire_time_interval", "INTEGER");
    localStringBuilder.append(" expire_time_interval INTEGER");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[5] = "show_expire_interval";
    localMAutoDBInfo.colsMap.put("show_expire_interval", "INTEGER");
    localStringBuilder.append(" show_expire_interval INTEGER");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[6] = "fetch_time";
    localMAutoDBInfo.colsMap.put("fetch_time", "LONG");
    localStringBuilder.append(" fetch_time LONG");
    localMAutoDBInfo.columns[7] = "rowid";
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
    if (paramContentValues.containsKey("lower_bound"))
    {
      this.field_lower_bound = paramContentValues.getAsInteger("lower_bound").intValue();
      if (paramBoolean) {
        this.jWb = true;
      }
    }
    if (paramContentValues.containsKey("need_insert_show_timestamp")) {
      if (paramContentValues.getAsInteger("need_insert_show_timestamp").intValue() == 0) {
        break label240;
      }
    }
    label240:
    for (boolean bool = true;; bool = false)
    {
      this.field_need_insert_show_timestamp = bool;
      if (paramBoolean) {
        this.jWc = true;
      }
      if (paramContentValues.containsKey("show_timestamp_encrypt_key"))
      {
        this.field_show_timestamp_encrypt_key = paramContentValues.getAsString("show_timestamp_encrypt_key");
        if (paramBoolean) {
          this.jWd = true;
        }
      }
      if (paramContentValues.containsKey("expire_time_interval"))
      {
        this.field_expire_time_interval = paramContentValues.getAsInteger("expire_time_interval").intValue();
        if (paramBoolean) {
          this.jWe = true;
        }
      }
      if (paramContentValues.containsKey("show_expire_interval"))
      {
        this.field_show_expire_interval = paramContentValues.getAsInteger("show_expire_interval").intValue();
        if (paramBoolean) {
          this.jWf = true;
        }
      }
      if (paramContentValues.containsKey("fetch_time"))
      {
        this.field_fetch_time = paramContentValues.getAsLong("fetch_time").longValue();
        if (paramBoolean) {
          this.jWg = true;
        }
      }
      if (paramContentValues.containsKey("rowid")) {
        this.systemRowid = paramContentValues.getAsLong("rowid").longValue();
      }
      return;
    }
  }
  
  public void convertFrom(Cursor paramCursor)
  {
    String[] arrayOfString = paramCursor.getColumnNames();
    if (arrayOfString == null) {
      return;
    }
    int j = arrayOfString.length;
    int i = 0;
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
      if (jWh == k)
      {
        this.field_lower_bound = paramCursor.getInt(i);
      }
      else
      {
        if (jWi == k)
        {
          if (paramCursor.getInt(i) != 0) {}
          for (boolean bool = true;; bool = false)
          {
            this.field_need_insert_show_timestamp = bool;
            break;
          }
        }
        if (jWj == k) {
          this.field_show_timestamp_encrypt_key = paramCursor.getString(i);
        } else if (jWk == k) {
          this.field_expire_time_interval = paramCursor.getInt(i);
        } else if (jWl == k) {
          this.field_show_expire_interval = paramCursor.getInt(i);
        } else if (jWm == k) {
          this.field_fetch_time = paramCursor.getLong(i);
        } else if (rowid_HASHCODE == k) {
          this.systemRowid = paramCursor.getLong(i);
        }
      }
    }
  }
  
  public ContentValues convertTo()
  {
    ContentValues localContentValues = new ContentValues();
    if (this.jVm) {
      localContentValues.put("card_id", this.field_card_id);
    }
    if (this.jWb) {
      localContentValues.put("lower_bound", Integer.valueOf(this.field_lower_bound));
    }
    if (this.jWc) {
      localContentValues.put("need_insert_show_timestamp", Boolean.valueOf(this.field_need_insert_show_timestamp));
    }
    if (this.jWd) {
      localContentValues.put("show_timestamp_encrypt_key", this.field_show_timestamp_encrypt_key);
    }
    if (this.jWe) {
      localContentValues.put("expire_time_interval", Integer.valueOf(this.field_expire_time_interval));
    }
    if (this.jWf) {
      localContentValues.put("show_expire_interval", Integer.valueOf(this.field_show_expire_interval));
    }
    if (this.jWg) {
      localContentValues.put("fetch_time", Long.valueOf(this.field_fetch_time));
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
  
  public StorageObserverOwner<? extends at> getObserverOwner()
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
 * Qualified Name:     com.tencent.mm.autogen.b.at
 * JD-Core Version:    0.7.0.1
 */