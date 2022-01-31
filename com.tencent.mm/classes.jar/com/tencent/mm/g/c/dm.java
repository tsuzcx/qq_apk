package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;

public abstract class dm
  extends c
{
  public static final String[] INDEX_CREATE = new String[0];
  private static final int dJE = "sceneFlag".hashCode();
  private static final int dJF = "msgTypeFlag".hashCode();
  private static final int dJG = "msgState".hashCode();
  private static final int dfJ;
  private static final int dhB = "appId".hashCode();
  private static final int djq = "packageName".hashCode();
  private static final int rowid_HASHCODE = "rowid".hashCode();
  private boolean dJB = true;
  private boolean dJC = true;
  private boolean dJD = true;
  private boolean dfG = true;
  private boolean dhk = true;
  private boolean diT = true;
  public String field_appId;
  public int field_msgState;
  public int field_msgTypeFlag;
  public String field_packageName;
  public int field_sceneFlag;
  public int field_status;
  
  static
  {
    dfJ = "status".hashCode();
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
      if (dhB != k) {
        break label65;
      }
      this.field_appId = paramCursor.getString(i);
      this.dhk = true;
    }
    for (;;)
    {
      i += 1;
      break label20;
      break;
      label65:
      if (djq == k) {
        this.field_packageName = paramCursor.getString(i);
      } else if (dfJ == k) {
        this.field_status = paramCursor.getInt(i);
      } else if (dJE == k) {
        this.field_sceneFlag = paramCursor.getInt(i);
      } else if (dJF == k) {
        this.field_msgTypeFlag = paramCursor.getInt(i);
      } else if (dJG == k) {
        this.field_msgState = paramCursor.getInt(i);
      } else if (rowid_HASHCODE == k) {
        this.systemRowid = paramCursor.getLong(i);
      }
    }
  }
  
  public ContentValues convertTo()
  {
    ContentValues localContentValues = new ContentValues();
    if (this.dhk) {
      localContentValues.put("appId", this.field_appId);
    }
    if (this.diT) {
      localContentValues.put("packageName", this.field_packageName);
    }
    if (this.dfG) {
      localContentValues.put("status", Integer.valueOf(this.field_status));
    }
    if (this.dJB) {
      localContentValues.put("sceneFlag", Integer.valueOf(this.field_sceneFlag));
    }
    if (this.dJC) {
      localContentValues.put("msgTypeFlag", Integer.valueOf(this.field_msgTypeFlag));
    }
    if (this.dJD) {
      localContentValues.put("msgState", Integer.valueOf(this.field_msgState));
    }
    if (this.systemRowid > 0L) {
      localContentValues.put("rowid", Long.valueOf(this.systemRowid));
    }
    return localContentValues;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.g.c.dm
 * JD-Core Version:    0.7.0.1
 */