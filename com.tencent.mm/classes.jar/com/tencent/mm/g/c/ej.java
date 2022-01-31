package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;

public abstract class ej
  extends c
{
  public static final String[] INDEX_CREATE = { "CREATE INDEX IF NOT EXISTS ShareCardInfo_card_tp_id_index ON ShareCardInfo(card_tp_id)" };
  private static final int dNA;
  private static final int dNB;
  private static final int dNC;
  private static final int dND;
  private static final int dNE;
  private static final int dNF;
  private static final int dNG = "block_mask".hashCode();
  private static final int dNH = "dataInfoData".hashCode();
  private static final int dNI = "cardTpInfoData".hashCode();
  private static final int dNJ = "shareInfoData".hashCode();
  private static final int dNK = "shopInfoData".hashCode();
  private static final int dNL = "categoryType".hashCode();
  private static final int dNM = "itemIndex".hashCode();
  private static final int dfJ;
  private static final int dhV;
  private static final int dnT = "card_id".hashCode();
  private static final int dnU = "card_tp_id".hashCode();
  private static final int duh;
  private static final int dwI;
  private static final int rowid_HASHCODE = "rowid".hashCode();
  private boolean dNn = true;
  private boolean dNo = true;
  private boolean dNp = true;
  private boolean dNq = true;
  private boolean dNr = true;
  private boolean dNs = true;
  private boolean dNt = true;
  private boolean dNu = true;
  private boolean dNv = true;
  private boolean dNw = true;
  private boolean dNx = true;
  private boolean dNy = true;
  private boolean dNz = true;
  private boolean dfG = true;
  private boolean dhT = true;
  private boolean dnA = true;
  private boolean dnB = true;
  private boolean dtv = true;
  private boolean dwu = true;
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
    dNA = "from_username".hashCode();
    dNB = "consumer".hashCode();
    duh = "app_id".hashCode();
    dfJ = "status".hashCode();
    dNC = "share_time".hashCode();
    dND = "local_updateTime".hashCode();
    dhV = "updateTime".hashCode();
    dNE = "begin_time".hashCode();
    dNF = "end_time".hashCode();
    dwI = "updateSeq".hashCode();
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
      if (dnT != k) {
        break label65;
      }
      this.field_card_id = paramCursor.getString(i);
      this.dnA = true;
    }
    for (;;)
    {
      i += 1;
      break label20;
      break;
      label65:
      if (dnU == k) {
        this.field_card_tp_id = paramCursor.getString(i);
      } else if (dNA == k) {
        this.field_from_username = paramCursor.getString(i);
      } else if (dNB == k) {
        this.field_consumer = paramCursor.getString(i);
      } else if (duh == k) {
        this.field_app_id = paramCursor.getString(i);
      } else if (dfJ == k) {
        this.field_status = paramCursor.getInt(i);
      } else if (dNC == k) {
        this.field_share_time = paramCursor.getLong(i);
      } else if (dND == k) {
        this.field_local_updateTime = paramCursor.getLong(i);
      } else if (dhV == k) {
        this.field_updateTime = paramCursor.getLong(i);
      } else if (dNE == k) {
        this.field_begin_time = paramCursor.getLong(i);
      } else if (dNF == k) {
        this.field_end_time = paramCursor.getLong(i);
      } else if (dwI == k) {
        this.field_updateSeq = paramCursor.getLong(i);
      } else if (dNG == k) {
        this.field_block_mask = paramCursor.getLong(i);
      } else if (dNH == k) {
        this.field_dataInfoData = paramCursor.getBlob(i);
      } else if (dNI == k) {
        this.field_cardTpInfoData = paramCursor.getBlob(i);
      } else if (dNJ == k) {
        this.field_shareInfoData = paramCursor.getBlob(i);
      } else if (dNK == k) {
        this.field_shopInfoData = paramCursor.getBlob(i);
      } else if (dNL == k) {
        this.field_categoryType = paramCursor.getInt(i);
      } else if (dNM == k) {
        this.field_itemIndex = paramCursor.getInt(i);
      } else if (rowid_HASHCODE == k) {
        this.systemRowid = paramCursor.getLong(i);
      }
    }
  }
  
  public ContentValues convertTo()
  {
    ContentValues localContentValues = new ContentValues();
    if (this.dnA) {
      localContentValues.put("card_id", this.field_card_id);
    }
    if (this.dnB) {
      localContentValues.put("card_tp_id", this.field_card_tp_id);
    }
    if (this.dNn) {
      localContentValues.put("from_username", this.field_from_username);
    }
    if (this.dNo) {
      localContentValues.put("consumer", this.field_consumer);
    }
    if (this.dtv) {
      localContentValues.put("app_id", this.field_app_id);
    }
    if (this.dfG) {
      localContentValues.put("status", Integer.valueOf(this.field_status));
    }
    if (this.dNp) {
      localContentValues.put("share_time", Long.valueOf(this.field_share_time));
    }
    if (this.dNq) {
      localContentValues.put("local_updateTime", Long.valueOf(this.field_local_updateTime));
    }
    if (this.dhT) {
      localContentValues.put("updateTime", Long.valueOf(this.field_updateTime));
    }
    if (this.dNr) {
      localContentValues.put("begin_time", Long.valueOf(this.field_begin_time));
    }
    if (this.dNs) {
      localContentValues.put("end_time", Long.valueOf(this.field_end_time));
    }
    if (this.dwu) {
      localContentValues.put("updateSeq", Long.valueOf(this.field_updateSeq));
    }
    if (this.dNt) {
      localContentValues.put("block_mask", Long.valueOf(this.field_block_mask));
    }
    if (this.dNu) {
      localContentValues.put("dataInfoData", this.field_dataInfoData);
    }
    if (this.dNv) {
      localContentValues.put("cardTpInfoData", this.field_cardTpInfoData);
    }
    if (this.dNw) {
      localContentValues.put("shareInfoData", this.field_shareInfoData);
    }
    if (this.dNx) {
      localContentValues.put("shopInfoData", this.field_shopInfoData);
    }
    if (this.dNy) {
      localContentValues.put("categoryType", Integer.valueOf(this.field_categoryType));
    }
    if (this.dNz) {
      localContentValues.put("itemIndex", Integer.valueOf(this.field_itemIndex));
    }
    if (this.systemRowid > 0L) {
      localContentValues.put("rowid", Long.valueOf(this.systemRowid));
    }
    return localContentValues;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.g.c.ej
 * JD-Core Version:    0.7.0.1
 */