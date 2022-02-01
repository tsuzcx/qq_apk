package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;

public abstract class dc
  extends c
{
  public static final String[] INDEX_CREATE = new String[0];
  private static final int eEL = "status".hashCode();
  private static final int eGY;
  private static final int eMy;
  private static final int ffR = "googleid".hashCode();
  private static final int ffS = "googlename".hashCode();
  private static final int ffT = "googlephotourl".hashCode();
  private static final int ffU = "googlegmail".hashCode();
  private static final int ffV;
  private static final int ffW;
  private static final int ffX;
  private static final int ffY;
  private static final int ffZ;
  private static final int fga = "googleitemid".hashCode();
  private static final int fgb = "googlecgistatus".hashCode();
  private static final int fgc = "contecttype".hashCode();
  private static final int fgd = "googlenamepy".hashCode();
  private static final int rowid_HASHCODE = "rowid".hashCode();
  private boolean eEI = true;
  private boolean eGV = true;
  private boolean eMu = true;
  private boolean ffE = true;
  private boolean ffF = true;
  private boolean ffG = true;
  private boolean ffH = true;
  private boolean ffI = true;
  private boolean ffJ = true;
  private boolean ffK = true;
  private boolean ffL = true;
  private boolean ffM = true;
  private boolean ffN = true;
  private boolean ffO = true;
  private boolean ffP = true;
  private boolean ffQ = true;
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
    eGY = "username".hashCode();
    eMy = "nickname".hashCode();
    ffV = "nicknameqp".hashCode();
    ffW = "usernamepy".hashCode();
    ffX = "small_url".hashCode();
    ffY = "big_url".hashCode();
    ffZ = "ret".hashCode();
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
      if (ffR != k) {
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
      if (ffS == k)
      {
        this.field_googlename = paramCursor.getString(i);
      }
      else if (ffT == k)
      {
        this.field_googlephotourl = paramCursor.getString(i);
      }
      else if (ffU == k)
      {
        this.field_googlegmail = paramCursor.getString(i);
      }
      else if (eGY == k)
      {
        this.field_username = paramCursor.getString(i);
      }
      else if (eMy == k)
      {
        this.field_nickname = paramCursor.getString(i);
      }
      else if (ffV == k)
      {
        this.field_nicknameqp = paramCursor.getString(i);
      }
      else if (ffW == k)
      {
        this.field_usernamepy = paramCursor.getString(i);
      }
      else if (ffX == k)
      {
        this.field_small_url = paramCursor.getString(i);
      }
      else if (ffY == k)
      {
        this.field_big_url = paramCursor.getString(i);
      }
      else if (ffZ == k)
      {
        this.field_ret = paramCursor.getInt(i);
      }
      else if (eEL == k)
      {
        this.field_status = paramCursor.getInt(i);
      }
      else if (fga == k)
      {
        this.field_googleitemid = paramCursor.getString(i);
        this.ffN = true;
      }
      else if (fgb == k)
      {
        this.field_googlecgistatus = paramCursor.getInt(i);
      }
      else if (fgc == k)
      {
        this.field_contecttype = paramCursor.getString(i);
      }
      else if (fgd == k)
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
    if (this.ffE) {
      localContentValues.put("googleid", this.field_googleid);
    }
    if (this.ffF) {
      localContentValues.put("googlename", this.field_googlename);
    }
    if (this.ffG) {
      localContentValues.put("googlephotourl", this.field_googlephotourl);
    }
    if (this.ffH) {
      localContentValues.put("googlegmail", this.field_googlegmail);
    }
    if (this.eGV) {
      localContentValues.put("username", this.field_username);
    }
    if (this.eMu) {
      localContentValues.put("nickname", this.field_nickname);
    }
    if (this.ffI) {
      localContentValues.put("nicknameqp", this.field_nicknameqp);
    }
    if (this.ffJ) {
      localContentValues.put("usernamepy", this.field_usernamepy);
    }
    if (this.ffK) {
      localContentValues.put("small_url", this.field_small_url);
    }
    if (this.ffL) {
      localContentValues.put("big_url", this.field_big_url);
    }
    if (this.ffM) {
      localContentValues.put("ret", Integer.valueOf(this.field_ret));
    }
    if (this.eEI) {
      localContentValues.put("status", Integer.valueOf(this.field_status));
    }
    if (this.ffN) {
      localContentValues.put("googleitemid", this.field_googleitemid);
    }
    if (this.ffO) {
      localContentValues.put("googlecgistatus", Integer.valueOf(this.field_googlecgistatus));
    }
    if (this.ffP) {
      localContentValues.put("contecttype", this.field_contecttype);
    }
    if (this.ffQ) {
      localContentValues.put("googlenamepy", this.field_googlenamepy);
    }
    if (this.systemRowid > 0L) {
      localContentValues.put("rowid", Long.valueOf(this.systemRowid));
    }
    return localContentValues;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.g.c.dc
 * JD-Core Version:    0.7.0.1
 */