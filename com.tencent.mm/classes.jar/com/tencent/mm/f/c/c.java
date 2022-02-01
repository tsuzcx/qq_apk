package com.tencent.mm.f.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.storage.IAutoDBItem;
import com.tencent.mm.sdk.storage.sql.Column;
import com.tencent.mm.sdk.storage.sql.SingleTable;

public abstract class c
  extends IAutoDBItem
{
  public static final Column C_ROWID;
  public static final Column C_VALUE;
  public static final String[] INDEX_CREATE = new String[0];
  public static final SingleTable TABLE = new SingleTable("ABTestInfo");
  public static final Column hmD;
  public static final Column hmE;
  public static final Column hmF;
  public static final Column hmG;
  public static final Column hmH;
  public static final Column hmI;
  public static final Column hmJ;
  private static final int hmR;
  private static final int hmS = "expId".hashCode();
  private static final int hmT = "sequence".hashCode();
  private static final int hmU = "prioritylevel".hashCode();
  private static final int hmV = "startTime".hashCode();
  private static final int hmW = "endTime".hashCode();
  private static final int hmX = "noReport".hashCode();
  private static final int rowid_HASHCODE = "rowid".hashCode();
  private static final int value_HASHCODE;
  private boolean __hadSetvalue = true;
  public String field_abtestkey;
  public long field_endTime;
  public String field_expId;
  public boolean field_noReport;
  public int field_prioritylevel;
  public long field_sequence;
  public long field_startTime;
  public String field_value;
  private boolean hmK = true;
  private boolean hmL = true;
  private boolean hmM = true;
  private boolean hmN = true;
  private boolean hmO = true;
  private boolean hmP = true;
  private boolean hmQ = true;
  
  static
  {
    C_ROWID = new Column("rowid", "long", "ABTestInfo", "");
    hmD = new Column("abtestkey", "string", "ABTestInfo", "");
    C_VALUE = new Column("value", "string", "ABTestInfo", "");
    hmE = new Column("expid", "string", "ABTestInfo", "");
    hmF = new Column("sequence", "long", "ABTestInfo", "");
    hmG = new Column("prioritylevel", "int", "ABTestInfo", "");
    hmH = new Column("starttime", "long", "ABTestInfo", "");
    hmI = new Column("endtime", "long", "ABTestInfo", "");
    hmJ = new Column("noreport", "boolean", "ABTestInfo", "");
    hmR = "abtestkey".hashCode();
    value_HASHCODE = "value".hashCode();
  }
  
  public void convertFrom(Cursor paramCursor)
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
      if (hmR != k) {
        break label65;
      }
      this.field_abtestkey = paramCursor.getString(i);
      this.hmK = true;
    }
    for (;;)
    {
      i += 1;
      break label20;
      break;
      label65:
      if (value_HASHCODE == k)
      {
        this.field_value = paramCursor.getString(i);
      }
      else if (hmS == k)
      {
        this.field_expId = paramCursor.getString(i);
      }
      else if (hmT == k)
      {
        this.field_sequence = paramCursor.getLong(i);
      }
      else if (hmU == k)
      {
        this.field_prioritylevel = paramCursor.getInt(i);
      }
      else if (hmV == k)
      {
        this.field_startTime = paramCursor.getLong(i);
      }
      else if (hmW == k)
      {
        this.field_endTime = paramCursor.getLong(i);
      }
      else
      {
        if (hmX == k)
        {
          if (paramCursor.getInt(i) != 0) {}
          for (boolean bool = true;; bool = false)
          {
            this.field_noReport = bool;
            break;
          }
        }
        if (rowid_HASHCODE == k) {
          this.systemRowid = paramCursor.getLong(i);
        }
      }
    }
  }
  
  public ContentValues convertTo()
  {
    ContentValues localContentValues = new ContentValues();
    if (this.hmK) {
      localContentValues.put("abtestkey", this.field_abtestkey);
    }
    if (this.__hadSetvalue) {
      localContentValues.put("value", this.field_value);
    }
    if (this.hmL) {
      localContentValues.put("expId", this.field_expId);
    }
    if (this.hmM) {
      localContentValues.put("sequence", Long.valueOf(this.field_sequence));
    }
    if (this.hmN) {
      localContentValues.put("prioritylevel", Integer.valueOf(this.field_prioritylevel));
    }
    if (this.hmO) {
      localContentValues.put("startTime", Long.valueOf(this.field_startTime));
    }
    if (this.hmP) {
      localContentValues.put("endTime", Long.valueOf(this.field_endTime));
    }
    if (this.hmQ) {
      localContentValues.put("noReport", Boolean.valueOf(this.field_noReport));
    }
    if (this.systemRowid > 0L) {
      localContentValues.put("rowid", Long.valueOf(this.systemRowid));
    }
    return localContentValues;
  }
  
  public String[] getIndexCreateSQL()
  {
    return INDEX_CREATE;
  }
  
  public String getTableName()
  {
    return "ABTestInfo";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.f.c.c
 * JD-Core Version:    0.7.0.1
 */