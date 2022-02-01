package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;

public abstract class af
  extends c
{
  public static final String[] INDEX_CREATE = new String[0];
  private static final int eDc;
  private static final int eEm;
  private static final int eHX = "flag".hashCode();
  private static final int eIE = "bizChatId".hashCode();
  private static final int eIF = "brandUserName".hashCode();
  private static final int eIG = "unReadCount".hashCode();
  private static final int eIH = "newUnReadCount".hashCode();
  private static final int eII = "lastMsgID".hashCode();
  private static final int eIJ = "lastMsgTime".hashCode();
  private static final int eIK;
  private static final int eIL;
  private static final int eIM;
  private static final int eIN;
  private static final int eIO;
  private static final int eIP;
  private static final int eIQ;
  private static final int eIR;
  private static final int eIS = "atAll".hashCode();
  private static final int rowid_HASHCODE = "rowid".hashCode();
  private boolean eCZ = true;
  private boolean eDP = true;
  private boolean eHV = true;
  private boolean eIA = true;
  private boolean eIB = true;
  private boolean eIC = true;
  private boolean eID = true;
  private boolean eIp = true;
  private boolean eIq = true;
  private boolean eIr = true;
  private boolean eIs = true;
  private boolean eIt = true;
  private boolean eIu = true;
  private boolean eIv = true;
  private boolean eIw = true;
  private boolean eIx = true;
  private boolean eIy = true;
  private boolean eIz = true;
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
  
  static
  {
    eEm = "content".hashCode();
    eIK = "digest".hashCode();
    eIL = "digestUser".hashCode();
    eIM = "atCount".hashCode();
    eIN = "editingMsg".hashCode();
    eIO = "chatType".hashCode();
    eDc = "status".hashCode();
    eIP = "isSend".hashCode();
    eIQ = "msgType".hashCode();
    eIR = "msgCount".hashCode();
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
      if (eIE != k) {
        break label65;
      }
      this.field_bizChatId = paramCursor.getLong(i);
      this.eIp = true;
    }
    for (;;)
    {
      i += 1;
      break label20;
      break;
      label65:
      if (eIF == k) {
        this.field_brandUserName = paramCursor.getString(i);
      } else if (eIG == k) {
        this.field_unReadCount = paramCursor.getInt(i);
      } else if (eIH == k) {
        this.field_newUnReadCount = paramCursor.getInt(i);
      } else if (eII == k) {
        this.field_lastMsgID = paramCursor.getLong(i);
      } else if (eIJ == k) {
        this.field_lastMsgTime = paramCursor.getLong(i);
      } else if (eEm == k) {
        this.field_content = paramCursor.getString(i);
      } else if (eIK == k) {
        this.field_digest = paramCursor.getString(i);
      } else if (eIL == k) {
        this.field_digestUser = paramCursor.getString(i);
      } else if (eIM == k) {
        this.field_atCount = paramCursor.getInt(i);
      } else if (eIN == k) {
        this.field_editingMsg = paramCursor.getString(i);
      } else if (eIO == k) {
        this.field_chatType = paramCursor.getInt(i);
      } else if (eDc == k) {
        this.field_status = paramCursor.getInt(i);
      } else if (eIP == k) {
        this.field_isSend = paramCursor.getInt(i);
      } else if (eIQ == k) {
        this.field_msgType = paramCursor.getString(i);
      } else if (eIR == k) {
        this.field_msgCount = paramCursor.getInt(i);
      } else if (eHX == k) {
        this.field_flag = paramCursor.getLong(i);
      } else if (eIS == k) {
        this.field_atAll = paramCursor.getInt(i);
      } else if (rowid_HASHCODE == k) {
        this.systemRowid = paramCursor.getLong(i);
      }
    }
  }
  
  public ContentValues convertTo()
  {
    ContentValues localContentValues = new ContentValues();
    if (this.eIp) {
      localContentValues.put("bizChatId", Long.valueOf(this.field_bizChatId));
    }
    if (this.eIq) {
      localContentValues.put("brandUserName", this.field_brandUserName);
    }
    if (this.eIr) {
      localContentValues.put("unReadCount", Integer.valueOf(this.field_unReadCount));
    }
    if (this.eIs) {
      localContentValues.put("newUnReadCount", Integer.valueOf(this.field_newUnReadCount));
    }
    if (this.eIt) {
      localContentValues.put("lastMsgID", Long.valueOf(this.field_lastMsgID));
    }
    if (this.eIu) {
      localContentValues.put("lastMsgTime", Long.valueOf(this.field_lastMsgTime));
    }
    if (this.eDP) {
      localContentValues.put("content", this.field_content);
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
    if (this.eIx) {
      localContentValues.put("atCount", Integer.valueOf(this.field_atCount));
    }
    if (this.eIy) {
      localContentValues.put("editingMsg", this.field_editingMsg);
    }
    if (this.eIz) {
      localContentValues.put("chatType", Integer.valueOf(this.field_chatType));
    }
    if (this.eCZ) {
      localContentValues.put("status", Integer.valueOf(this.field_status));
    }
    if (this.eIA) {
      localContentValues.put("isSend", Integer.valueOf(this.field_isSend));
    }
    if (this.field_msgType == null) {
      this.field_msgType = "";
    }
    if (this.eIB) {
      localContentValues.put("msgType", this.field_msgType);
    }
    if (this.eIC) {
      localContentValues.put("msgCount", Integer.valueOf(this.field_msgCount));
    }
    if (this.eHV) {
      localContentValues.put("flag", Long.valueOf(this.field_flag));
    }
    if (this.eID) {
      localContentValues.put("atAll", Integer.valueOf(this.field_atAll));
    }
    if (this.systemRowid > 0L) {
      localContentValues.put("rowid", Long.valueOf(this.systemRowid));
    }
    return localContentValues;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.g.c.af
 * JD-Core Version:    0.7.0.1
 */