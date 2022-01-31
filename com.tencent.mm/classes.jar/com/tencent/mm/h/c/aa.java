package com.tencent.mm.h.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;

public abstract class aa
  extends c
{
  public static final String[] cqY = new String[0];
  private static final int crh = "rowid".hashCode();
  private static final int cwT;
  private static final int cxA;
  private static final int cxB;
  private static final int cxC;
  private static final int cxD;
  private static final int cxc;
  private static final int cxs = "bizChatLocalId".hashCode();
  private static final int cxt = "bizChatServId".hashCode();
  private static final int cxu;
  private static final int cxv;
  private static final int cxw;
  private static final int cxx;
  private static final int cxy;
  private static final int cxz;
  private boolean cwF = true;
  private boolean cwO = true;
  private boolean cxg = true;
  private boolean cxh = true;
  private boolean cxi = true;
  private boolean cxj = true;
  private boolean cxk = true;
  private boolean cxl = true;
  private boolean cxm = true;
  private boolean cxn = true;
  private boolean cxo = true;
  private boolean cxp = true;
  private boolean cxq = true;
  private boolean cxr = true;
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
    cwT = "brandUserName".hashCode();
    cxc = "chatType".hashCode();
    cxu = "headImageUrl".hashCode();
    cxv = "chatName".hashCode();
    cxw = "chatNamePY".hashCode();
    cxx = "chatVersion".hashCode();
    cxy = "needToUpdate".hashCode();
    cxz = "bitFlag".hashCode();
    cxA = "maxMemberCnt".hashCode();
    cxB = "ownerUserId".hashCode();
    cxC = "userList".hashCode();
    cxD = "addMemberUrl".hashCode();
  }
  
  public final void d(Cursor paramCursor)
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
      if (cxs != k) {
        break label65;
      }
      this.field_bizChatLocalId = paramCursor.getLong(i);
      this.cxg = true;
    }
    for (;;)
    {
      i += 1;
      break label20;
      break;
      label65:
      if (cxt == k)
      {
        this.field_bizChatServId = paramCursor.getString(i);
      }
      else if (cwT == k)
      {
        this.field_brandUserName = paramCursor.getString(i);
      }
      else if (cxc == k)
      {
        this.field_chatType = paramCursor.getInt(i);
      }
      else if (cxu == k)
      {
        this.field_headImageUrl = paramCursor.getString(i);
      }
      else if (cxv == k)
      {
        this.field_chatName = paramCursor.getString(i);
      }
      else if (cxw == k)
      {
        this.field_chatNamePY = paramCursor.getString(i);
      }
      else if (cxx == k)
      {
        this.field_chatVersion = paramCursor.getInt(i);
      }
      else
      {
        if (cxy == k)
        {
          if (paramCursor.getInt(i) != 0) {}
          for (boolean bool = true;; bool = false)
          {
            this.field_needToUpdate = bool;
            break;
          }
        }
        if (cxz == k) {
          this.field_bitFlag = paramCursor.getInt(i);
        } else if (cxA == k) {
          this.field_maxMemberCnt = paramCursor.getInt(i);
        } else if (cxB == k) {
          this.field_ownerUserId = paramCursor.getString(i);
        } else if (cxC == k) {
          this.field_userList = paramCursor.getString(i);
        } else if (cxD == k) {
          this.field_addMemberUrl = paramCursor.getString(i);
        } else if (crh == k) {
          this.ujK = paramCursor.getLong(i);
        }
      }
    }
  }
  
  public final ContentValues vf()
  {
    ContentValues localContentValues = new ContentValues();
    if (this.cxg) {
      localContentValues.put("bizChatLocalId", Long.valueOf(this.field_bizChatLocalId));
    }
    if (this.cxh) {
      localContentValues.put("bizChatServId", this.field_bizChatServId);
    }
    if (this.field_brandUserName == null) {
      this.field_brandUserName = "";
    }
    if (this.cwF) {
      localContentValues.put("brandUserName", this.field_brandUserName);
    }
    if (this.cwO) {
      localContentValues.put("chatType", Integer.valueOf(this.field_chatType));
    }
    if (this.cxi) {
      localContentValues.put("headImageUrl", this.field_headImageUrl);
    }
    if (this.field_chatName == null) {
      this.field_chatName = "";
    }
    if (this.cxj) {
      localContentValues.put("chatName", this.field_chatName);
    }
    if (this.field_chatNamePY == null) {
      this.field_chatNamePY = "";
    }
    if (this.cxk) {
      localContentValues.put("chatNamePY", this.field_chatNamePY);
    }
    if (this.cxl) {
      localContentValues.put("chatVersion", Integer.valueOf(this.field_chatVersion));
    }
    if (this.cxm) {
      localContentValues.put("needToUpdate", Boolean.valueOf(this.field_needToUpdate));
    }
    if (this.cxn) {
      localContentValues.put("bitFlag", Integer.valueOf(this.field_bitFlag));
    }
    if (this.cxo) {
      localContentValues.put("maxMemberCnt", Integer.valueOf(this.field_maxMemberCnt));
    }
    if (this.cxp) {
      localContentValues.put("ownerUserId", this.field_ownerUserId);
    }
    if (this.cxq) {
      localContentValues.put("userList", this.field_userList);
    }
    if (this.cxr) {
      localContentValues.put("addMemberUrl", this.field_addMemberUrl);
    }
    if (this.ujK > 0L) {
      localContentValues.put("rowid", Long.valueOf(this.ujK));
    }
    return localContentValues;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.h.c.aa
 * JD-Core Version:    0.7.0.1
 */