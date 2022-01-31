package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;
import com.tencent.mm.sdk.e.c.a;
import java.lang.reflect.Field;
import java.util.Map;

public abstract class ey
  extends c
{
  public static final String[] INDEX_CREATE = new String[0];
  private static final int dPB = "storyId".hashCode();
  private static final int dQC = "cacheSize".hashCode();
  private static final int dkC = "url".hashCode();
  private static final int doK = "filePath".hashCode();
  private static final int dye = "totalSize".hashCode();
  private static final int rowid_HASHCODE = "rowid".hashCode();
  private boolean dPv = true;
  private boolean dQB = true;
  private boolean dky = true;
  private boolean doC = true;
  private boolean dxD = true;
  public int field_cacheSize;
  public String field_filePath;
  public long field_storyId;
  public int field_totalSize;
  public String field_url;
  
  public static c.a Hm()
  {
    c.a locala = new c.a();
    locala.yrK = new Field[5];
    locala.columns = new String[6];
    StringBuilder localStringBuilder = new StringBuilder();
    locala.columns[0] = "storyId";
    locala.yrM.put("storyId", "LONG PRIMARY KEY ");
    localStringBuilder.append(" storyId LONG PRIMARY KEY ");
    localStringBuilder.append(", ");
    locala.yrL = "storyId";
    locala.columns[1] = "url";
    locala.yrM.put("url", "TEXT");
    localStringBuilder.append(" url TEXT");
    localStringBuilder.append(", ");
    locala.columns[2] = "filePath";
    locala.yrM.put("filePath", "TEXT");
    localStringBuilder.append(" filePath TEXT");
    localStringBuilder.append(", ");
    locala.columns[3] = "totalSize";
    locala.yrM.put("totalSize", "INTEGER");
    localStringBuilder.append(" totalSize INTEGER");
    localStringBuilder.append(", ");
    locala.columns[4] = "cacheSize";
    locala.yrM.put("cacheSize", "INTEGER");
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
      if (dPB != k) {
        break label65;
      }
      this.field_storyId = paramCursor.getLong(i);
      this.dPv = true;
    }
    for (;;)
    {
      i += 1;
      break label20;
      break;
      label65:
      if (dkC == k) {
        this.field_url = paramCursor.getString(i);
      } else if (doK == k) {
        this.field_filePath = paramCursor.getString(i);
      } else if (dye == k) {
        this.field_totalSize = paramCursor.getInt(i);
      } else if (dQC == k) {
        this.field_cacheSize = paramCursor.getInt(i);
      } else if (rowid_HASHCODE == k) {
        this.systemRowid = paramCursor.getLong(i);
      }
    }
  }
  
  public ContentValues convertTo()
  {
    ContentValues localContentValues = new ContentValues();
    if (this.dPv) {
      localContentValues.put("storyId", Long.valueOf(this.field_storyId));
    }
    if (this.dky) {
      localContentValues.put("url", this.field_url);
    }
    if (this.doC) {
      localContentValues.put("filePath", this.field_filePath);
    }
    if (this.dxD) {
      localContentValues.put("totalSize", Integer.valueOf(this.field_totalSize));
    }
    if (this.dQB) {
      localContentValues.put("cacheSize", Integer.valueOf(this.field_cacheSize));
    }
    if (this.systemRowid > 0L) {
      localContentValues.put("rowid", Long.valueOf(this.systemRowid));
    }
    return localContentValues;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.g.c.ey
 * JD-Core Version:    0.7.0.1
 */