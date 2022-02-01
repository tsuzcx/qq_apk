package com.tencent.mm.plugin.expt.hellhound.a.d;

import android.util.Pair;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.expt.hellhound.a.f.b.b.a;
import com.tencent.mm.plugin.expt.hellhound.a.f.c.j;
import com.tencent.mm.plugin.expt.hellhound.a.f.c.j.a;
import com.tencent.mm.protocal.protobuf.bfy;
import com.tencent.mm.protocal.protobuf.bfz;
import com.tencent.mm.protocal.protobuf.bga;
import com.tencent.mm.protocal.protobuf.bgb;
import com.tencent.mm.protocal.protobuf.cyl;
import com.tencent.mm.protocal.protobuf.dve;
import com.tencent.mm.protocal.protobuf.dvg;
import com.tencent.mm.protocal.protobuf.dvk;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/expt/hellhound/ext/fuzzymatch/FuzzyMatch;", "", "()V", "TAG", "", "is8EventForFragment", "", "_addPage", "", "curSessionId", "curPageConfig", "Lcom/tencent/mm/protocal/protobuf/SessionPage;", "pathConfig", "Lcom/tencent/mm/protocal/protobuf/SessionPagePath;", "curPage", "timestamp", "", "_addPrePage", "prePageConfig", "expctPageConfig", "_addPrePage2", "prePagesConfig", "", "_doNewMatch", "curCloudConfig", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "matchingPathIds", "_doNewMatch1Page", "_getCloudConfig", "Lcom/tencent/mm/vending/tuple/Tuple2;", "_isPageLegal", "pageName", "_matchOn8Event", "_matchOnFinish", "onSessionClose", "_matchOnNot1stOnResume", "_matchOnResume", "_matchOnSessionNot1STOnResume", "sessionPath", "Lcom/tencent/mm/protocal/protobuf/SessionFuzzyPath;", "_updatePath", "getFuzzyPathOfCurSession", "Landroid/util/Pair;", "", "getMatchedFuzzyPaths", "Lcom/tencent/mm/protocal/protobuf/FuzzyPath;", "sessionId", "getMatchingFuzzyPaths", "getReportCache", "Lcom/tencent/mm/protocal/protobuf/FuzzyMatchCache;", "match", "state", "Lcom/tencent/mm/plugin/expt/hellhound/ext/fuzzymatch/MatchState;", "mmProcessRestartEvent", "resetFuzzyDaoOnSessionStart", "resetReportCache", "updateSessionFuzzyPath", "sessionFuzzyPath", "index", "plugin-expt_release"})
public final class a
{
  private static boolean sHV;
  public static final a sHW;
  
  static
  {
    AppMethodBeat.i(122574);
    sHW = new a();
    AppMethodBeat.o(122574);
  }
  
  private static void Dp(long paramLong)
  {
    AppMethodBeat.i(184280);
    e.a locala = e.sHZ;
    e.a.Dq(paramLong);
    AppMethodBeat.o(184280);
  }
  
