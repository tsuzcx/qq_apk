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

public abstract class dh
  extends IAutoDBItem
{
  public static final IAutoDBItem.MAutoDBInfo DB_INFO = aJm();
  public static final String[] INDEX_CREATE;
  public static final Column ROWID;
  public static final SingleTable TABLE = new SingleTable("FriendUser");
  public static final Column USERNAME;
  private static final int jNY;
  public static final Column jNg;
  private static final int jZQ;
  public static final Column jZe;
  private static final StorageObserverOwner<dh> observerOwner = new StorageObserverOwner();
  private static final int rowid_HASHCODE;
  private static final int username_HASHCODE;
  private boolean __hadSetusername = true;
  public String field_encryptUsername;
  public long field_modifyTime;
  public String field_username;
  private boolean jNC = true;
  private boolean jZx = true;
  
  static
  {
    ROWID = new Column("rowid", "long", TABLE.getName(), "");
    jZe = new Column("encryptUsername", "string", TABLE.getName(), "");
    USERNAME = new Column("username", "string", TABLE.getName(), "");
    jNg = new Column("modifyTime", "long", TABLE.getName(), "");
    INDEX_CREATE = new String[0];
    jZQ = "encryptUsername".hashCode();
    username_HASHCODE = "username".hashCode();
    jNY = "modifyTime".hashCode();
    rowid_HASHCODE = "rowid".hashCode();
  }
  
  public static IAutoDBItem.MAutoDBInfo aJm()
  {
    IAutoDBItem.MAutoDBInfo localMAutoDBInfo = new IAutoDBItem.MAutoDBInfo();
    localMAutoDBInfo.fields = new Field[3];
    localMAutoDBInfo.columns = new String[4];
    StringBuilder localStringBuilder = new StringBuilder();
    localMAutoDBInfo.columns[0] = "encryptUsername";
    localMAutoDBInfo.colsMap.put("encryptUsername", "TEXT default ''  PRIMARY KEY ");
    localStringBuilder.append(" encryptUsername TEXT default ''  PRIMARY KEY ");
    localStringBuilder.append(", ");
    localMAutoDBInfo.primaryKey = "encryptUsername";
    localMAutoDBInfo.columns[1] = "username";
    localMAutoDBInfo.colsMap.put("username", "TEXT default '' ");
    localStringBuilder.append(" username TEXT default '' ");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[2] = "modifyTime";
    localMAutoDBInfo.colsMap.put("modifyTime", "LONG default '0' ");
    localStringBuilder.append(" modifyTime LONG default '0' ");
    localMAutoDBInfo.columns[3] = "rowid";
    localMAutoDBInfo.sql = localStringBuilder.toString();
    if (localMAutoDBInfo.primaryKey == null) {
      localMAutoDBInfo.primaryKey = "rowid";
    }
    return localMAutoDBInfo;
  }
  
  public void convertFrom(ContentValues paramContentValues, boolean paramBoolean)
  {
    if (paramContentValues.containsKey("encryptUsername"))
    {
      this.field_encryptUsername = paramContentValues.getAsString("encryptUsername");
      if (paramBoolean) {
        this.jZx = true;
      }
    }
    if (paramContentValues.containsKey("username"))
    {
      this.field_username = paramContentValues.getAsString("username");
      if (paramBoolean) {
        this.__hadSetusername = true;
      }
    }
    if (paramContentValues.containsKey("modifyTime"))
    {
      this.field_modifyTime = paramContentValues.getAsLong("modifyTime").longValue();
      if (paramBoolean) {
        this.jNC = true;
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
      if (jZQ != k) {
        break label65;
      }
      this.field_encryptUsername = paramCursor.getString(i);
      this.jZx = true;
    }
    for (;;)
    {
      i += 1;
      break label20;
      break;
      label65:
      if (username_HASHCODE == k) {
        this.field_username = paramCursor.getString(i);
      } else if (jNY == k) {
        this.field_modifyTime = paramCursor.getLong(i);
      } else if (rowid_HASHCODE == k) {
        this.systemRowid = paramCursor.getLong(i);
      }
    }
  }
  
  public ContentValues convertTo()
  {
    ContentValues localContentValues = new ContentValues();
    if (this.field_encryptUsername == null) {
      this.field_encryptUsername = "";
    }
    if (this.jZx) {
      localContentValues.put("encryptUsername", this.field_encryptUsername);
    }
    if (this.field_username == null) {
      this.field_username = "";
    }
    if (this.__hadSetusername) {
      localContentValues.put("username", this.field_username);
    }
    if (this.jNC) {
      localContentValues.put("modifyTime", Long.valueOf(this.field_modifyTime));
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
  
  public StorageObserverOwner<? extends dh> getObserverOwner()
  {
    return observerOwner;
  }
  
  public Object getPrimaryKeyValue()
  {
    return this.field_encryptUsername;
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
 * Qualified Name:     com.tencent.mm.autogen.b.dh
 * JD-Core Version:    0.7.0.1
 */