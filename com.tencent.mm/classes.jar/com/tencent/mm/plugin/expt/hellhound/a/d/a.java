package com.tencent.mm.plugin.expt.hellhound.a.d;

import android.util.Pair;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.expt.hellhound.a.f.b.b.a;
import com.tencent.mm.plugin.expt.hellhound.a.f.c.j;
import com.tencent.mm.plugin.expt.hellhound.a.f.c.j.a;
import com.tencent.mm.protocal.protobuf.amz;
import com.tencent.mm.protocal.protobuf.ana;
import com.tencent.mm.protocal.protobuf.anb;
import com.tencent.mm.protocal.protobuf.anc;
import com.tencent.mm.protocal.protobuf.bxx;
import com.tencent.mm.protocal.protobuf.cqn;
import com.tencent.mm.protocal.protobuf.cqp;
import com.tencent.mm.protocal.protobuf.cqt;
import com.tencent.mm.sdk.platformtools.ad;
import d.g.b.k;
import d.l;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/expt/hellhound/ext/fuzzymatch/FuzzyMatch;", "", "()V", "TAG", "", "is8EventForFragment", "", "_addPage", "", "curSessionId", "curPageConfig", "Lcom/tencent/mm/protocal/protobuf/SessionPage;", "pathConfig", "Lcom/tencent/mm/protocal/protobuf/SessionPagePath;", "curPage", "timestamp", "", "_addPrePage", "prePageConfig", "expctPageConfig", "_addPrePage2", "prePagesConfig", "", "_doNewMatch", "curCloudConfig", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "matchingPathIds", "_doNewMatch1Page", "_getCloudConfig", "Lcom/tencent/mm/vending/tuple/Tuple2;", "_isPageLegal", "pageName", "_matchOn8Event", "_matchOnFinish", "onSessionClose", "_matchOnNot1stOnResume", "_matchOnResume", "_matchOnSessionNot1STOnResume", "sessionPath", "Lcom/tencent/mm/protocal/protobuf/SessionFuzzyPath;", "_updatePath", "getMatchedFuzzyPaths", "Lcom/tencent/mm/protocal/protobuf/FuzzyPath;", "sessionId", "getMatchingFuzzyPaths", "getReportCache", "Lcom/tencent/mm/protocal/protobuf/FuzzyMatchCache;", "match", "state", "Lcom/tencent/mm/plugin/expt/hellhound/ext/fuzzymatch/MatchState;", "mmProcessRestartEvent", "resetFuzzyDaoOnSessionStart", "resetReportCache", "plugin-expt_release"})
public final class a
{
  private static boolean pGN;
  public static final a pGO;
  
  static
  {
    AppMethodBeat.i(122574);
    pGO = new a();
    AppMethodBeat.o(122574);
  }
  
  public static void Wi(String paramString)
  {
    AppMethodBeat.i(169394);
    ad.i("FuzzyMatch", "HABBYGE-MALI, FuzzyMatch, resetFuzzyDaoOnStart: ".concat(String.valueOf(paramString)));
    if (paramString == null)
    {
      AppMethodBeat.o(169394);
      return;
    }
    Object localObject1 = d.pGQ;
    k.h(paramString, "curSessionId");
    localObject1 = d.a.ccv();
    if (localObject1 != null)
    {
      int i = ((ana)localObject1).Doa.size() - 1;
      while (i >= 0)
      {
        Object localObject2 = ((ana)localObject1).Doa.get(i);
        k.g(localObject2, "matchInfo.sessionFuzzyPaths[i]");
        localObject2 = (cqn)localObject2;
        if (!k.g(paramString, ((cqn)localObject2).dpw))
        {
          ad.i("FuzzyMatchDao", "HABBYGE-MALI, resetOnStart, need remove: " + ((cqn)localObject2).dpw);
          int j = ((cqn)localObject2).DnZ.size() - 1;
          while (j >= 0)
          {
            Object localObject3 = ((cqn)localObject2).DnZ.get(j);
            k.g(localObject3, "sessionPath.paths[j]");
            if (((anc)localObject3).Doh)
            {
              ad.i("FuzzyMatchDao", "HABBYGE-MALI, resetOnStart, real remove: " + ((cqn)localObject2).dpw);
              ((cqn)localObject2).DnZ.remove(j);
            }
            j -= 1;
          }
          if (((cqn)localObject2).DnZ.isEmpty()) {
            ((ana)localObject1).Doa.remove(i);
          }
        }
        i -= 1;
      }
      d.a.a((ana)localObject1);
    }
    paramString = f.pGS;
    f.a.reset();
    paramString = j.pHC;
    j.a.reset();
    AppMethodBeat.o(169394);
  }
  
