package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;
import com.tencent.mm.sdk.e.c.a;
import java.lang.reflect.Field;
import java.util.Map;

public abstract class fx
  extends c
{
  public static final String[] INDEX_CREATE = new String[0];
  private static final int eMn = "roomname".hashCode();
  private static final int fcB = "newStoryList".hashCode();
  private static final int fcC = "extbuf".hashCode();
  private static final int fcD = "nextSyncTime".hashCode();
  private static final int fck = "userStoryFlag".hashCode();
  private static final int rowid_HASHCODE = "rowid".hashCode();
  private boolean eMe = true;
  private boolean fbW = true;
  private boolean fcA = true;
  private boolean fcy = true;
  private boolean fcz = true;
  public byte[] field_extbuf;
  public String field_newStoryList;
  public long field_nextSyncTime;
  public String field_roomname;
  public int field_userStoryFlag;
  
  public static c.a Th()
  {
    c.a locala = new c.a();
    locala.GvF = new Field[5];
    locala.columns = new String[6];
    StringBuilder localStringBuilder = new StringBuilder();
    locala.columns[0] = "roomname";
    locala.GvH.put("roomname", "TEXT default ''  PRIMARY KEY ");
    localStringBuilder.append(" roomname TEXT default ''  PRIMARY KEY ");
    localStringBuilder.append(", ");
    locala.GvG = "roomname";
    locala.columns[1] = "userStoryFlag";
    locala.GvH.put("userStoryFlag", "INTEGER");
    localStringBuilder.append(" userStoryFlag INTEGER");
    localStringBuilder.append(", ");
    locala.columns[2] = "newStoryList";
    locala.GvH.put("newStoryList", "TEXT");
    localStringBuilder.append(" newStoryList TEXT");
    localStringBuilder.append(", ");
    locala.columns[3] = "extbuf";
    locala.GvH.put("extbuf", "BLOB");
    localStringBuilder.append(" extbuf BLOB");
    localStringBuilder.append(", ");
    locala.columns[4] = "nextSyncTime";
    locala.GvH.put("nextSyncTime", "LONG");
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
      if (eMn != k) {
        break label65;
      }
      this.field_roomname = paramCursor.getString(i);
      this.eMe = true;
    }
    for (;;)
    {
      i += 1;
      break label20;
      break;
      label65:
      if (fck == k) {
        this.field_userStoryFlag = paramCursor.getInt(i);
      } else if (fcB == k) {
        this.field_newStoryList = paramCursor.getString(i);
      } else if (fcC == k) {
        this.field_extbuf = paramCursor.getBlob(i);
      } else if (fcD == k) {
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
    if (this.eMe) {
      localContentValues.put("roomname", this.field_roomname);
    }
    if (this.fbW) {
      localContentValues.put("userStoryFlag", Integer.valueOf(this.field_userStoryFlag));
    }
    if (this.fcy) {
      localContentValues.put("newStoryList", this.field_newStoryList);
    }
    if (this.fcz) {
      localContentValues.put("extbuf", this.field_extbuf);
    }
    if (this.fcA) {
      localContentValues.put("nextSyncTime", Long.valueOf(this.field_nextSyncTime));
    }
    if (this.systemRowid > 0L) {
      localContentValues.put("rowid", Long.valueOf(this.systemRowid));
    }
    return localContentValues;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.g.c.fx
 * JD-Core Version:    0.7.0.1
 */