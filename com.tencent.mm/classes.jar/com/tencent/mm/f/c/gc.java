package com.tencent.mm.f.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.storage.IAutoDBItem;
import com.tencent.mm.sdk.storage.sql.Column;
import com.tencent.mm.sdk.storage.sql.SingleTable;

public abstract class gc
  extends IAutoDBItem
{
  public static final Column C_CREATETIME;
  public static final Column C_ROWID;
  public static final String[] INDEX_CREATE = new String[0];
  public static final SingleTable TABLE = new SingleTable("SafeDeviceInfo");
  public static final Column hHb;
  private static final int hID;
  private static final int icG = "createtime".hashCode();
  public static final Column idg;
  public static final Column ivg;
  private static final int ivj;
  private static final int ivk;
  private static final int rowid_HASHCODE = "rowid".hashCode();
  public long field_createtime;
  public String field_devicetype;
  public String field_name;
  public String field_uid;
  private boolean hHP = true;
  private boolean icv = true;
  private boolean ivh = true;
  private boolean ivi = true;
  
  static
  {
    C_ROWID = new Column("rowid", "long", "SafeDeviceInfo", "");
    ivg = new Column("uid", "string", "SafeDeviceInfo", "");
    hHb = new Column("name", "string", "SafeDeviceInfo", "");
    idg = new Column("devicetype", "string", "SafeDeviceInfo", "");
    C_CREATETIME = new Column("createtime", "long", "SafeDeviceInfo", "");
    ivj = "uid".hashCode();
    hID = "name".hashCode();
    ivk = "devicetype".hashCode();
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
      if (ivj != k) {
        break label65;
      }
      this.field_uid = paramCursor.getString(i);
      this.ivh = true;
    }
    for (;;)
    {
      i += 1;
      break label20;
      break;
      label65:
      if (hID == k) {
        this.field_name = paramCursor.getString(i);
      } else if (ivk == k) {
        this.field_devicetype = paramCursor.getString(i);
      } else if (icG == k) {
        this.field_createtime = paramCursor.getLong(i);
      } else if (rowid_HASHCODE == k) {
        this.systemRowid = paramCursor.getLong(i);
      }
    }
  }
  
  public ContentValues convertTo()
  {
    ContentValues localContentValues = new ContentValues();
    if (this.field_uid == null) {
      this.field_uid = "";
    }
    if (this.ivh) {
      localContentValues.put("uid", this.field_uid);
    }
    if (this.field_name == null) {
      this.field_name = "";
    }
    if (this.hHP) {
      localContentValues.put("name", this.field_name);
    }
    if (this.field_devicetype == null) {
      this.field_devicetype = "";
    }
    if (this.ivi) {
      localContentValues.put("devicetype", this.field_devicetype);
    }
    if (this.icv) {
      localContentValues.put("createtime", Long.valueOf(this.field_createtime));
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
    return "SafeDeviceInfo";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.f.c.gc
 * JD-Core Version:    0.7.0.1
 */