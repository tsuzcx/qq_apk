package com.tencent.mm.plugin.expt.hellhound.a.d;

import android.util.Pair;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.expt.hellhound.a.f.b.b.a;
import com.tencent.mm.plugin.expt.hellhound.a.f.c.j;
import com.tencent.mm.plugin.expt.hellhound.a.f.c.j.a;
import com.tencent.mm.protocal.protobuf.aqd;
import com.tencent.mm.protocal.protobuf.aqe;
import com.tencent.mm.protocal.protobuf.aqf;
import com.tencent.mm.protocal.protobuf.aqg;
import com.tencent.mm.protocal.protobuf.ccs;
import com.tencent.mm.protocal.protobuf.cvu;
import com.tencent.mm.protocal.protobuf.cvw;
import com.tencent.mm.protocal.protobuf.cwa;
import com.tencent.mm.sdk.platformtools.ac;
import d.g.b.k;
import d.l;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/expt/hellhound/ext/fuzzymatch/FuzzyMatch;", "", "()V", "TAG", "", "is8EventForFragment", "", "_addPage", "", "curSessionId", "curPageConfig", "Lcom/tencent/mm/protocal/protobuf/SessionPage;", "pathConfig", "Lcom/tencent/mm/protocal/protobuf/SessionPagePath;", "curPage", "timestamp", "", "_addPrePage", "prePageConfig", "expctPageConfig", "_addPrePage2", "prePagesConfig", "", "_doNewMatch", "curCloudConfig", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "matchingPathIds", "_doNewMatch1Page", "_getCloudConfig", "Lcom/tencent/mm/vending/tuple/Tuple2;", "_isPageLegal", "pageName", "_matchOn8Event", "_matchOnFinish", "onSessionClose", "_matchOnNot1stOnResume", "_matchOnResume", "_matchOnSessionNot1STOnResume", "sessionPath", "Lcom/tencent/mm/protocal/protobuf/SessionFuzzyPath;", "_updatePath", "getMatchedFuzzyPaths", "Lcom/tencent/mm/protocal/protobuf/FuzzyPath;", "sessionId", "getMatchingFuzzyPaths", "getReportCache", "Lcom/tencent/mm/protocal/protobuf/FuzzyMatchCache;", "match", "state", "Lcom/tencent/mm/plugin/expt/hellhound/ext/fuzzymatch/MatchState;", "mmProcessRestartEvent", "resetFuzzyDaoOnSessionStart", "resetReportCache", "plugin-expt_release"})
public final class a
{
  private static boolean qpu;
  public static final a qpv;
  
  static
  {
    AppMethodBeat.i(122574);
    qpv = new a();
    AppMethodBeat.o(122574);
  }
  
