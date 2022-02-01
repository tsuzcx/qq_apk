package com.tencent.mm.f.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.storage.IAutoDBItem;
import com.tencent.mm.sdk.storage.sql.Column;
import com.tencent.mm.sdk.storage.sql.SingleTable;

public abstract class gj
  extends IAutoDBItem
{
  public static final Column C_ROWID;
  public static final Column C_UPDATETIME;
  public static final String[] INDEX_CREATE = { "CREATE INDEX IF NOT EXISTS ShareCardInfo_card_tp_id_index ON ShareCardInfo(card_tp_id)" };
  public static final SingleTable TABLE = new SingleTable("ShareCardInfo");
  public static final Column hHg;
  private static final int hII;
  public static final Column hLH;
  private static final int hMj = "updateSeq".hashCode();
  private static final int hmC;
  public static final Column hmw;
  private static final int hyM;
  private static final int hyN;
  public static final Column hya;
  public static final Column hyb;
  public static final Column iwA;
  public static final Column iwB;
  public static final Column iwC;
  public static final Column iwD;
  public static final Column iwE;
  public static final Column iwF;
  public static final Column iwG;
  public static final Column iwH;
  public static final Column iwI;
  private static final int iwW;
  private static final int iwX;
  private static final int iwY;
  private static final int iwZ;
  public static final Column iww;
  public static final Column iwx;
  public static final Column iwy;
  public static final Column iwz;
  private static final int ixa;
  private static final int ixb;
  private static final int ixc = "block_mask".hashCode();
  private static final int ixd = "dataInfoData".hashCode();
  private static final int ixe = "cardTpInfoData".hashCode();
  private static final int ixf = "shareInfoData".hashCode();
  private static final int ixg = "shopInfoData".hashCode();
  private static final int ixh = "categoryType".hashCode();
  private static final int ixi = "itemIndex".hashCode();
  private static final int rowid_HASHCODE = "rowid".hashCode();
  private static final int updateTime_HASHCODE;
  private boolean __hadSetupdateTime = true;
  public String field_app_id;
  public long field_begin_time;
  public long field_block_mask;
  public byte[] field_cardTpInfoData;
  public String field_card_id;
  public String field_card_tp_id;
  public int field_categoryType;
  public String field_consumer;
  public byte[] field_dataInfoData;
  public long field_end_time;
  public String field_from_username;
  public int field_itemIndex;
  public long field_local_updateTime;
  public byte[] field_shareInfoData;
  public long field_share_time;
  public byte[] field_shopInfoData;
  public int field_status;
  public long field_updateSeq;
  public long field_updateTime;
  private boolean hHU = true;
  private boolean hLV = true;
  private boolean hmz = true;
  private boolean hyt = true;
  private boolean hyu = true;
  private boolean iwJ = true;
  private boolean iwK = true;
  private boolean iwL = true;
  private boolean iwM = true;
  private boolean iwN = true;
  private boolean iwO = true;
  private boolean iwP = true;
  private boolean iwQ = true;
  private boolean iwR = true;
  private boolean iwS = true;
  private boolean iwT = true;
  private boolean iwU = true;
  private boolean iwV = true;
  
  static
  {
    C_ROWID = new Column("rowid", "long", "ShareCardInfo", "");
    hya = new Column("card_id", "string", "ShareCardInfo", "");
    hyb = new Column("card_tp_id", "string", "ShareCardInfo", "");
    iww = new Column("from_username", "string", "ShareCardInfo", "");
    iwx = new Column("consumer", "string", "ShareCardInfo", "");
    hHg = new Column("app_id", "string", "ShareCardInfo", "");
    hmw = new Column("status", "int", "ShareCardInfo", "");
    iwy = new Column("share_time", "long", "ShareCardInfo", "");
    iwz = new Column("local_updatetime", "long", "ShareCardInfo", "");
    C_UPDATETIME = new Column("updatetime", "long", "ShareCardInfo", "");
    iwA = new Column("begin_time", "long", "ShareCardInfo", "");
    iwB = new Column("end_time", "long", "ShareCardInfo", "");
    hLH = new Column("updateseq", "long", "ShareCardInfo", "");
    iwC = new Column("block_mask", "long", "ShareCardInfo", "");
    iwD = new Column("datainfodata", "byte[]", "ShareCardInfo", "");
    iwE = new Column("cardtpinfodata", "byte[]", "ShareCardInfo", "");
    iwF = new Column("shareinfodata", "byte[]", "ShareCardInfo", "");
    iwG = new Column("shopinfodata", "byte[]", "ShareCardInfo", "");
    iwH = new Column("categorytype", "int", "ShareCardInfo", "");
    iwI = new Column("itemindex", "int", "ShareCardInfo", "");
    hyM = "card_id".hashCode();
    hyN = "card_tp_id".hashCode();
    iwW = "from_username".hashCode();
    iwX = "consumer".hashCode();
    hII = "app_id".hashCode();
    hmC = "status".hashCode();
    iwY = "share_time".hashCode();
    iwZ = "local_updateTime".hashCode();
    updateTime_HASHCODE = "updateTime".hashCode();
    ixa = "begin_time".hashCode();
    ixb = "end_time".hashCode();
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
      if (hyM != k) {
        break label65;
      }
      this.field_card_id = paramCursor.getString(i);
      this.hyt = true;
    }
    for (;;)
    {
      i += 1;
      break label20;
      break;
      label65:
      if (hyN == k) {
        this.field_card_tp_id = paramCursor.getString(i);
      } else if (iwW == k) {
        this.field_from_username = paramCursor.getString(i);
      } else if (iwX == k) {
        this.field_consumer = paramCursor.getString(i);
      } else if (hII == k) {
        this.field_app_id = paramCursor.getString(i);
      } else if (hmC == k) {
        this.field_status = paramCursor.getInt(i);
      } else if (iwY == k) {
        this.field_share_time = paramCursor.getLong(i);
      } else if (iwZ == k) {
        this.field_local_updateTime = paramCursor.getLong(i);
      } else if (updateTime_HASHCODE == k) {
        this.field_updateTime = paramCursor.getLong(i);
      } else if (ixa == k) {
        this.field_begin_time = paramCursor.getLong(i);
      } else if (ixb == k) {
        this.field_end_time = paramCursor.getLong(i);
      } else if (hMj == k) {
        this.field_updateSeq = paramCursor.getLong(i);
      } else if (ixc == k) {
        this.field_block_mask = paramCursor.getLong(i);
      } else if (ixd == k) {
        this.field_dataInfoData = paramCursor.getBlob(i);
      } else if (ixe == k) {
        this.field_cardTpInfoData = paramCursor.getBlob(i);
      } else if (ixf == k) {
        this.field_shareInfoData = paramCursor.getBlob(i);
      } else if (ixg == k) {
        this.field_shopInfoData = paramCursor.getBlob(i);
      } else if (ixh == k) {
        this.field_categoryType = paramCursor.getInt(i);
      } else if (ixi == k) {
        this.field_itemIndex = paramCursor.getInt(i);
      } else if (rowid_HASHCODE == k) {
        this.systemRowid = paramCursor.getLong(i);
      }
    }
  }
  
  public ContentValues convertTo()
  {
    ContentValues localContentValues = new ContentValues();
    if (this.hyt) {
      localContentValues.put("card_id", this.field_card_id);
    }
    if (this.hyu) {
      localContentValues.put("card_tp_id", this.field_card_tp_id);
    }
    if (this.iwJ) {
      localContentValues.put("from_username", this.field_from_username);
    }
    if (this.iwK) {
      localContentValues.put("consumer", this.field_consumer);
    }
    if (this.hHU) {
      localContentValues.put("app_id", this.field_app_id);
    }
    if (this.hmz) {
      localContentValues.put("status", Integer.valueOf(this.field_status));
    }
    if (this.iwL) {
      localContentValues.put("share_time", Long.valueOf(this.field_share_time));
    }
    if (this.iwM) {
      localContentValues.put("local_updateTime", Long.valueOf(this.field_local_updateTime));
    }
    if (this.__hadSetupdateTime) {
      localContentValues.put("updateTime", Long.valueOf(this.field_updateTime));
    }
    if (this.iwN) {
      localContentValues.put("begin_time", Long.valueOf(this.field_begin_time));
    }
    if (this.iwO) {
      localContentValues.put("end_time", Long.valueOf(this.field_end_time));
    }
    if (this.hLV) {
      localContentValues.put("updateSeq", Long.valueOf(this.field_updateSeq));
    }
    if (this.iwP) {
      localContentValues.put("block_mask", Long.valueOf(this.field_block_mask));
    }
    if (this.iwQ) {
      localContentValues.put("dataInfoData", this.field_dataInfoData);
    }
    if (this.iwR) {
      localContentValues.put("cardTpInfoData", this.field_cardTpInfoData);
    }
    if (this.iwS) {
      localContentValues.put("shareInfoData", this.field_shareInfoData);
    }
    if (this.iwT) {
      localContentValues.put("shopInfoData", this.field_shopInfoData);
    }
    if (this.iwU) {
      localContentValues.put("categoryType", Integer.valueOf(this.field_categoryType));
    }
    if (this.iwV) {
      localContentValues.put("itemIndex", Integer.valueOf(this.field_itemIndex));
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
    return "ShareCardInfo";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.f.c.gj
 * JD-Core Version:    0.7.0.1
 */