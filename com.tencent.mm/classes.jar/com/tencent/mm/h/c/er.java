package com.tencent.mm.h.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;

public abstract class er
  extends c
{
  public static final String[] cqY = new String[0];
  private static final int crh = "rowid".hashCode();
  private static final int dbN = "bulletin_scene".hashCode();
  private static final int dbO = "bulletin_content".hashCode();
  private static final int dbP = "bulletin_url".hashCode();
  private boolean dbK = true;
  private boolean dbL = true;
  private boolean dbM = true;
  public String field_bulletin_content;
  public String field_bulletin_scene;
  public String field_bulletin_url;
  
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
      if (dbN != k) {
        break label65;
      }
      this.field_bulletin_scene = paramCursor.getString(i);
      this.dbK = true;
    }
    for (;;)
    {
      i += 1;
      break label20;
      break;
      label65:
      if (dbO == k) {
        this.field_bulletin_content = paramCursor.getString(i);
      } else if (dbP == k) {
        this.field_bulletin_url = paramCursor.getString(i);
      } else if (crh == k) {
        this.ujK = paramCursor.getLong(i);
      }
    }
  }
  
  public final ContentValues vf()
  {
    ContentValues localContentValues = new ContentValues();
    if (this.dbK) {
      localContentValues.put("bulletin_scene", this.field_bulletin_scene);
    }
    if (this.dbL) {
      localContentValues.put("bulletin_content", this.field_bulletin_content);
    }
    if (this.dbM) {
      localContentValues.put("bulletin_url", this.field_bulletin_url);
    }
    if (this.ujK > 0L) {
      localContentValues.put("rowid", Long.valueOf(this.ujK));
    }
    return localContentValues;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.h.c.er
 * JD-Core Version:    0.7.0.1
 */