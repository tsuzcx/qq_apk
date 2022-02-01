package com.tencent.mm.f.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.storage.IAutoDBItem;
import com.tencent.mm.sdk.storage.IAutoDBItem.MAutoDBInfo;
import com.tencent.mm.sdk.storage.sql.Column;
import com.tencent.mm.sdk.storage.sql.SingleTable;
import java.lang.reflect.Field;
import java.util.Map;

public abstract class ek
  extends IAutoDBItem
{
  public static final Column C_ID;
  public static final Column C_ROWID;
  public static final String[] INDEX_CREATE = new String[0];
  public static final SingleTable TABLE = new SingleTable("LiveDemoDBInfo");
  public static final Column hMZ;
  private static final int hNt = "timestamp".hashCode();
  private static final int id_HASHCODE;
  public static final Column iiL;
  private static final int iiN;
  private static final int rowid_HASHCODE = "rowid".hashCode();
  private boolean __hadSetid = true;
  public String field_id;
  public String field_info;
  public long field_timestamp;
  private boolean hNj = true;
  private boolean iiM = true;
  
  static
  {
    C_ROWID = new Column("rowid", "long", "LiveDemoDBInfo", "");
    C_ID = new Column("id", "string", "LiveDemoDBInfo", "");
    iiL = new Column("info", "string", "LiveDemoDBInfo", "");
    hMZ = new Column("timestamp", "long", "LiveDemoDBInfo", "");
    id_HASHCODE = "id".hashCode();
    iiN = "info".hashCode();
  }
  
  public static IAutoDBItem.MAutoDBInfo aoY()
  {
    IAutoDBItem.MAutoDBInfo localMAutoDBInfo = new IAutoDBItem.MAutoDBInfo();
    localMAutoDBInfo.fields = new Field[3];
    localMAutoDBInfo.columns = new String[4];
    StringBuilder localStringBuilder = new StringBuilder();
    localMAutoDBInfo.columns[0] = "id";
    localMAutoDBInfo.colsMap.put("id", "TEXT PRIMARY KEY ");
    localStringBuilder.append(" id TEXT PRIMARY KEY ");
    localStringBuilder.append(", ");
    localMAutoDBInfo.primaryKey = "id";
    localMAutoDBInfo.columns[1] = "info";
    localMAutoDBInfo.colsMap.put("info", "TEXT");
    localStringBuilder.append(" info TEXT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[2] = "timestamp";
    localMAutoDBInfo.colsMap.put("timestamp", "LONG");
    localStringBuilder.append(" timestamp LONG");
    localMAutoDBInfo.columns[3] = "rowid";
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
      if (id_HASHCODE != k) {
        break label65;
      }
      this.field_id = paramCursor.getString(i);
      this.__hadSetid = true;
    }
    for (;;)
    {
      i += 1;
      break label20;
      break;
      label65:
      if (iiN == k) {
        this.field_info = paramCursor.getString(i);
      } else if (hNt == k) {
        this.field_timestamp = paramCursor.getLong(i);
      } else if (rowid_HASHCODE == k) {
        this.systemRowid = paramCursor.getLong(i);
      }
    }
  }
  
  public ContentValues convertTo()
  {
    ContentValues localContentValues = new ContentValues();
    if (this.__hadSetid) {
      localContentValues.put("id", this.field_id);
    }
    if (this.iiM) {
      localContentValues.put("info", this.field_info);
    }
    if (this.hNj) {
      localContentValues.put("timestamp", Long.valueOf(this.field_timestamp));
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
    return "LiveDemoDBInfo";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.f.c.ek
 * JD-Core Version:    0.7.0.1
 */