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
import com.tencent.mm.protocal.c.aed;
import com.tencent.mm.protocal.c.aee;
import com.tencent.mm.protocal.c.aqc;
import com.tencent.mm.protocal.c.aqd;
import com.tencent.mm.protocal.c.ass;
import com.tencent.mm.protocal.c.aze;
import com.tencent.mm.protocal.c.bvy;
import com.tencent.mm.protocal.c.qg;
import com.tencent.mm.protocal.c.qh;
import com.tencent.mm.protocal.c.qi;
import java.util.ArrayList;
import java.util.LinkedList;

public class SmcProtoBufUtil
{
  private static o fillStrategyTable(LinkedList<bvy> paramLinkedList)
  {
    o localo = new o();
    int i = 0;
    while (i < paramLinkedList.size())
    {
      bvy localbvy = (bvy)paramLinkedList.get(i);
      m localm = new m();
      localm.sqZ = localbvy.tMK;
      localm.sra = localbvy.tML;
      int j = 0;
      while (j < localbvy.tMM.size())
      {
        aze localaze = (aze)localbvy.tMM.get(j);
        n localn = new n();
        localn.sqt = localaze.tou;
        localn.srd = localaze.tvq;
        localn.sre = localaze.tvo;
        localn.srf = localaze.tvp;
        localn.srg = localaze.tvr;
        localn.srh = localaze.tvs;
        localn.sri = localaze.tvt;
        localn.type = localaze.hQR;
        localm.srb.add(localn);
        j += 1;
      }
      localo.srj.add(localm);
      i += 1;
    }
    return localo;
  }
  
  public static aed toMMGetStrategyReq()
  {
    aed localaed = new aed();
    ArrayList localArrayList = SmcLogic.getStrategyVersions();
    if (localArrayList.size() != 6) {
      return null;
    }
    localaed.sNV = ((Integer)localArrayList.get(0)).intValue();
    localaed.sNW = ((Integer)localArrayList.get(1)).intValue();
    localaed.sNX = ((Integer)localArrayList.get(2)).intValue();
    localaed.tck = ((Integer)localArrayList.get(3)).intValue();
    localaed.tcl = ((Integer)localArrayList.get(4)).intValue();
    localaed.tcm = ((Integer)localArrayList.get(5)).intValue();
    return localaed;
  }
  
  public static qh toMMReportIdkeyReq(g paramg)
  {
    qh localqh = new qh();
    localqh.sNV = paramg.sqw;
    localqh.sNW = paramg.sqM;
    localqh.sNX = 0;
    int i = 0;
    while (i < paramg.sqN.size())
    {
      com.tencent.mm.protocal.a.a.b localb = (com.tencent.mm.protocal.a.a.b)paramg.sqN.get(i);
      qg localqg = new qg();
      localqg.jwX = localb.uin;
      localqg.sAl = localb.squ;
      localqg.sNU = localb.nettype;
      int j = 0;
      while (j < localb.sqv.size())
      {
        a locala = (a)localb.sqv.get(j);
        ass localass = new ass();
        localass.tou = locala.sqt;
        localass.sQS = 0;
        localass.tow = 0;
        localass.hPS = locala.count;
        localass.tov = com.tencent.mm.bv.b.bk(Integer.toString(locala.value).getBytes());
        localqg.kTw.add(localass);
        j += 1;
      }
      localqh.sNY.add(localqg);
      i += 1;
    }
    return localqh;
  }
  
