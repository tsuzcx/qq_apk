package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;

public abstract class eb
  extends c
{
  public static final String[] INDEX_CREATE = new String[0];
  private static final int eHT = "title".hashCode();
  private static final int fjk = "loan_jump_url".hashCode();
  private static final int fjl = "red_dot_index".hashCode();
  private static final int fjm = "is_show_entry".hashCode();
  private static final int fjn = "tips".hashCode();
  private static final int fjo = "is_overdue".hashCode();
  private static final int fjp = "available_otb".hashCode();
  private static final int rowid_HASHCODE = "rowid".hashCode();
  private boolean eHQ = true;
  public String field_available_otb;
  public int field_is_overdue;
  public int field_is_show_entry;
  public String field_loan_jump_url;
  public int field_red_dot_index;
  public String field_tips;
  public String field_title;
  private boolean fje = true;
  private boolean fjf = true;
  private boolean fjg = true;
  private boolean fjh = true;
  private boolean fji = true;
  private boolean fjj = true;
  
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
      if (eHT != k) {
        break label65;
      }
      this.field_title = paramCursor.getString(i);
      this.eHQ = true;
    }
    for (;;)
    {
      i += 1;
      break label20;
      break;
      label65:
      if (fjk == k) {
        this.field_loan_jump_url = paramCursor.getString(i);
      } else if (fjl == k) {
        this.field_red_dot_index = paramCursor.getInt(i);
      } else if (fjm == k) {
        this.field_is_show_entry = paramCursor.getInt(i);
      } else if (fjn == k) {
        this.field_tips = paramCursor.getString(i);
      } else if (fjo == k) {
        this.field_is_overdue = paramCursor.getInt(i);
      } else if (fjp == k) {
        this.field_available_otb = paramCursor.getString(i);
      } else if (rowid_HASHCODE == k) {
        this.systemRowid = paramCursor.getLong(i);
      }
    }
  }
  
  public ContentValues convertTo()
  {
    ContentValues localContentValues = new ContentValues();
    if (this.eHQ) {
      localContentValues.put("title", this.field_title);
    }
    if (this.fje) {
      localContentValues.put("loan_jump_url", this.field_loan_jump_url);
    }
    if (this.fjf) {
      localContentValues.put("red_dot_index", Integer.valueOf(this.field_red_dot_index));
    }
    if (this.fjg) {
      localContentValues.put("is_show_entry", Integer.valueOf(this.field_is_show_entry));
    }
    if (this.fjh) {
      localContentValues.put("tips", this.field_tips);
    }
    if (this.fji) {
      localContentValues.put("is_overdue", Integer.valueOf(this.field_is_overdue));
    }
    if (this.fjj) {
      localContentValues.put("available_otb", this.field_available_otb);
    }
    if (this.systemRowid > 0L) {
      localContentValues.put("rowid", Long.valueOf(this.systemRowid));
    }
    return localContentValues;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.g.c.eb
 * JD-Core Version:    0.7.0.1
 */