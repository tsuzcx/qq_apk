package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.storage.IAutoDBItem;

public abstract class gy
  extends IAutoDBItem
{
  public static final String[] INDEX_CREATE = new String[0];
  private static final int fkj;
  private static final int fmt = "openId".hashCode();
  private static final int rowid_HASHCODE = "rowid".hashCode();
  private static final int username_HASHCODE;
  private boolean __hadSetusername = true;
  public String field_appId;
  public String field_openId;
  public String field_username;
  private boolean fjS = true;
  private boolean flX = true;
  
  static
  {
    fkj = "appId".hashCode();
    username_HASHCODE = "username".hashCode();
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
      if (fmt != k) {
        break label65;
      }
      this.field_openId = paramCursor.getString(i);
      this.flX = true;
    }
    for (;;)
    {
      i += 1;
      break label20;
      break;
      label65:
      if (fkj == k) {
        this.field_appId = paramCursor.getString(i);
      } else if (username_HASHCODE == k) {
        this.field_username = paramCursor.getString(i);
      } else if (rowid_HASHCODE == k) {
        this.systemRowid = paramCursor.getLong(i);
      }
    }
  }
  
  public ContentValues convertTo()
  {
    ContentValues localContentValues = new ContentValues();
    if (this.flX) {
      localContentValues.put("openId", this.field_openId);
    }
    if (this.fjS) {
      localContentValues.put("appId", this.field_appId);
    }
    if (this.__hadSetusername) {
      localContentValues.put("username", this.field_username);
    }
    if (this.systemRowid > 0L) {
      localContentValues.put("rowid", Long.valueOf(this.systemRowid));
    }
    return localContentValues;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.g.c.gy
 * JD-Core Version:    0.7.0.1
 */