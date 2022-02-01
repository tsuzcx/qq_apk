package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;

public abstract class es
  extends c
{
  public static final String[] INDEX_CREATE = { "CREATE INDEX IF NOT EXISTS PredownloadBlockCgiRequestAppIDIndex ON PredownloadBlockCgiRequest(appId)", "CREATE INDEX IF NOT EXISTS PredownloadBlockCgiRequestStartTimeIndex ON PredownloadBlockCgiRequest(startTime)", "CREATE INDEX IF NOT EXISTS PredownloadBlockCgiRequestEndTimeIndex ON PredownloadBlockCgiRequest(endTime)" };
  private static final int eVW = "sceneList".hashCode();
  private static final int eVX = "cgiList".hashCode();
  private static final int emh;
  private static final int emi;
  private static final int enO;
  private static final int eok = "username".hashCode();
  private static final int epp = "reportId".hashCode();
  private static final int rowid_HASHCODE = "rowid".hashCode();
  private boolean eVU = true;
  private boolean eVV = true;
  private boolean ema = true;
  private boolean emb = true;
  private boolean enx = true;
  private boolean eoh = true;
  private boolean epk = true;
  public String field_appId;
  public String field_cgiList;
  public long field_endTime;
  public int field_reportId;
  public String field_sceneList;
  public long field_startTime;
  public String field_username;
  
  static
  {
    enO = "appId".hashCode();
    emh = "startTime".hashCode();
    emi = "endTime".hashCode();
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
      if (eok != k) {
        break label65;
      }
      this.field_username = paramCursor.getString(i);
      this.eoh = true;
    }
    for (;;)
    {
      i += 1;
      break label20;
      break;
      label65:
      if (enO == k) {
        this.field_appId = paramCursor.getString(i);
      } else if (emh == k) {
        this.field_startTime = paramCursor.getLong(i);
      } else if (emi == k) {
        this.field_endTime = paramCursor.getLong(i);
      } else if (eVW == k) {
        this.field_sceneList = paramCursor.getString(i);
      } else if (eVX == k) {
        this.field_cgiList = paramCursor.getString(i);
      } else if (epp == k) {
        this.field_reportId = paramCursor.getInt(i);
      } else if (rowid_HASHCODE == k) {
        this.systemRowid = paramCursor.getLong(i);
      }
    }
  }
  
  public ContentValues convertTo()
  {
    ContentValues localContentValues = new ContentValues();
    if (this.eoh) {
      localContentValues.put("username", this.field_username);
    }
    if (this.enx) {
      localContentValues.put("appId", this.field_appId);
    }
    if (this.ema) {
      localContentValues.put("startTime", Long.valueOf(this.field_startTime));
    }
    if (this.emb) {
      localContentValues.put("endTime", Long.valueOf(this.field_endTime));
    }
    if (this.eVU) {
      localContentValues.put("sceneList", this.field_sceneList);
    }
    if (this.eVV) {
      localContentValues.put("cgiList", this.field_cgiList);
    }
    if (this.epk) {
      localContentValues.put("reportId", Integer.valueOf(this.field_reportId));
    }
    if (this.systemRowid > 0L) {
      localContentValues.put("rowid", Long.valueOf(this.systemRowid));
    }
    return localContentValues;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.g.c.es
 * JD-Core Version:    0.7.0.1
 */