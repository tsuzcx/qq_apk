package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;

public abstract class gb
  extends c
{
  public static final String[] INDEX_CREATE = { "CREATE INDEX IF NOT EXISTS UserCardInfo_card_type_index ON UserCardInfo(card_type)" };
  private static final int eEc;
  private static final int eZD;
  private static final int eZG;
  private static final int eZH;
  private static final int eZI;
  private static final int eZJ;
  private static final int eZK;
  private static final int eZL;
  private static final int eZM;
  private static final int eZN;
  private static final int elV;
  private static final int eol;
  private static final int euL = "card_type".hashCode();
  private static final int euO = "card_id".hashCode();
  private static final int euP = "card_tp_id".hashCode();
  private static final int fcV;
  private static final int fcW;
  private static final int fcX;
  private static final int fcY;
  private static final int fcZ;
  private static final int fda = "label_wording".hashCode();
  private static final int fdb = "is_dynamic".hashCode();
  private static final int rowid_HASHCODE = "rowid".hashCode();
  private boolean eDO = true;
  private boolean eZA = true;
  private boolean eZq = true;
  private boolean eZt = true;
  private boolean eZu = true;
  private boolean eZv = true;
  private boolean eZw = true;
  private boolean eZx = true;
  private boolean eZy = true;
  private boolean eZz = true;
  private boolean elS = true;
  private boolean eoi = true;
  private boolean eus = true;
  private boolean euv = true;
  private boolean euw = true;
  private boolean fcO = true;
  private boolean fcP = true;
  private boolean fcQ = true;
  private boolean fcR = true;
  private boolean fcS = true;
  private boolean fcT = true;
  private boolean fcU = true;
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
    eZD = "from_username".hashCode();
    elV = "status".hashCode();
    fcV = "delete_state_flag".hashCode();
    eZG = "local_updateTime".hashCode();
    eol = "updateTime".hashCode();
    eEc = "updateSeq".hashCode();
    fcW = "create_time".hashCode();
    eZH = "begin_time".hashCode();
    eZI = "end_time".hashCode();
    eZJ = "block_mask".hashCode();
    eZK = "dataInfoData".hashCode();
    eZL = "cardTpInfoData".hashCode();
    eZM = "shareInfoData".hashCode();
    eZN = "shopInfoData".hashCode();
    fcX = "stickyIndex".hashCode();
    fcY = "stickyEndTime".hashCode();
    fcZ = "stickyAnnouncement".hashCode();
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
      if (euP == k)
      {
        this.field_card_tp_id = paramCursor.getString(i);
      }
      else if (eZD == k)
      {
        this.field_from_username = paramCursor.getString(i);
      }
      else if (elV == k)
      {
        this.field_status = paramCursor.getInt(i);
      }
      else if (fcV == k)
      {
        this.field_delete_state_flag = paramCursor.getInt(i);
      }
      else if (eZG == k)
      {
        this.field_local_updateTime = paramCursor.getLong(i);
      }
      else if (eol == k)
      {
        this.field_updateTime = paramCursor.getLong(i);
      }
      else if (eEc == k)
      {
        this.field_updateSeq = paramCursor.getLong(i);
      }
      else if (fcW == k)
      {
        this.field_create_time = paramCursor.getLong(i);
      }
      else if (eZH == k)
      {
        this.field_begin_time = paramCursor.getLong(i);
      }
      else if (eZI == k)
      {
        this.field_end_time = paramCursor.getLong(i);
      }
      else if (eZJ == k)
      {
        this.field_block_mask = paramCursor.getString(i);
      }
      else if (eZK == k)
      {
        this.field_dataInfoData = paramCursor.getBlob(i);
      }
      else if (eZL == k)
      {
        this.field_cardTpInfoData = paramCursor.getBlob(i);
      }
      else if (eZM == k)
      {
        this.field_shareInfoData = paramCursor.getBlob(i);
      }
      else if (eZN == k)
      {
        this.field_shopInfoData = paramCursor.getBlob(i);
      }
      else if (fcX == k)
      {
        this.field_stickyIndex = paramCursor.getInt(i);
      }
      else if (fcY == k)
      {
        this.field_stickyEndTime = paramCursor.getInt(i);
      }
      else if (fcZ == k)
      {
        this.field_stickyAnnouncement = paramCursor.getString(i);
      }
      else if (euL == k)
      {
        this.field_card_type = paramCursor.getInt(i);
      }
      else if (fda == k)
      {
        this.field_label_wording = paramCursor.getString(i);
      }
      else
      {
        if (fdb == k)
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
    if (this.euv) {
      localContentValues.put("card_id", this.field_card_id);
    }
    if (this.euw) {
      localContentValues.put("card_tp_id", this.field_card_tp_id);
    }
    if (this.eZq) {
      localContentValues.put("from_username", this.field_from_username);
    }
    if (this.elS) {
      localContentValues.put("status", Integer.valueOf(this.field_status));
    }
    if (this.fcO) {
      localContentValues.put("delete_state_flag", Integer.valueOf(this.field_delete_state_flag));
    }
    if (this.eZt) {
      localContentValues.put("local_updateTime", Long.valueOf(this.field_local_updateTime));
    }
    if (this.eoi) {
      localContentValues.put("updateTime", Long.valueOf(this.field_updateTime));
    }
    if (this.eDO) {
      localContentValues.put("updateSeq", Long.valueOf(this.field_updateSeq));
    }
    if (this.fcP) {
      localContentValues.put("create_time", Long.valueOf(this.field_create_time));
    }
    if (this.eZu) {
      localContentValues.put("begin_time", Long.valueOf(this.field_begin_time));
    }
    if (this.eZv) {
      localContentValues.put("end_time", Long.valueOf(this.field_end_time));
    }
    if (this.eZw) {
      localContentValues.put("block_mask", this.field_block_mask);
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
    if (this.fcQ) {
      localContentValues.put("stickyIndex", Integer.valueOf(this.field_stickyIndex));
    }
    if (this.fcR) {
      localContentValues.put("stickyEndTime", Integer.valueOf(this.field_stickyEndTime));
    }
    if (this.fcS) {
      localContentValues.put("stickyAnnouncement", this.field_stickyAnnouncement);
    }
    if (this.eus) {
      localContentValues.put("card_type", Integer.valueOf(this.field_card_type));
    }
    if (this.fcT) {
      localContentValues.put("label_wording", this.field_label_wording);
    }
    if (this.fcU) {
      localContentValues.put("is_dynamic", Boolean.valueOf(this.field_is_dynamic));
    }
    if (this.systemRowid > 0L) {
      localContentValues.put("rowid", Long.valueOf(this.systemRowid));
    }
    return localContentValues;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.g.c.gb
 * JD-Core Version:    0.7.0.1
 */