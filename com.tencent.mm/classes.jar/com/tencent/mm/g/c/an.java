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
  private static final int eCW = "msgId".hashCode();
  private static final int eDc;
  private static final int eEf;
  private static final int eEm;
  private static final int eHX;
  private static final int eIE;
  private static final int eIP;
  private static final int eKz = "extInfo".hashCode();
  private static final int eLD;
  private static final int eLE;
  private static final int eLF;
  private static final int eLG;
  private static final int eLH;
  private static final int eLI;
  private static final int eLJ;
  private static final int eLK;
  private static final int eLe = "msgSvrId".hashCode();
  private static final int eLf;
  private static final int eLg;
  private static final int eLh;
  private static final int eLi;
  private static final int eLp;
  private static final int rowid_HASHCODE = "rowid".hashCode();
  private static final int type_HASHCODE = "type".hashCode();
  private boolean __hadSettype;
  private boolean eCS;
  private boolean eCZ;
  private boolean eDI;
  private boolean eDP;
  private boolean eHV;
  private boolean eIA;
  private boolean eIp;
  private boolean eKR;
  private boolean eKS;
  private boolean eKT;
  private boolean eKU;
  private boolean eKV;
  private boolean eKl;
  private boolean eLA;
  private boolean eLB;
  private boolean eLC;
  private boolean eLc;
  private boolean eLv;
  private boolean eLw;
  private boolean eLx;
  private boolean eLy;
  private boolean eLz;
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
    eDc = "status".hashCode();
    eIP = "isSend".hashCode();
    eLD = "isShowTimer".hashCode();
    eEf = "createTime".hashCode();
    eLf = "talker".hashCode();
    eEm = "content".hashCode();
    eLg = "imgPath".hashCode();
    eLE = "reserved".hashCode();
    eLh = "lvbuffer".hashCode();
    eLi = "talkerId".hashCode();
    eLF = "transContent".hashCode();
    eLG = "transBrandWording".hashCode();
    eLp = "bizClientMsgId".hashCode();
    eIE = "bizChatId".hashCode();
    eLH = "bizChatUserId".hashCode();
    eLI = "msgSeq".hashCode();
    eHX = "flag".hashCode();
    eLJ = "fromUsername".hashCode();
    eLK = "toUsername".hashCode();
  }
  
  public static c.a Vv()
  {
    c.a locala = new c.a();
    locala.IhA = new Field[23];
    locala.columns = new String[24];
    StringBuilder localStringBuilder = new StringBuilder();
    locala.columns[0] = "msgId";
    locala.IhC.put("msgId", "LONG PRIMARY KEY ");
    localStringBuilder.append(" msgId LONG PRIMARY KEY ");
    localStringBuilder.append(", ");
    locala.IhB = "msgId";
    locala.columns[1] = "msgSvrId";
    locala.IhC.put("msgSvrId", "LONG");
    localStringBuilder.append(" msgSvrId LONG");
    localStringBuilder.append(", ");
    locala.columns[2] = "type";
    locala.IhC.put("type", "INTEGER");
    localStringBuilder.append(" type INTEGER");
    localStringBuilder.append(", ");
    locala.columns[3] = "status";
    locala.IhC.put("status", "INTEGER");
    localStringBuilder.append(" status INTEGER");
    localStringBuilder.append(", ");
    locala.columns[4] = "isSend";
    locala.IhC.put("isSend", "INTEGER");
    localStringBuilder.append(" isSend INTEGER");
    localStringBuilder.append(", ");
    locala.columns[5] = "isShowTimer";
    locala.IhC.put("isShowTimer", "INTEGER");
    localStringBuilder.append(" isShowTimer INTEGER");
    localStringBuilder.append(", ");
    locala.columns[6] = "createTime";
    locala.IhC.put("createTime", "LONG");
    localStringBuilder.append(" createTime LONG");
    localStringBuilder.append(", ");
    locala.columns[7] = "talker";
    locala.IhC.put("talker", "TEXT");
    localStringBuilder.append(" talker TEXT");
    localStringBuilder.append(", ");
    locala.columns[8] = "content";
    locala.IhC.put("content", "TEXT default '' ");
    localStringBuilder.append(" content TEXT default '' ");
    localStringBuilder.append(", ");
    locala.columns[9] = "imgPath";
    locala.IhC.put("imgPath", "TEXT");
    localStringBuilder.append(" imgPath TEXT");
    localStringBuilder.append(", ");
    locala.columns[10] = "reserved";
    locala.IhC.put("reserved", "TEXT");
    localStringBuilder.append(" reserved TEXT");
    localStringBuilder.append(", ");
    locala.columns[11] = "lvbuffer";
    locala.IhC.put("lvbuffer", "BLOB");
    localStringBuilder.append(" lvbuffer BLOB");
    localStringBuilder.append(", ");
    locala.columns[12] = "talkerId";
    locala.IhC.put("talkerId", "INTEGER");
    localStringBuilder.append(" talkerId INTEGER");
    localStringBuilder.append(", ");
    locala.columns[13] = "transContent";
    locala.IhC.put("transContent", "TEXT default '' ");
    localStringBuilder.append(" transContent TEXT default '' ");
    localStringBuilder.append(", ");
    locala.columns[14] = "transBrandWording";
    locala.IhC.put("transBrandWording", "TEXT default '' ");
    localStringBuilder.append(" transBrandWording TEXT default '' ");
    localStringBuilder.append(", ");
    locala.columns[15] = "bizClientMsgId";
    locala.IhC.put("bizClientMsgId", "TEXT default '' ");
    localStringBuilder.append(" bizClientMsgId TEXT default '' ");
    localStringBuilder.append(", ");
    locala.columns[16] = "bizChatId";
    locala.IhC.put("bizChatId", "LONG default '-1' ");
    localStringBuilder.append(" bizChatId LONG default '-1' ");
    localStringBuilder.append(", ");
    locala.columns[17] = "bizChatUserId";
    locala.IhC.put("bizChatUserId", "TEXT default '' ");
    localStringBuilder.append(" bizChatUserId TEXT default '' ");
    localStringBuilder.append(", ");
    locala.columns[18] = "msgSeq";
    locala.IhC.put("msgSeq", "LONG");
    localStringBuilder.append(" msgSeq LONG");
    localStringBuilder.append(", ");
    locala.columns[19] = "flag";
    locala.IhC.put("flag", "INTEGER default '0' ");
    localStringBuilder.append(" flag INTEGER default '0' ");
    localStringBuilder.append(", ");
    locala.columns[20] = "fromUsername";
    locala.IhC.put("fromUsername", "TEXT");
    localStringBuilder.append(" fromUsername TEXT");
    localStringBuilder.append(", ");
    locala.columns[21] = "toUsername";
    locala.IhC.put("toUsername", "TEXT");
    localStringBuilder.append(" toUsername TEXT");
    localStringBuilder.append(", ");
    locala.columns[22] = "extInfo";
    locala.IhC.put("extInfo", "BLOB");
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
      if (eCW != k) {
        break label65;
      }
      this.field_msgId = paramCursor.getLong(i);
      this.eCS = true;
    }
    for (;;)
    {
      i += 1;
      break label20;
      break;
      label65:
      if (eLe == k) {
        this.field_msgSvrId = paramCursor.getLong(i);
      } else if (type_HASHCODE == k) {
        this.field_type = paramCursor.getInt(i);
      } else if (eDc == k) {
        this.field_status = paramCursor.getInt(i);
      } else if (eIP == k) {
        this.field_isSend = paramCursor.getInt(i);
      } else if (eLD == k) {
        this.field_isShowTimer = paramCursor.getInt(i);
      } else if (eEf == k) {
        this.field_createTime = paramCursor.getLong(i);
      } else if (eLf == k) {
        this.field_talker = paramCursor.getString(i);
      } else if (eEm == k) {
        this.field_content = paramCursor.getString(i);
      } else if (eLg == k) {
        this.field_imgPath = paramCursor.getString(i);
      } else if (eLE == k) {
        this.field_reserved = paramCursor.getString(i);
      } else if (eLh == k) {
        this.field_lvbuffer = paramCursor.getBlob(i);
      } else if (eLi == k) {
        this.field_talkerId = paramCursor.getInt(i);
      } else if (eLF == k) {
        this.field_transContent = paramCursor.getString(i);
      } else if (eLG == k) {
        this.field_transBrandWording = paramCursor.getString(i);
      } else if (eLp == k) {
        this.field_bizClientMsgId = paramCursor.getString(i);
      } else if (eIE == k) {
        this.field_bizChatId = paramCursor.getLong(i);
      } else if (eLH == k) {
        this.field_bizChatUserId = paramCursor.getString(i);
      } else if (eLI == k) {
        this.field_msgSeq = paramCursor.getLong(i);
      } else if (eHX == k) {
        this.field_flag = paramCursor.getInt(i);
      } else if (eLJ == k) {
        this.field_fromUsername = paramCursor.getString(i);
      } else if (eLK == k) {
        this.field_toUsername = paramCursor.getString(i);
      } else if (eKz == k) {
        this.field_extInfo = paramCursor.getBlob(i);
      } else if (rowid_HASHCODE == k) {
        this.systemRowid = paramCursor.getLong(i);
      }
    }
  }
  
  public ContentValues convertTo()
  {
    ContentValues localContentValues = new ContentValues();
    if (this.eCS) {
      localContentValues.put("msgId", Long.valueOf(this.field_msgId));
    }
    if (this.eKR) {
      localContentValues.put("msgSvrId", Long.valueOf(this.field_msgSvrId));
    }
    if (this.__hadSettype) {
      localContentValues.put("type", Integer.valueOf(this.field_type));
    }
    if (this.eCZ) {
      localContentValues.put("status", Integer.valueOf(this.field_status));
    }
    if (this.eIA) {
      localContentValues.put("isSend", Integer.valueOf(this.field_isSend));
    }
    if (this.eLv) {
      localContentValues.put("isShowTimer", Integer.valueOf(this.field_isShowTimer));
    }
    if (this.eDI) {
      localContentValues.put("createTime", Long.valueOf(this.field_createTime));
    }
    if (this.eKS) {
      localContentValues.put("talker", this.field_talker);
    }
    if (this.field_content == null) {
      this.field_content = "";
    }
    if (this.eDP) {
      localContentValues.put("content", this.field_content);
    }
    if (this.eKT) {
      localContentValues.put("imgPath", this.field_imgPath);
    }
    if (this.eLw) {
      localContentValues.put("reserved", this.field_reserved);
    }
    if (this.eKU) {
      localContentValues.put("lvbuffer", this.field_lvbuffer);
    }
    if (this.eKV) {
      localContentValues.put("talkerId", Integer.valueOf(this.field_talkerId));
    }
    if (this.field_transContent == null) {
      this.field_transContent = "";
    }
    if (this.eLx) {
      localContentValues.put("transContent", this.field_transContent);
    }
    if (this.field_transBrandWording == null) {
      this.field_transBrandWording = "";
    }
    if (this.eLy) {
      localContentValues.put("transBrandWording", this.field_transBrandWording);
    }
    if (this.field_bizClientMsgId == null) {
      this.field_bizClientMsgId = "";
    }
    if (this.eLc) {
      localContentValues.put("bizClientMsgId", this.field_bizClientMsgId);
    }
    if (this.eIp) {
      localContentValues.put("bizChatId", Long.valueOf(this.field_bizChatId));
    }
    if (this.field_bizChatUserId == null) {
      this.field_bizChatUserId = "";
    }
    if (this.eLz) {
      localContentValues.put("bizChatUserId", this.field_bizChatUserId);
    }
    if (this.eLA) {
      localContentValues.put("msgSeq", Long.valueOf(this.field_msgSeq));
    }
    if (this.eHV) {
      localContentValues.put("flag", Integer.valueOf(this.field_flag));
    }
    if (this.eLB) {
      localContentValues.put("fromUsername", this.field_fromUsername);
    }
    if (this.eLC) {
      localContentValues.put("toUsername", this.field_toUsername);
    }
    if (this.eKl) {
      localContentValues.put("extInfo", this.field_extInfo);
    }
    if (this.systemRowid > 0L) {
      localContentValues.put("rowid", Long.valueOf(this.systemRowid));
    }
    return localContentValues;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.g.c.an
 * JD-Core Version:    0.7.0.1
 */