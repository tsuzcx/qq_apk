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
import com.tencent.mm.protocal.protobuf.ase;
import com.tencent.mm.protocal.protobuf.asf;
import com.tencent.mm.protocal.protobuf.bhg;
import com.tencent.mm.protocal.protobuf.bhh;
import com.tencent.mm.protocal.protobuf.bkb;
import com.tencent.mm.protocal.protobuf.bti;
import com.tencent.mm.protocal.protobuf.czh;
import com.tencent.mm.protocal.protobuf.wh;
import com.tencent.mm.protocal.protobuf.wi;
import com.tencent.mm.protocal.protobuf.wj;
import java.util.ArrayList;
import java.util.LinkedList;

public class SmcProtoBufUtil
{
  private static o fillStrategyTable(LinkedList<czh> paramLinkedList)
  {
    o localo = new o();
    int i = 0;
    while (i < paramLinkedList.size())
    {
      czh localczh = (czh)paramLinkedList.get(i);
      m localm = new m();
      localm.CrT = localczh.Erk;
      localm.CrU = localczh.Erl;
      int j = 0;
      while (j < localczh.Erm.size())
      {
        bti localbti = (bti)localczh.Erm.get(j);
        n localn = new n();
        localn.Crn = localbti.DIc;
        localn.CrW = localbti.DQO;
        localn.CrX = localbti.DQM;
        localn.CrY = localbti.DQN;
        localn.CrZ = localbti.DQP;
        localn.Csa = localbti.DQQ;
        localn.Csb = localbti.DQR;
        localn.type = localbti.mBH;
        localm.CrV.add(localn);
        j += 1;
      }
      localo.Csc.add(localm);
      i += 1;
    }
    return localo;
  }
  
  public static ase toMMGetStrategyReq()
  {
    ase localase = new ase();
    ArrayList localArrayList = SmcLogic.getStrategyVersions();
    if (localArrayList.size() != 6) {
      return null;
    }
    localase.CYj = ((Integer)localArrayList.get(0)).intValue();
    localase.CYk = ((Integer)localArrayList.get(1)).intValue();
    localase.CYl = ((Integer)localArrayList.get(2)).intValue();
    localase.Dsu = ((Integer)localArrayList.get(3)).intValue();
    localase.Dsv = ((Integer)localArrayList.get(4)).intValue();
    localase.Dsw = ((Integer)localArrayList.get(5)).intValue();
    return localase;
  }
  
  public static wi toMMReportIdkeyReq(g paramg)
  {
    wi localwi = new wi();
    localwi.CYj = paramg.Crq;
    localwi.CYk = paramg.CrG;
    localwi.CYl = 0;
    int i = 0;
    while (i < paramg.CrH.size())
    {
      com.tencent.mm.protocal.a.a.b localb = (com.tencent.mm.protocal.a.a.b)paramg.CrH.get(i);
      wh localwh = new wh();
      localwh.oXh = localb.uin;
      localwh.CEj = localb.Cro;
      localwh.CYi = localb.nettype;
      int j = 0;
      while (j < localb.Crp.size())
      {
        a locala = (a)localb.Crp.get(j);
        bkb localbkb = new bkb();
        localbkb.DIc = locala.Crn;
        localbkb.Dcz = 0;
        localbkb.DIe = 0;
        localbkb.mAK = locala.count;
        localbkb.DId = com.tencent.mm.bx.b.cd(Integer.toString(locala.value).getBytes());
        localwh.saZ.add(localbkb);
        j += 1;
      }
      localwi.CYm.add(localwh);
      i += 1;
    }
    return localwi;
  }
  
