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
import com.tencent.mm.protocal.protobuf.avi;
import com.tencent.mm.protocal.protobuf.avj;
import com.tencent.mm.protocal.protobuf.bky;
import com.tencent.mm.protocal.protobuf.bkz;
import com.tencent.mm.protocal.protobuf.bnv;
import com.tencent.mm.protocal.protobuf.bxz;
import com.tencent.mm.protocal.protobuf.det;
import com.tencent.mm.protocal.protobuf.ws;
import com.tencent.mm.protocal.protobuf.wt;
import com.tencent.mm.protocal.protobuf.wu;
import java.util.ArrayList;
import java.util.LinkedList;

public class SmcProtoBufUtil
{
  private static o fillStrategyTable(LinkedList<det> paramLinkedList)
  {
    o localo = new o();
    int i = 0;
    while (i < paramLinkedList.size())
    {
      det localdet = (det)paramLinkedList.get(i);
      m localm = new m();
      localm.DKl = localdet.FOm;
      localm.DKm = localdet.FOn;
      int j = 0;
      while (j < localdet.FOo.size())
      {
        bxz localbxz = (bxz)localdet.FOo.get(j);
        n localn = new n();
        localn.DJF = localbxz.Fdx;
        localn.DKo = localbxz.Fng;
        localn.DKp = localbxz.Fne;
        localn.DKq = localbxz.Fnf;
        localn.DKr = localbxz.Fnh;
        localn.DKs = localbxz.Fni;
        localn.DKt = localbxz.Fnj;
        localn.type = localbxz.ndI;
        localm.DKn.add(localn);
        j += 1;
      }
      localo.DKu.add(localm);
      i += 1;
    }
    return localo;
  }
  
  public static avi toMMGetStrategyReq()
  {
    avi localavi = new avi();
    ArrayList localArrayList = SmcLogic.getStrategyVersions();
    if (localArrayList.size() != 6) {
      return null;
    }
    localavi.EqT = ((Integer)localArrayList.get(0)).intValue();
    localavi.EqU = ((Integer)localArrayList.get(1)).intValue();
    localavi.EqV = ((Integer)localArrayList.get(2)).intValue();
    localavi.ENx = ((Integer)localArrayList.get(3)).intValue();
    localavi.ENy = ((Integer)localArrayList.get(4)).intValue();
    localavi.ENz = ((Integer)localArrayList.get(5)).intValue();
    return localavi;
  }
  
  public static wt toMMReportIdkeyReq(g paramg)
  {
    wt localwt = new wt();
    localwt.EqT = paramg.DJI;
    localwt.EqU = paramg.DJY;
    localwt.EqV = 0;
    int i = 0;
    while (i < paramg.DJZ.size())
    {
      com.tencent.mm.protocal.a.a.b localb = (com.tencent.mm.protocal.a.a.b)paramg.DJZ.get(i);
      ws localws = new ws();
      localws.pAs = localb.uin;
      localws.DWJ = localb.DJG;
      localws.EqS = localb.nettype;
      int j = 0;
      while (j < localb.DJH.size())
      {
        a locala = (a)localb.DJH.get(j);
        bnv localbnv = new bnv();
        localbnv.Fdx = locala.DJF;
        localbnv.EvG = 0;
        localbnv.Fdz = 0;
        localbnv.ncL = locala.count;
        localbnv.Fdy = com.tencent.mm.bw.b.cc(Integer.toString(locala.value).getBytes());
        localws.tiT.add(localbnv);
        j += 1;
      }
      localwt.EqW.add(localws);
      i += 1;
    }
    return localwt;
  }
  
