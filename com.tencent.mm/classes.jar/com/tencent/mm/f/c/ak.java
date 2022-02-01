package com.tencent.mm.f.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.storage.IAutoDBItem;
import com.tencent.mm.sdk.storage.sql.Column;
import com.tencent.mm.sdk.storage.sql.SingleTable;

public abstract class ak
  extends IAutoDBItem
{
  public static final Column C_ROWID;
  public static final Column C_USERNAME;
  public static final String[] INDEX_CREATE = new String[0];
  public static final SingleTable TABLE = new SingleTable("BizEnterprise");
  public static final Column huK;
  public static final Column huL;
  public static final Column huM;
  public static final Column huN;
  public static final Column huO;
  public static final Column huP;
  public static final Column huQ;
  public static final Column huR;
  public static final Column huS;
  public static final Column huT;
  public static final Column huU;
  public static final Column huV;
  public static final Column huW;
  public static final Column huX;
  public static final Column huY;
  public static final Column huZ;
  private static final int hvA = "show_confirm".hashCode();
  private static final int hvB = "use_preset_banner_tips".hashCode();
  private static final int hvC = "hide_create_chat".hashCode();
  private static final int hvD = "hide_mod_chat_member".hashCode();
  private static final int hvE = "hide_colleage_invite".hashCode();
  private static final int hvF = "raw_attrs".hashCode();
  private static final int hvq;
  private static final int hvr;
  private static final int hvs;
  private static final int hvt;
  private static final int hvu;
  private static final int hvv;
  private static final int hvw;
  private static final int hvx;
  private static final int hvy;
  private static final int hvz;
  private static final int rowid_HASHCODE = "rowid".hashCode();
  private static final int userName_HASHCODE;
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
  private boolean hva = true;
  private boolean hvb = true;
  private boolean hvc = true;
  private boolean hvd = true;
  private boolean hve = true;
  private boolean hvf = true;
  private boolean hvg = true;
  private boolean hvh = true;
  private boolean hvi = true;
  private boolean hvj = true;
  private boolean hvk = true;
  private boolean hvl = true;
  private boolean hvm = true;
  private boolean hvn = true;
  private boolean hvo = true;
  private boolean hvp = true;
  
  static
  {
    C_ROWID = new Column("rowid", "long", "BizEnterprise", "");
    C_USERNAME = new Column("username", "string", "BizEnterprise", "");
    huK = new Column("qyuin", "int", "BizEnterprise", "");
    huL = new Column("useruin", "int", "BizEnterprise", "");
    huM = new Column("userflag", "int", "BizEnterprise", "");
    huN = new Column("wwexposetimes", "int", "BizEnterprise", "");
    huO = new Column("wwmaxexposetimes", "int", "BizEnterprise", "");
    huP = new Column("wwcorpid", "long", "BizEnterprise", "");
    huQ = new Column("wwuservid", "long", "BizEnterprise", "");
    huR = new Column("usertype", "int", "BizEnterprise", "");
    huS = new Column("chatopen", "boolean", "BizEnterprise", "");
    huT = new Column("wwunreadcnt", "int", "BizEnterprise", "");
    huU = new Column("show_confirm", "boolean", "BizEnterprise", "");
    huV = new Column("use_preset_banner_tips", "boolean", "BizEnterprise", "");
    huW = new Column("hide_create_chat", "boolean", "BizEnterprise", "");
    huX = new Column("hide_mod_chat_member", "boolean", "BizEnterprise", "");
    huY = new Column("hide_colleage_invite", "boolean", "BizEnterprise", "");
    huZ = new Column("raw_attrs", "byte[]", "BizEnterprise", "");
    userName_HASHCODE = "userName".hashCode();
    hvq = "qyUin".hashCode();
    hvr = "userUin".hashCode();
    hvs = "userFlag".hashCode();
    hvt = "wwExposeTimes".hashCode();
    hvu = "wwMaxExposeTimes".hashCode();
    hvv = "wwCorpId".hashCode();
    hvw = "wwUserVid".hashCode();
    hvx = "userType".hashCode();
    hvy = "chatOpen".hashCode();
    hvz = "wwUnreadCnt".hashCode();
  }
  
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
      if (hvq == k)
      {
        this.field_qyUin = paramCursor.getInt(i);
      }
      else if (hvr == k)
      {
        this.field_userUin = paramCursor.getInt(i);
      }
      else if (hvs == k)
      {
        this.field_userFlag = paramCursor.getInt(i);
      }
      else if (hvt == k)
      {
        this.field_wwExposeTimes = paramCursor.getInt(i);
      }
      else if (hvu == k)
      {
        this.field_wwMaxExposeTimes = paramCursor.getInt(i);
      }
      else if (hvv == k)
      {
        this.field_wwCorpId = paramCursor.getLong(i);
      }
      else if (hvw == k)
      {
        this.field_wwUserVid = paramCursor.getLong(i);
      }
      else if (hvx == k)
      {
        this.field_userType = paramCursor.getInt(i);
      }
      else
      {
        boolean bool;
        if (hvy == k)
        {
          if (paramCursor.getInt(i) != 0) {}
          for (bool = true;; bool = false)
          {
            this.field_chatOpen = bool;
            break;
          }
        }
        if (hvz == k)
        {
          this.field_wwUnreadCnt = paramCursor.getInt(i);
        }
        else
        {
          if (hvA == k)
          {
            if (paramCursor.getInt(i) != 0) {}
            for (bool = true;; bool = false)
            {
              this.field_show_confirm = bool;
              break;
            }
          }
          if (hvB == k)
          {
            if (paramCursor.getInt(i) != 0) {}
            for (bool = true;; bool = false)
            {
              this.field_use_preset_banner_tips = bool;
              break;
            }
          }
          if (hvC == k)
          {
            if (paramCursor.getInt(i) != 0) {}
            for (bool = true;; bool = false)
            {
              this.field_hide_create_chat = bool;
              break;
            }
          }
          if (hvD == k)
          {
            if (paramCursor.getInt(i) != 0) {}
            for (bool = true;; bool = false)
            {
              this.field_hide_mod_chat_member = bool;
              break;
            }
          }
          if (hvE == k)
          {
            if (paramCursor.getInt(i) != 0) {}
            for (bool = true;; bool = false)
            {
              this.field_hide_colleage_invite = bool;
              break;
            }
          }
          if (hvF == k) {
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
    if (this.hva) {
      localContentValues.put("qyUin", Integer.valueOf(this.field_qyUin));
    }
    if (this.hvb) {
      localContentValues.put("userUin", Integer.valueOf(this.field_userUin));
    }
    if (this.hvc) {
      localContentValues.put("userFlag", Integer.valueOf(this.field_userFlag));
    }
    if (this.hvd) {
      localContentValues.put("wwExposeTimes", Integer.valueOf(this.field_wwExposeTimes));
    }
    if (this.hve) {
      localContentValues.put("wwMaxExposeTimes", Integer.valueOf(this.field_wwMaxExposeTimes));
    }
    if (this.hvf) {
      localContentValues.put("wwCorpId", Long.valueOf(this.field_wwCorpId));
    }
    if (this.hvg) {
      localContentValues.put("wwUserVid", Long.valueOf(this.field_wwUserVid));
    }
    if (this.hvh) {
      localContentValues.put("userType", Integer.valueOf(this.field_userType));
    }
    if (this.hvi) {
      localContentValues.put("chatOpen", Boolean.valueOf(this.field_chatOpen));
    }
    if (this.hvj) {
      localContentValues.put("wwUnreadCnt", Integer.valueOf(this.field_wwUnreadCnt));
    }
    if (this.hvk) {
      localContentValues.put("show_confirm", Boolean.valueOf(this.field_show_confirm));
    }
    if (this.hvl) {
      localContentValues.put("use_preset_banner_tips", Boolean.valueOf(this.field_use_preset_banner_tips));
    }
    if (this.hvm) {
      localContentValues.put("hide_create_chat", Boolean.valueOf(this.field_hide_create_chat));
    }
    if (this.hvn) {
      localContentValues.put("hide_mod_chat_member", Boolean.valueOf(this.field_hide_mod_chat_member));
    }
    if (this.hvo) {
      localContentValues.put("hide_colleage_invite", Boolean.valueOf(this.field_hide_colleage_invite));
    }
    if (this.hvp) {
      localContentValues.put("raw_attrs", this.field_raw_attrs);
    }
    if (this.systemRowid > 0L) {
      localContentValues.put("rowid", Long.valueOf(this.systemRowid));
    }
    return localContentValues;
  }
  
  public String[] getIndexCreateSQL()
  {
    return INDEX_CREATE;
  }
  
  public String getTableName()
  {
    return "BizEnterprise";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.f.c.ak
 * JD-Core Version:    0.7.0.1
 */