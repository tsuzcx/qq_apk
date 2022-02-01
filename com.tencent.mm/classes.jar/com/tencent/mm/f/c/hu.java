package com.tencent.mm.f.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.storage.IAutoDBItem;
import com.tencent.mm.sdk.storage.sql.Column;
import com.tencent.mm.sdk.storage.sql.SingleTable;

public abstract class hu
  extends IAutoDBItem
{
  public static final Column C_ROWID;
  public static final Column C_VALUE;
  public static final String[] INDEX_CREATE = new String[0];
  public static final SingleTable TABLE = new SingleTable("WebViewData");
  public static final Column hMZ;
  private static final int hZD;
  private static final int hZH;
  public static final Column hZf;
  public static final Column hZj;
  public static final Column hnz;
  private static final int hoh;
  public static final Column hpd;
  private static final int hph = "size".hashCode();
  public static final Column iJN;
  public static final Column iJO;
  private static final int iJR;
  private static final int iJS = "localFile".hashCode();
  private static final int ijb;
  private static final int rowid_HASHCODE = "rowid".hashCode();
  private static final int value_HASHCODE;
  private boolean __hadSetvalue = true;
  public String field_appId;
  public String field_appIdKey;
  public long field_expireTime;
  public String field_localFile;
  public long field_size;
  public long field_timeStamp;
  public String field_value;
  public String field_weight;
  private boolean hZr = true;
  private boolean hZv = true;
  private boolean hnQ = true;
  private boolean hpf = true;
  private boolean iJP = true;
  private boolean iJQ = true;
  private boolean iiW = true;
  
  static
  {
    C_ROWID = new Column("rowid", "long", "WebViewData", "");
    hnz = new Column("appid", "string", "WebViewData", "");
    iJN = new Column("appidkey", "string", "WebViewData", "");
    C_VALUE = new Column("value", "string", "WebViewData", "");
    hZj = new Column("weight", "string", "WebViewData", "");
    hZf = new Column("expiretime", "long", "WebViewData", "");
    hMZ = new Column("timestamp", "long", "WebViewData", "");
    hpd = new Column("size", "long", "WebViewData", "");
    iJO = new Column("localfile", "string", "WebViewData", "");
    hoh = "appId".hashCode();
    iJR = "appIdKey".hashCode();
    value_HASHCODE = "value".hashCode();
    hZH = "weight".hashCode();
    hZD = "expireTime".hashCode();
    ijb = "timeStamp".hashCode();
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
      if (hoh != k) {
        break label60;
      }
      this.field_appId = paramCursor.getString(i);
    }
    for (;;)
    {
      i += 1;
      break label20;
      break;
      label60:
      if (iJR == k)
      {
        this.field_appIdKey = paramCursor.getString(i);
        this.iJP = true;
      }
      else if (value_HASHCODE == k)
      {
        this.field_value = paramCursor.getString(i);
      }
      else if (hZH == k)
      {
        this.field_weight = paramCursor.getString(i);
      }
      else if (hZD == k)
      {
        this.field_expireTime = paramCursor.getLong(i);
      }
      else if (ijb == k)
      {
        this.field_timeStamp = paramCursor.getLong(i);
      }
      else if (hph == k)
      {
        this.field_size = paramCursor.getLong(i);
      }
      else if (iJS == k)
      {
        this.field_localFile = paramCursor.getString(i);
      }
      else if (rowid_HASHCODE == k)
      {
        this.systemRowid = paramCursor.getLong(i);
      }
    }
  }
  
  public ContentValues convertTo()
  {
    ContentValues localContentValues = new ContentValues();
    if (this.hnQ) {
      localContentValues.put("appId", this.field_appId);
    }
    if (this.iJP) {
      localContentValues.put("appIdKey", this.field_appIdKey);
    }
    if (this.__hadSetvalue) {
      localContentValues.put("value", this.field_value);
    }
    if (this.hZv) {
      localContentValues.put("weight", this.field_weight);
    }
    if (this.hZr) {
      localContentValues.put("expireTime", Long.valueOf(this.field_expireTime));
    }
    if (this.iiW) {
      localContentValues.put("timeStamp", Long.valueOf(this.field_timeStamp));
    }
    if (this.hpf) {
      localContentValues.put("size", Long.valueOf(this.field_size));
    }
    if (this.iJQ) {
      localContentValues.put("localFile", this.field_localFile);
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
    return "WebViewData";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.f.c.hu
 * JD-Core Version:    0.7.0.1
 */