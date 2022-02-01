package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ae;

public abstract class aw
  extends c
{
  public static final String[] INDEX_CREATE = { "CREATE INDEX IF NOT EXISTS deleteflag_index ON Contact(deleteFlag)" };
  private static final int eGY = "username".hashCode();
  private static final int eGl = "ticket".hashCode();
  private static final int eIU;
  private static final int eMy;
  private static final int eQC = "alias".hashCode();
  private static final int eQD = "conRemark".hashCode();
  private static final int eQE = "domainList".hashCode();
  private static final int eQF;
  private static final int eQG;
  private static final int eQH;
  private static final int eQI;
  private static final int eQJ;
  private static final int eQK;
  private static final int eQL;
  private static final int eQM;
  private static final int eQN;
  private static final int eQO;
  private static final int eQP;
  private static final int eQQ;
  private static final int eQR;
  private static final int eQS;
  private static final int eQT;
  private static final int rowid_HASHCODE = "rowid".hashCode();
  private static final int type_HASHCODE;
  private boolean __hadSettype = false;
  public String dAs;
  private int doj;
  private boolean eGV = false;
  private boolean eGj = false;
  private boolean eIy = false;
  private boolean eMu = false;
  private boolean eQA = false;
  private boolean eQB = false;
  public int eQU;
  public int eQV;
  public String eQW;
  protected long eQX;
  protected String eQY;
  protected int eQZ;
  private boolean eQk = false;
  private boolean eQl = false;
  private boolean eQm = false;
  private boolean eQn = false;
  private boolean eQo = false;
  private boolean eQp = false;
  private boolean eQq = false;
  private boolean eQr = false;
  private boolean eQs = false;
  private boolean eQt = false;
  private boolean eQu = false;
  private boolean eQv = false;
  private boolean eQw = false;
  private boolean eQx = false;
  private boolean eQy = false;
  private boolean eQz = false;
  public long eRA;
  public long eRB;
  public int eRa;
  protected String eRb;
  protected String eRc;
  public int eRd;
  public int eRe;
  private String eRf;
  private String eRg;
  public String eRh;
  protected int eRi;
  public String eRj;
  public String eRk;
  public String eRl;
  public int eRm;
  public int eRn;
  public String eRo;
  public String eRp;
  public String eRq;
  public String eRr;
  public String eRs;
  public String eRt;
  public String eRu;
  public String eRv;
  private String eRw;
  public int eRx;
  public String eRy;
  public int eRz;
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
    eMy = "nickname".hashCode();
    eQF = "pyInitial".hashCode();
    eQG = "quanPin".hashCode();
    eQH = "showHead".hashCode();
    type_HASHCODE = "type".hashCode();
    eQI = "weiboFlag".hashCode();
    eQJ = "weiboNickname".hashCode();
    eQK = "conRemarkPYFull".hashCode();
    eQL = "conRemarkPYShort".hashCode();
    eIU = "lvbuff".hashCode();
    eQM = "verifyFlag".hashCode();
    eQN = "encryptUsername".hashCode();
    eQO = "chatroomFlag".hashCode();
    eQP = "deleteFlag".hashCode();
    eQQ = "contactLabelIds".hashCode();
    eQR = "descWordingId".hashCode();
    eQS = "openImAppid".hashCode();
    eQT = "sourceExtInfo".hashCode();
  }
  
  public final String HC()
  {
    return this.signature;
  }
  
  public void L(byte[] paramArrayOfByte)
  {
    this.field_lvbuff = paramArrayOfByte;
    this.eIy = true;
  }
  
  public String VI()
  {
    return this.field_alias;
  }
  
  public final String VJ()
  {
    return this.field_conRemark;
  }
  
  public final String VK()
  {
    return this.field_nickname;
  }
  
  public String VL()
  {
    return this.field_pyInitial;
  }
  
  public String VM()
  {
    return this.field_quanPin;
  }
  
  public final String VN()
  {
    return this.field_encryptUsername;
  }
  
  public final String VO()
  {
    return this.field_descWordingId;
  }
  
  public final String VP()
  {
    return this.field_openImAppid;
  }
  
  public final int VQ()
  {
    return this.eQV;
  }
  
  public final void VR()
  {
    this.eRz = 1;
    this.eIy = true;
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
      if (eGY == k)
      {
        this.field_username = paramCursor.getString(i);
        this.eGV = true;
      }
      for (;;)
      {
        i += 1;
        break;
        if (eQC == k) {
          this.field_alias = paramCursor.getString(i);
        } else if (eQD == k) {
          this.field_conRemark = paramCursor.getString(i);
        } else if (eQE == k) {
          this.field_domainList = paramCursor.getString(i);
        } else if (eMy == k) {
          this.field_nickname = paramCursor.getString(i);
        } else if (eQF == k) {
          this.field_pyInitial = paramCursor.getString(i);
        } else if (eQG == k) {
          this.field_quanPin = paramCursor.getString(i);
        } else if (eQH == k) {
          this.field_showHead = paramCursor.getInt(i);
        } else if (type_HASHCODE == k) {
          this.field_type = paramCursor.getInt(i);
        } else if (eQI == k) {
          this.field_weiboFlag = paramCursor.getInt(i);
        } else if (eQJ == k) {
          this.field_weiboNickname = paramCursor.getString(i);
        } else if (eQK == k) {
          this.field_conRemarkPYFull = paramCursor.getString(i);
        } else if (eQL == k) {
          this.field_conRemarkPYShort = paramCursor.getString(i);
        } else if (eIU == k) {
          this.field_lvbuff = paramCursor.getBlob(i);
        } else if (eQM == k) {
          this.field_verifyFlag = paramCursor.getInt(i);
        } else if (eQN == k) {
          this.field_encryptUsername = paramCursor.getString(i);
        } else if (eQO == k) {
          this.field_chatroomFlag = paramCursor.getInt(i);
        } else if (eQP == k) {
          this.field_deleteFlag = paramCursor.getInt(i);
        } else if (eQQ == k) {
          this.field_contactLabelIds = paramCursor.getString(i);
        } else if (eQR == k) {
          this.field_descWordingId = paramCursor.getString(i);
        } else if (eQS == k) {
          this.field_openImAppid = paramCursor.getString(i);
        } else if (eQT == k) {
          this.field_sourceExtInfo = paramCursor.getString(i);
        } else if (eGl == k) {
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
      if (this.eIy)
      {
        localObject = new ab();
        ((ab)localObject).fod();
        ((ab)localObject).abc(this.eQU);
        ((ab)localObject).abc(this.eQV);
        ((ab)localObject).aRM(this.eQW);
        ((ab)localObject).Dt(this.eQX);
        ((ab)localObject).abc(this.uin);
        ((ab)localObject).aRM(this.eQY);
        ((ab)localObject).aRM(this.dAs);
        ((ab)localObject).abc(this.eQZ);
        ((ab)localObject).abc(this.eRa);
        ((ab)localObject).aRM(this.eRb);
        ((ab)localObject).aRM(this.eRc);
        ((ab)localObject).abc(this.eRd);
        ((ab)localObject).abc(this.eRe);
        ((ab)localObject).aRM(this.signature);
        ((ab)localObject).aRM(this.eRf);
        ((ab)localObject).aRM(this.eRg);
        ((ab)localObject).aRM(this.eRh);
        ((ab)localObject).abc(this.eRi);
        ((ab)localObject).abc(this.doj);
        ((ab)localObject).aRM(this.eRj);
        ((ab)localObject).abc(this.field_verifyFlag);
        ((ab)localObject).aRM(this.eRk);
        ((ab)localObject).aRM(this.eRl);
        ((ab)localObject).abc(this.eRm);
        ((ab)localObject).abc(this.eRn);
        ((ab)localObject).aRM(this.eRo);
        ((ab)localObject).aRM(this.eRp);
        ((ab)localObject).aRM(this.eRq);
        ((ab)localObject).aRM(this.eRr);
        ((ab)localObject).aRM(this.eRs);
        ((ab)localObject).aRM(this.eRt);
        ((ab)localObject).aRM(this.eRu);
        ((ab)localObject).aRM(this.eRv);
        ((ab)localObject).abc(this.extFlag);
        ((ab)localObject).aRM(this.eRw);
        ((ab)localObject).abc(this.eRx);
        ((ab)localObject).aRM(this.eRy);
        ((ab)localObject).abc(this.eRz);
        ((ab)localObject).Dt(this.eRA);
        ((ab)localObject).Dt(this.eRB);
        this.field_lvbuff = ((ab)localObject).foe();
      }
      Object localObject = new ContentValues();
      if (this.field_username == null) {
        this.field_username = "";
      }
      if (this.eGV) {
        ((ContentValues)localObject).put("username", this.field_username);
      }
      if (this.field_alias == null) {
        this.field_alias = "";
      }
      if (this.eQk) {
        ((ContentValues)localObject).put("alias", this.field_alias);
      }
      if (this.field_conRemark == null) {
        this.field_conRemark = "";
      }
      if (this.eQl) {
        ((ContentValues)localObject).put("conRemark", this.field_conRemark);
      }
      if (this.field_domainList == null) {
        this.field_domainList = "";
      }
      if (this.eQm) {
        ((ContentValues)localObject).put("domainList", this.field_domainList);
      }
      if (this.field_nickname == null) {
        this.field_nickname = "";
      }
      if (this.eMu) {
        ((ContentValues)localObject).put("nickname", this.field_nickname);
      }
      if (this.field_pyInitial == null) {
        this.field_pyInitial = "";
      }
      if (this.eQn) {
        ((ContentValues)localObject).put("pyInitial", this.field_pyInitial);
      }
      if (this.field_quanPin == null) {
        this.field_quanPin = "";
      }
      if (this.eQo) {
        ((ContentValues)localObject).put("quanPin", this.field_quanPin);
      }
      if (this.eQp) {
        ((ContentValues)localObject).put("showHead", Integer.valueOf(this.field_showHead));
      }
      if (this.__hadSettype) {
        ((ContentValues)localObject).put("type", Integer.valueOf(this.field_type));
      }
      if (this.eQq) {
        ((ContentValues)localObject).put("weiboFlag", Integer.valueOf(this.field_weiboFlag));
      }
      if (this.field_weiboNickname == null) {
        this.field_weiboNickname = "";
      }
      if (this.eQr) {
        ((ContentValues)localObject).put("weiboNickname", this.field_weiboNickname);
      }
      if (this.field_conRemarkPYFull == null) {
        this.field_conRemarkPYFull = "";
      }
      if (this.eQs) {
        ((ContentValues)localObject).put("conRemarkPYFull", this.field_conRemarkPYFull);
      }
      if (this.field_conRemarkPYShort == null) {
        this.field_conRemarkPYShort = "";
      }
      if (this.eQt) {
        ((ContentValues)localObject).put("conRemarkPYShort", this.field_conRemarkPYShort);
      }
      if (this.eIy) {
        ((ContentValues)localObject).put("lvbuff", this.field_lvbuff);
      }
      if (this.eQu) {
        ((ContentValues)localObject).put("verifyFlag", Integer.valueOf(this.field_verifyFlag));
      }
      if (this.field_encryptUsername == null) {
        this.field_encryptUsername = "";
      }
      if (this.eQv) {
        ((ContentValues)localObject).put("encryptUsername", this.field_encryptUsername);
      }
      if (this.eQw) {
        ((ContentValues)localObject).put("chatroomFlag", Integer.valueOf(this.field_chatroomFlag));
      }
      if (this.eQx) {
        ((ContentValues)localObject).put("deleteFlag", Integer.valueOf(this.field_deleteFlag));
      }
      if (this.field_contactLabelIds == null) {
        this.field_contactLabelIds = "";
      }
      if (this.eQy) {
        ((ContentValues)localObject).put("contactLabelIds", this.field_contactLabelIds);
      }
      if (this.field_descWordingId == null) {
        this.field_descWordingId = "";
      }
      if (this.eQz) {
        ((ContentValues)localObject).put("descWordingId", this.field_descWordingId);
      }
      if (this.eQA) {
        ((ContentValues)localObject).put("openImAppid", this.field_openImAppid);
      }
      if (this.eQB) {
        ((ContentValues)localObject).put("sourceExtInfo", this.field_sourceExtInfo);
      }
      if (this.field_ticket == null) {
        this.field_ticket = "";
      }
      if (this.eGj) {
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
        ae.e("MicroMsg.SDK.BaseContact", "get value failed, %s", new Object[] { localException.getMessage() });
      }
    }
  }
  
  public String getCity()
  {
    return this.eRg;
  }
  
  public final int getFromType()
  {
    return this.eRi;
  }
  
  public String getProvince()
  {
    return this.eRf;
  }
  
  public int getSource()
  {
    return this.doj;
  }
  
  public final String getUsername()
  {
    return this.field_username;
  }
  
  public void kb(int paramInt)
  {
    this.field_showHead = paramInt;
    this.eQp = true;
  }
  
  public void kc(int paramInt)
  {
    this.field_weiboFlag = paramInt;
    this.eQq = true;
  }
  
  public void kd(int paramInt)
  {
    this.field_verifyFlag = paramInt;
    this.eQu = true;
  }
  
  public void ke(int paramInt)
  {
    this.field_chatroomFlag = paramInt;
    this.eQw = true;
  }
  
  public void kf(int paramInt)
  {
    this.field_deleteFlag = paramInt;
    this.eQx = true;
  }
  
  public void kg(int paramInt)
  {
    this.eQU = paramInt;
    this.eIy = true;
  }
  
  public void kh(int paramInt)
  {
    this.eQV = paramInt;
    this.eIy = true;
  }
  
  public void ki(int paramInt)
  {
    this.eQZ = paramInt;
    this.eIy = true;
  }
  
  public void kj(int paramInt)
  {
    this.eRa = paramInt;
    this.eIy = true;
  }
  
  public void kk(int paramInt)
  {
    this.eRd = paramInt;
    this.eIy = true;
  }
  
  public void kl(int paramInt)
  {
    this.eRe = paramInt;
    this.eIy = true;
  }
  
  public void km(int paramInt)
  {
    this.eRm = paramInt;
    this.eIy = true;
  }
  
  public void kn(int paramInt)
  {
    this.eRn = paramInt;
    this.eIy = true;
  }
  
  public final void ko(int paramInt)
  {
    this.extFlag = paramInt;
    this.eIy = true;
  }
  
  public final void kp(int paramInt)
  {
    this.eRx = paramInt;
    this.eIy = true;
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
      ab localab = new ab();
      int i = localab.cB(this.field_lvbuff);
      if (i != 0)
      {
        ae.e("MicroMsg.SDK.BaseContact", "parse LVBuffer error:".concat(String.valueOf(i)));
        return;
      }
    }
    catch (Exception localException)
    {
      ae.e("MicroMsg.SDK.BaseContact", "get value failed");
      return;
    }
    this.eQU = localException.getInt();
    this.eQV = localException.getInt();
    this.eQW = localException.getString();
    this.eQX = localException.getLong();
    this.uin = localException.getInt();
    this.eQY = localException.getString();
    this.dAs = localException.getString();
    this.eQZ = localException.getInt();
    this.eRa = localException.getInt();
    this.eRb = localException.getString();
    this.eRc = localException.getString();
    this.eRd = localException.getInt();
    this.eRe = localException.getInt();
    this.signature = localException.getString();
    this.eRf = localException.getString();
    this.eRg = localException.getString();
    this.eRh = localException.getString();
    this.eRi = localException.getInt();
    this.doj = localException.getInt();
    this.eRj = localException.getString();
    this.field_verifyFlag = localException.getInt();
    this.eRk = localException.getString();
    if (!localException.foc()) {
      this.eRl = localException.getString();
    }
    if (!localException.foc()) {
      this.eRm = localException.getInt();
    }
    if (!localException.foc()) {
      this.eRn = localException.getInt();
    }
    if (!localException.foc()) {
      this.eRo = localException.getString();
    }
    if (!localException.foc()) {
      this.eRp = localException.getString();
    }
    if (!localException.foc()) {
      this.eRq = localException.getString();
    }
    if (!localException.foc()) {
      this.eRr = localException.getString();
    }
    if (!localException.foc()) {
      this.eRs = localException.getString();
    }
    if (!localException.foc()) {
      this.eRt = localException.getString();
    }
    if (!localException.foc()) {
      this.eRu = localException.getString();
    }
    if (!localException.foc()) {
      this.eRv = localException.getString();
    }
    if (!localException.foc()) {
      this.extFlag = localException.getInt();
    }
    if (!localException.foc()) {
      this.eRw = localException.getString();
    }
    if (!localException.foc()) {
      this.eRx = localException.getInt();
    }
    if (!localException.foc()) {
      this.eRy = localException.getString();
    }
    if (!localException.foc()) {
      this.eRz = localException.getInt();
    }
    if (!localException.foc()) {
      this.eRA = localException.getLong();
    }
    if (!localException.foc()) {
      this.eRB = localException.getLong();
    }
  }
  
  public void qE(long paramLong)
  {
    this.eQX = paramLong;
    this.eIy = true;
  }
  
  public void qF(long paramLong)
  {
    this.eRA = paramLong;
    this.eIy = true;
  }
  
  public void qG(long paramLong)
  {
    this.eRB = paramLong;
    this.eIy = true;
  }
  
  public void setFromType(int paramInt)
  {
    this.eRi = paramInt;
    this.eIy = true;
  }
  
  public void setSource(int paramInt)
  {
    this.doj = paramInt;
    this.eIy = true;
  }
  
  public void setType(int paramInt)
  {
    this.field_type = paramInt;
    this.__hadSettype = true;
  }
  
  public void setUin(int paramInt)
  {
    this.uin = paramInt;
    this.eIy = true;
  }
  
  public void setUsername(String paramString)
  {
    this.field_username = paramString;
    this.eGV = true;
  }
  
  public void tA(String paramString)
  {
    this.eQW = paramString;
    this.eIy = true;
  }
  
  public void tB(String paramString)
  {
    this.eQY = paramString;
    this.eIy = true;
  }
  
  public void tC(String paramString)
  {
    this.dAs = paramString;
    this.eIy = true;
  }
  
  public void tD(String paramString)
  {
    this.eRb = paramString;
    this.eIy = true;
  }
  
  public void tE(String paramString)
  {
    this.eRc = paramString;
    this.eIy = true;
  }
  
  public void tF(String paramString)
  {
    this.signature = paramString;
    this.eIy = true;
  }
  
  public void tG(String paramString)
  {
    this.eRf = paramString;
    this.eIy = true;
  }
  
  public void tH(String paramString)
  {
    this.eRg = paramString;
    this.eIy = true;
  }
  
  public void tI(String paramString)
  {
    this.eRh = paramString;
    this.eIy = true;
  }
  
  public void tJ(String paramString)
  {
    this.eRj = paramString;
    this.eIy = true;
  }
  
  public void tK(String paramString)
  {
    this.eRk = paramString;
    this.eIy = true;
  }
  
  public void tL(String paramString)
  {
    this.eRl = paramString;
    this.eIy = true;
  }
  
  public void tM(String paramString)
  {
    this.eRo = paramString;
    this.eIy = true;
  }
  
  public void tN(String paramString)
  {
    this.eRp = paramString;
    this.eIy = true;
  }
  
  public void tO(String paramString)
  {
    this.eRq = paramString;
    this.eIy = true;
  }
  
  public void tP(String paramString)
  {
    this.eRr = paramString;
    this.eIy = true;
  }
  
  public void tQ(String paramString)
  {
    this.eRs = paramString;
    this.eIy = true;
  }
  
  public void tR(String paramString)
  {
    this.eRt = paramString;
    this.eIy = true;
  }
  
  public void tS(String paramString)
  {
    this.eRu = paramString;
    this.eIy = true;
  }
  
  public void tT(String paramString)
  {
    this.eRv = paramString;
    this.eIy = true;
  }
  
  public final void tU(String paramString)
  {
    this.eRy = paramString;
    this.eIy = true;
  }
  
  public void tl(String paramString)
  {
    this.field_alias = paramString;
    this.eQk = true;
  }
  
  public void tm(String paramString)
  {
    this.field_conRemark = paramString;
    this.eQl = true;
  }
  
  public void tn(String paramString)
  {
    this.field_domainList = paramString;
    this.eQm = true;
  }
  
  public void to(String paramString)
  {
    this.field_nickname = paramString;
    this.eMu = true;
  }
  
  public void tp(String paramString)
  {
    this.field_pyInitial = paramString;
    this.eQn = true;
  }
  
  public void tq(String paramString)
  {
    this.field_quanPin = paramString;
    this.eQo = true;
  }
  
  public void tr(String paramString)
  {
    this.field_weiboNickname = paramString;
    this.eQr = true;
  }
  
  public void ts(String paramString)
  {
    this.field_conRemarkPYFull = paramString;
    this.eQs = true;
  }
  
  public void tt(String paramString)
  {
    this.field_conRemarkPYShort = paramString;
    this.eQt = true;
  }
  
  public void tu(String paramString)
  {
    this.field_encryptUsername = paramString;
    this.eQv = true;
  }
  
  public void tv(String paramString)
  {
    this.field_contactLabelIds = paramString;
    this.eQy = true;
  }
  
  public final void tw(String paramString)
  {
    this.field_descWordingId = paramString;
    this.eQz = true;
  }
  
  public void tx(String paramString)
  {
    this.field_openImAppid = paramString;
    this.eQA = true;
  }
  
  public void ty(String paramString)
  {
    this.field_sourceExtInfo = paramString;
    this.eQB = true;
  }
  
  public void tz(String paramString)
  {
    this.field_ticket = paramString;
    this.eGj = true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.g.c.aw
 * JD-Core Version:    0.7.0.1
 */