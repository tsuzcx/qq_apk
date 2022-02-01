package com.tencent.mm.plugin.expt.d.e;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.expt.d.e.a.b;
import com.tencent.mm.protocal.protobuf.afz;
import com.tencent.mm.protocal.protobuf.aga;
import com.tencent.mm.protocal.protobuf.agb;
import com.tencent.mm.protocal.protobuf.agc;
import com.tencent.mm.protocal.protobuf.agd;
import com.tencent.mm.protocal.protobuf.age;
import com.tencent.mm.protocal.protobuf.agf;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public final class c
{
  public static List<a> a(aga paramaga)
  {
    AppMethodBeat.i(195920);
    if (paramaga.Gwj.size() <= 0)
    {
      AppMethodBeat.o(195920);
      return null;
    }
    ArrayList localArrayList = new ArrayList();
    paramaga = paramaga.Gwj.iterator();
    while (paramaga.hasNext())
    {
      afz localafz = (afz)paramaga.next();
      a locala = new a();
      locala.qXX = localafz.qXX;
      locala.data = localafz.data;
      locala.qXW = localafz.qXW;
      localArrayList.add(locala);
    }
    AppMethodBeat.o(195920);
    return localArrayList;
  }
  
  public static Map<String, b> a(agd paramagd)
  {
    AppMethodBeat.i(195917);
    if (paramagd.Gwl.size() <= 0)
    {
      AppMethodBeat.o(195917);
      return null;
    }
    HashMap localHashMap = new HashMap();
    paramagd = paramagd.Gwl.iterator();
    while (paramagd.hasNext())
    {
      Object localObject = (agc)paramagd.next();
      b localb = new b();
      localb.qXW = ((agc)localObject).qXW;
      localb.qXZ = ((agc)localObject).qXZ;
      localb.qYa = ((agc)localObject).qYa;
      localb.qYb = ((agc)localObject).qYb;
      localb.qYd = ((agc)localObject).qYd;
      localb.qYe = ((agc)localObject).qYe;
      localb.qYf = ((agc)localObject).qYf;
      localb.qYg = ((agc)localObject).qYg;
      localb.script = ((agc)localObject).script;
      localb.qYc = new ArrayList();
      localObject = ((agc)localObject).Gwk.iterator();
      while (((Iterator)localObject).hasNext())
      {
        agb localagb = (agb)((Iterator)localObject).next();
        com.tencent.mm.plugin.expt.d.e.a.a locala = new com.tencent.mm.plugin.expt.d.e.a.a();
        locala.index = localagb.index;
        locala.name = localagb.name;
        locala.type = localagb.type;
        localb.qYc.add(locala);
      }
      localHashMap.put(localb.qXW, localb);
    }
    AppMethodBeat.o(195917);
    return localHashMap;
  }
  
  public static Map<String, com.tencent.mm.plugin.expt.d.e.a.c> a(agf paramagf)
  {
    AppMethodBeat.i(195919);
    if (paramagf.Gwm.size() <= 0)
    {
      AppMethodBeat.o(195919);
      return null;
    }
    HashMap localHashMap = new HashMap();
    paramagf = paramagf.Gwm.iterator();
    while (paramagf.hasNext())
    {
      age localage = (age)paramagf.next();
      com.tencent.mm.plugin.expt.d.e.a.c localc = new com.tencent.mm.plugin.expt.d.e.a.c();
      localc.qXW = localage.qXW;
      localc.qYb = localage.qYb;
      localc.sql = localage.sql;
      localc.dbPath = localage.dbPath;
      localc.qYh = localage.qYh;
      localHashMap.put(localc.qXW, localc);
    }
    AppMethodBeat.o(195919);
    return localHashMap;
  }
  
  public static agf ab(Map<String, com.tencent.mm.plugin.expt.d.e.a.c> paramMap)
  {
    AppMethodBeat.i(195918);
    if ((paramMap == null) || (paramMap.size() <= 0))
    {
      AppMethodBeat.o(195918);
      return null;
    }
    agf localagf = new agf();
    paramMap = paramMap.values().iterator();
    while (paramMap.hasNext())
    {
      com.tencent.mm.plugin.expt.d.e.a.c localc = (com.tencent.mm.plugin.expt.d.e.a.c)paramMap.next();
      age localage = new age();
      localage.qXW = localc.qXW;
      localage.qYb = localc.qYb;
      localage.sql = localc.sql;
      localage.dbPath = localc.dbPath;
      localage.qYh = localc.qYh;
      localagf.Gwm.add(localage);
    }
    AppMethodBeat.o(195918);
    return localagf;
  }
  
  public static aga da(List<a> paramList)
  {
    AppMethodBeat.i(195921);
    if ((paramList == null) || (paramList.size() <= 0))
    {
      AppMethodBeat.o(195921);
      return null;
    }
    aga localaga = new aga();
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      a locala = (a)paramList.next();
      afz localafz = new afz();
      localafz.qXX = locala.qXX;
      localafz.data = locala.data;
      localafz.qXW = locala.qXW;
      localaga.Gwj.add(localafz);
    }
    AppMethodBeat.o(195921);
    return localaga;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.expt.d.e.c
 * JD-Core Version:    0.7.0.1
 */