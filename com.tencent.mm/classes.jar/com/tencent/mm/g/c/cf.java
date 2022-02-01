package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.storage.IAutoDBItem;
import com.tencent.mm.sdk.storage.IAutoDBItem.MAutoDBInfo;
import java.lang.reflect.Field;
import java.util.Map;

public abstract class cf
  extends IAutoDBItem
{
  public static final String[] INDEX_CREATE = { "CREATE INDEX IF NOT EXISTS FinderConversation_sessionId_index ON FinderConversation(sessionId)", "CREATE INDEX IF NOT EXISTS FinderConversation_talker_index ON FinderConversation(talker)", "CREATE INDEX IF NOT EXISTS FinderConversation_username_status ON FinderConversation(status)", "CREATE INDEX IF NOT EXISTS FinderConversation_updateTime_index ON FinderConversation(updateTime)", "CREATE INDEX IF NOT EXISTS FinderConversation_type_index ON FinderConversation(type)", "CREATE INDEX IF NOT EXISTS FinderConversation_scene_index ON FinderConversation(scene)", "CREATE INDEX IF NOT EXISTS FinderConversation_readStatus_index ON FinderConversation(readStatus)" };
  private static final int content_HASHCODE;
  private static final int fAZ = "sessionId".hashCode();
  private static final int fDV;
  private static final int fDW;
  private static final int fDX;
  private static final int fDY = "readStatus".hashCode();
  private static final int fjQ;
  private static final int fjl;
  private static final int fnV;
  private static final int fnX;
  private static final int fnZ;
  private static final int foa;
  private static final int foc;
  private static final int foe;
  private static final int fqw = "talker".hashCode();
  private static final int rowid_HASHCODE = "rowid".hashCode();
  private static final int type_HASHCODE;
  private static final int updateTime_HASHCODE;
  private boolean __hadSetcontent = true;
  private boolean __hadSettype = true;
  private boolean __hadSetupdateTime = true;
  private boolean fAL = true;
  private boolean fDR = true;
  private boolean fDS = true;
  private boolean fDT = true;
  private boolean fDU = true;
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
  public String field_sessionId;
  public int field_status;
  public String field_talker;
  public int field_type;
  public int field_unReadCount;
  public long field_updateTime;
  private boolean fjO = true;
  private boolean fji = true;
  private boolean fnG = true;
  private boolean fnI = true;
  private boolean fnK = true;
  private boolean fnL = true;
  private boolean fnN = true;
  private boolean fnP = true;
  private boolean fqi = true;
  
  static
  {
    fnV = "unReadCount".hashCode();
    fjl = "status".hashCode();
    updateTime_HASHCODE = "updateTime".hashCode();
    fnZ = "digest".hashCode();
    foa = "digestUser".hashCode();
    fDV = "digestType".hashCode();
    fnX = "lastMsgID".hashCode();
    content_HASHCODE = "content".hashCode();
    foe = "isSend".hashCode();
    fDW = "placedFlag".hashCode();
    foc = "editingMsg".hashCode();
    type_HASHCODE = "type".hashCode();
    fDX = "actionPermission".hashCode();
    fjQ = "scene".hashCode();
  }
  
  public static IAutoDBItem.MAutoDBInfo ajs()
  {
    IAutoDBItem.MAutoDBInfo localMAutoDBInfo = new IAutoDBItem.MAutoDBInfo();
    localMAutoDBInfo.fields = new Field[17];
    localMAutoDBInfo.columns = new String[18];
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
    localMAutoDBInfo.columns[17] = "rowid";
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
      if (fAZ != k) {
        break label65;
      }
      this.field_sessionId = paramCursor.getString(i);
      this.fAL = true;
    }
    for (;;)
    {
      i += 1;
      break label20;
      break;
      label65:
      if (fqw == k) {
        this.field_talker = paramCursor.getString(i);
      } else if (fnV == k) {
        this.field_unReadCount = paramCursor.getInt(i);
      } else if (fjl == k) {
        this.field_status = paramCursor.getInt(i);
      } else if (updateTime_HASHCODE == k) {
        this.field_updateTime = paramCursor.getLong(i);
      } else if (fnZ == k) {
        this.field_digest = paramCursor.getString(i);
      } else if (foa == k) {
        this.field_digestUser = paramCursor.getString(i);
      } else if (fDV == k) {
        this.field_digestType = paramCursor.getString(i);
      } else if (fnX == k) {
        this.field_lastMsgID = paramCursor.getLong(i);
      } else if (content_HASHCODE == k) {
        this.field_content = paramCursor.getString(i);
      } else if (foe == k) {
        this.field_isSend = paramCursor.getInt(i);
      } else if (fDW == k) {
        this.field_placedFlag = paramCursor.getLong(i);
      } else if (foc == k) {
        this.field_editingMsg = paramCursor.getString(i);
      } else if (type_HASHCODE == k) {
        this.field_type = paramCursor.getInt(i);
      } else if (fDX == k) {
        this.field_actionPermission = paramCursor.getInt(i);
      } else if (fjQ == k) {
        this.field_scene = paramCursor.getInt(i);
      } else if (fDY == k) {
        this.field_readStatus = paramCursor.getInt(i);
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
    if (this.fAL) {
      localContentValues.put("sessionId", this.field_sessionId);
    }
    if (this.field_talker == null) {
      this.field_talker = "";
    }
    if (this.fqi) {
      localContentValues.put("talker", this.field_talker);
    }
    if (this.fnG) {
      localContentValues.put("unReadCount", Integer.valueOf(this.field_unReadCount));
    }
    if (this.fji) {
      localContentValues.put("status", Integer.valueOf(this.field_status));
    }
    if (this.__hadSetupdateTime) {
      localContentValues.put("updateTime", Long.valueOf(this.field_updateTime));
    }
    if (this.field_digest == null) {
      this.field_digest = "";
    }
    if (this.fnK) {
      localContentValues.put("digest", this.field_digest);
    }
    if (this.field_digestUser == null) {
      this.field_digestUser = "";
    }
    if (this.fnL) {
      localContentValues.put("digestUser", this.field_digestUser);
    }
    if (this.field_digestType == null) {
      this.field_digestType = "";
    }
    if (this.fDR) {
      localContentValues.put("digestType", this.field_digestType);
    }
    if (this.fnI) {
      localContentValues.put("lastMsgID", Long.valueOf(this.field_lastMsgID));
    }
    if (this.__hadSetcontent) {
      localContentValues.put("content", this.field_content);
    }
    if (this.fnP) {
      localContentValues.put("isSend", Integer.valueOf(this.field_isSend));
    }
    if (this.fDS) {
      localContentValues.put("placedFlag", Long.valueOf(this.field_placedFlag));
    }
    if (this.fnN) {
      localContentValues.put("editingMsg", this.field_editingMsg);
    }
    if (this.__hadSettype) {
      localContentValues.put("type", Integer.valueOf(this.field_type));
    }
    if (this.fDT) {
      localContentValues.put("actionPermission", Integer.valueOf(this.field_actionPermission));
    }
    if (this.fjO) {
      localContentValues.put("scene", Integer.valueOf(this.field_scene));
    }
    if (this.fDU) {
      localContentValues.put("readStatus", Integer.valueOf(this.field_readStatus));
    }
    if (this.systemRowid > 0L) {
      localContentValues.put("rowid", Long.valueOf(this.systemRowid));
    }
    return localContentValues;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.g.c.cf
 * JD-Core Version:    0.7.0.1
 */