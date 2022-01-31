package com.tencent.mm.h.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;
import com.tencent.mm.sdk.e.c.a;
import java.lang.reflect.Field;
import java.util.Map;

public abstract class bl
  extends c
{
  private static final int cHG;
  public static final String[] cqY = new String[0];
  private static final int crh = "rowid".hashCode();
  private static final int crx;
  private boolean cHF = true;
  private boolean crp = true;
  public int field_configId;
  public String field_value;
  
  static
  {
    cHG = "configId".hashCode();
    crx = "value".hashCode();
  }
  
  public static c.a vg()
  {
    c.a locala = new c.a();
    locala.ujL = new Field[2];
    locala.columns = new String[3];
    StringBuilder localStringBuilder = new StringBuilder();
    locala.columns[0] = "configId";
    locala.ujN.put("configId", "INTEGER PRIMARY KEY ");
    localStringBuilder.append(" configId INTEGER PRIMARY KEY ");
    localStringBuilder.append(", ");
    locala.ujM = "configId";
    locala.columns[1] = "value";
    locala.ujN.put("value", "TEXT");
    localStringBuilder.append(" value TEXT");
    locala.columns[2] = "rowid";
    locala.sql = localStringBuilder.toString();
    return locala;
  }
  
  public final void d(Cursor paramCursor)
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
      if (cHG != k) {
        break label65;
      }
      this.field_configId = paramCursor.getInt(i);
      this.cHF = true;
    }
    for (;;)
    {
      i += 1;
      break label20;
      break;
      label65:
      if (crx == k) {
        this.field_value = paramCursor.getString(i);
      } else if (crh == k) {
        this.ujK = paramCursor.getLong(i);
      }
    }
  }
  
  public final ContentValues vf()
  {
    ContentValues localContentValues = new ContentValues();
    if (this.cHF) {
      localContentValues.put("configId", Integer.valueOf(this.field_configId));
    }
    if (this.crp) {
      localContentValues.put("value", this.field_value);
    }
    if (this.ujK > 0L) {
      localContentValues.put("rowid", Long.valueOf(this.ujK));
    }
    return localContentValues;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.h.c.bl
 * JD-Core Version:    0.7.0.1
 */