  private static ArrayList<Long> a(String paramString, cvu paramcvu, long paramLong)
  {
    AppMethodBeat.i(184277);
    ArrayList localArrayList = new ArrayList();
    int i = paramcvu.EIZ.size() - 1;
    if (i >= 0)
    {
      Object localObject = paramcvu.EIZ.get(i);
      k.g(localObject, "sessionPath.paths[i]");
      localObject = (aqg)localObject;
      aqf localaqf;
      if (((aqg)localObject).EJg.size() == 1) {
        if (((aqg)localObject).EJe.isEmpty())
        {
          localaqf = new aqf();
          localaqf.name = paramString;
          localaqf.startTime = paramLong;
          ((aqg)localObject).EJg.addLast(localaqf);
          localArrayList.add(Long.valueOf(((aqg)localObject).EJj));
          ac.i("FuzzyMatch", "HABBYGE-MALI, FuzzyMatch, _updatePath: " + ((aqg)localObject).EJj + ", " + paramString);
        }
      }
      for (;;)
      {
        i -= 1;
        break;
        if (((aqg)localObject).EJe.size() == 1)
        {
          if (k.g(((aqg)localObject).EJf.qoi, paramString))
          {
            localaqf = new aqf();
            localaqf.name = paramString;
            localaqf.startTime = paramLong;
            ((aqg)localObject).EJg.addLast(localaqf);
            localArrayList.add(Long.valueOf(((aqg)localObject).EJj));
            ac.i("FuzzyMatch", "HABBYGE-MALI, FuzzyMatch, _updatePath, =1: " + ((aqg)localObject).EJj + ", " + paramString);
          }
          else if (k.g(((cvw)((aqg)localObject).EJe.get(0)).qoi, paramString))
          {
            ((aqg)localObject).EJg.clear();
            localaqf = new aqf();
            localaqf.name = paramString;
            localaqf.startTime = paramLong;
            ((aqg)localObject).EJg.addLast(localaqf);
            localArrayList.add(Long.valueOf(((aqg)localObject).EJj));
          }
          else
          {
            paramcvu.EIZ.remove(i);
          }
        }
        else if (k.g(((cvw)((aqg)localObject).EJe.get(1)).qoi, paramString))
        {
          localaqf = new aqf();
          localaqf.name = paramString;
          localaqf.startTime = paramLong;
          ((aqg)localObject).EJg.addLast(localaqf);
          localArrayList.add(Long.valueOf(((aqg)localObject).EJj));
        }
        else if (k.g(((cvw)((aqg)localObject).EJe.get(0)).qoi, paramString))
        {
          ((aqg)localObject).EJg.clear();
          localaqf = new aqf();
          localaqf.name = paramString;
          localaqf.startTime = paramLong;
          ((aqg)localObject).EJg.addLast(localaqf);
          localArrayList.add(Long.valueOf(((aqg)localObject).EJj));
        }
        else
        {
          paramcvu.EIZ.remove(i);
          continue;
          if ((((aqg)localObject).EJg.size() > 1) && (((aqg)localObject).EJh)) {
            if (((aqg)localObject).EJe.isEmpty())
            {
              localaqf = new aqf();
              localaqf.name = paramString;
              localaqf.startTime = paramLong;
              ((aqg)localObject).EJg.addLast(localaqf);
              ac.i("FuzzyMatch", "HABBYGE-MALI, FuzzyMatch, _updatePath, =1: " + ((aqg)localObject).EJj + ", " + paramString);
              localArrayList.add(Long.valueOf(((aqg)localObject).EJj));
            }
            else if (((aqg)localObject).EJe.size() == 1)
            {
              localaqf = new aqf();
              localaqf.name = paramString;
              localaqf.startTime = paramLong;
              ((aqg)localObject).EJg.addLast(localaqf);
              ac.i("FuzzyMatch", "HABBYGE-MALI, FuzzyMatch, _updatePath, =2: " + ((aqg)localObject).EJj + ", " + paramString);
              localArrayList.add(Long.valueOf(((aqg)localObject).EJj));
            }
            else if (((aqg)localObject).EJg.size() > ((aqg)localObject).EJe.size())
            {
              localaqf = new aqf();
              localaqf.name = paramString;
              localaqf.startTime = paramLong;
              ((aqg)localObject).EJg.addLast(localaqf);
              ac.i("FuzzyMatch", "HABBYGE-MALI, FuzzyMatch, _updatePath, >2: " + ((aqg)localObject).EJj + ", " + paramString);
              localArrayList.add(Long.valueOf(((aqg)localObject).EJj));
            }
            else if (((aqg)localObject).EJg.size() == ((aqg)localObject).EJe.size())
            {
              if (k.g(((aqg)localObject).EJf.qoi, paramString))
              {
                localaqf = new aqf();
                localaqf.name = paramString;
                localaqf.startTime = paramLong;
                ((aqg)localObject).EJg.addLast(localaqf);
                localArrayList.add(Long.valueOf(((aqg)localObject).EJj));
                ac.i("FuzzyMatch", "HABBYGE-MALI, FuzzyMatch, _updatePath, >=2: " + ((aqg)localObject).EJj + ", " + paramString);
              }
              else if (k.g(((cvw)((aqg)localObject).EJe.get(0)).qoi, paramString))
              {
                ((aqg)localObject).EJg.clear();
                localaqf = new aqf();
                localaqf.name = paramString;
                localaqf.startTime = paramLong;
                ((aqg)localObject).EJg.addLast(localaqf);
                localArrayList.add(Long.valueOf(((aqg)localObject).EJj));
              }
              else
              {
                paramcvu.EIZ.remove(i);
              }
            }
            else if (k.g(((cvw)((aqg)localObject).EJe.get(((aqg)localObject).EJg.size())).qoi, paramString))
            {
              localaqf = new aqf();
              localaqf.name = paramString;
              localaqf.startTime = paramLong;
              ((aqg)localObject).EJg.addLast(localaqf);
              localArrayList.add(Long.valueOf(((aqg)localObject).EJj));
            }
            else if (k.g(((cvw)((aqg)localObject).EJe.get(0)).qoi, paramString))
            {
              ((aqg)localObject).EJg.clear();
              localaqf = new aqf();
              localaqf.name = paramString;
              localaqf.startTime = paramLong;
              ((aqg)localObject).EJg.addLast(localaqf);
              localArrayList.add(Long.valueOf(((aqg)localObject).EJj));
            }
            else
            {
              paramcvu.EIZ.remove(i);
            }
          }
        }
      }
    }
    paramString = d.qpx;
    d.a.a(paramcvu);
    AppMethodBeat.o(184277);
    return localArrayList;
  }
  
