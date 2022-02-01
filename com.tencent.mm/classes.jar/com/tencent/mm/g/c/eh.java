package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.storage.IAutoDBItem;

public abstract class eh
  extends IAutoDBItem
{
  public static final String[] INDEX_CREATE = new String[0];
  private static final int fPL = "loan_jump_url".hashCode();
  private static final int fPM = "red_dot_index".hashCode();
  private static final int fPN = "is_show_entry".hashCode();
  private static final int fPO = "tips".hashCode();
  private static final int fPP = "is_overdue".hashCode();
  private static final int fPQ = "available_otb".hashCode();
  private static final int fne = "title".hashCode();
  private static final int rowid_HASHCODE = "rowid".hashCode();
  private boolean fPF = true;
  private boolean fPG = true;
  private boolean fPH = true;
  private boolean fPI = true;
  private boolean fPJ = true;
  private boolean fPK = true;
  public String field_available_otb;
  public int field_is_overdue;
  public int field_is_show_entry;
  public String field_loan_jump_url;
  public int field_red_dot_index;
  public String field_tips;
  public String field_title;
  private boolean fnb = true;
  
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
      if (fne != k) {
        break label65;
      }
      this.field_title = paramCursor.getString(i);
      this.fnb = true;
    }
    for (;;)
    {
      i += 1;
      break label20;
      break;
      label65:
      if (fPL == k) {
        this.field_loan_jump_url = paramCursor.getString(i);
      } else if (fPM == k) {
        this.field_red_dot_index = paramCursor.getInt(i);
      } else if (fPN == k) {
        this.field_is_show_entry = paramCursor.getInt(i);
      } else if (fPO == k) {
        this.field_tips = paramCursor.getString(i);
      } else if (fPP == k) {
        this.field_is_overdue = paramCursor.getInt(i);
      } else if (fPQ == k) {
        this.field_available_otb = paramCursor.getString(i);
      } else if (rowid_HASHCODE == k) {
        this.systemRowid = paramCursor.getLong(i);
      }
    }
  }
  
  public ContentValues convertTo()
  {
    ContentValues localContentValues = new ContentValues();
    if (this.fnb) {
      localContentValues.put("title", this.field_title);
    }
    if (this.fPF) {
      localContentValues.put("loan_jump_url", this.field_loan_jump_url);
    }
    if (this.fPG) {
      localContentValues.put("red_dot_index", Integer.valueOf(this.field_red_dot_index));
    }
    if (this.fPH) {
      localContentValues.put("is_show_entry", Integer.valueOf(this.field_is_show_entry));
    }
    if (this.fPI) {
      localContentValues.put("tips", this.field_tips);
    }
    if (this.fPJ) {
      localContentValues.put("is_overdue", Integer.valueOf(this.field_is_overdue));
    }
    if (this.fPK) {
      localContentValues.put("available_otb", this.field_available_otb);
    }
    if (this.systemRowid > 0L) {
      localContentValues.put("rowid", Long.valueOf(this.systemRowid));
    }
    return localContentValues;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.g.c.eh
 * JD-Core Version:    0.7.0.1
 */