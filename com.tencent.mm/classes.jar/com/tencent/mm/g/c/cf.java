package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;

public abstract class cf
  extends c
{
  public static final String[] INDEX_CREATE = new String[0];
  private static final int dBS = "googleid".hashCode();
  private static final int dBT = "googlename".hashCode();
  private static final int dBU = "googlephotourl".hashCode();
  private static final int dBV = "googlegmail".hashCode();
  private static final int dBW;
  private static final int dBX;
  private static final int dBY;
  private static final int dBZ;
  private static final int dCa;
  private static final int dCb = "googleitemid".hashCode();
  private static final int dCc = "googlecgistatus".hashCode();
  private static final int dCd = "contecttype".hashCode();
  private static final int dCe = "googlenamepy".hashCode();
  private static final int dfJ;
  private static final int dhU = "username".hashCode();
  private static final int dmT = "nickname".hashCode();
  private static final int rowid_HASHCODE = "rowid".hashCode();
  private boolean dBF = true;
  private boolean dBG = true;
  private boolean dBH = true;
  private boolean dBI = true;
  private boolean dBJ = true;
  private boolean dBK = true;
  private boolean dBL = true;
  private boolean dBM = true;
  private boolean dBN = true;
  private boolean dBO = true;
  private boolean dBP = true;
  private boolean dBQ = true;
  private boolean dBR = true;
  private boolean dfG = true;
  private boolean dhS = true;
  private boolean dmP = true;
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
    dBW = "nicknameqp".hashCode();
    dBX = "usernamepy".hashCode();
    dBY = "small_url".hashCode();
    dBZ = "big_url".hashCode();
    dCa = "ret".hashCode();
    dfJ = "status".hashCode();
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
      if (dBS != k) {
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
      if (dBT == k)
      {
        this.field_googlename = paramCursor.getString(i);
      }
      else if (dBU == k)
      {
        this.field_googlephotourl = paramCursor.getString(i);
      }
      else if (dBV == k)
      {
        this.field_googlegmail = paramCursor.getString(i);
      }
      else if (dhU == k)
      {
        this.field_username = paramCursor.getString(i);
      }
      else if (dmT == k)
      {
        this.field_nickname = paramCursor.getString(i);
      }
      else if (dBW == k)
      {
        this.field_nicknameqp = paramCursor.getString(i);
      }
      else if (dBX == k)
      {
        this.field_usernamepy = paramCursor.getString(i);
      }
      else if (dBY == k)
      {
        this.field_small_url = paramCursor.getString(i);
      }
      else if (dBZ == k)
      {
        this.field_big_url = paramCursor.getString(i);
      }
      else if (dCa == k)
      {
        this.field_ret = paramCursor.getInt(i);
      }
      else if (dfJ == k)
      {
        this.field_status = paramCursor.getInt(i);
      }
      else if (dCb == k)
      {
        this.field_googleitemid = paramCursor.getString(i);
        this.dBO = true;
      }
      else if (dCc == k)
      {
        this.field_googlecgistatus = paramCursor.getInt(i);
      }
      else if (dCd == k)
      {
        this.field_contecttype = paramCursor.getString(i);
      }
      else if (dCe == k)
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
    if (this.dBF) {
      localContentValues.put("googleid", this.field_googleid);
    }
    if (this.dBG) {
      localContentValues.put("googlename", this.field_googlename);
    }
    if (this.dBH) {
      localContentValues.put("googlephotourl", this.field_googlephotourl);
    }
    if (this.dBI) {
      localContentValues.put("googlegmail", this.field_googlegmail);
    }
    if (this.dhS) {
      localContentValues.put("username", this.field_username);
    }
    if (this.dmP) {
      localContentValues.put("nickname", this.field_nickname);
    }
    if (this.dBJ) {
      localContentValues.put("nicknameqp", this.field_nicknameqp);
    }
    if (this.dBK) {
      localContentValues.put("usernamepy", this.field_usernamepy);
    }
    if (this.dBL) {
      localContentValues.put("small_url", this.field_small_url);
    }
    if (this.dBM) {
      localContentValues.put("big_url", this.field_big_url);
    }
    if (this.dBN) {
      localContentValues.put("ret", Integer.valueOf(this.field_ret));
    }
    if (this.dfG) {
      localContentValues.put("status", Integer.valueOf(this.field_status));
    }
    if (this.dBO) {
      localContentValues.put("googleitemid", this.field_googleitemid);
    }
    if (this.dBP) {
      localContentValues.put("googlecgistatus", Integer.valueOf(this.field_googlecgistatus));
    }
    if (this.dBQ) {
      localContentValues.put("contecttype", this.field_contecttype);
    }
    if (this.dBR) {
      localContentValues.put("googlenamepy", this.field_googlenamepy);
    }
    if (this.systemRowid > 0L) {
      localContentValues.put("rowid", Long.valueOf(this.systemRowid));
    }
    return localContentValues;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.g.c.cf
 * JD-Core Version:    0.7.0.1
 */