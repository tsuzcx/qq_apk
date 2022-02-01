package com.tencent.mm.plugin.game.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.cn;
import com.tencent.mm.sdk.e.c.a;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public final class o
  extends cn
{
  protected static c.a info;
  public String mAppName;
  public String oAY;
  public long rVS;
  private boolean rVT;
  public String rVU;
  public String rVV;
  public String rVW;
  public String rVX;
  public String rVY;
  public int rVZ;
  public boolean rVq;
  public String rWA;
  public String rWB;
  public String rWC;
  public String rWD;
  public String rWE;
  public String rWF;
  public String rWG;
  public g rWH;
  public f rWI;
  public h rWJ;
  public j rWK;
  public b rWL;
  public m rWM;
  public l rWN;
  public k rWO;
  public int rWP;
  public int rWQ;
  public String rWR;
  public String rWS;
  public String rWT;
  public int rWU;
  public String rWV;
  public boolean rWW;
  public String rWa;
  public String rWb;
  public LinkedList<i> rWc;
  public boolean rWd;
  public d rWe;
  public boolean rWf;
  public c rWg;
  public HashMap<String, e> rWh;
  public String rWi;
  public int rWj;
  public int rWk;
  public int rWl;
  public String rWm;
  public String rWn;
  public String rWo;
  public int rWp;
  public int rWq;
  public long rWr;
  public long rWs;
  public int rWt;
  public a rWu;
  public String rWv;
  public String rWw;
  public String rWx;
  public String rWy;
  public String rWz;
  
  static
  {
    AppMethodBeat.i(41454);
    c.a locala = new c.a();
    locala.EYt = new Field[17];
    locala.columns = new String[18];
    StringBuilder localStringBuilder = new StringBuilder();
    locala.columns[0] = "msgId";
    locala.EYv.put("msgId", "LONG PRIMARY KEY ");
    localStringBuilder.append(" msgId LONG PRIMARY KEY ");
    localStringBuilder.append(", ");
    locala.EYu = "msgId";
    locala.columns[1] = "mergerId";
    locala.EYv.put("mergerId", "TEXT");
    localStringBuilder.append(" mergerId TEXT");
    localStringBuilder.append(", ");
    locala.columns[2] = "gameMsgId";
    locala.EYv.put("gameMsgId", "TEXT");
    localStringBuilder.append(" gameMsgId TEXT");
    localStringBuilder.append(", ");
    locala.columns[3] = "msgType";
    locala.EYv.put("msgType", "INTEGER");
    localStringBuilder.append(" msgType INTEGER");
    localStringBuilder.append(", ");
    locala.columns[4] = "createTime";
    locala.EYv.put("createTime", "LONG default '0' ");
    localStringBuilder.append(" createTime LONG default '0' ");
    localStringBuilder.append(", ");
    locala.columns[5] = "expireTime";
    locala.EYv.put("expireTime", "LONG default '0' ");
    localStringBuilder.append(" expireTime LONG default '0' ");
    localStringBuilder.append(", ");
    locala.columns[6] = "appId";
    locala.EYv.put("appId", "TEXT");
    localStringBuilder.append(" appId TEXT");
    localStringBuilder.append(", ");
    locala.columns[7] = "showInMsgList";
    locala.EYv.put("showInMsgList", "INTEGER default 'true' ");
    localStringBuilder.append(" showInMsgList INTEGER default 'true' ");
    localStringBuilder.append(", ");
    locala.columns[8] = "isRead";
    locala.EYv.put("isRead", "INTEGER default 'false' ");
    localStringBuilder.append(" isRead INTEGER default 'false' ");
    localStringBuilder.append(", ");
    locala.columns[9] = "label";
    locala.EYv.put("label", "TEXT default '' ");
    localStringBuilder.append(" label TEXT default '' ");
    localStringBuilder.append(", ");
    locala.columns[10] = "isHidden";
    locala.EYv.put("isHidden", "INTEGER default 'false' ");
    localStringBuilder.append(" isHidden INTEGER default 'false' ");
    localStringBuilder.append(", ");
    locala.columns[11] = "weight";
    locala.EYv.put("weight", "TEXT default '' ");
    localStringBuilder.append(" weight TEXT default '' ");
    localStringBuilder.append(", ");
    locala.columns[12] = "rawXML";
    locala.EYv.put("rawXML", "TEXT default '' ");
    localStringBuilder.append(" rawXML TEXT default '' ");
    localStringBuilder.append(", ");
    locala.columns[13] = "receiveTime";
    locala.EYv.put("receiveTime", "LONG default '0' ");
    localStringBuilder.append(" receiveTime LONG default '0' ");
    localStringBuilder.append(", ");
    locala.columns[14] = "showType";
    locala.EYv.put("showType", "INTEGER default '0' ");
    localStringBuilder.append(" showType INTEGER default '0' ");
    localStringBuilder.append(", ");
    locala.columns[15] = "interactiveMergeId";
    locala.EYv.put("interactiveMergeId", "TEXT default '' ");
    localStringBuilder.append(" interactiveMergeId TEXT default '' ");
    localStringBuilder.append(", ");
    locala.columns[16] = "hasMergedCount";
    locala.EYv.put("hasMergedCount", "INTEGER default '1' ");
    localStringBuilder.append(" hasMergedCount INTEGER default '1' ");
    locala.columns[17] = "rowid";
    locala.sql = localStringBuilder.toString();
    info = locala;
    AppMethodBeat.o(41454);
  }
  
  public o()
  {
    AppMethodBeat.i(41452);
    this.rVS = 0L;
    this.rVT = false;
    this.oAY = "";
    this.rVU = "";
    this.rVV = "";
    this.mAppName = "";
    this.rVW = "";
    this.rVX = "";
    this.rVY = "";
    this.rVZ = 0;
    this.rWa = "";
    this.rWb = "";
    this.rWc = new LinkedList();
    this.rWe = new d();
    this.rWg = new c();
    this.rWh = new HashMap();
    this.rWi = "";
    this.rWj = 0;
    this.rWk = 0;
    this.rWl = 0;
    this.rWm = "";
    this.rWn = "";
    this.rWo = "";
    this.rWp = 0;
    this.rWq = 0;
    this.rWr = 0L;
    this.rWs = 0L;
    this.rWt = 0;
    this.rWu = new a();
    this.rWv = "";
    this.rWw = "";
    this.rWx = "";
    this.rWy = "";
    this.rWz = "";
    this.rWA = "";
    this.rWB = "";
    this.rWI = new f();
    this.rWJ = new h();
    this.rWK = new j();
    this.rWL = new b();
    this.rWM = new m();
    this.rWN = new l();
    this.rWO = new k();
    this.rVq = false;
    this.rWU = 0;
    this.rWV = "";
    this.rWW = false;
    AppMethodBeat.o(41452);
  }
  
  public final void cDf()
  {
    AppMethodBeat.i(41453);
    if (this.rVT)
    {
      AppMethodBeat.o(41453);
      return;
    }
    if (this.field_msgType == 100)
    {
      u.cDu();
      u.a(this);
    }
    for (;;)
    {
      q.b(this);
      this.rVT = true;
      AppMethodBeat.o(41453);
      return;
      q.a(this);
    }
  }
  
  public final boolean cey()
  {
    return this.rWN.rXG == 0;
  }
  
  public final c.a getDBInfo()
  {
    return info;
  }
  
  public static final class a
  {
    public int orientation;
    public boolean rOL;
    public boolean rWX;
    public List<String> rWY;
    public String url;
    
    public a()
    {
      AppMethodBeat.i(41450);
      this.rWY = new ArrayList();
      AppMethodBeat.o(41450);
    }
  }
  
  public static final class b
  {
    public List<String> rWY;
    public String rWZ;
    
    public b()
    {
      AppMethodBeat.i(41451);
      this.rWY = new ArrayList();
      AppMethodBeat.o(41451);
    }
  }
  
  public static final class c
  {
    public String mDesc;
    public String rXa;
    public String rXb;
  }
  
  public static final class d
  {
    public String mText;
    public String rXa;
    public int rXc;
    public int rXd;
    public int rXe;
    public boolean rXf;
    public int rXg;
    public boolean rXh;
  }
  
  public static final class e
  {
    public int mJumpType;
    public String pdh;
  }
  
  public static final class f
  {
    public String mContent;
    public String rXa;
    public String rXb;
  }
  
  public static final class g
  {
    public String rXb;
    public String rXi;
    public String rXj;
    public String rXk;
  }
  
  public static final class h
  {
    public boolean mClickable;
    public String mName;
    public String rXb;
  }
  
  public static final class i
  {
    public String bNK;
    public String rXl;
    public String rXm;
    public String rXn;
    public String rXo;
    public String userName;
  }
  
  public static final class j
  {
    public int nwF = 0;
    public String rXp;
    public long rXq = 0L;
  }
  
  public static final class k
  {
    public String rXA;
    public int rXB;
    public String rXC;
    public String rXD;
    public String rXE;
    public String rXF;
    public String rXr;
    public int rXs;
    public int rXt;
    public String rXu;
    public String rXv;
    public String rXw;
    public String rXx;
    public String rXy;
    public String rXz;
  }
  
  public static final class l
  {
    public String gPO;
    public int rXG = 0;
  }
  
  public static final class m
  {
    public int rXH;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.game.model.o
 * JD-Core Version:    0.7.0.1
 */