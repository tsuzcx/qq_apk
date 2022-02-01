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

public abstract class ib
  extends IAutoDBItem
{
  public static final IAutoDBItem.MAutoDBInfo DB_INFO = aJm();
  public static final String[] INDEX_CREATE;
  public static final Column ROWID;
  public static final SingleTable TABLE = new SingleTable("UserOpenIdInApp");
  public static final Column USERNAME;
  private static final int jKX;
  public static final Column jKp;
  public static final Column jNn;
  private static final int jOf;
  private static final StorageObserverOwner<ib> observerOwner = new StorageObserverOwner();
  private static final int rowid_HASHCODE;
  private static final int username_HASHCODE;
  private boolean __hadSetusername = true;
  public String field_appId;
  public String field_openId;
  public String field_username;
  private boolean jKG = true;
  private boolean jNJ = true;
  
  static
  {
    ROWID = new Column("rowid", "long", TABLE.getName(), "");
    jNn = new Column("openId", "string", TABLE.getName(), "");
    jKp = new Column("appId", "string", TABLE.getName(), "");
    USERNAME = new Column("username", "string", TABLE.getName(), "");
    INDEX_CREATE = new String[0];
    jOf = "openId".hashCode();
    jKX = "appId".hashCode();
    username_HASHCODE = "username".hashCode();
    rowid_HASHCODE = "rowid".hashCode();
  }
  
  public static IAutoDBItem.MAutoDBInfo aJm()
  {
    IAutoDBItem.MAutoDBInfo localMAutoDBInfo = new IAutoDBItem.MAutoDBInfo();
    localMAutoDBInfo.fields = new Field[3];
    localMAutoDBInfo.columns = new String[4];
    StringBuilder localStringBuilder = new StringBuilder();
    localMAutoDBInfo.columns[0] = "openId";
    localMAutoDBInfo.colsMap.put("openId", "TEXT PRIMARY KEY ");
    localStringBuilder.append(" openId TEXT PRIMARY KEY ");
    localStringBuilder.append(", ");
    localMAutoDBInfo.primaryKey = "openId";
    localMAutoDBInfo.columns[1] = "appId";
    localMAutoDBInfo.colsMap.put("appId", "TEXT");
    localStringBuilder.append(" appId TEXT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[2] = "username";
    localMAutoDBInfo.colsMap.put("username", "TEXT");
    localStringBuilder.append(" username TEXT");
    localMAutoDBInfo.columns[3] = "rowid";
    localMAutoDBInfo.sql = localStringBuilder.toString();
    if (localMAutoDBInfo.primaryKey == null) {
      localMAutoDBInfo.primaryKey = "rowid";
    }
    return localMAutoDBInfo;
  }
  
  public void convertFrom(ContentValues paramContentValues, boolean paramBoolean)
  {
    if (paramContentValues.containsKey("openId"))
    {
      this.field_openId = paramContentValues.getAsString("openId");
      if (paramBoolean) {
        this.jNJ = true;
      }
    }
    if (paramContentValues.containsKey("appId"))
    {
      this.field_appId = paramContentValues.getAsString("appId");
      if (paramBoolean) {
        this.jKG = true;
      }
    }
    if (paramContentValues.containsKey("username"))
    {
      this.field_username = paramContentValues.getAsString("username");
      if (paramBoolean) {
        this.__hadSetusername = true;
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
      if (jOf != k) {
        break label65;
      }
      this.field_openId = paramCursor.getString(i);
      this.jNJ = true;
    }
    for (;;)
    {
      i += 1;
      break label20;
      break;
      label65:
      if (jKX == k) {
        this.field_appId = paramCursor.getString(i);
      } else if (username_HASHCODE == k) {
        this.field_username = paramCursor.getString(i);
      } else if (rowid_HASHCODE == k) {
        this.systemRowid = paramCursor.getLong(i);
      }
    }
  }
  
  public ContentValues convertTo()
  {
    ContentValues localContentValues = new ContentValues();
    if (this.jNJ) {
      localContentValues.put("openId", this.field_openId);
    }
    if (this.jKG) {
      localContentValues.put("appId", this.field_appId);
    }
    if (this.__hadSetusername) {
      localContentValues.put("username", this.field_username);
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
  
  public StorageObserverOwner<? extends ib> getObserverOwner()
  {
    return observerOwner;
  }
  
  public Object getPrimaryKeyValue()
  {
    return this.field_openId;
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
 * Qualified Name:     com.tencent.mm.autogen.b.ib
 * JD-Core Version:    0.7.0.1
 */