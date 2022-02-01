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
import com.tencent.mm.protocal.protobuf.aao;
import com.tencent.mm.protocal.protobuf.aap;
import com.tencent.mm.protocal.protobuf.aaq;
import com.tencent.mm.protocal.protobuf.bsp;
import com.tencent.mm.protocal.protobuf.bsq;
import com.tencent.mm.protocal.protobuf.ckv;
import com.tencent.mm.protocal.protobuf.ckw;
import com.tencent.mm.protocal.protobuf.coq;
import com.tencent.mm.protocal.protobuf.dcp;
import com.tencent.mm.protocal.protobuf.eop;
import java.util.ArrayList;
import java.util.LinkedList;

public class SmcProtoBufUtil
{
  private static o fillStrategyTable(LinkedList<eop> paramLinkedList)
  {
    o localo = new o();
    int i = 0;
    while (i < paramLinkedList.size())
    {
      eop localeop = (eop)paramLinkedList.get(i);
      m localm = new m();
      localm.RCU = localeop.Urk;
      localm.RCV = localeop.Urm;
      int j = 0;
      while (j < localeop.Urn.size())
      {
        dcp localdcp = (dcp)localeop.Urn.get(j);
        n localn = new n();
        localn.RCo = localdcp.Twy;
        localn.RCX = localdcp.TKw;
        localn.RCY = localdcp.TKu;
        localn.RCZ = localdcp.TKv;
        localn.RDa = localdcp.TKx;
        localn.RDb = localdcp.TKy;
        localn.RDc = localdcp.TKz;
        localn.type = localdcp.rWu;
        localm.RCW.add(localn);
        j += 1;
      }
      localo.RDd.add(localm);
      i += 1;
    }
    return localo;
  }
  
  public static bsp toMMGetStrategyReq()
  {
    bsp localbsp = new bsp();
    ArrayList localArrayList = SmcLogic.getStrategyVersions();
    if (localArrayList.size() != 6) {
      return null;
    }
    localbsp.SmI = ((Integer)localArrayList.get(0)).intValue();
    localbsp.SmJ = ((Integer)localArrayList.get(1)).intValue();
    localbsp.SmK = ((Integer)localArrayList.get(2)).intValue();
    localbsp.TcR = ((Integer)localArrayList.get(3)).intValue();
    localbsp.TcS = ((Integer)localArrayList.get(4)).intValue();
    localbsp.TcT = ((Integer)localArrayList.get(5)).intValue();
    return localbsp;
  }
  
  public static aap toMMReportIdkeyReq(g paramg)
  {
    aap localaap = new aap();
    localaap.SmI = paramg.RCr;
    localaap.SmJ = paramg.RCH;
    localaap.SmK = 0;
    int i = 0;
    while (i < paramg.RCI.size())
    {
      com.tencent.mm.protocal.a.a.b localb = (com.tencent.mm.protocal.a.a.b)paramg.RCI.get(i);
      aao localaao = new aao();
      localaao.vhf = localb.uin;
      localaao.RPe = localb.RCp;
      localaao.SmH = localb.nettype;
      int j = 0;
      while (j < localb.RCq.size())
      {
        a locala = (a)localb.RCq.get(j);
        coq localcoq = new coq();
        localcoq.Twy = locala.RCo;
        localcoq.SsM = 0;
        localcoq.TwA = 0;
        localcoq.rVx = locala.count;
        localcoq.Twz = com.tencent.mm.cd.b.cU(Integer.toString(locala.value).getBytes());
        localaao.COK.add(localcoq);
        j += 1;
      }
      localaap.SmL.add(localaao);
      i += 1;
    }
    return localaap;
  }
  
