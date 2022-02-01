package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.storage.IAutoDBItem;

public abstract class fk
  extends IAutoDBItem
{
  public static final String[] INDEX_CREATE = { "CREATE INDEX IF NOT EXISTS PredownloadBlockCgiRequestAppIDIndex ON PredownloadBlockCgiRequest(appId)", "CREATE INDEX IF NOT EXISTS PredownloadBlockCgiRequestStartTimeIndex ON PredownloadBlockCgiRequest(startTime)", "CREATE INDEX IF NOT EXISTS PredownloadBlockCgiRequestEndTimeIndex ON PredownloadBlockCgiRequest(endTime)" };
  private static final int fUR = "sceneList".hashCode();
  private static final int fUS = "cgiList".hashCode();
  private static final int fjx;
  private static final int fjy;
  private static final int fkj;
  private static final int flJ = "reportId".hashCode();
  private static final int rowid_HASHCODE = "rowid".hashCode();
  private static final int username_HASHCODE = "username".hashCode();
  private boolean __hadSetusername = true;
  private boolean fUP = true;
  private boolean fUQ = true;
  public String field_appId;
  public String field_cgiList;
  public long field_endTime;
  public int field_reportId;
  public String field_sceneList;
  public long field_startTime;
  public String field_username;
  private boolean fjS = true;
  private boolean fjq = true;
  private boolean fjr = true;
  private boolean flE = true;
  
  static
  {
    fkj = "appId".hashCode();
    fjx = "startTime".hashCode();
    fjy = "endTime".hashCode();
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
      if (username_HASHCODE != k) {
        break label65;
      }
      this.field_username = paramCursor.getString(i);
      this.__hadSetusername = true;
    }
    for (;;)
    {
      i += 1;
      break label20;
      break;
      label65:
      if (fkj == k) {
        this.field_appId = paramCursor.getString(i);
      } else if (fjx == k) {
        this.field_startTime = paramCursor.getLong(i);
      } else if (fjy == k) {
        this.field_endTime = paramCursor.getLong(i);
      } else if (fUR == k) {
        this.field_sceneList = paramCursor.getString(i);
      } else if (fUS == k) {
        this.field_cgiList = paramCursor.getString(i);
      } else if (flJ == k) {
        this.field_reportId = paramCursor.getInt(i);
      } else if (rowid_HASHCODE == k) {
        this.systemRowid = paramCursor.getLong(i);
      }
    }
  }
  
  public ContentValues convertTo()
  {
    ContentValues localContentValues = new ContentValues();
    if (this.__hadSetusername) {
      localContentValues.put("username", this.field_username);
    }
    if (this.fjS) {
      localContentValues.put("appId", this.field_appId);
    }
    if (this.fjq) {
      localContentValues.put("startTime", Long.valueOf(this.field_startTime));
    }
    if (this.fjr) {
      localContentValues.put("endTime", Long.valueOf(this.field_endTime));
    }
    if (this.fUP) {
      localContentValues.put("sceneList", this.field_sceneList);
    }
    if (this.fUQ) {
      localContentValues.put("cgiList", this.field_cgiList);
    }
    if (this.flE) {
      localContentValues.put("reportId", Integer.valueOf(this.field_reportId));
    }
    if (this.systemRowid > 0L) {
      localContentValues.put("rowid", Long.valueOf(this.systemRowid));
    }
    return localContentValues;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.g.c.fk
 * JD-Core Version:    0.7.0.1
 */