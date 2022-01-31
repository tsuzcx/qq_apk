package com.tencent.mm.h.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;

public abstract class dx
  extends c
{
  private static final int cFM;
  private static final int cHZ = "updateSeq".hashCode();
  private static final int cXg;
  private static final int cXh;
  private static final int cXi;
  private static final int cXj;
  private static final int cXk;
  private static final int cXl;
  private static final int cXm = "block_mask".hashCode();
  private static final int cXn = "dataInfoData".hashCode();
  private static final int cXo = "cardTpInfoData".hashCode();
  private static final int cXp = "shareInfoData".hashCode();
  private static final int cXq = "shopInfoData".hashCode();
  private static final int cXr = "categoryType".hashCode();
  private static final int cXs = "itemIndex".hashCode();
  public static final String[] cqY = { "CREATE INDEX IF NOT EXISTS ShareCardInfo_card_tp_id_index ON ShareCardInfo(card_tp_id)" };
  private static final int crh = "rowid".hashCode();
  private static final int crn;
  private static final int ctG;
  private static final int czR = "card_id".hashCode();
  private static final int czS = "card_tp_id".hashCode();
  private boolean cFj = true;
  private boolean cHM = true;
  private boolean cWT = true;
  private boolean cWU = true;
  private boolean cWV = true;
  private boolean cWW = true;
  private boolean cWX = true;
  private boolean cWY = true;
  private boolean cWZ = true;
  private boolean cXa = true;
  private boolean cXb = true;
  private boolean cXc = true;
  private boolean cXd = true;
  private boolean cXe = true;
  private boolean cXf = true;
  private boolean crk = true;
  private boolean ctE = true;
  private boolean czA = true;
  private boolean czz = true;
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
    cXg = "from_username".hashCode();
    cXh = "consumer".hashCode();
    cFM = "app_id".hashCode();
    crn = "status".hashCode();
    cXi = "share_time".hashCode();
    cXj = "local_updateTime".hashCode();
    ctG = "updateTime".hashCode();
    cXk = "begin_time".hashCode();
    cXl = "end_time".hashCode();
  }
  
  public final void d(Cursor paramCursor)
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
      if (czR != k) {
        break label65;
      }
      this.field_card_id = paramCursor.getString(i);
      this.czz = true;
    }
    for (;;)
    {
      i += 1;
      break label20;
      break;
      label65:
      if (czS == k) {
        this.field_card_tp_id = paramCursor.getString(i);
      } else if (cXg == k) {
        this.field_from_username = paramCursor.getString(i);
      } else if (cXh == k) {
        this.field_consumer = paramCursor.getString(i);
      } else if (cFM == k) {
        this.field_app_id = paramCursor.getString(i);
      } else if (crn == k) {
        this.field_status = paramCursor.getInt(i);
      } else if (cXi == k) {
        this.field_share_time = paramCursor.getLong(i);
      } else if (cXj == k) {
        this.field_local_updateTime = paramCursor.getLong(i);
      } else if (ctG == k) {
        this.field_updateTime = paramCursor.getLong(i);
      } else if (cXk == k) {
        this.field_begin_time = paramCursor.getLong(i);
      } else if (cXl == k) {
        this.field_end_time = paramCursor.getLong(i);
      } else if (cHZ == k) {
        this.field_updateSeq = paramCursor.getLong(i);
      } else if (cXm == k) {
        this.field_block_mask = paramCursor.getLong(i);
      } else if (cXn == k) {
        this.field_dataInfoData = paramCursor.getBlob(i);
      } else if (cXo == k) {
        this.field_cardTpInfoData = paramCursor.getBlob(i);
      } else if (cXp == k) {
        this.field_shareInfoData = paramCursor.getBlob(i);
      } else if (cXq == k) {
        this.field_shopInfoData = paramCursor.getBlob(i);
      } else if (cXr == k) {
        this.field_categoryType = paramCursor.getInt(i);
      } else if (cXs == k) {
        this.field_itemIndex = paramCursor.getInt(i);
      } else if (crh == k) {
        this.ujK = paramCursor.getLong(i);
      }
    }
  }
  
  public final ContentValues vf()
  {
    ContentValues localContentValues = new ContentValues();
    if (this.czz) {
      localContentValues.put("card_id", this.field_card_id);
    }
    if (this.czA) {
      localContentValues.put("card_tp_id", this.field_card_tp_id);
    }
    if (this.cWT) {
      localContentValues.put("from_username", this.field_from_username);
    }
    if (this.cWU) {
      localContentValues.put("consumer", this.field_consumer);
    }
    if (this.cFj) {
      localContentValues.put("app_id", this.field_app_id);
    }
    if (this.crk) {
      localContentValues.put("status", Integer.valueOf(this.field_status));
    }
    if (this.cWV) {
      localContentValues.put("share_time", Long.valueOf(this.field_share_time));
    }
    if (this.cWW) {
      localContentValues.put("local_updateTime", Long.valueOf(this.field_local_updateTime));
    }
    if (this.ctE) {
      localContentValues.put("updateTime", Long.valueOf(this.field_updateTime));
    }
    if (this.cWX) {
      localContentValues.put("begin_time", Long.valueOf(this.field_begin_time));
    }
    if (this.cWY) {
      localContentValues.put("end_time", Long.valueOf(this.field_end_time));
    }
    if (this.cHM) {
      localContentValues.put("updateSeq", Long.valueOf(this.field_updateSeq));
    }
    if (this.cWZ) {
      localContentValues.put("block_mask", Long.valueOf(this.field_block_mask));
    }
    if (this.cXa) {
      localContentValues.put("dataInfoData", this.field_dataInfoData);
    }
    if (this.cXb) {
      localContentValues.put("cardTpInfoData", this.field_cardTpInfoData);
    }
    if (this.cXc) {
      localContentValues.put("shareInfoData", this.field_shareInfoData);
    }
    if (this.cXd) {
      localContentValues.put("shopInfoData", this.field_shopInfoData);
    }
    if (this.cXe) {
      localContentValues.put("categoryType", Integer.valueOf(this.field_categoryType));
    }
    if (this.cXf) {
      localContentValues.put("itemIndex", Integer.valueOf(this.field_itemIndex));
    }
    if (this.ujK > 0L) {
      localContentValues.put("rowid", Long.valueOf(this.ujK));
    }
    return localContentValues;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.h.c.dx
 * JD-Core Version:    0.7.0.1
 */