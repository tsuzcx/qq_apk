package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;

public abstract class ft
  extends c
{
  public static final String[] INDEX_CREATE = { "CREATE INDEX IF NOT EXISTS ShareCardInfo_card_tp_id_index ON ShareCardInfo(card_tp_id)" };
  private static final int eEL;
  private static final int eGZ;
  private static final int eNW = "card_id".hashCode();
  private static final int eNX = "card_tp_id".hashCode();
  private static final int eUK;
  private static final int eXl = "updateSeq".hashCode();
  private static final int ftR = "from_username".hashCode();
  private static final int ftS = "consumer".hashCode();
  private static final int ftT;
  private static final int ftU;
  private static final int ftV;
  private static final int ftW;
  private static final int ftX = "block_mask".hashCode();
  private static final int ftY = "dataInfoData".hashCode();
  private static final int ftZ = "cardTpInfoData".hashCode();
  private static final int fua = "shareInfoData".hashCode();
  private static final int fub = "shopInfoData".hashCode();
  private static final int fuc = "categoryType".hashCode();
  private static final int fud = "itemIndex".hashCode();
  private static final int rowid_HASHCODE = "rowid".hashCode();
  private boolean eEI = true;
  private boolean eGW = true;
  private boolean eND = true;
  private boolean eNE = true;
  private boolean eTY = true;
  private boolean eWX = true;
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
  private boolean ftE = true;
  private boolean ftF = true;
  private boolean ftG = true;
  private boolean ftH = true;
  private boolean ftI = true;
  private boolean ftJ = true;
  private boolean ftK = true;
  private boolean ftL = true;
  private boolean ftM = true;
  private boolean ftN = true;
  private boolean ftO = true;
  private boolean ftP = true;
  private boolean ftQ = true;
  
  static
  {
    eUK = "app_id".hashCode();
    eEL = "status".hashCode();
    ftT = "share_time".hashCode();
    ftU = "local_updateTime".hashCode();
    eGZ = "updateTime".hashCode();
    ftV = "begin_time".hashCode();
    ftW = "end_time".hashCode();
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
      if (eNW != k) {
        break label65;
      }
      this.field_card_id = paramCursor.getString(i);
      this.eND = true;
    }
    for (;;)
    {
      i += 1;
      break label20;
      break;
      label65:
      if (eNX == k) {
        this.field_card_tp_id = paramCursor.getString(i);
      } else if (ftR == k) {
        this.field_from_username = paramCursor.getString(i);
      } else if (ftS == k) {
        this.field_consumer = paramCursor.getString(i);
      } else if (eUK == k) {
        this.field_app_id = paramCursor.getString(i);
      } else if (eEL == k) {
        this.field_status = paramCursor.getInt(i);
      } else if (ftT == k) {
        this.field_share_time = paramCursor.getLong(i);
      } else if (ftU == k) {
        this.field_local_updateTime = paramCursor.getLong(i);
      } else if (eGZ == k) {
        this.field_updateTime = paramCursor.getLong(i);
      } else if (ftV == k) {
        this.field_begin_time = paramCursor.getLong(i);
      } else if (ftW == k) {
        this.field_end_time = paramCursor.getLong(i);
      } else if (eXl == k) {
        this.field_updateSeq = paramCursor.getLong(i);
      } else if (ftX == k) {
        this.field_block_mask = paramCursor.getLong(i);
      } else if (ftY == k) {
        this.field_dataInfoData = paramCursor.getBlob(i);
      } else if (ftZ == k) {
        this.field_cardTpInfoData = paramCursor.getBlob(i);
      } else if (fua == k) {
        this.field_shareInfoData = paramCursor.getBlob(i);
      } else if (fub == k) {
        this.field_shopInfoData = paramCursor.getBlob(i);
      } else if (fuc == k) {
        this.field_categoryType = paramCursor.getInt(i);
      } else if (fud == k) {
        this.field_itemIndex = paramCursor.getInt(i);
      } else if (rowid_HASHCODE == k) {
        this.systemRowid = paramCursor.getLong(i);
      }
    }
  }
  
  public ContentValues convertTo()
  {
    ContentValues localContentValues = new ContentValues();
    if (this.eND) {
      localContentValues.put("card_id", this.field_card_id);
    }
    if (this.eNE) {
      localContentValues.put("card_tp_id", this.field_card_tp_id);
    }
    if (this.ftE) {
      localContentValues.put("from_username", this.field_from_username);
    }
    if (this.ftF) {
      localContentValues.put("consumer", this.field_consumer);
    }
    if (this.eTY) {
      localContentValues.put("app_id", this.field_app_id);
    }
    if (this.eEI) {
      localContentValues.put("status", Integer.valueOf(this.field_status));
    }
    if (this.ftG) {
      localContentValues.put("share_time", Long.valueOf(this.field_share_time));
    }
    if (this.ftH) {
      localContentValues.put("local_updateTime", Long.valueOf(this.field_local_updateTime));
    }
    if (this.eGW) {
      localContentValues.put("updateTime", Long.valueOf(this.field_updateTime));
    }
    if (this.ftI) {
      localContentValues.put("begin_time", Long.valueOf(this.field_begin_time));
    }
    if (this.ftJ) {
      localContentValues.put("end_time", Long.valueOf(this.field_end_time));
    }
    if (this.eWX) {
      localContentValues.put("updateSeq", Long.valueOf(this.field_updateSeq));
    }
    if (this.ftK) {
      localContentValues.put("block_mask", Long.valueOf(this.field_block_mask));
    }
    if (this.ftL) {
      localContentValues.put("dataInfoData", this.field_dataInfoData);
    }
    if (this.ftM) {
      localContentValues.put("cardTpInfoData", this.field_cardTpInfoData);
    }
    if (this.ftN) {
      localContentValues.put("shareInfoData", this.field_shareInfoData);
    }
    if (this.ftO) {
      localContentValues.put("shopInfoData", this.field_shopInfoData);
    }
    if (this.ftP) {
      localContentValues.put("categoryType", Integer.valueOf(this.field_categoryType));
    }
    if (this.ftQ) {
      localContentValues.put("itemIndex", Integer.valueOf(this.field_itemIndex));
    }
    if (this.systemRowid > 0L) {
      localContentValues.put("rowid", Long.valueOf(this.systemRowid));
    }
    return localContentValues;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.g.c.ft
 * JD-Core Version:    0.7.0.1
 */