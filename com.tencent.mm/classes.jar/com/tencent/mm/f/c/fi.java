package com.tencent.mm.f.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.storage.IAutoDBItem;
import com.tencent.mm.sdk.storage.sql.Column;
import com.tencent.mm.sdk.storage.sql.SingleTable;

public abstract class fi
  extends IAutoDBItem
{
  public static final Column C_ROWID;
  public static final String[] INDEX_CREATE = new String[0];
  public static final SingleTable TABLE = new SingleTable("OpenMsgListener");
  private static final int hmC = "status".hashCode();
  public static final Column hmw;
  public static final Column hnz;
  private static final int hoh;
  public static final Column hqs;
  private static final int hrk;
  private static final int iqA = "sceneFlag".hashCode();
  private static final int iqB = "msgTypeFlag".hashCode();
  private static final int iqC = "msgState".hashCode();
  public static final Column iqu;
  public static final Column iqv;
  public static final Column iqw;
  private static final int rowid_HASHCODE = "rowid".hashCode();
  public String field_appId;
  public int field_msgState;
  public int field_msgTypeFlag;
  public String field_packageName;
  public int field_sceneFlag;
  public int field_status;
  private boolean hmz = true;
  private boolean hnQ = true;
  private boolean hqO = true;
  private boolean iqx = true;
  private boolean iqy = true;
  private boolean iqz = true;
  
  static
  {
    C_ROWID = new Column("rowid", "long", "OpenMsgListener", "");
    hnz = new Column("appid", "string", "OpenMsgListener", "");
    hqs = new Column("packagename", "string", "OpenMsgListener", "");
    hmw = new Column("status", "int", "OpenMsgListener", "");
    iqu = new Column("sceneflag", "int", "OpenMsgListener", "");
    iqv = new Column("msgtypeflag", "int", "OpenMsgListener", "");
    iqw = new Column("msgstate", "int", "OpenMsgListener", "");
    hoh = "appId".hashCode();
    hrk = "packageName".hashCode();
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
        break label65;
      }
      this.field_appId = paramCursor.getString(i);
      this.hnQ = true;
    }
    for (;;)
    {
      i += 1;
      break label20;
      break;
      label65:
      if (hrk == k) {
        this.field_packageName = paramCursor.getString(i);
      } else if (hmC == k) {
        this.field_status = paramCursor.getInt(i);
      } else if (iqA == k) {
        this.field_sceneFlag = paramCursor.getInt(i);
      } else if (iqB == k) {
        this.field_msgTypeFlag = paramCursor.getInt(i);
      } else if (iqC == k) {
        this.field_msgState = paramCursor.getInt(i);
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
    if (this.hqO) {
      localContentValues.put("packageName", this.field_packageName);
    }
    if (this.hmz) {
      localContentValues.put("status", Integer.valueOf(this.field_status));
    }
    if (this.iqx) {
      localContentValues.put("sceneFlag", Integer.valueOf(this.field_sceneFlag));
    }
    if (this.iqy) {
      localContentValues.put("msgTypeFlag", Integer.valueOf(this.field_msgTypeFlag));
    }
    if (this.iqz) {
      localContentValues.put("msgState", Integer.valueOf(this.field_msgState));
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
    return "OpenMsgListener";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.f.c.fi
 * JD-Core Version:    0.7.0.1
 */