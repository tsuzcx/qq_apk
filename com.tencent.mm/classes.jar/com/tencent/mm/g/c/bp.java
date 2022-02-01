package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;

public abstract class bp
  extends c
{
  public static final String[] INDEX_CREATE = new String[0];
  private static final int eIK = "modifyTime".hashCode();
  private static final int eJG;
  private static final int eVF = "prodcutID".hashCode();
  private static final int eVG = "totalCount".hashCode();
  private static final int eVH = "continuCount".hashCode();
  private static final int eVI = "showTipsTime".hashCode();
  private static final int eVJ = "setFlagTime".hashCode();
  private static final int rowid_HASHCODE = "rowid".hashCode();
  private boolean eIo = true;
  private boolean eJE = true;
  private boolean eVA = true;
  private boolean eVB = true;
  private boolean eVC = true;
  private boolean eVD = true;
  private boolean eVE = true;
  public int field_continuCount;
  public int field_flag;
  public long field_modifyTime;
  public String field_prodcutID;
  public long field_setFlagTime;
  public long field_showTipsTime;
  public int field_totalCount;
  
  static
  {
    eJG = "flag".hashCode();
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
      if (eVF != k) {
        break label65;
      }
      this.field_prodcutID = paramCursor.getString(i);
      this.eVA = true;
    }
    for (;;)
    {
      i += 1;
      break label20;
      break;
      label65:
      if (eVG == k) {
        this.field_totalCount = paramCursor.getInt(i);
      } else if (eVH == k) {
        this.field_continuCount = paramCursor.getInt(i);
      } else if (eJG == k) {
        this.field_flag = paramCursor.getInt(i);
      } else if (eIK == k) {
        this.field_modifyTime = paramCursor.getLong(i);
      } else if (eVI == k) {
        this.field_showTipsTime = paramCursor.getLong(i);
      } else if (eVJ == k) {
        this.field_setFlagTime = paramCursor.getLong(i);
      } else if (rowid_HASHCODE == k) {
        this.systemRowid = paramCursor.getLong(i);
      }
    }
  }
  
  public ContentValues convertTo()
  {
    ContentValues localContentValues = new ContentValues();
    if (this.eVA) {
      localContentValues.put("prodcutID", this.field_prodcutID);
    }
    if (this.eVB) {
      localContentValues.put("totalCount", Integer.valueOf(this.field_totalCount));
    }
    if (this.eVC) {
      localContentValues.put("continuCount", Integer.valueOf(this.field_continuCount));
    }
    if (this.eJE) {
      localContentValues.put("flag", Integer.valueOf(this.field_flag));
    }
    if (this.eIo) {
      localContentValues.put("modifyTime", Long.valueOf(this.field_modifyTime));
    }
    if (this.eVD) {
      localContentValues.put("showTipsTime", Long.valueOf(this.field_showTipsTime));
    }
    if (this.eVE) {
      localContentValues.put("setFlagTime", Long.valueOf(this.field_setFlagTime));
    }
    if (this.systemRowid > 0L) {
      localContentValues.put("rowid", Long.valueOf(this.systemRowid));
    }
    return localContentValues;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.g.c.bp
 * JD-Core Version:    0.7.0.1
 */