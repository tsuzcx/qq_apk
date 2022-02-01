package com.tencent.mm.plugin.expt.hellhound.a.d;

import android.util.Pair;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.expt.hellhound.a.f.b.b.a;
import com.tencent.mm.plugin.expt.hellhound.a.f.c.j;
import com.tencent.mm.plugin.expt.hellhound.a.f.c.j.a;
import com.tencent.mm.protocal.protobuf.atz;
import com.tencent.mm.protocal.protobuf.aua;
import com.tencent.mm.protocal.protobuf.aub;
import com.tencent.mm.protocal.protobuf.auc;
import com.tencent.mm.protocal.protobuf.chk;
import com.tencent.mm.protocal.protobuf.dbg;
import com.tencent.mm.protocal.protobuf.dbi;
import com.tencent.mm.protocal.protobuf.dbm;
import com.tencent.mm.sdk.platformtools.ad;
import d.g.b.p;
import d.l;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/expt/hellhound/ext/fuzzymatch/FuzzyMatch;", "", "()V", "TAG", "", "is8EventForFragment", "", "_addPage", "", "curSessionId", "curPageConfig", "Lcom/tencent/mm/protocal/protobuf/SessionPage;", "pathConfig", "Lcom/tencent/mm/protocal/protobuf/SessionPagePath;", "curPage", "timestamp", "", "_addPrePage", "prePageConfig", "expctPageConfig", "_addPrePage2", "prePagesConfig", "", "_doNewMatch", "curCloudConfig", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "matchingPathIds", "_doNewMatch1Page", "_getCloudConfig", "Lcom/tencent/mm/vending/tuple/Tuple2;", "_isPageLegal", "pageName", "_matchOn8Event", "_matchOnFinish", "onSessionClose", "_matchOnNot1stOnResume", "_matchOnResume", "_matchOnSessionNot1STOnResume", "sessionPath", "Lcom/tencent/mm/protocal/protobuf/SessionFuzzyPath;", "_updatePath", "getFuzzyPathOfCurSession", "Landroid/util/Pair;", "", "getMatchedFuzzyPaths", "Lcom/tencent/mm/protocal/protobuf/FuzzyPath;", "sessionId", "getMatchingFuzzyPaths", "getReportCache", "Lcom/tencent/mm/protocal/protobuf/FuzzyMatchCache;", "match", "state", "Lcom/tencent/mm/plugin/expt/hellhound/ext/fuzzymatch/MatchState;", "mmProcessRestartEvent", "resetFuzzyDaoOnSessionStart", "resetReportCache", "updateSessionFuzzyPath", "sessionFuzzyPath", "index", "plugin-expt_release"})
public final class a
{
  private static boolean qYt;
  public static final a qYu;
  
  static
  {
    AppMethodBeat.i(122574);
    qYu = new a();
    AppMethodBeat.o(122574);
  }
  
