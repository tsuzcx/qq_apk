package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;
import com.tencent.mm.sdk.e.c.a;
import java.lang.reflect.Field;
import java.util.Map;

public abstract class ft
  extends c
{
  public static final String[] INDEX_CREATE = new String[0];
  private static final int eJv = "roomname".hashCode();
  private static final int eYY = "userStoryFlag".hashCode();
  private static final int eZp = "newStoryList".hashCode();
  private static final int eZq = "extbuf".hashCode();
  private static final int eZr = "nextSyncTime".hashCode();
  private static final int rowid_HASHCODE = "rowid".hashCode();
  private boolean eJm = true;
  private boolean eYK = true;
  private boolean eZm = true;
  private boolean eZn = true;
  private boolean eZo = true;
  public byte[] field_extbuf;
  public String field_newStoryList;
  public long field_nextSyncTime;
  public String field_roomname;
  public int field_userStoryFlag;
  
  public static c.a So()
  {
    c.a locala = new c.a();
    locala.EYt = new Field[5];
    locala.columns = new String[6];
    StringBuilder localStringBuilder = new StringBuilder();
    locala.columns[0] = "roomname";
    locala.EYv.put("roomname", "TEXT default ''  PRIMARY KEY ");
    localStringBuilder.append(" roomname TEXT default ''  PRIMARY KEY ");
    localStringBuilder.append(", ");
    locala.EYu = "roomname";
    locala.columns[1] = "userStoryFlag";
    locala.EYv.put("userStoryFlag", "INTEGER");
    localStringBuilder.append(" userStoryFlag INTEGER");
    localStringBuilder.append(", ");
    locala.columns[2] = "newStoryList";
    locala.EYv.put("newStoryList", "TEXT");
    localStringBuilder.append(" newStoryList TEXT");
    localStringBuilder.append(", ");
    locala.columns[3] = "extbuf";
    locala.EYv.put("extbuf", "BLOB");
    localStringBuilder.append(" extbuf BLOB");
    localStringBuilder.append(", ");
    locala.columns[4] = "nextSyncTime";
    locala.EYv.put("nextSyncTime", "LONG");
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
      if (eJv != k) {
        break label65;
      }
      this.field_roomname = paramCursor.getString(i);
      this.eJm = true;
    }
    for (;;)
    {
      i += 1;
      break label20;
      break;
      label65:
      if (eYY == k) {
        this.field_userStoryFlag = paramCursor.getInt(i);
      } else if (eZp == k) {
        this.field_newStoryList = paramCursor.getString(i);
      } else if (eZq == k) {
        this.field_extbuf = paramCursor.getBlob(i);
      } else if (eZr == k) {
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
    if (this.eJm) {
      localContentValues.put("roomname", this.field_roomname);
    }
    if (this.eYK) {
      localContentValues.put("userStoryFlag", Integer.valueOf(this.field_userStoryFlag));
    }
    if (this.eZm) {
      localContentValues.put("newStoryList", this.field_newStoryList);
    }
    if (this.eZn) {
      localContentValues.put("extbuf", this.field_extbuf);
    }
    if (this.eZo) {
      localContentValues.put("nextSyncTime", Long.valueOf(this.field_nextSyncTime));
    }
    if (this.systemRowid > 0L) {
      localContentValues.put("rowid", Long.valueOf(this.systemRowid));
    }
    return localContentValues;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.g.c.ft
 * JD-Core Version:    0.7.0.1
 */