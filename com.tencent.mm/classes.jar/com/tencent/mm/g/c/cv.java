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
  private static final int eGZ;
  private static final int eKp;
  private static final int eKr;
  private static final int eKt;
  private static final int eKw = "editingMsg".hashCode();
  private static final int eMP;
  private static final int eXw = "sessionId".hashCode();
  private static final int fer;
  private static final int fes;
  private static final int fet;
  private static final int rowid_HASHCODE = "rowid".hashCode();
  private boolean eGW = true;
  private boolean eKa = true;
  private boolean eKc = true;
  private boolean eKe = true;
  private boolean eKh = true;
  private boolean eMB = true;
  private boolean eXi = true;
  private boolean feo = true;
  private boolean fep = true;
  private boolean feq = true;
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
  
  static
  {
    eMP = "talker".hashCode();
    fer = "selfUserName".hashCode();
    eKp = "unReadCount".hashCode();
    eGZ = "updateTime".hashCode();
    eKt = "digest".hashCode();
    eKr = "lastMsgID".hashCode();
    fes = "digestFlag".hashCode();
    fet = "digestPrefix".hashCode();
  }
  
  public static c.a VD()
  {
    c.a locala = new c.a();
    locala.IBL = new Field[10];
    locala.columns = new String[11];
    StringBuilder localStringBuilder = new StringBuilder();
    locala.columns[0] = "sessionId";
    locala.IBN.put("sessionId", "TEXT default ''  PRIMARY KEY ");
    localStringBuilder.append(" sessionId TEXT default ''  PRIMARY KEY ");
    localStringBuilder.append(", ");
    locala.IBM = "sessionId";
    locala.columns[1] = "talker";
    locala.IBN.put("talker", "TEXT default '' ");
    localStringBuilder.append(" talker TEXT default '' ");
    localStringBuilder.append(", ");
    locala.columns[2] = "selfUserName";
    locala.IBN.put("selfUserName", "TEXT default '' ");
    localStringBuilder.append(" selfUserName TEXT default '' ");
    localStringBuilder.append(", ");
    locala.columns[3] = "unReadCount";
    locala.IBN.put("unReadCount", "INTEGER default '0' ");
    localStringBuilder.append(" unReadCount INTEGER default '0' ");
    localStringBuilder.append(", ");
    locala.columns[4] = "updateTime";
    locala.IBN.put("updateTime", "LONG default '0' ");
    localStringBuilder.append(" updateTime LONG default '0' ");
    localStringBuilder.append(", ");
    locala.columns[5] = "digest";
    locala.IBN.put("digest", "TEXT default '' ");
    localStringBuilder.append(" digest TEXT default '' ");
    localStringBuilder.append(", ");
    locala.columns[6] = "lastMsgID";
    locala.IBN.put("lastMsgID", "LONG");
    localStringBuilder.append(" lastMsgID LONG");
    localStringBuilder.append(", ");
    locala.columns[7] = "digestFlag";
    locala.IBN.put("digestFlag", "LONG default '0' ");
    localStringBuilder.append(" digestFlag LONG default '0' ");
    localStringBuilder.append(", ");
    locala.columns[8] = "digestPrefix";
    locala.IBN.put("digestPrefix", "TEXT default '' ");
    localStringBuilder.append(" digestPrefix TEXT default '' ");
    localStringBuilder.append(", ");
    locala.columns[9] = "editingMsg";
    locala.IBN.put("editingMsg", "TEXT default '' ");
    localStringBuilder.append(" editingMsg TEXT default '' ");
    locala.columns[10] = "rowid";
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
      if (eXw != k) {
        break label65;
      }
      this.field_sessionId = paramCursor.getString(i);
      this.eXi = true;
    }
    for (;;)
    {
      i += 1;
      break label20;
      break;
      label65:
      if (eMP == k) {
        this.field_talker = paramCursor.getString(i);
      } else if (fer == k) {
        this.field_selfUserName = paramCursor.getString(i);
      } else if (eKp == k) {
        this.field_unReadCount = paramCursor.getInt(i);
      } else if (eGZ == k) {
        this.field_updateTime = paramCursor.getLong(i);
      } else if (eKt == k) {
        this.field_digest = paramCursor.getString(i);
      } else if (eKr == k) {
        this.field_lastMsgID = paramCursor.getLong(i);
      } else if (fes == k) {
        this.field_digestFlag = paramCursor.getLong(i);
      } else if (fet == k) {
        this.field_digestPrefix = paramCursor.getString(i);
      } else if (eKw == k) {
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
    if (this.eXi) {
      localContentValues.put("sessionId", this.field_sessionId);
    }
    if (this.field_talker == null) {
      this.field_talker = "";
    }
    if (this.eMB) {
      localContentValues.put("talker", this.field_talker);
    }
    if (this.field_selfUserName == null) {
      this.field_selfUserName = "";
    }
    if (this.feo) {
      localContentValues.put("selfUserName", this.field_selfUserName);
    }
    if (this.eKa) {
      localContentValues.put("unReadCount", Integer.valueOf(this.field_unReadCount));
    }
    if (this.eGW) {
      localContentValues.put("updateTime", Long.valueOf(this.field_updateTime));
    }
    if (this.field_digest == null) {
      this.field_digest = "";
    }
    if (this.eKe) {
      localContentValues.put("digest", this.field_digest);
    }
    if (this.eKc) {
      localContentValues.put("lastMsgID", Long.valueOf(this.field_lastMsgID));
    }
    if (this.fep) {
      localContentValues.put("digestFlag", Long.valueOf(this.field_digestFlag));
    }
    if (this.field_digestPrefix == null) {
      this.field_digestPrefix = "";
    }
    if (this.feq) {
      localContentValues.put("digestPrefix", this.field_digestPrefix);
    }
    if (this.field_editingMsg == null) {
      this.field_editingMsg = "";
    }
    if (this.eKh) {
      localContentValues.put("editingMsg", this.field_editingMsg);
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