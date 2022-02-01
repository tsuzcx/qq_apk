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
import com.tencent.mm.protocal.protobuf.azw;
import com.tencent.mm.protocal.protobuf.azx;
import com.tencent.mm.protocal.protobuf.bqa;
import com.tencent.mm.protocal.protobuf.bqb;
import com.tencent.mm.protocal.protobuf.btb;
import com.tencent.mm.protocal.protobuf.cdk;
import com.tencent.mm.protocal.protobuf.dlb;
import com.tencent.mm.protocal.protobuf.yu;
import com.tencent.mm.protocal.protobuf.yv;
import com.tencent.mm.protocal.protobuf.yw;
import java.util.ArrayList;
import java.util.LinkedList;

public class SmcProtoBufUtil
{
  private static o fillStrategyTable(LinkedList<dlb> paramLinkedList)
  {
    o localo = new o();
    int i = 0;
    while (i < paramLinkedList.size())
    {
      dlb localdlb = (dlb)paramLinkedList.get(i);
      m localm = new m();
      localm.FHQ = localdlb.HSI;
      localm.FHR = localdlb.HSJ;
      int j = 0;
      while (j < localdlb.HSK.size())
      {
        cdk localcdk = (cdk)localdlb.HSK.get(j);
        n localn = new n();
        localn.FHk = localcdk.HgA;
        localn.FHT = localcdk.Hqp;
        localn.FHU = localcdk.Hqn;
        localn.FHV = localcdk.Hqo;
        localn.FHW = localcdk.Hqq;
        localn.FHX = localcdk.Hqr;
        localn.FHY = localcdk.Hqs;
        localn.type = localcdk.nJA;
        localm.FHS.add(localn);
        j += 1;
      }
      localo.FHZ.add(localm);
      i += 1;
    }
    return localo;
  }
  
  public static azw toMMGetStrategyReq()
  {
    azw localazw = new azw();
    ArrayList localArrayList = SmcLogic.getStrategyVersions();
    if (localArrayList.size() != 6) {
      return null;
    }
    localazw.GqC = ((Integer)localArrayList.get(0)).intValue();
    localazw.GqD = ((Integer)localArrayList.get(1)).intValue();
    localazw.GqE = ((Integer)localArrayList.get(2)).intValue();
    localazw.GQc = ((Integer)localArrayList.get(3)).intValue();
    localazw.GQd = ((Integer)localArrayList.get(4)).intValue();
    localazw.GQe = ((Integer)localArrayList.get(5)).intValue();
    return localazw;
  }
  
  public static yv toMMReportIdkeyReq(g paramg)
  {
    yv localyv = new yv();
    localyv.GqC = paramg.FHn;
    localyv.GqD = paramg.FHD;
    localyv.GqE = 0;
    int i = 0;
    while (i < paramg.FHE.size())
    {
      com.tencent.mm.protocal.a.a.b localb = (com.tencent.mm.protocal.a.a.b)paramg.FHE.get(i);
      yu localyu = new yu();
      localyu.qkC = localb.uin;
      localyu.FUA = localb.FHl;
      localyu.GqB = localb.nettype;
      int j = 0;
      while (j < localb.FHm.size())
      {
        a locala = (a)localb.FHm.get(j);
        btb localbtb = new btb();
        localbtb.HgA = locala.FHk;
        localbtb.GvJ = 0;
        localbtb.HgC = 0;
        localbtb.nID = locala.count;
        localbtb.HgB = com.tencent.mm.bw.b.cm(Integer.toString(locala.value).getBytes());
        localyu.usl.add(localbtb);
        j += 1;
      }
      localyv.GqF.add(localyu);
      i += 1;
    }
    return localyv;
  }
  