  private static ArrayList<Long> a(String paramString, dve paramdve, long paramLong)
  {
    AppMethodBeat.i(184277);
    ArrayList localArrayList = new ArrayList();
    int i = paramdve.LPC.size() - 1;
    if (i >= 0)
    {
      Object localObject = paramdve.LPC.get(i);
      p.g(localObject, "sessionPath.paths[i]");
      localObject = (bgb)localObject;
      bga localbga;
      if (((bgb)localObject).LPK.size() == 1) {
        if (((bgb)localObject).LPI.isEmpty())
        {
          localbga = new bga();
          localbga.name = paramString;
          localbga.startTime = paramLong;
          ((bgb)localObject).LPK.addLast(localbga);
          localArrayList.add(Long.valueOf(((bgb)localObject).LPN));
          Log.i("HABBYGE-MALI.FuzzyMatch", "_updatePath: " + ((bgb)localObject).LPN + ", " + paramString);
        }
      }
      for (;;)
      {
        i -= 1;
        break;
        if (((bgb)localObject).LPI.size() == 1)
        {
          if (p.j(((bgb)localObject).LPJ.dMl, paramString))
          {
            localbga = new bga();
            localbga.name = paramString;
            localbga.startTime = paramLong;
            ((bgb)localObject).LPK.addLast(localbga);
            localArrayList.add(Long.valueOf(((bgb)localObject).LPN));
            Log.i("HABBYGE-MALI.FuzzyMatch", "_updatePath, =1: " + ((bgb)localObject).LPN + ", " + paramString);
          }
          else if (p.j(((dvg)((bgb)localObject).LPI.get(0)).dMl, paramString))
          {
            ((bgb)localObject).LPK.clear();
            localbga = new bga();
            localbga.name = paramString;
            localbga.startTime = paramLong;
            ((bgb)localObject).LPK.addLast(localbga);
            localArrayList.add(Long.valueOf(((bgb)localObject).LPN));
          }
          else
          {
            paramdve.LPC.remove(i);
          }
        }
        else if (p.j(((dvg)((bgb)localObject).LPI.get(1)).dMl, paramString))
        {
          localbga = new bga();
          localbga.name = paramString;
          localbga.startTime = paramLong;
          ((bgb)localObject).LPK.addLast(localbga);
          localArrayList.add(Long.valueOf(((bgb)localObject).LPN));
        }
        else if (p.j(((dvg)((bgb)localObject).LPI.get(0)).dMl, paramString))
        {
          ((bgb)localObject).LPK.clear();
          localbga = new bga();
          localbga.name = paramString;
          localbga.startTime = paramLong;
          ((bgb)localObject).LPK.addLast(localbga);
          localArrayList.add(Long.valueOf(((bgb)localObject).LPN));
        }
        else
        {
          paramdve.LPC.remove(i);
          continue;
          if ((((bgb)localObject).LPK.size() > 1) && (((bgb)localObject).LPL)) {
            if (((bgb)localObject).LPI.isEmpty())
            {
              localbga = new bga();
              localbga.name = paramString;
              localbga.startTime = paramLong;
              ((bgb)localObject).LPK.addLast(localbga);
              Log.i("HABBYGE-MALI.FuzzyMatch", "_updatePath, =1: " + ((bgb)localObject).LPN + ", " + paramString);
              localArrayList.add(Long.valueOf(((bgb)localObject).LPN));
            }
            else if (((bgb)localObject).LPI.size() == 1)
            {
              localbga = new bga();
              localbga.name = paramString;
              localbga.startTime = paramLong;
              ((bgb)localObject).LPK.addLast(localbga);
              Log.i("HABBYGE-MALI.FuzzyMatch", "_updatePath, =2: " + ((bgb)localObject).LPN + ", " + paramString);
              localArrayList.add(Long.valueOf(((bgb)localObject).LPN));
            }
            else if (((bgb)localObject).LPK.size() > ((bgb)localObject).LPI.size())
            {
              localbga = new bga();
              localbga.name = paramString;
              localbga.startTime = paramLong;
              ((bgb)localObject).LPK.addLast(localbga);
              Log.i("HABBYGE-MALI.FuzzyMatch", "_updatePath, >2: " + ((bgb)localObject).LPN + ", " + paramString);
              localArrayList.add(Long.valueOf(((bgb)localObject).LPN));
            }
            else if (((bgb)localObject).LPK.size() == ((bgb)localObject).LPI.size())
            {
              if (p.j(((bgb)localObject).LPJ.dMl, paramString))
              {
                localbga = new bga();
                localbga.name = paramString;
                localbga.startTime = paramLong;
                ((bgb)localObject).LPK.addLast(localbga);
                localArrayList.add(Long.valueOf(((bgb)localObject).LPN));
                Log.i("HABBYGE-MALI.FuzzyMatch", "_updatePath, >=2: " + ((bgb)localObject).LPN + ", " + paramString);
              }
              else if (p.j(((dvg)((bgb)localObject).LPI.get(0)).dMl, paramString))
              {
                ((bgb)localObject).LPK.clear();
                localbga = new bga();
                localbga.name = paramString;
                localbga.startTime = paramLong;
                ((bgb)localObject).LPK.addLast(localbga);
                localArrayList.add(Long.valueOf(((bgb)localObject).LPN));
              }
              else
              {
                paramdve.LPC.remove(i);
              }
            }
            else if (p.j(((dvg)((bgb)localObject).LPI.get(((bgb)localObject).LPK.size())).dMl, paramString))
            {
              localbga = new bga();
              localbga.name = paramString;
              localbga.startTime = paramLong;
              ((bgb)localObject).LPK.addLast(localbga);
              localArrayList.add(Long.valueOf(((bgb)localObject).LPN));
            }
            else if (p.j(((dvg)((bgb)localObject).LPI.get(0)).dMl, paramString))
            {
              ((bgb)localObject).LPK.clear();
              localbga = new bga();
              localbga.name = paramString;
              localbga.startTime = paramLong;
              ((bgb)localObject).LPK.addLast(localbga);
              localArrayList.add(Long.valueOf(((bgb)localObject).LPN));
            }
            else
            {
              paramdve.LPC.remove(i);
            }
          }
        }
      }
    }
    paramString = d.sHY;
    d.a.a(paramdve);
    AppMethodBeat.o(184277);
    return localArrayList;
  }
  
