package com.tencent.mm.f.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.protocal.protobuf.FinderAuthInfo;
import com.tencent.mm.protocal.protobuf.ard;
import com.tencent.mm.protocal.protobuf.aym;
import com.tencent.mm.protocal.protobuf.bgi;
import com.tencent.mm.protocal.protobuf.dt;
import com.tencent.mm.protocal.protobuf.egt;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.storage.IAutoDBItem;
import com.tencent.mm.sdk.storage.IAutoDBItem.MAutoDBInfo;
import com.tencent.mm.sdk.storage.sql.Column;
import com.tencent.mm.sdk.storage.sql.SingleTable;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.Map;

public abstract class cf
  extends IAutoDBItem
{
  public static final Column C_ROWID;
  public static final Column C_UPDATETIME;
  public static final Column C_USERNAME;
  public static final String[] INDEX_CREATE = { "CREATE INDEX IF NOT EXISTS FinderContact_username_index ON FinderContact(username)" };
  public static final SingleTable TABLE = new SingleTable("FinderContact");
  private static final int hCM;
  public static final Column hCa;
  public static final Column hLp;
  private static final int hLy;
  public static final Column hPQ;
  public static final Column hPR;
  public static final Column hPS;
  public static final Column hPT;
  public static final Column hPU;
  public static final Column hPV;
  public static final Column hPW;
  public static final Column hPX;
  public static final Column hPY;
  public static final Column hPZ;
  private static final int hQS;
  private static final int hQT;
  private static final int hQU;
  private static final int hQV;
  private static final int hQW;
  private static final int hQX;
  private static final int hQY;
  private static final int hQZ;
  public static final Column hQa;
  public static final Column hQb;
  public static final Column hQc;
  public static final Column hQd;
  public static final Column hQe;
  public static final Column hQf;
  public static final Column hQg;
  public static final Column hQh;
  public static final Column hQi;
  public static final Column hQj;
  public static final Column hQk;
  public static final Column hQl;
  public static final Column hQm;
  public static final Column hQn;
  public static final Column hQo;
  public static final Column hQp;
  public static final Column hQq;
  private static final int hRa;
  private static final int hRb;
  private static final int hRc;
  private static final int hRd;
  private static final int hRe;
  private static final int hRf;
  private static final int hRg;
  private static final int hRh;
  private static final int hRi;
  private static final int hRj;
  private static final int hRk;
  private static final int hRl;
  private static final int hRm;
  private static final int hRn;
  private static final int hRo = "liveMicSetting".hashCode();
  private static final int hRp = "liveMicSettingSwitch".hashCode();
  private static final int hRq = "badgeInfoList".hashCode();
  private static final int hRr = "settlementInfo".hashCode();
  private static final int hRs = "agencyCollaborateInfo".hashCode();
  public static final Column hnN;
  private static final int hov;
  public static final Column hpJ;
  private static final int hpT;
  public static final Column hqa;
  private static final int hqk;
  public static final Column hvK;
  private static final int hwF;
  private static final int hwm;
  public static final Column hwx;
  private static final int rowid_HASHCODE = "rowid".hashCode();
  private static final int updateTime_HASHCODE;
  private static final int username_HASHCODE;
  private boolean __hadSetupdateTime = true;
  private boolean __hadSetusername = true;
  public dt field_agencyCollaborateInfo;
  public FinderAuthInfo field_authInfo;
  public String field_avatarUrl;
  public aym field_badgeInfoList;
  public String field_coverImg;
  public int field_extFlag;
  public ard field_extInfo;
  public int field_feedCount;
  public String field_firstPageMD5;
  public int field_followTime;
  public int field_follow_Flag;
  public int field_friendFollowCount;
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
  public bgi field_originalInfo;
  public long field_personalMsgUpdateTime;
  public String field_pyInitial;
  public int field_retryCount;
  public long field_rewardTotalAmountInWecoin;
  public egt field_settlementInfo;
  public String field_signature;
  public int field_source;
  public int field_spamStatus;
  public long field_updateTime;
  public String field_username;
  public String field_v5username;
  public long field_version;
  public String field_vestNickname;
  private boolean hCt = true;
  private boolean hLt = true;
  private boolean hQA = true;
  private boolean hQB = true;
  private boolean hQC = true;
  private boolean hQD = true;
  private boolean hQE = true;
  private boolean hQF = true;
  private boolean hQG = true;
  private boolean hQH = true;
  private boolean hQI = true;
  private boolean hQJ = true;
  private boolean hQK = true;
  private boolean hQL = true;
  private boolean hQM = true;
  private boolean hQN = true;
  private boolean hQO = true;
  private boolean hQP = true;
  private boolean hQQ = true;
  private boolean hQR = true;
  private boolean hQr = true;
  private boolean hQs = true;
  private boolean hQt = true;
  private boolean hQu = true;
  private boolean hQv = true;
  private boolean hQw = true;
  private boolean hQx = true;
  private boolean hQy = true;
  private boolean hQz = true;
  private boolean hoe = true;
  private boolean hpO = true;
  private boolean hqf = true;
  private boolean hvY = true;
  private boolean hwB = true;
  
  static
  {
    C_ROWID = new Column("rowid", "long", "FinderContact", "");
    C_USERNAME = new Column("username", "string", "FinderContact", "");
    hwx = new Column("nickname", "string", "FinderContact", "");
    hPQ = new Column("avatarurl", "string", "FinderContact", "");
    hpJ = new Column("version", "long", "FinderContact", "");
    hPR = new Column("firstpagemd5", "string", "FinderContact", "");
    hnN = new Column("signature", "string", "FinderContact", "");
    hPS = new Column("follow_flag", "int", "FinderContact", "");
    hCa = new Column("pyinitial", "string", "FinderContact", "");
    hPT = new Column("followtime", "int", "FinderContact", "");
    hPU = new Column("coverimg", "string", "FinderContact", "");
    hPV = new Column("spamstatus", "int", "FinderContact", "");
    hPW = new Column("authinfo", "proto", "FinderContact", "com.tencent.mm.protocal.protobuf.FinderAuthInfo");
    hvK = new Column("extinfo", "proto", "FinderContact", "com.tencent.mm.protocal.protobuf.FinderContactExtraInfo");
    hPX = new Column("originalflag", "int", "FinderContact", "");
    hPY = new Column("originalinfo", "proto", "FinderContact", "com.tencent.mm.protocal.protobuf.FinderOriginalInfo");
    hLp = new Column("extflag", "int", "FinderContact", "");
    C_UPDATETIME = new Column("updatetime", "long", "FinderContact", "");
    hPZ = new Column("retrycount", "int", "FinderContact", "");
    hQa = new Column("originalentranceflag", "int", "FinderContact", "");
    hQb = new Column("livecoverimg", "string", "FinderContact", "");
    hQc = new Column("livestatus", "int", "FinderContact", "");
    hQd = new Column("liveanchorstatusflag", "long", "FinderContact", "");
    hQe = new Column("friendfollowcount", "int", "FinderContact", "");
    hQf = new Column("liveswitchflag", "long", "FinderContact", "");
    hQg = new Column("livealias", "string", "FinderContact", "");
    hQh = new Column("rewardtotalamountinwecoin", "long", "FinderContact", "");
    hQi = new Column("personalmsgupdatetime", "long", "FinderContact", "");
    hQj = new Column("v5username", "string", "FinderContact", "");
    hQk = new Column("vestnickname", "string", "FinderContact", "");
    hQl = new Column("feedcount", "int", "FinderContact", "");
    hqa = new Column("source", "int", "FinderContact", "");
    hQm = new Column("livemicsetting", "long", "FinderContact", "");
    hQn = new Column("livemicsettingswitch", "long", "FinderContact", "");
    hQo = new Column("badgeinfolist", "proto", "FinderContact", "com.tencent.mm.protocal.protobuf.FinderLiveBadgeInfoList");
    hQp = new Column("settlementinfo", "proto", "FinderContact", "com.tencent.mm.protocal.protobuf.SettleToAgencyRelateInfo");
    hQq = new Column("agencycollaborateinfo", "proto", "FinderContact", "com.tencent.mm.protocal.protobuf.AgencyCollaborateInfo");
    username_HASHCODE = "username".hashCode();
    hwF = "nickname".hashCode();
    hQS = "avatarUrl".hashCode();
    hpT = "version".hashCode();
    hQT = "firstPageMD5".hashCode();
    hov = "signature".hashCode();
    hQU = "follow_Flag".hashCode();
    hCM = "pyInitial".hashCode();
    hQV = "followTime".hashCode();
    hQW = "coverImg".hashCode();
    hQX = "spamStatus".hashCode();
    hQY = "authInfo".hashCode();
    hwm = "extInfo".hashCode();
    hQZ = "originalFlag".hashCode();
    hRa = "originalInfo".hashCode();
    hLy = "extFlag".hashCode();
    updateTime_HASHCODE = "updateTime".hashCode();
    hRb = "retryCount".hashCode();
    hRc = "originalEntranceFlag".hashCode();
    hRd = "liveCoverImg".hashCode();
    hRe = "liveStatus".hashCode();
    hRf = "liveAnchorStatusFlag".hashCode();
    hRg = "friendFollowCount".hashCode();
    hRh = "liveSwitchFlag".hashCode();
    hRi = "liveAlias".hashCode();
    hRj = "rewardTotalAmountInWecoin".hashCode();
    hRk = "personalMsgUpdateTime".hashCode();
    hRl = "v5username".hashCode();
    hRm = "vestNickname".hashCode();
    hRn = "feedCount".hashCode();
    hqk = "source".hashCode();
  }
  
  public static IAutoDBItem.MAutoDBInfo aoY()
  {
    IAutoDBItem.MAutoDBInfo localMAutoDBInfo = new IAutoDBItem.MAutoDBInfo();
    localMAutoDBInfo.fields = new Field[36];
    localMAutoDBInfo.columns = new String[37];
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
    localMAutoDBInfo.columns[36] = "rowid";
    localMAutoDBInfo.sql = localStringBuilder.toString();
    return localMAutoDBInfo;
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
      if (hwF == k) {
        this.field_nickname = paramCursor.getString(i);
      } else if (hQS == k) {
        this.field_avatarUrl = paramCursor.getString(i);
      } else if (hpT == k) {
        this.field_version = paramCursor.getLong(i);
      } else if (hQT == k) {
        this.field_firstPageMD5 = paramCursor.getString(i);
      } else if (hov == k) {
        this.field_signature = paramCursor.getString(i);
      } else if (hQU == k) {
        this.field_follow_Flag = paramCursor.getInt(i);
      } else if (hCM == k) {
        this.field_pyInitial = paramCursor.getString(i);
      } else if (hQV == k) {
        this.field_followTime = paramCursor.getInt(i);
      } else if (hQW == k) {
        this.field_coverImg = paramCursor.getString(i);
      } else if (hQX == k) {
        this.field_spamStatus = paramCursor.getInt(i);
      } else if (hQY == k) {
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
      } else if (hwm == k) {
        try
        {
          byte[] arrayOfByte2 = paramCursor.getBlob(i);
          if ((arrayOfByte2 == null) || (arrayOfByte2.length <= 0)) {
            continue;
          }
          this.field_extInfo = ((ard)new ard().parseFrom(arrayOfByte2));
        }
        catch (IOException localIOException2)
        {
          Log.e("MicroMsg.SDK.BaseFinderContact", localIOException2.getMessage());
        }
      } else if (hQZ == k) {
        this.field_originalFlag = paramCursor.getInt(i);
      } else if (hRa == k) {
        try
        {
          byte[] arrayOfByte3 = paramCursor.getBlob(i);
          if ((arrayOfByte3 == null) || (arrayOfByte3.length <= 0)) {
            continue;
          }
          this.field_originalInfo = ((bgi)new bgi().parseFrom(arrayOfByte3));
        }
        catch (IOException localIOException3)
        {
          Log.e("MicroMsg.SDK.BaseFinderContact", localIOException3.getMessage());
        }
      } else if (hLy == k) {
        this.field_extFlag = paramCursor.getInt(i);
      } else if (updateTime_HASHCODE == k) {
        this.field_updateTime = paramCursor.getLong(i);
      } else if (hRb == k) {
        this.field_retryCount = paramCursor.getInt(i);
      } else if (hRc == k) {
        this.field_originalEntranceFlag = paramCursor.getInt(i);
      } else if (hRd == k) {
        this.field_liveCoverImg = paramCursor.getString(i);
      } else if (hRe == k) {
        this.field_liveStatus = paramCursor.getInt(i);
      } else if (hRf == k) {
        this.field_liveAnchorStatusFlag = paramCursor.getLong(i);
      } else if (hRg == k) {
        this.field_friendFollowCount = paramCursor.getInt(i);
      } else if (hRh == k) {
        this.field_liveSwitchFlag = paramCursor.getLong(i);
      } else if (hRi == k) {
        this.field_liveAlias = paramCursor.getString(i);
      } else if (hRj == k) {
        this.field_rewardTotalAmountInWecoin = paramCursor.getLong(i);
      } else if (hRk == k) {
        this.field_personalMsgUpdateTime = paramCursor.getLong(i);
      } else if (hRl == k) {
        this.field_v5username = paramCursor.getString(i);
      } else if (hRm == k) {
        this.field_vestNickname = paramCursor.getString(i);
      } else if (hRn == k) {
        this.field_feedCount = paramCursor.getInt(i);
      } else if (hqk == k) {
        this.field_source = paramCursor.getInt(i);
      } else if (hRo == k) {
        this.field_liveMicSetting = paramCursor.getLong(i);
      } else if (hRp == k) {
        this.field_liveMicSettingSwitch = paramCursor.getLong(i);
      } else if (hRq == k) {
        try
        {
          byte[] arrayOfByte4 = paramCursor.getBlob(i);
          if ((arrayOfByte4 == null) || (arrayOfByte4.length <= 0)) {
            continue;
          }
          this.field_badgeInfoList = ((aym)new aym().parseFrom(arrayOfByte4));
        }
        catch (IOException localIOException4)
        {
          Log.e("MicroMsg.SDK.BaseFinderContact", localIOException4.getMessage());
        }
      } else if (hRr == k) {
        try
        {
          byte[] arrayOfByte5 = paramCursor.getBlob(i);
          if ((arrayOfByte5 == null) || (arrayOfByte5.length <= 0)) {
            continue;
          }
          this.field_settlementInfo = ((egt)new egt().parseFrom(arrayOfByte5));
        }
        catch (IOException localIOException5)
        {
          Log.e("MicroMsg.SDK.BaseFinderContact", localIOException5.getMessage());
        }
      } else if (hRs == k) {
        try
        {
          byte[] arrayOfByte6 = paramCursor.getBlob(i);
          if ((arrayOfByte6 == null) || (arrayOfByte6.length <= 0)) {
            continue;
          }
          this.field_agencyCollaborateInfo = ((dt)new dt().parseFrom(arrayOfByte6));
        }
        catch (IOException localIOException6)
        {
          Log.e("MicroMsg.SDK.BaseFinderContact", localIOException6.getMessage());
        }
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
    if (this.hwB) {
      localContentValues.put("nickname", this.field_nickname);
    }
    if (this.field_avatarUrl == null) {
      this.field_avatarUrl = "";
    }
    if (this.hQr) {
      localContentValues.put("avatarUrl", this.field_avatarUrl);
    }
    if (this.hpO) {
      localContentValues.put("version", Long.valueOf(this.field_version));
    }
    if (this.field_firstPageMD5 == null) {
      this.field_firstPageMD5 = "";
    }
    if (this.hQs) {
      localContentValues.put("firstPageMD5", this.field_firstPageMD5);
    }
    if (this.field_signature == null) {
      this.field_signature = "";
    }
    if (this.hoe) {
      localContentValues.put("signature", this.field_signature);
    }
    if (this.hQt) {
      localContentValues.put("follow_Flag", Integer.valueOf(this.field_follow_Flag));
    }
    if (this.field_pyInitial == null) {
      this.field_pyInitial = "";
    }
    if (this.hCt) {
      localContentValues.put("pyInitial", this.field_pyInitial);
    }
    if (this.hQu) {
      localContentValues.put("followTime", Integer.valueOf(this.field_followTime));
    }
    if (this.field_coverImg == null) {
      this.field_coverImg = "";
    }
    if (this.hQv) {
      localContentValues.put("coverImg", this.field_coverImg);
    }
    if (this.hQw) {
      localContentValues.put("spamStatus", Integer.valueOf(this.field_spamStatus));
    }
    if ((this.hQx) && (this.field_authInfo != null)) {}
    try
    {
      localContentValues.put("authInfo", this.field_authInfo.toByteArray());
      if ((!this.hvY) || (this.field_extInfo == null)) {}
    }
    catch (IOException localIOException5)
    {
      try
      {
        localContentValues.put("extInfo", this.field_extInfo.toByteArray());
        if (this.hQy) {
          localContentValues.put("originalFlag", Integer.valueOf(this.field_originalFlag));
        }
        if ((!this.hQz) || (this.field_originalInfo == null)) {}
      }
      catch (IOException localIOException5)
      {
        try
        {
          localContentValues.put("originalInfo", this.field_originalInfo.toByteArray());
          if (this.hLt) {
            localContentValues.put("extFlag", Integer.valueOf(this.field_extFlag));
          }
          if (this.__hadSetupdateTime) {
            localContentValues.put("updateTime", Long.valueOf(this.field_updateTime));
          }
          if (this.hQA) {
            localContentValues.put("retryCount", Integer.valueOf(this.field_retryCount));
          }
          if (this.hQB) {
            localContentValues.put("originalEntranceFlag", Integer.valueOf(this.field_originalEntranceFlag));
          }
          if (this.field_liveCoverImg == null) {
            this.field_liveCoverImg = "";
          }
          if (this.hQC) {
            localContentValues.put("liveCoverImg", this.field_liveCoverImg);
          }
          if (this.hQD) {
            localContentValues.put("liveStatus", Integer.valueOf(this.field_liveStatus));
          }
          if (this.hQE) {
            localContentValues.put("liveAnchorStatusFlag", Long.valueOf(this.field_liveAnchorStatusFlag));
          }
          if (this.hQF) {
            localContentValues.put("friendFollowCount", Integer.valueOf(this.field_friendFollowCount));
          }
          if (this.hQG) {
            localContentValues.put("liveSwitchFlag", Long.valueOf(this.field_liveSwitchFlag));
          }
          if (this.field_liveAlias == null) {
            this.field_liveAlias = "";
          }
          if (this.hQH) {
            localContentValues.put("liveAlias", this.field_liveAlias);
          }
          if (this.hQI) {
            localContentValues.put("rewardTotalAmountInWecoin", Long.valueOf(this.field_rewardTotalAmountInWecoin));
          }
          if (this.hQJ) {
            localContentValues.put("personalMsgUpdateTime", Long.valueOf(this.field_personalMsgUpdateTime));
          }
          if (this.field_v5username == null) {
            this.field_v5username = "";
          }
          if (this.hQK) {
            localContentValues.put("v5username", this.field_v5username);
          }
          if (this.field_vestNickname == null) {
            this.field_vestNickname = "";
          }
          if (this.hQL) {
            localContentValues.put("vestNickname", this.field_vestNickname);
          }
          if (this.hQM) {
            localContentValues.put("feedCount", Integer.valueOf(this.field_feedCount));
          }
          if (this.hqf) {
            localContentValues.put("source", Integer.valueOf(this.field_source));
          }
          if (this.hQN) {
            localContentValues.put("liveMicSetting", Long.valueOf(this.field_liveMicSetting));
          }
          if (this.hQO) {
            localContentValues.put("liveMicSettingSwitch", Long.valueOf(this.field_liveMicSettingSwitch));
          }
          if ((!this.hQP) || (this.field_badgeInfoList == null)) {}
        }
        catch (IOException localIOException5)
        {
          try
          {
            localContentValues.put("badgeInfoList", this.field_badgeInfoList.toByteArray());
            if ((!this.hQQ) || (this.field_settlementInfo == null)) {}
          }
          catch (IOException localIOException5)
          {
            try
            {
              localContentValues.put("settlementInfo", this.field_settlementInfo.toByteArray());
              if ((!this.hQR) || (this.field_agencyCollaborateInfo == null)) {}
            }
            catch (IOException localIOException5)
            {
              try
              {
                for (;;)
                {
                  localContentValues.put("agencyCollaborateInfo", this.field_agencyCollaborateInfo.toByteArray());
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
                }
                localIOException5 = localIOException5;
                Log.e("MicroMsg.SDK.BaseFinderContact", localIOException5.getMessage());
              }
              catch (IOException localIOException6)
              {
                for (;;)
                {
                  Log.e("MicroMsg.SDK.BaseFinderContact", localIOException6.getMessage());
                }
              }
            }
          }
        }
      }
    }
  }
  
  public String[] getIndexCreateSQL()
  {
    return INDEX_CREATE;
  }
  
  public String getTableName()
  {
    return "FinderContact";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.f.c.cf
 * JD-Core Version:    0.7.0.1
 */