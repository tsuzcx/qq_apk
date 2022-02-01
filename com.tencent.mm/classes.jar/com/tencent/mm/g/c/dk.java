package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;
import com.tencent.mm.sdk.e.c.a;
import java.lang.reflect.Field;
import java.util.Map;

public abstract class dk
  extends c
{
  public static final String COL_EXPIRE_AT = "expire_at";
  public static final String COL_KEY = "key";
  public static final String COL_TYPE = "type";
  public static final String COL_VALUE = "value";
  public static final String[] INDEX_CREATE = new String[0];
  public static final String TABLE_NAME = "KindaConfigCache";
  private static final String TAG = "MicroMsg.SDK.BaseKindaConfigCache";
  private static final int expire_at_HASHCODE = "expire_at".hashCode();
  private static final int key_HASHCODE = "key".hashCode();
  private static final int rowid_HASHCODE = "rowid".hashCode();
  private static final int type_HASHCODE;
  private static final int value_HASHCODE = "value".hashCode();
  private boolean __hadSetexpire_at = true;
  private boolean __hadSetkey = true;
  private boolean __hadSettype = true;
  private boolean __hadSetvalue = true;
  public long field_expire_at;
  public String field_key;
  public int field_type;
  public String field_value;
  
  static
  {
    type_HASHCODE = "type".hashCode();
  }
  
  private final void buildBuff() {}
  
  public static c.a initAutoDBInfo(Class<?> paramClass)
  {
    paramClass = new c.a();
    paramClass.GvF = new Field[4];
    paramClass.columns = new String[5];
    StringBuilder localStringBuilder = new StringBuilder();
    paramClass.columns[0] = "key";
    paramClass.GvH.put("key", "TEXT PRIMARY KEY ");
    localStringBuilder.append(" key TEXT PRIMARY KEY ");
    localStringBuilder.append(", ");
    paramClass.GvG = "key";
    paramClass.columns[1] = "value";
    paramClass.GvH.put("value", "TEXT");
    localStringBuilder.append(" value TEXT");
    localStringBuilder.append(", ");
    paramClass.columns[2] = "type";
    paramClass.GvH.put("type", "INTEGER");
    localStringBuilder.append(" type INTEGER");
    localStringBuilder.append(", ");
    paramClass.columns[3] = "expire_at";
    paramClass.GvH.put("expire_at", "LONG");
    localStringBuilder.append(" expire_at LONG");
    paramClass.columns[4] = "rowid";
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
        this.field_value = paramCursor.getString(i);
      } else if (type_HASHCODE == k) {
        this.field_type = paramCursor.getInt(i);
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
    if (this.__hadSettype) {
      localContentValues.put("type", Integer.valueOf(this.field_type));
    }
    if (this.__hadSetexpire_at) {
      localContentValues.put("expire_at", Long.valueOf(this.field_expire_at));
    }
    if (this.systemRowid > 0L) {
      localContentValues.put("rowid", Long.valueOf(this.systemRowid));
    }
    return localContentValues;
  }
  
  public void reset() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.g.c.dk
 * JD-Core Version:    0.7.0.1
 */