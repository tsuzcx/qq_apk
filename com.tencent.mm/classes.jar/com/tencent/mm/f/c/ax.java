package com.tencent.mm.f.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.platformtools.LVBuffer;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.storage.IAutoDBItem;
import com.tencent.mm.sdk.storage.sql.Column;
import com.tencent.mm.sdk.storage.sql.SingleTable;

public abstract class ax
  extends IAutoDBItem
{
  public static final Column C_ROWID;
  public static final Column C_TYPE;
  public static final Column C_USERNAME;
  public static final String[] INDEX_CREATE = { "CREATE INDEX IF NOT EXISTS deleteflag_index ON Contact(deleteFlag)" };
  public static final SingleTable TABLE = new SingleTable("Contact");
  public static final Column hBX;
  public static final Column hBY;
  public static final Column hBZ;
  private static final int hCJ;
  private static final int hCK;
  private static final int hCL;
  private static final int hCM;
  private static final int hCN;
  private static final int hCO;
  private static final int hCP;
  private static final int hCQ;
  private static final int hCR;
  private static final int hCS;
  private static final int hCT;
  private static final int hCU;
  private static final int hCV;
  private static final int hCW;
  private static final int hCX;
  private static final int hCY;
  private static final int hCZ;
  public static final Column hCa;
  public static final Column hCb;
  public static final Column hCc;
  public static final Column hCd;
  public static final Column hCe;
  public static final Column hCf;
  public static final Column hCg;
  public static final Column hCh;
  public static final Column hCi;
  public static final Column hCj;
  public static final Column hCk;
  public static final Column hCl;
  public static final Column hCm;
  public static final Column hCn;
  public static final Column hCo;
  public static final Column hCp;
  private static final int hDa;
  private static final int hDb = "usernameFlag".hashCode();
  public static final Column hnu;
  private static final int hny;
  public static final Column hqD;
  private static final int hrv;
  private static final int hwF;
  public static final Column hwx;
  private static final int rowid_HASHCODE = "rowid".hashCode();
  private static final int type_HASHCODE;
  private static final int username_HASHCODE;
  private boolean __hadSettype = false;
  private boolean __hadSetusername = false;
  private String city;
  private int extFlag;
  public String fLC;
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
  private int fromType;
  private boolean hCA = false;
  private boolean hCB = false;
  private boolean hCC = false;
  private boolean hCD = false;
  private boolean hCE = false;
  private boolean hCF = false;
  private boolean hCG = false;
  private boolean hCH = false;
  private boolean hCI = false;
  private boolean hCq = false;
  private boolean hCr = false;
  private boolean hCs = false;
  private boolean hCt = false;
  private boolean hCu = false;
  private boolean hCv = false;
  private boolean hCw = false;
  private boolean hCx = false;
  private boolean hCy = false;
  private boolean hCz = false;
  public String hDA;
  public int hDB;
  public long hDC;
  public long hDD;
  public int hDc;
  public String hDd;
  private long hDe;
  private String hDf;
  public int hDg;
  private String hDh;
  private String hDi;
  public int hDj;
  public int hDk;
  public String hDl;
  public String hDm;
  public String hDn;
  public int hDo;
  public int hDp;
  public String hDq;
  public String hDr;
  public String hDs;
  public String hDt;
  public String hDu;
  public String hDv;
  public String hDw;
  public String hDx;
  private String hDy;
  public int hDz;
  private boolean hnw = false;
  private boolean hqZ = false;
  private boolean hwB = false;
  private String province;
  public int sex;
  private int showFlag;
  public String signature;
  private int source;
  public int uin;
  public String verifyInfo;
  
  static
  {
    C_ROWID = new Column("rowid", "long", "Contact", "");
    C_USERNAME = new Column("username", "string", "Contact", "");
    hBX = new Column("alias", "string", "Contact", "");
    hBY = new Column("conremark", "string", "Contact", "");
    hBZ = new Column("domainlist", "string", "Contact", "");
    hwx = new Column("nickname", "string", "Contact", "");
    hCa = new Column("pyinitial", "string", "Contact", "");
    hCb = new Column("quanpin", "string", "Contact", "");
    hCc = new Column("showhead", "int", "Contact", "");
    C_TYPE = new Column("type", "int", "Contact", "");
    hCd = new Column("weiboflag", "int", "Contact", "");
    hCe = new Column("weibonickname", "string", "Contact", "");
    hCf = new Column("conremarkpyfull", "string", "Contact", "");
    hCg = new Column("conremarkpyshort", "string", "Contact", "");
    hqD = new Column("lvbuff", "byte[]", "Contact", "");
    hCh = new Column("verifyflag", "int", "Contact", "");
    hCi = new Column("encryptusername", "string", "Contact", "");
    hCj = new Column("chatroomflag", "int", "Contact", "");
    hCk = new Column("deleteflag", "int", "Contact", "");
    hCl = new Column("contactlabelids", "string", "Contact", "");
    hCm = new Column("descwordingid", "string", "Contact", "");
    hCn = new Column("openimappid", "string", "Contact", "");
    hCo = new Column("sourceextinfo", "string", "Contact", "");
    hnu = new Column("ticket", "string", "Contact", "");
    hCp = new Column("usernameflag", "long", "Contact", "");
    username_HASHCODE = "username".hashCode();
    hCJ = "alias".hashCode();
    hCK = "conRemark".hashCode();
    hCL = "domainList".hashCode();
    hwF = "nickname".hashCode();
    hCM = "pyInitial".hashCode();
    hCN = "quanPin".hashCode();
    hCO = "showHead".hashCode();
    type_HASHCODE = "type".hashCode();
    hCP = "weiboFlag".hashCode();
    hCQ = "weiboNickname".hashCode();
    hCR = "conRemarkPYFull".hashCode();
    hCS = "conRemarkPYShort".hashCode();
    hrv = "lvbuff".hashCode();
    hCT = "verifyFlag".hashCode();
    hCU = "encryptUsername".hashCode();
    hCV = "chatroomFlag".hashCode();
    hCW = "deleteFlag".hashCode();
    hCX = "contactLabelIds".hashCode();
    hCY = "descWordingId".hashCode();
    hCZ = "openImAppid".hashCode();
    hDa = "sourceExtInfo".hashCode();
    hny = "ticket".hashCode();
  }
  
  public void EA(long paramLong)
  {
    this.hDD = paramLong;
    this.hqZ = true;
  }
  
  public final void Ex(long paramLong)
  {
    this.field_usernameFlag = paramLong;
    this.hCI = true;
  }
  
  public void Ey(long paramLong)
  {
    this.hDe = paramLong;
    this.hqZ = true;
  }
  
  public void Ez(long paramLong)
  {
    this.hDC = paramLong;
    this.hqZ = true;
  }
  
  public final void IA(String paramString)
  {
    this.field_descWordingId = paramString;
    this.hCF = true;
  }
  
  public void IB(String paramString)
  {
    this.field_openImAppid = paramString;
    this.hCG = true;
  }
  
  public void IC(String paramString)
  {
    this.field_sourceExtInfo = paramString;
    this.hCH = true;
  }
  
  public void ID(String paramString)
  {
    this.field_ticket = paramString;
    this.hnw = true;
  }
  
  public void IE(String paramString)
  {
    this.hDd = paramString;
    this.hqZ = true;
  }
  
  public void IF(String paramString)
  {
    this.hDf = paramString;
    this.hqZ = true;
  }
  
  public void IG(String paramString)
  {
    this.fLC = paramString;
    this.hqZ = true;
  }
  
  public void IH(String paramString)
  {
    this.hDh = paramString;
    this.hqZ = true;
  }
  
  public void II(String paramString)
  {
    this.hDi = paramString;
    this.hqZ = true;
  }
  
  public void IJ(String paramString)
  {
    this.signature = paramString;
    this.hqZ = true;
  }
  
  public void IK(String paramString)
  {
    this.province = paramString;
    this.hqZ = true;
  }
  
  public void IL(String paramString)
  {
    this.city = paramString;
    this.hqZ = true;
  }
  
  public void IM(String paramString)
  {
    this.hDl = paramString;
    this.hqZ = true;
  }
  
  public void IN(String paramString)
  {
    this.hDm = paramString;
    this.hqZ = true;
  }
  
  public void IO(String paramString)
  {
    this.verifyInfo = paramString;
    this.hqZ = true;
  }
  
  public void IP(String paramString)
  {
    this.hDn = paramString;
    this.hqZ = true;
  }
  
  public void IQ(String paramString)
  {
    this.hDq = paramString;
    this.hqZ = true;
  }
  
  public void IR(String paramString)
  {
    this.hDr = paramString;
    this.hqZ = true;
  }
  
  public void IS(String paramString)
  {
    this.hDs = paramString;
    this.hqZ = true;
  }
  
  public void IT(String paramString)
  {
    this.hDt = paramString;
    this.hqZ = true;
  }
  
  public void IU(String paramString)
  {
    this.hDu = paramString;
    this.hqZ = true;
  }
  
  public void IV(String paramString)
  {
    this.hDv = paramString;
    this.hqZ = true;
  }
  
  public void IW(String paramString)
  {
    this.hDw = paramString;
    this.hqZ = true;
  }
  
  public void IX(String paramString)
  {
    this.hDx = paramString;
    this.hqZ = true;
  }
  
  public final void IY(String paramString)
  {
    this.hDA = paramString;
    this.hqZ = true;
  }
  
  public void Iq(String paramString)
  {
    this.field_alias = paramString;
    this.hCq = true;
  }
  
  public void Ir(String paramString)
  {
    this.field_conRemark = paramString;
    this.hCr = true;
  }
  
  public void Is(String paramString)
  {
    this.field_domainList = paramString;
    this.hCs = true;
  }
  
  public void It(String paramString)
  {
    this.field_pyInitial = paramString;
    this.hCt = true;
  }
  
  public void Iu(String paramString)
  {
    this.field_quanPin = paramString;
    this.hCu = true;
  }
  
  public void Iv(String paramString)
  {
    this.field_weiboNickname = paramString;
    this.hCx = true;
  }
  
  public void Iw(String paramString)
  {
    this.field_conRemarkPYFull = paramString;
    this.hCy = true;
  }
  
  public void Ix(String paramString)
  {
    this.field_conRemarkPYShort = paramString;
    this.hCz = true;
  }
  
  public void Iy(String paramString)
  {
    this.field_encryptUsername = paramString;
    this.hCB = true;
  }
  
  public void Iz(String paramString)
  {
    this.field_contactLabelIds = paramString;
    this.hCE = true;
  }
  
  public void ag(byte[] paramArrayOfByte)
  {
    this.field_lvbuff = paramArrayOfByte;
    this.hqZ = true;
  }
  
  public String apf()
  {
    return this.field_alias;
  }
  
  public final String apg()
  {
    return this.field_conRemark;
  }
  
  public String aph()
  {
    return this.field_pyInitial;
  }
  
  public String api()
  {
    return this.field_quanPin;
  }
  
  public final int apj()
  {
    return this.field_showHead;
  }
  
  public final String apk()
  {
    return this.field_conRemarkPYFull;
  }
  
  public final byte[] apl()
  {
    return this.field_lvbuff;
  }
  
  public final int apm()
  {
    return this.field_verifyFlag;
  }
  
  public final String apn()
  {
    return this.field_encryptUsername;
  }
  
  public final int apo()
  {
    return this.field_chatroomFlag;
  }
  
  public final int app()
  {
    return this.field_deleteFlag;
  }
  
  public final String apq()
  {
    return this.field_descWordingId;
  }
  
  public final String apr()
  {
    return this.field_openImAppid;
  }
  
  public final long aps()
  {
    return this.field_usernameFlag;
  }
  
  public final int apt()
  {
    return this.sex;
  }
  
  public final long apu()
  {
    return this.hDe;
  }
  
  public final String apv()
  {
    return this.hDh;
  }
  
  public final String apw()
  {
    return this.hDi;
  }
  
  public final int apx()
  {
    return this.hDp;
  }
  
  public final void apy()
  {
    this.hDB = 1;
    this.hqZ = true;
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
        if (hCJ == k) {
          this.field_alias = paramCursor.getString(i);
        } else if (hCK == k) {
          this.field_conRemark = paramCursor.getString(i);
        } else if (hCL == k) {
          this.field_domainList = paramCursor.getString(i);
        } else if (hwF == k) {
          this.field_nickname = paramCursor.getString(i);
        } else if (hCM == k) {
          this.field_pyInitial = paramCursor.getString(i);
        } else if (hCN == k) {
          this.field_quanPin = paramCursor.getString(i);
        } else if (hCO == k) {
          this.field_showHead = paramCursor.getInt(i);
        } else if (type_HASHCODE == k) {
          this.field_type = paramCursor.getInt(i);
        } else if (hCP == k) {
          this.field_weiboFlag = paramCursor.getInt(i);
        } else if (hCQ == k) {
          this.field_weiboNickname = paramCursor.getString(i);
        } else if (hCR == k) {
          this.field_conRemarkPYFull = paramCursor.getString(i);
        } else if (hCS == k) {
          this.field_conRemarkPYShort = paramCursor.getString(i);
        } else if (hrv == k) {
          this.field_lvbuff = paramCursor.getBlob(i);
        } else if (hCT == k) {
          this.field_verifyFlag = paramCursor.getInt(i);
        } else if (hCU == k) {
          this.field_encryptUsername = paramCursor.getString(i);
        } else if (hCV == k) {
          this.field_chatroomFlag = paramCursor.getInt(i);
        } else if (hCW == k) {
          this.field_deleteFlag = paramCursor.getInt(i);
        } else if (hCX == k) {
          this.field_contactLabelIds = paramCursor.getString(i);
        } else if (hCY == k) {
          this.field_descWordingId = paramCursor.getString(i);
        } else if (hCZ == k) {
          this.field_openImAppid = paramCursor.getString(i);
        } else if (hDa == k) {
          this.field_sourceExtInfo = paramCursor.getString(i);
        } else if (hny == k) {
          this.field_ticket = paramCursor.getString(i);
        } else if (hDb == k) {
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
      if (this.hqZ)
      {
        localObject = new LVBuffer();
        ((LVBuffer)localObject).initBuild();
        ((LVBuffer)localObject).putInt(this.hDc);
        ((LVBuffer)localObject).putInt(this.sex);
        ((LVBuffer)localObject).putString(this.hDd);
        ((LVBuffer)localObject).putLong(this.hDe);
        ((LVBuffer)localObject).putInt(this.uin);
        ((LVBuffer)localObject).putString(this.hDf);
        ((LVBuffer)localObject).putString(this.fLC);
        ((LVBuffer)localObject).putInt(this.showFlag);
        ((LVBuffer)localObject).putInt(this.hDg);
        ((LVBuffer)localObject).putString(this.hDh);
        ((LVBuffer)localObject).putString(this.hDi);
        ((LVBuffer)localObject).putInt(this.hDj);
        ((LVBuffer)localObject).putInt(this.hDk);
        ((LVBuffer)localObject).putString(this.signature);
        ((LVBuffer)localObject).putString(this.province);
        ((LVBuffer)localObject).putString(this.city);
        ((LVBuffer)localObject).putString(this.hDl);
        ((LVBuffer)localObject).putInt(this.fromType);
        ((LVBuffer)localObject).putInt(this.source);
        ((LVBuffer)localObject).putString(this.hDm);
        ((LVBuffer)localObject).putInt(this.field_verifyFlag);
        ((LVBuffer)localObject).putString(this.verifyInfo);
        ((LVBuffer)localObject).putString(this.hDn);
        ((LVBuffer)localObject).putInt(this.hDo);
        ((LVBuffer)localObject).putInt(this.hDp);
        ((LVBuffer)localObject).putString(this.hDq);
        ((LVBuffer)localObject).putString(this.hDr);
        ((LVBuffer)localObject).putString(this.hDs);
        ((LVBuffer)localObject).putString(this.hDt);
        ((LVBuffer)localObject).putString(this.hDu);
        ((LVBuffer)localObject).putString(this.hDv);
        ((LVBuffer)localObject).putString(this.hDw);
        ((LVBuffer)localObject).putString(this.hDx);
        ((LVBuffer)localObject).putInt(this.extFlag);
        ((LVBuffer)localObject).putString(this.hDy);
        ((LVBuffer)localObject).putInt(this.hDz);
        ((LVBuffer)localObject).putString(this.hDA);
        ((LVBuffer)localObject).putInt(this.hDB);
        ((LVBuffer)localObject).putLong(this.hDC);
        ((LVBuffer)localObject).putLong(this.hDD);
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
      if (this.hCq) {
        ((ContentValues)localObject).put("alias", this.field_alias);
      }
      if (this.field_conRemark == null) {
        this.field_conRemark = "";
      }
      if (this.hCr) {
        ((ContentValues)localObject).put("conRemark", this.field_conRemark);
      }
      if (this.field_domainList == null) {
        this.field_domainList = "";
      }
      if (this.hCs) {
        ((ContentValues)localObject).put("domainList", this.field_domainList);
      }
      if (this.field_nickname == null) {
        this.field_nickname = "";
      }
      if (this.hwB) {
        ((ContentValues)localObject).put("nickname", this.field_nickname);
      }
      if (this.field_pyInitial == null) {
        this.field_pyInitial = "";
      }
      if (this.hCt) {
        ((ContentValues)localObject).put("pyInitial", this.field_pyInitial);
      }
      if (this.field_quanPin == null) {
        this.field_quanPin = "";
      }
      if (this.hCu) {
        ((ContentValues)localObject).put("quanPin", this.field_quanPin);
      }
      if (this.hCv) {
        ((ContentValues)localObject).put("showHead", Integer.valueOf(this.field_showHead));
      }
      if (this.__hadSettype) {
        ((ContentValues)localObject).put("type", Integer.valueOf(this.field_type));
      }
      if (this.hCw) {
        ((ContentValues)localObject).put("weiboFlag", Integer.valueOf(this.field_weiboFlag));
      }
      if (this.field_weiboNickname == null) {
        this.field_weiboNickname = "";
      }
      if (this.hCx) {
        ((ContentValues)localObject).put("weiboNickname", this.field_weiboNickname);
      }
      if (this.field_conRemarkPYFull == null) {
        this.field_conRemarkPYFull = "";
      }
      if (this.hCy) {
        ((ContentValues)localObject).put("conRemarkPYFull", this.field_conRemarkPYFull);
      }
      if (this.field_conRemarkPYShort == null) {
        this.field_conRemarkPYShort = "";
      }
      if (this.hCz) {
        ((ContentValues)localObject).put("conRemarkPYShort", this.field_conRemarkPYShort);
      }
      if (this.hqZ) {
        ((ContentValues)localObject).put("lvbuff", this.field_lvbuff);
      }
      if (this.hCA) {
        ((ContentValues)localObject).put("verifyFlag", Integer.valueOf(this.field_verifyFlag));
      }
      if (this.field_encryptUsername == null) {
        this.field_encryptUsername = "";
      }
      if (this.hCB) {
        ((ContentValues)localObject).put("encryptUsername", this.field_encryptUsername);
      }
      if (this.hCC) {
        ((ContentValues)localObject).put("chatroomFlag", Integer.valueOf(this.field_chatroomFlag));
      }
      if (this.hCD) {
        ((ContentValues)localObject).put("deleteFlag", Integer.valueOf(this.field_deleteFlag));
      }
      if (this.field_contactLabelIds == null) {
        this.field_contactLabelIds = "";
      }
      if (this.hCE) {
        ((ContentValues)localObject).put("contactLabelIds", this.field_contactLabelIds);
      }
      if (this.field_descWordingId == null) {
        this.field_descWordingId = "";
      }
      if (this.hCF) {
        ((ContentValues)localObject).put("descWordingId", this.field_descWordingId);
      }
      if (this.hCG) {
        ((ContentValues)localObject).put("openImAppid", this.field_openImAppid);
      }
      if (this.hCH) {
        ((ContentValues)localObject).put("sourceExtInfo", this.field_sourceExtInfo);
      }
      if (this.field_ticket == null) {
        this.field_ticket = "";
      }
      if (this.hnw) {
        ((ContentValues)localObject).put("ticket", this.field_ticket);
      }
      if (this.hCI) {
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
  
  public String getCity()
  {
    return this.city;
  }
  
  public final String getEmail()
  {
    return this.hDf;
  }
  
  public final int getFromType()
  {
    return this.fromType;
  }
  
  public String[] getIndexCreateSQL()
  {
    return INDEX_CREATE;
  }
  
  public final String getNickname()
  {
    return this.field_nickname;
  }
  
  public String getProvince()
  {
    return this.province;
  }
  
  public final int getShowFlag()
  {
    return this.showFlag;
  }
  
  public final String getSignature()
  {
    return this.signature;
  }
  
  public int getSource()
  {
    return this.source;
  }
  
  public String getTableName()
  {
    return "Contact";
  }
  
  public final int getType()
  {
    return this.field_type;
  }
  
  public final int getUin()
  {
    return this.uin;
  }
  
  public final String getUsername()
  {
    return this.field_username;
  }
  
  public void pA(int paramInt)
  {
    this.hDj = paramInt;
    this.hqZ = true;
  }
  
  public void pB(int paramInt)
  {
    this.hDk = paramInt;
    this.hqZ = true;
  }
  
  public void pC(int paramInt)
  {
    this.hDo = paramInt;
    this.hqZ = true;
  }
  
  public void pD(int paramInt)
  {
    this.hDp = paramInt;
    this.hqZ = true;
  }
  
  public final void pE(int paramInt)
  {
    this.extFlag = paramInt;
    this.hqZ = true;
  }
  
  public final void pF(int paramInt)
  {
    this.hDz = paramInt;
    this.hqZ = true;
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
    this.hDc = localException.getInt();
    this.sex = localException.getInt();
    this.hDd = localException.getString();
    this.hDe = localException.getLong();
    this.uin = localException.getInt();
    this.hDf = localException.getString();
    this.fLC = localException.getString();
    this.showFlag = localException.getInt();
    this.hDg = localException.getInt();
    this.hDh = localException.getString();
    this.hDi = localException.getString();
    this.hDj = localException.getInt();
    this.hDk = localException.getInt();
    this.signature = localException.getString();
    this.province = localException.getString();
    this.city = localException.getString();
    this.hDl = localException.getString();
    this.fromType = localException.getInt();
    this.source = localException.getInt();
    this.hDm = localException.getString();
    this.field_verifyFlag = localException.getInt();
    this.verifyInfo = localException.getString();
    if (!localException.checkGetFinish()) {
      this.hDn = localException.getString();
    }
    if (!localException.checkGetFinish()) {
      this.hDo = localException.getInt();
    }
    if (!localException.checkGetFinish()) {
      this.hDp = localException.getInt();
    }
    if (!localException.checkGetFinish()) {
      this.hDq = localException.getString();
    }
    if (!localException.checkGetFinish()) {
      this.hDr = localException.getString();
    }
    if (!localException.checkGetFinish()) {
      this.hDs = localException.getString();
    }
    if (!localException.checkGetFinish()) {
      this.hDt = localException.getString();
    }
    if (!localException.checkGetFinish()) {
      this.hDu = localException.getString();
    }
    if (!localException.checkGetFinish()) {
      this.hDv = localException.getString();
    }
    if (!localException.checkGetFinish()) {
      this.hDw = localException.getString();
    }
    if (!localException.checkGetFinish()) {
      this.hDx = localException.getString();
    }
    if (!localException.checkGetFinish()) {
      this.extFlag = localException.getInt();
    }
    if (!localException.checkGetFinish()) {
      this.hDy = localException.getString();
    }
    if (!localException.checkGetFinish()) {
      this.hDz = localException.getInt();
    }
    if (!localException.checkGetFinish()) {
      this.hDA = localException.getString();
    }
    if (!localException.checkGetFinish()) {
      this.hDB = localException.getInt();
    }
    if (!localException.checkGetFinish()) {
      this.hDC = localException.getLong();
    }
    if (!localException.checkGetFinish()) {
      this.hDD = localException.getLong();
    }
  }
  
  public void pq(int paramInt)
  {
    this.field_showHead = paramInt;
    this.hCv = true;
  }
  
  public void pr(int paramInt)
  {
    this.field_weiboFlag = paramInt;
    this.hCw = true;
  }
  
  public void ps(int paramInt)
  {
    this.field_verifyFlag = paramInt;
    this.hCA = true;
  }
  
  public void pt(int paramInt)
  {
    this.field_chatroomFlag = paramInt;
    this.hCC = true;
  }
  
  public void pu(int paramInt)
  {
    this.field_deleteFlag = paramInt;
    this.hCD = true;
  }
  
  public void pv(int paramInt)
  {
    this.hDc = paramInt;
    this.hqZ = true;
  }
  
  public void pw(int paramInt)
  {
    this.sex = paramInt;
    this.hqZ = true;
  }
  
  public void py(int paramInt)
  {
    this.showFlag = paramInt;
    this.hqZ = true;
  }
  
  public void pz(int paramInt)
  {
    this.hDg = paramInt;
    this.hqZ = true;
  }
  
  public void setFromType(int paramInt)
  {
    this.fromType = paramInt;
    this.hqZ = true;
  }
  
  public void setNickname(String paramString)
  {
    this.field_nickname = paramString;
    this.hwB = true;
  }
  
  public void setSource(int paramInt)
  {
    this.source = paramInt;
    this.hqZ = true;
  }
  
  public void setType(int paramInt)
  {
    this.field_type = paramInt;
    this.__hadSettype = true;
  }
  
  public void setUin(int paramInt)
  {
    this.uin = paramInt;
    this.hqZ = true;
  }
  
  public void setUsername(String paramString)
  {
    this.field_username = paramString;
    this.__hadSetusername = true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.f.c.ax
 * JD-Core Version:    0.7.0.1
 */