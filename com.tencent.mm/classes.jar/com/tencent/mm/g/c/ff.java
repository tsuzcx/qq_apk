package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;

public abstract class ff
  extends c
{
  public static final String[] INDEX_CREATE = { "CREATE INDEX IF NOT EXISTS PushDuplicateLaunchWxaAppRespTableStartTimeIndex ON PredownloadIssueLaunchWxaAppResponse(startTime)", "CREATE INDEX IF NOT EXISTS PushDuplicateLaunchWxaAppRespTableEndTimeIndex ON PredownloadIssueLaunchWxaAppResponse(endTime)" };
  private static final int eDo = "startTime".hashCode();
  private static final int eDp = "endTime".hashCode();
  private static final int eEB;
  private static final int eEU = "appId".hashCode();
  private static final int eGy = "reportId".hashCode();
  private static final int foG;
  private static final int rowid_HASHCODE = "rowid".hashCode();
  private boolean eDh = true;
  private boolean eDi = true;
  private boolean eED = true;
  private boolean eEz = true;
  private boolean eGt = true;
  public String field_appId;
  public long field_endTime;
  public byte[] field_launchProtoBlob;
  public long field_reportId;
  public int field_scene;
  public long field_startTime;
  private boolean foF = true;
  
  static
  {
    eEB = "scene".hashCode();
    foG = "launchProtoBlob".hashCode();
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
      if (eEU != k) {
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
      if (eEB == k) {
        this.field_scene = paramCursor.getInt(i);
      } else if (foG == k) {
        this.field_launchProtoBlob = paramCursor.getBlob(i);
      } else if (eDo == k) {
        this.field_startTime = paramCursor.getLong(i);
      } else if (eDp == k) {
        this.field_endTime = paramCursor.getLong(i);
      } else if (eGy == k) {
        this.field_reportId = paramCursor.getLong(i);
      } else if (rowid_HASHCODE == k) {
        this.systemRowid = paramCursor.getLong(i);
      }
    }
  }
  
  public ContentValues convertTo()
  {
    ContentValues localContentValues = new ContentValues();
    if (this.eED) {
      localContentValues.put("appId", this.field_appId);
    }
    if (this.eEz) {
      localContentValues.put("scene", Integer.valueOf(this.field_scene));
    }
    if (this.foF) {
      localContentValues.put("launchProtoBlob", this.field_launchProtoBlob);
    }
    if (this.eDh) {
      localContentValues.put("startTime", Long.valueOf(this.field_startTime));
    }
    if (this.eDi) {
      localContentValues.put("endTime", Long.valueOf(this.field_endTime));
    }
    if (this.eGt) {
      localContentValues.put("reportId", Long.valueOf(this.field_reportId));
    }
    if (this.systemRowid > 0L) {
      localContentValues.put("rowid", Long.valueOf(this.systemRowid));
    }
    return localContentValues;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.g.c.ff
 * JD-Core Version:    0.7.0.1
 */