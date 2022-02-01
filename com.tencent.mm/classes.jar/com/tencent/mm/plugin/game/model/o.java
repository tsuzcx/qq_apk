package com.tencent.mm.plugin.game.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.cp;
import com.tencent.mm.sdk.e.c.a;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public final class o
  extends cp
{
  protected static c.a info;
  public String mAppName;
  public String pey;
  public long tdK;
  private boolean tdL;
  public String tdM;
  public String tdN;
  public String tdO;
  public String tdP;
  public String tdQ;
  public int tdR;
  public String tdS;
  public String tdT;
  public LinkedList<i> tdU;
  public boolean tdV;
  public d tdW;
  public boolean tdX;
  public c tdY;
  public HashMap<String, e> tdZ;
  public boolean tdi;
  public f teA;
  public h teB;
  public j teC;
  public b teD;
  public m teE;
  public l teF;
  public k teG;
  public int teH;
  public int teI;
  public String teJ;
  public String teK;
  public String teL;
  public int teM;
  public String teN;
  public boolean teO;
  public String tea;
  public int teb;
  public int tec;
  public int ted;
  public String tee;
  public String tef;
  public String teg;
  public int teh;
  public int tei;
  public long tej;
  public long tek;
  public int tel;
  public a tem;
  public String ten;
  public String teo;
  public String tep;
  public String teq;
  public String ter;
  public String tes;
  public String tet;
  public String teu;
  public String tev;
  public String tew;
  public String tex;
  public String tey;
  public g tez;
  
  static
  {
    AppMethodBeat.i(41454);
    c.a locala = new c.a();
    locala.GvF = new Field[17];
    locala.columns = new String[18];
    StringBuilder localStringBuilder = new StringBuilder();
    locala.columns[0] = "msgId";
    locala.GvH.put("msgId", "LONG PRIMARY KEY ");
    localStringBuilder.append(" msgId LONG PRIMARY KEY ");
    localStringBuilder.append(", ");
    locala.GvG = "msgId";
    locala.columns[1] = "mergerId";
    locala.GvH.put("mergerId", "TEXT");
    localStringBuilder.append(" mergerId TEXT");
    localStringBuilder.append(", ");
    locala.columns[2] = "gameMsgId";
    locala.GvH.put("gameMsgId", "TEXT");
    localStringBuilder.append(" gameMsgId TEXT");
    localStringBuilder.append(", ");
    locala.columns[3] = "msgType";
    locala.GvH.put("msgType", "INTEGER");
    localStringBuilder.append(" msgType INTEGER");
    localStringBuilder.append(", ");
    locala.columns[4] = "createTime";
    locala.GvH.put("createTime", "LONG default '0' ");
    localStringBuilder.append(" createTime LONG default '0' ");
    localStringBuilder.append(", ");
    locala.columns[5] = "expireTime";
    locala.GvH.put("expireTime", "LONG default '0' ");
    localStringBuilder.append(" expireTime LONG default '0' ");
    localStringBuilder.append(", ");
    locala.columns[6] = "appId";
    locala.GvH.put("appId", "TEXT");
    localStringBuilder.append(" appId TEXT");
    localStringBuilder.append(", ");
    locala.columns[7] = "showInMsgList";
    locala.GvH.put("showInMsgList", "INTEGER default 'true' ");
    localStringBuilder.append(" showInMsgList INTEGER default 'true' ");
    localStringBuilder.append(", ");
    locala.columns[8] = "isRead";
    locala.GvH.put("isRead", "INTEGER default 'false' ");
    localStringBuilder.append(" isRead INTEGER default 'false' ");
    localStringBuilder.append(", ");
    locala.columns[9] = "label";
    locala.GvH.put("label", "TEXT default '' ");
    localStringBuilder.append(" label TEXT default '' ");
    localStringBuilder.append(", ");
    locala.columns[10] = "isHidden";
    locala.GvH.put("isHidden", "INTEGER default 'false' ");
    localStringBuilder.append(" isHidden INTEGER default 'false' ");
    localStringBuilder.append(", ");
    locala.columns[11] = "weight";
    locala.GvH.put("weight", "TEXT default '' ");
    localStringBuilder.append(" weight TEXT default '' ");
    localStringBuilder.append(", ");
    locala.columns[12] = "rawXML";
    locala.GvH.put("rawXML", "TEXT default '' ");
    localStringBuilder.append(" rawXML TEXT default '' ");
    localStringBuilder.append(", ");
    locala.columns[13] = "receiveTime";
    locala.GvH.put("receiveTime", "LONG default '0' ");
    localStringBuilder.append(" receiveTime LONG default '0' ");
    localStringBuilder.append(", ");
    locala.columns[14] = "showType";
    locala.GvH.put("showType", "INTEGER default '0' ");
    localStringBuilder.append(" showType INTEGER default '0' ");
    localStringBuilder.append(", ");
    locala.columns[15] = "interactiveMergeId";
    locala.GvH.put("interactiveMergeId", "TEXT default '' ");
    localStringBuilder.append(" interactiveMergeId TEXT default '' ");
    localStringBuilder.append(", ");
    locala.columns[16] = "hasMergedCount";
    locala.GvH.put("hasMergedCount", "INTEGER default '1' ");
    localStringBuilder.append(" hasMergedCount INTEGER default '1' ");
    locala.columns[17] = "rowid";
    locala.sql = localStringBuilder.toString();
    info = locala;
    AppMethodBeat.o(41454);
  }
  
  public o()
  {
    AppMethodBeat.i(41452);
    this.tdK = 0L;
    this.tdL = false;
    this.pey = "";
    this.tdM = "";
    this.tdN = "";
    this.mAppName = "";
    this.tdO = "";
    this.tdP = "";
    this.tdQ = "";
    this.tdR = 0;
    this.tdS = "";
    this.tdT = "";
    this.tdU = new LinkedList();
    this.tdW = new d();
    this.tdY = new c();
    this.tdZ = new HashMap();
    this.tea = "";
    this.teb = 0;
    this.tec = 0;
    this.ted = 0;
    this.tee = "";
    this.tef = "";
    this.teg = "";
    this.teh = 0;
    this.tei = 0;
    this.tej = 0L;
    this.tek = 0L;
    this.tel = 0;
    this.tem = new a();
    this.ten = "";
    this.teo = "";
    this.tep = "";
    this.teq = "";
    this.ter = "";
    this.tes = "";
    this.tet = "";
    this.teA = new f();
    this.teB = new h();
    this.teC = new j();
    this.teD = new b();
    this.teE = new m();
    this.teF = new l();
    this.teG = new k();
    this.tdi = false;
    this.teM = 0;
    this.teN = "";
    this.teO = false;
    AppMethodBeat.o(41452);
  }
  
  public final void cQp()
  {
    AppMethodBeat.i(41453);
    if (this.tdL)
    {
      AppMethodBeat.o(41453);
      return;
    }
    if (this.field_msgType == 100)
    {
      u.cQE();
      u.a(this);
    }
    for (;;)
    {
      q.b(this);
      this.tdL = true;
      AppMethodBeat.o(41453);
      return;
      q.a(this);
    }
  }
  
  public final boolean cmf()
  {
    return this.teF.tfy == 0;
  }
  
  public final c.a getDBInfo()
  {
    return info;
  }
  
  public static final class a
  {
    public int orientation;
    public boolean sWB;
    public boolean teP;
    public List<String> teQ;
    public String url;
    
    public a()
    {
      AppMethodBeat.i(41450);
      this.teQ = new ArrayList();
      AppMethodBeat.o(41450);
    }
  }
  
  public static final class b
  {
    public List<String> teQ;
    public String teR;
    
    public b()
    {
      AppMethodBeat.i(41451);
      this.teQ = new ArrayList();
      AppMethodBeat.o(41451);
    }
  }
  
  public static final class c
  {
    public String mDesc;
    public String teS;
    public String teT;
  }
  
  public static final class d
  {
    public String mText;
    public String teS;
    public int teU;
    public int teV;
    public int teW;
    public boolean teX;
    public int teY;
    public boolean teZ;
  }
  
  public static final class e
  {
    public int mJumpType;
    public String pGs;
  }
  
  public static final class f
  {
    public String mContent;
    public String teS;
    public String teT;
  }
  
  public static final class g
  {
    public String teT;
    public String tfa;
    public String tfb;
    public String tfc;
  }
  
  public static final class h
  {
    public boolean mClickable;
    public String mName;
    public String teT;
  }
  
  public static final class i
  {
    public String bLs;
    public String tfd;
    public String tfe;
    public String tff;
    public String tfg;
    public String userName;
  }
  
  public static final class j
  {
    public int nZF = 0;
    public String tfh;
    public long tfi = 0L;
  }
  
  public static final class k
  {
    public String tfj;
    public int tfk;
    public int tfl;
    public String tfm;
    public String tfn;
    public String tfo;
    public String tfp;
    public String tfq;
    public String tfr;
    public String tfs;
    public int tft;
    public String tfu;
    public String tfv;
    public String tfw;
    public String tfx;
  }
  
  public static final class l
  {
    public String hqo;
    public int tfy = 0;
  }
  
  public static final class m
  {
    public int tfz;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.game.model.o
 * JD-Core Version:    0.7.0.1
 */