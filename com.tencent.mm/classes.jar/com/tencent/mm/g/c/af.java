package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;

public abstract class af
  extends c
{
  public static final String[] INDEX_CREATE = new String[0];
  private static final int eEL;
  private static final int eFV;
  private static final int eJG = "flag".hashCode();
  private static final int eKA;
  private static final int eKB = "atAll".hashCode();
  private static final int eKn = "bizChatId".hashCode();
  private static final int eKo = "brandUserName".hashCode();
  private static final int eKp = "unReadCount".hashCode();
  private static final int eKq = "newUnReadCount".hashCode();
  private static final int eKr = "lastMsgID".hashCode();
  private static final int eKs = "lastMsgTime".hashCode();
  private static final int eKt;
  private static final int eKu;
  private static final int eKv;
  private static final int eKw;
  private static final int eKx;
  private static final int eKy;
  private static final int eKz;
  private static final int rowid_HASHCODE = "rowid".hashCode();
  private boolean eEI = true;
  private boolean eFy = true;
  private boolean eJE = true;
  private boolean eJY = true;
  private boolean eJZ = true;
  private boolean eKa = true;
  private boolean eKb = true;
  private boolean eKc = true;
  private boolean eKd = true;
  private boolean eKe = true;
  private boolean eKf = true;
  private boolean eKg = true;
  private boolean eKh = true;
  private boolean eKi = true;
  private boolean eKj = true;
  private boolean eKk = true;
  private boolean eKl = true;
  private boolean eKm = true;
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
    eFV = "content".hashCode();
    eKt = "digest".hashCode();
    eKu = "digestUser".hashCode();
    eKv = "atCount".hashCode();
    eKw = "editingMsg".hashCode();
    eKx = "chatType".hashCode();
    eEL = "status".hashCode();
    eKy = "isSend".hashCode();
    eKz = "msgType".hashCode();
    eKA = "msgCount".hashCode();
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
      if (eKn != k) {
        break label65;
      }
      this.field_bizChatId = paramCursor.getLong(i);
      this.eJY = true;
    }
    for (;;)
    {
      i += 1;
      break label20;
      break;
      label65:
      if (eKo == k) {
        this.field_brandUserName = paramCursor.getString(i);
      } else if (eKp == k) {
        this.field_unReadCount = paramCursor.getInt(i);
      } else if (eKq == k) {
        this.field_newUnReadCount = paramCursor.getInt(i);
      } else if (eKr == k) {
        this.field_lastMsgID = paramCursor.getLong(i);
      } else if (eKs == k) {
        this.field_lastMsgTime = paramCursor.getLong(i);
      } else if (eFV == k) {
        this.field_content = paramCursor.getString(i);
      } else if (eKt == k) {
        this.field_digest = paramCursor.getString(i);
      } else if (eKu == k) {
        this.field_digestUser = paramCursor.getString(i);
      } else if (eKv == k) {
        this.field_atCount = paramCursor.getInt(i);
      } else if (eKw == k) {
        this.field_editingMsg = paramCursor.getString(i);
      } else if (eKx == k) {
        this.field_chatType = paramCursor.getInt(i);
      } else if (eEL == k) {
        this.field_status = paramCursor.getInt(i);
      } else if (eKy == k) {
        this.field_isSend = paramCursor.getInt(i);
      } else if (eKz == k) {
        this.field_msgType = paramCursor.getString(i);
      } else if (eKA == k) {
        this.field_msgCount = paramCursor.getInt(i);
      } else if (eJG == k) {
        this.field_flag = paramCursor.getLong(i);
      } else if (eKB == k) {
        this.field_atAll = paramCursor.getInt(i);
      } else if (rowid_HASHCODE == k) {
        this.systemRowid = paramCursor.getLong(i);
      }
    }
  }
  
  public ContentValues convertTo()
  {
    ContentValues localContentValues = new ContentValues();
    if (this.eJY) {
      localContentValues.put("bizChatId", Long.valueOf(this.field_bizChatId));
    }
    if (this.eJZ) {
      localContentValues.put("brandUserName", this.field_brandUserName);
    }
    if (this.eKa) {
      localContentValues.put("unReadCount", Integer.valueOf(this.field_unReadCount));
    }
    if (this.eKb) {
      localContentValues.put("newUnReadCount", Integer.valueOf(this.field_newUnReadCount));
    }
    if (this.eKc) {
      localContentValues.put("lastMsgID", Long.valueOf(this.field_lastMsgID));
    }
    if (this.eKd) {
      localContentValues.put("lastMsgTime", Long.valueOf(this.field_lastMsgTime));
    }
    if (this.eFy) {
      localContentValues.put("content", this.field_content);
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
    if (this.eKg) {
      localContentValues.put("atCount", Integer.valueOf(this.field_atCount));
    }
    if (this.eKh) {
      localContentValues.put("editingMsg", this.field_editingMsg);
    }
    if (this.eKi) {
      localContentValues.put("chatType", Integer.valueOf(this.field_chatType));
    }
    if (this.eEI) {
      localContentValues.put("status", Integer.valueOf(this.field_status));
    }
    if (this.eKj) {
      localContentValues.put("isSend", Integer.valueOf(this.field_isSend));
    }
    if (this.field_msgType == null) {
      this.field_msgType = "";
    }
    if (this.eKk) {
      localContentValues.put("msgType", this.field_msgType);
    }
    if (this.eKl) {
      localContentValues.put("msgCount", Integer.valueOf(this.field_msgCount));
    }
    if (this.eJE) {
      localContentValues.put("flag", Long.valueOf(this.field_flag));
    }
    if (this.eKm) {
      localContentValues.put("atAll", Integer.valueOf(this.field_atAll));
    }
    if (this.systemRowid > 0L) {
      localContentValues.put("rowid", Long.valueOf(this.systemRowid));
    }
    return localContentValues;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.g.c.af
 * JD-Core Version:    0.7.0.1
 */