  public static List<anc> Wj(String paramString)
  {
    AppMethodBeat.i(122573);
    ArrayList localArrayList = new ArrayList();
    Object localObject = d.pGQ;
    paramString = d.a.Wn(paramString);
    if (paramString == null)
    {
      AppMethodBeat.o(122573);
      return null;
    }
    paramString = paramString.DnZ.iterator();
    while (paramString.hasNext())
    {
      localObject = (anc)paramString.next();
      if (((anc)localObject).Doh) {
        localArrayList.add(localObject);
      }
    }
    paramString = (List)localArrayList;
    AppMethodBeat.o(122573);
    return paramString;
  }
  
  public static List<anc> Wk(String paramString)
  {
    AppMethodBeat.i(185590);
    ArrayList localArrayList = new ArrayList();
    Object localObject = d.pGQ;
    localObject = d.a.Wn(paramString);
    anc localanc;
    if (localObject != null)
    {
      localObject = ((cqn)localObject).DnZ.iterator();
      while (((Iterator)localObject).hasNext())
      {
        localanc = (anc)((Iterator)localObject).next();
        if (!localanc.Doh) {
          localArrayList.add(localanc);
        }
      }
    }
    localObject = f.pGS;
    localObject = f.a.Wp(paramString);
    if (localObject != null)
    {
      localObject = ((cqn)localObject).DnZ.iterator();
      while (((Iterator)localObject).hasNext())
      {
        localanc = (anc)((Iterator)localObject).next();
        if (!localanc.Doh) {
          localArrayList.add(localanc);
        }
      }
    }
    localObject = f.pGS;
    f.a.RR(paramString);
    paramString = (List)localArrayList;
    AppMethodBeat.o(185590);
    return paramString;
  }
  
  private static boolean Wl(String paramString)
  {
    AppMethodBeat.i(169395);
    boolean bool = k.g(paramString, "com.tencent.mm.ui.LauncherUI");
    AppMethodBeat.o(169395);
    return bool ^ true;
  }
  
