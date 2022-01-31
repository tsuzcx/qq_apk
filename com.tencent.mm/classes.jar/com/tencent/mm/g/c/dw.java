package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;

public abstract class dw
  extends c
{
  public static final String[] INDEX_CREATE = { "CREATE INDEX IF NOT EXISTS PushDuplicateLaunchWxaAppRespTableStartTimeIndex ON PredownloadIssueLaunchWxaAppResponse(startTime)", "CREATE INDEX IF NOT EXISTS PushDuplicateLaunchWxaAppRespTableEndTimeIndex ON PredownloadIssueLaunchWxaAppResponse(endTime)" };
  private static final int dKo = "launchProtoBlob".hashCode();
  private static final int dfV = "startTime".hashCode();
  private static final int dfW = "endTime".hashCode();
  private static final int dhB = "appId".hashCode();
  private static final int dhi = "scene".hashCode();
  private static final int diM = "reportId".hashCode();
  private static final int rowid_HASHCODE = "rowid".hashCode();
  private boolean dKn = true;
  private boolean dfO = true;
  private boolean dfP = true;
  private boolean dhg = true;
  private boolean dhk = true;
  private boolean diJ = true;
  public String field_appId;
  public long field_endTime;
  public byte[] field_launchProtoBlob;
  public long field_reportId;
  public int field_scene;
  public long field_startTime;
  
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
      if (dhB != k) {
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
      if (dhi == k) {
        this.field_scene = paramCursor.getInt(i);
      } else if (dKo == k) {
        this.field_launchProtoBlob = paramCursor.getBlob(i);
      } else if (dfV == k) {
        this.field_startTime = paramCursor.getLong(i);
      } else if (dfW == k) {
        this.field_endTime = paramCursor.getLong(i);
      } else if (diM == k) {
        this.field_reportId = paramCursor.getLong(i);
      } else if (rowid_HASHCODE == k) {
        this.systemRowid = paramCursor.getLong(i);
      }
    }
  }
  
  public ContentValues convertTo()
  {
    ContentValues localContentValues = new ContentValues();
    if (this.dhk) {
      localContentValues.put("appId", this.field_appId);
    }
    if (this.dhg) {
      localContentValues.put("scene", Integer.valueOf(this.field_scene));
    }
    if (this.dKn) {
      localContentValues.put("launchProtoBlob", this.field_launchProtoBlob);
    }
    if (this.dfO) {
      localContentValues.put("startTime", Long.valueOf(this.field_startTime));
    }
    if (this.dfP) {
      localContentValues.put("endTime", Long.valueOf(this.field_endTime));
    }
    if (this.diJ) {
      localContentValues.put("reportId", Long.valueOf(this.field_reportId));
    }
    if (this.systemRowid > 0L) {
      localContentValues.put("rowid", Long.valueOf(this.systemRowid));
    }
    return localContentValues;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.g.c.dw
 * JD-Core Version:    0.7.0.1
 */