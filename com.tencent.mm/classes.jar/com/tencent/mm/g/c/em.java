package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.storage.IAutoDBItem;
import com.tencent.mm.sdk.storage.IAutoDBItem.MAutoDBInfo;
import java.lang.reflect.Field;
import java.util.Map;

public abstract class em
  extends IAutoDBItem
{
  public static final String[] INDEX_CREATE = new String[0];
  private static final int fQC = "date".hashCode();
  private static final int fxs = "count".hashCode();
  private static final int rowid_HASHCODE = "rowid".hashCode();
  private boolean fQB = true;
  public int field_count;
  public String field_date;
  private boolean fwS = true;
  
  public static IAutoDBItem.MAutoDBInfo ajs()
  {
    IAutoDBItem.MAutoDBInfo localMAutoDBInfo = new IAutoDBItem.MAutoDBInfo();
    localMAutoDBInfo.fields = new Field[2];
    localMAutoDBInfo.columns = new String[3];
    StringBuilder localStringBuilder = new StringBuilder();
    localMAutoDBInfo.columns[0] = "date";
    localMAutoDBInfo.colsMap.put("date", "TEXT");
    localStringBuilder.append(" date TEXT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[1] = "count";
    localMAutoDBInfo.colsMap.put("count", "INTEGER");
    localStringBuilder.append(" count INTEGER");
    localMAutoDBInfo.columns[2] = "rowid";
    localMAutoDBInfo.sql = localStringBuilder.toString();
    return localMAutoDBInfo;
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
      if (fQC != k) {
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
      if (fxs == k) {
        this.field_count = paramCursor.getInt(i);
      } else if (rowid_HASHCODE == k) {
        this.systemRowid = paramCursor.getLong(i);
      }
    }
  }
  
  public ContentValues convertTo()
  {
    ContentValues localContentValues = new ContentValues();
    if (this.fQB) {
      localContentValues.put("date", this.field_date);
    }
    if (this.fwS) {
      localContentValues.put("count", Integer.valueOf(this.field_count));
    }
    if (this.systemRowid > 0L) {
      localContentValues.put("rowid", Long.valueOf(this.systemRowid));
    }
    return localContentValues;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.g.c.em
 * JD-Core Version:    0.7.0.1
 */