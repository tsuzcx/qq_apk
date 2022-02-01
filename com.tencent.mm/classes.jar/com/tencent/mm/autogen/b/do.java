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

public abstract class do
  extends IAutoDBItem
{
  public static final IAutoDBItem.MAutoDBInfo DB_INFO = aJm();
  public static final String[] INDEX_CREATE;
  public static final Column ROWID;
  public static final SingleTable TABLE = new SingleTable("GameLifeConversation");
  public static final Column UPDATETIME;
  public static final Column jPH;
  public static final Column jPJ;
  public static final Column jPL;
  public static final Column jPO;
  private static final int jQl;
  private static final int jQn;
  private static final int jQp;
  private static final int jQs;
  public static final Column jTB;
  private static final int jUd;
  public static final Column kiW;
  private static final int kjy;
  public static final Column kus;
  public static final Column kyg;
  public static final Column kyh;
  private static final int kyl;
  private static final int kym;
  private static final int kyn;
  private static final StorageObserverOwner<do> observerOwner = new StorageObserverOwner();
  private static final int rowid_HASHCODE;
  private static final int updateTime_HASHCODE;
  private boolean __hadSetupdateTime = true;
  public String field_digest;
  public long field_digestFlag;
  public String field_digestPrefix;
  public String field_editingMsg;
  public long field_lastMsgID;
  public String field_selfUserName;
  public String field_sessionId;
  public String field_talker;
  public int field_unReadCount;
  public long field_updateTime;
  private boolean jPW = true;
  private boolean jPY = true;
  private boolean jQa = true;
  private boolean jQd = true;
  private boolean jTP = true;
  private boolean kjk = true;
  private boolean kyi = true;
  private boolean kyj = true;
  private boolean kyk = true;
  
  static
  {
    ROWID = new Column("rowid", "long", TABLE.getName(), "");
    kiW = new Column("sessionId", "string", TABLE.getName(), "");
    jTB = new Column("talker", "string", TABLE.getName(), "");
    kus = new Column("selfUserName", "string", TABLE.getName(), "");
    jPH = new Column("unReadCount", "int", TABLE.getName(), "");
    UPDATETIME = new Column("updateTime", "long", TABLE.getName(), "");
    jPL = new Column("digest", "string", TABLE.getName(), "");
    jPJ = new Column("lastMsgID", "long", TABLE.getName(), "");
    kyg = new Column("digestFlag", "long", TABLE.getName(), "");
    kyh = new Column("digestPrefix", "string", TABLE.getName(), "");
    jPO = new Column("editingMsg", "string", TABLE.getName(), "");
    INDEX_CREATE = new String[] { "CREATE INDEX IF NOT EXISTS GameLifeConversation_sessionId_index ON GameLifeConversation(sessionId)", "CREATE INDEX IF NOT EXISTS GameLifeConversation_talker_index ON GameLifeConversation(talker)", "CREATE INDEX IF NOT EXISTS GameLifeConversation_selfUserName_index ON GameLifeConversation(selfUserName)", "CREATE INDEX IF NOT EXISTS GameLifeConversation_updateTime_index ON GameLifeConversation(updateTime)" };
    kjy = "sessionId".hashCode();
    jUd = "talker".hashCode();
    kyl = "selfUserName".hashCode();
    jQl = "unReadCount".hashCode();
    updateTime_HASHCODE = "updateTime".hashCode();
    jQp = "digest".hashCode();
    jQn = "lastMsgID".hashCode();
    kym = "digestFlag".hashCode();
    kyn = "digestPrefix".hashCode();
    jQs = "editingMsg".hashCode();
    rowid_HASHCODE = "rowid".hashCode();
  }
  
  public static IAutoDBItem.MAutoDBInfo aJm()
  {
    IAutoDBItem.MAutoDBInfo localMAutoDBInfo = new IAutoDBItem.MAutoDBInfo();
    localMAutoDBInfo.fields = new Field[10];
    localMAutoDBInfo.columns = new String[11];
    StringBuilder localStringBuilder = new StringBuilder();
    localMAutoDBInfo.columns[0] = "sessionId";
    localMAutoDBInfo.colsMap.put("sessionId", "TEXT default ''  PRIMARY KEY ");
    localStringBuilder.append(" sessionId TEXT default ''  PRIMARY KEY ");
    localStringBuilder.append(", ");
    localMAutoDBInfo.primaryKey = "sessionId";
    localMAutoDBInfo.columns[1] = "talker";
    localMAutoDBInfo.colsMap.put("talker", "TEXT default '' ");
    localStringBuilder.append(" talker TEXT default '' ");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[2] = "selfUserName";
    localMAutoDBInfo.colsMap.put("selfUserName", "TEXT default '' ");
    localStringBuilder.append(" selfUserName TEXT default '' ");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[3] = "unReadCount";
    localMAutoDBInfo.colsMap.put("unReadCount", "INTEGER default '0' ");
    localStringBuilder.append(" unReadCount INTEGER default '0' ");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[4] = "updateTime";
    localMAutoDBInfo.colsMap.put("updateTime", "LONG default '0' ");
    localStringBuilder.append(" updateTime LONG default '0' ");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[5] = "digest";
    localMAutoDBInfo.colsMap.put("digest", "TEXT default '' ");
    localStringBuilder.append(" digest TEXT default '' ");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[6] = "lastMsgID";
    localMAutoDBInfo.colsMap.put("lastMsgID", "LONG");
    localStringBuilder.append(" lastMsgID LONG");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[7] = "digestFlag";
    localMAutoDBInfo.colsMap.put("digestFlag", "LONG default '0' ");
    localStringBuilder.append(" digestFlag LONG default '0' ");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[8] = "digestPrefix";
    localMAutoDBInfo.colsMap.put("digestPrefix", "TEXT default '' ");
    localStringBuilder.append(" digestPrefix TEXT default '' ");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[9] = "editingMsg";
    localMAutoDBInfo.colsMap.put("editingMsg", "TEXT default '' ");
    localStringBuilder.append(" editingMsg TEXT default '' ");
    localMAutoDBInfo.columns[10] = "rowid";
    localMAutoDBInfo.sql = localStringBuilder.toString();
    if (localMAutoDBInfo.primaryKey == null) {
      localMAutoDBInfo.primaryKey = "rowid";
    }
    return localMAutoDBInfo;
  }
  
  public void convertFrom(ContentValues paramContentValues, boolean paramBoolean)
  {
    if (paramContentValues.containsKey("sessionId"))
    {
      this.field_sessionId = paramContentValues.getAsString("sessionId");
      if (paramBoolean) {
        this.kjk = true;
      }
    }
    if (paramContentValues.containsKey("talker"))
    {
      this.field_talker = paramContentValues.getAsString("talker");
      if (paramBoolean) {
        this.jTP = true;
      }
    }
    if (paramContentValues.containsKey("selfUserName"))
    {
      this.field_selfUserName = paramContentValues.getAsString("selfUserName");
      if (paramBoolean) {
        this.kyi = true;
      }
    }
    if (paramContentValues.containsKey("unReadCount"))
    {
      this.field_unReadCount = paramContentValues.getAsInteger("unReadCount").intValue();
      if (paramBoolean) {
        this.jPW = true;
      }
    }
    if (paramContentValues.containsKey("updateTime"))
    {
      this.field_updateTime = paramContentValues.getAsLong("updateTime").longValue();
      if (paramBoolean) {
        this.__hadSetupdateTime = true;
      }
    }
    if (paramContentValues.containsKey("digest"))
    {
      this.field_digest = paramContentValues.getAsString("digest");
      if (paramBoolean) {
        this.jQa = true;
      }
    }
    if (paramContentValues.containsKey("lastMsgID"))
    {
      this.field_lastMsgID = paramContentValues.getAsLong("lastMsgID").longValue();
      if (paramBoolean) {
        this.jPY = true;
      }
    }
    if (paramContentValues.containsKey("digestFlag"))
    {
      this.field_digestFlag = paramContentValues.getAsLong("digestFlag").longValue();
      if (paramBoolean) {
        this.kyj = true;
      }
    }
    if (paramContentValues.containsKey("digestPrefix"))
    {
      this.field_digestPrefix = paramContentValues.getAsString("digestPrefix");
      if (paramBoolean) {
        this.kyk = true;
      }
    }
    if (paramContentValues.containsKey("editingMsg"))
    {
      this.field_editingMsg = paramContentValues.getAsString("editingMsg");
      if (paramBoolean) {
        this.jQd = true;
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
      if (kjy != k) {
        break label65;
      }
      this.field_sessionId = paramCursor.getString(i);
      this.kjk = true;
    }
    for (;;)
    {
      i += 1;
      break label20;
      break;
      label65:
      if (jUd == k) {
        this.field_talker = paramCursor.getString(i);
      } else if (kyl == k) {
        this.field_selfUserName = paramCursor.getString(i);
      } else if (jQl == k) {
        this.field_unReadCount = paramCursor.getInt(i);
      } else if (updateTime_HASHCODE == k) {
        this.field_updateTime = paramCursor.getLong(i);
      } else if (jQp == k) {
        this.field_digest = paramCursor.getString(i);
      } else if (jQn == k) {
        this.field_lastMsgID = paramCursor.getLong(i);
      } else if (kym == k) {
        this.field_digestFlag = paramCursor.getLong(i);
      } else if (kyn == k) {
        this.field_digestPrefix = paramCursor.getString(i);
      } else if (jQs == k) {
        this.field_editingMsg = paramCursor.getString(i);
      } else if (rowid_HASHCODE == k) {
        this.systemRowid = paramCursor.getLong(i);
      }
    }
  }
  
  public ContentValues convertTo()
  {
    ContentValues localContentValues = new ContentValues();
    if (this.field_sessionId == null) {
      this.field_sessionId = "";
    }
    if (this.kjk) {
      localContentValues.put("sessionId", this.field_sessionId);
    }
    if (this.field_talker == null) {
      this.field_talker = "";
    }
    if (this.jTP) {
      localContentValues.put("talker", this.field_talker);
    }
    if (this.field_selfUserName == null) {
      this.field_selfUserName = "";
    }
    if (this.kyi) {
      localContentValues.put("selfUserName", this.field_selfUserName);
    }
    if (this.jPW) {
      localContentValues.put("unReadCount", Integer.valueOf(this.field_unReadCount));
    }
    if (this.__hadSetupdateTime) {
      localContentValues.put("updateTime", Long.valueOf(this.field_updateTime));
    }
    if (this.field_digest == null) {
      this.field_digest = "";
    }
    if (this.jQa) {
      localContentValues.put("digest", this.field_digest);
    }
    if (this.jPY) {
      localContentValues.put("lastMsgID", Long.valueOf(this.field_lastMsgID));
    }
    if (this.kyj) {
      localContentValues.put("digestFlag", Long.valueOf(this.field_digestFlag));
    }
    if (this.field_digestPrefix == null) {
      this.field_digestPrefix = "";
    }
    if (this.kyk) {
      localContentValues.put("digestPrefix", this.field_digestPrefix);
    }
    if (this.field_editingMsg == null) {
      this.field_editingMsg = "";
    }
    if (this.jQd) {
      localContentValues.put("editingMsg", this.field_editingMsg);
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
  
  public StorageObserverOwner<? extends do> getObserverOwner()
  {
    return observerOwner;
  }
  
  public Object getPrimaryKeyValue()
  {
    return this.field_sessionId;
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
 * Qualified Name:     com.tencent.mm.autogen.b.do
 * JD-Core Version:    0.7.0.1
 */