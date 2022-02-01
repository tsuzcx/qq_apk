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

public abstract class ai
  extends IAutoDBItem
{
  public static final IAutoDBItem.MAutoDBInfo DB_INFO = aJm();
  public static final String[] INDEX_CREATE;
  public static final Column ROWID;
  public static final SingleTable TABLE = new SingleTable("BizChatInfo");
  public static final Column jPG;
  public static final Column jPP;
  public static final Column jQA;
  public static final Column jQB;
  public static final Column jQC;
  public static final Column jQD;
  public static final Column jQE;
  public static final Column jQF;
  public static final Column jQG;
  public static final Column jQH;
  public static final Column jQI;
  public static final Column jQJ;
  public static final Column jQK;
  private static final int jQY;
  private static final int jQZ;
  private static final int jQk;
  private static final int jQt;
  public static final Column jQy;
  public static final Column jQz;
  private static final int jRa;
  private static final int jRb;
  private static final int jRc;
  private static final int jRd;
  private static final int jRe;
  private static final int jRf;
  private static final int jRg;
  private static final int jRh;
  private static final int jRi;
  private static final int jRj;
  private static final int jRk;
  private static final StorageObserverOwner<ai> observerOwner = new StorageObserverOwner();
  private static final int rowid_HASHCODE;
  public String field_addMemberUrl;
  public int field_bitFlag;
  public long field_bizChatLocalId;
  public String field_bizChatServId;
  public String field_brandUserName;
  public String field_chatName;
  public String field_chatNamePY;
  public int field_chatType;
  public int field_chatVersion;
  public String field_headImageUrl;
  public int field_maxMemberCnt;
  public boolean field_needToUpdate;
  public String field_ownerUserId;
  public int field_roomflag;
  public String field_userList;
  private boolean jPV = true;
  private boolean jQL = true;
  private boolean jQM = true;
  private boolean jQN = true;
  private boolean jQO = true;
  private boolean jQP = true;
  private boolean jQQ = true;
  private boolean jQR = true;
  private boolean jQS = true;
  private boolean jQT = true;
  private boolean jQU = true;
  private boolean jQV = true;
  private boolean jQW = true;
  private boolean jQX = true;
  private boolean jQe = true;
  
  static
  {
    ROWID = new Column("rowid", "long", TABLE.getName(), "");
    jQy = new Column("bizChatLocalId", "long", TABLE.getName(), "");
    jQz = new Column("bizChatServId", "string", TABLE.getName(), "");
    jPG = new Column("brandUserName", "string", TABLE.getName(), "");
    jPP = new Column("chatType", "int", TABLE.getName(), "");
    jQA = new Column("headImageUrl", "string", TABLE.getName(), "");
    jQB = new Column("chatName", "string", TABLE.getName(), "");
    jQC = new Column("chatNamePY", "string", TABLE.getName(), "");
    jQD = new Column("chatVersion", "int", TABLE.getName(), "");
    jQE = new Column("needToUpdate", "boolean", TABLE.getName(), "");
    jQF = new Column("bitFlag", "int", TABLE.getName(), "");
    jQG = new Column("maxMemberCnt", "int", TABLE.getName(), "");
    jQH = new Column("ownerUserId", "string", TABLE.getName(), "");
    jQI = new Column("userList", "string", TABLE.getName(), "");
    jQJ = new Column("addMemberUrl", "string", TABLE.getName(), "");
    jQK = new Column("roomflag", "int", TABLE.getName(), "");
    INDEX_CREATE = new String[0];
    jQY = "bizChatLocalId".hashCode();
    jQZ = "bizChatServId".hashCode();
    jQk = "brandUserName".hashCode();
    jQt = "chatType".hashCode();
    jRa = "headImageUrl".hashCode();
    jRb = "chatName".hashCode();
    jRc = "chatNamePY".hashCode();
    jRd = "chatVersion".hashCode();
    jRe = "needToUpdate".hashCode();
    jRf = "bitFlag".hashCode();
    jRg = "maxMemberCnt".hashCode();
    jRh = "ownerUserId".hashCode();
    jRi = "userList".hashCode();
    jRj = "addMemberUrl".hashCode();
    jRk = "roomflag".hashCode();
    rowid_HASHCODE = "rowid".hashCode();
  }
  
  public static IAutoDBItem.MAutoDBInfo aJm()
  {
    IAutoDBItem.MAutoDBInfo localMAutoDBInfo = new IAutoDBItem.MAutoDBInfo();
    localMAutoDBInfo.fields = new Field[15];
    localMAutoDBInfo.columns = new String[16];
    StringBuilder localStringBuilder = new StringBuilder();
    localMAutoDBInfo.columns[0] = "bizChatLocalId";
    localMAutoDBInfo.colsMap.put("bizChatLocalId", "LONG PRIMARY KEY ");
    localStringBuilder.append(" bizChatLocalId LONG PRIMARY KEY ");
    localStringBuilder.append(", ");
    localMAutoDBInfo.primaryKey = "bizChatLocalId";
    localMAutoDBInfo.columns[1] = "bizChatServId";
    localMAutoDBInfo.colsMap.put("bizChatServId", "TEXT");
    localStringBuilder.append(" bizChatServId TEXT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[2] = "brandUserName";
    localMAutoDBInfo.colsMap.put("brandUserName", "TEXT default '' ");
    localStringBuilder.append(" brandUserName TEXT default '' ");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[3] = "chatType";
    localMAutoDBInfo.colsMap.put("chatType", "INTEGER");
    localStringBuilder.append(" chatType INTEGER");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[4] = "headImageUrl";
    localMAutoDBInfo.colsMap.put("headImageUrl", "TEXT");
    localStringBuilder.append(" headImageUrl TEXT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[5] = "chatName";
    localMAutoDBInfo.colsMap.put("chatName", "TEXT default '' ");
    localStringBuilder.append(" chatName TEXT default '' ");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[6] = "chatNamePY";
    localMAutoDBInfo.colsMap.put("chatNamePY", "TEXT default '' ");
    localStringBuilder.append(" chatNamePY TEXT default '' ");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[7] = "chatVersion";
    localMAutoDBInfo.colsMap.put("chatVersion", "INTEGER default '-1' ");
    localStringBuilder.append(" chatVersion INTEGER default '-1' ");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[8] = "needToUpdate";
    localMAutoDBInfo.colsMap.put("needToUpdate", "INTEGER default 'true' ");
    localStringBuilder.append(" needToUpdate INTEGER default 'true' ");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[9] = "bitFlag";
    localMAutoDBInfo.colsMap.put("bitFlag", "INTEGER default '0' ");
    localStringBuilder.append(" bitFlag INTEGER default '0' ");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[10] = "maxMemberCnt";
    localMAutoDBInfo.colsMap.put("maxMemberCnt", "INTEGER default '0' ");
    localStringBuilder.append(" maxMemberCnt INTEGER default '0' ");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[11] = "ownerUserId";
    localMAutoDBInfo.colsMap.put("ownerUserId", "TEXT");
    localStringBuilder.append(" ownerUserId TEXT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[12] = "userList";
    localMAutoDBInfo.colsMap.put("userList", "TEXT");
    localStringBuilder.append(" userList TEXT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[13] = "addMemberUrl";
    localMAutoDBInfo.colsMap.put("addMemberUrl", "TEXT");
    localStringBuilder.append(" addMemberUrl TEXT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[14] = "roomflag";
    localMAutoDBInfo.colsMap.put("roomflag", "INTEGER default '0' ");
    localStringBuilder.append(" roomflag INTEGER default '0' ");
    localMAutoDBInfo.columns[15] = "rowid";
    localMAutoDBInfo.sql = localStringBuilder.toString();
    if (localMAutoDBInfo.primaryKey == null) {
      localMAutoDBInfo.primaryKey = "rowid";
    }
    return localMAutoDBInfo;
  }
  
  public void convertFrom(ContentValues paramContentValues, boolean paramBoolean)
  {
    if (paramContentValues.containsKey("bizChatLocalId"))
    {
      this.field_bizChatLocalId = paramContentValues.getAsLong("bizChatLocalId").longValue();
      if (paramBoolean) {
        this.jQL = true;
      }
    }
    if (paramContentValues.containsKey("bizChatServId"))
    {
      this.field_bizChatServId = paramContentValues.getAsString("bizChatServId");
      if (paramBoolean) {
        this.jQM = true;
      }
    }
    if (paramContentValues.containsKey("brandUserName"))
    {
      this.field_brandUserName = paramContentValues.getAsString("brandUserName");
      if (paramBoolean) {
        this.jPV = true;
      }
    }
    if (paramContentValues.containsKey("chatType"))
    {
      this.field_chatType = paramContentValues.getAsInteger("chatType").intValue();
      if (paramBoolean) {
        this.jQe = true;
      }
    }
    if (paramContentValues.containsKey("headImageUrl"))
    {
      this.field_headImageUrl = paramContentValues.getAsString("headImageUrl");
      if (paramBoolean) {
        this.jQN = true;
      }
    }
    if (paramContentValues.containsKey("chatName"))
    {
      this.field_chatName = paramContentValues.getAsString("chatName");
      if (paramBoolean) {
        this.jQO = true;
      }
    }
    if (paramContentValues.containsKey("chatNamePY"))
    {
      this.field_chatNamePY = paramContentValues.getAsString("chatNamePY");
      if (paramBoolean) {
        this.jQP = true;
      }
    }
    if (paramContentValues.containsKey("chatVersion"))
    {
      this.field_chatVersion = paramContentValues.getAsInteger("chatVersion").intValue();
      if (paramBoolean) {
        this.jQQ = true;
      }
    }
    if (paramContentValues.containsKey("needToUpdate")) {
      if (paramContentValues.getAsInteger("needToUpdate").intValue() == 0) {
        break label470;
      }
    }
    label470:
    for (boolean bool = true;; bool = false)
    {
      this.field_needToUpdate = bool;
      if (paramBoolean) {
        this.jQR = true;
      }
      if (paramContentValues.containsKey("bitFlag"))
      {
        this.field_bitFlag = paramContentValues.getAsInteger("bitFlag").intValue();
        if (paramBoolean) {
          this.jQS = true;
        }
      }
      if (paramContentValues.containsKey("maxMemberCnt"))
      {
        this.field_maxMemberCnt = paramContentValues.getAsInteger("maxMemberCnt").intValue();
        if (paramBoolean) {
          this.jQT = true;
        }
      }
      if (paramContentValues.containsKey("ownerUserId"))
      {
        this.field_ownerUserId = paramContentValues.getAsString("ownerUserId");
        if (paramBoolean) {
          this.jQU = true;
        }
      }
      if (paramContentValues.containsKey("userList"))
      {
        this.field_userList = paramContentValues.getAsString("userList");
        if (paramBoolean) {
          this.jQV = true;
        }
      }
      if (paramContentValues.containsKey("addMemberUrl"))
      {
        this.field_addMemberUrl = paramContentValues.getAsString("addMemberUrl");
        if (paramBoolean) {
          this.jQW = true;
        }
      }
      if (paramContentValues.containsKey("roomflag"))
      {
        this.field_roomflag = paramContentValues.getAsInteger("roomflag").intValue();
        if (paramBoolean) {
          this.jQX = true;
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
      if (jQY != k) {
        break label65;
      }
      this.field_bizChatLocalId = paramCursor.getLong(i);
      this.jQL = true;
    }
    for (;;)
    {
      i += 1;
      break label20;
      break;
      label65:
      if (jQZ == k)
      {
        this.field_bizChatServId = paramCursor.getString(i);
      }
      else if (jQk == k)
      {
        this.field_brandUserName = paramCursor.getString(i);
      }
      else if (jQt == k)
      {
        this.field_chatType = paramCursor.getInt(i);
      }
      else if (jRa == k)
      {
        this.field_headImageUrl = paramCursor.getString(i);
      }
      else if (jRb == k)
      {
        this.field_chatName = paramCursor.getString(i);
      }
      else if (jRc == k)
      {
        this.field_chatNamePY = paramCursor.getString(i);
      }
      else if (jRd == k)
      {
        this.field_chatVersion = paramCursor.getInt(i);
      }
      else
      {
        if (jRe == k)
        {
          if (paramCursor.getInt(i) != 0) {}
          for (boolean bool = true;; bool = false)
          {
            this.field_needToUpdate = bool;
            break;
          }
        }
        if (jRf == k) {
          this.field_bitFlag = paramCursor.getInt(i);
        } else if (jRg == k) {
          this.field_maxMemberCnt = paramCursor.getInt(i);
        } else if (jRh == k) {
          this.field_ownerUserId = paramCursor.getString(i);
        } else if (jRi == k) {
          this.field_userList = paramCursor.getString(i);
        } else if (jRj == k) {
          this.field_addMemberUrl = paramCursor.getString(i);
        } else if (jRk == k) {
          this.field_roomflag = paramCursor.getInt(i);
        } else if (rowid_HASHCODE == k) {
          this.systemRowid = paramCursor.getLong(i);
        }
      }
    }
  }
  
  public ContentValues convertTo()
  {
    ContentValues localContentValues = new ContentValues();
    if (this.jQL) {
      localContentValues.put("bizChatLocalId", Long.valueOf(this.field_bizChatLocalId));
    }
    if (this.jQM) {
      localContentValues.put("bizChatServId", this.field_bizChatServId);
    }
    if (this.field_brandUserName == null) {
      this.field_brandUserName = "";
    }
    if (this.jPV) {
      localContentValues.put("brandUserName", this.field_brandUserName);
    }
    if (this.jQe) {
      localContentValues.put("chatType", Integer.valueOf(this.field_chatType));
    }
    if (this.jQN) {
      localContentValues.put("headImageUrl", this.field_headImageUrl);
    }
    if (this.field_chatName == null) {
      this.field_chatName = "";
    }
    if (this.jQO) {
      localContentValues.put("chatName", this.field_chatName);
    }
    if (this.field_chatNamePY == null) {
      this.field_chatNamePY = "";
    }
    if (this.jQP) {
      localContentValues.put("chatNamePY", this.field_chatNamePY);
    }
    if (this.jQQ) {
      localContentValues.put("chatVersion", Integer.valueOf(this.field_chatVersion));
    }
    if (this.jQR) {
      localContentValues.put("needToUpdate", Boolean.valueOf(this.field_needToUpdate));
    }
    if (this.jQS) {
      localContentValues.put("bitFlag", Integer.valueOf(this.field_bitFlag));
    }
    if (this.jQT) {
      localContentValues.put("maxMemberCnt", Integer.valueOf(this.field_maxMemberCnt));
    }
    if (this.jQU) {
      localContentValues.put("ownerUserId", this.field_ownerUserId);
    }
    if (this.jQV) {
      localContentValues.put("userList", this.field_userList);
    }
    if (this.jQW) {
      localContentValues.put("addMemberUrl", this.field_addMemberUrl);
    }
    if (this.jQX) {
      localContentValues.put("roomflag", Integer.valueOf(this.field_roomflag));
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
  
  public StorageObserverOwner<? extends ai> getObserverOwner()
  {
    return observerOwner;
  }
  
  public Object getPrimaryKeyValue()
  {
    return Long.valueOf(this.field_bizChatLocalId);
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
 * Qualified Name:     com.tencent.mm.autogen.b.ai
 * JD-Core Version:    0.7.0.1
 */