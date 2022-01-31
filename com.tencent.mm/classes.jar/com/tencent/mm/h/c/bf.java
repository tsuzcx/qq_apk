package com.tencent.mm.h.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;

public abstract class bf
  extends c
{
  private static final int cGA;
  private static final int cGB = "showTipsTime".hashCode();
  private static final int cGC = "setFlagTime".hashCode();
  private static final int cGy;
  private static final int cGz;
  public static final String[] cqY = new String[0];
  private static final int crh = "rowid".hashCode();
  private static final int cvf;
  private static final int cwe;
  private boolean cGt = true;
  private boolean cGu = true;
  private boolean cGv = true;
  private boolean cGw = true;
  private boolean cGx = true;
  private boolean cuI = true;
  private boolean cwc = true;
  public int field_continuCount;
  public int field_flag;
  public long field_modifyTime;
  public String field_prodcutID;
  public long field_setFlagTime;
  public long field_showTipsTime;
  public int field_totalCount;
  
  static
  {
    cGy = "prodcutID".hashCode();
    cGz = "totalCount".hashCode();
    cGA = "continuCount".hashCode();
    cwe = "flag".hashCode();
    cvf = "modifyTime".hashCode();
  }
  
  public final void d(Cursor paramCursor)
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
      if (cGy != k) {
        break label65;
      }
      this.field_prodcutID = paramCursor.getString(i);
      this.cGt = true;
    }
    for (;;)
    {
      i += 1;
      break label20;
      break;
      label65:
      if (cGz == k) {
        this.field_totalCount = paramCursor.getInt(i);
      } else if (cGA == k) {
        this.field_continuCount = paramCursor.getInt(i);
      } else if (cwe == k) {
        this.field_flag = paramCursor.getInt(i);
      } else if (cvf == k) {
        this.field_modifyTime = paramCursor.getLong(i);
      } else if (cGB == k) {
        this.field_showTipsTime = paramCursor.getLong(i);
      } else if (cGC == k) {
        this.field_setFlagTime = paramCursor.getLong(i);
      } else if (crh == k) {
        this.ujK = paramCursor.getLong(i);
      }
    }
  }
  
  public final ContentValues vf()
  {
    ContentValues localContentValues = new ContentValues();
    if (this.cGt) {
      localContentValues.put("prodcutID", this.field_prodcutID);
    }
    if (this.cGu) {
      localContentValues.put("totalCount", Integer.valueOf(this.field_totalCount));
    }
    if (this.cGv) {
      localContentValues.put("continuCount", Integer.valueOf(this.field_continuCount));
    }
    if (this.cwc) {
      localContentValues.put("flag", Integer.valueOf(this.field_flag));
    }
    if (this.cuI) {
      localContentValues.put("modifyTime", Long.valueOf(this.field_modifyTime));
    }
    if (this.cGw) {
      localContentValues.put("showTipsTime", Long.valueOf(this.field_showTipsTime));
    }
    if (this.cGx) {
      localContentValues.put("setFlagTime", Long.valueOf(this.field_setFlagTime));
    }
    if (this.ujK > 0L) {
      localContentValues.put("rowid", Long.valueOf(this.ujK));
    }
    return localContentValues;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.h.c.bf
 * JD-Core Version:    0.7.0.1
 */