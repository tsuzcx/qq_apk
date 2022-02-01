package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;
import com.tencent.mm.sdk.e.c.a;
import java.lang.reflect.Field;
import java.util.Map;

public abstract class gt
  extends c
{
  public static final String[] INDEX_CREATE = new String[0];
  private static final int esJ = "time".hashCode();
  private static final int ffP = "weSeeUri".hashCode();
  private static final int rowid_HASHCODE = "rowid".hashCode();
  private boolean esq = true;
  private boolean ffO = true;
  public long field_time;
  public String field_weSeeUri;
  
  public static c.a So()
  {
    c.a locala = new c.a();
    locala.EYt = new Field[2];
    locala.columns = new String[3];
    StringBuilder localStringBuilder = new StringBuilder();
    locala.columns[0] = "weSeeUri";
    locala.EYv.put("weSeeUri", "TEXT");
    localStringBuilder.append(" weSeeUri TEXT");
    localStringBuilder.append(", ");
    locala.columns[1] = "time";
    locala.EYv.put("time", "LONG");
    localStringBuilder.append(" time LONG");
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
      if (ffP != k) {
        break label60;
      }
      this.field_weSeeUri = paramCursor.getString(i);
    }
    for (;;)
    {
      i += 1;
      break label20;
      break;
      label60:
      if (esJ == k) {
        this.field_time = paramCursor.getLong(i);
      } else if (rowid_HASHCODE == k) {
        this.systemRowid = paramCursor.getLong(i);
      }
    }
  }
  
  public ContentValues convertTo()
  {
    ContentValues localContentValues = new ContentValues();
    if (this.ffO) {
      localContentValues.put("weSeeUri", this.field_weSeeUri);
    }
    if (this.esq) {
      localContentValues.put("time", Long.valueOf(this.field_time));
    }
    if (this.systemRowid > 0L) {
      localContentValues.put("rowid", Long.valueOf(this.systemRowid));
    }
    return localContentValues;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.g.c.gt
 * JD-Core Version:    0.7.0.1
 */