package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;

public abstract class ag
  extends c
{
  public static final String[] INDEX_CREATE = new String[0];
  private static final int eIF = "brandUserName".hashCode();
  private static final int eIO = "chatType".hashCode();
  private static final int eJg = "bizChatLocalId".hashCode();
  private static final int eJh = "bizChatServId".hashCode();
  private static final int eJi = "headImageUrl".hashCode();
  private static final int eJj = "chatName".hashCode();
  private static final int eJk = "chatNamePY".hashCode();
  private static final int eJl = "chatVersion".hashCode();
  private static final int eJm = "needToUpdate".hashCode();
  private static final int eJn = "bitFlag".hashCode();
  private static final int eJo = "maxMemberCnt".hashCode();
  private static final int eJp = "ownerUserId".hashCode();
  private static final int eJq = "userList".hashCode();
  private static final int eJr = "addMemberUrl".hashCode();
  private static final int eJs = "roomflag".hashCode();
  private static final int rowid_HASHCODE = "rowid".hashCode();
  private boolean eIT = true;
  private boolean eIU = true;
  private boolean eIV = true;
  private boolean eIW = true;
  private boolean eIX = true;
  private boolean eIY = true;
  private boolean eIZ = true;
  private boolean eIq = true;
  private boolean eIz = true;
  private boolean eJa = true;
  private boolean eJb = true;
  private boolean eJc = true;
  private boolean eJd = true;
  private boolean eJe = true;
  private boolean eJf = true;
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
      if (eJg != k) {
        break label65;
      }
      this.field_bizChatLocalId = paramCursor.getLong(i);
      this.eIT = true;
    }
    for (;;)
    {
      i += 1;
      break label20;
      break;
      label65:
      if (eJh == k)
      {
        this.field_bizChatServId = paramCursor.getString(i);
      }
      else if (eIF == k)
      {
        this.field_brandUserName = paramCursor.getString(i);
      }
      else if (eIO == k)
      {
        this.field_chatType = paramCursor.getInt(i);
      }
      else if (eJi == k)
      {
        this.field_headImageUrl = paramCursor.getString(i);
      }
      else if (eJj == k)
      {
        this.field_chatName = paramCursor.getString(i);
      }
      else if (eJk == k)
      {
        this.field_chatNamePY = paramCursor.getString(i);
      }
      else if (eJl == k)
      {
        this.field_chatVersion = paramCursor.getInt(i);
      }
      else
      {
        if (eJm == k)
        {
          if (paramCursor.getInt(i) != 0) {}
          for (boolean bool = true;; bool = false)
          {
            this.field_needToUpdate = bool;
            break;
          }
        }
        if (eJn == k) {
          this.field_bitFlag = paramCursor.getInt(i);
        } else if (eJo == k) {
          this.field_maxMemberCnt = paramCursor.getInt(i);
        } else if (eJp == k) {
          this.field_ownerUserId = paramCursor.getString(i);
        } else if (eJq == k) {
          this.field_userList = paramCursor.getString(i);
        } else if (eJr == k) {
          this.field_addMemberUrl = paramCursor.getString(i);
        } else if (eJs == k) {
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
    if (this.eIT) {
      localContentValues.put("bizChatLocalId", Long.valueOf(this.field_bizChatLocalId));
    }
    if (this.eIU) {
      localContentValues.put("bizChatServId", this.field_bizChatServId);
    }
    if (this.field_brandUserName == null) {
      this.field_brandUserName = "";
    }
    if (this.eIq) {
      localContentValues.put("brandUserName", this.field_brandUserName);
    }
    if (this.eIz) {
      localContentValues.put("chatType", Integer.valueOf(this.field_chatType));
    }
    if (this.eIV) {
      localContentValues.put("headImageUrl", this.field_headImageUrl);
    }
    if (this.field_chatName == null) {
      this.field_chatName = "";
    }
    if (this.eIW) {
      localContentValues.put("chatName", this.field_chatName);
    }
    if (this.field_chatNamePY == null) {
      this.field_chatNamePY = "";
    }
    if (this.eIX) {
      localContentValues.put("chatNamePY", this.field_chatNamePY);
    }
    if (this.eIY) {
      localContentValues.put("chatVersion", Integer.valueOf(this.field_chatVersion));
    }
    if (this.eIZ) {
      localContentValues.put("needToUpdate", Boolean.valueOf(this.field_needToUpdate));
    }
    if (this.eJa) {
      localContentValues.put("bitFlag", Integer.valueOf(this.field_bitFlag));
    }
    if (this.eJb) {
      localContentValues.put("maxMemberCnt", Integer.valueOf(this.field_maxMemberCnt));
    }
    if (this.eJc) {
      localContentValues.put("ownerUserId", this.field_ownerUserId);
    }
    if (this.eJd) {
      localContentValues.put("userList", this.field_userList);
    }
    if (this.eJe) {
      localContentValues.put("addMemberUrl", this.field_addMemberUrl);
    }
    if (this.eJf) {
      localContentValues.put("roomflag", Integer.valueOf(this.field_roomflag));
    }
    if (this.systemRowid > 0L) {
      localContentValues.put("rowid", Long.valueOf(this.systemRowid));
    }
    return localContentValues;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.g.c.ag
 * JD-Core Version:    0.7.0.1
 */