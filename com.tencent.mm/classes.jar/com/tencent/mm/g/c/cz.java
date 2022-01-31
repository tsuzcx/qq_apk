package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;

public abstract class cz
  extends c
{
  public static final String[] INDEX_CREATE = new String[0];
  private static final int dGh = "loan_jump_url".hashCode();
  private static final int dGi = "red_dot_index".hashCode();
  private static final int dGj = "is_show_entry".hashCode();
  private static final int dGk = "tips".hashCode();
  private static final int dGl = "is_overdue".hashCode();
  private static final int dGm = "available_otb".hashCode();
  private static final int dkj = "title".hashCode();
  private static final int rowid_HASHCODE = "rowid".hashCode();
  private boolean dGb = true;
  private boolean dGc = true;
  private boolean dGd = true;
  private boolean dGe = true;
  private boolean dGf = true;
  private boolean dGg = true;
  private boolean dkg = true;
  public String field_available_otb;
  public int field_is_overdue;
  public int field_is_show_entry;
  public String field_loan_jump_url;
  public int field_red_dot_index;
  public String field_tips;
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
      if (dkj != k) {
        break label65;
      }
      this.field_title = paramCursor.getString(i);
      this.dkg = true;
    }
    for (;;)
    {
      i += 1;
      break label20;
      break;
      label65:
      if (dGh == k) {
        this.field_loan_jump_url = paramCursor.getString(i);
      } else if (dGi == k) {
        this.field_red_dot_index = paramCursor.getInt(i);
      } else if (dGj == k) {
        this.field_is_show_entry = paramCursor.getInt(i);
      } else if (dGk == k) {
        this.field_tips = paramCursor.getString(i);
      } else if (dGl == k) {
        this.field_is_overdue = paramCursor.getInt(i);
      } else if (dGm == k) {
        this.field_available_otb = paramCursor.getString(i);
      } else if (rowid_HASHCODE == k) {
        this.systemRowid = paramCursor.getLong(i);
      }
    }
  }
  
  public ContentValues convertTo()
  {
    ContentValues localContentValues = new ContentValues();
    if (this.dkg) {
      localContentValues.put("title", this.field_title);
    }
    if (this.dGb) {
      localContentValues.put("loan_jump_url", this.field_loan_jump_url);
    }
    if (this.dGc) {
      localContentValues.put("red_dot_index", Integer.valueOf(this.field_red_dot_index));
    }
    if (this.dGd) {
      localContentValues.put("is_show_entry", Integer.valueOf(this.field_is_show_entry));
    }
    if (this.dGe) {
      localContentValues.put("tips", this.field_tips);
    }
    if (this.dGf) {
      localContentValues.put("is_overdue", Integer.valueOf(this.field_is_overdue));
    }
    if (this.dGg) {
      localContentValues.put("available_otb", this.field_available_otb);
    }
    if (this.systemRowid > 0L) {
      localContentValues.put("rowid", Long.valueOf(this.systemRowid));
    }
    return localContentValues;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.g.c.cz
 * JD-Core Version:    0.7.0.1
 */