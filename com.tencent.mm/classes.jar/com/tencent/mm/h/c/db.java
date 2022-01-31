package com.tencent.mm.h.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;

public abstract class db
  extends c
{
  private static final int cTu = "sceneFlag".hashCode();
  private static final int cTv = "msgTypeFlag".hashCode();
  private static final int cTw = "msgState".hashCode();
  public static final String[] cqY = new String[0];
  private static final int crh = "rowid".hashCode();
  private static final int crn;
  private static final int ctl = "appId".hashCode();
  private static final int cve = "packageName".hashCode();
  private boolean cTr = true;
  private boolean cTs = true;
  private boolean cTt = true;
  private boolean crk = true;
  private boolean csU = true;
  private boolean cuH = true;
  public String field_appId;
  public int field_msgState;
  public int field_msgTypeFlag;
  public String field_packageName;
  public int field_sceneFlag;
  public int field_status;
  
  static
  {
    crn = "status".hashCode();
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
        break label65;
      }
      this.field_appId = paramCursor.getString(i);
      this.csU = true;
    }
    for (;;)
    {
      i += 1;
      break label20;
      break;
      label65:
      if (cve == k) {
        this.field_packageName = paramCursor.getString(i);
      } else if (crn == k) {
        this.field_status = paramCursor.getInt(i);
      } else if (cTu == k) {
        this.field_sceneFlag = paramCursor.getInt(i);
      } else if (cTv == k) {
        this.field_msgTypeFlag = paramCursor.getInt(i);
      } else if (cTw == k) {
        this.field_msgState = paramCursor.getInt(i);
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
    if (this.cuH) {
      localContentValues.put("packageName", this.field_packageName);
    }
    if (this.crk) {
      localContentValues.put("status", Integer.valueOf(this.field_status));
    }
    if (this.cTr) {
      localContentValues.put("sceneFlag", Integer.valueOf(this.field_sceneFlag));
    }
    if (this.cTs) {
      localContentValues.put("msgTypeFlag", Integer.valueOf(this.field_msgTypeFlag));
    }
    if (this.cTt) {
      localContentValues.put("msgState", Integer.valueOf(this.field_msgState));
    }
    if (this.ujK > 0L) {
      localContentValues.put("rowid", Long.valueOf(this.ujK));
    }
    return localContentValues;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.h.c.db
 * JD-Core Version:    0.7.0.1
 */