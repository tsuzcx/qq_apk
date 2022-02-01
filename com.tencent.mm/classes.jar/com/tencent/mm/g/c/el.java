package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;

public abstract class el
  extends c
{
  public static final String[] INDEX_CREATE = new String[0];
  private static final int eDc = "status".hashCode();
  private static final int eEd;
  private static final int eEf = "createTime".hashCode();
  private static final int fkO;
  private static final int fkS;
  private static final int fkV = "memberUuid".hashCode();
  private static final int fkW;
  private static final int rowid_HASHCODE = "rowid".hashCode();
  private boolean eCZ = true;
  private boolean eDG = true;
  private boolean eDI = true;
  public long field_createTime;
  public String field_inviteUserName;
  public long field_memberId;
  public long field_memberUuid;
  public int field_status;
  public String field_userName;
  public String field_wxGroupId;
  private boolean fkJ = true;
  private boolean fkN = true;
  private boolean fkT = true;
  private boolean fkU = true;
  
  static
  {
    fkO = "wxGroupId".hashCode();
    eEd = "userName".hashCode();
    fkS = "inviteUserName".hashCode();
    fkW = "memberId".hashCode();
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
      if (fkV != k) {
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
      if (fkO == k) {
        this.field_wxGroupId = paramCursor.getString(i);
      } else if (eEd == k) {
        this.field_userName = paramCursor.getString(i);
      } else if (fkS == k) {
        this.field_inviteUserName = paramCursor.getString(i);
      } else if (fkW == k) {
        this.field_memberId = paramCursor.getLong(i);
      } else if (eDc == k) {
        this.field_status = paramCursor.getInt(i);
      } else if (eEf == k) {
        this.field_createTime = paramCursor.getLong(i);
      } else if (rowid_HASHCODE == k) {
        this.systemRowid = paramCursor.getLong(i);
      }
    }
  }
  
  public ContentValues convertTo()
  {
    ContentValues localContentValues = new ContentValues();
    if (this.fkT) {
      localContentValues.put("memberUuid", Long.valueOf(this.field_memberUuid));
    }
    if (this.fkJ) {
      localContentValues.put("wxGroupId", this.field_wxGroupId);
    }
    if (this.eDG) {
      localContentValues.put("userName", this.field_userName);
    }
    if (this.fkN) {
      localContentValues.put("inviteUserName", this.field_inviteUserName);
    }
    if (this.fkU) {
      localContentValues.put("memberId", Long.valueOf(this.field_memberId));
    }
    if (this.eCZ) {
      localContentValues.put("status", Integer.valueOf(this.field_status));
    }
    if (this.eDI) {
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