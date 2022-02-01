package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;

public abstract class gl
  extends c
{
  public static final String[] INDEX_CREATE = { "CREATE INDEX IF NOT EXISTS UserCardInfo_card_type_index ON UserCardInfo(card_type)" };
  private static final int eDc;
  private static final int eFq;
  private static final int eMi = "card_type".hashCode();
  private static final int eMl = "card_id".hashCode();
  private static final int eMm = "card_tp_id".hashCode();
  private static final int eVA;
  private static final int frR = "from_username".hashCode();
  private static final int frU;
  private static final int frV;
  private static final int frW;
  private static final int frX;
  private static final int frY;
  private static final int frZ;
  private static final int fsa;
  private static final int fsb;
  private static final int fvj;
  private static final int fvk;
  private static final int fvl;
  private static final int fvm;
  private static final int fvn;
  private static final int fvo = "label_wording".hashCode();
  private static final int fvp = "is_dynamic".hashCode();
  private static final int rowid_HASHCODE = "rowid".hashCode();
  private boolean eCZ = true;
  private boolean eFn = true;
  private boolean eLP = true;
  private boolean eLS = true;
  private boolean eLT = true;
  private boolean eVm = true;
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
  private boolean frE = true;
  private boolean frH = true;
  private boolean frI = true;
  private boolean frJ = true;
  private boolean frK = true;
  private boolean frL = true;
  private boolean frM = true;
  private boolean frN = true;
  private boolean frO = true;
  private boolean fvc = true;
  private boolean fvd = true;
  private boolean fve = true;
  private boolean fvf = true;
  private boolean fvg = true;
  private boolean fvh = true;
  private boolean fvi = true;
  
  static
  {
    eDc = "status".hashCode();
    fvj = "delete_state_flag".hashCode();
    frU = "local_updateTime".hashCode();
    eFq = "updateTime".hashCode();
    eVA = "updateSeq".hashCode();
    fvk = "create_time".hashCode();
    frV = "begin_time".hashCode();
    frW = "end_time".hashCode();
    frX = "block_mask".hashCode();
    frY = "dataInfoData".hashCode();
    frZ = "cardTpInfoData".hashCode();
    fsa = "shareInfoData".hashCode();
    fsb = "shopInfoData".hashCode();
    fvl = "stickyIndex".hashCode();
    fvm = "stickyEndTime".hashCode();
    fvn = "stickyAnnouncement".hashCode();
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
      if (eMm == k)
      {
        this.field_card_tp_id = paramCursor.getString(i);
      }
      else if (frR == k)
      {
        this.field_from_username = paramCursor.getString(i);
      }
      else if (eDc == k)
      {
        this.field_status = paramCursor.getInt(i);
      }
      else if (fvj == k)
      {
        this.field_delete_state_flag = paramCursor.getInt(i);
      }
      else if (frU == k)
      {
        this.field_local_updateTime = paramCursor.getLong(i);
      }
      else if (eFq == k)
      {
        this.field_updateTime = paramCursor.getLong(i);
      }
      else if (eVA == k)
      {
        this.field_updateSeq = paramCursor.getLong(i);
      }
      else if (fvk == k)
      {
        this.field_create_time = paramCursor.getLong(i);
      }
      else if (frV == k)
      {
        this.field_begin_time = paramCursor.getLong(i);
      }
      else if (frW == k)
      {
        this.field_end_time = paramCursor.getLong(i);
      }
      else if (frX == k)
      {
        this.field_block_mask = paramCursor.getString(i);
      }
      else if (frY == k)
      {
        this.field_dataInfoData = paramCursor.getBlob(i);
      }
      else if (frZ == k)
      {
        this.field_cardTpInfoData = paramCursor.getBlob(i);
      }
      else if (fsa == k)
      {
        this.field_shareInfoData = paramCursor.getBlob(i);
      }
      else if (fsb == k)
      {
        this.field_shopInfoData = paramCursor.getBlob(i);
      }
      else if (fvl == k)
      {
        this.field_stickyIndex = paramCursor.getInt(i);
      }
      else if (fvm == k)
      {
        this.field_stickyEndTime = paramCursor.getInt(i);
      }
      else if (fvn == k)
      {
        this.field_stickyAnnouncement = paramCursor.getString(i);
      }
      else if (eMi == k)
      {
        this.field_card_type = paramCursor.getInt(i);
      }
      else if (fvo == k)
      {
        this.field_label_wording = paramCursor.getString(i);
      }
      else
      {
        if (fvp == k)
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
    if (this.eLS) {
      localContentValues.put("card_id", this.field_card_id);
    }
    if (this.eLT) {
      localContentValues.put("card_tp_id", this.field_card_tp_id);
    }
    if (this.frE) {
      localContentValues.put("from_username", this.field_from_username);
    }
    if (this.eCZ) {
      localContentValues.put("status", Integer.valueOf(this.field_status));
    }
    if (this.fvc) {
      localContentValues.put("delete_state_flag", Integer.valueOf(this.field_delete_state_flag));
    }
    if (this.frH) {
      localContentValues.put("local_updateTime", Long.valueOf(this.field_local_updateTime));
    }
    if (this.eFn) {
      localContentValues.put("updateTime", Long.valueOf(this.field_updateTime));
    }
    if (this.eVm) {
      localContentValues.put("updateSeq", Long.valueOf(this.field_updateSeq));
    }
    if (this.fvd) {
      localContentValues.put("create_time", Long.valueOf(this.field_create_time));
    }
    if (this.frI) {
      localContentValues.put("begin_time", Long.valueOf(this.field_begin_time));
    }
    if (this.frJ) {
      localContentValues.put("end_time", Long.valueOf(this.field_end_time));
    }
    if (this.frK) {
      localContentValues.put("block_mask", this.field_block_mask);
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
    if (this.fve) {
      localContentValues.put("stickyIndex", Integer.valueOf(this.field_stickyIndex));
    }
    if (this.fvf) {
      localContentValues.put("stickyEndTime", Integer.valueOf(this.field_stickyEndTime));
    }
    if (this.fvg) {
      localContentValues.put("stickyAnnouncement", this.field_stickyAnnouncement);
    }
    if (this.eLP) {
      localContentValues.put("card_type", Integer.valueOf(this.field_card_type));
    }
    if (this.fvh) {
      localContentValues.put("label_wording", this.field_label_wording);
    }
    if (this.fvi) {
      localContentValues.put("is_dynamic", Boolean.valueOf(this.field_is_dynamic));
    }
    if (this.systemRowid > 0L) {
      localContentValues.put("rowid", Long.valueOf(this.systemRowid));
    }
    return localContentValues;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.g.c.gl
 * JD-Core Version:    0.7.0.1
 */