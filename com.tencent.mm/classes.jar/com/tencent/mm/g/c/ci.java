package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;

public abstract class ci
  extends c
{
  public static final String[] INDEX_CREATE = new String[0];
  private static final int dCW = "rankID".hashCode();
  private static final int dCX = "appusername".hashCode();
  private static final int dCY = "liketips".hashCode();
  private static final int dhU = "username".hashCode();
  private static final int dxs = "timestamp".hashCode();
  private static final int rowid_HASHCODE = "rowid".hashCode();
  private boolean dCT = true;
  private boolean dCU = true;
  private boolean dCV = true;
  private boolean dhS = true;
  private boolean dxi = true;
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
      if (dCW != k) {
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
      if (dCX == k) {
        this.field_appusername = paramCursor.getString(i);
      } else if (dhU == k) {
        this.field_username = paramCursor.getString(i);
      } else if (dxs == k) {
        this.field_timestamp = paramCursor.getInt(i);
      } else if (dCY == k) {
        this.field_liketips = paramCursor.getString(i);
      } else if (rowid_HASHCODE == k) {
        this.systemRowid = paramCursor.getLong(i);
      }
    }
  }
  
  public ContentValues convertTo()
  {
    ContentValues localContentValues = new ContentValues();
    if (this.dCT) {
      localContentValues.put("rankID", this.field_rankID);
    }
    if (this.dCU) {
      localContentValues.put("appusername", this.field_appusername);
    }
    if (this.dhS) {
      localContentValues.put("username", this.field_username);
    }
    if (this.dxi) {
      localContentValues.put("timestamp", Integer.valueOf(this.field_timestamp));
    }
    if (this.field_liketips == null) {
      this.field_liketips = "";
    }
    if (this.dCV) {
      localContentValues.put("liketips", this.field_liketips);
    }
    if (this.systemRowid > 0L) {
      localContentValues.put("rowid", Long.valueOf(this.systemRowid));
    }
    return localContentValues;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.g.c.ci
 * JD-Core Version:    0.7.0.1
 */