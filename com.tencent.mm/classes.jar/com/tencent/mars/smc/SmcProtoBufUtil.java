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
import com.tencent.mm.protocal.protobuf.aix;
import com.tencent.mm.protocal.protobuf.aiy;
import com.tencent.mm.protocal.protobuf.awb;
import com.tencent.mm.protocal.protobuf.awc;
import com.tencent.mm.protocal.protobuf.ayt;
import com.tencent.mm.protocal.protobuf.bgh;
import com.tencent.mm.protocal.protobuf.cig;
import com.tencent.mm.protocal.protobuf.tl;
import com.tencent.mm.protocal.protobuf.tm;
import com.tencent.mm.protocal.protobuf.tn;
import java.util.ArrayList;
import java.util.LinkedList;

public class SmcProtoBufUtil
{
  private static o fillStrategyTable(LinkedList<cig> paramLinkedList)
  {
    o localo = new o();
    int i = 0;
    while (i < paramLinkedList.size())
    {
      cig localcig = (cig)paramLinkedList.get(i);
      m localm = new m();
      localm.wjH = localcig.xSU;
      localm.wjI = localcig.xSV;
      int j = 0;
      while (j < localcig.xSW.size())
      {
        bgh localbgh = (bgh)localcig.xSW.get(j);
        n localn = new n();
        localn.wjb = localbgh.xoo;
        localn.wjK = localbgh.xvB;
        localn.wjL = localbgh.xvz;
        localn.wjM = localbgh.xvA;
        localn.wjN = localbgh.xvC;
        localn.wjO = localbgh.xvD;
        localn.wjP = localbgh.xvE;
        localn.type = localbgh.jKs;
        localm.wjJ.add(localn);
        j += 1;
      }
      localo.wjQ.add(localm);
      i += 1;
    }
    return localo;
  }
  
  public static aix toMMGetStrategyReq()
  {
    aix localaix = new aix();
    ArrayList localArrayList = SmcLogic.getStrategyVersions();
    if (localArrayList.size() != 6) {
      return null;
    }
    localaix.wLP = ((Integer)localArrayList.get(0)).intValue();
    localaix.wLQ = ((Integer)localArrayList.get(1)).intValue();
    localaix.wLR = ((Integer)localArrayList.get(2)).intValue();
    localaix.xaD = ((Integer)localArrayList.get(3)).intValue();
    localaix.xaE = ((Integer)localArrayList.get(4)).intValue();
    localaix.xaF = ((Integer)localArrayList.get(5)).intValue();
    return localaix;
  }
  
  public static tm toMMReportIdkeyReq(g paramg)
  {
    tm localtm = new tm();
    localtm.wLP = paramg.wje;
    localtm.wLQ = paramg.wju;
    localtm.wLR = 0;
    int i = 0;
    while (i < paramg.wjv.size())
    {
      com.tencent.mm.protocal.a.a.b localb = (com.tencent.mm.protocal.a.a.b)paramg.wjv.get(i);
      tl localtl = new tl();
      localtl.lGw = localb.uin;
      localtl.wur = localb.wjc;
      localtl.wLO = localb.nettype;
      int j = 0;
      while (j < localb.wjd.size())
      {
        a locala = (a)localb.wjd.get(j);
        ayt localayt = new ayt();
        localayt.xoo = locala.wjb;
        localayt.wPI = 0;
        localayt.xoq = 0;
        localayt.jJu = locala.count;
        localayt.xop = com.tencent.mm.bv.b.bL(Integer.toString(locala.value).getBytes());
        localtl.nrw.add(localayt);
        j += 1;
      }
      localtm.wLS.add(localtl);
      i += 1;
    }
    return localtm;
  }
  