  private static ArrayList<Long> a(String paramString, dbg paramdbg, long paramLong)
  {
    AppMethodBeat.i(184277);
    ArrayList localArrayList = new ArrayList();
    int i = paramdbg.Gsa.size() - 1;
    if (i >= 0)
    {
      Object localObject = paramdbg.Gsa.get(i);
      p.g(localObject, "sessionPath.paths[i]");
      localObject = (auc)localObject;
      aub localaub;
      if (((auc)localObject).Gsi.size() == 1) {
        if (((auc)localObject).Gsg.isEmpty())
        {
          localaub = new aub();
          localaub.name = paramString;
          localaub.startTime = paramLong;
          ((auc)localObject).Gsi.addLast(localaub);
          localArrayList.add(Long.valueOf(((auc)localObject).Gsl));
          ad.i("HABBYGE-MALI.FuzzyMatch", "_updatePath: " + ((auc)localObject).Gsl + ", " + paramString);
        }
      }
      for (;;)
      {
        i -= 1;
        break;
        if (((auc)localObject).Gsg.size() == 1)
        {
          if (p.i(((auc)localObject).Gsh.dtL, paramString))
          {
            localaub = new aub();
            localaub.name = paramString;
            localaub.startTime = paramLong;
            ((auc)localObject).Gsi.addLast(localaub);
            localArrayList.add(Long.valueOf(((auc)localObject).Gsl));
            ad.i("HABBYGE-MALI.FuzzyMatch", "_updatePath, =1: " + ((auc)localObject).Gsl + ", " + paramString);
          }
          else if (p.i(((dbi)((auc)localObject).Gsg.get(0)).dtL, paramString))
          {
            ((auc)localObject).Gsi.clear();
            localaub = new aub();
            localaub.name = paramString;
            localaub.startTime = paramLong;
            ((auc)localObject).Gsi.addLast(localaub);
            localArrayList.add(Long.valueOf(((auc)localObject).Gsl));
          }
          else
          {
            paramdbg.Gsa.remove(i);
          }
        }
        else if (p.i(((dbi)((auc)localObject).Gsg.get(1)).dtL, paramString))
        {
          localaub = new aub();
          localaub.name = paramString;
          localaub.startTime = paramLong;
          ((auc)localObject).Gsi.addLast(localaub);
          localArrayList.add(Long.valueOf(((auc)localObject).Gsl));
        }
        else if (p.i(((dbi)((auc)localObject).Gsg.get(0)).dtL, paramString))
        {
          ((auc)localObject).Gsi.clear();
          localaub = new aub();
          localaub.name = paramString;
          localaub.startTime = paramLong;
          ((auc)localObject).Gsi.addLast(localaub);
          localArrayList.add(Long.valueOf(((auc)localObject).Gsl));
        }
        else
        {
          paramdbg.Gsa.remove(i);
          continue;
          if ((((auc)localObject).Gsi.size() > 1) && (((auc)localObject).Gsj)) {
            if (((auc)localObject).Gsg.isEmpty())
            {
              localaub = new aub();
              localaub.name = paramString;
              localaub.startTime = paramLong;
              ((auc)localObject).Gsi.addLast(localaub);
              ad.i("HABBYGE-MALI.FuzzyMatch", "_updatePath, =1: " + ((auc)localObject).Gsl + ", " + paramString);
              localArrayList.add(Long.valueOf(((auc)localObject).Gsl));
            }
            else if (((auc)localObject).Gsg.size() == 1)
            {
              localaub = new aub();
              localaub.name = paramString;
              localaub.startTime = paramLong;
              ((auc)localObject).Gsi.addLast(localaub);
              ad.i("HABBYGE-MALI.FuzzyMatch", "_updatePath, =2: " + ((auc)localObject).Gsl + ", " + paramString);
              localArrayList.add(Long.valueOf(((auc)localObject).Gsl));
            }
            else if (((auc)localObject).Gsi.size() > ((auc)localObject).Gsg.size())
            {
              localaub = new aub();
              localaub.name = paramString;
              localaub.startTime = paramLong;
              ((auc)localObject).Gsi.addLast(localaub);
              ad.i("HABBYGE-MALI.FuzzyMatch", "_updatePath, >2: " + ((auc)localObject).Gsl + ", " + paramString);
              localArrayList.add(Long.valueOf(((auc)localObject).Gsl));
            }
            else if (((auc)localObject).Gsi.size() == ((auc)localObject).Gsg.size())
            {
              if (p.i(((auc)localObject).Gsh.dtL, paramString))
              {
                localaub = new aub();
                localaub.name = paramString;
                localaub.startTime = paramLong;
                ((auc)localObject).Gsi.addLast(localaub);
                localArrayList.add(Long.valueOf(((auc)localObject).Gsl));
                ad.i("HABBYGE-MALI.FuzzyMatch", "_updatePath, >=2: " + ((auc)localObject).Gsl + ", " + paramString);
              }
              else if (p.i(((dbi)((auc)localObject).Gsg.get(0)).dtL, paramString))
              {
                ((auc)localObject).Gsi.clear();
                localaub = new aub();
                localaub.name = paramString;
                localaub.startTime = paramLong;
                ((auc)localObject).Gsi.addLast(localaub);
                localArrayList.add(Long.valueOf(((auc)localObject).Gsl));
              }
              else
              {
                paramdbg.Gsa.remove(i);
              }
            }
            else if (p.i(((dbi)((auc)localObject).Gsg.get(((auc)localObject).Gsi.size())).dtL, paramString))
            {
              localaub = new aub();
              localaub.name = paramString;
              localaub.startTime = paramLong;
              ((auc)localObject).Gsi.addLast(localaub);
              localArrayList.add(Long.valueOf(((auc)localObject).Gsl));
            }
            else if (p.i(((dbi)((auc)localObject).Gsg.get(0)).dtL, paramString))
            {
              ((auc)localObject).Gsi.clear();
              localaub = new aub();
              localaub.name = paramString;
              localaub.startTime = paramLong;
              ((auc)localObject).Gsi.addLast(localaub);
              localArrayList.add(Long.valueOf(((auc)localObject).Gsl));
            }
            else
            {
              paramdbg.Gsa.remove(i);
            }
          }
        }
      }
    }
    paramString = d.qYw;
    d.a.a(paramdbg);
    AppMethodBeat.o(184277);
    return localArrayList;
  }
  
