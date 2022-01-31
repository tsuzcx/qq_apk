package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;

public abstract class ab
  extends c
{
  public static final String[] INDEX_CREATE = new String[0];
  private static final int dkU;
  private static final int dlA = "bitFlag".hashCode();
  private static final int dlB = "maxMemberCnt".hashCode();
  private static final int dlC = "ownerUserId".hashCode();
  private static final int dlD = "userList".hashCode();
  private static final int dlE = "addMemberUrl".hashCode();
  private static final int dld;
  private static final int dlt = "bizChatLocalId".hashCode();
  private static final int dlu = "bizChatServId".hashCode();
  private static final int dlv;
  private static final int dlw;
  private static final int dlx;
  private static final int dly;
  private static final int dlz;
  private static final int rowid_HASHCODE = "rowid".hashCode();
  private boolean dkG = true;
  private boolean dkP = true;
  private boolean dlh = true;
  private boolean dli = true;
  private boolean dlj = true;
  private boolean dlk = true;
  private boolean dll = true;
  private boolean dlm = true;
  private boolean dln = true;
  private boolean dlo = true;
  private boolean dlp = true;
  private boolean dlq = true;
  private boolean dlr = true;
  private boolean dls = true;
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
  public String field_userList;
  
  static
  {
    dkU = "brandUserName".hashCode();
    dld = "chatType".hashCode();
    dlv = "headImageUrl".hashCode();
    dlw = "chatName".hashCode();
    dlx = "chatNamePY".hashCode();
    dly = "chatVersion".hashCode();
    dlz = "needToUpdate".hashCode();
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
      if (dlt != k) {
        break label65;
      }
      this.field_bizChatLocalId = paramCursor.getLong(i);
      this.dlh = true;
    }
    for (;;)
    {
      i += 1;
      break label20;
      break;
      label65:
      if (dlu == k)
      {
        this.field_bizChatServId = paramCursor.getString(i);
      }
      else if (dkU == k)
      {
        this.field_brandUserName = paramCursor.getString(i);
      }
      else if (dld == k)
      {
        this.field_chatType = paramCursor.getInt(i);
      }
      else if (dlv == k)
      {
        this.field_headImageUrl = paramCursor.getString(i);
      }
      else if (dlw == k)
      {
        this.field_chatName = paramCursor.getString(i);
      }
      else if (dlx == k)
      {
        this.field_chatNamePY = paramCursor.getString(i);
      }
      else if (dly == k)
      {
        this.field_chatVersion = paramCursor.getInt(i);
      }
      else
      {
        if (dlz == k)
        {
          if (paramCursor.getInt(i) != 0) {}
          for (boolean bool = true;; bool = false)
          {
            this.field_needToUpdate = bool;
            break;
          }
        }
        if (dlA == k) {
          this.field_bitFlag = paramCursor.getInt(i);
        } else if (dlB == k) {
          this.field_maxMemberCnt = paramCursor.getInt(i);
        } else if (dlC == k) {
          this.field_ownerUserId = paramCursor.getString(i);
        } else if (dlD == k) {
          this.field_userList = paramCursor.getString(i);
        } else if (dlE == k) {
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
    if (this.dlh) {
      localContentValues.put("bizChatLocalId", Long.valueOf(this.field_bizChatLocalId));
    }
    if (this.dli) {
      localContentValues.put("bizChatServId", this.field_bizChatServId);
    }
    if (this.field_brandUserName == null) {
      this.field_brandUserName = "";
    }
    if (this.dkG) {
      localContentValues.put("brandUserName", this.field_brandUserName);
    }
    if (this.dkP) {
      localContentValues.put("chatType", Integer.valueOf(this.field_chatType));
    }
    if (this.dlj) {
      localContentValues.put("headImageUrl", this.field_headImageUrl);
    }
    if (this.field_chatName == null) {
      this.field_chatName = "";
    }
    if (this.dlk) {
      localContentValues.put("chatName", this.field_chatName);
    }
    if (this.field_chatNamePY == null) {
      this.field_chatNamePY = "";
    }
    if (this.dll) {
      localContentValues.put("chatNamePY", this.field_chatNamePY);
    }
    if (this.dlm) {
      localContentValues.put("chatVersion", Integer.valueOf(this.field_chatVersion));
    }
    if (this.dln) {
      localContentValues.put("needToUpdate", Boolean.valueOf(this.field_needToUpdate));
    }
    if (this.dlo) {
      localContentValues.put("bitFlag", Integer.valueOf(this.field_bitFlag));
    }
    if (this.dlp) {
      localContentValues.put("maxMemberCnt", Integer.valueOf(this.field_maxMemberCnt));
    }
    if (this.dlq) {
      localContentValues.put("ownerUserId", this.field_ownerUserId);
    }
    if (this.dlr) {
      localContentValues.put("userList", this.field_userList);
    }
    if (this.dls) {
      localContentValues.put("addMemberUrl", this.field_addMemberUrl);
    }
    if (this.systemRowid > 0L) {
      localContentValues.put("rowid", Long.valueOf(this.systemRowid));
    }
    return localContentValues;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.g.c.ab
 * JD-Core Version:    0.7.0.1
 */