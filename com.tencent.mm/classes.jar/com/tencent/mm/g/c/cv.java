package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;
import com.tencent.mm.sdk.e.c.a;
import java.lang.reflect.Field;
import java.util.Map;

public abstract class cv
  extends c
{
  public static final String[] INDEX_CREATE = { "CREATE INDEX IF NOT EXISTS GameLifeConversation_sessionId_index ON GameLifeConversation(sessionId)", "CREATE INDEX IF NOT EXISTS GameLifeConversation_talker_index ON GameLifeConversation(talker)", "CREATE INDEX IF NOT EXISTS GameLifeConversation_selfUserName_index ON GameLifeConversation(selfUserName)", "CREATE INDEX IF NOT EXISTS GameLifeConversation_updateTime_index ON GameLifeConversation(updateTime)" };
  private static final int eFq;
  private static final int eIG;
  private static final int eII = "lastMsgID".hashCode();
  private static final int eIK;
  private static final int eLf;
  private static final int eVL = "sessionId".hashCode();
  private static final int fcB;
  private static final int fcC = "digestFlag".hashCode();
  private static final int rowid_HASHCODE = "rowid".hashCode();
  private boolean eFn = true;
  private boolean eIr = true;
  private boolean eIt = true;
  private boolean eIv = true;
  private boolean eKS = true;
  private boolean eVx = true;
  private boolean fcA = true;
  private boolean fcz = true;
  public String field_digest;
  public long field_digestFlag;
  public long field_lastMsgID;
  public String field_selfUserName;
  public String field_sessionId;
  public String field_talker;
  public int field_unReadCount;
  public long field_updateTime;
  
  static
  {
    eLf = "talker".hashCode();
    fcB = "selfUserName".hashCode();
    eIG = "unReadCount".hashCode();
    eFq = "updateTime".hashCode();
    eIK = "digest".hashCode();
  }
  
  public static c.a Vv()
  {
    c.a locala = new c.a();
    locala.IhA = new Field[8];
    locala.columns = new String[9];
    StringBuilder localStringBuilder = new StringBuilder();
    locala.columns[0] = "sessionId";
    locala.IhC.put("sessionId", "TEXT default ''  PRIMARY KEY ");
    localStringBuilder.append(" sessionId TEXT default ''  PRIMARY KEY ");
    localStringBuilder.append(", ");
    locala.IhB = "sessionId";
    locala.columns[1] = "talker";
    locala.IhC.put("talker", "TEXT default '' ");
    localStringBuilder.append(" talker TEXT default '' ");
    localStringBuilder.append(", ");
    locala.columns[2] = "selfUserName";
    locala.IhC.put("selfUserName", "TEXT default '' ");
    localStringBuilder.append(" selfUserName TEXT default '' ");
    localStringBuilder.append(", ");
    locala.columns[3] = "unReadCount";
    locala.IhC.put("unReadCount", "INTEGER default '0' ");
    localStringBuilder.append(" unReadCount INTEGER default '0' ");
    localStringBuilder.append(", ");
    locala.columns[4] = "updateTime";
    locala.IhC.put("updateTime", "LONG default '0' ");
    localStringBuilder.append(" updateTime LONG default '0' ");
    localStringBuilder.append(", ");
    locala.columns[5] = "digest";
    locala.IhC.put("digest", "TEXT default '' ");
    localStringBuilder.append(" digest TEXT default '' ");
    localStringBuilder.append(", ");
    locala.columns[6] = "lastMsgID";
    locala.IhC.put("lastMsgID", "LONG");
    localStringBuilder.append(" lastMsgID LONG");
    localStringBuilder.append(", ");
    locala.columns[7] = "digestFlag";
    locala.IhC.put("digestFlag", "LONG default '0' ");
    localStringBuilder.append(" digestFlag LONG default '0' ");
    locala.columns[8] = "rowid";
    locala.sql = localStringBuilder.toString();
    return locala;
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
      if (eVL != k) {
        break label65;
      }
      this.field_sessionId = paramCursor.getString(i);
      this.eVx = true;
    }
    for (;;)
    {
      i += 1;
      break label20;
      break;
      label65:
      if (eLf == k) {
        this.field_talker = paramCursor.getString(i);
      } else if (fcB == k) {
        this.field_selfUserName = paramCursor.getString(i);
      } else if (eIG == k) {
        this.field_unReadCount = paramCursor.getInt(i);
      } else if (eFq == k) {
        this.field_updateTime = paramCursor.getLong(i);
      } else if (eIK == k) {
        this.field_digest = paramCursor.getString(i);
      } else if (eII == k) {
        this.field_lastMsgID = paramCursor.getLong(i);
      } else if (fcC == k) {
        this.field_digestFlag = paramCursor.getLong(i);
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
    if (this.eVx) {
      localContentValues.put("sessionId", this.field_sessionId);
    }
    if (this.field_talker == null) {
      this.field_talker = "";
    }
    if (this.eKS) {
      localContentValues.put("talker", this.field_talker);
    }
    if (this.field_selfUserName == null) {
      this.field_selfUserName = "";
    }
    if (this.fcz) {
      localContentValues.put("selfUserName", this.field_selfUserName);
    }
    if (this.eIr) {
      localContentValues.put("unReadCount", Integer.valueOf(this.field_unReadCount));
    }
    if (this.eFn) {
      localContentValues.put("updateTime", Long.valueOf(this.field_updateTime));
    }
    if (this.field_digest == null) {
      this.field_digest = "";
    }
    if (this.eIv) {
      localContentValues.put("digest", this.field_digest);
    }
    if (this.eIt) {
      localContentValues.put("lastMsgID", Long.valueOf(this.field_lastMsgID));
    }
    if (this.fcA) {
      localContentValues.put("digestFlag", Long.valueOf(this.field_digestFlag));
    }
    if (this.systemRowid > 0L) {
      localContentValues.put("rowid", Long.valueOf(this.systemRowid));
    }
    return localContentValues;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.g.c.cv
 * JD-Core Version:    0.7.0.1
 */