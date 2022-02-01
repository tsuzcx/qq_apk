package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;

public abstract class bn
  extends c
{
  public static final String[] INDEX_CREATE = new String[0];
  private static final int eAm = "exptId".hashCode();
  private static final int eAn;
  private static final int eAo;
  private static final int eAp;
  private static final int eAq = "exptCheckSum".hashCode();
  private static final int ekd;
  private static final int eke;
  private static final int elk;
  private static final int ezi = "groupId".hashCode();
  private static final int rowid_HASHCODE = "rowid".hashCode();
  private boolean eAh = true;
  private boolean eAi = true;
  private boolean eAj = true;
  private boolean eAk = true;
  private boolean eAl = true;
  private boolean ejW = true;
  private boolean ejX = true;
  private boolean ekN = true;
  private boolean eyw = true;
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
    eAn = "exptSeq".hashCode();
    eAo = "exptContent".hashCode();
    ekd = "startTime".hashCode();
    eke = "endTime".hashCode();
    eAp = "exptType".hashCode();
    elk = "subType".hashCode();
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
      if (eAm != k) {
        break label65;
      }
      this.field_exptId = paramCursor.getInt(i);
      this.eAh = true;
    }
    for (;;)
    {
      i += 1;
      break label20;
      break;
      label65:
      if (ezi == k) {
        this.field_groupId = paramCursor.getInt(i);
      } else if (eAn == k) {
        this.field_exptSeq = paramCursor.getInt(i);
      } else if (eAo == k) {
        this.field_exptContent = paramCursor.getString(i);
      } else if (ekd == k) {
        this.field_startTime = paramCursor.getLong(i);
      } else if (eke == k) {
        this.field_endTime = paramCursor.getLong(i);
      } else if (eAp == k) {
        this.field_exptType = paramCursor.getInt(i);
      } else if (elk == k) {
        this.field_subType = paramCursor.getInt(i);
      } else if (eAq == k) {
        this.field_exptCheckSum = paramCursor.getString(i);
      } else if (rowid_HASHCODE == k) {
        this.systemRowid = paramCursor.getLong(i);
      }
    }
  }
  
  public ContentValues convertTo()
  {
    ContentValues localContentValues = new ContentValues();
    if (this.eAh) {
      localContentValues.put("exptId", Integer.valueOf(this.field_exptId));
    }
    if (this.eyw) {
      localContentValues.put("groupId", Integer.valueOf(this.field_groupId));
    }
    if (this.eAi) {
      localContentValues.put("exptSeq", Integer.valueOf(this.field_exptSeq));
    }
    if (this.eAj) {
      localContentValues.put("exptContent", this.field_exptContent);
    }
    if (this.ejW) {
      localContentValues.put("startTime", Long.valueOf(this.field_startTime));
    }
    if (this.ejX) {
      localContentValues.put("endTime", Long.valueOf(this.field_endTime));
    }
    if (this.eAk) {
      localContentValues.put("exptType", Integer.valueOf(this.field_exptType));
    }
    if (this.ekN) {
      localContentValues.put("subType", Integer.valueOf(this.field_subType));
    }
    if (this.eAl) {
      localContentValues.put("exptCheckSum", this.field_exptCheckSum);
    }
    if (this.systemRowid > 0L) {
      localContentValues.put("rowid", Long.valueOf(this.systemRowid));
    }
    return localContentValues;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.g.c.bn
 * JD-Core Version:    0.7.0.1
 */