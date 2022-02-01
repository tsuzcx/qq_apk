package com.tencent.mm.f.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.storage.IAutoDBItem;
import com.tencent.mm.sdk.storage.sql.Column;
import com.tencent.mm.sdk.storage.sql.SingleTable;

public abstract class em
  extends IAutoDBItem
{
  public static final Column C_ROWID;
  public static final String[] INDEX_CREATE = new String[0];
  public static final SingleTable TABLE = new SingleTable("LoanEntryInfo");
  public static final Column hsa;
  private static final int hsg = "title".hashCode();
  public static final Column ijc;
  public static final Column ijd;
  public static final Column ije;
  public static final Column ijf;
  public static final Column ijg;
  public static final Column ijh;
  private static final int ijo = "loan_jump_url".hashCode();
  private static final int ijp = "red_dot_index".hashCode();
  private static final int ijq = "is_show_entry".hashCode();
  private static final int ijr = "tips".hashCode();
  private static final int ijs = "is_overdue".hashCode();
  private static final int ijt = "available_otb".hashCode();
  private static final int rowid_HASHCODE = "rowid".hashCode();
  public String field_available_otb;
  public int field_is_overdue;
  public int field_is_show_entry;
  public String field_loan_jump_url;
  public int field_red_dot_index;
  public String field_tips;
  public String field_title;
  private boolean hsd = true;
  private boolean iji = true;
  private boolean ijj = true;
  private boolean ijk = true;
  private boolean ijl = true;
  private boolean ijm = true;
  private boolean ijn = true;
  
  static
  {
    C_ROWID = new Column("rowid", "long", "LoanEntryInfo", "");
    hsa = new Column("title", "string", "LoanEntryInfo", "");
    ijc = new Column("loan_jump_url", "string", "LoanEntryInfo", "");
    ijd = new Column("red_dot_index", "int", "LoanEntryInfo", "");
    ije = new Column("is_show_entry", "int", "LoanEntryInfo", "");
    ijf = new Column("tips", "string", "LoanEntryInfo", "");
    ijg = new Column("is_overdue", "int", "LoanEntryInfo", "");
    ijh = new Column("available_otb", "string", "LoanEntryInfo", "");
  }
  
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
      if (hsg != k) {
        break label65;
      }
      this.field_title = paramCursor.getString(i);
      this.hsd = true;
    }
    for (;;)
    {
      i += 1;
      break label20;
      break;
      label65:
      if (ijo == k) {
        this.field_loan_jump_url = paramCursor.getString(i);
      } else if (ijp == k) {
        this.field_red_dot_index = paramCursor.getInt(i);
      } else if (ijq == k) {
        this.field_is_show_entry = paramCursor.getInt(i);
      } else if (ijr == k) {
        this.field_tips = paramCursor.getString(i);
      } else if (ijs == k) {
        this.field_is_overdue = paramCursor.getInt(i);
      } else if (ijt == k) {
        this.field_available_otb = paramCursor.getString(i);
      } else if (rowid_HASHCODE == k) {
        this.systemRowid = paramCursor.getLong(i);
      }
    }
  }
  
  public ContentValues convertTo()
  {
    ContentValues localContentValues = new ContentValues();
    if (this.hsd) {
      localContentValues.put("title", this.field_title);
    }
    if (this.iji) {
      localContentValues.put("loan_jump_url", this.field_loan_jump_url);
    }
    if (this.ijj) {
      localContentValues.put("red_dot_index", Integer.valueOf(this.field_red_dot_index));
    }
    if (this.ijk) {
      localContentValues.put("is_show_entry", Integer.valueOf(this.field_is_show_entry));
    }
    if (this.ijl) {
      localContentValues.put("tips", this.field_tips);
    }
    if (this.ijm) {
      localContentValues.put("is_overdue", Integer.valueOf(this.field_is_overdue));
    }
    if (this.ijn) {
      localContentValues.put("available_otb", this.field_available_otb);
    }
    if (this.systemRowid > 0L) {
      localContentValues.put("rowid", Long.valueOf(this.systemRowid));
    }
    return localContentValues;
  }
  
  public String[] getIndexCreateSQL()
  {
    return INDEX_CREATE;
  }
  
  public String getTableName()
  {
    return "LoanEntryInfo";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.f.c.em
 * JD-Core Version:    0.7.0.1
 */