  private static void a(String paramString1, String paramString2, long paramLong, ArrayList<cwa> paramArrayList)
  {
    AppMethodBeat.i(184275);
    ac.i("FuzzyMatch", "HABBYGE-MALI, _matchOnNot1stOnResume: " + paramString1 + ", " + paramString2);
    Object localObject = d.qpx;
    localObject = d.a.aaL(paramString2);
    if (((cvu)((Pair)localObject).first).EIZ.isEmpty())
    {
      ac.i("FuzzyMatch", "HABBYGE-MALI, _matchSessionOn1stOnResume: " + paramString1 + ", " + paramString2);
      a(paramString1, paramString2, paramLong, paramArrayList, new ArrayList());
      AppMethodBeat.o(184275);
      return;
    }
    localObject = ((Pair)localObject).first;
    k.g(localObject, "sessionPathPair.first");
    a(paramString1, paramString2, (cvu)localObject, paramLong, paramArrayList);
    AppMethodBeat.o(184275);
  }
  
  private static void a(String paramString1, String paramString2, long paramLong, ArrayList<cwa> paramArrayList, ArrayList<Long> paramArrayList1)
  {
    AppMethodBeat.i(184278);
    paramArrayList = paramArrayList.iterator();
    while (paramArrayList.hasNext())
    {
      Object localObject1 = (cwa)paramArrayList.next();
      if (!paramArrayList1.contains(Long.valueOf(((cwa)localObject1).EJj)))
      {
        Object localObject3;
        Object localObject2;
        if (((cwa)localObject1).FGD.size() == 1)
        {
          k.g(localObject1, "pathConfig");
          localObject3 = (cvw)((cwa)localObject1).FGD.get(0);
          if ((localObject3 != null) && (k.g(paramString1, ((cvw)localObject3).qoi)))
          {
            ac.i("FuzzyMatch", "HABBYGE-MALI, _addPage: " + paramString2 + ", " + ((cvw)localObject3).qoi + ", " + paramString1);
            localObject2 = new aqg();
            ((aqg)localObject2).dnh = paramString2;
            ((aqg)localObject2).EJf = ((cvw)localObject3);
            ((aqg)localObject2).EJh = true;
            ((aqg)localObject2).rAJ = ((cwa)localObject1).rAJ;
            ((aqg)localObject2).EJi = ((cwa)localObject1).EJi;
            ((aqg)localObject2).EJj = ((cwa)localObject1).EJj;
            localObject1 = new aqf();
            ((aqf)localObject1).name = paramString1;
            ((aqf)localObject1).startTime = paramLong;
            ((aqg)localObject2).EJg.addLast(localObject1);
            localObject1 = d.qpx;
            localObject1 = d.a.aaL(paramString2);
            ((cvu)((Pair)localObject1).first).EIZ.addLast(localObject2);
            ((cvu)((Pair)localObject1).first).dnh = paramString2;
            localObject2 = d.qpx;
            localObject2 = (cvu)((Pair)localObject1).first;
            localObject1 = ((Pair)localObject1).second;
            k.g(localObject1, "curSessionPathPair.second");
            d.a.a((cvu)localObject2, ((Number)localObject1).intValue());
          }
        }
        else
        {
          cvw localcvw;
          if (((cwa)localObject1).FGD.size() == 2)
          {
            localObject3 = (cvw)((cwa)localObject1).FGD.get(0);
            localcvw = (cvw)((cwa)localObject1).FGD.get(1);
            if (k.g(paramString1, ((cvw)localObject3).qoi))
            {
              k.g(localObject3, "prePageConfig");
              k.g(localcvw, "curPageConfig");
              k.g(localObject1, "pathConfig");
              ac.i("FuzzyMatch", "HABBYGE-MAlI, _addPrePage: %s, %s, %s, %s", new Object[] { paramString2, ((cvw)localObject3).qoi, localcvw.qoi, paramString1 });
              localObject2 = new aqg();
              ((aqg)localObject2).dnh = paramString2;
              ((aqg)localObject2).EJe.add(localObject3);
              ((aqg)localObject2).EJf = localcvw;
              ((aqg)localObject2).EJh = true;
              ((aqg)localObject2).rAJ = ((cwa)localObject1).rAJ;
              ((aqg)localObject2).EJi = ((cwa)localObject1).EJi;
              ((aqg)localObject2).EJj = ((cwa)localObject1).EJj;
              localObject1 = new aqf();
              ((aqf)localObject1).name = paramString1;
              ((aqf)localObject1).startTime = paramLong;
              ((aqg)localObject2).EJg.addLast(localObject1);
              localObject1 = d.qpx;
              localObject1 = d.a.aaL(paramString2);
              ((cvu)((Pair)localObject1).first).EIZ.addLast(localObject2);
              ((cvu)((Pair)localObject1).first).dnh = paramString2;
              localObject2 = d.qpx;
              localObject2 = (cvu)((Pair)localObject1).first;
              localObject1 = ((Pair)localObject1).second;
              k.g(localObject1, "curSessionPathPair.second");
              d.a.a((cvu)localObject2, ((Number)localObject1).intValue());
            }
          }
          else
          {
            localObject3 = ((cwa)localObject1).FGD.subList(0, ((cwa)localObject1).FGD.size() - 1);
            k.g(localObject3, "pathConfig.pagePathUnits…g.pagePathUnits.size - 1)");
            localObject2 = ((cwa)localObject1).FGD;
            k.g(localObject2, "pathConfig.pagePathUnits");
            localcvw = (cvw)((LinkedList)localObject2).getLast();
            if (k.g(paramString1, ((cvw)((List)localObject3).get(0)).qoi))
            {
              k.g(localcvw, "curPageConfig");
              k.g(localObject1, "pathConfig");
              ac.i("FuzzyMatch", "HABBYGE-MAlI, _addPrePage: %s, %d, %s, %s", new Object[] { paramString2, Integer.valueOf(((List)localObject3).size()), localcvw.qoi, paramString1 });
              localObject2 = new aqg();
              ((aqg)localObject2).dnh = paramString2;
              ((aqg)localObject2).EJe.addAll((Collection)localObject3);
              ((aqg)localObject2).EJf = localcvw;
              ((aqg)localObject2).EJh = true;
              ((aqg)localObject2).rAJ = ((cwa)localObject1).rAJ;
              ((aqg)localObject2).EJi = ((cwa)localObject1).EJi;
              ((aqg)localObject2).EJj = ((cwa)localObject1).EJj;
              localObject1 = new aqf();
              ((aqf)localObject1).name = paramString1;
              ((aqf)localObject1).startTime = paramLong;
              ((aqg)localObject2).EJg.addLast(localObject1);
              localObject1 = d.qpx;
              localObject1 = d.a.aaL(paramString2);
              ((cvu)((Pair)localObject1).first).EIZ.addLast(localObject2);
              ((cvu)((Pair)localObject1).first).dnh = paramString2;
              localObject2 = d.qpx;
              localObject2 = (cvu)((Pair)localObject1).first;
              localObject1 = ((Pair)localObject1).second;
              k.g(localObject1, "curSessionPathPair.second");
              d.a.a((cvu)localObject2, ((Number)localObject1).intValue());
            }
          }
        }
      }
    }
    AppMethodBeat.o(184278);
  }
  
