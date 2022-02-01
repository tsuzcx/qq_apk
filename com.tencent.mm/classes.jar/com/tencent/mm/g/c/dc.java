package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;

public abstract class dc
  extends c
{
  public static final String[] INDEX_CREATE = new String[0];
  private static final int eDc = "status".hashCode();
  private static final int eFp;
  private static final int eKP;
  private static final int fdY = "googleid".hashCode();
  private static final int fdZ = "googlename".hashCode();
  private static final int fea = "googlephotourl".hashCode();
  private static final int feb = "googlegmail".hashCode();
  private static final int fec;
  private static final int fed;
  private static final int fee;
  private static final int fef;
  private static final int feg;
  private static final int feh = "googleitemid".hashCode();
  private static final int fei = "googlecgistatus".hashCode();
  private static final int fej = "contecttype".hashCode();
  private static final int fek = "googlenamepy".hashCode();
  private static final int rowid_HASHCODE = "rowid".hashCode();
  private boolean eCZ = true;
  private boolean eFm = true;
  private boolean eKL = true;
  private boolean fdL = true;
  private boolean fdM = true;
  private boolean fdN = true;
  private boolean fdO = true;
  private boolean fdP = true;
  private boolean fdQ = true;
  private boolean fdR = true;
  private boolean fdS = true;
  private boolean fdT = true;
  private boolean fdU = true;
  private boolean fdV = true;
  private boolean fdW = true;
  private boolean fdX = true;
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
  
  static
  {
    eFp = "username".hashCode();
    eKP = "nickname".hashCode();
    fec = "nicknameqp".hashCode();
    fed = "usernamepy".hashCode();
    fee = "small_url".hashCode();
    fef = "big_url".hashCode();
    feg = "ret".hashCode();
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
      if (fdY != k) {
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
      if (fdZ == k)
      {
        this.field_googlename = paramCursor.getString(i);
      }
      else if (fea == k)
      {
        this.field_googlephotourl = paramCursor.getString(i);
      }
      else if (feb == k)
      {
        this.field_googlegmail = paramCursor.getString(i);
      }
      else if (eFp == k)
      {
        this.field_username = paramCursor.getString(i);
      }
      else if (eKP == k)
      {
        this.field_nickname = paramCursor.getString(i);
      }
      else if (fec == k)
      {
        this.field_nicknameqp = paramCursor.getString(i);
      }
      else if (fed == k)
      {
        this.field_usernamepy = paramCursor.getString(i);
      }
      else if (fee == k)
      {
        this.field_small_url = paramCursor.getString(i);
      }
      else if (fef == k)
      {
        this.field_big_url = paramCursor.getString(i);
      }
      else if (feg == k)
      {
        this.field_ret = paramCursor.getInt(i);
      }
      else if (eDc == k)
      {
        this.field_status = paramCursor.getInt(i);
      }
      else if (feh == k)
      {
        this.field_googleitemid = paramCursor.getString(i);
        this.fdU = true;
      }
      else if (fei == k)
      {
        this.field_googlecgistatus = paramCursor.getInt(i);
      }
      else if (fej == k)
      {
        this.field_contecttype = paramCursor.getString(i);
      }
      else if (fek == k)
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
    if (this.fdL) {
      localContentValues.put("googleid", this.field_googleid);
    }
    if (this.fdM) {
      localContentValues.put("googlename", this.field_googlename);
    }
    if (this.fdN) {
      localContentValues.put("googlephotourl", this.field_googlephotourl);
    }
    if (this.fdO) {
      localContentValues.put("googlegmail", this.field_googlegmail);
    }
    if (this.eFm) {
      localContentValues.put("username", this.field_username);
    }
    if (this.eKL) {
      localContentValues.put("nickname", this.field_nickname);
    }
    if (this.fdP) {
      localContentValues.put("nicknameqp", this.field_nicknameqp);
    }
    if (this.fdQ) {
      localContentValues.put("usernamepy", this.field_usernamepy);
    }
    if (this.fdR) {
      localContentValues.put("small_url", this.field_small_url);
    }
    if (this.fdS) {
      localContentValues.put("big_url", this.field_big_url);
    }
    if (this.fdT) {
      localContentValues.put("ret", Integer.valueOf(this.field_ret));
    }
    if (this.eCZ) {
      localContentValues.put("status", Integer.valueOf(this.field_status));
    }
    if (this.fdU) {
      localContentValues.put("googleitemid", this.field_googleitemid);
    }
    if (this.fdV) {
      localContentValues.put("googlecgistatus", Integer.valueOf(this.field_googlecgistatus));
    }
    if (this.fdW) {
      localContentValues.put("contecttype", this.field_contecttype);
    }
    if (this.fdX) {
      localContentValues.put("googlenamepy", this.field_googlenamepy);
    }
    if (this.systemRowid > 0L) {
      localContentValues.put("rowid", Long.valueOf(this.systemRowid));
    }
    return localContentValues;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.g.c.dc
 * JD-Core Version:    0.7.0.1
 */