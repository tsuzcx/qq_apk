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

public abstract class bm
  extends IAutoDBItem
{
  public static final Column CONTENT;
  public static final IAutoDBItem.MAutoDBInfo DB_INFO = aJm();
  public static final String[] INDEX_CREATE;
  public static final Column ROWID;
  public static final SingleTable TABLE = new SingleTable("EmojiInfo");
  public static final Column TYPE;
  private static final int content_HASHCODE;
  public static final Column jLQ;
  private static final int jLU;
  public static final Column jMN;
  private static final int jMX;
  public static final Column kcO;
  public static final Column kcS;
  private static final int kdO;
  private static final int kdS;
  public static final Column keA;
  public static final Column keB;
  public static final Column keC;
  public static final Column keD;
  public static final Column keE;
  public static final Column keF;
  public static final Column keG;
  public static final Column keH;
  public static final Column keI;
  public static final Column keJ;
  public static final Column keK;
  public static final Column keL;
  public static final Column keM;
  public static final Column keN;
  public static final Column keO;
  public static final Column kea;
  public static final Column keb;
  public static final Column kec;
  public static final Column ked;
  public static final Column kee;
  public static final Column kef;
  public static final Column keg;
  public static final Column keh;
  public static final Column kei;
  public static final Column kej;
  public static final Column kek;
  public static final Column kel;
  public static final Column kem;
  public static final Column ken;
  public static final Column keo;
  public static final Column kep;
  public static final Column keq;
  public static final Column ker;
  public static final Column kes;
  public static final Column ket;
  public static final Column keu;
  public static final Column kev;
  public static final Column kew;
  public static final Column kex;
  public static final Column kez;
  private static final int kfD;
  private static final int kfE;
  private static final int kfF;
  private static final int kfG;
  private static final int kfH;
  private static final int kfI;
  private static final int kfJ;
  private static final int kfK;
  private static final int kfL;
  private static final int kfM;
  private static final int kfN;
  private static final int kfO;
  private static final int kfP;
  private static final int kfQ;
  private static final int kfR;
  private static final int kfS;
  private static final int kfT;
  private static final int kfU;
  private static final int kfV;
  private static final int kfW;
  private static final int kfX;
  private static final int kfY;
  private static final int kfZ;
  private static final int kga;
  private static final int kgb;
  private static final int kgc;
  private static final int kgd;
  private static final int kge;
  private static final int kgf;
  private static final int kgg;
  private static final int kgh;
  private static final int kgi;
  private static final int kgj;
  private static final int kgk;
  private static final int kgl;
  private static final int kgm;
  private static final int kgn;
  private static final int kgo;
  private static final int kgp;
  private static final int kgq;
  private static final StorageObserverOwner<bm> observerOwner = new StorageObserverOwner();
  private static final int rowid_HASHCODE;
  private static final int type_HASHCODE;
  private boolean __hadSetcontent = true;
  private boolean __hadSettype = true;
  public String field_activityid;
  public String field_aeskey;
  public String field_app_id;
  public String field_attachTextColor;
  public byte[] field_attachedEmojiMD5;
  public String field_attachedText;
  public String field_attr;
  public long field_captureEnterTime;
  public int field_captureScene;
  public int field_captureStatus;
  public int field_captureUploadCounter;
  public int field_captureUploadErrCode;
  public int field_catalog;
  public String field_cdnUrl;
  public String field_content;
  public String field_designerID;
  public String field_encrypturl;
  public String field_externMd5;
  public String field_externUrl;
  public String field_framesInfo;
  public String field_groupId;
  public int field_height;
  public int field_idx;
  public String field_imitateMd5;
  public long field_lastUseTime;
  public String field_lensId;
  public String field_linkId;
  public String field_md5;
  public String field_name;
  public int field_needupload;
  public String field_reserved1;
  public String field_reserved2;
  public int field_reserved3;
  public int field_reserved4;
  public int field_size;
  public int field_source;
  public int field_start;
  public int field_state;
  public String field_svrid;
  public int field_temp;
  public String field_thumbUrl;
  public String field_tpauthkey;
  public String field_tpurl;
  public int field_type;
  public int field_width;
  public String field_wxamMd5;
  private boolean jLS = true;
  private boolean jMS = true;
  private boolean kdo = true;
  private boolean kds = true;
  private boolean keP = true;
  private boolean keQ = true;
  private boolean keR = true;
  private boolean keS = true;
  private boolean keT = true;
  private boolean keU = true;
  private boolean keV = true;
  private boolean keW = true;
  private boolean keX = true;
  private boolean keY = true;
  private boolean keZ = true;
  private boolean kfA = true;
  private boolean kfB = true;
  private boolean kfC = true;
  private boolean kfa = true;
  private boolean kfb = true;
  private boolean kfc = true;
  private boolean kfd = true;
  private boolean kfe = true;
  private boolean kff = true;
  private boolean kfg = true;
  private boolean kfh = true;
  private boolean kfi = true;
  private boolean kfj = true;
  private boolean kfk = true;
  private boolean kfl = true;
  private boolean kfm = true;
  private boolean kfn = true;
  private boolean kfo = true;
  private boolean kfp = true;
  private boolean kfq = true;
  private boolean kfr = true;
  private boolean kfs = true;
  private boolean kft = true;
  private boolean kfu = true;
  private boolean kfv = true;
  private boolean kfw = true;
  private boolean kfx = true;
  private boolean kfy = true;
  private boolean kfz = true;
  
  static
  {
    ROWID = new Column("rowid", "long", TABLE.getName(), "");
    kea = new Column("md5", "string", TABLE.getName(), "");
    keb = new Column("svrid", "string", TABLE.getName(), "");
    kec = new Column("catalog", "int", TABLE.getName(), "");
    TYPE = new Column("type", "int", TABLE.getName(), "");
    jLQ = new Column("size", "int", TABLE.getName(), "");
    ked = new Column("start", "int", TABLE.getName(), "");
    kee = new Column("state", "int", TABLE.getName(), "");
    kef = new Column("name", "string", TABLE.getName(), "");
    CONTENT = new Column("content", "string", TABLE.getName(), "");
    keg = new Column("reserved1", "string", TABLE.getName(), "");
    keh = new Column("reserved2", "string", TABLE.getName(), "");
    kei = new Column("reserved3", "int", TABLE.getName(), "");
    kej = new Column("reserved4", "int", TABLE.getName(), "");
    kek = new Column("app_id", "string", TABLE.getName(), "");
    kel = new Column("groupId", "string", TABLE.getName(), "");
    kcO = new Column("lastUseTime", "long", TABLE.getName(), "");
    kem = new Column("framesInfo", "string", TABLE.getName(), "");
    kcS = new Column("idx", "int", TABLE.getName(), "");
    ken = new Column("temp", "int", TABLE.getName(), "");
    jMN = new Column("source", "int", TABLE.getName(), "");
    keo = new Column("needupload", "int", TABLE.getName(), "");
    kep = new Column("designerID", "string", TABLE.getName(), "");
    keq = new Column("thumbUrl", "string", TABLE.getName(), "");
    ker = new Column("cdnUrl", "string", TABLE.getName(), "");
    kes = new Column("encrypturl", "string", TABLE.getName(), "");
    ket = new Column("aeskey", "string", TABLE.getName(), "");
    keu = new Column("width", "int", TABLE.getName(), "");
    kev = new Column("height", "int", TABLE.getName(), "");
    kew = new Column("externUrl", "string", TABLE.getName(), "");
    kex = new Column("externMd5", "string", TABLE.getName(), "");
    kez = new Column("activityid", "string", TABLE.getName(), "");
    keA = new Column("tpurl", "string", TABLE.getName(), "");
    keB = new Column("tpauthkey", "string", TABLE.getName(), "");
    keC = new Column("wxamMd5", "string", TABLE.getName(), "");
    keD = new Column("attachedText", "string", TABLE.getName(), "");
    keE = new Column("captureStatus", "int", TABLE.getName(), "");
    keF = new Column("attachedEmojiMD5", "byte[]", TABLE.getName(), "");
    keG = new Column("imitateMd5", "string", TABLE.getName(), "");
    keH = new Column("captureUploadErrCode", "int", TABLE.getName(), "");
    keI = new Column("captureUploadCounter", "int", TABLE.getName(), "");
    keJ = new Column("captureEnterTime", "long", TABLE.getName(), "");
    keK = new Column("lensId", "string", TABLE.getName(), "");
    keL = new Column("attachTextColor", "string", TABLE.getName(), "");
    keM = new Column("captureScene", "int", TABLE.getName(), "");
    keN = new Column("attr", "string", TABLE.getName(), "");
    keO = new Column("linkId", "string", TABLE.getName(), "");
    INDEX_CREATE = new String[] { "CREATE INDEX IF NOT EXISTS emojiGroupIndex ON EmojiInfo(catalog)" };
    kfD = "md5".hashCode();
    kfE = "svrid".hashCode();
    kfF = "catalog".hashCode();
    type_HASHCODE = "type".hashCode();
    jLU = "size".hashCode();
    kfG = "start".hashCode();
    kfH = "state".hashCode();
    kfI = "name".hashCode();
    content_HASHCODE = "content".hashCode();
    kfJ = "reserved1".hashCode();
    kfK = "reserved2".hashCode();
    kfL = "reserved3".hashCode();
    kfM = "reserved4".hashCode();
    kfN = "app_id".hashCode();
    kfO = "groupId".hashCode();
    kdO = "lastUseTime".hashCode();
    kfP = "framesInfo".hashCode();
    kdS = "idx".hashCode();
    kfQ = "temp".hashCode();
    jMX = "source".hashCode();
    kfR = "needupload".hashCode();
    kfS = "designerID".hashCode();
    kfT = "thumbUrl".hashCode();
    kfU = "cdnUrl".hashCode();
    kfV = "encrypturl".hashCode();
    kfW = "aeskey".hashCode();
    kfX = "width".hashCode();
    kfY = "height".hashCode();
    kfZ = "externUrl".hashCode();
    kga = "externMd5".hashCode();
    kgb = "activityid".hashCode();
    kgc = "tpurl".hashCode();
    kgd = "tpauthkey".hashCode();
    kge = "wxamMd5".hashCode();
    kgf = "attachedText".hashCode();
    kgg = "captureStatus".hashCode();
    kgh = "attachedEmojiMD5".hashCode();
    kgi = "imitateMd5".hashCode();
    kgj = "captureUploadErrCode".hashCode();
    kgk = "captureUploadCounter".hashCode();
    kgl = "captureEnterTime".hashCode();
    kgm = "lensId".hashCode();
    kgn = "attachTextColor".hashCode();
    kgo = "captureScene".hashCode();
    kgp = "attr".hashCode();
    kgq = "linkId".hashCode();
    rowid_HASHCODE = "rowid".hashCode();
  }
  
  public static IAutoDBItem.MAutoDBInfo aJm()
  {
    IAutoDBItem.MAutoDBInfo localMAutoDBInfo = new IAutoDBItem.MAutoDBInfo();
    localMAutoDBInfo.fields = new Field[46];
    localMAutoDBInfo.columns = new String[47];
    StringBuilder localStringBuilder = new StringBuilder();
    localMAutoDBInfo.columns[0] = "md5";
    localMAutoDBInfo.colsMap.put("md5", "TEXT PRIMARY KEY  COLLATE NOCASE ");
    localStringBuilder.append(" md5 TEXT PRIMARY KEY  COLLATE NOCASE ");
    localStringBuilder.append(", ");
    localMAutoDBInfo.primaryKey = "md5";
    localMAutoDBInfo.columns[1] = "svrid";
    localMAutoDBInfo.colsMap.put("svrid", "TEXT");
    localStringBuilder.append(" svrid TEXT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[2] = "catalog";
    localMAutoDBInfo.colsMap.put("catalog", "INTEGER");
    localStringBuilder.append(" catalog INTEGER");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[3] = "type";
    localMAutoDBInfo.colsMap.put("type", "INTEGER");
    localStringBuilder.append(" type INTEGER");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[4] = "size";
    localMAutoDBInfo.colsMap.put("size", "INTEGER");
    localStringBuilder.append(" size INTEGER");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[5] = "start";
    localMAutoDBInfo.colsMap.put("start", "INTEGER");
    localStringBuilder.append(" start INTEGER");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[6] = "state";
    localMAutoDBInfo.colsMap.put("state", "INTEGER");
    localStringBuilder.append(" state INTEGER");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[7] = "name";
    localMAutoDBInfo.colsMap.put("name", "TEXT");
    localStringBuilder.append(" name TEXT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[8] = "content";
    localMAutoDBInfo.colsMap.put("content", "TEXT");
    localStringBuilder.append(" content TEXT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[9] = "reserved1";
    localMAutoDBInfo.colsMap.put("reserved1", "TEXT");
    localStringBuilder.append(" reserved1 TEXT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[10] = "reserved2";
    localMAutoDBInfo.colsMap.put("reserved2", "TEXT");
    localStringBuilder.append(" reserved2 TEXT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[11] = "reserved3";
    localMAutoDBInfo.colsMap.put("reserved3", "INTEGER");
    localStringBuilder.append(" reserved3 INTEGER");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[12] = "reserved4";
    localMAutoDBInfo.colsMap.put("reserved4", "INTEGER");
    localStringBuilder.append(" reserved4 INTEGER");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[13] = "app_id";
    localMAutoDBInfo.colsMap.put("app_id", "TEXT");
    localStringBuilder.append(" app_id TEXT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[14] = "groupId";
    localMAutoDBInfo.colsMap.put("groupId", "TEXT default '' ");
    localStringBuilder.append(" groupId TEXT default '' ");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[15] = "lastUseTime";
    localMAutoDBInfo.colsMap.put("lastUseTime", "LONG");
    localStringBuilder.append(" lastUseTime LONG");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[16] = "framesInfo";
    localMAutoDBInfo.colsMap.put("framesInfo", "TEXT default '' ");
    localStringBuilder.append(" framesInfo TEXT default '' ");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[17] = "idx";
    localMAutoDBInfo.colsMap.put("idx", "INTEGER default '0' ");
    localStringBuilder.append(" idx INTEGER default '0' ");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[18] = "temp";
    localMAutoDBInfo.colsMap.put("temp", "INTEGER default '0' ");
    localStringBuilder.append(" temp INTEGER default '0' ");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[19] = "source";
    localMAutoDBInfo.colsMap.put("source", "INTEGER default '0' ");
    localStringBuilder.append(" source INTEGER default '0' ");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[20] = "needupload";
    localMAutoDBInfo.colsMap.put("needupload", "INTEGER default '0' ");
    localStringBuilder.append(" needupload INTEGER default '0' ");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[21] = "designerID";
    localMAutoDBInfo.colsMap.put("designerID", "TEXT");
    localStringBuilder.append(" designerID TEXT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[22] = "thumbUrl";
    localMAutoDBInfo.colsMap.put("thumbUrl", "TEXT");
    localStringBuilder.append(" thumbUrl TEXT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[23] = "cdnUrl";
    localMAutoDBInfo.colsMap.put("cdnUrl", "TEXT");
    localStringBuilder.append(" cdnUrl TEXT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[24] = "encrypturl";
    localMAutoDBInfo.colsMap.put("encrypturl", "TEXT");
    localStringBuilder.append(" encrypturl TEXT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[25] = "aeskey";
    localMAutoDBInfo.colsMap.put("aeskey", "TEXT");
    localStringBuilder.append(" aeskey TEXT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[26] = "width";
    localMAutoDBInfo.colsMap.put("width", "INTEGER default '0' ");
    localStringBuilder.append(" width INTEGER default '0' ");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[27] = "height";
    localMAutoDBInfo.colsMap.put("height", "INTEGER default '0' ");
    localStringBuilder.append(" height INTEGER default '0' ");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[28] = "externUrl";
    localMAutoDBInfo.colsMap.put("externUrl", "TEXT");
    localStringBuilder.append(" externUrl TEXT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[29] = "externMd5";
    localMAutoDBInfo.colsMap.put("externMd5", "TEXT");
    localStringBuilder.append(" externMd5 TEXT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[30] = "activityid";
    localMAutoDBInfo.colsMap.put("activityid", "TEXT");
    localStringBuilder.append(" activityid TEXT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[31] = "tpurl";
    localMAutoDBInfo.colsMap.put("tpurl", "TEXT");
    localStringBuilder.append(" tpurl TEXT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[32] = "tpauthkey";
    localMAutoDBInfo.colsMap.put("tpauthkey", "TEXT");
    localStringBuilder.append(" tpauthkey TEXT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[33] = "wxamMd5";
    localMAutoDBInfo.colsMap.put("wxamMd5", "TEXT");
    localStringBuilder.append(" wxamMd5 TEXT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[34] = "attachedText";
    localMAutoDBInfo.colsMap.put("attachedText", "TEXT");
    localStringBuilder.append(" attachedText TEXT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[35] = "captureStatus";
    localMAutoDBInfo.colsMap.put("captureStatus", "INTEGER default '0' ");
    localStringBuilder.append(" captureStatus INTEGER default '0' ");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[36] = "attachedEmojiMD5";
    localMAutoDBInfo.colsMap.put("attachedEmojiMD5", "BLOB default '' ");
    localStringBuilder.append(" attachedEmojiMD5 BLOB default '' ");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[37] = "imitateMd5";
    localMAutoDBInfo.colsMap.put("imitateMd5", "TEXT");
    localStringBuilder.append(" imitateMd5 TEXT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[38] = "captureUploadErrCode";
    localMAutoDBInfo.colsMap.put("captureUploadErrCode", "INTEGER default '0' ");
    localStringBuilder.append(" captureUploadErrCode INTEGER default '0' ");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[39] = "captureUploadCounter";
    localMAutoDBInfo.colsMap.put("captureUploadCounter", "INTEGER default '0' ");
    localStringBuilder.append(" captureUploadCounter INTEGER default '0' ");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[40] = "captureEnterTime";
    localMAutoDBInfo.colsMap.put("captureEnterTime", "LONG");
    localStringBuilder.append(" captureEnterTime LONG");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[41] = "lensId";
    localMAutoDBInfo.colsMap.put("lensId", "TEXT");
    localStringBuilder.append(" lensId TEXT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[42] = "attachTextColor";
    localMAutoDBInfo.colsMap.put("attachTextColor", "TEXT");
    localStringBuilder.append(" attachTextColor TEXT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[43] = "captureScene";
    localMAutoDBInfo.colsMap.put("captureScene", "INTEGER");
    localStringBuilder.append(" captureScene INTEGER");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[44] = "attr";
    localMAutoDBInfo.colsMap.put("attr", "TEXT");
    localStringBuilder.append(" attr TEXT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[45] = "linkId";
    localMAutoDBInfo.colsMap.put("linkId", "TEXT");
    localStringBuilder.append(" linkId TEXT");
    localMAutoDBInfo.columns[46] = "rowid";
    localMAutoDBInfo.sql = localStringBuilder.toString();
    if (localMAutoDBInfo.primaryKey == null) {
      localMAutoDBInfo.primaryKey = "rowid";
    }
    return localMAutoDBInfo;
  }
  
  public void convertFrom(ContentValues paramContentValues, boolean paramBoolean)
  {
    if (paramContentValues.containsKey("md5"))
    {
      this.field_md5 = paramContentValues.getAsString("md5");
      if (paramBoolean) {
        this.keP = true;
      }
    }
    if (paramContentValues.containsKey("svrid"))
    {
      this.field_svrid = paramContentValues.getAsString("svrid");
      if (paramBoolean) {
        this.keQ = true;
      }
    }
    if (paramContentValues.containsKey("catalog"))
    {
      this.field_catalog = paramContentValues.getAsInteger("catalog").intValue();
      if (paramBoolean) {
        this.keR = true;
      }
    }
    if (paramContentValues.containsKey("type"))
    {
      this.field_type = paramContentValues.getAsInteger("type").intValue();
      if (paramBoolean) {
        this.__hadSettype = true;
      }
    }
    if (paramContentValues.containsKey("size"))
    {
      this.field_size = paramContentValues.getAsInteger("size").intValue();
      if (paramBoolean) {
        this.jLS = true;
      }
    }
    if (paramContentValues.containsKey("start"))
    {
      this.field_start = paramContentValues.getAsInteger("start").intValue();
      if (paramBoolean) {
        this.keS = true;
      }
    }
    if (paramContentValues.containsKey("state"))
    {
      this.field_state = paramContentValues.getAsInteger("state").intValue();
      if (paramBoolean) {
        this.keT = true;
      }
    }
    if (paramContentValues.containsKey("name"))
    {
      this.field_name = paramContentValues.getAsString("name");
      if (paramBoolean) {
        this.keU = true;
      }
    }
    if (paramContentValues.containsKey("content"))
    {
      this.field_content = paramContentValues.getAsString("content");
      if (paramBoolean) {
        this.__hadSetcontent = true;
      }
    }
    if (paramContentValues.containsKey("reserved1"))
    {
      this.field_reserved1 = paramContentValues.getAsString("reserved1");
      if (paramBoolean) {
        this.keV = true;
      }
    }
    if (paramContentValues.containsKey("reserved2"))
    {
      this.field_reserved2 = paramContentValues.getAsString("reserved2");
      if (paramBoolean) {
        this.keW = true;
      }
    }
    if (paramContentValues.containsKey("reserved3"))
    {
      this.field_reserved3 = paramContentValues.getAsInteger("reserved3").intValue();
      if (paramBoolean) {
        this.keX = true;
      }
    }
    if (paramContentValues.containsKey("reserved4"))
    {
      this.field_reserved4 = paramContentValues.getAsInteger("reserved4").intValue();
      if (paramBoolean) {
        this.keY = true;
      }
    }
    if (paramContentValues.containsKey("app_id"))
    {
      this.field_app_id = paramContentValues.getAsString("app_id");
      if (paramBoolean) {
        this.keZ = true;
      }
    }
    if (paramContentValues.containsKey("groupId"))
    {
      this.field_groupId = paramContentValues.getAsString("groupId");
      if (paramBoolean) {
        this.kfa = true;
      }
    }
    if (paramContentValues.containsKey("lastUseTime"))
    {
      this.field_lastUseTime = paramContentValues.getAsLong("lastUseTime").longValue();
      if (paramBoolean) {
        this.kdo = true;
      }
    }
    if (paramContentValues.containsKey("framesInfo"))
    {
      this.field_framesInfo = paramContentValues.getAsString("framesInfo");
      if (paramBoolean) {
        this.kfb = true;
      }
    }
    if (paramContentValues.containsKey("idx"))
    {
      this.field_idx = paramContentValues.getAsInteger("idx").intValue();
      if (paramBoolean) {
        this.kds = true;
      }
    }
    if (paramContentValues.containsKey("temp"))
    {
      this.field_temp = paramContentValues.getAsInteger("temp").intValue();
      if (paramBoolean) {
        this.kfc = true;
      }
    }
    if (paramContentValues.containsKey("source"))
    {
      this.field_source = paramContentValues.getAsInteger("source").intValue();
      if (paramBoolean) {
        this.jMS = true;
      }
    }
    if (paramContentValues.containsKey("needupload"))
    {
      this.field_needupload = paramContentValues.getAsInteger("needupload").intValue();
      if (paramBoolean) {
        this.kfd = true;
      }
    }
    if (paramContentValues.containsKey("designerID"))
    {
      this.field_designerID = paramContentValues.getAsString("designerID");
      if (paramBoolean) {
        this.kfe = true;
      }
    }
    if (paramContentValues.containsKey("thumbUrl"))
    {
      this.field_thumbUrl = paramContentValues.getAsString("thumbUrl");
      if (paramBoolean) {
        this.kff = true;
      }
    }
    if (paramContentValues.containsKey("cdnUrl"))
    {
      this.field_cdnUrl = paramContentValues.getAsString("cdnUrl");
      if (paramBoolean) {
        this.kfg = true;
      }
    }
    if (paramContentValues.containsKey("encrypturl"))
    {
      this.field_encrypturl = paramContentValues.getAsString("encrypturl");
      if (paramBoolean) {
        this.kfh = true;
      }
    }
    if (paramContentValues.containsKey("aeskey"))
    {
      this.field_aeskey = paramContentValues.getAsString("aeskey");
      if (paramBoolean) {
        this.kfi = true;
      }
    }
    if (paramContentValues.containsKey("width"))
    {
      this.field_width = paramContentValues.getAsInteger("width").intValue();
      if (paramBoolean) {
        this.kfj = true;
      }
    }
    if (paramContentValues.containsKey("height"))
    {
      this.field_height = paramContentValues.getAsInteger("height").intValue();
      if (paramBoolean) {
        this.kfk = true;
      }
    }
    if (paramContentValues.containsKey("externUrl"))
    {
      this.field_externUrl = paramContentValues.getAsString("externUrl");
      if (paramBoolean) {
        this.kfl = true;
      }
    }
    if (paramContentValues.containsKey("externMd5"))
    {
      this.field_externMd5 = paramContentValues.getAsString("externMd5");
      if (paramBoolean) {
        this.kfm = true;
      }
    }
    if (paramContentValues.containsKey("activityid"))
    {
      this.field_activityid = paramContentValues.getAsString("activityid");
      if (paramBoolean) {
        this.kfn = true;
      }
    }
    if (paramContentValues.containsKey("tpurl"))
    {
      this.field_tpurl = paramContentValues.getAsString("tpurl");
      if (paramBoolean) {
        this.kfo = true;
      }
    }
    if (paramContentValues.containsKey("tpauthkey"))
    {
      this.field_tpauthkey = paramContentValues.getAsString("tpauthkey");
      if (paramBoolean) {
        this.kfp = true;
      }
    }
    if (paramContentValues.containsKey("wxamMd5"))
    {
      this.field_wxamMd5 = paramContentValues.getAsString("wxamMd5");
      if (paramBoolean) {
        this.kfq = true;
      }
    }
    if (paramContentValues.containsKey("attachedText"))
    {
      this.field_attachedText = paramContentValues.getAsString("attachedText");
      if (paramBoolean) {
        this.kfr = true;
      }
    }
    if (paramContentValues.containsKey("captureStatus"))
    {
      this.field_captureStatus = paramContentValues.getAsInteger("captureStatus").intValue();
      if (paramBoolean) {
        this.kfs = true;
      }
    }
    if (paramContentValues.containsKey("attachedEmojiMD5"))
    {
      this.field_attachedEmojiMD5 = paramContentValues.getAsByteArray("attachedEmojiMD5");
      if (paramBoolean) {
        this.kft = true;
      }
    }
    if (paramContentValues.containsKey("imitateMd5"))
    {
      this.field_imitateMd5 = paramContentValues.getAsString("imitateMd5");
      if (paramBoolean) {
        this.kfu = true;
      }
    }
    if (paramContentValues.containsKey("captureUploadErrCode"))
    {
      this.field_captureUploadErrCode = paramContentValues.getAsInteger("captureUploadErrCode").intValue();
      if (paramBoolean) {
        this.kfv = true;
      }
    }
    if (paramContentValues.containsKey("captureUploadCounter"))
    {
      this.field_captureUploadCounter = paramContentValues.getAsInteger("captureUploadCounter").intValue();
      if (paramBoolean) {
        this.kfw = true;
      }
    }
    if (paramContentValues.containsKey("captureEnterTime"))
    {
      this.field_captureEnterTime = paramContentValues.getAsLong("captureEnterTime").longValue();
      if (paramBoolean) {
        this.kfx = true;
      }
    }
    if (paramContentValues.containsKey("lensId"))
    {
      this.field_lensId = paramContentValues.getAsString("lensId");
      if (paramBoolean) {
        this.kfy = true;
      }
    }
    if (paramContentValues.containsKey("attachTextColor"))
    {
      this.field_attachTextColor = paramContentValues.getAsString("attachTextColor");
      if (paramBoolean) {
        this.kfz = true;
      }
    }
    if (paramContentValues.containsKey("captureScene"))
    {
      this.field_captureScene = paramContentValues.getAsInteger("captureScene").intValue();
      if (paramBoolean) {
        this.kfA = true;
      }
    }
    if (paramContentValues.containsKey("attr"))
    {
      this.field_attr = paramContentValues.getAsString("attr");
      if (paramBoolean) {
        this.kfB = true;
      }
    }
    if (paramContentValues.containsKey("linkId"))
    {
      this.field_linkId = paramContentValues.getAsString("linkId");
      if (paramBoolean) {
        this.kfC = true;
      }
    }
    if (paramContentValues.containsKey("rowid")) {
      this.systemRowid = paramContentValues.getAsLong("rowid").longValue();
    }
  }
  
  public void convertFrom(Cursor paramCursor)
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
      if (kfD != k) {
        break label65;
      }
      this.field_md5 = paramCursor.getString(i);
      this.keP = true;
    }
    for (;;)
    {
      i += 1;
      break label20;
      break;
      label65:
      if (kfE == k) {
        this.field_svrid = paramCursor.getString(i);
      } else if (kfF == k) {
        this.field_catalog = paramCursor.getInt(i);
      } else if (type_HASHCODE == k) {
        this.field_type = paramCursor.getInt(i);
      } else if (jLU == k) {
        this.field_size = paramCursor.getInt(i);
      } else if (kfG == k) {
        this.field_start = paramCursor.getInt(i);
      } else if (kfH == k) {
        this.field_state = paramCursor.getInt(i);
      } else if (kfI == k) {
        this.field_name = paramCursor.getString(i);
      } else if (content_HASHCODE == k) {
        this.field_content = paramCursor.getString(i);
      } else if (kfJ == k) {
        this.field_reserved1 = paramCursor.getString(i);
      } else if (kfK == k) {
        this.field_reserved2 = paramCursor.getString(i);
      } else if (kfL == k) {
        this.field_reserved3 = paramCursor.getInt(i);
      } else if (kfM == k) {
        this.field_reserved4 = paramCursor.getInt(i);
      } else if (kfN == k) {
        this.field_app_id = paramCursor.getString(i);
      } else if (kfO == k) {
        this.field_groupId = paramCursor.getString(i);
      } else if (kdO == k) {
        this.field_lastUseTime = paramCursor.getLong(i);
      } else if (kfP == k) {
        this.field_framesInfo = paramCursor.getString(i);
      } else if (kdS == k) {
        this.field_idx = paramCursor.getInt(i);
      } else if (kfQ == k) {
        this.field_temp = paramCursor.getInt(i);
      } else if (jMX == k) {
        this.field_source = paramCursor.getInt(i);
      } else if (kfR == k) {
        this.field_needupload = paramCursor.getInt(i);
      } else if (kfS == k) {
        this.field_designerID = paramCursor.getString(i);
      } else if (kfT == k) {
        this.field_thumbUrl = paramCursor.getString(i);
      } else if (kfU == k) {
        this.field_cdnUrl = paramCursor.getString(i);
      } else if (kfV == k) {
        this.field_encrypturl = paramCursor.getString(i);
      } else if (kfW == k) {
        this.field_aeskey = paramCursor.getString(i);
      } else if (kfX == k) {
        this.field_width = paramCursor.getInt(i);
      } else if (kfY == k) {
        this.field_height = paramCursor.getInt(i);
      } else if (kfZ == k) {
        this.field_externUrl = paramCursor.getString(i);
      } else if (kga == k) {
        this.field_externMd5 = paramCursor.getString(i);
      } else if (kgb == k) {
        this.field_activityid = paramCursor.getString(i);
      } else if (kgc == k) {
        this.field_tpurl = paramCursor.getString(i);
      } else if (kgd == k) {
        this.field_tpauthkey = paramCursor.getString(i);
      } else if (kge == k) {
        this.field_wxamMd5 = paramCursor.getString(i);
      } else if (kgf == k) {
        this.field_attachedText = paramCursor.getString(i);
      } else if (kgg == k) {
        this.field_captureStatus = paramCursor.getInt(i);
      } else if (kgh == k) {
        this.field_attachedEmojiMD5 = paramCursor.getBlob(i);
      } else if (kgi == k) {
        this.field_imitateMd5 = paramCursor.getString(i);
      } else if (kgj == k) {
        this.field_captureUploadErrCode = paramCursor.getInt(i);
      } else if (kgk == k) {
        this.field_captureUploadCounter = paramCursor.getInt(i);
      } else if (kgl == k) {
        this.field_captureEnterTime = paramCursor.getLong(i);
      } else if (kgm == k) {
        this.field_lensId = paramCursor.getString(i);
      } else if (kgn == k) {
        this.field_attachTextColor = paramCursor.getString(i);
      } else if (kgo == k) {
        this.field_captureScene = paramCursor.getInt(i);
      } else if (kgp == k) {
        this.field_attr = paramCursor.getString(i);
      } else if (kgq == k) {
        this.field_linkId = paramCursor.getString(i);
      } else if (rowid_HASHCODE == k) {
        this.systemRowid = paramCursor.getLong(i);
      }
    }
  }
  
  public ContentValues convertTo()
  {
    ContentValues localContentValues = new ContentValues();
    if (this.keP) {
      localContentValues.put("md5", this.field_md5);
    }
    if (this.keQ) {
      localContentValues.put("svrid", this.field_svrid);
    }
    if (this.keR) {
      localContentValues.put("catalog", Integer.valueOf(this.field_catalog));
    }
    if (this.__hadSettype) {
      localContentValues.put("type", Integer.valueOf(this.field_type));
    }
    if (this.jLS) {
      localContentValues.put("size", Integer.valueOf(this.field_size));
    }
    if (this.keS) {
      localContentValues.put("start", Integer.valueOf(this.field_start));
    }
    if (this.keT) {
      localContentValues.put("state", Integer.valueOf(this.field_state));
    }
    if (this.keU) {
      localContentValues.put("name", this.field_name);
    }
    if (this.__hadSetcontent) {
      localContentValues.put("content", this.field_content);
    }
    if (this.keV) {
      localContentValues.put("reserved1", this.field_reserved1);
    }
    if (this.keW) {
      localContentValues.put("reserved2", this.field_reserved2);
    }
    if (this.keX) {
      localContentValues.put("reserved3", Integer.valueOf(this.field_reserved3));
    }
    if (this.keY) {
      localContentValues.put("reserved4", Integer.valueOf(this.field_reserved4));
    }
    if (this.keZ) {
      localContentValues.put("app_id", this.field_app_id);
    }
    if (this.field_groupId == null) {
      this.field_groupId = "";
    }
    if (this.kfa) {
      localContentValues.put("groupId", this.field_groupId);
    }
    if (this.kdo) {
      localContentValues.put("lastUseTime", Long.valueOf(this.field_lastUseTime));
    }
    if (this.field_framesInfo == null) {
      this.field_framesInfo = "";
    }
    if (this.kfb) {
      localContentValues.put("framesInfo", this.field_framesInfo);
    }
    if (this.kds) {
      localContentValues.put("idx", Integer.valueOf(this.field_idx));
    }
    if (this.kfc) {
      localContentValues.put("temp", Integer.valueOf(this.field_temp));
    }
    if (this.jMS) {
      localContentValues.put("source", Integer.valueOf(this.field_source));
    }
    if (this.kfd) {
      localContentValues.put("needupload", Integer.valueOf(this.field_needupload));
    }
    if (this.kfe) {
      localContentValues.put("designerID", this.field_designerID);
    }
    if (this.kff) {
      localContentValues.put("thumbUrl", this.field_thumbUrl);
    }
    if (this.kfg) {
      localContentValues.put("cdnUrl", this.field_cdnUrl);
    }
    if (this.kfh) {
      localContentValues.put("encrypturl", this.field_encrypturl);
    }
    if (this.kfi) {
      localContentValues.put("aeskey", this.field_aeskey);
    }
    if (this.kfj) {
      localContentValues.put("width", Integer.valueOf(this.field_width));
    }
    if (this.kfk) {
      localContentValues.put("height", Integer.valueOf(this.field_height));
    }
    if (this.kfl) {
      localContentValues.put("externUrl", this.field_externUrl);
    }
    if (this.kfm) {
      localContentValues.put("externMd5", this.field_externMd5);
    }
    if (this.kfn) {
      localContentValues.put("activityid", this.field_activityid);
    }
    if (this.kfo) {
      localContentValues.put("tpurl", this.field_tpurl);
    }
    if (this.kfp) {
      localContentValues.put("tpauthkey", this.field_tpauthkey);
    }
    if (this.kfq) {
      localContentValues.put("wxamMd5", this.field_wxamMd5);
    }
    if (this.kfr) {
      localContentValues.put("attachedText", this.field_attachedText);
    }
    if (this.kfs) {
      localContentValues.put("captureStatus", Integer.valueOf(this.field_captureStatus));
    }
    if (this.kft) {
      localContentValues.put("attachedEmojiMD5", this.field_attachedEmojiMD5);
    }
    if (this.kfu) {
      localContentValues.put("imitateMd5", this.field_imitateMd5);
    }
    if (this.kfv) {
      localContentValues.put("captureUploadErrCode", Integer.valueOf(this.field_captureUploadErrCode));
    }
    if (this.kfw) {
      localContentValues.put("captureUploadCounter", Integer.valueOf(this.field_captureUploadCounter));
    }
    if (this.kfx) {
      localContentValues.put("captureEnterTime", Long.valueOf(this.field_captureEnterTime));
    }
    if (this.kfy) {
      localContentValues.put("lensId", this.field_lensId);
    }
    if (this.kfz) {
      localContentValues.put("attachTextColor", this.field_attachTextColor);
    }
    if (this.kfA) {
      localContentValues.put("captureScene", Integer.valueOf(this.field_captureScene));
    }
    if (this.kfB) {
      localContentValues.put("attr", this.field_attr);
    }
    if (this.kfC) {
      localContentValues.put("linkId", this.field_linkId);
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
  
  public StorageObserverOwner<? extends bm> getObserverOwner()
  {
    return observerOwner;
  }
  
  public Object getPrimaryKeyValue()
  {
    return this.field_md5;
  }
  
  public SingleTable getTable()
  {
    return TABLE;
  }
  
  public String getTableName()
  {
    return TABLE.getName();
  }
  
  public void reset() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     com.tencent.mm.autogen.b.bm
 * JD-Core Version:    0.7.0.1
 */