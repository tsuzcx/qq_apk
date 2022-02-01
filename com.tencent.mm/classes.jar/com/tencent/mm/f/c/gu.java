package com.tencent.mm.f.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.storage.IAutoDBItem;
import com.tencent.mm.sdk.storage.sql.Column;
import com.tencent.mm.sdk.storage.sql.SingleTable;

public abstract class gu
  extends IAutoDBItem
{
  public static final Column C_ROWID;
  public static final String[] INDEX_CREATE = new String[0];
  public static final SingleTable TABLE = new SingleTable("SnsWsFoldGroup");
  public static final Column hHa;
  private static final int hIC = "state".hashCode();
  public static final Column hpd;
  private static final int hph;
  public static final Column izJ;
  public static final Column izK;
  private static final int izN;
  private static final int izO;
  private static final int rowid_HASHCODE = "rowid".hashCode();
  public long field_bottom;
  public int field_size;
  public int field_state;
  public long field_top;
  private boolean hHO = true;
  private boolean hpf = true;
  private boolean izL = true;
  private boolean izM = true;
  
  static
  {
    C_ROWID = new Column("rowid", "long", "SnsWsFoldGroup", "");
    izJ = new Column("top", "long", "SnsWsFoldGroup", "");
    izK = new Column("bottom", "long", "SnsWsFoldGroup", "");
    hpd = new Column("size", "int", "SnsWsFoldGroup", "");
    hHa = new Column("state", "int", "SnsWsFoldGroup", "");
    izN = "top".hashCode();
    izO = "bottom".hashCode();
    hph = "size".hashCode();
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
      if (izN != k) {
        break label60;
      }
      this.field_top = paramCursor.getLong(i);
    }
    for (;;)
    {
      i += 1;
      break label20;
      break;
      label60:
      if (izO == k)
      {
        this.field_bottom = paramCursor.getLong(i);
        this.izM = true;
      }
      else if (hph == k)
      {
        this.field_size = paramCursor.getInt(i);
      }
      else if (hIC == k)
      {
        this.field_state = paramCursor.getInt(i);
      }
      else if (rowid_HASHCODE == k)
      {
        this.systemRowid = paramCursor.getLong(i);
      }
    }
  }
  
  public ContentValues convertTo()
  {
    ContentValues localContentValues = new ContentValues();
    if (this.izL) {
      localContentValues.put("top", Long.valueOf(this.field_top));
    }
    if (this.izM) {
      localContentValues.put("bottom", Long.valueOf(this.field_bottom));
    }
    if (this.hpf) {
      localContentValues.put("size", Integer.valueOf(this.field_size));
    }
    if (this.hHO) {
      localContentValues.put("state", Integer.valueOf(this.field_state));
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
    return "SnsWsFoldGroup";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.f.c.gu
 * JD-Core Version:    0.7.0.1
 */