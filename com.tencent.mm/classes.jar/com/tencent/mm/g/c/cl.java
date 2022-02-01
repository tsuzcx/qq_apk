package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;

public abstract class cl
  extends c
{
  public static final String[] INDEX_CREATE = new String[0];
  private static final int far = "ForcePushId".hashCode();
  private static final int fas = "CreateTime".hashCode();
  private static final int fat = "ExpiredTime".hashCode();
  private static final int fau = "Description".hashCode();
  private static final int fav = "UserIcon".hashCode();
  private static final int faw = "UserName".hashCode();
  private static final int fax = "ExtInfo".hashCode();
  private static final int fay = "Status".hashCode();
  private static final int rowid_HASHCODE = "rowid".hashCode();
  private boolean faj = true;
  private boolean fak = true;
  private boolean fal = true;
  private boolean fam = true;
  private boolean fan = true;
  private boolean fao = true;
  private boolean fap = true;
  private boolean faq = true;
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
      if (far != k) {
        break label65;
      }
      this.field_ForcePushId = paramCursor.getString(i);
      this.faj = true;
    }
    for (;;)
    {
      i += 1;
      break label20;
      break;
      label65:
      if (fas == k) {
        this.field_CreateTime = paramCursor.getLong(i);
      } else if (fat == k) {
        this.field_ExpiredTime = paramCursor.getLong(i);
      } else if (fau == k) {
        this.field_Description = paramCursor.getString(i);
      } else if (fav == k) {
        this.field_UserIcon = paramCursor.getString(i);
      } else if (faw == k) {
        this.field_UserName = paramCursor.getString(i);
      } else if (fax == k) {
        this.field_ExtInfo = paramCursor.getString(i);
      } else if (fay == k) {
        this.field_Status = paramCursor.getInt(i);
      } else if (rowid_HASHCODE == k) {
        this.systemRowid = paramCursor.getLong(i);
      }
    }
  }
  
  public ContentValues convertTo()
  {
    ContentValues localContentValues = new ContentValues();
    if (this.faj) {
      localContentValues.put("ForcePushId", this.field_ForcePushId);
    }
    if (this.fak) {
      localContentValues.put("CreateTime", Long.valueOf(this.field_CreateTime));
    }
    if (this.fal) {
      localContentValues.put("ExpiredTime", Long.valueOf(this.field_ExpiredTime));
    }
    if (this.fam) {
      localContentValues.put("Description", this.field_Description);
    }
    if (this.fan) {
      localContentValues.put("UserIcon", this.field_UserIcon);
    }
    if (this.fao) {
      localContentValues.put("UserName", this.field_UserName);
    }
    if (this.fap) {
      localContentValues.put("ExtInfo", this.field_ExtInfo);
    }
    if (this.faq) {
      localContentValues.put("Status", Integer.valueOf(this.field_Status));
    }
    if (this.systemRowid > 0L) {
      localContentValues.put("rowid", Long.valueOf(this.systemRowid));
    }
    return localContentValues;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.g.c.cl
 * JD-Core Version:    0.7.0.1
 */