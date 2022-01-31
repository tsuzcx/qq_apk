package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;

public abstract class dt
  extends c
{
  public static final String[] INDEX_CREATE = { "CREATE INDEX IF NOT EXISTS PredownloadBlockCgiRequestAppIDIndex ON PredownloadBlockCgiRequest(appId)", "CREATE INDEX IF NOT EXISTS PredownloadBlockCgiRequestStartTimeIndex ON PredownloadBlockCgiRequest(startTime)", "CREATE INDEX IF NOT EXISTS PredownloadBlockCgiRequestEndTimeIndex ON PredownloadBlockCgiRequest(endTime)" };
  private static final int dJX = "sceneList".hashCode();
  private static final int dJY = "cgiList".hashCode();
  private static final int dfV;
  private static final int dfW;
  private static final int dhB;
  private static final int dhU = "username".hashCode();
  private static final int diM = "reportId".hashCode();
  private static final int rowid_HASHCODE = "rowid".hashCode();
  private boolean dJV = true;
  private boolean dJW = true;
  private boolean dfO = true;
  private boolean dfP = true;
  private boolean dhS = true;
  private boolean dhk = true;
  private boolean diJ = true;
  public String field_appId;
  public String field_cgiList;
  public long field_endTime;
  public int field_reportId;
  public String field_sceneList;
  public long field_startTime;
  public String field_username;
  
  static
  {
    dhB = "appId".hashCode();
    dfV = "startTime".hashCode();
    dfW = "endTime".hashCode();
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
      if (dhU != k) {
        break label65;
      }
      this.field_username = paramCursor.getString(i);
      this.dhS = true;
    }
    for (;;)
    {
      i += 1;
      break label20;
      break;
      label65:
      if (dhB == k) {
        this.field_appId = paramCursor.getString(i);
      } else if (dfV == k) {
        this.field_startTime = paramCursor.getLong(i);
      } else if (dfW == k) {
        this.field_endTime = paramCursor.getLong(i);
      } else if (dJX == k) {
        this.field_sceneList = paramCursor.getString(i);
      } else if (dJY == k) {
        this.field_cgiList = paramCursor.getString(i);
      } else if (diM == k) {
        this.field_reportId = paramCursor.getInt(i);
      } else if (rowid_HASHCODE == k) {
        this.systemRowid = paramCursor.getLong(i);
      }
    }
  }
  
  public ContentValues convertTo()
  {
    ContentValues localContentValues = new ContentValues();
    if (this.dhS) {
      localContentValues.put("username", this.field_username);
    }
    if (this.dhk) {
      localContentValues.put("appId", this.field_appId);
    }
    if (this.dfO) {
      localContentValues.put("startTime", Long.valueOf(this.field_startTime));
    }
    if (this.dfP) {
      localContentValues.put("endTime", Long.valueOf(this.field_endTime));
    }
    if (this.dJV) {
      localContentValues.put("sceneList", this.field_sceneList);
    }
    if (this.dJW) {
      localContentValues.put("cgiList", this.field_cgiList);
    }
    if (this.diJ) {
      localContentValues.put("reportId", Integer.valueOf(this.field_reportId));
    }
    if (this.systemRowid > 0L) {
      localContentValues.put("rowid", Long.valueOf(this.systemRowid));
    }
    return localContentValues;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.g.c.dt
 * JD-Core Version:    0.7.0.1
 */