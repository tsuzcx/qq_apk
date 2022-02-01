package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;

public abstract class do
  extends c
{
  public static final String[] INDEX_CREATE = new String[0];
  private static final int eNJ = "loan_jump_url".hashCode();
  private static final int eNK = "red_dot_index".hashCode();
  private static final int eNL = "is_show_entry".hashCode();
  private static final int eNM = "tips".hashCode();
  private static final int eNN = "is_overdue".hashCode();
  private static final int eNO = "available_otb".hashCode();
  private static final int eoG = "title".hashCode();
  private static final int rowid_HASHCODE = "rowid".hashCode();
  private boolean eND = true;
  private boolean eNE = true;
  private boolean eNF = true;
  private boolean eNG = true;
  private boolean eNH = true;
  private boolean eNI = true;
  private boolean eoD = true;
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
      if (eoG != k) {
        break label65;
      }
      this.field_title = paramCursor.getString(i);
      this.eoD = true;
    }
    for (;;)
    {
      i += 1;
      break label20;
      break;
      label65:
      if (eNJ == k) {
        this.field_loan_jump_url = paramCursor.getString(i);
      } else if (eNK == k) {
        this.field_red_dot_index = paramCursor.getInt(i);
      } else if (eNL == k) {
        this.field_is_show_entry = paramCursor.getInt(i);
      } else if (eNM == k) {
        this.field_tips = paramCursor.getString(i);
      } else if (eNN == k) {
        this.field_is_overdue = paramCursor.getInt(i);
      } else if (eNO == k) {
        this.field_available_otb = paramCursor.getString(i);
      } else if (rowid_HASHCODE == k) {
        this.systemRowid = paramCursor.getLong(i);
      }
    }
  }
  
  public ContentValues convertTo()
  {
    ContentValues localContentValues = new ContentValues();
    if (this.eoD) {
      localContentValues.put("title", this.field_title);
    }
    if (this.eND) {
      localContentValues.put("loan_jump_url", this.field_loan_jump_url);
    }
    if (this.eNE) {
      localContentValues.put("red_dot_index", Integer.valueOf(this.field_red_dot_index));
    }
    if (this.eNF) {
      localContentValues.put("is_show_entry", Integer.valueOf(this.field_is_show_entry));
    }
    if (this.eNG) {
      localContentValues.put("tips", this.field_tips);
    }
    if (this.eNH) {
      localContentValues.put("is_overdue", Integer.valueOf(this.field_is_overdue));
    }
    if (this.eNI) {
      localContentValues.put("available_otb", this.field_available_otb);
    }
    if (this.systemRowid > 0L) {
      localContentValues.put("rowid", Long.valueOf(this.systemRowid));
    }
    return localContentValues;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.g.c.do
 * JD-Core Version:    0.7.0.1
 */