package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;

public abstract class i
  extends c
{
  public static final String[] INDEX_CREATE = { "CREATE INDEX IF NOT EXISTS AppBrandAppLaunchRecordUpdateTimeIndex ON AppBrandAppLaunchUsernameDuplicateRecord2(updateTime)" };
  private static final int eFo = "usernameHash".hashCode();
  private static final int eFp = "username".hashCode();
  private static final int eFq = "updateTime".hashCode();
  private static final int rowid_HASHCODE = "rowid".hashCode();
  private boolean eFl = true;
  private boolean eFm = true;
  private boolean eFn = true;
  public long field_updateTime;
  public String field_username;
  public int field_usernameHash;
  
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
      if (eFo != k) {
        break label65;
      }
      this.field_usernameHash = paramCursor.getInt(i);
      this.eFl = true;
    }
    for (;;)
    {
      i += 1;
      break label20;
      break;
      label65:
      if (eFp == k) {
        this.field_username = paramCursor.getString(i);
      } else if (eFq == k) {
        this.field_updateTime = paramCursor.getLong(i);
      } else if (rowid_HASHCODE == k) {
        this.systemRowid = paramCursor.getLong(i);
      }
    }
  }
  
  public ContentValues convertTo()
  {
    ContentValues localContentValues = new ContentValues();
    if (this.eFl) {
      localContentValues.put("usernameHash", Integer.valueOf(this.field_usernameHash));
    }
    if (this.eFm) {
      localContentValues.put("username", this.field_username);
    }
    if (this.eFn) {
      localContentValues.put("updateTime", Long.valueOf(this.field_updateTime));
    }
    if (this.systemRowid > 0L) {
      localContentValues.put("rowid", Long.valueOf(this.systemRowid));
    }
    return localContentValues;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.g.c.i
 * JD-Core Version:    0.7.0.1
 */