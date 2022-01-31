package com.tencent.mm.h.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;

public abstract class z
  extends c
{
  public static final String[] cqY = new String[0];
  private static final int crh = "rowid".hashCode();
  private static final int crn;
  private static final int csD;
  private static final int cwS = "bizChatId".hashCode();
  private static final int cwT = "brandUserName".hashCode();
  private static final int cwU = "unReadCount".hashCode();
  private static final int cwV = "newUnReadCount".hashCode();
  private static final int cwW = "lastMsgID".hashCode();
  private static final int cwX = "lastMsgTime".hashCode();
  private static final int cwY;
  private static final int cwZ;
  private static final int cwe;
  private static final int cxa;
  private static final int cxb;
  private static final int cxc;
  private static final int cxd;
  private static final int cxe;
  private static final int cxf;
  private boolean crk = true;
  private boolean csf = true;
  private boolean cwE = true;
  private boolean cwF = true;
  private boolean cwG = true;
  private boolean cwH = true;
  private boolean cwI = true;
  private boolean cwJ = true;
  private boolean cwK = true;
  private boolean cwL = true;
  private boolean cwM = true;
  private boolean cwN = true;
  private boolean cwO = true;
  private boolean cwP = true;
  private boolean cwQ = true;
  private boolean cwR = true;
  private boolean cwc = true;
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
    csD = "content".hashCode();
    cwY = "digest".hashCode();
    cwZ = "digestUser".hashCode();
    cxa = "atCount".hashCode();
    cxb = "editingMsg".hashCode();
    cxc = "chatType".hashCode();
    crn = "status".hashCode();
    cxd = "isSend".hashCode();
    cxe = "msgType".hashCode();
    cxf = "msgCount".hashCode();
    cwe = "flag".hashCode();
  }
  
  public final void d(Cursor paramCursor)
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
      if (cwS != k) {
        break label65;
      }
      this.field_bizChatId = paramCursor.getLong(i);
      this.cwE = true;
    }
    for (;;)
    {
      i += 1;
      break label20;
      break;
      label65:
      if (cwT == k) {
        this.field_brandUserName = paramCursor.getString(i);
      } else if (cwU == k) {
        this.field_unReadCount = paramCursor.getInt(i);
      } else if (cwV == k) {
        this.field_newUnReadCount = paramCursor.getInt(i);
      } else if (cwW == k) {
        this.field_lastMsgID = paramCursor.getLong(i);
      } else if (cwX == k) {
        this.field_lastMsgTime = paramCursor.getLong(i);
      } else if (csD == k) {
        this.field_content = paramCursor.getString(i);
      } else if (cwY == k) {
        this.field_digest = paramCursor.getString(i);
      } else if (cwZ == k) {
        this.field_digestUser = paramCursor.getString(i);
      } else if (cxa == k) {
        this.field_atCount = paramCursor.getInt(i);
      } else if (cxb == k) {
        this.field_editingMsg = paramCursor.getString(i);
      } else if (cxc == k) {
        this.field_chatType = paramCursor.getInt(i);
      } else if (crn == k) {
        this.field_status = paramCursor.getInt(i);
      } else if (cxd == k) {
        this.field_isSend = paramCursor.getInt(i);
      } else if (cxe == k) {
        this.field_msgType = paramCursor.getString(i);
      } else if (cxf == k) {
        this.field_msgCount = paramCursor.getInt(i);
      } else if (cwe == k) {
        this.field_flag = paramCursor.getLong(i);
      } else if (crh == k) {
        this.ujK = paramCursor.getLong(i);
      }
    }
  }
  
  public final ContentValues vf()
  {
    ContentValues localContentValues = new ContentValues();
    if (this.cwE) {
      localContentValues.put("bizChatId", Long.valueOf(this.field_bizChatId));
    }
    if (this.cwF) {
      localContentValues.put("brandUserName", this.field_brandUserName);
    }
    if (this.cwG) {
      localContentValues.put("unReadCount", Integer.valueOf(this.field_unReadCount));
    }
    if (this.cwH) {
      localContentValues.put("newUnReadCount", Integer.valueOf(this.field_newUnReadCount));
    }
    if (this.cwI) {
      localContentValues.put("lastMsgID", Long.valueOf(this.field_lastMsgID));
    }
    if (this.cwJ) {
      localContentValues.put("lastMsgTime", Long.valueOf(this.field_lastMsgTime));
    }
    if (this.csf) {
      localContentValues.put("content", this.field_content);
    }
    if (this.field_digest == null) {
      this.field_digest = "";
    }
    if (this.cwK) {
      localContentValues.put("digest", this.field_digest);
    }
    if (this.field_digestUser == null) {
      this.field_digestUser = "";
    }
    if (this.cwL) {
      localContentValues.put("digestUser", this.field_digestUser);
    }
    if (this.cwM) {
      localContentValues.put("atCount", Integer.valueOf(this.field_atCount));
    }
    if (this.cwN) {
      localContentValues.put("editingMsg", this.field_editingMsg);
    }
    if (this.cwO) {
      localContentValues.put("chatType", Integer.valueOf(this.field_chatType));
    }
    if (this.crk) {
      localContentValues.put("status", Integer.valueOf(this.field_status));
    }
    if (this.cwP) {
      localContentValues.put("isSend", Integer.valueOf(this.field_isSend));
    }
    if (this.field_msgType == null) {
      this.field_msgType = "";
    }
    if (this.cwQ) {
      localContentValues.put("msgType", this.field_msgType);
    }
    if (this.cwR) {
      localContentValues.put("msgCount", Integer.valueOf(this.field_msgCount));
    }
    if (this.cwc) {
      localContentValues.put("flag", Long.valueOf(this.field_flag));
    }
    if (this.ujK > 0L) {
      localContentValues.put("rowid", Long.valueOf(this.ujK));
    }
    return localContentValues;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.h.c.z
 * JD-Core Version:    0.7.0.1
 */