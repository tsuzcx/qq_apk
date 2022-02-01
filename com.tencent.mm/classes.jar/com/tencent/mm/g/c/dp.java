package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.storage.IAutoDBItem;

public abstract class dp
  extends IAutoDBItem
{
  public static final String[] INDEX_CREATE = new String[0];
  private static final int fBI = "timestamp".hashCode();
  private static final int fMo = "rankID".hashCode();
  private static final int fMp = "appusername".hashCode();
  private static final int fMq = "liketips".hashCode();
  private static final int rowid_HASHCODE = "rowid".hashCode();
  private static final int username_HASHCODE = "username".hashCode();
  private boolean __hadSetusername = true;
  private boolean fBy = true;
  private boolean fMl = true;
  private boolean fMm = true;
  private boolean fMn = true;
  public String field_appusername;
  public String field_liketips;
  public String field_rankID;
  public int field_timestamp;
  public String field_username;
  
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
      if (fMo != k) {
        break label60;
      }
      this.field_rankID = paramCursor.getString(i);
    }
    for (;;)
    {
      i += 1;
      break label20;
      break;
      label60:
      if (fMp == k) {
        this.field_appusername = paramCursor.getString(i);
      } else if (username_HASHCODE == k) {
        this.field_username = paramCursor.getString(i);
      } else if (fBI == k) {
        this.field_timestamp = paramCursor.getInt(i);
      } else if (fMq == k) {
        this.field_liketips = paramCursor.getString(i);
      } else if (rowid_HASHCODE == k) {
        this.systemRowid = paramCursor.getLong(i);
      }
    }
  }
  
  public ContentValues convertTo()
  {
    ContentValues localContentValues = new ContentValues();
    if (this.fMl) {
      localContentValues.put("rankID", this.field_rankID);
    }
    if (this.fMm) {
      localContentValues.put("appusername", this.field_appusername);
    }
    if (this.__hadSetusername) {
      localContentValues.put("username", this.field_username);
    }
    if (this.fBy) {
      localContentValues.put("timestamp", Integer.valueOf(this.field_timestamp));
    }
    if (this.field_liketips == null) {
      this.field_liketips = "";
    }
    if (this.fMn) {
      localContentValues.put("liketips", this.field_liketips);
    }
    if (this.systemRowid > 0L) {
      localContentValues.put("rowid", Long.valueOf(this.systemRowid));
    }
    return localContentValues;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.g.c.dp
 * JD-Core Version:    0.7.0.1
 */