package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;

public abstract class bp
  extends c
{
  public static final String[] INDEX_CREATE = { "CREATE INDEX IF NOT EXISTS fmconversation_isnew_Index ON fmessage_conversation(isNew)" };
  private static final int eAI;
  private static final int eAJ;
  private static final int eAK = "lastModifiedTime".hashCode();
  private static final int eAL = "isNew".hashCode();
  private static final int eAM = "addScene".hashCode();
  private static final int eAN = "fmsgSysRowId".hashCode();
  private static final int eAO = "fmsgIsSend".hashCode();
  private static final int eAP = "fmsgType".hashCode();
  private static final int eAQ = "fmsgContent".hashCode();
  private static final int eAR = "recvFmsgType".hashCode();
  private static final int eAS = "contentFromUsername".hashCode();
  private static final int eAT = "contentNickname".hashCode();
  private static final int eAU = "contentPhoneNumMD5".hashCode();
  private static final int eAV = "contentFullPhoneNumMD5".hashCode();
  private static final int eAW = "contentVerifyContent".hashCode();
  private static final int erT = "talker".hashCode();
  private static final int ezb;
  private static final int rowid_HASHCODE = "rowid".hashCode();
  private boolean eAA = true;
  private boolean eAB = true;
  private boolean eAC = true;
  private boolean eAD = true;
  private boolean eAE = true;
  private boolean eAF = true;
  private boolean eAG = true;
  private boolean eAH = true;
  private boolean eAt = true;
  private boolean eAu = true;
  private boolean eAv = true;
  private boolean eAw = true;
  private boolean eAx = true;
  private boolean eAy = true;
  private boolean eAz = true;
  private boolean erF = true;
  private boolean eyp = true;
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
    eAI = "encryptTalker".hashCode();
    eAJ = "displayName".hashCode();
    ezb = "state".hashCode();
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
      if (erT != k) {
        break label65;
      }
      this.field_talker = paramCursor.getString(i);
      this.erF = true;
    }
    for (;;)
    {
      i += 1;
      break label20;
      break;
      label65:
      if (eAI == k) {
        this.field_encryptTalker = paramCursor.getString(i);
      } else if (eAJ == k) {
        this.field_displayName = paramCursor.getString(i);
      } else if (ezb == k) {
        this.field_state = paramCursor.getInt(i);
      } else if (eAK == k) {
        this.field_lastModifiedTime = paramCursor.getLong(i);
      } else if (eAL == k) {
        this.field_isNew = paramCursor.getInt(i);
      } else if (eAM == k) {
        this.field_addScene = paramCursor.getInt(i);
      } else if (eAN == k) {
        this.field_fmsgSysRowId = paramCursor.getLong(i);
      } else if (eAO == k) {
        this.field_fmsgIsSend = paramCursor.getInt(i);
      } else if (eAP == k) {
        this.field_fmsgType = paramCursor.getInt(i);
      } else if (eAQ == k) {
        this.field_fmsgContent = paramCursor.getString(i);
      } else if (eAR == k) {
        this.field_recvFmsgType = paramCursor.getInt(i);
      } else if (eAS == k) {
        this.field_contentFromUsername = paramCursor.getString(i);
      } else if (eAT == k) {
        this.field_contentNickname = paramCursor.getString(i);
      } else if (eAU == k) {
        this.field_contentPhoneNumMD5 = paramCursor.getString(i);
      } else if (eAV == k) {
        this.field_contentFullPhoneNumMD5 = paramCursor.getString(i);
      } else if (eAW == k) {
        this.field_contentVerifyContent = paramCursor.getString(i);
      } else if (rowid_HASHCODE == k) {
        this.systemRowid = paramCursor.getLong(i);
      }
    }
  }
  
  public ContentValues convertTo()
  {
    ContentValues localContentValues = new ContentValues();
    if (this.field_talker == null) {
      this.field_talker = "0";
    }
    if (this.erF) {
      localContentValues.put("talker", this.field_talker);
    }
    if (this.field_encryptTalker == null) {
      this.field_encryptTalker = "";
    }
    if (this.eAt) {
      localContentValues.put("encryptTalker", this.field_encryptTalker);
    }
    if (this.field_displayName == null) {
      this.field_displayName = "";
    }
    if (this.eAu) {
      localContentValues.put("displayName", this.field_displayName);
    }
    if (this.eyp) {
      localContentValues.put("state", Integer.valueOf(this.field_state));
    }
    if (this.eAv) {
      localContentValues.put("lastModifiedTime", Long.valueOf(this.field_lastModifiedTime));
    }
    if (this.eAw) {
      localContentValues.put("isNew", Integer.valueOf(this.field_isNew));
    }
    if (this.eAx) {
      localContentValues.put("addScene", Integer.valueOf(this.field_addScene));
    }
    if (this.eAy) {
      localContentValues.put("fmsgSysRowId", Long.valueOf(this.field_fmsgSysRowId));
    }
    if (this.eAz) {
      localContentValues.put("fmsgIsSend", Integer.valueOf(this.field_fmsgIsSend));
    }
    if (this.eAA) {
      localContentValues.put("fmsgType", Integer.valueOf(this.field_fmsgType));
    }
    if (this.field_fmsgContent == null) {
      this.field_fmsgContent = "";
    }
    if (this.eAB) {
      localContentValues.put("fmsgContent", this.field_fmsgContent);
    }
    if (this.eAC) {
      localContentValues.put("recvFmsgType", Integer.valueOf(this.field_recvFmsgType));
    }
    if (this.field_contentFromUsername == null) {
      this.field_contentFromUsername = "";
    }
    if (this.eAD) {
      localContentValues.put("contentFromUsername", this.field_contentFromUsername);
    }
    if (this.field_contentNickname == null) {
      this.field_contentNickname = "";
    }
    if (this.eAE) {
      localContentValues.put("contentNickname", this.field_contentNickname);
    }
    if (this.field_contentPhoneNumMD5 == null) {
      this.field_contentPhoneNumMD5 = "";
    }
    if (this.eAF) {
      localContentValues.put("contentPhoneNumMD5", this.field_contentPhoneNumMD5);
    }
    if (this.field_contentFullPhoneNumMD5 == null) {
      this.field_contentFullPhoneNumMD5 = "";
    }
    if (this.eAG) {
      localContentValues.put("contentFullPhoneNumMD5", this.field_contentFullPhoneNumMD5);
    }
    if (this.field_contentVerifyContent == null) {
      this.field_contentVerifyContent = "";
    }
    if (this.eAH) {
      localContentValues.put("contentVerifyContent", this.field_contentVerifyContent);
    }
    if (this.systemRowid > 0L) {
      localContentValues.put("rowid", Long.valueOf(this.systemRowid));
    }
    return localContentValues;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.g.c.bp
 * JD-Core Version:    0.7.0.1
 */