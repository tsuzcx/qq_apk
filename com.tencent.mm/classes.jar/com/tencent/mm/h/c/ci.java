package com.tencent.mm.h.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;

public abstract class ci
  extends c
{
  private static final int cNA = "sortKey".hashCode();
  private static final int cNx;
  private static final int cNy;
  private static final int cNz;
  public static final String[] cqY = new String[0];
  private static final int crh = "rowid".hashCode();
  private boolean cNt = true;
  private boolean cNu = true;
  private boolean cNv = true;
  private boolean cNw = true;
  public String field_contactId;
  public String field_sortKey;
  public String field_systemAddressBookUsername;
  public String field_wechatUsername;
  
  static
  {
    cNx = "wechatUsername".hashCode();
    cNy = "systemAddressBookUsername".hashCode();
    cNz = "contactId".hashCode();
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
      if (cNx != k) {
        break label60;
      }
      this.field_wechatUsername = paramCursor.getString(i);
    }
    for (;;)
    {
      i += 1;
      break label20;
      break;
      label60:
      if (cNy == k) {
        this.field_systemAddressBookUsername = paramCursor.getString(i);
      } else if (cNz == k) {
        this.field_contactId = paramCursor.getString(i);
      } else if (cNA == k) {
        this.field_sortKey = paramCursor.getString(i);
      } else if (crh == k) {
        this.ujK = paramCursor.getLong(i);
      }
    }
  }
  
  public final ContentValues vf()
  {
    ContentValues localContentValues = new ContentValues();
    if (this.cNt) {
      localContentValues.put("wechatUsername", this.field_wechatUsername);
    }
    if (this.cNu) {
      localContentValues.put("systemAddressBookUsername", this.field_systemAddressBookUsername);
    }
    if (this.cNv) {
      localContentValues.put("contactId", this.field_contactId);
    }
    if (this.cNw) {
      localContentValues.put("sortKey", this.field_sortKey);
    }
    if (this.ujK > 0L) {
      localContentValues.put("rowid", Long.valueOf(this.ujK));
    }
    return localContentValues;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.h.c.ci
 * JD-Core Version:    0.7.0.1
 */