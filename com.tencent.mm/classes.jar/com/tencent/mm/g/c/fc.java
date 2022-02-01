package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;

public abstract class fc
  extends c
{
  public static final String[] INDEX_CREATE = { "CREATE INDEX IF NOT EXISTS PredownloadBlockCgiRequestAppIDIndex ON PredownloadBlockCgiRequest(appId)", "CREATE INDEX IF NOT EXISTS PredownloadBlockCgiRequestStartTimeIndex ON PredownloadBlockCgiRequest(startTime)", "CREATE INDEX IF NOT EXISTS PredownloadBlockCgiRequestEndTimeIndex ON PredownloadBlockCgiRequest(endTime)" };
  private static final int eEX;
  private static final int eEY;
  private static final int eGD;
  private static final int eGY = "username".hashCode();
  private static final int eIh = "reportId".hashCode();
  private static final int fqm;
  private static final int fqn;
  private static final int rowid_HASHCODE = "rowid".hashCode();
  private boolean eEQ = true;
  private boolean eER = true;
  private boolean eGV = true;
  private boolean eGm = true;
  private boolean eIc = true;
  public String field_appId;
  public String field_cgiList;
  public long field_endTime;
  public int field_reportId;
  public String field_sceneList;
  public long field_startTime;
  public String field_username;
  private boolean fqk = true;
  private boolean fql = true;
  
  static
  {
    eGD = "appId".hashCode();
    eEX = "startTime".hashCode();
    eEY = "endTime".hashCode();
    fqm = "sceneList".hashCode();
    fqn = "cgiList".hashCode();
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
      if (eGY != k) {
        break label65;
      }
      this.field_username = paramCursor.getString(i);
      this.eGV = true;
    }
    for (;;)
    {
      i += 1;
      break label20;
      break;
      label65:
      if (eGD == k) {
        this.field_appId = paramCursor.getString(i);
      } else if (eEX == k) {
        this.field_startTime = paramCursor.getLong(i);
      } else if (eEY == k) {
        this.field_endTime = paramCursor.getLong(i);
      } else if (fqm == k) {
        this.field_sceneList = paramCursor.getString(i);
      } else if (fqn == k) {
        this.field_cgiList = paramCursor.getString(i);
      } else if (eIh == k) {
        this.field_reportId = paramCursor.getInt(i);
      } else if (rowid_HASHCODE == k) {
        this.systemRowid = paramCursor.getLong(i);
      }
    }
  }
  
  public ContentValues convertTo()
  {
    ContentValues localContentValues = new ContentValues();
    if (this.eGV) {
      localContentValues.put("username", this.field_username);
    }
    if (this.eGm) {
      localContentValues.put("appId", this.field_appId);
    }
    if (this.eEQ) {
      localContentValues.put("startTime", Long.valueOf(this.field_startTime));
    }
    if (this.eER) {
      localContentValues.put("endTime", Long.valueOf(this.field_endTime));
    }
    if (this.fqk) {
      localContentValues.put("sceneList", this.field_sceneList);
    }
    if (this.fql) {
      localContentValues.put("cgiList", this.field_cgiList);
    }
    if (this.eIc) {
      localContentValues.put("reportId", Integer.valueOf(this.field_reportId));
    }
    if (this.systemRowid > 0L) {
      localContentValues.put("rowid", Long.valueOf(this.systemRowid));
    }
    return localContentValues;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.g.c.fc
 * JD-Core Version:    0.7.0.1
 */