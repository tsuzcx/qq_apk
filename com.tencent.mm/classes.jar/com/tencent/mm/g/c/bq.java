package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;

public abstract class bq
  extends c
{
  public static final String[] INDEX_CREATE = new String[0];
  private static final int eEX;
  private static final int eEY;
  private static final int eGe = "subType".hashCode();
  private static final int eUL;
  private static final int eVP = "exptId".hashCode();
  private static final int eVQ;
  private static final int eVR;
  private static final int eVS;
  private static final int eVT = "exptCheckSum".hashCode();
  private static final int rowid_HASHCODE = "rowid".hashCode();
  private boolean eEQ = true;
  private boolean eER = true;
  private boolean eFH = true;
  private boolean eTZ = true;
  private boolean eVK = true;
  private boolean eVL = true;
  private boolean eVM = true;
  private boolean eVN = true;
  private boolean eVO = true;
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
    eUL = "groupId".hashCode();
    eVQ = "exptSeq".hashCode();
    eVR = "exptContent".hashCode();
    eEX = "startTime".hashCode();
    eEY = "endTime".hashCode();
    eVS = "exptType".hashCode();
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
      if (eVP != k) {
        break label65;
      }
      this.field_exptId = paramCursor.getInt(i);
      this.eVK = true;
    }
    for (;;)
    {
      i += 1;
      break label20;
      break;
      label65:
      if (eUL == k) {
        this.field_groupId = paramCursor.getInt(i);
      } else if (eVQ == k) {
        this.field_exptSeq = paramCursor.getInt(i);
      } else if (eVR == k) {
        this.field_exptContent = paramCursor.getString(i);
      } else if (eEX == k) {
        this.field_startTime = paramCursor.getLong(i);
      } else if (eEY == k) {
        this.field_endTime = paramCursor.getLong(i);
      } else if (eVS == k) {
        this.field_exptType = paramCursor.getInt(i);
      } else if (eGe == k) {
        this.field_subType = paramCursor.getInt(i);
      } else if (eVT == k) {
        this.field_exptCheckSum = paramCursor.getString(i);
      } else if (rowid_HASHCODE == k) {
        this.systemRowid = paramCursor.getLong(i);
      }
    }
  }
  
  public ContentValues convertTo()
  {
    ContentValues localContentValues = new ContentValues();
    if (this.eVK) {
      localContentValues.put("exptId", Integer.valueOf(this.field_exptId));
    }
    if (this.eTZ) {
      localContentValues.put("groupId", Integer.valueOf(this.field_groupId));
    }
    if (this.eVL) {
      localContentValues.put("exptSeq", Integer.valueOf(this.field_exptSeq));
    }
    if (this.eVM) {
      localContentValues.put("exptContent", this.field_exptContent);
    }
    if (this.eEQ) {
      localContentValues.put("startTime", Long.valueOf(this.field_startTime));
    }
    if (this.eER) {
      localContentValues.put("endTime", Long.valueOf(this.field_endTime));
    }
    if (this.eVN) {
      localContentValues.put("exptType", Integer.valueOf(this.field_exptType));
    }
    if (this.eFH) {
      localContentValues.put("subType", Integer.valueOf(this.field_subType));
    }
    if (this.eVO) {
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