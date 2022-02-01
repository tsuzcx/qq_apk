package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;

public abstract class cz
  extends c
{
  public static final String[] INDEX_CREATE = new String[0];
  private static final int eEW = "timestamp".hashCode();
  private static final int eNs = "rankID".hashCode();
  private static final int eNt = "appusername".hashCode();
  private static final int eNu = "liketips".hashCode();
  private static final int eok = "username".hashCode();
  private static final int rowid_HASHCODE = "rowid".hashCode();
  private boolean eEM = true;
  private boolean eNp = true;
  private boolean eNq = true;
  private boolean eNr = true;
  private boolean eoh = true;
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
      if (eNs != k) {
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
      if (eNt == k) {
        this.field_appusername = paramCursor.getString(i);
      } else if (eok == k) {
        this.field_username = paramCursor.getString(i);
      } else if (eEW == k) {
        this.field_timestamp = paramCursor.getInt(i);
      } else if (eNu == k) {
        this.field_liketips = paramCursor.getString(i);
      } else if (rowid_HASHCODE == k) {
        this.systemRowid = paramCursor.getLong(i);
      }
    }
  }
  
  public ContentValues convertTo()
  {
    ContentValues localContentValues = new ContentValues();
    if (this.eNp) {
      localContentValues.put("rankID", this.field_rankID);
    }
    if (this.eNq) {
      localContentValues.put("appusername", this.field_appusername);
    }
    if (this.eoh) {
      localContentValues.put("username", this.field_username);
    }
    if (this.eEM) {
      localContentValues.put("timestamp", Integer.valueOf(this.field_timestamp));
    }
    if (this.field_liketips == null) {
      this.field_liketips = "";
    }
    if (this.eNr) {
      localContentValues.put("liketips", this.field_liketips);
    }
    if (this.systemRowid > 0L) {
      localContentValues.put("rowid", Long.valueOf(this.systemRowid));
    }
    return localContentValues;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.g.c.cz
 * JD-Core Version:    0.7.0.1
 */