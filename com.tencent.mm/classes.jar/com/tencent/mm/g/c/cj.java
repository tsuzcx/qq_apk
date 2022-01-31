package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;

public abstract class cj
  extends c
{
  public static final String[] INDEX_CREATE = new String[0];
  private static final int dCX = "appusername".hashCode();
  private static final int dDa = "score".hashCode();
  private static final int dkj = "title".hashCode();
  private static final int rowid_HASHCODE = "rowid".hashCode();
  private boolean dCU;
  private boolean dCZ;
  private boolean dkg;
  public String field_appusername;
  public int field_score;
  public String field_title;
  
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
      if (dCX != k) {
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
      if (dkj == k) {
        this.field_title = paramCursor.getString(i);
      } else if (dDa == k) {
        this.field_score = paramCursor.getInt(i);
      } else if (rowid_HASHCODE == k) {
        this.systemRowid = paramCursor.getLong(i);
      }
    }
  }
  
  public ContentValues convertTo()
  {
    ContentValues localContentValues = new ContentValues();
    if (this.dCU) {
      localContentValues.put("appusername", this.field_appusername);
    }
    if (this.dkg) {
      localContentValues.put("title", this.field_title);
    }
    if (this.dCZ) {
      localContentValues.put("score", Integer.valueOf(this.field_score));
    }
    if (this.systemRowid > 0L) {
      localContentValues.put("rowid", Long.valueOf(this.systemRowid));
    }
    return localContentValues;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.g.c.cj
 * JD-Core Version:    0.7.0.1
 */