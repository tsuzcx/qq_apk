package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;

public abstract class dr
  extends c
{
  public static final String[] INDEX_CREATE = new String[0];
  private static final int eQN = "loan_jump_url".hashCode();
  private static final int eQO = "red_dot_index".hashCode();
  private static final int eQP = "is_show_entry".hashCode();
  private static final int eQQ = "tips".hashCode();
  private static final int eQR = "is_overdue".hashCode();
  private static final int eQS = "available_otb".hashCode();
  private static final int eqK = "title".hashCode();
  private static final int rowid_HASHCODE = "rowid".hashCode();
  private boolean eQH = true;
  private boolean eQI = true;
  private boolean eQJ = true;
  private boolean eQK = true;
  private boolean eQL = true;
  private boolean eQM = true;
  private boolean eqH = true;
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
      if (eqK != k) {
        break label65;
      }
      this.field_title = paramCursor.getString(i);
      this.eqH = true;
    }
    for (;;)
    {
      i += 1;
      break label20;
      break;
      label65:
      if (eQN == k) {
        this.field_loan_jump_url = paramCursor.getString(i);
      } else if (eQO == k) {
        this.field_red_dot_index = paramCursor.getInt(i);
      } else if (eQP == k) {
        this.field_is_show_entry = paramCursor.getInt(i);
      } else if (eQQ == k) {
        this.field_tips = paramCursor.getString(i);
      } else if (eQR == k) {
        this.field_is_overdue = paramCursor.getInt(i);
      } else if (eQS == k) {
        this.field_available_otb = paramCursor.getString(i);
      } else if (rowid_HASHCODE == k) {
        this.systemRowid = paramCursor.getLong(i);
      }
    }
  }
  
  public ContentValues convertTo()
  {
    ContentValues localContentValues = new ContentValues();
    if (this.eqH) {
      localContentValues.put("title", this.field_title);
    }
    if (this.eQH) {
      localContentValues.put("loan_jump_url", this.field_loan_jump_url);
    }
    if (this.eQI) {
      localContentValues.put("red_dot_index", Integer.valueOf(this.field_red_dot_index));
    }
    if (this.eQJ) {
      localContentValues.put("is_show_entry", Integer.valueOf(this.field_is_show_entry));
    }
    if (this.eQK) {
      localContentValues.put("tips", this.field_tips);
    }
    if (this.eQL) {
      localContentValues.put("is_overdue", Integer.valueOf(this.field_is_overdue));
    }
    if (this.eQM) {
      localContentValues.put("available_otb", this.field_available_otb);
    }
    if (this.systemRowid > 0L) {
      localContentValues.put("rowid", Long.valueOf(this.systemRowid));
    }
    return localContentValues;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.g.c.dr
 * JD-Core Version:    0.7.0.1
 */