package com.tencent.mm.plugin.expt.d.e;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.expt.d.e.a.b;
import com.tencent.mm.protocal.protobuf.aig;
import com.tencent.mm.protocal.protobuf.aih;
import com.tencent.mm.protocal.protobuf.aii;
import com.tencent.mm.protocal.protobuf.aij;
import com.tencent.mm.protocal.protobuf.aik;
import com.tencent.mm.protocal.protobuf.ail;
import com.tencent.mm.protocal.protobuf.aim;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public final class c
{
  public static List<a> a(aih paramaih)
  {
    AppMethodBeat.i(220342);
    if (paramaih.LrP.size() <= 0)
    {
      AppMethodBeat.o(220342);
      return null;
    }
    ArrayList localArrayList = new ArrayList();
    paramaih = paramaih.LrP.iterator();
    while (paramaih.hasNext())
    {
      aig localaig = (aig)paramaih.next();
      a locala = new a();
      locala.syh = localaig.syh;
      locala.data = localaig.data;
      locala.syg = localaig.syg;
      localArrayList.add(locala);
    }
    AppMethodBeat.o(220342);
    return localArrayList;
  }
  
  public static Map<String, b> a(aik paramaik)
  {
    AppMethodBeat.i(220339);
    if (paramaik.LrR.size() <= 0)
    {
      AppMethodBeat.o(220339);
      return null;
    }
    HashMap localHashMap = new HashMap();
    paramaik = paramaik.LrR.iterator();
    while (paramaik.hasNext())
    {
      Object localObject = (aij)paramaik.next();
      b localb = new b();
      localb.syg = ((aij)localObject).syg;
      localb.syj = ((aij)localObject).syj;
      localb.syk = ((aij)localObject).syk;
      localb.syl = ((aij)localObject).syl;
      localb.syn = ((aij)localObject).syn;
      localb.syo = ((aij)localObject).syo;
      localb.syp = ((aij)localObject).syp;
      localb.syq = ((aij)localObject).syq;
      localb.script = ((aij)localObject).script;
      localb.sys = ((aij)localObject).sys;
      localb.sym = new ArrayList();
      localObject = ((aij)localObject).LrQ.iterator();
      while (((Iterator)localObject).hasNext())
      {
        aii localaii = (aii)((Iterator)localObject).next();
        com.tencent.mm.plugin.expt.d.e.a.a locala = new com.tencent.mm.plugin.expt.d.e.a.a();
        locala.index = localaii.index;
        locala.name = localaii.name;
        locala.type = localaii.type;
        localb.sym.add(locala);
      }
      localHashMap.put(localb.syg, localb);
    }
    AppMethodBeat.o(220339);
    return localHashMap;
  }
  
  public static Map<String, com.tencent.mm.plugin.expt.d.e.a.c> a(aim paramaim)
  {
    AppMethodBeat.i(220341);
    if (paramaim.LrS.size() <= 0)
    {
      AppMethodBeat.o(220341);
      return null;
    }
    HashMap localHashMap = new HashMap();
    paramaim = paramaim.LrS.iterator();
    while (paramaim.hasNext())
    {
      ail localail = (ail)paramaim.next();
      com.tencent.mm.plugin.expt.d.e.a.c localc = new com.tencent.mm.plugin.expt.d.e.a.c();
      localc.syg = localail.syg;
      localc.syl = localail.syl;
      localc.sql = localail.sql;
      localc.syt = localail.syt;
      localc.dbPath = localail.dbPath;
      localc.syr = localail.syr;
      localHashMap.put(localc.syg, localc);
    }
    AppMethodBeat.o(220341);
    return localHashMap;
  }
  
  public static aim ae(Map<String, com.tencent.mm.plugin.expt.d.e.a.c> paramMap)
  {
    AppMethodBeat.i(220340);
    if ((paramMap == null) || (paramMap.size() <= 0))
    {
      AppMethodBeat.o(220340);
      return null;
    }
    aim localaim = new aim();
    paramMap = paramMap.values().iterator();
    while (paramMap.hasNext())
    {
      com.tencent.mm.plugin.expt.d.e.a.c localc = (com.tencent.mm.plugin.expt.d.e.a.c)paramMap.next();
      ail localail = new ail();
      localail.syg = localc.syg;
      localail.syl = localc.syl;
      localail.sql = localc.sql;
      localail.syt = localc.syt;
      localail.dbPath = localc.dbPath;
      localail.syr = localc.syr;
      localaim.LrS.add(localail);
    }
    AppMethodBeat.o(220340);
    return localaim;
  }
  
  public static aih jdMethod_do(List<a> paramList)
  {
    AppMethodBeat.i(220343);
    if ((paramList == null) || (paramList.size() <= 0))
    {
      AppMethodBeat.o(220343);
      return null;
    }
    aih localaih = new aih();
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      a locala = (a)paramList.next();
      aig localaig = new aig();
      localaig.syh = locala.syh;
      localaig.data = locala.data;
      localaig.syg = locala.syg;
      localaih.LrP.add(localaig);
    }
    AppMethodBeat.o(220343);
    return localaih;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.expt.d.e.c
 * JD-Core Version:    0.7.0.1
 */