  public static void a(dbg paramdbg, int paramInt)
  {
    AppMethodBeat.i(210956);
    d.a locala = d.qYw;
    d.a.b(paramdbg, paramInt);
    AppMethodBeat.o(210956);
  }
  
  private static void a(String paramString1, dbi paramdbi1, dbi paramdbi2, long paramLong, dbm paramdbm, String paramString2)
  {
    AppMethodBeat.i(210953);
    auc localauc = new auc();
    localauc.dyV = paramString1;
    localauc.Gsg.add(paramdbi1);
    localauc.Gsh = paramdbi2;
    localauc.Gsj = true;
    localauc.ssW = paramdbm.ssW;
    localauc.Gsk = paramdbm.Gsk;
    localauc.Gsl = paramdbm.Gsl;
    paramdbi1 = new aub();
    paramdbi1.name = paramString2;
    paramdbi1.startTime = paramLong;
    localauc.Gsi.addLast(paramdbi1);
    paramdbi1 = d.qYw;
    paramdbi1 = d.a.aez(paramString1);
    ((dbg)paramdbi1.first).Gsa.addLast(localauc);
    ((dbg)paramdbi1.first).dyV = paramString1;
    paramString1 = d.qYw;
    paramString1 = (dbg)paramdbi1.first;
    paramdbi1 = paramdbi1.second;
    p.g(paramdbi1, "curSessionPathPair.second");
    d.a.b(paramString1, ((Number)paramdbi1).intValue());
    AppMethodBeat.o(210953);
  }
  
  private static void a(String paramString1, dbi paramdbi, dbm paramdbm, String paramString2, long paramLong)
  {
    AppMethodBeat.i(210952);
    auc localauc = new auc();
    localauc.dyV = paramString1;
    localauc.Gsh = paramdbi;
    localauc.Gsj = true;
    localauc.ssW = paramdbm.ssW;
    localauc.Gsk = paramdbm.Gsk;
    localauc.Gsl = paramdbm.Gsl;
    paramdbi = new aub();
    paramdbi.name = paramString2;
    paramdbi.startTime = paramLong;
    localauc.Gsi.addLast(paramdbi);
    paramdbi = d.qYw;
    paramdbi = d.a.aez(paramString1);
    ((dbg)paramdbi.first).Gsa.addLast(localauc);
    ((dbg)paramdbi.first).dyV = paramString1;
    paramString1 = d.qYw;
    paramString1 = (dbg)paramdbi.first;
    paramdbi = paramdbi.second;
    p.g(paramdbi, "curSessionPathPair.second");
    d.a.b(paramString1, ((Number)paramdbi).intValue());
    AppMethodBeat.o(210952);
  }
  
  private static void a(String paramString1, String paramString2, long paramLong, ArrayList<dbm> paramArrayList)
  {
    AppMethodBeat.i(184275);
    Object localObject = d.qYw;
    localObject = d.a.aez(paramString2);
    if (((dbg)((Pair)localObject).first).Gsa.isEmpty())
    {
      a(paramString1, paramString2, paramLong, paramArrayList, new ArrayList());
      AppMethodBeat.o(184275);
      return;
    }
    localObject = ((Pair)localObject).first;
    p.g(localObject, "sessionPathPair.first");
    a(paramString1, paramString2, (dbg)localObject, paramLong, paramArrayList);
    AppMethodBeat.o(184275);
  }
  
