package com.tencent.mm.f.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.storage.IAutoDBItem;
import com.tencent.mm.sdk.storage.sql.Column;
import com.tencent.mm.sdk.storage.sql.SingleTable;

public abstract class he
  extends IAutoDBItem
{
  public static final Column C_ROWID;
  public static final Column C_UPDATETIME;
  public static final String[] INDEX_CREATE = { "CREATE INDEX IF NOT EXISTS UserCardInfo_card_type_index ON UserCardInfo(card_type)" };
  public static final SingleTable TABLE = new SingleTable("UserCardInfo");
  public static final Column hLH;
  private static final int hMj;
  private static final int hmC;
  public static final Column hmw;
  public static final Column hxX;
  private static final int hyJ = "card_type".hashCode();
  private static final int hyM;
  private static final int hyN;
  public static final Column hya;
  public static final Column hyb;
  public static final Column iBJ;
  public static final Column iBK;
  public static final Column iBL;
  public static final Column iBM;
  public static final Column iBN;
  public static final Column iBO;
  public static final Column iBP;
  private static final int iBX;
  private static final int iBY;
  private static final int iBZ;
  private static final int iCa;
  private static final int iCb;
  private static final int iCc = "label_wording".hashCode();
  private static final int iCd = "is_dynamic".hashCode();
  public static final Column iwA;
  public static final Column iwB;
  public static final Column iwC;
  public static final Column iwD;
  public static final Column iwE;
  public static final Column iwF;
  public static final Column iwG;
  private static final int iwW;
  private static final int iwZ;
  public static final Column iww;
  public static final Column iwz;
  private static final int ixa;
  private static final int ixb;
  private static final int ixc;
  private static final int ixd;
  private static final int ixe;
  private static final int ixf;
  private static final int ixg;
  private static final int rowid_HASHCODE = "rowid".hashCode();
  private static final int updateTime_HASHCODE;
  private boolean __hadSetupdateTime = true;
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
  private boolean hLV = true;
  private boolean hmz = true;
  private boolean hyq = true;
  private boolean hyt = true;
  private boolean hyu = true;
  private boolean iBQ = true;
  private boolean iBR = true;
  private boolean iBS = true;
  private boolean iBT = true;
  private boolean iBU = true;
  private boolean iBV = true;
  private boolean iBW = true;
  private boolean iwJ = true;
  private boolean iwM = true;
  private boolean iwN = true;
  private boolean iwO = true;
  private boolean iwP = true;
  private boolean iwQ = true;
  private boolean iwR = true;
  private boolean iwS = true;
  private boolean iwT = true;
  
  static
  {
    C_ROWID = new Column("rowid", "long", "UserCardInfo", "");
    hya = new Column("card_id", "string", "UserCardInfo", "");
    hyb = new Column("card_tp_id", "string", "UserCardInfo", "");
    iww = new Column("from_username", "string", "UserCardInfo", "");
    hmw = new Column("status", "int", "UserCardInfo", "");
    iBJ = new Column("delete_state_flag", "int", "UserCardInfo", "");
    iwz = new Column("local_updatetime", "long", "UserCardInfo", "");
    C_UPDATETIME = new Column("updatetime", "long", "UserCardInfo", "");
    hLH = new Column("updateseq", "long", "UserCardInfo", "");
    iBK = new Column("create_time", "long", "UserCardInfo", "");
    iwA = new Column("begin_time", "long", "UserCardInfo", "");
    iwB = new Column("end_time", "long", "UserCardInfo", "");
    iwC = new Column("block_mask", "string", "UserCardInfo", "");
    iwD = new Column("datainfodata", "byte[]", "UserCardInfo", "");
    iwE = new Column("cardtpinfodata", "byte[]", "UserCardInfo", "");
    iwF = new Column("shareinfodata", "byte[]", "UserCardInfo", "");
    iwG = new Column("shopinfodata", "byte[]", "UserCardInfo", "");
    iBL = new Column("stickyindex", "int", "UserCardInfo", "");
    iBM = new Column("stickyendtime", "int", "UserCardInfo", "");
    iBN = new Column("stickyannouncement", "string", "UserCardInfo", "");
    hxX = new Column("card_type", "int", "UserCardInfo", "");
    iBO = new Column("label_wording", "string", "UserCardInfo", "");
    iBP = new Column("is_dynamic", "boolean", "UserCardInfo", "");
    hyM = "card_id".hashCode();
    hyN = "card_tp_id".hashCode();
    iwW = "from_username".hashCode();
    hmC = "status".hashCode();
    iBX = "delete_state_flag".hashCode();
    iwZ = "local_updateTime".hashCode();
    updateTime_HASHCODE = "updateTime".hashCode();
    hMj = "updateSeq".hashCode();
    iBY = "create_time".hashCode();
    ixa = "begin_time".hashCode();
    ixb = "end_time".hashCode();
    ixc = "block_mask".hashCode();
    ixd = "dataInfoData".hashCode();
    ixe = "cardTpInfoData".hashCode();
    ixf = "shareInfoData".hashCode();
    ixg = "shopInfoData".hashCode();
    iBZ = "stickyIndex".hashCode();
    iCa = "stickyEndTime".hashCode();
    iCb = "stickyAnnouncement".hashCode();
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
      if (hyM != k) {
        break label65;
      }
      this.field_card_id = paramCursor.getString(i);
      this.hyt = true;
    }
    for (;;)
    {
      i += 1;
      break label20;
      break;
      label65:
      if (hyN == k)
      {
        this.field_card_tp_id = paramCursor.getString(i);
      }
      else if (iwW == k)
      {
        this.field_from_username = paramCursor.getString(i);
      }
      else if (hmC == k)
      {
        this.field_status = paramCursor.getInt(i);
      }
      else if (iBX == k)
      {
        this.field_delete_state_flag = paramCursor.getInt(i);
      }
      else if (iwZ == k)
      {
        this.field_local_updateTime = paramCursor.getLong(i);
      }
      else if (updateTime_HASHCODE == k)
      {
        this.field_updateTime = paramCursor.getLong(i);
      }
      else if (hMj == k)
      {
        this.field_updateSeq = paramCursor.getLong(i);
      }
      else if (iBY == k)
      {
        this.field_create_time = paramCursor.getLong(i);
      }
      else if (ixa == k)
      {
        this.field_begin_time = paramCursor.getLong(i);
      }
      else if (ixb == k)
      {
        this.field_end_time = paramCursor.getLong(i);
      }
      else if (ixc == k)
      {
        this.field_block_mask = paramCursor.getString(i);
      }
      else if (ixd == k)
      {
        this.field_dataInfoData = paramCursor.getBlob(i);
      }
      else if (ixe == k)
      {
        this.field_cardTpInfoData = paramCursor.getBlob(i);
      }
      else if (ixf == k)
      {
        this.field_shareInfoData = paramCursor.getBlob(i);
      }
      else if (ixg == k)
      {
        this.field_shopInfoData = paramCursor.getBlob(i);
      }
      else if (iBZ == k)
      {
        this.field_stickyIndex = paramCursor.getInt(i);
      }
      else if (iCa == k)
      {
        this.field_stickyEndTime = paramCursor.getInt(i);
      }
      else if (iCb == k)
      {
        this.field_stickyAnnouncement = paramCursor.getString(i);
      }
      else if (hyJ == k)
      {
        this.field_card_type = paramCursor.getInt(i);
      }
      else if (iCc == k)
      {
        this.field_label_wording = paramCursor.getString(i);
      }
      else
      {
        if (iCd == k)
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
    if (this.hyt) {
      localContentValues.put("card_id", this.field_card_id);
    }
    if (this.hyu) {
      localContentValues.put("card_tp_id", this.field_card_tp_id);
    }
    if (this.iwJ) {
      localContentValues.put("from_username", this.field_from_username);
    }
    if (this.hmz) {
      localContentValues.put("status", Integer.valueOf(this.field_status));
    }
    if (this.iBQ) {
      localContentValues.put("delete_state_flag", Integer.valueOf(this.field_delete_state_flag));
    }
    if (this.iwM) {
      localContentValues.put("local_updateTime", Long.valueOf(this.field_local_updateTime));
    }
    if (this.__hadSetupdateTime) {
      localContentValues.put("updateTime", Long.valueOf(this.field_updateTime));
    }
    if (this.hLV) {
      localContentValues.put("updateSeq", Long.valueOf(this.field_updateSeq));
    }
    if (this.iBR) {
      localContentValues.put("create_time", Long.valueOf(this.field_create_time));
    }
    if (this.iwN) {
      localContentValues.put("begin_time", Long.valueOf(this.field_begin_time));
    }
    if (this.iwO) {
      localContentValues.put("end_time", Long.valueOf(this.field_end_time));
    }
    if (this.iwP) {
      localContentValues.put("block_mask", this.field_block_mask);
    }
    if (this.iwQ) {
      localContentValues.put("dataInfoData", this.field_dataInfoData);
    }
    if (this.iwR) {
      localContentValues.put("cardTpInfoData", this.field_cardTpInfoData);
    }
    if (this.iwS) {
      localContentValues.put("shareInfoData", this.field_shareInfoData);
    }
    if (this.iwT) {
      localContentValues.put("shopInfoData", this.field_shopInfoData);
    }
    if (this.iBS) {
      localContentValues.put("stickyIndex", Integer.valueOf(this.field_stickyIndex));
    }
    if (this.iBT) {
      localContentValues.put("stickyEndTime", Integer.valueOf(this.field_stickyEndTime));
    }
    if (this.iBU) {
      localContentValues.put("stickyAnnouncement", this.field_stickyAnnouncement);
    }
    if (this.hyq) {
      localContentValues.put("card_type", Integer.valueOf(this.field_card_type));
    }
    if (this.iBV) {
      localContentValues.put("label_wording", this.field_label_wording);
    }
    if (this.iBW) {
      localContentValues.put("is_dynamic", Boolean.valueOf(this.field_is_dynamic));
    }
    if (this.systemRowid > 0L) {
      localContentValues.put("rowid", Long.valueOf(this.systemRowid));
    }
    return localContentValues;
  }
  
  public String[] getIndexCreateSQL()
  {
    return INDEX_CREATE;
  }
  
  public String getTableName()
  {
    return "UserCardInfo";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.f.c.he
 * JD-Core Version:    0.7.0.1
 */