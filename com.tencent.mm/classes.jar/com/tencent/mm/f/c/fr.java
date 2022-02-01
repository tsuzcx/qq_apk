package com.tencent.mm.f.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.storage.IAutoDBItem;
import com.tencent.mm.sdk.storage.sql.Column;
import com.tencent.mm.sdk.storage.sql.SingleTable;

public abstract class fr
  extends IAutoDBItem
{
  public static final Column C_ROWID;
  public static final Column C_USERNAME;
  public static final String[] INDEX_CREATE = { "CREATE INDEX IF NOT EXISTS PredownloadBlockCgiRequestAppIDIndex ON PredownloadBlockCgiRequest(appId)", "CREATE INDEX IF NOT EXISTS PredownloadBlockCgiRequestStartTimeIndex ON PredownloadBlockCgiRequest(startTime)", "CREATE INDEX IF NOT EXISTS PredownloadBlockCgiRequestEndTimeIndex ON PredownloadBlockCgiRequest(endTime)" };
  public static final SingleTable TABLE = new SingleTable("PredownloadBlockCgiRequest");
  public static final Column hmH;
  public static final Column hmI;
  private static final int hmV;
  private static final int hmW;
  public static final Column hnz;
  private static final int hoh;
  public static final Column hqc;
  private static final int hqm = "reportId".hashCode();
  public static final Column irk;
  public static final Column irl;
  private static final int iro;
  private static final int irp;
  private static final int rowid_HASHCODE = "rowid".hashCode();
  private static final int username_HASHCODE;
  private boolean __hadSetusername = true;
  public String field_appId;
  public String field_cgiList;
  public long field_endTime;
  public int field_reportId;
  public String field_sceneList;
  public long field_startTime;
  public String field_username;
  private boolean hmO = true;
  private boolean hmP = true;
  private boolean hnQ = true;
  private boolean hqh = true;
  private boolean irm = true;
  private boolean irn = true;
  
  static
  {
    C_ROWID = new Column("rowid", "long", "PredownloadBlockCgiRequest", "");
    C_USERNAME = new Column("username", "string", "PredownloadBlockCgiRequest", "");
    hnz = new Column("appid", "string", "PredownloadBlockCgiRequest", "");
    hmH = new Column("starttime", "long", "PredownloadBlockCgiRequest", "");
    hmI = new Column("endtime", "long", "PredownloadBlockCgiRequest", "");
    irk = new Column("scenelist", "string", "PredownloadBlockCgiRequest", "");
    irl = new Column("cgilist", "string", "PredownloadBlockCgiRequest", "");
    hqc = new Column("reportid", "int", "PredownloadBlockCgiRequest", "");
    username_HASHCODE = "username".hashCode();
    hoh = "appId".hashCode();
    hmV = "startTime".hashCode();
    hmW = "endTime".hashCode();
    iro = "sceneList".hashCode();
    irp = "cgiList".hashCode();
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
      if (username_HASHCODE != k) {
        break label65;
      }
      this.field_username = paramCursor.getString(i);
      this.__hadSetusername = true;
    }
    for (;;)
    {
      i += 1;
      break label20;
      break;
      label65:
      if (hoh == k) {
        this.field_appId = paramCursor.getString(i);
      } else if (hmV == k) {
        this.field_startTime = paramCursor.getLong(i);
      } else if (hmW == k) {
        this.field_endTime = paramCursor.getLong(i);
      } else if (iro == k) {
        this.field_sceneList = paramCursor.getString(i);
      } else if (irp == k) {
        this.field_cgiList = paramCursor.getString(i);
      } else if (hqm == k) {
        this.field_reportId = paramCursor.getInt(i);
      } else if (rowid_HASHCODE == k) {
        this.systemRowid = paramCursor.getLong(i);
      }
    }
  }
  
  public ContentValues convertTo()
  {
    ContentValues localContentValues = new ContentValues();
    if (this.__hadSetusername) {
      localContentValues.put("username", this.field_username);
    }
    if (this.hnQ) {
      localContentValues.put("appId", this.field_appId);
    }
    if (this.hmO) {
      localContentValues.put("startTime", Long.valueOf(this.field_startTime));
    }
    if (this.hmP) {
      localContentValues.put("endTime", Long.valueOf(this.field_endTime));
    }
    if (this.irm) {
      localContentValues.put("sceneList", this.field_sceneList);
    }
    if (this.irn) {
      localContentValues.put("cgiList", this.field_cgiList);
    }
    if (this.hqh) {
      localContentValues.put("reportId", Integer.valueOf(this.field_reportId));
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
    return "PredownloadBlockCgiRequest";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.f.c.fr
 * JD-Core Version:    0.7.0.1
 */