  public static aap toMMReportKvReq(i parami)
  {
    aap localaap = new aap();
    localaap.SmI = parami.RCr;
    localaap.SmJ = parami.RCH;
    localaap.SmK = parami.RCF;
    int i = 0;
    while (i < parami.RCI.size())
    {
      e locale = (e)parami.RCI.get(i);
      aao localaao = new aao();
      localaao.vhf = locale.uin;
      localaao.RPe = locale.RCp;
      localaao.SmH = locale.nettype;
      localaao.jUd = locale.RCB;
      localaao.jUb = locale.RCz;
      localaao.jUc = locale.RCA;
      localaao.jUe = locale.RCC;
      localaao.jUf = locale.RCD;
      localaao.rWz = locale.RCE;
      int j = 0;
      while (j < locale.RCq.size())
      {
        d locald = (d)locale.RCq.get(j);
        coq localcoq = new coq();
        localcoq.Twy = locald.RCo;
        localcoq.Twz = locald.RCx;
        localcoq.TwA = locald.RCy;
        localcoq.SsM = locald.Jnj;
        localcoq.rVx = locald.count;
        localaao.COK.add(localcoq);
        j += 1;
      }
      localaap.SmL.add(localaao);
      i += 1;
    }
    return localaap;
  }
  
  public static ckv toMMSelfMonitor(k paramk)
  {
    ckv localckv = new ckv();
    localckv.Tsn = paramk.RCL;
    int i = 0;
    while (i < paramk.RCM.size())
    {
      ckw localckw = new ckw();
      l locall = (l)paramk.RCM.get(i);
      localckw.Tso = locall.RCN;
      localckw.fwq = locall.action;
      localckw.Tsp = locall.RCO;
      localckw.Tsq = locall.RCP;
      localckw.Tsr = locall.RCQ;
      localckw.Tss = locall.RCR;
      localckw.Tst = locall.RCS;
      localckw.Tsu = locall.RCT;
      localckv.COK.add(localckw);
      i += 1;
    }
    return localckv;
  }
  
  public static c toSmcIdkeyStrategyResp(bsq parambsq)
  {
    c localc = new c();
    localc.ret = parambsq.CqV;
    localc.RCr = parambsq.SmO;
    localc.RCs = parambsq.SmP;
    localc.RCv = parambsq.SmU;
    localc.RCw = parambsq.SmW;
    localc.RCt = fillStrategyTable(parambsq.SmR);
    localc.RCu = fillStrategyTable(parambsq.SmS);
    return localc;
  }
  
  public static f toSmcKVStrategyResp(bsq parambsq)
  {
    f localf = new f();
    localf.ret = parambsq.CqV;
    localf.RCr = parambsq.TcR;
    localf.RCs = parambsq.TcS;
    localf.RCF = parambsq.TcT;
    localf.RCv = parambsq.SmU;
    localf.RCw = parambsq.SmW;
    localf.RCt = fillStrategyTable(parambsq.TcU);
    localf.RCu = fillStrategyTable(parambsq.TcV);
    localf.RCG = fillStrategyTable(parambsq.TcW);
    return localf;
  }
  
  public static h toSmcReportIdkeyResp(aaq paramaaq)
  {
    h localh = new h();
    localh.ret = paramaaq.CqV;
    localh.RCr = paramaaq.SmO;
    localh.RCs = paramaaq.SmP;
    localh.RCv = paramaaq.SmU;
    localh.RCK = paramaaq.SmV;
    localh.RCw = paramaaq.SmW;
    localh.RCt = fillStrategyTable(paramaaq.SmR);
    localh.RCu = fillStrategyTable(paramaaq.SmS);
    return localh;
  }
  
  public static j toSmcReportKvResp(aaq paramaaq)
  {
    j localj = new j();
    localj.ret = paramaaq.CqV;
    localj.RCr = paramaaq.SmO;
    localj.RCs = paramaaq.SmP;
    localj.RCF = paramaaq.SmQ;
    localj.RCv = paramaaq.SmU;
    localj.RCK = paramaaq.SmV;
    localj.RCw = paramaaq.SmW;
    localj.RCt = fillStrategyTable(paramaaq.SmR);
    localj.RCu = fillStrategyTable(paramaaq.SmS);
    localj.RCG = fillStrategyTable(paramaaq.SmT);
    return localj;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mars.smc.SmcProtoBufUtil
 * JD-Core Version:    0.7.0.1
 */