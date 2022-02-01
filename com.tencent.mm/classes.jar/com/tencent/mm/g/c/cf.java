package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;

public abstract class cf
  extends c
{
  public static final String[] INDEX_CREATE = new String[0];
  private static final int eFn = "ForcePushId".hashCode();
  private static final int eFo = "CreateTime".hashCode();
  private static final int eFp = "ExpiredTime".hashCode();
  private static final int eFq = "Description".hashCode();
  private static final int eFr = "UserIcon".hashCode();
  private static final int eFs = "UserName".hashCode();
  private static final int eFt = "ExtInfo".hashCode();
  private static final int eFu = "Status".hashCode();
  private static final int rowid_HASHCODE = "rowid".hashCode();
  private boolean eFf = true;
  private boolean eFg = true;
  private boolean eFh = true;
  private boolean eFi = true;
  private boolean eFj = true;
  private boolean eFk = true;
  private boolean eFl = true;
  private boolean eFm = true;
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
      if (eFn != k) {
        break label65;
      }
      this.field_ForcePushId = paramCursor.getString(i);
      this.eFf = true;
    }
    for (;;)
    {
      i += 1;
      break label20;
      break;
      label65:
      if (eFo == k) {
        this.field_CreateTime = paramCursor.getLong(i);
      } else if (eFp == k) {
        this.field_ExpiredTime = paramCursor.getLong(i);
      } else if (eFq == k) {
        this.field_Description = paramCursor.getString(i);
      } else if (eFr == k) {
        this.field_UserIcon = paramCursor.getString(i);
      } else if (eFs == k) {
        this.field_UserName = paramCursor.getString(i);
      } else if (eFt == k) {
        this.field_ExtInfo = paramCursor.getString(i);
      } else if (eFu == k) {
        this.field_Status = paramCursor.getInt(i);
      } else if (rowid_HASHCODE == k) {
        this.systemRowid = paramCursor.getLong(i);
      }
    }
  }
  
  public ContentValues convertTo()
  {
    ContentValues localContentValues = new ContentValues();
    if (this.eFf) {
      localContentValues.put("ForcePushId", this.field_ForcePushId);
    }
    if (this.eFg) {
      localContentValues.put("CreateTime", Long.valueOf(this.field_CreateTime));
    }
    if (this.eFh) {
      localContentValues.put("ExpiredTime", Long.valueOf(this.field_ExpiredTime));
    }
    if (this.eFi) {
      localContentValues.put("Description", this.field_Description);
    }
    if (this.eFj) {
      localContentValues.put("UserIcon", this.field_UserIcon);
    }
    if (this.eFk) {
      localContentValues.put("UserName", this.field_UserName);
    }
    if (this.eFl) {
      localContentValues.put("ExtInfo", this.field_ExtInfo);
    }
    if (this.eFm) {
      localContentValues.put("Status", Integer.valueOf(this.field_Status));
    }
    if (this.systemRowid > 0L) {
      localContentValues.put("rowid", Long.valueOf(this.systemRowid));
    }
    return localContentValues;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.g.c.cf
 * JD-Core Version:    0.7.0.1
 */