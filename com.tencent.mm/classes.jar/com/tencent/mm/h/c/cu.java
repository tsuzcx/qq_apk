package com.tencent.mm.h.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;

public abstract class cu
  extends c
{
  private static final int cQX;
  private static final int cRb;
  private static final int cRf;
  private static final int cRg;
  public static final String[] cqY = new String[0];
  private static final int crh = "rowid".hashCode();
  private static final int crn;
  private static final int cst;
  private static final int csv;
  private boolean cQR = true;
  private boolean cQV = true;
  private boolean cRd = true;
  private boolean cRe = true;
  private boolean crV = true;
  private boolean crX = true;
  private boolean crk = true;
  public long field_createTime;
  public String field_inviteUserName;
  public long field_memberId;
  public long field_memberUuid;
  public int field_status;
  public String field_userName;
  public String field_wxGroupId;
  
  static
  {
    cRf = "memberUuid".hashCode();
    cQX = "wxGroupId".hashCode();
    cst = "userName".hashCode();
    cRb = "inviteUserName".hashCode();
    cRg = "memberId".hashCode();
    crn = "status".hashCode();
    csv = "createTime".hashCode();
  }
  
  public final void d(Cursor paramCursor)
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
      if (cRf != k) {
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
      if (cQX == k) {
        this.field_wxGroupId = paramCursor.getString(i);
      } else if (cst == k) {
        this.field_userName = paramCursor.getString(i);
      } else if (cRb == k) {
        this.field_inviteUserName = paramCursor.getString(i);
      } else if (cRg == k) {
        this.field_memberId = paramCursor.getLong(i);
      } else if (crn == k) {
        this.field_status = paramCursor.getInt(i);
      } else if (csv == k) {
        this.field_createTime = paramCursor.getLong(i);
      } else if (crh == k) {
        this.ujK = paramCursor.getLong(i);
      }
    }
  }
  
  public final ContentValues vf()
  {
    ContentValues localContentValues = new ContentValues();
    if (this.cRd) {
      localContentValues.put("memberUuid", Long.valueOf(this.field_memberUuid));
    }
    if (this.cQR) {
      localContentValues.put("wxGroupId", this.field_wxGroupId);
    }
    if (this.crV) {
      localContentValues.put("userName", this.field_userName);
    }
    if (this.cQV) {
      localContentValues.put("inviteUserName", this.field_inviteUserName);
    }
    if (this.cRe) {
      localContentValues.put("memberId", Long.valueOf(this.field_memberId));
    }
    if (this.crk) {
      localContentValues.put("status", Integer.valueOf(this.field_status));
    }
    if (this.crX) {
      localContentValues.put("createTime", Long.valueOf(this.field_createTime));
    }
    if (this.ujK > 0L) {
      localContentValues.put("rowid", Long.valueOf(this.ujK));
    }
    return localContentValues;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.h.c.cu
 * JD-Core Version:    0.7.0.1
 */