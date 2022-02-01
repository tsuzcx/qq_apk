package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.storage.IAutoDBItem;

public abstract class er
  extends IAutoDBItem
{
  public static final String[] INDEX_CREATE = new String[0];
  private static final int createTime_HASHCODE = "createTime".hashCode();
  private static final int fRA;
  private static final int fRr;
  private static final int fRv;
  private static final int fRz = "memberUuid".hashCode();
  private static final int fjl;
  private static final int rowid_HASHCODE = "rowid".hashCode();
  private static final int userName_HASHCODE;
  private boolean __hadSetcreateTime = true;
  private boolean __hadSetuserName = true;
  private boolean fRl = true;
  private boolean fRp = true;
  private boolean fRx = true;
  private boolean fRy = true;
  public long field_createTime;
  public String field_inviteUserName;
  public long field_memberId;
  public long field_memberUuid;
  public int field_status;
  public String field_userName;
  public String field_wxGroupId;
  private boolean fji = true;
  
  static
  {
    fRr = "wxGroupId".hashCode();
    userName_HASHCODE = "userName".hashCode();
    fRv = "inviteUserName".hashCode();
    fRA = "memberId".hashCode();
    fjl = "status".hashCode();
  }
  
  public void convertFrom(Cursor paramCursor)
  {
    String[] arrayOfString = paramCursor.getColumnNames();
    if (arrayOfString == null) {
      return;
    }
    int i = 0;
    int j = arrayOfString.length;
    label20:
    int k;
    if (i < j)
    {
      k = arrayOfString[i].hashCode();
      if (fRz != k) {
        break label60;
      }
      this.field_memberUuid = paramCursor.getLong(i);
    }
    for (;;)
    {
      i += 1;
      break label20;
      break;
      label60:
      if (fRr == k) {
        this.field_wxGroupId = paramCursor.getString(i);
      } else if (userName_HASHCODE == k) {
        this.field_userName = paramCursor.getString(i);
      } else if (fRv == k) {
        this.field_inviteUserName = paramCursor.getString(i);
      } else if (fRA == k) {
        this.field_memberId = paramCursor.getLong(i);
      } else if (fjl == k) {
        this.field_status = paramCursor.getInt(i);
      } else if (createTime_HASHCODE == k) {
        this.field_createTime = paramCursor.getLong(i);
      } else if (rowid_HASHCODE == k) {
        this.systemRowid = paramCursor.getLong(i);
      }
    }
  }
  
  public ContentValues convertTo()
  {
    ContentValues localContentValues = new ContentValues();
    if (this.fRx) {
      localContentValues.put("memberUuid", Long.valueOf(this.field_memberUuid));
    }
    if (this.fRl) {
      localContentValues.put("wxGroupId", this.field_wxGroupId);
    }
    if (this.__hadSetuserName) {
      localContentValues.put("userName", this.field_userName);
    }
    if (this.fRp) {
      localContentValues.put("inviteUserName", this.field_inviteUserName);
    }
    if (this.fRy) {
      localContentValues.put("memberId", Long.valueOf(this.field_memberId));
    }
    if (this.fji) {
      localContentValues.put("status", Integer.valueOf(this.field_status));
    }
    if (this.__hadSetcreateTime) {
      localContentValues.put("createTime", Long.valueOf(this.field_createTime));
    }
    if (this.systemRowid > 0L) {
      localContentValues.put("rowid", Long.valueOf(this.systemRowid));
    }
    return localContentValues;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.g.c.er
 * JD-Core Version:    0.7.0.1
 */