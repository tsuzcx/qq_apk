package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;

public abstract class fs
  extends c
{
  public static final String[] INDEX_CREATE = { "CREATE INDEX IF NOT EXISTS ShareCardInfo_card_tp_id_index ON ShareCardInfo(card_tp_id)" };
  private static final int eDc;
  private static final int eFq;
  private static final int eMl = "card_id".hashCode();
  private static final int eMm = "card_tp_id".hashCode();
  private static final int eSZ;
  private static final int eVA = "updateSeq".hashCode();
  private static final int frR = "from_username".hashCode();
  private static final int frS = "consumer".hashCode();
  private static final int frT;
  private static final int frU;
  private static final int frV;
  private static final int frW;
  private static final int frX = "block_mask".hashCode();
  private static final int frY = "dataInfoData".hashCode();
  private static final int frZ = "cardTpInfoData".hashCode();
  private static final int fsa = "shareInfoData".hashCode();
  private static final int fsb = "shopInfoData".hashCode();
  private static final int fsc = "categoryType".hashCode();
  private static final int fsd = "itemIndex".hashCode();
  private static final int rowid_HASHCODE = "rowid".hashCode();
  private boolean eCZ = true;
  private boolean eFn = true;
  private boolean eLS = true;
  private boolean eLT = true;
  private boolean eSn = true;
  private boolean eVm = true;
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
  private boolean frE = true;
  private boolean frF = true;
  private boolean frG = true;
  private boolean frH = true;
  private boolean frI = true;
  private boolean frJ = true;
  private boolean frK = true;
  private boolean frL = true;
  private boolean frM = true;
  private boolean frN = true;
  private boolean frO = true;
  private boolean frP = true;
  private boolean frQ = true;
  
  static
  {
    eSZ = "app_id".hashCode();
    eDc = "status".hashCode();
    frT = "share_time".hashCode();
    frU = "local_updateTime".hashCode();
    eFq = "updateTime".hashCode();
    frV = "begin_time".hashCode();
    frW = "end_time".hashCode();
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
      if (eMl != k) {
        break label65;
      }
      this.field_card_id = paramCursor.getString(i);
      this.eLS = true;
    }
    for (;;)
    {
      i += 1;
      break label20;
      break;
      label65:
      if (eMm == k) {
        this.field_card_tp_id = paramCursor.getString(i);
      } else if (frR == k) {
        this.field_from_username = paramCursor.getString(i);
      } else if (frS == k) {
        this.field_consumer = paramCursor.getString(i);
      } else if (eSZ == k) {
        this.field_app_id = paramCursor.getString(i);
      } else if (eDc == k) {
        this.field_status = paramCursor.getInt(i);
      } else if (frT == k) {
        this.field_share_time = paramCursor.getLong(i);
      } else if (frU == k) {
        this.field_local_updateTime = paramCursor.getLong(i);
      } else if (eFq == k) {
        this.field_updateTime = paramCursor.getLong(i);
      } else if (frV == k) {
        this.field_begin_time = paramCursor.getLong(i);
      } else if (frW == k) {
        this.field_end_time = paramCursor.getLong(i);
      } else if (eVA == k) {
        this.field_updateSeq = paramCursor.getLong(i);
      } else if (frX == k) {
        this.field_block_mask = paramCursor.getLong(i);
      } else if (frY == k) {
        this.field_dataInfoData = paramCursor.getBlob(i);
      } else if (frZ == k) {
        this.field_cardTpInfoData = paramCursor.getBlob(i);
      } else if (fsa == k) {
        this.field_shareInfoData = paramCursor.getBlob(i);
      } else if (fsb == k) {
        this.field_shopInfoData = paramCursor.getBlob(i);
      } else if (fsc == k) {
        this.field_categoryType = paramCursor.getInt(i);
      } else if (fsd == k) {
        this.field_itemIndex = paramCursor.getInt(i);
      } else if (rowid_HASHCODE == k) {
        this.systemRowid = paramCursor.getLong(i);
      }
    }
  }
  
  public ContentValues convertTo()
  {
    ContentValues localContentValues = new ContentValues();
    if (this.eLS) {
      localContentValues.put("card_id", this.field_card_id);
    }
    if (this.eLT) {
      localContentValues.put("card_tp_id", this.field_card_tp_id);
    }
    if (this.frE) {
      localContentValues.put("from_username", this.field_from_username);
    }
    if (this.frF) {
      localContentValues.put("consumer", this.field_consumer);
    }
    if (this.eSn) {
      localContentValues.put("app_id", this.field_app_id);
    }
    if (this.eCZ) {
      localContentValues.put("status", Integer.valueOf(this.field_status));
    }
    if (this.frG) {
      localContentValues.put("share_time", Long.valueOf(this.field_share_time));
    }
    if (this.frH) {
      localContentValues.put("local_updateTime", Long.valueOf(this.field_local_updateTime));
    }
    if (this.eFn) {
      localContentValues.put("updateTime", Long.valueOf(this.field_updateTime));
    }
    if (this.frI) {
      localContentValues.put("begin_time", Long.valueOf(this.field_begin_time));
    }
    if (this.frJ) {
      localContentValues.put("end_time", Long.valueOf(this.field_end_time));
    }
    if (this.eVm) {
      localContentValues.put("updateSeq", Long.valueOf(this.field_updateSeq));
    }
    if (this.frK) {
      localContentValues.put("block_mask", Long.valueOf(this.field_block_mask));
    }
    if (this.frL) {
      localContentValues.put("dataInfoData", this.field_dataInfoData);
    }
    if (this.frM) {
      localContentValues.put("cardTpInfoData", this.field_cardTpInfoData);
    }
    if (this.frN) {
      localContentValues.put("shareInfoData", this.field_shareInfoData);
    }
    if (this.frO) {
      localContentValues.put("shopInfoData", this.field_shopInfoData);
    }
    if (this.frP) {
      localContentValues.put("categoryType", Integer.valueOf(this.field_categoryType));
    }
    if (this.frQ) {
      localContentValues.put("itemIndex", Integer.valueOf(this.field_itemIndex));
    }
    if (this.systemRowid > 0L) {
      localContentValues.put("rowid", Long.valueOf(this.systemRowid));
    }
    return localContentValues;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.g.c.fs
 * JD-Core Version:    0.7.0.1
 */