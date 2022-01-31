package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;

public abstract class bh
  extends c
{
  public static final String[] INDEX_CREATE = new String[0];
  private static final int djr = "modifyTime".hashCode();
  private static final int dkn;
  private static final int dvc = "prodcutID".hashCode();
  private static final int dvd = "totalCount".hashCode();
  private static final int dve = "continuCount".hashCode();
  private static final int dvf = "showTipsTime".hashCode();
  private static final int dvg = "setFlagTime".hashCode();
  private static final int rowid_HASHCODE = "rowid".hashCode();
  private boolean diU = true;
  private boolean dkl = true;
  private boolean duX = true;
  private boolean duY = true;
  private boolean duZ = true;
  private boolean dva = true;
  private boolean dvb = true;
  public int field_continuCount;
  public int field_flag;
  public long field_modifyTime;
  public String field_prodcutID;
  public long field_setFlagTime;
  public long field_showTipsTime;
  public int field_totalCount;
  
  static
  {
    dkn = "flag".hashCode();
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
      if (dvc != k) {
        break label65;
      }
      this.field_prodcutID = paramCursor.getString(i);
      this.duX = true;
    }
    for (;;)
    {
      i += 1;
      break label20;
      break;
      label65:
      if (dvd == k) {
        this.field_totalCount = paramCursor.getInt(i);
      } else if (dve == k) {
        this.field_continuCount = paramCursor.getInt(i);
      } else if (dkn == k) {
        this.field_flag = paramCursor.getInt(i);
      } else if (djr == k) {
        this.field_modifyTime = paramCursor.getLong(i);
      } else if (dvf == k) {
        this.field_showTipsTime = paramCursor.getLong(i);
      } else if (dvg == k) {
        this.field_setFlagTime = paramCursor.getLong(i);
      } else if (rowid_HASHCODE == k) {
        this.systemRowid = paramCursor.getLong(i);
      }
    }
  }
  
  public ContentValues convertTo()
  {
    ContentValues localContentValues = new ContentValues();
    if (this.duX) {
      localContentValues.put("prodcutID", this.field_prodcutID);
    }
    if (this.duY) {
      localContentValues.put("totalCount", Integer.valueOf(this.field_totalCount));
    }
    if (this.duZ) {
      localContentValues.put("continuCount", Integer.valueOf(this.field_continuCount));
    }
    if (this.dkl) {
      localContentValues.put("flag", Integer.valueOf(this.field_flag));
    }
    if (this.diU) {
      localContentValues.put("modifyTime", Long.valueOf(this.field_modifyTime));
    }
    if (this.dva) {
      localContentValues.put("showTipsTime", Long.valueOf(this.field_showTipsTime));
    }
    if (this.dvb) {
      localContentValues.put("setFlagTime", Long.valueOf(this.field_setFlagTime));
    }
    if (this.systemRowid > 0L) {
      localContentValues.put("rowid", Long.valueOf(this.systemRowid));
    }
    return localContentValues;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.g.c.bh
 * JD-Core Version:    0.7.0.1
 */