package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.storage.IAutoDBItem;
import com.tencent.mm.sdk.storage.IAutoDBItem.MAutoDBInfo;
import java.lang.reflect.Field;
import java.util.Map;

public abstract class da
  extends IAutoDBItem
{
  public static final String[] INDEX_CREATE = { "CREATE INDEX IF NOT EXISTS GameLifeConversation_sessionId_index ON GameLifeConversation(sessionId)", "CREATE INDEX IF NOT EXISTS GameLifeConversation_talker_index ON GameLifeConversation(talker)", "CREATE INDEX IF NOT EXISTS GameLifeConversation_selfUserName_index ON GameLifeConversation(selfUserName)", "CREATE INDEX IF NOT EXISTS GameLifeConversation_updateTime_index ON GameLifeConversation(updateTime)" };
  private static final int fAZ = "sessionId".hashCode();
  private static final int fIK;
  private static final int fIL = "digestFlag".hashCode();
  private static final int fIM = "digestPrefix".hashCode();
  private static final int fnV;
  private static final int fnX;
  private static final int fnZ;
  private static final int foc = "editingMsg".hashCode();
  private static final int fqw = "talker".hashCode();
  private static final int rowid_HASHCODE = "rowid".hashCode();
  private static final int updateTime_HASHCODE;
  private boolean __hadSetupdateTime = true;
  private boolean fAL = true;
  private boolean fIH = true;
  private boolean fII = true;
  private boolean fIJ = true;
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
  private boolean fnG = true;
  private boolean fnI = true;
  private boolean fnK = true;
  private boolean fnN = true;
  private boolean fqi = true;
  
  static
  {
    fIK = "selfUserName".hashCode();
    fnV = "unReadCount".hashCode();
    updateTime_HASHCODE = "updateTime".hashCode();
    fnZ = "digest".hashCode();
    fnX = "lastMsgID".hashCode();
  }
  
  public static IAutoDBItem.MAutoDBInfo ajs()
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
      } else if (fIK == k) {
        this.field_selfUserName = paramCursor.getString(i);
      } else if (fnV == k) {
        this.field_unReadCount = paramCursor.getInt(i);
      } else if (updateTime_HASHCODE == k) {
        this.field_updateTime = paramCursor.getLong(i);
      } else if (fnZ == k) {
        this.field_digest = paramCursor.getString(i);
      } else if (fnX == k) {
        this.field_lastMsgID = paramCursor.getLong(i);
      } else if (fIL == k) {
        this.field_digestFlag = paramCursor.getLong(i);
      } else if (fIM == k) {
        this.field_digestPrefix = paramCursor.getString(i);
      } else if (foc == k) {
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
    if (this.fAL) {
      localContentValues.put("sessionId", this.field_sessionId);
    }
    if (this.field_talker == null) {
      this.field_talker = "";
    }
    if (this.fqi) {
      localContentValues.put("talker", this.field_talker);
    }
    if (this.field_selfUserName == null) {
      this.field_selfUserName = "";
    }
    if (this.fIH) {
      localContentValues.put("selfUserName", this.field_selfUserName);
    }
    if (this.fnG) {
      localContentValues.put("unReadCount", Integer.valueOf(this.field_unReadCount));
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
    if (this.fnI) {
      localContentValues.put("lastMsgID", Long.valueOf(this.field_lastMsgID));
    }
    if (this.fII) {
      localContentValues.put("digestFlag", Long.valueOf(this.field_digestFlag));
    }
    if (this.field_digestPrefix == null) {
      this.field_digestPrefix = "";
    }
    if (this.fIJ) {
      localContentValues.put("digestPrefix", this.field_digestPrefix);
    }
    if (this.field_editingMsg == null) {
      this.field_editingMsg = "";
    }
    if (this.fnN) {
      localContentValues.put("editingMsg", this.field_editingMsg);
    }
    if (this.systemRowid > 0L) {
      localContentValues.put("rowid", Long.valueOf(this.systemRowid));
    }
    return localContentValues;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.g.c.da
 * JD-Core Version:    0.7.0.1
 */