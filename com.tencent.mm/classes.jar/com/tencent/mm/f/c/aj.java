package com.tencent.mm.f.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.storage.IAutoDBItem;
import com.tencent.mm.sdk.storage.sql.Column;
import com.tencent.mm.sdk.storage.sql.SingleTable;

public abstract class aj
  extends IAutoDBItem
{
  public static final Column C_ROWID;
  public static final Column C_USERNAME;
  public static final String[] INDEX_CREATE = new String[0];
  public static final SingleTable TABLE = new SingleTable("BizChatUserInfo");
  public static final Column hsT;
  public static final Column htN;
  public static final Column htR;
  public static final Column htS;
  public static final Column htW;
  private static final int htx;
  private static final int huA;
  public static final Column huB;
  public static final Column huC;
  public static final Column huD;
  private static final int huH;
  private static final int huI;
  private static final int huJ = "profileUrl".hashCode();
  private static final int hun;
  private static final int hur;
  private static final int hus = "bitFlag".hashCode();
  private static final int huw = "addMemberUrl".hashCode();
  public static final Column huy;
  private static final int rowid_HASHCODE = "rowid".hashCode();
  private static final int userName_HASHCODE;
  private boolean __hadSetuserName = true;
  public int field_UserVersion;
  public String field_addMemberUrl;
  public int field_bitFlag;
  public String field_brandUserName;
  public String field_headImageUrl;
  public boolean field_needToUpdate;
  public String field_profileUrl;
  public String field_userId;
  public String field_userName;
  public String field_userNamePY;
  private boolean hti = true;
  private boolean huE = true;
  private boolean huF = true;
  private boolean huG = true;
  private boolean hua = true;
  private boolean hue = true;
  private boolean huf = true;
  private boolean huj = true;
  private boolean huz = true;
  
  static
  {
    C_ROWID = new Column("rowid", "long", "BizChatUserInfo", "");
    huy = new Column("userid", "string", "BizChatUserInfo", "");
    C_USERNAME = new Column("username", "string", "BizChatUserInfo", "");
    huB = new Column("usernamepy", "string", "BizChatUserInfo", "");
    hsT = new Column("brandusername", "string", "BizChatUserInfo", "");
    huC = new Column("userversion", "int", "BizChatUserInfo", "");
    htR = new Column("needtoupdate", "boolean", "BizChatUserInfo", "");
    htN = new Column("headimageurl", "string", "BizChatUserInfo", "");
    huD = new Column("profileurl", "string", "BizChatUserInfo", "");
    htS = new Column("bitflag", "int", "BizChatUserInfo", "");
    htW = new Column("addmemberurl", "string", "BizChatUserInfo", "");
    huA = "userId".hashCode();
    userName_HASHCODE = "userName".hashCode();
    huH = "userNamePY".hashCode();
    htx = "brandUserName".hashCode();
    huI = "UserVersion".hashCode();
    hur = "needToUpdate".hashCode();
    hun = "headImageUrl".hashCode();
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
      if (huA != k) {
        break label65;
      }
      this.field_userId = paramCursor.getString(i);
      this.huz = true;
    }
    for (;;)
    {
      i += 1;
      break label20;
      break;
      label65:
      if (userName_HASHCODE == k)
      {
        this.field_userName = paramCursor.getString(i);
      }
      else if (huH == k)
      {
        this.field_userNamePY = paramCursor.getString(i);
      }
      else if (htx == k)
      {
        this.field_brandUserName = paramCursor.getString(i);
      }
      else if (huI == k)
      {
        this.field_UserVersion = paramCursor.getInt(i);
      }
      else
      {
        if (hur == k)
        {
          if (paramCursor.getInt(i) != 0) {}
          for (boolean bool = true;; bool = false)
          {
            this.field_needToUpdate = bool;
            break;
          }
        }
        if (hun == k) {
          this.field_headImageUrl = paramCursor.getString(i);
        } else if (huJ == k) {
          this.field_profileUrl = paramCursor.getString(i);
        } else if (hus == k) {
          this.field_bitFlag = paramCursor.getInt(i);
        } else if (huw == k) {
          this.field_addMemberUrl = paramCursor.getString(i);
        } else if (rowid_HASHCODE == k) {
          this.systemRowid = paramCursor.getLong(i);
        }
      }
    }
  }
  
  public ContentValues convertTo()
  {
    ContentValues localContentValues = new ContentValues();
    if (this.huz) {
      localContentValues.put("userId", this.field_userId);
    }
    if (this.field_userName == null) {
      this.field_userName = "";
    }
    if (this.__hadSetuserName) {
      localContentValues.put("userName", this.field_userName);
    }
    if (this.field_userNamePY == null) {
      this.field_userNamePY = "";
    }
    if (this.huE) {
      localContentValues.put("userNamePY", this.field_userNamePY);
    }
    if (this.field_brandUserName == null) {
      this.field_brandUserName = "";
    }
    if (this.hti) {
      localContentValues.put("brandUserName", this.field_brandUserName);
    }
    if (this.huF) {
      localContentValues.put("UserVersion", Integer.valueOf(this.field_UserVersion));
    }
    if (this.hue) {
      localContentValues.put("needToUpdate", Boolean.valueOf(this.field_needToUpdate));
    }
    if (this.hua) {
      localContentValues.put("headImageUrl", this.field_headImageUrl);
    }
    if (this.huG) {
      localContentValues.put("profileUrl", this.field_profileUrl);
    }
    if (this.huf) {
      localContentValues.put("bitFlag", Integer.valueOf(this.field_bitFlag));
    }
    if (this.huj) {
      localContentValues.put("addMemberUrl", this.field_addMemberUrl);
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
    return "BizChatUserInfo";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.f.c.aj
 * JD-Core Version:    0.7.0.1
 */