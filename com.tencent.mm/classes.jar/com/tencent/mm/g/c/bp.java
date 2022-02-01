package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;

public abstract class bp
  extends c
{
  public static final String[] INDEX_CREATE = new String[0];
  private static final int eBC;
  private static final int eCG = "exptId".hashCode();
  private static final int eCH;
  private static final int eCI;
  private static final int eCJ;
  private static final int eCK = "exptCheckSum".hashCode();
  private static final int emh;
  private static final int emi;
  private static final int enp;
  private static final int rowid_HASHCODE = "rowid".hashCode();
  private boolean eAQ = true;
  private boolean eCB = true;
  private boolean eCC = true;
  private boolean eCD = true;
  private boolean eCE = true;
  private boolean eCF = true;
  private boolean emR = true;
  private boolean ema = true;
  private boolean emb = true;
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
    eBC = "groupId".hashCode();
    eCH = "exptSeq".hashCode();
    eCI = "exptContent".hashCode();
    emh = "startTime".hashCode();
    emi = "endTime".hashCode();
    eCJ = "exptType".hashCode();
    enp = "subType".hashCode();
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
      if (eCG != k) {
        break label65;
      }
      this.field_exptId = paramCursor.getInt(i);
      this.eCB = true;
    }
    for (;;)
    {
      i += 1;
      break label20;
      break;
      label65:
      if (eBC == k) {
        this.field_groupId = paramCursor.getInt(i);
      } else if (eCH == k) {
        this.field_exptSeq = paramCursor.getInt(i);
      } else if (eCI == k) {
        this.field_exptContent = paramCursor.getString(i);
      } else if (emh == k) {
        this.field_startTime = paramCursor.getLong(i);
      } else if (emi == k) {
        this.field_endTime = paramCursor.getLong(i);
      } else if (eCJ == k) {
        this.field_exptType = paramCursor.getInt(i);
      } else if (enp == k) {
        this.field_subType = paramCursor.getInt(i);
      } else if (eCK == k) {
        this.field_exptCheckSum = paramCursor.getString(i);
      } else if (rowid_HASHCODE == k) {
        this.systemRowid = paramCursor.getLong(i);
      }
    }
  }
  
  public ContentValues convertTo()
  {
    ContentValues localContentValues = new ContentValues();
    if (this.eCB) {
      localContentValues.put("exptId", Integer.valueOf(this.field_exptId));
    }
    if (this.eAQ) {
      localContentValues.put("groupId", Integer.valueOf(this.field_groupId));
    }
    if (this.eCC) {
      localContentValues.put("exptSeq", Integer.valueOf(this.field_exptSeq));
    }
    if (this.eCD) {
      localContentValues.put("exptContent", this.field_exptContent);
    }
    if (this.ema) {
      localContentValues.put("startTime", Long.valueOf(this.field_startTime));
    }
    if (this.emb) {
      localContentValues.put("endTime", Long.valueOf(this.field_endTime));
    }
    if (this.eCE) {
      localContentValues.put("exptType", Integer.valueOf(this.field_exptType));
    }
    if (this.emR) {
      localContentValues.put("subType", Integer.valueOf(this.field_subType));
    }
    if (this.eCF) {
      localContentValues.put("exptCheckSum", this.field_exptCheckSum);
    }
    if (this.systemRowid > 0L) {
      localContentValues.put("rowid", Long.valueOf(this.systemRowid));
    }
    return localContentValues;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.g.c.bp
 * JD-Core Version:    0.7.0.1
 */