package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.storage.IAutoDBItem;

public abstract class bt
  extends IAutoDBItem
{
  public static final String[] INDEX_CREATE = { "CREATE INDEX IF NOT EXISTS fmconversation_isnew_Index ON fmessage_conversation(isNew)" };
  private static final int fAa = "contentFromUsername".hashCode();
  private static final int fAb = "contentNickname".hashCode();
  private static final int fAc = "contentPhoneNumMD5".hashCode();
  private static final int fAd = "contentFullPhoneNumMD5".hashCode();
  private static final int fAe = "contentVerifyContent".hashCode();
  private static final int fqw = "talker".hashCode();
  private static final int fyj;
  private static final int fzQ = "encryptTalker".hashCode();
  private static final int fzR = "displayName".hashCode();
  private static final int fzS;
  private static final int fzT;
  private static final int fzU;
  private static final int fzV;
  private static final int fzW;
  private static final int fzX;
  private static final int fzY;
  private static final int fzZ;
  private static final int rowid_HASHCODE = "rowid".hashCode();
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
  private boolean fqi = true;
  private boolean fxx = true;
  private boolean fzB = true;
  private boolean fzC = true;
  private boolean fzD = true;
  private boolean fzE = true;
  private boolean fzF = true;
  private boolean fzG = true;
  private boolean fzH = true;
  private boolean fzI = true;
  private boolean fzJ = true;
  private boolean fzK = true;
  private boolean fzL = true;
  private boolean fzM = true;
  private boolean fzN = true;
  private boolean fzO = true;
  private boolean fzP = true;
  
  static
  {
    fyj = "state".hashCode();
    fzS = "lastModifiedTime".hashCode();
    fzT = "isNew".hashCode();
    fzU = "addScene".hashCode();
    fzV = "fmsgSysRowId".hashCode();
    fzW = "fmsgIsSend".hashCode();
    fzX = "fmsgType".hashCode();
    fzY = "fmsgContent".hashCode();
    fzZ = "recvFmsgType".hashCode();
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
      if (fqw != k) {
        break label65;
      }
      this.field_talker = paramCursor.getString(i);
      this.fqi = true;
    }
    for (;;)
    {
      i += 1;
      break label20;
      break;
      label65:
      if (fzQ == k) {
        this.field_encryptTalker = paramCursor.getString(i);
      } else if (fzR == k) {
        this.field_displayName = paramCursor.getString(i);
      } else if (fyj == k) {
        this.field_state = paramCursor.getInt(i);
      } else if (fzS == k) {
        this.field_lastModifiedTime = paramCursor.getLong(i);
      } else if (fzT == k) {
        this.field_isNew = paramCursor.getInt(i);
      } else if (fzU == k) {
        this.field_addScene = paramCursor.getInt(i);
      } else if (fzV == k) {
        this.field_fmsgSysRowId = paramCursor.getLong(i);
      } else if (fzW == k) {
        this.field_fmsgIsSend = paramCursor.getInt(i);
      } else if (fzX == k) {
        this.field_fmsgType = paramCursor.getInt(i);
      } else if (fzY == k) {
        this.field_fmsgContent = paramCursor.getString(i);
      } else if (fzZ == k) {
        this.field_recvFmsgType = paramCursor.getInt(i);
      } else if (fAa == k) {
        this.field_contentFromUsername = paramCursor.getString(i);
      } else if (fAb == k) {
        this.field_contentNickname = paramCursor.getString(i);
      } else if (fAc == k) {
        this.field_contentPhoneNumMD5 = paramCursor.getString(i);
      } else if (fAd == k) {
        this.field_contentFullPhoneNumMD5 = paramCursor.getString(i);
      } else if (fAe == k) {
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
    if (this.fqi) {
      localContentValues.put("talker", this.field_talker);
    }
    if (this.field_encryptTalker == null) {
      this.field_encryptTalker = "";
    }
    if (this.fzB) {
      localContentValues.put("encryptTalker", this.field_encryptTalker);
    }
    if (this.field_displayName == null) {
      this.field_displayName = "";
    }
    if (this.fzC) {
      localContentValues.put("displayName", this.field_displayName);
    }
    if (this.fxx) {
      localContentValues.put("state", Integer.valueOf(this.field_state));
    }
    if (this.fzD) {
      localContentValues.put("lastModifiedTime", Long.valueOf(this.field_lastModifiedTime));
    }
    if (this.fzE) {
      localContentValues.put("isNew", Integer.valueOf(this.field_isNew));
    }
    if (this.fzF) {
      localContentValues.put("addScene", Integer.valueOf(this.field_addScene));
    }
    if (this.fzG) {
      localContentValues.put("fmsgSysRowId", Long.valueOf(this.field_fmsgSysRowId));
    }
    if (this.fzH) {
      localContentValues.put("fmsgIsSend", Integer.valueOf(this.field_fmsgIsSend));
    }
    if (this.fzI) {
      localContentValues.put("fmsgType", Integer.valueOf(this.field_fmsgType));
    }
    if (this.field_fmsgContent == null) {
      this.field_fmsgContent = "";
    }
    if (this.fzJ) {
      localContentValues.put("fmsgContent", this.field_fmsgContent);
    }
    if (this.fzK) {
      localContentValues.put("recvFmsgType", Integer.valueOf(this.field_recvFmsgType));
    }
    if (this.field_contentFromUsername == null) {
      this.field_contentFromUsername = "";
    }
    if (this.fzL) {
      localContentValues.put("contentFromUsername", this.field_contentFromUsername);
    }
    if (this.field_contentNickname == null) {
      this.field_contentNickname = "";
    }
    if (this.fzM) {
      localContentValues.put("contentNickname", this.field_contentNickname);
    }
    if (this.field_contentPhoneNumMD5 == null) {
      this.field_contentPhoneNumMD5 = "";
    }
    if (this.fzN) {
      localContentValues.put("contentPhoneNumMD5", this.field_contentPhoneNumMD5);
    }
    if (this.field_contentFullPhoneNumMD5 == null) {
      this.field_contentFullPhoneNumMD5 = "";
    }
    if (this.fzO) {
      localContentValues.put("contentFullPhoneNumMD5", this.field_contentFullPhoneNumMD5);
    }
    if (this.field_contentVerifyContent == null) {
      this.field_contentVerifyContent = "";
    }
    if (this.fzP) {
      localContentValues.put("contentVerifyContent", this.field_contentVerifyContent);
    }
    if (this.systemRowid > 0L) {
      localContentValues.put("rowid", Long.valueOf(this.systemRowid));
    }
    return localContentValues;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.g.c.bt
 * JD-Core Version:    0.7.0.1
 */