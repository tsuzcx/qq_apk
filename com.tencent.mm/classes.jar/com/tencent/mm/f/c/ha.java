package com.tencent.mm.f.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.storage.IAutoDBItem;
import com.tencent.mm.sdk.storage.IAutoDBItem.MAutoDBInfo;
import com.tencent.mm.sdk.storage.sql.Column;
import com.tencent.mm.sdk.storage.sql.SingleTable;
import java.lang.reflect.Field;
import java.util.Map;

public abstract class ha
  extends IAutoDBItem
{
  public static final Column C_ROWID;
  public static final String[] INDEX_CREATE = new String[0];
  public static final SingleTable TABLE = new SingleTable("StoryRoomInfo");
  public static final Column hWV;
  private static final int iAX = "userStoryFlag".hashCode();
  public static final Column iAv;
  public static final Column iBl;
  public static final Column iBm;
  public static final Column iBn;
  private static final int iBr = "newStoryList".hashCode();
  private static final int iBs = "extbuf".hashCode();
  private static final int iBt = "nextSyncTime".hashCode();
  private static final int icF;
  private static final int rowid_HASHCODE = "rowid".hashCode();
  public byte[] field_extbuf;
  public String field_newStoryList;
  public long field_nextSyncTime;
  public String field_roomname;
  public int field_userStoryFlag;
  private boolean iAJ = true;
  private boolean iBo = true;
  private boolean iBp = true;
  private boolean iBq = true;
  private boolean icu = true;
  
  static
  {
    C_ROWID = new Column("rowid", "long", "StoryRoomInfo", "");
    hWV = new Column("roomname", "string", "StoryRoomInfo", "");
    iAv = new Column("userstoryflag", "int", "StoryRoomInfo", "");
    iBl = new Column("newstorylist", "string", "StoryRoomInfo", "");
    iBm = new Column("extbuf", "byte[]", "StoryRoomInfo", "");
    iBn = new Column("nextsynctime", "long", "StoryRoomInfo", "");
    icF = "roomname".hashCode();
  }
  
  public static IAutoDBItem.MAutoDBInfo aoY()
  {
    IAutoDBItem.MAutoDBInfo localMAutoDBInfo = new IAutoDBItem.MAutoDBInfo();
    localMAutoDBInfo.fields = new Field[5];
    localMAutoDBInfo.columns = new String[6];
    StringBuilder localStringBuilder = new StringBuilder();
    localMAutoDBInfo.columns[0] = "roomname";
    localMAutoDBInfo.colsMap.put("roomname", "TEXT default ''  PRIMARY KEY ");
    localStringBuilder.append(" roomname TEXT default ''  PRIMARY KEY ");
    localStringBuilder.append(", ");
    localMAutoDBInfo.primaryKey = "roomname";
    localMAutoDBInfo.columns[1] = "userStoryFlag";
    localMAutoDBInfo.colsMap.put("userStoryFlag", "INTEGER");
    localStringBuilder.append(" userStoryFlag INTEGER");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[2] = "newStoryList";
    localMAutoDBInfo.colsMap.put("newStoryList", "TEXT");
    localStringBuilder.append(" newStoryList TEXT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[3] = "extbuf";
    localMAutoDBInfo.colsMap.put("extbuf", "BLOB");
    localStringBuilder.append(" extbuf BLOB");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[4] = "nextSyncTime";
    localMAutoDBInfo.colsMap.put("nextSyncTime", "LONG");
    localStringBuilder.append(" nextSyncTime LONG");
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
      if (icF != k) {
        break label65;
      }
      this.field_roomname = paramCursor.getString(i);
      this.icu = true;
    }
    for (;;)
    {
      i += 1;
      break label20;
      break;
      label65:
      if (iAX == k) {
        this.field_userStoryFlag = paramCursor.getInt(i);
      } else if (iBr == k) {
        this.field_newStoryList = paramCursor.getString(i);
      } else if (iBs == k) {
        this.field_extbuf = paramCursor.getBlob(i);
      } else if (iBt == k) {
        this.field_nextSyncTime = paramCursor.getLong(i);
      } else if (rowid_HASHCODE == k) {
        this.systemRowid = paramCursor.getLong(i);
      }
    }
  }
  
  public ContentValues convertTo()
  {
    ContentValues localContentValues = new ContentValues();
    if (this.field_roomname == null) {
      this.field_roomname = "";
    }
    if (this.icu) {
      localContentValues.put("roomname", this.field_roomname);
    }
    if (this.iAJ) {
      localContentValues.put("userStoryFlag", Integer.valueOf(this.field_userStoryFlag));
    }
    if (this.iBo) {
      localContentValues.put("newStoryList", this.field_newStoryList);
    }
    if (this.iBp) {
      localContentValues.put("extbuf", this.field_extbuf);
    }
    if (this.iBq) {
      localContentValues.put("nextSyncTime", Long.valueOf(this.field_nextSyncTime));
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
    return "StoryRoomInfo";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.f.c.ha
 * JD-Core Version:    0.7.0.1
 */