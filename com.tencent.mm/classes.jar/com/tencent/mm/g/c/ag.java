package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;

public abstract class ag
  extends c
{
  public static final String[] INDEX_CREATE = new String[0];
  private static final int epB = "chatType".hashCode();
  private static final int epT = "bizChatLocalId".hashCode();
  private static final int epU = "bizChatServId".hashCode();
  private static final int epV = "headImageUrl".hashCode();
  private static final int epW = "chatName".hashCode();
  private static final int epX = "chatNamePY".hashCode();
  private static final int epY = "chatVersion".hashCode();
  private static final int epZ = "needToUpdate".hashCode();
  private static final int eps = "brandUserName".hashCode();
  private static final int eqa = "bitFlag".hashCode();
  private static final int eqb = "maxMemberCnt".hashCode();
  private static final int eqc = "ownerUserId".hashCode();
  private static final int eqd = "userList".hashCode();
  private static final int eqe = "addMemberUrl".hashCode();
  private static final int eqf = "roomflag".hashCode();
  private static final int rowid_HASHCODE = "rowid".hashCode();
  private boolean epG = true;
  private boolean epH = true;
  private boolean epI = true;
  private boolean epJ = true;
  private boolean epK = true;
  private boolean epL = true;
  private boolean epM = true;
  private boolean epN = true;
  private boolean epO = true;
  private boolean epP = true;
  private boolean epQ = true;
  private boolean epR = true;
  private boolean epS = true;
  private boolean epd = true;
  private boolean epm = true;
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
      if (epT != k) {
        break label65;
      }
      this.field_bizChatLocalId = paramCursor.getLong(i);
      this.epG = true;
    }
    for (;;)
    {
      i += 1;
      break label20;
      break;
      label65:
      if (epU == k)
      {
        this.field_bizChatServId = paramCursor.getString(i);
      }
      else if (eps == k)
      {
        this.field_brandUserName = paramCursor.getString(i);
      }
      else if (epB == k)
      {
        this.field_chatType = paramCursor.getInt(i);
      }
      else if (epV == k)
      {
        this.field_headImageUrl = paramCursor.getString(i);
      }
      else if (epW == k)
      {
        this.field_chatName = paramCursor.getString(i);
      }
      else if (epX == k)
      {
        this.field_chatNamePY = paramCursor.getString(i);
      }
      else if (epY == k)
      {
        this.field_chatVersion = paramCursor.getInt(i);
      }
      else
      {
        if (epZ == k)
        {
          if (paramCursor.getInt(i) != 0) {}
          for (boolean bool = true;; bool = false)
          {
            this.field_needToUpdate = bool;
            break;
          }
        }
        if (eqa == k) {
          this.field_bitFlag = paramCursor.getInt(i);
        } else if (eqb == k) {
          this.field_maxMemberCnt = paramCursor.getInt(i);
        } else if (eqc == k) {
          this.field_ownerUserId = paramCursor.getString(i);
        } else if (eqd == k) {
          this.field_userList = paramCursor.getString(i);
        } else if (eqe == k) {
          this.field_addMemberUrl = paramCursor.getString(i);
        } else if (eqf == k) {
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
    if (this.epG) {
      localContentValues.put("bizChatLocalId", Long.valueOf(this.field_bizChatLocalId));
    }
    if (this.epH) {
      localContentValues.put("bizChatServId", this.field_bizChatServId);
    }
    if (this.field_brandUserName == null) {
      this.field_brandUserName = "";
    }
    if (this.epd) {
      localContentValues.put("brandUserName", this.field_brandUserName);
    }
    if (this.epm) {
      localContentValues.put("chatType", Integer.valueOf(this.field_chatType));
    }
    if (this.epI) {
      localContentValues.put("headImageUrl", this.field_headImageUrl);
    }
    if (this.field_chatName == null) {
      this.field_chatName = "";
    }
    if (this.epJ) {
      localContentValues.put("chatName", this.field_chatName);
    }
    if (this.field_chatNamePY == null) {
      this.field_chatNamePY = "";
    }
    if (this.epK) {
      localContentValues.put("chatNamePY", this.field_chatNamePY);
    }
    if (this.epL) {
      localContentValues.put("chatVersion", Integer.valueOf(this.field_chatVersion));
    }
    if (this.epM) {
      localContentValues.put("needToUpdate", Boolean.valueOf(this.field_needToUpdate));
    }
    if (this.epN) {
      localContentValues.put("bitFlag", Integer.valueOf(this.field_bitFlag));
    }
    if (this.epO) {
      localContentValues.put("maxMemberCnt", Integer.valueOf(this.field_maxMemberCnt));
    }
    if (this.epP) {
      localContentValues.put("ownerUserId", this.field_ownerUserId);
    }
    if (this.epQ) {
      localContentValues.put("userList", this.field_userList);
    }
    if (this.epR) {
      localContentValues.put("addMemberUrl", this.field_addMemberUrl);
    }
    if (this.epS) {
      localContentValues.put("roomflag", Integer.valueOf(this.field_roomflag));
    }
    if (this.systemRowid > 0L) {
      localContentValues.put("rowid", Long.valueOf(this.systemRowid));
    }
    return localContentValues;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.g.c.ag
 * JD-Core Version:    0.7.0.1
 */