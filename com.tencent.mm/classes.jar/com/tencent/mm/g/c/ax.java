package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.platformtools.LVBuffer;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.storage.IAutoDBItem;

public abstract class ax
  extends IAutoDBItem
{
  public static final String[] INDEX_CREATE = { "CREATE INDEX IF NOT EXISTS deleteflag_index ON Contact(deleteFlag)" };
  private static final int fjR = "ticket".hashCode();
  private static final int fmw;
  private static final int fqf;
  private static final int fuh;
  private static final int fui;
  private static final int fuj;
  private static final int fuk;
  private static final int ful;
  private static final int fum;
  private static final int fun;
  private static final int fuo;
  private static final int fup;
  private static final int fuq;
  private static final int fur;
  private static final int fus;
  private static final int fut;
  private static final int fuu;
  private static final int fuv;
  private static final int fuw;
  private static final int fux;
  private static final int fuy;
  private static final int rowid_HASHCODE = "rowid".hashCode();
  private static final int type_HASHCODE;
  private static final int username_HASHCODE = "username".hashCode();
  private boolean __hadSettype = false;
  private boolean __hadSetusername = false;
  public String dSf;
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
  private boolean fjP = false;
  private boolean fma = false;
  private boolean fqb = false;
  protected int fromType;
  private boolean ftP = false;
  private boolean ftQ = false;
  private boolean ftR = false;
  private boolean ftS = false;
  private boolean ftT = false;
  private boolean ftU = false;
  private boolean ftV = false;
  private boolean ftW = false;
  private boolean ftX = false;
  private boolean ftY = false;
  private boolean ftZ = false;
  public int fuA;
  public String fuB;
  protected long fuC;
  protected String fuD;
  public int fuE;
  protected String fuF;
  protected String fuG;
  public int fuH;
  public int fuI;
  private String fuJ;
  private String fuK;
  public String fuL;
  public String fuM;
  public String fuN;
  public String fuO;
  public int fuP;
  public int fuQ;
  public String fuR;
  public String fuS;
  public String fuT;
  public String fuU;
  public String fuV;
  public String fuW;
  public String fuX;
  public String fuY;
  private String fuZ;
  private boolean fua = false;
  private boolean fub = false;
  private boolean fuc = false;
  private boolean fud = false;
  private boolean fue = false;
  private boolean fuf = false;
  private boolean fug = false;
  public int fuz;
  public int fva;
  public String fvb;
  public int fvc;
  public long fvd;
  public long fve;
  protected int showFlag;
  public String signature;
  private int source;
  public int uin;
  
  static
  {
    fuh = "alias".hashCode();
    fui = "conRemark".hashCode();
    fuj = "domainList".hashCode();
    fqf = "nickname".hashCode();
    fuk = "pyInitial".hashCode();
    ful = "quanPin".hashCode();
    fum = "showHead".hashCode();
    type_HASHCODE = "type".hashCode();
    fun = "weiboFlag".hashCode();
    fuo = "weiboNickname".hashCode();
    fup = "conRemarkPYFull".hashCode();
    fuq = "conRemarkPYShort".hashCode();
    fmw = "lvbuff".hashCode();
    fur = "verifyFlag".hashCode();
    fus = "encryptUsername".hashCode();
    fut = "chatroomFlag".hashCode();
    fuu = "deleteFlag".hashCode();
    fuv = "contactLabelIds".hashCode();
    fuw = "descWordingId".hashCode();
    fux = "openImAppid".hashCode();
    fuy = "sourceExtInfo".hashCode();
  }
  
  public void BC(String paramString)
  {
    this.field_alias = paramString;
    this.ftP = true;
  }
  
  public void BD(String paramString)
  {
    this.field_conRemark = paramString;
    this.ftQ = true;
  }
  
  public void BE(String paramString)
  {
    this.field_domainList = paramString;
    this.ftR = true;
  }
  
  public void BF(String paramString)
  {
    this.field_pyInitial = paramString;
    this.ftS = true;
  }
  
  public void BG(String paramString)
  {
    this.field_quanPin = paramString;
    this.ftT = true;
  }
  
  public void BH(String paramString)
  {
    this.field_weiboNickname = paramString;
    this.ftW = true;
  }
  
  public void BI(String paramString)
  {
    this.field_conRemarkPYFull = paramString;
    this.ftX = true;
  }
  
  public void BJ(String paramString)
  {
    this.field_conRemarkPYShort = paramString;
    this.ftY = true;
  }
  
  public void BK(String paramString)
  {
    this.field_encryptUsername = paramString;
    this.fua = true;
  }
  
  public void BL(String paramString)
  {
    this.field_contactLabelIds = paramString;
    this.fud = true;
  }
  
  public final void BM(String paramString)
  {
    this.field_descWordingId = paramString;
    this.fue = true;
  }
  
  public void BN(String paramString)
  {
    this.field_openImAppid = paramString;
    this.fuf = true;
  }
  
  public void BO(String paramString)
  {
    this.field_sourceExtInfo = paramString;
    this.fug = true;
  }
  
  public void BP(String paramString)
  {
    this.field_ticket = paramString;
    this.fjP = true;
  }
  
  public void BQ(String paramString)
  {
    this.fuB = paramString;
    this.fma = true;
  }
  
  public void BR(String paramString)
  {
    this.fuD = paramString;
    this.fma = true;
  }
  
  public void BS(String paramString)
  {
    this.dSf = paramString;
    this.fma = true;
  }
  
  public void BT(String paramString)
  {
    this.fuF = paramString;
    this.fma = true;
  }
  
  public void BU(String paramString)
  {
    this.fuG = paramString;
    this.fma = true;
  }
  
  public void BV(String paramString)
  {
    this.signature = paramString;
    this.fma = true;
  }
  
  public void BW(String paramString)
  {
    this.fuJ = paramString;
    this.fma = true;
  }
  
  public void BX(String paramString)
  {
    this.fuK = paramString;
    this.fma = true;
  }
  
  public void BY(String paramString)
  {
    this.fuL = paramString;
    this.fma = true;
  }
  
  public void BZ(String paramString)
  {
    this.fuM = paramString;
    this.fma = true;
  }
  
  public void Ca(String paramString)
  {
    this.fuN = paramString;
    this.fma = true;
  }
  
  public void Cb(String paramString)
  {
    this.fuO = paramString;
    this.fma = true;
  }
  
  public void Cc(String paramString)
  {
    this.fuR = paramString;
    this.fma = true;
  }
  
  public void Cd(String paramString)
  {
    this.fuS = paramString;
    this.fma = true;
  }
  
  public void Ce(String paramString)
  {
    this.fuT = paramString;
    this.fma = true;
  }
  
  public void Cf(String paramString)
  {
    this.fuU = paramString;
    this.fma = true;
  }
  
  public void Cg(String paramString)
  {
    this.fuV = paramString;
    this.fma = true;
  }
  
  public void Ch(String paramString)
  {
    this.fuW = paramString;
    this.fma = true;
  }
  
  public void Ci(String paramString)
  {
    this.fuX = paramString;
    this.fma = true;
  }
  
  public void Cj(String paramString)
  {
    this.fuY = paramString;
    this.fma = true;
  }
  
  public final void Ck(String paramString)
  {
    this.fvb = paramString;
    this.fma = true;
  }
  
  public void Z(byte[] paramArrayOfByte)
  {
    this.field_lvbuff = paramArrayOfByte;
    this.fma = true;
  }
  
  public String ajA()
  {
    return this.field_quanPin;
  }
  
  public final String ajB()
  {
    return this.field_encryptUsername;
  }
  
  public final String ajC()
  {
    return this.field_descWordingId;
  }
  
  public final String ajD()
  {
    return this.field_openImAppid;
  }
  
  public final int ajE()
  {
    return this.fuA;
  }
  
  public final void ajF()
  {
    this.fvc = 1;
    this.fma = true;
  }
  
  public String ajx()
  {
    return this.field_alias;
  }
  
  public final String ajy()
  {
    return this.field_conRemark;
  }
  
  public String ajz()
  {
    return this.field_pyInitial;
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
        if (fuh == k) {
          this.field_alias = paramCursor.getString(i);
        } else if (fui == k) {
          this.field_conRemark = paramCursor.getString(i);
        } else if (fuj == k) {
          this.field_domainList = paramCursor.getString(i);
        } else if (fqf == k) {
          this.field_nickname = paramCursor.getString(i);
        } else if (fuk == k) {
          this.field_pyInitial = paramCursor.getString(i);
        } else if (ful == k) {
          this.field_quanPin = paramCursor.getString(i);
        } else if (fum == k) {
          this.field_showHead = paramCursor.getInt(i);
        } else if (type_HASHCODE == k) {
          this.field_type = paramCursor.getInt(i);
        } else if (fun == k) {
          this.field_weiboFlag = paramCursor.getInt(i);
        } else if (fuo == k) {
          this.field_weiboNickname = paramCursor.getString(i);
        } else if (fup == k) {
          this.field_conRemarkPYFull = paramCursor.getString(i);
        } else if (fuq == k) {
          this.field_conRemarkPYShort = paramCursor.getString(i);
        } else if (fmw == k) {
          this.field_lvbuff = paramCursor.getBlob(i);
        } else if (fur == k) {
          this.field_verifyFlag = paramCursor.getInt(i);
        } else if (fus == k) {
          this.field_encryptUsername = paramCursor.getString(i);
        } else if (fut == k) {
          this.field_chatroomFlag = paramCursor.getInt(i);
        } else if (fuu == k) {
          this.field_deleteFlag = paramCursor.getInt(i);
        } else if (fuv == k) {
          this.field_contactLabelIds = paramCursor.getString(i);
        } else if (fuw == k) {
          this.field_descWordingId = paramCursor.getString(i);
        } else if (fux == k) {
          this.field_openImAppid = paramCursor.getString(i);
        } else if (fuy == k) {
          this.field_sourceExtInfo = paramCursor.getString(i);
        } else if (fjR == k) {
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
      if (this.fma)
      {
        localObject = new LVBuffer();
        ((LVBuffer)localObject).initBuild();
        ((LVBuffer)localObject).putInt(this.fuz);
        ((LVBuffer)localObject).putInt(this.fuA);
        ((LVBuffer)localObject).putString(this.fuB);
        ((LVBuffer)localObject).putLong(this.fuC);
        ((LVBuffer)localObject).putInt(this.uin);
        ((LVBuffer)localObject).putString(this.fuD);
        ((LVBuffer)localObject).putString(this.dSf);
        ((LVBuffer)localObject).putInt(this.showFlag);
        ((LVBuffer)localObject).putInt(this.fuE);
        ((LVBuffer)localObject).putString(this.fuF);
        ((LVBuffer)localObject).putString(this.fuG);
        ((LVBuffer)localObject).putInt(this.fuH);
        ((LVBuffer)localObject).putInt(this.fuI);
        ((LVBuffer)localObject).putString(this.signature);
        ((LVBuffer)localObject).putString(this.fuJ);
        ((LVBuffer)localObject).putString(this.fuK);
        ((LVBuffer)localObject).putString(this.fuL);
        ((LVBuffer)localObject).putInt(this.fromType);
        ((LVBuffer)localObject).putInt(this.source);
        ((LVBuffer)localObject).putString(this.fuM);
        ((LVBuffer)localObject).putInt(this.field_verifyFlag);
        ((LVBuffer)localObject).putString(this.fuN);
        ((LVBuffer)localObject).putString(this.fuO);
        ((LVBuffer)localObject).putInt(this.fuP);
        ((LVBuffer)localObject).putInt(this.fuQ);
        ((LVBuffer)localObject).putString(this.fuR);
        ((LVBuffer)localObject).putString(this.fuS);
        ((LVBuffer)localObject).putString(this.fuT);
        ((LVBuffer)localObject).putString(this.fuU);
        ((LVBuffer)localObject).putString(this.fuV);
        ((LVBuffer)localObject).putString(this.fuW);
        ((LVBuffer)localObject).putString(this.fuX);
        ((LVBuffer)localObject).putString(this.fuY);
        ((LVBuffer)localObject).putInt(this.extFlag);
        ((LVBuffer)localObject).putString(this.fuZ);
        ((LVBuffer)localObject).putInt(this.fva);
        ((LVBuffer)localObject).putString(this.fvb);
        ((LVBuffer)localObject).putInt(this.fvc);
        ((LVBuffer)localObject).putLong(this.fvd);
        ((LVBuffer)localObject).putLong(this.fve);
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
      if (this.ftP) {
        ((ContentValues)localObject).put("alias", this.field_alias);
      }
      if (this.field_conRemark == null) {
        this.field_conRemark = "";
      }
      if (this.ftQ) {
        ((ContentValues)localObject).put("conRemark", this.field_conRemark);
      }
      if (this.field_domainList == null) {
        this.field_domainList = "";
      }
      if (this.ftR) {
        ((ContentValues)localObject).put("domainList", this.field_domainList);
      }
      if (this.field_nickname == null) {
        this.field_nickname = "";
      }
      if (this.fqb) {
        ((ContentValues)localObject).put("nickname", this.field_nickname);
      }
      if (this.field_pyInitial == null) {
        this.field_pyInitial = "";
      }
      if (this.ftS) {
        ((ContentValues)localObject).put("pyInitial", this.field_pyInitial);
      }
      if (this.field_quanPin == null) {
        this.field_quanPin = "";
      }
      if (this.ftT) {
        ((ContentValues)localObject).put("quanPin", this.field_quanPin);
      }
      if (this.ftU) {
        ((ContentValues)localObject).put("showHead", Integer.valueOf(this.field_showHead));
      }
      if (this.__hadSettype) {
        ((ContentValues)localObject).put("type", Integer.valueOf(this.field_type));
      }
      if (this.ftV) {
        ((ContentValues)localObject).put("weiboFlag", Integer.valueOf(this.field_weiboFlag));
      }
      if (this.field_weiboNickname == null) {
        this.field_weiboNickname = "";
      }
      if (this.ftW) {
        ((ContentValues)localObject).put("weiboNickname", this.field_weiboNickname);
      }
      if (this.field_conRemarkPYFull == null) {
        this.field_conRemarkPYFull = "";
      }
      if (this.ftX) {
        ((ContentValues)localObject).put("conRemarkPYFull", this.field_conRemarkPYFull);
      }
      if (this.field_conRemarkPYShort == null) {
        this.field_conRemarkPYShort = "";
      }
      if (this.ftY) {
        ((ContentValues)localObject).put("conRemarkPYShort", this.field_conRemarkPYShort);
      }
      if (this.fma) {
        ((ContentValues)localObject).put("lvbuff", this.field_lvbuff);
      }
      if (this.ftZ) {
        ((ContentValues)localObject).put("verifyFlag", Integer.valueOf(this.field_verifyFlag));
      }
      if (this.field_encryptUsername == null) {
        this.field_encryptUsername = "";
      }
      if (this.fua) {
        ((ContentValues)localObject).put("encryptUsername", this.field_encryptUsername);
      }
      if (this.fub) {
        ((ContentValues)localObject).put("chatroomFlag", Integer.valueOf(this.field_chatroomFlag));
      }
      if (this.fuc) {
        ((ContentValues)localObject).put("deleteFlag", Integer.valueOf(this.field_deleteFlag));
      }
      if (this.field_contactLabelIds == null) {
        this.field_contactLabelIds = "";
      }
      if (this.fud) {
        ((ContentValues)localObject).put("contactLabelIds", this.field_contactLabelIds);
      }
      if (this.field_descWordingId == null) {
        this.field_descWordingId = "";
      }
      if (this.fue) {
        ((ContentValues)localObject).put("descWordingId", this.field_descWordingId);
      }
      if (this.fuf) {
        ((ContentValues)localObject).put("openImAppid", this.field_openImAppid);
      }
      if (this.fug) {
        ((ContentValues)localObject).put("sourceExtInfo", this.field_sourceExtInfo);
      }
      if (this.field_ticket == null) {
        this.field_ticket = "";
      }
      if (this.fjP) {
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
        Log.e("MicroMsg.SDK.BaseContact", "get value failed, %s", new Object[] { localException.getMessage() });
      }
    }
  }
  
  public String getCity()
  {
    return this.fuK;
  }
  
  public final int getFromType()
  {
    return this.fromType;
  }
  
  public final String getNickname()
  {
    return this.field_nickname;
  }
  
  public String getProvince()
  {
    return this.fuJ;
  }
  
  public final String getSignature()
  {
    return this.signature;
  }
  
  public int getSource()
  {
    return this.source;
  }
  
  public final String getUsername()
  {
    return this.field_username;
  }
  
  public void nd(int paramInt)
  {
    this.field_showHead = paramInt;
    this.ftU = true;
  }
  
  public void ne(int paramInt)
  {
    this.field_weiboFlag = paramInt;
    this.ftV = true;
  }
  
  public void nf(int paramInt)
  {
    this.field_verifyFlag = paramInt;
    this.ftZ = true;
  }
  
  public void ng(int paramInt)
  {
    this.field_chatroomFlag = paramInt;
    this.fub = true;
  }
  
  public void nh(int paramInt)
  {
    this.field_deleteFlag = paramInt;
    this.fuc = true;
  }
  
  public void ni(int paramInt)
  {
    this.fuz = paramInt;
    this.fma = true;
  }
  
  public void nj(int paramInt)
  {
    this.fuA = paramInt;
    this.fma = true;
  }
  
  public void nk(int paramInt)
  {
    this.showFlag = paramInt;
    this.fma = true;
  }
  
  public void nl(int paramInt)
  {
    this.fuE = paramInt;
    this.fma = true;
  }
  
  public void nm(int paramInt)
  {
    this.fuH = paramInt;
    this.fma = true;
  }
  
  public void nn(int paramInt)
  {
    this.fuI = paramInt;
    this.fma = true;
  }
  
  public void no(int paramInt)
  {
    this.fuP = paramInt;
    this.fma = true;
  }
  
  public void np(int paramInt)
  {
    this.fuQ = paramInt;
    this.fma = true;
  }
  
  public final void nq(int paramInt)
  {
    this.extFlag = paramInt;
    this.fma = true;
  }
  
  public final void nr(int paramInt)
  {
    this.fva = paramInt;
    this.fma = true;
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
    this.fuz = localException.getInt();
    this.fuA = localException.getInt();
    this.fuB = localException.getString();
    this.fuC = localException.getLong();
    this.uin = localException.getInt();
    this.fuD = localException.getString();
    this.dSf = localException.getString();
    this.showFlag = localException.getInt();
    this.fuE = localException.getInt();
    this.fuF = localException.getString();
    this.fuG = localException.getString();
    this.fuH = localException.getInt();
    this.fuI = localException.getInt();
    this.signature = localException.getString();
    this.fuJ = localException.getString();
    this.fuK = localException.getString();
    this.fuL = localException.getString();
    this.fromType = localException.getInt();
    this.source = localException.getInt();
    this.fuM = localException.getString();
    this.field_verifyFlag = localException.getInt();
    this.fuN = localException.getString();
    if (!localException.checkGetFinish()) {
      this.fuO = localException.getString();
    }
    if (!localException.checkGetFinish()) {
      this.fuP = localException.getInt();
    }
    if (!localException.checkGetFinish()) {
      this.fuQ = localException.getInt();
    }
    if (!localException.checkGetFinish()) {
      this.fuR = localException.getString();
    }
    if (!localException.checkGetFinish()) {
      this.fuS = localException.getString();
    }
    if (!localException.checkGetFinish()) {
      this.fuT = localException.getString();
    }
    if (!localException.checkGetFinish()) {
      this.fuU = localException.getString();
    }
    if (!localException.checkGetFinish()) {
      this.fuV = localException.getString();
    }
    if (!localException.checkGetFinish()) {
      this.fuW = localException.getString();
    }
    if (!localException.checkGetFinish()) {
      this.fuX = localException.getString();
    }
    if (!localException.checkGetFinish()) {
      this.fuY = localException.getString();
    }
    if (!localException.checkGetFinish()) {
      this.extFlag = localException.getInt();
    }
    if (!localException.checkGetFinish()) {
      this.fuZ = localException.getString();
    }
    if (!localException.checkGetFinish()) {
      this.fva = localException.getInt();
    }
    if (!localException.checkGetFinish()) {
      this.fvb = localException.getString();
    }
    if (!localException.checkGetFinish()) {
      this.fvc = localException.getInt();
    }
    if (!localException.checkGetFinish()) {
      this.fvd = localException.getLong();
    }
    if (!localException.checkGetFinish()) {
      this.fve = localException.getLong();
    }
  }
  
  public void setFromType(int paramInt)
  {
    this.fromType = paramInt;
    this.fma = true;
  }
  
  public void setNickname(String paramString)
  {
    this.field_nickname = paramString;
    this.fqb = true;
  }
  
  public void setSource(int paramInt)
  {
    this.source = paramInt;
    this.fma = true;
  }
  
  public void setType(int paramInt)
  {
    this.field_type = paramInt;
    this.__hadSettype = true;
  }
  
  public void setUin(int paramInt)
  {
    this.uin = paramInt;
    this.fma = true;
  }
  
  public void setUsername(String paramString)
  {
    this.field_username = paramString;
    this.__hadSetusername = true;
  }
  
  public void yx(long paramLong)
  {
    this.fuC = paramLong;
    this.fma = true;
  }
  
  public void yy(long paramLong)
  {
    this.fvd = paramLong;
    this.fma = true;
  }
  
  public void yz(long paramLong)
  {
    this.fve = paramLong;
    this.fma = true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.g.c.ax
 * JD-Core Version:    0.7.0.1
 */