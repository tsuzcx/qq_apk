package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;

public abstract class eu
  extends c
{
  public static final String[] INDEX_CREATE = new String[0];
  private static final int eDc = "status".hashCode();
  private static final int eEU = "appId".hashCode();
  private static final int eHa = "packageName".hashCode();
  private static final int fnO = "sceneFlag".hashCode();
  private static final int fnP = "msgTypeFlag".hashCode();
  private static final int fnQ = "msgState".hashCode();
  private static final int rowid_HASHCODE = "rowid".hashCode();
  private boolean eCZ = true;
  private boolean eED = true;
  private boolean eGE = true;
  public String field_appId;
  public int field_msgState;
  public int field_msgTypeFlag;
  public String field_packageName;
  public int field_sceneFlag;
  public int field_status;
  private boolean fnL = true;
  private boolean fnM = true;
  private boolean fnN = true;
  
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
        break label65;
      }
      this.field_appId = paramCursor.getString(i);
      this.eED = true;
    }
    for (;;)
    {
      i += 1;
      break label20;
      break;
      label65:
      if (eHa == k) {
        this.field_packageName = paramCursor.getString(i);
      } else if (eDc == k) {
        this.field_status = paramCursor.getInt(i);
      } else if (fnO == k) {
        this.field_sceneFlag = paramCursor.getInt(i);
      } else if (fnP == k) {
        this.field_msgTypeFlag = paramCursor.getInt(i);
      } else if (fnQ == k) {
        this.field_msgState = paramCursor.getInt(i);
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
    if (this.eGE) {
      localContentValues.put("packageName", this.field_packageName);
    }
    if (this.eCZ) {
      localContentValues.put("status", Integer.valueOf(this.field_status));
    }
    if (this.fnL) {
      localContentValues.put("sceneFlag", Integer.valueOf(this.field_sceneFlag));
    }
    if (this.fnM) {
      localContentValues.put("msgTypeFlag", Integer.valueOf(this.field_msgTypeFlag));
    }
    if (this.fnN) {
      localContentValues.put("msgState", Integer.valueOf(this.field_msgState));
    }
    if (this.systemRowid > 0L) {
      localContentValues.put("rowid", Long.valueOf(this.systemRowid));
    }
    return localContentValues;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.g.c.eu
 * JD-Core Version:    0.7.0.1
 */