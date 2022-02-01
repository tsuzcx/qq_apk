package com.tencent.mm.autogen.b;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.platformtools.LVBuffer;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.storage.IAutoDBItem;
import com.tencent.mm.sdk.storage.IAutoDBItem.MAutoDBInfo;
import com.tencent.mm.sdk.storage.sql.Column;
import com.tencent.mm.sdk.storage.sql.SingleTable;
import java.lang.reflect.Field;
import java.util.Map;

public abstract class az
  extends IAutoDBItem
{
  public static final IAutoDBItem.MAutoDBInfo DB_INFO = aJm();
  public static final String[] INDEX_CREATE;
  public static final Column ROWID;
  public static final SingleTable TABLE = new SingleTable("rcontact");
  public static final Column TYPE;
  public static final Column USERNAME;
  public static final Column jJA;
  private static final int jJE;
  public static final Column jNq;
  private static final int jOi;
  public static final Column jTk;
  private static final int jTs;
  public static final Column jYT;
  public static final Column jYU;
  public static final Column jYV;
  public static final Column jYW;
  public static final Column jYX;
  public static final Column jYY;
  public static final Column jYZ;
  private static final int jZF;
  private static final int jZG;
  private static final int jZH;
  private static final int jZI;
  private static final int jZJ;
  private static final int jZK;
  private static final int jZL;
  private static final int jZM;
  private static final int jZN;
  private static final int jZO;
  private static final int jZP;
  private static final int jZQ;
  private static final int jZR;
  private static final int jZS;
  private static final int jZT;
  private static final int jZU;
  private static final int jZV;
  private static final int jZW;
  private static final int jZX;
  public static final Column jZa;
  public static final Column jZb;
  public static final Column jZc;
  public static final Column jZd;
  public static final Column jZe;
  public static final Column jZf;
  public static final Column jZg;
  public static final Column jZh;
  public static final Column jZi;
  public static final Column jZj;
  public static final Column jZk;
  public static final Column jZl;
  private static final int rowid_HASHCODE;
  private static final int type_HASHCODE;
  private static final int username_HASHCODE;
  private boolean __hadSettype = false;
  private boolean __hadSetusername = false;
  private String city;
  public int extFlag;
  private String field_alias;
  private int field_chatroomFlag;
  public String field_conRemark;
  public String field_conRemarkPYFull;
  public String field_conRemarkPYShort;
  public String field_contactLabelIds;
  public int field_deleteFlag;
  public String field_descWordingId;
  public String field_domainList;
  public String field_encryptUsername;
  private byte[] field_lvbuff;
  public String field_nickname;
  public String field_openImAppid;
  private String field_pyInitial;
  private String field_quanPin;
  public int field_showHead;
  public String field_sourceExtInfo;
  public String field_ticket;
  public int field_type;
  public String field_username;
  public long field_usernameFlag;
  public int field_verifyFlag;
  public int field_weiboFlag;
  public String field_weiboNickname;
  public int fromType;
  public String hRk;
  public int hyY;
  private boolean jJC = false;
  private boolean jNM = false;
  private boolean jTo = false;
  private boolean jZA = false;
  private boolean jZB = false;
  private boolean jZC = false;
  private boolean jZD = false;
  private boolean jZE = false;
  public int jZY;
  public String jZZ;
  private boolean jZm = false;
  private boolean jZn = false;
  private boolean jZo = false;
  private boolean jZp = false;
  private boolean jZq = false;
  private boolean jZr = false;
  private boolean jZs = false;
  private boolean jZt = false;
  private boolean jZu = false;
  private boolean jZv = false;
  private boolean jZw = false;
  private boolean jZx = false;
  private boolean jZy = false;
  private boolean jZz = false;
  private long kaa;
  private String kab;
  public int kac;
  private String kad;
  private String kae;
  public int kaf;
  public int kag;
  public String kah;
  public String kai;
  public String kaj;
  public int kak;
  public String kal;
  public String kam;
  public String kan;
  public String kao;
  public String kap;
  public String kaq;
  public String kar;
  public String kas;
  private String kat;
  public int kau;
  public String kav;
  public int kaw;
  public long kax;
  public long kay;
  private String province;
  public int sex;
  private int showFlag;
  public String signature;
  private int source;
  public int uin;
  public String verifyInfo;
  
  static
  {
    ROWID = new Column("rowid", "long", TABLE.getName(), "");
    USERNAME = new Column("username", "string", TABLE.getName(), "");
    jYT = new Column("alias", "string", TABLE.getName(), "");
    jYU = new Column("conRemark", "string", TABLE.getName(), "");
    jYV = new Column("domainList", "string", TABLE.getName(), "");
    jTk = new Column("nickname", "string", TABLE.getName(), "");
    jYW = new Column("pyInitial", "string", TABLE.getName(), "");
    jYX = new Column("quanPin", "string", TABLE.getName(), "");
    jYY = new Column("showHead", "int", TABLE.getName(), "");
    TYPE = new Column("type", "int", TABLE.getName(), "");
    jYZ = new Column("weiboFlag", "int", TABLE.getName(), "");
    jZa = new Column("weiboNickname", "string", TABLE.getName(), "");
    jZb = new Column("conRemarkPYFull", "string", TABLE.getName(), "");
    jZc = new Column("conRemarkPYShort", "string", TABLE.getName(), "");
    jNq = new Column("lvbuff", "byte[]", TABLE.getName(), "");
    jZd = new Column("verifyFlag", "int", TABLE.getName(), "");
    jZe = new Column("encryptUsername", "string", TABLE.getName(), "");
    jZf = new Column("chatroomFlag", "int", TABLE.getName(), "");
    jZg = new Column("deleteFlag", "int", TABLE.getName(), "");
    jZh = new Column("contactLabelIds", "string", TABLE.getName(), "");
    jZi = new Column("descWordingId", "string", TABLE.getName(), "");
    jZj = new Column("openImAppid", "string", TABLE.getName(), "");
    jZk = new Column("sourceExtInfo", "string", TABLE.getName(), "");
    jJA = new Column("ticket", "string", TABLE.getName(), "");
    jZl = new Column("usernameFlag", "long", TABLE.getName(), "");
    INDEX_CREATE = new String[] { "CREATE INDEX IF NOT EXISTS deleteflag_index ON rcontact(deleteFlag)" };
    username_HASHCODE = "username".hashCode();
    jZF = "alias".hashCode();
    jZG = "conRemark".hashCode();
    jZH = "domainList".hashCode();
    jTs = "nickname".hashCode();
    jZI = "pyInitial".hashCode();
    jZJ = "quanPin".hashCode();
    jZK = "showHead".hashCode();
    type_HASHCODE = "type".hashCode();
    jZL = "weiboFlag".hashCode();
    jZM = "weiboNickname".hashCode();
    jZN = "conRemarkPYFull".hashCode();
    jZO = "conRemarkPYShort".hashCode();
    jOi = "lvbuff".hashCode();
    jZP = "verifyFlag".hashCode();
    jZQ = "encryptUsername".hashCode();
    jZR = "chatroomFlag".hashCode();
    jZS = "deleteFlag".hashCode();
    jZT = "contactLabelIds".hashCode();
    jZU = "descWordingId".hashCode();
    jZV = "openImAppid".hashCode();
    jZW = "sourceExtInfo".hashCode();
    jJE = "ticket".hashCode();
    jZX = "usernameFlag".hashCode();
    rowid_HASHCODE = "rowid".hashCode();
  }
  
  public static IAutoDBItem.MAutoDBInfo aJm()
  {
    IAutoDBItem.MAutoDBInfo localMAutoDBInfo = new IAutoDBItem.MAutoDBInfo();
    localMAutoDBInfo.fields = new Field[24];
    localMAutoDBInfo.columns = new String[25];
    StringBuilder localStringBuilder = new StringBuilder();
    localMAutoDBInfo.columns[0] = "username";
    localMAutoDBInfo.colsMap.put("username", "TEXT default ''  PRIMARY KEY ");
    localStringBuilder.append(" username TEXT default ''  PRIMARY KEY ");
    localStringBuilder.append(", ");
    localMAutoDBInfo.primaryKey = "username";
    localMAutoDBInfo.columns[1] = "alias";
    localMAutoDBInfo.colsMap.put("alias", "TEXT default '' ");
    localStringBuilder.append(" alias TEXT default '' ");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[2] = "conRemark";
    localMAutoDBInfo.colsMap.put("conRemark", "TEXT default '' ");
    localStringBuilder.append(" conRemark TEXT default '' ");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[3] = "domainList";
    localMAutoDBInfo.colsMap.put("domainList", "TEXT default '' ");
    localStringBuilder.append(" domainList TEXT default '' ");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[4] = "nickname";
    localMAutoDBInfo.colsMap.put("nickname", "TEXT default '' ");
    localStringBuilder.append(" nickname TEXT default '' ");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[5] = "pyInitial";
    localMAutoDBInfo.colsMap.put("pyInitial", "TEXT default '' ");
    localStringBuilder.append(" pyInitial TEXT default '' ");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[6] = "quanPin";
    localMAutoDBInfo.colsMap.put("quanPin", "TEXT default '' ");
    localStringBuilder.append(" quanPin TEXT default '' ");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[7] = "showHead";
    localMAutoDBInfo.colsMap.put("showHead", "INTEGER default '0' ");
    localStringBuilder.append(" showHead INTEGER default '0' ");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[8] = "type";
    localMAutoDBInfo.colsMap.put("type", "INTEGER default '0' ");
    localStringBuilder.append(" type INTEGER default '0' ");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[9] = "weiboFlag";
    localMAutoDBInfo.colsMap.put("weiboFlag", "INTEGER default '0' ");
    localStringBuilder.append(" weiboFlag INTEGER default '0' ");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[10] = "weiboNickname";
    localMAutoDBInfo.colsMap.put("weiboNickname", "TEXT default '' ");
    localStringBuilder.append(" weiboNickname TEXT default '' ");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[11] = "conRemarkPYFull";
    localMAutoDBInfo.colsMap.put("conRemarkPYFull", "TEXT default '' ");
    localStringBuilder.append(" conRemarkPYFull TEXT default '' ");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[12] = "conRemarkPYShort";
    localMAutoDBInfo.colsMap.put("conRemarkPYShort", "TEXT default '' ");
    localStringBuilder.append(" conRemarkPYShort TEXT default '' ");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[13] = "lvbuff";
    localMAutoDBInfo.colsMap.put("lvbuff", "BLOB");
    localStringBuilder.append(" lvbuff BLOB");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[14] = "verifyFlag";
    localMAutoDBInfo.colsMap.put("verifyFlag", "INTEGER default '0' ");
    localStringBuilder.append(" verifyFlag INTEGER default '0' ");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[15] = "encryptUsername";
    localMAutoDBInfo.colsMap.put("encryptUsername", "TEXT default '' ");
    localStringBuilder.append(" encryptUsername TEXT default '' ");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[16] = "chatroomFlag";
    localMAutoDBInfo.colsMap.put("chatroomFlag", "INTEGER");
    localStringBuilder.append(" chatroomFlag INTEGER");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[17] = "deleteFlag";
    localMAutoDBInfo.colsMap.put("deleteFlag", "INTEGER default '0' ");
    localStringBuilder.append(" deleteFlag INTEGER default '0' ");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[18] = "contactLabelIds";
    localMAutoDBInfo.colsMap.put("contactLabelIds", "TEXT default '' ");
    localStringBuilder.append(" contactLabelIds TEXT default '' ");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[19] = "descWordingId";
    localMAutoDBInfo.colsMap.put("descWordingId", "TEXT default '' ");
    localStringBuilder.append(" descWordingId TEXT default '' ");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[20] = "openImAppid";
    localMAutoDBInfo.colsMap.put("openImAppid", "TEXT");
    localStringBuilder.append(" openImAppid TEXT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[21] = "sourceExtInfo";
    localMAutoDBInfo.colsMap.put("sourceExtInfo", "TEXT");
    localStringBuilder.append(" sourceExtInfo TEXT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[22] = "ticket";
    localMAutoDBInfo.colsMap.put("ticket", "TEXT default '' ");
    localStringBuilder.append(" ticket TEXT default '' ");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[23] = "usernameFlag";
    localMAutoDBInfo.colsMap.put("usernameFlag", "LONG default '0' ");
    localStringBuilder.append(" usernameFlag LONG default '0' ");
    localMAutoDBInfo.columns[24] = "rowid";
    localMAutoDBInfo.sql = localStringBuilder.toString();
    if (localMAutoDBInfo.primaryKey == null) {
      localMAutoDBInfo.primaryKey = "rowid";
    }
    return localMAutoDBInfo;
  }
  
  public void AV(String paramString)
  {
    this.field_alias = paramString;
    this.jZm = true;
  }
  
  public void AW(String paramString)
  {
    this.field_conRemark = paramString;
    this.jZn = true;
  }
  
  public void AX(String paramString)
  {
    this.field_domainList = paramString;
    this.jZo = true;
  }
  
  public void AY(String paramString)
  {
    this.field_pyInitial = paramString;
    this.jZp = true;
  }
  
  public void AZ(String paramString)
  {
    this.field_quanPin = paramString;
    this.jZq = true;
  }
  
  public void BA(String paramString)
  {
    this.kaq = paramString;
    this.jNM = true;
  }
  
  public void BB(String paramString)
  {
    this.kar = paramString;
    this.jNM = true;
  }
  
  public void BC(String paramString)
  {
    this.kas = paramString;
    this.jNM = true;
  }
  
  public final void BD(String paramString)
  {
    this.kav = paramString;
    this.jNM = true;
  }
  
  public void Ba(String paramString)
  {
    this.field_weiboNickname = paramString;
    this.jZt = true;
  }
  
  public void Bb(String paramString)
  {
    this.field_conRemarkPYFull = paramString;
    this.jZu = true;
  }
  
  public void Bc(String paramString)
  {
    this.field_conRemarkPYShort = paramString;
    this.jZv = true;
  }
  
  public void Bd(String paramString)
  {
    this.field_encryptUsername = paramString;
    this.jZx = true;
  }
  
  public void Be(String paramString)
  {
    this.field_contactLabelIds = paramString;
    this.jZA = true;
  }
  
  public final void Bf(String paramString)
  {
    this.field_descWordingId = paramString;
    this.jZB = true;
  }
  
  public void Bg(String paramString)
  {
    this.field_openImAppid = paramString;
    this.jZC = true;
  }
  
  public void Bh(String paramString)
  {
    this.field_sourceExtInfo = paramString;
    this.jZD = true;
  }
  
  public void Bi(String paramString)
  {
    this.field_ticket = paramString;
    this.jJC = true;
  }
  
  public void Bj(String paramString)
  {
    this.jZZ = paramString;
    this.jNM = true;
  }
  
  public void Bk(String paramString)
  {
    this.kab = paramString;
    this.jNM = true;
  }
  
  public void Bl(String paramString)
  {
    this.hRk = paramString;
    this.jNM = true;
  }
  
  public void Bm(String paramString)
  {
    this.kad = paramString;
    this.jNM = true;
  }
  
  public void Bn(String paramString)
  {
    this.kae = paramString;
    this.jNM = true;
  }
  
  public void Bo(String paramString)
  {
    this.signature = paramString;
    this.jNM = true;
  }
  
  public void Bp(String paramString)
  {
    this.province = paramString;
    this.jNM = true;
  }
  
  public void Bq(String paramString)
  {
    this.city = paramString;
    this.jNM = true;
  }
  
  public void Br(String paramString)
  {
    this.kah = paramString;
    this.jNM = true;
  }
  
  public void Bs(String paramString)
  {
    this.kai = paramString;
    this.jNM = true;
  }
  
  public void Bt(String paramString)
  {
    this.verifyInfo = paramString;
    this.jNM = true;
  }
  
  public void Bu(String paramString)
  {
    this.kaj = paramString;
    this.jNM = true;
  }
  
  public void Bv(String paramString)
  {
    this.kal = paramString;
    this.jNM = true;
  }
  
  public void Bw(String paramString)
  {
    this.kam = paramString;
    this.jNM = true;
  }
  
  public void Bx(String paramString)
  {
    this.kan = paramString;
    this.jNM = true;
  }
  
  public void By(String paramString)
  {
    this.kao = paramString;
    this.jNM = true;
  }
  
  public void Bz(String paramString)
  {
    this.kap = paramString;
    this.jNM = true;
  }
  
  public final String aJA()
  {
    return this.kad;
  }
  
  public final String aJB()
  {
    return this.kae;
  }
  
  public final void aJC()
  {
    this.kaw = 1;
    this.jNM = true;
  }
  
  public String aJs()
  {
    return this.field_alias;
  }
  
  public String aJt()
  {
    return this.field_pyInitial;
  }
  
  public String aJu()
  {
    return this.field_quanPin;
  }
  
  public final byte[] aJv()
  {
    return this.field_lvbuff;
  }
  
  public final int aJw()
  {
    return this.field_chatroomFlag;
  }
  
  public final String aJx()
  {
    return this.field_descWordingId;
  }
  
  public final String aJy()
  {
    return this.field_openImAppid;
  }
  
  public final long aJz()
  {
    return this.kaa;
  }
  
  public void ag(byte[] paramArrayOfByte)
  {
    this.field_lvbuff = paramArrayOfByte;
    this.jNM = true;
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
    if (paramContentValues.containsKey("alias"))
    {
      this.field_alias = paramContentValues.getAsString("alias");
      if (paramBoolean) {
        this.jZm = true;
      }
    }
    if (paramContentValues.containsKey("conRemark"))
    {
      this.field_conRemark = paramContentValues.getAsString("conRemark");
      if (paramBoolean) {
        this.jZn = true;
      }
    }
    if (paramContentValues.containsKey("domainList"))
    {
      this.field_domainList = paramContentValues.getAsString("domainList");
      if (paramBoolean) {
        this.jZo = true;
      }
    }
    if (paramContentValues.containsKey("nickname"))
    {
      this.field_nickname = paramContentValues.getAsString("nickname");
      if (paramBoolean) {
        this.jTo = true;
      }
    }
    if (paramContentValues.containsKey("pyInitial"))
    {
      this.field_pyInitial = paramContentValues.getAsString("pyInitial");
      if (paramBoolean) {
        this.jZp = true;
      }
    }
    if (paramContentValues.containsKey("quanPin"))
    {
      this.field_quanPin = paramContentValues.getAsString("quanPin");
      if (paramBoolean) {
        this.jZq = true;
      }
    }
    if (paramContentValues.containsKey("showHead"))
    {
      this.field_showHead = paramContentValues.getAsInteger("showHead").intValue();
      if (paramBoolean) {
        this.jZr = true;
      }
    }
    if (paramContentValues.containsKey("type"))
    {
      this.field_type = paramContentValues.getAsInteger("type").intValue();
      if (paramBoolean) {
        this.__hadSettype = true;
      }
    }
    if (paramContentValues.containsKey("weiboFlag"))
    {
      this.field_weiboFlag = paramContentValues.getAsInteger("weiboFlag").intValue();
      if (paramBoolean) {
        this.jZs = true;
      }
    }
    if (paramContentValues.containsKey("weiboNickname"))
    {
      this.field_weiboNickname = paramContentValues.getAsString("weiboNickname");
      if (paramBoolean) {
        this.jZt = true;
      }
    }
    if (paramContentValues.containsKey("conRemarkPYFull"))
    {
      this.field_conRemarkPYFull = paramContentValues.getAsString("conRemarkPYFull");
      if (paramBoolean) {
        this.jZu = true;
      }
    }
    if (paramContentValues.containsKey("conRemarkPYShort"))
    {
      this.field_conRemarkPYShort = paramContentValues.getAsString("conRemarkPYShort");
      if (paramBoolean) {
        this.jZv = true;
      }
    }
    if (paramContentValues.containsKey("lvbuff"))
    {
      this.field_lvbuff = paramContentValues.getAsByteArray("lvbuff");
      if (paramBoolean) {
        this.jNM = true;
      }
    }
    if (paramContentValues.containsKey("verifyFlag"))
    {
      this.field_verifyFlag = paramContentValues.getAsInteger("verifyFlag").intValue();
      if (paramBoolean) {
        this.jZw = true;
      }
    }
    if (paramContentValues.containsKey("encryptUsername"))
    {
      this.field_encryptUsername = paramContentValues.getAsString("encryptUsername");
      if (paramBoolean) {
        this.jZx = true;
      }
    }
    if (paramContentValues.containsKey("chatroomFlag"))
    {
      this.field_chatroomFlag = paramContentValues.getAsInteger("chatroomFlag").intValue();
      if (paramBoolean) {
        this.jZy = true;
      }
    }
    if (paramContentValues.containsKey("deleteFlag"))
    {
      this.field_deleteFlag = paramContentValues.getAsInteger("deleteFlag").intValue();
      if (paramBoolean) {
        this.jZz = true;
      }
    }
    if (paramContentValues.containsKey("contactLabelIds"))
    {
      this.field_contactLabelIds = paramContentValues.getAsString("contactLabelIds");
      if (paramBoolean) {
        this.jZA = true;
      }
    }
    if (paramContentValues.containsKey("descWordingId"))
    {
      this.field_descWordingId = paramContentValues.getAsString("descWordingId");
      if (paramBoolean) {
        this.jZB = true;
      }
    }
    if (paramContentValues.containsKey("openImAppid"))
    {
      this.field_openImAppid = paramContentValues.getAsString("openImAppid");
      if (paramBoolean) {
        this.jZC = true;
      }
    }
    if (paramContentValues.containsKey("sourceExtInfo"))
    {
      this.field_sourceExtInfo = paramContentValues.getAsString("sourceExtInfo");
      if (paramBoolean) {
        this.jZD = true;
      }
    }
    if (paramContentValues.containsKey("ticket"))
    {
      this.field_ticket = paramContentValues.getAsString("ticket");
      if (paramBoolean) {
        this.jJC = true;
      }
    }
    if (paramContentValues.containsKey("usernameFlag"))
    {
      this.field_usernameFlag = paramContentValues.getAsLong("usernameFlag").longValue();
      if (paramBoolean) {
        this.jZE = true;
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
    if (i < j)
    {
      int k = arrayOfString[i].hashCode();
      if (username_HASHCODE == k)
      {
        this.field_username = paramCursor.getString(i);
        this.__hadSetusername = true;
      }
      for (;;)
      {
        i += 1;
        break;
        if (jZF == k) {
          this.field_alias = paramCursor.getString(i);
        } else if (jZG == k) {
          this.field_conRemark = paramCursor.getString(i);
        } else if (jZH == k) {
          this.field_domainList = paramCursor.getString(i);
        } else if (jTs == k) {
          this.field_nickname = paramCursor.getString(i);
        } else if (jZI == k) {
          this.field_pyInitial = paramCursor.getString(i);
        } else if (jZJ == k) {
          this.field_quanPin = paramCursor.getString(i);
        } else if (jZK == k) {
          this.field_showHead = paramCursor.getInt(i);
        } else if (type_HASHCODE == k) {
          this.field_type = paramCursor.getInt(i);
        } else if (jZL == k) {
          this.field_weiboFlag = paramCursor.getInt(i);
        } else if (jZM == k) {
          this.field_weiboNickname = paramCursor.getString(i);
        } else if (jZN == k) {
          this.field_conRemarkPYFull = paramCursor.getString(i);
        } else if (jZO == k) {
          this.field_conRemarkPYShort = paramCursor.getString(i);
        } else if (jOi == k) {
          this.field_lvbuff = paramCursor.getBlob(i);
        } else if (jZP == k) {
          this.field_verifyFlag = paramCursor.getInt(i);
        } else if (jZQ == k) {
          this.field_encryptUsername = paramCursor.getString(i);
        } else if (jZR == k) {
          this.field_chatroomFlag = paramCursor.getInt(i);
        } else if (jZS == k) {
          this.field_deleteFlag = paramCursor.getInt(i);
        } else if (jZT == k) {
          this.field_contactLabelIds = paramCursor.getString(i);
        } else if (jZU == k) {
          this.field_descWordingId = paramCursor.getString(i);
        } else if (jZV == k) {
          this.field_openImAppid = paramCursor.getString(i);
        } else if (jZW == k) {
          this.field_sourceExtInfo = paramCursor.getString(i);
        } else if (jJE == k) {
          this.field_ticket = paramCursor.getString(i);
        } else if (jZX == k) {
          this.field_usernameFlag = paramCursor.getLong(i);
        } else if (rowid_HASHCODE == k) {
          this.systemRowid = paramCursor.getLong(i);
        }
      }
    }
    parseBuff();
  }
  
  public ContentValues convertTo()
  {
    try
    {
      if (this.jNM)
      {
        localObject = new LVBuffer();
        ((LVBuffer)localObject).initBuild();
        ((LVBuffer)localObject).putInt(this.jZY);
        ((LVBuffer)localObject).putInt(this.sex);
        ((LVBuffer)localObject).putString(this.jZZ);
        ((LVBuffer)localObject).putLong(this.kaa);
        ((LVBuffer)localObject).putInt(this.uin);
        ((LVBuffer)localObject).putString(this.kab);
        ((LVBuffer)localObject).putString(this.hRk);
        ((LVBuffer)localObject).putInt(this.showFlag);
        ((LVBuffer)localObject).putInt(this.kac);
        ((LVBuffer)localObject).putString(this.kad);
        ((LVBuffer)localObject).putString(this.kae);
        ((LVBuffer)localObject).putInt(this.kaf);
        ((LVBuffer)localObject).putInt(this.kag);
        ((LVBuffer)localObject).putString(this.signature);
        ((LVBuffer)localObject).putString(this.province);
        ((LVBuffer)localObject).putString(this.city);
        ((LVBuffer)localObject).putString(this.kah);
        ((LVBuffer)localObject).putInt(this.fromType);
        ((LVBuffer)localObject).putInt(this.source);
        ((LVBuffer)localObject).putString(this.kai);
        ((LVBuffer)localObject).putInt(this.field_verifyFlag);
        ((LVBuffer)localObject).putString(this.verifyInfo);
        ((LVBuffer)localObject).putString(this.kaj);
        ((LVBuffer)localObject).putInt(this.kak);
        ((LVBuffer)localObject).putInt(this.hyY);
        ((LVBuffer)localObject).putString(this.kal);
        ((LVBuffer)localObject).putString(this.kam);
        ((LVBuffer)localObject).putString(this.kan);
        ((LVBuffer)localObject).putString(this.kao);
        ((LVBuffer)localObject).putString(this.kap);
        ((LVBuffer)localObject).putString(this.kaq);
        ((LVBuffer)localObject).putString(this.kar);
        ((LVBuffer)localObject).putString(this.kas);
        ((LVBuffer)localObject).putInt(this.extFlag);
        ((LVBuffer)localObject).putString(this.kat);
        ((LVBuffer)localObject).putInt(this.kau);
        ((LVBuffer)localObject).putString(this.kav);
        ((LVBuffer)localObject).putInt(this.kaw);
        ((LVBuffer)localObject).putLong(this.kax);
        ((LVBuffer)localObject).putLong(this.kay);
        this.field_lvbuff = ((LVBuffer)localObject).buildFinish();
      }
      Object localObject = new ContentValues();
      if (this.field_username == null) {
        this.field_username = "";
      }
      if (this.__hadSetusername) {
        ((ContentValues)localObject).put("username", this.field_username);
      }
      if (this.field_alias == null) {
        this.field_alias = "";
      }
      if (this.jZm) {
        ((ContentValues)localObject).put("alias", this.field_alias);
      }
      if (this.field_conRemark == null) {
        this.field_conRemark = "";
      }
      if (this.jZn) {
        ((ContentValues)localObject).put("conRemark", this.field_conRemark);
      }
      if (this.field_domainList == null) {
        this.field_domainList = "";
      }
      if (this.jZo) {
        ((ContentValues)localObject).put("domainList", this.field_domainList);
      }
      if (this.field_nickname == null) {
        this.field_nickname = "";
      }
      if (this.jTo) {
        ((ContentValues)localObject).put("nickname", this.field_nickname);
      }
      if (this.field_pyInitial == null) {
        this.field_pyInitial = "";
      }
      if (this.jZp) {
        ((ContentValues)localObject).put("pyInitial", this.field_pyInitial);
      }
      if (this.field_quanPin == null) {
        this.field_quanPin = "";
      }
      if (this.jZq) {
        ((ContentValues)localObject).put("quanPin", this.field_quanPin);
      }
      if (this.jZr) {
        ((ContentValues)localObject).put("showHead", Integer.valueOf(this.field_showHead));
      }
      if (this.__hadSettype) {
        ((ContentValues)localObject).put("type", Integer.valueOf(this.field_type));
      }
      if (this.jZs) {
        ((ContentValues)localObject).put("weiboFlag", Integer.valueOf(this.field_weiboFlag));
      }
      if (this.field_weiboNickname == null) {
        this.field_weiboNickname = "";
      }
      if (this.jZt) {
        ((ContentValues)localObject).put("weiboNickname", this.field_weiboNickname);
      }
      if (this.field_conRemarkPYFull == null) {
        this.field_conRemarkPYFull = "";
      }
      if (this.jZu) {
        ((ContentValues)localObject).put("conRemarkPYFull", this.field_conRemarkPYFull);
      }
      if (this.field_conRemarkPYShort == null) {
        this.field_conRemarkPYShort = "";
      }
      if (this.jZv) {
        ((ContentValues)localObject).put("conRemarkPYShort", this.field_conRemarkPYShort);
      }
      if (this.jNM) {
        ((ContentValues)localObject).put("lvbuff", this.field_lvbuff);
      }
      if (this.jZw) {
        ((ContentValues)localObject).put("verifyFlag", Integer.valueOf(this.field_verifyFlag));
      }
      if (this.field_encryptUsername == null) {
        this.field_encryptUsername = "";
      }
      if (this.jZx) {
        ((ContentValues)localObject).put("encryptUsername", this.field_encryptUsername);
      }
      if (this.jZy) {
        ((ContentValues)localObject).put("chatroomFlag", Integer.valueOf(this.field_chatroomFlag));
      }
      if (this.jZz) {
        ((ContentValues)localObject).put("deleteFlag", Integer.valueOf(this.field_deleteFlag));
      }
      if (this.field_contactLabelIds == null) {
        this.field_contactLabelIds = "";
      }
      if (this.jZA) {
        ((ContentValues)localObject).put("contactLabelIds", this.field_contactLabelIds);
      }
      if (this.field_descWordingId == null) {
        this.field_descWordingId = "";
      }
      if (this.jZB) {
        ((ContentValues)localObject).put("descWordingId", this.field_descWordingId);
      }
      if (this.jZC) {
        ((ContentValues)localObject).put("openImAppid", this.field_openImAppid);
      }
      if (this.jZD) {
        ((ContentValues)localObject).put("sourceExtInfo", this.field_sourceExtInfo);
      }
      if (this.field_ticket == null) {
        this.field_ticket = "";
      }
      if (this.jJC) {
        ((ContentValues)localObject).put("ticket", this.field_ticket);
      }
      if (this.jZE) {
        ((ContentValues)localObject).put("usernameFlag", Long.valueOf(this.field_usernameFlag));
      }
      if (this.systemRowid > 0L) {
        ((ContentValues)localObject).put("rowid", Long.valueOf(this.systemRowid));
      }
      return localObject;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        Log.e("MicroMsg.SDK.BaseContact", "get value failed, %s", new Object[] { localException.getMessage() });
      }
    }
  }
  
  public final void gN(long paramLong)
  {
    this.field_usernameFlag = paramLong;
    this.jZE = true;
  }
  
  public void gO(long paramLong)
  {
    this.kaa = paramLong;
    this.jNM = true;
  }
  
  public void gP(long paramLong)
  {
    this.kax = paramLong;
    this.jNM = true;
  }
  
  public void gQ(long paramLong)
  {
    this.kay = paramLong;
    this.jNM = true;
  }
  
  public String getCity()
  {
    return this.city;
  }
  
  public IAutoDBItem.MAutoDBInfo getDBInfo()
  {
    return DB_INFO;
  }
  
  public final String getEmail()
  {
    return this.kab;
  }
  
  public String[] getIndexCreateSQL()
  {
    return INDEX_CREATE;
  }
  
  public Object getPrimaryKeyValue()
  {
    return this.field_username;
  }
  
  public String getProvince()
  {
    return this.province;
  }
  
  public final int getShowFlag()
  {
    return this.showFlag;
  }
  
  public int getSource()
  {
    return this.source;
  }
  
  public SingleTable getTable()
  {
    return TABLE;
  }
  
  public String getTableName()
  {
    return TABLE.getName();
  }
  
  public final String getUsername()
  {
    return this.field_username;
  }
  
  public void pA(int paramInt)
  {
    this.kag = paramInt;
    this.jNM = true;
  }
  
  public void pB(int paramInt)
  {
    this.kak = paramInt;
    this.jNM = true;
  }
  
  public void pC(int paramInt)
  {
    this.hyY = paramInt;
    this.jNM = true;
  }
  
  public final void pD(int paramInt)
  {
    this.extFlag = paramInt;
    this.jNM = true;
  }
  
  public final void pE(int paramInt)
  {
    this.kau = paramInt;
    this.jNM = true;
  }
  
  public final void parseBuff()
  {
    try
    {
      if (this.field_lvbuff == null) {
        return;
      }
      if (this.field_lvbuff.length == 0) {
        return;
      }
      LVBuffer localLVBuffer = new LVBuffer();
      int i = localLVBuffer.initParse(this.field_lvbuff);
      if (i != 0)
      {
        Log.e("MicroMsg.SDK.BaseContact", "parse LVBuffer error:".concat(String.valueOf(i)));
        return;
      }
    }
    catch (Exception localException)
    {
      Log.e("MicroMsg.SDK.BaseContact", "get value failed");
      return;
    }
    this.jZY = localException.getInt();
    this.sex = localException.getInt();
    this.jZZ = localException.getString();
    this.kaa = localException.getLong();
    this.uin = localException.getInt();
    this.kab = localException.getString();
    this.hRk = localException.getString();
    this.showFlag = localException.getInt();
    this.kac = localException.getInt();
    this.kad = localException.getString();
    this.kae = localException.getString();
    this.kaf = localException.getInt();
    this.kag = localException.getInt();
    this.signature = localException.getString();
    this.province = localException.getString();
    this.city = localException.getString();
    this.kah = localException.getString();
    this.fromType = localException.getInt();
    this.source = localException.getInt();
    this.kai = localException.getString();
    this.field_verifyFlag = localException.getInt();
    this.verifyInfo = localException.getString();
    if (!localException.checkGetFinish()) {
      this.kaj = localException.getString();
    }
    if (!localException.checkGetFinish()) {
      this.kak = localException.getInt();
    }
    if (!localException.checkGetFinish()) {
      this.hyY = localException.getInt();
    }
    if (!localException.checkGetFinish()) {
      this.kal = localException.getString();
    }
    if (!localException.checkGetFinish()) {
      this.kam = localException.getString();
    }
    if (!localException.checkGetFinish()) {
      this.kan = localException.getString();
    }
    if (!localException.checkGetFinish()) {
      this.kao = localException.getString();
    }
    if (!localException.checkGetFinish()) {
      this.kap = localException.getString();
    }
    if (!localException.checkGetFinish()) {
      this.kaq = localException.getString();
    }
    if (!localException.checkGetFinish()) {
      this.kar = localException.getString();
    }
    if (!localException.checkGetFinish()) {
      this.kas = localException.getString();
    }
    if (!localException.checkGetFinish()) {
      this.extFlag = localException.getInt();
    }
    if (!localException.checkGetFinish()) {
      this.kat = localException.getString();
    }
    if (!localException.checkGetFinish()) {
      this.kau = localException.getInt();
    }
    if (!localException.checkGetFinish()) {
      this.kav = localException.getString();
    }
    if (!localException.checkGetFinish()) {
      this.kaw = localException.getInt();
    }
    if (!localException.checkGetFinish()) {
      this.kax = localException.getLong();
    }
    if (!localException.checkGetFinish()) {
      this.kay = localException.getLong();
    }
  }
  
  public void pp(int paramInt)
  {
    this.field_showHead = paramInt;
    this.jZr = true;
  }
  
  public void pq(int paramInt)
  {
    this.field_weiboFlag = paramInt;
    this.jZs = true;
  }
  
  public void pr(int paramInt)
  {
    this.field_verifyFlag = paramInt;
    this.jZw = true;
  }
  
  public void ps(int paramInt)
  {
    this.field_chatroomFlag = paramInt;
    this.jZy = true;
  }
  
  public void pt(int paramInt)
  {
    this.field_deleteFlag = paramInt;
    this.jZz = true;
  }
  
  public void pu(int paramInt)
  {
    this.jZY = paramInt;
    this.jNM = true;
  }
  
  public void pv(int paramInt)
  {
    this.sex = paramInt;
    this.jNM = true;
  }
  
  public void pw(int paramInt)
  {
    this.showFlag = paramInt;
    this.jNM = true;
  }
  
  public void py(int paramInt)
  {
    this.kac = paramInt;
    this.jNM = true;
  }
  
  public void pz(int paramInt)
  {
    this.kaf = paramInt;
    this.jNM = true;
  }
  
  public void setFromType(int paramInt)
  {
    this.fromType = paramInt;
    this.jNM = true;
  }
  
  public void setNickname(String paramString)
  {
    this.field_nickname = paramString;
    this.jTo = true;
  }
  
  public void setSource(int paramInt)
  {
    this.source = paramInt;
    this.jNM = true;
  }
  
  public void setType(int paramInt)
  {
    this.field_type = paramInt;
    this.__hadSettype = true;
  }
  
  public void setUin(int paramInt)
  {
    this.uin = paramInt;
    this.jNM = true;
  }
  
  public void setUsername(String paramString)
  {
    this.field_username = paramString;
    this.__hadSetusername = true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.autogen.b.az
 * JD-Core Version:    0.7.0.1
 */