package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.storage.IAutoDBItem;
import com.tencent.mm.sdk.storage.IAutoDBItem.MAutoDBInfo;
import java.lang.reflect.Field;
import java.util.Map;

public abstract class ao
  extends IAutoDBItem
{
  public static final String[] INDEX_CREATE = new String[0];
  private static final int content_HASHCODE;
  private static final int createTime_HASHCODE;
  private static final int fjf = "msgId".hashCode();
  private static final int fjl;
  private static final int fnT;
  private static final int fni;
  private static final int foe;
  private static final int fpP = "extInfo".hashCode();
  private static final int fqG;
  private static final int fqV;
  private static final int fqW;
  private static final int fqX;
  private static final int fqY;
  private static final int fqZ;
  private static final int fqv = "msgSvrId".hashCode();
  private static final int fqw;
  private static final int fqx;
  private static final int fqy;
  private static final int fqz;
  private static final int fra;
  private static final int frb;
  private static final int frc;
  private static final int rowid_HASHCODE = "rowid".hashCode();
  private static final int type_HASHCODE = "type".hashCode();
  private boolean __hadSetcontent;
  private boolean __hadSetcreateTime;
  private boolean __hadSettype;
  public long field_bizChatId;
  public String field_bizChatUserId;
  public String field_bizClientMsgId;
  public String field_content;
  public long field_createTime;
  public byte[] field_extInfo;
  public int field_flag;
  public String field_fromUsername;
  public String field_imgPath;
  public int field_isSend;
  public int field_isShowTimer;
  public byte[] field_lvbuffer;
  public long field_msgId;
  public long field_msgSeq;
  public long field_msgSvrId;
  public String field_reserved;
  public int field_status;
  public String field_talker;
  public int field_talkerId;
  public String field_toUsername;
  public String field_transBrandWording;
  public String field_transContent;
  public int field_type;
  private boolean fjb;
  private boolean fji;
  private boolean fnE;
  private boolean fnP;
  private boolean fng;
  private boolean fpB;
  private boolean fqN;
  private boolean fqO;
  private boolean fqP;
  private boolean fqQ;
  private boolean fqR;
  private boolean fqS;
  private boolean fqT;
  private boolean fqU;
  private boolean fqh;
  private boolean fqi;
  private boolean fqj;
  private boolean fqk;
  private boolean fql;
  private boolean fqs;
  
  static
  {
    fjl = "status".hashCode();
    foe = "isSend".hashCode();
    fqV = "isShowTimer".hashCode();
    createTime_HASHCODE = "createTime".hashCode();
    fqw = "talker".hashCode();
    content_HASHCODE = "content".hashCode();
    fqx = "imgPath".hashCode();
    fqW = "reserved".hashCode();
    fqy = "lvbuffer".hashCode();
    fqz = "talkerId".hashCode();
    fqX = "transContent".hashCode();
    fqY = "transBrandWording".hashCode();
    fqG = "bizClientMsgId".hashCode();
    fnT = "bizChatId".hashCode();
    fqZ = "bizChatUserId".hashCode();
    fra = "msgSeq".hashCode();
    fni = "flag".hashCode();
    frb = "fromUsername".hashCode();
    frc = "toUsername".hashCode();
  }
  
  public static IAutoDBItem.MAutoDBInfo ajs()
  {
    IAutoDBItem.MAutoDBInfo localMAutoDBInfo = new IAutoDBItem.MAutoDBInfo();
    localMAutoDBInfo.fields = new Field[23];
    localMAutoDBInfo.columns = new String[24];
    StringBuilder localStringBuilder = new StringBuilder();
    localMAutoDBInfo.columns[0] = "msgId";
    localMAutoDBInfo.colsMap.put("msgId", "LONG PRIMARY KEY ");
    localStringBuilder.append(" msgId LONG PRIMARY KEY ");
    localStringBuilder.append(", ");
    localMAutoDBInfo.primaryKey = "msgId";
    localMAutoDBInfo.columns[1] = "msgSvrId";
    localMAutoDBInfo.colsMap.put("msgSvrId", "LONG");
    localStringBuilder.append(" msgSvrId LONG");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[2] = "type";
    localMAutoDBInfo.colsMap.put("type", "INTEGER");
    localStringBuilder.append(" type INTEGER");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[3] = "status";
    localMAutoDBInfo.colsMap.put("status", "INTEGER");
    localStringBuilder.append(" status INTEGER");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[4] = "isSend";
    localMAutoDBInfo.colsMap.put("isSend", "INTEGER");
    localStringBuilder.append(" isSend INTEGER");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[5] = "isShowTimer";
    localMAutoDBInfo.colsMap.put("isShowTimer", "INTEGER");
    localStringBuilder.append(" isShowTimer INTEGER");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[6] = "createTime";
    localMAutoDBInfo.colsMap.put("createTime", "LONG");
    localStringBuilder.append(" createTime LONG");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[7] = "talker";
    localMAutoDBInfo.colsMap.put("talker", "TEXT");
    localStringBuilder.append(" talker TEXT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[8] = "content";
    localMAutoDBInfo.colsMap.put("content", "TEXT default '' ");
    localStringBuilder.append(" content TEXT default '' ");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[9] = "imgPath";
    localMAutoDBInfo.colsMap.put("imgPath", "TEXT");
    localStringBuilder.append(" imgPath TEXT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[10] = "reserved";
    localMAutoDBInfo.colsMap.put("reserved", "TEXT");
    localStringBuilder.append(" reserved TEXT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[11] = "lvbuffer";
    localMAutoDBInfo.colsMap.put("lvbuffer", "BLOB");
    localStringBuilder.append(" lvbuffer BLOB");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[12] = "talkerId";
    localMAutoDBInfo.colsMap.put("talkerId", "INTEGER");
    localStringBuilder.append(" talkerId INTEGER");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[13] = "transContent";
    localMAutoDBInfo.colsMap.put("transContent", "TEXT default '' ");
    localStringBuilder.append(" transContent TEXT default '' ");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[14] = "transBrandWording";
    localMAutoDBInfo.colsMap.put("transBrandWording", "TEXT default '' ");
    localStringBuilder.append(" transBrandWording TEXT default '' ");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[15] = "bizClientMsgId";
    localMAutoDBInfo.colsMap.put("bizClientMsgId", "TEXT default '' ");
    localStringBuilder.append(" bizClientMsgId TEXT default '' ");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[16] = "bizChatId";
    localMAutoDBInfo.colsMap.put("bizChatId", "LONG default '-1' ");
    localStringBuilder.append(" bizChatId LONG default '-1' ");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[17] = "bizChatUserId";
    localMAutoDBInfo.colsMap.put("bizChatUserId", "TEXT default '' ");
    localStringBuilder.append(" bizChatUserId TEXT default '' ");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[18] = "msgSeq";
    localMAutoDBInfo.colsMap.put("msgSeq", "LONG");
    localStringBuilder.append(" msgSeq LONG");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[19] = "flag";
    localMAutoDBInfo.colsMap.put("flag", "INTEGER default '0' ");
    localStringBuilder.append(" flag INTEGER default '0' ");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[20] = "fromUsername";
    localMAutoDBInfo.colsMap.put("fromUsername", "TEXT");
    localStringBuilder.append(" fromUsername TEXT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[21] = "toUsername";
    localMAutoDBInfo.colsMap.put("toUsername", "TEXT");
    localStringBuilder.append(" toUsername TEXT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[22] = "extInfo";
    localMAutoDBInfo.colsMap.put("extInfo", "BLOB");
    localStringBuilder.append(" extInfo BLOB");
    localMAutoDBInfo.columns[23] = "rowid";
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
      if (fjf != k) {
        break label65;
      }
      this.field_msgId = paramCursor.getLong(i);
      this.fjb = true;
    }
    for (;;)
    {
      i += 1;
      break label20;
      break;
      label65:
      if (fqv == k) {
        this.field_msgSvrId = paramCursor.getLong(i);
      } else if (type_HASHCODE == k) {
        this.field_type = paramCursor.getInt(i);
      } else if (fjl == k) {
        this.field_status = paramCursor.getInt(i);
      } else if (foe == k) {
        this.field_isSend = paramCursor.getInt(i);
      } else if (fqV == k) {
        this.field_isShowTimer = paramCursor.getInt(i);
      } else if (createTime_HASHCODE == k) {
        this.field_createTime = paramCursor.getLong(i);
      } else if (fqw == k) {
        this.field_talker = paramCursor.getString(i);
      } else if (content_HASHCODE == k) {
        this.field_content = paramCursor.getString(i);
      } else if (fqx == k) {
        this.field_imgPath = paramCursor.getString(i);
      } else if (fqW == k) {
        this.field_reserved = paramCursor.getString(i);
      } else if (fqy == k) {
        this.field_lvbuffer = paramCursor.getBlob(i);
      } else if (fqz == k) {
        this.field_talkerId = paramCursor.getInt(i);
      } else if (fqX == k) {
        this.field_transContent = paramCursor.getString(i);
      } else if (fqY == k) {
        this.field_transBrandWording = paramCursor.getString(i);
      } else if (fqG == k) {
        this.field_bizClientMsgId = paramCursor.getString(i);
      } else if (fnT == k) {
        this.field_bizChatId = paramCursor.getLong(i);
      } else if (fqZ == k) {
        this.field_bizChatUserId = paramCursor.getString(i);
      } else if (fra == k) {
        this.field_msgSeq = paramCursor.getLong(i);
      } else if (fni == k) {
        this.field_flag = paramCursor.getInt(i);
      } else if (frb == k) {
        this.field_fromUsername = paramCursor.getString(i);
      } else if (frc == k) {
        this.field_toUsername = paramCursor.getString(i);
      } else if (fpP == k) {
        this.field_extInfo = paramCursor.getBlob(i);
      } else if (rowid_HASHCODE == k) {
        this.systemRowid = paramCursor.getLong(i);
      }
    }
  }
  
  public ContentValues convertTo()
  {
    ContentValues localContentValues = new ContentValues();
    if (this.fjb) {
      localContentValues.put("msgId", Long.valueOf(this.field_msgId));
    }
    if (this.fqh) {
      localContentValues.put("msgSvrId", Long.valueOf(this.field_msgSvrId));
    }
    if (this.__hadSettype) {
      localContentValues.put("type", Integer.valueOf(this.field_type));
    }
    if (this.fji) {
      localContentValues.put("status", Integer.valueOf(this.field_status));
    }
    if (this.fnP) {
      localContentValues.put("isSend", Integer.valueOf(this.field_isSend));
    }
    if (this.fqN) {
      localContentValues.put("isShowTimer", Integer.valueOf(this.field_isShowTimer));
    }
    if (this.__hadSetcreateTime) {
      localContentValues.put("createTime", Long.valueOf(this.field_createTime));
    }
    if (this.fqi) {
      localContentValues.put("talker", this.field_talker);
    }
    if (this.field_content == null) {
      this.field_content = "";
    }
    if (this.__hadSetcontent) {
      localContentValues.put("content", this.field_content);
    }
    if (this.fqj) {
      localContentValues.put("imgPath", this.field_imgPath);
    }
    if (this.fqO) {
      localContentValues.put("reserved", this.field_reserved);
    }
    if (this.fqk) {
      localContentValues.put("lvbuffer", this.field_lvbuffer);
    }
    if (this.fql) {
      localContentValues.put("talkerId", Integer.valueOf(this.field_talkerId));
    }
    if (this.field_transContent == null) {
      this.field_transContent = "";
    }
    if (this.fqP) {
      localContentValues.put("transContent", this.field_transContent);
    }
    if (this.field_transBrandWording == null) {
      this.field_transBrandWording = "";
    }
    if (this.fqQ) {
      localContentValues.put("transBrandWording", this.field_transBrandWording);
    }
    if (this.field_bizClientMsgId == null) {
      this.field_bizClientMsgId = "";
    }
    if (this.fqs) {
      localContentValues.put("bizClientMsgId", this.field_bizClientMsgId);
    }
    if (this.fnE) {
      localContentValues.put("bizChatId", Long.valueOf(this.field_bizChatId));
    }
    if (this.field_bizChatUserId == null) {
      this.field_bizChatUserId = "";
    }
    if (this.fqR) {
      localContentValues.put("bizChatUserId", this.field_bizChatUserId);
    }
    if (this.fqS) {
      localContentValues.put("msgSeq", Long.valueOf(this.field_msgSeq));
    }
    if (this.fng) {
      localContentValues.put("flag", Integer.valueOf(this.field_flag));
    }
    if (this.fqT) {
      localContentValues.put("fromUsername", this.field_fromUsername);
    }
    if (this.fqU) {
      localContentValues.put("toUsername", this.field_toUsername);
    }
    if (this.fpB) {
      localContentValues.put("extInfo", this.field_extInfo);
    }
    if (this.systemRowid > 0L) {
      localContentValues.put("rowid", Long.valueOf(this.systemRowid));
    }
    return localContentValues;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.g.c.ao
 * JD-Core Version:    0.7.0.1
 */