package com.tencent.mm.h.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;

public abstract class di
  extends c
{
  private static final int cTQ = "sceneList".hashCode();
  private static final int cTR = "cgiList".hashCode();
  private static final int cTS = "reportId".hashCode();
  public static final String[] cqY = { "CREATE INDEX IF NOT EXISTS PredownloadBlockCgiRequestAppIDIndex ON PredownloadBlockCgiRequest(appId)", "CREATE INDEX IF NOT EXISTS PredownloadBlockCgiRequestStartTimeIndex ON PredownloadBlockCgiRequest(startTime)", "CREATE INDEX IF NOT EXISTS PredownloadBlockCgiRequestEndTimeIndex ON PredownloadBlockCgiRequest(endTime)" };
  private static final int crB;
  private static final int crC;
  private static final int crh = "rowid".hashCode();
  private static final int ctF = "username".hashCode();
  private static final int ctl = "appId".hashCode();
  private boolean cTN = true;
  private boolean cTO = true;
  private boolean cTP = true;
  private boolean crt = true;
  private boolean cru = true;
  private boolean csU = true;
  private boolean ctD = true;
  public String field_appId;
  public String field_cgiList;
  public long field_endTime;
  public int field_reportId;
  public String field_sceneList;
  public long field_startTime;
  public String field_username;
  
  static
  {
    crB = "startTime".hashCode();
    crC = "endTime".hashCode();
  }
  
  public final void d(Cursor paramCursor)
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
      if (ctF != k) {
        break label65;
      }
      this.field_username = paramCursor.getString(i);
      this.ctD = true;
    }
    for (;;)
    {
      i += 1;
      break label20;
      break;
      label65:
      if (ctl == k) {
        this.field_appId = paramCursor.getString(i);
      } else if (crB == k) {
        this.field_startTime = paramCursor.getLong(i);
      } else if (crC == k) {
        this.field_endTime = paramCursor.getLong(i);
      } else if (cTQ == k) {
        this.field_sceneList = paramCursor.getString(i);
      } else if (cTR == k) {
        this.field_cgiList = paramCursor.getString(i);
      } else if (cTS == k) {
        this.field_reportId = paramCursor.getInt(i);
      } else if (crh == k) {
        this.ujK = paramCursor.getLong(i);
      }
    }
  }
  
  public final ContentValues vf()
  {
    ContentValues localContentValues = new ContentValues();
    if (this.ctD) {
      localContentValues.put("username", this.field_username);
    }
    if (this.csU) {
      localContentValues.put("appId", this.field_appId);
    }
    if (this.crt) {
      localContentValues.put("startTime", Long.valueOf(this.field_startTime));
    }
    if (this.cru) {
      localContentValues.put("endTime", Long.valueOf(this.field_endTime));
    }
    if (this.cTN) {
      localContentValues.put("sceneList", this.field_sceneList);
    }
    if (this.cTO) {
      localContentValues.put("cgiList", this.field_cgiList);
    }
    if (this.cTP) {
      localContentValues.put("reportId", Integer.valueOf(this.field_reportId));
    }
    if (this.ujK > 0L) {
      localContentValues.put("rowid", Long.valueOf(this.ujK));
    }
    return localContentValues;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.h.c.di
 * JD-Core Version:    0.7.0.1
 */