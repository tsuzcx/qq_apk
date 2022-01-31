package com.tencent.mm.h.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;

public abstract class ev
  extends c
{
  public static final String[] cqY = new String[0];
  private static final int crh = "rowid".hashCode();
  private static final int dcA;
  private static final int dcB;
  private static final int dcy = "pref_key".hashCode();
  private static final int dcz = "pref_title".hashCode();
  private boolean dcu = true;
  private boolean dcv = true;
  private boolean dcw = true;
  private boolean dcx = true;
  public int field_is_show;
  public String field_pref_key;
  public String field_pref_title;
  public String field_pref_url;
  
  static
  {
    dcA = "pref_url".hashCode();
    dcB = "is_show".hashCode();
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
      if (dcy != k) {
        break label65;
      }
      this.field_pref_key = paramCursor.getString(i);
      this.dcu = true;
    }
    for (;;)
    {
      i += 1;
      break label20;
      break;
      label65:
      if (dcz == k) {
        this.field_pref_title = paramCursor.getString(i);
      } else if (dcA == k) {
        this.field_pref_url = paramCursor.getString(i);
      } else if (dcB == k) {
        this.field_is_show = paramCursor.getInt(i);
      } else if (crh == k) {
        this.ujK = paramCursor.getLong(i);
      }
    }
  }
  
  public final ContentValues vf()
  {
    ContentValues localContentValues = new ContentValues();
    if (this.dcu) {
      localContentValues.put("pref_key", this.field_pref_key);
    }
    if (this.dcv) {
      localContentValues.put("pref_title", this.field_pref_title);
    }
    if (this.dcw) {
      localContentValues.put("pref_url", this.field_pref_url);
    }
    if (this.dcx) {
      localContentValues.put("is_show", Integer.valueOf(this.field_is_show));
    }
    if (this.ujK > 0L) {
      localContentValues.put("rowid", Long.valueOf(this.ujK));
    }
    return localContentValues;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.h.c.ev
 * JD-Core Version:    0.7.0.1
 */