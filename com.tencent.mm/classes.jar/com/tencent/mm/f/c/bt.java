package com.tencent.mm.f.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.storage.IAutoDBItem;
import com.tencent.mm.sdk.storage.sql.Column;
import com.tencent.mm.sdk.storage.sql.SingleTable;

public abstract class bt
  extends IAutoDBItem
{
  public static final Column C_ROWID;
  public static final String[] INDEX_CREATE = { "CREATE INDEX IF NOT EXISTS fmconversation_isnew_Index ON fmessage_conversation(isNew)" };
  public static final SingleTable TABLE = new SingleTable("fmessage_conversation");
  public static final Column hAa;
  public static final Column hHa;
  private static final int hIC = "state".hashCode();
  public static final Column hKA;
  private static final int hKQ;
  private static final int hKR;
  private static final int hKS = "lastModifiedTime".hashCode();
  private static final int hKT = "isNew".hashCode();
  private static final int hKU = "addScene".hashCode();
  private static final int hKV = "fmsgSysRowId".hashCode();
  private static final int hKW = "fmsgIsSend".hashCode();
  private static final int hKX = "fmsgType".hashCode();
  private static final int hKY = "fmsgContent".hashCode();
  private static final int hKZ = "recvFmsgType".hashCode();
  public static final Column hKn;
  public static final Column hKo;
  public static final Column hKp;
  public static final Column hKq;
  public static final Column hKr;
  public static final Column hKs;
  public static final Column hKt;
  public static final Column hKu;
  public static final Column hKv;
  public static final Column hKw;
  public static final Column hKx;
  public static final Column hKy;
  public static final Column hKz;
  private static final int hLa = "contentFromUsername".hashCode();
  private static final int hLb = "contentNickname".hashCode();
  private static final int hLc = "contentPhoneNumMD5".hashCode();
  private static final int hLd = "contentFullPhoneNumMD5".hashCode();
  private static final int hLe = "contentVerifyContent".hashCode();
  public static final Column hwI;
  private static final int hxk;
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
  private boolean hHO = true;
  private boolean hKB = true;
  private boolean hKC = true;
  private boolean hKD = true;
  private boolean hKE = true;
  private boolean hKF = true;
  private boolean hKG = true;
  private boolean hKH = true;
  private boolean hKI = true;
  private boolean hKJ = true;
  private boolean hKK = true;
  private boolean hKL = true;
  private boolean hKM = true;
  private boolean hKN = true;
  private boolean hKO = true;
  private boolean hKP = true;
  private boolean hwW = true;
  
  static
  {
    C_ROWID = new Column("rowid", "long", "fmessage_conversation", "");
    hwI = new Column("talker", "string", "fmessage_conversation", "");
    hKn = new Column("encrypttalker", "string", "fmessage_conversation", "");
    hAa = new Column("displayname", "string", "fmessage_conversation", "");
    hHa = new Column("state", "int", "fmessage_conversation", "");
    hKo = new Column("lastmodifiedtime", "long", "fmessage_conversation", "");
    hKp = new Column("isnew", "int", "fmessage_conversation", "");
    hKq = new Column("addscene", "int", "fmessage_conversation", "");
    hKr = new Column("fmsgsysrowid", "long", "fmessage_conversation", "");
    hKs = new Column("fmsgissend", "int", "fmessage_conversation", "");
    hKt = new Column("fmsgtype", "int", "fmessage_conversation", "");
    hKu = new Column("fmsgcontent", "string", "fmessage_conversation", "");
    hKv = new Column("recvfmsgtype", "int", "fmessage_conversation", "");
    hKw = new Column("contentfromusername", "string", "fmessage_conversation", "");
    hKx = new Column("contentnickname", "string", "fmessage_conversation", "");
    hKy = new Column("contentphonenummd5", "string", "fmessage_conversation", "");
    hKz = new Column("contentfullphonenummd5", "string", "fmessage_conversation", "");
    hKA = new Column("contentverifycontent", "string", "fmessage_conversation", "");
    hxk = "talker".hashCode();
    hKQ = "encryptTalker".hashCode();
    hKR = "displayName".hashCode();
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
      if (hxk != k) {
        break label65;
      }
      this.field_talker = paramCursor.getString(i);
      this.hwW = true;
    }
    for (;;)
    {
      i += 1;
      break label20;
      break;
      label65:
      if (hKQ == k) {
        this.field_encryptTalker = paramCursor.getString(i);
      } else if (hKR == k) {
        this.field_displayName = paramCursor.getString(i);
      } else if (hIC == k) {
        this.field_state = paramCursor.getInt(i);
      } else if (hKS == k) {
        this.field_lastModifiedTime = paramCursor.getLong(i);
      } else if (hKT == k) {
        this.field_isNew = paramCursor.getInt(i);
      } else if (hKU == k) {
        this.field_addScene = paramCursor.getInt(i);
      } else if (hKV == k) {
        this.field_fmsgSysRowId = paramCursor.getLong(i);
      } else if (hKW == k) {
        this.field_fmsgIsSend = paramCursor.getInt(i);
      } else if (hKX == k) {
        this.field_fmsgType = paramCursor.getInt(i);
      } else if (hKY == k) {
        this.field_fmsgContent = paramCursor.getString(i);
      } else if (hKZ == k) {
        this.field_recvFmsgType = paramCursor.getInt(i);
      } else if (hLa == k) {
        this.field_contentFromUsername = paramCursor.getString(i);
      } else if (hLb == k) {
        this.field_contentNickname = paramCursor.getString(i);
      } else if (hLc == k) {
        this.field_contentPhoneNumMD5 = paramCursor.getString(i);
      } else if (hLd == k) {
        this.field_contentFullPhoneNumMD5 = paramCursor.getString(i);
      } else if (hLe == k) {
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
    if (this.hwW) {
      localContentValues.put("talker", this.field_talker);
    }
    if (this.field_encryptTalker == null) {
      this.field_encryptTalker = "";
    }
    if (this.hKB) {
      localContentValues.put("encryptTalker", this.field_encryptTalker);
    }
    if (this.field_displayName == null) {
      this.field_displayName = "";
    }
    if (this.hKC) {
      localContentValues.put("displayName", this.field_displayName);
    }
    if (this.hHO) {
      localContentValues.put("state", Integer.valueOf(this.field_state));
    }
    if (this.hKD) {
      localContentValues.put("lastModifiedTime", Long.valueOf(this.field_lastModifiedTime));
    }
    if (this.hKE) {
      localContentValues.put("isNew", Integer.valueOf(this.field_isNew));
    }
    if (this.hKF) {
      localContentValues.put("addScene", Integer.valueOf(this.field_addScene));
    }
    if (this.hKG) {
      localContentValues.put("fmsgSysRowId", Long.valueOf(this.field_fmsgSysRowId));
    }
    if (this.hKH) {
      localContentValues.put("fmsgIsSend", Integer.valueOf(this.field_fmsgIsSend));
    }
    if (this.hKI) {
      localContentValues.put("fmsgType", Integer.valueOf(this.field_fmsgType));
    }
    if (this.field_fmsgContent == null) {
      this.field_fmsgContent = "";
    }
    if (this.hKJ) {
      localContentValues.put("fmsgContent", this.field_fmsgContent);
    }
    if (this.hKK) {
      localContentValues.put("recvFmsgType", Integer.valueOf(this.field_recvFmsgType));
    }
    if (this.field_contentFromUsername == null) {
      this.field_contentFromUsername = "";
    }
    if (this.hKL) {
      localContentValues.put("contentFromUsername", this.field_contentFromUsername);
    }
    if (this.field_contentNickname == null) {
      this.field_contentNickname = "";
    }
    if (this.hKM) {
      localContentValues.put("contentNickname", this.field_contentNickname);
    }
    if (this.field_contentPhoneNumMD5 == null) {
      this.field_contentPhoneNumMD5 = "";
    }
    if (this.hKN) {
      localContentValues.put("contentPhoneNumMD5", this.field_contentPhoneNumMD5);
    }
    if (this.field_contentFullPhoneNumMD5 == null) {
      this.field_contentFullPhoneNumMD5 = "";
    }
    if (this.hKO) {
      localContentValues.put("contentFullPhoneNumMD5", this.field_contentFullPhoneNumMD5);
    }
    if (this.field_contentVerifyContent == null) {
      this.field_contentVerifyContent = "";
    }
    if (this.hKP) {
      localContentValues.put("contentVerifyContent", this.field_contentVerifyContent);
    }
    if (this.systemRowid > 0L) {
      localContentValues.put("rowid", Long.valueOf(this.systemRowid));
    }
    return localContentValues;
  }
  
  public String[] getIndexCreateSQL()
  {
    return INDEX_CREATE;
  }
  
  public String getTableName()
  {
    return "fmessage_conversation";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.f.c.bt
 * JD-Core Version:    0.7.0.1
 */