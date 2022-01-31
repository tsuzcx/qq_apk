package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;
import com.tencent.mm.sdk.e.c.a;
import java.lang.reflect.Field;
import java.util.Map;

public abstract class ex
  extends c
{
  public static final String[] INDEX_CREATE = new String[0];
  private static final int dQA = "nextSyncTime".hashCode();
  private static final int dQg;
  private static final int dQx = "roomname".hashCode();
  private static final int dQy;
  private static final int dQz;
  private static final int rowid_HASHCODE = "rowid".hashCode();
  private boolean dPT = true;
  private boolean dQt = true;
  private boolean dQu = true;
  private boolean dQv = true;
  private boolean dQw = true;
  public byte[] field_extbuf;
  public String field_newStoryList;
  public long field_nextSyncTime;
  public String field_roomname;
  public int field_userStoryFlag;
  
  static
  {
    dQg = "userStoryFlag".hashCode();
    dQy = "newStoryList".hashCode();
    dQz = "extbuf".hashCode();
  }
  
  public static c.a Hm()
  {
    c.a locala = new c.a();
    locala.yrK = new Field[5];
    locala.columns = new String[6];
    StringBuilder localStringBuilder = new StringBuilder();
    locala.columns[0] = "roomname";
    locala.yrM.put("roomname", "TEXT default ''  PRIMARY KEY ");
    localStringBuilder.append(" roomname TEXT default ''  PRIMARY KEY ");
    localStringBuilder.append(", ");
    locala.yrL = "roomname";
    locala.columns[1] = "userStoryFlag";
    locala.yrM.put("userStoryFlag", "INTEGER");
    localStringBuilder.append(" userStoryFlag INTEGER");
    localStringBuilder.append(", ");
    locala.columns[2] = "newStoryList";
    locala.yrM.put("newStoryList", "TEXT");
    localStringBuilder.append(" newStoryList TEXT");
    localStringBuilder.append(", ");
    locala.columns[3] = "extbuf";
    locala.yrM.put("extbuf", "BLOB");
    localStringBuilder.append(" extbuf BLOB");
    localStringBuilder.append(", ");
    locala.columns[4] = "nextSyncTime";
    locala.yrM.put("nextSyncTime", "LONG");
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
      if (dQx != k) {
        break label65;
      }
      this.field_roomname = paramCursor.getString(i);
      this.dQt = true;
    }
    for (;;)
    {
      i += 1;
      break label20;
      break;
      label65:
      if (dQg == k) {
        this.field_userStoryFlag = paramCursor.getInt(i);
      } else if (dQy == k) {
        this.field_newStoryList = paramCursor.getString(i);
      } else if (dQz == k) {
        this.field_extbuf = paramCursor.getBlob(i);
      } else if (dQA == k) {
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
    if (this.dQt) {
      localContentValues.put("roomname", this.field_roomname);
    }
    if (this.dPT) {
      localContentValues.put("userStoryFlag", Integer.valueOf(this.field_userStoryFlag));
    }
    if (this.dQu) {
      localContentValues.put("newStoryList", this.field_newStoryList);
    }
    if (this.dQv) {
      localContentValues.put("extbuf", this.field_extbuf);
    }
    if (this.dQw) {
      localContentValues.put("nextSyncTime", Long.valueOf(this.field_nextSyncTime));
    }
    if (this.systemRowid > 0L) {
      localContentValues.put("rowid", Long.valueOf(this.systemRowid));
    }
    return localContentValues;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.g.c.ex
 * JD-Core Version:    0.7.0.1
 */