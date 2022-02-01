package com.tencent.mm.f.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.storage.IAutoDBItem;
import com.tencent.mm.sdk.storage.sql.Column;
import com.tencent.mm.sdk.storage.sql.SingleTable;

public abstract class in
  extends IAutoDBItem
{
  public static final Column C_CONTENT;
  public static final Column C_ROWID;
  public static final String[] INDEX_CREATE = new String[0];
  public static final SingleTable TABLE = new SingleTable("WxaUpdateableMsg");
  private static final int content_HASHCODE = "content".hashCode();
  public static final Column iNI;
  public static final Column iNJ;
  public static final Column iNK;
  public static final Column iNL;
  private static final int iNQ;
  private static final int iNR;
  private static final int iNS = "contentColor".hashCode();
  private static final int iNT = "updatePeroid".hashCode();
  private static final int iqC;
  public static final Column iqw;
  private static final int rowid_HASHCODE = "rowid".hashCode();
  private boolean __hadSetcontent = true;
  public int field_btnState;
  public String field_content;
  public String field_contentColor;
  public int field_msgState;
  public int field_shareKeyHash;
  public int field_updatePeroid;
  private boolean iNM = true;
  private boolean iNN = true;
  private boolean iNO = true;
  private boolean iNP = true;
  private boolean iqz = true;
  
  static
  {
    C_ROWID = new Column("rowid", "long", "WxaUpdateableMsg", "");
    iNI = new Column("sharekeyhash", "int", "WxaUpdateableMsg", "");
    iNJ = new Column("btnstate", "int", "WxaUpdateableMsg", "");
    iqw = new Column("msgstate", "int", "WxaUpdateableMsg", "");
    C_CONTENT = new Column("content", "string", "WxaUpdateableMsg", "");
    iNK = new Column("contentcolor", "string", "WxaUpdateableMsg", "");
    iNL = new Column("updateperoid", "int", "WxaUpdateableMsg", "");
    iNQ = "shareKeyHash".hashCode();
    iNR = "btnState".hashCode();
    iqC = "msgState".hashCode();
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
      if (iNQ != k) {
        break label65;
      }
      this.field_shareKeyHash = paramCursor.getInt(i);
      this.iNM = true;
    }
    for (;;)
    {
      i += 1;
      break label20;
      break;
      label65:
      if (iNR == k) {
        this.field_btnState = paramCursor.getInt(i);
      } else if (iqC == k) {
        this.field_msgState = paramCursor.getInt(i);
      } else if (content_HASHCODE == k) {
        this.field_content = paramCursor.getString(i);
      } else if (iNS == k) {
        this.field_contentColor = paramCursor.getString(i);
      } else if (iNT == k) {
        this.field_updatePeroid = paramCursor.getInt(i);
      } else if (rowid_HASHCODE == k) {
        this.systemRowid = paramCursor.getLong(i);
      }
    }
  }
  
  public ContentValues convertTo()
  {
    ContentValues localContentValues = new ContentValues();
    if (this.iNM) {
      localContentValues.put("shareKeyHash", Integer.valueOf(this.field_shareKeyHash));
    }
    if (this.iNN) {
      localContentValues.put("btnState", Integer.valueOf(this.field_btnState));
    }
    if (this.iqz) {
      localContentValues.put("msgState", Integer.valueOf(this.field_msgState));
    }
    if (this.__hadSetcontent) {
      localContentValues.put("content", this.field_content);
    }
    if (this.iNO) {
      localContentValues.put("contentColor", this.field_contentColor);
    }
    if (this.iNP) {
      localContentValues.put("updatePeroid", Integer.valueOf(this.field_updatePeroid));
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
    return "WxaUpdateableMsg";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.f.c.in
 * JD-Core Version:    0.7.0.1
 */