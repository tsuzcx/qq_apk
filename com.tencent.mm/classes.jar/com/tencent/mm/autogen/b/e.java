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

public abstract class e
  extends IAutoDBItem
{
  public static final IAutoDBItem.MAutoDBInfo DB_INFO = aJm();
  public static final String[] INDEX_CREATE;
  public static final Column KEY;
  public static final Column ROWID;
  public static final SingleTable TABLE = new SingleTable("ActiveInfo");
  public static final Column jJn;
  public static final Column jJo;
  public static final Column jJp;
  private static final int jJt;
  private static final int jJu;
  private static final int jJv;
  private static final int key_HASHCODE;
  private static final StorageObserverOwner<e> observerOwner = new StorageObserverOwner();
  private static final int rowid_HASHCODE;
  private boolean __hadSetkey = true;
  public int field_dau;
  public int field_key;
  public int field_mau;
  public long field_useTime;
  private boolean jJq = true;
  private boolean jJr = true;
  private boolean jJs = true;
  
  static
  {
    ROWID = new Column("rowid", "long", TABLE.getName(), "");
    KEY = new Column("key", "int", TABLE.getName(), "");
    jJn = new Column("mau", "int", TABLE.getName(), "");
    jJo = new Column("dau", "int", TABLE.getName(), "");
    jJp = new Column("useTime", "long", TABLE.getName(), "");
    INDEX_CREATE = new String[0];
    key_HASHCODE = "key".hashCode();
    jJt = "mau".hashCode();
    jJu = "dau".hashCode();
    jJv = "useTime".hashCode();
    rowid_HASHCODE = "rowid".hashCode();
  }
  
  public static IAutoDBItem.MAutoDBInfo aJm()
  {
    IAutoDBItem.MAutoDBInfo localMAutoDBInfo = new IAutoDBItem.MAutoDBInfo();
    localMAutoDBInfo.fields = new Field[4];
    localMAutoDBInfo.columns = new String[5];
    StringBuilder localStringBuilder = new StringBuilder();
    localMAutoDBInfo.columns[0] = "key";
    localMAutoDBInfo.colsMap.put("key", "INTEGER PRIMARY KEY  COLLATE NOCASE ");
    localStringBuilder.append(" key INTEGER PRIMARY KEY  COLLATE NOCASE ");
    localStringBuilder.append(", ");
    localMAutoDBInfo.primaryKey = "key";
    localMAutoDBInfo.columns[1] = "mau";
    localMAutoDBInfo.colsMap.put("mau", "INTEGER");
    localStringBuilder.append(" mau INTEGER");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[2] = "dau";
    localMAutoDBInfo.colsMap.put("dau", "INTEGER");
    localStringBuilder.append(" dau INTEGER");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[3] = "useTime";
    localMAutoDBInfo.colsMap.put("useTime", "LONG");
    localStringBuilder.append(" useTime LONG");
    localMAutoDBInfo.columns[4] = "rowid";
    localMAutoDBInfo.sql = localStringBuilder.toString();
    if (localMAutoDBInfo.primaryKey == null) {
      localMAutoDBInfo.primaryKey = "rowid";
    }
    return localMAutoDBInfo;
  }
  
  public void convertFrom(ContentValues paramContentValues, boolean paramBoolean)
  {
    if (paramContentValues.containsKey("key"))
    {
      this.field_key = paramContentValues.getAsInteger("key").intValue();
      if (paramBoolean) {
        this.__hadSetkey = true;
      }
    }
    if (paramContentValues.containsKey("mau"))
    {
      this.field_mau = paramContentValues.getAsInteger("mau").intValue();
      if (paramBoolean) {
        this.jJq = true;
      }
    }
    if (paramContentValues.containsKey("dau"))
    {
      this.field_dau = paramContentValues.getAsInteger("dau").intValue();
      if (paramBoolean) {
        this.jJr = true;
      }
    }
    if (paramContentValues.containsKey("useTime"))
    {
      this.field_useTime = paramContentValues.getAsLong("useTime").longValue();
      if (paramBoolean) {
        this.jJs = true;
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
      this.field_key = paramCursor.getInt(i);
      this.__hadSetkey = true;
    }
    for (;;)
    {
      i += 1;
      break label20;
      break;
      label65:
      if (jJt == k) {
        this.field_mau = paramCursor.getInt(i);
      } else if (jJu == k) {
        this.field_dau = paramCursor.getInt(i);
      } else if (jJv == k) {
        this.field_useTime = paramCursor.getLong(i);
      } else if (rowid_HASHCODE == k) {
        this.systemRowid = paramCursor.getLong(i);
      }
    }
  }
  
  public ContentValues convertTo()
  {
    ContentValues localContentValues = new ContentValues();
    if (this.__hadSetkey) {
      localContentValues.put("key", Integer.valueOf(this.field_key));
    }
    if (this.jJq) {
      localContentValues.put("mau", Integer.valueOf(this.field_mau));
    }
    if (this.jJr) {
      localContentValues.put("dau", Integer.valueOf(this.field_dau));
    }
    if (this.jJs) {
      localContentValues.put("useTime", Long.valueOf(this.field_useTime));
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
  
  public StorageObserverOwner<? extends e> getObserverOwner()
  {
    return observerOwner;
  }
  
  public Object getPrimaryKeyValue()
  {
    return Integer.valueOf(this.field_key);
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
 * Qualified Name:     com.tencent.mm.autogen.b.e
 * JD-Core Version:    0.7.0.1
 */