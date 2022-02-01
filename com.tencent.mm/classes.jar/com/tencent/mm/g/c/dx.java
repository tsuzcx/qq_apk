package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;

public abstract class dx
  extends c
{
  public static final String[] INDEX_CREATE = new String[0];
  private static final int ePr;
  private static final int ePv = "inviteUserName".hashCode();
  private static final int ePy = "memberUuid".hashCode();
  private static final int ePz = "memberId".hashCode();
  private static final int ejR = "status".hashCode();
  private static final int ekS;
  private static final int ekU = "createTime".hashCode();
  private static final int rowid_HASHCODE = "rowid".hashCode();
  private boolean ePm = true;
  private boolean ePq = true;
  private boolean ePw = true;
  private boolean ePx = true;
  private boolean ejO = true;
  private boolean ekv = true;
  private boolean ekx = true;
  public long field_createTime;
  public String field_inviteUserName;
  public long field_memberId;
  public long field_memberUuid;
  public int field_status;
  public String field_userName;
  public String field_wxGroupId;
  
  static
  {
    ePr = "wxGroupId".hashCode();
    ekS = "userName".hashCode();
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
      if (ePy != k) {
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
      if (ePr == k) {
        this.field_wxGroupId = paramCursor.getString(i);
      } else if (ekS == k) {
        this.field_userName = paramCursor.getString(i);
      } else if (ePv == k) {
        this.field_inviteUserName = paramCursor.getString(i);
      } else if (ePz == k) {
        this.field_memberId = paramCursor.getLong(i);
      } else if (ejR == k) {
        this.field_status = paramCursor.getInt(i);
      } else if (ekU == k) {
        this.field_createTime = paramCursor.getLong(i);
      } else if (rowid_HASHCODE == k) {
        this.systemRowid = paramCursor.getLong(i);
      }
    }
  }
  
  public ContentValues convertTo()
  {
    ContentValues localContentValues = new ContentValues();
    if (this.ePw) {
      localContentValues.put("memberUuid", Long.valueOf(this.field_memberUuid));
    }
    if (this.ePm) {
      localContentValues.put("wxGroupId", this.field_wxGroupId);
    }
    if (this.ekv) {
      localContentValues.put("userName", this.field_userName);
    }
    if (this.ePq) {
      localContentValues.put("inviteUserName", this.field_inviteUserName);
    }
    if (this.ePx) {
      localContentValues.put("memberId", Long.valueOf(this.field_memberId));
    }
    if (this.ejO) {
      localContentValues.put("status", Integer.valueOf(this.field_status));
    }
    if (this.ekx) {
      localContentValues.put("createTime", Long.valueOf(this.field_createTime));
    }
    if (this.systemRowid > 0L) {
      localContentValues.put("rowid", Long.valueOf(this.systemRowid));
    }
    return localContentValues;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.g.c.dx
 * JD-Core Version:    0.7.0.1
 */