package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;
import com.tencent.mm.sdk.e.c.a;
import java.lang.reflect.Field;
import java.util.Map;

public abstract class ce
  extends c
{
  public static final String[] INDEX_CREATE = { "CREATE INDEX IF NOT EXISTS FinderConversation_sessionId_index ON FinderConversation(sessionId)", "CREATE INDEX IF NOT EXISTS FinderConversation_talker_index ON FinderConversation(talker)", "CREATE INDEX IF NOT EXISTS FinderConversation_username_status ON FinderConversation(status)", "CREATE INDEX IF NOT EXISTS FinderConversation_updateTime_index ON FinderConversation(updateTime)", "CREATE INDEX IF NOT EXISTS FinderConversation_type_index ON FinderConversation(type)", "CREATE INDEX IF NOT EXISTS FinderConversation_scene_index ON FinderConversation(scene)", "CREATE INDEX IF NOT EXISTS FinderConversation_readStatus_index ON FinderConversation(readStatus)" };
  private static final int eDc;
  private static final int eEB = "scene".hashCode();
  private static final int eEm;
  private static final int eFq;
  private static final int eIG;
  private static final int eII;
  private static final int eIK;
  private static final int eIL;
  private static final int eIN;
  private static final int eIP;
  private static final int eLf;
  private static final int eVL = "sessionId".hashCode();
  private static final int eYt;
  private static final int eYu;
  private static final int eYv;
  private static final int eYw = "readStatus".hashCode();
  private static final int rowid_HASHCODE = "rowid".hashCode();
  private static final int type_HASHCODE;
  private boolean __hadSettype = true;
  private boolean eCZ = true;
  private boolean eDP = true;
  private boolean eEz = true;
  private boolean eFn = true;
  private boolean eIA = true;
  private boolean eIr = true;
  private boolean eIt = true;
  private boolean eIv = true;
  private boolean eIw = true;
  private boolean eIy = true;
  private boolean eKS = true;
  private boolean eVx = true;
  private boolean eYp = true;
  private boolean eYq = true;
  private boolean eYr = true;
  private boolean eYs = true;
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
  
  static
  {
    eLf = "talker".hashCode();
    eIG = "unReadCount".hashCode();
    eDc = "status".hashCode();
    eFq = "updateTime".hashCode();
    eIK = "digest".hashCode();
    eIL = "digestUser".hashCode();
    eYt = "digestType".hashCode();
    eII = "lastMsgID".hashCode();
    eEm = "content".hashCode();
    eIP = "isSend".hashCode();
    eYu = "placedFlag".hashCode();
    eIN = "editingMsg".hashCode();
    type_HASHCODE = "type".hashCode();
    eYv = "actionPermission".hashCode();
  }
  
  public static c.a Vv()
  {
    c.a locala = new c.a();
    locala.IhA = new Field[17];
    locala.columns = new String[18];
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
    locala.columns[2] = "unReadCount";
    locala.IhC.put("unReadCount", "INTEGER default '0' ");
    localStringBuilder.append(" unReadCount INTEGER default '0' ");
    localStringBuilder.append(", ");
    locala.columns[3] = "status";
    locala.IhC.put("status", "INTEGER default '0' ");
    localStringBuilder.append(" status INTEGER default '0' ");
    localStringBuilder.append(", ");
    locala.columns[4] = "updateTime";
    locala.IhC.put("updateTime", "LONG default '0' ");
    localStringBuilder.append(" updateTime LONG default '0' ");
    localStringBuilder.append(", ");
    locala.columns[5] = "digest";
    locala.IhC.put("digest", "TEXT default '' ");
    localStringBuilder.append(" digest TEXT default '' ");
    localStringBuilder.append(", ");
    locala.columns[6] = "digestUser";
    locala.IhC.put("digestUser", "TEXT default '' ");
    localStringBuilder.append(" digestUser TEXT default '' ");
    localStringBuilder.append(", ");
    locala.columns[7] = "digestType";
    locala.IhC.put("digestType", "TEXT default '' ");
    localStringBuilder.append(" digestType TEXT default '' ");
    localStringBuilder.append(", ");
    locala.columns[8] = "lastMsgID";
    locala.IhC.put("lastMsgID", "LONG");
    localStringBuilder.append(" lastMsgID LONG");
    localStringBuilder.append(", ");
    locala.columns[9] = "content";
    locala.IhC.put("content", "TEXT");
    localStringBuilder.append(" content TEXT");
    localStringBuilder.append(", ");
    locala.columns[10] = "isSend";
    locala.IhC.put("isSend", "INTEGER");
    localStringBuilder.append(" isSend INTEGER");
    localStringBuilder.append(", ");
    locala.columns[11] = "placedFlag";
    locala.IhC.put("placedFlag", "LONG default '0' ");
    localStringBuilder.append(" placedFlag LONG default '0' ");
    localStringBuilder.append(", ");
    locala.columns[12] = "editingMsg";
    locala.IhC.put("editingMsg", "TEXT");
    localStringBuilder.append(" editingMsg TEXT");
    localStringBuilder.append(", ");
    locala.columns[13] = "type";
    locala.IhC.put("type", "INTEGER");
    localStringBuilder.append(" type INTEGER");
    localStringBuilder.append(", ");
    locala.columns[14] = "actionPermission";
    locala.IhC.put("actionPermission", "INTEGER");
    localStringBuilder.append(" actionPermission INTEGER");
    localStringBuilder.append(", ");
    locala.columns[15] = "scene";
    locala.IhC.put("scene", "INTEGER");
    localStringBuilder.append(" scene INTEGER");
    localStringBuilder.append(", ");
    locala.columns[16] = "readStatus";
    locala.IhC.put("readStatus", "INTEGER");
    localStringBuilder.append(" readStatus INTEGER");
    locala.columns[17] = "rowid";
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
      } else if (eIG == k) {
        this.field_unReadCount = paramCursor.getInt(i);
      } else if (eDc == k) {
        this.field_status = paramCursor.getInt(i);
      } else if (eFq == k) {
        this.field_updateTime = paramCursor.getLong(i);
      } else if (eIK == k) {
        this.field_digest = paramCursor.getString(i);
      } else if (eIL == k) {
        this.field_digestUser = paramCursor.getString(i);
      } else if (eYt == k) {
        this.field_digestType = paramCursor.getString(i);
      } else if (eII == k) {
        this.field_lastMsgID = paramCursor.getLong(i);
      } else if (eEm == k) {
        this.field_content = paramCursor.getString(i);
      } else if (eIP == k) {
        this.field_isSend = paramCursor.getInt(i);
      } else if (eYu == k) {
        this.field_placedFlag = paramCursor.getLong(i);
      } else if (eIN == k) {
        this.field_editingMsg = paramCursor.getString(i);
      } else if (type_HASHCODE == k) {
        this.field_type = paramCursor.getInt(i);
      } else if (eYv == k) {
        this.field_actionPermission = paramCursor.getInt(i);
      } else if (eEB == k) {
        this.field_scene = paramCursor.getInt(i);
      } else if (eYw == k) {
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
    if (this.eVx) {
      localContentValues.put("sessionId", this.field_sessionId);
    }
    if (this.field_talker == null) {
      this.field_talker = "";
    }
    if (this.eKS) {
      localContentValues.put("talker", this.field_talker);
    }
    if (this.eIr) {
      localContentValues.put("unReadCount", Integer.valueOf(this.field_unReadCount));
    }
    if (this.eCZ) {
      localContentValues.put("status", Integer.valueOf(this.field_status));
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
    if (this.field_digestUser == null) {
      this.field_digestUser = "";
    }
    if (this.eIw) {
      localContentValues.put("digestUser", this.field_digestUser);
    }
    if (this.field_digestType == null) {
      this.field_digestType = "";
    }
    if (this.eYp) {
      localContentValues.put("digestType", this.field_digestType);
    }
    if (this.eIt) {
      localContentValues.put("lastMsgID", Long.valueOf(this.field_lastMsgID));
    }
    if (this.eDP) {
      localContentValues.put("content", this.field_content);
    }
    if (this.eIA) {
      localContentValues.put("isSend", Integer.valueOf(this.field_isSend));
    }
    if (this.eYq) {
      localContentValues.put("placedFlag", Long.valueOf(this.field_placedFlag));
    }
    if (this.eIy) {
      localContentValues.put("editingMsg", this.field_editingMsg);
    }
    if (this.__hadSettype) {
      localContentValues.put("type", Integer.valueOf(this.field_type));
    }
    if (this.eYr) {
      localContentValues.put("actionPermission", Integer.valueOf(this.field_actionPermission));
    }
    if (this.eEz) {
      localContentValues.put("scene", Integer.valueOf(this.field_scene));
    }
    if (this.eYs) {
      localContentValues.put("readStatus", Integer.valueOf(this.field_readStatus));
    }
    if (this.systemRowid > 0L) {
      localContentValues.put("rowid", Long.valueOf(this.systemRowid));
    }
    return localContentValues;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.g.c.ce
 * JD-Core Version:    0.7.0.1
 */