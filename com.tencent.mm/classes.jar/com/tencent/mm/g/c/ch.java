package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;

public abstract class ch
  extends c
{
  public static final String[] INDEX_CREATE = new String[0];
  private static final int eIf = "ForcePushId".hashCode();
  private static final int eIg = "CreateTime".hashCode();
  private static final int eIh = "ExpiredTime".hashCode();
  private static final int eIi = "Description".hashCode();
  private static final int eIj = "UserIcon".hashCode();
  private static final int eIk = "UserName".hashCode();
  private static final int eIl = "ExtInfo".hashCode();
  private static final int eIm = "Status".hashCode();
  private static final int rowid_HASHCODE = "rowid".hashCode();
  private boolean eHX = true;
  private boolean eHY = true;
  private boolean eHZ = true;
  private boolean eIa = true;
  private boolean eIb = true;
  private boolean eIc = true;
  private boolean eId = true;
  private boolean eIe = true;
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
      if (eIf != k) {
        break label65;
      }
      this.field_ForcePushId = paramCursor.getString(i);
      this.eHX = true;
    }
    for (;;)
    {
      i += 1;
      break label20;
      break;
      label65:
      if (eIg == k) {
        this.field_CreateTime = paramCursor.getLong(i);
      } else if (eIh == k) {
        this.field_ExpiredTime = paramCursor.getLong(i);
      } else if (eIi == k) {
        this.field_Description = paramCursor.getString(i);
      } else if (eIj == k) {
        this.field_UserIcon = paramCursor.getString(i);
      } else if (eIk == k) {
        this.field_UserName = paramCursor.getString(i);
      } else if (eIl == k) {
        this.field_ExtInfo = paramCursor.getString(i);
      } else if (eIm == k) {
        this.field_Status = paramCursor.getInt(i);
      } else if (rowid_HASHCODE == k) {
        this.systemRowid = paramCursor.getLong(i);
      }
    }
  }
  
  public ContentValues convertTo()
  {
    ContentValues localContentValues = new ContentValues();
    if (this.eHX) {
      localContentValues.put("ForcePushId", this.field_ForcePushId);
    }
    if (this.eHY) {
      localContentValues.put("CreateTime", Long.valueOf(this.field_CreateTime));
    }
    if (this.eHZ) {
      localContentValues.put("ExpiredTime", Long.valueOf(this.field_ExpiredTime));
    }
    if (this.eIa) {
      localContentValues.put("Description", this.field_Description);
    }
    if (this.eIb) {
      localContentValues.put("UserIcon", this.field_UserIcon);
    }
    if (this.eIc) {
      localContentValues.put("UserName", this.field_UserName);
    }
    if (this.eId) {
      localContentValues.put("ExtInfo", this.field_ExtInfo);
    }
    if (this.eIe) {
      localContentValues.put("Status", Integer.valueOf(this.field_Status));
    }
    if (this.systemRowid > 0L) {
      localContentValues.put("rowid", Long.valueOf(this.systemRowid));
    }
    return localContentValues;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.g.c.ch
 * JD-Core Version:    0.7.0.1
 */