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
  private static final int eEL;
  private static final int eFV;
  private static final int eGZ;
  private static final int eGk = "scene".hashCode();
  private static final int eKp;
  private static final int eKr;
  private static final int eKt;
  private static final int eKu;
  private static final int eKw;
  private static final int eKy;
  private static final int eMP;
  private static final int eXw = "sessionId".hashCode();
  private static final int fag;
  private static final int fah;
  private static final int fai;
  private static final int faj = "readStatus".hashCode();
  private static final int rowid_HASHCODE = "rowid".hashCode();
  private static final int type_HASHCODE;
  private boolean __hadSettype = true;
  private boolean eEI = true;
  private boolean eFy = true;
  private boolean eGW = true;
  private boolean eGi = true;
  private boolean eKa = true;
  private boolean eKc = true;
  private boolean eKe = true;
  private boolean eKf = true;
  private boolean eKh = true;
  private boolean eKj = true;
  private boolean eMB = true;
  private boolean eXi = true;
  private boolean fac = true;
  private boolean fad = true;
  private boolean fae = true;
  private boolean faf = true;
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
    eMP = "talker".hashCode();
    eKp = "unReadCount".hashCode();
    eEL = "status".hashCode();
    eGZ = "updateTime".hashCode();
    eKt = "digest".hashCode();
    eKu = "digestUser".hashCode();
    fag = "digestType".hashCode();
    eKr = "lastMsgID".hashCode();
    eFV = "content".hashCode();
    eKy = "isSend".hashCode();
    fah = "placedFlag".hashCode();
    eKw = "editingMsg".hashCode();
    type_HASHCODE = "type".hashCode();
    fai = "actionPermission".hashCode();
  }
  
  public static c.a VD()
  {
    c.a locala = new c.a();
    locala.IBL = new Field[17];
    locala.columns = new String[18];
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
    locala.columns[2] = "unReadCount";
    locala.IBN.put("unReadCount", "INTEGER default '0' ");
    localStringBuilder.append(" unReadCount INTEGER default '0' ");
    localStringBuilder.append(", ");
    locala.columns[3] = "status";
    locala.IBN.put("status", "INTEGER default '0' ");
    localStringBuilder.append(" status INTEGER default '0' ");
    localStringBuilder.append(", ");
    locala.columns[4] = "updateTime";
    locala.IBN.put("updateTime", "LONG default '0' ");
    localStringBuilder.append(" updateTime LONG default '0' ");
    localStringBuilder.append(", ");
    locala.columns[5] = "digest";
    locala.IBN.put("digest", "TEXT default '' ");
    localStringBuilder.append(" digest TEXT default '' ");
    localStringBuilder.append(", ");
    locala.columns[6] = "digestUser";
    locala.IBN.put("digestUser", "TEXT default '' ");
    localStringBuilder.append(" digestUser TEXT default '' ");
    localStringBuilder.append(", ");
    locala.columns[7] = "digestType";
    locala.IBN.put("digestType", "TEXT default '' ");
    localStringBuilder.append(" digestType TEXT default '' ");
    localStringBuilder.append(", ");
    locala.columns[8] = "lastMsgID";
    locala.IBN.put("lastMsgID", "LONG");
    localStringBuilder.append(" lastMsgID LONG");
    localStringBuilder.append(", ");
    locala.columns[9] = "content";
    locala.IBN.put("content", "TEXT");
    localStringBuilder.append(" content TEXT");
    localStringBuilder.append(", ");
    locala.columns[10] = "isSend";
    locala.IBN.put("isSend", "INTEGER");
    localStringBuilder.append(" isSend INTEGER");
    localStringBuilder.append(", ");
    locala.columns[11] = "placedFlag";
    locala.IBN.put("placedFlag", "LONG default '0' ");
    localStringBuilder.append(" placedFlag LONG default '0' ");
    localStringBuilder.append(", ");
    locala.columns[12] = "editingMsg";
    locala.IBN.put("editingMsg", "TEXT");
    localStringBuilder.append(" editingMsg TEXT");
    localStringBuilder.append(", ");
    locala.columns[13] = "type";
    locala.IBN.put("type", "INTEGER");
    localStringBuilder.append(" type INTEGER");
    localStringBuilder.append(", ");
    locala.columns[14] = "actionPermission";
    locala.IBN.put("actionPermission", "INTEGER");
    localStringBuilder.append(" actionPermission INTEGER");
    localStringBuilder.append(", ");
    locala.columns[15] = "scene";
    locala.IBN.put("scene", "INTEGER");
    localStringBuilder.append(" scene INTEGER");
    localStringBuilder.append(", ");
    locala.columns[16] = "readStatus";
    locala.IBN.put("readStatus", "INTEGER");
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
      } else if (eKp == k) {
        this.field_unReadCount = paramCursor.getInt(i);
      } else if (eEL == k) {
        this.field_status = paramCursor.getInt(i);
      } else if (eGZ == k) {
        this.field_updateTime = paramCursor.getLong(i);
      } else if (eKt == k) {
        this.field_digest = paramCursor.getString(i);
      } else if (eKu == k) {
        this.field_digestUser = paramCursor.getString(i);
      } else if (fag == k) {
        this.field_digestType = paramCursor.getString(i);
      } else if (eKr == k) {
        this.field_lastMsgID = paramCursor.getLong(i);
      } else if (eFV == k) {
        this.field_content = paramCursor.getString(i);
      } else if (eKy == k) {
        this.field_isSend = paramCursor.getInt(i);
      } else if (fah == k) {
        this.field_placedFlag = paramCursor.getLong(i);
      } else if (eKw == k) {
        this.field_editingMsg = paramCursor.getString(i);
      } else if (type_HASHCODE == k) {
        this.field_type = paramCursor.getInt(i);
      } else if (fai == k) {
        this.field_actionPermission = paramCursor.getInt(i);
      } else if (eGk == k) {
        this.field_scene = paramCursor.getInt(i);
      } else if (faj == k) {
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
    if (this.eXi) {
      localContentValues.put("sessionId", this.field_sessionId);
    }
    if (this.field_talker == null) {
      this.field_talker = "";
    }
    if (this.eMB) {
      localContentValues.put("talker", this.field_talker);
    }
    if (this.eKa) {
      localContentValues.put("unReadCount", Integer.valueOf(this.field_unReadCount));
    }
    if (this.eEI) {
      localContentValues.put("status", Integer.valueOf(this.field_status));
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
    if (this.field_digestUser == null) {
      this.field_digestUser = "";
    }
    if (this.eKf) {
      localContentValues.put("digestUser", this.field_digestUser);
    }
    if (this.field_digestType == null) {
      this.field_digestType = "";
    }
    if (this.fac) {
      localContentValues.put("digestType", this.field_digestType);
    }
    if (this.eKc) {
      localContentValues.put("lastMsgID", Long.valueOf(this.field_lastMsgID));
    }
    if (this.eFy) {
      localContentValues.put("content", this.field_content);
    }
    if (this.eKj) {
      localContentValues.put("isSend", Integer.valueOf(this.field_isSend));
    }
    if (this.fad) {
      localContentValues.put("placedFlag", Long.valueOf(this.field_placedFlag));
    }
    if (this.eKh) {
      localContentValues.put("editingMsg", this.field_editingMsg);
    }
    if (this.__hadSettype) {
      localContentValues.put("type", Integer.valueOf(this.field_type));
    }
    if (this.fae) {
      localContentValues.put("actionPermission", Integer.valueOf(this.field_actionPermission));
    }
    if (this.eGi) {
      localContentValues.put("scene", Integer.valueOf(this.field_scene));
    }
    if (this.faf) {
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