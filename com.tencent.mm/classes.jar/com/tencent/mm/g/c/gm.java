package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;

public abstract class gm
  extends c
{
  public static final String[] INDEX_CREATE = { "CREATE INDEX IF NOT EXISTS UserCardInfo_card_type_index ON UserCardInfo(card_type)" };
  private static final int eEL;
  private static final int eGZ;
  private static final int eNT = "card_type".hashCode();
  private static final int eNW = "card_id".hashCode();
  private static final int eNX = "card_tp_id".hashCode();
  private static final int eXl;
  private static final int ftR = "from_username".hashCode();
  private static final int ftU;
  private static final int ftV;
  private static final int ftW;
  private static final int ftX;
  private static final int ftY;
  private static final int ftZ;
  private static final int fua;
  private static final int fub;
  private static final int fxj;
  private static final int fxk;
  private static final int fxl;
  private static final int fxm;
  private static final int fxn;
  private static final int fxo = "label_wording".hashCode();
  private static final int fxp = "is_dynamic".hashCode();
  private static final int rowid_HASHCODE = "rowid".hashCode();
  private boolean eEI = true;
  private boolean eGW = true;
  private boolean eNA = true;
  private boolean eND = true;
  private boolean eNE = true;
  private boolean eWX = true;
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
  private boolean ftE = true;
  private boolean ftH = true;
  private boolean ftI = true;
  private boolean ftJ = true;
  private boolean ftK = true;
  private boolean ftL = true;
  private boolean ftM = true;
  private boolean ftN = true;
  private boolean ftO = true;
  private boolean fxc = true;
  private boolean fxd = true;
  private boolean fxe = true;
  private boolean fxf = true;
  private boolean fxg = true;
  private boolean fxh = true;
  private boolean fxi = true;
  
  static
  {
    eEL = "status".hashCode();
    fxj = "delete_state_flag".hashCode();
    ftU = "local_updateTime".hashCode();
    eGZ = "updateTime".hashCode();
    eXl = "updateSeq".hashCode();
    fxk = "create_time".hashCode();
    ftV = "begin_time".hashCode();
    ftW = "end_time".hashCode();
    ftX = "block_mask".hashCode();
    ftY = "dataInfoData".hashCode();
    ftZ = "cardTpInfoData".hashCode();
    fua = "shareInfoData".hashCode();
    fub = "shopInfoData".hashCode();
    fxl = "stickyIndex".hashCode();
    fxm = "stickyEndTime".hashCode();
    fxn = "stickyAnnouncement".hashCode();
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
      if (eNX == k)
      {
        this.field_card_tp_id = paramCursor.getString(i);
      }
      else if (ftR == k)
      {
        this.field_from_username = paramCursor.getString(i);
      }
      else if (eEL == k)
      {
        this.field_status = paramCursor.getInt(i);
      }
      else if (fxj == k)
      {
        this.field_delete_state_flag = paramCursor.getInt(i);
      }
      else if (ftU == k)
      {
        this.field_local_updateTime = paramCursor.getLong(i);
      }
      else if (eGZ == k)
      {
        this.field_updateTime = paramCursor.getLong(i);
      }
      else if (eXl == k)
      {
        this.field_updateSeq = paramCursor.getLong(i);
      }
      else if (fxk == k)
      {
        this.field_create_time = paramCursor.getLong(i);
      }
      else if (ftV == k)
      {
        this.field_begin_time = paramCursor.getLong(i);
      }
      else if (ftW == k)
      {
        this.field_end_time = paramCursor.getLong(i);
      }
      else if (ftX == k)
      {
        this.field_block_mask = paramCursor.getString(i);
      }
      else if (ftY == k)
      {
        this.field_dataInfoData = paramCursor.getBlob(i);
      }
      else if (ftZ == k)
      {
        this.field_cardTpInfoData = paramCursor.getBlob(i);
      }
      else if (fua == k)
      {
        this.field_shareInfoData = paramCursor.getBlob(i);
      }
      else if (fub == k)
      {
        this.field_shopInfoData = paramCursor.getBlob(i);
      }
      else if (fxl == k)
      {
        this.field_stickyIndex = paramCursor.getInt(i);
      }
      else if (fxm == k)
      {
        this.field_stickyEndTime = paramCursor.getInt(i);
      }
      else if (fxn == k)
      {
        this.field_stickyAnnouncement = paramCursor.getString(i);
      }
      else if (eNT == k)
      {
        this.field_card_type = paramCursor.getInt(i);
      }
      else if (fxo == k)
      {
        this.field_label_wording = paramCursor.getString(i);
      }
      else
      {
        if (fxp == k)
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
    if (this.eND) {
      localContentValues.put("card_id", this.field_card_id);
    }
    if (this.eNE) {
      localContentValues.put("card_tp_id", this.field_card_tp_id);
    }
    if (this.ftE) {
      localContentValues.put("from_username", this.field_from_username);
    }
    if (this.eEI) {
      localContentValues.put("status", Integer.valueOf(this.field_status));
    }
    if (this.fxc) {
      localContentValues.put("delete_state_flag", Integer.valueOf(this.field_delete_state_flag));
    }
    if (this.ftH) {
      localContentValues.put("local_updateTime", Long.valueOf(this.field_local_updateTime));
    }
    if (this.eGW) {
      localContentValues.put("updateTime", Long.valueOf(this.field_updateTime));
    }
    if (this.eWX) {
      localContentValues.put("updateSeq", Long.valueOf(this.field_updateSeq));
    }
    if (this.fxd) {
      localContentValues.put("create_time", Long.valueOf(this.field_create_time));
    }
    if (this.ftI) {
      localContentValues.put("begin_time", Long.valueOf(this.field_begin_time));
    }
    if (this.ftJ) {
      localContentValues.put("end_time", Long.valueOf(this.field_end_time));
    }
    if (this.ftK) {
      localContentValues.put("block_mask", this.field_block_mask);
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
    if (this.fxe) {
      localContentValues.put("stickyIndex", Integer.valueOf(this.field_stickyIndex));
    }
    if (this.fxf) {
      localContentValues.put("stickyEndTime", Integer.valueOf(this.field_stickyEndTime));
    }
    if (this.fxg) {
      localContentValues.put("stickyAnnouncement", this.field_stickyAnnouncement);
    }
    if (this.eNA) {
      localContentValues.put("card_type", Integer.valueOf(this.field_card_type));
    }
    if (this.fxh) {
      localContentValues.put("label_wording", this.field_label_wording);
    }
    if (this.fxi) {
      localContentValues.put("is_dynamic", Boolean.valueOf(this.field_is_dynamic));
    }
    if (this.systemRowid > 0L) {
      localContentValues.put("rowid", Long.valueOf(this.systemRowid));
    }
    return localContentValues;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.g.c.gm
 * JD-Core Version:    0.7.0.1
 */