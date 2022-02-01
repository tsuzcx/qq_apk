package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;

public abstract class fx
  extends c
{
  public static final String[] INDEX_CREATE = { "CREATE INDEX IF NOT EXISTS UserCardInfo_card_type_index ON UserCardInfo(card_type)" };
  private static final int eBI;
  private static final int eWp;
  private static final int eWs;
  private static final int eWt;
  private static final int eWu;
  private static final int eWv;
  private static final int eWw;
  private static final int eWx;
  private static final int eWy;
  private static final int eWz;
  private static final int eZJ;
  private static final int eZK;
  private static final int eZL;
  private static final int eZM;
  private static final int eZN;
  private static final int eZO = "label_wording".hashCode();
  private static final int eZP = "is_dynamic".hashCode();
  private static final int ejR;
  private static final int emf;
  private static final int esH;
  private static final int esK = "card_id".hashCode();
  private static final int esL = "card_tp_id".hashCode();
  private static final int rowid_HASHCODE = "rowid".hashCode();
  private boolean eBu = true;
  private boolean eWc = true;
  private boolean eWf = true;
  private boolean eWg = true;
  private boolean eWh = true;
  private boolean eWi = true;
  private boolean eWj = true;
  private boolean eWk = true;
  private boolean eWl = true;
  private boolean eWm = true;
  private boolean eZC = true;
  private boolean eZD = true;
  private boolean eZE = true;
  private boolean eZF = true;
  private boolean eZG = true;
  private boolean eZH = true;
  private boolean eZI = true;
  private boolean ejO = true;
  private boolean emc = true;
  private boolean eso = true;
  private boolean esr = true;
  private boolean ess = true;
  public long field_begin_time;
  public String field_block_mask;
  public byte[] field_cardTpInfoData;
  public String field_card_id;
  public String field_card_tp_id;
  public int field_card_type;
  public long field_create_time;
  public byte[] field_dataInfoData;
  public int field_delete_state_flag;
  public long field_end_time;
  public String field_from_username;
  public boolean field_is_dynamic;
  public String field_label_wording;
  public long field_local_updateTime;
  public byte[] field_shareInfoData;
  public byte[] field_shopInfoData;
  public int field_status;
  public String field_stickyAnnouncement;
  public int field_stickyEndTime;
  public int field_stickyIndex;
  public long field_updateSeq;
  public long field_updateTime;
  
  static
  {
    eWp = "from_username".hashCode();
    ejR = "status".hashCode();
    eZJ = "delete_state_flag".hashCode();
    eWs = "local_updateTime".hashCode();
    emf = "updateTime".hashCode();
    eBI = "updateSeq".hashCode();
    eZK = "create_time".hashCode();
    eWt = "begin_time".hashCode();
    eWu = "end_time".hashCode();
    eWv = "block_mask".hashCode();
    eWw = "dataInfoData".hashCode();
    eWx = "cardTpInfoData".hashCode();
    eWy = "shareInfoData".hashCode();
    eWz = "shopInfoData".hashCode();
    eZL = "stickyIndex".hashCode();
    eZM = "stickyEndTime".hashCode();
    eZN = "stickyAnnouncement".hashCode();
    esH = "card_type".hashCode();
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
      if (esL == k)
      {
        this.field_card_tp_id = paramCursor.getString(i);
      }
      else if (eWp == k)
      {
        this.field_from_username = paramCursor.getString(i);
      }
      else if (ejR == k)
      {
        this.field_status = paramCursor.getInt(i);
      }
      else if (eZJ == k)
      {
        this.field_delete_state_flag = paramCursor.getInt(i);
      }
      else if (eWs == k)
      {
        this.field_local_updateTime = paramCursor.getLong(i);
      }
      else if (emf == k)
      {
        this.field_updateTime = paramCursor.getLong(i);
      }
      else if (eBI == k)
      {
        this.field_updateSeq = paramCursor.getLong(i);
      }
      else if (eZK == k)
      {
        this.field_create_time = paramCursor.getLong(i);
      }
      else if (eWt == k)
      {
        this.field_begin_time = paramCursor.getLong(i);
      }
      else if (eWu == k)
      {
        this.field_end_time = paramCursor.getLong(i);
      }
      else if (eWv == k)
      {
        this.field_block_mask = paramCursor.getString(i);
      }
      else if (eWw == k)
      {
        this.field_dataInfoData = paramCursor.getBlob(i);
      }
      else if (eWx == k)
      {
        this.field_cardTpInfoData = paramCursor.getBlob(i);
      }
      else if (eWy == k)
      {
        this.field_shareInfoData = paramCursor.getBlob(i);
      }
      else if (eWz == k)
      {
        this.field_shopInfoData = paramCursor.getBlob(i);
      }
      else if (eZL == k)
      {
        this.field_stickyIndex = paramCursor.getInt(i);
      }
      else if (eZM == k)
      {
        this.field_stickyEndTime = paramCursor.getInt(i);
      }
      else if (eZN == k)
      {
        this.field_stickyAnnouncement = paramCursor.getString(i);
      }
      else if (esH == k)
      {
        this.field_card_type = paramCursor.getInt(i);
      }
      else if (eZO == k)
      {
        this.field_label_wording = paramCursor.getString(i);
      }
      else
      {
        if (eZP == k)
        {
          if (paramCursor.getInt(i) != 0) {}
          for (boolean bool = true;; bool = false)
          {
            this.field_is_dynamic = bool;
            break;
          }
        }
        if (rowid_HASHCODE == k) {
          this.systemRowid = paramCursor.getLong(i);
        }
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
    if (this.ejO) {
      localContentValues.put("status", Integer.valueOf(this.field_status));
    }
    if (this.eZC) {
      localContentValues.put("delete_state_flag", Integer.valueOf(this.field_delete_state_flag));
    }
    if (this.eWf) {
      localContentValues.put("local_updateTime", Long.valueOf(this.field_local_updateTime));
    }
    if (this.emc) {
      localContentValues.put("updateTime", Long.valueOf(this.field_updateTime));
    }
    if (this.eBu) {
      localContentValues.put("updateSeq", Long.valueOf(this.field_updateSeq));
    }
    if (this.eZD) {
      localContentValues.put("create_time", Long.valueOf(this.field_create_time));
    }
    if (this.eWg) {
      localContentValues.put("begin_time", Long.valueOf(this.field_begin_time));
    }
    if (this.eWh) {
      localContentValues.put("end_time", Long.valueOf(this.field_end_time));
    }
    if (this.eWi) {
      localContentValues.put("block_mask", this.field_block_mask);
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
    if (this.eZE) {
      localContentValues.put("stickyIndex", Integer.valueOf(this.field_stickyIndex));
    }
    if (this.eZF) {
      localContentValues.put("stickyEndTime", Integer.valueOf(this.field_stickyEndTime));
    }
    if (this.eZG) {
      localContentValues.put("stickyAnnouncement", this.field_stickyAnnouncement);
    }
    if (this.eso) {
      localContentValues.put("card_type", Integer.valueOf(this.field_card_type));
    }
    if (this.eZH) {
      localContentValues.put("label_wording", this.field_label_wording);
    }
    if (this.eZI) {
      localContentValues.put("is_dynamic", Boolean.valueOf(this.field_is_dynamic));
    }
    if (this.systemRowid > 0L) {
      localContentValues.put("rowid", Long.valueOf(this.systemRowid));
    }
    return localContentValues;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.g.c.fx
 * JD-Core Version:    0.7.0.1
 */