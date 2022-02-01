package com.tencent.mm.plugin.game.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.f.c.dh;
import com.tencent.mm.sdk.storage.IAutoDBItem.MAutoDBInfo;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public final class o
  extends dh
{
  protected static IAutoDBItem.MAutoDBInfo info;
  public long CIV;
  private boolean CIW;
  public String CIX;
  public String CIY;
  public String CIZ;
  public boolean CIt;
  public String CJA;
  public String CJB;
  public String CJC;
  public String CJD;
  public String CJE;
  public String CJF;
  public String CJG;
  public String CJH;
  public String CJI;
  public String CJJ;
  public j CJK;
  public i CJL;
  public k CJM;
  public m CJN;
  public e CJO;
  public q CJP;
  public p CJQ;
  public o CJR;
  public d CJS;
  public n CJT;
  public c CJU;
  public int CJV;
  public int CJW;
  public String CJX;
  public String CJY;
  public String CJZ;
  public String CJa;
  public String CJb;
  public int CJc;
  public String CJd;
  public String CJe;
  public LinkedList<l> CJf;
  public boolean CJg;
  public g CJh;
  public boolean CJi;
  public f CJj;
  public HashMap<String, h> CJk;
  public String CJl;
  public int CJm;
  public int CJn;
  public int CJo;
  public String CJp;
  public String CJq;
  public String CJr;
  public int CJs;
  public int CJt;
  public long CJu;
  public long CJv;
  public int CJw;
  public b CJx;
  public String CJy;
  public String CJz;
  public int CKa;
  public String CKb;
  public boolean CKc;
  public String mAppName;
  public String uIi;
  
  static
  {
    AppMethodBeat.i(41454);
    IAutoDBItem.MAutoDBInfo localMAutoDBInfo = new IAutoDBItem.MAutoDBInfo();
    localMAutoDBInfo.fields = new Field[19];
    localMAutoDBInfo.columns = new String[20];
    StringBuilder localStringBuilder = new StringBuilder();
    localMAutoDBInfo.columns[0] = "msgId";
    localMAutoDBInfo.colsMap.put("msgId", "LONG PRIMARY KEY ");
    localStringBuilder.append(" msgId LONG PRIMARY KEY ");
    localStringBuilder.append(", ");
    localMAutoDBInfo.primaryKey = "msgId";
    localMAutoDBInfo.columns[1] = "mergerId";
    localMAutoDBInfo.colsMap.put("mergerId", "TEXT");
    localStringBuilder.append(" mergerId TEXT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[2] = "gameMsgId";
    localMAutoDBInfo.colsMap.put("gameMsgId", "TEXT");
    localStringBuilder.append(" gameMsgId TEXT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[3] = "msgType";
    localMAutoDBInfo.colsMap.put("msgType", "INTEGER");
    localStringBuilder.append(" msgType INTEGER");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[4] = "createTime";
    localMAutoDBInfo.colsMap.put("createTime", "LONG default '0' ");
    localStringBuilder.append(" createTime LONG default '0' ");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[5] = "expireTime";
    localMAutoDBInfo.colsMap.put("expireTime", "LONG default '0' ");
    localStringBuilder.append(" expireTime LONG default '0' ");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[6] = "appId";
    localMAutoDBInfo.colsMap.put("appId", "TEXT");
    localStringBuilder.append(" appId TEXT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[7] = "showInMsgList";
    localMAutoDBInfo.colsMap.put("showInMsgList", "INTEGER default 'true' ");
    localStringBuilder.append(" showInMsgList INTEGER default 'true' ");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[8] = "isRead";
    localMAutoDBInfo.colsMap.put("isRead", "INTEGER default 'false' ");
    localStringBuilder.append(" isRead INTEGER default 'false' ");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[9] = "label";
    localMAutoDBInfo.colsMap.put("label", "TEXT default '' ");
    localStringBuilder.append(" label TEXT default '' ");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[10] = "isHidden";
    localMAutoDBInfo.colsMap.put("isHidden", "INTEGER default 'false' ");
    localStringBuilder.append(" isHidden INTEGER default 'false' ");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[11] = "weight";
    localMAutoDBInfo.colsMap.put("weight", "TEXT default '' ");
    localStringBuilder.append(" weight TEXT default '' ");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[12] = "rawXML";
    localMAutoDBInfo.colsMap.put("rawXML", "TEXT default '' ");
    localStringBuilder.append(" rawXML TEXT default '' ");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[13] = "receiveTime";
    localMAutoDBInfo.colsMap.put("receiveTime", "LONG default '0' ");
    localStringBuilder.append(" receiveTime LONG default '0' ");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[14] = "showType";
    localMAutoDBInfo.colsMap.put("showType", "INTEGER default '0' ");
    localStringBuilder.append(" showType INTEGER default '0' ");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[15] = "interactiveMergeId";
    localMAutoDBInfo.colsMap.put("interactiveMergeId", "TEXT default '' ");
    localStringBuilder.append(" interactiveMergeId TEXT default '' ");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[16] = "hasMergedCount";
    localMAutoDBInfo.colsMap.put("hasMergedCount", "INTEGER default '1' ");
    localStringBuilder.append(" hasMergedCount INTEGER default '1' ");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[17] = "redDotExpireTime";
    localMAutoDBInfo.colsMap.put("redDotExpireTime", "LONG default '0' ");
    localStringBuilder.append(" redDotExpireTime LONG default '0' ");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[18] = "needReport";
    localMAutoDBInfo.colsMap.put("needReport", "INTEGER default 'false' ");
    localStringBuilder.append(" needReport INTEGER default 'false' ");
    localMAutoDBInfo.columns[19] = "rowid";
    localMAutoDBInfo.sql = localStringBuilder.toString();
    info = localMAutoDBInfo;
    AppMethodBeat.o(41454);
  }
  
  public o()
  {
    AppMethodBeat.i(41452);
    this.CIV = 0L;
    this.CIW = false;
    this.uIi = "";
    this.CIX = "";
    this.CIY = "";
    this.mAppName = "";
    this.CIZ = "";
    this.CJa = "";
    this.CJb = "";
    this.CJc = 0;
    this.CJd = "";
    this.CJe = "";
    this.CJf = new LinkedList();
    this.CJh = new g();
    this.CJj = new f();
    this.CJk = new HashMap();
    this.CJl = "";
    this.CJm = 0;
    this.CJn = 0;
    this.CJo = 0;
    this.CJp = "";
    this.CJq = "";
    this.CJr = "";
    this.CJs = 0;
    this.CJt = 0;
    this.CJu = 0L;
    this.CJv = 0L;
    this.CJw = 0;
    this.CJx = new b();
    this.CJy = "";
    this.CJz = "";
    this.CJA = "";
    this.CJB = "";
    this.CJC = "";
    this.CJD = "";
    this.CJE = "";
    this.CJL = new i();
    this.CJM = new k();
    this.CJN = new m();
    this.CJO = new e();
    this.CJP = new q();
    this.CJQ = new p();
    this.CJR = new o();
    this.CJS = new d();
    this.CJT = new n();
    this.CJU = new c();
    this.CIt = false;
    this.CKa = 0;
    this.CKb = "";
    this.CKc = false;
    AppMethodBeat.o(41452);
  }
  
  public final void eyt()
  {
    AppMethodBeat.i(41453);
    if (this.CIW)
    {
      AppMethodBeat.o(41453);
      return;
    }
    if (this.field_msgType == 100)
    {
      u.eyK();
      u.a(this);
    }
    for (;;)
    {
      q.b(this);
      this.CIW = true;
      AppMethodBeat.o(41453);
      return;
      q.a(this);
    }
  }
  
  public final IAutoDBItem.MAutoDBInfo getDBInfo()
  {
    return info;
  }
  
  public static final class a
  {
    public String CKd;
  }
  
  public static final class b
  {
    public List<String> CKe;
    public boolean CzQ;
    public int FO;
    public boolean cpf;
    public String url;
    
    public b()
    {
      AppMethodBeat.i(41450);
      this.CKe = new ArrayList();
      AppMethodBeat.o(41450);
    }
  }
  
  public static final class c
  {
    public String CKf;
  }
  
  public static final class d
  {
    public boolean CKg;
    public o.a CKh;
    public boolean fQf;
    
    public d()
    {
      AppMethodBeat.i(198131);
      this.CKg = false;
      this.fQf = false;
      this.CKh = new o.a();
      AppMethodBeat.o(198131);
    }
  }
  
  public static final class e
  {
    public List<String> CKe;
    public String CKi;
    
    public e()
    {
      AppMethodBeat.i(41451);
      this.CKe = new ArrayList();
      AppMethodBeat.o(41451);
    }
  }
  
  public static final class f
  {
    public String CKj;
    public String CKk;
    public String mDesc;
  }
  
  public static final class g
  {
    public String CKj;
    public int CKl;
    public boolean CKm;
    public int CKn;
    public boolean CKo;
    public int mIconHeight;
    public int mIconWidth;
    public String mText;
  }
  
  public static final class h
  {
    public int mJumpType;
    public String vnr;
  }
  
  public static final class i
  {
    public String CKj;
    public String CKk;
    public String mContent;
  }
  
  public static final class j
  {
    public String CKk;
    public String CKp;
    public String CKq;
    public String CKr;
  }
  
  public static final class k
  {
    public String CKk;
    public boolean mClickable;
    public String mName;
  }
  
  public static final class l
  {
    public String CKs;
    public String CKt;
    public String CKu;
    public String CKv;
    public String nickName;
    public String userName;
  }
  
  public static final class m
  {
    public String CKw;
    public long CKx = 0L;
    public int ttm = 0;
  }
  
  public static final class n
  {
    public long CKA;
    public String CKy;
    public String CKz;
  }
  
  public static final class o
  {
    public String CKB;
    public int CKC;
    public int CKD;
    public String CKE;
    public String CKF;
    public String CKG;
    public String CKH;
    public String CKI;
    public String CKJ;
    public String CKK;
    public int CKL;
    public String CKM;
    public String CKN;
    public String CKO;
    public String CKP;
    public String CKQ;
  }
  
  public static final class p
  {
    public int CKR = 0;
    public int CKS;
    public Boolean fUv = null;
    public String lwD;
  }
  
  public static final class q
  {
    public int CKT;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.game.model.o
 * JD-Core Version:    0.7.0.1
 */