  private static void a(String paramString1, String paramString2, cvu paramcvu, long paramLong, ArrayList<cwa> paramArrayList)
  {
    AppMethodBeat.i(184276);
    ac.i("FuzzyMatch", "HABBYGE-MALI, _matchSessionNot1STOnResume: " + paramString1 + ", " + paramString2);
    paramcvu = a(paramString1, paramcvu, paramLong);
    ac.i("FuzzyMatch", "HABBYGE-MALI, _updatePath, matchingPathIds: " + paramcvu.size());
    a(paramString1, paramString2, paramLong, paramArrayList, paramcvu);
    AppMethodBeat.o(184276);
  }
  
  public static void aaF(String paramString)
  {
    AppMethodBeat.i(169394);
    ac.i("FuzzyMatch", "HABBYGE-MALI, FuzzyMatch, resetFuzzyDaoOnStart: ".concat(String.valueOf(paramString)));
    if (paramString == null)
    {
      AppMethodBeat.o(169394);
      return;
    }
    Object localObject1 = d.qpx;
    k.h(paramString, "curSessionId");
    localObject1 = d.a.cke();
    if (localObject1 != null)
    {
      int i = ((aqe)localObject1).EJa.size() - 1;
      while (i >= 0)
      {
        Object localObject2 = ((aqe)localObject1).EJa.get(i);
        k.g(localObject2, "matchInfo.sessionFuzzyPaths[i]");
        localObject2 = (cvu)localObject2;
        if (!k.g(paramString, ((cvu)localObject2).dnh))
        {
          ac.i("FuzzyMatchDao", "HABBYGE-MALI, resetOnStart, need remove: " + ((cvu)localObject2).dnh);
          int j = ((cvu)localObject2).EIZ.size() - 1;
          while (j >= 0)
          {
            Object localObject3 = ((cvu)localObject2).EIZ.get(j);
            k.g(localObject3, "sessionPath.paths[j]");
            if (((aqg)localObject3).EJh)
            {
              ac.i("FuzzyMatchDao", "HABBYGE-MALI, resetOnStart, real remove: " + ((cvu)localObject2).dnh);
              ((cvu)localObject2).EIZ.remove(j);
            }
            j -= 1;
          }
          if (((cvu)localObject2).EIZ.isEmpty()) {
            ((aqe)localObject1).EJa.remove(i);
          }
        }
        i -= 1;
      }
      d.a.a((aqe)localObject1);
    }
    paramString = f.qpz;
    f.a.reset();
    paramString = j.qqj;
    j.a.reset();
    AppMethodBeat.o(169394);
  }
  
