package com.tencent.mm.h.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;

public abstract class bi
  extends c
{
  private static final int cFG = "state".hashCode();
  private static final int cHa;
  private static final int cHb;
  private static final int cHc = "lastModifiedTime".hashCode();
  private static final int cHd = "isNew".hashCode();
  private static final int cHe = "addScene".hashCode();
  private static final int cHf = "fmsgSysRowId".hashCode();
  private static final int cHg = "fmsgIsSend".hashCode();
  private static final int cHh = "fmsgType".hashCode();
  private static final int cHi = "fmsgContent".hashCode();
  private static final int cHj = "recvFmsgType".hashCode();
  private static final int cHk = "contentFromUsername".hashCode();
  private static final int cHl = "contentNickname".hashCode();
  private static final int cHm = "contentPhoneNumMD5".hashCode();
  private static final int cHn = "contentFullPhoneNumMD5".hashCode();
  private static final int cHo = "contentVerifyContent".hashCode();
  public static final String[] cqY = { "CREATE INDEX IF NOT EXISTS fmconversation_isnew_Index ON fmessage_conversation(isNew)" };
  private static final int crh = "rowid".hashCode();
  private static final int czg = "talker".hashCode();
  private boolean cFd = true;
  private boolean cGL = true;
  private boolean cGM = true;
  private boolean cGN = true;
  private boolean cGO = true;
  private boolean cGP = true;
  private boolean cGQ = true;
  private boolean cGR = true;
  private boolean cGS = true;
  private boolean cGT = true;
  private boolean cGU = true;
  private boolean cGV = true;
  private boolean cGW = true;
  private boolean cGX = true;
  private boolean cGY = true;
  private boolean cGZ = true;
  private boolean cyV = true;
  public int field_addScene;
  public String field_contentFromUsername;
  public String field_contentFullPhoneNumMD5;
  public String field_contentNickname;
  public String field_contentPhoneNumMD5;
  public String field_contentVerifyContent;
  public String field_displayName;
  public String field_encryptTalker;
  public String field_fmsgContent;
  public int field_fmsgIsSend;
  public long field_fmsgSysRowId;
  public int field_fmsgType;
  public int field_isNew;
  public long field_lastModifiedTime;
  public int field_recvFmsgType;
  public int field_state;
  public String field_talker;
  
  static
  {
    cHa = "encryptTalker".hashCode();
    cHb = "displayName".hashCode();
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
      if (czg != k) {
        break label65;
      }
      this.field_talker = paramCursor.getString(i);
      this.cyV = true;
    }
    for (;;)
    {
      i += 1;
      break label20;
      break;
      label65:
      if (cHa == k) {
        this.field_encryptTalker = paramCursor.getString(i);
      } else if (cHb == k) {
        this.field_displayName = paramCursor.getString(i);
      } else if (cFG == k) {
        this.field_state = paramCursor.getInt(i);
      } else if (cHc == k) {
        this.field_lastModifiedTime = paramCursor.getLong(i);
      } else if (cHd == k) {
        this.field_isNew = paramCursor.getInt(i);
      } else if (cHe == k) {
        this.field_addScene = paramCursor.getInt(i);
      } else if (cHf == k) {
        this.field_fmsgSysRowId = paramCursor.getLong(i);
      } else if (cHg == k) {
        this.field_fmsgIsSend = paramCursor.getInt(i);
      } else if (cHh == k) {
        this.field_fmsgType = paramCursor.getInt(i);
      } else if (cHi == k) {
        this.field_fmsgContent = paramCursor.getString(i);
      } else if (cHj == k) {
        this.field_recvFmsgType = paramCursor.getInt(i);
      } else if (cHk == k) {
        this.field_contentFromUsername = paramCursor.getString(i);
      } else if (cHl == k) {
        this.field_contentNickname = paramCursor.getString(i);
      } else if (cHm == k) {
        this.field_contentPhoneNumMD5 = paramCursor.getString(i);
      } else if (cHn == k) {
        this.field_contentFullPhoneNumMD5 = paramCursor.getString(i);
      } else if (cHo == k) {
        this.field_contentVerifyContent = paramCursor.getString(i);
      } else if (crh == k) {
        this.ujK = paramCursor.getLong(i);
      }
    }
  }
  
  public final ContentValues vf()
  {
    ContentValues localContentValues = new ContentValues();
    if (this.field_talker == null) {
      this.field_talker = "0";
    }
    if (this.cyV) {
      localContentValues.put("talker", this.field_talker);
    }
    if (this.field_encryptTalker == null) {
      this.field_encryptTalker = "";
    }
    if (this.cGL) {
      localContentValues.put("encryptTalker", this.field_encryptTalker);
    }
    if (this.field_displayName == null) {
      this.field_displayName = "";
    }
    if (this.cGM) {
      localContentValues.put("displayName", this.field_displayName);
    }
    if (this.cFd) {
      localContentValues.put("state", Integer.valueOf(this.field_state));
    }
    if (this.cGN) {
      localContentValues.put("lastModifiedTime", Long.valueOf(this.field_lastModifiedTime));
    }
    if (this.cGO) {
      localContentValues.put("isNew", Integer.valueOf(this.field_isNew));
    }
    if (this.cGP) {
      localContentValues.put("addScene", Integer.valueOf(this.field_addScene));
    }
    if (this.cGQ) {
      localContentValues.put("fmsgSysRowId", Long.valueOf(this.field_fmsgSysRowId));
    }
    if (this.cGR) {
      localContentValues.put("fmsgIsSend", Integer.valueOf(this.field_fmsgIsSend));
    }
    if (this.cGS) {
      localContentValues.put("fmsgType", Integer.valueOf(this.field_fmsgType));
    }
    if (this.field_fmsgContent == null) {
      this.field_fmsgContent = "";
    }
    if (this.cGT) {
      localContentValues.put("fmsgContent", this.field_fmsgContent);
    }
    if (this.cGU) {
      localContentValues.put("recvFmsgType", Integer.valueOf(this.field_recvFmsgType));
    }
    if (this.field_contentFromUsername == null) {
      this.field_contentFromUsername = "";
    }
    if (this.cGV) {
      localContentValues.put("contentFromUsername", this.field_contentFromUsername);
    }
    if (this.field_contentNickname == null) {
      this.field_contentNickname = "";
    }
    if (this.cGW) {
      localContentValues.put("contentNickname", this.field_contentNickname);
    }
    if (this.field_contentPhoneNumMD5 == null) {
      this.field_contentPhoneNumMD5 = "";
    }
    if (this.cGX) {
      localContentValues.put("contentPhoneNumMD5", this.field_contentPhoneNumMD5);
    }
    if (this.field_contentFullPhoneNumMD5 == null) {
      this.field_contentFullPhoneNumMD5 = "";
    }
    if (this.cGY) {
      localContentValues.put("contentFullPhoneNumMD5", this.field_contentFullPhoneNumMD5);
    }
    if (this.field_contentVerifyContent == null) {
      this.field_contentVerifyContent = "";
    }
    if (this.cGZ) {
      localContentValues.put("contentVerifyContent", this.field_contentVerifyContent);
    }
    if (this.ujK > 0L) {
      localContentValues.put("rowid", Long.valueOf(this.ujK));
    }
    return localContentValues;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.h.c.bi
 * JD-Core Version:    0.7.0.1
 */