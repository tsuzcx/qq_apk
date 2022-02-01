package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;

public abstract class eb
  extends c
{
  public static final String[] INDEX_CREATE = new String[0];
  private static final int eJC = "title".hashCode();
  private static final int flh = "loan_jump_url".hashCode();
  private static final int fli = "red_dot_index".hashCode();
  private static final int flj = "is_show_entry".hashCode();
  private static final int flk = "tips".hashCode();
  private static final int fll = "is_overdue".hashCode();
  private static final int flm = "available_otb".hashCode();
  private static final int rowid_HASHCODE = "rowid".hashCode();
  private boolean eJz = true;
  public String field_available_otb;
  public int field_is_overdue;
  public int field_is_show_entry;
  public String field_loan_jump_url;
  public int field_red_dot_index;
  public String field_tips;
  public String field_title;
  private boolean flb = true;
  private boolean flc = true;
  private boolean fld = true;
  private boolean fle = true;
  private boolean flf = true;
  private boolean flg = true;
  
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
      if (eJC != k) {
        break label65;
      }
      this.field_title = paramCursor.getString(i);
      this.eJz = true;
    }
    for (;;)
    {
      i += 1;
      break label20;
      break;
      label65:
      if (flh == k) {
        this.field_loan_jump_url = paramCursor.getString(i);
      } else if (fli == k) {
        this.field_red_dot_index = paramCursor.getInt(i);
      } else if (flj == k) {
        this.field_is_show_entry = paramCursor.getInt(i);
      } else if (flk == k) {
        this.field_tips = paramCursor.getString(i);
      } else if (fll == k) {
        this.field_is_overdue = paramCursor.getInt(i);
      } else if (flm == k) {
        this.field_available_otb = paramCursor.getString(i);
      } else if (rowid_HASHCODE == k) {
        this.systemRowid = paramCursor.getLong(i);
      }
    }
  }
  
  public ContentValues convertTo()
  {
    ContentValues localContentValues = new ContentValues();
    if (this.eJz) {
      localContentValues.put("title", this.field_title);
    }
    if (this.flb) {
      localContentValues.put("loan_jump_url", this.field_loan_jump_url);
    }
    if (this.flc) {
      localContentValues.put("red_dot_index", Integer.valueOf(this.field_red_dot_index));
    }
    if (this.fld) {
      localContentValues.put("is_show_entry", Integer.valueOf(this.field_is_show_entry));
    }
    if (this.fle) {
      localContentValues.put("tips", this.field_tips);
    }
    if (this.flf) {
      localContentValues.put("is_overdue", Integer.valueOf(this.field_is_overdue));
    }
    if (this.flg) {
      localContentValues.put("available_otb", this.field_available_otb);
    }
    if (this.systemRowid > 0L) {
      localContentValues.put("rowid", Long.valueOf(this.systemRowid));
    }
    return localContentValues;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.g.c.eb
 * JD-Core Version:    0.7.0.1
 */