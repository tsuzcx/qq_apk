package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.storage.IAutoDBItem;

public abstract class ak
  extends IAutoDBItem
{
  public static final String[] INDEX_CREATE = new String[0];
  private static final int fpg = "qyUin".hashCode();
  private static final int fph = "userUin".hashCode();
  private static final int fpi = "userFlag".hashCode();
  private static final int fpj = "wwExposeTimes".hashCode();
  private static final int fpk = "wwMaxExposeTimes".hashCode();
  private static final int fpl = "wwCorpId".hashCode();
  private static final int fpm = "wwUserVid".hashCode();
  private static final int fpn = "userType".hashCode();
  private static final int fpo = "chatOpen".hashCode();
  private static final int fpp = "wwUnreadCnt".hashCode();
  private static final int fpq = "show_confirm".hashCode();
  private static final int fpr = "use_preset_banner_tips".hashCode();
  private static final int fpt = "hide_create_chat".hashCode();
  private static final int fpu = "hide_mod_chat_member".hashCode();
  private static final int fpv = "hide_colleage_invite".hashCode();
  private static final int fpw = "raw_attrs".hashCode();
  private static final int rowid_HASHCODE = "rowid".hashCode();
  private static final int userName_HASHCODE = "userName".hashCode();
  private boolean __hadSetuserName = true;
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
  private boolean foQ = true;
  private boolean foR = true;
  private boolean foS = true;
  private boolean foT = true;
  private boolean foU = true;
  private boolean foV = true;
  private boolean foW = true;
  private boolean foX = true;
  private boolean foY = true;
  private boolean foZ = true;
  private boolean fpa = true;
  private boolean fpb = true;
  private boolean fpc = true;
  private boolean fpd = true;
  private boolean fpe = true;
  private boolean fpf = true;
  
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
      if (userName_HASHCODE != k) {
        break label65;
      }
      this.field_userName = paramCursor.getString(i);
      this.__hadSetuserName = true;
    }
    for (;;)
    {
      i += 1;
      break label20;
      break;
      label65:
      if (fpg == k)
      {
        this.field_qyUin = paramCursor.getInt(i);
      }
      else if (fph == k)
      {
        this.field_userUin = paramCursor.getInt(i);
      }
      else if (fpi == k)
      {
        this.field_userFlag = paramCursor.getInt(i);
      }
      else if (fpj == k)
      {
        this.field_wwExposeTimes = paramCursor.getInt(i);
      }
      else if (fpk == k)
      {
        this.field_wwMaxExposeTimes = paramCursor.getInt(i);
      }
      else if (fpl == k)
      {
        this.field_wwCorpId = paramCursor.getLong(i);
      }
      else if (fpm == k)
      {
        this.field_wwUserVid = paramCursor.getLong(i);
      }
      else if (fpn == k)
      {
        this.field_userType = paramCursor.getInt(i);
      }
      else
      {
        boolean bool;
        if (fpo == k)
        {
          if (paramCursor.getInt(i) != 0) {}
          for (bool = true;; bool = false)
          {
            this.field_chatOpen = bool;
            break;
          }
        }
        if (fpp == k)
        {
          this.field_wwUnreadCnt = paramCursor.getInt(i);
        }
        else
        {
          if (fpq == k)
          {
            if (paramCursor.getInt(i) != 0) {}
            for (bool = true;; bool = false)
            {
              this.field_show_confirm = bool;
              break;
            }
          }
          if (fpr == k)
          {
            if (paramCursor.getInt(i) != 0) {}
            for (bool = true;; bool = false)
            {
              this.field_use_preset_banner_tips = bool;
              break;
            }
          }
          if (fpt == k)
          {
            if (paramCursor.getInt(i) != 0) {}
            for (bool = true;; bool = false)
            {
              this.field_hide_create_chat = bool;
              break;
            }
          }
          if (fpu == k)
          {
            if (paramCursor.getInt(i) != 0) {}
            for (bool = true;; bool = false)
            {
              this.field_hide_mod_chat_member = bool;
              break;
            }
          }
          if (fpv == k)
          {
            if (paramCursor.getInt(i) != 0) {}
            for (bool = true;; bool = false)
            {
              this.field_hide_colleage_invite = bool;
              break;
            }
          }
          if (fpw == k) {
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
    if (this.__hadSetuserName) {
      localContentValues.put("userName", this.field_userName);
    }
    if (this.foQ) {
      localContentValues.put("qyUin", Integer.valueOf(this.field_qyUin));
    }
    if (this.foR) {
      localContentValues.put("userUin", Integer.valueOf(this.field_userUin));
    }
    if (this.foS) {
      localContentValues.put("userFlag", Integer.valueOf(this.field_userFlag));
    }
    if (this.foT) {
      localContentValues.put("wwExposeTimes", Integer.valueOf(this.field_wwExposeTimes));
    }
    if (this.foU) {
      localContentValues.put("wwMaxExposeTimes", Integer.valueOf(this.field_wwMaxExposeTimes));
    }
    if (this.foV) {
      localContentValues.put("wwCorpId", Long.valueOf(this.field_wwCorpId));
    }
    if (this.foW) {
      localContentValues.put("wwUserVid", Long.valueOf(this.field_wwUserVid));
    }
    if (this.foX) {
      localContentValues.put("userType", Integer.valueOf(this.field_userType));
    }
    if (this.foY) {
      localContentValues.put("chatOpen", Boolean.valueOf(this.field_chatOpen));
    }
    if (this.foZ) {
      localContentValues.put("wwUnreadCnt", Integer.valueOf(this.field_wwUnreadCnt));
    }
    if (this.fpa) {
      localContentValues.put("show_confirm", Boolean.valueOf(this.field_show_confirm));
    }
    if (this.fpb) {
      localContentValues.put("use_preset_banner_tips", Boolean.valueOf(this.field_use_preset_banner_tips));
    }
    if (this.fpc) {
      localContentValues.put("hide_create_chat", Boolean.valueOf(this.field_hide_create_chat));
    }
    if (this.fpd) {
      localContentValues.put("hide_mod_chat_member", Boolean.valueOf(this.field_hide_mod_chat_member));
    }
    if (this.fpe) {
      localContentValues.put("hide_colleage_invite", Boolean.valueOf(this.field_hide_colleage_invite));
    }
    if (this.fpf) {
      localContentValues.put("raw_attrs", this.field_raw_attrs);
    }
    if (this.systemRowid > 0L) {
      localContentValues.put("rowid", Long.valueOf(this.systemRowid));
    }
    return localContentValues;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.g.c.ak
 * JD-Core Version:    0.7.0.1
 */