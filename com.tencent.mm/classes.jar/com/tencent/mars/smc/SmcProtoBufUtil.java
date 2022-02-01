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
import com.tencent.mm.protocal.protobuf.aaj;
import com.tencent.mm.protocal.protobuf.aak;
import com.tencent.mm.protocal.protobuf.aal;
import com.tencent.mm.protocal.protobuf.blg;
import com.tencent.mm.protocal.protobuf.blh;
import com.tencent.mm.protocal.protobuf.ccs;
import com.tencent.mm.protocal.protobuf.cct;
import com.tencent.mm.protocal.protobuf.cfu;
import com.tencent.mm.protocal.protobuf.ctq;
import com.tencent.mm.protocal.protobuf.eeo;
import java.util.ArrayList;
import java.util.LinkedList;

public class SmcProtoBufUtil
{
  private static o fillStrategyTable(LinkedList<eeo> paramLinkedList)
  {
    o localo = new o();
    int i = 0;
    while (i < paramLinkedList.size())
    {
      eeo localeeo = (eeo)paramLinkedList.get(i);
      m localm = new m();
      localm.KBe = localeeo.NeL;
      localm.KBf = localeeo.NeM;
      int j = 0;
      while (j < localeeo.NeN.size())
      {
        ctq localctq = (ctq)localeeo.NeN.get(j);
        n localn = new n();
        localn.KAy = localctq.MlF;
        localn.KBh = localctq.MyV;
        localn.KBi = localctq.MyT;
        localn.KBj = localctq.MyU;
        localn.KBk = localctq.MyW;
        localn.KBl = localctq.MyX;
        localn.KBm = localctq.MyY;
        localn.type = localctq.oUv;
        localm.KBg.add(localn);
        j += 1;
      }
      localo.KBn.add(localm);
      i += 1;
    }
    return localo;
  }
  
  public static blg toMMGetStrategyReq()
  {
    blg localblg = new blg();
    ArrayList localArrayList = SmcLogic.getStrategyVersions();
    if (localArrayList.size() != 6) {
      return null;
    }
    localblg.Lly = ((Integer)localArrayList.get(0)).intValue();
    localblg.Llz = ((Integer)localArrayList.get(1)).intValue();
    localblg.LlA = ((Integer)localArrayList.get(2)).intValue();
    localblg.LUj = ((Integer)localArrayList.get(3)).intValue();
    localblg.LUk = ((Integer)localArrayList.get(4)).intValue();
    localblg.LUl = ((Integer)localArrayList.get(5)).intValue();
    return localblg;
  }
  
  public static aak toMMReportIdkeyReq(g paramg)
  {
    aak localaak = new aak();
    localaak.Lly = paramg.KAB;
    localaak.Llz = paramg.KAR;
    localaak.LlA = 0;
    int i = 0;
    while (i < paramg.KAS.size())
    {
      com.tencent.mm.protocal.a.a.b localb = (com.tencent.mm.protocal.a.a.b)paramg.KAS.get(i);
      aaj localaaj = new aaj();
      localaaj.rBx = localb.uin;
      localaaj.KOj = localb.KAz;
      localaaj.Llx = localb.nettype;
      int j = 0;
      while (j < localb.KAA.size())
      {
        a locala = (a)localb.KAA.get(j);
        cfu localcfu = new cfu();
        localcfu.MlF = locala.KAy;
        localcfu.Lrp = 0;
        localcfu.MlH = 0;
        localcfu.oTz = locala.count;
        localcfu.MlG = com.tencent.mm.bw.b.cD(Integer.toString(locala.value).getBytes());
        localaaj.xKD.add(localcfu);
        j += 1;
      }
      localaak.LlB.add(localaaj);
      i += 1;
    }
    return localaak;
  }
  
