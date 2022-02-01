package com.tencent.mm.plugin.expt.d.e;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.expt.d.e.a.b;
import com.tencent.mm.protocal.protobuf.afq;
import com.tencent.mm.protocal.protobuf.afr;
import com.tencent.mm.protocal.protobuf.afs;
import com.tencent.mm.protocal.protobuf.aft;
import com.tencent.mm.protocal.protobuf.afu;
import com.tencent.mm.protocal.protobuf.afv;
import com.tencent.mm.protocal.protobuf.afw;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public final class c
{
  public static afu U(Map<String, b> paramMap)
  {
    AppMethodBeat.i(210263);
    if ((paramMap == null) || (paramMap.size() <= 0))
    {
      AppMethodBeat.o(210263);
      return null;
    }
    afu localafu = new afu();
    paramMap = paramMap.values().iterator();
    while (paramMap.hasNext())
    {
      Object localObject = (b)paramMap.next();
      aft localaft = new aft();
      localaft.qQf = ((b)localObject).qQf;
      localaft.qQb = ((b)localObject).qQb;
      localaft.qQc = ((b)localObject).qQc;
      localaft.qQg = ((b)localObject).qQg;
      localaft.qQh = ((b)localObject).qQh;
      localaft.qQi = ((b)localObject).qQi;
      localaft.qQk = ((b)localObject).qQk;
      localaft.qQl = ((b)localObject).qQl;
      localaft.script = ((b)localObject).script;
      localaft.qQm = ((b)localObject).qQm;
      localObject = ((b)localObject).qQj.iterator();
      while (((Iterator)localObject).hasNext())
      {
        com.tencent.mm.plugin.expt.d.e.a.a locala = (com.tencent.mm.plugin.expt.d.e.a.a)((Iterator)localObject).next();
        afs localafs = new afs();
        localafs.index = locala.index;
        localafs.name = locala.name;
        localafs.type = locala.type;
        localaft.GdD.add(localafs);
      }
      localafu.GdE.add(localaft);
    }
    AppMethodBeat.o(210263);
    return localafu;
  }
  
  public static afw V(Map<String, com.tencent.mm.plugin.expt.d.e.a.c> paramMap)
  {
    AppMethodBeat.i(210265);
    if ((paramMap == null) || (paramMap.size() <= 0))
    {
      AppMethodBeat.o(210265);
      return null;
    }
    afw localafw = new afw();
    paramMap = paramMap.values().iterator();
    while (paramMap.hasNext())
    {
      com.tencent.mm.plugin.expt.d.e.a.c localc = (com.tencent.mm.plugin.expt.d.e.a.c)paramMap.next();
      afv localafv = new afv();
      localafv.qQf = localc.qQf;
      localafv.qQi = localc.qQi;
      localafv.sql = localc.sql;
      localafv.dbName = localc.dbName;
      localafv.owc = localc.owc;
      localafv.qQm = localc.qQm;
      localafw.GdF.add(localafv);
    }
    AppMethodBeat.o(210265);
    return localafw;
  }
  
  public static List<a> a(afr paramafr)
  {
    AppMethodBeat.i(210267);
    if (paramafr.GdC.size() <= 0)
    {
      AppMethodBeat.o(210267);
      return null;
    }
    ArrayList localArrayList = new ArrayList();
    paramafr = paramafr.GdC.iterator();
    while (paramafr.hasNext())
    {
      afq localafq = (afq)paramafr.next();
      a locala = new a();
      locala.qQb = localafq.qQb;
      locala.qQc = localafq.qQc;
      locala.qQd = localafq.qQd;
      locala.data = localafq.data;
      localArrayList.add(locala);
    }
    AppMethodBeat.o(210267);
    return localArrayList;
  }
  
  public static Map<String, b> a(afu paramafu)
  {
    AppMethodBeat.i(210264);
    if (paramafu.GdE.size() <= 0)
    {
      AppMethodBeat.o(210264);
      return null;
    }
    HashMap localHashMap = new HashMap();
    paramafu = paramafu.GdE.iterator();
    while (paramafu.hasNext())
    {
      Object localObject = (aft)paramafu.next();
      b localb = new b();
      localb.qQf = ((aft)localObject).qQf;
      localb.qQb = ((aft)localObject).qQb;
      localb.qQc = ((aft)localObject).qQc;
      localb.qQg = ((aft)localObject).qQg;
      localb.qQh = ((aft)localObject).qQh;
      localb.qQi = ((aft)localObject).qQi;
      localb.qQk = ((aft)localObject).qQk;
      localb.qQl = ((aft)localObject).qQl;
      localb.script = ((aft)localObject).script;
      localb.qQj = new ArrayList();
      localObject = ((aft)localObject).GdD.iterator();
      while (((Iterator)localObject).hasNext())
      {
        afs localafs = (afs)((Iterator)localObject).next();
        com.tencent.mm.plugin.expt.d.e.a.a locala = new com.tencent.mm.plugin.expt.d.e.a.a();
        locala.index = localafs.index;
        locala.name = localafs.name;
        locala.type = localafs.type;
        localb.qQj.add(locala);
      }
      localHashMap.put(localb.qQf, localb);
    }
    AppMethodBeat.o(210264);
    return localHashMap;
  }
  
  public static Map<String, com.tencent.mm.plugin.expt.d.e.a.c> a(afw paramafw)
  {
    AppMethodBeat.i(210266);
    if (paramafw.GdF.size() <= 0)
    {
      AppMethodBeat.o(210266);
      return null;
    }
    HashMap localHashMap = new HashMap();
    paramafw = paramafw.GdF.iterator();
    while (paramafw.hasNext())
    {
      afv localafv = (afv)paramafw.next();
      com.tencent.mm.plugin.expt.d.e.a.c localc = new com.tencent.mm.plugin.expt.d.e.a.c();
      localc.qQf = localafv.qQf;
      localc.qQi = localafv.qQi;
      localc.sql = localafv.sql;
      localc.dbName = localafv.dbName;
      localc.owc = localafv.owc;
      localc.qQm = localafv.qQm;
      localHashMap.put(localc.qQf, localc);
    }
    AppMethodBeat.o(210266);
    return localHashMap;
  }
  
  public static afr cX(List<a> paramList)
  {
    AppMethodBeat.i(210268);
    if ((paramList == null) || (paramList.size() <= 0))
    {
      AppMethodBeat.o(210268);
      return null;
    }
    afr localafr = new afr();
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      a locala = (a)paramList.next();
      afq localafq = new afq();
      localafq.qQb = locala.qQb;
      localafq.qQc = locala.qQc;
      localafq.qQd = locala.qQd;
      localafq.data = locala.data;
      localafr.GdC.add(localafq);
    }
    AppMethodBeat.o(210268);
    return localafr;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.expt.d.e.c
 * JD-Core Version:    0.7.0.1
 */