  public static void a(dve paramdve, int paramInt)
  {
    AppMethodBeat.i(221119);
    d.a locala = d.sHY;
    d.a.b(paramdve, paramInt);
    AppMethodBeat.o(221119);
  }
  
  private static void a(String paramString1, dvg paramdvg1, dvg paramdvg2, long paramLong, dvk paramdvk, String paramString2)
  {
    AppMethodBeat.i(221116);
    bgb localbgb = new bgb();
    localbgb.dRM = paramString1;
    localbgb.LPI.add(paramdvg1);
    localbgb.LPJ = paramdvg2;
    localbgb.LPL = true;
    localbgb.vtY = paramdvk.vtY;
    localbgb.LPM = paramdvk.LPM;
    localbgb.LPN = paramdvk.LPN;
    paramdvg1 = new bga();
    paramdvg1.name = paramString2;
    paramdvg1.startTime = paramLong;
    localbgb.LPK.addLast(paramdvg1);
    paramdvg1 = d.sHY;
    paramdvg1 = d.a.aqg(paramString1);
    ((dve)paramdvg1.first).LPC.addLast(localbgb);
    ((dve)paramdvg1.first).dRM = paramString1;
    paramString1 = d.sHY;
    paramString1 = (dve)paramdvg1.first;
    paramdvg1 = paramdvg1.second;
    p.g(paramdvg1, "curSessionPathPair.second");
    d.a.b(paramString1, ((Number)paramdvg1).intValue());
    AppMethodBeat.o(221116);
  }
  
  private static void a(String paramString1, dvg paramdvg, dvk paramdvk, String paramString2, long paramLong)
  {
    AppMethodBeat.i(221115);
    bgb localbgb = new bgb();
    localbgb.dRM = paramString1;
    localbgb.LPJ = paramdvg;
    localbgb.LPL = true;
    localbgb.vtY = paramdvk.vtY;
    localbgb.LPM = paramdvk.LPM;
    localbgb.LPN = paramdvk.LPN;
    paramdvg = new bga();
    paramdvg.name = paramString2;
    paramdvg.startTime = paramLong;
    localbgb.LPK.addLast(paramdvg);
    paramdvg = d.sHY;
    paramdvg = d.a.aqg(paramString1);
    ((dve)paramdvg.first).LPC.addLast(localbgb);
    ((dve)paramdvg.first).dRM = paramString1;
    paramString1 = d.sHY;
    paramString1 = (dve)paramdvg.first;
    paramdvg = paramdvg.second;
    p.g(paramdvg, "curSessionPathPair.second");
    d.a.b(paramString1, ((Number)paramdvg).intValue());
    AppMethodBeat.o(221115);
  }
  
  private final void a(String paramString1, String paramString2, long paramLong, ArrayList<dvk> paramArrayList)
  {
    AppMethodBeat.i(184275);
    Object localObject = d.sHY;
    localObject = d.a.aqg(paramString2);
    if (((dve)((Pair)localObject).first).LPC.isEmpty())
    {
      a(paramString1, paramString2, paramLong, paramArrayList, new ArrayList());
      AppMethodBeat.o(184275);
      return;
    }
    localObject = ((Pair)localObject).first;
    p.g(localObject, "sessionPathPair.first");
    a(paramString1, paramString2, (dve)localObject, paramLong, paramArrayList);
    AppMethodBeat.o(184275);
  }
  
