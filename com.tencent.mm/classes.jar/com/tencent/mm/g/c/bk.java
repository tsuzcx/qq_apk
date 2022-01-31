package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;

public abstract class bk
  extends c
{
  public static final String[] INDEX_CREATE = { "CREATE INDEX IF NOT EXISTS fmconversation_isnew_Index ON fmessage_conversation(isNew)" };
  private static final int dnh = "talker".hashCode();
  private static final int dub = "state".hashCode();
  private static final int dvI = "encryptTalker".hashCode();
  private static final int dvJ = "displayName".hashCode();
  private static final int dvK = "lastModifiedTime".hashCode();
  private static final int dvL = "isNew".hashCode();
  private static final int dvM = "addScene".hashCode();
  private static final int dvN = "fmsgSysRowId".hashCode();
  private static final int dvO = "fmsgIsSend".hashCode();
  private static final int dvP = "fmsgType".hashCode();
  private static final int dvQ = "fmsgContent".hashCode();
  private static final int dvR = "recvFmsgType".hashCode();
  private static final int dvS = "contentFromUsername".hashCode();
  private static final int dvT = "contentNickname".hashCode();
  private static final int dvU = "contentPhoneNumMD5".hashCode();
  private static final int dvV = "contentFullPhoneNumMD5".hashCode();
  private static final int dvW = "contentVerifyContent".hashCode();
  private static final int rowid_HASHCODE = "rowid".hashCode();
  private boolean dmW = true;
  private boolean dto = true;
  private boolean dvA = true;
  private boolean dvB = true;
  private boolean dvC = true;
  private boolean dvD = true;
  private boolean dvE = true;
  private boolean dvF = true;
  private boolean dvG = true;
  private boolean dvH = true;
  private boolean dvt = true;
  private boolean dvu = true;
  private boolean dvv = true;
  private boolean dvw = true;
  private boolean dvx = true;
  private boolean dvy = true;
  private boolean dvz = true;
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
      if (dnh != k) {
        break label65;
      }
      this.field_talker = paramCursor.getString(i);
      this.dmW = true;
    }
    for (;;)
    {
      i += 1;
      break label20;
      break;
      label65:
      if (dvI == k) {
        this.field_encryptTalker = paramCursor.getString(i);
      } else if (dvJ == k) {
        this.field_displayName = paramCursor.getString(i);
      } else if (dub == k) {
        this.field_state = paramCursor.getInt(i);
      } else if (dvK == k) {
        this.field_lastModifiedTime = paramCursor.getLong(i);
      } else if (dvL == k) {
        this.field_isNew = paramCursor.getInt(i);
      } else if (dvM == k) {
        this.field_addScene = paramCursor.getInt(i);
      } else if (dvN == k) {
        this.field_fmsgSysRowId = paramCursor.getLong(i);
      } else if (dvO == k) {
        this.field_fmsgIsSend = paramCursor.getInt(i);
      } else if (dvP == k) {
        this.field_fmsgType = paramCursor.getInt(i);
      } else if (dvQ == k) {
        this.field_fmsgContent = paramCursor.getString(i);
      } else if (dvR == k) {
        this.field_recvFmsgType = paramCursor.getInt(i);
      } else if (dvS == k) {
        this.field_contentFromUsername = paramCursor.getString(i);
      } else if (dvT == k) {
        this.field_contentNickname = paramCursor.getString(i);
      } else if (dvU == k) {
        this.field_contentPhoneNumMD5 = paramCursor.getString(i);
      } else if (dvV == k) {
        this.field_contentFullPhoneNumMD5 = paramCursor.getString(i);
      } else if (dvW == k) {
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
    if (this.dmW) {
      localContentValues.put("talker", this.field_talker);
    }
    if (this.field_encryptTalker == null) {
      this.field_encryptTalker = "";
    }
    if (this.dvt) {
      localContentValues.put("encryptTalker", this.field_encryptTalker);
    }
    if (this.field_displayName == null) {
      this.field_displayName = "";
    }
    if (this.dvu) {
      localContentValues.put("displayName", this.field_displayName);
    }
    if (this.dto) {
      localContentValues.put("state", Integer.valueOf(this.field_state));
    }
    if (this.dvv) {
      localContentValues.put("lastModifiedTime", Long.valueOf(this.field_lastModifiedTime));
    }
    if (this.dvw) {
      localContentValues.put("isNew", Integer.valueOf(this.field_isNew));
    }
    if (this.dvx) {
      localContentValues.put("addScene", Integer.valueOf(this.field_addScene));
    }
    if (this.dvy) {
      localContentValues.put("fmsgSysRowId", Long.valueOf(this.field_fmsgSysRowId));
    }
    if (this.dvz) {
      localContentValues.put("fmsgIsSend", Integer.valueOf(this.field_fmsgIsSend));
    }
    if (this.dvA) {
      localContentValues.put("fmsgType", Integer.valueOf(this.field_fmsgType));
    }
    if (this.field_fmsgContent == null) {
      this.field_fmsgContent = "";
    }
    if (this.dvB) {
      localContentValues.put("fmsgContent", this.field_fmsgContent);
    }
    if (this.dvC) {
      localContentValues.put("recvFmsgType", Integer.valueOf(this.field_recvFmsgType));
    }
    if (this.field_contentFromUsername == null) {
      this.field_contentFromUsername = "";
    }
    if (this.dvD) {
      localContentValues.put("contentFromUsername", this.field_contentFromUsername);
    }
    if (this.field_contentNickname == null) {
      this.field_contentNickname = "";
    }
    if (this.dvE) {
      localContentValues.put("contentNickname", this.field_contentNickname);
    }
    if (this.field_contentPhoneNumMD5 == null) {
      this.field_contentPhoneNumMD5 = "";
    }
    if (this.dvF) {
      localContentValues.put("contentPhoneNumMD5", this.field_contentPhoneNumMD5);
    }
    if (this.field_contentFullPhoneNumMD5 == null) {
      this.field_contentFullPhoneNumMD5 = "";
    }
    if (this.dvG) {
      localContentValues.put("contentFullPhoneNumMD5", this.field_contentFullPhoneNumMD5);
    }
    if (this.field_contentVerifyContent == null) {
      this.field_contentVerifyContent = "";
    }
    if (this.dvH) {
      localContentValues.put("contentVerifyContent", this.field_contentVerifyContent);
    }
    if (this.systemRowid > 0L) {
      localContentValues.put("rowid", Long.valueOf(this.systemRowid));
    }
    return localContentValues;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.g.c.bk
 * JD-Core Version:    0.7.0.1
 */