  public static yv toMMReportKvReq(i parami)
  {
    yv localyv = new yv();
    localyv.GqC = parami.FHn;
    localyv.GqD = parami.FHD;
    localyv.GqE = parami.FHB;
    int i = 0;
    while (i < parami.FHE.size())
    {
      e locale = (e)parami.FHE.get(i);
      yu localyu = new yu();
      localyu.qkC = locale.uin;
      localyu.FUA = locale.FHl;
      localyu.GqB = locale.nettype;
      localyu.gvq = locale.FHx;
      localyu.gvo = locale.FHv;
      localyu.gvp = locale.FHw;
      localyu.gvr = locale.FHy;
      localyu.gvs = locale.FHz;
      localyu.nJF = locale.FHA;
      int j = 0;
      while (j < locale.FHm.size())
      {
        d locald = (d)locale.FHm.get(j);
        btb localbtb = new btb();
        localbtb.HgA = locald.FHk;
        localbtb.HgB = locald.FHt;
        localbtb.HgC = locald.FHu;
        localbtb.GvJ = locald.zcL;
        localbtb.nID = locald.count;
        localyu.usl.add(localbtb);
        j += 1;
      }
      localyv.GqF.add(localyu);
      i += 1;
    }
    return localyv;
  }
  
  public static bqa toMMSelfMonitor(k paramk)
  {
    bqa localbqa = new bqa();
    localbqa.Hdw = paramk.FHH;
    int i = 0;
    while (i < paramk.FHI.size())
    {
      bqb localbqb = new bqb();
      l locall = (l)paramk.FHI.get(i);
      localbqb.Hdx = locall.FHJ;
      localbqb.dms = locall.action;
      localbqb.Hdy = locall.FHK;
      localbqb.Hdz = locall.FHL;
      localbqb.HdA = locall.FHM;
      localbqb.HdB = locall.FHN;
      localbqb.HdC = locall.FHO;
      localbqb.HdD = locall.FHP;
      localbqa.usl.add(localbqb);
      i += 1;
    }
    return localbqa;
  }
  
  public static c toSmcIdkeyStrategyResp(azx paramazx)
  {
    c localc = new c();
    localc.ret = paramazx.Ret;
    localc.FHn = paramazx.GqI;
    localc.FHo = paramazx.GqJ;
    localc.FHr = paramazx.GqO;
    localc.FHs = paramazx.GqQ;
    localc.FHp = fillStrategyTable(paramazx.GqL);
    localc.FHq = fillStrategyTable(paramazx.GqM);
    return localc;
  }
  
  public static f toSmcKVStrategyResp(azx paramazx)
  {
    f localf = new f();
    localf.ret = paramazx.Ret;
    localf.FHn = paramazx.GQc;
    localf.FHo = paramazx.GQd;
    localf.FHB = paramazx.GQe;
    localf.FHr = paramazx.GqO;
    localf.FHs = paramazx.GqQ;
    localf.FHp = fillStrategyTable(paramazx.GQf);
    localf.FHq = fillStrategyTable(paramazx.GQg);
    localf.FHC = fillStrategyTable(paramazx.GQh);
    return localf;
  }
  
  public static h toSmcReportIdkeyResp(yw paramyw)
  {
    h localh = new h();
    localh.ret = paramyw.Ret;
    localh.FHn = paramyw.GqI;
    localh.FHo = paramyw.GqJ;
    localh.FHr = paramyw.GqO;
    localh.FHG = paramyw.GqP;
    localh.FHs = paramyw.GqQ;
    localh.FHp = fillStrategyTable(paramyw.GqL);
    localh.FHq = fillStrategyTable(paramyw.GqM);
    return localh;
  }
  
  public static j toSmcReportKvResp(yw paramyw)
  {
    j localj = new j();
    localj.ret = paramyw.Ret;
    localj.FHn = paramyw.GqI;
    localj.FHo = paramyw.GqJ;
    localj.FHB = paramyw.GqK;
    localj.FHr = paramyw.GqO;
    localj.FHG = paramyw.GqP;
    localj.FHs = paramyw.GqQ;
    localj.FHp = fillStrategyTable(paramyw.GqL);
    localj.FHq = fillStrategyTable(paramyw.GqM);
    localj.FHC = fillStrategyTable(paramyw.GqN);
    return localj;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mars.smc.SmcProtoBufUtil
 * JD-Core Version:    0.7.0.1
 */