  public static wt toMMReportKvReq(i parami)
  {
    wt localwt = new wt();
    localwt.EqT = parami.DJI;
    localwt.EqU = parami.DJY;
    localwt.EqV = parami.DJW;
    int i = 0;
    while (i < parami.DJZ.size())
    {
      e locale = (e)parami.DJZ.get(i);
      ws localws = new ws();
      localws.pAs = locale.uin;
      localws.DWJ = locale.DJG;
      localws.EqS = locale.nettype;
      localws.fZs = locale.DJS;
      localws.fZq = locale.DJQ;
      localws.fZr = locale.DJR;
      localws.fZt = locale.DJT;
      localws.fZu = locale.DJU;
      localws.ndN = locale.DJV;
      int j = 0;
      while (j < locale.DJH.size())
      {
        d locald = (d)locale.DJH.get(j);
        bnv localbnv = new bnv();
        localbnv.Fdx = locald.DJF;
        localbnv.Fdy = locald.DJO;
        localbnv.Fdz = locald.DJP;
        localbnv.EvG = locald.xxQ;
        localbnv.ncL = locald.count;
        localws.tiT.add(localbnv);
        j += 1;
      }
      localwt.EqW.add(localws);
      i += 1;
    }
    return localwt;
  }
  
  public static bky toMMSelfMonitor(k paramk)
  {
    bky localbky = new bky();
    localbky.Faw = paramk.DKc;
    int i = 0;
    while (i < paramk.DKd.size())
    {
      bkz localbkz = new bkz();
      l locall = (l)paramk.DKd.get(i);
      localbkz.Fax = locall.DKe;
      localbkz.cZY = locall.action;
      localbkz.Fay = locall.DKf;
      localbkz.Faz = locall.DKg;
      localbkz.FaA = locall.DKh;
      localbkz.FaB = locall.DKi;
      localbkz.FaC = locall.DKj;
      localbkz.FaD = locall.DKk;
      localbky.tiT.add(localbkz);
      i += 1;
    }
    return localbky;
  }
  
  public static c toSmcIdkeyStrategyResp(avj paramavj)
  {
    c localc = new c();
    localc.ret = paramavj.Ret;
    localc.DJI = paramavj.EqZ;
    localc.DJJ = paramavj.Era;
    localc.DJM = paramavj.Erf;
    localc.DJN = paramavj.Erh;
    localc.DJK = fillStrategyTable(paramavj.Erc);
    localc.DJL = fillStrategyTable(paramavj.Erd);
    return localc;
  }
  
  public static f toSmcKVStrategyResp(avj paramavj)
  {
    f localf = new f();
    localf.ret = paramavj.Ret;
    localf.DJI = paramavj.ENx;
    localf.DJJ = paramavj.ENy;
    localf.DJW = paramavj.ENz;
    localf.DJM = paramavj.Erf;
    localf.DJN = paramavj.Erh;
    localf.DJK = fillStrategyTable(paramavj.ENA);
    localf.DJL = fillStrategyTable(paramavj.ENB);
    localf.DJX = fillStrategyTable(paramavj.ENC);
    return localf;
  }
  
  public static h toSmcReportIdkeyResp(wu paramwu)
  {
    h localh = new h();
    localh.ret = paramwu.Ret;
    localh.DJI = paramwu.EqZ;
    localh.DJJ = paramwu.Era;
    localh.DJM = paramwu.Erf;
    localh.DKb = paramwu.Erg;
    localh.DJN = paramwu.Erh;
    localh.DJK = fillStrategyTable(paramwu.Erc);
    localh.DJL = fillStrategyTable(paramwu.Erd);
    return localh;
  }
  
  public static j toSmcReportKvResp(wu paramwu)
  {
    j localj = new j();
    localj.ret = paramwu.Ret;
    localj.DJI = paramwu.EqZ;
    localj.DJJ = paramwu.Era;
    localj.DJW = paramwu.Erb;
    localj.DJM = paramwu.Erf;
    localj.DKb = paramwu.Erg;
    localj.DJN = paramwu.Erh;
    localj.DJK = fillStrategyTable(paramwu.Erc);
    localj.DJL = fillStrategyTable(paramwu.Erd);
    localj.DJX = fillStrategyTable(paramwu.Ere);
    return localj;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mars.smc.SmcProtoBufUtil
 * JD-Core Version:    0.7.0.1
 */