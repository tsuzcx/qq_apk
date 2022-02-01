package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;
import com.tencent.mm.sdk.e.c.a;
import java.lang.reflect.Field;
import java.util.Map;

public abstract class bv
  extends c
{
  public static final String[] INDEX_CREATE = new String[0];
  private static final int eVg = "configId".hashCode();
  private static final int rowid_HASHCODE = "rowid".hashCode();
  private static final int value_HASHCODE = "value".hashCode();
  private boolean __hadSetvalue = true;
  private boolean eVf = true;
  public int field_configId;
  public String field_value;
  
  public static c.a Vv()
  {
    c.a locala = new c.a();
    locala.IhA = new Field[2];
    locala.columns = new String[3];
    StringBuilder localStringBuilder = new StringBuilder();
    locala.columns[0] = "configId";
    locala.IhC.put("configId", "INTEGER PRIMARY KEY ");
    localStringBuilder.append(" configId INTEGER PRIMARY KEY ");
    localStringBuilder.append(", ");
    locala.IhB = "configId";
    locala.columns[1] = "value";
    locala.IhC.put("value", "TEXT");
    localStringBuilder.append(" value TEXT");
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
      if (eVg != k) {
        break label65;
      }
      this.field_configId = paramCursor.getInt(i);
      this.eVf = true;
    }
    for (;;)
    {
      i += 1;
      break label20;
      break;
      label65:
      if (value_HASHCODE == k) {
        this.field_value = paramCursor.getString(i);
      } else if (rowid_HASHCODE == k) {
        this.systemRowid = paramCursor.getLong(i);
      }
    }
  }
  
  public ContentValues convertTo()
  {
    ContentValues localContentValues = new ContentValues();
    if (this.eVf) {
      localContentValues.put("configId", Integer.valueOf(this.field_configId));
    }
    if (this.__hadSetvalue) {
      localContentValues.put("value", this.field_value);
    }
    if (this.systemRowid > 0L) {
      localContentValues.put("rowid", Long.valueOf(this.systemRowid));
    }
    return localContentValues;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.g.c.bv
 * JD-Core Version:    0.7.0.1
 */