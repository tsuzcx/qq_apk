package com.tencent.mm.f.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.storage.IAutoDBItem;
import com.tencent.mm.sdk.storage.sql.Column;
import com.tencent.mm.sdk.storage.sql.SingleTable;

public abstract class fd
  extends IAutoDBItem
{
  public static final Column C_ROWID;
  public static final Column C_USERNAME;
  public static final String[] INDEX_CREATE = new String[0];
  public static final SingleTable TABLE = new SingleTable("OldAccountFriend");
  private static final int hCO;
  private static final int hCU;
  public static final Column hCc;
  public static final Column hCi;
  public static final Column hnu;
  private static final int hny;
  private static final int hwF;
  public static final Column hwx;
  public static final Column ipD;
  public static final Column ipE;
  public static final Column ipF;
  public static final Column ipG;
  private static final int ipL;
  private static final int ipM;
  private static final int ipN;
  private static final int ipO = "seq".hashCode();
  private static final int rowid_HASHCODE = "rowid".hashCode();
  private static final int username_HASHCODE;
  private boolean __hadSetusername = true;
  public int field_addState;
  public String field_encryptUsername;
  public String field_nickname;
  public String field_oldUsername;
  public String field_pinyinName;
  public int field_seq;
  public int field_showHead;
  public String field_ticket;
  public String field_username;
  private boolean hCB = true;
  private boolean hCv = true;
  private boolean hnw = true;
  private boolean hwB = true;
  private boolean ipH = true;
  private boolean ipI = true;
  private boolean ipJ = true;
  private boolean ipK = true;
  
  static
  {
    C_ROWID = new Column("rowid", "long", "OldAccountFriend", "");
    hCi = new Column("encryptusername", "string", "OldAccountFriend", "");
    ipD = new Column("oldusername", "string", "OldAccountFriend", "");
    hnu = new Column("ticket", "string", "OldAccountFriend", "");
    hwx = new Column("nickname", "string", "OldAccountFriend", "");
    ipE = new Column("addstate", "int", "OldAccountFriend", "");
    hCc = new Column("showhead", "int", "OldAccountFriend", "");
    ipF = new Column("pinyinname", "string", "OldAccountFriend", "");
    C_USERNAME = new Column("username", "string", "OldAccountFriend", "");
    ipG = new Column("seq", "int", "OldAccountFriend", "");
    hCU = "encryptUsername".hashCode();
    ipL = "oldUsername".hashCode();
    hny = "ticket".hashCode();
    hwF = "nickname".hashCode();
    ipM = "addState".hashCode();
    hCO = "showHead".hashCode();
    ipN = "pinyinName".hashCode();
    username_HASHCODE = "username".hashCode();
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
      if (hCU != k) {
        break label60;
      }
      this.field_encryptUsername = paramCursor.getString(i);
    }
    for (;;)
    {
      i += 1;
      break label20;
      break;
      label60:
      if (ipL == k) {
        this.field_oldUsername = paramCursor.getString(i);
      } else if (hny == k) {
        this.field_ticket = paramCursor.getString(i);
      } else if (hwF == k) {
        this.field_nickname = paramCursor.getString(i);
      } else if (ipM == k) {
        this.field_addState = paramCursor.getInt(i);
      } else if (hCO == k) {
        this.field_showHead = paramCursor.getInt(i);
      } else if (ipN == k) {
        this.field_pinyinName = paramCursor.getString(i);
      } else if (username_HASHCODE == k) {
        this.field_username = paramCursor.getString(i);
      } else if (ipO == k) {
        this.field_seq = paramCursor.getInt(i);
      } else if (rowid_HASHCODE == k) {
        this.systemRowid = paramCursor.getLong(i);
      }
    }
  }
  
  public ContentValues convertTo()
  {
    ContentValues localContentValues = new ContentValues();
    if (this.hCB) {
      localContentValues.put("encryptUsername", this.field_encryptUsername);
    }
    if (this.ipH) {
      localContentValues.put("oldUsername", this.field_oldUsername);
    }
    if (this.hnw) {
      localContentValues.put("ticket", this.field_ticket);
    }
    if (this.hwB) {
      localContentValues.put("nickname", this.field_nickname);
    }
    if (this.ipI) {
      localContentValues.put("addState", Integer.valueOf(this.field_addState));
    }
    if (this.hCv) {
      localContentValues.put("showHead", Integer.valueOf(this.field_showHead));
    }
    if (this.ipJ) {
      localContentValues.put("pinyinName", this.field_pinyinName);
    }
    if (this.__hadSetusername) {
      localContentValues.put("username", this.field_username);
    }
    if (this.ipK) {
      localContentValues.put("seq", Integer.valueOf(this.field_seq));
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
    return "OldAccountFriend";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.f.c.fd
 * JD-Core Version:    0.7.0.1
 */