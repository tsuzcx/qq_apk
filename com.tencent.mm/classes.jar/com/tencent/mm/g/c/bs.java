package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;

public abstract class bs
  extends c
{
  public static final String[] INDEX_CREATE = { "CREATE INDEX IF NOT EXISTS fmconversation_isnew_Index ON fmessage_conversation(isNew)" };
  private static final int eMP = "talker".hashCode();
  private static final int eUE = "state".hashCode();
  private static final int eWl = "encryptTalker".hashCode();
  private static final int eWm = "displayName".hashCode();
  private static final int eWn = "lastModifiedTime".hashCode();
  private static final int eWo = "isNew".hashCode();
  private static final int eWp = "addScene".hashCode();
  private static final int eWq = "fmsgSysRowId".hashCode();
  private static final int eWr = "fmsgIsSend".hashCode();
  private static final int eWs = "fmsgType".hashCode();
  private static final int eWt = "fmsgContent".hashCode();
  private static final int eWu = "recvFmsgType".hashCode();
  private static final int eWv = "contentFromUsername".hashCode();
  private static final int eWw = "contentNickname".hashCode();
  private static final int eWx = "contentPhoneNumMD5".hashCode();
  private static final int eWy = "contentFullPhoneNumMD5".hashCode();
  private static final int eWz = "contentVerifyContent".hashCode();
  private static final int rowid_HASHCODE = "rowid".hashCode();
  private boolean eMB = true;
  private boolean eTS = true;
  private boolean eVW = true;
  private boolean eVX = true;
  private boolean eVY = true;
  private boolean eVZ = true;
  private boolean eWa = true;
  private boolean eWb = true;
  private boolean eWc = true;
  private boolean eWd = true;
  private boolean eWe = true;
  private boolean eWf = true;
  private boolean eWg = true;
  private boolean eWh = true;
  private boolean eWi = true;
  private boolean eWj = true;
  private boolean eWk = true;
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
      if (eMP != k) {
        break label65;
      }
      this.field_talker = paramCursor.getString(i);
      this.eMB = true;
    }
    for (;;)
    {
      i += 1;
      break label20;
      break;
      label65:
      if (eWl == k) {
        this.field_encryptTalker = paramCursor.getString(i);
      } else if (eWm == k) {
        this.field_displayName = paramCursor.getString(i);
      } else if (eUE == k) {
        this.field_state = paramCursor.getInt(i);
      } else if (eWn == k) {
        this.field_lastModifiedTime = paramCursor.getLong(i);
      } else if (eWo == k) {
        this.field_isNew = paramCursor.getInt(i);
      } else if (eWp == k) {
        this.field_addScene = paramCursor.getInt(i);
      } else if (eWq == k) {
        this.field_fmsgSysRowId = paramCursor.getLong(i);
      } else if (eWr == k) {
        this.field_fmsgIsSend = paramCursor.getInt(i);
      } else if (eWs == k) {
        this.field_fmsgType = paramCursor.getInt(i);
      } else if (eWt == k) {
        this.field_fmsgContent = paramCursor.getString(i);
      } else if (eWu == k) {
        this.field_recvFmsgType = paramCursor.getInt(i);
      } else if (eWv == k) {
        this.field_contentFromUsername = paramCursor.getString(i);
      } else if (eWw == k) {
        this.field_contentNickname = paramCursor.getString(i);
      } else if (eWx == k) {
        this.field_contentPhoneNumMD5 = paramCursor.getString(i);
      } else if (eWy == k) {
        this.field_contentFullPhoneNumMD5 = paramCursor.getString(i);
      } else if (eWz == k) {
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
    if (this.eMB) {
      localContentValues.put("talker", this.field_talker);
    }
    if (this.field_encryptTalker == null) {
      this.field_encryptTalker = "";
    }
    if (this.eVW) {
      localContentValues.put("encryptTalker", this.field_encryptTalker);
    }
    if (this.field_displayName == null) {
      this.field_displayName = "";
    }
    if (this.eVX) {
      localContentValues.put("displayName", this.field_displayName);
    }
    if (this.eTS) {
      localContentValues.put("state", Integer.valueOf(this.field_state));
    }
    if (this.eVY) {
      localContentValues.put("lastModifiedTime", Long.valueOf(this.field_lastModifiedTime));
    }
    if (this.eVZ) {
      localContentValues.put("isNew", Integer.valueOf(this.field_isNew));
    }
    if (this.eWa) {
      localContentValues.put("addScene", Integer.valueOf(this.field_addScene));
    }
    if (this.eWb) {
      localContentValues.put("fmsgSysRowId", Long.valueOf(this.field_fmsgSysRowId));
    }
    if (this.eWc) {
      localContentValues.put("fmsgIsSend", Integer.valueOf(this.field_fmsgIsSend));
    }
    if (this.eWd) {
      localContentValues.put("fmsgType", Integer.valueOf(this.field_fmsgType));
    }
    if (this.field_fmsgContent == null) {
      this.field_fmsgContent = "";
    }
    if (this.eWe) {
      localContentValues.put("fmsgContent", this.field_fmsgContent);
    }
    if (this.eWf) {
      localContentValues.put("recvFmsgType", Integer.valueOf(this.field_recvFmsgType));
    }
    if (this.field_contentFromUsername == null) {
      this.field_contentFromUsername = "";
    }
    if (this.eWg) {
      localContentValues.put("contentFromUsername", this.field_contentFromUsername);
    }
    if (this.field_contentNickname == null) {
      this.field_contentNickname = "";
    }
    if (this.eWh) {
      localContentValues.put("contentNickname", this.field_contentNickname);
    }
    if (this.field_contentPhoneNumMD5 == null) {
      this.field_contentPhoneNumMD5 = "";
    }
    if (this.eWi) {
      localContentValues.put("contentPhoneNumMD5", this.field_contentPhoneNumMD5);
    }
    if (this.field_contentFullPhoneNumMD5 == null) {
      this.field_contentFullPhoneNumMD5 = "";
    }
    if (this.eWj) {
      localContentValues.put("contentFullPhoneNumMD5", this.field_contentFullPhoneNumMD5);
    }
    if (this.field_contentVerifyContent == null) {
      this.field_contentVerifyContent = "";
    }
    if (this.eWk) {
      localContentValues.put("contentVerifyContent", this.field_contentVerifyContent);
    }
    if (this.systemRowid > 0L) {
      localContentValues.put("rowid", Long.valueOf(this.systemRowid));
    }
    return localContentValues;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.g.c.bs
 * JD-Core Version:    0.7.0.1
 */