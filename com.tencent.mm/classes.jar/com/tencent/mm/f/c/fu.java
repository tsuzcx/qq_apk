package com.tencent.mm.f.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.storage.IAutoDBItem;
import com.tencent.mm.sdk.storage.sql.Column;
import com.tencent.mm.sdk.storage.sql.SingleTable;

public abstract class fu
  extends IAutoDBItem
{
  public static final Column C_ROWID;
  public static final String[] INDEX_CREATE = { "CREATE INDEX IF NOT EXISTS PushDuplicateLaunchWxaAppRespTableStartTimeIndex ON PredownloadIssueLaunchWxaAppResponse(startTime)", "CREATE INDEX IF NOT EXISTS PushDuplicateLaunchWxaAppRespTableEndTimeIndex ON PredownloadIssueLaunchWxaAppResponse(endTime)" };
  public static final SingleTable TABLE = new SingleTable("PredownloadIssueLaunchWxaAppResponse");
  public static final Column hmH;
  public static final Column hmI;
  private static final int hmV = "startTime".hashCode();
  private static final int hmW = "endTime".hashCode();
  public static final Column hnt;
  private static final int hnx;
  public static final Column hnz;
  private static final int hoh;
  public static final Column hqc;
  private static final int hqm = "reportId".hashCode();
  public static final Column irR;
  private static final int irT;
  private static final int rowid_HASHCODE = "rowid".hashCode();
  public String field_appId;
  public long field_endTime;
  public byte[] field_launchProtoBlob;
  public long field_reportId;
  public int field_scene;
  public long field_startTime;
  private boolean hmO = true;
  private boolean hmP = true;
  private boolean hnQ = true;
  private boolean hnv = true;
  private boolean hqh = true;
  private boolean irS = true;
  
  static
  {
    C_ROWID = new Column("rowid", "long", "PredownloadIssueLaunchWxaAppResponse", "");
    hnz = new Column("appid", "string", "PredownloadIssueLaunchWxaAppResponse", "");
    hnt = new Column("scene", "int", "PredownloadIssueLaunchWxaAppResponse", "");
    irR = new Column("launchprotoblob", "byte[]", "PredownloadIssueLaunchWxaAppResponse", "");
    hmH = new Column("starttime", "long", "PredownloadIssueLaunchWxaAppResponse", "");
    hmI = new Column("endtime", "long", "PredownloadIssueLaunchWxaAppResponse", "");
    hqc = new Column("reportid", "long", "PredownloadIssueLaunchWxaAppResponse", "");
    hoh = "appId".hashCode();
    hnx = "scene".hashCode();
    irT = "launchProtoBlob".hashCode();
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
      if (hoh != k) {
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
      if (hnx == k) {
        this.field_scene = paramCursor.getInt(i);
      } else if (irT == k) {
        this.field_launchProtoBlob = paramCursor.getBlob(i);
      } else if (hmV == k) {
        this.field_startTime = paramCursor.getLong(i);
      } else if (hmW == k) {
        this.field_endTime = paramCursor.getLong(i);
      } else if (hqm == k) {
        this.field_reportId = paramCursor.getLong(i);
      } else if (rowid_HASHCODE == k) {
        this.systemRowid = paramCursor.getLong(i);
      }
    }
  }
  
  public ContentValues convertTo()
  {
    ContentValues localContentValues = new ContentValues();
    if (this.hnQ) {
      localContentValues.put("appId", this.field_appId);
    }
    if (this.hnv) {
      localContentValues.put("scene", Integer.valueOf(this.field_scene));
    }
    if (this.irS) {
      localContentValues.put("launchProtoBlob", this.field_launchProtoBlob);
    }
    if (this.hmO) {
      localContentValues.put("startTime", Long.valueOf(this.field_startTime));
    }
    if (this.hmP) {
      localContentValues.put("endTime", Long.valueOf(this.field_endTime));
    }
    if (this.hqh) {
      localContentValues.put("reportId", Long.valueOf(this.field_reportId));
    }
    if (this.systemRowid > 0L) {
      localContentValues.put("rowid", Long.valueOf(this.systemRowid));
    }
    return localContentValues;
  }
  
  public String[] getIndexCreateSQL()
  {
    return INDEX_CREATE;
  }
  
  public String getTableName()
  {
    return "PredownloadIssueLaunchWxaAppResponse";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.f.c.fu
 * JD-Core Version:    0.7.0.1
 */