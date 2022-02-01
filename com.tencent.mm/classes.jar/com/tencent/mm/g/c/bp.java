package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;

public abstract class bp
  extends c
{
  public static final String[] INDEX_CREATE = new String[0];
  private static final int eHX = "flag".hashCode();
  private static final int eHb = "modifyTime".hashCode();
  private static final int eTU = "prodcutID".hashCode();
  private static final int eTV = "totalCount".hashCode();
  private static final int eTW = "continuCount".hashCode();
  private static final int eTX = "showTipsTime".hashCode();
  private static final int eTY = "setFlagTime".hashCode();
  private static final int rowid_HASHCODE = "rowid".hashCode();
  private boolean eGF = true;
  private boolean eHV = true;
  private boolean eTP = true;
  private boolean eTQ = true;
  private boolean eTR = true;
  private boolean eTS = true;
  private boolean eTT = true;
  public int field_continuCount;
  public int field_flag;
  public long field_modifyTime;
  public String field_prodcutID;
  public long field_setFlagTime;
  public long field_showTipsTime;
  public int field_totalCount;
  
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
      if (eTU != k) {
        break label65;
      }
      this.field_prodcutID = paramCursor.getString(i);
      this.eTP = true;
    }
    for (;;)
    {
      i += 1;
      break label20;
      break;
      label65:
      if (eTV == k) {
        this.field_totalCount = paramCursor.getInt(i);
      } else if (eTW == k) {
        this.field_continuCount = paramCursor.getInt(i);
      } else if (eHX == k) {
        this.field_flag = paramCursor.getInt(i);
      } else if (eHb == k) {
        this.field_modifyTime = paramCursor.getLong(i);
      } else if (eTX == k) {
        this.field_showTipsTime = paramCursor.getLong(i);
      } else if (eTY == k) {
        this.field_setFlagTime = paramCursor.getLong(i);
      } else if (rowid_HASHCODE == k) {
        this.systemRowid = paramCursor.getLong(i);
      }
    }
  }
  
  public ContentValues convertTo()
  {
    ContentValues localContentValues = new ContentValues();
    if (this.eTP) {
      localContentValues.put("prodcutID", this.field_prodcutID);
    }
    if (this.eTQ) {
      localContentValues.put("totalCount", Integer.valueOf(this.field_totalCount));
    }
    if (this.eTR) {
      localContentValues.put("continuCount", Integer.valueOf(this.field_continuCount));
    }
    if (this.eHV) {
      localContentValues.put("flag", Integer.valueOf(this.field_flag));
    }
    if (this.eGF) {
      localContentValues.put("modifyTime", Long.valueOf(this.field_modifyTime));
    }
    if (this.eTS) {
      localContentValues.put("showTipsTime", Long.valueOf(this.field_showTipsTime));
    }
    if (this.eTT) {
      localContentValues.put("setFlagTime", Long.valueOf(this.field_setFlagTime));
    }
    if (this.systemRowid > 0L) {
      localContentValues.put("rowid", Long.valueOf(this.systemRowid));
    }
    return localContentValues;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.g.c.bp
 * JD-Core Version:    0.7.0.1
 */