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
import com.tencent.mm.protocal.protobuf.azg;
import com.tencent.mm.protocal.protobuf.azh;
import com.tencent.mm.protocal.protobuf.bpi;
import com.tencent.mm.protocal.protobuf.bpj;
import com.tencent.mm.protocal.protobuf.bsh;
import com.tencent.mm.protocal.protobuf.ccq;
import com.tencent.mm.protocal.protobuf.dkg;
import com.tencent.mm.protocal.protobuf.yr;
import com.tencent.mm.protocal.protobuf.ys;
import com.tencent.mm.protocal.protobuf.yt;
import java.util.ArrayList;
import java.util.LinkedList;

public class SmcProtoBufUtil
{
  private static o fillStrategyTable(LinkedList<dkg> paramLinkedList)
  {
    o localo = new o();
    int i = 0;
    while (i < paramLinkedList.size())
    {
      dkg localdkg = (dkg)paramLinkedList.get(i);
      m localm = new m();
      localm.Fps = localdkg.HyX;
      localm.Fpt = localdkg.HyY;
      int j = 0;
      while (j < localdkg.HyZ.size())
      {
        ccq localccq = (ccq)localdkg.HyZ.get(j);
        n localn = new n();
        localn.FoM = localccq.GNa;
        localn.Fpv = localccq.GWP;
        localn.Fpw = localccq.GWN;
        localn.Fpx = localccq.GWO;
        localn.Fpy = localccq.GWQ;
        localn.Fpz = localccq.GWR;
        localn.FpA = localccq.GWS;
        localn.type = localccq.nEf;
        localm.Fpu.add(localn);
        j += 1;
      }
      localo.FpB.add(localm);
      i += 1;
    }
    return localo;
  }
  
  public static azg toMMGetStrategyReq()
  {
    azg localazg = new azg();
    ArrayList localArrayList = SmcLogic.getStrategyVersions();
    if (localArrayList.size() != 6) {
      return null;
    }
    localazg.FYd = ((Integer)localArrayList.get(0)).intValue();
    localazg.FYe = ((Integer)localArrayList.get(1)).intValue();
    localazg.FYf = ((Integer)localArrayList.get(2)).intValue();
    localazg.GwC = ((Integer)localArrayList.get(3)).intValue();
    localazg.GwD = ((Integer)localArrayList.get(4)).intValue();
    localazg.GwE = ((Integer)localArrayList.get(5)).intValue();
    return localazg;
  }
  
  public static ys toMMReportIdkeyReq(g paramg)
  {
    ys localys = new ys();
    localys.FYd = paramg.FoP;
    localys.FYe = paramg.Fpf;
    localys.FYf = 0;
    int i = 0;
    while (i < paramg.Fpg.size())
    {
      com.tencent.mm.protocal.a.a.b localb = (com.tencent.mm.protocal.a.a.b)paramg.Fpg.get(i);
      yr localyr = new yr();
      localyr.qdX = localb.uin;
      localyr.FCf = localb.FoN;
      localyr.FYc = localb.nettype;
      int j = 0;
      while (j < localb.FoO.size())
      {
        a locala = (a)localb.FoO.get(j);
        bsh localbsh = new bsh();
        localbsh.GNa = locala.FoM;
        localbsh.Gdc = 0;
        localbsh.GNc = 0;
        localbsh.nDi = locala.count;
        localbsh.GNb = com.tencent.mm.bx.b.cj(Integer.toString(locala.value).getBytes());
        localyr.ugO.add(localbsh);
        j += 1;
      }
      localys.FYg.add(localyr);
      i += 1;
    }
    return localys;
  }
  
