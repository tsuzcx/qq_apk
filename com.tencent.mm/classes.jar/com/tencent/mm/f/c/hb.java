package com.tencent.mm.f.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.storage.IAutoDBItem;
import com.tencent.mm.sdk.storage.IAutoDBItem.MAutoDBInfo;
import com.tencent.mm.sdk.storage.sql.Column;
import com.tencent.mm.sdk.storage.sql.SingleTable;
import java.lang.reflect.Field;
import java.util.Map;

public abstract class hb
  extends IAutoDBItem
{
  public static final Column C_ROWID;
  public static final String[] INDEX_CREATE = new String[0];
  public static final SingleTable TABLE = new SingleTable("StoryVideoCacheInfo");
  public static final Column hNE;
  private static final int hOM = "totalSize".hashCode();
  public static final Column hTD;
  private static final int hUb = "cacheSize".hashCode();
  public static final Column hsH;
  private static final int hsP;
  public static final Column hzC;
  private static final int hzS;
  private static final int iAf;
  public static final Column ikF;
  private static final int rowid_HASHCODE = "rowid".hashCode();
  public int field_cacheSize;
  public String field_filePath;
  public long field_storyId;
  public int field_totalSize;
  public String field_url;
  private boolean hOi = true;
  private boolean hTP = true;
  private boolean hsL = true;
  private boolean hzK = true;
  private boolean izZ = true;
  
  static
  {
    C_ROWID = new Column("rowid", "long", "StoryVideoCacheInfo", "");
    ikF = new Column("storyid", "long", "StoryVideoCacheInfo", "");
    hsH = new Column("url", "string", "StoryVideoCacheInfo", "");
    hzC = new Column("filepath", "string", "StoryVideoCacheInfo", "");
    hNE = new Column("totalsize", "int", "StoryVideoCacheInfo", "");
    hTD = new Column("cachesize", "int", "StoryVideoCacheInfo", "");
    iAf = "storyId".hashCode();
    hsP = "url".hashCode();
    hzS = "filePath".hashCode();
  }
  
  public static IAutoDBItem.MAutoDBInfo aoY()
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
      if (iAf != k) {
        break label65;
      }
      this.field_storyId = paramCursor.getLong(i);
      this.izZ = true;
    }
    for (;;)
    {
      i += 1;
      break label20;
      break;
      label65:
      if (hsP == k) {
        this.field_url = paramCursor.getString(i);
      } else if (hzS == k) {
        this.field_filePath = paramCursor.getString(i);
      } else if (hOM == k) {
        this.field_totalSize = paramCursor.getInt(i);
      } else if (hUb == k) {
        this.field_cacheSize = paramCursor.getInt(i);
      } else if (rowid_HASHCODE == k) {
        this.systemRowid = paramCursor.getLong(i);
      }
    }
  }
  
  public ContentValues convertTo()
  {
    ContentValues localContentValues = new ContentValues();
    if (this.izZ) {
      localContentValues.put("storyId", Long.valueOf(this.field_storyId));
    }
    if (this.hsL) {
      localContentValues.put("url", this.field_url);
    }
    if (this.hzK) {
      localContentValues.put("filePath", this.field_filePath);
    }
    if (this.hOi) {
      localContentValues.put("totalSize", Integer.valueOf(this.field_totalSize));
    }
    if (this.hTP) {
      localContentValues.put("cacheSize", Integer.valueOf(this.field_cacheSize));
    }
    if (this.systemRowid > 0L) {
      localContentValues.put("rowid", Long.valueOf(this.systemRowid));
    }
    return localContentValues;
  }
  
  public String[] getIndexCreateSQL()
  {
    return INDEX_CREATE;
  }
  
  public String getTableName()
  {
    return "StoryVideoCacheInfo";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.f.c.hb
 * JD-Core Version:    0.7.0.1
 */