  public static wi toMMReportKvReq(i parami)
  {
    wi localwi = new wi();
    localwi.CYj = parami.Crq;
    localwi.CYk = parami.CrG;
    localwi.CYl = parami.CrE;
    int i = 0;
    while (i < parami.CrH.size())
    {
      e locale = (e)parami.CrH.get(i);
      wh localwh = new wh();
      localwh.oXh = locale.uin;
      localwh.CEj = locale.Cro;
      localwh.CYi = locale.nettype;
      localwh.fVx = locale.CrA;
      localwh.fVv = locale.Cry;
      localwh.fVw = locale.Crz;
      localwh.fVy = locale.CrB;
      localwh.fVz = locale.CrC;
      localwh.mBM = locale.CrD;
      int j = 0;
      while (j < locale.Crp.size())
      {
        d locald = (d)locale.Crp.get(j);
        bkb localbkb = new bkb();
        localbkb.DIc = locald.Crn;
        localbkb.DId = locald.Crw;
        localbkb.DIe = locald.Crx;
        localbkb.Dcz = locald.wmA;
        localbkb.mAK = locald.count;
        localwh.saZ.add(localbkb);
        j += 1;
      }
      localwi.CYm.add(localwh);
      i += 1;
    }
    return localwi;
  }
  
  public static bhg toMMSelfMonitor(k paramk)
  {
    bhg localbhg = new bhg();
    localbhg.DFc = paramk.CrK;
    int i = 0;
    while (i < paramk.CrL.size())
    {
      bhh localbhh = new bhh();
      l locall = (l)paramk.CrL.get(i);
      localbhh.DFd = locall.CrM;
      localbhh.dcA = locall.action;
      localbhh.DFe = locall.CrN;
      localbhh.DFf = locall.CrO;
      localbhh.DFg = locall.CrP;
      localbhh.DFh = locall.CrQ;
      localbhh.DFi = locall.CrR;
      localbhh.DFj = locall.CrS;
      localbhg.saZ.add(localbhh);
      i += 1;
    }
    return localbhg;
  }
  
  public static c toSmcIdkeyStrategyResp(asf paramasf)
  {
    c localc = new c();
    localc.ret = paramasf.Ret;
    localc.Crq = paramasf.CYp;
    localc.Crr = paramasf.CYq;
    localc.Cru = paramasf.CYv;
    localc.Crv = paramasf.CYx;
    localc.Crs = fillStrategyTable(paramasf.CYs);
    localc.Crt = fillStrategyTable(paramasf.CYt);
    return localc;
  }
  
  public static f toSmcKVStrategyResp(asf paramasf)
  {
    f localf = new f();
    localf.ret = paramasf.Ret;
    localf.Crq = paramasf.Dsu;
    localf.Crr = paramasf.Dsv;
    localf.CrE = paramasf.Dsw;
    localf.Cru = paramasf.CYv;
    localf.Crv = paramasf.CYx;
    localf.Crs = fillStrategyTable(paramasf.Dsx);
    localf.Crt = fillStrategyTable(paramasf.Dsy);
    localf.CrF = fillStrategyTable(paramasf.Dsz);
    return localf;
  }
  
  public static h toSmcReportIdkeyResp(wj paramwj)
  {
    h localh = new h();
    localh.ret = paramwj.Ret;
    localh.Crq = paramwj.CYp;
    localh.Crr = paramwj.CYq;
    localh.Cru = paramwj.CYv;
    localh.CrJ = paramwj.CYw;
    localh.Crv = paramwj.CYx;
    localh.Crs = fillStrategyTable(paramwj.CYs);
    localh.Crt = fillStrategyTable(paramwj.CYt);
    return localh;
  }
  
  public static j toSmcReportKvResp(wj paramwj)
  {
    j localj = new j();
    localj.ret = paramwj.Ret;
    localj.Crq = paramwj.CYp;
    localj.Crr = paramwj.CYq;
    localj.CrE = paramwj.CYr;
    localj.Cru = paramwj.CYv;
    localj.CrJ = paramwj.CYw;
    localj.Crv = paramwj.CYx;
    localj.Crs = fillStrategyTable(paramwj.CYs);
    localj.Crt = fillStrategyTable(paramwj.CYt);
    localj.CrF = fillStrategyTable(paramwj.CYu);
    return localj;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mars.smc.SmcProtoBufUtil
 * JD-Core Version:    0.7.0.1
 */