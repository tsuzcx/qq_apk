package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.storage.IAutoDBItem;

public abstract class di
  extends IAutoDBItem
{
  public static final String[] INDEX_CREATE = new String[0];
  private static final int fKA;
  private static final int fKB;
  private static final int fKC;
  private static final int fKD = "googleitemid".hashCode();
  private static final int fKE = "googlecgistatus".hashCode();
  private static final int fKF = "contecttype".hashCode();
  private static final int fKG = "googlenamepy".hashCode();
  private static final int fKu = "googleid".hashCode();
  private static final int fKv = "googlename".hashCode();
  private static final int fKw = "googlephotourl".hashCode();
  private static final int fKx = "googlegmail".hashCode();
  private static final int fKy;
  private static final int fKz;
  private static final int fjl;
  private static final int fqf;
  private static final int rowid_HASHCODE = "rowid".hashCode();
  private static final int username_HASHCODE = "username".hashCode();
  private boolean __hadSetusername = true;
  private boolean fKh = true;
  private boolean fKi = true;
  private boolean fKj = true;
  private boolean fKk = true;
  private boolean fKl = true;
  private boolean fKm = true;
  private boolean fKn = true;
  private boolean fKo = true;
  private boolean fKp = true;
  private boolean fKq = true;
  private boolean fKr = true;
  private boolean fKs = true;
  private boolean fKt = true;
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
  private boolean fji = true;
  private boolean fqb = true;
  
  static
  {
    fqf = "nickname".hashCode();
    fKy = "nicknameqp".hashCode();
    fKz = "usernamepy".hashCode();
    fKA = "small_url".hashCode();
    fKB = "big_url".hashCode();
    fKC = "ret".hashCode();
    fjl = "status".hashCode();
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
      if (fKu != k) {
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
      if (fKv == k)
      {
        this.field_googlename = paramCursor.getString(i);
      }
      else if (fKw == k)
      {
        this.field_googlephotourl = paramCursor.getString(i);
      }
      else if (fKx == k)
      {
        this.field_googlegmail = paramCursor.getString(i);
      }
      else if (username_HASHCODE == k)
      {
        this.field_username = paramCursor.getString(i);
      }
      else if (fqf == k)
      {
        this.field_nickname = paramCursor.getString(i);
      }
      else if (fKy == k)
      {
        this.field_nicknameqp = paramCursor.getString(i);
      }
      else if (fKz == k)
      {
        this.field_usernamepy = paramCursor.getString(i);
      }
      else if (fKA == k)
      {
        this.field_small_url = paramCursor.getString(i);
      }
      else if (fKB == k)
      {
        this.field_big_url = paramCursor.getString(i);
      }
      else if (fKC == k)
      {
        this.field_ret = paramCursor.getInt(i);
      }
      else if (fjl == k)
      {
        this.field_status = paramCursor.getInt(i);
      }
      else if (fKD == k)
      {
        this.field_googleitemid = paramCursor.getString(i);
        this.fKq = true;
      }
      else if (fKE == k)
      {
        this.field_googlecgistatus = paramCursor.getInt(i);
      }
      else if (fKF == k)
      {
        this.field_contecttype = paramCursor.getString(i);
      }
      else if (fKG == k)
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
    if (this.fKh) {
      localContentValues.put("googleid", this.field_googleid);
    }
    if (this.fKi) {
      localContentValues.put("googlename", this.field_googlename);
    }
    if (this.fKj) {
      localContentValues.put("googlephotourl", this.field_googlephotourl);
    }
    if (this.fKk) {
      localContentValues.put("googlegmail", this.field_googlegmail);
    }
    if (this.__hadSetusername) {
      localContentValues.put("username", this.field_username);
    }
    if (this.fqb) {
      localContentValues.put("nickname", this.field_nickname);
    }
    if (this.fKl) {
      localContentValues.put("nicknameqp", this.field_nicknameqp);
    }
    if (this.fKm) {
      localContentValues.put("usernamepy", this.field_usernamepy);
    }
    if (this.fKn) {
      localContentValues.put("small_url", this.field_small_url);
    }
    if (this.fKo) {
      localContentValues.put("big_url", this.field_big_url);
    }
    if (this.fKp) {
      localContentValues.put("ret", Integer.valueOf(this.field_ret));
    }
    if (this.fji) {
      localContentValues.put("status", Integer.valueOf(this.field_status));
    }
    if (this.fKq) {
      localContentValues.put("googleitemid", this.field_googleitemid);
    }
    if (this.fKr) {
      localContentValues.put("googlecgistatus", Integer.valueOf(this.field_googlecgistatus));
    }
    if (this.fKs) {
      localContentValues.put("contecttype", this.field_contecttype);
    }
    if (this.fKt) {
      localContentValues.put("googlenamepy", this.field_googlenamepy);
    }
    if (this.systemRowid > 0L) {
      localContentValues.put("rowid", Long.valueOf(this.systemRowid));
    }
    return localContentValues;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.g.c.di
 * JD-Core Version:    0.7.0.1
 */