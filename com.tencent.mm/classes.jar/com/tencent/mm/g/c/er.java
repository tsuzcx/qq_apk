package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;

public abstract class er
  extends c
{
  public static final String[] INDEX_CREATE = { "CREATE INDEX IF NOT EXISTS PushDuplicateLaunchWxaAppRespTableStartTimeIndex ON PredownloadIssueLaunchWxaAppResponse(startTime)", "CREATE INDEX IF NOT EXISTS PushDuplicateLaunchWxaAppRespTableEndTimeIndex ON PredownloadIssueLaunchWxaAppResponse(endTime)" };
  private static final int eTh = "launchProtoBlob".hashCode();
  private static final int ekd = "startTime".hashCode();
  private static final int eke = "endTime".hashCode();
  private static final int elJ = "appId".hashCode();
  private static final int elq = "scene".hashCode();
  private static final int enk = "reportId".hashCode();
  private static final int rowid_HASHCODE = "rowid".hashCode();
  private boolean eTg = true;
  private boolean ejW = true;
  private boolean ejX = true;
  private boolean elo = true;
  private boolean els = true;
  private boolean enf = true;
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
      if (elJ != k) {
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
      if (elq == k) {
        this.field_scene = paramCursor.getInt(i);
      } else if (eTh == k) {
        this.field_launchProtoBlob = paramCursor.getBlob(i);
      } else if (ekd == k) {
        this.field_startTime = paramCursor.getLong(i);
      } else if (eke == k) {
        this.field_endTime = paramCursor.getLong(i);
      } else if (enk == k) {
        this.field_reportId = paramCursor.getLong(i);
      } else if (rowid_HASHCODE == k) {
        this.systemRowid = paramCursor.getLong(i);
      }
    }
  }
  
  public ContentValues convertTo()
  {
    ContentValues localContentValues = new ContentValues();
    if (this.els) {
      localContentValues.put("appId", this.field_appId);
    }
    if (this.elo) {
      localContentValues.put("scene", Integer.valueOf(this.field_scene));
    }
    if (this.eTg) {
      localContentValues.put("launchProtoBlob", this.field_launchProtoBlob);
    }
    if (this.ejW) {
      localContentValues.put("startTime", Long.valueOf(this.field_startTime));
    }
    if (this.ejX) {
      localContentValues.put("endTime", Long.valueOf(this.field_endTime));
    }
    if (this.enf) {
      localContentValues.put("reportId", Long.valueOf(this.field_reportId));
    }
    if (this.systemRowid > 0L) {
      localContentValues.put("rowid", Long.valueOf(this.systemRowid));
    }
    return localContentValues;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.g.c.er
 * JD-Core Version:    0.7.0.1
 */