  public static ys toMMReportKvReq(i parami)
  {
    ys localys = new ys();
    localys.FYd = parami.FoP;
    localys.FYe = parami.Fpf;
    localys.FYf = parami.Fpd;
    int i = 0;
    while (i < parami.Fpg.size())
    {
      e locale = (e)parami.Fpg.get(i);
      yr localyr = new yr();
      localyr.qdX = locale.uin;
      localyr.FCf = locale.FoN;
      localyr.FYc = locale.nettype;
      localyr.gsO = locale.FoZ;
      localyr.gsM = locale.FoX;
      localyr.gsN = locale.FoY;
      localyr.gsP = locale.Fpa;
      localyr.gsQ = locale.Fpb;
      localyr.nEk = locale.Fpc;
      int j = 0;
      while (j < locale.FoO.size())
      {
        d locald = (d)locale.FoO.get(j);
        bsh localbsh = new bsh();
        localbsh.GNa = locald.FoM;
        localbsh.GNb = locald.FoV;
        localbsh.GNc = locald.FoW;
        localbsh.Gdc = locald.yMB;
        localbsh.nDi = locald.count;
        localyr.ugO.add(localbsh);
        j += 1;
      }
      localys.FYg.add(localyr);
      i += 1;
    }
    return localys;
  }
  
  public static bpi toMMSelfMonitor(k paramk)
  {
    bpi localbpi = new bpi();
    localbpi.GJV = paramk.Fpj;
    int i = 0;
    while (i < paramk.Fpk.size())
    {
      bpj localbpj = new bpj();
      l locall = (l)paramk.Fpk.get(i);
      localbpj.GJW = locall.Fpl;
      localbpj.dlq = locall.action;
      localbpj.GJX = locall.Fpm;
      localbpj.GJY = locall.Fpn;
      localbpj.GJZ = locall.Fpo;
      localbpj.GKa = locall.Fpp;
      localbpj.GKb = locall.Fpq;
      localbpj.GKc = locall.Fpr;
      localbpi.ugO.add(localbpj);
      i += 1;
    }
    return localbpi;
  }
  
  public static c toSmcIdkeyStrategyResp(azh paramazh)
  {
    c localc = new c();
    localc.ret = paramazh.Ret;
    localc.FoP = paramazh.FYj;
    localc.FoQ = paramazh.FYk;
    localc.FoT = paramazh.FYp;
    localc.FoU = paramazh.FYr;
    localc.FoR = fillStrategyTable(paramazh.FYm);
    localc.FoS = fillStrategyTable(paramazh.FYn);
    return localc;
  }
  
  public static f toSmcKVStrategyResp(azh paramazh)
  {
    f localf = new f();
    localf.ret = paramazh.Ret;
    localf.FoP = paramazh.GwC;
    localf.FoQ = paramazh.GwD;
    localf.Fpd = paramazh.GwE;
    localf.FoT = paramazh.FYp;
    localf.FoU = paramazh.FYr;
    localf.FoR = fillStrategyTable(paramazh.GwF);
    localf.FoS = fillStrategyTable(paramazh.GwG);
    localf.Fpe = fillStrategyTable(paramazh.GwH);
    return localf;
  }
  
  public static h toSmcReportIdkeyResp(yt paramyt)
  {
    h localh = new h();
    localh.ret = paramyt.Ret;
    localh.FoP = paramyt.FYj;
    localh.FoQ = paramyt.FYk;
    localh.FoT = paramyt.FYp;
    localh.Fpi = paramyt.FYq;
    localh.FoU = paramyt.FYr;
    localh.FoR = fillStrategyTable(paramyt.FYm);
    localh.FoS = fillStrategyTable(paramyt.FYn);
    return localh;
  }
  
  public static j toSmcReportKvResp(yt paramyt)
  {
    j localj = new j();
    localj.ret = paramyt.Ret;
    localj.FoP = paramyt.FYj;
    localj.FoQ = paramyt.FYk;
    localj.Fpd = paramyt.FYl;
    localj.FoT = paramyt.FYp;
    localj.Fpi = paramyt.FYq;
    localj.FoU = paramyt.FYr;
    localj.FoR = fillStrategyTable(paramyt.FYm);
    localj.FoS = fillStrategyTable(paramyt.FYn);
    localj.Fpe = fillStrategyTable(paramyt.FYo);
    return localj;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mars.smc.SmcProtoBufUtil
 * JD-Core Version:    0.7.0.1
 */