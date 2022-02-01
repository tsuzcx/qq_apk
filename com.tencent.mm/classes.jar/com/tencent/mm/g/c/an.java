package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;
import com.tencent.mm.sdk.e.c.a;
import java.lang.reflect.Field;
import java.util.Map;

public abstract class an
  extends c
{
  public static final String[] INDEX_CREATE = new String[0];
  private static final int eEF = "msgId".hashCode();
  private static final int eEL;
  private static final int eFO;
  private static final int eFV;
  private static final int eJG;
  private static final int eKn;
  private static final int eKy;
  private static final int eMO = "msgSvrId".hashCode();
  private static final int eMP;
  private static final int eMQ;
  private static final int eMR;
  private static final int eMS;
  private static final int eMZ;
  private static final int eMi = "extInfo".hashCode();
  private static final int eNo;
  private static final int eNp;
  private static final int eNq;
  private static final int eNr;
  private static final int eNs;
  private static final int eNt;
  private static final int eNu;
  private static final int eNv;
  private static final int rowid_HASHCODE = "rowid".hashCode();
  private static final int type_HASHCODE = "type".hashCode();
  private boolean __hadSettype;
  private boolean eEB;
  private boolean eEI;
  private boolean eFr;
  private boolean eFy;
  private boolean eJE;
  private boolean eJY;
  private boolean eKj;
  private boolean eLU;
  private boolean eMA;
  private boolean eMB;
  private boolean eMC;
  private boolean eMD;
  private boolean eME;
  private boolean eML;
  private boolean eNg;
  private boolean eNh;
  private boolean eNi;
  private boolean eNj;
  private boolean eNk;
  private boolean eNl;
  private boolean eNm;
  private boolean eNn;
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
  
  static
  {
    eEL = "status".hashCode();
    eKy = "isSend".hashCode();
    eNo = "isShowTimer".hashCode();
    eFO = "createTime".hashCode();
    eMP = "talker".hashCode();
    eFV = "content".hashCode();
    eMQ = "imgPath".hashCode();
    eNp = "reserved".hashCode();
    eMR = "lvbuffer".hashCode();
    eMS = "talkerId".hashCode();
    eNq = "transContent".hashCode();
    eNr = "transBrandWording".hashCode();
    eMZ = "bizClientMsgId".hashCode();
    eKn = "bizChatId".hashCode();
    eNs = "bizChatUserId".hashCode();
    eNt = "msgSeq".hashCode();
    eJG = "flag".hashCode();
    eNu = "fromUsername".hashCode();
    eNv = "toUsername".hashCode();
  }
  
  public static c.a VD()
  {
    c.a locala = new c.a();
    locala.IBL = new Field[23];
    locala.columns = new String[24];
    StringBuilder localStringBuilder = new StringBuilder();
    locala.columns[0] = "msgId";
    locala.IBN.put("msgId", "LONG PRIMARY KEY ");
    localStringBuilder.append(" msgId LONG PRIMARY KEY ");
    localStringBuilder.append(", ");
    locala.IBM = "msgId";
    locala.columns[1] = "msgSvrId";
    locala.IBN.put("msgSvrId", "LONG");
    localStringBuilder.append(" msgSvrId LONG");
    localStringBuilder.append(", ");
    locala.columns[2] = "type";
    locala.IBN.put("type", "INTEGER");
    localStringBuilder.append(" type INTEGER");
    localStringBuilder.append(", ");
    locala.columns[3] = "status";
    locala.IBN.put("status", "INTEGER");
    localStringBuilder.append(" status INTEGER");
    localStringBuilder.append(", ");
    locala.columns[4] = "isSend";
    locala.IBN.put("isSend", "INTEGER");
    localStringBuilder.append(" isSend INTEGER");
    localStringBuilder.append(", ");
    locala.columns[5] = "isShowTimer";
    locala.IBN.put("isShowTimer", "INTEGER");
    localStringBuilder.append(" isShowTimer INTEGER");
    localStringBuilder.append(", ");
    locala.columns[6] = "createTime";
    locala.IBN.put("createTime", "LONG");
    localStringBuilder.append(" createTime LONG");
    localStringBuilder.append(", ");
    locala.columns[7] = "talker";
    locala.IBN.put("talker", "TEXT");
    localStringBuilder.append(" talker TEXT");
    localStringBuilder.append(", ");
    locala.columns[8] = "content";
    locala.IBN.put("content", "TEXT default '' ");
    localStringBuilder.append(" content TEXT default '' ");
    localStringBuilder.append(", ");
    locala.columns[9] = "imgPath";
    locala.IBN.put("imgPath", "TEXT");
    localStringBuilder.append(" imgPath TEXT");
    localStringBuilder.append(", ");
    locala.columns[10] = "reserved";
    locala.IBN.put("reserved", "TEXT");
    localStringBuilder.append(" reserved TEXT");
    localStringBuilder.append(", ");
    locala.columns[11] = "lvbuffer";
    locala.IBN.put("lvbuffer", "BLOB");
    localStringBuilder.append(" lvbuffer BLOB");
    localStringBuilder.append(", ");
    locala.columns[12] = "talkerId";
    locala.IBN.put("talkerId", "INTEGER");
    localStringBuilder.append(" talkerId INTEGER");
    localStringBuilder.append(", ");
    locala.columns[13] = "transContent";
    locala.IBN.put("transContent", "TEXT default '' ");
    localStringBuilder.append(" transContent TEXT default '' ");
    localStringBuilder.append(", ");
    locala.columns[14] = "transBrandWording";
    locala.IBN.put("transBrandWording", "TEXT default '' ");
    localStringBuilder.append(" transBrandWording TEXT default '' ");
    localStringBuilder.append(", ");
    locala.columns[15] = "bizClientMsgId";
    locala.IBN.put("bizClientMsgId", "TEXT default '' ");
    localStringBuilder.append(" bizClientMsgId TEXT default '' ");
    localStringBuilder.append(", ");
    locala.columns[16] = "bizChatId";
    locala.IBN.put("bizChatId", "LONG default '-1' ");
    localStringBuilder.append(" bizChatId LONG default '-1' ");
    localStringBuilder.append(", ");
    locala.columns[17] = "bizChatUserId";
    locala.IBN.put("bizChatUserId", "TEXT default '' ");
    localStringBuilder.append(" bizChatUserId TEXT default '' ");
    localStringBuilder.append(", ");
    locala.columns[18] = "msgSeq";
    locala.IBN.put("msgSeq", "LONG");
    localStringBuilder.append(" msgSeq LONG");
    localStringBuilder.append(", ");
    locala.columns[19] = "flag";
    locala.IBN.put("flag", "INTEGER default '0' ");
    localStringBuilder.append(" flag INTEGER default '0' ");
    localStringBuilder.append(", ");
    locala.columns[20] = "fromUsername";
    locala.IBN.put("fromUsername", "TEXT");
    localStringBuilder.append(" fromUsername TEXT");
    localStringBuilder.append(", ");
    locala.columns[21] = "toUsername";
    locala.IBN.put("toUsername", "TEXT");
    localStringBuilder.append(" toUsername TEXT");
    localStringBuilder.append(", ");
    locala.columns[22] = "extInfo";
    locala.IBN.put("extInfo", "BLOB");
    localStringBuilder.append(" extInfo BLOB");
    locala.columns[23] = "rowid";
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
      if (eEF != k) {
        break label65;
      }
      this.field_msgId = paramCursor.getLong(i);
      this.eEB = true;
    }
    for (;;)
    {
      i += 1;
      break label20;
      break;
      label65:
      if (eMO == k) {
        this.field_msgSvrId = paramCursor.getLong(i);
      } else if (type_HASHCODE == k) {
        this.field_type = paramCursor.getInt(i);
      } else if (eEL == k) {
        this.field_status = paramCursor.getInt(i);
      } else if (eKy == k) {
        this.field_isSend = paramCursor.getInt(i);
      } else if (eNo == k) {
        this.field_isShowTimer = paramCursor.getInt(i);
      } else if (eFO == k) {
        this.field_createTime = paramCursor.getLong(i);
      } else if (eMP == k) {
        this.field_talker = paramCursor.getString(i);
      } else if (eFV == k) {
        this.field_content = paramCursor.getString(i);
      } else if (eMQ == k) {
        this.field_imgPath = paramCursor.getString(i);
      } else if (eNp == k) {
        this.field_reserved = paramCursor.getString(i);
      } else if (eMR == k) {
        this.field_lvbuffer = paramCursor.getBlob(i);
      } else if (eMS == k) {
        this.field_talkerId = paramCursor.getInt(i);
      } else if (eNq == k) {
        this.field_transContent = paramCursor.getString(i);
      } else if (eNr == k) {
        this.field_transBrandWording = paramCursor.getString(i);
      } else if (eMZ == k) {
        this.field_bizClientMsgId = paramCursor.getString(i);
      } else if (eKn == k) {
        this.field_bizChatId = paramCursor.getLong(i);
      } else if (eNs == k) {
        this.field_bizChatUserId = paramCursor.getString(i);
      } else if (eNt == k) {
        this.field_msgSeq = paramCursor.getLong(i);
      } else if (eJG == k) {
        this.field_flag = paramCursor.getInt(i);
      } else if (eNu == k) {
        this.field_fromUsername = paramCursor.getString(i);
      } else if (eNv == k) {
        this.field_toUsername = paramCursor.getString(i);
      } else if (eMi == k) {
        this.field_extInfo = paramCursor.getBlob(i);
      } else if (rowid_HASHCODE == k) {
        this.systemRowid = paramCursor.getLong(i);
      }
    }
  }
  
  public ContentValues convertTo()
  {
    ContentValues localContentValues = new ContentValues();
    if (this.eEB) {
      localContentValues.put("msgId", Long.valueOf(this.field_msgId));
    }
    if (this.eMA) {
      localContentValues.put("msgSvrId", Long.valueOf(this.field_msgSvrId));
    }
    if (this.__hadSettype) {
      localContentValues.put("type", Integer.valueOf(this.field_type));
    }
    if (this.eEI) {
      localContentValues.put("status", Integer.valueOf(this.field_status));
    }
    if (this.eKj) {
      localContentValues.put("isSend", Integer.valueOf(this.field_isSend));
    }
    if (this.eNg) {
      localContentValues.put("isShowTimer", Integer.valueOf(this.field_isShowTimer));
    }
    if (this.eFr) {
      localContentValues.put("createTime", Long.valueOf(this.field_createTime));
    }
    if (this.eMB) {
      localContentValues.put("talker", this.field_talker);
    }
    if (this.field_content == null) {
      this.field_content = "";
    }
    if (this.eFy) {
      localContentValues.put("content", this.field_content);
    }
    if (this.eMC) {
      localContentValues.put("imgPath", this.field_imgPath);
    }
    if (this.eNh) {
      localContentValues.put("reserved", this.field_reserved);
    }
    if (this.eMD) {
      localContentValues.put("lvbuffer", this.field_lvbuffer);
    }
    if (this.eME) {
      localContentValues.put("talkerId", Integer.valueOf(this.field_talkerId));
    }
    if (this.field_transContent == null) {
      this.field_transContent = "";
    }
    if (this.eNi) {
      localContentValues.put("transContent", this.field_transContent);
    }
    if (this.field_transBrandWording == null) {
      this.field_transBrandWording = "";
    }
    if (this.eNj) {
      localContentValues.put("transBrandWording", this.field_transBrandWording);
    }
    if (this.field_bizClientMsgId == null) {
      this.field_bizClientMsgId = "";
    }
    if (this.eML) {
      localContentValues.put("bizClientMsgId", this.field_bizClientMsgId);
    }
    if (this.eJY) {
      localContentValues.put("bizChatId", Long.valueOf(this.field_bizChatId));
    }
    if (this.field_bizChatUserId == null) {
      this.field_bizChatUserId = "";
    }
    if (this.eNk) {
      localContentValues.put("bizChatUserId", this.field_bizChatUserId);
    }
    if (this.eNl) {
      localContentValues.put("msgSeq", Long.valueOf(this.field_msgSeq));
    }
    if (this.eJE) {
      localContentValues.put("flag", Integer.valueOf(this.field_flag));
    }
    if (this.eNm) {
      localContentValues.put("fromUsername", this.field_fromUsername);
    }
    if (this.eNn) {
      localContentValues.put("toUsername", this.field_toUsername);
    }
    if (this.eLU) {
      localContentValues.put("extInfo", this.field_extInfo);
    }
    if (this.systemRowid > 0L) {
      localContentValues.put("rowid", Long.valueOf(this.systemRowid));
    }
    return localContentValues;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.g.c.an
 * JD-Core Version:    0.7.0.1
 */