  private static ArrayList<Long> a(String paramString, cqn paramcqn, long paramLong)
  {
    AppMethodBeat.i(184277);
    ArrayList localArrayList = new ArrayList();
    int i = paramcqn.DnZ.size() - 1;
    if (i >= 0)
    {
      Object localObject = paramcqn.DnZ.get(i);
      k.g(localObject, "sessionPath.paths[i]");
      localObject = (anc)localObject;
      anb localanb;
      if (((anc)localObject).Dog.size() == 1) {
        if (((anc)localObject).Doe.isEmpty())
        {
          localanb = new anb();
          localanb.name = paramString;
          localanb.startTime = paramLong;
          ((anc)localObject).Dog.addLast(localanb);
          localArrayList.add(Long.valueOf(((anc)localObject).Doj));
          ad.i("FuzzyMatch", "HABBYGE-MALI, FuzzyMatch, _updatePath: " + ((anc)localObject).Doj + ", " + paramString);
        }
      }
      for (;;)
      {
        i -= 1;
        break;
        if (((anc)localObject).Doe.size() == 1)
        {
          if (k.g(((anc)localObject).Dof.DDP, paramString))
          {
            localanb = new anb();
            localanb.name = paramString;
            localanb.startTime = paramLong;
            ((anc)localObject).Dog.addLast(localanb);
            localArrayList.add(Long.valueOf(((anc)localObject).Doj));
            ad.i("FuzzyMatch", "HABBYGE-MALI, FuzzyMatch, _updatePath, =1: " + ((anc)localObject).Doj + ", " + paramString);
          }
          else if (k.g(((cqp)((anc)localObject).Doe.get(0)).DDP, paramString))
          {
            ((anc)localObject).Dog.clear();
            localanb = new anb();
            localanb.name = paramString;
            localanb.startTime = paramLong;
            ((anc)localObject).Dog.addLast(localanb);
            localArrayList.add(Long.valueOf(((anc)localObject).Doj));
          }
          else
          {
            paramcqn.DnZ.remove(i);
          }
        }
        else if (k.g(((cqp)((anc)localObject).Doe.get(1)).DDP, paramString))
        {
          localanb = new anb();
          localanb.name = paramString;
          localanb.startTime = paramLong;
          ((anc)localObject).Dog.addLast(localanb);
          localArrayList.add(Long.valueOf(((anc)localObject).Doj));
        }
        else if (k.g(((cqp)((anc)localObject).Doe.get(0)).DDP, paramString))
        {
          ((anc)localObject).Dog.clear();
          localanb = new anb();
          localanb.name = paramString;
          localanb.startTime = paramLong;
          ((anc)localObject).Dog.addLast(localanb);
          localArrayList.add(Long.valueOf(((anc)localObject).Doj));
        }
        else
        {
          paramcqn.DnZ.remove(i);
          continue;
          if ((((anc)localObject).Dog.size() > 1) && (((anc)localObject).Doh)) {
            if (((anc)localObject).Doe.isEmpty())
            {
              localanb = new anb();
              localanb.name = paramString;
              localanb.startTime = paramLong;
              ((anc)localObject).Dog.addLast(localanb);
              ad.i("FuzzyMatch", "HABBYGE-MALI, FuzzyMatch, _updatePath, =1: " + ((anc)localObject).Doj + ", " + paramString);
              localArrayList.add(Long.valueOf(((anc)localObject).Doj));
            }
            else if (((anc)localObject).Doe.size() == 1)
            {
              localanb = new anb();
              localanb.name = paramString;
              localanb.startTime = paramLong;
              ((anc)localObject).Dog.addLast(localanb);
              ad.i("FuzzyMatch", "HABBYGE-MALI, FuzzyMatch, _updatePath, =2: " + ((anc)localObject).Doj + ", " + paramString);
              localArrayList.add(Long.valueOf(((anc)localObject).Doj));
            }
            else if (((anc)localObject).Dog.size() > ((anc)localObject).Doe.size())
            {
              localanb = new anb();
              localanb.name = paramString;
              localanb.startTime = paramLong;
              ((anc)localObject).Dog.addLast(localanb);
              ad.i("FuzzyMatch", "HABBYGE-MALI, FuzzyMatch, _updatePath, >2: " + ((anc)localObject).Doj + ", " + paramString);
              localArrayList.add(Long.valueOf(((anc)localObject).Doj));
            }
            else if (((anc)localObject).Dog.size() == ((anc)localObject).Doe.size())
            {
              if (k.g(((anc)localObject).Dof.DDP, paramString))
              {
                localanb = new anb();
                localanb.name = paramString;
                localanb.startTime = paramLong;
                ((anc)localObject).Dog.addLast(localanb);
                localArrayList.add(Long.valueOf(((anc)localObject).Doj));
                ad.i("FuzzyMatch", "HABBYGE-MALI, FuzzyMatch, _updatePath, >=2: " + ((anc)localObject).Doj + ", " + paramString);
              }
              else if (k.g(((cqp)((anc)localObject).Doe.get(0)).DDP, paramString))
              {
                ((anc)localObject).Dog.clear();
                localanb = new anb();
                localanb.name = paramString;
                localanb.startTime = paramLong;
                ((anc)localObject).Dog.addLast(localanb);
                localArrayList.add(Long.valueOf(((anc)localObject).Doj));
              }
              else
              {
                paramcqn.DnZ.remove(i);
              }
            }
            else if (k.g(((cqp)((anc)localObject).Doe.get(((anc)localObject).Dog.size())).DDP, paramString))
            {
              localanb = new anb();
              localanb.name = paramString;
              localanb.startTime = paramLong;
              ((anc)localObject).Dog.addLast(localanb);
              localArrayList.add(Long.valueOf(((anc)localObject).Doj));
            }
            else if (k.g(((cqp)((anc)localObject).Doe.get(0)).DDP, paramString))
            {
              ((anc)localObject).Dog.clear();
              localanb = new anb();
              localanb.name = paramString;
              localanb.startTime = paramLong;
              ((anc)localObject).Dog.addLast(localanb);
              localArrayList.add(Long.valueOf(((anc)localObject).Doj));
            }
            else
            {
              paramcqn.DnZ.remove(i);
            }
          }
        }
      }
    }
    paramString = d.pGQ;
    d.a.a(paramcqn);
    AppMethodBeat.o(184277);
    return localArrayList;
  }
  
