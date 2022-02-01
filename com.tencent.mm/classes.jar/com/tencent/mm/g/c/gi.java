package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;
import com.tencent.mm.sdk.e.c.a;
import java.lang.reflect.Field;
import java.util.Map;

public abstract class gi
  extends c
{
  public static final String[] INDEX_CREATE = new String[0];
  private static final int fgE = "roomname".hashCode();
  private static final int fwP = "newStoryList".hashCode();
  private static final int fwQ = "extbuf".hashCode();
  private static final int fwR = "nextSyncTime".hashCode();
  private static final int fwy = "userStoryFlag".hashCode();
  private static final int rowid_HASHCODE = "rowid".hashCode();
  private boolean fgt = true;
  public byte[] field_extbuf;
  public String field_newStoryList;
  public long field_nextSyncTime;
  public String field_roomname;
  public int field_userStoryFlag;
  private boolean fwM = true;
  private boolean fwN = true;
  private boolean fwO = true;
  private boolean fwk = true;
  
  public static c.a VD()
  {
    c.a locala = new c.a();
    locala.IBL = new Field[5];
    locala.columns = new String[6];
    StringBuilder localStringBuilder = new StringBuilder();
    locala.columns[0] = "roomname";
    locala.IBN.put("roomname", "TEXT default ''  PRIMARY KEY ");
    localStringBuilder.append(" roomname TEXT default ''  PRIMARY KEY ");
    localStringBuilder.append(", ");
    locala.IBM = "roomname";
    locala.columns[1] = "userStoryFlag";
    locala.IBN.put("userStoryFlag", "INTEGER");
    localStringBuilder.append(" userStoryFlag INTEGER");
    localStringBuilder.append(", ");
    locala.columns[2] = "newStoryList";
    locala.IBN.put("newStoryList", "TEXT");
    localStringBuilder.append(" newStoryList TEXT");
    localStringBuilder.append(", ");
    locala.columns[3] = "extbuf";
    locala.IBN.put("extbuf", "BLOB");
    localStringBuilder.append(" extbuf BLOB");
    localStringBuilder.append(", ");
    locala.columns[4] = "nextSyncTime";
    locala.IBN.put("nextSyncTime", "LONG");
    localStringBuilder.append(" nextSyncTime LONG");
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
      if (fgE != k) {
        break label65;
      }
      this.field_roomname = paramCursor.getString(i);
      this.fgt = true;
    }
    for (;;)
    {
      i += 1;
      break label20;
      break;
      label65:
      if (fwy == k) {
        this.field_userStoryFlag = paramCursor.getInt(i);
      } else if (fwP == k) {
        this.field_newStoryList = paramCursor.getString(i);
      } else if (fwQ == k) {
        this.field_extbuf = paramCursor.getBlob(i);
      } else if (fwR == k) {
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
    if (this.fgt) {
      localContentValues.put("roomname", this.field_roomname);
    }
    if (this.fwk) {
      localContentValues.put("userStoryFlag", Integer.valueOf(this.field_userStoryFlag));
    }
    if (this.fwM) {
      localContentValues.put("newStoryList", this.field_newStoryList);
    }
    if (this.fwN) {
      localContentValues.put("extbuf", this.field_extbuf);
    }
    if (this.fwO) {
      localContentValues.put("nextSyncTime", Long.valueOf(this.field_nextSyncTime));
    }
    if (this.systemRowid > 0L) {
      localContentValues.put("rowid", Long.valueOf(this.systemRowid));
    }
    return localContentValues;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.g.c.gi
 * JD-Core Version:    0.7.0.1
 */