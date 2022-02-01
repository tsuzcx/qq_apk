package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.storage.IAutoDBItem;

public abstract class ag
  extends IAutoDBItem
{
  public static final String[] INDEX_CREATE = new String[0];
  private static final int content_HASHCODE;
  private static final int fjl;
  private static final int fnT = "bizChatId".hashCode();
  private static final int fnU = "brandUserName".hashCode();
  private static final int fnV = "unReadCount".hashCode();
  private static final int fnW = "newUnReadCount".hashCode();
  private static final int fnX = "lastMsgID".hashCode();
  private static final int fnY = "lastMsgTime".hashCode();
  private static final int fnZ;
  private static final int fni = "flag".hashCode();
  private static final int foa;
  private static final int fob;
  private static final int foc;
  private static final int fod;
  private static final int foe;
  private static final int fof;
  private static final int fog;
  private static final int foh = "atAll".hashCode();
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
  private boolean fji = true;
  private boolean fnE = true;
  private boolean fnF = true;
  private boolean fnG = true;
  private boolean fnH = true;
  private boolean fnI = true;
  private boolean fnJ = true;
  private boolean fnK = true;
  private boolean fnL = true;
  private boolean fnM = true;
  private boolean fnN = true;
  private boolean fnO = true;
  private boolean fnP = true;
  private boolean fnQ = true;
  private boolean fnR = true;
  private boolean fnS = true;
  private boolean fng = true;
  
  static
  {
    content_HASHCODE = "content".hashCode();
    fnZ = "digest".hashCode();
    foa = "digestUser".hashCode();
    fob = "atCount".hashCode();
    foc = "editingMsg".hashCode();
    fod = "chatType".hashCode();
    fjl = "status".hashCode();
    foe = "isSend".hashCode();
    fof = "msgType".hashCode();
    fog = "msgCount".hashCode();
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
      if (fnT != k) {
        break label65;
      }
      this.field_bizChatId = paramCursor.getLong(i);
      this.fnE = true;
    }
    for (;;)
    {
      i += 1;
      break label20;
      break;
      label65:
      if (fnU == k) {
        this.field_brandUserName = paramCursor.getString(i);
      } else if (fnV == k) {
        this.field_unReadCount = paramCursor.getInt(i);
      } else if (fnW == k) {
        this.field_newUnReadCount = paramCursor.getInt(i);
      } else if (fnX == k) {
        this.field_lastMsgID = paramCursor.getLong(i);
      } else if (fnY == k) {
        this.field_lastMsgTime = paramCursor.getLong(i);
      } else if (content_HASHCODE == k) {
        this.field_content = paramCursor.getString(i);
      } else if (fnZ == k) {
        this.field_digest = paramCursor.getString(i);
      } else if (foa == k) {
        this.field_digestUser = paramCursor.getString(i);
      } else if (fob == k) {
        this.field_atCount = paramCursor.getInt(i);
      } else if (foc == k) {
        this.field_editingMsg = paramCursor.getString(i);
      } else if (fod == k) {
        this.field_chatType = paramCursor.getInt(i);
      } else if (fjl == k) {
        this.field_status = paramCursor.getInt(i);
      } else if (foe == k) {
        this.field_isSend = paramCursor.getInt(i);
      } else if (fof == k) {
        this.field_msgType = paramCursor.getString(i);
      } else if (fog == k) {
        this.field_msgCount = paramCursor.getInt(i);
      } else if (fni == k) {
        this.field_flag = paramCursor.getLong(i);
      } else if (foh == k) {
        this.field_atAll = paramCursor.getInt(i);
      } else if (rowid_HASHCODE == k) {
        this.systemRowid = paramCursor.getLong(i);
      }
    }
  }
  
  public ContentValues convertTo()
  {
    ContentValues localContentValues = new ContentValues();
    if (this.fnE) {
      localContentValues.put("bizChatId", Long.valueOf(this.field_bizChatId));
    }
    if (this.fnF) {
      localContentValues.put("brandUserName", this.field_brandUserName);
    }
    if (this.fnG) {
      localContentValues.put("unReadCount", Integer.valueOf(this.field_unReadCount));
    }
    if (this.fnH) {
      localContentValues.put("newUnReadCount", Integer.valueOf(this.field_newUnReadCount));
    }
    if (this.fnI) {
      localContentValues.put("lastMsgID", Long.valueOf(this.field_lastMsgID));
    }
    if (this.fnJ) {
      localContentValues.put("lastMsgTime", Long.valueOf(this.field_lastMsgTime));
    }
    if (this.__hadSetcontent) {
      localContentValues.put("content", this.field_content);
    }
    if (this.field_digest == null) {
      this.field_digest = "";
    }
    if (this.fnK) {
      localContentValues.put("digest", this.field_digest);
    }
    if (this.field_digestUser == null) {
      this.field_digestUser = "";
    }
    if (this.fnL) {
      localContentValues.put("digestUser", this.field_digestUser);
    }
    if (this.fnM) {
      localContentValues.put("atCount", Integer.valueOf(this.field_atCount));
    }
    if (this.fnN) {
      localContentValues.put("editingMsg", this.field_editingMsg);
    }
    if (this.fnO) {
      localContentValues.put("chatType", Integer.valueOf(this.field_chatType));
    }
    if (this.fji) {
      localContentValues.put("status", Integer.valueOf(this.field_status));
    }
    if (this.fnP) {
      localContentValues.put("isSend", Integer.valueOf(this.field_isSend));
    }
    if (this.field_msgType == null) {
      this.field_msgType = "";
    }
    if (this.fnQ) {
      localContentValues.put("msgType", this.field_msgType);
    }
    if (this.fnR) {
      localContentValues.put("msgCount", Integer.valueOf(this.field_msgCount));
    }
    if (this.fng) {
      localContentValues.put("flag", Long.valueOf(this.field_flag));
    }
    if (this.fnS) {
      localContentValues.put("atAll", Integer.valueOf(this.field_atAll));
    }
    if (this.systemRowid > 0L) {
      localContentValues.put("rowid", Long.valueOf(this.systemRowid));
    }
    return localContentValues;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.g.c.ag
 * JD-Core Version:    0.7.0.1
 */