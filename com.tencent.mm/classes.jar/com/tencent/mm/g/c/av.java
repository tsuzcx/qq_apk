package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.z;

public abstract class av
  extends c
{
  public static final String[] INDEX_CREATE = { "CREATE INDEX IF NOT EXISTS deleteflag_index ON Contact(deleteFlag)" };
  private static final int enw = "ticket".hashCode();
  private static final int eok = "username".hashCode();
  private static final int eqc;
  private static final int etG;
  private static final int exA;
  private static final int exB;
  private static final int exC;
  private static final int exD;
  private static final int exE;
  private static final int exF;
  private static final int exG;
  private static final int exH;
  private static final int exI;
  private static final int exJ;
  private static final int exs = "alias".hashCode();
  private static final int ext = "conRemark".hashCode();
  private static final int exu = "domainList".hashCode();
  private static final int exv;
  private static final int exw;
  private static final int exx;
  private static final int exy;
  private static final int exz;
  private static final int rowid_HASHCODE = "rowid".hashCode();
  private static final int type_HASHCODE;
  private boolean __hadSettype = false;
  private int dbL;
  public String dnz;
  private boolean enu = false;
  private boolean eoh = false;
  private boolean epG = false;
  private boolean etC = false;
  public int exK;
  public int exL;
  public String exM;
  protected long exN;
  protected String exO;
  protected int exP;
  public int exQ;
  protected String exR;
  protected String exS;
  public int exT;
  public int exU;
  private String exV;
  private String exW;
  public String exX;
  protected int exY;
  public String exZ;
  private boolean exa = false;
  private boolean exb = false;
  private boolean exc = false;
  private boolean exd = false;
  private boolean exe = false;
  private boolean exf = false;
  private boolean exg = false;
  private boolean exh = false;
  private boolean exi = false;
  private boolean exj = false;
  private boolean exk = false;
  private boolean exl = false;
  private boolean exm = false;
  private boolean exn = false;
  private boolean exo = false;
  private boolean exp = false;
  private boolean exq = false;
  private boolean exr = false;
  private int extFlag;
  public String eya;
  public String eyb;
  public int eyc;
  public int eyd;
  public String eyf;
  public String eyg;
  public String eyh;
  public String eyi;
  public String eyj;
  public String eyk;
  public String eyl;
  public String eym;
  private String eyn;
  public int eyo;
  public String eyp;
  public int eyq;
  public long eyr;
  public long eys;
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
    etG = "nickname".hashCode();
    exv = "pyInitial".hashCode();
    exw = "quanPin".hashCode();
    exx = "showHead".hashCode();
    type_HASHCODE = "type".hashCode();
    exy = "weiboFlag".hashCode();
    exz = "weiboNickname".hashCode();
    exA = "conRemarkPYFull".hashCode();
    exB = "conRemarkPYShort".hashCode();
    eqc = "lvbuff".hashCode();
    exC = "verifyFlag".hashCode();
    exD = "encryptUsername".hashCode();
    exE = "chatroomFlag".hashCode();
    exF = "deleteFlag".hashCode();
    exG = "contactLabelIds".hashCode();
    exH = "descWordingId".hashCode();
    exI = "openImAppid".hashCode();
    exJ = "sourceExtInfo".hashCode();
  }
  
  public final String FZ()
  {
    return this.signature;
  }
  
  public void M(byte[] paramArrayOfByte)
  {
    this.field_lvbuff = paramArrayOfByte;
    this.epG = true;
  }
  
  public String Tl()
  {
    return this.field_alias;
  }
  
  public final String Tm()
  {
    return this.field_conRemark;
  }
  
  public final String Tn()
  {
    return this.field_nickname;
  }
  
  public String To()
  {
    return this.field_pyInitial;
  }
  
  public String Tp()
  {
    return this.field_quanPin;
  }
  
  public final String Tq()
  {
    return this.field_encryptUsername;
  }
  
  public final String Tr()
  {
    return this.field_descWordingId;
  }
  
  public final String Ts()
  {
    return this.field_openImAppid;
  }
  
  public final int Tt()
  {
    return this.exL;
  }
  
  public final void Tu()
  {
    this.eyq = 1;
    this.epG = true;
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
      if (eok == k)
      {
        this.field_username = paramCursor.getString(i);
        this.eoh = true;
      }
      for (;;)
      {
        i += 1;
        break;
        if (exs == k) {
          this.field_alias = paramCursor.getString(i);
        } else if (ext == k) {
          this.field_conRemark = paramCursor.getString(i);
        } else if (exu == k) {
          this.field_domainList = paramCursor.getString(i);
        } else if (etG == k) {
          this.field_nickname = paramCursor.getString(i);
        } else if (exv == k) {
          this.field_pyInitial = paramCursor.getString(i);
        } else if (exw == k) {
          this.field_quanPin = paramCursor.getString(i);
        } else if (exx == k) {
          this.field_showHead = paramCursor.getInt(i);
        } else if (type_HASHCODE == k) {
          this.field_type = paramCursor.getInt(i);
        } else if (exy == k) {
          this.field_weiboFlag = paramCursor.getInt(i);
        } else if (exz == k) {
          this.field_weiboNickname = paramCursor.getString(i);
        } else if (exA == k) {
          this.field_conRemarkPYFull = paramCursor.getString(i);
        } else if (exB == k) {
          this.field_conRemarkPYShort = paramCursor.getString(i);
        } else if (eqc == k) {
          this.field_lvbuff = paramCursor.getBlob(i);
        } else if (exC == k) {
          this.field_verifyFlag = paramCursor.getInt(i);
        } else if (exD == k) {
          this.field_encryptUsername = paramCursor.getString(i);
        } else if (exE == k) {
          this.field_chatroomFlag = paramCursor.getInt(i);
        } else if (exF == k) {
          this.field_deleteFlag = paramCursor.getInt(i);
        } else if (exG == k) {
          this.field_contactLabelIds = paramCursor.getString(i);
        } else if (exH == k) {
          this.field_descWordingId = paramCursor.getString(i);
        } else if (exI == k) {
          this.field_openImAppid = paramCursor.getString(i);
        } else if (exJ == k) {
          this.field_sourceExtInfo = paramCursor.getString(i);
        } else if (enw == k) {
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
      if (this.epG)
      {
        localObject = new z();
        ((z)localObject).eUF();
        ((z)localObject).Yr(this.exK);
        ((z)localObject).Yr(this.exL);
        ((z)localObject).aKJ(this.exM);
        ((z)localObject).Af(this.exN);
        ((z)localObject).Yr(this.uin);
        ((z)localObject).aKJ(this.exO);
        ((z)localObject).aKJ(this.dnz);
        ((z)localObject).Yr(this.exP);
        ((z)localObject).Yr(this.exQ);
        ((z)localObject).aKJ(this.exR);
        ((z)localObject).aKJ(this.exS);
        ((z)localObject).Yr(this.exT);
        ((z)localObject).Yr(this.exU);
        ((z)localObject).aKJ(this.signature);
        ((z)localObject).aKJ(this.exV);
        ((z)localObject).aKJ(this.exW);
        ((z)localObject).aKJ(this.exX);
        ((z)localObject).Yr(this.exY);
        ((z)localObject).Yr(this.dbL);
        ((z)localObject).aKJ(this.exZ);
        ((z)localObject).Yr(this.field_verifyFlag);
        ((z)localObject).aKJ(this.eya);
        ((z)localObject).aKJ(this.eyb);
        ((z)localObject).Yr(this.eyc);
        ((z)localObject).Yr(this.eyd);
        ((z)localObject).aKJ(this.eyf);
        ((z)localObject).aKJ(this.eyg);
        ((z)localObject).aKJ(this.eyh);
        ((z)localObject).aKJ(this.eyi);
        ((z)localObject).aKJ(this.eyj);
        ((z)localObject).aKJ(this.eyk);
        ((z)localObject).aKJ(this.eyl);
        ((z)localObject).aKJ(this.eym);
        ((z)localObject).Yr(this.extFlag);
        ((z)localObject).aKJ(this.eyn);
        ((z)localObject).Yr(this.eyo);
        ((z)localObject).aKJ(this.eyp);
        ((z)localObject).Yr(this.eyq);
        ((z)localObject).Af(this.eyr);
        ((z)localObject).Af(this.eys);
        this.field_lvbuff = ((z)localObject).eUG();
      }
      Object localObject = new ContentValues();
      if (this.field_username == null) {
        this.field_username = "";
      }
      if (this.eoh) {
        ((ContentValues)localObject).put("username", this.field_username);
      }
      if (this.field_alias == null) {
        this.field_alias = "";
      }
      if (this.exa) {
        ((ContentValues)localObject).put("alias", this.field_alias);
      }
      if (this.field_conRemark == null) {
        this.field_conRemark = "";
      }
      if (this.exb) {
        ((ContentValues)localObject).put("conRemark", this.field_conRemark);
      }
      if (this.field_domainList == null) {
        this.field_domainList = "";
      }
      if (this.exc) {
        ((ContentValues)localObject).put("domainList", this.field_domainList);
      }
      if (this.field_nickname == null) {
        this.field_nickname = "";
      }
      if (this.etC) {
        ((ContentValues)localObject).put("nickname", this.field_nickname);
      }
      if (this.field_pyInitial == null) {
        this.field_pyInitial = "";
      }
      if (this.exd) {
        ((ContentValues)localObject).put("pyInitial", this.field_pyInitial);
      }
      if (this.field_quanPin == null) {
        this.field_quanPin = "";
      }
      if (this.exe) {
        ((ContentValues)localObject).put("quanPin", this.field_quanPin);
      }
      if (this.exf) {
        ((ContentValues)localObject).put("showHead", Integer.valueOf(this.field_showHead));
      }
      if (this.__hadSettype) {
        ((ContentValues)localObject).put("type", Integer.valueOf(this.field_type));
      }
      if (this.exg) {
        ((ContentValues)localObject).put("weiboFlag", Integer.valueOf(this.field_weiboFlag));
      }
      if (this.field_weiboNickname == null) {
        this.field_weiboNickname = "";
      }
      if (this.exh) {
        ((ContentValues)localObject).put("weiboNickname", this.field_weiboNickname);
      }
      if (this.field_conRemarkPYFull == null) {
        this.field_conRemarkPYFull = "";
      }
      if (this.exi) {
        ((ContentValues)localObject).put("conRemarkPYFull", this.field_conRemarkPYFull);
      }
      if (this.field_conRemarkPYShort == null) {
        this.field_conRemarkPYShort = "";
      }
      if (this.exj) {
        ((ContentValues)localObject).put("conRemarkPYShort", this.field_conRemarkPYShort);
      }
      if (this.epG) {
        ((ContentValues)localObject).put("lvbuff", this.field_lvbuff);
      }
      if (this.exk) {
        ((ContentValues)localObject).put("verifyFlag", Integer.valueOf(this.field_verifyFlag));
      }
      if (this.field_encryptUsername == null) {
        this.field_encryptUsername = "";
      }
      if (this.exl) {
        ((ContentValues)localObject).put("encryptUsername", this.field_encryptUsername);
      }
      if (this.exm) {
        ((ContentValues)localObject).put("chatroomFlag", Integer.valueOf(this.field_chatroomFlag));
      }
      if (this.exn) {
        ((ContentValues)localObject).put("deleteFlag", Integer.valueOf(this.field_deleteFlag));
      }
      if (this.field_contactLabelIds == null) {
        this.field_contactLabelIds = "";
      }
      if (this.exo) {
        ((ContentValues)localObject).put("contactLabelIds", this.field_contactLabelIds);
      }
      if (this.field_descWordingId == null) {
        this.field_descWordingId = "";
      }
      if (this.exp) {
        ((ContentValues)localObject).put("descWordingId", this.field_descWordingId);
      }
      if (this.exq) {
        ((ContentValues)localObject).put("openImAppid", this.field_openImAppid);
      }
      if (this.exr) {
        ((ContentValues)localObject).put("sourceExtInfo", this.field_sourceExtInfo);
      }
      if (this.field_ticket == null) {
        this.field_ticket = "";
      }
      if (this.enu) {
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
        ac.e("MicroMsg.SDK.BaseContact", "get value failed, %s", new Object[] { localException.getMessage() });
      }
    }
  }
  
  public String getCity()
  {
    return this.exW;
  }
  
  public String getProvince()
  {
    return this.exV;
  }
  
  public int getSource()
  {
    return this.dbL;
  }
  
  public final String getUsername()
  {
    return this.field_username;
  }
  
  public void jB(int paramInt)
  {
    this.field_showHead = paramInt;
    this.exf = true;
  }
  
  public void jC(int paramInt)
  {
    this.field_weiboFlag = paramInt;
    this.exg = true;
  }
  
  public void jD(int paramInt)
  {
    this.field_verifyFlag = paramInt;
    this.exk = true;
  }
  
  public void jE(int paramInt)
  {
    this.field_chatroomFlag = paramInt;
    this.exm = true;
  }
  
  public void jF(int paramInt)
  {
    this.field_deleteFlag = paramInt;
    this.exn = true;
  }
  
  public void jG(int paramInt)
  {
    this.exK = paramInt;
    this.epG = true;
  }
  
  public void jH(int paramInt)
  {
    this.exL = paramInt;
    this.epG = true;
  }
  
  public void jI(int paramInt)
  {
    this.exP = paramInt;
    this.epG = true;
  }
  
  public void jJ(int paramInt)
  {
    this.exQ = paramInt;
    this.epG = true;
  }
  
  public void jK(int paramInt)
  {
    this.exT = paramInt;
    this.epG = true;
  }
  
  public void jL(int paramInt)
  {
    this.exU = paramInt;
    this.epG = true;
  }
  
  public void jM(int paramInt)
  {
    this.eyc = paramInt;
    this.epG = true;
  }
  
  public void jN(int paramInt)
  {
    this.eyd = paramInt;
    this.epG = true;
  }
  
  public final void jO(int paramInt)
  {
    this.extFlag = paramInt;
    this.epG = true;
  }
  
  public final void jP(int paramInt)
  {
    this.eyo = paramInt;
    this.epG = true;
  }
  
  public void or(long paramLong)
  {
    this.exN = paramLong;
    this.epG = true;
  }
  
  public void os(long paramLong)
  {
    this.eyr = paramLong;
    this.epG = true;
  }
  
  public void ot(long paramLong)
  {
    this.eys = paramLong;
    this.epG = true;
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
      z localz = new z();
      int i = localz.cr(this.field_lvbuff);
      if (i != 0)
      {
        ac.e("MicroMsg.SDK.BaseContact", "parse LVBuffer error:".concat(String.valueOf(i)));
        return;
      }
    }
    catch (Exception localException)
    {
      ac.e("MicroMsg.SDK.BaseContact", "get value failed");
      return;
    }
    this.exK = localException.getInt();
    this.exL = localException.getInt();
    this.exM = localException.getString();
    this.exN = localException.getLong();
    this.uin = localException.getInt();
    this.exO = localException.getString();
    this.dnz = localException.getString();
    this.exP = localException.getInt();
    this.exQ = localException.getInt();
    this.exR = localException.getString();
    this.exS = localException.getString();
    this.exT = localException.getInt();
    this.exU = localException.getInt();
    this.signature = localException.getString();
    this.exV = localException.getString();
    this.exW = localException.getString();
    this.exX = localException.getString();
    this.exY = localException.getInt();
    this.dbL = localException.getInt();
    this.exZ = localException.getString();
    this.field_verifyFlag = localException.getInt();
    this.eya = localException.getString();
    if (!localException.eUE()) {
      this.eyb = localException.getString();
    }
    if (!localException.eUE()) {
      this.eyc = localException.getInt();
    }
    if (!localException.eUE()) {
      this.eyd = localException.getInt();
    }
    if (!localException.eUE()) {
      this.eyf = localException.getString();
    }
    if (!localException.eUE()) {
      this.eyg = localException.getString();
    }
    if (!localException.eUE()) {
      this.eyh = localException.getString();
    }
    if (!localException.eUE()) {
      this.eyi = localException.getString();
    }
    if (!localException.eUE()) {
      this.eyj = localException.getString();
    }
    if (!localException.eUE()) {
      this.eyk = localException.getString();
    }
    if (!localException.eUE()) {
      this.eyl = localException.getString();
    }
    if (!localException.eUE()) {
      this.eym = localException.getString();
    }
    if (!localException.eUE()) {
      this.extFlag = localException.getInt();
    }
    if (!localException.eUE()) {
      this.eyn = localException.getString();
    }
    if (!localException.eUE()) {
      this.eyo = localException.getInt();
    }
    if (!localException.eUE()) {
      this.eyp = localException.getString();
    }
    if (!localException.eUE()) {
      this.eyq = localException.getInt();
    }
    if (!localException.eUE()) {
      this.eyr = localException.getLong();
    }
    if (!localException.eUE()) {
      this.eys = localException.getLong();
    }
  }
  
  public void qA(String paramString)
  {
    this.signature = paramString;
    this.epG = true;
  }
  
  public void qB(String paramString)
  {
    this.exV = paramString;
    this.epG = true;
  }
  
  public void qC(String paramString)
  {
    this.exW = paramString;
    this.epG = true;
  }
  
  public void qD(String paramString)
  {
    this.exX = paramString;
    this.epG = true;
  }
  
  public void qE(String paramString)
  {
    this.exZ = paramString;
    this.epG = true;
  }
  
  public void qF(String paramString)
  {
    this.eya = paramString;
    this.epG = true;
  }
  
  public void qG(String paramString)
  {
    this.eyb = paramString;
    this.epG = true;
  }
  
  public void qH(String paramString)
  {
    this.eyf = paramString;
    this.epG = true;
  }
  
  public void qI(String paramString)
  {
    this.eyg = paramString;
    this.epG = true;
  }
  
  public void qJ(String paramString)
  {
    this.eyh = paramString;
    this.epG = true;
  }
  
  public void qK(String paramString)
  {
    this.eyi = paramString;
    this.epG = true;
  }
  
  public void qL(String paramString)
  {
    this.eyj = paramString;
    this.epG = true;
  }
  
  public void qM(String paramString)
  {
    this.eyk = paramString;
    this.epG = true;
  }
  
  public void qN(String paramString)
  {
    this.eyl = paramString;
    this.epG = true;
  }
  
  public void qO(String paramString)
  {
    this.eym = paramString;
    this.epG = true;
  }
  
  public final void qP(String paramString)
  {
    this.eyp = paramString;
    this.epG = true;
  }
  
  public void qg(String paramString)
  {
    this.field_alias = paramString;
    this.exa = true;
  }
  
  public void qh(String paramString)
  {
    this.field_conRemark = paramString;
    this.exb = true;
  }
  
  public void qi(String paramString)
  {
    this.field_domainList = paramString;
    this.exc = true;
  }
  
  public void qj(String paramString)
  {
    this.field_nickname = paramString;
    this.etC = true;
  }
  
  public void qk(String paramString)
  {
    this.field_pyInitial = paramString;
    this.exd = true;
  }
  
  public void ql(String paramString)
  {
    this.field_quanPin = paramString;
    this.exe = true;
  }
  
  public void qm(String paramString)
  {
    this.field_weiboNickname = paramString;
    this.exh = true;
  }
  
  public void qn(String paramString)
  {
    this.field_conRemarkPYFull = paramString;
    this.exi = true;
  }
  
  public void qo(String paramString)
  {
    this.field_conRemarkPYShort = paramString;
    this.exj = true;
  }
  
  public void qp(String paramString)
  {
    this.field_encryptUsername = paramString;
    this.exl = true;
  }
  
  public void qq(String paramString)
  {
    this.field_contactLabelIds = paramString;
    this.exo = true;
  }
  
  public final void qr(String paramString)
  {
    this.field_descWordingId = paramString;
    this.exp = true;
  }
  
  public void qs(String paramString)
  {
    this.field_openImAppid = paramString;
    this.exq = true;
  }
  
  public void qt(String paramString)
  {
    this.field_sourceExtInfo = paramString;
    this.exr = true;
  }
  
  public void qu(String paramString)
  {
    this.field_ticket = paramString;
    this.enu = true;
  }
  
  public void qv(String paramString)
  {
    this.exM = paramString;
    this.epG = true;
  }
  
  public void qw(String paramString)
  {
    this.exO = paramString;
    this.epG = true;
  }
  
  public void qx(String paramString)
  {
    this.dnz = paramString;
    this.epG = true;
  }
  
  public void qy(String paramString)
  {
    this.exR = paramString;
    this.epG = true;
  }
  
  public void qz(String paramString)
  {
    this.exS = paramString;
    this.epG = true;
  }
  
  public void setFromType(int paramInt)
  {
    this.exY = paramInt;
    this.epG = true;
  }
  
  public void setSource(int paramInt)
  {
    this.dbL = paramInt;
    this.epG = true;
  }
  
  public void setType(int paramInt)
  {
    this.field_type = paramInt;
    this.__hadSettype = true;
  }
  
  public void setUin(int paramInt)
  {
    this.uin = paramInt;
    this.epG = true;
  }
  
  public void setUsername(String paramString)
  {
    this.field_username = paramString;
    this.eoh = true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.g.c.av
 * JD-Core Version:    0.7.0.1
 */