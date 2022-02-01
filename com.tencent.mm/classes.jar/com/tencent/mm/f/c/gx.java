package com.tencent.mm.f.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.storage.IAutoDBItem;
import com.tencent.mm.sdk.storage.IAutoDBItem.MAutoDBInfo;
import com.tencent.mm.sdk.storage.sql.Column;
import com.tencent.mm.sdk.storage.sql.SingleTable;
import java.lang.reflect.Field;
import java.util.Map;

public abstract class gx
  extends IAutoDBItem
{
  public static final Column C_ROWID;
  public static final String[] INDEX_CREATE = new String[0];
  public static final SingleTable TABLE = new SingleTable("StoryCommentSync");
  private static final int iAf = "storyId".hashCode();
  private static final int iAg = "readCommentId".hashCode();
  private static final int iAh = "syncCommentId".hashCode();
  private static final int iAi = "readCommentTime".hashCode();
  private static final int iAj = "syncCommentTime".hashCode();
  private static final int iAk = "commentFlag".hashCode();
  public static final Column ikF;
  public static final Column iyb;
  public static final Column izV;
  public static final Column izW;
  public static final Column izX;
  public static final Column izY;
  private static final int rowid_HASHCODE = "rowid".hashCode();
  public int field_commentFlag;
  public int field_readCommentId;
  public int field_readCommentTime;
  public long field_storyId;
  public int field_syncCommentId;
  public int field_syncCommentTime;
  private boolean iAa = true;
  private boolean iAb = true;
  private boolean iAc = true;
  private boolean iAd = true;
  private boolean iAe = true;
  private boolean izZ = true;
  
  static
  {
    C_ROWID = new Column("rowid", "long", "StoryCommentSync", "");
    ikF = new Column("storyid", "long", "StoryCommentSync", "");
    izV = new Column("readcommentid", "int", "StoryCommentSync", "");
    izW = new Column("synccommentid", "int", "StoryCommentSync", "");
    izX = new Column("readcommenttime", "int", "StoryCommentSync", "");
    izY = new Column("synccommenttime", "int", "StoryCommentSync", "");
    iyb = new Column("commentflag", "int", "StoryCommentSync", "");
  }
  
  public static IAutoDBItem.MAutoDBInfo aoY()
  {
    IAutoDBItem.MAutoDBInfo localMAutoDBInfo = new IAutoDBItem.MAutoDBInfo();
    localMAutoDBInfo.fields = new Field[6];
    localMAutoDBInfo.columns = new String[7];
    StringBuilder localStringBuilder = new StringBuilder();
    localMAutoDBInfo.columns[0] = "storyId";
    localMAutoDBInfo.colsMap.put("storyId", "LONG PRIMARY KEY ");
    localStringBuilder.append(" storyId LONG PRIMARY KEY ");
    localStringBuilder.append(", ");
    localMAutoDBInfo.primaryKey = "storyId";
    localMAutoDBInfo.columns[1] = "readCommentId";
    localMAutoDBInfo.colsMap.put("readCommentId", "INTEGER");
    localStringBuilder.append(" readCommentId INTEGER");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[2] = "syncCommentId";
    localMAutoDBInfo.colsMap.put("syncCommentId", "INTEGER");
    localStringBuilder.append(" syncCommentId INTEGER");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[3] = "readCommentTime";
    localMAutoDBInfo.colsMap.put("readCommentTime", "INTEGER");
    localStringBuilder.append(" readCommentTime INTEGER");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[4] = "syncCommentTime";
    localMAutoDBInfo.colsMap.put("syncCommentTime", "INTEGER");
    localStringBuilder.append(" syncCommentTime INTEGER");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[5] = "commentFlag";
    localMAutoDBInfo.colsMap.put("commentFlag", "INTEGER");
    localStringBuilder.append(" commentFlag INTEGER");
    localMAutoDBInfo.columns[6] = "rowid";
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
      if (iAg == k) {
        this.field_readCommentId = paramCursor.getInt(i);
      } else if (iAh == k) {
        this.field_syncCommentId = paramCursor.getInt(i);
      } else if (iAi == k) {
        this.field_readCommentTime = paramCursor.getInt(i);
      } else if (iAj == k) {
        this.field_syncCommentTime = paramCursor.getInt(i);
      } else if (iAk == k) {
        this.field_commentFlag = paramCursor.getInt(i);
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
    if (this.iAa) {
      localContentValues.put("readCommentId", Integer.valueOf(this.field_readCommentId));
    }
    if (this.iAb) {
      localContentValues.put("syncCommentId", Integer.valueOf(this.field_syncCommentId));
    }
    if (this.iAc) {
      localContentValues.put("readCommentTime", Integer.valueOf(this.field_readCommentTime));
    }
    if (this.iAd) {
      localContentValues.put("syncCommentTime", Integer.valueOf(this.field_syncCommentTime));
    }
    if (this.iAe) {
      localContentValues.put("commentFlag", Integer.valueOf(this.field_commentFlag));
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
    return "StoryCommentSync";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.f.c.gx
 * JD-Core Version:    0.7.0.1
 */