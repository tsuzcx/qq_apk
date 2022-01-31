package com.tencent.mm.h.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;

public abstract class bg
  extends c
{
  private static final int cFN = "groupId".hashCode();
  private static final int cGG;
  private static final int cGH = "exptSeq".hashCode();
  private static final int cGI = "exptContent".hashCode();
  public static final String[] cqY = new String[0];
  private static final int crB = "startTime".hashCode();
  private static final int crC = "endTime".hashCode();
  private static final int crh = "rowid".hashCode();
  private boolean cFk = true;
  private boolean cGD = true;
  private boolean cGE = true;
  private boolean cGF = true;
  private boolean crt = true;
  private boolean cru = true;
  public long field_endTime;
  public String field_exptContent;
  public int field_exptId;
  public int field_exptSeq;
  public int field_groupId;
  public long field_startTime;
  
  static
  {
    cGG = "exptId".hashCode();
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
      if (cGG != k) {
        break label65;
      }
      this.field_exptId = paramCursor.getInt(i);
      this.cGD = true;
    }
    for (;;)
    {
      i += 1;
      break label20;
      break;
      label65:
      if (cFN == k) {
        this.field_groupId = paramCursor.getInt(i);
      } else if (cGH == k) {
        this.field_exptSeq = paramCursor.getInt(i);
      } else if (cGI == k) {
        this.field_exptContent = paramCursor.getString(i);
      } else if (crB == k) {
        this.field_startTime = paramCursor.getLong(i);
      } else if (crC == k) {
        this.field_endTime = paramCursor.getLong(i);
      } else if (crh == k) {
        this.ujK = paramCursor.getLong(i);
      }
    }
  }
  
  public final ContentValues vf()
  {
    ContentValues localContentValues = new ContentValues();
    if (this.cGD) {
      localContentValues.put("exptId", Integer.valueOf(this.field_exptId));
    }
    if (this.cFk) {
      localContentValues.put("groupId", Integer.valueOf(this.field_groupId));
    }
    if (this.cGE) {
      localContentValues.put("exptSeq", Integer.valueOf(this.field_exptSeq));
    }
    if (this.cGF) {
      localContentValues.put("exptContent", this.field_exptContent);
    }
    if (this.crt) {
      localContentValues.put("startTime", Long.valueOf(this.field_startTime));
    }
    if (this.cru) {
      localContentValues.put("endTime", Long.valueOf(this.field_endTime));
    }
    if (this.ujK > 0L) {
      localContentValues.put("rowid", Long.valueOf(this.ujK));
    }
    return localContentValues;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.h.c.bg
 * JD-Core Version:    0.7.0.1
 */