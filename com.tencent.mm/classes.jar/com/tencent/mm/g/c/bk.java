package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;
import com.tencent.mm.sdk.e.c.a;
import java.lang.reflect.Field;
import java.util.Map;

public abstract class bk
  extends c
{
  public static final String[] INDEX_CREATE = new String[0];
  private static final int eEm = "content".hashCode();
  private static final int eFq;
  private static final int eTG = "desc".hashCode();
  private static final int rowid_HASHCODE = "rowid".hashCode();
  private boolean eDP = true;
  private boolean eFn = true;
  private boolean eTC = true;
  public byte[] field_content;
  public String field_desc;
  public int field_updateTime;
  
  static
  {
    eFq = "updateTime".hashCode();
  }
  
  public static c.a Vv()
  {
    c.a locala = new c.a();
    locala.IhA = new Field[3];
    locala.columns = new String[4];
    StringBuilder localStringBuilder = new StringBuilder();
    locala.columns[0] = "desc";
    locala.IhC.put("desc", "TEXT PRIMARY KEY ");
    localStringBuilder.append(" desc TEXT PRIMARY KEY ");
    localStringBuilder.append(", ");
    locala.IhB = "desc";
    locala.columns[1] = "updateTime";
    locala.IhC.put("updateTime", "INTEGER");
    localStringBuilder.append(" updateTime INTEGER");
    localStringBuilder.append(", ");
    locala.columns[2] = "content";
    locala.IhC.put("content", "BLOB");
    localStringBuilder.append(" content BLOB");
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
      if (eTG != k) {
        break label65;
      }
      this.field_desc = paramCursor.getString(i);
      this.eTC = true;
    }
    for (;;)
    {
      i += 1;
      break label20;
      break;
      label65:
      if (eFq == k) {
        this.field_updateTime = paramCursor.getInt(i);
      } else if (eEm == k) {
        this.field_content = paramCursor.getBlob(i);
      } else if (rowid_HASHCODE == k) {
        this.systemRowid = paramCursor.getLong(i);
      }
    }
  }
  
  public ContentValues convertTo()
  {
    ContentValues localContentValues = new ContentValues();
    if (this.eTC) {
      localContentValues.put("desc", this.field_desc);
    }
    if (this.eFn) {
      localContentValues.put("updateTime", Integer.valueOf(this.field_updateTime));
    }
    if (this.eDP) {
      localContentValues.put("content", this.field_content);
    }
    if (this.systemRowid > 0L) {
      localContentValues.put("rowid", Long.valueOf(this.systemRowid));
    }
    return localContentValues;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.g.c.bk
 * JD-Core Version:    0.7.0.1
 */