package com.tencent.mars.smc;

import com.tencent.mm.protocal.a.a.a;
import com.tencent.mm.protocal.a.a.c;
import com.tencent.mm.protocal.a.a.d;
import com.tencent.mm.protocal.a.a.e;
import com.tencent.mm.protocal.a.a.f;
import com.tencent.mm.protocal.a.a.g;
import com.tencent.mm.protocal.a.a.h;
import com.tencent.mm.protocal.a.a.i;
import com.tencent.mm.protocal.a.a.j;
import com.tencent.mm.protocal.a.a.k;
import com.tencent.mm.protocal.a.a.l;
import com.tencent.mm.protocal.a.a.m;
import com.tencent.mm.protocal.a.a.n;
import com.tencent.mm.protocal.a.a.o;
import com.tencent.mm.protocal.protobuf.aco;
import com.tencent.mm.protocal.protobuf.acp;
import com.tencent.mm.protocal.protobuf.acq;
import com.tencent.mm.protocal.protobuf.chi;
import com.tencent.mm.protocal.protobuf.chj;
import com.tencent.mm.protocal.protobuf.dbc;
import com.tencent.mm.protocal.protobuf.dbd;
import com.tencent.mm.protocal.protobuf.dfk;
import com.tencent.mm.protocal.protobuf.dui;
import com.tencent.mm.protocal.protobuf.fjn;
import java.util.ArrayList;
import java.util.LinkedList;

public class SmcProtoBufUtil
{
  private static o fillStrategyTable(LinkedList<fjn> paramLinkedList)
  {
    o localo = new o();
    int i = 0;
    while (i < paramLinkedList.size())
    {
      fjn localfjn = (fjn)paramLinkedList.get(i);
      m localm = new m();
      localm.Yzw = localfjn.abKj;
      localm.Yzx = localfjn.abKk;
      int j = 0;
      while (j < localfjn.abKl.size())
      {
        dui localdui = (dui)localfjn.abKl.get(j);
        n localn = new n();
        localn.YyQ = localdui.aaLf;
        localn.Yzz = localdui.abap;
        localn.YzA = localdui.aban;
        localn.YzB = localdui.abao;
        localn.YzC = localdui.abaq;
        localn.YzD = localdui.abar;
        localn.YzE = localdui.abas;
        localn.type = localdui.vhJ;
        localm.Yzy.add(localn);
        j += 1;
      }
      localo.YzF.add(localm);
      i += 1;
    }
    return localo;
  }
  
  public static chi toMMGetStrategyReq()
  {
    chi localchi = new chi();
    ArrayList localArrayList = SmcLogic.getStrategyVersions();
    if (localArrayList.size() != 6) {
      return null;
    }
    localchi.ZkU = ((Integer)localArrayList.get(0)).intValue();
    localchi.ZkV = ((Integer)localArrayList.get(1)).intValue();
    localchi.ZkW = ((Integer)localArrayList.get(2)).intValue();
    localchi.aaqg = ((Integer)localArrayList.get(3)).intValue();
    localchi.aaqh = ((Integer)localArrayList.get(4)).intValue();
    localchi.aaqi = ((Integer)localArrayList.get(5)).intValue();
    return localchi;
  }
  
  public static acp toMMReportIdkeyReq(g paramg)
  {
    acp localacp = new acp();
    localacp.ZkU = paramg.YyT;
    localacp.ZkV = paramg.Yzj;
    localacp.ZkW = 0;
    int i = 0;
    while (i < paramg.Yzk.size())
    {
      com.tencent.mm.protocal.a.a.b localb = (com.tencent.mm.protocal.a.a.b)paramg.Yzk.get(i);
      aco localaco = new aco();
      localaco.yth = localb.uin;
      localaco.YMr = localb.YyR;
      localaco.ZkT = localb.nettype;
      int j = 0;
      while (j < localb.YyS.size())
      {
        a locala = (a)localb.YyS.get(j);
        dfk localdfk = new dfk();
        localdfk.aaLf = locala.YyQ;
        localdfk.ZrV = 0;
        localdfk.aaLh = 0;
        localdfk.vgN = locala.count;
        localdfk.aaLg = com.tencent.mm.bx.b.cX(Integer.toString(locala.value).getBytes());
        localaco.IIU.add(localdfk);
        j += 1;
      }
      localacp.ZkX.add(localaco);
      i += 1;
    }
    return localacp;
  }
  