  private static void a(String paramString1, String paramString2, long paramLong, ArrayList<cqt> paramArrayList)
  {
    AppMethodBeat.i(184275);
    ad.i("FuzzyMatch", "HABBYGE-MALI, _matchOnNot1stOnResume: " + paramString1 + ", " + paramString2);
    Object localObject = d.pGQ;
    localObject = d.a.Wo(paramString2);
    if (((cqn)((Pair)localObject).first).DnZ.isEmpty())
    {
      ad.i("FuzzyMatch", "HABBYGE-MALI, _matchSessionOn1stOnResume: " + paramString1 + ", " + paramString2);
      a(paramString1, paramString2, paramLong, paramArrayList, new ArrayList());
      AppMethodBeat.o(184275);
      return;
    }
    localObject = ((Pair)localObject).first;
    k.g(localObject, "sessionPathPair.first");
    a(paramString1, paramString2, (cqn)localObject, paramLong, paramArrayList);
    AppMethodBeat.o(184275);
  }
  
  private static void a(String paramString1, String paramString2, long paramLong, ArrayList<cqt> paramArrayList, ArrayList<Long> paramArrayList1)
  {
    AppMethodBeat.i(184278);
    paramArrayList = paramArrayList.iterator();
    while (paramArrayList.hasNext())
    {
      Object localObject1 = (cqt)paramArrayList.next();
      if (!paramArrayList1.contains(Long.valueOf(((cqt)localObject1).Doj)))
      {
        Object localObject3;
        Object localObject2;
        if (((cqt)localObject1).EjF.size() == 1)
        {
          k.g(localObject1, "pathConfig");
          localObject3 = (cqp)((cqt)localObject1).EjF.get(0);
          if ((localObject3 != null) && (k.g(paramString1, ((cqp)localObject3).DDP)))
          {
            ad.i("FuzzyMatch", "HABBYGE-MALI, _addPage: " + paramString2 + ", " + ((cqp)localObject3).DDP + ", " + paramString1);
            localObject2 = new anc();
            ((anc)localObject2).dpw = paramString2;
            ((anc)localObject2).Dof = ((cqp)localObject3);
            ((anc)localObject2).Doh = true;
            ((anc)localObject2).qHI = ((cqt)localObject1).qHI;
            ((anc)localObject2).Doi = ((cqt)localObject1).Doi;
            ((anc)localObject2).Doj = ((cqt)localObject1).Doj;
            localObject1 = new anb();
            ((anb)localObject1).name = paramString1;
            ((anb)localObject1).startTime = paramLong;
            ((anc)localObject2).Dog.addLast(localObject1);
            localObject1 = d.pGQ;
            localObject1 = d.a.Wo(paramString2);
            ((cqn)((Pair)localObject1).first).DnZ.addLast(localObject2);
            ((cqn)((Pair)localObject1).first).dpw = paramString2;
            localObject2 = d.pGQ;
            localObject2 = (cqn)((Pair)localObject1).first;
            localObject1 = ((Pair)localObject1).second;
            k.g(localObject1, "curSessionPathPair.second");
            d.a.a((cqn)localObject2, ((Number)localObject1).intValue());
          }
        }
        else
        {
          cqp localcqp;
          if (((cqt)localObject1).EjF.size() == 2)
          {
            localObject3 = (cqp)((cqt)localObject1).EjF.get(0);
            localcqp = (cqp)((cqt)localObject1).EjF.get(1);
            if (k.g(paramString1, ((cqp)localObject3).DDP))
            {
              k.g(localObject3, "prePageConfig");
              k.g(localcqp, "curPageConfig");
              k.g(localObject1, "pathConfig");
              ad.i("FuzzyMatch", "HABBYGE-MAlI, _addPrePage: %s, %s, %s, %s", new Object[] { paramString2, ((cqp)localObject3).DDP, localcqp.DDP, paramString1 });
              localObject2 = new anc();
              ((anc)localObject2).dpw = paramString2;
              ((anc)localObject2).Doe.add(localObject3);
              ((anc)localObject2).Dof = localcqp;
              ((anc)localObject2).Doh = true;
              ((anc)localObject2).qHI = ((cqt)localObject1).qHI;
              ((anc)localObject2).Doi = ((cqt)localObject1).Doi;
              ((anc)localObject2).Doj = ((cqt)localObject1).Doj;
              localObject1 = new anb();
              ((anb)localObject1).name = paramString1;
              ((anb)localObject1).startTime = paramLong;
              ((anc)localObject2).Dog.addLast(localObject1);
              localObject1 = d.pGQ;
              localObject1 = d.a.Wo(paramString2);
              ((cqn)((Pair)localObject1).first).DnZ.addLast(localObject2);
              ((cqn)((Pair)localObject1).first).dpw = paramString2;
              localObject2 = d.pGQ;
              localObject2 = (cqn)((Pair)localObject1).first;
              localObject1 = ((Pair)localObject1).second;
              k.g(localObject1, "curSessionPathPair.second");
              d.a.a((cqn)localObject2, ((Number)localObject1).intValue());
            }
          }
          else
          {
            localObject3 = ((cqt)localObject1).EjF.subList(0, ((cqt)localObject1).EjF.size() - 1);
            k.g(localObject3, "pathConfig.pagePathUnits…g.pagePathUnits.size - 1)");
            localObject2 = ((cqt)localObject1).EjF;
            k.g(localObject2, "pathConfig.pagePathUnits");
            localcqp = (cqp)((LinkedList)localObject2).getLast();
            if (k.g(paramString1, ((cqp)((List)localObject3).get(0)).DDP))
            {
              k.g(localcqp, "curPageConfig");
              k.g(localObject1, "pathConfig");
              ad.i("FuzzyMatch", "HABBYGE-MAlI, _addPrePage: %s, %d, %s, %s", new Object[] { paramString2, Integer.valueOf(((List)localObject3).size()), localcqp.DDP, paramString1 });
              localObject2 = new anc();
              ((anc)localObject2).dpw = paramString2;
              ((anc)localObject2).Doe.addAll((Collection)localObject3);
              ((anc)localObject2).Dof = localcqp;
              ((anc)localObject2).Doh = true;
              ((anc)localObject2).qHI = ((cqt)localObject1).qHI;
              ((anc)localObject2).Doi = ((cqt)localObject1).Doi;
              ((anc)localObject2).Doj = ((cqt)localObject1).Doj;
              localObject1 = new anb();
              ((anb)localObject1).name = paramString1;
              ((anb)localObject1).startTime = paramLong;
              ((anc)localObject2).Dog.addLast(localObject1);
              localObject1 = d.pGQ;
              localObject1 = d.a.Wo(paramString2);
              ((cqn)((Pair)localObject1).first).DnZ.addLast(localObject2);
              ((cqn)((Pair)localObject1).first).dpw = paramString2;
              localObject2 = d.pGQ;
              localObject2 = (cqn)((Pair)localObject1).first;
              localObject1 = ((Pair)localObject1).second;
              k.g(localObject1, "curSessionPathPair.second");
              d.a.a((cqn)localObject2, ((Number)localObject1).intValue());
            }
          }
        }
      }
    }
    AppMethodBeat.o(184278);
  }
  
