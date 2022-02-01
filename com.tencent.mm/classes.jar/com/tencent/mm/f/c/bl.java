package com.tencent.mm.f.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.storage.IAutoDBItem;
import com.tencent.mm.sdk.storage.IAutoDBItem.MAutoDBInfo;
import com.tencent.mm.sdk.storage.sql.Column;
import com.tencent.mm.sdk.storage.sql.SingleTable;
import java.lang.reflect.Field;
import java.util.Map;

public abstract class bl
  extends IAutoDBItem
{
  public static final Column C_CONTENT;
  public static final Column C_ROWID;
  public static final Column C_UPDATETIME;
  public static final String[] INDEX_CREATE = new String[0];
  public static final SingleTable TABLE = new SingleTable("EmojiSuggestCacheInfo");
  private static final int content_HASHCODE = "content".hashCode();
  public static final Column hJn;
  private static final int hJv;
  private static final int rowid_HASHCODE = "rowid".hashCode();
  private static final int updateTime_HASHCODE;
  private boolean __hadSetcontent = true;
  private boolean __hadSetupdateTime = true;
  public byte[] field_content;
  public String field_desc;
  public int field_updateTime;
  private boolean hJr = true;
  
  static
  {
    C_ROWID = new Column("rowid", "long", "EmojiSuggestCacheInfo", "");
    hJn = new Column("desc", "string", "EmojiSuggestCacheInfo", "");
    C_UPDATETIME = new Column("updatetime", "int", "EmojiSuggestCacheInfo", "");
    C_CONTENT = new Column("content", "byte[]", "EmojiSuggestCacheInfo", "");
    hJv = "desc".hashCode();
    updateTime_HASHCODE = "updateTime".hashCode();
  }
  
  public static IAutoDBItem.MAutoDBInfo aoY()
  {
    IAutoDBItem.MAutoDBInfo localMAutoDBInfo = new IAutoDBItem.MAutoDBInfo();
    localMAutoDBInfo.fields = new Field[3];
    localMAutoDBInfo.columns = new String[4];
    StringBuilder localStringBuilder = new StringBuilder();
    localMAutoDBInfo.columns[0] = "desc";
    localMAutoDBInfo.colsMap.put("desc", "TEXT PRIMARY KEY ");
    localStringBuilder.append(" desc TEXT PRIMARY KEY ");
    localStringBuilder.append(", ");
    localMAutoDBInfo.primaryKey = "desc";
    localMAutoDBInfo.columns[1] = "updateTime";
    localMAutoDBInfo.colsMap.put("updateTime", "INTEGER");
    localStringBuilder.append(" updateTime INTEGER");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[2] = "content";
    localMAutoDBInfo.colsMap.put("content", "BLOB");
    localStringBuilder.append(" content BLOB");
    localMAutoDBInfo.columns[3] = "rowid";
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
      if (hJv != k) {
        break label65;
      }
      this.field_desc = paramCursor.getString(i);
      this.hJr = true;
    }
    for (;;)
    {
      i += 1;
      break label20;
      break;
      label65:
      if (updateTime_HASHCODE == k) {
        this.field_updateTime = paramCursor.getInt(i);
      } else if (content_HASHCODE == k) {
        this.field_content = paramCursor.getBlob(i);
      } else if (rowid_HASHCODE == k) {
        this.systemRowid = paramCursor.getLong(i);
      }
    }
  }
  
  public ContentValues convertTo()
  {
    ContentValues localContentValues = new ContentValues();
    if (this.hJr) {
      localContentValues.put("desc", this.field_desc);
    }
    if (this.__hadSetupdateTime) {
      localContentValues.put("updateTime", Integer.valueOf(this.field_updateTime));
    }
    if (this.__hadSetcontent) {
      localContentValues.put("content", this.field_content);
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
    return "EmojiSuggestCacheInfo";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.f.c.bl
 * JD-Core Version:    0.7.0.1
 */