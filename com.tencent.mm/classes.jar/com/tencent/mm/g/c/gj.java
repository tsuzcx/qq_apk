package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;
import com.tencent.mm.sdk.e.c.a;
import java.lang.reflect.Field;
import java.util.Map;

public abstract class gj
  extends c
{
  public static final String[] INDEX_CREATE = new String[0];
  private static final int eJV = "url".hashCode();
  private static final int eON = "filePath".hashCode();
  private static final int eYT = "totalSize".hashCode();
  private static final int faQ = "cacheSize".hashCode();
  private static final int fvU = "storyId".hashCode();
  private static final int rowid_HASHCODE = "rowid".hashCode();
  private boolean eJR = true;
  private boolean eOF = true;
  private boolean eYq = true;
  private boolean faE = true;
  public int field_cacheSize;
  public String field_filePath;
  public long field_storyId;
  public int field_totalSize;
  public String field_url;
  private boolean fvO = true;
  
  public static c.a VD()
  {
    c.a locala = new c.a();
    locala.IBL = new Field[5];
    locala.columns = new String[6];
    StringBuilder localStringBuilder = new StringBuilder();
    locala.columns[0] = "storyId";
    locala.IBN.put("storyId", "LONG PRIMARY KEY ");
    localStringBuilder.append(" storyId LONG PRIMARY KEY ");
    localStringBuilder.append(", ");
    locala.IBM = "storyId";
    locala.columns[1] = "url";
    locala.IBN.put("url", "TEXT");
    localStringBuilder.append(" url TEXT");
    localStringBuilder.append(", ");
    locala.columns[2] = "filePath";
    locala.IBN.put("filePath", "TEXT");
    localStringBuilder.append(" filePath TEXT");
    localStringBuilder.append(", ");
    locala.columns[3] = "totalSize";
    locala.IBN.put("totalSize", "INTEGER");
    localStringBuilder.append(" totalSize INTEGER");
    localStringBuilder.append(", ");
    locala.columns[4] = "cacheSize";
    locala.IBN.put("cacheSize", "INTEGER");
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
      if (fvU != k) {
        break label65;
      }
      this.field_storyId = paramCursor.getLong(i);
      this.fvO = true;
    }
    for (;;)
    {
      i += 1;
      break label20;
      break;
      label65:
      if (eJV == k) {
        this.field_url = paramCursor.getString(i);
      } else if (eON == k) {
        this.field_filePath = paramCursor.getString(i);
      } else if (eYT == k) {
        this.field_totalSize = paramCursor.getInt(i);
      } else if (faQ == k) {
        this.field_cacheSize = paramCursor.getInt(i);
      } else if (rowid_HASHCODE == k) {
        this.systemRowid = paramCursor.getLong(i);
      }
    }
  }
  
  public ContentValues convertTo()
  {
    ContentValues localContentValues = new ContentValues();
    if (this.fvO) {
      localContentValues.put("storyId", Long.valueOf(this.field_storyId));
    }
    if (this.eJR) {
      localContentValues.put("url", this.field_url);
    }
    if (this.eOF) {
      localContentValues.put("filePath", this.field_filePath);
    }
    if (this.eYq) {
      localContentValues.put("totalSize", Integer.valueOf(this.field_totalSize));
    }
    if (this.faE) {
      localContentValues.put("cacheSize", Integer.valueOf(this.field_cacheSize));
    }
    if (this.systemRowid > 0L) {
      localContentValues.put("rowid", Long.valueOf(this.systemRowid));
    }
    return localContentValues;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.g.c.gj
 * JD-Core Version:    0.7.0.1
 */