  public static aak toMMReportKvReq(i parami)
  {
    aak localaak = new aak();
    localaak.Lly = parami.KAB;
    localaak.Llz = parami.KAR;
    localaak.LlA = parami.KAP;
    int i = 0;
    while (i < parami.KAS.size())
    {
      e locale = (e)parami.KAS.get(i);
      aaj localaaj = new aaj();
      localaaj.rBx = locale.uin;
      localaaj.KOj = locale.KAz;
      localaaj.Llx = locale.nettype;
      localaaj.hif = locale.KAL;
      localaaj.hid = locale.KAJ;
      localaaj.hie = locale.KAK;
      localaaj.hig = locale.KAM;
      localaaj.hih = locale.KAN;
      localaaj.oUA = locale.KAO;
      int j = 0;
      while (j < locale.KAA.size())
      {
        d locald = (d)locale.KAA.get(j);
        cfu localcfu = new cfu();
        localcfu.MlF = locald.KAy;
        localcfu.MlG = locald.KAH;
        localcfu.MlH = locald.KAI;
        localcfu.Lrp = locald.DhD;
        localcfu.oTz = locald.count;
        localaaj.xKD.add(localcfu);
        j += 1;
      }
      localaak.LlB.add(localaaj);
      i += 1;
    }
    return localaak;
  }
  
  public static ccs toMMSelfMonitor(k paramk)
  {
    ccs localccs = new ccs();
    localccs.Miz = paramk.KAV;
    int i = 0;
    while (i < paramk.KAW.size())
    {
      cct localcct = new cct();
      l locall = (l)paramk.KAW.get(i);
      localcct.MiA = locall.KAX;
      localcct.dDH = locall.action;
      localcct.MiB = locall.KAY;
      localcct.MiC = locall.KAZ;
      localcct.MiD = locall.KBa;
      localcct.MiE = locall.KBb;
      localcct.MiF = locall.KBc;
      localcct.MiG = locall.KBd;
      localccs.xKD.add(localcct);
      i += 1;
    }
    return localccs;
  }
  
  public static c toSmcIdkeyStrategyResp(blh paramblh)
  {
    c localc = new c();
    localc.ret = paramblh.Ret;
    localc.KAB = paramblh.LlE;
    localc.KAC = paramblh.LlF;
    localc.KAF = paramblh.LlK;
    localc.KAG = paramblh.LlM;
    localc.KAD = fillStrategyTable(paramblh.LlH);
    localc.KAE = fillStrategyTable(paramblh.LlI);
    return localc;
  }
  
  public static f toSmcKVStrategyResp(blh paramblh)
  {
    f localf = new f();
    localf.ret = paramblh.Ret;
    localf.KAB = paramblh.LUj;
    localf.KAC = paramblh.LUk;
    localf.KAP = paramblh.LUl;
    localf.KAF = paramblh.LlK;
    localf.KAG = paramblh.LlM;
    localf.KAD = fillStrategyTable(paramblh.LUm);
    localf.KAE = fillStrategyTable(paramblh.LUn);
    localf.KAQ = fillStrategyTable(paramblh.LUo);
    return localf;
  }
  
  public static h toSmcReportIdkeyResp(aal paramaal)
  {
    h localh = new h();
    localh.ret = paramaal.Ret;
    localh.KAB = paramaal.LlE;
    localh.KAC = paramaal.LlF;
    localh.KAF = paramaal.LlK;
    localh.KAU = paramaal.LlL;
    localh.KAG = paramaal.LlM;
    localh.KAD = fillStrategyTable(paramaal.LlH);
    localh.KAE = fillStrategyTable(paramaal.LlI);
    return localh;
  }
  
  public static j toSmcReportKvResp(aal paramaal)
  {
    j localj = new j();
    localj.ret = paramaal.Ret;
    localj.KAB = paramaal.LlE;
    localj.KAC = paramaal.LlF;
    localj.KAP = paramaal.LlG;
    localj.KAF = paramaal.LlK;
    localj.KAU = paramaal.LlL;
    localj.KAG = paramaal.LlM;
    localj.KAD = fillStrategyTable(paramaal.LlH);
    localj.KAE = fillStrategyTable(paramaal.LlI);
    localj.KAQ = fillStrategyTable(paramaal.LlJ);
    return localj;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mars.smc.SmcProtoBufUtil
 * JD-Core Version:    0.7.0.1
 */