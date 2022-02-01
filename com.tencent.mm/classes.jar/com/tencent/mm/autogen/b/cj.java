package com.tencent.mm.autogen.b;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.protocal.protobuf.FinderAuthInfo;
import com.tencent.mm.protocal.protobuf.aud;
import com.tencent.mm.protocal.protobuf.avl;
import com.tencent.mm.protocal.protobuf.bbl;
import com.tencent.mm.protocal.protobuf.bcf;
import com.tencent.mm.protocal.protobuf.bfm;
import com.tencent.mm.protocal.protobuf.bry;
import com.tencent.mm.protocal.protobuf.ei;
import com.tencent.mm.protocal.protobuf.fat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.storage.IAutoDBItem;
import com.tencent.mm.sdk.storage.IAutoDBItem.MAutoDBInfo;
import com.tencent.mm.sdk.storage.observer.StorageObserverOwner;
import com.tencent.mm.sdk.storage.sql.Column;
import com.tencent.mm.sdk.storage.sql.SingleTable;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.Map;

public abstract class cj
  extends IAutoDBItem
{
  public static final IAutoDBItem.MAutoDBInfo DB_INFO = aJm();
  public static final String[] INDEX_CREATE;
  public static final Column ROWID;
  public static final SingleTable TABLE = new SingleTable("FinderContact");
  public static final Column UPDATETIME;
  public static final Column USERNAME;
  public static final Column jKD;
  private static final int jLl;
  private static final int jMG;
  public static final Column jMN;
  private static final int jMX;
  public static final Column jMw;
  private static final int jSZ;
  public static final Column jSx;
  public static final Column jTk;
  private static final int jTs;
  public static final Column jYW;
  private static final int jZI;
  private static final int kiD;
  public static final Column kiu;
  public static final Column knA;
  public static final Column knB;
  public static final Column knC;
  public static final Column knD;
  public static final Column knE;
  public static final Column knF;
  public static final Column knG;
  public static final Column knH;
  public static final Column knI;
  public static final Column knJ;
  public static final Column knK;
  public static final Column kna;
  public static final Column knb;
  public static final Column knc;
  public static final Column knd;
  public static final Column kne;
  public static final Column knf;
  public static final Column kng;
  public static final Column knh;
  public static final Column kni;
  public static final Column knj;
  public static final Column knk;
  public static final Column knl;
  public static final Column knm;
  public static final Column knn;
  public static final Column kno;
  public static final Column knp;
  public static final Column knq;
  public static final Column knr;
  public static final Column kns;
  public static final Column knt;
  public static final Column knu;
  public static final Column knv;
  public static final Column knw;
  public static final Column knx;
  public static final Column kny;
  public static final Column knz;
  private static final int koA;
  private static final int koB;
  private static final int koC;
  private static final int koD;
  private static final int koE;
  private static final int koF;
  private static final int koG;
  private static final int koH;
  private static final int koI;
  private static final int koJ;
  private static final int koK;
  private static final int koL;
  private static final int koM;
  private static final int koN;
  private static final int koO;
  private static final int koP;
  private static final int koQ;
  private static final int koR;
  private static final int koS;
  private static final int koT;
  private static final int koU;
  private static final int koV;
  private static final int koW;
  private static final int koX;
  private static final int koY;
  private static final int koZ;
  private static final int kow;
  private static final int kox;
  private static final int koy;
  private static final int koz;
  private static final int kpa;
  private static final int kpb;
  private static final int kpc;
  private static final int kpd;
  private static final int kpe;
  private static final int kpf;
  private static final int kpg;
  private static final StorageObserverOwner<cj> observerOwner = new StorageObserverOwner();
  private static final int rowid_HASHCODE;
  private static final int updateTime_HASHCODE;
  private static final int username_HASHCODE;
  private boolean __hadSetupdateTime = true;
  private boolean __hadSetusername = true;
  public ei field_agencyCollaborateInfo;
  public FinderAuthInfo field_authInfo;
  public String field_avatarUrl;
  public bfm field_badgeInfoList;
  public aud field_bindInfoList;
  public int field_coverEntranceFlag;
  public String field_coverImg;
  public String field_coverUrl;
  public int field_extFlag;
  public avl field_extInfo;
  public int field_feedCount;
  public String field_firstPageMD5;
  public int field_followTime;
  public int field_follow_Flag;
  public int field_friendFollowCount;
  public bbl field_guestInfo;
  public long field_interactionCount;
  public bcf field_jumpInfoList;
  public String field_liveAlias;
  public long field_liveAnchorStatusFlag;
  public String field_liveCoverImg;
  public long field_liveMicSetting;
  public long field_liveMicSettingSwitch;
  public int field_liveStatus;
  public long field_liveSwitchFlag;
  public String field_nickname;
  public int field_originalEntranceFlag;
  public int field_originalFlag;
  public bry field_originalInfo;
  public long field_personalMsgUpdateTime;
  public String field_pyInitial;
  public String field_rawAvatarUrl;
  public String field_rawNickname;
  public int field_retryCount;
  public long field_rewardTotalAmountInWecoin;
  public fat field_settlementInfo;
  public String field_signature;
  public int field_source;
  public int field_spamStatus;
  public long field_updateTime;
  public int field_user_flag;
  public int field_user_mode;
  public String field_username;
  public String field_v5username;
  public long field_version;
  public String field_vestNickname;
  private boolean jKU = true;
  private boolean jMB = true;
  private boolean jMS = true;
  private boolean jSL = true;
  private boolean jTo = true;
  private boolean jZp = true;
  private boolean kiy = true;
  private boolean knL = true;
  private boolean knM = true;
  private boolean knN = true;
  private boolean knO = true;
  private boolean knP = true;
  private boolean knQ = true;
  private boolean knR = true;
  private boolean knS = true;
  private boolean knT = true;
  private boolean knU = true;
  private boolean knV = true;
  private boolean knW = true;
  private boolean knX = true;
  private boolean knY = true;
  private boolean knZ = true;
  private boolean koa = true;
  private boolean kob = true;
  private boolean koc = true;
  private boolean kod = true;
  private boolean koe = true;
  private boolean kof = true;
  private boolean kog = true;
  private boolean koh = true;
  private boolean koi = true;
  private boolean koj = true;
  private boolean kok = true;
  private boolean kol = true;
  private boolean kom = true;
  private boolean kon = true;
  private boolean koo = true;
  private boolean kop = true;
  private boolean koq = true;
  private boolean kor = true;
  private boolean kos = true;
  private boolean kot = true;
  private boolean kou = true;
  private boolean kov = true;
  
  static
  {
    ROWID = new Column("rowid", "long", TABLE.getName(), "");
    USERNAME = new Column("username", "string", TABLE.getName(), "");
    jTk = new Column("nickname", "string", TABLE.getName(), "");
    kna = new Column("avatarUrl", "string", TABLE.getName(), "");
    jMw = new Column("version", "long", TABLE.getName(), "");
    knb = new Column("firstPageMD5", "string", TABLE.getName(), "");
    jKD = new Column("signature", "string", TABLE.getName(), "");
    knc = new Column("follow_Flag", "int", TABLE.getName(), "");
    jYW = new Column("pyInitial", "string", TABLE.getName(), "");
    knd = new Column("followTime", "int", TABLE.getName(), "");
    kne = new Column("coverImg", "string", TABLE.getName(), "");
    knf = new Column("spamStatus", "int", TABLE.getName(), "");
    kng = new Column("authInfo", "proto", TABLE.getName(), "com.tencent.mm.protocal.protobuf.FinderAuthInfo");
    jSx = new Column("extInfo", "proto", TABLE.getName(), "com.tencent.mm.protocal.protobuf.FinderContactExtraInfo");
    knh = new Column("originalFlag", "int", TABLE.getName(), "");
    kni = new Column("originalInfo", "proto", TABLE.getName(), "com.tencent.mm.protocal.protobuf.FinderOriginalInfo");
    kiu = new Column("extFlag", "int", TABLE.getName(), "");
    UPDATETIME = new Column("updateTime", "long", TABLE.getName(), "");
    knj = new Column("retryCount", "int", TABLE.getName(), "");
    knk = new Column("originalEntranceFlag", "int", TABLE.getName(), "");
    knl = new Column("liveCoverImg", "string", TABLE.getName(), "");
    knm = new Column("liveStatus", "int", TABLE.getName(), "");
    knn = new Column("liveAnchorStatusFlag", "long", TABLE.getName(), "");
    kno = new Column("friendFollowCount", "int", TABLE.getName(), "");
    knp = new Column("liveSwitchFlag", "long", TABLE.getName(), "");
    knq = new Column("liveAlias", "string", TABLE.getName(), "");
    knr = new Column("rewardTotalAmountInWecoin", "long", TABLE.getName(), "");
    kns = new Column("personalMsgUpdateTime", "long", TABLE.getName(), "");
    knt = new Column("v5username", "string", TABLE.getName(), "");
    knu = new Column("vestNickname", "string", TABLE.getName(), "");
    knv = new Column("feedCount", "int", TABLE.getName(), "");
    jMN = new Column("source", "int", TABLE.getName(), "");
    knw = new Column("liveMicSetting", "long", TABLE.getName(), "");
    knx = new Column("liveMicSettingSwitch", "long", TABLE.getName(), "");
    kny = new Column("badgeInfoList", "proto", TABLE.getName(), "com.tencent.mm.protocal.protobuf.FinderLiveBadgeInfoList");
    knz = new Column("settlementInfo", "proto", TABLE.getName(), "com.tencent.mm.protocal.protobuf.SettleToAgencyRelateInfo");
    knA = new Column("agencyCollaborateInfo", "proto", TABLE.getName(), "com.tencent.mm.protocal.protobuf.AgencyCollaborateInfo");
    knB = new Column("bindInfoList", "proto", TABLE.getName(), "com.tencent.mm.protocal.protobuf.FinderBindInfoList");
    knC = new Column("guestInfo", "proto", TABLE.getName(), "com.tencent.mm.protocal.protobuf.FinderGuestInfo");
    knD = new Column("user_mode", "int", TABLE.getName(), "");
    knE = new Column("coverUrl", "string", TABLE.getName(), "");
    knF = new Column("coverEntranceFlag", "int", TABLE.getName(), "");
    knG = new Column("user_flag", "int", TABLE.getName(), "");
    knH = new Column("rawNickname", "string", TABLE.getName(), "");
    knI = new Column("rawAvatarUrl", "string", TABLE.getName(), "");
    knJ = new Column("jumpInfoList", "proto", TABLE.getName(), "com.tencent.mm.protocal.protobuf.FinderJumpInfoList");
    knK = new Column("interactionCount", "long", TABLE.getName(), "");
    INDEX_CREATE = new String[] { "CREATE INDEX IF NOT EXISTS FinderContact_username_index ON FinderContact(username)", "CREATE INDEX IF NOT EXISTS FinderContact_follow_flag_index ON FinderContact(follow_Flag)", "CREATE INDEX IF NOT EXISTS FinderContact_user_flag_index ON FinderContact(user_flag)" };
    username_HASHCODE = "username".hashCode();
    jTs = "nickname".hashCode();
    kow = "avatarUrl".hashCode();
    jMG = "version".hashCode();
    kox = "firstPageMD5".hashCode();
    jLl = "signature".hashCode();
    koy = "follow_Flag".hashCode();
    jZI = "pyInitial".hashCode();
    koz = "followTime".hashCode();
    koA = "coverImg".hashCode();
    koB = "spamStatus".hashCode();
    koC = "authInfo".hashCode();
    jSZ = "extInfo".hashCode();
    koD = "originalFlag".hashCode();
    koE = "originalInfo".hashCode();
    kiD = "extFlag".hashCode();
    updateTime_HASHCODE = "updateTime".hashCode();
    koF = "retryCount".hashCode();
    koG = "originalEntranceFlag".hashCode();
    koH = "liveCoverImg".hashCode();
    koI = "liveStatus".hashCode();
    koJ = "liveAnchorStatusFlag".hashCode();
    koK = "friendFollowCount".hashCode();
    koL = "liveSwitchFlag".hashCode();
    koM = "liveAlias".hashCode();
    koN = "rewardTotalAmountInWecoin".hashCode();
    koO = "personalMsgUpdateTime".hashCode();
    koP = "v5username".hashCode();
    koQ = "vestNickname".hashCode();
    koR = "feedCount".hashCode();
    jMX = "source".hashCode();
    koS = "liveMicSetting".hashCode();
    koT = "liveMicSettingSwitch".hashCode();
    koU = "badgeInfoList".hashCode();
    koV = "settlementInfo".hashCode();
    koW = "agencyCollaborateInfo".hashCode();
    koX = "bindInfoList".hashCode();
    koY = "guestInfo".hashCode();
    koZ = "user_mode".hashCode();
    kpa = "coverUrl".hashCode();
    kpb = "coverEntranceFlag".hashCode();
    kpc = "user_flag".hashCode();
    kpd = "rawNickname".hashCode();
    kpe = "rawAvatarUrl".hashCode();
    kpf = "jumpInfoList".hashCode();
    kpg = "interactionCount".hashCode();
    rowid_HASHCODE = "rowid".hashCode();
  }
  
  public static IAutoDBItem.MAutoDBInfo aJm()
  {
    IAutoDBItem.MAutoDBInfo localMAutoDBInfo = new IAutoDBItem.MAutoDBInfo();
    localMAutoDBInfo.fields = new Field[46];
    localMAutoDBInfo.columns = new String[47];
    StringBuilder localStringBuilder = new StringBuilder();
    localMAutoDBInfo.columns[0] = "username";
    localMAutoDBInfo.colsMap.put("username", "TEXT default ''  PRIMARY KEY ");
    localStringBuilder.append(" username TEXT default ''  PRIMARY KEY ");
    localStringBuilder.append(", ");
    localMAutoDBInfo.primaryKey = "username";
    localMAutoDBInfo.columns[1] = "nickname";
    localMAutoDBInfo.colsMap.put("nickname", "TEXT default '' ");
    localStringBuilder.append(" nickname TEXT default '' ");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[2] = "avatarUrl";
    localMAutoDBInfo.colsMap.put("avatarUrl", "TEXT default '' ");
    localStringBuilder.append(" avatarUrl TEXT default '' ");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[3] = "version";
    localMAutoDBInfo.colsMap.put("version", "LONG");
    localStringBuilder.append(" version LONG");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[4] = "firstPageMD5";
    localMAutoDBInfo.colsMap.put("firstPageMD5", "TEXT default '' ");
    localStringBuilder.append(" firstPageMD5 TEXT default '' ");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[5] = "signature";
    localMAutoDBInfo.colsMap.put("signature", "TEXT default '' ");
    localStringBuilder.append(" signature TEXT default '' ");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[6] = "follow_Flag";
    localMAutoDBInfo.colsMap.put("follow_Flag", "INTEGER default '0' ");
    localStringBuilder.append(" follow_Flag INTEGER default '0' ");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[7] = "pyInitial";
    localMAutoDBInfo.colsMap.put("pyInitial", "TEXT default '' ");
    localStringBuilder.append(" pyInitial TEXT default '' ");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[8] = "followTime";
    localMAutoDBInfo.colsMap.put("followTime", "INTEGER default '0' ");
    localStringBuilder.append(" followTime INTEGER default '0' ");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[9] = "coverImg";
    localMAutoDBInfo.colsMap.put("coverImg", "TEXT default '' ");
    localStringBuilder.append(" coverImg TEXT default '' ");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[10] = "spamStatus";
    localMAutoDBInfo.colsMap.put("spamStatus", "INTEGER");
    localStringBuilder.append(" spamStatus INTEGER");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[11] = "authInfo";
    localMAutoDBInfo.colsMap.put("authInfo", "BLOB");
    localStringBuilder.append(" authInfo BLOB");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[12] = "extInfo";
    localMAutoDBInfo.colsMap.put("extInfo", "BLOB");
    localStringBuilder.append(" extInfo BLOB");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[13] = "originalFlag";
    localMAutoDBInfo.colsMap.put("originalFlag", "INTEGER default '0' ");
    localStringBuilder.append(" originalFlag INTEGER default '0' ");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[14] = "originalInfo";
    localMAutoDBInfo.colsMap.put("originalInfo", "BLOB");
    localStringBuilder.append(" originalInfo BLOB");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[15] = "extFlag";
    localMAutoDBInfo.colsMap.put("extFlag", "INTEGER");
    localStringBuilder.append(" extFlag INTEGER");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[16] = "updateTime";
    localMAutoDBInfo.colsMap.put("updateTime", "LONG");
    localStringBuilder.append(" updateTime LONG");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[17] = "retryCount";
    localMAutoDBInfo.colsMap.put("retryCount", "INTEGER");
    localStringBuilder.append(" retryCount INTEGER");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[18] = "originalEntranceFlag";
    localMAutoDBInfo.colsMap.put("originalEntranceFlag", "INTEGER default '0' ");
    localStringBuilder.append(" originalEntranceFlag INTEGER default '0' ");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[19] = "liveCoverImg";
    localMAutoDBInfo.colsMap.put("liveCoverImg", "TEXT default '' ");
    localStringBuilder.append(" liveCoverImg TEXT default '' ");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[20] = "liveStatus";
    localMAutoDBInfo.colsMap.put("liveStatus", "INTEGER default '0' ");
    localStringBuilder.append(" liveStatus INTEGER default '0' ");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[21] = "liveAnchorStatusFlag";
    localMAutoDBInfo.colsMap.put("liveAnchorStatusFlag", "LONG default '0' ");
    localStringBuilder.append(" liveAnchorStatusFlag LONG default '0' ");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[22] = "friendFollowCount";
    localMAutoDBInfo.colsMap.put("friendFollowCount", "INTEGER default '0' ");
    localStringBuilder.append(" friendFollowCount INTEGER default '0' ");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[23] = "liveSwitchFlag";
    localMAutoDBInfo.colsMap.put("liveSwitchFlag", "LONG default '0' ");
    localStringBuilder.append(" liveSwitchFlag LONG default '0' ");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[24] = "liveAlias";
    localMAutoDBInfo.colsMap.put("liveAlias", "TEXT default '' ");
    localStringBuilder.append(" liveAlias TEXT default '' ");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[25] = "rewardTotalAmountInWecoin";
    localMAutoDBInfo.colsMap.put("rewardTotalAmountInWecoin", "LONG default '0' ");
    localStringBuilder.append(" rewardTotalAmountInWecoin LONG default '0' ");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[26] = "personalMsgUpdateTime";
    localMAutoDBInfo.colsMap.put("personalMsgUpdateTime", "LONG");
    localStringBuilder.append(" personalMsgUpdateTime LONG");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[27] = "v5username";
    localMAutoDBInfo.colsMap.put("v5username", "TEXT default '' ");
    localStringBuilder.append(" v5username TEXT default '' ");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[28] = "vestNickname";
    localMAutoDBInfo.colsMap.put("vestNickname", "TEXT default '' ");
    localStringBuilder.append(" vestNickname TEXT default '' ");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[29] = "feedCount";
    localMAutoDBInfo.colsMap.put("feedCount", "INTEGER default '0' ");
    localStringBuilder.append(" feedCount INTEGER default '0' ");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[30] = "source";
    localMAutoDBInfo.colsMap.put("source", "INTEGER default '0' ");
    localStringBuilder.append(" source INTEGER default '0' ");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[31] = "liveMicSetting";
    localMAutoDBInfo.colsMap.put("liveMicSetting", "LONG default '0' ");
    localStringBuilder.append(" liveMicSetting LONG default '0' ");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[32] = "liveMicSettingSwitch";
    localMAutoDBInfo.colsMap.put("liveMicSettingSwitch", "LONG default '0' ");
    localStringBuilder.append(" liveMicSettingSwitch LONG default '0' ");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[33] = "badgeInfoList";
    localMAutoDBInfo.colsMap.put("badgeInfoList", "BLOB");
    localStringBuilder.append(" badgeInfoList BLOB");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[34] = "settlementInfo";
    localMAutoDBInfo.colsMap.put("settlementInfo", "BLOB");
    localStringBuilder.append(" settlementInfo BLOB");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[35] = "agencyCollaborateInfo";
    localMAutoDBInfo.colsMap.put("agencyCollaborateInfo", "BLOB");
    localStringBuilder.append(" agencyCollaborateInfo BLOB");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[36] = "bindInfoList";
    localMAutoDBInfo.colsMap.put("bindInfoList", "BLOB");
    localStringBuilder.append(" bindInfoList BLOB");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[37] = "guestInfo";
    localMAutoDBInfo.colsMap.put("guestInfo", "BLOB");
    localStringBuilder.append(" guestInfo BLOB");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[38] = "user_mode";
    localMAutoDBInfo.colsMap.put("user_mode", "INTEGER default '0' ");
    localStringBuilder.append(" user_mode INTEGER default '0' ");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[39] = "coverUrl";
    localMAutoDBInfo.colsMap.put("coverUrl", "TEXT default '' ");
    localStringBuilder.append(" coverUrl TEXT default '' ");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[40] = "coverEntranceFlag";
    localMAutoDBInfo.colsMap.put("coverEntranceFlag", "INTEGER default '0' ");
    localStringBuilder.append(" coverEntranceFlag INTEGER default '0' ");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[41] = "user_flag";
    localMAutoDBInfo.colsMap.put("user_flag", "INTEGER default '0' ");
    localStringBuilder.append(" user_flag INTEGER default '0' ");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[42] = "rawNickname";
    localMAutoDBInfo.colsMap.put("rawNickname", "TEXT default '' ");
    localStringBuilder.append(" rawNickname TEXT default '' ");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[43] = "rawAvatarUrl";
    localMAutoDBInfo.colsMap.put("rawAvatarUrl", "TEXT default '' ");
    localStringBuilder.append(" rawAvatarUrl TEXT default '' ");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[44] = "jumpInfoList";
    localMAutoDBInfo.colsMap.put("jumpInfoList", "BLOB");
    localStringBuilder.append(" jumpInfoList BLOB");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[45] = "interactionCount";
    localMAutoDBInfo.colsMap.put("interactionCount", "LONG default '0' ");
    localStringBuilder.append(" interactionCount LONG default '0' ");
    localMAutoDBInfo.columns[46] = "rowid";
    localMAutoDBInfo.sql = localStringBuilder.toString();
    if (localMAutoDBInfo.primaryKey == null) {
      localMAutoDBInfo.primaryKey = "rowid";
    }
    return localMAutoDBInfo;
  }
  
  public void convertFrom(ContentValues paramContentValues, boolean paramBoolean)
  {
    if (paramContentValues.containsKey("username"))
    {
      this.field_username = paramContentValues.getAsString("username");
      if (paramBoolean) {
        this.__hadSetusername = true;
      }
    }
    if (paramContentValues.containsKey("nickname"))
    {
      this.field_nickname = paramContentValues.getAsString("nickname");
      if (paramBoolean) {
        this.jTo = true;
      }
    }
    if (paramContentValues.containsKey("avatarUrl"))
    {
      this.field_avatarUrl = paramContentValues.getAsString("avatarUrl");
      if (paramBoolean) {
        this.knL = true;
      }
    }
    if (paramContentValues.containsKey("version"))
    {
      this.field_version = paramContentValues.getAsLong("version").longValue();
      if (paramBoolean) {
        this.jMB = true;
      }
    }
    if (paramContentValues.containsKey("firstPageMD5"))
    {
      this.field_firstPageMD5 = paramContentValues.getAsString("firstPageMD5");
      if (paramBoolean) {
        this.knM = true;
      }
    }
    if (paramContentValues.containsKey("signature"))
    {
      this.field_signature = paramContentValues.getAsString("signature");
      if (paramBoolean) {
        this.jKU = true;
      }
    }
    if (paramContentValues.containsKey("follow_Flag"))
    {
      this.field_follow_Flag = paramContentValues.getAsInteger("follow_Flag").intValue();
      if (paramBoolean) {
        this.knN = true;
      }
    }
    if (paramContentValues.containsKey("pyInitial"))
    {
      this.field_pyInitial = paramContentValues.getAsString("pyInitial");
      if (paramBoolean) {
        this.jZp = true;
      }
    }
    if (paramContentValues.containsKey("followTime"))
    {
      this.field_followTime = paramContentValues.getAsInteger("followTime").intValue();
      if (paramBoolean) {
        this.knO = true;
      }
    }
    if (paramContentValues.containsKey("coverImg"))
    {
      this.field_coverImg = paramContentValues.getAsString("coverImg");
      if (paramBoolean) {
        this.knP = true;
      }
    }
    if (paramContentValues.containsKey("spamStatus"))
    {
      this.field_spamStatus = paramContentValues.getAsInteger("spamStatus").intValue();
      if (paramBoolean) {
        this.knQ = true;
      }
    }
    if (paramContentValues.containsKey("authInfo")) {}
    try
    {
      arrayOfByte = paramContentValues.getAsByteArray("authInfo");
      if ((arrayOfByte != null) && (arrayOfByte.length > 0))
      {
        this.field_authInfo = ((FinderAuthInfo)new FinderAuthInfo().parseFrom(arrayOfByte));
        if (paramBoolean) {
          this.knR = true;
        }
      }
    }
    catch (IOException localIOException1)
    {
      for (;;)
      {
        byte[] arrayOfByte;
        Log.e("MicroMsg.SDK.BaseFinderContact", localIOException1.getMessage());
      }
    }
    if (paramContentValues.containsKey("extInfo")) {}
    try
    {
      arrayOfByte = paramContentValues.getAsByteArray("extInfo");
      if ((arrayOfByte != null) && (arrayOfByte.length > 0))
      {
        this.field_extInfo = ((avl)new avl().parseFrom(arrayOfByte));
        if (paramBoolean) {
          this.jSL = true;
        }
      }
    }
    catch (IOException localIOException2)
    {
      for (;;)
      {
        Log.e("MicroMsg.SDK.BaseFinderContact", localIOException2.getMessage());
      }
    }
    if (paramContentValues.containsKey("originalFlag"))
    {
      this.field_originalFlag = paramContentValues.getAsInteger("originalFlag").intValue();
      if (paramBoolean) {
        this.knS = true;
      }
    }
    if (paramContentValues.containsKey("originalInfo")) {}
    try
    {
      arrayOfByte = paramContentValues.getAsByteArray("originalInfo");
      if ((arrayOfByte != null) && (arrayOfByte.length > 0))
      {
        this.field_originalInfo = ((bry)new bry().parseFrom(arrayOfByte));
        if (paramBoolean) {
          this.knT = true;
        }
      }
    }
    catch (IOException localIOException3)
    {
      for (;;)
      {
        Log.e("MicroMsg.SDK.BaseFinderContact", localIOException3.getMessage());
      }
    }
    if (paramContentValues.containsKey("extFlag"))
    {
      this.field_extFlag = paramContentValues.getAsInteger("extFlag").intValue();
      if (paramBoolean) {
        this.kiy = true;
      }
    }
    if (paramContentValues.containsKey("updateTime"))
    {
      this.field_updateTime = paramContentValues.getAsLong("updateTime").longValue();
      if (paramBoolean) {
        this.__hadSetupdateTime = true;
      }
    }
    if (paramContentValues.containsKey("retryCount"))
    {
      this.field_retryCount = paramContentValues.getAsInteger("retryCount").intValue();
      if (paramBoolean) {
        this.knU = true;
      }
    }
    if (paramContentValues.containsKey("originalEntranceFlag"))
    {
      this.field_originalEntranceFlag = paramContentValues.getAsInteger("originalEntranceFlag").intValue();
      if (paramBoolean) {
        this.knV = true;
      }
    }
    if (paramContentValues.containsKey("liveCoverImg"))
    {
      this.field_liveCoverImg = paramContentValues.getAsString("liveCoverImg");
      if (paramBoolean) {
        this.knW = true;
      }
    }
    if (paramContentValues.containsKey("liveStatus"))
    {
      this.field_liveStatus = paramContentValues.getAsInteger("liveStatus").intValue();
      if (paramBoolean) {
        this.knX = true;
      }
    }
    if (paramContentValues.containsKey("liveAnchorStatusFlag"))
    {
      this.field_liveAnchorStatusFlag = paramContentValues.getAsLong("liveAnchorStatusFlag").longValue();
      if (paramBoolean) {
        this.knY = true;
      }
    }
    if (paramContentValues.containsKey("friendFollowCount"))
    {
      this.field_friendFollowCount = paramContentValues.getAsInteger("friendFollowCount").intValue();
      if (paramBoolean) {
        this.knZ = true;
      }
    }
    if (paramContentValues.containsKey("liveSwitchFlag"))
    {
      this.field_liveSwitchFlag = paramContentValues.getAsLong("liveSwitchFlag").longValue();
      if (paramBoolean) {
        this.koa = true;
      }
    }
    if (paramContentValues.containsKey("liveAlias"))
    {
      this.field_liveAlias = paramContentValues.getAsString("liveAlias");
      if (paramBoolean) {
        this.kob = true;
      }
    }
    if (paramContentValues.containsKey("rewardTotalAmountInWecoin"))
    {
      this.field_rewardTotalAmountInWecoin = paramContentValues.getAsLong("rewardTotalAmountInWecoin").longValue();
      if (paramBoolean) {
        this.koc = true;
      }
    }
    if (paramContentValues.containsKey("personalMsgUpdateTime"))
    {
      this.field_personalMsgUpdateTime = paramContentValues.getAsLong("personalMsgUpdateTime").longValue();
      if (paramBoolean) {
        this.kod = true;
      }
    }
    if (paramContentValues.containsKey("v5username"))
    {
      this.field_v5username = paramContentValues.getAsString("v5username");
      if (paramBoolean) {
        this.koe = true;
      }
    }
    if (paramContentValues.containsKey("vestNickname"))
    {
      this.field_vestNickname = paramContentValues.getAsString("vestNickname");
      if (paramBoolean) {
        this.kof = true;
      }
    }
    if (paramContentValues.containsKey("feedCount"))
    {
      this.field_feedCount = paramContentValues.getAsInteger("feedCount").intValue();
      if (paramBoolean) {
        this.kog = true;
      }
    }
    if (paramContentValues.containsKey("source"))
    {
      this.field_source = paramContentValues.getAsInteger("source").intValue();
      if (paramBoolean) {
        this.jMS = true;
      }
    }
    if (paramContentValues.containsKey("liveMicSetting"))
    {
      this.field_liveMicSetting = paramContentValues.getAsLong("liveMicSetting").longValue();
      if (paramBoolean) {
        this.koh = true;
      }
    }
    if (paramContentValues.containsKey("liveMicSettingSwitch"))
    {
      this.field_liveMicSettingSwitch = paramContentValues.getAsLong("liveMicSettingSwitch").longValue();
      if (paramBoolean) {
        this.koi = true;
      }
    }
    if (paramContentValues.containsKey("badgeInfoList")) {}
    try
    {
      arrayOfByte = paramContentValues.getAsByteArray("badgeInfoList");
      if ((arrayOfByte != null) && (arrayOfByte.length > 0))
      {
        this.field_badgeInfoList = ((bfm)new bfm().parseFrom(arrayOfByte));
        if (paramBoolean) {
          this.koj = true;
        }
      }
    }
    catch (IOException localIOException4)
    {
      for (;;)
      {
        Log.e("MicroMsg.SDK.BaseFinderContact", localIOException4.getMessage());
      }
    }
    if (paramContentValues.containsKey("settlementInfo")) {}
    try
    {
      arrayOfByte = paramContentValues.getAsByteArray("settlementInfo");
      if ((arrayOfByte != null) && (arrayOfByte.length > 0))
      {
        this.field_settlementInfo = ((fat)new fat().parseFrom(arrayOfByte));
        if (paramBoolean) {
          this.kok = true;
        }
      }
    }
    catch (IOException localIOException5)
    {
      for (;;)
      {
        Log.e("MicroMsg.SDK.BaseFinderContact", localIOException5.getMessage());
      }
    }
    if (paramContentValues.containsKey("agencyCollaborateInfo")) {}
    try
    {
      arrayOfByte = paramContentValues.getAsByteArray("agencyCollaborateInfo");
      if ((arrayOfByte != null) && (arrayOfByte.length > 0))
      {
        this.field_agencyCollaborateInfo = ((ei)new ei().parseFrom(arrayOfByte));
        if (paramBoolean) {
          this.kol = true;
        }
      }
    }
    catch (IOException localIOException6)
    {
      for (;;)
      {
        Log.e("MicroMsg.SDK.BaseFinderContact", localIOException6.getMessage());
      }
    }
    if (paramContentValues.containsKey("bindInfoList")) {}
    try
    {
      arrayOfByte = paramContentValues.getAsByteArray("bindInfoList");
      if ((arrayOfByte != null) && (arrayOfByte.length > 0))
      {
        this.field_bindInfoList = ((aud)new aud().parseFrom(arrayOfByte));
        if (paramBoolean) {
          this.kom = true;
        }
      }
    }
    catch (IOException localIOException7)
    {
      for (;;)
      {
        Log.e("MicroMsg.SDK.BaseFinderContact", localIOException7.getMessage());
      }
    }
    if (paramContentValues.containsKey("guestInfo")) {}
    try
    {
      arrayOfByte = paramContentValues.getAsByteArray("guestInfo");
      if ((arrayOfByte != null) && (arrayOfByte.length > 0))
      {
        this.field_guestInfo = ((bbl)new bbl().parseFrom(arrayOfByte));
        if (paramBoolean) {
          this.kon = true;
        }
      }
    }
    catch (IOException localIOException8)
    {
      for (;;)
      {
        Log.e("MicroMsg.SDK.BaseFinderContact", localIOException8.getMessage());
      }
    }
    if (paramContentValues.containsKey("user_mode"))
    {
      this.field_user_mode = paramContentValues.getAsInteger("user_mode").intValue();
      if (paramBoolean) {
        this.koo = true;
      }
    }
    if (paramContentValues.containsKey("coverUrl"))
    {
      this.field_coverUrl = paramContentValues.getAsString("coverUrl");
      if (paramBoolean) {
        this.kop = true;
      }
    }
    if (paramContentValues.containsKey("coverEntranceFlag"))
    {
      this.field_coverEntranceFlag = paramContentValues.getAsInteger("coverEntranceFlag").intValue();
      if (paramBoolean) {
        this.koq = true;
      }
    }
    if (paramContentValues.containsKey("user_flag"))
    {
      this.field_user_flag = paramContentValues.getAsInteger("user_flag").intValue();
      if (paramBoolean) {
        this.kor = true;
      }
    }
    if (paramContentValues.containsKey("rawNickname"))
    {
      this.field_rawNickname = paramContentValues.getAsString("rawNickname");
      if (paramBoolean) {
        this.kos = true;
      }
    }
    if (paramContentValues.containsKey("rawAvatarUrl"))
    {
      this.field_rawAvatarUrl = paramContentValues.getAsString("rawAvatarUrl");
      if (paramBoolean) {
        this.kot = true;
      }
    }
    if (paramContentValues.containsKey("jumpInfoList")) {}
    try
    {
      arrayOfByte = paramContentValues.getAsByteArray("jumpInfoList");
      if ((arrayOfByte != null) && (arrayOfByte.length > 0))
      {
        this.field_jumpInfoList = ((bcf)new bcf().parseFrom(arrayOfByte));
        if (paramBoolean) {
          this.kou = true;
        }
      }
    }
    catch (IOException localIOException9)
    {
      for (;;)
      {
        Log.e("MicroMsg.SDK.BaseFinderContact", localIOException9.getMessage());
      }
    }
    if (paramContentValues.containsKey("interactionCount"))
    {
      this.field_interactionCount = paramContentValues.getAsLong("interactionCount").longValue();
      if (paramBoolean) {
        this.kov = true;
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
    int j = arrayOfString.length;
    int i = 0;
    label20:
    int k;
    if (i < j)
    {
      k = arrayOfString[i].hashCode();
      if (username_HASHCODE != k) {
        break label65;
      }
      this.field_username = paramCursor.getString(i);
      this.__hadSetusername = true;
    }
    for (;;)
    {
      i += 1;
      break label20;
      break;
      label65:
      if (jTs == k) {
        this.field_nickname = paramCursor.getString(i);
      } else if (kow == k) {
        this.field_avatarUrl = paramCursor.getString(i);
      } else if (jMG == k) {
        this.field_version = paramCursor.getLong(i);
      } else if (kox == k) {
        this.field_firstPageMD5 = paramCursor.getString(i);
      } else if (jLl == k) {
        this.field_signature = paramCursor.getString(i);
      } else if (koy == k) {
        this.field_follow_Flag = paramCursor.getInt(i);
      } else if (jZI == k) {
        this.field_pyInitial = paramCursor.getString(i);
      } else if (koz == k) {
        this.field_followTime = paramCursor.getInt(i);
      } else if (koA == k) {
        this.field_coverImg = paramCursor.getString(i);
      } else if (koB == k) {
        this.field_spamStatus = paramCursor.getInt(i);
      } else if (koC == k) {
        try
        {
          byte[] arrayOfByte1 = paramCursor.getBlob(i);
          if ((arrayOfByte1 == null) || (arrayOfByte1.length <= 0)) {
            continue;
          }
          this.field_authInfo = ((FinderAuthInfo)new FinderAuthInfo().parseFrom(arrayOfByte1));
        }
        catch (IOException localIOException1)
        {
          Log.e("MicroMsg.SDK.BaseFinderContact", localIOException1.getMessage());
        }
      } else if (jSZ == k) {
        try
        {
          byte[] arrayOfByte2 = paramCursor.getBlob(i);
          if ((arrayOfByte2 == null) || (arrayOfByte2.length <= 0)) {
            continue;
          }
          this.field_extInfo = ((avl)new avl().parseFrom(arrayOfByte2));
        }
        catch (IOException localIOException2)
        {
          Log.e("MicroMsg.SDK.BaseFinderContact", localIOException2.getMessage());
        }
      } else if (koD == k) {
        this.field_originalFlag = paramCursor.getInt(i);
      } else if (koE == k) {
        try
        {
          byte[] arrayOfByte3 = paramCursor.getBlob(i);
          if ((arrayOfByte3 == null) || (arrayOfByte3.length <= 0)) {
            continue;
          }
          this.field_originalInfo = ((bry)new bry().parseFrom(arrayOfByte3));
        }
        catch (IOException localIOException3)
        {
          Log.e("MicroMsg.SDK.BaseFinderContact", localIOException3.getMessage());
        }
      } else if (kiD == k) {
        this.field_extFlag = paramCursor.getInt(i);
      } else if (updateTime_HASHCODE == k) {
        this.field_updateTime = paramCursor.getLong(i);
      } else if (koF == k) {
        this.field_retryCount = paramCursor.getInt(i);
      } else if (koG == k) {
        this.field_originalEntranceFlag = paramCursor.getInt(i);
      } else if (koH == k) {
        this.field_liveCoverImg = paramCursor.getString(i);
      } else if (koI == k) {
        this.field_liveStatus = paramCursor.getInt(i);
      } else if (koJ == k) {
        this.field_liveAnchorStatusFlag = paramCursor.getLong(i);
      } else if (koK == k) {
        this.field_friendFollowCount = paramCursor.getInt(i);
      } else if (koL == k) {
        this.field_liveSwitchFlag = paramCursor.getLong(i);
      } else if (koM == k) {
        this.field_liveAlias = paramCursor.getString(i);
      } else if (koN == k) {
        this.field_rewardTotalAmountInWecoin = paramCursor.getLong(i);
      } else if (koO == k) {
        this.field_personalMsgUpdateTime = paramCursor.getLong(i);
      } else if (koP == k) {
        this.field_v5username = paramCursor.getString(i);
      } else if (koQ == k) {
        this.field_vestNickname = paramCursor.getString(i);
      } else if (koR == k) {
        this.field_feedCount = paramCursor.getInt(i);
      } else if (jMX == k) {
        this.field_source = paramCursor.getInt(i);
      } else if (koS == k) {
        this.field_liveMicSetting = paramCursor.getLong(i);
      } else if (koT == k) {
        this.field_liveMicSettingSwitch = paramCursor.getLong(i);
      } else if (koU == k) {
        try
        {
          byte[] arrayOfByte4 = paramCursor.getBlob(i);
          if ((arrayOfByte4 == null) || (arrayOfByte4.length <= 0)) {
            continue;
          }
          this.field_badgeInfoList = ((bfm)new bfm().parseFrom(arrayOfByte4));
        }
        catch (IOException localIOException4)
        {
          Log.e("MicroMsg.SDK.BaseFinderContact", localIOException4.getMessage());
        }
      } else if (koV == k) {
        try
        {
          byte[] arrayOfByte5 = paramCursor.getBlob(i);
          if ((arrayOfByte5 == null) || (arrayOfByte5.length <= 0)) {
            continue;
          }
          this.field_settlementInfo = ((fat)new fat().parseFrom(arrayOfByte5));
        }
        catch (IOException localIOException5)
        {
          Log.e("MicroMsg.SDK.BaseFinderContact", localIOException5.getMessage());
        }
      } else if (koW == k) {
        try
        {
          byte[] arrayOfByte6 = paramCursor.getBlob(i);
          if ((arrayOfByte6 == null) || (arrayOfByte6.length <= 0)) {
            continue;
          }
          this.field_agencyCollaborateInfo = ((ei)new ei().parseFrom(arrayOfByte6));
        }
        catch (IOException localIOException6)
        {
          Log.e("MicroMsg.SDK.BaseFinderContact", localIOException6.getMessage());
        }
      } else if (koX == k) {
        try
        {
          byte[] arrayOfByte7 = paramCursor.getBlob(i);
          if ((arrayOfByte7 == null) || (arrayOfByte7.length <= 0)) {
            continue;
          }
          this.field_bindInfoList = ((aud)new aud().parseFrom(arrayOfByte7));
        }
        catch (IOException localIOException7)
        {
          Log.e("MicroMsg.SDK.BaseFinderContact", localIOException7.getMessage());
        }
      } else if (koY == k) {
        try
        {
          byte[] arrayOfByte8 = paramCursor.getBlob(i);
          if ((arrayOfByte8 == null) || (arrayOfByte8.length <= 0)) {
            continue;
          }
          this.field_guestInfo = ((bbl)new bbl().parseFrom(arrayOfByte8));
        }
        catch (IOException localIOException8)
        {
          Log.e("MicroMsg.SDK.BaseFinderContact", localIOException8.getMessage());
        }
      } else if (koZ == k) {
        this.field_user_mode = paramCursor.getInt(i);
      } else if (kpa == k) {
        this.field_coverUrl = paramCursor.getString(i);
      } else if (kpb == k) {
        this.field_coverEntranceFlag = paramCursor.getInt(i);
      } else if (kpc == k) {
        this.field_user_flag = paramCursor.getInt(i);
      } else if (kpd == k) {
        this.field_rawNickname = paramCursor.getString(i);
      } else if (kpe == k) {
        this.field_rawAvatarUrl = paramCursor.getString(i);
      } else if (kpf == k) {
        try
        {
          byte[] arrayOfByte9 = paramCursor.getBlob(i);
          if ((arrayOfByte9 == null) || (arrayOfByte9.length <= 0)) {
            continue;
          }
          this.field_jumpInfoList = ((bcf)new bcf().parseFrom(arrayOfByte9));
        }
        catch (IOException localIOException9)
        {
          Log.e("MicroMsg.SDK.BaseFinderContact", localIOException9.getMessage());
        }
      } else if (kpg == k) {
        this.field_interactionCount = paramCursor.getLong(i);
      } else if (rowid_HASHCODE == k) {
        this.systemRowid = paramCursor.getLong(i);
      }
    }
  }
  
  public ContentValues convertTo()
  {
    ContentValues localContentValues = new ContentValues();
    if (this.field_username == null) {
      this.field_username = "";
    }
    if (this.__hadSetusername) {
      localContentValues.put("username", this.field_username);
    }
    if (this.field_nickname == null) {
      this.field_nickname = "";
    }
    if (this.jTo) {
      localContentValues.put("nickname", this.field_nickname);
    }
    if (this.field_avatarUrl == null) {
      this.field_avatarUrl = "";
    }
    if (this.knL) {
      localContentValues.put("avatarUrl", this.field_avatarUrl);
    }
    if (this.jMB) {
      localContentValues.put("version", Long.valueOf(this.field_version));
    }
    if (this.field_firstPageMD5 == null) {
      this.field_firstPageMD5 = "";
    }
    if (this.knM) {
      localContentValues.put("firstPageMD5", this.field_firstPageMD5);
    }
    if (this.field_signature == null) {
      this.field_signature = "";
    }
    if (this.jKU) {
      localContentValues.put("signature", this.field_signature);
    }
    if (this.knN) {
      localContentValues.put("follow_Flag", Integer.valueOf(this.field_follow_Flag));
    }
    if (this.field_pyInitial == null) {
      this.field_pyInitial = "";
    }
    if (this.jZp) {
      localContentValues.put("pyInitial", this.field_pyInitial);
    }
    if (this.knO) {
      localContentValues.put("followTime", Integer.valueOf(this.field_followTime));
    }
    if (this.field_coverImg == null) {
      this.field_coverImg = "";
    }
    if (this.knP) {
      localContentValues.put("coverImg", this.field_coverImg);
    }
    if (this.knQ) {
      localContentValues.put("spamStatus", Integer.valueOf(this.field_spamStatus));
    }
    if ((this.knR) && (this.field_authInfo != null)) {}
    try
    {
      localContentValues.put("authInfo", this.field_authInfo.toByteArray());
      if ((!this.jSL) || (this.field_extInfo == null)) {}
    }
    catch (IOException localIOException8)
    {
      try
      {
        localContentValues.put("extInfo", this.field_extInfo.toByteArray());
        if (this.knS) {
          localContentValues.put("originalFlag", Integer.valueOf(this.field_originalFlag));
        }
        if ((!this.knT) || (this.field_originalInfo == null)) {}
      }
      catch (IOException localIOException8)
      {
        try
        {
          localContentValues.put("originalInfo", this.field_originalInfo.toByteArray());
          if (this.kiy) {
            localContentValues.put("extFlag", Integer.valueOf(this.field_extFlag));
          }
          if (this.__hadSetupdateTime) {
            localContentValues.put("updateTime", Long.valueOf(this.field_updateTime));
          }
          if (this.knU) {
            localContentValues.put("retryCount", Integer.valueOf(this.field_retryCount));
          }
          if (this.knV) {
            localContentValues.put("originalEntranceFlag", Integer.valueOf(this.field_originalEntranceFlag));
          }
          if (this.field_liveCoverImg == null) {
            this.field_liveCoverImg = "";
          }
          if (this.knW) {
            localContentValues.put("liveCoverImg", this.field_liveCoverImg);
          }
          if (this.knX) {
            localContentValues.put("liveStatus", Integer.valueOf(this.field_liveStatus));
          }
          if (this.knY) {
            localContentValues.put("liveAnchorStatusFlag", Long.valueOf(this.field_liveAnchorStatusFlag));
          }
          if (this.knZ) {
            localContentValues.put("friendFollowCount", Integer.valueOf(this.field_friendFollowCount));
          }
          if (this.koa) {
            localContentValues.put("liveSwitchFlag", Long.valueOf(this.field_liveSwitchFlag));
          }
          if (this.field_liveAlias == null) {
            this.field_liveAlias = "";
          }
          if (this.kob) {
            localContentValues.put("liveAlias", this.field_liveAlias);
          }
          if (this.koc) {
            localContentValues.put("rewardTotalAmountInWecoin", Long.valueOf(this.field_rewardTotalAmountInWecoin));
          }
          if (this.kod) {
            localContentValues.put("personalMsgUpdateTime", Long.valueOf(this.field_personalMsgUpdateTime));
          }
          if (this.field_v5username == null) {
            this.field_v5username = "";
          }
          if (this.koe) {
            localContentValues.put("v5username", this.field_v5username);
          }
          if (this.field_vestNickname == null) {
            this.field_vestNickname = "";
          }
          if (this.kof) {
            localContentValues.put("vestNickname", this.field_vestNickname);
          }
          if (this.kog) {
            localContentValues.put("feedCount", Integer.valueOf(this.field_feedCount));
          }
          if (this.jMS) {
            localContentValues.put("source", Integer.valueOf(this.field_source));
          }
          if (this.koh) {
            localContentValues.put("liveMicSetting", Long.valueOf(this.field_liveMicSetting));
          }
          if (this.koi) {
            localContentValues.put("liveMicSettingSwitch", Long.valueOf(this.field_liveMicSettingSwitch));
          }
          if ((!this.koj) || (this.field_badgeInfoList == null)) {}
        }
        catch (IOException localIOException8)
        {
          try
          {
            localContentValues.put("badgeInfoList", this.field_badgeInfoList.toByteArray());
            if ((!this.kok) || (this.field_settlementInfo == null)) {}
          }
          catch (IOException localIOException8)
          {
            try
            {
              localContentValues.put("settlementInfo", this.field_settlementInfo.toByteArray());
              if ((!this.kol) || (this.field_agencyCollaborateInfo == null)) {}
            }
            catch (IOException localIOException8)
            {
              try
              {
                localContentValues.put("agencyCollaborateInfo", this.field_agencyCollaborateInfo.toByteArray());
                if ((!this.kom) || (this.field_bindInfoList == null)) {}
              }
              catch (IOException localIOException8)
              {
                try
                {
                  localContentValues.put("bindInfoList", this.field_bindInfoList.toByteArray());
                  if ((!this.kon) || (this.field_guestInfo == null)) {}
                }
                catch (IOException localIOException8)
                {
                  try
                  {
                    localContentValues.put("guestInfo", this.field_guestInfo.toByteArray());
                    if (this.koo) {
                      localContentValues.put("user_mode", Integer.valueOf(this.field_user_mode));
                    }
                    if (this.field_coverUrl == null) {
                      this.field_coverUrl = "";
                    }
                    if (this.kop) {
                      localContentValues.put("coverUrl", this.field_coverUrl);
                    }
                    if (this.koq) {
                      localContentValues.put("coverEntranceFlag", Integer.valueOf(this.field_coverEntranceFlag));
                    }
                    if (this.kor) {
                      localContentValues.put("user_flag", Integer.valueOf(this.field_user_flag));
                    }
                    if (this.field_rawNickname == null) {
                      this.field_rawNickname = "";
                    }
                    if (this.kos) {
                      localContentValues.put("rawNickname", this.field_rawNickname);
                    }
                    if (this.field_rawAvatarUrl == null) {
                      this.field_rawAvatarUrl = "";
                    }
                    if (this.kot) {
                      localContentValues.put("rawAvatarUrl", this.field_rawAvatarUrl);
                    }
                    if ((!this.kou) || (this.field_jumpInfoList == null)) {}
                  }
                  catch (IOException localIOException8)
                  {
                    try
                    {
                      for (;;)
                      {
                        localContentValues.put("jumpInfoList", this.field_jumpInfoList.toByteArray());
                        if (this.kov) {
                          localContentValues.put("interactionCount", Long.valueOf(this.field_interactionCount));
                        }
                        if (this.systemRowid > 0L) {
                          localContentValues.put("rowid", Long.valueOf(this.systemRowid));
                        }
                        return localContentValues;
                        localIOException1 = localIOException1;
                        Log.e("MicroMsg.SDK.BaseFinderContact", localIOException1.getMessage());
                        continue;
                        localIOException2 = localIOException2;
                        Log.e("MicroMsg.SDK.BaseFinderContact", localIOException2.getMessage());
                        continue;
                        localIOException3 = localIOException3;
                        Log.e("MicroMsg.SDK.BaseFinderContact", localIOException3.getMessage());
                        continue;
                        localIOException4 = localIOException4;
                        Log.e("MicroMsg.SDK.BaseFinderContact", localIOException4.getMessage());
                        continue;
                        localIOException5 = localIOException5;
                        Log.e("MicroMsg.SDK.BaseFinderContact", localIOException5.getMessage());
                        continue;
                        localIOException6 = localIOException6;
                        Log.e("MicroMsg.SDK.BaseFinderContact", localIOException6.getMessage());
                        continue;
                        localIOException7 = localIOException7;
                        Log.e("MicroMsg.SDK.BaseFinderContact", localIOException7.getMessage());
                      }
                      localIOException8 = localIOException8;
                      Log.e("MicroMsg.SDK.BaseFinderContact", localIOException8.getMessage());
                    }
                    catch (IOException localIOException9)
                    {
                      for (;;)
                      {
                        Log.e("MicroMsg.SDK.BaseFinderContact", localIOException9.getMessage());
                      }
                    }
                  }
                }
              }
            }
          }
        }
      }
    }
  }
  
  public IAutoDBItem.MAutoDBInfo getDBInfo()
  {
    return DB_INFO;
  }
  
  public String[] getIndexCreateSQL()
  {
    return INDEX_CREATE;
  }
  
  public StorageObserverOwner<? extends cj> getObserverOwner()
  {
    return observerOwner;
  }
  
  public Object getPrimaryKeyValue()
  {
    return this.field_username;
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
 * Qualified Name:     com.tencent.mm.autogen.b.cj
 * JD-Core Version:    0.7.0.1
 */