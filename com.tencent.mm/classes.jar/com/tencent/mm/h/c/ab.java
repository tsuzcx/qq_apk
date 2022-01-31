package com.tencent.mm.h.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;

public abstract class ab
  extends c
{
  public static final String[] cqY = new String[0];
  private static final int crh = "rowid".hashCode();
  private static final int cwT = "brandUserName".hashCode();
  private static final int cxF = "userId".hashCode();
  private boolean cwF = true;
  private boolean cxE = true;
  public String field_brandUserName;
  public String field_userId;
  
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
      if (cwT != k) {
        break label65;
      }
      this.field_brandUserName = paramCursor.getString(i);
      this.cwF = true;
    }
    for (;;)
    {
      i += 1;
      break label20;
      break;
      label65:
      if (cxF == k) {
        this.field_userId = paramCursor.getString(i);
      } else if (crh == k) {
        this.ujK = paramCursor.getLong(i);
      }
    }
  }
  
  public final ContentValues vf()
  {
    ContentValues localContentValues = new ContentValues();
    if (this.cwF) {
      localContentValues.put("brandUserName", this.field_brandUserName);
    }
    if (this.cxE) {
      localContentValues.put("userId", this.field_userId);
    }
    if (this.ujK > 0L) {
      localContentValues.put("rowid", Long.valueOf(this.ujK));
    }
    return localContentValues;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.h.c.ab
 * JD-Core Version:    0.7.0.1
 */