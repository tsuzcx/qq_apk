package com.tencent.mm.f.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.storage.IAutoDBItem;
import com.tencent.mm.sdk.storage.sql.Column;
import com.tencent.mm.sdk.storage.sql.SingleTable;

public abstract class d
  extends IAutoDBItem
{
  public static final Column C_ROWID;
  public static final String[] INDEX_CREATE = new String[0];
  public static final SingleTable TABLE = new SingleTable("ABTestItem");
  public static final Column hmE;
  public static final Column hmF;
  public static final Column hmG;
  public static final Column hmH;
  public static final Column hmI;
  private static final int hmS = "expId".hashCode();
  private static final int hmT = "sequence".hashCode();
  private static final int hmU = "prioritylevel".hashCode();
  private static final int hmV = "startTime".hashCode();
  private static final int hmW = "endTime".hashCode();
  public static final Column hmY;
  public static final Column hmZ;
  public static final Column hna;
  public static final Column hnb;
  private static final int hng;
  private static final int hnh;
  private static final int hni = "needReport".hashCode();
  private static final int hnj = "rawXML".hashCode();
  private static final int rowid_HASHCODE = "rowid".hashCode();
  public String field_business;
  public long field_endTime;
  public String field_expId;
  public String field_layerId;
  public boolean field_needReport;
  public int field_prioritylevel;
  public String field_rawXML;
  public long field_sequence;
  public long field_startTime;
  private boolean hmL = true;
  private boolean hmM = true;
  private boolean hmN = true;
  private boolean hmO = true;
  private boolean hmP = true;
  private boolean hnc = true;
  private boolean hnd = true;
  private boolean hne = true;
  private boolean hnf = true;
  
  static
  {
    C_ROWID = new Column("rowid", "long", "ABTestItem", "");
    hmY = new Column("layerid", "string", "ABTestItem", "");
    hmZ = new Column("business", "string", "ABTestItem", "");
    hmE = new Column("expid", "string", "ABTestItem", "");
    hmF = new Column("sequence", "long", "ABTestItem", "");
    hmG = new Column("prioritylevel", "int", "ABTestItem", "");
    hmH = new Column("starttime", "long", "ABTestItem", "");
    hmI = new Column("endtime", "long", "ABTestItem", "");
    hna = new Column("needreport", "boolean", "ABTestItem", "");
    hnb = new Column("rawxml", "string", "ABTestItem", "");
    hng = "layerId".hashCode();
    hnh = "business".hashCode();
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
      if (hng != k) {
        break label65;
      }
      this.field_layerId = paramCursor.getString(i);
      this.hnc = true;
    }
    for (;;)
    {
      i += 1;
      break label20;
      break;
      label65:
      if (hnh == k)
      {
        this.field_business = paramCursor.getString(i);
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
        if (hni == k)
        {
          if (paramCursor.getInt(i) != 0) {}
          for (boolean bool = true;; bool = false)
          {
            this.field_needReport = bool;
            break;
          }
        }
        if (hnj == k) {
          this.field_rawXML = paramCursor.getString(i);
        } else if (rowid_HASHCODE == k) {
          this.systemRowid = paramCursor.getLong(i);
        }
      }
    }
  }
  
  public ContentValues convertTo()
  {
    ContentValues localContentValues = new ContentValues();
    if (this.hnc) {
      localContentValues.put("layerId", this.field_layerId);
    }
    if (this.hnd) {
      localContentValues.put("business", this.field_business);
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
    if (this.hne) {
      localContentValues.put("needReport", Boolean.valueOf(this.field_needReport));
    }
    if (this.field_rawXML == null) {
      this.field_rawXML = "";
    }
    if (this.hnf) {
      localContentValues.put("rawXML", this.field_rawXML);
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
    return "ABTestItem";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.f.c.d
 * JD-Core Version:    0.7.0.1
 */