package com.tencent.mm.f.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.storage.IAutoDBItem;
import com.tencent.mm.sdk.storage.sql.Column;
import com.tencent.mm.sdk.storage.sql.SingleTable;

public abstract class hp
  extends IAutoDBItem
{
  public static final Column C_ROWID;
  public static final String[] INDEX_CREATE = new String[0];
  public static final SingleTable TABLE = new SingleTable("WalletLuckyMoney");
  private static final int hZI;
  public static final Column hZk;
  public static final Column hwH;
  private static final int hxj = "msgSvrId".hashCode();
  public static final Column iGQ;
  public static final Column iGR;
  public static final Column iGS;
  public static final Column iGT;
  public static final Column iGU;
  public static final Column iGV;
  public static final Column iGW;
  private static final int iHe;
  private static final int iHf;
  private static final int iHg;
  private static final int iHh;
  private static final int iHi;
  private static final int iHj;
  private static final int iHk;
  public static final Column itm;
  public static final Column itn;
  private static final int itw;
  private static final int itx;
  private static final int rowid_HASHCODE = "rowid".hashCode();
  public String field_exclusiveUsername;
  public int field_hbStatus;
  public int field_hbType;
  public int field_invalidtime;
  public String field_mNativeUrl;
  public long field_msgSvrId;
  public long field_receiveAmount;
  public int field_receiveStatus;
  public long field_receiveTime;
  public String field_sendId;
  public String field_sender;
  private boolean hZw = true;
  private boolean hwV = true;
  private boolean iGX = true;
  private boolean iGY = true;
  private boolean iGZ = true;
  private boolean iHa = true;
  private boolean iHb = true;
  private boolean iHc = true;
  private boolean iHd = true;
  private boolean itr = true;
  private boolean its = true;
  
  static
  {
    C_ROWID = new Column("rowid", "long", "WalletLuckyMoney", "");
    iGQ = new Column("mnativeurl", "string", "WalletLuckyMoney", "");
    iGR = new Column("hbtype", "int", "WalletLuckyMoney", "");
    iGS = new Column("receiveamount", "long", "WalletLuckyMoney", "");
    hZk = new Column("receivetime", "long", "WalletLuckyMoney", "");
    itm = new Column("receivestatus", "int", "WalletLuckyMoney", "");
    iGT = new Column("hbstatus", "int", "WalletLuckyMoney", "");
    iGU = new Column("sender", "string", "WalletLuckyMoney", "");
    iGV = new Column("exclusiveusername", "string", "WalletLuckyMoney", "");
    iGW = new Column("sendid", "string", "WalletLuckyMoney", "");
    itn = new Column("invalidtime", "int", "WalletLuckyMoney", "");
    hwH = new Column("msgsvrid", "long", "WalletLuckyMoney", "");
    iHe = "mNativeUrl".hashCode();
    iHf = "hbType".hashCode();
    iHg = "receiveAmount".hashCode();
    hZI = "receiveTime".hashCode();
    itw = "receiveStatus".hashCode();
    iHh = "hbStatus".hashCode();
    iHi = "sender".hashCode();
    iHj = "exclusiveUsername".hashCode();
    iHk = "sendId".hashCode();
    itx = "invalidtime".hashCode();
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
      if (iHe != k) {
        break label65;
      }
      this.field_mNativeUrl = paramCursor.getString(i);
      this.iGX = true;
    }
    for (;;)
    {
      i += 1;
      break label20;
      break;
      label65:
      if (iHf == k) {
        this.field_hbType = paramCursor.getInt(i);
      } else if (iHg == k) {
        this.field_receiveAmount = paramCursor.getLong(i);
      } else if (hZI == k) {
        this.field_receiveTime = paramCursor.getLong(i);
      } else if (itw == k) {
        this.field_receiveStatus = paramCursor.getInt(i);
      } else if (iHh == k) {
        this.field_hbStatus = paramCursor.getInt(i);
      } else if (iHi == k) {
        this.field_sender = paramCursor.getString(i);
      } else if (iHj == k) {
        this.field_exclusiveUsername = paramCursor.getString(i);
      } else if (iHk == k) {
        this.field_sendId = paramCursor.getString(i);
      } else if (itx == k) {
        this.field_invalidtime = paramCursor.getInt(i);
      } else if (hxj == k) {
        this.field_msgSvrId = paramCursor.getLong(i);
      } else if (rowid_HASHCODE == k) {
        this.systemRowid = paramCursor.getLong(i);
      }
    }
  }
  
  public ContentValues convertTo()
  {
    ContentValues localContentValues = new ContentValues();
    if (this.iGX) {
      localContentValues.put("mNativeUrl", this.field_mNativeUrl);
    }
    if (this.iGY) {
      localContentValues.put("hbType", Integer.valueOf(this.field_hbType));
    }
    if (this.iGZ) {
      localContentValues.put("receiveAmount", Long.valueOf(this.field_receiveAmount));
    }
    if (this.hZw) {
      localContentValues.put("receiveTime", Long.valueOf(this.field_receiveTime));
    }
    if (this.itr) {
      localContentValues.put("receiveStatus", Integer.valueOf(this.field_receiveStatus));
    }
    if (this.iHa) {
      localContentValues.put("hbStatus", Integer.valueOf(this.field_hbStatus));
    }
    if (this.iHb) {
      localContentValues.put("sender", this.field_sender);
    }
    if (this.iHc) {
      localContentValues.put("exclusiveUsername", this.field_exclusiveUsername);
    }
    if (this.iHd) {
      localContentValues.put("sendId", this.field_sendId);
    }
    if (this.its) {
      localContentValues.put("invalidtime", Integer.valueOf(this.field_invalidtime));
    }
    if (this.hwV) {
      localContentValues.put("msgSvrId", Long.valueOf(this.field_msgSvrId));
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
    return "WalletLuckyMoney";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.f.c.hp
 * JD-Core Version:    0.7.0.1
 */