package com.tencent.mm.plugin.game.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.cb;
import com.tencent.mm.sdk.e.c.a;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public final class n
  extends cb
{
  protected static c.a info;
  public String lkK;
  public String mAppName;
  public long nmP;
  private boolean nmQ;
  public String nmR;
  public String nmS;
  public String nmT;
  public String nmU;
  public String nmV;
  public int nmW;
  public String nmX;
  public String nmY;
  public LinkedList<n.i> nmZ;
  public boolean nmt;
  public String nnA;
  public String nnB;
  public String nnC;
  public n.g nnD;
  public n.f nnE;
  public n.h nnF;
  public n.j nnG;
  public n.b nnH;
  public k nnI;
  public n.l nnJ;
  public int nnK;
  public int nnL;
  public String nnM;
  public int nnN;
  public String nnO;
  public boolean nnP;
  public boolean nna;
  public n.d nnb;
  public boolean nnc;
  public n.c nnd;
  public HashMap<String, n.e> nne;
  public String nnf;
  public int nng;
  public int nnh;
  public int nni;
  public String nnj;
  public String nnk;
  public String nnl;
  public int nnm;
  public long nnn;
  public long nno;
  public int nnp;
  public n.a nnq;
  public String nnr;
  public String nns;
  public String nnt;
  public String nnu;
  public String nnv;
  public String nnw;
  public String nnx;
  public String nny;
  public String nnz;
  
  static
  {
    AppMethodBeat.i(111291);
    c.a locala = new c.a();
    locala.yrK = new Field[14];
    locala.columns = new String[15];
    StringBuilder localStringBuilder = new StringBuilder();
    locala.columns[0] = "msgId";
    locala.yrM.put("msgId", "LONG PRIMARY KEY ");
    localStringBuilder.append(" msgId LONG PRIMARY KEY ");
    localStringBuilder.append(", ");
    locala.yrL = "msgId";
    locala.columns[1] = "mergerId";
    locala.yrM.put("mergerId", "TEXT");
    localStringBuilder.append(" mergerId TEXT");
    localStringBuilder.append(", ");
    locala.columns[2] = "gameMsgId";
    locala.yrM.put("gameMsgId", "TEXT");
    localStringBuilder.append(" gameMsgId TEXT");
    localStringBuilder.append(", ");
    locala.columns[3] = "msgType";
    locala.yrM.put("msgType", "INTEGER");
    localStringBuilder.append(" msgType INTEGER");
    localStringBuilder.append(", ");
    locala.columns[4] = "createTime";
    locala.yrM.put("createTime", "LONG default '0' ");
    localStringBuilder.append(" createTime LONG default '0' ");
    localStringBuilder.append(", ");
    locala.columns[5] = "expireTime";
    locala.yrM.put("expireTime", "LONG default '0' ");
    localStringBuilder.append(" expireTime LONG default '0' ");
    localStringBuilder.append(", ");
    locala.columns[6] = "appId";
    locala.yrM.put("appId", "TEXT");
    localStringBuilder.append(" appId TEXT");
    localStringBuilder.append(", ");
    locala.columns[7] = "showInMsgList";
    locala.yrM.put("showInMsgList", "INTEGER default 'true' ");
    localStringBuilder.append(" showInMsgList INTEGER default 'true' ");
    localStringBuilder.append(", ");
    locala.columns[8] = "isRead";
    locala.yrM.put("isRead", "INTEGER default 'false' ");
    localStringBuilder.append(" isRead INTEGER default 'false' ");
    localStringBuilder.append(", ");
    locala.columns[9] = "label";
    locala.yrM.put("label", "TEXT default '' ");
    localStringBuilder.append(" label TEXT default '' ");
    localStringBuilder.append(", ");
    locala.columns[10] = "isHidden";
    locala.yrM.put("isHidden", "INTEGER default 'false' ");
    localStringBuilder.append(" isHidden INTEGER default 'false' ");
    localStringBuilder.append(", ");
    locala.columns[11] = "weight";
    locala.yrM.put("weight", "TEXT default '' ");
    localStringBuilder.append(" weight TEXT default '' ");
    localStringBuilder.append(", ");
    locala.columns[12] = "rawXML";
    locala.yrM.put("rawXML", "TEXT default '' ");
    localStringBuilder.append(" rawXML TEXT default '' ");
    localStringBuilder.append(", ");
    locala.columns[13] = "receiveTime";
    locala.yrM.put("receiveTime", "LONG default '0' ");
    localStringBuilder.append(" receiveTime LONG default '0' ");
    locala.columns[14] = "rowid";
    locala.sql = localStringBuilder.toString();
    info = locala;
    AppMethodBeat.o(111291);
  }
  
  public n()
  {
    AppMethodBeat.i(111289);
    this.nmP = 0L;
    this.nmQ = false;
    this.lkK = "";
    this.nmR = "";
    this.nmS = "";
    this.mAppName = "";
    this.nmT = "";
    this.nmU = "";
    this.nmV = "";
    this.nmW = 0;
    this.nmX = "";
    this.nmY = "";
    this.nmZ = new LinkedList();
    this.nnb = new n.d();
    this.nnd = new n.c();
    this.nne = new HashMap();
    this.nnf = "";
    this.nng = 0;
    this.nnh = 0;
    this.nni = 0;
    this.nnj = "";
    this.nnk = "";
    this.nnl = "";
    this.nnm = 0;
    this.nnn = 0L;
    this.nno = 0L;
    this.nnp = 0;
    this.nnq = new n.a();
    this.nnr = "";
    this.nns = "";
    this.nnt = "";
    this.nnu = "";
    this.nnv = "";
    this.nnw = "";
    this.nnx = "";
    this.nnE = new n.f();
    this.nnF = new n.h();
    this.nnG = new n.j();
    this.nnH = new n.b();
    this.nnI = new k();
    this.nnJ = new n.l();
    this.nmt = false;
    this.nnN = 0;
    this.nnO = "";
    this.nnP = false;
    AppMethodBeat.o(111289);
  }
  
  public final void bGm()
  {
    AppMethodBeat.i(111290);
    if (this.nmQ)
    {
      AppMethodBeat.o(111290);
      return;
    }
    if (this.field_msgType == 100)
    {
      u.bGy();
      u.a(this);
    }
    for (;;)
    {
      this.nmQ = true;
      AppMethodBeat.o(111290);
      return;
      p.a(this);
    }
  }
  
  public final c.a getDBInfo()
  {
    return info;
  }
  
  public static final class k
  {
    public int noi;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.game.model.n
 * JD-Core Version:    0.7.0.1
 */