package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;
import com.tencent.mm.sdk.e.c.a;
import java.lang.reflect.Field;
import java.util.Map;

public abstract class dw
  extends c
{
  public static final String[] INDEX_CREATE = new String[0];
  private static final int eAE = "count".hashCode();
  private static final int eRE = "date".hashCode();
  private static final int rowid_HASHCODE = "rowid".hashCode();
  private boolean eAe = true;
  private boolean eRD = true;
  public int field_count;
  public String field_date;
  
  public static c.a Th()
  {
    c.a locala = new c.a();
    locala.GvF = new Field[2];
    locala.columns = new String[3];
    StringBuilder localStringBuilder = new StringBuilder();
    locala.columns[0] = "date";
    locala.GvH.put("date", "TEXT");
    localStringBuilder.append(" date TEXT");
    localStringBuilder.append(", ");
    locala.columns[1] = "count";
    locala.GvH.put("count", "INTEGER");
    localStringBuilder.append(" count INTEGER");
    locala.columns[2] = "rowid";
    locala.sql = localStringBuilder.toString();
    return locala;
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
      if (eRE != k) {
        break label60;
      }
      this.field_date = paramCursor.getString(i);
    }
    for (;;)
    {
      i += 1;
      break label20;
      break;
      label60:
      if (eAE == k) {
        this.field_count = paramCursor.getInt(i);
      } else if (rowid_HASHCODE == k) {
        this.systemRowid = paramCursor.getLong(i);
      }
    }
  }
  
  public ContentValues convertTo()
  {
    ContentValues localContentValues = new ContentValues();
    if (this.eRD) {
      localContentValues.put("date", this.field_date);
    }
    if (this.eAe) {
      localContentValues.put("count", Integer.valueOf(this.field_count));
    }
    if (this.systemRowid > 0L) {
      localContentValues.put("rowid", Long.valueOf(this.systemRowid));
    }
    return localContentValues;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.g.c.dw
 * JD-Core Version:    0.7.0.1
 */