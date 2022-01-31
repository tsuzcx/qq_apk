package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;

public abstract class df
  extends c
{
  public static final String[] INDEX_CREATE = new String[0];
  private static final int dHi;
  private static final int dHm = "inviteUserName".hashCode();
  private static final int dHp = "memberUuid".hashCode();
  private static final int dHq = "memberId".hashCode();
  private static final int dfJ = "status".hashCode();
  private static final int dgK;
  private static final int dgM = "createTime".hashCode();
  private static final int rowid_HASHCODE = "rowid".hashCode();
  private boolean dHd = true;
  private boolean dHh = true;
  private boolean dHn = true;
  private boolean dHo = true;
  private boolean dfG = true;
  private boolean dgn = true;
  private boolean dgp = true;
  public long field_createTime;
  public String field_inviteUserName;
  public long field_memberId;
  public long field_memberUuid;
  public int field_status;
  public String field_userName;
  public String field_wxGroupId;
  
  static
  {
    dHi = "wxGroupId".hashCode();
    dgK = "userName".hashCode();
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
      if (dHp != k) {
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
      if (dHi == k) {
        this.field_wxGroupId = paramCursor.getString(i);
      } else if (dgK == k) {
        this.field_userName = paramCursor.getString(i);
      } else if (dHm == k) {
        this.field_inviteUserName = paramCursor.getString(i);
      } else if (dHq == k) {
        this.field_memberId = paramCursor.getLong(i);
      } else if (dfJ == k) {
        this.field_status = paramCursor.getInt(i);
      } else if (dgM == k) {
        this.field_createTime = paramCursor.getLong(i);
      } else if (rowid_HASHCODE == k) {
        this.systemRowid = paramCursor.getLong(i);
      }
    }
  }
  
  public ContentValues convertTo()
  {
    ContentValues localContentValues = new ContentValues();
    if (this.dHn) {
      localContentValues.put("memberUuid", Long.valueOf(this.field_memberUuid));
    }
    if (this.dHd) {
      localContentValues.put("wxGroupId", this.field_wxGroupId);
    }
    if (this.dgn) {
      localContentValues.put("userName", this.field_userName);
    }
    if (this.dHh) {
      localContentValues.put("inviteUserName", this.field_inviteUserName);
    }
    if (this.dHo) {
      localContentValues.put("memberId", Long.valueOf(this.field_memberId));
    }
    if (this.dfG) {
      localContentValues.put("status", Integer.valueOf(this.field_status));
    }
    if (this.dgp) {
      localContentValues.put("createTime", Long.valueOf(this.field_createTime));
    }
    if (this.systemRowid > 0L) {
      localContentValues.put("rowid", Long.valueOf(this.systemRowid));
    }
    return localContentValues;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.g.c.df
 * JD-Core Version:    0.7.0.1
 */