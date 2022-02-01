package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;

public abstract class bq
  extends c
{
  public static final String[] INDEX_CREATE = new String[0];
  private static final int eDo;
  private static final int eDp;
  private static final int eEv = "subType".hashCode();
  private static final int eTa;
  private static final int eUe = "exptId".hashCode();
  private static final int eUf;
  private static final int eUg;
  private static final int eUh;
  private static final int eUi = "exptCheckSum".hashCode();
  private static final int rowid_HASHCODE = "rowid".hashCode();
  private boolean eDY = true;
  private boolean eDh = true;
  private boolean eDi = true;
  private boolean eSo = true;
  private boolean eTZ = true;
  private boolean eUa = true;
  private boolean eUb = true;
  private boolean eUc = true;
  private boolean eUd = true;
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
    eTa = "groupId".hashCode();
    eUf = "exptSeq".hashCode();
    eUg = "exptContent".hashCode();
    eDo = "startTime".hashCode();
    eDp = "endTime".hashCode();
    eUh = "exptType".hashCode();
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
      if (eUe != k) {
        break label65;
      }
      this.field_exptId = paramCursor.getInt(i);
      this.eTZ = true;
    }
    for (;;)
    {
      i += 1;
      break label20;
      break;
      label65:
      if (eTa == k) {
        this.field_groupId = paramCursor.getInt(i);
      } else if (eUf == k) {
        this.field_exptSeq = paramCursor.getInt(i);
      } else if (eUg == k) {
        this.field_exptContent = paramCursor.getString(i);
      } else if (eDo == k) {
        this.field_startTime = paramCursor.getLong(i);
      } else if (eDp == k) {
        this.field_endTime = paramCursor.getLong(i);
      } else if (eUh == k) {
        this.field_exptType = paramCursor.getInt(i);
      } else if (eEv == k) {
        this.field_subType = paramCursor.getInt(i);
      } else if (eUi == k) {
        this.field_exptCheckSum = paramCursor.getString(i);
      } else if (rowid_HASHCODE == k) {
        this.systemRowid = paramCursor.getLong(i);
      }
    }
  }
  
  public ContentValues convertTo()
  {
    ContentValues localContentValues = new ContentValues();
    if (this.eTZ) {
      localContentValues.put("exptId", Integer.valueOf(this.field_exptId));
    }
    if (this.eSo) {
      localContentValues.put("groupId", Integer.valueOf(this.field_groupId));
    }
    if (this.eUa) {
      localContentValues.put("exptSeq", Integer.valueOf(this.field_exptSeq));
    }
    if (this.eUb) {
      localContentValues.put("exptContent", this.field_exptContent);
    }
    if (this.eDh) {
      localContentValues.put("startTime", Long.valueOf(this.field_startTime));
    }
    if (this.eDi) {
      localContentValues.put("endTime", Long.valueOf(this.field_endTime));
    }
    if (this.eUc) {
      localContentValues.put("exptType", Integer.valueOf(this.field_exptType));
    }
    if (this.eDY) {
      localContentValues.put("subType", Integer.valueOf(this.field_subType));
    }
    if (this.eUd) {
      localContentValues.put("exptCheckSum", this.field_exptCheckSum);
    }
    if (this.systemRowid > 0L) {
      localContentValues.put("rowid", Long.valueOf(this.systemRowid));
    }
    return localContentValues;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.g.c.bq
 * JD-Core Version:    0.7.0.1
 */