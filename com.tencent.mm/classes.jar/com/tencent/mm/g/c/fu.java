package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;
import com.tencent.mm.sdk.e.c.a;
import java.lang.reflect.Field;
import java.util.Map;

public abstract class fu
  extends c
{
  public static final String[] INDEX_CREATE = new String[0];
  private static final int eDq = "totalSize".hashCode();
  private static final int eEG = "cacheSize".hashCode();
  private static final int eYs = "storyId".hashCode();
  private static final int eoZ = "url".hashCode();
  private static final int etB = "filePath".hashCode();
  private static final int rowid_HASHCODE = "rowid".hashCode();
  private boolean eCN = true;
  private boolean eED = true;
  private boolean eYm = true;
  private boolean eoV = true;
  private boolean ett = true;
  public int field_cacheSize;
  public String field_filePath;
  public long field_storyId;
  public int field_totalSize;
  public String field_url;
  
  public static c.a So()
  {
    c.a locala = new c.a();
    locala.EYt = new Field[5];
    locala.columns = new String[6];
    StringBuilder localStringBuilder = new StringBuilder();
    locala.columns[0] = "storyId";
    locala.EYv.put("storyId", "LONG PRIMARY KEY ");
    localStringBuilder.append(" storyId LONG PRIMARY KEY ");
    localStringBuilder.append(", ");
    locala.EYu = "storyId";
    locala.columns[1] = "url";
    locala.EYv.put("url", "TEXT");
    localStringBuilder.append(" url TEXT");
    localStringBuilder.append(", ");
    locala.columns[2] = "filePath";
    locala.EYv.put("filePath", "TEXT");
    localStringBuilder.append(" filePath TEXT");
    localStringBuilder.append(", ");
    locala.columns[3] = "totalSize";
    locala.EYv.put("totalSize", "INTEGER");
    localStringBuilder.append(" totalSize INTEGER");
    localStringBuilder.append(", ");
    locala.columns[4] = "cacheSize";
    locala.EYv.put("cacheSize", "INTEGER");
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
      if (eYs != k) {
        break label65;
      }
      this.field_storyId = paramCursor.getLong(i);
      this.eYm = true;
    }
    for (;;)
    {
      i += 1;
      break label20;
      break;
      label65:
      if (eoZ == k) {
        this.field_url = paramCursor.getString(i);
      } else if (etB == k) {
        this.field_filePath = paramCursor.getString(i);
      } else if (eDq == k) {
        this.field_totalSize = paramCursor.getInt(i);
      } else if (eEG == k) {
        this.field_cacheSize = paramCursor.getInt(i);
      } else if (rowid_HASHCODE == k) {
        this.systemRowid = paramCursor.getLong(i);
      }
    }
  }
  
  public ContentValues convertTo()
  {
    ContentValues localContentValues = new ContentValues();
    if (this.eYm) {
      localContentValues.put("storyId", Long.valueOf(this.field_storyId));
    }
    if (this.eoV) {
      localContentValues.put("url", this.field_url);
    }
    if (this.ett) {
      localContentValues.put("filePath", this.field_filePath);
    }
    if (this.eCN) {
      localContentValues.put("totalSize", Integer.valueOf(this.field_totalSize));
    }
    if (this.eED) {
      localContentValues.put("cacheSize", Integer.valueOf(this.field_cacheSize));
    }
    if (this.systemRowid > 0L) {
      localContentValues.put("rowid", Long.valueOf(this.systemRowid));
    }
    return localContentValues;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.g.c.fu
 * JD-Core Version:    0.7.0.1
 */