package com.tencent.mm.f.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.storage.IAutoDBItem;
import com.tencent.mm.sdk.storage.sql.Column;
import com.tencent.mm.sdk.storage.sql.SingleTable;

public abstract class dz
  extends IAutoDBItem
{
  public static final Column C_CONTENT;
  public static final Column C_ROWID;
  public static final String[] INDEX_CREATE = new String[0];
  public static final SingleTable TABLE = new SingleTable("IPCallMsg");
  private static final int content_HASHCODE;
  public static final Column hGX;
  private static final int hLk;
  public static final Column hsa;
  private static final int hsg;
  private static final int htI = "msgType".hashCode();
  public static final Column hte;
  public static final Column hwR;
  private static final int hxt;
  public static final Column ieQ;
  public static final Column ieR;
  private static final int ieU;
  private static final int ieV = "descUrl".hashCode();
  private static final int rowid_HASHCODE = "rowid".hashCode();
  private boolean __hadSetcontent = true;
  public String field_content;
  public String field_descUrl;
  public short field_isRead;
  public int field_msgType;
  public long field_pushTime;
  public long field_svrId;
  public String field_title;
  private boolean hLh = true;
  private boolean hsd = true;
  private boolean htt = true;
  private boolean hxf = true;
  private boolean ieS = true;
  private boolean ieT = true;
  
  static
  {
    C_ROWID = new Column("rowid", "long", "IPCallMsg", "");
    hGX = new Column("svrid", "long", "IPCallMsg", "");
    hwR = new Column("isread", "short", "IPCallMsg", "");
    hsa = new Column("title", "string", "IPCallMsg", "");
    C_CONTENT = new Column("content", "string", "IPCallMsg", "");
    ieQ = new Column("pushtime", "long", "IPCallMsg", "");
    hte = new Column("msgtype", "int", "IPCallMsg", "");
    ieR = new Column("descurl", "string", "IPCallMsg", "");
    hLk = "svrId".hashCode();
    hxt = "isRead".hashCode();
    hsg = "title".hashCode();
    content_HASHCODE = "content".hashCode();
    ieU = "pushTime".hashCode();
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
      if (hLk != k) {
        break label65;
      }
      this.field_svrId = paramCursor.getLong(i);
      this.hLh = true;
    }
    for (;;)
    {
      i += 1;
      break label20;
      break;
      label65:
      if (hxt == k) {
        this.field_isRead = paramCursor.getShort(i);
      } else if (hsg == k) {
        this.field_title = paramCursor.getString(i);
      } else if (content_HASHCODE == k) {
        this.field_content = paramCursor.getString(i);
      } else if (ieU == k) {
        this.field_pushTime = paramCursor.getLong(i);
      } else if (htI == k) {
        this.field_msgType = paramCursor.getInt(i);
      } else if (ieV == k) {
        this.field_descUrl = paramCursor.getString(i);
      } else if (rowid_HASHCODE == k) {
        this.systemRowid = paramCursor.getLong(i);
      }
    }
  }
  
  public ContentValues convertTo()
  {
    ContentValues localContentValues = new ContentValues();
    if (this.hLh) {
      localContentValues.put("svrId", Long.valueOf(this.field_svrId));
    }
    if (this.hxf) {
      localContentValues.put("isRead", Short.valueOf(this.field_isRead));
    }
    if (this.hsd) {
      localContentValues.put("title", this.field_title);
    }
    if (this.__hadSetcontent) {
      localContentValues.put("content", this.field_content);
    }
    if (this.ieS) {
      localContentValues.put("pushTime", Long.valueOf(this.field_pushTime));
    }
    if (this.htt) {
      localContentValues.put("msgType", Integer.valueOf(this.field_msgType));
    }
    if (this.ieT) {
      localContentValues.put("descUrl", this.field_descUrl);
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
    return "IPCallMsg";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.f.c.dz
 * JD-Core Version:    0.7.0.1
 */