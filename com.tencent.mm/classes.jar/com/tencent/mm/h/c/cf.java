package com.tencent.mm.h.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;

public abstract class cf
  extends c
{
  private static final int cEM = "sort".hashCode();
  private static final int cNg;
  private static final int cNh;
  private static final int cNm;
  public static final String[] cqY = new String[0];
  private static final int crh = "rowid".hashCode();
  private static final int ctF;
  private boolean cEm = true;
  private boolean cNd = true;
  private boolean cNe = true;
  private boolean cNl = true;
  private boolean ctD = true;
  public String field_appusername;
  public String field_rankID;
  public int field_sort;
  public int field_step;
  public String field_username;
  
  static
  {
    cNh = "appusername".hashCode();
    cNg = "rankID".hashCode();
    ctF = "username".hashCode();
    cNm = "step".hashCode();
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
      if (cNh != k) {
        break label60;
      }
      this.field_appusername = paramCursor.getString(i);
    }
    for (;;)
    {
      i += 1;
      break label20;
      break;
      label60:
      if (cNg == k) {
        this.field_rankID = paramCursor.getString(i);
      } else if (ctF == k) {
        this.field_username = paramCursor.getString(i);
      } else if (cNm == k) {
        this.field_step = paramCursor.getInt(i);
      } else if (cEM == k) {
        this.field_sort = paramCursor.getInt(i);
      } else if (crh == k) {
        this.ujK = paramCursor.getLong(i);
      }
    }
  }
  
  public final ContentValues vf()
  {
    ContentValues localContentValues = new ContentValues();
    if (this.cNe) {
      localContentValues.put("appusername", this.field_appusername);
    }
    if (this.cNd) {
      localContentValues.put("rankID", this.field_rankID);
    }
    if (this.ctD) {
      localContentValues.put("username", this.field_username);
    }
    if (this.cNl) {
      localContentValues.put("step", Integer.valueOf(this.field_step));
    }
    if (this.cEm) {
      localContentValues.put("sort", Integer.valueOf(this.field_sort));
    }
    if (this.ujK > 0L) {
      localContentValues.put("rowid", Long.valueOf(this.ujK));
    }
    return localContentValues;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.h.c.cf
 * JD-Core Version:    0.7.0.1
 */