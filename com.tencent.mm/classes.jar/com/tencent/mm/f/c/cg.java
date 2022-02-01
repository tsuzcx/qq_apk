package com.tencent.mm.f.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.storage.IAutoDBItem;
import com.tencent.mm.sdk.storage.IAutoDBItem.MAutoDBInfo;
import com.tencent.mm.sdk.storage.sql.Column;
import com.tencent.mm.sdk.storage.sql.SingleTable;
import java.lang.reflect.Field;
import java.util.Map;

public abstract class cg
  extends IAutoDBItem
{
  public static final Column C_CONTENT;
  public static final Column C_ROWID;
  public static final Column C_TYPE;
  public static final Column C_UPDATETIME;
  public static final String[] INDEX_CREATE = { "CREATE INDEX IF NOT EXISTS FinderConversation_sessionId_index ON FinderConversation(sessionId)", "CREATE INDEX IF NOT EXISTS FinderConversation_talker_index ON FinderConversation(talker)", "CREATE INDEX IF NOT EXISTS FinderConversation_username_status ON FinderConversation(status)", "CREATE INDEX IF NOT EXISTS FinderConversation_updateTime_index ON FinderConversation(updateTime)", "CREATE INDEX IF NOT EXISTS FinderConversation_type_index ON FinderConversation(type)", "CREATE INDEX IF NOT EXISTS FinderConversation_scene_index ON FinderConversation(scene)", "CREATE INDEX IF NOT EXISTS FinderConversation_readStatus_index ON FinderConversation(readStatus)", "CREATE INDEX IF NOT EXISTS FinderConversation_senderUserName_index ON FinderConversation(senderUserName)", "CREATE INDEX IF NOT EXISTS FinderConversation_senderUserNameVersion_index ON FinderConversation(senderUserNameVersion)" };
  public static final SingleTable TABLE = new SingleTable("FinderConversation");
  private static final int content_HASHCODE;
  public static final Column hLS;
  private static final int hMu;
  private static final int hRH;
  private static final int hRI;
  private static final int hRJ;
  private static final int hRK = "readStatus".hashCode();
  private static final int hRL = "senderUserName".hashCode();
  private static final int hRM = "senderRoleType".hashCode();
  private static final int hRN = "senderUserNameVersion".hashCode();
  public static final Column hRt;
  public static final Column hRu;
  public static final Column hRv;
  public static final Column hRw;
  public static final Column hRx;
  public static final Column hRy;
  public static final Column hRz;
  private static final int hmC;
  public static final Column hmw;
  public static final Column hnt;
  private static final int hnx;
  public static final Column hsU;
  public static final Column hsW;
  public static final Column hsY;
  public static final Column hsZ;
  private static final int htA;
  private static final int htC;
  private static final int htD;
  private static final int htF;
  private static final int htH;
  public static final Column htb;
  public static final Column htd;
  private static final int hty;
  public static final Column hwI;
  private static final int hxk;
  private static final int rowid_HASHCODE = "rowid".hashCode();
  private static final int type_HASHCODE;
  private static final int updateTime_HASHCODE;
  private boolean __hadSetcontent = true;
  private boolean __hadSettype = true;
  private boolean __hadSetupdateTime = true;
  public int field_actionPermission;
  public String field_content;
  public String field_digest;
  public String field_digestType;
  public String field_digestUser;
  public String field_editingMsg;
  public int field_isSend;
  public long field_lastMsgID;
  public long field_placedFlag;
  public int field_readStatus;
  public int field_scene;
  public int field_senderRoleType;
  public String field_senderUserName;
  public int field_senderUserNameVersion;
  public String field_sessionId;
  public int field_status;
  public String field_talker;
  public int field_type;
  public int field_unReadCount;
  public long field_updateTime;
  private boolean hMg = true;
  private boolean hRA = true;
  private boolean hRB = true;
  private boolean hRC = true;
  private boolean hRD = true;
  private boolean hRE = true;
  private boolean hRF = true;
  private boolean hRG = true;
  private boolean hmz = true;
  private boolean hnv = true;
  private boolean htj = true;
  private boolean htl = true;
  private boolean htn = true;
  private boolean hto = true;
  private boolean htq = true;
  private boolean hts = true;
  private boolean hwW = true;
  
  static
  {
    C_ROWID = new Column("rowid", "long", "FinderConversation", "");
    hLS = new Column("sessionid", "string", "FinderConversation", "");
    hwI = new Column("talker", "string", "FinderConversation", "");
    hsU = new Column("unreadcount", "int", "FinderConversation", "");
    hmw = new Column("status", "int", "FinderConversation", "");
    C_UPDATETIME = new Column("updatetime", "long", "FinderConversation", "");
    hsY = new Column("digest", "string", "FinderConversation", "");
    hsZ = new Column("digestuser", "string", "FinderConversation", "");
    hRt = new Column("digesttype", "string", "FinderConversation", "");
    hsW = new Column("lastmsgid", "long", "FinderConversation", "");
    C_CONTENT = new Column("content", "string", "FinderConversation", "");
    htd = new Column("issend", "int", "FinderConversation", "");
    hRu = new Column("placedflag", "long", "FinderConversation", "");
    htb = new Column("editingmsg", "string", "FinderConversation", "");
    C_TYPE = new Column("type", "int", "FinderConversation", "");
    hRv = new Column("actionpermission", "int", "FinderConversation", "");
    hnt = new Column("scene", "int", "FinderConversation", "");
    hRw = new Column("readstatus", "int", "FinderConversation", "");
    hRx = new Column("senderusername", "string", "FinderConversation", "");
    hRy = new Column("senderroletype", "int", "FinderConversation", "");
    hRz = new Column("senderusernameversion", "int", "FinderConversation", "");
    hMu = "sessionId".hashCode();
    hxk = "talker".hashCode();
    hty = "unReadCount".hashCode();
    hmC = "status".hashCode();
    updateTime_HASHCODE = "updateTime".hashCode();
    htC = "digest".hashCode();
    htD = "digestUser".hashCode();
    hRH = "digestType".hashCode();
    htA = "lastMsgID".hashCode();
    content_HASHCODE = "content".hashCode();
    htH = "isSend".hashCode();
    hRI = "placedFlag".hashCode();
    htF = "editingMsg".hashCode();
    type_HASHCODE = "type".hashCode();
    hRJ = "actionPermission".hashCode();
    hnx = "scene".hashCode();
  }
  
  public static IAutoDBItem.MAutoDBInfo aoY()
  {
    IAutoDBItem.MAutoDBInfo localMAutoDBInfo = new IAutoDBItem.MAutoDBInfo();
    localMAutoDBInfo.fields = new Field[20];
    localMAutoDBInfo.columns = new String[21];
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
    localMAutoDBInfo.columns[2] = "unReadCount";
    localMAutoDBInfo.colsMap.put("unReadCount", "INTEGER default '0' ");
    localStringBuilder.append(" unReadCount INTEGER default '0' ");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[3] = "status";
    localMAutoDBInfo.colsMap.put("status", "INTEGER default '0' ");
    localStringBuilder.append(" status INTEGER default '0' ");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[4] = "updateTime";
    localMAutoDBInfo.colsMap.put("updateTime", "LONG default '0' ");
    localStringBuilder.append(" updateTime LONG default '0' ");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[5] = "digest";
    localMAutoDBInfo.colsMap.put("digest", "TEXT default '' ");
    localStringBuilder.append(" digest TEXT default '' ");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[6] = "digestUser";
    localMAutoDBInfo.colsMap.put("digestUser", "TEXT default '' ");
    localStringBuilder.append(" digestUser TEXT default '' ");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[7] = "digestType";
    localMAutoDBInfo.colsMap.put("digestType", "TEXT default '' ");
    localStringBuilder.append(" digestType TEXT default '' ");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[8] = "lastMsgID";
    localMAutoDBInfo.colsMap.put("lastMsgID", "LONG");
    localStringBuilder.append(" lastMsgID LONG");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[9] = "content";
    localMAutoDBInfo.colsMap.put("content", "TEXT");
    localStringBuilder.append(" content TEXT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[10] = "isSend";
    localMAutoDBInfo.colsMap.put("isSend", "INTEGER");
    localStringBuilder.append(" isSend INTEGER");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[11] = "placedFlag";
    localMAutoDBInfo.colsMap.put("placedFlag", "LONG default '0' ");
    localStringBuilder.append(" placedFlag LONG default '0' ");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[12] = "editingMsg";
    localMAutoDBInfo.colsMap.put("editingMsg", "TEXT");
    localStringBuilder.append(" editingMsg TEXT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[13] = "type";
    localMAutoDBInfo.colsMap.put("type", "INTEGER");
    localStringBuilder.append(" type INTEGER");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[14] = "actionPermission";
    localMAutoDBInfo.colsMap.put("actionPermission", "INTEGER");
    localStringBuilder.append(" actionPermission INTEGER");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[15] = "scene";
    localMAutoDBInfo.colsMap.put("scene", "INTEGER");
    localStringBuilder.append(" scene INTEGER");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[16] = "readStatus";
    localMAutoDBInfo.colsMap.put("readStatus", "INTEGER");
    localStringBuilder.append(" readStatus INTEGER");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[17] = "senderUserName";
    localMAutoDBInfo.colsMap.put("senderUserName", "TEXT default '' ");
    localStringBuilder.append(" senderUserName TEXT default '' ");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[18] = "senderRoleType";
    localMAutoDBInfo.colsMap.put("senderRoleType", "INTEGER default '0' ");
    localStringBuilder.append(" senderRoleType INTEGER default '0' ");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[19] = "senderUserNameVersion";
    localMAutoDBInfo.colsMap.put("senderUserNameVersion", "INTEGER default '0' ");
    localStringBuilder.append(" senderUserNameVersion INTEGER default '0' ");
    localMAutoDBInfo.columns[20] = "rowid";
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
      } else if (hty == k) {
        this.field_unReadCount = paramCursor.getInt(i);
      } else if (hmC == k) {
        this.field_status = paramCursor.getInt(i);
      } else if (updateTime_HASHCODE == k) {
        this.field_updateTime = paramCursor.getLong(i);
      } else if (htC == k) {
        this.field_digest = paramCursor.getString(i);
      } else if (htD == k) {
        this.field_digestUser = paramCursor.getString(i);
      } else if (hRH == k) {
        this.field_digestType = paramCursor.getString(i);
      } else if (htA == k) {
        this.field_lastMsgID = paramCursor.getLong(i);
      } else if (content_HASHCODE == k) {
        this.field_content = paramCursor.getString(i);
      } else if (htH == k) {
        this.field_isSend = paramCursor.getInt(i);
      } else if (hRI == k) {
        this.field_placedFlag = paramCursor.getLong(i);
      } else if (htF == k) {
        this.field_editingMsg = paramCursor.getString(i);
      } else if (type_HASHCODE == k) {
        this.field_type = paramCursor.getInt(i);
      } else if (hRJ == k) {
        this.field_actionPermission = paramCursor.getInt(i);
      } else if (hnx == k) {
        this.field_scene = paramCursor.getInt(i);
      } else if (hRK == k) {
        this.field_readStatus = paramCursor.getInt(i);
      } else if (hRL == k) {
        this.field_senderUserName = paramCursor.getString(i);
      } else if (hRM == k) {
        this.field_senderRoleType = paramCursor.getInt(i);
      } else if (hRN == k) {
        this.field_senderUserNameVersion = paramCursor.getInt(i);
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
    if (this.htj) {
      localContentValues.put("unReadCount", Integer.valueOf(this.field_unReadCount));
    }
    if (this.hmz) {
      localContentValues.put("status", Integer.valueOf(this.field_status));
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
    if (this.field_digestUser == null) {
      this.field_digestUser = "";
    }
    if (this.hto) {
      localContentValues.put("digestUser", this.field_digestUser);
    }
    if (this.field_digestType == null) {
      this.field_digestType = "";
    }
    if (this.hRA) {
      localContentValues.put("digestType", this.field_digestType);
    }
    if (this.htl) {
      localContentValues.put("lastMsgID", Long.valueOf(this.field_lastMsgID));
    }
    if (this.__hadSetcontent) {
      localContentValues.put("content", this.field_content);
    }
    if (this.hts) {
      localContentValues.put("isSend", Integer.valueOf(this.field_isSend));
    }
    if (this.hRB) {
      localContentValues.put("placedFlag", Long.valueOf(this.field_placedFlag));
    }
    if (this.htq) {
      localContentValues.put("editingMsg", this.field_editingMsg);
    }
    if (this.__hadSettype) {
      localContentValues.put("type", Integer.valueOf(this.field_type));
    }
    if (this.hRC) {
      localContentValues.put("actionPermission", Integer.valueOf(this.field_actionPermission));
    }
    if (this.hnv) {
      localContentValues.put("scene", Integer.valueOf(this.field_scene));
    }
    if (this.hRD) {
      localContentValues.put("readStatus", Integer.valueOf(this.field_readStatus));
    }
    if (this.field_senderUserName == null) {
      this.field_senderUserName = "";
    }
    if (this.hRE) {
      localContentValues.put("senderUserName", this.field_senderUserName);
    }
    if (this.hRF) {
      localContentValues.put("senderRoleType", Integer.valueOf(this.field_senderRoleType));
    }
    if (this.hRG) {
      localContentValues.put("senderUserNameVersion", Integer.valueOf(this.field_senderUserNameVersion));
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
    return "FinderConversation";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.f.c.cg
 * JD-Core Version:    0.7.0.1
 */