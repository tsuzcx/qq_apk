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

public abstract class jm
  extends IAutoDBItem
{
  public static final IAutoDBItem.MAutoDBInfo DB_INFO = aJm();
  public static final String[] INDEX_CREATE;
  public static final Column ROWID;
  public static final SingleTable TABLE = new SingleTable("WxaWidgetInfo");
  private static final int jKX;
  public static final Column jKp;
  private static final int kHN;
  public static final Column kHx;
  public static final Column lpU;
  private static final int lpW;
  private static final StorageObserverOwner<jm> observerOwner = new StorageObserverOwner();
  private static final int rowid_HASHCODE;
  public String field_appId;
  public int field_appIdHash;
  public boolean field_openDebug;
  private boolean jKG = true;
  private boolean kHF = true;
  private boolean lpV = true;
  
  static
  {
    ROWID = new Column("rowid", "long", TABLE.getName(), "");
    kHx = new Column("appIdHash", "int", TABLE.getName(), "");
    jKp = new Column("appId", "string", TABLE.getName(), "");
    lpU = new Column("openDebug", "boolean", TABLE.getName(), "");
    INDEX_CREATE = new String[0];
    kHN = "appIdHash".hashCode();
    jKX = "appId".hashCode();
    lpW = "openDebug".hashCode();
    rowid_HASHCODE = "rowid".hashCode();
  }
  
  public static IAutoDBItem.MAutoDBInfo aJm()
  {
    IAutoDBItem.MAutoDBInfo localMAutoDBInfo = new IAutoDBItem.MAutoDBInfo();
    localMAutoDBInfo.fields = new Field[3];
    localMAutoDBInfo.columns = new String[4];
    StringBuilder localStringBuilder = new StringBuilder();
    localMAutoDBInfo.columns[0] = "appIdHash";
    localMAutoDBInfo.colsMap.put("appIdHash", "INTEGER PRIMARY KEY ");
    localStringBuilder.append(" appIdHash INTEGER PRIMARY KEY ");
    localStringBuilder.append(", ");
    localMAutoDBInfo.primaryKey = "appIdHash";
    localMAutoDBInfo.columns[1] = "appId";
    localMAutoDBInfo.colsMap.put("appId", "TEXT");
    localStringBuilder.append(" appId TEXT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[2] = "openDebug";
    localMAutoDBInfo.colsMap.put("openDebug", "INTEGER");
    localStringBuilder.append(" openDebug INTEGER");
    localMAutoDBInfo.columns[3] = "rowid";
    localMAutoDBInfo.sql = localStringBuilder.toString();
    if (localMAutoDBInfo.primaryKey == null) {
      localMAutoDBInfo.primaryKey = "rowid";
    }
    return localMAutoDBInfo;
  }
  
  public void convertFrom(ContentValues paramContentValues, boolean paramBoolean)
  {
    if (paramContentValues.containsKey("appIdHash"))
    {
      this.field_appIdHash = paramContentValues.getAsInteger("appIdHash").intValue();
      if (paramBoolean) {
        this.kHF = true;
      }
    }
    if (paramContentValues.containsKey("appId"))
    {
      this.field_appId = paramContentValues.getAsString("appId");
      if (paramBoolean) {
        this.jKG = true;
      }
    }
    if (paramContentValues.containsKey("openDebug")) {
      if (paramContentValues.getAsInteger("openDebug").intValue() == 0) {
        break label119;
      }
    }
    label119:
    for (boolean bool = true;; bool = false)
    {
      this.field_openDebug = bool;
      if (paramBoolean) {
        this.lpV = true;
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
      if (kHN != k) {
        break label65;
      }
      this.field_appIdHash = paramCursor.getInt(i);
      this.kHF = true;
    }
    for (;;)
    {
      i += 1;
      break label20;
      break;
      label65:
      if (jKX == k)
      {
        this.field_appId = paramCursor.getString(i);
      }
      else
      {
        if (lpW == k)
        {
          if (paramCursor.getInt(i) != 0) {}
          for (boolean bool = true;; bool = false)
          {
            this.field_openDebug = bool;
            break;
          }
        }
        if (rowid_HASHCODE == k) {
          this.systemRowid = paramCursor.getLong(i);
        }
      }
    }
  }
  
  public ContentValues convertTo()
  {
    ContentValues localContentValues = new ContentValues();
    if (this.kHF) {
      localContentValues.put("appIdHash", Integer.valueOf(this.field_appIdHash));
    }
    if (this.jKG) {
      localContentValues.put("appId", this.field_appId);
    }
    if (this.lpV) {
      localContentValues.put("openDebug", Boolean.valueOf(this.field_openDebug));
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
  
  public StorageObserverOwner<? extends jm> getObserverOwner()
  {
    return observerOwner;
  }
  
  public Object getPrimaryKeyValue()
  {
    return Integer.valueOf(this.field_appIdHash);
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
 * Qualified Name:     com.tencent.mm.autogen.b.jm
 * JD-Core Version:    0.7.0.1
 */