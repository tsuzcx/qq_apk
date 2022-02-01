package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;

public abstract class cx
  extends c
{
  public static final String[] INDEX_CREATE = new String[0];
  private static final int eCC = "timestamp".hashCode();
  private static final int eKA = "rankID".hashCode();
  private static final int eKB = "appusername".hashCode();
  private static final int eKC = "liketips".hashCode();
  private static final int eme = "username".hashCode();
  private static final int rowid_HASHCODE = "rowid".hashCode();
  private boolean eCs = true;
  private boolean eKx = true;
  private boolean eKy = true;
  private boolean eKz = true;
  private boolean emb = true;
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
      if (eKA != k) {
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
      if (eKB == k) {
        this.field_appusername = paramCursor.getString(i);
      } else if (eme == k) {
        this.field_username = paramCursor.getString(i);
      } else if (eCC == k) {
        this.field_timestamp = paramCursor.getInt(i);
      } else if (eKC == k) {
        this.field_liketips = paramCursor.getString(i);
      } else if (rowid_HASHCODE == k) {
        this.systemRowid = paramCursor.getLong(i);
      }
    }
  }
  
  public ContentValues convertTo()
  {
    ContentValues localContentValues = new ContentValues();
    if (this.eKx) {
      localContentValues.put("rankID", this.field_rankID);
    }
    if (this.eKy) {
      localContentValues.put("appusername", this.field_appusername);
    }
    if (this.emb) {
      localContentValues.put("username", this.field_username);
    }
    if (this.eCs) {
      localContentValues.put("timestamp", Integer.valueOf(this.field_timestamp));
    }
    if (this.field_liketips == null) {
      this.field_liketips = "";
    }
    if (this.eKz) {
      localContentValues.put("liketips", this.field_liketips);
    }
    if (this.systemRowid > 0L) {
      localContentValues.put("rowid", Long.valueOf(this.systemRowid));
    }
    return localContentValues;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.g.c.cx
 * JD-Core Version:    0.7.0.1
 */