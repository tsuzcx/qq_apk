package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.storage.IAutoDBItem;
import com.tencent.mm.sdk.storage.IAutoDBItem.MAutoDBInfo;
import java.lang.reflect.Field;
import java.util.Map;

public abstract class gt
  extends IAutoDBItem
{
  public static final String[] INDEX_CREATE = new String[0];
  private static final int fLh = "roomname".hashCode();
  private static final int gbH = "newStoryList".hashCode();
  private static final int gbI = "extbuf".hashCode();
  private static final int gbJ = "nextSyncTime".hashCode();
  private static final int gbq = "userStoryFlag".hashCode();
  private static final int rowid_HASHCODE = "rowid".hashCode();
  private boolean fKW = true;
  public byte[] field_extbuf;
  public String field_newStoryList;
  public long field_nextSyncTime;
  public String field_roomname;
  public int field_userStoryFlag;
  private boolean gbE = true;
  private boolean gbF = true;
  private boolean gbG = true;
  private boolean gbc = true;
  
  public static IAutoDBItem.MAutoDBInfo ajs()
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
      if (fLh != k) {
        break label65;
      }
      this.field_roomname = paramCursor.getString(i);
      this.fKW = true;
    }
    for (;;)
    {
      i += 1;
      break label20;
      break;
      label65:
      if (gbq == k) {
        this.field_userStoryFlag = paramCursor.getInt(i);
      } else if (gbH == k) {
        this.field_newStoryList = paramCursor.getString(i);
      } else if (gbI == k) {
        this.field_extbuf = paramCursor.getBlob(i);
      } else if (gbJ == k) {
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
    if (this.fKW) {
      localContentValues.put("roomname", this.field_roomname);
    }
    if (this.gbc) {
      localContentValues.put("userStoryFlag", Integer.valueOf(this.field_userStoryFlag));
    }
    if (this.gbE) {
      localContentValues.put("newStoryList", this.field_newStoryList);
    }
    if (this.gbF) {
      localContentValues.put("extbuf", this.field_extbuf);
    }
    if (this.gbG) {
      localContentValues.put("nextSyncTime", Long.valueOf(this.field_nextSyncTime));
    }
    if (this.systemRowid > 0L) {
      localContentValues.put("rowid", Long.valueOf(this.systemRowid));
    }
    return localContentValues;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.g.c.gt
 * JD-Core Version:    0.7.0.1
 */