package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;
import com.tencent.mm.sdk.e.c.a;
import java.lang.reflect.Field;
import java.util.Map;

public abstract class g
  extends c
{
  public static final String[] INDEX_CREATE = new String[0];
  private static final int dgK = "userName".hashCode();
  private static final int dhi = "scene".hashCode();
  private static final int dhj = "ticket".hashCode();
  private static final int rowid_HASHCODE = "rowid".hashCode();
  private boolean dgn = true;
  private boolean dhg = true;
  private boolean dhh = true;
  public int field_scene;
  public String field_ticket;
  public String field_userName;
  
  public static c.a Hm()
  {
    c.a locala = new c.a();
    locala.yrK = new Field[3];
    locala.columns = new String[4];
    StringBuilder localStringBuilder = new StringBuilder();
    locala.columns[0] = "userName";
    locala.yrM.put("userName", "TEXT");
    localStringBuilder.append(" userName TEXT");
    localStringBuilder.append(", ");
    locala.columns[1] = "scene";
    locala.yrM.put("scene", "INTEGER");
    localStringBuilder.append(" scene INTEGER");
    localStringBuilder.append(", ");
    locala.columns[2] = "ticket";
    locala.yrM.put("ticket", "TEXT");
    localStringBuilder.append(" ticket TEXT");
    locala.columns[3] = "rowid";
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
      if (dgK != k) {
        break label60;
      }
      this.field_userName = paramCursor.getString(i);
    }
    for (;;)
    {
      i += 1;
      break label20;
      break;
      label60:
      if (dhi == k) {
        this.field_scene = paramCursor.getInt(i);
      } else if (dhj == k) {
        this.field_ticket = paramCursor.getString(i);
      } else if (rowid_HASHCODE == k) {
        this.systemRowid = paramCursor.getLong(i);
      }
    }
  }
  
  public ContentValues convertTo()
  {
    ContentValues localContentValues = new ContentValues();
    if (this.dgn) {
      localContentValues.put("userName", this.field_userName);
    }
    if (this.dhg) {
      localContentValues.put("scene", Integer.valueOf(this.field_scene));
    }
    if (this.dhh) {
      localContentValues.put("ticket", this.field_ticket);
    }
    if (this.systemRowid > 0L) {
      localContentValues.put("rowid", Long.valueOf(this.systemRowid));
    }
    return localContentValues;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.g.c.g
 * JD-Core Version:    0.7.0.1
 */