  private static void a(String paramString1, String paramString2, long paramLong, ArrayList<dbm> paramArrayList, ArrayList<Long> paramArrayList1)
  {
    AppMethodBeat.i(184278);
    paramArrayList = paramArrayList.iterator();
    while (paramArrayList.hasNext())
    {
      dbm localdbm = (dbm)paramArrayList.next();
      if (!paramArrayList1.contains(Long.valueOf(localdbm.Gsl))) {
        if (localdbm.Hrg.size() == 1)
        {
          p.g(localdbm, "pathConfig");
          a(paramString1, paramString2, localdbm, paramLong);
        }
        else
        {
          Object localObject1;
          Object localObject2;
          if (localdbm.Hrg.size() == 2)
          {
            localObject1 = (dbi)localdbm.Hrg.get(0);
            localObject2 = (dbi)localdbm.Hrg.get(1);
            if (p.i(paramString1, ((dbi)localObject1).dtL))
            {
              p.g(localObject1, "prePageConfig");
              p.g(localObject2, "curPageConfig");
              p.g(localdbm, "pathConfig");
              a(paramString2, (dbi)localObject1, (dbi)localObject2, paramLong, localdbm, paramString1);
            }
          }
          else
          {
            localObject1 = localdbm.Hrg.subList(0, localdbm.Hrg.size() - 1);
            p.g(localObject1, "pathConfig.pagePathUnits…g.pagePathUnits.size - 1)");
            localObject2 = localdbm.Hrg;
            p.g(localObject2, "pathConfig.pagePathUnits");
            localObject2 = (dbi)((LinkedList)localObject2).getLast();
            if (p.i(paramString1, ((dbi)((List)localObject1).get(0)).dtL))
            {
              p.g(localObject2, "curPageConfig");
              p.g(localdbm, "pathConfig");
              a(paramString2, (List)localObject1, paramLong, (dbi)localObject2, localdbm, paramString1);
            }
          }
        }
      }
    }
    AppMethodBeat.o(184278);
  }
  
  private static void a(String paramString1, String paramString2, dbg paramdbg, long paramLong, ArrayList<dbm> paramArrayList)
  {
    AppMethodBeat.i(184276);
    a(paramString1, paramString2, paramLong, paramArrayList, a(paramString1, paramdbg, paramLong));
    AppMethodBeat.o(184276);
  }
  
  private static void a(String paramString1, String paramString2, dbm paramdbm, long paramLong)
  {
    AppMethodBeat.i(210951);
    dbi localdbi = (dbi)paramdbm.Hrg.get(0);
    if (localdbi == null)
    {
      AppMethodBeat.o(210951);
      return;
    }
    if (p.i(paramString1, localdbi.dtL)) {
      a(paramString2, localdbi, paramdbm, paramString1, paramLong);
    }
    AppMethodBeat.o(210951);
  }
  
  private static void a(String paramString1, List<? extends dbi> paramList, long paramLong, dbi paramdbi, dbm paramdbm, String paramString2)
  {
    AppMethodBeat.i(210954);
    auc localauc = new auc();
    localauc.dyV = paramString1;
    localauc.Gsg.addAll((Collection)paramList);
    localauc.Gsh = paramdbi;
    localauc.Gsj = true;
    localauc.ssW = paramdbm.ssW;
    localauc.Gsk = paramdbm.Gsk;
    localauc.Gsl = paramdbm.Gsl;
    paramList = new aub();
    paramList.name = paramString2;
    paramList.startTime = paramLong;
    localauc.Gsi.addLast(paramList);
    paramList = d.qYw;
    paramList = d.a.aez(paramString1);
    ((dbg)paramList.first).Gsa.addLast(localauc);
    ((dbg)paramList.first).dyV = paramString1;
    paramString1 = d.qYw;
    paramString1 = (dbg)paramList.first;
    paramList = paramList.second;
    p.g(paramList, "curSessionPathPair.second");
    d.a.b(paramString1, ((Number)paramList).intValue());
    AppMethodBeat.o(210954);
  }
  
