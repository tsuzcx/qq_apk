package com.tencent.mm.f.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.storage.IAutoDBItem;
import com.tencent.mm.sdk.storage.sql.Column;
import com.tencent.mm.sdk.storage.sql.SingleTable;

public abstract class b
  extends IAutoDBItem
{
  public static final Column C_ROWID;
  public static final String[] INDEX_CREATE = new String[0];
  public static final SingleTable TABLE = new SingleTable("AARecord");
  private static final int hmA;
  private static final int hmB = "localMsgId".hashCode();
  private static final int hmC = "status".hashCode();
  public static final Column hmj;
  private static final int hmr;
  public static final Column hmu;
  public static final Column hmv;
  public static final Column hmw;
  private static final int rowid_HASHCODE = "rowid".hashCode();
  public String field_billNo;
  public boolean field_insertmsg;
  public long field_localMsgId;
  public int field_status;
  private boolean hmn = true;
  private boolean hmx = true;
  private boolean hmy = true;
  private boolean hmz = true;
  
  static
  {
    C_ROWID = new Column("rowid", "long", "AARecord", "");
    hmu = new Column("billno", "string", "AARecord", "");
    hmj = new Column("insertmsg", "boolean", "AARecord", "");
    hmv = new Column("localmsgid", "long", "AARecord", "");
    hmw = new Column("status", "int", "AARecord", "");
    hmA = "billNo".hashCode();
    hmr = "insertmsg".hashCode();
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
      if (hmA != k) {
        break label65;
      }
      this.field_billNo = paramCursor.getString(i);
      this.hmx = true;
    }
    for (;;)
    {
      i += 1;
      break label20;
      break;
      label65:
      if (hmr == k)
      {
        if (paramCursor.getInt(i) != 0) {}
        for (boolean bool = true;; bool = false)
        {
          this.field_insertmsg = bool;
          break;
        }
      }
      if (hmB == k) {
        this.field_localMsgId = paramCursor.getLong(i);
      } else if (hmC == k) {
        this.field_status = paramCursor.getInt(i);
      } else if (rowid_HASHCODE == k) {
        this.systemRowid = paramCursor.getLong(i);
      }
    }
  }
  
  public ContentValues convertTo()
  {
    ContentValues localContentValues = new ContentValues();
    if (this.hmx) {
      localContentValues.put("billNo", this.field_billNo);
    }
    if (this.hmn) {
      localContentValues.put("insertmsg", Boolean.valueOf(this.field_insertmsg));
    }
    if (this.hmy) {
      localContentValues.put("localMsgId", Long.valueOf(this.field_localMsgId));
    }
    if (this.hmz) {
      localContentValues.put("status", Integer.valueOf(this.field_status));
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
    return "AARecord";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.f.c.b
 * JD-Core Version:    0.7.0.1
 */