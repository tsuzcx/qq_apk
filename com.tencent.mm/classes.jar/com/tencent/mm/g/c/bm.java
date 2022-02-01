package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;

public abstract class bm
  extends c
{
  public static final String[] INDEX_CREATE = new String[0];
  private static final int eAc = "prodcutID".hashCode();
  private static final int eAd = "totalCount".hashCode();
  private static final int eAe = "continuCount".hashCode();
  private static final int eAf = "showTipsTime".hashCode();
  private static final int eAg = "setFlagTime".hashCode();
  private static final int enN;
  private static final int eoK = "flag".hashCode();
  private static final int rowid_HASHCODE = "rowid".hashCode();
  private boolean eAa = true;
  private boolean eAb = true;
  private boolean enr = true;
  private boolean eoI = true;
  private boolean ezX = true;
  private boolean ezY = true;
  private boolean ezZ = true;
  public int field_continuCount;
  public int field_flag;
  public long field_modifyTime;
  public String field_prodcutID;
  public long field_setFlagTime;
  public long field_showTipsTime;
  public int field_totalCount;
  
  static
  {
    enN = "modifyTime".hashCode();
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
      if (eAc != k) {
        break label65;
      }
      this.field_prodcutID = paramCursor.getString(i);
      this.ezX = true;
    }
    for (;;)
    {
      i += 1;
      break label20;
      break;
      label65:
      if (eAd == k) {
        this.field_totalCount = paramCursor.getInt(i);
      } else if (eAe == k) {
        this.field_continuCount = paramCursor.getInt(i);
      } else if (eoK == k) {
        this.field_flag = paramCursor.getInt(i);
      } else if (enN == k) {
        this.field_modifyTime = paramCursor.getLong(i);
      } else if (eAf == k) {
        this.field_showTipsTime = paramCursor.getLong(i);
      } else if (eAg == k) {
        this.field_setFlagTime = paramCursor.getLong(i);
      } else if (rowid_HASHCODE == k) {
        this.systemRowid = paramCursor.getLong(i);
      }
    }
  }
  
  public ContentValues convertTo()
  {
    ContentValues localContentValues = new ContentValues();
    if (this.ezX) {
      localContentValues.put("prodcutID", this.field_prodcutID);
    }
    if (this.ezY) {
      localContentValues.put("totalCount", Integer.valueOf(this.field_totalCount));
    }
    if (this.ezZ) {
      localContentValues.put("continuCount", Integer.valueOf(this.field_continuCount));
    }
    if (this.eoI) {
      localContentValues.put("flag", Integer.valueOf(this.field_flag));
    }
    if (this.enr) {
      localContentValues.put("modifyTime", Long.valueOf(this.field_modifyTime));
    }
    if (this.eAa) {
      localContentValues.put("showTipsTime", Long.valueOf(this.field_showTipsTime));
    }
    if (this.eAb) {
      localContentValues.put("setFlagTime", Long.valueOf(this.field_setFlagTime));
    }
    if (this.systemRowid > 0L) {
      localContentValues.put("rowid", Long.valueOf(this.systemRowid));
    }
    return localContentValues;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.g.c.bm
 * JD-Core Version:    0.7.0.1
 */