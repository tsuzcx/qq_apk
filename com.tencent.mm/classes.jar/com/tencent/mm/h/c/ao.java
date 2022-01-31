package com.tencent.mm.h.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.sdk.platformtools.y;

public abstract class ao
  extends c
{
  private static final int cBZ;
  private static final int cCa;
  private static final int cCb;
  private static final int cCc;
  private static final int cCd;
  private static final int cCe;
  private static final int cCf;
  private static final int cCg;
  private static final int cCh;
  private static final int cCi;
  private static final int cCj = "verifyFlag".hashCode();
  private static final int cCk = "encryptUsername".hashCode();
  private static final int cCl = "chatroomFlag".hashCode();
  private static final int cCm = "deleteFlag".hashCode();
  private static final int cCn = "contactLabelIds".hashCode();
  private static final int cCo = "descWordingId".hashCode();
  private static final int cCp = "openImAppid".hashCode();
  public static final String[] cqY = { "CREATE INDEX IF NOT EXISTS deleteflag_index ON Contact(deleteFlag)" };
  private static final int crh = "rowid".hashCode();
  private static final int csy;
  private static final int ctF = "username".hashCode();
  private static final int cvp;
  private static final int cyS;
  public String bSe;
  private boolean cBI = false;
  private boolean cBJ = false;
  private boolean cBK = false;
  private boolean cBL = false;
  private boolean cBM = false;
  private boolean cBN = false;
  private boolean cBO = false;
  private boolean cBP = false;
  private boolean cBQ = false;
  private boolean cBR = false;
  private boolean cBS = false;
  private boolean cBT = false;
  private boolean cBU = false;
  private boolean cBV = false;
  private boolean cBW = false;
  private boolean cBX = false;
  private boolean cBY = false;
  private String cCA;
  private String cCB;
  public String cCC;
  public int cCD;
  public String cCE;
  public String cCF;
  public String cCG;
  public int cCH;
  public int cCI;
  public String cCJ;
  public String cCK;
  public String cCL;
  public String cCM;
  public String cCN;
  public String cCO;
  public String cCP;
  public String cCQ;
  private int cCR;
  private String cCS;
  public int cCT;
  public String cCU;
  public int cCq;
  public String cCr;
  public long cCs;
  public String cCt;
  public int cCu;
  public int cCv;
  public String cCw;
  public String cCx;
  public int cCy;
  public int cCz;
  private boolean csa = false;
  private boolean ctD = false;
  private boolean cuS = false;
  private boolean cyO = false;
  private String field_alias;
  public int field_chatroomFlag;
  public String field_conRemark;
  public String field_conRemarkPYFull;
  public String field_conRemarkPYShort;
  public String field_contactLabelIds;
  public int field_deleteFlag;
  public String field_descWordingId;
  public String field_domainList;
  public String field_encryptUsername;
  public byte[] field_lvbuff;
  public String field_nickname;
  public String field_openImAppid;
  private String field_pyInitial;
  private String field_quanPin;
  public int field_showHead;
  public int field_type;
  public String field_username;
  public int field_verifyFlag;
  public int field_weiboFlag;
  public String field_weiboNickname;
  public int sex;
  public String signature;
  private int source;
  public int uin;
  
  static
  {
    cBZ = "alias".hashCode();
    cCa = "conRemark".hashCode();
    cCb = "domainList".hashCode();
    cyS = "nickname".hashCode();
    cCc = "pyInitial".hashCode();
    cCd = "quanPin".hashCode();
    cCe = "showHead".hashCode();
    csy = "type".hashCode();
    cCf = "weiboFlag".hashCode();
    cCg = "weiboNickname".hashCode();
    cCh = "conRemarkPYFull".hashCode();
    cCi = "conRemarkPYShort".hashCode();
    cvp = "lvbuff".hashCode();
  }
  
  public void aZ(long paramLong)
  {
    this.cCs = paramLong;
    this.cuS = true;
  }
  
  public void cZ(String paramString)
  {
    this.field_alias = paramString;
    this.cBI = true;
  }
  
  public void d(Cursor paramCursor)
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
      if (ctF == k)
      {
        this.field_username = paramCursor.getString(i);
        this.ctD = true;
      }
      for (;;)
      {
        i += 1;
        break;
        if (cBZ == k) {
          this.field_alias = paramCursor.getString(i);
        } else if (cCa == k) {
          this.field_conRemark = paramCursor.getString(i);
        } else if (cCb == k) {
          this.field_domainList = paramCursor.getString(i);
        } else if (cyS == k) {
          this.field_nickname = paramCursor.getString(i);
        } else if (cCc == k) {
          this.field_pyInitial = paramCursor.getString(i);
        } else if (cCd == k) {
          this.field_quanPin = paramCursor.getString(i);
        } else if (cCe == k) {
          this.field_showHead = paramCursor.getInt(i);
        } else if (csy == k) {
          this.field_type = paramCursor.getInt(i);
        } else if (cCf == k) {
          this.field_weiboFlag = paramCursor.getInt(i);
        } else if (cCg == k) {
          this.field_weiboNickname = paramCursor.getString(i);
        } else if (cCh == k) {
          this.field_conRemarkPYFull = paramCursor.getString(i);
        } else if (cCi == k) {
          this.field_conRemarkPYShort = paramCursor.getString(i);
        } else if (cvp == k) {
          this.field_lvbuff = paramCursor.getBlob(i);
        } else if (cCj == k) {
          this.field_verifyFlag = paramCursor.getInt(i);
        } else if (cCk == k) {
          this.field_encryptUsername = paramCursor.getString(i);
        } else if (cCl == k) {
          this.field_chatroomFlag = paramCursor.getInt(i);
        } else if (cCm == k) {
          this.field_deleteFlag = paramCursor.getInt(i);
        } else if (cCn == k) {
          this.field_contactLabelIds = paramCursor.getString(i);
        } else if (cCo == k) {
          this.field_descWordingId = paramCursor.getString(i);
        } else if (cCp == k) {
          this.field_openImAppid = paramCursor.getString(i);
        } else if (crh == k) {
          this.ujK = paramCursor.getLong(i);
        }
      }
    }
    vq();
  }
  
  public void dA(String paramString)
  {
    this.cCA = paramString;
    this.cuS = true;
  }
  
  public void dB(String paramString)
  {
    this.cCB = paramString;
    this.cuS = true;
  }
  
  public void dC(String paramString)
  {
    this.cCC = paramString;
    this.cuS = true;
  }
  
  public void dD(String paramString)
  {
    this.cCE = paramString;
    this.cuS = true;
  }
  
  public void dE(String paramString)
  {
    this.cCF = paramString;
    this.cuS = true;
  }
  
  public void dF(String paramString)
  {
    this.cCG = paramString;
    this.cuS = true;
  }
  
  public void dG(String paramString)
  {
    this.cCJ = paramString;
    this.cuS = true;
  }
  
  public void dH(String paramString)
  {
    this.cCK = paramString;
    this.cuS = true;
  }
  
  public void dI(String paramString)
  {
    this.cCL = paramString;
    this.cuS = true;
  }
  
  public void dJ(String paramString)
  {
    this.cCM = paramString;
    this.cuS = true;
  }
  
  public void dK(String paramString)
  {
    this.cCN = paramString;
    this.cuS = true;
  }
  
  public void dL(String paramString)
  {
    this.cCO = paramString;
    this.cuS = true;
  }
  
  public void dM(String paramString)
  {
    this.cCP = paramString;
    this.cuS = true;
  }
  
  public void dN(String paramString)
  {
    this.cCQ = paramString;
    this.cuS = true;
  }
  
  public final void dO(String paramString)
  {
    this.cCU = paramString;
    this.cuS = true;
  }
  
  public void df(String paramString)
  {
    this.field_conRemark = paramString;
    this.cBJ = true;
  }
  
  public void dg(String paramString)
  {
    this.field_domainList = paramString;
    this.cBK = true;
  }
  
  public void dk(String paramString)
  {
    this.field_nickname = paramString;
    this.cyO = true;
  }
  
  public void dl(String paramString)
  {
    this.field_pyInitial = paramString;
    this.cBL = true;
  }
  
  public void dm(String paramString)
  {
    this.field_quanPin = paramString;
    this.cBM = true;
  }
  
  public void dn(String paramString)
  {
    this.field_weiboNickname = paramString;
    this.cBP = true;
  }
  
  public void jdMethod_do(String paramString)
  {
    this.field_conRemarkPYFull = paramString;
    this.cBQ = true;
  }
  
  public void dp(String paramString)
  {
    this.field_conRemarkPYShort = paramString;
    this.cBR = true;
  }
  
  public void dq(String paramString)
  {
    this.field_encryptUsername = paramString;
    this.cBT = true;
  }
  
  public void dr(String paramString)
  {
    this.field_contactLabelIds = paramString;
    this.cBW = true;
  }
  
  public final void ds(String paramString)
  {
    this.field_descWordingId = paramString;
    this.cBX = true;
  }
  
  public void dt(String paramString)
  {
    this.field_openImAppid = paramString;
    this.cBY = true;
  }
  
  public void du(String paramString)
  {
    this.cCr = paramString;
    this.cuS = true;
  }
  
  public void dv(String paramString)
  {
    this.cCt = paramString;
    this.cuS = true;
  }
  
  public void dw(String paramString)
  {
    this.bSe = paramString;
    this.cuS = true;
  }
  
  public void dx(String paramString)
  {
    this.cCw = paramString;
    this.cuS = true;
  }
  
  public void dy(String paramString)
  {
    this.cCx = paramString;
    this.cuS = true;
  }
  
  public void dz(String paramString)
  {
    this.signature = paramString;
    this.cuS = true;
  }
  
  public void fg(int paramInt)
  {
    this.field_showHead = paramInt;
    this.cBN = true;
  }
  
  public void fh(int paramInt)
  {
    this.field_weiboFlag = paramInt;
    this.cBO = true;
  }
  
  public void fi(int paramInt)
  {
    this.field_verifyFlag = paramInt;
    this.cBS = true;
  }
  
  public void fj(int paramInt)
  {
    this.field_chatroomFlag = paramInt;
    this.cBU = true;
  }
  
  public void fk(int paramInt)
  {
    this.field_deleteFlag = paramInt;
    this.cBV = true;
  }
  
  public void fl(int paramInt)
  {
    this.cCq = paramInt;
    this.cuS = true;
  }
  
  public void fm(int paramInt)
  {
    this.sex = paramInt;
    this.cuS = true;
  }
  
  public void fn(int paramInt)
  {
    this.uin = paramInt;
    this.cuS = true;
  }
  
  public void fo(int paramInt)
  {
    this.cCu = paramInt;
    this.cuS = true;
  }
  
  public void fp(int paramInt)
  {
    this.cCv = paramInt;
    this.cuS = true;
  }
  
  public void fq(int paramInt)
  {
    this.cCy = paramInt;
    this.cuS = true;
  }
  
  public void fr(int paramInt)
  {
    this.cCz = paramInt;
    this.cuS = true;
  }
  
  public void fs(int paramInt)
  {
    this.cCD = paramInt;
    this.cuS = true;
  }
  
  public void ft(int paramInt)
  {
    this.cCH = paramInt;
    this.cuS = true;
  }
  
  public void fu(int paramInt)
  {
    this.cCI = paramInt;
    this.cuS = true;
  }
  
  public final void fv(int paramInt)
  {
    this.cCR = paramInt;
    this.cuS = true;
  }
  
  public final void fw(int paramInt)
  {
    this.cCT = paramInt;
    this.cuS = true;
  }
  
  public String getCity()
  {
    return this.cCB;
  }
  
  public String getProvince()
  {
    return this.cCA;
  }
  
  public int getSource()
  {
    return this.source;
  }
  
  public final String getUsername()
  {
    return this.field_username;
  }
  
  public void setSource(int paramInt)
  {
    this.source = paramInt;
    this.cuS = true;
  }
  
  public void setType(int paramInt)
  {
    this.field_type = paramInt;
    this.csa = true;
  }
  
  public void setUsername(String paramString)
  {
    this.field_username = paramString;
    this.ctD = true;
  }
  
  public void v(byte[] paramArrayOfByte)
  {
    this.field_lvbuff = paramArrayOfByte;
    this.cuS = true;
  }
  
  public final ContentValues vf()
  {
    try
    {
      if (this.cuS)
      {
        localObject = new v();
        ((v)localObject).cqy();
        ((v)localObject).Fb(this.cCq);
        ((v)localObject).Fb(this.sex);
        ((v)localObject).Zg(this.cCr);
        ((v)localObject).ho(this.cCs);
        ((v)localObject).Fb(this.uin);
        ((v)localObject).Zg(this.cCt);
        ((v)localObject).Zg(this.bSe);
        ((v)localObject).Fb(this.cCu);
        ((v)localObject).Fb(this.cCv);
        ((v)localObject).Zg(this.cCw);
        ((v)localObject).Zg(this.cCx);
        ((v)localObject).Fb(this.cCy);
        ((v)localObject).Fb(this.cCz);
        ((v)localObject).Zg(this.signature);
        ((v)localObject).Zg(this.cCA);
        ((v)localObject).Zg(this.cCB);
        ((v)localObject).Zg(this.cCC);
        ((v)localObject).Fb(this.cCD);
        ((v)localObject).Fb(this.source);
        ((v)localObject).Zg(this.cCE);
        ((v)localObject).Fb(this.field_verifyFlag);
        ((v)localObject).Zg(this.cCF);
        ((v)localObject).Zg(this.cCG);
        ((v)localObject).Fb(this.cCH);
        ((v)localObject).Fb(this.cCI);
        ((v)localObject).Zg(this.cCJ);
        ((v)localObject).Zg(this.cCK);
        ((v)localObject).Zg(this.cCL);
        ((v)localObject).Zg(this.cCM);
        ((v)localObject).Zg(this.cCN);
        ((v)localObject).Zg(this.cCO);
        ((v)localObject).Zg(this.cCP);
        ((v)localObject).Zg(this.cCQ);
        ((v)localObject).Fb(this.cCR);
        ((v)localObject).Zg(this.cCS);
        ((v)localObject).Fb(this.cCT);
        ((v)localObject).Zg(this.cCU);
        this.field_lvbuff = ((v)localObject).cqz();
      }
      Object localObject = new ContentValues();
      if (this.field_username == null) {
        this.field_username = "";
      }
      if (this.ctD) {
        ((ContentValues)localObject).put("username", this.field_username);
      }
      if (this.field_alias == null) {
        this.field_alias = "";
      }
      if (this.cBI) {
        ((ContentValues)localObject).put("alias", this.field_alias);
      }
      if (this.field_conRemark == null) {
        this.field_conRemark = "";
      }
      if (this.cBJ) {
        ((ContentValues)localObject).put("conRemark", this.field_conRemark);
      }
      if (this.field_domainList == null) {
        this.field_domainList = "";
      }
      if (this.cBK) {
        ((ContentValues)localObject).put("domainList", this.field_domainList);
      }
      if (this.field_nickname == null) {
        this.field_nickname = "";
      }
      if (this.cyO) {
        ((ContentValues)localObject).put("nickname", this.field_nickname);
      }
      if (this.field_pyInitial == null) {
        this.field_pyInitial = "";
      }
      if (this.cBL) {
        ((ContentValues)localObject).put("pyInitial", this.field_pyInitial);
      }
      if (this.field_quanPin == null) {
        this.field_quanPin = "";
      }
      if (this.cBM) {
        ((ContentValues)localObject).put("quanPin", this.field_quanPin);
      }
      if (this.cBN) {
        ((ContentValues)localObject).put("showHead", Integer.valueOf(this.field_showHead));
      }
      if (this.csa) {
        ((ContentValues)localObject).put("type", Integer.valueOf(this.field_type));
      }
      if (this.cBO) {
        ((ContentValues)localObject).put("weiboFlag", Integer.valueOf(this.field_weiboFlag));
      }
      if (this.field_weiboNickname == null) {
        this.field_weiboNickname = "";
      }
      if (this.cBP) {
        ((ContentValues)localObject).put("weiboNickname", this.field_weiboNickname);
      }
      if (this.field_conRemarkPYFull == null) {
        this.field_conRemarkPYFull = "";
      }
      if (this.cBQ) {
        ((ContentValues)localObject).put("conRemarkPYFull", this.field_conRemarkPYFull);
      }
      if (this.field_conRemarkPYShort == null) {
        this.field_conRemarkPYShort = "";
      }
      if (this.cBR) {
        ((ContentValues)localObject).put("conRemarkPYShort", this.field_conRemarkPYShort);
      }
      if (this.cuS) {
        ((ContentValues)localObject).put("lvbuff", this.field_lvbuff);
      }
      if (this.cBS) {
        ((ContentValues)localObject).put("verifyFlag", Integer.valueOf(this.field_verifyFlag));
      }
      if (this.field_encryptUsername == null) {
        this.field_encryptUsername = "";
      }
      if (this.cBT) {
        ((ContentValues)localObject).put("encryptUsername", this.field_encryptUsername);
      }
      if (this.cBU) {
        ((ContentValues)localObject).put("chatroomFlag", Integer.valueOf(this.field_chatroomFlag));
      }
      if (this.cBV) {
        ((ContentValues)localObject).put("deleteFlag", Integer.valueOf(this.field_deleteFlag));
      }
      if (this.field_contactLabelIds == null) {
        this.field_contactLabelIds = "";
      }
      if (this.cBW) {
        ((ContentValues)localObject).put("contactLabelIds", this.field_contactLabelIds);
      }
      if (this.field_descWordingId == null) {
        this.field_descWordingId = "";
      }
      if (this.cBX) {
        ((ContentValues)localObject).put("descWordingId", this.field_descWordingId);
      }
      if (this.cBY) {
        ((ContentValues)localObject).put("openImAppid", this.field_openImAppid);
      }
      if (this.ujK > 0L) {
        ((ContentValues)localObject).put("rowid", Long.valueOf(this.ujK));
      }
      return localObject;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        y.e("MicroMsg.SDK.BaseContact", "get value failed, %s", new Object[] { localException.getMessage() });
      }
    }
  }
  
  public String vk()
  {
    return this.field_alias;
  }
  
  public final String vl()
  {
    return this.field_conRemark;
  }
  
  public final String vm()
  {
    return this.field_nickname;
  }
  
  public String vn()
  {
    return this.field_pyInitial;
  }
  
  public String vo()
  {
    return this.field_quanPin;
  }
  
  public final String vp()
  {
    return this.field_encryptUsername;
  }
  
  public final void vq()
  {
    try
    {
      if (this.field_lvbuff == null) {
        return;
      }
      if (this.field_lvbuff.length == 0) {
        return;
      }
      v localv = new v();
      int i = localv.bA(this.field_lvbuff);
      if (i != 0)
      {
        y.e("MicroMsg.SDK.BaseContact", "parse LVBuffer error:" + i);
        return;
      }
    }
    catch (Exception localException)
    {
      y.e("MicroMsg.SDK.BaseContact", "get value failed");
      return;
    }
    this.cCq = localException.getInt();
    this.sex = localException.getInt();
    this.cCr = localException.getString();
    this.cCs = localException.getLong();
    this.uin = localException.getInt();
    this.cCt = localException.getString();
    this.bSe = localException.getString();
    this.cCu = localException.getInt();
    this.cCv = localException.getInt();
    this.cCw = localException.getString();
    this.cCx = localException.getString();
    this.cCy = localException.getInt();
    this.cCz = localException.getInt();
    this.signature = localException.getString();
    this.cCA = localException.getString();
    this.cCB = localException.getString();
    this.cCC = localException.getString();
    this.cCD = localException.getInt();
    this.source = localException.getInt();
    this.cCE = localException.getString();
    this.field_verifyFlag = localException.getInt();
    this.cCF = localException.getString();
    if (!localException.cqx()) {
      this.cCG = localException.getString();
    }
    if (!localException.cqx()) {
      this.cCH = localException.getInt();
    }
    if (!localException.cqx()) {
      this.cCI = localException.getInt();
    }
    if (!localException.cqx()) {
      this.cCJ = localException.getString();
    }
    if (!localException.cqx()) {
      this.cCK = localException.getString();
    }
    if (!localException.cqx()) {
      this.cCL = localException.getString();
    }
    if (!localException.cqx()) {
      this.cCM = localException.getString();
    }
    if (!localException.cqx()) {
      this.cCN = localException.getString();
    }
    if (!localException.cqx()) {
      this.cCO = localException.getString();
    }
    if (!localException.cqx()) {
      this.cCP = localException.getString();
    }
    if (!localException.cqx()) {
      this.cCQ = localException.getString();
    }
    if (!localException.cqx()) {
      this.cCR = localException.getInt();
    }
    if (!localException.cqx()) {
      this.cCS = localException.getString();
    }
    if (!localException.cqx()) {
      this.cCT = localException.getInt();
    }
    if (!localException.cqx()) {
      this.cCU = localException.getString();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.h.c.ao
 * JD-Core Version:    0.7.0.1
 */