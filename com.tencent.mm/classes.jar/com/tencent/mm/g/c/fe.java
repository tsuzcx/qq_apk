package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;

public abstract class fe
  extends c
{
  public static final String[] INDEX_CREATE = { "CREATE INDEX IF NOT EXISTS ShareCardInfo_card_tp_id_index ON ShareCardInfo(card_tp_id)" };
  private static final int eBI;
  private static final int eWA = "categoryType".hashCode();
  private static final int eWB = "itemIndex".hashCode();
  private static final int eWp;
  private static final int eWq;
  private static final int eWr;
  private static final int eWs;
  private static final int eWt;
  private static final int eWu;
  private static final int eWv;
  private static final int eWw;
  private static final int eWx;
  private static final int eWy;
  private static final int eWz;
  private static final int ejR;
  private static final int emf;
  private static final int esK = "card_id".hashCode();
  private static final int esL = "card_tp_id".hashCode();
  private static final int ezh;
  private static final int rowid_HASHCODE = "rowid".hashCode();
  private boolean eBu = true;
  private boolean eWc = true;
  private boolean eWd = true;
  private boolean eWe = true;
  private boolean eWf = true;
  private boolean eWg = true;
  private boolean eWh = true;
  private boolean eWi = true;
  private boolean eWj = true;
  private boolean eWk = true;
  private boolean eWl = true;
  private boolean eWm = true;
  private boolean eWn = true;
  private boolean eWo = true;
  private boolean ejO = true;
  private boolean emc = true;
  private boolean esr = true;
  private boolean ess = true;
  private boolean eyv = true;
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
  
  static
  {
    eWp = "from_username".hashCode();
    eWq = "consumer".hashCode();
    ezh = "app_id".hashCode();
    ejR = "status".hashCode();
    eWr = "share_time".hashCode();
    eWs = "local_updateTime".hashCode();
    emf = "updateTime".hashCode();
    eWt = "begin_time".hashCode();
    eWu = "end_time".hashCode();
    eBI = "updateSeq".hashCode();
    eWv = "block_mask".hashCode();
    eWw = "dataInfoData".hashCode();
    eWx = "cardTpInfoData".hashCode();
    eWy = "shareInfoData".hashCode();
    eWz = "shopInfoData".hashCode();
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
      if (esK != k) {
        break label65;
      }
      this.field_card_id = paramCursor.getString(i);
      this.esr = true;
    }
    for (;;)
    {
      i += 1;
      break label20;
      break;
      label65:
      if (esL == k) {
        this.field_card_tp_id = paramCursor.getString(i);
      } else if (eWp == k) {
        this.field_from_username = paramCursor.getString(i);
      } else if (eWq == k) {
        this.field_consumer = paramCursor.getString(i);
      } else if (ezh == k) {
        this.field_app_id = paramCursor.getString(i);
      } else if (ejR == k) {
        this.field_status = paramCursor.getInt(i);
      } else if (eWr == k) {
        this.field_share_time = paramCursor.getLong(i);
      } else if (eWs == k) {
        this.field_local_updateTime = paramCursor.getLong(i);
      } else if (emf == k) {
        this.field_updateTime = paramCursor.getLong(i);
      } else if (eWt == k) {
        this.field_begin_time = paramCursor.getLong(i);
      } else if (eWu == k) {
        this.field_end_time = paramCursor.getLong(i);
      } else if (eBI == k) {
        this.field_updateSeq = paramCursor.getLong(i);
      } else if (eWv == k) {
        this.field_block_mask = paramCursor.getLong(i);
      } else if (eWw == k) {
        this.field_dataInfoData = paramCursor.getBlob(i);
      } else if (eWx == k) {
        this.field_cardTpInfoData = paramCursor.getBlob(i);
      } else if (eWy == k) {
        this.field_shareInfoData = paramCursor.getBlob(i);
      } else if (eWz == k) {
        this.field_shopInfoData = paramCursor.getBlob(i);
      } else if (eWA == k) {
        this.field_categoryType = paramCursor.getInt(i);
      } else if (eWB == k) {
        this.field_itemIndex = paramCursor.getInt(i);
      } else if (rowid_HASHCODE == k) {
        this.systemRowid = paramCursor.getLong(i);
      }
    }
  }
  
  public ContentValues convertTo()
  {
    ContentValues localContentValues = new ContentValues();
    if (this.esr) {
      localContentValues.put("card_id", this.field_card_id);
    }
    if (this.ess) {
      localContentValues.put("card_tp_id", this.field_card_tp_id);
    }
    if (this.eWc) {
      localContentValues.put("from_username", this.field_from_username);
    }
    if (this.eWd) {
      localContentValues.put("consumer", this.field_consumer);
    }
    if (this.eyv) {
      localContentValues.put("app_id", this.field_app_id);
    }
    if (this.ejO) {
      localContentValues.put("status", Integer.valueOf(this.field_status));
    }
    if (this.eWe) {
      localContentValues.put("share_time", Long.valueOf(this.field_share_time));
    }
    if (this.eWf) {
      localContentValues.put("local_updateTime", Long.valueOf(this.field_local_updateTime));
    }
    if (this.emc) {
      localContentValues.put("updateTime", Long.valueOf(this.field_updateTime));
    }
    if (this.eWg) {
      localContentValues.put("begin_time", Long.valueOf(this.field_begin_time));
    }
    if (this.eWh) {
      localContentValues.put("end_time", Long.valueOf(this.field_end_time));
    }
    if (this.eBu) {
      localContentValues.put("updateSeq", Long.valueOf(this.field_updateSeq));
    }
    if (this.eWi) {
      localContentValues.put("block_mask", Long.valueOf(this.field_block_mask));
    }
    if (this.eWj) {
      localContentValues.put("dataInfoData", this.field_dataInfoData);
    }
    if (this.eWk) {
      localContentValues.put("cardTpInfoData", this.field_cardTpInfoData);
    }
    if (this.eWl) {
      localContentValues.put("shareInfoData", this.field_shareInfoData);
    }
    if (this.eWm) {
      localContentValues.put("shopInfoData", this.field_shopInfoData);
    }
    if (this.eWn) {
      localContentValues.put("categoryType", Integer.valueOf(this.field_categoryType));
    }
    if (this.eWo) {
      localContentValues.put("itemIndex", Integer.valueOf(this.field_itemIndex));
    }
    if (this.systemRowid > 0L) {
      localContentValues.put("rowid", Long.valueOf(this.systemRowid));
    }
    return localContentValues;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.g.c.fe
 * JD-Core Version:    0.7.0.1
 */