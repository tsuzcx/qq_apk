package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;

public abstract class aj
  extends c
{
  public static final String[] INDEX_CREATE = new String[0];
  private static final int eEd = "userName".hashCode();
  private static final int eJR = "qyUin".hashCode();
  private static final int eJS = "userUin".hashCode();
  private static final int eJT = "userFlag".hashCode();
  private static final int eJU = "wwExposeTimes".hashCode();
  private static final int eJV = "wwMaxExposeTimes".hashCode();
  private static final int eJW = "wwCorpId".hashCode();
  private static final int eJX = "wwUserVid".hashCode();
  private static final int eJY = "userType".hashCode();
  private static final int eJZ = "chatOpen".hashCode();
  private static final int eKa = "wwUnreadCnt".hashCode();
  private static final int eKb = "show_confirm".hashCode();
  private static final int eKc = "use_preset_banner_tips".hashCode();
  private static final int eKd = "hide_create_chat".hashCode();
  private static final int eKe = "hide_mod_chat_member".hashCode();
  private static final int eKf = "hide_colleage_invite".hashCode();
  private static final int eKg = "raw_attrs".hashCode();
  private static final int rowid_HASHCODE = "rowid".hashCode();
  private boolean eDG = true;
  private boolean eJB = true;
  private boolean eJC = true;
  private boolean eJD = true;
  private boolean eJE = true;
  private boolean eJF = true;
  private boolean eJG = true;
  private boolean eJH = true;
  private boolean eJI = true;
  private boolean eJJ = true;
  private boolean eJK = true;
  private boolean eJL = true;
  private boolean eJM = true;
  private boolean eJN = true;
  private boolean eJO = true;
  private boolean eJP = true;
  private boolean eJQ = true;
  public boolean field_chatOpen;
  public boolean field_hide_colleage_invite;
  public boolean field_hide_create_chat;
  public boolean field_hide_mod_chat_member;
  public int field_qyUin;
  public byte[] field_raw_attrs;
  public boolean field_show_confirm;
  public boolean field_use_preset_banner_tips;
  public int field_userFlag;
  public String field_userName;
  public int field_userType;
  public int field_userUin;
  public long field_wwCorpId;
  public int field_wwExposeTimes;
  public int field_wwMaxExposeTimes;
  public int field_wwUnreadCnt;
  public long field_wwUserVid;
  
  public void convertFrom(Cursor paramCursor)
  {
    String[] arrayOfString = paramCursor.getColumnNames();
    if (arrayOfString == null) {
      return;
    }
    int j = arrayOfString.length;
    int i = 0;
    label20:
    int k;
    if (i < j)
    {
      k = arrayOfString[i].hashCode();
      if (eEd != k) {
        break label65;
      }
      this.field_userName = paramCursor.getString(i);
      this.eDG = true;
    }
    for (;;)
    {
      i += 1;
      break label20;
      break;
      label65:
      if (eJR == k)
      {
        this.field_qyUin = paramCursor.getInt(i);
      }
      else if (eJS == k)
      {
        this.field_userUin = paramCursor.getInt(i);
      }
      else if (eJT == k)
      {
        this.field_userFlag = paramCursor.getInt(i);
      }
      else if (eJU == k)
      {
        this.field_wwExposeTimes = paramCursor.getInt(i);
      }
      else if (eJV == k)
      {
        this.field_wwMaxExposeTimes = paramCursor.getInt(i);
      }
      else if (eJW == k)
      {
        this.field_wwCorpId = paramCursor.getLong(i);
      }
      else if (eJX == k)
      {
        this.field_wwUserVid = paramCursor.getLong(i);
      }
      else if (eJY == k)
      {
        this.field_userType = paramCursor.getInt(i);
      }
      else
      {
        boolean bool;
        if (eJZ == k)
        {
          if (paramCursor.getInt(i) != 0) {}
          for (bool = true;; bool = false)
          {
            this.field_chatOpen = bool;
            break;
          }
        }
        if (eKa == k)
        {
          this.field_wwUnreadCnt = paramCursor.getInt(i);
        }
        else
        {
          if (eKb == k)
          {
            if (paramCursor.getInt(i) != 0) {}
            for (bool = true;; bool = false)
            {
              this.field_show_confirm = bool;
              break;
            }
          }
          if (eKc == k)
          {
            if (paramCursor.getInt(i) != 0) {}
            for (bool = true;; bool = false)
            {
              this.field_use_preset_banner_tips = bool;
              break;
            }
          }
          if (eKd == k)
          {
            if (paramCursor.getInt(i) != 0) {}
            for (bool = true;; bool = false)
            {
              this.field_hide_create_chat = bool;
              break;
            }
          }
          if (eKe == k)
          {
            if (paramCursor.getInt(i) != 0) {}
            for (bool = true;; bool = false)
            {
              this.field_hide_mod_chat_member = bool;
              break;
            }
          }
          if (eKf == k)
          {
            if (paramCursor.getInt(i) != 0) {}
            for (bool = true;; bool = false)
            {
              this.field_hide_colleage_invite = bool;
              break;
            }
          }
          if (eKg == k) {
            this.field_raw_attrs = paramCursor.getBlob(i);
          } else if (rowid_HASHCODE == k) {
            this.systemRowid = paramCursor.getLong(i);
          }
        }
      }
    }
  }
  
  public ContentValues convertTo()
  {
    ContentValues localContentValues = new ContentValues();
    if (this.eDG) {
      localContentValues.put("userName", this.field_userName);
    }
    if (this.eJB) {
      localContentValues.put("qyUin", Integer.valueOf(this.field_qyUin));
    }
    if (this.eJC) {
      localContentValues.put("userUin", Integer.valueOf(this.field_userUin));
    }
    if (this.eJD) {
      localContentValues.put("userFlag", Integer.valueOf(this.field_userFlag));
    }
    if (this.eJE) {
      localContentValues.put("wwExposeTimes", Integer.valueOf(this.field_wwExposeTimes));
    }
    if (this.eJF) {
      localContentValues.put("wwMaxExposeTimes", Integer.valueOf(this.field_wwMaxExposeTimes));
    }
    if (this.eJG) {
      localContentValues.put("wwCorpId", Long.valueOf(this.field_wwCorpId));
    }
    if (this.eJH) {
      localContentValues.put("wwUserVid", Long.valueOf(this.field_wwUserVid));
    }
    if (this.eJI) {
      localContentValues.put("userType", Integer.valueOf(this.field_userType));
    }
    if (this.eJJ) {
      localContentValues.put("chatOpen", Boolean.valueOf(this.field_chatOpen));
    }
    if (this.eJK) {
      localContentValues.put("wwUnreadCnt", Integer.valueOf(this.field_wwUnreadCnt));
    }
    if (this.eJL) {
      localContentValues.put("show_confirm", Boolean.valueOf(this.field_show_confirm));
    }
    if (this.eJM) {
      localContentValues.put("use_preset_banner_tips", Boolean.valueOf(this.field_use_preset_banner_tips));
    }
    if (this.eJN) {
      localContentValues.put("hide_create_chat", Boolean.valueOf(this.field_hide_create_chat));
    }
    if (this.eJO) {
      localContentValues.put("hide_mod_chat_member", Boolean.valueOf(this.field_hide_mod_chat_member));
    }
    if (this.eJP) {
      localContentValues.put("hide_colleage_invite", Boolean.valueOf(this.field_hide_colleage_invite));
    }
    if (this.eJQ) {
      localContentValues.put("raw_attrs", this.field_raw_attrs);
    }
    if (this.systemRowid > 0L) {
      localContentValues.put("rowid", Long.valueOf(this.systemRowid));
    }
    return localContentValues;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.g.c.aj
 * JD-Core Version:    0.7.0.1
 */