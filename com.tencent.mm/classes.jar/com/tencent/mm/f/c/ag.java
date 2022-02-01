package com.tencent.mm.f.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.storage.IAutoDBItem;
import com.tencent.mm.sdk.storage.sql.Column;
import com.tencent.mm.sdk.storage.sql.SingleTable;

public abstract class ag
  extends IAutoDBItem
{
  public static final Column C_CONTENT;
  public static final Column C_ROWID;
  public static final String[] INDEX_CREATE = new String[0];
  public static final SingleTable TABLE = new SingleTable("BizChatConversation");
  private static final int content_HASHCODE;
  private static final int hmC;
  public static final Column hmw;
  public static final Column hsS;
  public static final Column hsT;
  public static final Column hsU;
  public static final Column hsV;
  public static final Column hsW;
  public static final Column hsX;
  public static final Column hsY;
  public static final Column hsZ;
  public static final Column hsi;
  private static final int hsm = "flag".hashCode();
  private static final int htA;
  private static final int htB;
  private static final int htC;
  private static final int htD;
  private static final int htE;
  private static final int htF;
  private static final int htG;
  private static final int htH;
  private static final int htI;
  private static final int htJ;
  private static final int htK = "atAll".hashCode();
  public static final Column hta;
  public static final Column htb;
  public static final Column htc;
  public static final Column htd;
  public static final Column hte;
  public static final Column htf;
  public static final Column htg;
  private static final int htw;
  private static final int htx;
  private static final int hty;
  private static final int htz;
  private static final int rowid_HASHCODE = "rowid".hashCode();
  private boolean __hadSetcontent = true;
  public int field_atAll;
  public int field_atCount;
  public long field_bizChatId;
  public String field_brandUserName;
  public int field_chatType;
  public String field_content;
  public String field_digest;
  public String field_digestUser;
  public String field_editingMsg;
  public long field_flag;
  public int field_isSend;
  public long field_lastMsgID;
  public long field_lastMsgTime;
  public int field_msgCount;
  public String field_msgType;
  public int field_newUnReadCount;
  public int field_status;
  public int field_unReadCount;
  private boolean hmz = true;
  private boolean hsk = true;
  private boolean hth = true;
  private boolean hti = true;
  private boolean htj = true;
  private boolean htk = true;
  private boolean htl = true;
  private boolean htm = true;
  private boolean htn = true;
  private boolean hto = true;
  private boolean htp = true;
  private boolean htq = true;
  private boolean htr = true;
  private boolean hts = true;
  private boolean htt = true;
  private boolean htu = true;
  private boolean htv = true;
  
  static
  {
    C_ROWID = new Column("rowid", "long", "BizChatConversation", "");
    hsS = new Column("bizchatid", "long", "BizChatConversation", "");
    hsT = new Column("brandusername", "string", "BizChatConversation", "");
    hsU = new Column("unreadcount", "int", "BizChatConversation", "");
    hsV = new Column("newunreadcount", "int", "BizChatConversation", "");
    hsW = new Column("lastmsgid", "long", "BizChatConversation", "");
    hsX = new Column("lastmsgtime", "long", "BizChatConversation", "");
    C_CONTENT = new Column("content", "string", "BizChatConversation", "");
    hsY = new Column("digest", "string", "BizChatConversation", "");
    hsZ = new Column("digestuser", "string", "BizChatConversation", "");
    hta = new Column("atcount", "int", "BizChatConversation", "");
    htb = new Column("editingmsg", "string", "BizChatConversation", "");
    htc = new Column("chattype", "int", "BizChatConversation", "");
    hmw = new Column("status", "int", "BizChatConversation", "");
    htd = new Column("issend", "int", "BizChatConversation", "");
    hte = new Column("msgtype", "string", "BizChatConversation", "");
    htf = new Column("msgcount", "int", "BizChatConversation", "");
    hsi = new Column("flag", "long", "BizChatConversation", "");
    htg = new Column("atall", "int", "BizChatConversation", "");
    htw = "bizChatId".hashCode();
    htx = "brandUserName".hashCode();
    hty = "unReadCount".hashCode();
    htz = "newUnReadCount".hashCode();
    htA = "lastMsgID".hashCode();
    htB = "lastMsgTime".hashCode();
    content_HASHCODE = "content".hashCode();
    htC = "digest".hashCode();
    htD = "digestUser".hashCode();
    htE = "atCount".hashCode();
    htF = "editingMsg".hashCode();
    htG = "chatType".hashCode();
    hmC = "status".hashCode();
    htH = "isSend".hashCode();
    htI = "msgType".hashCode();
    htJ = "msgCount".hashCode();
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
      if (htw != k) {
        break label65;
      }
      this.field_bizChatId = paramCursor.getLong(i);
      this.hth = true;
    }
    for (;;)
    {
      i += 1;
      break label20;
      break;
      label65:
      if (htx == k) {
        this.field_brandUserName = paramCursor.getString(i);
      } else if (hty == k) {
        this.field_unReadCount = paramCursor.getInt(i);
      } else if (htz == k) {
        this.field_newUnReadCount = paramCursor.getInt(i);
      } else if (htA == k) {
        this.field_lastMsgID = paramCursor.getLong(i);
      } else if (htB == k) {
        this.field_lastMsgTime = paramCursor.getLong(i);
      } else if (content_HASHCODE == k) {
        this.field_content = paramCursor.getString(i);
      } else if (htC == k) {
        this.field_digest = paramCursor.getString(i);
      } else if (htD == k) {
        this.field_digestUser = paramCursor.getString(i);
      } else if (htE == k) {
        this.field_atCount = paramCursor.getInt(i);
      } else if (htF == k) {
        this.field_editingMsg = paramCursor.getString(i);
      } else if (htG == k) {
        this.field_chatType = paramCursor.getInt(i);
      } else if (hmC == k) {
        this.field_status = paramCursor.getInt(i);
      } else if (htH == k) {
        this.field_isSend = paramCursor.getInt(i);
      } else if (htI == k) {
        this.field_msgType = paramCursor.getString(i);
      } else if (htJ == k) {
        this.field_msgCount = paramCursor.getInt(i);
      } else if (hsm == k) {
        this.field_flag = paramCursor.getLong(i);
      } else if (htK == k) {
        this.field_atAll = paramCursor.getInt(i);
      } else if (rowid_HASHCODE == k) {
        this.systemRowid = paramCursor.getLong(i);
      }
    }
  }
  
  public ContentValues convertTo()
  {
    ContentValues localContentValues = new ContentValues();
    if (this.hth) {
      localContentValues.put("bizChatId", Long.valueOf(this.field_bizChatId));
    }
    if (this.hti) {
      localContentValues.put("brandUserName", this.field_brandUserName);
    }
    if (this.htj) {
      localContentValues.put("unReadCount", Integer.valueOf(this.field_unReadCount));
    }
    if (this.htk) {
      localContentValues.put("newUnReadCount", Integer.valueOf(this.field_newUnReadCount));
    }
    if (this.htl) {
      localContentValues.put("lastMsgID", Long.valueOf(this.field_lastMsgID));
    }
    if (this.htm) {
      localContentValues.put("lastMsgTime", Long.valueOf(this.field_lastMsgTime));
    }
    if (this.__hadSetcontent) {
      localContentValues.put("content", this.field_content);
    }
    if (this.field_digest == null) {
      this.field_digest = "";
    }
    if (this.htn) {
      localContentValues.put("digest", this.field_digest);
    }
    if (this.field_digestUser == null) {
      this.field_digestUser = "";
    }
    if (this.hto) {
      localContentValues.put("digestUser", this.field_digestUser);
    }
    if (this.htp) {
      localContentValues.put("atCount", Integer.valueOf(this.field_atCount));
    }
    if (this.htq) {
      localContentValues.put("editingMsg", this.field_editingMsg);
    }
    if (this.htr) {
      localContentValues.put("chatType", Integer.valueOf(this.field_chatType));
    }
    if (this.hmz) {
      localContentValues.put("status", Integer.valueOf(this.field_status));
    }
    if (this.hts) {
      localContentValues.put("isSend", Integer.valueOf(this.field_isSend));
    }
    if (this.field_msgType == null) {
      this.field_msgType = "";
    }
    if (this.htt) {
      localContentValues.put("msgType", this.field_msgType);
    }
    if (this.htu) {
      localContentValues.put("msgCount", Integer.valueOf(this.field_msgCount));
    }
    if (this.hsk) {
      localContentValues.put("flag", Long.valueOf(this.field_flag));
    }
    if (this.htv) {
      localContentValues.put("atAll", Integer.valueOf(this.field_atAll));
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
    return "BizChatConversation";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.f.c.ag
 * JD-Core Version:    0.7.0.1
 */