  public static void aet(String paramString)
  {
    AppMethodBeat.i(169394);
    ad.i("HABBYGE-MALI.FuzzyMatch", "resetFuzzyDaoOnStart: ".concat(String.valueOf(paramString)));
    if (paramString == null)
    {
      AppMethodBeat.o(169394);
      return;
    }
    Object localObject1 = d.qYw;
    p.h(paramString, "curSessionId");
    localObject1 = d.a.cpt();
    if (localObject1 != null)
    {
      int i = ((aua)localObject1).Gsb.size() - 1;
      while (i >= 0)
      {
        Object localObject2 = ((aua)localObject1).Gsb.get(i);
        p.g(localObject2, "matchInfo.sessionFuzzyPaths[i]");
        localObject2 = (dbg)localObject2;
        if (!p.i(paramString, ((dbg)localObject2).dyV))
        {
          ad.i("HABBYGE-MALI.FuzzyMatchDao", "resetOnStart, need remove: " + ((dbg)localObject2).dyV);
          int j = ((dbg)localObject2).Gsa.size() - 1;
          while (j >= 0)
          {
            Object localObject3 = ((dbg)localObject2).Gsa.get(j);
            p.g(localObject3, "sessionPath.paths[j]");
            if (((auc)localObject3).Gsj)
            {
              ad.i("HABBYGE-MALI.FuzzyMatchDao", "resetOnStart, real remove: " + ((dbg)localObject2).dyV);
              ((dbg)localObject2).Gsa.remove(j);
            }
            j -= 1;
          }
          if (((dbg)localObject2).Gsa.isEmpty()) {
            ((aua)localObject1).Gsb.remove(i);
          }
        }
        i -= 1;
      }
      d.a.a((aua)localObject1);
    }
    paramString = f.qYy;
    f.a.reset();
    paramString = j.qZi;
    j.a.reset();
    AppMethodBeat.o(169394);
  }
  
  public static List<auc> aeu(String paramString)
  {
    AppMethodBeat.i(122573);
    ArrayList localArrayList = new ArrayList();
    Object localObject = d.qYw;
    paramString = d.a.aey(paramString);
    if (paramString == null)
    {
      AppMethodBeat.o(122573);
      return null;
    }
    paramString = paramString.Gsa.iterator();
    while (paramString.hasNext())
    {
      localObject = (auc)paramString.next();
      if (((auc)localObject).Gsj) {
        localArrayList.add(localObject);
      }
    }
    paramString = (List)localArrayList;
    AppMethodBeat.o(122573);
    return paramString;
  }
  
  public static List<auc> aev(String paramString)
  {
    AppMethodBeat.i(185590);
    ArrayList localArrayList = new ArrayList();
    Object localObject = d.qYw;
    localObject = d.a.aey(paramString);
    auc localauc;
    if (localObject != null)
    {
      localObject = ((dbg)localObject).Gsa.iterator();
      while (((Iterator)localObject).hasNext())
      {
        localauc = (auc)((Iterator)localObject).next();
        if (!localauc.Gsj) {
          localArrayList.add(localauc);
        }
      }
    }
    localObject = f.qYy;
    localObject = f.a.aeA(paramString);
    if (localObject != null)
    {
      localObject = ((dbg)localObject).Gsa.iterator();
      while (((Iterator)localObject).hasNext())
      {
        localauc = (auc)((Iterator)localObject).next();
        if (!localauc.Gsj) {
          localArrayList.add(localauc);
        }
      }
    }
    localObject = f.qYy;
    f.a.ZK(paramString);
    paramString = (List)localArrayList;
    AppMethodBeat.o(185590);
    return paramString;
  }
  
  private static boolean aew(String paramString)
  {
    AppMethodBeat.i(169395);
    boolean bool = p.i(paramString, "com.tencent.mm.ui.LauncherUI");
    AppMethodBeat.o(169395);
    return bool ^ true;
  }
  
