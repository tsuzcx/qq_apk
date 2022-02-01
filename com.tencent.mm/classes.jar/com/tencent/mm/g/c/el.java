package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;

public abstract class el
  extends c
{
  public static final String[] INDEX_CREATE = new String[0];
  private static final int eEL = "status".hashCode();
  private static final int eFM;
  private static final int eFO = "createTime".hashCode();
  private static final int fmN;
  private static final int fmR;
  private static final int fmV = "memberUuid".hashCode();
  private static final int fmW;
  private static final int rowid_HASHCODE = "rowid".hashCode();
  private boolean eEI = true;
  private boolean eFp = true;
  private boolean eFr = true;
  public long field_createTime;
  public String field_inviteUserName;
  public long field_memberId;
  public long field_memberUuid;
  public int field_status;
  public String field_userName;
  public String field_wxGroupId;
  private boolean fmH = true;
  private boolean fmL = true;
  private boolean fmT = true;
  private boolean fmU = true;
  
  static
  {
    fmN = "wxGroupId".hashCode();
    eFM = "userName".hashCode();
    fmR = "inviteUserName".hashCode();
    fmW = "memberId".hashCode();
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
      if (fmV != k) {
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
      if (fmN == k) {
        this.field_wxGroupId = paramCursor.getString(i);
      } else if (eFM == k) {
        this.field_userName = paramCursor.getString(i);
      } else if (fmR == k) {
        this.field_inviteUserName = paramCursor.getString(i);
      } else if (fmW == k) {
        this.field_memberId = paramCursor.getLong(i);
      } else if (eEL == k) {
        this.field_status = paramCursor.getInt(i);
      } else if (eFO == k) {
        this.field_createTime = paramCursor.getLong(i);
      } else if (rowid_HASHCODE == k) {
        this.systemRowid = paramCursor.getLong(i);
      }
    }
  }
  
  public ContentValues convertTo()
  {
    ContentValues localContentValues = new ContentValues();
    if (this.fmT) {
      localContentValues.put("memberUuid", Long.valueOf(this.field_memberUuid));
    }
    if (this.fmH) {
      localContentValues.put("wxGroupId", this.field_wxGroupId);
    }
    if (this.eFp) {
      localContentValues.put("userName", this.field_userName);
    }
    if (this.fmL) {
      localContentValues.put("inviteUserName", this.field_inviteUserName);
    }
    if (this.fmU) {
      localContentValues.put("memberId", Long.valueOf(this.field_memberId));
    }
    if (this.eEI) {
      localContentValues.put("status", Integer.valueOf(this.field_status));
    }
    if (this.eFr) {
      localContentValues.put("createTime", Long.valueOf(this.field_createTime));
    }
    if (this.systemRowid > 0L) {
      localContentValues.put("rowid", Long.valueOf(this.systemRowid));
    }
    return localContentValues;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.g.c.el
 * JD-Core Version:    0.7.0.1
 */