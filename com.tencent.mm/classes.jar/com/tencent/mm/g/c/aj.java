package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;

public abstract class aj
  extends c
{
  public static final String[] INDEX_CREATE = new String[0];
  private static final int eFM = "userName".hashCode();
  private static final int eLA = "qyUin".hashCode();
  private static final int eLB = "userUin".hashCode();
  private static final int eLC = "userFlag".hashCode();
  private static final int eLD = "wwExposeTimes".hashCode();
  private static final int eLE = "wwMaxExposeTimes".hashCode();
  private static final int eLF = "wwCorpId".hashCode();
  private static final int eLG = "wwUserVid".hashCode();
  private static final int eLH = "userType".hashCode();
  private static final int eLI = "chatOpen".hashCode();
  private static final int eLJ = "wwUnreadCnt".hashCode();
  private static final int eLK = "show_confirm".hashCode();
  private static final int eLL = "use_preset_banner_tips".hashCode();
  private static final int eLM = "hide_create_chat".hashCode();
  private static final int eLN = "hide_mod_chat_member".hashCode();
  private static final int eLO = "hide_colleage_invite".hashCode();
  private static final int eLP = "raw_attrs".hashCode();
  private static final int rowid_HASHCODE = "rowid".hashCode();
  private boolean eFp = true;
  private boolean eLk = true;
  private boolean eLl = true;
  private boolean eLm = true;
  private boolean eLn = true;
  private boolean eLo = true;
  private boolean eLp = true;
  private boolean eLq = true;
  private boolean eLr = true;
  private boolean eLs = true;
  private boolean eLt = true;
  private boolean eLu = true;
  private boolean eLv = true;
  private boolean eLw = true;
  private boolean eLx = true;
  private boolean eLy = true;
  private boolean eLz = true;
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
      if (eFM != k) {
        break label65;
      }
      this.field_userName = paramCursor.getString(i);
      this.eFp = true;
    }
    for (;;)
    {
      i += 1;
      break label20;
      break;
      label65:
      if (eLA == k)
      {
        this.field_qyUin = paramCursor.getInt(i);
      }
      else if (eLB == k)
      {
        this.field_userUin = paramCursor.getInt(i);
      }
      else if (eLC == k)
      {
        this.field_userFlag = paramCursor.getInt(i);
      }
      else if (eLD == k)
      {
        this.field_wwExposeTimes = paramCursor.getInt(i);
      }
      else if (eLE == k)
      {
        this.field_wwMaxExposeTimes = paramCursor.getInt(i);
      }
      else if (eLF == k)
      {
        this.field_wwCorpId = paramCursor.getLong(i);
      }
      else if (eLG == k)
      {
        this.field_wwUserVid = paramCursor.getLong(i);
      }
      else if (eLH == k)
      {
        this.field_userType = paramCursor.getInt(i);
      }
      else
      {
        boolean bool;
        if (eLI == k)
        {
          if (paramCursor.getInt(i) != 0) {}
          for (bool = true;; bool = false)
          {
            this.field_chatOpen = bool;
            break;
          }
        }
        if (eLJ == k)
        {
          this.field_wwUnreadCnt = paramCursor.getInt(i);
        }
        else
        {
          if (eLK == k)
          {
            if (paramCursor.getInt(i) != 0) {}
            for (bool = true;; bool = false)
            {
              this.field_show_confirm = bool;
              break;
            }
          }
          if (eLL == k)
          {
            if (paramCursor.getInt(i) != 0) {}
            for (bool = true;; bool = false)
            {
              this.field_use_preset_banner_tips = bool;
              break;
            }
          }
          if (eLM == k)
          {
            if (paramCursor.getInt(i) != 0) {}
            for (bool = true;; bool = false)
            {
              this.field_hide_create_chat = bool;
              break;
            }
          }
          if (eLN == k)
          {
            if (paramCursor.getInt(i) != 0) {}
            for (bool = true;; bool = false)
            {
              this.field_hide_mod_chat_member = bool;
              break;
            }
          }
          if (eLO == k)
          {
            if (paramCursor.getInt(i) != 0) {}
            for (bool = true;; bool = false)
            {
              this.field_hide_colleage_invite = bool;
              break;
            }
          }
          if (eLP == k) {
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
    if (this.eFp) {
      localContentValues.put("userName", this.field_userName);
    }
    if (this.eLk) {
      localContentValues.put("qyUin", Integer.valueOf(this.field_qyUin));
    }
    if (this.eLl) {
      localContentValues.put("userUin", Integer.valueOf(this.field_userUin));
    }
    if (this.eLm) {
      localContentValues.put("userFlag", Integer.valueOf(this.field_userFlag));
    }
    if (this.eLn) {
      localContentValues.put("wwExposeTimes", Integer.valueOf(this.field_wwExposeTimes));
    }
    if (this.eLo) {
      localContentValues.put("wwMaxExposeTimes", Integer.valueOf(this.field_wwMaxExposeTimes));
    }
    if (this.eLp) {
      localContentValues.put("wwCorpId", Long.valueOf(this.field_wwCorpId));
    }
    if (this.eLq) {
      localContentValues.put("wwUserVid", Long.valueOf(this.field_wwUserVid));
    }
    if (this.eLr) {
      localContentValues.put("userType", Integer.valueOf(this.field_userType));
    }
    if (this.eLs) {
      localContentValues.put("chatOpen", Boolean.valueOf(this.field_chatOpen));
    }
    if (this.eLt) {
      localContentValues.put("wwUnreadCnt", Integer.valueOf(this.field_wwUnreadCnt));
    }
    if (this.eLu) {
      localContentValues.put("show_confirm", Boolean.valueOf(this.field_show_confirm));
    }
    if (this.eLv) {
      localContentValues.put("use_preset_banner_tips", Boolean.valueOf(this.field_use_preset_banner_tips));
    }
    if (this.eLw) {
      localContentValues.put("hide_create_chat", Boolean.valueOf(this.field_hide_create_chat));
    }
    if (this.eLx) {
      localContentValues.put("hide_mod_chat_member", Boolean.valueOf(this.field_hide_mod_chat_member));
    }
    if (this.eLy) {
      localContentValues.put("hide_colleage_invite", Boolean.valueOf(this.field_hide_colleage_invite));
    }
    if (this.eLz) {
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