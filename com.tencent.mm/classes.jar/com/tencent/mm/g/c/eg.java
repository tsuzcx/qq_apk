package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;

public abstract class eg
  extends c
{
  public static final String[] INDEX_CREATE = new String[0];
  private static final int eSp = "sceneFlag".hashCode();
  private static final int eSq = "msgTypeFlag".hashCode();
  private static final int eSr = "msgState".hashCode();
  private static final int ejR;
  private static final int elJ = "appId".hashCode();
  private static final int enM = "packageName".hashCode();
  private static final int rowid_HASHCODE = "rowid".hashCode();
  private boolean eSm = true;
  private boolean eSn = true;
  private boolean eSo = true;
  private boolean ejO = true;
  private boolean els = true;
  private boolean enq = true;
  public String field_appId;
  public int field_msgState;
  public int field_msgTypeFlag;
  public String field_packageName;
  public int field_sceneFlag;
  public int field_status;
  
  static
  {
    ejR = "status".hashCode();
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
      if (elJ != k) {
        break label65;
      }
      this.field_appId = paramCursor.getString(i);
      this.els = true;
    }
    for (;;)
    {
      i += 1;
      break label20;
      break;
      label65:
      if (enM == k) {
        this.field_packageName = paramCursor.getString(i);
      } else if (ejR == k) {
        this.field_status = paramCursor.getInt(i);
      } else if (eSp == k) {
        this.field_sceneFlag = paramCursor.getInt(i);
      } else if (eSq == k) {
        this.field_msgTypeFlag = paramCursor.getInt(i);
      } else if (eSr == k) {
        this.field_msgState = paramCursor.getInt(i);
      } else if (rowid_HASHCODE == k) {
        this.systemRowid = paramCursor.getLong(i);
      }
    }
  }
  
  public ContentValues convertTo()
  {
    ContentValues localContentValues = new ContentValues();
    if (this.els) {
      localContentValues.put("appId", this.field_appId);
    }
    if (this.enq) {
      localContentValues.put("packageName", this.field_packageName);
    }
    if (this.ejO) {
      localContentValues.put("status", Integer.valueOf(this.field_status));
    }
    if (this.eSm) {
      localContentValues.put("sceneFlag", Integer.valueOf(this.field_sceneFlag));
    }
    if (this.eSn) {
      localContentValues.put("msgTypeFlag", Integer.valueOf(this.field_msgTypeFlag));
    }
    if (this.eSo) {
      localContentValues.put("msgState", Integer.valueOf(this.field_msgState));
    }
    if (this.systemRowid > 0L) {
      localContentValues.put("rowid", Long.valueOf(this.systemRowid));
    }
    return localContentValues;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.g.c.eg
 * JD-Core Version:    0.7.0.1
 */