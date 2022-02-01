package com.tencent.mm.f.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.storage.IAutoDBItem;
import com.tencent.mm.sdk.storage.sql.Column;
import com.tencent.mm.sdk.storage.sql.SingleTable;

public abstract class ah
  extends IAutoDBItem
{
  public static final Column C_ROWID;
  public static final String[] INDEX_CREATE = new String[0];
  public static final SingleTable TABLE = new SingleTable("BizChatInfo");
  public static final Column hsT;
  private static final int htG = "chatType".hashCode();
  public static final Column htL;
  public static final Column htM;
  public static final Column htN;
  public static final Column htO;
  public static final Column htP;
  public static final Column htQ;
  public static final Column htR;
  public static final Column htS;
  public static final Column htT;
  public static final Column htU;
  public static final Column htV;
  public static final Column htW;
  public static final Column htX;
  public static final Column htc;
  private static final int htx;
  private static final int hul;
  private static final int hum;
  private static final int hun = "headImageUrl".hashCode();
  private static final int huo = "chatName".hashCode();
  private static final int hup = "chatNamePY".hashCode();
  private static final int huq = "chatVersion".hashCode();
  private static final int hur = "needToUpdate".hashCode();
  private static final int hus = "bitFlag".hashCode();
  private static final int hut = "maxMemberCnt".hashCode();
  private static final int huu = "ownerUserId".hashCode();
  private static final int huv = "userList".hashCode();
  private static final int huw = "addMemberUrl".hashCode();
  private static final int hux = "roomflag".hashCode();
  private static final int rowid_HASHCODE = "rowid".hashCode();
  public String field_addMemberUrl;
  public int field_bitFlag;
  public long field_bizChatLocalId;
  public String field_bizChatServId;
  public String field_brandUserName;
  public String field_chatName;
  public String field_chatNamePY;
  public int field_chatType;
  public int field_chatVersion;
  public String field_headImageUrl;
  public int field_maxMemberCnt;
  public boolean field_needToUpdate;
  public String field_ownerUserId;
  public int field_roomflag;
  public String field_userList;
  private boolean htY = true;
  private boolean htZ = true;
  private boolean hti = true;
  private boolean htr = true;
  private boolean hua = true;
  private boolean hub = true;
  private boolean huc = true;
  private boolean hud = true;
  private boolean hue = true;
  private boolean huf = true;
  private boolean hug = true;
  private boolean huh = true;
  private boolean hui = true;
  private boolean huj = true;
  private boolean huk = true;
  
  static
  {
    C_ROWID = new Column("rowid", "long", "BizChatInfo", "");
    htL = new Column("bizchatlocalid", "long", "BizChatInfo", "");
    htM = new Column("bizchatservid", "string", "BizChatInfo", "");
    hsT = new Column("brandusername", "string", "BizChatInfo", "");
    htc = new Column("chattype", "int", "BizChatInfo", "");
    htN = new Column("headimageurl", "string", "BizChatInfo", "");
    htO = new Column("chatname", "string", "BizChatInfo", "");
    htP = new Column("chatnamepy", "string", "BizChatInfo", "");
    htQ = new Column("chatversion", "int", "BizChatInfo", "");
    htR = new Column("needtoupdate", "boolean", "BizChatInfo", "");
    htS = new Column("bitflag", "int", "BizChatInfo", "");
    htT = new Column("maxmembercnt", "int", "BizChatInfo", "");
    htU = new Column("owneruserid", "string", "BizChatInfo", "");
    htV = new Column("userlist", "string", "BizChatInfo", "");
    htW = new Column("addmemberurl", "string", "BizChatInfo", "");
    htX = new Column("roomflag", "int", "BizChatInfo", "");
    hul = "bizChatLocalId".hashCode();
    hum = "bizChatServId".hashCode();
    htx = "brandUserName".hashCode();
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
      if (hul != k) {
        break label65;
      }
      this.field_bizChatLocalId = paramCursor.getLong(i);
      this.htY = true;
    }
    for (;;)
    {
      i += 1;
      break label20;
      break;
      label65:
      if (hum == k)
      {
        this.field_bizChatServId = paramCursor.getString(i);
      }
      else if (htx == k)
      {
        this.field_brandUserName = paramCursor.getString(i);
      }
      else if (htG == k)
      {
        this.field_chatType = paramCursor.getInt(i);
      }
      else if (hun == k)
      {
        this.field_headImageUrl = paramCursor.getString(i);
      }
      else if (huo == k)
      {
        this.field_chatName = paramCursor.getString(i);
      }
      else if (hup == k)
      {
        this.field_chatNamePY = paramCursor.getString(i);
      }
      else if (huq == k)
      {
        this.field_chatVersion = paramCursor.getInt(i);
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
        if (hus == k) {
          this.field_bitFlag = paramCursor.getInt(i);
        } else if (hut == k) {
          this.field_maxMemberCnt = paramCursor.getInt(i);
        } else if (huu == k) {
          this.field_ownerUserId = paramCursor.getString(i);
        } else if (huv == k) {
          this.field_userList = paramCursor.getString(i);
        } else if (huw == k) {
          this.field_addMemberUrl = paramCursor.getString(i);
        } else if (hux == k) {
          this.field_roomflag = paramCursor.getInt(i);
        } else if (rowid_HASHCODE == k) {
          this.systemRowid = paramCursor.getLong(i);
        }
      }
    }
  }
  
  public ContentValues convertTo()
  {
    ContentValues localContentValues = new ContentValues();
    if (this.htY) {
      localContentValues.put("bizChatLocalId", Long.valueOf(this.field_bizChatLocalId));
    }
    if (this.htZ) {
      localContentValues.put("bizChatServId", this.field_bizChatServId);
    }
    if (this.field_brandUserName == null) {
      this.field_brandUserName = "";
    }
    if (this.hti) {
      localContentValues.put("brandUserName", this.field_brandUserName);
    }
    if (this.htr) {
      localContentValues.put("chatType", Integer.valueOf(this.field_chatType));
    }
    if (this.hua) {
      localContentValues.put("headImageUrl", this.field_headImageUrl);
    }
    if (this.field_chatName == null) {
      this.field_chatName = "";
    }
    if (this.hub) {
      localContentValues.put("chatName", this.field_chatName);
    }
    if (this.field_chatNamePY == null) {
      this.field_chatNamePY = "";
    }
    if (this.huc) {
      localContentValues.put("chatNamePY", this.field_chatNamePY);
    }
    if (this.hud) {
      localContentValues.put("chatVersion", Integer.valueOf(this.field_chatVersion));
    }
    if (this.hue) {
      localContentValues.put("needToUpdate", Boolean.valueOf(this.field_needToUpdate));
    }
    if (this.huf) {
      localContentValues.put("bitFlag", Integer.valueOf(this.field_bitFlag));
    }
    if (this.hug) {
      localContentValues.put("maxMemberCnt", Integer.valueOf(this.field_maxMemberCnt));
    }
    if (this.huh) {
      localContentValues.put("ownerUserId", this.field_ownerUserId);
    }
    if (this.hui) {
      localContentValues.put("userList", this.field_userList);
    }
    if (this.huj) {
      localContentValues.put("addMemberUrl", this.field_addMemberUrl);
    }
    if (this.huk) {
      localContentValues.put("roomflag", Integer.valueOf(this.field_roomflag));
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
    return "BizChatInfo";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.f.c.ah
 * JD-Core Version:    0.7.0.1
 */