package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.storage.IAutoDBItem;
import com.tencent.mm.sdk.storage.IAutoDBItem.MAutoDBInfo;
import java.lang.reflect.Field;
import java.util.Map;

public abstract class cp
  extends IAutoDBItem
{
  public static final String[] INDEX_CREATE = { "CREATE INDEX IF NOT EXISTS FinderSessionInfo_sessionId_index ON FinderSessionInfo(sessionId)", "CREATE INDEX IF NOT EXISTS FinderSessionInfo_talker_index ON FinderSessionInfo(talker)", "CREATE INDEX IF NOT EXISTS FinderSessionInfo_type_index ON FinderSessionInfo(type)" };
  private static final int fAZ = "sessionId".hashCode();
  private static final int fDX = "actionPermission".hashCode();
  private static final int fGo;
  private static final int fGp = "rejectMsg".hashCode();
  private static final int fGq = "disableSendMsg".hashCode();
  private static final int fqw = "talker".hashCode();
  private static final int rowid_HASHCODE = "rowid".hashCode();
  private static final int type_HASHCODE;
  private static final int updateTime_HASHCODE = "updateTime".hashCode();
  private boolean __hadSettype = true;
  private boolean __hadSetupdateTime = true;
  private boolean fAL = true;
  private boolean fDT = true;
  private boolean fGl = true;
  private boolean fGm = true;
  private boolean fGn = true;
  public int field_actionPermission;
  public int field_disableSendMsg;
  public int field_rejectMsg;
  public String field_selfUsername;
  public String field_sessionId;
  public String field_talker;
  public int field_type;
  public long field_updateTime;
  private boolean fqi = true;
  
  static
  {
    fGo = "selfUsername".hashCode();
    type_HASHCODE = "type".hashCode();
  }
  
  public static IAutoDBItem.MAutoDBInfo ajs()
  {
    IAutoDBItem.MAutoDBInfo localMAutoDBInfo = new IAutoDBItem.MAutoDBInfo();
    localMAutoDBInfo.fields = new Field[8];
    localMAutoDBInfo.columns = new String[9];
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
    localMAutoDBInfo.columns[8] = "rowid";
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
      } else if (updateTime_HASHCODE == k) {
        this.field_updateTime = paramCursor.getLong(i);
      } else if (fGo == k) {
        this.field_selfUsername = paramCursor.getString(i);
      } else if (type_HASHCODE == k) {
        this.field_type = paramCursor.getInt(i);
      } else if (fDX == k) {
        this.field_actionPermission = paramCursor.getInt(i);
      } else if (fGp == k) {
        this.field_rejectMsg = paramCursor.getInt(i);
      } else if (fGq == k) {
        this.field_disableSendMsg = paramCursor.getInt(i);
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
    if (this.__hadSetupdateTime) {
      localContentValues.put("updateTime", Long.valueOf(this.field_updateTime));
    }
    if (this.field_selfUsername == null) {
      this.field_selfUsername = "";
    }
    if (this.fGl) {
      localContentValues.put("selfUsername", this.field_selfUsername);
    }
    if (this.__hadSettype) {
      localContentValues.put("type", Integer.valueOf(this.field_type));
    }
    if (this.fDT) {
      localContentValues.put("actionPermission", Integer.valueOf(this.field_actionPermission));
    }
    if (this.fGm) {
      localContentValues.put("rejectMsg", Integer.valueOf(this.field_rejectMsg));
    }
    if (this.fGn) {
      localContentValues.put("disableSendMsg", Integer.valueOf(this.field_disableSendMsg));
    }
    if (this.systemRowid > 0L) {
      localContentValues.put("rowid", Long.valueOf(this.systemRowid));
    }
    return localContentValues;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.g.c.cp
 * JD-Core Version:    0.7.0.1
 */