  private static void a(String paramString1, String paramString2, long paramLong, ArrayList<dvk> paramArrayList, ArrayList<Long> paramArrayList1)
  {
    AppMethodBeat.i(184278);
    paramArrayList = paramArrayList.iterator();
    while (paramArrayList.hasNext())
    {
      dvk localdvk = (dvk)paramArrayList.next();
      if (!paramArrayList1.contains(Long.valueOf(localdvk.LPN))) {
        if (localdvk.MWr.size() == 1)
        {
          p.g(localdvk, "pathConfig");
          a(paramString1, paramString2, localdvk, paramLong);
        }
        else
        {
          Object localObject1;
          Object localObject2;
          if (localdvk.MWr.size() == 2)
          {
            localObject1 = (dvg)localdvk.MWr.get(0);
            localObject2 = (dvg)localdvk.MWr.get(1);
            if (p.j(paramString1, ((dvg)localObject1).dMl))
            {
              p.g(localObject1, "prePageConfig");
              p.g(localObject2, "curPageConfig");
              p.g(localdvk, "pathConfig");
              a(paramString2, (dvg)localObject1, (dvg)localObject2, paramLong, localdvk, paramString1);
            }
          }
          else
          {
            localObject1 = localdvk.MWr.subList(0, localdvk.MWr.size() - 1);
            p.g(localObject1, "pathConfig.pagePathUnits…g.pagePathUnits.size - 1)");
            localObject2 = localdvk.MWr;
            p.g(localObject2, "pathConfig.pagePathUnits");
            localObject2 = (dvg)((LinkedList)localObject2).getLast();
            if (p.j(paramString1, ((dvg)((List)localObject1).get(0)).dMl))
            {
              p.g(localObject2, "curPageConfig");
              p.g(localdvk, "pathConfig");
              a(paramString2, (List)localObject1, paramLong, (dvg)localObject2, localdvk, paramString1);
            }
          }
        }
      }
    }
    AppMethodBeat.o(184278);
  }
  
  private final void a(String paramString1, String paramString2, dve paramdve, long paramLong, ArrayList<dvk> paramArrayList)
  {
    AppMethodBeat.i(184276);
    a(paramString1, paramString2, paramLong, paramArrayList, a(paramString1, paramdve, paramLong));
    AppMethodBeat.o(184276);
  }
  
  private static void a(String paramString1, String paramString2, dvk paramdvk, long paramLong)
  {
    AppMethodBeat.i(221114);
    dvg localdvg = (dvg)paramdvk.MWr.get(0);
    if (localdvg == null)
    {
      AppMethodBeat.o(221114);
      return;
    }
    if (p.j(paramString1, localdvg.dMl)) {
      a(paramString2, localdvg, paramdvk, paramString1, paramLong);
    }
    AppMethodBeat.o(221114);
  }
  
  private static void a(String paramString1, List<? extends dvg> paramList, long paramLong, dvg paramdvg, dvk paramdvk, String paramString2)
  {
    AppMethodBeat.i(221117);
    bgb localbgb = new bgb();
    localbgb.dRM = paramString1;
    localbgb.LPI.addAll((Collection)paramList);
    localbgb.LPJ = paramdvg;
    localbgb.LPL = true;
    localbgb.vtY = paramdvk.vtY;
    localbgb.LPM = paramdvk.LPM;
    localbgb.LPN = paramdvk.LPN;
    paramList = new bga();
    paramList.name = paramString2;
    paramList.startTime = paramLong;
    localbgb.LPK.addLast(paramList);
    paramList = d.sHY;
    paramList = d.a.aqg(paramString1);
    ((dve)paramList.first).LPC.addLast(localbgb);
    ((dve)paramList.first).dRM = paramString1;
    paramString1 = d.sHY;
    paramString1 = (dve)paramList.first;
    paramList = paramList.second;
    p.g(paramList, "curSessionPathPair.second");
    d.a.b(paramString1, ((Number)paramList).intValue());
    AppMethodBeat.o(221117);
  }
  
