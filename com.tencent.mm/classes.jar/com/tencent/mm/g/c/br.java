package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;

public abstract class br
  extends c
{
  public static final String[] INDEX_CREATE = { "CREATE INDEX IF NOT EXISTS fmconversation_isnew_Index ON fmessage_conversation(isNew)" };
  private static final int eBv = "state".hashCode();
  private static final int eDc;
  private static final int eDd;
  private static final int eDe = "lastModifiedTime".hashCode();
  private static final int eDf = "isNew".hashCode();
  private static final int eDg = "addScene".hashCode();
  private static final int eDh = "fmsgSysRowId".hashCode();
  private static final int eDi = "fmsgIsSend".hashCode();
  private static final int eDj = "fmsgType".hashCode();
  private static final int eDk = "fmsgContent".hashCode();
  private static final int eDl = "recvFmsgType".hashCode();
  private static final int eDm = "contentFromUsername".hashCode();
  private static final int eDn = "contentNickname".hashCode();
  private static final int eDo = "contentPhoneNumMD5".hashCode();
  private static final int eDp = "contentFullPhoneNumMD5".hashCode();
  private static final int eDq = "contentVerifyContent".hashCode();
  private static final int etX = "talker".hashCode();
  private static final int rowid_HASHCODE = "rowid".hashCode();
  private boolean eAJ = true;
  private boolean eCN = true;
  private boolean eCO = true;
  private boolean eCP = true;
  private boolean eCQ = true;
  private boolean eCR = true;
  private boolean eCS = true;
  private boolean eCT = true;
  private boolean eCU = true;
  private boolean eCV = true;
  private boolean eCW = true;
  private boolean eCX = true;
  private boolean eCY = true;
  private boolean eCZ = true;
  private boolean eDa = true;
  private boolean eDb = true;
  private boolean etJ = true;
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
    eDc = "encryptTalker".hashCode();
    eDd = "displayName".hashCode();
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
      if (etX != k) {
        break label65;
      }
      this.field_talker = paramCursor.getString(i);
      this.etJ = true;
    }
    for (;;)
    {
      i += 1;
      break label20;
      break;
      label65:
      if (eDc == k) {
        this.field_encryptTalker = paramCursor.getString(i);
      } else if (eDd == k) {
        this.field_displayName = paramCursor.getString(i);
      } else if (eBv == k) {
        this.field_state = paramCursor.getInt(i);
      } else if (eDe == k) {
        this.field_lastModifiedTime = paramCursor.getLong(i);
      } else if (eDf == k) {
        this.field_isNew = paramCursor.getInt(i);
      } else if (eDg == k) {
        this.field_addScene = paramCursor.getInt(i);
      } else if (eDh == k) {
        this.field_fmsgSysRowId = paramCursor.getLong(i);
      } else if (eDi == k) {
        this.field_fmsgIsSend = paramCursor.getInt(i);
      } else if (eDj == k) {
        this.field_fmsgType = paramCursor.getInt(i);
      } else if (eDk == k) {
        this.field_fmsgContent = paramCursor.getString(i);
      } else if (eDl == k) {
        this.field_recvFmsgType = paramCursor.getInt(i);
      } else if (eDm == k) {
        this.field_contentFromUsername = paramCursor.getString(i);
      } else if (eDn == k) {
        this.field_contentNickname = paramCursor.getString(i);
      } else if (eDo == k) {
        this.field_contentPhoneNumMD5 = paramCursor.getString(i);
      } else if (eDp == k) {
        this.field_contentFullPhoneNumMD5 = paramCursor.getString(i);
      } else if (eDq == k) {
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
    if (this.etJ) {
      localContentValues.put("talker", this.field_talker);
    }
    if (this.field_encryptTalker == null) {
      this.field_encryptTalker = "";
    }
    if (this.eCN) {
      localContentValues.put("encryptTalker", this.field_encryptTalker);
    }
    if (this.field_displayName == null) {
      this.field_displayName = "";
    }
    if (this.eCO) {
      localContentValues.put("displayName", this.field_displayName);
    }
    if (this.eAJ) {
      localContentValues.put("state", Integer.valueOf(this.field_state));
    }
    if (this.eCP) {
      localContentValues.put("lastModifiedTime", Long.valueOf(this.field_lastModifiedTime));
    }
    if (this.eCQ) {
      localContentValues.put("isNew", Integer.valueOf(this.field_isNew));
    }
    if (this.eCR) {
      localContentValues.put("addScene", Integer.valueOf(this.field_addScene));
    }
    if (this.eCS) {
      localContentValues.put("fmsgSysRowId", Long.valueOf(this.field_fmsgSysRowId));
    }
    if (this.eCT) {
      localContentValues.put("fmsgIsSend", Integer.valueOf(this.field_fmsgIsSend));
    }
    if (this.eCU) {
      localContentValues.put("fmsgType", Integer.valueOf(this.field_fmsgType));
    }
    if (this.field_fmsgContent == null) {
      this.field_fmsgContent = "";
    }
    if (this.eCV) {
      localContentValues.put("fmsgContent", this.field_fmsgContent);
    }
    if (this.eCW) {
      localContentValues.put("recvFmsgType", Integer.valueOf(this.field_recvFmsgType));
    }
    if (this.field_contentFromUsername == null) {
      this.field_contentFromUsername = "";
    }
    if (this.eCX) {
      localContentValues.put("contentFromUsername", this.field_contentFromUsername);
    }
    if (this.field_contentNickname == null) {
      this.field_contentNickname = "";
    }
    if (this.eCY) {
      localContentValues.put("contentNickname", this.field_contentNickname);
    }
    if (this.field_contentPhoneNumMD5 == null) {
      this.field_contentPhoneNumMD5 = "";
    }
    if (this.eCZ) {
      localContentValues.put("contentPhoneNumMD5", this.field_contentPhoneNumMD5);
    }
    if (this.field_contentFullPhoneNumMD5 == null) {
      this.field_contentFullPhoneNumMD5 = "";
    }
    if (this.eDa) {
      localContentValues.put("contentFullPhoneNumMD5", this.field_contentFullPhoneNumMD5);
    }
    if (this.field_contentVerifyContent == null) {
      this.field_contentVerifyContent = "";
    }
    if (this.eDb) {
      localContentValues.put("contentVerifyContent", this.field_contentVerifyContent);
    }
    if (this.systemRowid > 0L) {
      localContentValues.put("rowid", Long.valueOf(this.systemRowid));
    }
    return localContentValues;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.g.c.br
 * JD-Core Version:    0.7.0.1
 */