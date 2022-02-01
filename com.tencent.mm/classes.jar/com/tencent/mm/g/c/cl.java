package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;

public abstract class cl
  extends c
{
  public static final String[] INDEX_CREATE = new String[0];
  private static final int fcg = "ForcePushId".hashCode();
  private static final int fch = "CreateTime".hashCode();
  private static final int fci = "ExpiredTime".hashCode();
  private static final int fcj = "Description".hashCode();
  private static final int fck = "UserIcon".hashCode();
  private static final int fcl = "UserName".hashCode();
  private static final int fcm = "ExtInfo".hashCode();
  private static final int fcn = "Status".hashCode();
  private static final int rowid_HASHCODE = "rowid".hashCode();
  private boolean fbY = true;
  private boolean fbZ = true;
  private boolean fca = true;
  private boolean fcb = true;
  private boolean fcc = true;
  private boolean fcd = true;
  private boolean fce = true;
  private boolean fcf = true;
  public long field_CreateTime;
  public String field_Description;
  public long field_ExpiredTime;
  public String field_ExtInfo;
  public String field_ForcePushId;
  public int field_Status;
  public String field_UserIcon;
  public String field_UserName;
  
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
      if (fcg != k) {
        break label65;
      }
      this.field_ForcePushId = paramCursor.getString(i);
      this.fbY = true;
    }
    for (;;)
    {
      i += 1;
      break label20;
      break;
      label65:
      if (fch == k) {
        this.field_CreateTime = paramCursor.getLong(i);
      } else if (fci == k) {
        this.field_ExpiredTime = paramCursor.getLong(i);
      } else if (fcj == k) {
        this.field_Description = paramCursor.getString(i);
      } else if (fck == k) {
        this.field_UserIcon = paramCursor.getString(i);
      } else if (fcl == k) {
        this.field_UserName = paramCursor.getString(i);
      } else if (fcm == k) {
        this.field_ExtInfo = paramCursor.getString(i);
      } else if (fcn == k) {
        this.field_Status = paramCursor.getInt(i);
      } else if (rowid_HASHCODE == k) {
        this.systemRowid = paramCursor.getLong(i);
      }
    }
  }
  
  public ContentValues convertTo()
  {
    ContentValues localContentValues = new ContentValues();
    if (this.fbY) {
      localContentValues.put("ForcePushId", this.field_ForcePushId);
    }
    if (this.fbZ) {
      localContentValues.put("CreateTime", Long.valueOf(this.field_CreateTime));
    }
    if (this.fca) {
      localContentValues.put("ExpiredTime", Long.valueOf(this.field_ExpiredTime));
    }
    if (this.fcb) {
      localContentValues.put("Description", this.field_Description);
    }
    if (this.fcc) {
      localContentValues.put("UserIcon", this.field_UserIcon);
    }
    if (this.fcd) {
      localContentValues.put("UserName", this.field_UserName);
    }
    if (this.fce) {
      localContentValues.put("ExtInfo", this.field_ExtInfo);
    }
    if (this.fcf) {
      localContentValues.put("Status", Integer.valueOf(this.field_Status));
    }
    if (this.systemRowid > 0L) {
      localContentValues.put("rowid", Long.valueOf(this.systemRowid));
    }
    return localContentValues;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.g.c.cl
 * JD-Core Version:    0.7.0.1
 */