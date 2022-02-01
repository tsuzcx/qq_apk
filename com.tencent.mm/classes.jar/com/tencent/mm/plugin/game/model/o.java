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
  public String pOE;
  public long umC;
  private boolean umD;
  public String umE;
  public String umF;
  public String umG;
  public String umH;
  public String umI;
  public int umJ;
  public String umK;
  public String umL;
  public LinkedList<k> umM;
  public boolean umN;
  public f umO;
  public boolean umP;
  public e umQ;
  public HashMap<String, g> umR;
  public String umS;
  public int umT;
  public int umU;
  public int umV;
  public String umW;
  public String umX;
  public String umY;
  public int umZ;
  public boolean uma;
  public m unA;
  public b unB;
  public int unC;
  public int unD;
  public String unE;
  public String unF;
  public String unG;
  public int unH;
  public String unI;
  public boolean unJ;
  public int una;
  public long unb;
  public long unc;
  public int und;
  public a une;
  public String unf;
  public String ung;
  public String unh;
  public String uni;
  public String unj;
  public String unk;
  public String unl;
  public String unm;
  public String unn;
  public String uno;
  public String unp;
  public String unq;
  public i unr;
  public h uns;
  public j unt;
  public l unu;
  public d unv;
  public p unw;
  public o unx;
  public n uny;
  public c unz;
  
  static
  {
    AppMethodBeat.i(41454);
    c.a locala = new c.a();
    locala.IBL = new Field[18];
    locala.columns = new String[19];
    StringBuilder localStringBuilder = new StringBuilder();
    locala.columns[0] = "msgId";
    locala.IBN.put("msgId", "LONG PRIMARY KEY ");
    localStringBuilder.append(" msgId LONG PRIMARY KEY ");
    localStringBuilder.append(", ");
    locala.IBM = "msgId";
    locala.columns[1] = "mergerId";
    locala.IBN.put("mergerId", "TEXT");
    localStringBuilder.append(" mergerId TEXT");
    localStringBuilder.append(", ");
    locala.columns[2] = "gameMsgId";
    locala.IBN.put("gameMsgId", "TEXT");
    localStringBuilder.append(" gameMsgId TEXT");
    localStringBuilder.append(", ");
    locala.columns[3] = "msgType";
    locala.IBN.put("msgType", "INTEGER");
    localStringBuilder.append(" msgType INTEGER");
    localStringBuilder.append(", ");
    locala.columns[4] = "createTime";
    locala.IBN.put("createTime", "LONG default '0' ");
    localStringBuilder.append(" createTime LONG default '0' ");
    localStringBuilder.append(", ");
    locala.columns[5] = "expireTime";
    locala.IBN.put("expireTime", "LONG default '0' ");
    localStringBuilder.append(" expireTime LONG default '0' ");
    localStringBuilder.append(", ");
    locala.columns[6] = "appId";
    locala.IBN.put("appId", "TEXT");
    localStringBuilder.append(" appId TEXT");
    localStringBuilder.append(", ");
    locala.columns[7] = "showInMsgList";
    locala.IBN.put("showInMsgList", "INTEGER default 'true' ");
    localStringBuilder.append(" showInMsgList INTEGER default 'true' ");
    localStringBuilder.append(", ");
    locala.columns[8] = "isRead";
    locala.IBN.put("isRead", "INTEGER default 'false' ");
    localStringBuilder.append(" isRead INTEGER default 'false' ");
    localStringBuilder.append(", ");
    locala.columns[9] = "label";
    locala.IBN.put("label", "TEXT default '' ");
    localStringBuilder.append(" label TEXT default '' ");
    localStringBuilder.append(", ");
    locala.columns[10] = "isHidden";
    locala.IBN.put("isHidden", "INTEGER default 'false' ");
    localStringBuilder.append(" isHidden INTEGER default 'false' ");
    localStringBuilder.append(", ");
    locala.columns[11] = "weight";
    locala.IBN.put("weight", "TEXT default '' ");
    localStringBuilder.append(" weight TEXT default '' ");
    localStringBuilder.append(", ");
    locala.columns[12] = "rawXML";
    locala.IBN.put("rawXML", "TEXT default '' ");
    localStringBuilder.append(" rawXML TEXT default '' ");
    localStringBuilder.append(", ");
    locala.columns[13] = "receiveTime";
    locala.IBN.put("receiveTime", "LONG default '0' ");
    localStringBuilder.append(" receiveTime LONG default '0' ");
    localStringBuilder.append(", ");
    locala.columns[14] = "showType";
    locala.IBN.put("showType", "INTEGER default '0' ");
    localStringBuilder.append(" showType INTEGER default '0' ");
    localStringBuilder.append(", ");
    locala.columns[15] = "interactiveMergeId";
    locala.IBN.put("interactiveMergeId", "TEXT default '' ");
    localStringBuilder.append(" interactiveMergeId TEXT default '' ");
    localStringBuilder.append(", ");
    locala.columns[16] = "hasMergedCount";
    locala.IBN.put("hasMergedCount", "INTEGER default '1' ");
    localStringBuilder.append(" hasMergedCount INTEGER default '1' ");
    localStringBuilder.append(", ");
    locala.columns[17] = "redDotExpireTime";
    locala.IBN.put("redDotExpireTime", "LONG default '0' ");
    localStringBuilder.append(" redDotExpireTime LONG default '0' ");
    locala.columns[18] = "rowid";
    locala.sql = localStringBuilder.toString();
    info = locala;
    AppMethodBeat.o(41454);
  }
  
  public o()
  {
    AppMethodBeat.i(41452);
    this.umC = 0L;
    this.umD = false;
    this.pOE = "";
    this.umE = "";
    this.umF = "";
    this.mAppName = "";
    this.umG = "";
    this.umH = "";
    this.umI = "";
    this.umJ = 0;
    this.umK = "";
    this.umL = "";
    this.umM = new LinkedList();
    this.umO = new f();
    this.umQ = new e();
    this.umR = new HashMap();
    this.umS = "";
    this.umT = 0;
    this.umU = 0;
    this.umV = 0;
    this.umW = "";
    this.umX = "";
    this.umY = "";
    this.umZ = 0;
    this.una = 0;
    this.unb = 0L;
    this.unc = 0L;
    this.und = 0;
    this.une = new a();
    this.unf = "";
    this.ung = "";
    this.unh = "";
    this.uni = "";
    this.unj = "";
    this.unk = "";
    this.unl = "";
    this.uns = new h();
    this.unt = new j();
    this.unu = new l();
    this.unv = new d();
    this.unw = new p();
    this.unx = new o();
    this.uny = new n();
    this.unz = new c();
    this.unA = new m();
    this.unB = new b();
    this.uma = false;
    this.unH = 0;
    this.unI = "";
    this.unJ = false;
    AppMethodBeat.o(41452);
  }
  
  public final boolean ctn()
  {
    return this.unx.uow == 0;
  }
  
  public final void dbE()
  {
    AppMethodBeat.i(41453);
    if (this.umD)
    {
      AppMethodBeat.o(41453);
      return;
    }
    if (this.field_msgType == 100)
    {
      u.dbV();
      u.a(this);
    }
    for (;;)
    {
      q.b(this);
      this.umD = true;
      AppMethodBeat.o(41453);
      return;
      q.a(this);
    }
  }
  
  public final c.a getDBInfo()
  {
    return info;
  }
  
  public static final class a
  {
    public int orientation;
    public boolean uea;
    public boolean unK;
    public List<String> unL;
    public String url;
    
    public a()
    {
      AppMethodBeat.i(41450);
      this.unL = new ArrayList();
      AppMethodBeat.o(41450);
    }
  }
  
  public static final class b
  {
    public String unM;
  }
  
  public static final class c
  {
    public boolean dEO = false;
    public boolean unN = false;
  }
  
  public static final class d
  {
    public List<String> unL;
    public String unO;
    
    public d()
    {
      AppMethodBeat.i(41451);
      this.unL = new ArrayList();
      AppMethodBeat.o(41451);
    }
  }
  
  public static final class e
  {
    public String mDesc;
    public String unP;
    public String unQ;
  }
  
  public static final class f
  {
    public int mIconHeight;
    public int mIconWidth;
    public String mText;
    public String unP;
    public int unR;
    public boolean unS;
    public int unT;
    public boolean unU;
  }
  
  public static final class g
  {
    public int mJumpType;
    public String qqC;
  }
  
  public static final class h
  {
    public String mContent;
    public String unP;
    public String unQ;
  }
  
  public static final class i
  {
    public String unQ;
    public String unV;
    public String unW;
    public String unX;
  }
  
  public static final class j
  {
    public boolean mClickable;
    public String mName;
    public String unQ;
  }
  
  public static final class k
  {
    public String bVF;
    public String unY;
    public String unZ;
    public String uoa;
    public String uob;
    public String userName;
  }
  
  public static final class l
  {
    public int oJB = 0;
    public String uoc;
    public long uod = 0L;
  }
  
  public static final class m
  {
    public String uoe;
    public String uof;
    public long uog;
  }
  
  public static final class n
  {
    public String uoh;
    public int uoi;
    public int uoj;
    public String uok;
    public String uol;
    public String uom;
    public String uon;
    public String uoo;
    public String uop;
    public String uoq;
    public int uor;
    public String uos;
    public String uot;
    public String uou;
    public String uov;
  }
  
  public static final class o
  {
    public String hLz;
    public int uow = 0;
  }
  
  public static final class p
  {
    public int uox;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.game.model.o
 * JD-Core Version:    0.7.0.1
 */