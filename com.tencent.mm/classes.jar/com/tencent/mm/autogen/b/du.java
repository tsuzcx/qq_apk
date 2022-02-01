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

public abstract class du
  extends IAutoDBItem
{
  public static final IAutoDBItem.MAutoDBInfo DB_INFO = aJm();
  public static final String[] INDEX_CREATE;
  public static final Column ROWID;
  public static final SingleTable TABLE = new SingleTable("GameSimpleUserInfo");
  public static final Column UPDATETIME;
  public static final Column USERNAME;
  public static final Column jTk;
  public static final Column kna;
  private static final int kwL;
  private static final int kwM;
  private static final int kwN;
  private static final int kwT;
  public static final Column kwh;
  public static final Column kwn;
  public static final Column kzT;
  private static final int kzV;
  private static final StorageObserverOwner<du> observerOwner = new StorageObserverOwner();
  private static final int rowid_HASHCODE;
  private static final int updateTime_HASHCODE;
  private static final int userName_HASHCODE;
  private boolean __hadSetupdateTime = true;
  private boolean __hadSetuserName = true;
  public String field_avatarURL;
  public String field_compositionKey;
  public String field_nickName;
  public int field_role;
  public String field_roomName;
  public long field_updateTime;
  public String field_userName;
  private boolean kwD = true;
  private boolean kwv = true;
  private boolean kww = true;
  private boolean kwx = true;
  private boolean kzU = true;
  
  static
  {
    ROWID = new Column("rowid", "long", TABLE.getName(), "");
    kzT = new Column("compositionKey", "string", TABLE.getName(), "");
    USERNAME = new Column("userName", "string", TABLE.getName(), "");
    kwh = new Column("roomName", "string", TABLE.getName(), "");
    jTk = new Column("nickName", "string", TABLE.getName(), "");
    kna = new Column("avatarURL", "string", TABLE.getName(), "");
    kwn = new Column("role", "int", TABLE.getName(), "");
    UPDATETIME = new Column("updateTime", "long", TABLE.getName(), "");
    INDEX_CREATE = new String[] { "CREATE INDEX IF NOT EXISTS GameSimpleUserInfo_UserName ON GameSimpleUserInfo(userName)", "CREATE INDEX IF NOT EXISTS GameSimpleUserInfo_RoomName ON GameSimpleUserInfo(roomName)", "CREATE INDEX IF NOT EXISTS GameSimpleUserInfo_NickName ON GameSimpleUserInfo(nickName)" };
    kzV = "compositionKey".hashCode();
    userName_HASHCODE = "userName".hashCode();
    kwL = "roomName".hashCode();
    kwM = "nickName".hashCode();
    kwN = "avatarURL".hashCode();
    kwT = "role".hashCode();
    updateTime_HASHCODE = "updateTime".hashCode();
    rowid_HASHCODE = "rowid".hashCode();
  }
  
  public static IAutoDBItem.MAutoDBInfo aJm()
  {
    IAutoDBItem.MAutoDBInfo localMAutoDBInfo = new IAutoDBItem.MAutoDBInfo();
    localMAutoDBInfo.fields = new Field[7];
    localMAutoDBInfo.columns = new String[8];
    StringBuilder localStringBuilder = new StringBuilder();
    localMAutoDBInfo.columns[0] = "compositionKey";
    localMAutoDBInfo.colsMap.put("compositionKey", "TEXT default ''  PRIMARY KEY ");
    localStringBuilder.append(" compositionKey TEXT default ''  PRIMARY KEY ");
    localStringBuilder.append(", ");
    localMAutoDBInfo.primaryKey = "compositionKey";
    localMAutoDBInfo.columns[1] = "userName";
    localMAutoDBInfo.colsMap.put("userName", "TEXT default '' ");
    localStringBuilder.append(" userName TEXT default '' ");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[2] = "roomName";
    localMAutoDBInfo.colsMap.put("roomName", "TEXT default '' ");
    localStringBuilder.append(" roomName TEXT default '' ");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[3] = "nickName";
    localMAutoDBInfo.colsMap.put("nickName", "TEXT default '' ");
    localStringBuilder.append(" nickName TEXT default '' ");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[4] = "avatarURL";
    localMAutoDBInfo.colsMap.put("avatarURL", "TEXT default '' ");
    localStringBuilder.append(" avatarURL TEXT default '' ");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[5] = "role";
    localMAutoDBInfo.colsMap.put("role", "INTEGER default '0' ");
    localStringBuilder.append(" role INTEGER default '0' ");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[6] = "updateTime";
    localMAutoDBInfo.colsMap.put("updateTime", "LONG");
    localStringBuilder.append(" updateTime LONG");
    localMAutoDBInfo.columns[7] = "rowid";
    localMAutoDBInfo.sql = localStringBuilder.toString();
    if (localMAutoDBInfo.primaryKey == null) {
      localMAutoDBInfo.primaryKey = "rowid";
    }
    return localMAutoDBInfo;
  }
  
  public void convertFrom(ContentValues paramContentValues, boolean paramBoolean)
  {
    if (paramContentValues.containsKey("compositionKey"))
    {
      this.field_compositionKey = paramContentValues.getAsString("compositionKey");
      if (paramBoolean) {
        this.kzU = true;
      }
    }
    if (paramContentValues.containsKey("userName"))
    {
      this.field_userName = paramContentValues.getAsString("userName");
      if (paramBoolean) {
        this.__hadSetuserName = true;
      }
    }
    if (paramContentValues.containsKey("roomName"))
    {
      this.field_roomName = paramContentValues.getAsString("roomName");
      if (paramBoolean) {
        this.kwv = true;
      }
    }
    if (paramContentValues.containsKey("nickName"))
    {
      this.field_nickName = paramContentValues.getAsString("nickName");
      if (paramBoolean) {
        this.kww = true;
      }
    }
    if (paramContentValues.containsKey("avatarURL"))
    {
      this.field_avatarURL = paramContentValues.getAsString("avatarURL");
      if (paramBoolean) {
        this.kwx = true;
      }
    }
    if (paramContentValues.containsKey("role"))
    {
      this.field_role = paramContentValues.getAsInteger("role").intValue();
      if (paramBoolean) {
        this.kwD = true;
      }
    }
    if (paramContentValues.containsKey("updateTime"))
    {
      this.field_updateTime = paramContentValues.getAsLong("updateTime").longValue();
      if (paramBoolean) {
        this.__hadSetupdateTime = true;
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
      if (kzV != k) {
        break label65;
      }
      this.field_compositionKey = paramCursor.getString(i);
      this.kzU = true;
    }
    for (;;)
    {
      i += 1;
      break label20;
      break;
      label65:
      if (userName_HASHCODE == k) {
        this.field_userName = paramCursor.getString(i);
      } else if (kwL == k) {
        this.field_roomName = paramCursor.getString(i);
      } else if (kwM == k) {
        this.field_nickName = paramCursor.getString(i);
      } else if (kwN == k) {
        this.field_avatarURL = paramCursor.getString(i);
      } else if (kwT == k) {
        this.field_role = paramCursor.getInt(i);
      } else if (updateTime_HASHCODE == k) {
        this.field_updateTime = paramCursor.getLong(i);
      } else if (rowid_HASHCODE == k) {
        this.systemRowid = paramCursor.getLong(i);
      }
    }
  }
  
  public ContentValues convertTo()
  {
    ContentValues localContentValues = new ContentValues();
    if (this.field_compositionKey == null) {
      this.field_compositionKey = "";
    }
    if (this.kzU) {
      localContentValues.put("compositionKey", this.field_compositionKey);
    }
    if (this.field_userName == null) {
      this.field_userName = "";
    }
    if (this.__hadSetuserName) {
      localContentValues.put("userName", this.field_userName);
    }
    if (this.field_roomName == null) {
      this.field_roomName = "";
    }
    if (this.kwv) {
      localContentValues.put("roomName", this.field_roomName);
    }
    if (this.field_nickName == null) {
      this.field_nickName = "";
    }
    if (this.kww) {
      localContentValues.put("nickName", this.field_nickName);
    }
    if (this.field_avatarURL == null) {
      this.field_avatarURL = "";
    }
    if (this.kwx) {
      localContentValues.put("avatarURL", this.field_avatarURL);
    }
    if (this.kwD) {
      localContentValues.put("role", Integer.valueOf(this.field_role));
    }
    if (this.__hadSetupdateTime) {
      localContentValues.put("updateTime", Long.valueOf(this.field_updateTime));
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
  
  public StorageObserverOwner<? extends du> getObserverOwner()
  {
    return observerOwner;
  }
  
  public Object getPrimaryKeyValue()
  {
    return this.field_compositionKey;
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
 * Qualified Name:     com.tencent.mm.autogen.b.du
 * JD-Core Version:    0.7.0.1
 */