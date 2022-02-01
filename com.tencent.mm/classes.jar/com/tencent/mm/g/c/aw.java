package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.ad;

public abstract class aw
  extends c
{
  public static final String[] INDEX_CREATE = { "CREATE INDEX IF NOT EXISTS deleteflag_index ON Contact(deleteFlag)" };
  private static final int eEC = "ticket".hashCode();
  private static final int eFp = "username".hashCode();
  private static final int eHl;
  private static final int eKP;
  private static final int eOR = "alias".hashCode();
  private static final int eOS = "conRemark".hashCode();
  private static final int eOT = "domainList".hashCode();
  private static final int eOU;
  private static final int eOV;
  private static final int eOW;
  private static final int eOX;
  private static final int eOY;
  private static final int eOZ;
  private static final int ePa;
  private static final int ePb;
  private static final int ePc;
  private static final int ePd;
  private static final int ePe;
  private static final int ePf;
  private static final int ePg;
  private static final int ePh;
  private static final int ePi;
  private static final int rowid_HASHCODE = "rowid".hashCode();
  private static final int type_HASHCODE;
  private boolean __hadSettype = false;
  private int dnh;
  public String dzn;
  private boolean eEA = false;
  private boolean eFm = false;
  private boolean eGP = false;
  private boolean eKL = false;
  private boolean eOA = false;
  private boolean eOB = false;
  private boolean eOC = false;
  private boolean eOD = false;
  private boolean eOE = false;
  private boolean eOF = false;
  private boolean eOG = false;
  private boolean eOH = false;
  private boolean eOI = false;
  private boolean eOJ = false;
  private boolean eOK = false;
  private boolean eOL = false;
  private boolean eOM = false;
  private boolean eON = false;
  private boolean eOO = false;
  private boolean eOP = false;
  private boolean eOQ = false;
  private boolean eOz = false;
  public String ePA;
  public int ePB;
  public int ePC;
  public String ePD;
  public String ePE;
  public String ePF;
  public String ePG;
  public String ePH;
  public String ePI;
  public String ePJ;
  public String ePK;
  private String ePL;
  public int ePM;
  public String ePN;
  public int ePO;
  public long ePP;
  public long ePQ;
  public int ePj;
  public int ePk;
  public String ePl;
  protected long ePm;
  protected String ePn;
  protected int ePo;
  public int ePp;
  protected String ePq;
  protected String ePr;
  public int ePs;
  public int ePt;
  private String ePu;
  private String ePv;
  public String ePw;
  protected int ePx;
  public String ePy;
  public String ePz;
  private int extFlag;
  private String field_alias;
  protected int field_chatroomFlag;
  public String field_conRemark;
  public String field_conRemarkPYFull;
  public String field_conRemarkPYShort;
  public String field_contactLabelIds;
  public int field_deleteFlag;
  public String field_descWordingId;
  public String field_domainList;
  public String field_encryptUsername;
  protected byte[] field_lvbuff;
  public String field_nickname;
  public String field_openImAppid;
  private String field_pyInitial;
  private String field_quanPin;
  public int field_showHead;
  public String field_sourceExtInfo;
  public String field_ticket;
  public int field_type;
  public String field_username;
  public int field_verifyFlag;
  public int field_weiboFlag;
  public String field_weiboNickname;
  public String signature;
  public int uin;
  
  static
  {
    eKP = "nickname".hashCode();
    eOU = "pyInitial".hashCode();
    eOV = "quanPin".hashCode();
    eOW = "showHead".hashCode();
    type_HASHCODE = "type".hashCode();
    eOX = "weiboFlag".hashCode();
    eOY = "weiboNickname".hashCode();
    eOZ = "conRemarkPYFull".hashCode();
    ePa = "conRemarkPYShort".hashCode();
    eHl = "lvbuff".hashCode();
    ePb = "verifyFlag".hashCode();
    ePc = "encryptUsername".hashCode();
    ePd = "chatroomFlag".hashCode();
    ePe = "deleteFlag".hashCode();
    ePf = "contactLabelIds".hashCode();
    ePg = "descWordingId".hashCode();
    ePh = "openImAppid".hashCode();
    ePi = "sourceExtInfo".hashCode();
  }
  
  public final String Hu()
  {
    return this.signature;
  }
  
  public void L(byte[] paramArrayOfByte)
  {
    this.field_lvbuff = paramArrayOfByte;
    this.eGP = true;
  }
  
  public String VA()
  {
    return this.field_alias;
  }
  
  public final String VB()
  {
    return this.field_conRemark;
  }
  
  public final String VC()
  {
    return this.field_nickname;
  }
  
  public String VD()
  {
    return this.field_pyInitial;
  }
  
  public String VE()
  {
    return this.field_quanPin;
  }
  
  public final String VF()
  {
    return this.field_encryptUsername;
  }
  
  public final String VG()
  {
    return this.field_descWordingId;
  }
  
  public final String VH()
  {
    return this.field_openImAppid;
  }
  
  public final int VI()
  {
    return this.ePk;
  }
  
  public final void VJ()
  {
    this.ePO = 1;
    this.eGP = true;
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
      if (eFp == k)
      {
        this.field_username = paramCursor.getString(i);
        this.eFm = true;
      }
      for (;;)
      {
        i += 1;
        break;
        if (eOR == k) {
          this.field_alias = paramCursor.getString(i);
        } else if (eOS == k) {
          this.field_conRemark = paramCursor.getString(i);
        } else if (eOT == k) {
          this.field_domainList = paramCursor.getString(i);
        } else if (eKP == k) {
          this.field_nickname = paramCursor.getString(i);
        } else if (eOU == k) {
          this.field_pyInitial = paramCursor.getString(i);
        } else if (eOV == k) {
          this.field_quanPin = paramCursor.getString(i);
        } else if (eOW == k) {
          this.field_showHead = paramCursor.getInt(i);
        } else if (type_HASHCODE == k) {
          this.field_type = paramCursor.getInt(i);
        } else if (eOX == k) {
          this.field_weiboFlag = paramCursor.getInt(i);
        } else if (eOY == k) {
          this.field_weiboNickname = paramCursor.getString(i);
        } else if (eOZ == k) {
          this.field_conRemarkPYFull = paramCursor.getString(i);
        } else if (ePa == k) {
          this.field_conRemarkPYShort = paramCursor.getString(i);
        } else if (eHl == k) {
          this.field_lvbuff = paramCursor.getBlob(i);
        } else if (ePb == k) {
          this.field_verifyFlag = paramCursor.getInt(i);
        } else if (ePc == k) {
          this.field_encryptUsername = paramCursor.getString(i);
        } else if (ePd == k) {
          this.field_chatroomFlag = paramCursor.getInt(i);
        } else if (ePe == k) {
          this.field_deleteFlag = paramCursor.getInt(i);
        } else if (ePf == k) {
          this.field_contactLabelIds = paramCursor.getString(i);
        } else if (ePg == k) {
          this.field_descWordingId = paramCursor.getString(i);
        } else if (ePh == k) {
          this.field_openImAppid = paramCursor.getString(i);
        } else if (ePi == k) {
          this.field_sourceExtInfo = paramCursor.getString(i);
        } else if (eEC == k) {
          this.field_ticket = paramCursor.getString(i);
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
      if (this.eGP)
      {
        localObject = new aa();
        ((aa)localObject).fkj();
        ((aa)localObject).aaw(this.ePj);
        ((aa)localObject).aaw(this.ePk);
        ((aa)localObject).aQp(this.ePl);
        ((aa)localObject).CV(this.ePm);
        ((aa)localObject).aaw(this.uin);
        ((aa)localObject).aQp(this.ePn);
        ((aa)localObject).aQp(this.dzn);
        ((aa)localObject).aaw(this.ePo);
        ((aa)localObject).aaw(this.ePp);
        ((aa)localObject).aQp(this.ePq);
        ((aa)localObject).aQp(this.ePr);
        ((aa)localObject).aaw(this.ePs);
        ((aa)localObject).aaw(this.ePt);
        ((aa)localObject).aQp(this.signature);
        ((aa)localObject).aQp(this.ePu);
        ((aa)localObject).aQp(this.ePv);
        ((aa)localObject).aQp(this.ePw);
        ((aa)localObject).aaw(this.ePx);
        ((aa)localObject).aaw(this.dnh);
        ((aa)localObject).aQp(this.ePy);
        ((aa)localObject).aaw(this.field_verifyFlag);
        ((aa)localObject).aQp(this.ePz);
        ((aa)localObject).aQp(this.ePA);
        ((aa)localObject).aaw(this.ePB);
        ((aa)localObject).aaw(this.ePC);
        ((aa)localObject).aQp(this.ePD);
        ((aa)localObject).aQp(this.ePE);
        ((aa)localObject).aQp(this.ePF);
        ((aa)localObject).aQp(this.ePG);
        ((aa)localObject).aQp(this.ePH);
        ((aa)localObject).aQp(this.ePI);
        ((aa)localObject).aQp(this.ePJ);
        ((aa)localObject).aQp(this.ePK);
        ((aa)localObject).aaw(this.extFlag);
        ((aa)localObject).aQp(this.ePL);
        ((aa)localObject).aaw(this.ePM);
        ((aa)localObject).aQp(this.ePN);
        ((aa)localObject).aaw(this.ePO);
        ((aa)localObject).CV(this.ePP);
        ((aa)localObject).CV(this.ePQ);
        this.field_lvbuff = ((aa)localObject).fkk();
      }
      Object localObject = new ContentValues();
      if (this.field_username == null) {
        this.field_username = "";
      }
      if (this.eFm) {
        ((ContentValues)localObject).put("username", this.field_username);
      }
      if (this.field_alias == null) {
        this.field_alias = "";
      }
      if (this.eOz) {
        ((ContentValues)localObject).put("alias", this.field_alias);
      }
      if (this.field_conRemark == null) {
        this.field_conRemark = "";
      }
      if (this.eOA) {
        ((ContentValues)localObject).put("conRemark", this.field_conRemark);
      }
      if (this.field_domainList == null) {
        this.field_domainList = "";
      }
      if (this.eOB) {
        ((ContentValues)localObject).put("domainList", this.field_domainList);
      }
      if (this.field_nickname == null) {
        this.field_nickname = "";
      }
      if (this.eKL) {
        ((ContentValues)localObject).put("nickname", this.field_nickname);
      }
      if (this.field_pyInitial == null) {
        this.field_pyInitial = "";
      }
      if (this.eOC) {
        ((ContentValues)localObject).put("pyInitial", this.field_pyInitial);
      }
      if (this.field_quanPin == null) {
        this.field_quanPin = "";
      }
      if (this.eOD) {
        ((ContentValues)localObject).put("quanPin", this.field_quanPin);
      }
      if (this.eOE) {
        ((ContentValues)localObject).put("showHead", Integer.valueOf(this.field_showHead));
      }
      if (this.__hadSettype) {
        ((ContentValues)localObject).put("type", Integer.valueOf(this.field_type));
      }
      if (this.eOF) {
        ((ContentValues)localObject).put("weiboFlag", Integer.valueOf(this.field_weiboFlag));
      }
      if (this.field_weiboNickname == null) {
        this.field_weiboNickname = "";
      }
      if (this.eOG) {
        ((ContentValues)localObject).put("weiboNickname", this.field_weiboNickname);
      }
      if (this.field_conRemarkPYFull == null) {
        this.field_conRemarkPYFull = "";
      }
      if (this.eOH) {
        ((ContentValues)localObject).put("conRemarkPYFull", this.field_conRemarkPYFull);
      }
      if (this.field_conRemarkPYShort == null) {
        this.field_conRemarkPYShort = "";
      }
      if (this.eOI) {
        ((ContentValues)localObject).put("conRemarkPYShort", this.field_conRemarkPYShort);
      }
      if (this.eGP) {
        ((ContentValues)localObject).put("lvbuff", this.field_lvbuff);
      }
      if (this.eOJ) {
        ((ContentValues)localObject).put("verifyFlag", Integer.valueOf(this.field_verifyFlag));
      }
      if (this.field_encryptUsername == null) {
        this.field_encryptUsername = "";
      }
      if (this.eOK) {
        ((ContentValues)localObject).put("encryptUsername", this.field_encryptUsername);
      }
      if (this.eOL) {
        ((ContentValues)localObject).put("chatroomFlag", Integer.valueOf(this.field_chatroomFlag));
      }
      if (this.eOM) {
        ((ContentValues)localObject).put("deleteFlag", Integer.valueOf(this.field_deleteFlag));
      }
      if (this.field_contactLabelIds == null) {
        this.field_contactLabelIds = "";
      }
      if (this.eON) {
        ((ContentValues)localObject).put("contactLabelIds", this.field_contactLabelIds);
      }
      if (this.field_descWordingId == null) {
        this.field_descWordingId = "";
      }
      if (this.eOO) {
        ((ContentValues)localObject).put("descWordingId", this.field_descWordingId);
      }
      if (this.eOP) {
        ((ContentValues)localObject).put("openImAppid", this.field_openImAppid);
      }
      if (this.eOQ) {
        ((ContentValues)localObject).put("sourceExtInfo", this.field_sourceExtInfo);
      }
      if (this.field_ticket == null) {
        this.field_ticket = "";
      }
      if (this.eEA) {
        ((ContentValues)localObject).put("ticket", this.field_ticket);
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
        ad.e("MicroMsg.SDK.BaseContact", "get value failed, %s", new Object[] { localException.getMessage() });
      }
    }
  }
  
  public String getCity()
  {
    return this.ePv;
  }
  
  public final int getFromType()
  {
    return this.ePx;
  }
  
  public String getProvince()
  {
    return this.ePu;
  }
  
  public int getSource()
  {
    return this.dnh;
  }
  
  public final String getUsername()
  {
    return this.field_username;
  }
  
  public void jZ(int paramInt)
  {
    this.field_showHead = paramInt;
    this.eOE = true;
  }
  
  public void ka(int paramInt)
  {
    this.field_weiboFlag = paramInt;
    this.eOF = true;
  }
  
  public void kb(int paramInt)
  {
    this.field_verifyFlag = paramInt;
    this.eOJ = true;
  }
  
  public void kc(int paramInt)
  {
    this.field_chatroomFlag = paramInt;
    this.eOL = true;
  }
  
  public void kd(int paramInt)
  {
    this.field_deleteFlag = paramInt;
    this.eOM = true;
  }
  
  public void ke(int paramInt)
  {
    this.ePj = paramInt;
    this.eGP = true;
  }
  
  public void kf(int paramInt)
  {
    this.ePk = paramInt;
    this.eGP = true;
  }
  
  public void kg(int paramInt)
  {
    this.ePo = paramInt;
    this.eGP = true;
  }
  
  public void kh(int paramInt)
  {
    this.ePp = paramInt;
    this.eGP = true;
  }
  
  public void ki(int paramInt)
  {
    this.ePs = paramInt;
    this.eGP = true;
  }
  
  public void kj(int paramInt)
  {
    this.ePt = paramInt;
    this.eGP = true;
  }
  
  public void kk(int paramInt)
  {
    this.ePB = paramInt;
    this.eGP = true;
  }
  
  public void kl(int paramInt)
  {
    this.ePC = paramInt;
    this.eGP = true;
  }
  
  public final void km(int paramInt)
  {
    this.extFlag = paramInt;
    this.eGP = true;
  }
  
  public final void kn(int paramInt)
  {
    this.ePM = paramInt;
    this.eGP = true;
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
      aa localaa = new aa();
      int i = localaa.cy(this.field_lvbuff);
      if (i != 0)
      {
        ad.e("MicroMsg.SDK.BaseContact", "parse LVBuffer error:".concat(String.valueOf(i)));
        return;
      }
    }
    catch (Exception localException)
    {
      ad.e("MicroMsg.SDK.BaseContact", "get value failed");
      return;
    }
    this.ePj = localException.getInt();
    this.ePk = localException.getInt();
    this.ePl = localException.getString();
    this.ePm = localException.getLong();
    this.uin = localException.getInt();
    this.ePn = localException.getString();
    this.dzn = localException.getString();
    this.ePo = localException.getInt();
    this.ePp = localException.getInt();
    this.ePq = localException.getString();
    this.ePr = localException.getString();
    this.ePs = localException.getInt();
    this.ePt = localException.getInt();
    this.signature = localException.getString();
    this.ePu = localException.getString();
    this.ePv = localException.getString();
    this.ePw = localException.getString();
    this.ePx = localException.getInt();
    this.dnh = localException.getInt();
    this.ePy = localException.getString();
    this.field_verifyFlag = localException.getInt();
    this.ePz = localException.getString();
    if (!localException.fki()) {
      this.ePA = localException.getString();
    }
    if (!localException.fki()) {
      this.ePB = localException.getInt();
    }
    if (!localException.fki()) {
      this.ePC = localException.getInt();
    }
    if (!localException.fki()) {
      this.ePD = localException.getString();
    }
    if (!localException.fki()) {
      this.ePE = localException.getString();
    }
    if (!localException.fki()) {
      this.ePF = localException.getString();
    }
    if (!localException.fki()) {
      this.ePG = localException.getString();
    }
    if (!localException.fki()) {
      this.ePH = localException.getString();
    }
    if (!localException.fki()) {
      this.ePI = localException.getString();
    }
    if (!localException.fki()) {
      this.ePJ = localException.getString();
    }
    if (!localException.fki()) {
      this.ePK = localException.getString();
    }
    if (!localException.fki()) {
      this.extFlag = localException.getInt();
    }
    if (!localException.fki()) {
      this.ePL = localException.getString();
    }
    if (!localException.fki()) {
      this.ePM = localException.getInt();
    }
    if (!localException.fki()) {
      this.ePN = localException.getString();
    }
    if (!localException.fki()) {
      this.ePO = localException.getInt();
    }
    if (!localException.fki()) {
      this.ePP = localException.getLong();
    }
    if (!localException.fki()) {
      this.ePQ = localException.getLong();
    }
  }
  
  public void qr(long paramLong)
  {
    this.ePm = paramLong;
    this.eGP = true;
  }
  
  public void qs(long paramLong)
  {
    this.ePP = paramLong;
    this.eGP = true;
  }
  
  public void qt(long paramLong)
  {
    this.ePQ = paramLong;
    this.eGP = true;
  }
  
  public void sQ(String paramString)
  {
    this.field_alias = paramString;
    this.eOz = true;
  }
  
  public void sR(String paramString)
  {
    this.field_conRemark = paramString;
    this.eOA = true;
  }
  
  public void sS(String paramString)
  {
    this.field_domainList = paramString;
    this.eOB = true;
  }
  
  public void sT(String paramString)
  {
    this.field_nickname = paramString;
    this.eKL = true;
  }
  
  public void sU(String paramString)
  {
    this.field_pyInitial = paramString;
    this.eOC = true;
  }
  
  public void sV(String paramString)
  {
    this.field_quanPin = paramString;
    this.eOD = true;
  }
  
  public void sW(String paramString)
  {
    this.field_weiboNickname = paramString;
    this.eOG = true;
  }
  
  public void sX(String paramString)
  {
    this.field_conRemarkPYFull = paramString;
    this.eOH = true;
  }
  
  public void sY(String paramString)
  {
    this.field_conRemarkPYShort = paramString;
    this.eOI = true;
  }
  
  public void sZ(String paramString)
  {
    this.field_encryptUsername = paramString;
    this.eOK = true;
  }
  
  public void setFromType(int paramInt)
  {
    this.ePx = paramInt;
    this.eGP = true;
  }
  
  public void setSource(int paramInt)
  {
    this.dnh = paramInt;
    this.eGP = true;
  }
  
  public void setType(int paramInt)
  {
    this.field_type = paramInt;
    this.__hadSettype = true;
  }
  
  public void setUin(int paramInt)
  {
    this.uin = paramInt;
    this.eGP = true;
  }
  
  public void setUsername(String paramString)
  {
    this.field_username = paramString;
    this.eFm = true;
  }
  
  public void ta(String paramString)
  {
    this.field_contactLabelIds = paramString;
    this.eON = true;
  }
  
  public final void tb(String paramString)
  {
    this.field_descWordingId = paramString;
    this.eOO = true;
  }
  
  public void tc(String paramString)
  {
    this.field_openImAppid = paramString;
    this.eOP = true;
  }
  
  public void td(String paramString)
  {
    this.field_sourceExtInfo = paramString;
    this.eOQ = true;
  }
  
  public void te(String paramString)
  {
    this.field_ticket = paramString;
    this.eEA = true;
  }
  
  public void tf(String paramString)
  {
    this.ePl = paramString;
    this.eGP = true;
  }
  
  public void tg(String paramString)
  {
    this.ePn = paramString;
    this.eGP = true;
  }
  
  public void th(String paramString)
  {
    this.dzn = paramString;
    this.eGP = true;
  }
  
  public void ti(String paramString)
  {
    this.ePq = paramString;
    this.eGP = true;
  }
  
  public void tj(String paramString)
  {
    this.ePr = paramString;
    this.eGP = true;
  }
  
  public void tk(String paramString)
  {
    this.signature = paramString;
    this.eGP = true;
  }
  
  public void tl(String paramString)
  {
    this.ePu = paramString;
    this.eGP = true;
  }
  
  public void tm(String paramString)
  {
    this.ePv = paramString;
    this.eGP = true;
  }
  
  public void tn(String paramString)
  {
    this.ePw = paramString;
    this.eGP = true;
  }
  
  public void to(String paramString)
  {
    this.ePy = paramString;
    this.eGP = true;
  }
  
  public void tp(String paramString)
  {
    this.ePz = paramString;
    this.eGP = true;
  }
  
  public void tq(String paramString)
  {
    this.ePA = paramString;
    this.eGP = true;
  }
  
  public void tr(String paramString)
  {
    this.ePD = paramString;
    this.eGP = true;
  }
  
  public void ts(String paramString)
  {
    this.ePE = paramString;
    this.eGP = true;
  }
  
  public void tt(String paramString)
  {
    this.ePF = paramString;
    this.eGP = true;
  }
  
  public void tu(String paramString)
  {
    this.ePG = paramString;
    this.eGP = true;
  }
  
  public void tv(String paramString)
  {
    this.ePH = paramString;
    this.eGP = true;
  }
  
  public void tw(String paramString)
  {
    this.ePI = paramString;
    this.eGP = true;
  }
  
  public void tx(String paramString)
  {
    this.ePJ = paramString;
    this.eGP = true;
  }
  
  public void ty(String paramString)
  {
    this.ePK = paramString;
    this.eGP = true;
  }
  
  public final void tz(String paramString)
  {
    this.ePN = paramString;
    this.eGP = true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.g.c.aw
 * JD-Core Version:    0.7.0.1
 */