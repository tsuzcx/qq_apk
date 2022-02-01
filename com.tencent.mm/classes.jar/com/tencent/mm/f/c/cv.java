package com.tencent.mm.f.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.storage.IAutoDBItem;
import com.tencent.mm.sdk.storage.IAutoDBItem.MAutoDBInfo;
import com.tencent.mm.sdk.storage.sql.Column;
import com.tencent.mm.sdk.storage.sql.SingleTable;
import java.lang.reflect.Field;
import java.util.Map;

public abstract class cv
  extends IAutoDBItem
{
  public static final Column C_ROWID;
  public static final Column C_TYPE;
  public static final Column C_UPDATETIME;
  public static final String[] INDEX_CREATE = { "CREATE INDEX IF NOT EXISTS FinderSessionInfo_sessionId_index ON FinderSessionInfo(sessionId)", "CREATE INDEX IF NOT EXISTS FinderSessionInfo_talker_index ON FinderSessionInfo(talker)", "CREATE INDEX IF NOT EXISTS FinderSessionInfo_selfUsername_index ON FinderSessionInfo(selfUsername)", "CREATE INDEX IF NOT EXISTS FinderSessionInfo_type_index ON FinderSessionInfo(type)", "CREATE INDEX IF NOT EXISTS FinderSessionInfo_senderUserName_index ON FinderSessionInfo(senderUserName)" };
  public static final SingleTable TABLE = new SingleTable("FinderSessionInfo");
  public static final Column hLS;
  private static final int hMu;
  private static final int hRJ;
  private static final int hRL = "senderUserName".hashCode();
  private static final int hRM = "senderRoleType".hashCode();
  public static final Column hRv;
  public static final Column hRx;
  public static final Column hRy;
  private static final int hVB;
  private static final int hVC;
  private static final int hVD;
  public static final Column hVv;
  public static final Column hVw;
  public static final Column hVx;
  public static final Column hwI;
  private static final int hxk;
  private static final int rowid_HASHCODE = "rowid".hashCode();
  private static final int type_HASHCODE;
  private static final int updateTime_HASHCODE;
  private boolean __hadSettype = true;
  private boolean __hadSetupdateTime = true;
  public int field_actionPermission;
  public int field_disableSendMsg;
  public int field_rejectMsg;
  public String field_selfUsername;
  public int field_senderRoleType;
  public String field_senderUserName;
  public String field_sessionId;
  public String field_talker;
  public int field_type;
  public long field_updateTime;
  private boolean hMg = true;
  private boolean hRC = true;
  private boolean hRE = true;
  private boolean hRF = true;
  private boolean hVA = true;
  private boolean hVy = true;
  private boolean hVz = true;
  private boolean hwW = true;
  
  static
  {
    C_ROWID = new Column("rowid", "long", "FinderSessionInfo", "");
    hLS = new Column("sessionid", "string", "FinderSessionInfo", "");
    hwI = new Column("talker", "string", "FinderSessionInfo", "");
    C_UPDATETIME = new Column("updatetime", "long", "FinderSessionInfo", "");
    hVv = new Column("selfusername", "string", "FinderSessionInfo", "");
    C_TYPE = new Column("type", "int", "FinderSessionInfo", "");
    hRv = new Column("actionpermission", "int", "FinderSessionInfo", "");
    hVw = new Column("rejectmsg", "int", "FinderSessionInfo", "");
    hVx = new Column("disablesendmsg", "int", "FinderSessionInfo", "");
    hRx = new Column("senderusername", "string", "FinderSessionInfo", "");
    hRy = new Column("senderroletype", "int", "FinderSessionInfo", "");
    hMu = "sessionId".hashCode();
    hxk = "talker".hashCode();
    updateTime_HASHCODE = "updateTime".hashCode();
    hVB = "selfUsername".hashCode();
    type_HASHCODE = "type".hashCode();
    hRJ = "actionPermission".hashCode();
    hVC = "rejectMsg".hashCode();
    hVD = "disableSendMsg".hashCode();
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
    localMAutoDBInfo.columns[2] = "updateTime";
    localMAutoDBInfo.colsMap.put("updateTime", "LONG default '0' ");
    localStringBuilder.append(" updateTime LONG default '0' ");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[3] = "selfUsername";
    localMAutoDBInfo.colsMap.put("selfUsername", "TEXT default '' ");
    localStringBuilder.append(" selfUsername TEXT default '' ");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[4] = "type";
    localMAutoDBInfo.colsMap.put("type", "INTEGER");
    localStringBuilder.append(" type INTEGER");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[5] = "actionPermission";
    localMAutoDBInfo.colsMap.put("actionPermission", "INTEGER");
    localStringBuilder.append(" actionPermission INTEGER");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[6] = "rejectMsg";
    localMAutoDBInfo.colsMap.put("rejectMsg", "INTEGER");
    localStringBuilder.append(" rejectMsg INTEGER");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[7] = "disableSendMsg";
    localMAutoDBInfo.colsMap.put("disableSendMsg", "INTEGER");
    localStringBuilder.append(" disableSendMsg INTEGER");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[8] = "senderUserName";
    localMAutoDBInfo.colsMap.put("senderUserName", "TEXT default '' ");
    localStringBuilder.append(" senderUserName TEXT default '' ");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[9] = "senderRoleType";
    localMAutoDBInfo.colsMap.put("senderRoleType", "INTEGER default '0' ");
    localStringBuilder.append(" senderRoleType INTEGER default '0' ");
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
      } else if (updateTime_HASHCODE == k) {
        this.field_updateTime = paramCursor.getLong(i);
      } else if (hVB == k) {
        this.field_selfUsername = paramCursor.getString(i);
      } else if (type_HASHCODE == k) {
        this.field_type = paramCursor.getInt(i);
      } else if (hRJ == k) {
        this.field_actionPermission = paramCursor.getInt(i);
      } else if (hVC == k) {
        this.field_rejectMsg = paramCursor.getInt(i);
      } else if (hVD == k) {
        this.field_disableSendMsg = paramCursor.getInt(i);
      } else if (hRL == k) {
        this.field_senderUserName = paramCursor.getString(i);
      } else if (hRM == k) {
        this.field_senderRoleType = paramCursor.getInt(i);
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
    if (this.__hadSetupdateTime) {
      localContentValues.put("updateTime", Long.valueOf(this.field_updateTime));
    }
    if (this.field_selfUsername == null) {
      this.field_selfUsername = "";
    }
    if (this.hVy) {
      localContentValues.put("selfUsername", this.field_selfUsername);
    }
    if (this.__hadSettype) {
      localContentValues.put("type", Integer.valueOf(this.field_type));
    }
    if (this.hRC) {
      localContentValues.put("actionPermission", Integer.valueOf(this.field_actionPermission));
    }
    if (this.hVz) {
      localContentValues.put("rejectMsg", Integer.valueOf(this.field_rejectMsg));
    }
    if (this.hVA) {
      localContentValues.put("disableSendMsg", Integer.valueOf(this.field_disableSendMsg));
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
    return "FinderSessionInfo";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.f.c.cv
 * JD-Core Version:    0.7.0.1
 */