  public static List<aqg> aaG(String paramString)
  {
    AppMethodBeat.i(122573);
    ArrayList localArrayList = new ArrayList();
    Object localObject = d.qpx;
    paramString = d.a.aaK(paramString);
    if (paramString == null)
    {
      AppMethodBeat.o(122573);
      return null;
    }
    paramString = paramString.EIZ.iterator();
    while (paramString.hasNext())
    {
      localObject = (aqg)paramString.next();
      if (((aqg)localObject).EJh) {
        localArrayList.add(localObject);
      }
    }
    paramString = (List)localArrayList;
    AppMethodBeat.o(122573);
    return paramString;
  }
  
  public static List<aqg> aaH(String paramString)
  {
    AppMethodBeat.i(185590);
    ArrayList localArrayList = new ArrayList();
    Object localObject = d.qpx;
    localObject = d.a.aaK(paramString);
    aqg localaqg;
    if (localObject != null)
    {
      localObject = ((cvu)localObject).EIZ.iterator();
      while (((Iterator)localObject).hasNext())
      {
        localaqg = (aqg)((Iterator)localObject).next();
        if (!localaqg.EJh) {
          localArrayList.add(localaqg);
        }
      }
    }
    localObject = f.qpz;
    localObject = f.a.aaM(paramString);
    if (localObject != null)
    {
      localObject = ((cvu)localObject).EIZ.iterator();
      while (((Iterator)localObject).hasNext())
      {
        localaqg = (aqg)((Iterator)localObject).next();
        if (!localaqg.EJh) {
          localArrayList.add(localaqg);
        }
      }
    }
    localObject = f.qpz;
    f.a.Wd(paramString);
    paramString = (List)localArrayList;
    AppMethodBeat.o(185590);
    return paramString;
  }
  
