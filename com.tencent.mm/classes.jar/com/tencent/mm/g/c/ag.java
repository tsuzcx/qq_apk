package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;

public abstract class ag
  extends c
{
  public static final String[] INDEX_CREATE = new String[0];
  private static final int erF = "chatType".hashCode();
  private static final int erX = "bizChatLocalId".hashCode();
  private static final int erY = "bizChatServId".hashCode();
  private static final int erZ = "headImageUrl".hashCode();
  private static final int erw = "brandUserName".hashCode();
  private static final int esa = "chatName".hashCode();
  private static final int esb = "chatNamePY".hashCode();
  private static final int esc = "chatVersion".hashCode();
  private static final int esd = "needToUpdate".hashCode();
  private static final int ese = "bitFlag".hashCode();
  private static final int esf = "maxMemberCnt".hashCode();
  private static final int esg = "ownerUserId".hashCode();
  private static final int esh = "userList".hashCode();
  private static final int esi = "addMemberUrl".hashCode();
  private static final int esj = "roomflag".hashCode();
  private static final int rowid_HASHCODE = "rowid".hashCode();
  private boolean erK = true;
  private boolean erL = true;
  private boolean erM = true;
  private boolean erN = true;
  private boolean erO = true;
  private boolean erP = true;
  private boolean erQ = true;
  private boolean erR = true;
  private boolean erS = true;
  private boolean erT = true;
  private boolean erU = true;
  private boolean erV = true;
  private boolean erW = true;
  private boolean erh = true;
  private boolean erq = true;
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
      if (erX != k) {
        break label65;
      }
      this.field_bizChatLocalId = paramCursor.getLong(i);
      this.erK = true;
    }
    for (;;)
    {
      i += 1;
      break label20;
      break;
      label65:
      if (erY == k)
      {
        this.field_bizChatServId = paramCursor.getString(i);
      }
      else if (erw == k)
      {
        this.field_brandUserName = paramCursor.getString(i);
      }
      else if (erF == k)
      {
        this.field_chatType = paramCursor.getInt(i);
      }
      else if (erZ == k)
      {
        this.field_headImageUrl = paramCursor.getString(i);
      }
      else if (esa == k)
      {
        this.field_chatName = paramCursor.getString(i);
      }
      else if (esb == k)
      {
        this.field_chatNamePY = paramCursor.getString(i);
      }
      else if (esc == k)
      {
        this.field_chatVersion = paramCursor.getInt(i);
      }
      else
      {
        if (esd == k)
        {
          if (paramCursor.getInt(i) != 0) {}
          for (boolean bool = true;; bool = false)
          {
            this.field_needToUpdate = bool;
            break;
          }
        }
        if (ese == k) {
          this.field_bitFlag = paramCursor.getInt(i);
        } else if (esf == k) {
          this.field_maxMemberCnt = paramCursor.getInt(i);
        } else if (esg == k) {
          this.field_ownerUserId = paramCursor.getString(i);
        } else if (esh == k) {
          this.field_userList = paramCursor.getString(i);
        } else if (esi == k) {
          this.field_addMemberUrl = paramCursor.getString(i);
        } else if (esj == k) {
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
    if (this.erK) {
      localContentValues.put("bizChatLocalId", Long.valueOf(this.field_bizChatLocalId));
    }
    if (this.erL) {
      localContentValues.put("bizChatServId", this.field_bizChatServId);
    }
    if (this.field_brandUserName == null) {
      this.field_brandUserName = "";
    }
    if (this.erh) {
      localContentValues.put("brandUserName", this.field_brandUserName);
    }
    if (this.erq) {
      localContentValues.put("chatType", Integer.valueOf(this.field_chatType));
    }
    if (this.erM) {
      localContentValues.put("headImageUrl", this.field_headImageUrl);
    }
    if (this.field_chatName == null) {
      this.field_chatName = "";
    }
    if (this.erN) {
      localContentValues.put("chatName", this.field_chatName);
    }
    if (this.field_chatNamePY == null) {
      this.field_chatNamePY = "";
    }
    if (this.erO) {
      localContentValues.put("chatNamePY", this.field_chatNamePY);
    }
    if (this.erP) {
      localContentValues.put("chatVersion", Integer.valueOf(this.field_chatVersion));
    }
    if (this.erQ) {
      localContentValues.put("needToUpdate", Boolean.valueOf(this.field_needToUpdate));
    }
    if (this.erR) {
      localContentValues.put("bitFlag", Integer.valueOf(this.field_bitFlag));
    }
    if (this.erS) {
      localContentValues.put("maxMemberCnt", Integer.valueOf(this.field_maxMemberCnt));
    }
    if (this.erT) {
      localContentValues.put("ownerUserId", this.field_ownerUserId);
    }
    if (this.erU) {
      localContentValues.put("userList", this.field_userList);
    }
    if (this.erV) {
      localContentValues.put("addMemberUrl", this.field_addMemberUrl);
    }
    if (this.erW) {
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