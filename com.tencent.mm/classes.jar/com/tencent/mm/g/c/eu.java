package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;

public abstract class eu
  extends c
{
  public static final String[] INDEX_CREATE = new String[0];
  private static final int eEL = "status".hashCode();
  private static final int eGD = "appId".hashCode();
  private static final int eIJ = "packageName".hashCode();
  private static final int fpP = "sceneFlag".hashCode();
  private static final int fpQ = "msgTypeFlag".hashCode();
  private static final int fpR = "msgState".hashCode();
  private static final int rowid_HASHCODE = "rowid".hashCode();
  private boolean eEI = true;
  private boolean eGm = true;
  private boolean eIn = true;
  public String field_appId;
  public int field_msgState;
  public int field_msgTypeFlag;
  public String field_packageName;
  public int field_sceneFlag;
  public int field_status;
  private boolean fpM = true;
  private boolean fpN = true;
  private boolean fpO = true;
  
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
      if (eGD != k) {
        break label65;
      }
      this.field_appId = paramCursor.getString(i);
      this.eGm = true;
    }
    for (;;)
    {
      i += 1;
      break label20;
      break;
      label65:
      if (eIJ == k) {
        this.field_packageName = paramCursor.getString(i);
      } else if (eEL == k) {
        this.field_status = paramCursor.getInt(i);
      } else if (fpP == k) {
        this.field_sceneFlag = paramCursor.getInt(i);
      } else if (fpQ == k) {
        this.field_msgTypeFlag = paramCursor.getInt(i);
      } else if (fpR == k) {
        this.field_msgState = paramCursor.getInt(i);
      } else if (rowid_HASHCODE == k) {
        this.systemRowid = paramCursor.getLong(i);
      }
    }
  }
  
  public ContentValues convertTo()
  {
    ContentValues localContentValues = new ContentValues();
    if (this.eGm) {
      localContentValues.put("appId", this.field_appId);
    }
    if (this.eIn) {
      localContentValues.put("packageName", this.field_packageName);
    }
    if (this.eEI) {
      localContentValues.put("status", Integer.valueOf(this.field_status));
    }
    if (this.fpM) {
      localContentValues.put("sceneFlag", Integer.valueOf(this.field_sceneFlag));
    }
    if (this.fpN) {
      localContentValues.put("msgTypeFlag", Integer.valueOf(this.field_msgTypeFlag));
    }
    if (this.fpO) {
      localContentValues.put("msgState", Integer.valueOf(this.field_msgState));
    }
    if (this.systemRowid > 0L) {
      localContentValues.put("rowid", Long.valueOf(this.systemRowid));
    }
    return localContentValues;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.g.c.eu
 * JD-Core Version:    0.7.0.1
 */