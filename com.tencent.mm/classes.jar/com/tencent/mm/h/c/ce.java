package com.tencent.mm.h.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;

public abstract class ce
  extends c
{
  private static final int cNh;
  private static final int cNk = "score".hashCode();
  public static final String[] cqY = new String[0];
  private static final int crh = "rowid".hashCode();
  private static final int cvZ;
  private boolean cNe;
  private boolean cNj;
  private boolean cvV;
  public String field_appusername;
  public int field_score;
  public String field_title;
  
  static
  {
    cNh = "appusername".hashCode();
    cvZ = "title".hashCode();
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
      if (cvZ == k) {
        this.field_title = paramCursor.getString(i);
      } else if (cNk == k) {
        this.field_score = paramCursor.getInt(i);
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
    if (this.cvV) {
      localContentValues.put("title", this.field_title);
    }
    if (this.cNj) {
      localContentValues.put("score", Integer.valueOf(this.field_score));
    }
    if (this.ujK > 0L) {
      localContentValues.put("rowid", Long.valueOf(this.ujK));
    }
    return localContentValues;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.h.c.ce
 * JD-Core Version:    0.7.0.1
 */