package com.tencent.mm.f.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.storage.IAutoDBItem;
import com.tencent.mm.sdk.storage.IAutoDBItem.MAutoDBInfo;
import com.tencent.mm.sdk.storage.sql.Column;
import com.tencent.mm.sdk.storage.sql.SingleTable;
import java.lang.reflect.Field;
import java.util.Map;

public abstract class de
  extends IAutoDBItem
{
  public static final Column C_ROWID;
  public static final Column C_UPDATETIME;
  public static final String[] INDEX_CREATE = { "CREATE INDEX IF NOT EXISTS GameLifeConversation_sessionId_index ON GameLifeConversation(sessionId)", "CREATE INDEX IF NOT EXISTS GameLifeConversation_talker_index ON GameLifeConversation(talker)", "CREATE INDEX IF NOT EXISTS GameLifeConversation_selfUserName_index ON GameLifeConversation(selfUserName)", "CREATE INDEX IF NOT EXISTS GameLifeConversation_updateTime_index ON GameLifeConversation(updateTime)" };
  public static final SingleTable TABLE = new SingleTable("GameLifeConversation");
  public static final Column hLS;
  private static final int hMu;
  public static final Column hVv;
  public static final Column hYV;
  public static final Column hYW;
  private static final int hZa;
  private static final int hZb = "digestFlag".hashCode();
  private static final int hZc = "digestPrefix".hashCode();
  public static final Column hsU;
  public static final Column hsW;
  public static final Column hsY;
  private static final int htA;
  private static final int htC;
  private static final int htF = "editingMsg".hashCode();
  public static final Column htb;
  private static final int hty;
  public static final Column hwI;
  private static final int hxk;
  private static final int rowid_HASHCODE = "rowid".hashCode();
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
  private boolean hMg = true;
  private boolean hYX = true;
  private boolean hYY = true;
  private boolean hYZ = true;
  private boolean htj = true;
  private boolean htl = true;
  private boolean htn = true;
  private boolean htq = true;
  private boolean hwW = true;
  
  static
  {
    C_ROWID = new Column("rowid", "long", "GameLifeConversation", "");
    hLS = new Column("sessionid", "string", "GameLifeConversation", "");
    hwI = new Column("talker", "string", "GameLifeConversation", "");
    hVv = new Column("selfusername", "string", "GameLifeConversation", "");
    hsU = new Column("unreadcount", "int", "GameLifeConversation", "");
    C_UPDATETIME = new Column("updatetime", "long", "GameLifeConversation", "");
    hsY = new Column("digest", "string", "GameLifeConversation", "");
    hsW = new Column("lastmsgid", "long", "GameLifeConversation", "");
    hYV = new Column("digestflag", "long", "GameLifeConversation", "");
    hYW = new Column("digestprefix", "string", "GameLifeConversation", "");
    htb = new Column("editingmsg", "string", "GameLifeConversation", "");
    hMu = "sessionId".hashCode();
    hxk = "talker".hashCode();
    hZa = "selfUserName".hashCode();
    hty = "unReadCount".hashCode();
    updateTime_HASHCODE = "updateTime".hashCode();
    htC = "digest".hashCode();
    htA = "lastMsgID".hashCode();
  }
  
  public static IAutoDBItem.MAutoDBInfo aoY()
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
    return localMAutoDBInfo;
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
      if (hMu != k) {
        break label65;
      }
      this.field_sessionId = paramCursor.getString(i);
      this.hMg = true;
    }
    for (;;)
    {
      i += 1;
      break label20;
      break;
      label65:
      if (hxk == k) {
        this.field_talker = paramCursor.getString(i);
      } else if (hZa == k) {
        this.field_selfUserName = paramCursor.getString(i);
      } else if (hty == k) {
        this.field_unReadCount = paramCursor.getInt(i);
      } else if (updateTime_HASHCODE == k) {
        this.field_updateTime = paramCursor.getLong(i);
      } else if (htC == k) {
        this.field_digest = paramCursor.getString(i);
      } else if (htA == k) {
        this.field_lastMsgID = paramCursor.getLong(i);
      } else if (hZb == k) {
        this.field_digestFlag = paramCursor.getLong(i);
      } else if (hZc == k) {
        this.field_digestPrefix = paramCursor.getString(i);
      } else if (htF == k) {
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
    if (this.hMg) {
      localContentValues.put("sessionId", this.field_sessionId);
    }
    if (this.field_talker == null) {
      this.field_talker = "";
    }
    if (this.hwW) {
      localContentValues.put("talker", this.field_talker);
    }
    if (this.field_selfUserName == null) {
      this.field_selfUserName = "";
    }
    if (this.hYX) {
      localContentValues.put("selfUserName", this.field_selfUserName);
    }
    if (this.htj) {
      localContentValues.put("unReadCount", Integer.valueOf(this.field_unReadCount));
    }
    if (this.__hadSetupdateTime) {
      localContentValues.put("updateTime", Long.valueOf(this.field_updateTime));
    }
    if (this.field_digest == null) {
      this.field_digest = "";
    }
    if (this.htn) {
      localContentValues.put("digest", this.field_digest);
    }
    if (this.htl) {
      localContentValues.put("lastMsgID", Long.valueOf(this.field_lastMsgID));
    }
    if (this.hYY) {
      localContentValues.put("digestFlag", Long.valueOf(this.field_digestFlag));
    }
    if (this.field_digestPrefix == null) {
      this.field_digestPrefix = "";
    }
    if (this.hYZ) {
      localContentValues.put("digestPrefix", this.field_digestPrefix);
    }
    if (this.field_editingMsg == null) {
      this.field_editingMsg = "";
    }
    if (this.htq) {
      localContentValues.put("editingMsg", this.field_editingMsg);
    }
    if (this.systemRowid > 0L) {
      localContentValues.put("rowid", Long.valueOf(this.systemRowid));
    }
    return localContentValues;
  }
  
  public String[] getIndexCreateSQL()
  {
    return INDEX_CREATE;
  }
  
  public String getTableName()
  {
    return "GameLifeConversation";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.f.c.de
 * JD-Core Version:    0.7.0.1
 */