package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.storage.IAutoDBItem;

public abstract class cq
  extends IAutoDBItem
{
  public static final String[] INDEX_CREATE = new String[0];
  private static final int fGA = "CreateTime".hashCode();
  private static final int fGB = "ExpiredTime".hashCode();
  private static final int fGC = "Description".hashCode();
  private static final int fGD = "UserIcon".hashCode();
  private static final int fGE = "UserName".hashCode();
  private static final int fGF = "ExtInfo".hashCode();
  private static final int fGG = "Status".hashCode();
  private static final int fGz = "ForcePushId".hashCode();
  private static final int rowid_HASHCODE = "rowid".hashCode();
  private boolean fGr = true;
  private boolean fGs = true;
  private boolean fGt = true;
  private boolean fGu = true;
  private boolean fGv = true;
  private boolean fGw = true;
  private boolean fGx = true;
  private boolean fGy = true;
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
      if (fGz != k) {
        break label65;
      }
      this.field_ForcePushId = paramCursor.getString(i);
      this.fGr = true;
    }
    for (;;)
    {
      i += 1;
      break label20;
      break;
      label65:
      if (fGA == k) {
        this.field_CreateTime = paramCursor.getLong(i);
      } else if (fGB == k) {
        this.field_ExpiredTime = paramCursor.getLong(i);
      } else if (fGC == k) {
        this.field_Description = paramCursor.getString(i);
      } else if (fGD == k) {
        this.field_UserIcon = paramCursor.getString(i);
      } else if (fGE == k) {
        this.field_UserName = paramCursor.getString(i);
      } else if (fGF == k) {
        this.field_ExtInfo = paramCursor.getString(i);
      } else if (fGG == k) {
        this.field_Status = paramCursor.getInt(i);
      } else if (rowid_HASHCODE == k) {
        this.systemRowid = paramCursor.getLong(i);
      }
    }
  }
  
  public ContentValues convertTo()
  {
    ContentValues localContentValues = new ContentValues();
    if (this.fGr) {
      localContentValues.put("ForcePushId", this.field_ForcePushId);
    }
    if (this.fGs) {
      localContentValues.put("CreateTime", Long.valueOf(this.field_CreateTime));
    }
    if (this.fGt) {
      localContentValues.put("ExpiredTime", Long.valueOf(this.field_ExpiredTime));
    }
    if (this.fGu) {
      localContentValues.put("Description", this.field_Description);
    }
    if (this.fGv) {
      localContentValues.put("UserIcon", this.field_UserIcon);
    }
    if (this.fGw) {
      localContentValues.put("UserName", this.field_UserName);
    }
    if (this.fGx) {
      localContentValues.put("ExtInfo", this.field_ExtInfo);
    }
    if (this.fGy) {
      localContentValues.put("Status", Integer.valueOf(this.field_Status));
    }
    if (this.systemRowid > 0L) {
      localContentValues.put("rowid", Long.valueOf(this.systemRowid));
    }
    return localContentValues;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.g.c.cq
 * JD-Core Version:    0.7.0.1
 */