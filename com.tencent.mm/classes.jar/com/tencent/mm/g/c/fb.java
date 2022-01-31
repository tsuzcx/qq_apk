package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;

public abstract class fb
  extends c
{
  public static final String[] INDEX_CREATE = { "CREATE INDEX IF NOT EXISTS UserCardInfo_card_type_index ON UserCardInfo(card_type)" };
  private static final int dNA;
  private static final int dND;
  private static final int dNE;
  private static final int dNF;
  private static final int dNG;
  private static final int dNH;
  private static final int dNI;
  private static final int dNJ;
  private static final int dNK;
  private static final int dQU;
  private static final int dQV;
  private static final int dQW;
  private static final int dQX;
  private static final int dQY;
  private static final int dQZ = "label_wording".hashCode();
  private static final int dRa = "is_dynamic".hashCode();
  private static final int dfJ;
  private static final int dhV;
  private static final int dnQ;
  private static final int dnT = "card_id".hashCode();
  private static final int dnU = "card_tp_id".hashCode();
  private static final int dwI;
  private static final int rowid_HASHCODE = "rowid".hashCode();
  private boolean dNn = true;
  private boolean dNq = true;
  private boolean dNr = true;
  private boolean dNs = true;
  private boolean dNt = true;
  private boolean dNu = true;
  private boolean dNv = true;
  private boolean dNw = true;
  private boolean dNx = true;
  private boolean dQN = true;
  private boolean dQO = true;
  private boolean dQP = true;
  private boolean dQQ = true;
  private boolean dQR = true;
  private boolean dQS = true;
  private boolean dQT = true;
  private boolean dfG = true;
  private boolean dhT = true;
  private boolean dnA = true;
  private boolean dnB = true;
  private boolean dnx = true;
  private boolean dwu = true;
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
    dNA = "from_username".hashCode();
    dfJ = "status".hashCode();
    dQU = "delete_state_flag".hashCode();
    dND = "local_updateTime".hashCode();
    dhV = "updateTime".hashCode();
    dwI = "updateSeq".hashCode();
    dQV = "create_time".hashCode();
    dNE = "begin_time".hashCode();
    dNF = "end_time".hashCode();
    dNG = "block_mask".hashCode();
    dNH = "dataInfoData".hashCode();
    dNI = "cardTpInfoData".hashCode();
    dNJ = "shareInfoData".hashCode();
    dNK = "shopInfoData".hashCode();
    dQW = "stickyIndex".hashCode();
    dQX = "stickyEndTime".hashCode();
    dQY = "stickyAnnouncement".hashCode();
    dnQ = "card_type".hashCode();
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
      if (dnU == k)
      {
        this.field_card_tp_id = paramCursor.getString(i);
      }
      else if (dNA == k)
      {
        this.field_from_username = paramCursor.getString(i);
      }
      else if (dfJ == k)
      {
        this.field_status = paramCursor.getInt(i);
      }
      else if (dQU == k)
      {
        this.field_delete_state_flag = paramCursor.getInt(i);
      }
      else if (dND == k)
      {
        this.field_local_updateTime = paramCursor.getLong(i);
      }
      else if (dhV == k)
      {
        this.field_updateTime = paramCursor.getLong(i);
      }
      else if (dwI == k)
      {
        this.field_updateSeq = paramCursor.getLong(i);
      }
      else if (dQV == k)
      {
        this.field_create_time = paramCursor.getLong(i);
      }
      else if (dNE == k)
      {
        this.field_begin_time = paramCursor.getLong(i);
      }
      else if (dNF == k)
      {
        this.field_end_time = paramCursor.getLong(i);
      }
      else if (dNG == k)
      {
        this.field_block_mask = paramCursor.getString(i);
      }
      else if (dNH == k)
      {
        this.field_dataInfoData = paramCursor.getBlob(i);
      }
      else if (dNI == k)
      {
        this.field_cardTpInfoData = paramCursor.getBlob(i);
      }
      else if (dNJ == k)
      {
        this.field_shareInfoData = paramCursor.getBlob(i);
      }
      else if (dNK == k)
      {
        this.field_shopInfoData = paramCursor.getBlob(i);
      }
      else if (dQW == k)
      {
        this.field_stickyIndex = paramCursor.getInt(i);
      }
      else if (dQX == k)
      {
        this.field_stickyEndTime = paramCursor.getInt(i);
      }
      else if (dQY == k)
      {
        this.field_stickyAnnouncement = paramCursor.getString(i);
      }
      else if (dnQ == k)
      {
        this.field_card_type = paramCursor.getInt(i);
      }
      else if (dQZ == k)
      {
        this.field_label_wording = paramCursor.getString(i);
      }
      else
      {
        if (dRa == k)
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
    if (this.dnA) {
      localContentValues.put("card_id", this.field_card_id);
    }
    if (this.dnB) {
      localContentValues.put("card_tp_id", this.field_card_tp_id);
    }
    if (this.dNn) {
      localContentValues.put("from_username", this.field_from_username);
    }
    if (this.dfG) {
      localContentValues.put("status", Integer.valueOf(this.field_status));
    }
    if (this.dQN) {
      localContentValues.put("delete_state_flag", Integer.valueOf(this.field_delete_state_flag));
    }
    if (this.dNq) {
      localContentValues.put("local_updateTime", Long.valueOf(this.field_local_updateTime));
    }
    if (this.dhT) {
      localContentValues.put("updateTime", Long.valueOf(this.field_updateTime));
    }
    if (this.dwu) {
      localContentValues.put("updateSeq", Long.valueOf(this.field_updateSeq));
    }
    if (this.dQO) {
      localContentValues.put("create_time", Long.valueOf(this.field_create_time));
    }
    if (this.dNr) {
      localContentValues.put("begin_time", Long.valueOf(this.field_begin_time));
    }
    if (this.dNs) {
      localContentValues.put("end_time", Long.valueOf(this.field_end_time));
    }
    if (this.dNt) {
      localContentValues.put("block_mask", this.field_block_mask);
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
    if (this.dQP) {
      localContentValues.put("stickyIndex", Integer.valueOf(this.field_stickyIndex));
    }
    if (this.dQQ) {
      localContentValues.put("stickyEndTime", Integer.valueOf(this.field_stickyEndTime));
    }
    if (this.dQR) {
      localContentValues.put("stickyAnnouncement", this.field_stickyAnnouncement);
    }
    if (this.dnx) {
      localContentValues.put("card_type", Integer.valueOf(this.field_card_type));
    }
    if (this.dQS) {
      localContentValues.put("label_wording", this.field_label_wording);
    }
    if (this.dQT) {
      localContentValues.put("is_dynamic", Boolean.valueOf(this.field_is_dynamic));
    }
    if (this.systemRowid > 0L) {
      localContentValues.put("rowid", Long.valueOf(this.systemRowid));
    }
    return localContentValues;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.g.c.fb
 * JD-Core Version:    0.7.0.1
 */