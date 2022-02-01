package com.tencent.mm.f.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.storage.IAutoDBItem;
import com.tencent.mm.sdk.storage.sql.Column;
import com.tencent.mm.sdk.storage.sql.SingleTable;

public abstract class hc
  extends IAutoDBItem
{
  public static final Column C_ROWID;
  public static final String[] INDEX_CREATE = new String[0];
  public static final SingleTable TABLE = new SingleTable("Stranger");
  public static final Column hBY;
  private static final int hCK = "conRemark".hashCode();
  private static final int hCU;
  public static final Column hCi;
  private static final int iBA = "contactLabels".hashCode();
  private static final int iBB = "conDescription".hashCode();
  private static final int iBC = "conPhone".hashCode();
  public static final Column iBu;
  public static final Column iBv;
  public static final Column iBw;
  private static final int rowid_HASHCODE = "rowid".hashCode();
  public String field_conDescription;
  public String field_conPhone;
  public String field_conRemark;
  public String field_contactLabels;
  public String field_encryptUsername;
  private boolean hCB = true;
  private boolean hCr = true;
  private boolean iBx = true;
  private boolean iBy = true;
  private boolean iBz = true;
  
  static
  {
    C_ROWID = new Column("rowid", "long", "Stranger", "");
    hCi = new Column("encryptusername", "string", "Stranger", "");
    hBY = new Column("conremark", "string", "Stranger", "");
    iBu = new Column("contactlabels", "string", "Stranger", "");
    iBv = new Column("condescription", "string", "Stranger", "");
    iBw = new Column("conphone", "string", "Stranger", "");
    hCU = "encryptUsername".hashCode();
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
      if (hCU != k) {
        break label65;
      }
      this.field_encryptUsername = paramCursor.getString(i);
      this.hCB = true;
    }
    for (;;)
    {
      i += 1;
      break label20;
      break;
      label65:
      if (hCK == k) {
        this.field_conRemark = paramCursor.getString(i);
      } else if (iBA == k) {
        this.field_contactLabels = paramCursor.getString(i);
      } else if (iBB == k) {
        this.field_conDescription = paramCursor.getString(i);
      } else if (iBC == k) {
        this.field_conPhone = paramCursor.getString(i);
      } else if (rowid_HASHCODE == k) {
        this.systemRowid = paramCursor.getLong(i);
      }
    }
  }
  
  public ContentValues convertTo()
  {
    ContentValues localContentValues = new ContentValues();
    if (this.field_encryptUsername == null) {
      this.field_encryptUsername = "";
    }
    if (this.hCB) {
      localContentValues.put("encryptUsername", this.field_encryptUsername);
    }
    if (this.field_conRemark == null) {
      this.field_conRemark = "";
    }
    if (this.hCr) {
      localContentValues.put("conRemark", this.field_conRemark);
    }
    if (this.field_contactLabels == null) {
      this.field_contactLabels = "";
    }
    if (this.iBx) {
      localContentValues.put("contactLabels", this.field_contactLabels);
    }
    if (this.field_conDescription == null) {
      this.field_conDescription = "";
    }
    if (this.iBy) {
      localContentValues.put("conDescription", this.field_conDescription);
    }
    if (this.field_conPhone == null) {
      this.field_conPhone = "";
    }
    if (this.iBz) {
      localContentValues.put("conPhone", this.field_conPhone);
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
    return "Stranger";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.f.c.hc
 * JD-Core Version:    0.7.0.1
 */