  private final void ag(String paramString, long paramLong)
  {
    AppMethodBeat.i(184274);
    Object localObject1 = cPz();
    if (localObject1 == null)
    {
      AppMethodBeat.o(184274);
      return;
    }
    String str = (String)((com.tencent.mm.vending.j.c)localObject1).hdM();
    localObject1 = (ArrayList)((com.tencent.mm.vending.j.c)localObject1).hdN();
    if (localObject1 == null)
    {
      AppMethodBeat.o(184274);
      return;
    }
    Object localObject2 = d.sHY;
    localObject2 = d.a.cPD();
    if ((localObject2 == null) || (((bfz)localObject2).LPD.isEmpty()))
    {
      p.g(str, "curSessionId");
      a(paramString, str, paramLong, (ArrayList)localObject1, new ArrayList());
      AppMethodBeat.o(184274);
      return;
    }
    p.g(str, "curSessionId");
    a(paramString, str, paramLong, (ArrayList)localObject1);
    AppMethodBeat.o(184274);
  }
  
  public static void aqa(String paramString)
  {
    AppMethodBeat.i(169394);
    Log.i("HABBYGE-MALI.FuzzyMatch", "resetFuzzyDaoOnStart: ".concat(String.valueOf(paramString)));
    if (paramString == null)
    {
      AppMethodBeat.o(169394);
      return;
    }
    Object localObject1 = d.sHY;
    p.h(paramString, "curSessionId");
    localObject1 = d.a.cPD();
    if (localObject1 != null)
    {
      int i = ((bfz)localObject1).LPD.size() - 1;
      while (i >= 0)
      {
        Object localObject2 = ((bfz)localObject1).LPD.get(i);
        p.g(localObject2, "matchInfo.sessionFuzzyPaths[i]");
        localObject2 = (dve)localObject2;
        if (!p.j(paramString, ((dve)localObject2).dRM))
        {
          Log.i("HABBYGE-MALI.FuzzyMatchDao", "resetOnStart, need remove: " + ((dve)localObject2).dRM);
          int j = ((dve)localObject2).LPC.size() - 1;
          while (j >= 0)
          {
            Object localObject3 = ((dve)localObject2).LPC.get(j);
            p.g(localObject3, "sessionPath.paths[j]");
            if (((bgb)localObject3).LPL)
            {
              Log.i("HABBYGE-MALI.FuzzyMatchDao", "resetOnStart, real remove: " + ((dve)localObject2).dRM);
              ((dve)localObject2).LPC.remove(j);
            }
            j -= 1;
          }
          if (((dve)localObject2).LPC.isEmpty()) {
            ((bfz)localObject1).LPD.remove(i);
          }
        }
        i -= 1;
      }
      d.a.a((bfz)localObject1);
    }
    paramString = f.sIa;
    f.a.reset();
    paramString = j.sIK;
    j.a.reset();
    AppMethodBeat.o(169394);
  }
  
  public static List<bgb> aqb(String paramString)
  {
    AppMethodBeat.i(122573);
    ArrayList localArrayList = new ArrayList();
    Object localObject = d.sHY;
    paramString = d.a.aqf(paramString);
    if (paramString == null)
    {
      AppMethodBeat.o(122573);
      return null;
    }
    paramString = paramString.LPC.iterator();
    while (paramString.hasNext())
    {
      localObject = (bgb)paramString.next();
      if (((bgb)localObject).LPL) {
        localArrayList.add(localObject);
      }
    }
    paramString = (List)localArrayList;
    AppMethodBeat.o(122573);
    return paramString;
  }
  
  public static List<bgb> aqc(String paramString)
  {
    AppMethodBeat.i(185590);
    ArrayList localArrayList = new ArrayList();
    Object localObject = d.sHY;
    localObject = d.a.aqf(paramString);
    bgb localbgb;
    if (localObject != null)
    {
      localObject = ((dve)localObject).LPC.iterator();
      while (((Iterator)localObject).hasNext())
      {
        localbgb = (bgb)((Iterator)localObject).next();
        if (!localbgb.LPL) {
          localArrayList.add(localbgb);
        }
      }
    }
    localObject = f.sIa;
    localObject = f.a.aqh(paramString);
    if (localObject != null)
    {
      localObject = ((dve)localObject).LPC.iterator();
      while (((Iterator)localObject).hasNext())
      {
        localbgb = (bgb)((Iterator)localObject).next();
        if (!localbgb.LPL) {
          localArrayList.add(localbgb);
        }
      }
    }
    localObject = f.sIa;
    f.a.akH(paramString);
    paramString = (List)localArrayList;
    AppMethodBeat.o(185590);
    return paramString;
  }
  
