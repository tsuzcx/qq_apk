package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;

public abstract class cr
  extends c
{
  public static final String[] INDEX_CREATE = new String[0];
  private static final int eIO = "googleid".hashCode();
  private static final int eIP = "googlename".hashCode();
  private static final int eIQ = "googlephotourl".hashCode();
  private static final int eIR = "googlegmail".hashCode();
  private static final int eIS;
  private static final int eIT;
  private static final int eIU;
  private static final int eIV;
  private static final int eIW;
  private static final int eIX = "googleitemid".hashCode();
  private static final int eIY = "googlecgistatus".hashCode();
  private static final int eIZ = "contecttype".hashCode();
  private static final int eJa = "googlenamepy".hashCode();
  private static final int ejR;
  private static final int eme = "username".hashCode();
  private static final int erC = "nickname".hashCode();
  private static final int rowid_HASHCODE = "rowid".hashCode();
  private boolean eIB = true;
  private boolean eIC = true;
  private boolean eID = true;
  private boolean eIE = true;
  private boolean eIF = true;
  private boolean eIG = true;
  private boolean eIH = true;
  private boolean eII = true;
  private boolean eIJ = true;
  private boolean eIK = true;
  private boolean eIL = true;
  private boolean eIM = true;
  private boolean eIN = true;
  private boolean ejO = true;
  private boolean emb = true;
  private boolean ery = true;
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
    eIS = "nicknameqp".hashCode();
    eIT = "usernamepy".hashCode();
    eIU = "small_url".hashCode();
    eIV = "big_url".hashCode();
    eIW = "ret".hashCode();
    ejR = "status".hashCode();
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
      if (eIO != k) {
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
      if (eIP == k)
      {
        this.field_googlename = paramCursor.getString(i);
      }
      else if (eIQ == k)
      {
        this.field_googlephotourl = paramCursor.getString(i);
      }
      else if (eIR == k)
      {
        this.field_googlegmail = paramCursor.getString(i);
      }
      else if (eme == k)
      {
        this.field_username = paramCursor.getString(i);
      }
      else if (erC == k)
      {
        this.field_nickname = paramCursor.getString(i);
      }
      else if (eIS == k)
      {
        this.field_nicknameqp = paramCursor.getString(i);
      }
      else if (eIT == k)
      {
        this.field_usernamepy = paramCursor.getString(i);
      }
      else if (eIU == k)
      {
        this.field_small_url = paramCursor.getString(i);
      }
      else if (eIV == k)
      {
        this.field_big_url = paramCursor.getString(i);
      }
      else if (eIW == k)
      {
        this.field_ret = paramCursor.getInt(i);
      }
      else if (ejR == k)
      {
        this.field_status = paramCursor.getInt(i);
      }
      else if (eIX == k)
      {
        this.field_googleitemid = paramCursor.getString(i);
        this.eIK = true;
      }
      else if (eIY == k)
      {
        this.field_googlecgistatus = paramCursor.getInt(i);
      }
      else if (eIZ == k)
      {
        this.field_contecttype = paramCursor.getString(i);
      }
      else if (eJa == k)
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
    if (this.eIB) {
      localContentValues.put("googleid", this.field_googleid);
    }
    if (this.eIC) {
      localContentValues.put("googlename", this.field_googlename);
    }
    if (this.eID) {
      localContentValues.put("googlephotourl", this.field_googlephotourl);
    }
    if (this.eIE) {
      localContentValues.put("googlegmail", this.field_googlegmail);
    }
    if (this.emb) {
      localContentValues.put("username", this.field_username);
    }
    if (this.ery) {
      localContentValues.put("nickname", this.field_nickname);
    }
    if (this.eIF) {
      localContentValues.put("nicknameqp", this.field_nicknameqp);
    }
    if (this.eIG) {
      localContentValues.put("usernamepy", this.field_usernamepy);
    }
    if (this.eIH) {
      localContentValues.put("small_url", this.field_small_url);
    }
    if (this.eII) {
      localContentValues.put("big_url", this.field_big_url);
    }
    if (this.eIJ) {
      localContentValues.put("ret", Integer.valueOf(this.field_ret));
    }
    if (this.ejO) {
      localContentValues.put("status", Integer.valueOf(this.field_status));
    }
    if (this.eIK) {
      localContentValues.put("googleitemid", this.field_googleitemid);
    }
    if (this.eIL) {
      localContentValues.put("googlecgistatus", Integer.valueOf(this.field_googlecgistatus));
    }
    if (this.eIM) {
      localContentValues.put("contecttype", this.field_contecttype);
    }
    if (this.eIN) {
      localContentValues.put("googlenamepy", this.field_googlenamepy);
    }
    if (this.systemRowid > 0L) {
      localContentValues.put("rowid", Long.valueOf(this.systemRowid));
    }
    return localContentValues;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.g.c.cr
 * JD-Core Version:    0.7.0.1
 */