package com.tencent.mm.plugin.expt.edge.e;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.expt.edge.e.a.b;
import com.tencent.mm.protocal.protobuf.alw;
import com.tencent.mm.protocal.protobuf.alx;
import com.tencent.mm.protocal.protobuf.aly;
import com.tencent.mm.protocal.protobuf.amd;
import com.tencent.mm.protocal.protobuf.ame;
import com.tencent.mm.protocal.protobuf.amf;
import com.tencent.mm.protocal.protobuf.amg;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import org.apache.commons.c.i;

public final class c
{
  public static List<a> a(alx paramalx)
  {
    AppMethodBeat.i(299662);
    if (paramalx.ZsW.size() <= 0)
    {
      AppMethodBeat.o(299662);
      return null;
    }
    ArrayList localArrayList = new ArrayList();
    paramalx = paramalx.ZsW.iterator();
    while (paramalx.hasNext())
    {
      alw localalw = (alw)paramalx.next();
      a locala = new a();
      locala.zzT = localalw.zzT;
      locala.data = localalw.data;
      locala.zzS = localalw.zzS;
      localArrayList.add(locala);
    }
    AppMethodBeat.o(299662);
    return localArrayList;
  }
  
  public static Map<String, b> a(ame paramame)
  {
    AppMethodBeat.i(299636);
    if (paramame.Ztd.size() <= 0)
    {
      AppMethodBeat.o(299636);
      return null;
    }
    HashMap localHashMap = new HashMap();
    paramame = paramame.Ztd.iterator();
    while (paramame.hasNext())
    {
      Object localObject = (amd)paramame.next();
      if (!i.hm(((amd)localObject).zzS))
      {
        b localb = new b();
        localb.zzS = ((amd)localObject).zzS;
        localb.zzV = ((amd)localObject).zzV;
        localb.zzW = ((amd)localObject).zzW;
        localb.zzX = ((amd)localObject).zzX;
        localb.zzZ = ((amd)localObject).zzZ;
        localb.zAd = ((amd)localObject).zAd;
        localb.zAa = ((amd)localObject).zAa;
        localb.zAb = ((amd)localObject).zAb;
        localb.zAc = ((amd)localObject).zAc;
        localb.script = ((amd)localObject).script;
        localb.zAe = ((amd)localObject).zAe;
        localb.zAg = ((amd)localObject).zAg;
        localb.zzY = new ArrayList();
        localObject = ((amd)localObject).Ztc.iterator();
        while (((Iterator)localObject).hasNext())
        {
          aly localaly = (aly)((Iterator)localObject).next();
          com.tencent.mm.plugin.expt.edge.e.a.a locala = new com.tencent.mm.plugin.expt.edge.e.a.a();
          locala.index = localaly.index;
          locala.name = localaly.name;
          locala.type = localaly.type;
          localb.zzY.add(locala);
        }
        localHashMap.put(localb.zzS, localb);
      }
    }
    AppMethodBeat.o(299636);
    return localHashMap;
  }
  
  public static Map<String, com.tencent.mm.plugin.expt.edge.e.a.c> a(amg paramamg)
  {
    AppMethodBeat.i(299656);
    if (paramamg.Zte.size() <= 0)
    {
      AppMethodBeat.o(299656);
      return null;
    }
    HashMap localHashMap = new HashMap();
    paramamg = paramamg.Zte.iterator();
    while (paramamg.hasNext())
    {
      amf localamf = (amf)paramamg.next();
      if (!i.hm(localamf.zzS))
      {
        com.tencent.mm.plugin.expt.edge.e.a.c localc = new com.tencent.mm.plugin.expt.edge.e.a.c();
        localc.zzS = localamf.zzS;
        localc.zzX = localamf.zzX;
        localc.sql = localamf.sql;
        localc.zAh = localamf.zAh;
        localc.zAi = localamf.zAi;
        localc.dbPath = localamf.dbPath;
        localc.zAd = localamf.zAd;
        localc.zAf = localamf.zAf;
        localHashMap.put(localc.zzS, localc);
      }
    }
    AppMethodBeat.o(299656);
    return localHashMap;
  }
  
  public static amg ag(Map<String, com.tencent.mm.plugin.expt.edge.e.a.c> paramMap)
  {
    AppMethodBeat.i(299645);
    if ((paramMap == null) || (paramMap.size() <= 0))
    {
      AppMethodBeat.o(299645);
      return null;
    }
    amg localamg = new amg();
    paramMap = paramMap.values().iterator();
    while (paramMap.hasNext())
    {
      com.tencent.mm.plugin.expt.edge.e.a.c localc = (com.tencent.mm.plugin.expt.edge.e.a.c)paramMap.next();
      if (!i.hm(localc.zzS))
      {
        amf localamf = new amf();
        localamf.zzS = localc.zzS;
        localamf.zzX = localc.zzX;
        localamf.sql = localc.sql;
        localamf.zAh = localc.zAh;
        localamf.zAi = localc.zAi;
        localamf.dbPath = localc.dbPath;
        localamf.zAd = localc.zAd;
        localamf.zAf = localc.zAf;
        localamg.Zte.add(localamf);
      }
    }
    AppMethodBeat.o(299645);
    return localamg;
  }
  
  public static alx fm(List<a> paramList)
  {
    AppMethodBeat.i(299669);
    if ((paramList == null) || (paramList.size() <= 0))
    {
      AppMethodBeat.o(299669);
      return null;
    }
    alx localalx = new alx();
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      a locala = (a)paramList.next();
      alw localalw = new alw();
      localalw.zzT = locala.zzT;
      localalw.data = locala.data;
      localalw.zzS = locala.zzS;
      localalx.ZsW.add(localalw);
    }
    AppMethodBeat.o(299669);
    return localalx;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.expt.edge.e.c
 * JD-Core Version:    0.7.0.1
 */