  public static acp toMMReportKvReq(i parami)
  {
    acp localacp = new acp();
    localacp.ZkU = parami.YyT;
    localacp.ZkV = parami.Yzj;
    localacp.ZkW = parami.Yzh;
    int i = 0;
    while (i < parami.Yzk.size())
    {
      e locale = (e)parami.Yzk.get(i);
      aco localaco = new aco();
      localaco.yth = locale.uin;
      localaco.YMr = locale.YyR;
      localaco.ZkT = locale.nettype;
      localaco.muv = locale.Yzd;
      localaco.mut = locale.Yzb;
      localaco.muu = locale.Yzc;
      localaco.muw = locale.Yze;
      localaco.mux = locale.Yzf;
      localaco.vhO = locale.Yzg;
      int j = 0;
      while (j < locale.YyS.size())
      {
        d locald = (d)locale.YyS.get(j);
        dfk localdfk = new dfk();
        localdfk.aaLf = locald.YyQ;
        localdfk.aaLg = locald.YyZ;
        localdfk.aaLh = locald.Yza;
        localdfk.ZrV = locald.PzZ;
        localdfk.vgN = locald.count;
        localaco.IIU.add(localdfk);
        j += 1;
      }
      localacp.ZkX.add(localaco);
      i += 1;
    }
    return localacp;
  }
  
  public static dbc toMMSelfMonitor(k paramk)
  {
    dbc localdbc = new dbc();
    localdbc.aaGy = paramk.Yzn;
    int i = 0;
    while (i < paramk.Yzo.size())
    {
      dbd localdbd = new dbd();
      l locall = (l)paramk.Yzo.get(i);
      localdbd.aaGz = locall.Yzp;
      localdbd.hAO = locall.action;
      localdbd.aaGA = locall.Yzq;
      localdbd.aaGB = locall.Yzr;
      localdbd.aaGC = locall.Yzs;
      localdbd.aaGD = locall.Yzt;
      localdbd.aaGE = locall.Yzu;
      localdbd.aaGF = locall.Yzv;
      localdbc.IIU.add(localdbd);
      i += 1;
    }
    return localdbc;
  }
  
  public static c toSmcIdkeyStrategyResp(chj paramchj)
  {
    c localc = new c();
    localc.ret = paramchj.Idd;
    localc.YyT = paramchj.Zla;
    localc.YyU = paramchj.Zlb;
    localc.YyX = paramchj.Zlg;
    localc.YyY = paramchj.Zli;
    localc.YyV = fillStrategyTable(paramchj.Zld);
    localc.YyW = fillStrategyTable(paramchj.Zle);
    return localc;
  }
  
  public static f toSmcKVStrategyResp(chj paramchj)
  {
    f localf = new f();
    localf.ret = paramchj.Idd;
    localf.YyT = paramchj.aaqg;
    localf.YyU = paramchj.aaqh;
    localf.Yzh = paramchj.aaqi;
    localf.YyX = paramchj.Zlg;
    localf.YyY = paramchj.Zli;
    localf.YyV = fillStrategyTable(paramchj.aaqj);
    localf.YyW = fillStrategyTable(paramchj.aaqk);
    localf.Yzi = fillStrategyTable(paramchj.aaql);
    return localf;
  }
  
  public static h toSmcReportIdkeyResp(acq paramacq)
  {
    h localh = new h();
    localh.ret = paramacq.Idd;
    localh.YyT = paramacq.Zla;
    localh.YyU = paramacq.Zlb;
    localh.YyX = paramacq.Zlg;
    localh.Yzm = paramacq.Zlh;
    localh.YyY = paramacq.Zli;
    localh.YyV = fillStrategyTable(paramacq.Zld);
    localh.YyW = fillStrategyTable(paramacq.Zle);
    return localh;
  }
  
  public static j toSmcReportKvResp(acq paramacq)
  {
    j localj = new j();
    localj.ret = paramacq.Idd;
    localj.YyT = paramacq.Zla;
    localj.YyU = paramacq.Zlb;
    localj.Yzh = paramacq.Zlc;
    localj.YyX = paramacq.Zlg;
    localj.Yzm = paramacq.Zlh;
    localj.YyY = paramacq.Zli;
    localj.YyV = fillStrategyTable(paramacq.Zld);
    localj.YyW = fillStrategyTable(paramacq.Zle);
    localj.Yzi = fillStrategyTable(paramacq.Zlf);
    return localj;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mars.smc.SmcProtoBufUtil
 * JD-Core Version:    0.7.0.1
 */