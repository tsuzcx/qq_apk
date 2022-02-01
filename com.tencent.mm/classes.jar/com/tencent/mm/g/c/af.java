package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;

public abstract class af
  extends c
{
  public static final String[] INDEX_CREATE = new String[0];
  private static final int elV;
  private static final int eng;
  private static final int eqO = "flag".hashCode();
  private static final int erA;
  private static final int erB;
  private static final int erC;
  private static final int erD;
  private static final int erE;
  private static final int erF;
  private static final int erG;
  private static final int erH;
  private static final int erI;
  private static final int erJ = "atAll".hashCode();
  private static final int erv = "bizChatId".hashCode();
  private static final int erw = "brandUserName".hashCode();
  private static final int erx = "unReadCount".hashCode();
  private static final int ery = "newUnReadCount".hashCode();
  private static final int erz = "lastMsgID".hashCode();
  private static final int rowid_HASHCODE = "rowid".hashCode();
  private boolean elS = true;
  private boolean emI = true;
  private boolean eqM = true;
  private boolean erg = true;
  private boolean erh = true;
  private boolean eri = true;
  private boolean erj = true;
  private boolean erk = true;
  private boolean erl = true;
  private boolean erm = true;
  private boolean ern = true;
  private boolean ero = true;
  private boolean erp = true;
  private boolean erq = true;
  private boolean err = true;
  private boolean ers = true;
  private boolean ert = true;
  private boolean eru = true;
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
    erA = "lastMsgTime".hashCode();
    eng = "content".hashCode();
    erB = "digest".hashCode();
    erC = "digestUser".hashCode();
    erD = "atCount".hashCode();
    erE = "editingMsg".hashCode();
    erF = "chatType".hashCode();
    elV = "status".hashCode();
    erG = "isSend".hashCode();
    erH = "msgType".hashCode();
    erI = "msgCount".hashCode();
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
      if (erv != k) {
        break label65;
      }
      this.field_bizChatId = paramCursor.getLong(i);
      this.erg = true;
    }
    for (;;)
    {
      i += 1;
      break label20;
      break;
      label65:
      if (erw == k) {
        this.field_brandUserName = paramCursor.getString(i);
      } else if (erx == k) {
        this.field_unReadCount = paramCursor.getInt(i);
      } else if (ery == k) {
        this.field_newUnReadCount = paramCursor.getInt(i);
      } else if (erz == k) {
        this.field_lastMsgID = paramCursor.getLong(i);
      } else if (erA == k) {
        this.field_lastMsgTime = paramCursor.getLong(i);
      } else if (eng == k) {
        this.field_content = paramCursor.getString(i);
      } else if (erB == k) {
        this.field_digest = paramCursor.getString(i);
      } else if (erC == k) {
        this.field_digestUser = paramCursor.getString(i);
      } else if (erD == k) {
        this.field_atCount = paramCursor.getInt(i);
      } else if (erE == k) {
        this.field_editingMsg = paramCursor.getString(i);
      } else if (erF == k) {
        this.field_chatType = paramCursor.getInt(i);
      } else if (elV == k) {
        this.field_status = paramCursor.getInt(i);
      } else if (erG == k) {
        this.field_isSend = paramCursor.getInt(i);
      } else if (erH == k) {
        this.field_msgType = paramCursor.getString(i);
      } else if (erI == k) {
        this.field_msgCount = paramCursor.getInt(i);
      } else if (eqO == k) {
        this.field_flag = paramCursor.getLong(i);
      } else if (erJ == k) {
        this.field_atAll = paramCursor.getInt(i);
      } else if (rowid_HASHCODE == k) {
        this.systemRowid = paramCursor.getLong(i);
      }
    }
  }
  
  public ContentValues convertTo()
  {
    ContentValues localContentValues = new ContentValues();
    if (this.erg) {
      localContentValues.put("bizChatId", Long.valueOf(this.field_bizChatId));
    }
    if (this.erh) {
      localContentValues.put("brandUserName", this.field_brandUserName);
    }
    if (this.eri) {
      localContentValues.put("unReadCount", Integer.valueOf(this.field_unReadCount));
    }
    if (this.erj) {
      localContentValues.put("newUnReadCount", Integer.valueOf(this.field_newUnReadCount));
    }
    if (this.erk) {
      localContentValues.put("lastMsgID", Long.valueOf(this.field_lastMsgID));
    }
    if (this.erl) {
      localContentValues.put("lastMsgTime", Long.valueOf(this.field_lastMsgTime));
    }
    if (this.emI) {
      localContentValues.put("content", this.field_content);
    }
    if (this.field_digest == null) {
      this.field_digest = "";
    }
    if (this.erm) {
      localContentValues.put("digest", this.field_digest);
    }
    if (this.field_digestUser == null) {
      this.field_digestUser = "";
    }
    if (this.ern) {
      localContentValues.put("digestUser", this.field_digestUser);
    }
    if (this.ero) {
      localContentValues.put("atCount", Integer.valueOf(this.field_atCount));
    }
    if (this.erp) {
      localContentValues.put("editingMsg", this.field_editingMsg);
    }
    if (this.erq) {
      localContentValues.put("chatType", Integer.valueOf(this.field_chatType));
    }
    if (this.elS) {
      localContentValues.put("status", Integer.valueOf(this.field_status));
    }
    if (this.err) {
      localContentValues.put("isSend", Integer.valueOf(this.field_isSend));
    }
    if (this.field_msgType == null) {
      this.field_msgType = "";
    }
    if (this.ers) {
      localContentValues.put("msgType", this.field_msgType);
    }
    if (this.ert) {
      localContentValues.put("msgCount", Integer.valueOf(this.field_msgCount));
    }
    if (this.eqM) {
      localContentValues.put("flag", Long.valueOf(this.field_flag));
    }
    if (this.eru) {
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