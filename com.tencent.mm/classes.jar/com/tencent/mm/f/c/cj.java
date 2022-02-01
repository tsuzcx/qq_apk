package com.tencent.mm.f.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.storage.IAutoDBItem;
import com.tencent.mm.sdk.storage.IAutoDBItem.MAutoDBInfo;
import com.tencent.mm.sdk.storage.sql.Column;
import com.tencent.mm.sdk.storage.sql.SingleTable;
import java.lang.reflect.Field;
import java.util.Map;

public abstract class cj
  extends IAutoDBItem
{
  public static final Column C_ROWID;
  public static final String[] INDEX_CREATE = new String[0];
  public static final SingleTable TABLE = new SingleTable("FinderLiveActionRecord");
  private static final int hPI = "actionTime".hashCode();
  public static final Column hPo;
  public static final Column hSa;
  private static final int hSc;
  private static final int rowid_HASHCODE = "rowid".hashCode();
  public String field_actionTag;
  public long field_actionTime;
  private boolean hPy = true;
  private boolean hSb = true;
  
  static
  {
    C_ROWID = new Column("rowid", "long", "FinderLiveActionRecord", "");
    hSa = new Column("actiontag", "string", "FinderLiveActionRecord", "");
    hPo = new Column("actiontime", "long", "FinderLiveActionRecord", "");
    hSc = "actionTag".hashCode();
  }
  
  public static IAutoDBItem.MAutoDBInfo aoY()
  {
    IAutoDBItem.MAutoDBInfo localMAutoDBInfo = new IAutoDBItem.MAutoDBInfo();
    localMAutoDBInfo.fields = new Field[2];
    localMAutoDBInfo.columns = new String[3];
    StringBuilder localStringBuilder = new StringBuilder();
    localMAutoDBInfo.columns[0] = "actionTag";
    localMAutoDBInfo.colsMap.put("actionTag", "TEXT PRIMARY KEY ");
    localStringBuilder.append(" actionTag TEXT PRIMARY KEY ");
    localStringBuilder.append(", ");
    localMAutoDBInfo.primaryKey = "actionTag";
    localMAutoDBInfo.columns[1] = "actionTime";
    localMAutoDBInfo.colsMap.put("actionTime", "LONG");
    localStringBuilder.append(" actionTime LONG");
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
      if (hSc != k) {
        break label65;
      }
      this.field_actionTag = paramCursor.getString(i);
      this.hSb = true;
    }
    for (;;)
    {
      i += 1;
      break label20;
      break;
      label65:
      if (hPI == k) {
        this.field_actionTime = paramCursor.getLong(i);
      } else if (rowid_HASHCODE == k) {
        this.systemRowid = paramCursor.getLong(i);
      }
    }
  }
  
  public ContentValues convertTo()
  {
    ContentValues localContentValues = new ContentValues();
    if (this.hSb) {
      localContentValues.put("actionTag", this.field_actionTag);
    }
    if (this.hPy) {
      localContentValues.put("actionTime", Long.valueOf(this.field_actionTime));
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
    return "FinderLiveActionRecord";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.f.c.cj
 * JD-Core Version:    0.7.0.1
 */