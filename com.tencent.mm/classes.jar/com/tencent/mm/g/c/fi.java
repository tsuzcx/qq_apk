package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;

public abstract class fi
  extends c
{
  public static final String[] INDEX_CREATE = { "CREATE INDEX IF NOT EXISTS ShareCardInfo_card_tp_id_index ON ShareCardInfo(card_tp_id)" };
  private static final int eBB;
  private static final int eEc = "updateSeq".hashCode();
  private static final int eZD;
  private static final int eZE;
  private static final int eZF;
  private static final int eZG;
  private static final int eZH;
  private static final int eZI;
  private static final int eZJ = "block_mask".hashCode();
  private static final int eZK = "dataInfoData".hashCode();
  private static final int eZL = "cardTpInfoData".hashCode();
  private static final int eZM = "shareInfoData".hashCode();
  private static final int eZN = "shopInfoData".hashCode();
  private static final int eZO = "categoryType".hashCode();
  private static final int eZP = "itemIndex".hashCode();
  private static final int elV;
  private static final int eol;
  private static final int euO = "card_id".hashCode();
  private static final int euP = "card_tp_id".hashCode();
  private static final int rowid_HASHCODE = "rowid".hashCode();
  private boolean eAP = true;
  private boolean eDO = true;
  private boolean eZA = true;
  private boolean eZB = true;
  private boolean eZC = true;
  private boolean eZq = true;
  private boolean eZr = true;
  private boolean eZs = true;
  private boolean eZt = true;
  private boolean eZu = true;
  private boolean eZv = true;
  private boolean eZw = true;
  private boolean eZx = true;
  private boolean eZy = true;
  private boolean eZz = true;
  private boolean elS = true;
  private boolean eoi = true;
  private boolean euv = true;
  private boolean euw = true;
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
    eZD = "from_username".hashCode();
    eZE = "consumer".hashCode();
    eBB = "app_id".hashCode();
    elV = "status".hashCode();
    eZF = "share_time".hashCode();
    eZG = "local_updateTime".hashCode();
    eol = "updateTime".hashCode();
    eZH = "begin_time".hashCode();
    eZI = "end_time".hashCode();
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
      if (euO != k) {
        break label65;
      }
      this.field_card_id = paramCursor.getString(i);
      this.euv = true;
    }
    for (;;)
    {
      i += 1;
      break label20;
      break;
      label65:
      if (euP == k) {
        this.field_card_tp_id = paramCursor.getString(i);
      } else if (eZD == k) {
        this.field_from_username = paramCursor.getString(i);
      } else if (eZE == k) {
        this.field_consumer = paramCursor.getString(i);
      } else if (eBB == k) {
        this.field_app_id = paramCursor.getString(i);
      } else if (elV == k) {
        this.field_status = paramCursor.getInt(i);
      } else if (eZF == k) {
        this.field_share_time = paramCursor.getLong(i);
      } else if (eZG == k) {
        this.field_local_updateTime = paramCursor.getLong(i);
      } else if (eol == k) {
        this.field_updateTime = paramCursor.getLong(i);
      } else if (eZH == k) {
        this.field_begin_time = paramCursor.getLong(i);
      } else if (eZI == k) {
        this.field_end_time = paramCursor.getLong(i);
      } else if (eEc == k) {
        this.field_updateSeq = paramCursor.getLong(i);
      } else if (eZJ == k) {
        this.field_block_mask = paramCursor.getLong(i);
      } else if (eZK == k) {
        this.field_dataInfoData = paramCursor.getBlob(i);
      } else if (eZL == k) {
        this.field_cardTpInfoData = paramCursor.getBlob(i);
      } else if (eZM == k) {
        this.field_shareInfoData = paramCursor.getBlob(i);
      } else if (eZN == k) {
        this.field_shopInfoData = paramCursor.getBlob(i);
      } else if (eZO == k) {
        this.field_categoryType = paramCursor.getInt(i);
      } else if (eZP == k) {
        this.field_itemIndex = paramCursor.getInt(i);
      } else if (rowid_HASHCODE == k) {
        this.systemRowid = paramCursor.getLong(i);
      }
    }
  }
  
  public ContentValues convertTo()
  {
    ContentValues localContentValues = new ContentValues();
    if (this.euv) {
      localContentValues.put("card_id", this.field_card_id);
    }
    if (this.euw) {
      localContentValues.put("card_tp_id", this.field_card_tp_id);
    }
    if (this.eZq) {
      localContentValues.put("from_username", this.field_from_username);
    }
    if (this.eZr) {
      localContentValues.put("consumer", this.field_consumer);
    }
    if (this.eAP) {
      localContentValues.put("app_id", this.field_app_id);
    }
    if (this.elS) {
      localContentValues.put("status", Integer.valueOf(this.field_status));
    }
    if (this.eZs) {
      localContentValues.put("share_time", Long.valueOf(this.field_share_time));
    }
    if (this.eZt) {
      localContentValues.put("local_updateTime", Long.valueOf(this.field_local_updateTime));
    }
    if (this.eoi) {
      localContentValues.put("updateTime", Long.valueOf(this.field_updateTime));
    }
    if (this.eZu) {
      localContentValues.put("begin_time", Long.valueOf(this.field_begin_time));
    }
    if (this.eZv) {
      localContentValues.put("end_time", Long.valueOf(this.field_end_time));
    }
    if (this.eDO) {
      localContentValues.put("updateSeq", Long.valueOf(this.field_updateSeq));
    }
    if (this.eZw) {
      localContentValues.put("block_mask", Long.valueOf(this.field_block_mask));
    }
    if (this.eZx) {
      localContentValues.put("dataInfoData", this.field_dataInfoData);
    }
    if (this.eZy) {
      localContentValues.put("cardTpInfoData", this.field_cardTpInfoData);
    }
    if (this.eZz) {
      localContentValues.put("shareInfoData", this.field_shareInfoData);
    }
    if (this.eZA) {
      localContentValues.put("shopInfoData", this.field_shopInfoData);
    }
    if (this.eZB) {
      localContentValues.put("categoryType", Integer.valueOf(this.field_categoryType));
    }
    if (this.eZC) {
      localContentValues.put("itemIndex", Integer.valueOf(this.field_itemIndex));
    }
    if (this.systemRowid > 0L) {
      localContentValues.put("rowid", Long.valueOf(this.systemRowid));
    }
    return localContentValues;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.g.c.fi
 * JD-Core Version:    0.7.0.1
 */