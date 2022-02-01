package com.tencent.mm.f.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.storage.IAutoDBItem;
import com.tencent.mm.sdk.storage.sql.Column;
import com.tencent.mm.sdk.storage.sql.SingleTable;

public abstract class bs
  extends IAutoDBItem
{
  public static final Column C_ROWID;
  public static final String[] INDEX_CREATE = new String[0];
  public static final SingleTable TABLE = new SingleTable("ExptKeyMapId");
  public static final Column hJV;
  private static final int hKf = "exptId".hashCode();
  public static final Column hKk;
  private static final int hKm;
  private static final int rowid_HASHCODE = "rowid".hashCode();
  public int field_exptId;
  public String field_exptKey;
  private boolean hKa = true;
  private boolean hKl = true;
  
  static
  {
    C_ROWID = new Column("rowid", "long", "ExptKeyMapId", "");
    hKk = new Column("exptkey", "string", "ExptKeyMapId", "");
    hJV = new Column("exptid", "int", "ExptKeyMapId", "");
    hKm = "exptKey".hashCode();
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
      if (hKm != k) {
        break label65;
      }
      this.field_exptKey = paramCursor.getString(i);
      this.hKl = true;
    }
    for (;;)
    {
      i += 1;
      break label20;
      break;
      label65:
      if (hKf == k) {
        this.field_exptId = paramCursor.getInt(i);
      } else if (rowid_HASHCODE == k) {
        this.systemRowid = paramCursor.getLong(i);
      }
    }
  }
  
  public ContentValues convertTo()
  {
    ContentValues localContentValues = new ContentValues();
    if (this.hKl) {
      localContentValues.put("exptKey", this.field_exptKey);
    }
    if (this.hKa) {
      localContentValues.put("exptId", Integer.valueOf(this.field_exptId));
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
    return "ExptKeyMapId";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.f.c.bs
 * JD-Core Version:    0.7.0.1
 */