  public static qh toMMReportKvReq(i parami)
  {
    qh localqh = new qh();
    localqh.sNV = parami.sqw;
    localqh.sNW = parami.sqM;
    localqh.sNX = parami.sqK;
    int i = 0;
    while (i < parami.sqN.size())
    {
      e locale = (e)parami.sqN.get(i);
      qg localqg = new qg();
      localqg.jwX = locale.uin;
      localqg.sAl = locale.squ;
      localqg.sNU = locale.nettype;
      localqg.sEe = locale.sqG;
      localqg.sEc = locale.sqE;
      localqg.sEd = locale.sqF;
      localqg.sEf = locale.sqH;
      localqg.sEg = locale.sqI;
      localqg.hQW = locale.sqJ;
      int j = 0;
      while (j < locale.sqv.size())
      {
        d locald = (d)locale.sqv.get(j);
        ass localass = new ass();
        localass.tou = locald.sqt;
        localass.tov = locald.sqC;
        localass.tow = locald.sqD;
        localass.sQS = locald.nZA;
        localass.hPS = locald.count;
        localqg.kTw.add(localass);
        j += 1;
      }
      localqh.sNY.add(localqg);
      i += 1;
    }
    return localqh;
  }
  
  public static aqc toMMSelfMonitor(k paramk)
  {
    aqc localaqc = new aqc();
    localaqc.tlW = paramk.sqQ;
    int i = 0;
    while (i < paramk.sqR.size())
    {
      aqd localaqd = new aqd();
      l locall = (l)paramk.sqR.get(i);
      localaqd.tlX = locall.sqS;
      localaqd.bGv = locall.action;
      localaqd.tlY = locall.sqT;
      localaqd.tlZ = locall.sqU;
      localaqd.tma = locall.sqV;
      localaqd.tmb = locall.sqW;
      localaqd.tmc = locall.sqX;
      localaqd.tmd = locall.sqY;
      localaqc.kTw.add(localaqd);
      i += 1;
    }
    return localaqc;
  }
  
  public static c toSmcIdkeyStrategyResp(aee paramaee)
  {
    c localc = new c();
    localc.ret = paramaee.sze;
    localc.sqw = paramaee.sOb;
    localc.sqx = paramaee.sOc;
    localc.sqA = paramaee.sOh;
    localc.sqB = paramaee.sOj;
    localc.sqy = fillStrategyTable(paramaee.sOe);
    localc.sqz = fillStrategyTable(paramaee.sOf);
    return localc;
  }
  
  public static f toSmcKVStrategyResp(aee paramaee)
  {
    f localf = new f();
    localf.ret = paramaee.sze;
    localf.sqw = paramaee.tck;
    localf.sqx = paramaee.tcl;
    localf.sqK = paramaee.tcm;
    localf.sqA = paramaee.sOh;
    localf.sqB = paramaee.sOj;
    localf.sqy = fillStrategyTable(paramaee.tcn);
    localf.sqz = fillStrategyTable(paramaee.tco);
    localf.sqL = fillStrategyTable(paramaee.tcp);
    return localf;
  }
  
  public static h toSmcReportIdkeyResp(qi paramqi)
  {
    h localh = new h();
    localh.ret = paramqi.sze;
    localh.sqw = paramqi.sOb;
    localh.sqx = paramqi.sOc;
    localh.sqA = paramqi.sOh;
    localh.sqP = paramqi.sOi;
    localh.sqB = paramqi.sOj;
    localh.sqy = fillStrategyTable(paramqi.sOe);
    localh.sqz = fillStrategyTable(paramqi.sOf);
    return localh;
  }
  
  public static j toSmcReportKvResp(qi paramqi)
  {
    j localj = new j();
    localj.ret = paramqi.sze;
    localj.sqw = paramqi.sOb;
    localj.sqx = paramqi.sOc;
    localj.sqK = paramqi.sOd;
    localj.sqA = paramqi.sOh;
    localj.sqP = paramqi.sOi;
    localj.sqB = paramqi.sOj;
    localj.sqy = fillStrategyTable(paramqi.sOe);
    localj.sqz = fillStrategyTable(paramqi.sOf);
    localj.sqL = fillStrategyTable(paramqi.sOg);
    return localj;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mars.smc.SmcProtoBufUtil
 * JD-Core Version:    0.7.0.1
 */