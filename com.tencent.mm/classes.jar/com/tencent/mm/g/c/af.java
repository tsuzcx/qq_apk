package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;

public abstract class af
  extends c
{
  public static final String[] INDEX_CREATE = new String[0];
  private static final int ejR;
  private static final int elb;
  private static final int eoK = "flag".hashCode();
  private static final int epA;
  private static final int epB;
  private static final int epC;
  private static final int epD;
  private static final int epE;
  private static final int epF = "atAll".hashCode();
  private static final int epr = "bizChatId".hashCode();
  private static final int eps = "brandUserName".hashCode();
  private static final int ept = "unReadCount".hashCode();
  private static final int epu = "newUnReadCount".hashCode();
  private static final int epv = "lastMsgID".hashCode();
  private static final int epw = "lastMsgTime".hashCode();
  private static final int epx;
  private static final int epy;
  private static final int epz;
  private static final int rowid_HASHCODE = "rowid".hashCode();
  private boolean ejO = true;
  private boolean ekE = true;
  private boolean eoI = true;
  private boolean epc = true;
  private boolean epd = true;
  private boolean epe = true;
  private boolean epf = true;
  private boolean epg = true;
  private boolean eph = true;
  private boolean epi = true;
  private boolean epj = true;
  private boolean epk = true;
  private boolean epl = true;
  private boolean epm = true;
  private boolean epn = true;
  private boolean epo = true;
  private boolean epp = true;
  private boolean epq = true;
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
    elb = "content".hashCode();
    epx = "digest".hashCode();
    epy = "digestUser".hashCode();
    epz = "atCount".hashCode();
    epA = "editingMsg".hashCode();
    epB = "chatType".hashCode();
    ejR = "status".hashCode();
    epC = "isSend".hashCode();
    epD = "msgType".hashCode();
    epE = "msgCount".hashCode();
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
      if (epr != k) {
        break label65;
      }
      this.field_bizChatId = paramCursor.getLong(i);
      this.epc = true;
    }
    for (;;)
    {
      i += 1;
      break label20;
      break;
      label65:
      if (eps == k) {
        this.field_brandUserName = paramCursor.getString(i);
      } else if (ept == k) {
        this.field_unReadCount = paramCursor.getInt(i);
      } else if (epu == k) {
        this.field_newUnReadCount = paramCursor.getInt(i);
      } else if (epv == k) {
        this.field_lastMsgID = paramCursor.getLong(i);
      } else if (epw == k) {
        this.field_lastMsgTime = paramCursor.getLong(i);
      } else if (elb == k) {
        this.field_content = paramCursor.getString(i);
      } else if (epx == k) {
        this.field_digest = paramCursor.getString(i);
      } else if (epy == k) {
        this.field_digestUser = paramCursor.getString(i);
      } else if (epz == k) {
        this.field_atCount = paramCursor.getInt(i);
      } else if (epA == k) {
        this.field_editingMsg = paramCursor.getString(i);
      } else if (epB == k) {
        this.field_chatType = paramCursor.getInt(i);
      } else if (ejR == k) {
        this.field_status = paramCursor.getInt(i);
      } else if (epC == k) {
        this.field_isSend = paramCursor.getInt(i);
      } else if (epD == k) {
        this.field_msgType = paramCursor.getString(i);
      } else if (epE == k) {
        this.field_msgCount = paramCursor.getInt(i);
      } else if (eoK == k) {
        this.field_flag = paramCursor.getLong(i);
      } else if (epF == k) {
        this.field_atAll = paramCursor.getInt(i);
      } else if (rowid_HASHCODE == k) {
        this.systemRowid = paramCursor.getLong(i);
      }
    }
  }
  
  public ContentValues convertTo()
  {
    ContentValues localContentValues = new ContentValues();
    if (this.epc) {
      localContentValues.put("bizChatId", Long.valueOf(this.field_bizChatId));
    }
    if (this.epd) {
      localContentValues.put("brandUserName", this.field_brandUserName);
    }
    if (this.epe) {
      localContentValues.put("unReadCount", Integer.valueOf(this.field_unReadCount));
    }
    if (this.epf) {
      localContentValues.put("newUnReadCount", Integer.valueOf(this.field_newUnReadCount));
    }
    if (this.epg) {
      localContentValues.put("lastMsgID", Long.valueOf(this.field_lastMsgID));
    }
    if (this.eph) {
      localContentValues.put("lastMsgTime", Long.valueOf(this.field_lastMsgTime));
    }
    if (this.ekE) {
      localContentValues.put("content", this.field_content);
    }
    if (this.field_digest == null) {
      this.field_digest = "";
    }
    if (this.epi) {
      localContentValues.put("digest", this.field_digest);
    }
    if (this.field_digestUser == null) {
      this.field_digestUser = "";
    }
    if (this.epj) {
      localContentValues.put("digestUser", this.field_digestUser);
    }
    if (this.epk) {
      localContentValues.put("atCount", Integer.valueOf(this.field_atCount));
    }
    if (this.epl) {
      localContentValues.put("editingMsg", this.field_editingMsg);
    }
    if (this.epm) {
      localContentValues.put("chatType", Integer.valueOf(this.field_chatType));
    }
    if (this.ejO) {
      localContentValues.put("status", Integer.valueOf(this.field_status));
    }
    if (this.epn) {
      localContentValues.put("isSend", Integer.valueOf(this.field_isSend));
    }
    if (this.field_msgType == null) {
      this.field_msgType = "";
    }
    if (this.epo) {
      localContentValues.put("msgType", this.field_msgType);
    }
    if (this.epp) {
      localContentValues.put("msgCount", Integer.valueOf(this.field_msgCount));
    }
    if (this.eoI) {
      localContentValues.put("flag", Long.valueOf(this.field_flag));
    }
    if (this.epq) {
      localContentValues.put("atAll", Integer.valueOf(this.field_atAll));
    }
    if (this.systemRowid > 0L) {
      localContentValues.put("rowid", Long.valueOf(this.systemRowid));
    }
    return localContentValues;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.g.c.af
 * JD-Core Version:    0.7.0.1
 */