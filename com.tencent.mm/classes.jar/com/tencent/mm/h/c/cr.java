package com.tencent.mm.h.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;

public abstract class cr
  extends c
{
  private static final int cQn = "loan_jump_url".hashCode();
  private static final int cQo = "red_dot_index".hashCode();
  private static final int cQp = "is_show_entry".hashCode();
  private static final int cQq = "tips".hashCode();
  private static final int cQr = "is_overdue".hashCode();
  private static final int cQs = "available_otb".hashCode();
  public static final String[] cqY = new String[0];
  private static final int crh = "rowid".hashCode();
  private static final int cvZ = "title".hashCode();
  private boolean cQh = true;
  private boolean cQi = true;
  private boolean cQj = true;
  private boolean cQk = true;
  private boolean cQl = true;
  private boolean cQm = true;
  private boolean cvV = true;
  public String field_available_otb;
  public int field_is_overdue;
  public int field_is_show_entry;
  public String field_loan_jump_url;
  public int field_red_dot_index;
  public String field_tips;
  public String field_title;
  
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
      if (cvZ != k) {
        break label65;
      }
      this.field_title = paramCursor.getString(i);
      this.cvV = true;
    }
    for (;;)
    {
      i += 1;
      break label20;
      break;
      label65:
      if (cQn == k) {
        this.field_loan_jump_url = paramCursor.getString(i);
      } else if (cQo == k) {
        this.field_red_dot_index = paramCursor.getInt(i);
      } else if (cQp == k) {
        this.field_is_show_entry = paramCursor.getInt(i);
      } else if (cQq == k) {
        this.field_tips = paramCursor.getString(i);
      } else if (cQr == k) {
        this.field_is_overdue = paramCursor.getInt(i);
      } else if (cQs == k) {
        this.field_available_otb = paramCursor.getString(i);
      } else if (crh == k) {
        this.ujK = paramCursor.getLong(i);
      }
    }
  }
  
  public final ContentValues vf()
  {
    ContentValues localContentValues = new ContentValues();
    if (this.cvV) {
      localContentValues.put("title", this.field_title);
    }
    if (this.cQh) {
      localContentValues.put("loan_jump_url", this.field_loan_jump_url);
    }
    if (this.cQi) {
      localContentValues.put("red_dot_index", Integer.valueOf(this.field_red_dot_index));
    }
    if (this.cQj) {
      localContentValues.put("is_show_entry", Integer.valueOf(this.field_is_show_entry));
    }
    if (this.cQk) {
      localContentValues.put("tips", this.field_tips);
    }
    if (this.cQl) {
      localContentValues.put("is_overdue", Integer.valueOf(this.field_is_overdue));
    }
    if (this.cQm) {
      localContentValues.put("available_otb", this.field_available_otb);
    }
    if (this.ujK > 0L) {
      localContentValues.put("rowid", Long.valueOf(this.ujK));
    }
    return localContentValues;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.h.c.cr
 * JD-Core Version:    0.7.0.1
 */