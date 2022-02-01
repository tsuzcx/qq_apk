package com.tencent.mm.autogen.b;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.storage.IAutoDBItem;
import com.tencent.mm.sdk.storage.IAutoDBItem.MAutoDBInfo;
import com.tencent.mm.sdk.storage.observer.StorageObserverOwner;
import com.tencent.mm.sdk.storage.sql.Column;
import com.tencent.mm.sdk.storage.sql.SingleTable;
import java.lang.reflect.Field;
import java.util.Map;

public abstract class ia
  extends IAutoDBItem
{
  public static final IAutoDBItem.MAutoDBInfo DB_INFO = aJm();
  public static final String[] INDEX_CREATE;
  public static final Column ROWID;
  public static final SingleTable TABLE = new SingleTable("UserCardInfo");
  public static final Column UPDATETIME;
  private static final int jIF;
  public static final Column jIz;
  public static final Column jUQ;
  public static final Column jUT;
  public static final Column jUU;
  private static final int jVC;
  private static final int jVF;
  private static final int jVG;
  private static final int kXJ;
  private static final int kXM;
  private static final int kXN;
  private static final int kXO;
  private static final int kXP;
  private static final int kXQ;
  private static final int kXR;
  private static final int kXS;
  private static final int kXT;
  public static final Column kXj;
  public static final Column kXm;
  public static final Column kXn;
  public static final Column kXo;
  public static final Column kXp;
  public static final Column kXq;
  public static final Column kXr;
  public static final Column kXs;
  public static final Column kXt;
  public static final Column kiL;
  private static final int kjn;
  private static final int ldA;
  private static final int ldB;
  private static final int ldC;
  private static final int ldD;
  private static final int ldE;
  private static final int ldF;
  private static final int ldG;
  public static final Column ldm;
  public static final Column ldn;
  public static final Column ldo;
  public static final Column ldp;
  public static final Column ldq;
  public static final Column ldr;
  public static final Column lds;
  private static final StorageObserverOwner<ia> observerOwner = new StorageObserverOwner();
  private static final int rowid_HASHCODE;
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
  private boolean jIC = true;
  private boolean jVj = true;
  private boolean jVm = true;
  private boolean jVn = true;
  private boolean kXA = true;
  private boolean kXB = true;
  private boolean kXC = true;
  private boolean kXD = true;
  private boolean kXE = true;
  private boolean kXF = true;
  private boolean kXG = true;
  private boolean kXw = true;
  private boolean kXz = true;
  private boolean kiZ = true;
  private boolean ldt = true;
  private boolean ldu = true;
  private boolean ldv = true;
  private boolean ldw = true;
  private boolean ldx = true;
  private boolean ldy = true;
  private boolean ldz = true;
  
  static
  {
    ROWID = new Column("rowid", "long", TABLE.getName(), "");
    jUT = new Column("card_id", "string", TABLE.getName(), "");
    jUU = new Column("card_tp_id", "string", TABLE.getName(), "");
    kXj = new Column("from_username", "string", TABLE.getName(), "");
    jIz = new Column("status", "int", TABLE.getName(), "");
    ldm = new Column("delete_state_flag", "int", TABLE.getName(), "");
    kXm = new Column("local_updateTime", "long", TABLE.getName(), "");
    UPDATETIME = new Column("updateTime", "long", TABLE.getName(), "");
    kiL = new Column("updateSeq", "long", TABLE.getName(), "");
    ldn = new Column("create_time", "long", TABLE.getName(), "");
    kXn = new Column("begin_time", "long", TABLE.getName(), "");
    kXo = new Column("end_time", "long", TABLE.getName(), "");
    kXp = new Column("block_mask", "string", TABLE.getName(), "");
    kXq = new Column("dataInfoData", "byte[]", TABLE.getName(), "");
    kXr = new Column("cardTpInfoData", "byte[]", TABLE.getName(), "");
    kXs = new Column("shareInfoData", "byte[]", TABLE.getName(), "");
    kXt = new Column("shopInfoData", "byte[]", TABLE.getName(), "");
    ldo = new Column("stickyIndex", "int", TABLE.getName(), "");
    ldp = new Column("stickyEndTime", "int", TABLE.getName(), "");
    ldq = new Column("stickyAnnouncement", "string", TABLE.getName(), "");
    jUQ = new Column("card_type", "int", TABLE.getName(), "");
    ldr = new Column("label_wording", "string", TABLE.getName(), "");
    lds = new Column("is_dynamic", "boolean", TABLE.getName(), "");
    INDEX_CREATE = new String[] { "CREATE INDEX IF NOT EXISTS UserCardInfo_card_type_index ON UserCardInfo(card_type)" };
    jVF = "card_id".hashCode();
    jVG = "card_tp_id".hashCode();
    kXJ = "from_username".hashCode();
    jIF = "status".hashCode();
    ldA = "delete_state_flag".hashCode();
    kXM = "local_updateTime".hashCode();
    updateTime_HASHCODE = "updateTime".hashCode();
    kjn = "updateSeq".hashCode();
    ldB = "create_time".hashCode();
    kXN = "begin_time".hashCode();
    kXO = "end_time".hashCode();
    kXP = "block_mask".hashCode();
    kXQ = "dataInfoData".hashCode();
    kXR = "cardTpInfoData".hashCode();
    kXS = "shareInfoData".hashCode();
    kXT = "shopInfoData".hashCode();
    ldC = "stickyIndex".hashCode();
    ldD = "stickyEndTime".hashCode();
    ldE = "stickyAnnouncement".hashCode();
    jVC = "card_type".hashCode();
    ldF = "label_wording".hashCode();
    ldG = "is_dynamic".hashCode();
    rowid_HASHCODE = "rowid".hashCode();
  }
  
  public static IAutoDBItem.MAutoDBInfo aJm()
  {
    IAutoDBItem.MAutoDBInfo localMAutoDBInfo = new IAutoDBItem.MAutoDBInfo();
    localMAutoDBInfo.fields = new Field[22];
    localMAutoDBInfo.columns = new String[23];
    StringBuilder localStringBuilder = new StringBuilder();
    localMAutoDBInfo.columns[0] = "card_id";
    localMAutoDBInfo.colsMap.put("card_id", "TEXT PRIMARY KEY ");
    localStringBuilder.append(" card_id TEXT PRIMARY KEY ");
    localStringBuilder.append(", ");
    localMAutoDBInfo.primaryKey = "card_id";
    localMAutoDBInfo.columns[1] = "card_tp_id";
    localMAutoDBInfo.colsMap.put("card_tp_id", "TEXT");
    localStringBuilder.append(" card_tp_id TEXT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[2] = "from_username";
    localMAutoDBInfo.colsMap.put("from_username", "TEXT");
    localStringBuilder.append(" from_username TEXT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[3] = "status";
    localMAutoDBInfo.colsMap.put("status", "INTEGER");
    localStringBuilder.append(" status INTEGER");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[4] = "delete_state_flag";
    localMAutoDBInfo.colsMap.put("delete_state_flag", "INTEGER");
    localStringBuilder.append(" delete_state_flag INTEGER");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[5] = "local_updateTime";
    localMAutoDBInfo.colsMap.put("local_updateTime", "LONG");
    localStringBuilder.append(" local_updateTime LONG");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[6] = "updateTime";
    localMAutoDBInfo.colsMap.put("updateTime", "LONG");
    localStringBuilder.append(" updateTime LONG");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[7] = "updateSeq";
    localMAutoDBInfo.colsMap.put("updateSeq", "LONG");
    localStringBuilder.append(" updateSeq LONG");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[8] = "create_time";
    localMAutoDBInfo.colsMap.put("create_time", "LONG");
    localStringBuilder.append(" create_time LONG");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[9] = "begin_time";
    localMAutoDBInfo.colsMap.put("begin_time", "LONG");
    localStringBuilder.append(" begin_time LONG");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[10] = "end_time";
    localMAutoDBInfo.colsMap.put("end_time", "LONG");
    localStringBuilder.append(" end_time LONG");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[11] = "block_mask";
    localMAutoDBInfo.colsMap.put("block_mask", "TEXT");
    localStringBuilder.append(" block_mask TEXT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[12] = "dataInfoData";
    localMAutoDBInfo.colsMap.put("dataInfoData", "BLOB");
    localStringBuilder.append(" dataInfoData BLOB");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[13] = "cardTpInfoData";
    localMAutoDBInfo.colsMap.put("cardTpInfoData", "BLOB");
    localStringBuilder.append(" cardTpInfoData BLOB");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[14] = "shareInfoData";
    localMAutoDBInfo.colsMap.put("shareInfoData", "BLOB");
    localStringBuilder.append(" shareInfoData BLOB");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[15] = "shopInfoData";
    localMAutoDBInfo.colsMap.put("shopInfoData", "BLOB");
    localStringBuilder.append(" shopInfoData BLOB");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[16] = "stickyIndex";
    localMAutoDBInfo.colsMap.put("stickyIndex", "INTEGER");
    localStringBuilder.append(" stickyIndex INTEGER");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[17] = "stickyEndTime";
    localMAutoDBInfo.colsMap.put("stickyEndTime", "INTEGER");
    localStringBuilder.append(" stickyEndTime INTEGER");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[18] = "stickyAnnouncement";
    localMAutoDBInfo.colsMap.put("stickyAnnouncement", "TEXT");
    localStringBuilder.append(" stickyAnnouncement TEXT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[19] = "card_type";
    localMAutoDBInfo.colsMap.put("card_type", "INTEGER default '-1' ");
    localStringBuilder.append(" card_type INTEGER default '-1' ");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[20] = "label_wording";
    localMAutoDBInfo.colsMap.put("label_wording", "TEXT");
    localStringBuilder.append(" label_wording TEXT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[21] = "is_dynamic";
    localMAutoDBInfo.colsMap.put("is_dynamic", "INTEGER");
    localStringBuilder.append(" is_dynamic INTEGER");
    localMAutoDBInfo.columns[22] = "rowid";
    localMAutoDBInfo.sql = localStringBuilder.toString();
    if (localMAutoDBInfo.primaryKey == null) {
      localMAutoDBInfo.primaryKey = "rowid";
    }
    return localMAutoDBInfo;
  }
  
  public void convertFrom(ContentValues paramContentValues, boolean paramBoolean)
  {
    if (paramContentValues.containsKey("card_id"))
    {
      this.field_card_id = paramContentValues.getAsString("card_id");
      if (paramBoolean) {
        this.jVm = true;
      }
    }
    if (paramContentValues.containsKey("card_tp_id"))
    {
      this.field_card_tp_id = paramContentValues.getAsString("card_tp_id");
      if (paramBoolean) {
        this.jVn = true;
      }
    }
    if (paramContentValues.containsKey("from_username"))
    {
      this.field_from_username = paramContentValues.getAsString("from_username");
      if (paramBoolean) {
        this.kXw = true;
      }
    }
    if (paramContentValues.containsKey("status"))
    {
      this.field_status = paramContentValues.getAsInteger("status").intValue();
      if (paramBoolean) {
        this.jIC = true;
      }
    }
    if (paramContentValues.containsKey("delete_state_flag"))
    {
      this.field_delete_state_flag = paramContentValues.getAsInteger("delete_state_flag").intValue();
      if (paramBoolean) {
        this.ldt = true;
      }
    }
    if (paramContentValues.containsKey("local_updateTime"))
    {
      this.field_local_updateTime = paramContentValues.getAsLong("local_updateTime").longValue();
      if (paramBoolean) {
        this.kXz = true;
      }
    }
    if (paramContentValues.containsKey("updateTime"))
    {
      this.field_updateTime = paramContentValues.getAsLong("updateTime").longValue();
      if (paramBoolean) {
        this.__hadSetupdateTime = true;
      }
    }
    if (paramContentValues.containsKey("updateSeq"))
    {
      this.field_updateSeq = paramContentValues.getAsLong("updateSeq").longValue();
      if (paramBoolean) {
        this.kiZ = true;
      }
    }
    if (paramContentValues.containsKey("create_time"))
    {
      this.field_create_time = paramContentValues.getAsLong("create_time").longValue();
      if (paramBoolean) {
        this.ldu = true;
      }
    }
    if (paramContentValues.containsKey("begin_time"))
    {
      this.field_begin_time = paramContentValues.getAsLong("begin_time").longValue();
      if (paramBoolean) {
        this.kXA = true;
      }
    }
    if (paramContentValues.containsKey("end_time"))
    {
      this.field_end_time = paramContentValues.getAsLong("end_time").longValue();
      if (paramBoolean) {
        this.kXB = true;
      }
    }
    if (paramContentValues.containsKey("block_mask"))
    {
      this.field_block_mask = paramContentValues.getAsString("block_mask");
      if (paramBoolean) {
        this.kXC = true;
      }
    }
    if (paramContentValues.containsKey("dataInfoData"))
    {
      this.field_dataInfoData = paramContentValues.getAsByteArray("dataInfoData");
      if (paramBoolean) {
        this.kXD = true;
      }
    }
    if (paramContentValues.containsKey("cardTpInfoData"))
    {
      this.field_cardTpInfoData = paramContentValues.getAsByteArray("cardTpInfoData");
      if (paramBoolean) {
        this.kXE = true;
      }
    }
    if (paramContentValues.containsKey("shareInfoData"))
    {
      this.field_shareInfoData = paramContentValues.getAsByteArray("shareInfoData");
      if (paramBoolean) {
        this.kXF = true;
      }
    }
    if (paramContentValues.containsKey("shopInfoData"))
    {
      this.field_shopInfoData = paramContentValues.getAsByteArray("shopInfoData");
      if (paramBoolean) {
        this.kXG = true;
      }
    }
    if (paramContentValues.containsKey("stickyIndex"))
    {
      this.field_stickyIndex = paramContentValues.getAsInteger("stickyIndex").intValue();
      if (paramBoolean) {
        this.ldv = true;
      }
    }
    if (paramContentValues.containsKey("stickyEndTime"))
    {
      this.field_stickyEndTime = paramContentValues.getAsInteger("stickyEndTime").intValue();
      if (paramBoolean) {
        this.ldw = true;
      }
    }
    if (paramContentValues.containsKey("stickyAnnouncement"))
    {
      this.field_stickyAnnouncement = paramContentValues.getAsString("stickyAnnouncement");
      if (paramBoolean) {
        this.ldx = true;
      }
    }
    if (paramContentValues.containsKey("card_type"))
    {
      this.field_card_type = paramContentValues.getAsInteger("card_type").intValue();
      if (paramBoolean) {
        this.jVj = true;
      }
    }
    if (paramContentValues.containsKey("label_wording"))
    {
      this.field_label_wording = paramContentValues.getAsString("label_wording");
      if (paramBoolean) {
        this.ldy = true;
      }
    }
    if (paramContentValues.containsKey("is_dynamic")) {
      if (paramContentValues.getAsInteger("is_dynamic").intValue() == 0) {
        break label681;
      }
    }
    label681:
    for (boolean bool = true;; bool = false)
    {
      this.field_is_dynamic = bool;
      if (paramBoolean) {
        this.ldz = true;
      }
      if (paramContentValues.containsKey("rowid")) {
        this.systemRowid = paramContentValues.getAsLong("rowid").longValue();
      }
      return;
    }
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
      if (jVF != k) {
        break label65;
      }
      this.field_card_id = paramCursor.getString(i);
      this.jVm = true;
    }
    for (;;)
    {
      i += 1;
      break label20;
      break;
      label65:
      if (jVG == k)
      {
        this.field_card_tp_id = paramCursor.getString(i);
      }
      else if (kXJ == k)
      {
        this.field_from_username = paramCursor.getString(i);
      }
      else if (jIF == k)
      {
        this.field_status = paramCursor.getInt(i);
      }
      else if (ldA == k)
      {
        this.field_delete_state_flag = paramCursor.getInt(i);
      }
      else if (kXM == k)
      {
        this.field_local_updateTime = paramCursor.getLong(i);
      }
      else if (updateTime_HASHCODE == k)
      {
        this.field_updateTime = paramCursor.getLong(i);
      }
      else if (kjn == k)
      {
        this.field_updateSeq = paramCursor.getLong(i);
      }
      else if (ldB == k)
      {
        this.field_create_time = paramCursor.getLong(i);
      }
      else if (kXN == k)
      {
        this.field_begin_time = paramCursor.getLong(i);
      }
      else if (kXO == k)
      {
        this.field_end_time = paramCursor.getLong(i);
      }
      else if (kXP == k)
      {
        this.field_block_mask = paramCursor.getString(i);
      }
      else if (kXQ == k)
      {
        this.field_dataInfoData = paramCursor.getBlob(i);
      }
      else if (kXR == k)
      {
        this.field_cardTpInfoData = paramCursor.getBlob(i);
      }
      else if (kXS == k)
      {
        this.field_shareInfoData = paramCursor.getBlob(i);
      }
      else if (kXT == k)
      {
        this.field_shopInfoData = paramCursor.getBlob(i);
      }
      else if (ldC == k)
      {
        this.field_stickyIndex = paramCursor.getInt(i);
      }
      else if (ldD == k)
      {
        this.field_stickyEndTime = paramCursor.getInt(i);
      }
      else if (ldE == k)
      {
        this.field_stickyAnnouncement = paramCursor.getString(i);
      }
      else if (jVC == k)
      {
        this.field_card_type = paramCursor.getInt(i);
      }
      else if (ldF == k)
      {
        this.field_label_wording = paramCursor.getString(i);
      }
      else
      {
        if (ldG == k)
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
    if (this.jVm) {
      localContentValues.put("card_id", this.field_card_id);
    }
    if (this.jVn) {
      localContentValues.put("card_tp_id", this.field_card_tp_id);
    }
    if (this.kXw) {
      localContentValues.put("from_username", this.field_from_username);
    }
    if (this.jIC) {
      localContentValues.put("status", Integer.valueOf(this.field_status));
    }
    if (this.ldt) {
      localContentValues.put("delete_state_flag", Integer.valueOf(this.field_delete_state_flag));
    }
    if (this.kXz) {
      localContentValues.put("local_updateTime", Long.valueOf(this.field_local_updateTime));
    }
    if (this.__hadSetupdateTime) {
      localContentValues.put("updateTime", Long.valueOf(this.field_updateTime));
    }
    if (this.kiZ) {
      localContentValues.put("updateSeq", Long.valueOf(this.field_updateSeq));
    }
    if (this.ldu) {
      localContentValues.put("create_time", Long.valueOf(this.field_create_time));
    }
    if (this.kXA) {
      localContentValues.put("begin_time", Long.valueOf(this.field_begin_time));
    }
    if (this.kXB) {
      localContentValues.put("end_time", Long.valueOf(this.field_end_time));
    }
    if (this.kXC) {
      localContentValues.put("block_mask", this.field_block_mask);
    }
    if (this.kXD) {
      localContentValues.put("dataInfoData", this.field_dataInfoData);
    }
    if (this.kXE) {
      localContentValues.put("cardTpInfoData", this.field_cardTpInfoData);
    }
    if (this.kXF) {
      localContentValues.put("shareInfoData", this.field_shareInfoData);
    }
    if (this.kXG) {
      localContentValues.put("shopInfoData", this.field_shopInfoData);
    }
    if (this.ldv) {
      localContentValues.put("stickyIndex", Integer.valueOf(this.field_stickyIndex));
    }
    if (this.ldw) {
      localContentValues.put("stickyEndTime", Integer.valueOf(this.field_stickyEndTime));
    }
    if (this.ldx) {
      localContentValues.put("stickyAnnouncement", this.field_stickyAnnouncement);
    }
    if (this.jVj) {
      localContentValues.put("card_type", Integer.valueOf(this.field_card_type));
    }
    if (this.ldy) {
      localContentValues.put("label_wording", this.field_label_wording);
    }
    if (this.ldz) {
      localContentValues.put("is_dynamic", Boolean.valueOf(this.field_is_dynamic));
    }
    if (this.systemRowid > 0L) {
      localContentValues.put("rowid", Long.valueOf(this.systemRowid));
    }
    return localContentValues;
  }
  
  public IAutoDBItem.MAutoDBInfo getDBInfo()
  {
    return DB_INFO;
  }
  
  public String[] getIndexCreateSQL()
  {
    return INDEX_CREATE;
  }
  
  public StorageObserverOwner<? extends ia> getObserverOwner()
  {
    return observerOwner;
  }
  
  public Object getPrimaryKeyValue()
  {
    return this.field_card_id;
  }
  
  public SingleTable getTable()
  {
    return TABLE;
  }
  
  public String getTableName()
  {
    return TABLE.getName();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     com.tencent.mm.autogen.b.ia
 * JD-Core Version:    0.7.0.1
 */