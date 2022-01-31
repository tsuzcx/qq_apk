package com.tencent.mm.h.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;

public abstract class aq
  extends c
{
  private static final int cDc;
  private static final int cDd;
  private static final int cDe;
  private static final int cDf;
  private static final int cDg = "isTemporary".hashCode();
  public static final String[] cqY = new String[0];
  private static final int crh = "rowid".hashCode();
  private static final int csv;
  private boolean cCX = true;
  private boolean cCY = true;
  private boolean cCZ = true;
  private boolean cDa = true;
  private boolean cDb = true;
  private boolean crX = true;
  public long field_createTime;
  public boolean field_isTemporary;
  public int field_labelID;
  public String field_labelName;
  public String field_labelPYFull;
  public String field_labelPYShort;
  
  static
  {
    cDc = "labelID".hashCode();
    cDd = "labelName".hashCode();
    cDe = "labelPYFull".hashCode();
    cDf = "labelPYShort".hashCode();
    csv = "createTime".hashCode();
  }
  
  public final void d(Cursor paramCursor)
  {
    String[] arrayOfString = paramCursor.getColumnNames();
    if (arrayOfString == null) {
      return;
    }
    int j = arrayOfString.length;
    int i = 0;
    label20:
    int k;
    if (i < j)
    {
      k = arrayOfString[i].hashCode();
      if (cDc != k) {
        break label65;
      }
      this.field_labelID = paramCursor.getInt(i);
      this.cCX = true;
    }
    for (;;)
    {
      i += 1;
      break label20;
      break;
      label65:
      if (cDd == k)
      {
        this.field_labelName = paramCursor.getString(i);
      }
      else if (cDe == k)
      {
        this.field_labelPYFull = paramCursor.getString(i);
      }
      else if (cDf == k)
      {
        this.field_labelPYShort = paramCursor.getString(i);
      }
      else if (csv == k)
      {
        this.field_createTime = paramCursor.getLong(i);
      }
      else
      {
        if (cDg == k)
        {
          if (paramCursor.getInt(i) != 0) {}
          for (boolean bool = true;; bool = false)
          {
            this.field_isTemporary = bool;
            break;
          }
        }
        if (crh == k) {
          this.ujK = paramCursor.getLong(i);
        }
      }
    }
  }
  
  public final ContentValues vf()
  {
    ContentValues localContentValues = new ContentValues();
    if (this.cCX) {
      localContentValues.put("labelID", Integer.valueOf(this.field_labelID));
    }
    if (this.cCY) {
      localContentValues.put("labelName", this.field_labelName);
    }
    if (this.cCZ) {
      localContentValues.put("labelPYFull", this.field_labelPYFull);
    }
    if (this.cDa) {
      localContentValues.put("labelPYShort", this.field_labelPYShort);
    }
    if (this.crX) {
      localContentValues.put("createTime", Long.valueOf(this.field_createTime));
    }
    if (this.cDb) {
      localContentValues.put("isTemporary", Boolean.valueOf(this.field_isTemporary));
    }
    if (this.ujK > 0L) {
      localContentValues.put("rowid", Long.valueOf(this.ujK));
    }
    return localContentValues;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.h.c.aq
 * JD-Core Version:    0.7.0.1
 */