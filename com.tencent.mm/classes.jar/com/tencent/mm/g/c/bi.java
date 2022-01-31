package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;

public abstract class bi
  extends c
{
  public static final String[] INDEX_CREATE = new String[0];
  private static final int dfV;
  private static final int dfW;
  private static final int dhc = "subType".hashCode();
  private static final int dui;
  private static final int dvm = "exptId".hashCode();
  private static final int dvn;
  private static final int dvo;
  private static final int dvp;
  private static final int dvq = "exptCheckSum".hashCode();
  private static final int rowid_HASHCODE = "rowid".hashCode();
  private boolean dfO = true;
  private boolean dfP = true;
  private boolean dgF = true;
  private boolean dtw = true;
  private boolean dvh = true;
  private boolean dvi = true;
  private boolean dvj = true;
  private boolean dvk = true;
  private boolean dvl = true;
  public long field_endTime;
  public String field_exptCheckSum;
  public String field_exptContent;
  public int field_exptId;
  public int field_exptSeq;
  public int field_exptType;
  public int field_groupId;
  public long field_startTime;
  public int field_subType;
  
  static
  {
    dui = "groupId".hashCode();
    dvn = "exptSeq".hashCode();
    dvo = "exptContent".hashCode();
    dfV = "startTime".hashCode();
    dfW = "endTime".hashCode();
    dvp = "exptType".hashCode();
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
      if (dvm != k) {
        break label65;
      }
      this.field_exptId = paramCursor.getInt(i);
      this.dvh = true;
    }
    for (;;)
    {
      i += 1;
      break label20;
      break;
      label65:
      if (dui == k) {
        this.field_groupId = paramCursor.getInt(i);
      } else if (dvn == k) {
        this.field_exptSeq = paramCursor.getInt(i);
      } else if (dvo == k) {
        this.field_exptContent = paramCursor.getString(i);
      } else if (dfV == k) {
        this.field_startTime = paramCursor.getLong(i);
      } else if (dfW == k) {
        this.field_endTime = paramCursor.getLong(i);
      } else if (dvp == k) {
        this.field_exptType = paramCursor.getInt(i);
      } else if (dhc == k) {
        this.field_subType = paramCursor.getInt(i);
      } else if (dvq == k) {
        this.field_exptCheckSum = paramCursor.getString(i);
      } else if (rowid_HASHCODE == k) {
        this.systemRowid = paramCursor.getLong(i);
      }
    }
  }
  
  public ContentValues convertTo()
  {
    ContentValues localContentValues = new ContentValues();
    if (this.dvh) {
      localContentValues.put("exptId", Integer.valueOf(this.field_exptId));
    }
    if (this.dtw) {
      localContentValues.put("groupId", Integer.valueOf(this.field_groupId));
    }
    if (this.dvi) {
      localContentValues.put("exptSeq", Integer.valueOf(this.field_exptSeq));
    }
    if (this.dvj) {
      localContentValues.put("exptContent", this.field_exptContent);
    }
    if (this.dfO) {
      localContentValues.put("startTime", Long.valueOf(this.field_startTime));
    }
    if (this.dfP) {
      localContentValues.put("endTime", Long.valueOf(this.field_endTime));
    }
    if (this.dvk) {
      localContentValues.put("exptType", Integer.valueOf(this.field_exptType));
    }
    if (this.dgF) {
      localContentValues.put("subType", Integer.valueOf(this.field_subType));
    }
    if (this.dvl) {
      localContentValues.put("exptCheckSum", this.field_exptCheckSum);
    }
    if (this.systemRowid > 0L) {
      localContentValues.put("rowid", Long.valueOf(this.systemRowid));
    }
    return localContentValues;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.g.c.bi
 * JD-Core Version:    0.7.0.1
 */