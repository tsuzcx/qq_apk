package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;

public abstract class aj
  extends c
{
  public static final String[] INDEX_CREATE = new String[0];
  private static final int emW = "userName".hashCode();
  private static final int esI = "qyUin".hashCode();
  private static final int esJ = "userUin".hashCode();
  private static final int esK = "userFlag".hashCode();
  private static final int esL = "wwExposeTimes".hashCode();
  private static final int esM = "wwMaxExposeTimes".hashCode();
  private static final int esN = "wwCorpId".hashCode();
  private static final int esO = "wwUserVid".hashCode();
  private static final int esP = "userType".hashCode();
  private static final int esQ = "chatOpen".hashCode();
  private static final int esR = "wwUnreadCnt".hashCode();
  private static final int esS = "show_confirm".hashCode();
  private static final int esT = "use_preset_banner_tips".hashCode();
  private static final int esU = "hide_create_chat".hashCode();
  private static final int esV = "hide_mod_chat_member".hashCode();
  private static final int esW = "hide_colleage_invite".hashCode();
  private static final int esX = "raw_attrs".hashCode();
  private static final int rowid_HASHCODE = "rowid".hashCode();
  private boolean emz = true;
  private boolean esA = true;
  private boolean esB = true;
  private boolean esC = true;
  private boolean esD = true;
  private boolean esE = true;
  private boolean esF = true;
  private boolean esG = true;
  private boolean esH = true;
  private boolean ess = true;
  private boolean est = true;
  private boolean esu = true;
  private boolean esv = true;
  private boolean esw = true;
  private boolean esx = true;
  private boolean esy = true;
  private boolean esz = true;
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
      if (emW != k) {
        break label65;
      }
      this.field_userName = paramCursor.getString(i);
      this.emz = true;
    }
    for (;;)
    {
      i += 1;
      break label20;
      break;
      label65:
      if (esI == k)
      {
        this.field_qyUin = paramCursor.getInt(i);
      }
      else if (esJ == k)
      {
        this.field_userUin = paramCursor.getInt(i);
      }
      else if (esK == k)
      {
        this.field_userFlag = paramCursor.getInt(i);
      }
      else if (esL == k)
      {
        this.field_wwExposeTimes = paramCursor.getInt(i);
      }
      else if (esM == k)
      {
        this.field_wwMaxExposeTimes = paramCursor.getInt(i);
      }
      else if (esN == k)
      {
        this.field_wwCorpId = paramCursor.getLong(i);
      }
      else if (esO == k)
      {
        this.field_wwUserVid = paramCursor.getLong(i);
      }
      else if (esP == k)
      {
        this.field_userType = paramCursor.getInt(i);
      }
      else
      {
        boolean bool;
        if (esQ == k)
        {
          if (paramCursor.getInt(i) != 0) {}
          for (bool = true;; bool = false)
          {
            this.field_chatOpen = bool;
            break;
          }
        }
        if (esR == k)
        {
          this.field_wwUnreadCnt = paramCursor.getInt(i);
        }
        else
        {
          if (esS == k)
          {
            if (paramCursor.getInt(i) != 0) {}
            for (bool = true;; bool = false)
            {
              this.field_show_confirm = bool;
              break;
            }
          }
          if (esT == k)
          {
            if (paramCursor.getInt(i) != 0) {}
            for (bool = true;; bool = false)
            {
              this.field_use_preset_banner_tips = bool;
              break;
            }
          }
          if (esU == k)
          {
            if (paramCursor.getInt(i) != 0) {}
            for (bool = true;; bool = false)
            {
              this.field_hide_create_chat = bool;
              break;
            }
          }
          if (esV == k)
          {
            if (paramCursor.getInt(i) != 0) {}
            for (bool = true;; bool = false)
            {
              this.field_hide_mod_chat_member = bool;
              break;
            }
          }
          if (esW == k)
          {
            if (paramCursor.getInt(i) != 0) {}
            for (bool = true;; bool = false)
            {
              this.field_hide_colleage_invite = bool;
              break;
            }
          }
          if (esX == k) {
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
    if (this.emz) {
      localContentValues.put("userName", this.field_userName);
    }
    if (this.ess) {
      localContentValues.put("qyUin", Integer.valueOf(this.field_qyUin));
    }
    if (this.est) {
      localContentValues.put("userUin", Integer.valueOf(this.field_userUin));
    }
    if (this.esu) {
      localContentValues.put("userFlag", Integer.valueOf(this.field_userFlag));
    }
    if (this.esv) {
      localContentValues.put("wwExposeTimes", Integer.valueOf(this.field_wwExposeTimes));
    }
    if (this.esw) {
      localContentValues.put("wwMaxExposeTimes", Integer.valueOf(this.field_wwMaxExposeTimes));
    }
    if (this.esx) {
      localContentValues.put("wwCorpId", Long.valueOf(this.field_wwCorpId));
    }
    if (this.esy) {
      localContentValues.put("wwUserVid", Long.valueOf(this.field_wwUserVid));
    }
    if (this.esz) {
      localContentValues.put("userType", Integer.valueOf(this.field_userType));
    }
    if (this.esA) {
      localContentValues.put("chatOpen", Boolean.valueOf(this.field_chatOpen));
    }
    if (this.esB) {
      localContentValues.put("wwUnreadCnt", Integer.valueOf(this.field_wwUnreadCnt));
    }
    if (this.esC) {
      localContentValues.put("show_confirm", Boolean.valueOf(this.field_show_confirm));
    }
    if (this.esD) {
      localContentValues.put("use_preset_banner_tips", Boolean.valueOf(this.field_use_preset_banner_tips));
    }
    if (this.esE) {
      localContentValues.put("hide_create_chat", Boolean.valueOf(this.field_hide_create_chat));
    }
    if (this.esF) {
      localContentValues.put("hide_mod_chat_member", Boolean.valueOf(this.field_hide_mod_chat_member));
    }
    if (this.esG) {
      localContentValues.put("hide_colleage_invite", Boolean.valueOf(this.field_hide_colleage_invite));
    }
    if (this.esH) {
      localContentValues.put("raw_attrs", this.field_raw_attrs);
    }
    if (this.systemRowid > 0L) {
      localContentValues.put("rowid", Long.valueOf(this.systemRowid));
    }
    return localContentValues;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.g.c.aj
 * JD-Core Version:    0.7.0.1
 */