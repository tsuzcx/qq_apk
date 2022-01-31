package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;

public abstract class bt
  extends c
{
  public static final String[] INDEX_CREATE = new String[0];
  private static final int dyD = "ForcePushId".hashCode();
  private static final int dyE = "CreateTime".hashCode();
  private static final int dyF = "ExpiredTime".hashCode();
  private static final int dyG = "Description".hashCode();
  private static final int dyH = "UserIcon".hashCode();
  private static final int dyI = "UserName".hashCode();
  private static final int dyJ = "ExtInfo".hashCode();
  private static final int dyK = "Status".hashCode();
  private static final int rowid_HASHCODE = "rowid".hashCode();
  private boolean dyA = true;
  private boolean dyB = true;
  private boolean dyC = true;
  private boolean dyv = true;
  private boolean dyw = true;
  private boolean dyx = true;
  private boolean dyy = true;
  private boolean dyz = true;
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
      if (dyD != k) {
        break label65;
      }
      this.field_ForcePushId = paramCursor.getString(i);
      this.dyv = true;
    }
    for (;;)
    {
      i += 1;
      break label20;
      break;
      label65:
      if (dyE == k) {
        this.field_CreateTime = paramCursor.getLong(i);
      } else if (dyF == k) {
        this.field_ExpiredTime = paramCursor.getLong(i);
      } else if (dyG == k) {
        this.field_Description = paramCursor.getString(i);
      } else if (dyH == k) {
        this.field_UserIcon = paramCursor.getString(i);
      } else if (dyI == k) {
        this.field_UserName = paramCursor.getString(i);
      } else if (dyJ == k) {
        this.field_ExtInfo = paramCursor.getString(i);
      } else if (dyK == k) {
        this.field_Status = paramCursor.getInt(i);
      } else if (rowid_HASHCODE == k) {
        this.systemRowid = paramCursor.getLong(i);
      }
    }
  }
  
  public ContentValues convertTo()
  {
    ContentValues localContentValues = new ContentValues();
    if (this.dyv) {
      localContentValues.put("ForcePushId", this.field_ForcePushId);
    }
    if (this.dyw) {
      localContentValues.put("CreateTime", Long.valueOf(this.field_CreateTime));
    }
    if (this.dyx) {
      localContentValues.put("ExpiredTime", Long.valueOf(this.field_ExpiredTime));
    }
    if (this.dyy) {
      localContentValues.put("Description", this.field_Description);
    }
    if (this.dyz) {
      localContentValues.put("UserIcon", this.field_UserIcon);
    }
    if (this.dyA) {
      localContentValues.put("UserName", this.field_UserName);
    }
    if (this.dyB) {
      localContentValues.put("ExtInfo", this.field_ExtInfo);
    }
    if (this.dyC) {
      localContentValues.put("Status", Integer.valueOf(this.field_Status));
    }
    if (this.systemRowid > 0L) {
      localContentValues.put("rowid", Long.valueOf(this.systemRowid));
    }
    return localContentValues;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.g.c.bt
 * JD-Core Version:    0.7.0.1
 */