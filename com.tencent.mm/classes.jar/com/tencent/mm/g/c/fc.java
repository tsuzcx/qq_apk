package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;

public abstract class fc
  extends c
{
  public static final String[] INDEX_CREATE = { "CREATE INDEX IF NOT EXISTS PredownloadBlockCgiRequestAppIDIndex ON PredownloadBlockCgiRequest(appId)", "CREATE INDEX IF NOT EXISTS PredownloadBlockCgiRequestStartTimeIndex ON PredownloadBlockCgiRequest(startTime)", "CREATE INDEX IF NOT EXISTS PredownloadBlockCgiRequestEndTimeIndex ON PredownloadBlockCgiRequest(endTime)" };
  private static final int eDo;
  private static final int eDp;
  private static final int eEU;
  private static final int eFp = "username".hashCode();
  private static final int eGy = "reportId".hashCode();
  private static final int fol;
  private static final int fom;
  private static final int rowid_HASHCODE = "rowid".hashCode();
  private boolean eDh = true;
  private boolean eDi = true;
  private boolean eED = true;
  private boolean eFm = true;
  private boolean eGt = true;
  public String field_appId;
  public String field_cgiList;
  public long field_endTime;
  public int field_reportId;
  public String field_sceneList;
  public long field_startTime;
  public String field_username;
  private boolean foj = true;
  private boolean fok = true;
  
  static
  {
    eEU = "appId".hashCode();
    eDo = "startTime".hashCode();
    eDp = "endTime".hashCode();
    fol = "sceneList".hashCode();
    fom = "cgiList".hashCode();
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
      if (eFp != k) {
        break label65;
      }
      this.field_username = paramCursor.getString(i);
      this.eFm = true;
    }
    for (;;)
    {
      i += 1;
      break label20;
      break;
      label65:
      if (eEU == k) {
        this.field_appId = paramCursor.getString(i);
      } else if (eDo == k) {
        this.field_startTime = paramCursor.getLong(i);
      } else if (eDp == k) {
        this.field_endTime = paramCursor.getLong(i);
      } else if (fol == k) {
        this.field_sceneList = paramCursor.getString(i);
      } else if (fom == k) {
        this.field_cgiList = paramCursor.getString(i);
      } else if (eGy == k) {
        this.field_reportId = paramCursor.getInt(i);
      } else if (rowid_HASHCODE == k) {
        this.systemRowid = paramCursor.getLong(i);
      }
    }
  }
  
  public ContentValues convertTo()
  {
    ContentValues localContentValues = new ContentValues();
    if (this.eFm) {
      localContentValues.put("username", this.field_username);
    }
    if (this.eED) {
      localContentValues.put("appId", this.field_appId);
    }
    if (this.eDh) {
      localContentValues.put("startTime", Long.valueOf(this.field_startTime));
    }
    if (this.eDi) {
      localContentValues.put("endTime", Long.valueOf(this.field_endTime));
    }
    if (this.foj) {
      localContentValues.put("sceneList", this.field_sceneList);
    }
    if (this.fok) {
      localContentValues.put("cgiList", this.field_cgiList);
    }
    if (this.eGt) {
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