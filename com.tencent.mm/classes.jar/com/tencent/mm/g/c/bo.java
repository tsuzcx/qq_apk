package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;

public abstract class bo
  extends c
{
  public static final String[] INDEX_CREATE = new String[0];
  private static final int eCA = "setFlagTime".hashCode();
  private static final int eCw = "prodcutID".hashCode();
  private static final int eCx = "totalCount".hashCode();
  private static final int eCy = "continuCount".hashCode();
  private static final int eCz;
  private static final int epS;
  private static final int eqO = "flag".hashCode();
  private static final int rowid_HASHCODE = "rowid".hashCode();
  private boolean eCr = true;
  private boolean eCs = true;
  private boolean eCt = true;
  private boolean eCu = true;
  private boolean eCv = true;
  private boolean epw = true;
  private boolean eqM = true;
  public int field_continuCount;
  public int field_flag;
  public long field_modifyTime;
  public String field_prodcutID;
  public long field_setFlagTime;
  public long field_showTipsTime;
  public int field_totalCount;
  
  static
  {
    epS = "modifyTime".hashCode();
    eCz = "showTipsTime".hashCode();
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
      if (eCw != k) {
        break label65;
      }
      this.field_prodcutID = paramCursor.getString(i);
      this.eCr = true;
    }
    for (;;)
    {
      i += 1;
      break label20;
      break;
      label65:
      if (eCx == k) {
        this.field_totalCount = paramCursor.getInt(i);
      } else if (eCy == k) {
        this.field_continuCount = paramCursor.getInt(i);
      } else if (eqO == k) {
        this.field_flag = paramCursor.getInt(i);
      } else if (epS == k) {
        this.field_modifyTime = paramCursor.getLong(i);
      } else if (eCz == k) {
        this.field_showTipsTime = paramCursor.getLong(i);
      } else if (eCA == k) {
        this.field_setFlagTime = paramCursor.getLong(i);
      } else if (rowid_HASHCODE == k) {
        this.systemRowid = paramCursor.getLong(i);
      }
    }
  }
  
  public ContentValues convertTo()
  {
    ContentValues localContentValues = new ContentValues();
    if (this.eCr) {
      localContentValues.put("prodcutID", this.field_prodcutID);
    }
    if (this.eCs) {
      localContentValues.put("totalCount", Integer.valueOf(this.field_totalCount));
    }
    if (this.eCt) {
      localContentValues.put("continuCount", Integer.valueOf(this.field_continuCount));
    }
    if (this.eqM) {
      localContentValues.put("flag", Integer.valueOf(this.field_flag));
    }
    if (this.epw) {
      localContentValues.put("modifyTime", Long.valueOf(this.field_modifyTime));
    }
    if (this.eCu) {
      localContentValues.put("showTipsTime", Long.valueOf(this.field_showTipsTime));
    }
    if (this.eCv) {
      localContentValues.put("setFlagTime", Long.valueOf(this.field_setFlagTime));
    }
    if (this.systemRowid > 0L) {
      localContentValues.put("rowid", Long.valueOf(this.systemRowid));
    }
    return localContentValues;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.g.c.bo
 * JD-Core Version:    0.7.0.1
 */