  private static void a(String paramString1, String paramString2, cqn paramcqn, long paramLong, ArrayList<cqt> paramArrayList)
  {
    AppMethodBeat.i(184276);
    ad.i("FuzzyMatch", "HABBYGE-MALI, _matchSessionNot1STOnResume: " + paramString1 + ", " + paramString2);
    paramcqn = a(paramString1, paramcqn, paramLong);
    ad.i("FuzzyMatch", "HABBYGE-MALI, _updatePath, matchingPathIds: " + paramcqn.size());
    a(paramString1, paramString2, paramLong, paramArrayList, paramcqn);
    AppMethodBeat.o(184276);
  }
  
  private final void aa(String paramString, long paramLong)
  {
    AppMethodBeat.i(184274);
    ad.i("FuzzyMatch", "HABBYGE-MALI, FuzzyMatch, _matchOnResume: ".concat(String.valueOf(paramString)));
    Object localObject1 = ccs();
    if (localObject1 == null)
    {
      AppMethodBeat.o(184274);
      return;
    }
    String str = (String)((com.tencent.mm.vending.j.c)localObject1).fhx();
    localObject1 = (ArrayList)((com.tencent.mm.vending.j.c)localObject1).fhy();
    if (localObject1 == null)
    {
      AppMethodBeat.o(184274);
      return;
    }
    Object localObject2 = d.pGQ;
    localObject2 = d.a.ccv();
    if ((localObject2 == null) || (((ana)localObject2).Doa.isEmpty()))
    {
      ad.i("FuzzyMatch", "HABBYGE-MALI, _matchOn1stOnResume: " + paramString + ", " + str);
      k.g(str, "curSessionId");
      a(paramString, str, paramLong, (ArrayList)localObject1, new ArrayList());
      AppMethodBeat.o(184274);
      return;
    }
    k.g(str, "curSessionId");
    a(paramString, str, paramLong, (ArrayList)localObject1);
    AppMethodBeat.o(184274);
  }
  
