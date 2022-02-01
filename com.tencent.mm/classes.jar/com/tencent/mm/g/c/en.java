package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.storage.IAutoDBItem;
import com.tencent.mm.sdk.storage.IAutoDBItem.MAutoDBInfo;
import java.lang.reflect.Field;
import java.util.Map;

public abstract class en
  extends IAutoDBItem
{
  public static final String[] INDEX_CREATE = { "CREATE INDEX IF NOT EXISTS MMStoryInfo_id_Index ON MMStoryInfo(storyID)" };
  private static final int attrBuf_HASHCODE;
  private static final int content_HASHCODE;
  private static final int createTime_HASHCODE;
  private static final int fQI = "storyID".hashCode();
  private static final int fQJ;
  private static final int fQK = "itemStoryFlag".hashCode();
  private static final int fQL = "readCount".hashCode();
  private static final int fQM = "favoriteTime".hashCode();
  private static final int localFlag_HASHCODE;
  private static final int postBuf_HASHCODE;
  private static final int rowid_HASHCODE = "rowid".hashCode();
  private static final int sourceType_HASHCODE;
  private static final int type_HASHCODE;
  private static final int userName_HASHCODE = "userName".hashCode();
  private boolean __hadSetattrBuf = true;
  private boolean __hadSetcontent = true;
  private boolean __hadSetcreateTime = true;
  private boolean __hadSetlocalFlag = true;
  private boolean __hadSetpostBuf = true;
  private boolean __hadSetsourceType = true;
  private boolean __hadSettype = true;
  private boolean __hadSetuserName = true;
  private boolean fQD = true;
  private boolean fQE = true;
  private boolean fQF = true;
  private boolean fQG = true;
  private boolean fQH = true;
  public byte[] field_attrBuf;
  public int field_commentListCount;
  public byte[] field_content;
  public int field_createTime;
  public int field_favoriteTime;
  public int field_itemStoryFlag;
  public int field_localFlag;
  public byte[] field_postBuf;
  public int field_readCount;
  public int field_sourceType;
  public long field_storyID;
  public int field_type;
  public String field_userName;
  
  static
  {
    localFlag_HASHCODE = "localFlag".hashCode();
    createTime_HASHCODE = "createTime".hashCode();
    fQJ = "commentListCount".hashCode();
    content_HASHCODE = "content".hashCode();
    attrBuf_HASHCODE = "attrBuf".hashCode();
    postBuf_HASHCODE = "postBuf".hashCode();
    sourceType_HASHCODE = "sourceType".hashCode();
    type_HASHCODE = "type".hashCode();
  }
  
  public static IAutoDBItem.MAutoDBInfo ajs()
  {
    IAutoDBItem.MAutoDBInfo localMAutoDBInfo = new IAutoDBItem.MAutoDBInfo();
    localMAutoDBInfo.fields = new Field[13];
    localMAutoDBInfo.columns = new String[14];
    StringBuilder localStringBuilder = new StringBuilder();
    localMAutoDBInfo.columns[0] = "storyID";
    localMAutoDBInfo.colsMap.put("storyID", "LONG");
    localStringBuilder.append(" storyID LONG");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[1] = "userName";
    localMAutoDBInfo.colsMap.put("userName", "TEXT");
    localStringBuilder.append(" userName TEXT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[2] = "localFlag";
    localMAutoDBInfo.colsMap.put("localFlag", "INTEGER");
    localStringBuilder.append(" localFlag INTEGER");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[3] = "createTime";
    localMAutoDBInfo.colsMap.put("createTime", "INTEGER");
    localStringBuilder.append(" createTime INTEGER");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[4] = "commentListCount";
    localMAutoDBInfo.colsMap.put("commentListCount", "INTEGER");
    localStringBuilder.append(" commentListCount INTEGER");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[5] = "content";
    localMAutoDBInfo.colsMap.put("content", "BLOB");
    localStringBuilder.append(" content BLOB");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[6] = "attrBuf";
    localMAutoDBInfo.colsMap.put("attrBuf", "BLOB");
    localStringBuilder.append(" attrBuf BLOB");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[7] = "postBuf";
    localMAutoDBInfo.colsMap.put("postBuf", "BLOB");
    localStringBuilder.append(" postBuf BLOB");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[8] = "sourceType";
    localMAutoDBInfo.colsMap.put("sourceType", "INTEGER");
    localStringBuilder.append(" sourceType INTEGER");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[9] = "type";
    localMAutoDBInfo.colsMap.put("type", "INTEGER");
    localStringBuilder.append(" type INTEGER");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[10] = "itemStoryFlag";
    localMAutoDBInfo.colsMap.put("itemStoryFlag", "INTEGER");
    localStringBuilder.append(" itemStoryFlag INTEGER");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[11] = "readCount";
    localMAutoDBInfo.colsMap.put("readCount", "INTEGER");
    localStringBuilder.append(" readCount INTEGER");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[12] = "favoriteTime";
    localMAutoDBInfo.colsMap.put("favoriteTime", "INTEGER");
    localStringBuilder.append(" favoriteTime INTEGER");
    localMAutoDBInfo.columns[13] = "rowid";
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
      if (fQI != k) {
        break label60;
      }
      this.field_storyID = paramCursor.getLong(i);
    }
    for (;;)
    {
      i += 1;
      break label20;
      break;
      label60:
      if (userName_HASHCODE == k) {
        this.field_userName = paramCursor.getString(i);
      } else if (localFlag_HASHCODE == k) {
        this.field_localFlag = paramCursor.getInt(i);
      } else if (createTime_HASHCODE == k) {
        this.field_createTime = paramCursor.getInt(i);
      } else if (fQJ == k) {
        this.field_commentListCount = paramCursor.getInt(i);
      } else if (content_HASHCODE == k) {
        this.field_content = paramCursor.getBlob(i);
      } else if (attrBuf_HASHCODE == k) {
        this.field_attrBuf = paramCursor.getBlob(i);
      } else if (postBuf_HASHCODE == k) {
        this.field_postBuf = paramCursor.getBlob(i);
      } else if (sourceType_HASHCODE == k) {
        this.field_sourceType = paramCursor.getInt(i);
      } else if (type_HASHCODE == k) {
        this.field_type = paramCursor.getInt(i);
      } else if (fQK == k) {
        this.field_itemStoryFlag = paramCursor.getInt(i);
      } else if (fQL == k) {
        this.field_readCount = paramCursor.getInt(i);
      } else if (fQM == k) {
        this.field_favoriteTime = paramCursor.getInt(i);
      } else if (rowid_HASHCODE == k) {
        this.systemRowid = paramCursor.getLong(i);
      }
    }
  }
  
  public ContentValues convertTo()
  {
    ContentValues localContentValues = new ContentValues();
    if (this.fQD) {
      localContentValues.put("storyID", Long.valueOf(this.field_storyID));
    }
    if (this.__hadSetuserName) {
      localContentValues.put("userName", this.field_userName);
    }
    if (this.__hadSetlocalFlag) {
      localContentValues.put("localFlag", Integer.valueOf(this.field_localFlag));
    }
    if (this.__hadSetcreateTime) {
      localContentValues.put("createTime", Integer.valueOf(this.field_createTime));
    }
    if (this.fQE) {
      localContentValues.put("commentListCount", Integer.valueOf(this.field_commentListCount));
    }
    if (this.__hadSetcontent) {
      localContentValues.put("content", this.field_content);
    }
    if (this.__hadSetattrBuf) {
      localContentValues.put("attrBuf", this.field_attrBuf);
    }
    if (this.__hadSetpostBuf) {
      localContentValues.put("postBuf", this.field_postBuf);
    }
    if (this.__hadSetsourceType) {
      localContentValues.put("sourceType", Integer.valueOf(this.field_sourceType));
    }
    if (this.__hadSettype) {
      localContentValues.put("type", Integer.valueOf(this.field_type));
    }
    if (this.fQF) {
      localContentValues.put("itemStoryFlag", Integer.valueOf(this.field_itemStoryFlag));
    }
    if (this.fQG) {
      localContentValues.put("readCount", Integer.valueOf(this.field_readCount));
    }
    if (this.fQH) {
      localContentValues.put("favoriteTime", Integer.valueOf(this.field_favoriteTime));
    }
    if (this.systemRowid > 0L) {
      localContentValues.put("rowid", Long.valueOf(this.systemRowid));
    }
    return localContentValues;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.g.c.en
 * JD-Core Version:    0.7.0.1
 */