  public static tm toMMReportKvReq(i parami)
  {
    tm localtm = new tm();
    localtm.wLP = parami.wje;
    localtm.wLQ = parami.wju;
    localtm.wLR = parami.wjs;
    int i = 0;
    while (i < parami.wjv.size())
    {
      e locale = (e)parami.wjv.get(i);
      tl localtl = new tl();
      localtl.lGw = locale.uin;
      localtl.wur = locale.wjc;
      localtl.wLO = locale.nettype;
      localtl.wAd = locale.wjo;
      localtl.wAb = locale.wjm;
      localtl.wAc = locale.wjn;
      localtl.wAe = locale.wjp;
      localtl.wAf = locale.wjq;
      localtl.jKx = locale.wjr;
      int j = 0;
      while (j < locale.wjd.size())
      {
        d locald = (d)locale.wjd.get(j);
        ayt localayt = new ayt();
        localayt.xoo = locald.wjb;
        localayt.xop = locald.wjk;
        localayt.xoq = locald.wjl;
        localayt.wPI = locald.qNK;
        localayt.jJu = locald.count;
        localtl.nrw.add(localayt);
        j += 1;
      }
      localtm.wLS.add(localtl);
      i += 1;
    }
    return localtm;
  }
  
  public static awb toMMSelfMonitor(k paramk)
  {
    awb localawb = new awb();
    localawb.xlp = paramk.wjy;
    int i = 0;
    while (i < paramk.wjz.size())
    {
      awc localawc = new awc();
      l locall = (l)paramk.wjz.get(i);
      localawc.xlq = locall.wjA;
      localawc.cnE = locall.action;
      localawc.xlr = locall.wjB;
      localawc.xls = locall.wjC;
      localawc.xlt = locall.wjD;
      localawc.xlu = locall.wjE;
      localawc.xlv = locall.wjF;
      localawc.xlw = locall.wjG;
      localawb.nrw.add(localawc);
      i += 1;
    }
    return localawb;
  }
  
  public static c toSmcIdkeyStrategyResp(aiy paramaiy)
  {
    c localc = new c();
    localc.ret = paramaiy.Ret;
    localc.wje = paramaiy.wLV;
    localc.wjf = paramaiy.wLW;
    localc.wji = paramaiy.wMb;
    localc.wjj = paramaiy.wMd;
    localc.wjg = fillStrategyTable(paramaiy.wLY);
    localc.wjh = fillStrategyTable(paramaiy.wLZ);
    return localc;
  }
  
  public static f toSmcKVStrategyResp(aiy paramaiy)
  {
    f localf = new f();
    localf.ret = paramaiy.Ret;
    localf.wje = paramaiy.xaD;
    localf.wjf = paramaiy.xaE;
    localf.wjs = paramaiy.xaF;
    localf.wji = paramaiy.wMb;
    localf.wjj = paramaiy.wMd;
    localf.wjg = fillStrategyTable(paramaiy.xaG);
    localf.wjh = fillStrategyTable(paramaiy.xaH);
    localf.wjt = fillStrategyTable(paramaiy.xaI);
    return localf;
  }
  
  public static h toSmcReportIdkeyResp(tn paramtn)
  {
    h localh = new h();
    localh.ret = paramtn.Ret;
    localh.wje = paramtn.wLV;
    localh.wjf = paramtn.wLW;
    localh.wji = paramtn.wMb;
    localh.wjx = paramtn.wMc;
    localh.wjj = paramtn.wMd;
    localh.wjg = fillStrategyTable(paramtn.wLY);
    localh.wjh = fillStrategyTable(paramtn.wLZ);
    return localh;
  }
  
  public static j toSmcReportKvResp(tn paramtn)
  {
    j localj = new j();
    localj.ret = paramtn.Ret;
    localj.wje = paramtn.wLV;
    localj.wjf = paramtn.wLW;
    localj.wjs = paramtn.wLX;
    localj.wji = paramtn.wMb;
    localj.wjx = paramtn.wMc;
    localj.wjj = paramtn.wMd;
    localj.wjg = fillStrategyTable(paramtn.wLY);
    localj.wjh = fillStrategyTable(paramtn.wLZ);
    localj.wjt = fillStrategyTable(paramtn.wMa);
    return localj;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mars.smc.SmcProtoBufUtil
 * JD-Core Version:    0.7.0.1
 */