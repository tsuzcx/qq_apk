package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;

public abstract class ag
  extends c
{
  public static final String[] INDEX_CREATE = new String[0];
  private static final int eKP = "bizChatLocalId".hashCode();
  private static final int eKQ = "bizChatServId".hashCode();
  private static final int eKR = "headImageUrl".hashCode();
  private static final int eKS = "chatName".hashCode();
  private static final int eKT = "chatNamePY".hashCode();
  private static final int eKU = "chatVersion".hashCode();
  private static final int eKV = "needToUpdate".hashCode();
  private static final int eKW = "bitFlag".hashCode();
  private static final int eKX = "maxMemberCnt".hashCode();
  private static final int eKY = "ownerUserId".hashCode();
  private static final int eKZ = "userList".hashCode();
  private static final int eKo = "brandUserName".hashCode();
  private static final int eKx = "chatType".hashCode();
  private static final int eLa = "addMemberUrl".hashCode();
  private static final int eLb = "roomflag".hashCode();
  private static final int rowid_HASHCODE = "rowid".hashCode();
  private boolean eJZ = true;
  private boolean eKC = true;
  private boolean eKD = true;
  private boolean eKE = true;
  private boolean eKF = true;
  private boolean eKG = true;
  private boolean eKH = true;
  private boolean eKI = true;
  private boolean eKJ = true;
  private boolean eKK = true;
  private boolean eKL = true;
  private boolean eKM = true;
  private boolean eKN = true;
  private boolean eKO = true;
  private boolean eKi = true;
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
      if (eKP != k) {
        break label65;
      }
      this.field_bizChatLocalId = paramCursor.getLong(i);
      this.eKC = true;
    }
    for (;;)
    {
      i += 1;
      break label20;
      break;
      label65:
      if (eKQ == k)
      {
        this.field_bizChatServId = paramCursor.getString(i);
      }
      else if (eKo == k)
      {
        this.field_brandUserName = paramCursor.getString(i);
      }
      else if (eKx == k)
      {
        this.field_chatType = paramCursor.getInt(i);
      }
      else if (eKR == k)
      {
        this.field_headImageUrl = paramCursor.getString(i);
      }
      else if (eKS == k)
      {
        this.field_chatName = paramCursor.getString(i);
      }
      else if (eKT == k)
      {
        this.field_chatNamePY = paramCursor.getString(i);
      }
      else if (eKU == k)
      {
        this.field_chatVersion = paramCursor.getInt(i);
      }
      else
      {
        if (eKV == k)
        {
          if (paramCursor.getInt(i) != 0) {}
          for (boolean bool = true;; bool = false)
          {
            this.field_needToUpdate = bool;
            break;
          }
        }
        if (eKW == k) {
          this.field_bitFlag = paramCursor.getInt(i);
        } else if (eKX == k) {
          this.field_maxMemberCnt = paramCursor.getInt(i);
        } else if (eKY == k) {
          this.field_ownerUserId = paramCursor.getString(i);
        } else if (eKZ == k) {
          this.field_userList = paramCursor.getString(i);
        } else if (eLa == k) {
          this.field_addMemberUrl = paramCursor.getString(i);
        } else if (eLb == k) {
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
    if (this.eKC) {
      localContentValues.put("bizChatLocalId", Long.valueOf(this.field_bizChatLocalId));
    }
    if (this.eKD) {
      localContentValues.put("bizChatServId", this.field_bizChatServId);
    }
    if (this.field_brandUserName == null) {
      this.field_brandUserName = "";
    }
    if (this.eJZ) {
      localContentValues.put("brandUserName", this.field_brandUserName);
    }
    if (this.eKi) {
      localContentValues.put("chatType", Integer.valueOf(this.field_chatType));
    }
    if (this.eKE) {
      localContentValues.put("headImageUrl", this.field_headImageUrl);
    }
    if (this.field_chatName == null) {
      this.field_chatName = "";
    }
    if (this.eKF) {
      localContentValues.put("chatName", this.field_chatName);
    }
    if (this.field_chatNamePY == null) {
      this.field_chatNamePY = "";
    }
    if (this.eKG) {
      localContentValues.put("chatNamePY", this.field_chatNamePY);
    }
    if (this.eKH) {
      localContentValues.put("chatVersion", Integer.valueOf(this.field_chatVersion));
    }
    if (this.eKI) {
      localContentValues.put("needToUpdate", Boolean.valueOf(this.field_needToUpdate));
    }
    if (this.eKJ) {
      localContentValues.put("bitFlag", Integer.valueOf(this.field_bitFlag));
    }
    if (this.eKK) {
      localContentValues.put("maxMemberCnt", Integer.valueOf(this.field_maxMemberCnt));
    }
    if (this.eKL) {
      localContentValues.put("ownerUserId", this.field_ownerUserId);
    }
    if (this.eKM) {
      localContentValues.put("userList", this.field_userList);
    }
    if (this.eKN) {
      localContentValues.put("addMemberUrl", this.field_addMemberUrl);
    }
    if (this.eKO) {
      localContentValues.put("roomflag", Integer.valueOf(this.field_roomflag));
    }
    if (this.systemRowid > 0L) {
      localContentValues.put("rowid", Long.valueOf(this.systemRowid));
    }
    return localContentValues;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.g.c.ag
 * JD-Core Version:    0.7.0.1
 */