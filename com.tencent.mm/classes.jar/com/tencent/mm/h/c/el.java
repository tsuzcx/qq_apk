package com.tencent.mm.h.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;

public abstract class el
  extends c
{
  private static final int cHZ;
  private static final int cXg;
  private static final int cXj;
  private static final int cXk;
  private static final int cXl;
  private static final int cXm;
  private static final int cXn;
  private static final int cXo;
  private static final int cXp;
  private static final int cXq;
  private static final int cZC;
  private static final int cZD;
  private static final int cZE;
  private static final int cZF;
  private static final int cZG;
  private static final int cZH = "label_wording".hashCode();
  private static final int cZI = "is_dynamic".hashCode();
  public static final String[] cqY = { "CREATE INDEX IF NOT EXISTS UserCardInfo_card_type_index ON UserCardInfo(card_type)" };
  private static final int crh = "rowid".hashCode();
  private static final int crn;
  private static final int ctG;
  private static final int czO;
  private static final int czR = "card_id".hashCode();
  private static final int czS = "card_tp_id".hashCode();
  private boolean cHM = true;
  private boolean cWT = true;
  private boolean cWW = true;
  private boolean cWX = true;
  private boolean cWY = true;
  private boolean cWZ = true;
  private boolean cXa = true;
  private boolean cXb = true;
  private boolean cXc = true;
  private boolean cXd = true;
  private boolean cZA = true;
  private boolean cZB = true;
  private boolean cZv = true;
  private boolean cZw = true;
  private boolean cZx = true;
  private boolean cZy = true;
  private boolean cZz = true;
  private boolean crk = true;
  private boolean ctE = true;
  private boolean czA = true;
  private boolean czw = true;
  private boolean czz = true;
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
    cXg = "from_username".hashCode();
    crn = "status".hashCode();
    cZC = "delete_state_flag".hashCode();
    cXj = "local_updateTime".hashCode();
    ctG = "updateTime".hashCode();
    cHZ = "updateSeq".hashCode();
    cZD = "create_time".hashCode();
    cXk = "begin_time".hashCode();
    cXl = "end_time".hashCode();
    cXm = "block_mask".hashCode();
    cXn = "dataInfoData".hashCode();
    cXo = "cardTpInfoData".hashCode();
    cXp = "shareInfoData".hashCode();
    cXq = "shopInfoData".hashCode();
    cZE = "stickyIndex".hashCode();
    cZF = "stickyEndTime".hashCode();
    cZG = "stickyAnnouncement".hashCode();
    czO = "card_type".hashCode();
  }
  
  public final void d(Cursor paramCursor)
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
      if (czS == k)
      {
        this.field_card_tp_id = paramCursor.getString(i);
      }
      else if (cXg == k)
      {
        this.field_from_username = paramCursor.getString(i);
      }
      else if (crn == k)
      {
        this.field_status = paramCursor.getInt(i);
      }
      else if (cZC == k)
      {
        this.field_delete_state_flag = paramCursor.getInt(i);
      }
      else if (cXj == k)
      {
        this.field_local_updateTime = paramCursor.getLong(i);
      }
      else if (ctG == k)
      {
        this.field_updateTime = paramCursor.getLong(i);
      }
      else if (cHZ == k)
      {
        this.field_updateSeq = paramCursor.getLong(i);
      }
      else if (cZD == k)
      {
        this.field_create_time = paramCursor.getLong(i);
      }
      else if (cXk == k)
      {
        this.field_begin_time = paramCursor.getLong(i);
      }
      else if (cXl == k)
      {
        this.field_end_time = paramCursor.getLong(i);
      }
      else if (cXm == k)
      {
        this.field_block_mask = paramCursor.getString(i);
      }
      else if (cXn == k)
      {
        this.field_dataInfoData = paramCursor.getBlob(i);
      }
      else if (cXo == k)
      {
        this.field_cardTpInfoData = paramCursor.getBlob(i);
      }
      else if (cXp == k)
      {
        this.field_shareInfoData = paramCursor.getBlob(i);
      }
      else if (cXq == k)
      {
        this.field_shopInfoData = paramCursor.getBlob(i);
      }
      else if (cZE == k)
      {
        this.field_stickyIndex = paramCursor.getInt(i);
      }
      else if (cZF == k)
      {
        this.field_stickyEndTime = paramCursor.getInt(i);
      }
      else if (cZG == k)
      {
        this.field_stickyAnnouncement = paramCursor.getString(i);
      }
      else if (czO == k)
      {
        this.field_card_type = paramCursor.getInt(i);
      }
      else if (cZH == k)
      {
        this.field_label_wording = paramCursor.getString(i);
      }
      else
      {
        if (cZI == k)
        {
          if (paramCursor.getInt(i) != 0) {}
          for (boolean bool = true;; bool = false)
          {
            this.field_is_dynamic = bool;
            break;
          }
        }
        if (crh == k) {
          this.ujK = paramCursor.getLong(i);
        }
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
    if (this.crk) {
      localContentValues.put("status", Integer.valueOf(this.field_status));
    }
    if (this.cZv) {
      localContentValues.put("delete_state_flag", Integer.valueOf(this.field_delete_state_flag));
    }
    if (this.cWW) {
      localContentValues.put("local_updateTime", Long.valueOf(this.field_local_updateTime));
    }
    if (this.ctE) {
      localContentValues.put("updateTime", Long.valueOf(this.field_updateTime));
    }
    if (this.cHM) {
      localContentValues.put("updateSeq", Long.valueOf(this.field_updateSeq));
    }
    if (this.cZw) {
      localContentValues.put("create_time", Long.valueOf(this.field_create_time));
    }
    if (this.cWX) {
      localContentValues.put("begin_time", Long.valueOf(this.field_begin_time));
    }
    if (this.cWY) {
      localContentValues.put("end_time", Long.valueOf(this.field_end_time));
    }
    if (this.cWZ) {
      localContentValues.put("block_mask", this.field_block_mask);
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
    if (this.cZx) {
      localContentValues.put("stickyIndex", Integer.valueOf(this.field_stickyIndex));
    }
    if (this.cZy) {
      localContentValues.put("stickyEndTime", Integer.valueOf(this.field_stickyEndTime));
    }
    if (this.cZz) {
      localContentValues.put("stickyAnnouncement", this.field_stickyAnnouncement);
    }
    if (this.czw) {
      localContentValues.put("card_type", Integer.valueOf(this.field_card_type));
    }
    if (this.cZA) {
      localContentValues.put("label_wording", this.field_label_wording);
    }
    if (this.cZB) {
      localContentValues.put("is_dynamic", Boolean.valueOf(this.field_is_dynamic));
    }
    if (this.ujK > 0L) {
      localContentValues.put("rowid", Long.valueOf(this.ujK));
    }
    return localContentValues;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.h.c.el
 * JD-Core Version:    0.7.0.1
 */