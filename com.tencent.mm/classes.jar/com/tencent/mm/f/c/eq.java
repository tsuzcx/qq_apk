package com.tencent.mm.f.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.storage.IAutoDBItem;
import com.tencent.mm.sdk.storage.sql.Column;
import com.tencent.mm.sdk.storage.sql.SingleTable;

public abstract class eq
  extends IAutoDBItem
{
  public static final Column C_ROWID;
  public static final Column C_SUBTYPE;
  public static final String[] INDEX_CREATE = new String[0];
  public static final SingleTable TABLE = new SingleTable("LuckyMoneyEnvelopeResource");
  private static final int hMP;
  public static final Column hpJ;
  private static final int hpT = "version".hashCode();
  private static final int ikA;
  private static final int ikB;
  public static final Column ikq;
  public static final Column ikr;
  public static final Column iks;
  public static final Column ikt;
  private static final int iky;
  private static final int ikz;
  private static final int rowid_HASHCODE = "rowid".hashCode();
  public String field_bubbleMd5;
  public String field_coverMd5;
  public String field_detailMd5;
  public String field_minilogoMd5;
  public int field_subtype;
  public int field_version;
  private boolean hMN = true;
  private boolean hpO = true;
  private boolean iku = true;
  private boolean ikv = true;
  private boolean ikw = true;
  private boolean ikx = true;
  
  static
  {
    C_ROWID = new Column("rowid", "long", "LuckyMoneyEnvelopeResource", "");
    C_SUBTYPE = new Column("subtype", "int", "LuckyMoneyEnvelopeResource", "");
    ikq = new Column("bubblemd5", "string", "LuckyMoneyEnvelopeResource", "");
    ikr = new Column("covermd5", "string", "LuckyMoneyEnvelopeResource", "");
    iks = new Column("minilogomd5", "string", "LuckyMoneyEnvelopeResource", "");
    ikt = new Column("detailmd5", "string", "LuckyMoneyEnvelopeResource", "");
    hpJ = new Column("version", "int", "LuckyMoneyEnvelopeResource", "");
    hMP = "subtype".hashCode();
    iky = "bubbleMd5".hashCode();
    ikz = "coverMd5".hashCode();
    ikA = "minilogoMd5".hashCode();
    ikB = "detailMd5".hashCode();
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
      if (hMP != k) {
        break label65;
      }
      this.field_subtype = paramCursor.getInt(i);
      this.hMN = true;
    }
    for (;;)
    {
      i += 1;
      break label20;
      break;
      label65:
      if (iky == k) {
        this.field_bubbleMd5 = paramCursor.getString(i);
      } else if (ikz == k) {
        this.field_coverMd5 = paramCursor.getString(i);
      } else if (ikA == k) {
        this.field_minilogoMd5 = paramCursor.getString(i);
      } else if (ikB == k) {
        this.field_detailMd5 = paramCursor.getString(i);
      } else if (hpT == k) {
        this.field_version = paramCursor.getInt(i);
      } else if (rowid_HASHCODE == k) {
        this.systemRowid = paramCursor.getLong(i);
      }
    }
  }
  
  public ContentValues convertTo()
  {
    ContentValues localContentValues = new ContentValues();
    if (this.hMN) {
      localContentValues.put("subtype", Integer.valueOf(this.field_subtype));
    }
    if (this.iku) {
      localContentValues.put("bubbleMd5", this.field_bubbleMd5);
    }
    if (this.ikv) {
      localContentValues.put("coverMd5", this.field_coverMd5);
    }
    if (this.ikw) {
      localContentValues.put("minilogoMd5", this.field_minilogoMd5);
    }
    if (this.ikx) {
      localContentValues.put("detailMd5", this.field_detailMd5);
    }
    if (this.hpO) {
      localContentValues.put("version", Integer.valueOf(this.field_version));
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
    return "LuckyMoneyEnvelopeResource";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.f.c.eq
 * JD-Core Version:    0.7.0.1
 */