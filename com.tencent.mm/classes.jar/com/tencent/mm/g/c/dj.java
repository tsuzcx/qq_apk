package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;

public abstract class dj
  extends c
{
  public static final String[] INDEX_CREATE = new String[0];
  private static final int eGY = "username".hashCode();
  private static final int eYf = "timestamp".hashCode();
  private static final int fhL = "rankID".hashCode();
  private static final int fhM = "appusername".hashCode();
  private static final int fhN = "liketips".hashCode();
  private static final int rowid_HASHCODE = "rowid".hashCode();
  private boolean eGV = true;
  private boolean eXV = true;
  private boolean fhI = true;
  private boolean fhJ = true;
  private boolean fhK = true;
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
      if (fhL != k) {
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
      if (fhM == k) {
        this.field_appusername = paramCursor.getString(i);
      } else if (eGY == k) {
        this.field_username = paramCursor.getString(i);
      } else if (eYf == k) {
        this.field_timestamp = paramCursor.getInt(i);
      } else if (fhN == k) {
        this.field_liketips = paramCursor.getString(i);
      } else if (rowid_HASHCODE == k) {
        this.systemRowid = paramCursor.getLong(i);
      }
    }
  }
  
  public ContentValues convertTo()
  {
    ContentValues localContentValues = new ContentValues();
    if (this.fhI) {
      localContentValues.put("rankID", this.field_rankID);
    }
    if (this.fhJ) {
      localContentValues.put("appusername", this.field_appusername);
    }
    if (this.eGV) {
      localContentValues.put("username", this.field_username);
    }
    if (this.eXV) {
      localContentValues.put("timestamp", Integer.valueOf(this.field_timestamp));
    }
    if (this.field_liketips == null) {
      this.field_liketips = "";
    }
    if (this.fhK) {
      localContentValues.put("liketips", this.field_liketips);
    }
    if (this.systemRowid > 0L) {
      localContentValues.put("rowid", Long.valueOf(this.systemRowid));
    }
    return localContentValues;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.g.c.dj
 * JD-Core Version:    0.7.0.1
 */