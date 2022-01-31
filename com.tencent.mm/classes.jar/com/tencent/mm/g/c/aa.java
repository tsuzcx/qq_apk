package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;

public abstract class aa
  extends c
{
  public static final String[] INDEX_CREATE = new String[0];
  private static final int dfJ;
  private static final int dgT;
  private static final int dkT = "bizChatId".hashCode();
  private static final int dkU = "brandUserName".hashCode();
  private static final int dkV = "unReadCount".hashCode();
  private static final int dkW = "newUnReadCount".hashCode();
  private static final int dkX = "lastMsgID".hashCode();
  private static final int dkY = "lastMsgTime".hashCode();
  private static final int dkZ;
  private static final int dkn = "flag".hashCode();
  private static final int dla;
  private static final int dlb;
  private static final int dlc;
  private static final int dld;
  private static final int dle;
  private static final int dlf;
  private static final int dlg;
  private static final int rowid_HASHCODE = "rowid".hashCode();
  private boolean dfG = true;
  private boolean dgw = true;
  private boolean dkF = true;
  private boolean dkG = true;
  private boolean dkH = true;
  private boolean dkI = true;
  private boolean dkJ = true;
  private boolean dkK = true;
  private boolean dkL = true;
  private boolean dkM = true;
  private boolean dkN = true;
  private boolean dkO = true;
  private boolean dkP = true;
  private boolean dkQ = true;
  private boolean dkR = true;
  private boolean dkS = true;
  private boolean dkl = true;
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
    dgT = "content".hashCode();
    dkZ = "digest".hashCode();
    dla = "digestUser".hashCode();
    dlb = "atCount".hashCode();
    dlc = "editingMsg".hashCode();
    dld = "chatType".hashCode();
    dfJ = "status".hashCode();
    dle = "isSend".hashCode();
    dlf = "msgType".hashCode();
    dlg = "msgCount".hashCode();
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
      if (dkT != k) {
        break label65;
      }
      this.field_bizChatId = paramCursor.getLong(i);
      this.dkF = true;
    }
    for (;;)
    {
      i += 1;
      break label20;
      break;
      label65:
      if (dkU == k) {
        this.field_brandUserName = paramCursor.getString(i);
      } else if (dkV == k) {
        this.field_unReadCount = paramCursor.getInt(i);
      } else if (dkW == k) {
        this.field_newUnReadCount = paramCursor.getInt(i);
      } else if (dkX == k) {
        this.field_lastMsgID = paramCursor.getLong(i);
      } else if (dkY == k) {
        this.field_lastMsgTime = paramCursor.getLong(i);
      } else if (dgT == k) {
        this.field_content = paramCursor.getString(i);
      } else if (dkZ == k) {
        this.field_digest = paramCursor.getString(i);
      } else if (dla == k) {
        this.field_digestUser = paramCursor.getString(i);
      } else if (dlb == k) {
        this.field_atCount = paramCursor.getInt(i);
      } else if (dlc == k) {
        this.field_editingMsg = paramCursor.getString(i);
      } else if (dld == k) {
        this.field_chatType = paramCursor.getInt(i);
      } else if (dfJ == k) {
        this.field_status = paramCursor.getInt(i);
      } else if (dle == k) {
        this.field_isSend = paramCursor.getInt(i);
      } else if (dlf == k) {
        this.field_msgType = paramCursor.getString(i);
      } else if (dlg == k) {
        this.field_msgCount = paramCursor.getInt(i);
      } else if (dkn == k) {
        this.field_flag = paramCursor.getLong(i);
      } else if (rowid_HASHCODE == k) {
        this.systemRowid = paramCursor.getLong(i);
      }
    }
  }
  
  public ContentValues convertTo()
  {
    ContentValues localContentValues = new ContentValues();
    if (this.dkF) {
      localContentValues.put("bizChatId", Long.valueOf(this.field_bizChatId));
    }
    if (this.dkG) {
      localContentValues.put("brandUserName", this.field_brandUserName);
    }
    if (this.dkH) {
      localContentValues.put("unReadCount", Integer.valueOf(this.field_unReadCount));
    }
    if (this.dkI) {
      localContentValues.put("newUnReadCount", Integer.valueOf(this.field_newUnReadCount));
    }
    if (this.dkJ) {
      localContentValues.put("lastMsgID", Long.valueOf(this.field_lastMsgID));
    }
    if (this.dkK) {
      localContentValues.put("lastMsgTime", Long.valueOf(this.field_lastMsgTime));
    }
    if (this.dgw) {
      localContentValues.put("content", this.field_content);
    }
    if (this.field_digest == null) {
      this.field_digest = "";
    }
    if (this.dkL) {
      localContentValues.put("digest", this.field_digest);
    }
    if (this.field_digestUser == null) {
      this.field_digestUser = "";
    }
    if (this.dkM) {
      localContentValues.put("digestUser", this.field_digestUser);
    }
    if (this.dkN) {
      localContentValues.put("atCount", Integer.valueOf(this.field_atCount));
    }
    if (this.dkO) {
      localContentValues.put("editingMsg", this.field_editingMsg);
    }
    if (this.dkP) {
      localContentValues.put("chatType", Integer.valueOf(this.field_chatType));
    }
    if (this.dfG) {
      localContentValues.put("status", Integer.valueOf(this.field_status));
    }
    if (this.dkQ) {
      localContentValues.put("isSend", Integer.valueOf(this.field_isSend));
    }
    if (this.field_msgType == null) {
      this.field_msgType = "";
    }
    if (this.dkR) {
      localContentValues.put("msgType", this.field_msgType);
    }
    if (this.dkS) {
      localContentValues.put("msgCount", Integer.valueOf(this.field_msgCount));
    }
    if (this.dkl) {
      localContentValues.put("flag", Long.valueOf(this.field_flag));
    }
    if (this.systemRowid > 0L) {
      localContentValues.put("rowid", Long.valueOf(this.systemRowid));
    }
    return localContentValues;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.g.c.aa
 * JD-Core Version:    0.7.0.1
 */