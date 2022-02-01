package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.storage.IAutoDBItem;

public abstract class fn
  extends IAutoDBItem
{
  public static final String[] INDEX_CREATE = { "CREATE INDEX IF NOT EXISTS PushDuplicateLaunchWxaAppRespTableStartTimeIndex ON PredownloadIssueLaunchWxaAppResponse(startTime)", "CREATE INDEX IF NOT EXISTS PushDuplicateLaunchWxaAppRespTableEndTimeIndex ON PredownloadIssueLaunchWxaAppResponse(endTime)" };
  private static final int fVm = "launchProtoBlob".hashCode();
  private static final int fjQ;
  private static final int fjx = "startTime".hashCode();
  private static final int fjy = "endTime".hashCode();
  private static final int fkj = "appId".hashCode();
  private static final int flJ = "reportId".hashCode();
  private static final int rowid_HASHCODE = "rowid".hashCode();
  private boolean fVl = true;
  public String field_appId;
  public long field_endTime;
  public byte[] field_launchProtoBlob;
  public long field_reportId;
  public int field_scene;
  public long field_startTime;
  private boolean fjO = true;
  private boolean fjS = true;
  private boolean fjq = true;
  private boolean fjr = true;
  private boolean flE = true;
  
  static
  {
    fjQ = "scene".hashCode();
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
      if (fkj != k) {
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
      if (fjQ == k) {
        this.field_scene = paramCursor.getInt(i);
      } else if (fVm == k) {
        this.field_launchProtoBlob = paramCursor.getBlob(i);
      } else if (fjx == k) {
        this.field_startTime = paramCursor.getLong(i);
      } else if (fjy == k) {
        this.field_endTime = paramCursor.getLong(i);
      } else if (flJ == k) {
        this.field_reportId = paramCursor.getLong(i);
      } else if (rowid_HASHCODE == k) {
        this.systemRowid = paramCursor.getLong(i);
      }
    }
  }
  
  public ContentValues convertTo()
  {
    ContentValues localContentValues = new ContentValues();
    if (this.fjS) {
      localContentValues.put("appId", this.field_appId);
    }
    if (this.fjO) {
      localContentValues.put("scene", Integer.valueOf(this.field_scene));
    }
    if (this.fVl) {
      localContentValues.put("launchProtoBlob", this.field_launchProtoBlob);
    }
    if (this.fjq) {
      localContentValues.put("startTime", Long.valueOf(this.field_startTime));
    }
    if (this.fjr) {
      localContentValues.put("endTime", Long.valueOf(this.field_endTime));
    }
    if (this.flE) {
      localContentValues.put("reportId", Long.valueOf(this.field_reportId));
    }
    if (this.systemRowid > 0L) {
      localContentValues.put("rowid", Long.valueOf(this.systemRowid));
    }
    return localContentValues;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.g.c.fn
 * JD-Core Version:    0.7.0.1
 */