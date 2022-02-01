package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;

public abstract class ek
  extends c
{
  public static final String[] INDEX_CREATE = new String[0];
  private static final int eVA = "msgTypeFlag".hashCode();
  private static final int eVB = "msgState".hashCode();
  private static final int eVz;
  private static final int elV;
  private static final int enO = "appId".hashCode();
  private static final int epR = "packageName".hashCode();
  private static final int rowid_HASHCODE = "rowid".hashCode();
  private boolean eVw = true;
  private boolean eVx = true;
  private boolean eVy = true;
  private boolean elS = true;
  private boolean enx = true;
  private boolean epv = true;
  public String field_appId;
  public int field_msgState;
  public int field_msgTypeFlag;
  public String field_packageName;
  public int field_sceneFlag;
  public int field_status;
  
  static
  {
    elV = "status".hashCode();
    eVz = "sceneFlag".hashCode();
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
      if (enO != k) {
        break label65;
      }
      this.field_appId = paramCursor.getString(i);
      this.enx = true;
    }
    for (;;)
    {
      i += 1;
      break label20;
      break;
      label65:
      if (epR == k) {
        this.field_packageName = paramCursor.getString(i);
      } else if (elV == k) {
        this.field_status = paramCursor.getInt(i);
      } else if (eVz == k) {
        this.field_sceneFlag = paramCursor.getInt(i);
      } else if (eVA == k) {
        this.field_msgTypeFlag = paramCursor.getInt(i);
      } else if (eVB == k) {
        this.field_msgState = paramCursor.getInt(i);
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
    if (this.epv) {
      localContentValues.put("packageName", this.field_packageName);
    }
    if (this.elS) {
      localContentValues.put("status", Integer.valueOf(this.field_status));
    }
    if (this.eVw) {
      localContentValues.put("sceneFlag", Integer.valueOf(this.field_sceneFlag));
    }
    if (this.eVx) {
      localContentValues.put("msgTypeFlag", Integer.valueOf(this.field_msgTypeFlag));
    }
    if (this.eVy) {
      localContentValues.put("msgState", Integer.valueOf(this.field_msgState));
    }
    if (this.systemRowid > 0L) {
      localContentValues.put("rowid", Long.valueOf(this.systemRowid));
    }
    return localContentValues;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.g.c.ek
 * JD-Core Version:    0.7.0.1
 */