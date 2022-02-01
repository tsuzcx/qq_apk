package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;

public abstract class ev
  extends c
{
  public static final String[] INDEX_CREATE = { "CREATE INDEX IF NOT EXISTS PushDuplicateLaunchWxaAppRespTableStartTimeIndex ON PredownloadIssueLaunchWxaAppResponse(startTime)", "CREATE INDEX IF NOT EXISTS PushDuplicateLaunchWxaAppRespTableEndTimeIndex ON PredownloadIssueLaunchWxaAppResponse(endTime)" };
  private static final int eWr = "launchProtoBlob".hashCode();
  private static final int emh = "startTime".hashCode();
  private static final int emi = "endTime".hashCode();
  private static final int enO = "appId".hashCode();
  private static final int env = "scene".hashCode();
  private static final int epp = "reportId".hashCode();
  private static final int rowid_HASHCODE = "rowid".hashCode();
  private boolean eWq = true;
  private boolean ema = true;
  private boolean emb = true;
  private boolean ent = true;
  private boolean enx = true;
  private boolean epk = true;
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
      if (enO != k) {
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
      if (env == k) {
        this.field_scene = paramCursor.getInt(i);
      } else if (eWr == k) {
        this.field_launchProtoBlob = paramCursor.getBlob(i);
      } else if (emh == k) {
        this.field_startTime = paramCursor.getLong(i);
      } else if (emi == k) {
        this.field_endTime = paramCursor.getLong(i);
      } else if (epp == k) {
        this.field_reportId = paramCursor.getLong(i);
      } else if (rowid_HASHCODE == k) {
        this.systemRowid = paramCursor.getLong(i);
      }
    }
  }
  
  public ContentValues convertTo()
  {
    ContentValues localContentValues = new ContentValues();
    if (this.enx) {
      localContentValues.put("appId", this.field_appId);
    }
    if (this.ent) {
      localContentValues.put("scene", Integer.valueOf(this.field_scene));
    }
    if (this.eWq) {
      localContentValues.put("launchProtoBlob", this.field_launchProtoBlob);
    }
    if (this.ema) {
      localContentValues.put("startTime", Long.valueOf(this.field_startTime));
    }
    if (this.emb) {
      localContentValues.put("endTime", Long.valueOf(this.field_endTime));
    }
    if (this.epk) {
      localContentValues.put("reportId", Long.valueOf(this.field_reportId));
    }
    if (this.systemRowid > 0L) {
      localContentValues.put("rowid", Long.valueOf(this.systemRowid));
    }
    return localContentValues;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.g.c.ev
 * JD-Core Version:    0.7.0.1
 */