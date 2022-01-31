package com.tencent.mm.h.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;

public abstract class bb
  extends c
{
  private static final int cGk = "desc".hashCode();
  private static final int cGo;
  public static final String[] cqY = new String[0];
  private static final int crh = "rowid".hashCode();
  private boolean cGg = true;
  private boolean cGn = true;
  public String field_desc;
  public String field_groupID;
  
  static
  {
    cGo = "groupID".hashCode();
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
      if (cGo != k) {
        break label60;
      }
      this.field_groupID = paramCursor.getString(i);
    }
    for (;;)
    {
      i += 1;
      break label20;
      break;
      label60:
      if (cGk == k) {
        this.field_desc = paramCursor.getString(i);
      } else if (crh == k) {
        this.ujK = paramCursor.getLong(i);
      }
    }
  }
  
  public final ContentValues vf()
  {
    ContentValues localContentValues = new ContentValues();
    if (this.cGn) {
      localContentValues.put("groupID", this.field_groupID);
    }
    if (this.cGg) {
      localContentValues.put("desc", this.field_desc);
    }
    if (this.ujK > 0L) {
      localContentValues.put("rowid", Long.valueOf(this.ujK));
    }
    return localContentValues;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.h.c.bb
 * JD-Core Version:    0.7.0.1
 */