  private final void ah(String paramString, long paramLong)
  {
    AppMethodBeat.i(184274);
    Object localObject1 = cpp();
    if (localObject1 == null)
    {
      AppMethodBeat.o(184274);
      return;
    }
    String str = (String)((com.tencent.mm.vending.j.c)localObject1).fOm();
    localObject1 = (ArrayList)((com.tencent.mm.vending.j.c)localObject1).fOn();
    if (localObject1 == null)
    {
      AppMethodBeat.o(184274);
      return;
    }
    Object localObject2 = d.qYw;
    localObject2 = d.a.cpt();
    if ((localObject2 == null) || (((aua)localObject2).Gsb.isEmpty()))
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
  
  private static void c(String paramString, boolean paramBoolean, long paramLong)
  {
    AppMethodBeat.i(184279);
    if (((paramBoolean) || (com.tencent.mm.plugin.expt.hellhound.core.b.adL(paramString))) && (qYt))
    {
      qYt = false;
      AppMethodBeat.o(184279);
      return;
    }
    Object localObject1 = com.tencent.mm.plugin.expt.hellhound.a.f.b.b.qYW;
    localObject1 = com.tencent.mm.plugin.expt.hellhound.a.f.c.c.cqf();
    if (localObject1 == null) {}
    for (localObject1 = null; localObject1 == null; localObject1 = ((chk)localObject1).sessionId)
    {
      ad.w("HABBYGE-MALI.FuzzyMatch", "_matchOnFinish: curSession == null");
      AppMethodBeat.o(184279);
      return;
    }
    Object localObject2 = d.qYw;
    localObject1 = d.a.aey((String)localObject1);
    if (localObject1 == null)
    {
      ad.w("HABBYGE-MALI.FuzzyMatch", "_matchOnFinish: sessionMatch == null");
      AppMethodBeat.o(184279);
      return;
    }
    localObject2 = ((dbg)localObject1).Gsa.iterator();
    while (((Iterator)localObject2).hasNext())
    {
      auc localauc = (auc)((Iterator)localObject2).next();
      Object localObject3;
      if (localauc.Gsj)
      {
        localObject3 = com.tencent.mm.plugin.expt.hellhound.core.b.adx(localauc.Gsh.dtL);
        if ((p.i(paramString, localauc.Gsh.dtL)) || (p.i(paramString, localObject3)))
        {
          localauc.Gsj = false;
          localObject3 = e.qYx;
          e.a.a(localauc, paramLong);
        }
      }
      else
      {
        int i = localauc.Gsi.size() - 1;
        label223:
        long l;
        if (i >= 0)
        {
          localObject3 = (aub)localauc.Gsi.get(i);
          if (localObject3 != null)
          {
            String str = com.tencent.mm.plugin.expt.hellhound.core.b.adx(((aub)localObject3).name);
            if (((p.i(paramString, ((aub)localObject3).name)) || (p.i(paramString, str))) && (((aub)localObject3).Gsd <= 0L))
            {
              l = paramLong - ((aub)localObject3).startTime;
              if (l < 0L) {
                break label321;
              }
            }
          }
        }
        for (;;)
        {
          ((aub)localObject3).Gsd = l;
          i -= 1;
          break label223;
          break;
          label321:
          l = 0L;
        }
      }
    }
    paramString = d.qYw;
    d.a.a((dbg)localObject1);
    AppMethodBeat.o(184279);
  }
  
  private static void cpo()
  {
    AppMethodBeat.i(169392);
    Object localObject = d.qYw;
    d.a.reset();
    localObject = f.qYy;
    f.a.reset();
    localObject = j.qZi;
    j.a.reset();
    AppMethodBeat.o(169392);
  }
  
  private static com.tencent.mm.vending.j.c<String, ArrayList<dbm>> cpp()
  {
    AppMethodBeat.i(169393);
    Object localObject1 = com.tencent.mm.plugin.expt.hellhound.a.f.b.b.qYW;
    localObject1 = b.a.cpP();
    if (localObject1 == null)
    {
      AppMethodBeat.o(169393);
      return null;
    }
    Object localObject2 = com.tencent.mm.plugin.expt.hellhound.a.f.b.b.qYW;
    localObject2 = b.a.aeG((String)localObject1);
    if (localObject2 == null)
    {
      AppMethodBeat.o(169393);
      return null;
    }
    c.a locala = c.qYv;
    localObject2 = c.a.aex((String)localObject2);
    if (localObject2 == null)
    {
      AppMethodBeat.o(169393);
      return null;
    }
    if (((ArrayList)localObject2).isEmpty())
    {
      ad.w("HABBYGE-MALI.FuzzyMatch", "_getCloudConfig Empty!!");
      AppMethodBeat.o(169393);
      return null;
    }
    localObject1 = com.tencent.mm.vending.j.a.N(localObject1, localObject2);
    AppMethodBeat.o(169393);
    return localObject1;
  }
  
  public static void cpq()
  {
    AppMethodBeat.i(122571);
    ad.i("HABBYGE-MALI.FuzzyMatch", "resetReportCache");
    e.a locala = e.qYx;
    com.tencent.mm.plugin.expt.hellhound.core.a.b.p("mmkv_fuzzy_mc_rpt", new byte[0]);
    AppMethodBeat.o(122571);
  }
  
  public static atz cpr()
  {
    AppMethodBeat.i(122572);
    Object localObject = e.qYx;
    localObject = e.a.cpu();
    AppMethodBeat.o(122572);
    return localObject;
  }
  
  public static Pair<dbg, Integer> cps()
  {
    AppMethodBeat.i(210955);
    Object localObject1 = com.tencent.mm.plugin.expt.hellhound.a.f.b.cpE();
    p.g(localObject1, "HellSessionMonitor.getInstance()");
    String str = ((com.tencent.mm.plugin.expt.hellhound.a.f.b)localObject1).cpH();
    localObject1 = d.qYw;
    p.g(str, "curSessionid");
    p.h(str, "sessionId");
    localObject1 = d.a.cpt();
    if (localObject1 == null) {
      localObject1 = new aua();
    }
    for (;;)
    {
      int i = ((aua)localObject1).Gsb.size() - 1;
      while (i >= 0)
      {
        Object localObject2 = ((aua)localObject1).Gsb.get(i);
        p.g(localObject2, "fuzzyMatchInfo.sessionFuzzyPaths[i]");
        localObject2 = (dbg)localObject2;
        if (p.i(str, ((dbg)localObject2).dyV))
        {
          localObject1 = Pair.create(localObject2, Integer.valueOf(i));
          AppMethodBeat.o(210955);
          return localObject1;
        }
        i -= 1;
      }
      AppMethodBeat.o(210955);
      return null;
    }
  }
  
  private static void uU(long paramLong)
  {
    AppMethodBeat.i(184280);
    e.a locala = e.qYx;
    e.a.uV(paramLong);
    AppMethodBeat.o(184280);
  }
  
  public final void a(String paramString, long paramLong, g paramg)
  {
    AppMethodBeat.i(184273);
    p.h(paramg, "state");
    if (paramString == null)
    {
      ad.i("HABBYGE-MALI.FuzzyMatch", "match: page is: ".concat(String.valueOf(paramString)));
      AppMethodBeat.o(184273);
      return;
    }
    b.a locala = com.tencent.mm.plugin.expt.hellhound.a.f.b.b.qYW;
    if (b.a.cpN())
    {
      ad.w("HABBYGE-MALI.FuzzyMatch", "match, doNotNeedSessionMonitor: TRUE");
      AppMethodBeat.o(184273);
      return;
    }
    ad.i("HABBYGE-MALI.FuzzyMatch", "match: " + paramString + ", " + paramg);
    switch (b.cpQ[paramg.ordinal()])
    {
    default: 
      ad.e("HABBYGE-MALI.FuzzyMatch", "match ~");
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
          } while (!aew(paramString));
          ah(paramString, paramLong);
          AppMethodBeat.o(184273);
          return;
        } while (!aew(paramString));
        c(paramString, false, paramLong);
        AppMethodBeat.o(184273);
        return;
      } while (!aew(paramString));
      c(paramString, false, paramLong);
      AppMethodBeat.o(184273);
      return;
    case 4: 
      c(paramString, true, paramLong);
      AppMethodBeat.o(184273);
      return;
    case 5: 
      qYt = true;
      uU(paramLong);
      AppMethodBeat.o(184273);
      return;
    }
    cpo();
    AppMethodBeat.o(184273);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.expt.hellhound.a.d.a
 * JD-Core Version:    0.7.0.1
 */