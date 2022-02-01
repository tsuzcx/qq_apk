package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;

public abstract class do
  extends c
{
  public static final String[] INDEX_CREATE = new String[0];
  private static final int fic = "wechatUsername".hashCode();
  private static final int fid = "systemAddressBookUsername".hashCode();
  private static final int fie = "contactId".hashCode();
  private static final int fif = "sortKey".hashCode();
  private static final int rowid_HASHCODE = "rowid".hashCode();
  private boolean fhY = true;
  private boolean fhZ = true;
  private boolean fia = true;
  private boolean fib = true;
  public String field_contactId;
  public String field_sortKey;
  public String field_systemAddressBookUsername;
  public String field_wechatUsername;
  
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
      if (fic != k) {
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
      if (fid == k) {
        this.field_systemAddressBookUsername = paramCursor.getString(i);
      } else if (fie == k) {
        this.field_contactId = paramCursor.getString(i);
      } else if (fif == k) {
        this.field_sortKey = paramCursor.getString(i);
      } else if (rowid_HASHCODE == k) {
        this.systemRowid = paramCursor.getLong(i);
      }
    }
  }
  
  public ContentValues convertTo()
  {
    ContentValues localContentValues = new ContentValues();
    if (this.fhY) {
      localContentValues.put("wechatUsername", this.field_wechatUsername);
    }
    if (this.fhZ) {
      localContentValues.put("systemAddressBookUsername", this.field_systemAddressBookUsername);
    }
    if (this.fia) {
      localContentValues.put("contactId", this.field_contactId);
    }
    if (this.fib) {
      localContentValues.put("sortKey", this.field_sortKey);
    }
    if (this.systemRowid > 0L) {
      localContentValues.put("rowid", Long.valueOf(this.systemRowid));
    }
    return localContentValues;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.g.c.do
 * JD-Core Version:    0.7.0.1
 */