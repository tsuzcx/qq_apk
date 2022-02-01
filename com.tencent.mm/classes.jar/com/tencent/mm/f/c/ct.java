package com.tencent.mm.f.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.storage.IAutoDBItem;
import com.tencent.mm.sdk.storage.sql.Column;
import com.tencent.mm.sdk.storage.sql.SingleTable;

public abstract class ct
  extends IAutoDBItem
{
  public static final Column C_ROWID = new Column("rowid", "long", "FinderRedDotHistory", "");
  public static final String[] INDEX_CREATE = new String[0];
  public static final SingleTable TABLE = new SingleTable("FinderRedDotHistory");
  public static final Column hUX = new Column("ds", "int", "FinderRedDotHistory", "");
  public static final Column hUY = new Column("hour", "int", "FinderRedDotHistory", "");
  public static final Column hUZ = new Column("actionms", "long", "FinderRedDotHistory", "");
  public static final Column hVa = new Column("isgotofinderui", "int", "FinderRedDotHistory", "");
  private static final int hVf = "ds".hashCode();
  private static final int hVg = "hour".hashCode();
  private static final int hVh = "actionMs".hashCode();
  private static final int hVi = "isGoToFinderUI".hashCode();
  private static final int rowid_HASHCODE = "rowid".hashCode();
  public long field_actionMs;
  public int field_ds;
  public int field_hour;
  public int field_isGoToFinderUI;
  private boolean hVb = true;
  private boolean hVc = true;
  private boolean hVd = true;
  private boolean hVe = true;
  
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
      if (hVf != k) {
        break label60;
      }
      this.field_ds = paramCursor.getInt(i);
    }
    for (;;)
    {
      i += 1;
      break label20;
      break;
      label60:
      if (hVg == k) {
        this.field_hour = paramCursor.getInt(i);
      } else if (hVh == k) {
        this.field_actionMs = paramCursor.getLong(i);
      } else if (hVi == k) {
        this.field_isGoToFinderUI = paramCursor.getInt(i);
      } else if (rowid_HASHCODE == k) {
        this.systemRowid = paramCursor.getLong(i);
      }
    }
  }
  
  public ContentValues convertTo()
  {
    ContentValues localContentValues = new ContentValues();
    if (this.hVb) {
      localContentValues.put("ds", Integer.valueOf(this.field_ds));
    }
    if (this.hVc) {
      localContentValues.put("hour", Integer.valueOf(this.field_hour));
    }
    if (this.hVd) {
      localContentValues.put("actionMs", Long.valueOf(this.field_actionMs));
    }
    if (this.hVe) {
      localContentValues.put("isGoToFinderUI", Integer.valueOf(this.field_isGoToFinderUI));
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
    return "FinderRedDotHistory";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.f.c.ct
 * JD-Core Version:    0.7.0.1
 */