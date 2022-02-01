package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;
import com.tencent.mm.sdk.e.c.a;
import java.lang.reflect.Field;
import java.util.Map;

public abstract class fy
  extends c
{
  public static final String[] INDEX_CREATE = new String[0];
  private static final int eFK = "totalSize".hashCode();
  private static final int eHj = "cacheSize".hashCode();
  private static final int erd;
  private static final int evF;
  private static final int fbG = "storyId".hashCode();
  private static final int rowid_HASHCODE = "rowid".hashCode();
  private boolean eFh = true;
  private boolean eHd = true;
  private boolean eqZ = true;
  private boolean evx = true;
  private boolean fbA = true;
  public int field_cacheSize;
  public String field_filePath;
  public long field_storyId;
  public int field_totalSize;
  public String field_url;
  
  static
  {
    erd = "url".hashCode();
    evF = "filePath".hashCode();
  }
  
  public static c.a Th()
  {
    c.a locala = new c.a();
    locala.GvF = new Field[5];
    locala.columns = new String[6];
    StringBuilder localStringBuilder = new StringBuilder();
    locala.columns[0] = "storyId";
    locala.GvH.put("storyId", "LONG PRIMARY KEY ");
    localStringBuilder.append(" storyId LONG PRIMARY KEY ");
    localStringBuilder.append(", ");
    locala.GvG = "storyId";
    locala.columns[1] = "url";
    locala.GvH.put("url", "TEXT");
    localStringBuilder.append(" url TEXT");
    localStringBuilder.append(", ");
    locala.columns[2] = "filePath";
    locala.GvH.put("filePath", "TEXT");
    localStringBuilder.append(" filePath TEXT");
    localStringBuilder.append(", ");
    locala.columns[3] = "totalSize";
    locala.GvH.put("totalSize", "INTEGER");
    localStringBuilder.append(" totalSize INTEGER");
    localStringBuilder.append(", ");
    locala.columns[4] = "cacheSize";
    locala.GvH.put("cacheSize", "INTEGER");
    localStringBuilder.append(" cacheSize INTEGER");
    locala.columns[5] = "rowid";
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
      if (fbG != k) {
        break label65;
      }
      this.field_storyId = paramCursor.getLong(i);
      this.fbA = true;
    }
    for (;;)
    {
      i += 1;
      break label20;
      break;
      label65:
      if (erd == k) {
        this.field_url = paramCursor.getString(i);
      } else if (evF == k) {
        this.field_filePath = paramCursor.getString(i);
      } else if (eFK == k) {
        this.field_totalSize = paramCursor.getInt(i);
      } else if (eHj == k) {
        this.field_cacheSize = paramCursor.getInt(i);
      } else if (rowid_HASHCODE == k) {
        this.systemRowid = paramCursor.getLong(i);
      }
    }
  }
  
  public ContentValues convertTo()
  {
    ContentValues localContentValues = new ContentValues();
    if (this.fbA) {
      localContentValues.put("storyId", Long.valueOf(this.field_storyId));
    }
    if (this.eqZ) {
      localContentValues.put("url", this.field_url);
    }
    if (this.evx) {
      localContentValues.put("filePath", this.field_filePath);
    }
    if (this.eFh) {
      localContentValues.put("totalSize", Integer.valueOf(this.field_totalSize));
    }
    if (this.eHd) {
      localContentValues.put("cacheSize", Integer.valueOf(this.field_cacheSize));
    }
    if (this.systemRowid > 0L) {
      localContentValues.put("rowid", Long.valueOf(this.systemRowid));
    }
    return localContentValues;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.g.c.fy
 * JD-Core Version:    0.7.0.1
 */