  private static void b(String paramString, boolean paramBoolean, long paramLong)
  {
    AppMethodBeat.i(184279);
    ad.i("FuzzyMatch", "HABBYGE-MALI, FuzzyMatch, _matchOnFinish: " + paramString + ", " + paramBoolean + ", " + pGN);
    if (((paramBoolean) || (com.tencent.mm.plugin.expt.hellhound.core.b.aUN(paramString))) && (pGN))
    {
      pGN = false;
      AppMethodBeat.o(184279);
      return;
    }
    Object localObject1 = com.tencent.mm.plugin.expt.hellhound.a.f.b.b.pHq;
    localObject1 = com.tencent.mm.plugin.expt.hellhound.a.f.c.c.cdi();
    if (localObject1 == null) {}
    for (localObject1 = null; localObject1 == null; localObject1 = ((bxx)localObject1).sessionId)
    {
      ad.w("FuzzyMatch", "HABBYGE-MALI, FuzzyMatch, _matchOnFinish: curSession == null");
      AppMethodBeat.o(184279);
      return;
    }
    Object localObject2 = d.pGQ;
    localObject2 = d.a.Wn((String)localObject1);
    if (localObject2 == null)
    {
      ad.w("FuzzyMatch", "HABBYGE-MALI, FuzzyMatch, _matchOnFinish: sessionMatch == null");
      AppMethodBeat.o(184279);
      return;
    }
    ad.i("FuzzyMatch", "HABBYGE-MALI, FuzzyMatch, _matchOnFinish: %s, %s, %d", new Object[] { localObject1, ((cqn)localObject2).dpw, Integer.valueOf(((cqn)localObject2).DnZ.size()) });
    localObject1 = ((cqn)localObject2).DnZ.iterator();
    while (((Iterator)localObject1).hasNext())
    {
      anc localanc = (anc)((Iterator)localObject1).next();
      Object localObject3 = com.tencent.mm.plugin.expt.hellhound.core.b.Vy(localanc.Dof.DDP);
      if ((localanc.Doh) && ((k.g(paramString, localanc.Dof.DDP)) || (k.g(paramString, localObject3))))
      {
        localanc.Doh = false;
        localObject3 = e.pGR;
        e.a.a(localanc, paramLong);
      }
    }
    paramString = d.pGQ;
    d.a.a((cqn)localObject2);
    AppMethodBeat.o(184279);
  }
  
  private static void ccr()
  {
    AppMethodBeat.i(169392);
    Object localObject = d.pGQ;
    d.a.reset();
    localObject = f.pGS;
    f.a.reset();
    localObject = j.pHC;
    j.a.reset();
    AppMethodBeat.o(169392);
  }
  
