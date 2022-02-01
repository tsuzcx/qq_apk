package com.tencent.mm.plugin.game.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.cy;
import com.tencent.mm.sdk.e.c.a;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public final class o
  extends cy
{
  protected static c.a info;
  public String mAppName;
  public String pIa;
  public boolean uaY;
  public long ubA;
  private boolean ubB;
  public String ubC;
  public String ubD;
  public String ubE;
  public String ubF;
  public String ubG;
  public int ubH;
  public String ubI;
  public String ubJ;
  public LinkedList<j> ubK;
  public boolean ubL;
  public e ubM;
  public boolean ubN;
  public d ubO;
  public HashMap<String, f> ubP;
  public String ubQ;
  public int ubR;
  public int ubS;
  public int ubT;
  public String ubU;
  public String ubV;
  public String ubW;
  public int ubX;
  public int ubY;
  public long ubZ;
  public String ucA;
  public String ucB;
  public String ucC;
  public int ucD;
  public String ucE;
  public boolean ucF;
  public long uca;
  public int ucb;
  public a ucc;
  public String ucd;
  public String uce;
  public String ucf;
  public String ucg;
  public String uch;
  public String uci;
  public String ucj;
  public String uck;
  public String ucl;
  public String ucm;
  public String ucn;
  public String uco;
  public h ucp;
  public g ucq;
  public i ucr;
  public k ucs;
  public c uct;
  public n ucu;
  public m ucv;
  public l ucw;
  public b ucx;
  public int ucy;
  public int ucz;
  
  static
  {
    AppMethodBeat.i(41454);
    c.a locala = new c.a();
    locala.IhA = new Field[17];
    locala.columns = new String[18];
    StringBuilder localStringBuilder = new StringBuilder();
    locala.columns[0] = "msgId";
    locala.IhC.put("msgId", "LONG PRIMARY KEY ");
    localStringBuilder.append(" msgId LONG PRIMARY KEY ");
    localStringBuilder.append(", ");
    locala.IhB = "msgId";
    locala.columns[1] = "mergerId";
    locala.IhC.put("mergerId", "TEXT");
    localStringBuilder.append(" mergerId TEXT");
    localStringBuilder.append(", ");
    locala.columns[2] = "gameMsgId";
    locala.IhC.put("gameMsgId", "TEXT");
    localStringBuilder.append(" gameMsgId TEXT");
    localStringBuilder.append(", ");
    locala.columns[3] = "msgType";
    locala.IhC.put("msgType", "INTEGER");
    localStringBuilder.append(" msgType INTEGER");
    localStringBuilder.append(", ");
    locala.columns[4] = "createTime";
    locala.IhC.put("createTime", "LONG default '0' ");
    localStringBuilder.append(" createTime LONG default '0' ");
    localStringBuilder.append(", ");
    locala.columns[5] = "expireTime";
    locala.IhC.put("expireTime", "LONG default '0' ");
    localStringBuilder.append(" expireTime LONG default '0' ");
    localStringBuilder.append(", ");
    locala.columns[6] = "appId";
    locala.IhC.put("appId", "TEXT");
    localStringBuilder.append(" appId TEXT");
    localStringBuilder.append(", ");
    locala.columns[7] = "showInMsgList";
    locala.IhC.put("showInMsgList", "INTEGER default 'true' ");
    localStringBuilder.append(" showInMsgList INTEGER default 'true' ");
    localStringBuilder.append(", ");
    locala.columns[8] = "isRead";
    locala.IhC.put("isRead", "INTEGER default 'false' ");
    localStringBuilder.append(" isRead INTEGER default 'false' ");
    localStringBuilder.append(", ");
    locala.columns[9] = "label";
    locala.IhC.put("label", "TEXT default '' ");
    localStringBuilder.append(" label TEXT default '' ");
    localStringBuilder.append(", ");
    locala.columns[10] = "isHidden";
    locala.IhC.put("isHidden", "INTEGER default 'false' ");
    localStringBuilder.append(" isHidden INTEGER default 'false' ");
    localStringBuilder.append(", ");
    locala.columns[11] = "weight";
    locala.IhC.put("weight", "TEXT default '' ");
    localStringBuilder.append(" weight TEXT default '' ");
    localStringBuilder.append(", ");
    locala.columns[12] = "rawXML";
    locala.IhC.put("rawXML", "TEXT default '' ");
    localStringBuilder.append(" rawXML TEXT default '' ");
    localStringBuilder.append(", ");
    locala.columns[13] = "receiveTime";
    locala.IhC.put("receiveTime", "LONG default '0' ");
    localStringBuilder.append(" receiveTime LONG default '0' ");
    localStringBuilder.append(", ");
    locala.columns[14] = "showType";
    locala.IhC.put("showType", "INTEGER default '0' ");
    localStringBuilder.append(" showType INTEGER default '0' ");
    localStringBuilder.append(", ");
    locala.columns[15] = "interactiveMergeId";
    locala.IhC.put("interactiveMergeId", "TEXT default '' ");
    localStringBuilder.append(" interactiveMergeId TEXT default '' ");
    localStringBuilder.append(", ");
    locala.columns[16] = "hasMergedCount";
    locala.IhC.put("hasMergedCount", "INTEGER default '1' ");
    localStringBuilder.append(" hasMergedCount INTEGER default '1' ");
    locala.columns[17] = "rowid";
    locala.sql = localStringBuilder.toString();
    info = locala;
    AppMethodBeat.o(41454);
  }
  
  public o()
  {
    AppMethodBeat.i(41452);
    this.ubA = 0L;
    this.ubB = false;
    this.pIa = "";
    this.ubC = "";
    this.ubD = "";
    this.mAppName = "";
    this.ubE = "";
    this.ubF = "";
    this.ubG = "";
    this.ubH = 0;
    this.ubI = "";
    this.ubJ = "";
    this.ubK = new LinkedList();
    this.ubM = new e();
    this.ubO = new d();
    this.ubP = new HashMap();
    this.ubQ = "";
    this.ubR = 0;
    this.ubS = 0;
    this.ubT = 0;
    this.ubU = "";
    this.ubV = "";
    this.ubW = "";
    this.ubX = 0;
    this.ubY = 0;
    this.ubZ = 0L;
    this.uca = 0L;
    this.ucb = 0;
    this.ucc = new a();
    this.ucd = "";
    this.uce = "";
    this.ucf = "";
    this.ucg = "";
    this.uch = "";
    this.uci = "";
    this.ucj = "";
    this.ucq = new g();
    this.ucr = new i();
    this.ucs = new k();
    this.uct = new c();
    this.ucu = new n();
    this.ucv = new m();
    this.ucw = new l();
    this.ucx = new b();
    this.uaY = false;
    this.ucD = 0;
    this.ucE = "";
    this.ucF = false;
    AppMethodBeat.o(41452);
  }
  
  public final void cYU()
  {
    AppMethodBeat.i(41453);
    if (this.ubB)
    {
      AppMethodBeat.o(41453);
      return;
    }
    if (this.field_msgType == 100)
    {
      u.cZk();
      u.a(this);
    }
    for (;;)
    {
      q.b(this);
      this.ubB = true;
      AppMethodBeat.o(41453);
      return;
      q.a(this);
    }
  }
  
  public final boolean crL()
  {
    return this.ucv.udo == 0;
  }
  
  public final c.a getDBInfo()
  {
    return info;
  }
  
  public static final class a
  {
    public int orientation;
    public boolean tTj;
    public boolean ucG;
    public List<String> ucH;
    public String url;
    
    public a()
    {
      AppMethodBeat.i(41450);
      this.ucH = new ArrayList();
      AppMethodBeat.o(41450);
    }
  }
  
  public static final class b
  {
    public boolean dDJ = false;
    public boolean ucI = false;
  }
  
  public static final class c
  {
    public List<String> ucH;
    public String ucJ;
    
    public c()
    {
      AppMethodBeat.i(41451);
      this.ucH = new ArrayList();
      AppMethodBeat.o(41451);
    }
  }
  
  public static final class d
  {
    public String mDesc;
    public String ucK;
    public String ucL;
  }
  
  public static final class e
  {
    public int mIconHeight;
    public int mIconWidth;
    public String mText;
    public String ucK;
    public int ucM;
    public boolean ucN;
    public int ucO;
    public boolean ucP;
  }
  
  public static final class f
  {
    public int mJumpType;
    public String qjX;
  }
  
  public static final class g
  {
    public String mContent;
    public String ucK;
    public String ucL;
  }
  
  public static final class h
  {
    public String ucL;
    public String ucQ;
    public String ucR;
    public String ucS;
  }
  
  public static final class i
  {
    public boolean mClickable;
    public String mName;
    public String ucL;
  }
  
  public static final class j
  {
    public String bVF;
    public String ucT;
    public String ucU;
    public String ucV;
    public String ucW;
    public String userName;
  }
  
  public static final class k
  {
    public int oCZ = 0;
    public String ucX;
    public long ucY = 0L;
  }
  
  public static final class l
  {
    public String ucZ;
    public int uda;
    public int udb;
    public String udc;
    public String udd;
    public String ude;
    public String udf;
    public String udg;
    public String udh;
    public String udi;
    public int udj;
    public String udk;
    public String udl;
    public String udm;
    public String udn;
  }
  
  public static final class m
  {
    public String hIG;
    public int udo = 0;
  }
  
  public static final class n
  {
    public int udp;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.game.model.o
 * JD-Core Version:    0.7.0.1
 */