  private static boolean aqd(String paramString)
  {
    AppMethodBeat.i(169395);
    boolean bool = p.j(paramString, "com.tencent.mm.ui.LauncherUI");
    AppMethodBeat.o(169395);
    return bool ^ true;
  }
  
  private static void c(String paramString, boolean paramBoolean, long paramLong)
  {
    AppMethodBeat.i(184279);
    if (((paramBoolean) || (com.tencent.mm.plugin.expt.hellhound.core.b.aoS(paramString))) && (sHV))
    {
      sHV = false;
      AppMethodBeat.o(184279);
      return;
    }
    Object localObject1 = com.tencent.mm.plugin.expt.hellhound.a.f.b.b.sIy;
    localObject1 = com.tencent.mm.plugin.expt.hellhound.a.f.c.c.cQp();
    if (localObject1 == null) {}
    for (localObject1 = null; localObject1 == null; localObject1 = ((cyl)localObject1).sessionId)
    {
      Log.w("HABBYGE-MALI.FuzzyMatch", "_matchOnFinish: curSession == null");
      AppMethodBeat.o(184279);
      return;
    }
    Object localObject2 = d.sHY;
    localObject1 = d.a.aqf((String)localObject1);
    if (localObject1 == null)
    {
      Log.w("HABBYGE-MALI.FuzzyMatch", "_matchOnFinish: sessionMatch == null");
      AppMethodBeat.o(184279);
      return;
    }
    localObject2 = ((dve)localObject1).LPC.iterator();
    while (((Iterator)localObject2).hasNext())
    {
      bgb localbgb = (bgb)((Iterator)localObject2).next();
      Object localObject3;
      if (localbgb.LPL)
      {
        localObject3 = com.tencent.mm.plugin.expt.hellhound.core.b.aoE(localbgb.LPJ.dMl);
        if ((p.j(paramString, localbgb.LPJ.dMl)) || (p.j(paramString, localObject3)))
        {
          localbgb.LPL = false;
          localObject3 = e.sHZ;
          e.a.a(localbgb, paramLong);
        }
      }
      else
      {
        int i = localbgb.LPK.size() - 1;
        label223:
        long l;
        if (i >= 0)
        {
          localObject3 = (bga)localbgb.LPK.get(i);
          if (localObject3 != null)
          {
            String str = com.tencent.mm.plugin.expt.hellhound.core.b.aoE(((bga)localObject3).name);
            if (((p.j(paramString, ((bga)localObject3).name)) || (p.j(paramString, str))) && (((bga)localObject3).LPF <= 0L))
            {
              l = paramLong - ((bga)localObject3).startTime;
              if (l < 0L) {
                break label321;
              }
            }
          }
        }
        for (;;)
        {
          ((bga)localObject3).LPF = l;
          i -= 1;
          break label223;
          break;
          label321:
          l = 0L;
        }
      }
    }
    paramString = d.sHY;
    d.a.a((dve)localObject1);
    AppMethodBeat.o(184279);
  }
  
  public static void cPA()
  {
    AppMethodBeat.i(122571);
    Log.i("HABBYGE-MALI.FuzzyMatch", "resetReportCache");
    e.a locala = e.sHZ;
    com.tencent.mm.plugin.expt.hellhound.core.a.b.o("mmkv_fuzzy_mc_rpt", new byte[0]);
    AppMethodBeat.o(122571);
  }
  
  public static bfy cPB()
  {
    AppMethodBeat.i(122572);
    Object localObject = e.sHZ;
    localObject = e.a.cPE();
    AppMethodBeat.o(122572);
    return localObject;
  }
  
