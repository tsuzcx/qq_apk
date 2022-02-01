package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;

public abstract class ct
  extends c
{
  public static final String[] INDEX_CREATE = new String[0];
  private static final int eLG = "googleid".hashCode();
  private static final int eLH = "googlename".hashCode();
  private static final int eLI = "googlephotourl".hashCode();
  private static final int eLJ = "googlegmail".hashCode();
  private static final int eLK;
  private static final int eLL;
  private static final int eLM;
  private static final int eLN;
  private static final int eLO;
  private static final int eLP = "googleitemid".hashCode();
  private static final int eLQ = "googlecgistatus".hashCode();
  private static final int eLR = "contecttype".hashCode();
  private static final int eLS = "googlenamepy".hashCode();
  private static final int elV;
  private static final int eok = "username".hashCode();
  private static final int etG = "nickname".hashCode();
  private static final int rowid_HASHCODE = "rowid".hashCode();
  private boolean eLA = true;
  private boolean eLB = true;
  private boolean eLC = true;
  private boolean eLD = true;
  private boolean eLE = true;
  private boolean eLF = true;
  private boolean eLt = true;
  private boolean eLu = true;
  private boolean eLv = true;
  private boolean eLw = true;
  private boolean eLx = true;
  private boolean eLy = true;
  private boolean eLz = true;
  private boolean elS = true;
  private boolean eoh = true;
  private boolean etC = true;
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
    eLK = "nicknameqp".hashCode();
    eLL = "usernamepy".hashCode();
    eLM = "small_url".hashCode();
    eLN = "big_url".hashCode();
    eLO = "ret".hashCode();
    elV = "status".hashCode();
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
      if (eLG != k) {
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
      if (eLH == k)
      {
        this.field_googlename = paramCursor.getString(i);
      }
      else if (eLI == k)
      {
        this.field_googlephotourl = paramCursor.getString(i);
      }
      else if (eLJ == k)
      {
        this.field_googlegmail = paramCursor.getString(i);
      }
      else if (eok == k)
      {
        this.field_username = paramCursor.getString(i);
      }
      else if (etG == k)
      {
        this.field_nickname = paramCursor.getString(i);
      }
      else if (eLK == k)
      {
        this.field_nicknameqp = paramCursor.getString(i);
      }
      else if (eLL == k)
      {
        this.field_usernamepy = paramCursor.getString(i);
      }
      else if (eLM == k)
      {
        this.field_small_url = paramCursor.getString(i);
      }
      else if (eLN == k)
      {
        this.field_big_url = paramCursor.getString(i);
      }
      else if (eLO == k)
      {
        this.field_ret = paramCursor.getInt(i);
      }
      else if (elV == k)
      {
        this.field_status = paramCursor.getInt(i);
      }
      else if (eLP == k)
      {
        this.field_googleitemid = paramCursor.getString(i);
        this.eLC = true;
      }
      else if (eLQ == k)
      {
        this.field_googlecgistatus = paramCursor.getInt(i);
      }
      else if (eLR == k)
      {
        this.field_contecttype = paramCursor.getString(i);
      }
      else if (eLS == k)
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
    if (this.eLt) {
      localContentValues.put("googleid", this.field_googleid);
    }
    if (this.eLu) {
      localContentValues.put("googlename", this.field_googlename);
    }
    if (this.eLv) {
      localContentValues.put("googlephotourl", this.field_googlephotourl);
    }
    if (this.eLw) {
      localContentValues.put("googlegmail", this.field_googlegmail);
    }
    if (this.eoh) {
      localContentValues.put("username", this.field_username);
    }
    if (this.etC) {
      localContentValues.put("nickname", this.field_nickname);
    }
    if (this.eLx) {
      localContentValues.put("nicknameqp", this.field_nicknameqp);
    }
    if (this.eLy) {
      localContentValues.put("usernamepy", this.field_usernamepy);
    }
    if (this.eLz) {
      localContentValues.put("small_url", this.field_small_url);
    }
    if (this.eLA) {
      localContentValues.put("big_url", this.field_big_url);
    }
    if (this.eLB) {
      localContentValues.put("ret", Integer.valueOf(this.field_ret));
    }
    if (this.elS) {
      localContentValues.put("status", Integer.valueOf(this.field_status));
    }
    if (this.eLC) {
      localContentValues.put("googleitemid", this.field_googleitemid);
    }
    if (this.eLD) {
      localContentValues.put("googlecgistatus", Integer.valueOf(this.field_googlecgistatus));
    }
    if (this.eLE) {
      localContentValues.put("contecttype", this.field_contecttype);
    }
    if (this.eLF) {
      localContentValues.put("googlenamepy", this.field_googlenamepy);
    }
    if (this.systemRowid > 0L) {
      localContentValues.put("rowid", Long.valueOf(this.systemRowid));
    }
    return localContentValues;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.g.c.ct
 * JD-Core Version:    0.7.0.1
 */