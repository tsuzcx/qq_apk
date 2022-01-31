package com.tencent.mm.h.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;

public abstract class ca
  extends c
{
  private static final int cMc;
  private static final int cMd;
  private static final int cMe;
  private static final int cMf;
  private static final int cMg;
  private static final int cMh;
  private static final int cMi;
  private static final int cMj;
  private static final int cMk;
  private static final int cMl = "googleitemid".hashCode();
  private static final int cMm = "googlecgistatus".hashCode();
  private static final int cMn = "contecttype".hashCode();
  private static final int cMo = "googlenamepy".hashCode();
  public static final String[] cqY = new String[0];
  private static final int crh = "rowid".hashCode();
  private static final int crn;
  private static final int ctF;
  private static final int cyS;
  private boolean cLP = true;
  private boolean cLQ = true;
  private boolean cLR = true;
  private boolean cLS = true;
  private boolean cLT = true;
  private boolean cLU = true;
  private boolean cLV = true;
  private boolean cLW = true;
  private boolean cLX = true;
  private boolean cLY = true;
  private boolean cLZ = true;
  private boolean cMa = true;
  private boolean cMb = true;
  private boolean crk = true;
  private boolean ctD = true;
  private boolean cyO = true;
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
    cMc = "googleid".hashCode();
    cMd = "googlename".hashCode();
    cMe = "googlephotourl".hashCode();
    cMf = "googlegmail".hashCode();
    ctF = "username".hashCode();
    cyS = "nickname".hashCode();
    cMg = "nicknameqp".hashCode();
    cMh = "usernamepy".hashCode();
    cMi = "small_url".hashCode();
    cMj = "big_url".hashCode();
    cMk = "ret".hashCode();
    crn = "status".hashCode();
  }
  
  public final void d(Cursor paramCursor)
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
      if (cMc != k) {
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
      if (cMd == k)
      {
        this.field_googlename = paramCursor.getString(i);
      }
      else if (cMe == k)
      {
        this.field_googlephotourl = paramCursor.getString(i);
      }
      else if (cMf == k)
      {
        this.field_googlegmail = paramCursor.getString(i);
      }
      else if (ctF == k)
      {
        this.field_username = paramCursor.getString(i);
      }
      else if (cyS == k)
      {
        this.field_nickname = paramCursor.getString(i);
      }
      else if (cMg == k)
      {
        this.field_nicknameqp = paramCursor.getString(i);
      }
      else if (cMh == k)
      {
        this.field_usernamepy = paramCursor.getString(i);
      }
      else if (cMi == k)
      {
        this.field_small_url = paramCursor.getString(i);
      }
      else if (cMj == k)
      {
        this.field_big_url = paramCursor.getString(i);
      }
      else if (cMk == k)
      {
        this.field_ret = paramCursor.getInt(i);
      }
      else if (crn == k)
      {
        this.field_status = paramCursor.getInt(i);
      }
      else if (cMl == k)
      {
        this.field_googleitemid = paramCursor.getString(i);
        this.cLY = true;
      }
      else if (cMm == k)
      {
        this.field_googlecgistatus = paramCursor.getInt(i);
      }
      else if (cMn == k)
      {
        this.field_contecttype = paramCursor.getString(i);
      }
      else if (cMo == k)
      {
        this.field_googlenamepy = paramCursor.getString(i);
      }
      else if (crh == k)
      {
        this.ujK = paramCursor.getLong(i);
      }
    }
  }
  
  public final ContentValues vf()
  {
    ContentValues localContentValues = new ContentValues();
    if (this.cLP) {
      localContentValues.put("googleid", this.field_googleid);
    }
    if (this.cLQ) {
      localContentValues.put("googlename", this.field_googlename);
    }
    if (this.cLR) {
      localContentValues.put("googlephotourl", this.field_googlephotourl);
    }
    if (this.cLS) {
      localContentValues.put("googlegmail", this.field_googlegmail);
    }
    if (this.ctD) {
      localContentValues.put("username", this.field_username);
    }
    if (this.cyO) {
      localContentValues.put("nickname", this.field_nickname);
    }
    if (this.cLT) {
      localContentValues.put("nicknameqp", this.field_nicknameqp);
    }
    if (this.cLU) {
      localContentValues.put("usernamepy", this.field_usernamepy);
    }
    if (this.cLV) {
      localContentValues.put("small_url", this.field_small_url);
    }
    if (this.cLW) {
      localContentValues.put("big_url", this.field_big_url);
    }
    if (this.cLX) {
      localContentValues.put("ret", Integer.valueOf(this.field_ret));
    }
    if (this.crk) {
      localContentValues.put("status", Integer.valueOf(this.field_status));
    }
    if (this.cLY) {
      localContentValues.put("googleitemid", this.field_googleitemid);
    }
    if (this.cLZ) {
      localContentValues.put("googlecgistatus", Integer.valueOf(this.field_googlecgistatus));
    }
    if (this.cMa) {
      localContentValues.put("contecttype", this.field_contecttype);
    }
    if (this.cMb) {
      localContentValues.put("googlenamepy", this.field_googlenamepy);
    }
    if (this.ujK > 0L) {
      localContentValues.put("rowid", Long.valueOf(this.ujK));
    }
    return localContentValues;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.h.c.ca
 * JD-Core Version:    0.7.0.1
 */