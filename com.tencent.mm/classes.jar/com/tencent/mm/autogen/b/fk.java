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

public abstract class fk
  extends IAutoDBItem
{
  public static final Column CREATETIME;
  public static final IAutoDBItem.MAutoDBInfo DB_INFO = aJm();
  public static final String[] INDEX_CREATE;
  public static final Column ROWID;
  public static final SingleTable TABLE = new SingleTable("MultiTalkInfo");
  private static final int createTime_HASHCODE;
  public static final Column jXi;
  private static final int jYm;
  public static final Column kLF;
  public static final Column kLG;
  public static final Column kLH;
  public static final Column kLI;
  public static final Column kLJ;
  public static final Column kLK;
  private static final int kLR;
  private static final int kLS;
  private static final int kLT;
  private static final int kLU;
  private static final int kLV;
  private static final int kLW;
  public static final Column kee;
  public static final Column kel;
  private static final int kfH;
  private static final int kfO;
  private static final StorageObserverOwner<fk> observerOwner = new StorageObserverOwner();
  private static final int rowid_HASHCODE;
  private boolean __hadSetcreateTime = true;
  public long field_createTime;
  public String field_groupId;
  public long field_ilinkRoomId;
  public String field_inviteUserName;
  public int field_memberCount;
  public int field_roomId;
  public long field_roomKey;
  public int field_routeId;
  public int field_state;
  public String field_wxGroupId;
  private boolean jXK = true;
  private boolean kLL = true;
  private boolean kLM = true;
  private boolean kLN = true;
  private boolean kLO = true;
  private boolean kLP = true;
  private boolean kLQ = true;
  private boolean keT = true;
  private boolean kfa = true;
  
  static
  {
    ROWID = new Column("rowid", "long", TABLE.getName(), "");
    kLF = new Column("wxGroupId", "string", TABLE.getName(), "");
    kel = new Column("groupId", "string", TABLE.getName(), "");
    kLG = new Column("roomId", "int", TABLE.getName(), "");
    kLH = new Column("roomKey", "long", TABLE.getName(), "");
    kLI = new Column("routeId", "int", TABLE.getName(), "");
    kLJ = new Column("inviteUserName", "string", TABLE.getName(), "");
    jXi = new Column("memberCount", "int", TABLE.getName(), "");
    CREATETIME = new Column("createTime", "long", TABLE.getName(), "");
    kee = new Column("state", "int", TABLE.getName(), "");
    kLK = new Column("ilinkRoomId", "long", TABLE.getName(), "");
    INDEX_CREATE = new String[0];
    kLR = "wxGroupId".hashCode();
    kfO = "groupId".hashCode();
    kLS = "roomId".hashCode();
    kLT = "roomKey".hashCode();
    kLU = "routeId".hashCode();
    kLV = "inviteUserName".hashCode();
    jYm = "memberCount".hashCode();
    createTime_HASHCODE = "createTime".hashCode();
    kfH = "state".hashCode();
    kLW = "ilinkRoomId".hashCode();
    rowid_HASHCODE = "rowid".hashCode();
  }
  
  public static IAutoDBItem.MAutoDBInfo aJm()
  {
    IAutoDBItem.MAutoDBInfo localMAutoDBInfo = new IAutoDBItem.MAutoDBInfo();
    localMAutoDBInfo.fields = new Field[10];
    localMAutoDBInfo.columns = new String[11];
    StringBuilder localStringBuilder = new StringBuilder();
    localMAutoDBInfo.columns[0] = "wxGroupId";
    localMAutoDBInfo.colsMap.put("wxGroupId", "TEXT PRIMARY KEY ");
    localStringBuilder.append(" wxGroupId TEXT PRIMARY KEY ");
    localStringBuilder.append(", ");
    localMAutoDBInfo.primaryKey = "wxGroupId";
    localMAutoDBInfo.columns[1] = "groupId";
    localMAutoDBInfo.colsMap.put("groupId", "TEXT");
    localStringBuilder.append(" groupId TEXT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[2] = "roomId";
    localMAutoDBInfo.colsMap.put("roomId", "INTEGER");
    localStringBuilder.append(" roomId INTEGER");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[3] = "roomKey";
    localMAutoDBInfo.colsMap.put("roomKey", "LONG");
    localStringBuilder.append(" roomKey LONG");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[4] = "routeId";
    localMAutoDBInfo.colsMap.put("routeId", "INTEGER");
    localStringBuilder.append(" routeId INTEGER");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[5] = "inviteUserName";
    localMAutoDBInfo.colsMap.put("inviteUserName", "TEXT");
    localStringBuilder.append(" inviteUserName TEXT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[6] = "memberCount";
    localMAutoDBInfo.colsMap.put("memberCount", "INTEGER");
    localStringBuilder.append(" memberCount INTEGER");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[7] = "createTime";
    localMAutoDBInfo.colsMap.put("createTime", "LONG");
    localStringBuilder.append(" createTime LONG");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[8] = "state";
    localMAutoDBInfo.colsMap.put("state", "INTEGER default '0' ");
    localStringBuilder.append(" state INTEGER default '0' ");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[9] = "ilinkRoomId";
    localMAutoDBInfo.colsMap.put("ilinkRoomId", "LONG");
    localStringBuilder.append(" ilinkRoomId LONG");
    localMAutoDBInfo.columns[10] = "rowid";
    localMAutoDBInfo.sql = localStringBuilder.toString();
    if (localMAutoDBInfo.primaryKey == null) {
      localMAutoDBInfo.primaryKey = "rowid";
    }
    return localMAutoDBInfo;
  }
  
  public void convertFrom(ContentValues paramContentValues, boolean paramBoolean)
  {
    if (paramContentValues.containsKey("wxGroupId"))
    {
      this.field_wxGroupId = paramContentValues.getAsString("wxGroupId");
      if (paramBoolean) {
        this.kLL = true;
      }
    }
    if (paramContentValues.containsKey("groupId"))
    {
      this.field_groupId = paramContentValues.getAsString("groupId");
      if (paramBoolean) {
        this.kfa = true;
      }
    }
    if (paramContentValues.containsKey("roomId"))
    {
      this.field_roomId = paramContentValues.getAsInteger("roomId").intValue();
      if (paramBoolean) {
        this.kLM = true;
      }
    }
    if (paramContentValues.containsKey("roomKey"))
    {
      this.field_roomKey = paramContentValues.getAsLong("roomKey").longValue();
      if (paramBoolean) {
        this.kLN = true;
      }
    }
    if (paramContentValues.containsKey("routeId"))
    {
      this.field_routeId = paramContentValues.getAsInteger("routeId").intValue();
      if (paramBoolean) {
        this.kLO = true;
      }
    }
    if (paramContentValues.containsKey("inviteUserName"))
    {
      this.field_inviteUserName = paramContentValues.getAsString("inviteUserName");
      if (paramBoolean) {
        this.kLP = true;
      }
    }
    if (paramContentValues.containsKey("memberCount"))
    {
      this.field_memberCount = paramContentValues.getAsInteger("memberCount").intValue();
      if (paramBoolean) {
        this.jXK = true;
      }
    }
    if (paramContentValues.containsKey("createTime"))
    {
      this.field_createTime = paramContentValues.getAsLong("createTime").longValue();
      if (paramBoolean) {
        this.__hadSetcreateTime = true;
      }
    }
    if (paramContentValues.containsKey("state"))
    {
      this.field_state = paramContentValues.getAsInteger("state").intValue();
      if (paramBoolean) {
        this.keT = true;
      }
    }
    if (paramContentValues.containsKey("ilinkRoomId"))
    {
      this.field_ilinkRoomId = paramContentValues.getAsLong("ilinkRoomId").longValue();
      if (paramBoolean) {
        this.kLQ = true;
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
      if (kLR != k) {
        break label65;
      }
      this.field_wxGroupId = paramCursor.getString(i);
      this.kLL = true;
    }
    for (;;)
    {
      i += 1;
      break label20;
      break;
      label65:
      if (kfO == k) {
        this.field_groupId = paramCursor.getString(i);
      } else if (kLS == k) {
        this.field_roomId = paramCursor.getInt(i);
      } else if (kLT == k) {
        this.field_roomKey = paramCursor.getLong(i);
      } else if (kLU == k) {
        this.field_routeId = paramCursor.getInt(i);
      } else if (kLV == k) {
        this.field_inviteUserName = paramCursor.getString(i);
      } else if (jYm == k) {
        this.field_memberCount = paramCursor.getInt(i);
      } else if (createTime_HASHCODE == k) {
        this.field_createTime = paramCursor.getLong(i);
      } else if (kfH == k) {
        this.field_state = paramCursor.getInt(i);
      } else if (kLW == k) {
        this.field_ilinkRoomId = paramCursor.getLong(i);
      } else if (rowid_HASHCODE == k) {
        this.systemRowid = paramCursor.getLong(i);
      }
    }
  }
  
  public ContentValues convertTo()
  {
    ContentValues localContentValues = new ContentValues();
    if (this.kLL) {
      localContentValues.put("wxGroupId", this.field_wxGroupId);
    }
    if (this.kfa) {
      localContentValues.put("groupId", this.field_groupId);
    }
    if (this.kLM) {
      localContentValues.put("roomId", Integer.valueOf(this.field_roomId));
    }
    if (this.kLN) {
      localContentValues.put("roomKey", Long.valueOf(this.field_roomKey));
    }
    if (this.kLO) {
      localContentValues.put("routeId", Integer.valueOf(this.field_routeId));
    }
    if (this.kLP) {
      localContentValues.put("inviteUserName", this.field_inviteUserName);
    }
    if (this.jXK) {
      localContentValues.put("memberCount", Integer.valueOf(this.field_memberCount));
    }
    if (this.__hadSetcreateTime) {
      localContentValues.put("createTime", Long.valueOf(this.field_createTime));
    }
    if (this.keT) {
      localContentValues.put("state", Integer.valueOf(this.field_state));
    }
    if (this.kLQ) {
      localContentValues.put("ilinkRoomId", Long.valueOf(this.field_ilinkRoomId));
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
  
  public StorageObserverOwner<? extends fk> getObserverOwner()
  {
    return observerOwner;
  }
  
  public Object getPrimaryKeyValue()
  {
    return this.field_wxGroupId;
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
 * Qualified Name:     com.tencent.mm.autogen.b.fk
 * JD-Core Version:    0.7.0.1
 */