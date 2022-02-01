package com.tencent.mm.f.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.storage.IAutoDBItem;
import com.tencent.mm.sdk.storage.sql.Column;
import com.tencent.mm.sdk.storage.sql.SingleTable;

public abstract class fz
  extends IAutoDBItem
{
  public static final Column C_ROWID;
  public static final String[] INDEX_CREATE = { "CREATE INDEX IF NOT EXISTS remittance_record_status_index ON RemittanceRecord(receiveStatus)", "CREATE INDEX IF NOT EXISTS remittance_record_talker_index ON RemittanceRecord(talker)" };
  public static final SingleTable TABLE = new SingleTable("RemittanceRecord");
  public static final Column hEY;
  private static final int hFa;
  private static final int htH = "isSend".hashCode();
  public static final Column htd;
  public static final Column hwI;
  private static final int hxk = "talker".hashCode();
  public static final Column itl;
  public static final Column itm;
  public static final Column itn;
  public static final Column ito;
  public static final Column itp;
  private static final int itv;
  private static final int itw;
  private static final int itx = "invalidtime".hashCode();
  private static final int ity = "receiverName".hashCode();
  private static final int itz = "hasClicked".hashCode();
  private static final int rowid_HASHCODE = "rowid".hashCode();
  public boolean field_hasClicked;
  public long field_invalidtime;
  public boolean field_isSend;
  public long field_locaMsgId;
  public int field_receiveStatus;
  public String field_receiverName;
  public String field_talker;
  public String field_transferId;
  private boolean hEZ = true;
  private boolean hts = true;
  private boolean hwW = true;
  private boolean itq = true;
  private boolean itr = true;
  private boolean its = true;
  private boolean itt = true;
  private boolean itu = true;
  
  static
  {
    C_ROWID = new Column("rowid", "long", "RemittanceRecord", "");
    hEY = new Column("transferid", "string", "RemittanceRecord", "");
    itl = new Column("locamsgid", "long", "RemittanceRecord", "");
    itm = new Column("receivestatus", "int", "RemittanceRecord", "");
    htd = new Column("issend", "boolean", "RemittanceRecord", "");
    hwI = new Column("talker", "string", "RemittanceRecord", "");
    itn = new Column("invalidtime", "long", "RemittanceRecord", "");
    ito = new Column("receivername", "string", "RemittanceRecord", "");
    itp = new Column("hasclicked", "boolean", "RemittanceRecord", "");
    hFa = "transferId".hashCode();
    itv = "locaMsgId".hashCode();
    itw = "receiveStatus".hashCode();
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
      if (hFa != k) {
        break label65;
      }
      this.field_transferId = paramCursor.getString(i);
      this.hEZ = true;
    }
    for (;;)
    {
      i += 1;
      break label20;
      break;
      label65:
      if (itv == k)
      {
        this.field_locaMsgId = paramCursor.getLong(i);
      }
      else if (itw == k)
      {
        this.field_receiveStatus = paramCursor.getInt(i);
      }
      else
      {
        boolean bool;
        if (htH == k)
        {
          if (paramCursor.getInt(i) != 0) {}
          for (bool = true;; bool = false)
          {
            this.field_isSend = bool;
            break;
          }
        }
        if (hxk == k)
        {
          this.field_talker = paramCursor.getString(i);
        }
        else if (itx == k)
        {
          this.field_invalidtime = paramCursor.getLong(i);
        }
        else if (ity == k)
        {
          this.field_receiverName = paramCursor.getString(i);
        }
        else
        {
          if (itz == k)
          {
            if (paramCursor.getInt(i) != 0) {}
            for (bool = true;; bool = false)
            {
              this.field_hasClicked = bool;
              break;
            }
          }
          if (rowid_HASHCODE == k) {
            this.systemRowid = paramCursor.getLong(i);
          }
        }
      }
    }
  }
  
  public ContentValues convertTo()
  {
    ContentValues localContentValues = new ContentValues();
    if (this.hEZ) {
      localContentValues.put("transferId", this.field_transferId);
    }
    if (this.itq) {
      localContentValues.put("locaMsgId", Long.valueOf(this.field_locaMsgId));
    }
    if (this.itr) {
      localContentValues.put("receiveStatus", Integer.valueOf(this.field_receiveStatus));
    }
    if (this.hts) {
      localContentValues.put("isSend", Boolean.valueOf(this.field_isSend));
    }
    if (this.hwW) {
      localContentValues.put("talker", this.field_talker);
    }
    if (this.its) {
      localContentValues.put("invalidtime", Long.valueOf(this.field_invalidtime));
    }
    if (this.itt) {
      localContentValues.put("receiverName", this.field_receiverName);
    }
    if (this.itu) {
      localContentValues.put("hasClicked", Boolean.valueOf(this.field_hasClicked));
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
    return "RemittanceRecord";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.f.c.fz
 * JD-Core Version:    0.7.0.1
 */