  private static boolean aaI(String paramString)
  {
    AppMethodBeat.i(169395);
    boolean bool = k.g(paramString, "com.tencent.mm.ui.LauncherUI");
    AppMethodBeat.o(169395);
    return bool ^ true;
  }
  
  private final void ac(String paramString, long paramLong)
  {
    AppMethodBeat.i(184274);
    ac.i("FuzzyMatch", "HABBYGE-MALI, FuzzyMatch, _matchOnResume: ".concat(String.valueOf(paramString)));
    Object localObject1 = ckb();
    if (localObject1 == null)
    {
      AppMethodBeat.o(184274);
      return;
    }
    String str = (String)((com.tencent.mm.vending.j.c)localObject1).fxz();
    localObject1 = (ArrayList)((com.tencent.mm.vending.j.c)localObject1).fxA();
    if (localObject1 == null)
    {
      AppMethodBeat.o(184274);
      return;
    }
    Object localObject2 = d.qpx;
    localObject2 = d.a.cke();
    if ((localObject2 == null) || (((aqe)localObject2).EJa.isEmpty()))
    {
      ac.i("FuzzyMatch", "HABBYGE-MALI, _matchOn1stOnResume: " + paramString + ", " + str);
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
    ac.i("FuzzyMatch", "HABBYGE-MALI, FuzzyMatch, _matchOnFinish: " + paramString + ", " + paramBoolean + ", " + qpu);
    if (((paramBoolean) || (com.tencent.mm.plugin.expt.hellhound.core.b.ZY(paramString))) && (qpu))
    {
      qpu = false;
      AppMethodBeat.o(184279);
      return;
    }
    Object localObject1 = com.tencent.mm.plugin.expt.hellhound.a.f.b.b.qpX;
    localObject1 = com.tencent.mm.plugin.expt.hellhound.a.f.c.c.ckQ();
    if (localObject1 == null) {}
    for (localObject1 = null; localObject1 == null; localObject1 = ((ccs)localObject1).sessionId)
    {
      ac.w("FuzzyMatch", "HABBYGE-MALI, FuzzyMatch, _matchOnFinish: curSession == null");
      AppMethodBeat.o(184279);
      return;
    }
    Object localObject2 = d.qpx;
    localObject2 = d.a.aaK((String)localObject1);
    if (localObject2 == null)
    {
      ac.w("FuzzyMatch", "HABBYGE-MALI, FuzzyMatch, _matchOnFinish: sessionMatch == null");
      AppMethodBeat.o(184279);
      return;
    }
    ac.i("FuzzyMatch", "HABBYGE-MALI, FuzzyMatch, _matchOnFinish: %s, %s, %d", new Object[] { localObject1, ((cvu)localObject2).dnh, Integer.valueOf(((cvu)localObject2).EIZ.size()) });
    localObject1 = ((cvu)localObject2).EIZ.iterator();
    while (((Iterator)localObject1).hasNext())
    {
      aqg localaqg = (aqg)((Iterator)localObject1).next();
      Object localObject3 = com.tencent.mm.plugin.expt.hellhound.core.b.ZK(localaqg.EJf.qoi);
      if ((localaqg.EJh) && ((k.g(paramString, localaqg.EJf.qoi)) || (k.g(paramString, localObject3))))
      {
        localaqg.EJh = false;
        localObject3 = e.qpy;
        e.a.a(localaqg, paramLong);
      }
    }
    paramString = d.qpx;
    d.a.a((cvu)localObject2);
    AppMethodBeat.o(184279);
  }
  
  private static void cka()
  {
    AppMethodBeat.i(169392);
    Object localObject = d.qpx;
    d.a.reset();
    localObject = f.qpz;
    f.a.reset();
    localObject = j.qqj;
    j.a.reset();
    AppMethodBeat.o(169392);
  }
  
  private static com.tencent.mm.vending.j.c<String, ArrayList<cwa>> ckb()
  {
    AppMethodBeat.i(169393);
    Object localObject1 = com.tencent.mm.plugin.expt.hellhound.a.f.b.b.qpX;
    localObject1 = b.a.ckA();
    if (localObject1 == null)
    {
      AppMethodBeat.o(169393);
      return null;
    }
    Object localObject2 = com.tencent.mm.plugin.expt.hellhound.a.f.b.b.qpX;
    localObject2 = b.a.aaS((String)localObject1);
    if (localObject2 == null)
    {
      AppMethodBeat.o(169393);
      return null;
    }
    c.a locala = c.qpw;
    localObject2 = c.a.aaJ((String)localObject2);
    if (localObject2 == null)
    {
      AppMethodBeat.o(169393);
      return null;
    }
    if (((ArrayList)localObject2).isEmpty())
    {
      ac.w("FuzzyMatch", "HABBYGE-MALI, FuzzyMatch, _getCloudConfig Empty!!");
      AppMethodBeat.o(169393);
      return null;
    }
    localObject1 = com.tencent.mm.vending.j.a.L(localObject1, localObject2);
    AppMethodBeat.o(169393);
    return localObject1;
  }
  
  public static void ckc()
  {
    AppMethodBeat.i(122571);
    ac.i("FuzzyMatch", "HABBYGE-MALI, FuzzyMatch, resetReportCache");
    e.a locala = e.qpy;
    com.tencent.mm.plugin.expt.hellhound.core.a.b.o("mmkv_fuzzy_mc_rpt", new byte[0]);
    AppMethodBeat.o(122571);
  }
  
  public static aqd ckd()
  {
    AppMethodBeat.i(122572);
    Object localObject = e.qpy;
    localObject = e.a.ckf();
    AppMethodBeat.o(122572);
    return localObject;
  }
  
  private static void sX(long paramLong)
  {
    AppMethodBeat.i(184280);
    e.a locala = e.qpy;
    e.a.sY(paramLong);
    AppMethodBeat.o(184280);
  }
  
  public final void a(String paramString, long paramLong, g paramg)
  {
    AppMethodBeat.i(184273);
    k.h(paramg, "state");
    if (paramString == null)
    {
      ac.i("FuzzyMatch", "HABBYGE-MALI, FuzzyMatch.match: page is: ".concat(String.valueOf(paramString)));
      AppMethodBeat.o(184273);
      return;
    }
    b.a locala = com.tencent.mm.plugin.expt.hellhound.a.f.b.b.qpX;
    if (b.a.ckx())
    {
      ac.w("FuzzyMatch", "HABBYGE-MALI, FuzzyMatch, match, doNotNeedSessionMonitor: TRUE");
      AppMethodBeat.o(184273);
      return;
    }
    ac.i("FuzzyMatch", "HABBYGE-MALI, FuzzyMatch, match: " + paramString + ", " + paramg);
    switch (b.cfA[paramg.ordinal()])
    {
    default: 
      ac.e("FuzzyMatch", "HABBYGE-MALI, FuzzyMatch, match ~");
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
          } while (!aaI(paramString));
          ac(paramString, paramLong);
          AppMethodBeat.o(184273);
          return;
          ac.i("FuzzyMatch", "HABBYGE-MALI, MatchState.MATCH_PAGE_SLIENCE_POP_STACK: ".concat(String.valueOf(paramString)));
        } while (!aaI(paramString));
        b(paramString, false, paramLong);
        AppMethodBeat.o(184273);
        return;
        ac.i("FuzzyMatch", "HABBYGE-MALI, MatchState.MATCH_PAGE_FINISH: ".concat(String.valueOf(paramString)));
      } while (!aaI(paramString));
      b(paramString, false, paramLong);
      AppMethodBeat.o(184273);
      return;
    case 4: 
      ac.i("FuzzyMatch", "HABBYGE-MALI, MatchState.MATCH_PAGE_SESSION_CLOSE: ".concat(String.valueOf(paramString)));
      b(paramString, true, paramLong);
      AppMethodBeat.o(184273);
      return;
    case 5: 
      ac.i("FuzzyMatch", "HABBYGE-MALI, MatchState.MATCH_PAGE_8_EVENT: ".concat(String.valueOf(paramString)));
      qpu = true;
      sX(paramLong);
      AppMethodBeat.o(184273);
      return;
    }
    cka();
    AppMethodBeat.o(184273);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.expt.hellhound.a.d.a
 * JD-Core Version:    0.7.0.1
 */