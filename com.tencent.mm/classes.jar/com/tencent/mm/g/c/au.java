package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.ad;

public abstract class au
  extends c
{
  public static final String[] INDEX_CREATE = { "CREATE INDEX IF NOT EXISTS deleteflag_index ON Contact(deleteFlag)" };
  private static final int elr = "ticket".hashCode();
  private static final int eme = "username".hashCode();
  private static final int enX;
  private static final int erC;
  private static final int euW = "alias".hashCode();
  private static final int euX = "conRemark".hashCode();
  private static final int euY = "domainList".hashCode();
  private static final int euZ;
  private static final int eva;
  private static final int evb;
  private static final int evc;
  private static final int evd;
  private static final int eve;
  private static final int evf;
  private static final int evg;
  private static final int evh;
  private static final int evi;
  private static final int evj;
  private static final int evk;
  private static final int evl;
  private static final int evm;
  private static final int evn;
  private static final int rowid_HASHCODE = "rowid".hashCode();
  private static final int type_HASHCODE;
  private boolean __hadSettype = false;
  private int dep;
  public String dpO;
  private boolean elp = false;
  private boolean emb = false;
  private boolean enB = false;
  private boolean ery = false;
  private boolean euE = false;
  private boolean euF = false;
  private boolean euG = false;
  private boolean euH = false;
  private boolean euI = false;
  private boolean euJ = false;
  private boolean euK = false;
  private boolean euL = false;
  private boolean euM = false;
  private boolean euN = false;
  private boolean euO = false;
  private boolean euP = false;
  private boolean euQ = false;
  private boolean euR = false;
  private boolean euS = false;
  private boolean euT = false;
  private boolean euU = false;
  private boolean euV = false;
  private String evA;
  public String evB;
  protected int evC;
  public String evD;
  public String evE;
  public String evF;
  public int evG;
  public int evH;
  public String evI;
  public String evJ;
  public String evK;
  public String evL;
  public String evM;
  public String evN;
  public String evO;
  public String evP;
  private String evQ;
  public int evR;
  public String evS;
  public int evT;
  public long evU;
  public long evV;
  public int evo;
  public int evp;
  public String evq;
  protected long evr;
  protected String evs;
  protected int evt;
  public int evu;
  protected String evv;
  protected String evw;
  public int evx;
  public int evy;
  private String evz;
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
    erC = "nickname".hashCode();
    euZ = "pyInitial".hashCode();
    eva = "quanPin".hashCode();
    evb = "showHead".hashCode();
    type_HASHCODE = "type".hashCode();
    evc = "weiboFlag".hashCode();
    evd = "weiboNickname".hashCode();
    eve = "conRemarkPYFull".hashCode();
    evf = "conRemarkPYShort".hashCode();
    enX = "lvbuff".hashCode();
    evg = "verifyFlag".hashCode();
    evh = "encryptUsername".hashCode();
    evi = "chatroomFlag".hashCode();
    evj = "deleteFlag".hashCode();
    evk = "contactLabelIds".hashCode();
    evl = "descWordingId".hashCode();
    evm = "openImAppid".hashCode();
    evn = "sourceExtInfo".hashCode();
  }
  
  public final String Gn()
  {
    return this.signature;
  }
  
  public void O(byte[] paramArrayOfByte)
  {
    this.field_lvbuff = paramArrayOfByte;
    this.enB = true;
  }
  
  public final void SA()
  {
    this.evT = 1;
    this.enB = true;
  }
  
  public String Ss()
  {
    return this.field_alias;
  }
  
  public final String St()
  {
    return this.field_conRemark;
  }
  
  public final String Su()
  {
    return this.field_nickname;
  }
  
  public String Sv()
  {
    return this.field_pyInitial;
  }
  
  public String Sw()
  {
    return this.field_quanPin;
  }
  
  public final String Sx()
  {
    return this.field_encryptUsername;
  }
  
  public final String Sy()
  {
    return this.field_descWordingId;
  }
  
  public final String Sz()
  {
    return this.field_openImAppid;
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
      if (eme == k)
      {
        this.field_username = paramCursor.getString(i);
        this.emb = true;
      }
      for (;;)
      {
        i += 1;
        break;
        if (euW == k) {
          this.field_alias = paramCursor.getString(i);
        } else if (euX == k) {
          this.field_conRemark = paramCursor.getString(i);
        } else if (euY == k) {
          this.field_domainList = paramCursor.getString(i);
        } else if (erC == k) {
          this.field_nickname = paramCursor.getString(i);
        } else if (euZ == k) {
          this.field_pyInitial = paramCursor.getString(i);
        } else if (eva == k) {
          this.field_quanPin = paramCursor.getString(i);
        } else if (evb == k) {
          this.field_showHead = paramCursor.getInt(i);
        } else if (type_HASHCODE == k) {
          this.field_type = paramCursor.getInt(i);
        } else if (evc == k) {
          this.field_weiboFlag = paramCursor.getInt(i);
        } else if (evd == k) {
          this.field_weiboNickname = paramCursor.getString(i);
        } else if (eve == k) {
          this.field_conRemarkPYFull = paramCursor.getString(i);
        } else if (evf == k) {
          this.field_conRemarkPYShort = paramCursor.getString(i);
        } else if (enX == k) {
          this.field_lvbuff = paramCursor.getBlob(i);
        } else if (evg == k) {
          this.field_verifyFlag = paramCursor.getInt(i);
        } else if (evh == k) {
          this.field_encryptUsername = paramCursor.getString(i);
        } else if (evi == k) {
          this.field_chatroomFlag = paramCursor.getInt(i);
        } else if (evj == k) {
          this.field_deleteFlag = paramCursor.getInt(i);
        } else if (evk == k) {
          this.field_contactLabelIds = paramCursor.getString(i);
        } else if (evl == k) {
          this.field_descWordingId = paramCursor.getString(i);
        } else if (evm == k) {
          this.field_openImAppid = paramCursor.getString(i);
        } else if (evn == k) {
          this.field_sourceExtInfo = paramCursor.getString(i);
        } else if (elr == k) {
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
      if (this.enB)
      {
        localObject = new aa();
        ((aa)localObject).eFl();
        ((aa)localObject).Wi(this.evo);
        ((aa)localObject).Wi(this.evp);
        ((aa)localObject).aFs(this.evq);
        ((aa)localObject).vC(this.evr);
        ((aa)localObject).Wi(this.uin);
        ((aa)localObject).aFs(this.evs);
        ((aa)localObject).aFs(this.dpO);
        ((aa)localObject).Wi(this.evt);
        ((aa)localObject).Wi(this.evu);
        ((aa)localObject).aFs(this.evv);
        ((aa)localObject).aFs(this.evw);
        ((aa)localObject).Wi(this.evx);
        ((aa)localObject).Wi(this.evy);
        ((aa)localObject).aFs(this.signature);
        ((aa)localObject).aFs(this.evz);
        ((aa)localObject).aFs(this.evA);
        ((aa)localObject).aFs(this.evB);
        ((aa)localObject).Wi(this.evC);
        ((aa)localObject).Wi(this.dep);
        ((aa)localObject).aFs(this.evD);
        ((aa)localObject).Wi(this.field_verifyFlag);
        ((aa)localObject).aFs(this.evE);
        ((aa)localObject).aFs(this.evF);
        ((aa)localObject).Wi(this.evG);
        ((aa)localObject).Wi(this.evH);
        ((aa)localObject).aFs(this.evI);
        ((aa)localObject).aFs(this.evJ);
        ((aa)localObject).aFs(this.evK);
        ((aa)localObject).aFs(this.evL);
        ((aa)localObject).aFs(this.evM);
        ((aa)localObject).aFs(this.evN);
        ((aa)localObject).aFs(this.evO);
        ((aa)localObject).aFs(this.evP);
        ((aa)localObject).Wi(this.extFlag);
        ((aa)localObject).aFs(this.evQ);
        ((aa)localObject).Wi(this.evR);
        ((aa)localObject).aFs(this.evS);
        ((aa)localObject).Wi(this.evT);
        ((aa)localObject).vC(this.evU);
        ((aa)localObject).vC(this.evV);
        this.field_lvbuff = ((aa)localObject).eFm();
      }
      Object localObject = new ContentValues();
      if (this.field_username == null) {
        this.field_username = "";
      }
      if (this.emb) {
        ((ContentValues)localObject).put("username", this.field_username);
      }
      if (this.field_alias == null) {
        this.field_alias = "";
      }
      if (this.euE) {
        ((ContentValues)localObject).put("alias", this.field_alias);
      }
      if (this.field_conRemark == null) {
        this.field_conRemark = "";
      }
      if (this.euF) {
        ((ContentValues)localObject).put("conRemark", this.field_conRemark);
      }
      if (this.field_domainList == null) {
        this.field_domainList = "";
      }
      if (this.euG) {
        ((ContentValues)localObject).put("domainList", this.field_domainList);
      }
      if (this.field_nickname == null) {
        this.field_nickname = "";
      }
      if (this.ery) {
        ((ContentValues)localObject).put("nickname", this.field_nickname);
      }
      if (this.field_pyInitial == null) {
        this.field_pyInitial = "";
      }
      if (this.euH) {
        ((ContentValues)localObject).put("pyInitial", this.field_pyInitial);
      }
      if (this.field_quanPin == null) {
        this.field_quanPin = "";
      }
      if (this.euI) {
        ((ContentValues)localObject).put("quanPin", this.field_quanPin);
      }
      if (this.euJ) {
        ((ContentValues)localObject).put("showHead", Integer.valueOf(this.field_showHead));
      }
      if (this.__hadSettype) {
        ((ContentValues)localObject).put("type", Integer.valueOf(this.field_type));
      }
      if (this.euK) {
        ((ContentValues)localObject).put("weiboFlag", Integer.valueOf(this.field_weiboFlag));
      }
      if (this.field_weiboNickname == null) {
        this.field_weiboNickname = "";
      }
      if (this.euL) {
        ((ContentValues)localObject).put("weiboNickname", this.field_weiboNickname);
      }
      if (this.field_conRemarkPYFull == null) {
        this.field_conRemarkPYFull = "";
      }
      if (this.euM) {
        ((ContentValues)localObject).put("conRemarkPYFull", this.field_conRemarkPYFull);
      }
      if (this.field_conRemarkPYShort == null) {
        this.field_conRemarkPYShort = "";
      }
      if (this.euN) {
        ((ContentValues)localObject).put("conRemarkPYShort", this.field_conRemarkPYShort);
      }
      if (this.enB) {
        ((ContentValues)localObject).put("lvbuff", this.field_lvbuff);
      }
      if (this.euO) {
        ((ContentValues)localObject).put("verifyFlag", Integer.valueOf(this.field_verifyFlag));
      }
      if (this.field_encryptUsername == null) {
        this.field_encryptUsername = "";
      }
      if (this.euP) {
        ((ContentValues)localObject).put("encryptUsername", this.field_encryptUsername);
      }
      if (this.euQ) {
        ((ContentValues)localObject).put("chatroomFlag", Integer.valueOf(this.field_chatroomFlag));
      }
      if (this.euR) {
        ((ContentValues)localObject).put("deleteFlag", Integer.valueOf(this.field_deleteFlag));
      }
      if (this.field_contactLabelIds == null) {
        this.field_contactLabelIds = "";
      }
      if (this.euS) {
        ((ContentValues)localObject).put("contactLabelIds", this.field_contactLabelIds);
      }
      if (this.field_descWordingId == null) {
        this.field_descWordingId = "";
      }
      if (this.euT) {
        ((ContentValues)localObject).put("descWordingId", this.field_descWordingId);
      }
      if (this.euU) {
        ((ContentValues)localObject).put("openImAppid", this.field_openImAppid);
      }
      if (this.euV) {
        ((ContentValues)localObject).put("sourceExtInfo", this.field_sourceExtInfo);
      }
      if (this.field_ticket == null) {
        this.field_ticket = "";
      }
      if (this.elp) {
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
  
  public final int eMK()
  {
    return this.evp;
  }
  
  public String getCity()
  {
    return this.evA;
  }
  
  public String getProvince()
  {
    return this.evz;
  }
  
  public int getSource()
  {
    return this.dep;
  }
  
  public final String getUsername()
  {
    return this.field_username;
  }
  
  public void jD(int paramInt)
  {
    this.field_showHead = paramInt;
    this.euJ = true;
  }
  
  public void jE(int paramInt)
  {
    this.field_weiboFlag = paramInt;
    this.euK = true;
  }
  
  public void jF(int paramInt)
  {
    this.field_verifyFlag = paramInt;
    this.euO = true;
  }
  
  public void jG(int paramInt)
  {
    this.field_chatroomFlag = paramInt;
    this.euQ = true;
  }
  
  public void jH(int paramInt)
  {
    this.field_deleteFlag = paramInt;
    this.euR = true;
  }
  
  public void jI(int paramInt)
  {
    this.evo = paramInt;
    this.enB = true;
  }
  
  public void jJ(int paramInt)
  {
    this.evp = paramInt;
    this.enB = true;
  }
  
  public void jK(int paramInt)
  {
    this.evt = paramInt;
    this.enB = true;
  }
  
  public void jL(int paramInt)
  {
    this.evu = paramInt;
    this.enB = true;
  }
  
  public void jM(int paramInt)
  {
    this.evx = paramInt;
    this.enB = true;
  }
  
  public void jN(int paramInt)
  {
    this.evy = paramInt;
    this.enB = true;
  }
  
  public void jO(int paramInt)
  {
    this.evG = paramInt;
    this.enB = true;
  }
  
  public void jP(int paramInt)
  {
    this.evH = paramInt;
    this.enB = true;
  }
  
  public final void jQ(int paramInt)
  {
    this.extFlag = paramInt;
    this.enB = true;
  }
  
  public final void jR(int paramInt)
  {
    this.evR = paramInt;
    this.enB = true;
  }
  
  public void kP(long paramLong)
  {
    this.evr = paramLong;
    this.enB = true;
  }
  
  public void kQ(long paramLong)
  {
    this.evU = paramLong;
    this.enB = true;
  }
  
  public void kR(long paramLong)
  {
    this.evV = paramLong;
    this.enB = true;
  }
  
  public void nA(String paramString)
  {
    this.evF = paramString;
    this.enB = true;
  }
  
  public void nB(String paramString)
  {
    this.evI = paramString;
    this.enB = true;
  }
  
  public void nC(String paramString)
  {
    this.evJ = paramString;
    this.enB = true;
  }
  
  public void nD(String paramString)
  {
    this.evK = paramString;
    this.enB = true;
  }
  
  public void nE(String paramString)
  {
    this.evL = paramString;
    this.enB = true;
  }
  
  public void nF(String paramString)
  {
    this.evM = paramString;
    this.enB = true;
  }
  
  public void nG(String paramString)
  {
    this.evN = paramString;
    this.enB = true;
  }
  
  public void nH(String paramString)
  {
    this.evO = paramString;
    this.enB = true;
  }
  
  public void nI(String paramString)
  {
    this.evP = paramString;
    this.enB = true;
  }
  
  public final void nJ(String paramString)
  {
    this.evS = paramString;
    this.enB = true;
  }
  
  public void na(String paramString)
  {
    this.field_alias = paramString;
    this.euE = true;
  }
  
  public void nb(String paramString)
  {
    this.field_conRemark = paramString;
    this.euF = true;
  }
  
  public void nc(String paramString)
  {
    this.field_domainList = paramString;
    this.euG = true;
  }
  
  public void nd(String paramString)
  {
    this.field_nickname = paramString;
    this.ery = true;
  }
  
  public void ne(String paramString)
  {
    this.field_pyInitial = paramString;
    this.euH = true;
  }
  
  public void nf(String paramString)
  {
    this.field_quanPin = paramString;
    this.euI = true;
  }
  
  public void ng(String paramString)
  {
    this.field_weiboNickname = paramString;
    this.euL = true;
  }
  
  public void nh(String paramString)
  {
    this.field_conRemarkPYFull = paramString;
    this.euM = true;
  }
  
  public void ni(String paramString)
  {
    this.field_conRemarkPYShort = paramString;
    this.euN = true;
  }
  
  public void nj(String paramString)
  {
    this.field_encryptUsername = paramString;
    this.euP = true;
  }
  
  public void nk(String paramString)
  {
    this.field_contactLabelIds = paramString;
    this.euS = true;
  }
  
  public final void nl(String paramString)
  {
    this.field_descWordingId = paramString;
    this.euT = true;
  }
  
  public void nm(String paramString)
  {
    this.field_openImAppid = paramString;
    this.euU = true;
  }
  
  public void nn(String paramString)
  {
    this.field_sourceExtInfo = paramString;
    this.euV = true;
  }
  
  public void no(String paramString)
  {
    this.field_ticket = paramString;
    this.elp = true;
  }
  
  public void np(String paramString)
  {
    this.evq = paramString;
    this.enB = true;
  }
  
  public void nq(String paramString)
  {
    this.evs = paramString;
    this.enB = true;
  }
  
  public void nr(String paramString)
  {
    this.dpO = paramString;
    this.enB = true;
  }
  
  public void ns(String paramString)
  {
    this.evv = paramString;
    this.enB = true;
  }
  
  public void nt(String paramString)
  {
    this.evw = paramString;
    this.enB = true;
  }
  
  public void nu(String paramString)
  {
    this.signature = paramString;
    this.enB = true;
  }
  
  public void nv(String paramString)
  {
    this.evz = paramString;
    this.enB = true;
  }
  
  public void nw(String paramString)
  {
    this.evA = paramString;
    this.enB = true;
  }
  
  public void nx(String paramString)
  {
    this.evB = paramString;
    this.enB = true;
  }
  
  public void ny(String paramString)
  {
    this.evD = paramString;
    this.enB = true;
  }
  
  public void nz(String paramString)
  {
    this.evE = paramString;
    this.enB = true;
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
      int i = localaa.cs(this.field_lvbuff);
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
    this.evo = localException.getInt();
    this.evp = localException.getInt();
    this.evq = localException.getString();
    this.evr = localException.getLong();
    this.uin = localException.getInt();
    this.evs = localException.getString();
    this.dpO = localException.getString();
    this.evt = localException.getInt();
    this.evu = localException.getInt();
    this.evv = localException.getString();
    this.evw = localException.getString();
    this.evx = localException.getInt();
    this.evy = localException.getInt();
    this.signature = localException.getString();
    this.evz = localException.getString();
    this.evA = localException.getString();
    this.evB = localException.getString();
    this.evC = localException.getInt();
    this.dep = localException.getInt();
    this.evD = localException.getString();
    this.field_verifyFlag = localException.getInt();
    this.evE = localException.getString();
    if (!localException.eFk()) {
      this.evF = localException.getString();
    }
    if (!localException.eFk()) {
      this.evG = localException.getInt();
    }
    if (!localException.eFk()) {
      this.evH = localException.getInt();
    }
    if (!localException.eFk()) {
      this.evI = localException.getString();
    }
    if (!localException.eFk()) {
      this.evJ = localException.getString();
    }
    if (!localException.eFk()) {
      this.evK = localException.getString();
    }
    if (!localException.eFk()) {
      this.evL = localException.getString();
    }
    if (!localException.eFk()) {
      this.evM = localException.getString();
    }
    if (!localException.eFk()) {
      this.evN = localException.getString();
    }
    if (!localException.eFk()) {
      this.evO = localException.getString();
    }
    if (!localException.eFk()) {
      this.evP = localException.getString();
    }
    if (!localException.eFk()) {
      this.extFlag = localException.getInt();
    }
    if (!localException.eFk()) {
      this.evQ = localException.getString();
    }
    if (!localException.eFk()) {
      this.evR = localException.getInt();
    }
    if (!localException.eFk()) {
      this.evS = localException.getString();
    }
    if (!localException.eFk()) {
      this.evT = localException.getInt();
    }
    if (!localException.eFk()) {
      this.evU = localException.getLong();
    }
    if (!localException.eFk()) {
      this.evV = localException.getLong();
    }
  }
  
  public void setFromType(int paramInt)
  {
    this.evC = paramInt;
    this.enB = true;
  }
  
  public void setSource(int paramInt)
  {
    this.dep = paramInt;
    this.enB = true;
  }
  
  public void setType(int paramInt)
  {
    this.field_type = paramInt;
    this.__hadSettype = true;
  }
  
  public void setUin(int paramInt)
  {
    this.uin = paramInt;
    this.enB = true;
  }
  
  public void setUsername(String paramString)
  {
    this.field_username = paramString;
    this.emb = true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.g.c.au
 * JD-Core Version:    0.7.0.1
 */