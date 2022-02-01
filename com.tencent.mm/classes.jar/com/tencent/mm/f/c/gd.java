package com.tencent.mm.f.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.storage.IAutoDBItem;
import com.tencent.mm.sdk.storage.sql.Column;
import com.tencent.mm.sdk.storage.sql.SingleTable;

public abstract class gd
  extends IAutoDBItem
{
  public static final Column C_ROWID;
  public static final String[] INDEX_CREATE = new String[0];
  public static final SingleTable TABLE = new SingleTable("ScanHistoryItem");
  public static final Column hFp;
  private static final int hFv;
  public static final Column hnt;
  private static final int hnx = "scene".hashCode();
  public static final Column ivl;
  public static final Column ivm;
  public static final Column ivn;
  public static final Column ivo;
  private static final int ivt;
  private static final int ivu;
  private static final int ivv;
  private static final int ivw;
  private static final int rowid_HASHCODE = "rowid".hashCode();
  public long field_ScanTime;
  public int field_funcType;
  public String field_productId;
  public String field_qrcodeUrl;
  public int field_scene;
  public String field_xmlContent;
  private boolean hFs = true;
  private boolean hnv = true;
  private boolean ivp = true;
  private boolean ivq = true;
  private boolean ivr = true;
  private boolean ivs = true;
  
  static
  {
    C_ROWID = new Column("rowid", "long", "ScanHistoryItem", "");
    hFp = new Column("productid", "string", "ScanHistoryItem", "");
    ivl = new Column("xmlcontent", "string", "ScanHistoryItem", "");
    ivm = new Column("scantime", "long", "ScanHistoryItem", "");
    ivn = new Column("functype", "int", "ScanHistoryItem", "");
    ivo = new Column("qrcodeurl", "string", "ScanHistoryItem", "");
    hnt = new Column("scene", "int", "ScanHistoryItem", "");
    hFv = "productId".hashCode();
    ivt = "xmlContent".hashCode();
    ivu = "ScanTime".hashCode();
    ivv = "funcType".hashCode();
    ivw = "qrcodeUrl".hashCode();
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
      if (hFv != k) {
        break label65;
      }
      this.field_productId = paramCursor.getString(i);
      this.hFs = true;
    }
    for (;;)
    {
      i += 1;
      break label20;
      break;
      label65:
      if (ivt == k) {
        this.field_xmlContent = paramCursor.getString(i);
      } else if (ivu == k) {
        this.field_ScanTime = paramCursor.getLong(i);
      } else if (ivv == k) {
        this.field_funcType = paramCursor.getInt(i);
      } else if (ivw == k) {
        this.field_qrcodeUrl = paramCursor.getString(i);
      } else if (hnx == k) {
        this.field_scene = paramCursor.getInt(i);
      } else if (rowid_HASHCODE == k) {
        this.systemRowid = paramCursor.getLong(i);
      }
    }
  }
  
  public ContentValues convertTo()
  {
    ContentValues localContentValues = new ContentValues();
    if (this.hFs) {
      localContentValues.put("productId", this.field_productId);
    }
    if (this.ivp) {
      localContentValues.put("xmlContent", this.field_xmlContent);
    }
    if (this.ivq) {
      localContentValues.put("ScanTime", Long.valueOf(this.field_ScanTime));
    }
    if (this.ivr) {
      localContentValues.put("funcType", Integer.valueOf(this.field_funcType));
    }
    if (this.ivs) {
      localContentValues.put("qrcodeUrl", this.field_qrcodeUrl);
    }
    if (this.hnv) {
      localContentValues.put("scene", Integer.valueOf(this.field_scene));
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
    return "ScanHistoryItem";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.f.c.gd
 * JD-Core Version:    0.7.0.1
 */