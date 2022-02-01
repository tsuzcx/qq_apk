package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;

public abstract class eb
  extends c
{
  public static final String[] INDEX_CREATE = new String[0];
  private static final int eSD = "inviteUserName".hashCode();
  private static final int eSG = "memberUuid".hashCode();
  private static final int eSH = "memberId".hashCode();
  private static final int eSz = "wxGroupId".hashCode();
  private static final int elV = "status".hashCode();
  private static final int emW = "userName".hashCode();
  private static final int emY = "createTime".hashCode();
  private static final int rowid_HASHCODE = "rowid".hashCode();
  private boolean eSE = true;
  private boolean eSF = true;
  private boolean eSu = true;
  private boolean eSy = true;
  private boolean elS = true;
  private boolean emB = true;
  private boolean emz = true;
  public long field_createTime;
  public String field_inviteUserName;
  public long field_memberId;
  public long field_memberUuid;
  public int field_status;
  public String field_userName;
  public String field_wxGroupId;
  
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
      if (eSG != k) {
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
      if (eSz == k) {
        this.field_wxGroupId = paramCursor.getString(i);
      } else if (emW == k) {
        this.field_userName = paramCursor.getString(i);
      } else if (eSD == k) {
        this.field_inviteUserName = paramCursor.getString(i);
      } else if (eSH == k) {
        this.field_memberId = paramCursor.getLong(i);
      } else if (elV == k) {
        this.field_status = paramCursor.getInt(i);
      } else if (emY == k) {
        this.field_createTime = paramCursor.getLong(i);
      } else if (rowid_HASHCODE == k) {
        this.systemRowid = paramCursor.getLong(i);
      }
    }
  }
  
  public ContentValues convertTo()
  {
    ContentValues localContentValues = new ContentValues();
    if (this.eSE) {
      localContentValues.put("memberUuid", Long.valueOf(this.field_memberUuid));
    }
    if (this.eSu) {
      localContentValues.put("wxGroupId", this.field_wxGroupId);
    }
    if (this.emz) {
      localContentValues.put("userName", this.field_userName);
    }
    if (this.eSy) {
      localContentValues.put("inviteUserName", this.field_inviteUserName);
    }
    if (this.eSF) {
      localContentValues.put("memberId", Long.valueOf(this.field_memberId));
    }
    if (this.elS) {
      localContentValues.put("status", Integer.valueOf(this.field_status));
    }
    if (this.emB) {
      localContentValues.put("createTime", Long.valueOf(this.field_createTime));
    }
    if (this.systemRowid > 0L) {
      localContentValues.put("rowid", Long.valueOf(this.systemRowid));
    }
    return localContentValues;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.g.c.eb
 * JD-Core Version:    0.7.0.1
 */