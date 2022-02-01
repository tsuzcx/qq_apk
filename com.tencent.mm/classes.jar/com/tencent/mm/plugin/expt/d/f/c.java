package com.tencent.mm.plugin.expt.d.f;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.expt.d.f.a.b;
import com.tencent.mm.protocal.protobuf.air;
import com.tencent.mm.protocal.protobuf.ais;
import com.tencent.mm.protocal.protobuf.ait;
import com.tencent.mm.protocal.protobuf.aiy;
import com.tencent.mm.protocal.protobuf.aiz;
import com.tencent.mm.protocal.protobuf.aja;
import com.tencent.mm.protocal.protobuf.ajb;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public final class c
{
  public static ajb W(Map<String, com.tencent.mm.plugin.expt.d.f.a.c> paramMap)
  {
    AppMethodBeat.i(257697);
    if ((paramMap == null) || (paramMap.size() <= 0))
    {
      AppMethodBeat.o(257697);
      return null;
    }
    ajb localajb = new ajb();
    paramMap = paramMap.values().iterator();
    while (paramMap.hasNext())
    {
      com.tencent.mm.plugin.expt.d.f.a.c localc = (com.tencent.mm.plugin.expt.d.f.a.c)paramMap.next();
      aja localaja = new aja();
      localaja.wdY = localc.wdY;
      localaja.wed = localc.wed;
      localaja.sql = localc.sql;
      localaja.wen = localc.wen;
      localaja.weo = localc.weo;
      localaja.dbPath = localc.dbPath;
      localaja.wej = localc.wej;
      localaja.wel = localc.wel;
      localajb.Stu.add(localaja);
    }
    AppMethodBeat.o(257697);
    return localajb;
  }
  
  public static List<a> a(ais paramais)
  {
    AppMethodBeat.i(257701);
    if (paramais.Stm.size() <= 0)
    {
      AppMethodBeat.o(257701);
      return null;
    }
    ArrayList localArrayList = new ArrayList();
    paramais = paramais.Stm.iterator();
    while (paramais.hasNext())
    {
      air localair = (air)paramais.next();
      a locala = new a();
      locala.wdZ = localair.wdZ;
      locala.data = localair.data;
      locala.wdY = localair.wdY;
      localArrayList.add(locala);
    }
    AppMethodBeat.o(257701);
    return localArrayList;
  }
  
  public static Map<String, b> a(aiz paramaiz)
  {
    AppMethodBeat.i(257696);
    if (paramaiz.Stt.size() <= 0)
    {
      AppMethodBeat.o(257696);
      return null;
    }
    HashMap localHashMap = new HashMap();
    paramaiz = paramaiz.Stt.iterator();
    while (paramaiz.hasNext())
    {
      Object localObject = (aiy)paramaiz.next();
      b localb = new b();
      localb.wdY = ((aiy)localObject).wdY;
      localb.web = ((aiy)localObject).web;
      localb.wec = ((aiy)localObject).wec;
      localb.wed = ((aiy)localObject).wed;
      localb.wef = ((aiy)localObject).wef;
      localb.wej = ((aiy)localObject).wej;
      localb.weg = ((aiy)localObject).weg;
      localb.weh = ((aiy)localObject).weh;
      localb.wei = ((aiy)localObject).wei;
      localb.script = ((aiy)localObject).script;
      localb.wek = ((aiy)localObject).wek;
      localb.wem = ((aiy)localObject).wem;
      localb.wee = new ArrayList();
      localObject = ((aiy)localObject).Sts.iterator();
      while (((Iterator)localObject).hasNext())
      {
        ait localait = (ait)((Iterator)localObject).next();
        com.tencent.mm.plugin.expt.d.f.a.a locala = new com.tencent.mm.plugin.expt.d.f.a.a();
        locala.index = localait.index;
        locala.name = localait.name;
        locala.type = localait.type;
        localb.wee.add(locala);
      }
      localHashMap.put(localb.wdY, localb);
    }
    AppMethodBeat.o(257696);
    return localHashMap;
  }
  
  public static Map<String, com.tencent.mm.plugin.expt.d.f.a.c> a(ajb paramajb)
  {
    AppMethodBeat.i(257699);
    if (paramajb.Stu.size() <= 0)
    {
      AppMethodBeat.o(257699);
      return null;
    }
    HashMap localHashMap = new HashMap();
    paramajb = paramajb.Stu.iterator();
    while (paramajb.hasNext())
    {
      aja localaja = (aja)paramajb.next();
      com.tencent.mm.plugin.expt.d.f.a.c localc = new com.tencent.mm.plugin.expt.d.f.a.c();
      localc.wdY = localaja.wdY;
      localc.wed = localaja.wed;
      localc.sql = localaja.sql;
      localc.wen = localaja.wen;
      localc.weo = localaja.weo;
      localc.dbPath = localaja.dbPath;
      localc.wej = localaja.wej;
      localc.wel = localaja.wel;
      localHashMap.put(localc.wdY, localc);
    }
    AppMethodBeat.o(257699);
    return localHashMap;
  }
  
  public static ais dq(List<a> paramList)
  {
    AppMethodBeat.i(257703);
    if ((paramList == null) || (paramList.size() <= 0))
    {
      AppMethodBeat.o(257703);
      return null;
    }
    ais localais = new ais();
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      a locala = (a)paramList.next();
      air localair = new air();
      localair.wdZ = locala.wdZ;
      localair.data = locala.data;
      localair.wdY = locala.wdY;
      localais.Stm.add(localair);
    }
    AppMethodBeat.o(257703);
    return localais;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.expt.d.f.c
 * JD-Core Version:    0.7.0.1
 */