package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.storage.IAutoDBItem;

public abstract class gx
  extends IAutoDBItem
{
  public static final String[] INDEX_CREATE = { "CREATE INDEX IF NOT EXISTS UserCardInfo_card_type_index ON UserCardInfo(card_type)" };
  private static final int fAO;
  private static final int fYA;
  private static final int fYD;
  private static final int fYE;
  private static final int fYF;
  private static final int fYG;
  private static final int fYH;
  private static final int fYI;
  private static final int fYJ;
  private static final int fYK;
  private static final int fjl;
  private static final int frA = "card_type".hashCode();
  private static final int frD = "card_id".hashCode();
  private static final int frE = "card_tp_id".hashCode();
  private static final int gcb;
  private static final int gcc;
  private static final int gcd;
  private static final int gce;
  private static final int gcf;
  private static final int gcg = "label_wording".hashCode();
  private static final int gch = "is_dynamic".hashCode();
  private static final int rowid_HASHCODE = "rowid".hashCode();
  private static final int updateTime_HASHCODE;
  private boolean __hadSetupdateTime = true;
  private boolean fAA = true;
  private boolean fYn = true;
  private boolean fYq = true;
  private boolean fYr = true;
  private boolean fYs = true;
  private boolean fYt = true;
  private boolean fYu = true;
  private boolean fYv = true;
  private boolean fYw = true;
  private boolean fYx = true;
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
  private boolean fji = true;
  private boolean frh = true;
  private boolean frk = true;
  private boolean frl = true;
  private boolean gbU = true;
  private boolean gbV = true;
  private boolean gbW = true;
  private boolean gbX = true;
  private boolean gbY = true;
  private boolean gbZ = true;
  private boolean gca = true;
  
  static
  {
    fYA = "from_username".hashCode();
    fjl = "status".hashCode();
    gcb = "delete_state_flag".hashCode();
    fYD = "local_updateTime".hashCode();
    updateTime_HASHCODE = "updateTime".hashCode();
    fAO = "updateSeq".hashCode();
    gcc = "create_time".hashCode();
    fYE = "begin_time".hashCode();
    fYF = "end_time".hashCode();
    fYG = "block_mask".hashCode();
    fYH = "dataInfoData".hashCode();
    fYI = "cardTpInfoData".hashCode();
    fYJ = "shareInfoData".hashCode();
    fYK = "shopInfoData".hashCode();
    gcd = "stickyIndex".hashCode();
    gce = "stickyEndTime".hashCode();
    gcf = "stickyAnnouncement".hashCode();
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
      if (frE == k)
      {
        this.field_card_tp_id = paramCursor.getString(i);
      }
      else if (fYA == k)
      {
        this.field_from_username = paramCursor.getString(i);
      }
      else if (fjl == k)
      {
        this.field_status = paramCursor.getInt(i);
      }
      else if (gcb == k)
      {
        this.field_delete_state_flag = paramCursor.getInt(i);
      }
      else if (fYD == k)
      {
        this.field_local_updateTime = paramCursor.getLong(i);
      }
      else if (updateTime_HASHCODE == k)
      {
        this.field_updateTime = paramCursor.getLong(i);
      }
      else if (fAO == k)
      {
        this.field_updateSeq = paramCursor.getLong(i);
      }
      else if (gcc == k)
      {
        this.field_create_time = paramCursor.getLong(i);
      }
      else if (fYE == k)
      {
        this.field_begin_time = paramCursor.getLong(i);
      }
      else if (fYF == k)
      {
        this.field_end_time = paramCursor.getLong(i);
      }
      else if (fYG == k)
      {
        this.field_block_mask = paramCursor.getString(i);
      }
      else if (fYH == k)
      {
        this.field_dataInfoData = paramCursor.getBlob(i);
      }
      else if (fYI == k)
      {
        this.field_cardTpInfoData = paramCursor.getBlob(i);
      }
      else if (fYJ == k)
      {
        this.field_shareInfoData = paramCursor.getBlob(i);
      }
      else if (fYK == k)
      {
        this.field_shopInfoData = paramCursor.getBlob(i);
      }
      else if (gcd == k)
      {
        this.field_stickyIndex = paramCursor.getInt(i);
      }
      else if (gce == k)
      {
        this.field_stickyEndTime = paramCursor.getInt(i);
      }
      else if (gcf == k)
      {
        this.field_stickyAnnouncement = paramCursor.getString(i);
      }
      else if (frA == k)
      {
        this.field_card_type = paramCursor.getInt(i);
      }
      else if (gcg == k)
      {
        this.field_label_wording = paramCursor.getString(i);
      }
      else
      {
        if (gch == k)
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
    if (this.frk) {
      localContentValues.put("card_id", this.field_card_id);
    }
    if (this.frl) {
      localContentValues.put("card_tp_id", this.field_card_tp_id);
    }
    if (this.fYn) {
      localContentValues.put("from_username", this.field_from_username);
    }
    if (this.fji) {
      localContentValues.put("status", Integer.valueOf(this.field_status));
    }
    if (this.gbU) {
      localContentValues.put("delete_state_flag", Integer.valueOf(this.field_delete_state_flag));
    }
    if (this.fYq) {
      localContentValues.put("local_updateTime", Long.valueOf(this.field_local_updateTime));
    }
    if (this.__hadSetupdateTime) {
      localContentValues.put("updateTime", Long.valueOf(this.field_updateTime));
    }
    if (this.fAA) {
      localContentValues.put("updateSeq", Long.valueOf(this.field_updateSeq));
    }
    if (this.gbV) {
      localContentValues.put("create_time", Long.valueOf(this.field_create_time));
    }
    if (this.fYr) {
      localContentValues.put("begin_time", Long.valueOf(this.field_begin_time));
    }
    if (this.fYs) {
      localContentValues.put("end_time", Long.valueOf(this.field_end_time));
    }
    if (this.fYt) {
      localContentValues.put("block_mask", this.field_block_mask);
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
    if (this.gbW) {
      localContentValues.put("stickyIndex", Integer.valueOf(this.field_stickyIndex));
    }
    if (this.gbX) {
      localContentValues.put("stickyEndTime", Integer.valueOf(this.field_stickyEndTime));
    }
    if (this.gbY) {
      localContentValues.put("stickyAnnouncement", this.field_stickyAnnouncement);
    }
    if (this.frh) {
      localContentValues.put("card_type", Integer.valueOf(this.field_card_type));
    }
    if (this.gbZ) {
      localContentValues.put("label_wording", this.field_label_wording);
    }
    if (this.gca) {
      localContentValues.put("is_dynamic", Boolean.valueOf(this.field_is_dynamic));
    }
    if (this.systemRowid > 0L) {
      localContentValues.put("rowid", Long.valueOf(this.systemRowid));
    }
    return localContentValues;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.g.c.gx
 * JD-Core Version:    0.7.0.1
 */