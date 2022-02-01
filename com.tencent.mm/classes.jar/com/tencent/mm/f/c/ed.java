package com.tencent.mm.f.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.storage.IAutoDBItem;
import com.tencent.mm.sdk.storage.IAutoDBItem.MAutoDBInfo;
import com.tencent.mm.sdk.storage.sql.Column;
import com.tencent.mm.sdk.storage.sql.SingleTable;
import java.lang.reflect.Field;
import java.util.Map;

public abstract class ed
  extends IAutoDBItem
{
  public static final String COL_EXPIRE_AT = "expire_at";
  public static final String COL_KEY = "key";
  public static final String COL_VALUE = "value";
  public static final Column C_EXPIRE_AT;
  public static final Column C_KEY;
  public static final Column C_ROWID;
  public static final Column C_VALUE;
  public static final String[] INDEX_CREATE = new String[0];
  public static final SingleTable TABLE = new SingleTable("KindaCacheTable");
  public static final String TABLE_NAME = "KindaCacheTable";
  private static final String TAG = "MicroMsg.SDK.BaseKindaCacheTable";
  private static final int expire_at_HASHCODE = "expire_at".hashCode();
  private static final int key_HASHCODE;
  private static final int rowid_HASHCODE = "rowid".hashCode();
  private static final int value_HASHCODE;
  private boolean __hadSetexpire_at = true;
  private boolean __hadSetkey = true;
  private boolean __hadSetvalue = true;
  public long field_expire_at;
  public String field_key;
  public byte[] field_value;
  
  static
  {
    C_ROWID = new Column("rowid", "long", "KindaCacheTable", "");
    C_KEY = new Column("key", "string", "KindaCacheTable", "");
    C_VALUE = new Column("value", "byte[]", "KindaCacheTable", "");
    C_EXPIRE_AT = new Column("expire_at", "long", "KindaCacheTable", "");
    key_HASHCODE = "key".hashCode();
    value_HASHCODE = "value".hashCode();
  }
  
  private final void buildBuff() {}
  
  public static IAutoDBItem.MAutoDBInfo initAutoDBInfo(Class<?> paramClass)
  {
    paramClass = new IAutoDBItem.MAutoDBInfo();
    paramClass.fields = new Field[3];
    paramClass.columns = new String[4];
    StringBuilder localStringBuilder = new StringBuilder();
    paramClass.columns[0] = "key";
    paramClass.colsMap.put("key", "TEXT PRIMARY KEY ");
    localStringBuilder.append(" key TEXT PRIMARY KEY ");
    localStringBuilder.append(", ");
    paramClass.primaryKey = "key";
    paramClass.columns[1] = "value";
    paramClass.colsMap.put("value", "BLOB");
    localStringBuilder.append(" value BLOB");
    localStringBuilder.append(", ");
    paramClass.columns[2] = "expire_at";
    paramClass.colsMap.put("expire_at", "LONG");
    localStringBuilder.append(" expire_at LONG");
    paramClass.columns[3] = "rowid";
    paramClass.sql = localStringBuilder.toString();
    return paramClass;
  }
  
  private final void parseBuff() {}
  
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
      if (key_HASHCODE != k) {
        break label65;
      }
      this.field_key = paramCursor.getString(i);
      this.__hadSetkey = true;
    }
    for (;;)
    {
      i += 1;
      break label20;
      break;
      label65:
      if (value_HASHCODE == k) {
        this.field_value = paramCursor.getBlob(i);
      } else if (expire_at_HASHCODE == k) {
        this.field_expire_at = paramCursor.getLong(i);
      } else if (rowid_HASHCODE == k) {
        this.systemRowid = paramCursor.getLong(i);
      }
    }
  }
  
  public ContentValues convertTo()
  {
    buildBuff();
    ContentValues localContentValues = new ContentValues();
    if (this.__hadSetkey) {
      localContentValues.put("key", this.field_key);
    }
    if (this.__hadSetvalue) {
      localContentValues.put("value", this.field_value);
    }
    if (this.__hadSetexpire_at) {
      localContentValues.put("expire_at", Long.valueOf(this.field_expire_at));
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
    return "KindaCacheTable";
  }
  
  public void reset() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.f.c.ed
 * JD-Core Version:    0.7.0.1
 */