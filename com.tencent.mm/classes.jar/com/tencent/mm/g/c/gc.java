package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.storage.IAutoDBItem;

public abstract class gc
  extends IAutoDBItem
{
  public static final String[] INDEX_CREATE = { "CREATE INDEX IF NOT EXISTS ShareCardInfo_card_tp_id_index ON ShareCardInfo(card_tp_id)" };
  private static final int fAO = "updateSeq".hashCode();
  private static final int fYA;
  private static final int fYB;
  private static final int fYC;
  private static final int fYD;
  private static final int fYE;
  private static final int fYF;
  private static final int fYG = "block_mask".hashCode();
  private static final int fYH = "dataInfoData".hashCode();
  private static final int fYI = "cardTpInfoData".hashCode();
  private static final int fYJ = "shareInfoData".hashCode();
  private static final int fYK = "shopInfoData".hashCode();
  private static final int fYL = "categoryType".hashCode();
  private static final int fYM = "itemIndex".hashCode();
  private static final int fjl;
  private static final int frD = "card_id".hashCode();
  private static final int frE = "card_tp_id".hashCode();
  private static final int fyp;
  private static final int rowid_HASHCODE = "rowid".hashCode();
  private static final int updateTime_HASHCODE;
  private boolean __hadSetupdateTime = true;
  private boolean fAA = true;
  private boolean fYn = true;
  private boolean fYo = true;
  private boolean fYp = true;
  private boolean fYq = true;
  private boolean fYr = true;
  private boolean fYs = true;
  private boolean fYt = true;
  private boolean fYu = true;
  private boolean fYv = true;
  private boolean fYw = true;
  private boolean fYx = true;
  private boolean fYy = true;
  private boolean fYz = true;
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
  private boolean fji = true;
  private boolean frk = true;
  private boolean frl = true;
  private boolean fxD = true;
  
  static
  {
    fYA = "from_username".hashCode();
    fYB = "consumer".hashCode();
    fyp = "app_id".hashCode();
    fjl = "status".hashCode();
    fYC = "share_time".hashCode();
    fYD = "local_updateTime".hashCode();
    updateTime_HASHCODE = "updateTime".hashCode();
    fYE = "begin_time".hashCode();
    fYF = "end_time".hashCode();
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
      if (frD != k) {
        break label65;
      }
      this.field_card_id = paramCursor.getString(i);
      this.frk = true;
    }
    for (;;)
    {
      i += 1;
      break label20;
      break;
      label65:
      if (frE == k) {
        this.field_card_tp_id = paramCursor.getString(i);
      } else if (fYA == k) {
        this.field_from_username = paramCursor.getString(i);
      } else if (fYB == k) {
        this.field_consumer = paramCursor.getString(i);
      } else if (fyp == k) {
        this.field_app_id = paramCursor.getString(i);
      } else if (fjl == k) {
        this.field_status = paramCursor.getInt(i);
      } else if (fYC == k) {
        this.field_share_time = paramCursor.getLong(i);
      } else if (fYD == k) {
        this.field_local_updateTime = paramCursor.getLong(i);
      } else if (updateTime_HASHCODE == k) {
        this.field_updateTime = paramCursor.getLong(i);
      } else if (fYE == k) {
        this.field_begin_time = paramCursor.getLong(i);
      } else if (fYF == k) {
        this.field_end_time = paramCursor.getLong(i);
      } else if (fAO == k) {
        this.field_updateSeq = paramCursor.getLong(i);
      } else if (fYG == k) {
        this.field_block_mask = paramCursor.getLong(i);
      } else if (fYH == k) {
        this.field_dataInfoData = paramCursor.getBlob(i);
      } else if (fYI == k) {
        this.field_cardTpInfoData = paramCursor.getBlob(i);
      } else if (fYJ == k) {
        this.field_shareInfoData = paramCursor.getBlob(i);
      } else if (fYK == k) {
        this.field_shopInfoData = paramCursor.getBlob(i);
      } else if (fYL == k) {
        this.field_categoryType = paramCursor.getInt(i);
      } else if (fYM == k) {
        this.field_itemIndex = paramCursor.getInt(i);
      } else if (rowid_HASHCODE == k) {
        this.systemRowid = paramCursor.getLong(i);
      }
    }
  }
  
  public ContentValues convertTo()
  {
    ContentValues localContentValues = new ContentValues();
    if (this.frk) {
      localContentValues.put("card_id", this.field_card_id);
    }
    if (this.frl) {
      localContentValues.put("card_tp_id", this.field_card_tp_id);
    }
    if (this.fYn) {
      localContentValues.put("from_username", this.field_from_username);
    }
    if (this.fYo) {
      localContentValues.put("consumer", this.field_consumer);
    }
    if (this.fxD) {
      localContentValues.put("app_id", this.field_app_id);
    }
    if (this.fji) {
      localContentValues.put("status", Integer.valueOf(this.field_status));
    }
    if (this.fYp) {
      localContentValues.put("share_time", Long.valueOf(this.field_share_time));
    }
    if (this.fYq) {
      localContentValues.put("local_updateTime", Long.valueOf(this.field_local_updateTime));
    }
    if (this.__hadSetupdateTime) {
      localContentValues.put("updateTime", Long.valueOf(this.field_updateTime));
    }
    if (this.fYr) {
      localContentValues.put("begin_time", Long.valueOf(this.field_begin_time));
    }
    if (this.fYs) {
      localContentValues.put("end_time", Long.valueOf(this.field_end_time));
    }
    if (this.fAA) {
      localContentValues.put("updateSeq", Long.valueOf(this.field_updateSeq));
    }
    if (this.fYt) {
      localContentValues.put("block_mask", Long.valueOf(this.field_block_mask));
    }
    if (this.fYu) {
      localContentValues.put("dataInfoData", this.field_dataInfoData);
    }
    if (this.fYv) {
      localContentValues.put("cardTpInfoData", this.field_cardTpInfoData);
    }
    if (this.fYw) {
      localContentValues.put("shareInfoData", this.field_shareInfoData);
    }
    if (this.fYx) {
      localContentValues.put("shopInfoData", this.field_shopInfoData);
    }
    if (this.fYy) {
      localContentValues.put("categoryType", Integer.valueOf(this.field_categoryType));
    }
    if (this.fYz) {
      localContentValues.put("itemIndex", Integer.valueOf(this.field_itemIndex));
    }
    if (this.systemRowid > 0L) {
      localContentValues.put("rowid", Long.valueOf(this.systemRowid));
    }
    return localContentValues;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.g.c.gc
 * JD-Core Version:    0.7.0.1
 */