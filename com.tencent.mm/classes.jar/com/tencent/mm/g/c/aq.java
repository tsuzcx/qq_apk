package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.y;

public abstract class aq
  extends c
{
  public static final String[] INDEX_CREATE = { "CREATE INDEX IF NOT EXISTS deleteflag_index ON Contact(deleteFlag)" };
  private static final int dhU = "username".hashCode();
  private static final int djB;
  private static final int dmT;
  private static final int dqA = "sourceExtInfo".hashCode();
  private static final int dqj = "alias".hashCode();
  private static final int dqk = "conRemark".hashCode();
  private static final int dql = "domainList".hashCode();
  private static final int dqm;
  private static final int dqn;
  private static final int dqo;
  private static final int dqp;
  private static final int dqq;
  private static final int dqr;
  private static final int dqs;
  private static final int dqt;
  private static final int dqu;
  private static final int dqv;
  private static final int dqw;
  private static final int dqx;
  private static final int dqy;
  private static final int dqz;
  private static final int rowid_HASHCODE = "rowid".hashCode();
  private static final int type_HASHCODE;
  private boolean __hadSettype = false;
  private String city;
  private int cpt;
  public String czF;
  private boolean dhS = false;
  private boolean dje = false;
  private boolean dmP = false;
  private boolean dpR = false;
  private boolean dpS = false;
  private boolean dpT = false;
  private boolean dpU = false;
  private boolean dpV = false;
  private boolean dpW = false;
  private boolean dpX = false;
  private boolean dpY = false;
  private boolean dpZ = false;
  public int dqB;
  public int dqC;
  public String dqD;
  protected long dqE;
  protected String dqF;
  protected int dqG;
  public int dqH;
  protected String dqI;
  protected String dqJ;
  public int dqK;
  public int dqL;
  public String dqM;
  protected int dqN;
  public String dqO;
  public String dqP;
  public String dqQ;
  public int dqR;
  public int dqS;
  public String dqT;
  public String dqU;
  public String dqV;
  public String dqW;
  public String dqX;
  public String dqY;
  public String dqZ;
  private boolean dqa = false;
  private boolean dqb = false;
  private boolean dqc = false;
  private boolean dqd = false;
  private boolean dqe = false;
  private boolean dqf = false;
  private boolean dqg = false;
  private boolean dqh = false;
  private boolean dqi = false;
  public String dra;
  private int drb;
  private String drc;
  public int drd;
  public String dre;
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
  public int field_type;
  public String field_username;
  public int field_verifyFlag;
  public int field_weiboFlag;
  public String field_weiboNickname;
  private String province;
  public String signature;
  public int uin;
  
  static
  {
    dmT = "nickname".hashCode();
    dqm = "pyInitial".hashCode();
    dqn = "quanPin".hashCode();
    dqo = "showHead".hashCode();
    type_HASHCODE = "type".hashCode();
    dqp = "weiboFlag".hashCode();
    dqq = "weiboNickname".hashCode();
    dqr = "conRemarkPYFull".hashCode();
    dqs = "conRemarkPYShort".hashCode();
    djB = "lvbuff".hashCode();
    dqt = "verifyFlag".hashCode();
    dqu = "encryptUsername".hashCode();
    dqv = "chatroomFlag".hashCode();
    dqw = "deleteFlag".hashCode();
    dqx = "contactLabelIds".hashCode();
    dqy = "descWordingId".hashCode();
    dqz = "openImAppid".hashCode();
  }
  
  public void G(byte[] paramArrayOfByte)
  {
    this.field_lvbuff = paramArrayOfByte;
    this.dje = true;
  }
  
  public String Hq()
  {
    return this.field_alias;
  }
  
  public final String Hr()
  {
    return this.field_conRemark;
  }
  
  public final String Hs()
  {
    return this.field_nickname;
  }
  
  public String Ht()
  {
    return this.field_pyInitial;
  }
  
  public String Hu()
  {
    return this.field_quanPin;
  }
  
  public final String Hv()
  {
    return this.field_encryptUsername;
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
      if (dhU == k)
      {
        this.field_username = paramCursor.getString(i);
        this.dhS = true;
      }
      for (;;)
      {
        i += 1;
        break;
        if (dqj == k) {
          this.field_alias = paramCursor.getString(i);
        } else if (dqk == k) {
          this.field_conRemark = paramCursor.getString(i);
        } else if (dql == k) {
          this.field_domainList = paramCursor.getString(i);
        } else if (dmT == k) {
          this.field_nickname = paramCursor.getString(i);
        } else if (dqm == k) {
          this.field_pyInitial = paramCursor.getString(i);
        } else if (dqn == k) {
          this.field_quanPin = paramCursor.getString(i);
        } else if (dqo == k) {
          this.field_showHead = paramCursor.getInt(i);
        } else if (type_HASHCODE == k) {
          this.field_type = paramCursor.getInt(i);
        } else if (dqp == k) {
          this.field_weiboFlag = paramCursor.getInt(i);
        } else if (dqq == k) {
          this.field_weiboNickname = paramCursor.getString(i);
        } else if (dqr == k) {
          this.field_conRemarkPYFull = paramCursor.getString(i);
        } else if (dqs == k) {
          this.field_conRemarkPYShort = paramCursor.getString(i);
        } else if (djB == k) {
          this.field_lvbuff = paramCursor.getBlob(i);
        } else if (dqt == k) {
          this.field_verifyFlag = paramCursor.getInt(i);
        } else if (dqu == k) {
          this.field_encryptUsername = paramCursor.getString(i);
        } else if (dqv == k) {
          this.field_chatroomFlag = paramCursor.getInt(i);
        } else if (dqw == k) {
          this.field_deleteFlag = paramCursor.getInt(i);
        } else if (dqx == k) {
          this.field_contactLabelIds = paramCursor.getString(i);
        } else if (dqy == k) {
          this.field_descWordingId = paramCursor.getString(i);
        } else if (dqz == k) {
          this.field_openImAppid = paramCursor.getString(i);
        } else if (dqA == k) {
          this.field_sourceExtInfo = paramCursor.getString(i);
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
      if (this.dje)
      {
        localObject = new y();
        ((y)localObject).dsv();
        ((y)localObject).Nd(this.dqB);
        ((y)localObject).Nd(this.dqC);
        ((y)localObject).ape(this.dqD);
        ((y)localObject).nN(this.dqE);
        ((y)localObject).Nd(this.uin);
        ((y)localObject).ape(this.dqF);
        ((y)localObject).ape(this.czF);
        ((y)localObject).Nd(this.dqG);
        ((y)localObject).Nd(this.dqH);
        ((y)localObject).ape(this.dqI);
        ((y)localObject).ape(this.dqJ);
        ((y)localObject).Nd(this.dqK);
        ((y)localObject).Nd(this.dqL);
        ((y)localObject).ape(this.signature);
        ((y)localObject).ape(this.province);
        ((y)localObject).ape(this.city);
        ((y)localObject).ape(this.dqM);
        ((y)localObject).Nd(this.dqN);
        ((y)localObject).Nd(this.cpt);
        ((y)localObject).ape(this.dqO);
        ((y)localObject).Nd(this.field_verifyFlag);
        ((y)localObject).ape(this.dqP);
        ((y)localObject).ape(this.dqQ);
        ((y)localObject).Nd(this.dqR);
        ((y)localObject).Nd(this.dqS);
        ((y)localObject).ape(this.dqT);
        ((y)localObject).ape(this.dqU);
        ((y)localObject).ape(this.dqV);
        ((y)localObject).ape(this.dqW);
        ((y)localObject).ape(this.dqX);
        ((y)localObject).ape(this.dqY);
        ((y)localObject).ape(this.dqZ);
        ((y)localObject).ape(this.dra);
        ((y)localObject).Nd(this.drb);
        ((y)localObject).ape(this.drc);
        ((y)localObject).Nd(this.drd);
        ((y)localObject).ape(this.dre);
        this.field_lvbuff = ((y)localObject).dsw();
      }
      Object localObject = new ContentValues();
      if (this.field_username == null) {
        this.field_username = "";
      }
      if (this.dhS) {
        ((ContentValues)localObject).put("username", this.field_username);
      }
      if (this.field_alias == null) {
        this.field_alias = "";
      }
      if (this.dpR) {
        ((ContentValues)localObject).put("alias", this.field_alias);
      }
      if (this.field_conRemark == null) {
        this.field_conRemark = "";
      }
      if (this.dpS) {
        ((ContentValues)localObject).put("conRemark", this.field_conRemark);
      }
      if (this.field_domainList == null) {
        this.field_domainList = "";
      }
      if (this.dpT) {
        ((ContentValues)localObject).put("domainList", this.field_domainList);
      }
      if (this.field_nickname == null) {
        this.field_nickname = "";
      }
      if (this.dmP) {
        ((ContentValues)localObject).put("nickname", this.field_nickname);
      }
      if (this.field_pyInitial == null) {
        this.field_pyInitial = "";
      }
      if (this.dpU) {
        ((ContentValues)localObject).put("pyInitial", this.field_pyInitial);
      }
      if (this.field_quanPin == null) {
        this.field_quanPin = "";
      }
      if (this.dpV) {
        ((ContentValues)localObject).put("quanPin", this.field_quanPin);
      }
      if (this.dpW) {
        ((ContentValues)localObject).put("showHead", Integer.valueOf(this.field_showHead));
      }
      if (this.__hadSettype) {
        ((ContentValues)localObject).put("type", Integer.valueOf(this.field_type));
      }
      if (this.dpX) {
        ((ContentValues)localObject).put("weiboFlag", Integer.valueOf(this.field_weiboFlag));
      }
      if (this.field_weiboNickname == null) {
        this.field_weiboNickname = "";
      }
      if (this.dpY) {
        ((ContentValues)localObject).put("weiboNickname", this.field_weiboNickname);
      }
      if (this.field_conRemarkPYFull == null) {
        this.field_conRemarkPYFull = "";
      }
      if (this.dpZ) {
        ((ContentValues)localObject).put("conRemarkPYFull", this.field_conRemarkPYFull);
      }
      if (this.field_conRemarkPYShort == null) {
        this.field_conRemarkPYShort = "";
      }
      if (this.dqa) {
        ((ContentValues)localObject).put("conRemarkPYShort", this.field_conRemarkPYShort);
      }
      if (this.dje) {
        ((ContentValues)localObject).put("lvbuff", this.field_lvbuff);
      }
      if (this.dqb) {
        ((ContentValues)localObject).put("verifyFlag", Integer.valueOf(this.field_verifyFlag));
      }
      if (this.field_encryptUsername == null) {
        this.field_encryptUsername = "";
      }
      if (this.dqc) {
        ((ContentValues)localObject).put("encryptUsername", this.field_encryptUsername);
      }
      if (this.dqd) {
        ((ContentValues)localObject).put("chatroomFlag", Integer.valueOf(this.field_chatroomFlag));
      }
      if (this.dqe) {
        ((ContentValues)localObject).put("deleteFlag", Integer.valueOf(this.field_deleteFlag));
      }
      if (this.field_contactLabelIds == null) {
        this.field_contactLabelIds = "";
      }
      if (this.dqf) {
        ((ContentValues)localObject).put("contactLabelIds", this.field_contactLabelIds);
      }
      if (this.field_descWordingId == null) {
        this.field_descWordingId = "";
      }
      if (this.dqg) {
        ((ContentValues)localObject).put("descWordingId", this.field_descWordingId);
      }
      if (this.dqh) {
        ((ContentValues)localObject).put("openImAppid", this.field_openImAppid);
      }
      if (this.dqi) {
        ((ContentValues)localObject).put("sourceExtInfo", this.field_sourceExtInfo);
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
        ab.e("MicroMsg.SDK.BaseContact", "get value failed, %s", new Object[] { localException.getMessage() });
      }
    }
  }
  
  public void fJ(long paramLong)
  {
    this.dqE = paramLong;
    this.dje = true;
  }
  
  public String getCity()
  {
    return this.city;
  }
  
  public String getProvince()
  {
    return this.province;
  }
  
  public int getSource()
  {
    return this.cpt;
  }
  
  public final String getUsername()
  {
    return this.field_username;
  }
  
  public void hA(int paramInt)
  {
    this.dqH = paramInt;
    this.dje = true;
  }
  
  public void hB(int paramInt)
  {
    this.dqK = paramInt;
    this.dje = true;
  }
  
  public void hC(int paramInt)
  {
    this.dqL = paramInt;
    this.dje = true;
  }
  
  public void hD(int paramInt)
  {
    this.dqN = paramInt;
    this.dje = true;
  }
  
  public void hE(int paramInt)
  {
    this.dqR = paramInt;
    this.dje = true;
  }
  
  public void hF(int paramInt)
  {
    this.dqS = paramInt;
    this.dje = true;
  }
  
  public final void hG(int paramInt)
  {
    this.drb = paramInt;
    this.dje = true;
  }
  
  public final void hH(int paramInt)
  {
    this.drd = paramInt;
    this.dje = true;
  }
  
  public void hs(int paramInt)
  {
    this.field_showHead = paramInt;
    this.dpW = true;
  }
  
  public void ht(int paramInt)
  {
    this.field_weiboFlag = paramInt;
    this.dpX = true;
  }
  
  public void hu(int paramInt)
  {
    this.field_verifyFlag = paramInt;
    this.dqb = true;
  }
  
  public void hv(int paramInt)
  {
    this.field_chatroomFlag = paramInt;
    this.dqd = true;
  }
  
  public void hw(int paramInt)
  {
    this.field_deleteFlag = paramInt;
    this.dqe = true;
  }
  
  public void hx(int paramInt)
  {
    this.dqB = paramInt;
    this.dje = true;
  }
  
  public void hy(int paramInt)
  {
    this.dqC = paramInt;
    this.dje = true;
  }
  
  public void hz(int paramInt)
  {
    this.dqG = paramInt;
    this.dje = true;
  }
  
  public void jA(String paramString)
  {
    this.dqD = paramString;
    this.dje = true;
  }
  
  public void jB(String paramString)
  {
    this.dqF = paramString;
    this.dje = true;
  }
  
  public void jC(String paramString)
  {
    this.czF = paramString;
    this.dje = true;
  }
  
  public void jD(String paramString)
  {
    this.dqI = paramString;
    this.dje = true;
  }
  
  public void jE(String paramString)
  {
    this.dqJ = paramString;
    this.dje = true;
  }
  
  public void jF(String paramString)
  {
    this.signature = paramString;
    this.dje = true;
  }
  
  public void jG(String paramString)
  {
    this.province = paramString;
    this.dje = true;
  }
  
  public void jH(String paramString)
  {
    this.city = paramString;
    this.dje = true;
  }
  
  public void jI(String paramString)
  {
    this.dqM = paramString;
    this.dje = true;
  }
  
  public void jJ(String paramString)
  {
    this.dqO = paramString;
    this.dje = true;
  }
  
  public void jK(String paramString)
  {
    this.dqP = paramString;
    this.dje = true;
  }
  
  public void jL(String paramString)
  {
    this.dqQ = paramString;
    this.dje = true;
  }
  
  public void jM(String paramString)
  {
    this.dqT = paramString;
    this.dje = true;
  }
  
  public void jN(String paramString)
  {
    this.dqU = paramString;
    this.dje = true;
  }
  
  public void jO(String paramString)
  {
    this.dqV = paramString;
    this.dje = true;
  }
  
  public void jP(String paramString)
  {
    this.dqW = paramString;
    this.dje = true;
  }
  
  public void jQ(String paramString)
  {
    this.dqX = paramString;
    this.dje = true;
  }
  
  public void jR(String paramString)
  {
    this.dqY = paramString;
    this.dje = true;
  }
  
  public void jS(String paramString)
  {
    this.dqZ = paramString;
    this.dje = true;
  }
  
  public void jT(String paramString)
  {
    this.dra = paramString;
    this.dje = true;
  }
  
  public final void jU(String paramString)
  {
    this.dre = paramString;
    this.dje = true;
  }
  
  public void jm(String paramString)
  {
    this.field_alias = paramString;
    this.dpR = true;
  }
  
  public void jn(String paramString)
  {
    this.field_conRemark = paramString;
    this.dpS = true;
  }
  
  public void jo(String paramString)
  {
    this.field_domainList = paramString;
    this.dpT = true;
  }
  
  public void jp(String paramString)
  {
    this.field_nickname = paramString;
    this.dmP = true;
  }
  
  public void jq(String paramString)
  {
    this.field_pyInitial = paramString;
    this.dpU = true;
  }
  
  public void jr(String paramString)
  {
    this.field_quanPin = paramString;
    this.dpV = true;
  }
  
  public void js(String paramString)
  {
    this.field_weiboNickname = paramString;
    this.dpY = true;
  }
  
  public void jt(String paramString)
  {
    this.field_conRemarkPYFull = paramString;
    this.dpZ = true;
  }
  
  public void ju(String paramString)
  {
    this.field_conRemarkPYShort = paramString;
    this.dqa = true;
  }
  
  public void jv(String paramString)
  {
    this.field_encryptUsername = paramString;
    this.dqc = true;
  }
  
  public void jw(String paramString)
  {
    this.field_contactLabelIds = paramString;
    this.dqf = true;
  }
  
  public final void jx(String paramString)
  {
    this.field_descWordingId = paramString;
    this.dqg = true;
  }
  
  public void jy(String paramString)
  {
    this.field_openImAppid = paramString;
    this.dqh = true;
  }
  
  public void jz(String paramString)
  {
    this.field_sourceExtInfo = paramString;
    this.dqi = true;
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
      y localy = new y();
      int i = localy.ca(this.field_lvbuff);
      if (i != 0)
      {
        ab.e("MicroMsg.SDK.BaseContact", "parse LVBuffer error:".concat(String.valueOf(i)));
        return;
      }
    }
    catch (Exception localException)
    {
      ab.e("MicroMsg.SDK.BaseContact", "get value failed");
      return;
    }
    this.dqB = localException.getInt();
    this.dqC = localException.getInt();
    this.dqD = localException.getString();
    this.dqE = localException.getLong();
    this.uin = localException.getInt();
    this.dqF = localException.getString();
    this.czF = localException.getString();
    this.dqG = localException.getInt();
    this.dqH = localException.getInt();
    this.dqI = localException.getString();
    this.dqJ = localException.getString();
    this.dqK = localException.getInt();
    this.dqL = localException.getInt();
    this.signature = localException.getString();
    this.province = localException.getString();
    this.city = localException.getString();
    this.dqM = localException.getString();
    this.dqN = localException.getInt();
    this.cpt = localException.getInt();
    this.dqO = localException.getString();
    this.field_verifyFlag = localException.getInt();
    this.dqP = localException.getString();
    if (!localException.dsu()) {
      this.dqQ = localException.getString();
    }
    if (!localException.dsu()) {
      this.dqR = localException.getInt();
    }
    if (!localException.dsu()) {
      this.dqS = localException.getInt();
    }
    if (!localException.dsu()) {
      this.dqT = localException.getString();
    }
    if (!localException.dsu()) {
      this.dqU = localException.getString();
    }
    if (!localException.dsu()) {
      this.dqV = localException.getString();
    }
    if (!localException.dsu()) {
      this.dqW = localException.getString();
    }
    if (!localException.dsu()) {
      this.dqX = localException.getString();
    }
    if (!localException.dsu()) {
      this.dqY = localException.getString();
    }
    if (!localException.dsu()) {
      this.dqZ = localException.getString();
    }
    if (!localException.dsu()) {
      this.dra = localException.getString();
    }
    if (!localException.dsu()) {
      this.drb = localException.getInt();
    }
    if (!localException.dsu()) {
      this.drc = localException.getString();
    }
    if (!localException.dsu()) {
      this.drd = localException.getInt();
    }
    if (!localException.dsu()) {
      this.dre = localException.getString();
    }
  }
  
  public void setSource(int paramInt)
  {
    this.cpt = paramInt;
    this.dje = true;
  }
  
  public void setType(int paramInt)
  {
    this.field_type = paramInt;
    this.__hadSettype = true;
  }
  
  public void setUin(int paramInt)
  {
    this.uin = paramInt;
    this.dje = true;
  }
  
  public void setUsername(String paramString)
  {
    this.field_username = paramString;
    this.dhS = true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.g.c.aq
 * JD-Core Version:    0.7.0.1
 */