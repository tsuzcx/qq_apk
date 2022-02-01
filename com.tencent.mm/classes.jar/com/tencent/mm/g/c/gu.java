package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.storage.IAutoDBItem;
import com.tencent.mm.sdk.storage.IAutoDBItem.MAutoDBInfo;
import java.lang.reflect.Field;
import java.util.Map;

public abstract class gu
  extends IAutoDBItem
{
  public static final String[] INDEX_CREATE = new String[0];
  private static final int fCx = "totalSize".hashCode();
  private static final int fEV = "cacheSize".hashCode();
  private static final int fnB;
  private static final int fsu;
  private static final int gaM = "storyId".hashCode();
  private static final int rowid_HASHCODE = "rowid".hashCode();
  private boolean fBT = true;
  private boolean fEJ = true;
  public int field_cacheSize;
  public String field_filePath;
  public long field_storyId;
  public int field_totalSize;
  public String field_url;
  private boolean fnx = true;
  private boolean fsm = true;
  private boolean gaG = true;
  
  static
  {
    fnB = "url".hashCode();
    fsu = "filePath".hashCode();
  }
  
  public static IAutoDBItem.MAutoDBInfo ajs()
  {
    IAutoDBItem.MAutoDBInfo localMAutoDBInfo = new IAutoDBItem.MAutoDBInfo();
    localMAutoDBInfo.fields = new Field[5];
    localMAutoDBInfo.columns = new String[6];
    StringBuilder localStringBuilder = new StringBuilder();
    localMAutoDBInfo.columns[0] = "storyId";
    localMAutoDBInfo.colsMap.put("storyId", "LONG PRIMARY KEY ");
    localStringBuilder.append(" storyId LONG PRIMARY KEY ");
    localStringBuilder.append(", ");
    localMAutoDBInfo.primaryKey = "storyId";
    localMAutoDBInfo.columns[1] = "url";
    localMAutoDBInfo.colsMap.put("url", "TEXT");
    localStringBuilder.append(" url TEXT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[2] = "filePath";
    localMAutoDBInfo.colsMap.put("filePath", "TEXT");
    localStringBuilder.append(" filePath TEXT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[3] = "totalSize";
    localMAutoDBInfo.colsMap.put("totalSize", "INTEGER");
    localStringBuilder.append(" totalSize INTEGER");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[4] = "cacheSize";
    localMAutoDBInfo.colsMap.put("cacheSize", "INTEGER");
    localStringBuilder.append(" cacheSize INTEGER");
    localMAutoDBInfo.columns[5] = "rowid";
    localMAutoDBInfo.sql = localStringBuilder.toString();
    return localMAutoDBInfo;
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
      if (gaM != k) {
        break label65;
      }
      this.field_storyId = paramCursor.getLong(i);
      this.gaG = true;
    }
    for (;;)
    {
      i += 1;
      break label20;
      break;
      label65:
      if (fnB == k) {
        this.field_url = paramCursor.getString(i);
      } else if (fsu == k) {
        this.field_filePath = paramCursor.getString(i);
      } else if (fCx == k) {
        this.field_totalSize = paramCursor.getInt(i);
      } else if (fEV == k) {
        this.field_cacheSize = paramCursor.getInt(i);
      } else if (rowid_HASHCODE == k) {
        this.systemRowid = paramCursor.getLong(i);
      }
    }
  }
  
  public ContentValues convertTo()
  {
    ContentValues localContentValues = new ContentValues();
    if (this.gaG) {
      localContentValues.put("storyId", Long.valueOf(this.field_storyId));
    }
    if (this.fnx) {
      localContentValues.put("url", this.field_url);
    }
    if (this.fsm) {
      localContentValues.put("filePath", this.field_filePath);
    }
    if (this.fBT) {
      localContentValues.put("totalSize", Integer.valueOf(this.field_totalSize));
    }
    if (this.fEJ) {
      localContentValues.put("cacheSize", Integer.valueOf(this.field_cacheSize));
    }
    if (this.systemRowid > 0L) {
      localContentValues.put("rowid", Long.valueOf(this.systemRowid));
    }
    return localContentValues;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.g.c.gu
 * JD-Core Version:    0.7.0.1
 */