  public static Pair<dve, Integer> cPC()
  {
    AppMethodBeat.i(221118);
    Object localObject1 = com.tencent.mm.plugin.expt.hellhound.a.f.b.cPO();
    p.g(localObject1, "HellSessionMonitor.getInstance()");
    String str = ((com.tencent.mm.plugin.expt.hellhound.a.f.b)localObject1).cPR();
    localObject1 = d.sHY;
    p.g(str, "curSessionid");
    p.h(str, "sessionId");
    localObject1 = d.a.cPD();
    if (localObject1 == null) {
      localObject1 = new bfz();
    }
    for (;;)
    {
      int i = ((bfz)localObject1).LPD.size() - 1;
      while (i >= 0)
      {
        Object localObject2 = ((bfz)localObject1).LPD.get(i);
        p.g(localObject2, "fuzzyMatchInfo.sessionFuzzyPaths[i]");
        localObject2 = (dve)localObject2;
        if (p.j(str, ((dve)localObject2).dRM))
        {
          localObject1 = Pair.create(localObject2, Integer.valueOf(i));
          AppMethodBeat.o(221118);
          return localObject1;
        }
        i -= 1;
      }
      AppMethodBeat.o(221118);
      return null;
    }
  }
  
  private static void cPy()
  {
    AppMethodBeat.i(169392);
    Object localObject = d.sHY;
    d.a.reset();
    localObject = f.sIa;
    f.a.reset();
    localObject = j.sIK;
    j.a.reset();
    AppMethodBeat.o(169392);
  }
  
  private static com.tencent.mm.vending.j.c<String, ArrayList<dvk>> cPz()
  {
    AppMethodBeat.i(169393);
    Object localObject1 = com.tencent.mm.plugin.expt.hellhound.a.f.b.b.sIy;
    localObject1 = b.a.cPZ();
    if (localObject1 == null)
    {
      AppMethodBeat.o(169393);
      return null;
    }
    Object localObject2 = com.tencent.mm.plugin.expt.hellhound.a.f.b.b.sIy;
    localObject2 = b.a.aqn((String)localObject1);
    if (localObject2 == null)
    {
      AppMethodBeat.o(169393);
      return null;
    }
    c.a locala = c.sHX;
    localObject2 = c.a.aqe((String)localObject2);
    if (localObject2 == null)
    {
      AppMethodBeat.o(169393);
      return null;
    }
    if (((ArrayList)localObject2).isEmpty())
    {
      Log.w("HABBYGE-MALI.FuzzyMatch", "_getCloudConfig Empty!!");
      AppMethodBeat.o(169393);
      return null;
    }
    localObject1 = com.tencent.mm.vending.j.a.Q(localObject1, localObject2);
    AppMethodBeat.o(169393);
    return localObject1;
  }
  
  public final void a(String paramString, long paramLong, g paramg)
  {
    AppMethodBeat.i(184273);
    p.h(paramg, "state");
    if (paramString == null)
    {
      Log.i("HABBYGE-MALI.FuzzyMatch", "match: page is: ".concat(String.valueOf(paramString)));
      AppMethodBeat.o(184273);
      return;
    }
    b.a locala = com.tencent.mm.plugin.expt.hellhound.a.f.b.b.sIy;
    if (b.a.cPX())
    {
      Log.w("HABBYGE-MALI.FuzzyMatch", "match, doNotNeedSessionMonitor: TRUE");
      AppMethodBeat.o(184273);
      return;
    }
    Log.i("HABBYGE-MALI.FuzzyMatch", "match: " + paramString + ", " + paramg);
    switch (b.$EnumSwitchMapping$0[paramg.ordinal()])
    {
    default: 
      Log.e("HABBYGE-MALI.FuzzyMatch", "match ~");
    case 1: 
    case 2: 
    case 3: 
      do
      {
        do
        {
          do
          {
            AppMethodBeat.o(184273);
            return;
          } while (!aqd(paramString));
          ag(paramString, paramLong);
          AppMethodBeat.o(184273);
          return;
        } while (!aqd(paramString));
        c(paramString, false, paramLong);
        AppMethodBeat.o(184273);
        return;
      } while (!aqd(paramString));
      c(paramString, false, paramLong);
      AppMethodBeat.o(184273);
      return;
    case 4: 
      c(paramString, true, paramLong);
      AppMethodBeat.o(184273);
      return;
    case 5: 
      sHV = true;
      Dp(paramLong);
      AppMethodBeat.o(184273);
      return;
    }
    cPy();
    AppMethodBeat.o(184273);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.expt.hellhound.a.d.a
 * JD-Core Version:    0.7.0.1
 */