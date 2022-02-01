package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;

public abstract class bs
  extends c
{
  public static final String[] INDEX_CREATE = { "CREATE INDEX IF NOT EXISTS fmconversation_isnew_Index ON fmessage_conversation(isNew)" };
  private static final int eLf = "talker".hashCode();
  private static final int eST = "state".hashCode();
  private static final int eUA = "encryptTalker".hashCode();
  private static final int eUB = "displayName".hashCode();
  private static final int eUC = "lastModifiedTime".hashCode();
  private static final int eUD = "isNew".hashCode();
  private static final int eUE = "addScene".hashCode();
  private static final int eUF = "fmsgSysRowId".hashCode();
  private static final int eUG = "fmsgIsSend".hashCode();
  private static final int eUH = "fmsgType".hashCode();
  private static final int eUI = "fmsgContent".hashCode();
  private static final int eUJ = "recvFmsgType".hashCode();
  private static final int eUK = "contentFromUsername".hashCode();
  private static final int eUL = "contentNickname".hashCode();
  private static final int eUM = "contentPhoneNumMD5".hashCode();
  private static final int eUN = "contentFullPhoneNumMD5".hashCode();
  private static final int eUO = "contentVerifyContent".hashCode();
  private static final int rowid_HASHCODE = "rowid".hashCode();
  private boolean eKS = true;
  private boolean eSh = true;
  private boolean eUl = true;
  private boolean eUm = true;
  private boolean eUn = true;
  private boolean eUo = true;
  private boolean eUp = true;
  private boolean eUq = true;
  private boolean eUr = true;
  private boolean eUs = true;
  private boolean eUt = true;
  private boolean eUu = true;
  private boolean eUv = true;
  private boolean eUw = true;
  private boolean eUx = true;
  private boolean eUy = true;
  private boolean eUz = true;
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
      if (eLf != k) {
        break label65;
      }
      this.field_talker = paramCursor.getString(i);
      this.eKS = true;
    }
    for (;;)
    {
      i += 1;
      break label20;
      break;
      label65:
      if (eUA == k) {
        this.field_encryptTalker = paramCursor.getString(i);
      } else if (eUB == k) {
        this.field_displayName = paramCursor.getString(i);
      } else if (eST == k) {
        this.field_state = paramCursor.getInt(i);
      } else if (eUC == k) {
        this.field_lastModifiedTime = paramCursor.getLong(i);
      } else if (eUD == k) {
        this.field_isNew = paramCursor.getInt(i);
      } else if (eUE == k) {
        this.field_addScene = paramCursor.getInt(i);
      } else if (eUF == k) {
        this.field_fmsgSysRowId = paramCursor.getLong(i);
      } else if (eUG == k) {
        this.field_fmsgIsSend = paramCursor.getInt(i);
      } else if (eUH == k) {
        this.field_fmsgType = paramCursor.getInt(i);
      } else if (eUI == k) {
        this.field_fmsgContent = paramCursor.getString(i);
      } else if (eUJ == k) {
        this.field_recvFmsgType = paramCursor.getInt(i);
      } else if (eUK == k) {
        this.field_contentFromUsername = paramCursor.getString(i);
      } else if (eUL == k) {
        this.field_contentNickname = paramCursor.getString(i);
      } else if (eUM == k) {
        this.field_contentPhoneNumMD5 = paramCursor.getString(i);
      } else if (eUN == k) {
        this.field_contentFullPhoneNumMD5 = paramCursor.getString(i);
      } else if (eUO == k) {
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
    if (this.eKS) {
      localContentValues.put("talker", this.field_talker);
    }
    if (this.field_encryptTalker == null) {
      this.field_encryptTalker = "";
    }
    if (this.eUl) {
      localContentValues.put("encryptTalker", this.field_encryptTalker);
    }
    if (this.field_displayName == null) {
      this.field_displayName = "";
    }
    if (this.eUm) {
      localContentValues.put("displayName", this.field_displayName);
    }
    if (this.eSh) {
      localContentValues.put("state", Integer.valueOf(this.field_state));
    }
    if (this.eUn) {
      localContentValues.put("lastModifiedTime", Long.valueOf(this.field_lastModifiedTime));
    }
    if (this.eUo) {
      localContentValues.put("isNew", Integer.valueOf(this.field_isNew));
    }
    if (this.eUp) {
      localContentValues.put("addScene", Integer.valueOf(this.field_addScene));
    }
    if (this.eUq) {
      localContentValues.put("fmsgSysRowId", Long.valueOf(this.field_fmsgSysRowId));
    }
    if (this.eUr) {
      localContentValues.put("fmsgIsSend", Integer.valueOf(this.field_fmsgIsSend));
    }
    if (this.eUs) {
      localContentValues.put("fmsgType", Integer.valueOf(this.field_fmsgType));
    }
    if (this.field_fmsgContent == null) {
      this.field_fmsgContent = "";
    }
    if (this.eUt) {
      localContentValues.put("fmsgContent", this.field_fmsgContent);
    }
    if (this.eUu) {
      localContentValues.put("recvFmsgType", Integer.valueOf(this.field_recvFmsgType));
    }
    if (this.field_contentFromUsername == null) {
      this.field_contentFromUsername = "";
    }
    if (this.eUv) {
      localContentValues.put("contentFromUsername", this.field_contentFromUsername);
    }
    if (this.field_contentNickname == null) {
      this.field_contentNickname = "";
    }
    if (this.eUw) {
      localContentValues.put("contentNickname", this.field_contentNickname);
    }
    if (this.field_contentPhoneNumMD5 == null) {
      this.field_contentPhoneNumMD5 = "";
    }
    if (this.eUx) {
      localContentValues.put("contentPhoneNumMD5", this.field_contentPhoneNumMD5);
    }
    if (this.field_contentFullPhoneNumMD5 == null) {
      this.field_contentFullPhoneNumMD5 = "";
    }
    if (this.eUy) {
      localContentValues.put("contentFullPhoneNumMD5", this.field_contentFullPhoneNumMD5);
    }
    if (this.field_contentVerifyContent == null) {
      this.field_contentVerifyContent = "";
    }
    if (this.eUz) {
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