  private static com.tencent.mm.vending.j.c<String, ArrayList<cqt>> ccs()
  {
    AppMethodBeat.i(169393);
    Object localObject1 = com.tencent.mm.plugin.expt.hellhound.a.f.b.b.pHq;
    localObject1 = b.a.ccS();
    if (localObject1 == null)
    {
      AppMethodBeat.o(169393);
      return null;
    }
    Object localObject2 = com.tencent.mm.plugin.expt.hellhound.a.f.b.b.pHq;
    localObject2 = b.a.Wv((String)localObject1);
    if (localObject2 == null)
    {
      AppMethodBeat.o(169393);
      return null;
    }
    c.a locala = c.pGP;
    localObject2 = c.a.Wm((String)localObject2);
    if (localObject2 == null)
    {
      AppMethodBeat.o(169393);
      return null;
    }
    if (((ArrayList)localObject2).isEmpty())
    {
      ad.w("FuzzyMatch", "HABBYGE-MALI, FuzzyMatch, _getCloudConfig Empty!!");
      AppMethodBeat.o(169393);
      return null;
    }
    localObject1 = com.tencent.mm.vending.j.a.L(localObject1, localObject2);
    AppMethodBeat.o(169393);
    return localObject1;
  }
  
  public static void cct()
  {
    AppMethodBeat.i(122571);
    ad.i("FuzzyMatch", "HABBYGE-MALI, FuzzyMatch, resetReportCache");
    e.a locala = e.pGR;
    com.tencent.mm.plugin.expt.hellhound.core.a.b.o("mmkv_fuzzy_mc_rpt", new byte[0]);
    AppMethodBeat.o(122571);
  }
  
  public static amz ccu()
  {
    AppMethodBeat.i(122572);
    Object localObject = e.pGR;
    localObject = e.a.ccw();
    AppMethodBeat.o(122572);
    return localObject;
  }
  
  private static void pi(long paramLong)
  {
    AppMethodBeat.i(184280);
    e.a locala = e.pGR;
    e.a.pj(paramLong);
    AppMethodBeat.o(184280);
  }
  
  public final void a(String paramString, long paramLong, g paramg)
  {
    AppMethodBeat.i(184273);
    k.h(paramg, "state");
    if (paramString == null)
    {
      ad.i("FuzzyMatch", "HABBYGE-MALI, FuzzyMatch.match: page is: ".concat(String.valueOf(paramString)));
      AppMethodBeat.o(184273);
      return;
    }
    b.a locala = com.tencent.mm.plugin.expt.hellhound.a.f.b.b.pHq;
    if (b.a.ccP())
    {
      ad.w("FuzzyMatch", "HABBYGE-MALI, FuzzyMatch, match, doNotNeedSessionMonitor: TRUE");
      AppMethodBeat.o(184273);
      return;
    }
    ad.i("FuzzyMatch", "HABBYGE-MALI, FuzzyMatch, match: " + paramString + ", " + paramg);
    switch (b.ciE[paramg.ordinal()])
    {
    default: 
      ad.e("FuzzyMatch", "HABBYGE-MALI, FuzzyMatch, match ~");
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
          } while (!Wl(paramString));
          aa(paramString, paramLong);
          AppMethodBeat.o(184273);
          return;
          ad.i("FuzzyMatch", "HABBYGE-MALI, MatchState.MATCH_PAGE_SLIENCE_POP_STACK: ".concat(String.valueOf(paramString)));
        } while (!Wl(paramString));
        b(paramString, false, paramLong);
        AppMethodBeat.o(184273);
        return;
        ad.i("FuzzyMatch", "HABBYGE-MALI, MatchState.MATCH_PAGE_FINISH: ".concat(String.valueOf(paramString)));
      } while (!Wl(paramString));
      b(paramString, false, paramLong);
      AppMethodBeat.o(184273);
      return;
    case 4: 
      ad.i("FuzzyMatch", "HABBYGE-MALI, MatchState.MATCH_PAGE_SESSION_CLOSE: ".concat(String.valueOf(paramString)));
      b(paramString, true, paramLong);
      AppMethodBeat.o(184273);
      return;
    case 5: 
      ad.i("FuzzyMatch", "HABBYGE-MALI, MatchState.MATCH_PAGE_8_EVENT: ".concat(String.valueOf(paramString)));
      pGN = true;
      pi(paramLong);
      AppMethodBeat.o(184273);
      return;
    }
    ccr();
    AppMethodBeat.o(184273);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.expt.hellhound.a.d.a
 * JD-Core Version:    0.7.0.1
 */