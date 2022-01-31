package com.tencent.mm.h.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;

public abstract class cd
  extends c
{
  private static final int cII = "timestamp".hashCode();
  private static final int cNg;
  private static final int cNh;
  private static final int cNi = "liketips".hashCode();
  public static final String[] cqY = new String[0];
  private static final int crh = "rowid".hashCode();
  private static final int ctF;
  private boolean cIy = true;
  private boolean cNd = true;
  private boolean cNe = true;
  private boolean cNf = true;
  private boolean ctD = true;
  public String field_appusername;
  public String field_liketips;
  public String field_rankID;
  public int field_timestamp;
  public String field_username;
  
  static
  {
    cNg = "rankID".hashCode();
    cNh = "appusername".hashCode();
    ctF = "username".hashCode();
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
      if (cNg != k) {
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
      if (cNh == k) {
        this.field_appusername = paramCursor.getString(i);
      } else if (ctF == k) {
        this.field_username = paramCursor.getString(i);
      } else if (cII == k) {
        this.field_timestamp = paramCursor.getInt(i);
      } else if (cNi == k) {
        this.field_liketips = paramCursor.getString(i);
      } else if (crh == k) {
        this.ujK = paramCursor.getLong(i);
      }
    }
  }
  
  public final ContentValues vf()
  {
    ContentValues localContentValues = new ContentValues();
    if (this.cNd) {
      localContentValues.put("rankID", this.field_rankID);
    }
    if (this.cNe) {
      localContentValues.put("appusername", this.field_appusername);
    }
    if (this.ctD) {
      localContentValues.put("username", this.field_username);
    }
    if (this.cIy) {
      localContentValues.put("timestamp", Integer.valueOf(this.field_timestamp));
    }
    if (this.field_liketips == null) {
      this.field_liketips = "";
    }
    if (this.cNf) {
      localContentValues.put("liketips", this.field_liketips);
    }
    if (this.ujK > 0L) {
      localContentValues.put("rowid", Long.valueOf(this.ujK));
    }
    return localContentValues;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.h.c.cd
 * JD-Core Version:    0.7.0.1
 */