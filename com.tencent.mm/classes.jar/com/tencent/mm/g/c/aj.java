package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;

public abstract class aj
  extends c
{
  public static final String[] INDEX_CREATE = new String[0];
  private static final int ekS = "userName".hashCode();
  private static final int eqE = "qyUin".hashCode();
  private static final int eqF = "userUin".hashCode();
  private static final int eqG = "userFlag".hashCode();
  private static final int eqH = "wwExposeTimes".hashCode();
  private static final int eqI = "wwMaxExposeTimes".hashCode();
  private static final int eqJ = "wwCorpId".hashCode();
  private static final int eqK = "wwUserVid".hashCode();
  private static final int eqL = "userType".hashCode();
  private static final int eqM = "chatOpen".hashCode();
  private static final int eqN = "wwUnreadCnt".hashCode();
  private static final int eqO = "show_confirm".hashCode();
  private static final int eqP = "use_preset_banner_tips".hashCode();
  private static final int eqQ = "hide_create_chat".hashCode();
  private static final int eqR = "hide_mod_chat_member".hashCode();
  private static final int eqS = "hide_colleage_invite".hashCode();
  private static final int eqT = "raw_attrs".hashCode();
  private static final int rowid_HASHCODE = "rowid".hashCode();
  private boolean ekv = true;
  private boolean eqA = true;
  private boolean eqB = true;
  private boolean eqC = true;
  private boolean eqD = true;
  private boolean eqo = true;
  private boolean eqp = true;
  private boolean eqq = true;
  private boolean eqr = true;
  private boolean eqs = true;
  private boolean eqt = true;
  private boolean equ = true;
  private boolean eqv = true;
  private boolean eqw = true;
  private boolean eqx = true;
  private boolean eqy = true;
  private boolean eqz = true;
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
      if (ekS != k) {
        break label65;
      }
      this.field_userName = paramCursor.getString(i);
      this.ekv = true;
    }
    for (;;)
    {
      i += 1;
      break label20;
      break;
      label65:
      if (eqE == k)
      {
        this.field_qyUin = paramCursor.getInt(i);
      }
      else if (eqF == k)
      {
        this.field_userUin = paramCursor.getInt(i);
      }
      else if (eqG == k)
      {
        this.field_userFlag = paramCursor.getInt(i);
      }
      else if (eqH == k)
      {
        this.field_wwExposeTimes = paramCursor.getInt(i);
      }
      else if (eqI == k)
      {
        this.field_wwMaxExposeTimes = paramCursor.getInt(i);
      }
      else if (eqJ == k)
      {
        this.field_wwCorpId = paramCursor.getLong(i);
      }
      else if (eqK == k)
      {
        this.field_wwUserVid = paramCursor.getLong(i);
      }
      else if (eqL == k)
      {
        this.field_userType = paramCursor.getInt(i);
      }
      else
      {
        boolean bool;
        if (eqM == k)
        {
          if (paramCursor.getInt(i) != 0) {}
          for (bool = true;; bool = false)
          {
            this.field_chatOpen = bool;
            break;
          }
        }
        if (eqN == k)
        {
          this.field_wwUnreadCnt = paramCursor.getInt(i);
        }
        else
        {
          if (eqO == k)
          {
            if (paramCursor.getInt(i) != 0) {}
            for (bool = true;; bool = false)
            {
              this.field_show_confirm = bool;
              break;
            }
          }
          if (eqP == k)
          {
            if (paramCursor.getInt(i) != 0) {}
            for (bool = true;; bool = false)
            {
              this.field_use_preset_banner_tips = bool;
              break;
            }
          }
          if (eqQ == k)
          {
            if (paramCursor.getInt(i) != 0) {}
            for (bool = true;; bool = false)
            {
              this.field_hide_create_chat = bool;
              break;
            }
          }
          if (eqR == k)
          {
            if (paramCursor.getInt(i) != 0) {}
            for (bool = true;; bool = false)
            {
              this.field_hide_mod_chat_member = bool;
              break;
            }
          }
          if (eqS == k)
          {
            if (paramCursor.getInt(i) != 0) {}
            for (bool = true;; bool = false)
            {
              this.field_hide_colleage_invite = bool;
              break;
            }
          }
          if (eqT == k) {
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
    if (this.ekv) {
      localContentValues.put("userName", this.field_userName);
    }
    if (this.eqo) {
      localContentValues.put("qyUin", Integer.valueOf(this.field_qyUin));
    }
    if (this.eqp) {
      localContentValues.put("userUin", Integer.valueOf(this.field_userUin));
    }
    if (this.eqq) {
      localContentValues.put("userFlag", Integer.valueOf(this.field_userFlag));
    }
    if (this.eqr) {
      localContentValues.put("wwExposeTimes", Integer.valueOf(this.field_wwExposeTimes));
    }
    if (this.eqs) {
      localContentValues.put("wwMaxExposeTimes", Integer.valueOf(this.field_wwMaxExposeTimes));
    }
    if (this.eqt) {
      localContentValues.put("wwCorpId", Long.valueOf(this.field_wwCorpId));
    }
    if (this.equ) {
      localContentValues.put("wwUserVid", Long.valueOf(this.field_wwUserVid));
    }
    if (this.eqv) {
      localContentValues.put("userType", Integer.valueOf(this.field_userType));
    }
    if (this.eqw) {
      localContentValues.put("chatOpen", Boolean.valueOf(this.field_chatOpen));
    }
    if (this.eqx) {
      localContentValues.put("wwUnreadCnt", Integer.valueOf(this.field_wwUnreadCnt));
    }
    if (this.eqy) {
      localContentValues.put("show_confirm", Boolean.valueOf(this.field_show_confirm));
    }
    if (this.eqz) {
      localContentValues.put("use_preset_banner_tips", Boolean.valueOf(this.field_use_preset_banner_tips));
    }
    if (this.eqA) {
      localContentValues.put("hide_create_chat", Boolean.valueOf(this.field_hide_create_chat));
    }
    if (this.eqB) {
      localContentValues.put("hide_mod_chat_member", Boolean.valueOf(this.field_hide_mod_chat_member));
    }
    if (this.eqC) {
      localContentValues.put("hide_colleage_invite", Boolean.valueOf(this.field_hide_colleage_invite));
    }
    if (this.eqD) {
      localContentValues.put("raw_attrs", this.field_raw_attrs);
    }
    if (this.systemRowid > 0L) {
      localContentValues.put("rowid", Long.valueOf(this.systemRowid));
    }
    return localContentValues;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.g.c.aj
 * JD-Core Version:    0.7.0.1
 */