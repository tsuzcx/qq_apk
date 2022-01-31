package com.tencent.mm.h.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;

public abstract class dl
  extends c
{
  private static final int cTS = "reportId".hashCode();
  private static final int cUi;
  public static final String[] cqY = { "CREATE INDEX IF NOT EXISTS PushDuplicateLaunchWxaAppRespTableStartTimeIndex ON PredownloadIssueLaunchWxaAppResponse(startTime)", "CREATE INDEX IF NOT EXISTS PushDuplicateLaunchWxaAppRespTableEndTimeIndex ON PredownloadIssueLaunchWxaAppResponse(endTime)" };
  private static final int crB;
  private static final int crC;
  private static final int crh = "rowid".hashCode();
  private static final int csS;
  private static final int ctl = "appId".hashCode();
  private boolean cTP = true;
  private boolean cUh = true;
  private boolean crt = true;
  private boolean cru = true;
  private boolean csQ = true;
  private boolean csU = true;
  public String field_appId;
  public long field_endTime;
  public byte[] field_launchProtoBlob;
  public long field_reportId;
  public int field_scene;
  public long field_startTime;
  
  static
  {
    csS = "scene".hashCode();
    cUi = "launchProtoBlob".hashCode();
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
      if (ctl != k) {
        break label60;
      }
      this.field_appId = paramCursor.getString(i);
    }
    for (;;)
    {
      i += 1;
      break label20;
      break;
      label60:
      if (csS == k) {
        this.field_scene = paramCursor.getInt(i);
      } else if (cUi == k) {
        this.field_launchProtoBlob = paramCursor.getBlob(i);
      } else if (crB == k) {
        this.field_startTime = paramCursor.getLong(i);
      } else if (crC == k) {
        this.field_endTime = paramCursor.getLong(i);
      } else if (cTS == k) {
        this.field_reportId = paramCursor.getLong(i);
      } else if (crh == k) {
        this.ujK = paramCursor.getLong(i);
      }
    }
  }
  
  public final ContentValues vf()
  {
    ContentValues localContentValues = new ContentValues();
    if (this.csU) {
      localContentValues.put("appId", this.field_appId);
    }
    if (this.csQ) {
      localContentValues.put("scene", Integer.valueOf(this.field_scene));
    }
    if (this.cUh) {
      localContentValues.put("launchProtoBlob", this.field_launchProtoBlob);
    }
    if (this.crt) {
      localContentValues.put("startTime", Long.valueOf(this.field_startTime));
    }
    if (this.cru) {
      localContentValues.put("endTime", Long.valueOf(this.field_endTime));
    }
    if (this.cTP) {
      localContentValues.put("reportId", Long.valueOf(this.field_reportId));
    }
    if (this.ujK > 0L) {
      localContentValues.put("rowid", Long.valueOf(this.ujK));
    }
    return localContentValues;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.h.c.dl
 * JD-Core Version:    0.7.0.1
 */