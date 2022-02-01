package com.tencent.mm.plugin.game.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.dd;
import com.tencent.mm.sdk.storage.IAutoDBItem.MAutoDBInfo;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public final class o
  extends dd
{
  protected static IAutoDBItem.MAutoDBInfo info;
  public String mAppName;
  public String rfc;
  public long xEU;
  private boolean xEV;
  public String xEW;
  public String xEX;
  public String xEY;
  public String xEZ;
  public boolean xEs;
  public String xFA;
  public String xFB;
  public String xFC;
  public String xFD;
  public String xFE;
  public String xFF;
  public String xFG;
  public String xFH;
  public String xFI;
  public i xFJ;
  public h xFK;
  public j xFL;
  public l xFM;
  public d xFN;
  public p xFO;
  public o xFP;
  public n xFQ;
  public c xFR;
  public m xFS;
  public b xFT;
  public int xFU;
  public int xFV;
  public String xFW;
  public String xFX;
  public String xFY;
  public int xFZ;
  public String xFa;
  public int xFb;
  public String xFc;
  public String xFd;
  public LinkedList<o.k> xFe;
  public boolean xFf;
  public f xFg;
  public boolean xFh;
  public e xFi;
  public HashMap<String, o.g> xFj;
  public String xFk;
  public int xFl;
  public int xFm;
  public int xFn;
  public String xFo;
  public String xFp;
  public String xFq;
  public int xFr;
  public int xFs;
  public long xFt;
  public long xFu;
  public int xFv;
  public a xFw;
  public String xFx;
  public String xFy;
  public String xFz;
  public String xGa;
  public boolean xGb;
  
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
    this.xEU = 0L;
    this.xEV = false;
    this.rfc = "";
    this.xEW = "";
    this.xEX = "";
    this.mAppName = "";
    this.xEY = "";
    this.xEZ = "";
    this.xFa = "";
    this.xFb = 0;
    this.xFc = "";
    this.xFd = "";
    this.xFe = new LinkedList();
    this.xFg = new f();
    this.xFi = new e();
    this.xFj = new HashMap();
    this.xFk = "";
    this.xFl = 0;
    this.xFm = 0;
    this.xFn = 0;
    this.xFo = "";
    this.xFp = "";
    this.xFq = "";
    this.xFr = 0;
    this.xFs = 0;
    this.xFt = 0L;
    this.xFu = 0L;
    this.xFv = 0;
    this.xFw = new a();
    this.xFx = "";
    this.xFy = "";
    this.xFz = "";
    this.xFA = "";
    this.xFB = "";
    this.xFC = "";
    this.xFD = "";
    this.xFK = new h();
    this.xFL = new j();
    this.xFM = new l();
    this.xFN = new d();
    this.xFO = new p();
    this.xFP = new o();
    this.xFQ = new n();
    this.xFR = new c();
    this.xFS = new m();
    this.xFT = new b();
    this.xEs = false;
    this.xFZ = 0;
    this.xGa = "";
    this.xGb = false;
    AppMethodBeat.o(41452);
  }
  
  public final void dVl()
  {
    AppMethodBeat.i(41453);
    if (this.xEV)
    {
      AppMethodBeat.o(41453);
      return;
    }
    if (this.field_msgType == 100)
    {
      u.dVC();
      u.a(this);
    }
    for (;;)
    {
      q.b(this);
      this.xEV = true;
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
    public boolean crp;
    public int orientation;
    public String url;
    public List<String> xGc;
    public boolean xvW;
    
    public a()
    {
      AppMethodBeat.i(41450);
      this.xGc = new ArrayList();
      AppMethodBeat.o(41450);
    }
  }
  
  public static final class b
  {
    public String xGd;
  }
  
  public static final class c
  {
    public boolean dWA = false;
    public boolean xGe = false;
  }
  
  public static final class d
  {
    public List<String> xGc;
    public String xGf;
    
    public d()
    {
      AppMethodBeat.i(41451);
      this.xGc = new ArrayList();
      AppMethodBeat.o(41451);
    }
  }
  
  public static final class e
  {
    public String mDesc;
    public String xGg;
    public String xGh;
  }
  
  public static final class f
  {
    public int mIconHeight;
    public int mIconWidth;
    public String mText;
    public String xGg;
    public int xGi;
    public boolean xGj;
    public int xGk;
    public boolean xGl;
  }
  
  public static final class h
  {
    public String mContent;
    public String xGg;
    public String xGh;
  }
  
  public static final class i
  {
    public String xGh;
    public String xGm;
    public String xGn;
    public String xGo;
  }
  
  public static final class j
  {
    public boolean mClickable;
    public String mName;
    public String xGh;
  }
  
  public static final class l
  {
    public int pXp = 0;
    public String xGt;
    public long xGu = 0L;
  }
  
  public static final class m
  {
    public String xGv;
    public String xGw;
    public long xGx;
  }
  
  public static final class n
  {
    public int xGA;
    public String xGB;
    public String xGC;
    public String xGD;
    public String xGE;
    public String xGF;
    public String xGG;
    public String xGH;
    public int xGI;
    public String xGJ;
    public String xGK;
    public String xGL;
    public String xGM;
    public String xGN;
    public String xGy;
    public int xGz;
  }
  
  public static final class o
  {
    public Boolean eay = null;
    public String iGB;
    public int xGO = 0;
    public int xGP;
  }
  
  public static final class p
  {
    public int xGQ;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.game.model.o
 * JD-Core Version:    0.7.0.1
 */