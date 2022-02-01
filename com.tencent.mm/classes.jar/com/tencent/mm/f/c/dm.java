package com.tencent.mm.f.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.storage.IAutoDBItem;
import com.tencent.mm.sdk.storage.sql.Column;
import com.tencent.mm.sdk.storage.sql.SingleTable;

public abstract class dm
  extends IAutoDBItem
{
  public static final Column C_ROWID;
  public static final Column C_USERNAME;
  public static final String[] INDEX_CREATE = new String[0];
  public static final SingleTable TABLE = new SingleTable("GoogleFriend");
  private static final int hmC = "status".hashCode();
  public static final Column hmw;
  public static final Column huB;
  private static final int hwF;
  public static final Column hwx;
  private static final int ibE;
  private static final int ibF;
  private static final int ibG;
  private static final int ibH;
  private static final int ibI;
  private static final int ibJ;
  private static final int ibK;
  private static final int ibL;
  private static final int ibM;
  private static final int ibN = "googleitemid".hashCode();
  private static final int ibO = "googlecgistatus".hashCode();
  private static final int ibP = "contecttype".hashCode();
  private static final int ibQ = "googlenamepy".hashCode();
  public static final Column ibf;
  public static final Column ibg;
  public static final Column ibh;
  public static final Column ibi;
  public static final Column ibj;
  public static final Column ibk;
  public static final Column ibl;
  public static final Column ibm;
  public static final Column ibn;
  public static final Column ibo;
  public static final Column ibp;
  public static final Column ibq;
  private static final int rowid_HASHCODE = "rowid".hashCode();
  private static final int username_HASHCODE;
  private boolean __hadSetusername = true;
  public String field_big_url;
  public String field_contecttype;
  public int field_googlecgistatus;
  public String field_googlegmail;
  public String field_googleid;
  public String field_googleitemid;
  public String field_googlename;
  public String field_googlenamepy;
  public String field_googlephotourl;
  public String field_nickname;
  public String field_nicknameqp;
  public int field_ret;
  public String field_small_url;
  public int field_status;
  public String field_username;
  public String field_usernamepy;
  private boolean hmz = true;
  private boolean hwB = true;
  private boolean ibA = true;
  private boolean ibB = true;
  private boolean ibC = true;
  private boolean ibD = true;
  private boolean ibr = true;
  private boolean ibs = true;
  private boolean ibt = true;
  private boolean ibu = true;
  private boolean ibv = true;
  private boolean ibw = true;
  private boolean ibx = true;
  private boolean iby = true;
  private boolean ibz = true;
  
  static
  {
    C_ROWID = new Column("rowid", "long", "GoogleFriend", "");
    ibf = new Column("googleid", "string", "GoogleFriend", "");
    ibg = new Column("googlename", "string", "GoogleFriend", "");
    ibh = new Column("googlephotourl", "string", "GoogleFriend", "");
    ibi = new Column("googlegmail", "string", "GoogleFriend", "");
    C_USERNAME = new Column("username", "string", "GoogleFriend", "");
    hwx = new Column("nickname", "string", "GoogleFriend", "");
    ibj = new Column("nicknameqp", "string", "GoogleFriend", "");
    huB = new Column("usernamepy", "string", "GoogleFriend", "");
    ibk = new Column("small_url", "string", "GoogleFriend", "");
    ibl = new Column("big_url", "string", "GoogleFriend", "");
    ibm = new Column("ret", "int", "GoogleFriend", "");
    hmw = new Column("status", "int", "GoogleFriend", "");
    ibn = new Column("googleitemid", "string", "GoogleFriend", "");
    ibo = new Column("googlecgistatus", "int", "GoogleFriend", "");
    ibp = new Column("contecttype", "string", "GoogleFriend", "");
    ibq = new Column("googlenamepy", "string", "GoogleFriend", "");
    ibE = "googleid".hashCode();
    ibF = "googlename".hashCode();
    ibG = "googlephotourl".hashCode();
    ibH = "googlegmail".hashCode();
    username_HASHCODE = "username".hashCode();
    hwF = "nickname".hashCode();
    ibI = "nicknameqp".hashCode();
    ibJ = "usernamepy".hashCode();
    ibK = "small_url".hashCode();
    ibL = "big_url".hashCode();
    ibM = "ret".hashCode();
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
      if (ibE != k) {
        break label60;
      }
      this.field_googleid = paramCursor.getString(i);
    }
    for (;;)
    {
      i += 1;
      break label20;
      break;
      label60:
      if (ibF == k)
      {
        this.field_googlename = paramCursor.getString(i);
      }
      else if (ibG == k)
      {
        this.field_googlephotourl = paramCursor.getString(i);
      }
      else if (ibH == k)
      {
        this.field_googlegmail = paramCursor.getString(i);
      }
      else if (username_HASHCODE == k)
      {
        this.field_username = paramCursor.getString(i);
      }
      else if (hwF == k)
      {
        this.field_nickname = paramCursor.getString(i);
      }
      else if (ibI == k)
      {
        this.field_nicknameqp = paramCursor.getString(i);
      }
      else if (ibJ == k)
      {
        this.field_usernamepy = paramCursor.getString(i);
      }
      else if (ibK == k)
      {
        this.field_small_url = paramCursor.getString(i);
      }
      else if (ibL == k)
      {
        this.field_big_url = paramCursor.getString(i);
      }
      else if (ibM == k)
      {
        this.field_ret = paramCursor.getInt(i);
      }
      else if (hmC == k)
      {
        this.field_status = paramCursor.getInt(i);
      }
      else if (ibN == k)
      {
        this.field_googleitemid = paramCursor.getString(i);
        this.ibA = true;
      }
      else if (ibO == k)
      {
        this.field_googlecgistatus = paramCursor.getInt(i);
      }
      else if (ibP == k)
      {
        this.field_contecttype = paramCursor.getString(i);
      }
      else if (ibQ == k)
      {
        this.field_googlenamepy = paramCursor.getString(i);
      }
      else if (rowid_HASHCODE == k)
      {
        this.systemRowid = paramCursor.getLong(i);
      }
    }
  }
  
  public ContentValues convertTo()
  {
    ContentValues localContentValues = new ContentValues();
    if (this.ibr) {
      localContentValues.put("googleid", this.field_googleid);
    }
    if (this.ibs) {
      localContentValues.put("googlename", this.field_googlename);
    }
    if (this.ibt) {
      localContentValues.put("googlephotourl", this.field_googlephotourl);
    }
    if (this.ibu) {
      localContentValues.put("googlegmail", this.field_googlegmail);
    }
    if (this.__hadSetusername) {
      localContentValues.put("username", this.field_username);
    }
    if (this.hwB) {
      localContentValues.put("nickname", this.field_nickname);
    }
    if (this.ibv) {
      localContentValues.put("nicknameqp", this.field_nicknameqp);
    }
    if (this.ibw) {
      localContentValues.put("usernamepy", this.field_usernamepy);
    }
    if (this.ibx) {
      localContentValues.put("small_url", this.field_small_url);
    }
    if (this.iby) {
      localContentValues.put("big_url", this.field_big_url);
    }
    if (this.ibz) {
      localContentValues.put("ret", Integer.valueOf(this.field_ret));
    }
    if (this.hmz) {
      localContentValues.put("status", Integer.valueOf(this.field_status));
    }
    if (this.ibA) {
      localContentValues.put("googleitemid", this.field_googleitemid);
    }
    if (this.ibB) {
      localContentValues.put("googlecgistatus", Integer.valueOf(this.field_googlecgistatus));
    }
    if (this.ibC) {
      localContentValues.put("contecttype", this.field_contecttype);
    }
    if (this.ibD) {
      localContentValues.put("googlenamepy", this.field_googlenamepy);
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
    return "GoogleFriend";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.f.c.dm
 * JD-Core Version:    0.7.0.1
 */