package com.tencent.mm.plugin.expt.hellhound.a.d;

import android.util.Pair;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.expt.hellhound.a.f.b.b.a;
import com.tencent.mm.plugin.expt.hellhound.a.f.c.j;
import com.tencent.mm.plugin.expt.hellhound.a.f.c.j.a;
import com.tencent.mm.protocal.protobuf.bmz;
import com.tencent.mm.protocal.protobuf.bna;
import com.tencent.mm.protocal.protobuf.bnb;
import com.tencent.mm.protocal.protobuf.bnc;
import com.tencent.mm.protocal.protobuf.dhx;
import com.tencent.mm.protocal.protobuf.efg;
import com.tencent.mm.protocal.protobuf.efi;
import com.tencent.mm.protocal.protobuf.efm;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/expt/hellhound/ext/fuzzymatch/FuzzyMatch;", "", "()V", "TAG", "", "is8EventForFragment", "", "_addPage", "", "curSessionId", "curPageConfig", "Lcom/tencent/mm/protocal/protobuf/SessionPage;", "pathConfig", "Lcom/tencent/mm/protocal/protobuf/SessionPagePath;", "curPage", "timestamp", "", "_addPrePage", "prePageConfig", "expctPageConfig", "_addPrePage2", "prePagesConfig", "", "_doNewMatch", "curCloudConfig", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "matchingPathIds", "_doNewMatch1Page", "_getCloudConfig", "Lcom/tencent/mm/vending/tuple/Tuple2;", "_isPageLegal", "pageName", "_matchOn8Event", "_matchOnFinish", "onSessionClose", "_matchOnNot1stOnResume", "_matchOnResume", "_matchOnSessionNot1STOnResume", "sessionPath", "Lcom/tencent/mm/protocal/protobuf/SessionFuzzyPath;", "_updatePath", "getFuzzyPathOfCurSession", "Landroid/util/Pair;", "", "getMatchedFuzzyPaths", "Lcom/tencent/mm/protocal/protobuf/FuzzyPath;", "sessionId", "getMatchingFuzzyPaths", "getReportCache", "Lcom/tencent/mm/protocal/protobuf/FuzzyMatchCache;", "match", "state", "Lcom/tencent/mm/plugin/expt/hellhound/ext/fuzzymatch/MatchState;", "mmProcessRestartEvent", "resetFuzzyDaoOnSessionStart", "resetReportCache", "updateSessionFuzzyPath", "sessionFuzzyPath", "index", "plugin-expt_release"})
public final class a
{
  private static boolean wnQ;
  public static final a wnR;
  
  static
  {
    AppMethodBeat.i(122574);
    wnR = new a();
    AppMethodBeat.o(122574);
  }
  
  private static void JD(long paramLong)
  {
    AppMethodBeat.i(184280);
    e.a locala = e.wnU;
    e.a.JE(paramLong);
    AppMethodBeat.o(184280);
  }
  
  private static ArrayList<Long> a(String paramString, efg paramefg, long paramLong)
  {
    AppMethodBeat.i(184277);
    ArrayList localArrayList = new ArrayList();
    int i = paramefg.SXQ.size() - 1;
    if (i >= 0)
    {
      Object localObject = paramefg.SXQ.get(i);
      p.j(localObject, "sessionPath.paths[i]");
      localObject = (bnc)localObject;
      bnb localbnb;
      if (((bnc)localObject).SXY.size() == 1) {
        if (((bnc)localObject).SXW.isEmpty())
        {
          localbnb = new bnb();
          localbnb.name = paramString;
          localbnb.startTime = paramLong;
          ((bnc)localObject).SXY.addLast(localbnb);
          localArrayList.add(Long.valueOf(((bnc)localObject).SYb));
          Log.i("HABBYGE-MALI.FuzzyMatch", "_updatePath: " + ((bnc)localObject).SYb + ", " + paramString);
        }
      }
      for (;;)
      {
        i -= 1;
        break;
        if (((bnc)localObject).SXW.size() == 1)
        {
          if (p.h(((bnc)localObject).SXX.fFe, paramString))
          {
            localbnb = new bnb();
            localbnb.name = paramString;
            localbnb.startTime = paramLong;
            ((bnc)localObject).SXY.addLast(localbnb);
            localArrayList.add(Long.valueOf(((bnc)localObject).SYb));
            Log.i("HABBYGE-MALI.FuzzyMatch", "_updatePath, =1: " + ((bnc)localObject).SYb + ", " + paramString);
          }
          else if (p.h(((efi)((bnc)localObject).SXW.get(0)).fFe, paramString))
          {
            ((bnc)localObject).SXY.clear();
            localbnb = new bnb();
            localbnb.name = paramString;
            localbnb.startTime = paramLong;
            ((bnc)localObject).SXY.addLast(localbnb);
            localArrayList.add(Long.valueOf(((bnc)localObject).SYb));
          }
          else
          {
            paramefg.SXQ.remove(i);
          }
        }
        else if (p.h(((efi)((bnc)localObject).SXW.get(1)).fFe, paramString))
        {
          localbnb = new bnb();
          localbnb.name = paramString;
          localbnb.startTime = paramLong;
          ((bnc)localObject).SXY.addLast(localbnb);
          localArrayList.add(Long.valueOf(((bnc)localObject).SYb));
        }
        else if (p.h(((efi)((bnc)localObject).SXW.get(0)).fFe, paramString))
        {
          ((bnc)localObject).SXY.clear();
          localbnb = new bnb();
          localbnb.name = paramString;
          localbnb.startTime = paramLong;
          ((bnc)localObject).SXY.addLast(localbnb);
          localArrayList.add(Long.valueOf(((bnc)localObject).SYb));
        }
        else
        {
          paramefg.SXQ.remove(i);
          continue;
          if ((((bnc)localObject).SXY.size() > 1) && (((bnc)localObject).SXZ)) {
            if (((bnc)localObject).SXW.isEmpty())
            {
              localbnb = new bnb();
              localbnb.name = paramString;
              localbnb.startTime = paramLong;
              ((bnc)localObject).SXY.addLast(localbnb);
              Log.i("HABBYGE-MALI.FuzzyMatch", "_updatePath, =1: " + ((bnc)localObject).SYb + ", " + paramString);
              localArrayList.add(Long.valueOf(((bnc)localObject).SYb));
            }
            else if (((bnc)localObject).SXW.size() == 1)
            {
              localbnb = new bnb();
              localbnb.name = paramString;
              localbnb.startTime = paramLong;
              ((bnc)localObject).SXY.addLast(localbnb);
              Log.i("HABBYGE-MALI.FuzzyMatch", "_updatePath, =2: " + ((bnc)localObject).SYb + ", " + paramString);
              localArrayList.add(Long.valueOf(((bnc)localObject).SYb));
            }
            else if (((bnc)localObject).SXY.size() > ((bnc)localObject).SXW.size())
            {
              localbnb = new bnb();
              localbnb.name = paramString;
              localbnb.startTime = paramLong;
              ((bnc)localObject).SXY.addLast(localbnb);
              Log.i("HABBYGE-MALI.FuzzyMatch", "_updatePath, >2: " + ((bnc)localObject).SYb + ", " + paramString);
              localArrayList.add(Long.valueOf(((bnc)localObject).SYb));
            }
            else if (((bnc)localObject).SXY.size() == ((bnc)localObject).SXW.size())
            {
              if (p.h(((bnc)localObject).SXX.fFe, paramString))
              {
                localbnb = new bnb();
                localbnb.name = paramString;
                localbnb.startTime = paramLong;
                ((bnc)localObject).SXY.addLast(localbnb);
                localArrayList.add(Long.valueOf(((bnc)localObject).SYb));
                Log.i("HABBYGE-MALI.FuzzyMatch", "_updatePath, >=2: " + ((bnc)localObject).SYb + ", " + paramString);
              }
              else if (p.h(((efi)((bnc)localObject).SXW.get(0)).fFe, paramString))
              {
                ((bnc)localObject).SXY.clear();
                localbnb = new bnb();
                localbnb.name = paramString;
                localbnb.startTime = paramLong;
                ((bnc)localObject).SXY.addLast(localbnb);
                localArrayList.add(Long.valueOf(((bnc)localObject).SYb));
              }
              else
              {
                paramefg.SXQ.remove(i);
              }
            }
            else if (p.h(((efi)((bnc)localObject).SXW.get(((bnc)localObject).SXY.size())).fFe, paramString))
            {
              localbnb = new bnb();
              localbnb.name = paramString;
              localbnb.startTime = paramLong;
              ((bnc)localObject).SXY.addLast(localbnb);
              localArrayList.add(Long.valueOf(((bnc)localObject).SYb));
            }
            else if (p.h(((efi)((bnc)localObject).SXW.get(0)).fFe, paramString))
            {
              ((bnc)localObject).SXY.clear();
              localbnb = new bnb();
              localbnb.name = paramString;
              localbnb.startTime = paramLong;
              ((bnc)localObject).SXY.addLast(localbnb);
              localArrayList.add(Long.valueOf(((bnc)localObject).SYb));
            }
            else
            {
              paramefg.SXQ.remove(i);
            }
          }
        }
      }
    }
    paramString = d.wnT;
    d.a.a(paramefg);
    AppMethodBeat.o(184277);
    return localArrayList;
  }
  
  public static void a(efg paramefg, int paramInt)
  {
    AppMethodBeat.i(251077);
    d.a locala = d.wnT;
    d.a.b(paramefg, paramInt);
    AppMethodBeat.o(251077);
  }
  
  private static void a(String paramString1, efi paramefi1, efi paramefi2, long paramLong, efm paramefm, String paramString2)
  {
    AppMethodBeat.i(251068);
    bnc localbnc = new bnc();
    localbnc.fLj = paramString1;
    localbnc.SXW.add(paramefi1);
    localbnc.SXX = paramefi2;
    localbnc.SXZ = true;
    localbnc.Aaj = paramefm.Aaj;
    localbnc.SYa = paramefm.SYa;
    localbnc.SYb = paramefm.SYb;
    paramefi1 = new bnb();
    paramefi1.name = paramString2;
    paramefi1.startTime = paramLong;
    localbnc.SXY.addLast(paramefi1);
    paramefi1 = d.wnT;
    paramefi1 = d.a.ayg(paramString1);
    ((efg)paramefi1.first).SXQ.addLast(localbnc);
    ((efg)paramefi1.first).fLj = paramString1;
    paramString1 = d.wnT;
    paramString1 = (efg)paramefi1.first;
    paramefi1 = paramefi1.second;
    p.j(paramefi1, "curSessionPathPair.second");
    d.a.b(paramString1, ((Number)paramefi1).intValue());
    AppMethodBeat.o(251068);
  }
  
  private static void a(String paramString1, efi paramefi, efm paramefm, String paramString2, long paramLong)
  {
    AppMethodBeat.i(251066);
    bnc localbnc = new bnc();
    localbnc.fLj = paramString1;
    localbnc.SXX = paramefi;
    localbnc.SXZ = true;
    localbnc.Aaj = paramefm.Aaj;
    localbnc.SYa = paramefm.SYa;
    localbnc.SYb = paramefm.SYb;
    paramefi = new bnb();
    paramefi.name = paramString2;
    paramefi.startTime = paramLong;
    localbnc.SXY.addLast(paramefi);
    paramefi = d.wnT;
    paramefi = d.a.ayg(paramString1);
    ((efg)paramefi.first).SXQ.addLast(localbnc);
    ((efg)paramefi.first).fLj = paramString1;
    paramString1 = d.wnT;
    paramString1 = (efg)paramefi.first;
    paramefi = paramefi.second;
    p.j(paramefi, "curSessionPathPair.second");
    d.a.b(paramString1, ((Number)paramefi).intValue());
    AppMethodBeat.o(251066);
  }
  
  private final void a(String paramString1, String paramString2, long paramLong, ArrayList<efm> paramArrayList)
  {
    AppMethodBeat.i(184275);
    Object localObject = d.wnT;
    localObject = d.a.ayg(paramString2);
    if (((efg)((Pair)localObject).first).SXQ.isEmpty())
    {
      a(paramString1, paramString2, paramLong, paramArrayList, new ArrayList());
      AppMethodBeat.o(184275);
      return;
    }
    localObject = ((Pair)localObject).first;
    p.j(localObject, "sessionPathPair.first");
    a(paramString1, paramString2, (efg)localObject, paramLong, paramArrayList);
    AppMethodBeat.o(184275);
  }
  
  private static void a(String paramString1, String paramString2, long paramLong, ArrayList<efm> paramArrayList, ArrayList<Long> paramArrayList1)
  {
    AppMethodBeat.i(184278);
    paramArrayList = paramArrayList.iterator();
    while (paramArrayList.hasNext())
    {
      efm localefm = (efm)paramArrayList.next();
      if (!paramArrayList1.contains(Long.valueOf(localefm.SYb))) {
        if (localefm.UiM.size() == 1)
        {
          p.j(localefm, "pathConfig");
          a(paramString1, paramString2, localefm, paramLong);
        }
        else
        {
          Object localObject1;
          Object localObject2;
          if (localefm.UiM.size() == 2)
          {
            localObject1 = (efi)localefm.UiM.get(0);
            localObject2 = (efi)localefm.UiM.get(1);
            if (p.h(paramString1, ((efi)localObject1).fFe))
            {
              p.j(localObject1, "prePageConfig");
              p.j(localObject2, "curPageConfig");
              p.j(localefm, "pathConfig");
              a(paramString2, (efi)localObject1, (efi)localObject2, paramLong, localefm, paramString1);
            }
          }
          else
          {
            localObject1 = localefm.UiM.subList(0, localefm.UiM.size() - 1);
            p.j(localObject1, "pathConfig.pagePathUnits…g.pagePathUnits.size - 1)");
            localObject2 = localefm.UiM;
            p.j(localObject2, "pathConfig.pagePathUnits");
            localObject2 = (efi)((LinkedList)localObject2).getLast();
            if (p.h(paramString1, ((efi)((List)localObject1).get(0)).fFe))
            {
              p.j(localObject2, "curPageConfig");
              p.j(localefm, "pathConfig");
              a(paramString2, (List)localObject1, paramLong, (efi)localObject2, localefm, paramString1);
            }
          }
        }
      }
    }
    AppMethodBeat.o(184278);
  }
  
  private final void a(String paramString1, String paramString2, efg paramefg, long paramLong, ArrayList<efm> paramArrayList)
  {
    AppMethodBeat.i(184276);
    a(paramString1, paramString2, paramLong, paramArrayList, a(paramString1, paramefg, paramLong));
    AppMethodBeat.o(184276);
  }
  
  private static void a(String paramString1, String paramString2, efm paramefm, long paramLong)
  {
    AppMethodBeat.i(251063);
    efi localefi = (efi)paramefm.UiM.get(0);
    if (localefi == null)
    {
      AppMethodBeat.o(251063);
      return;
    }
    if (p.h(paramString1, localefi.fFe)) {
      a(paramString2, localefi, paramefm, paramString1, paramLong);
    }
    AppMethodBeat.o(251063);
  }
  
  private static void a(String paramString1, List<? extends efi> paramList, long paramLong, efi paramefi, efm paramefm, String paramString2)
  {
    AppMethodBeat.i(251069);
    bnc localbnc = new bnc();
    localbnc.fLj = paramString1;
    localbnc.SXW.addAll((Collection)paramList);
    localbnc.SXX = paramefi;
    localbnc.SXZ = true;
    localbnc.Aaj = paramefm.Aaj;
    localbnc.SYa = paramefm.SYa;
    localbnc.SYb = paramefm.SYb;
    paramList = new bnb();
    paramList.name = paramString2;
    paramList.startTime = paramLong;
    localbnc.SXY.addLast(paramList);
    paramList = d.wnT;
    paramList = d.a.ayg(paramString1);
    ((efg)paramList.first).SXQ.addLast(localbnc);
    ((efg)paramList.first).fLj = paramString1;
    paramString1 = d.wnT;
    paramString1 = (efg)paramList.first;
    paramList = paramList.second;
    p.j(paramList, "curSessionPathPair.second");
    d.a.b(paramString1, ((Number)paramList).intValue());
    AppMethodBeat.o(251069);
  }
  
  private final void ah(String paramString, long paramLong)
  {
    AppMethodBeat.i(184274);
    Object localObject1 = det();
    if (localObject1 == null)
    {
      AppMethodBeat.o(184274);
      return;
    }
    String str = (String)((com.tencent.mm.vending.j.c)localObject1).ieT();
    localObject1 = (ArrayList)((com.tencent.mm.vending.j.c)localObject1).ieU();
    if (localObject1 == null)
    {
      AppMethodBeat.o(184274);
      return;
    }
    Object localObject2 = d.wnT;
    localObject2 = d.a.dex();
    if ((localObject2 == null) || (((bna)localObject2).SXR.isEmpty()))
    {
      p.j(str, "curSessionId");
      a(paramString, str, paramLong, (ArrayList)localObject1, new ArrayList());
      AppMethodBeat.o(184274);
      return;
    }
    p.j(str, "curSessionId");
    a(paramString, str, paramLong, (ArrayList)localObject1);
    AppMethodBeat.o(184274);
  }
  
  public static void aya(String paramString)
  {
    AppMethodBeat.i(169394);
    Log.i("HABBYGE-MALI.FuzzyMatch", "resetFuzzyDaoOnStart: ".concat(String.valueOf(paramString)));
    if (paramString == null)
    {
      AppMethodBeat.o(169394);
      return;
    }
    Object localObject1 = d.wnT;
    p.k(paramString, "curSessionId");
    localObject1 = d.a.dex();
    if (localObject1 != null)
    {
      int i = ((bna)localObject1).SXR.size() - 1;
      while (i >= 0)
      {
        Object localObject2 = ((bna)localObject1).SXR.get(i);
        p.j(localObject2, "matchInfo.sessionFuzzyPaths[i]");
        localObject2 = (efg)localObject2;
        if (!p.h(paramString, ((efg)localObject2).fLj))
        {
          Log.i("HABBYGE-MALI.FuzzyMatchDao", "resetOnStart, need remove: " + ((efg)localObject2).fLj);
          int j = ((efg)localObject2).SXQ.size() - 1;
          while (j >= 0)
          {
            Object localObject3 = ((efg)localObject2).SXQ.get(j);
            p.j(localObject3, "sessionPath.paths[j]");
            if (((bnc)localObject3).SXZ)
            {
              Log.i("HABBYGE-MALI.FuzzyMatchDao", "resetOnStart, real remove: " + ((efg)localObject2).fLj);
              ((efg)localObject2).SXQ.remove(j);
            }
            j -= 1;
          }
          if (((efg)localObject2).SXQ.isEmpty()) {
            ((bna)localObject1).SXR.remove(i);
          }
        }
        i -= 1;
      }
      d.a.a((bna)localObject1);
    }
    paramString = f.wnV;
    f.a.reset();
    paramString = j.woH;
    j.a.reset();
    AppMethodBeat.o(169394);
  }
  
  public static List<bnc> ayb(String paramString)
  {
    AppMethodBeat.i(122573);
    ArrayList localArrayList = new ArrayList();
    Object localObject = d.wnT;
    paramString = d.a.ayf(paramString);
    if (paramString == null)
    {
      AppMethodBeat.o(122573);
      return null;
    }
    paramString = paramString.SXQ.iterator();
    while (paramString.hasNext())
    {
      localObject = (bnc)paramString.next();
      if (((bnc)localObject).SXZ) {
        localArrayList.add(localObject);
      }
    }
    paramString = (List)localArrayList;
    AppMethodBeat.o(122573);
    return paramString;
  }
  
  public static List<bnc> ayc(String paramString)
  {
    AppMethodBeat.i(185590);
    ArrayList localArrayList = new ArrayList();
    Object localObject = d.wnT;
    localObject = d.a.ayf(paramString);
    bnc localbnc;
    if (localObject != null)
    {
      localObject = ((efg)localObject).SXQ.iterator();
      while (((Iterator)localObject).hasNext())
      {
        localbnc = (bnc)((Iterator)localObject).next();
        if (!localbnc.SXZ) {
          localArrayList.add(localbnc);
        }
      }
    }
    localObject = f.wnV;
    localObject = f.a.ayh(paramString);
    if (localObject != null)
    {
      localObject = ((efg)localObject).SXQ.iterator();
      while (((Iterator)localObject).hasNext())
      {
        localbnc = (bnc)((Iterator)localObject).next();
        if (!localbnc.SXZ) {
          localArrayList.add(localbnc);
        }
      }
    }
    localObject = f.wnV;
    f.a.asv(paramString);
    paramString = (List)localArrayList;
    AppMethodBeat.o(185590);
    return paramString;
  }
  
  private static boolean ayd(String paramString)
  {
    AppMethodBeat.i(169395);
    boolean bool = p.h(paramString, "com.tencent.mm.ui.LauncherUI");
    AppMethodBeat.o(169395);
    return bool ^ true;
  }
  
  private static void c(String paramString, boolean paramBoolean, long paramLong)
  {
    AppMethodBeat.i(184279);
    if (((paramBoolean) || (com.tencent.mm.plugin.expt.hellhound.core.b.awR(paramString))) && (wnQ))
    {
      wnQ = false;
      AppMethodBeat.o(184279);
      return;
    }
    Object localObject1 = com.tencent.mm.plugin.expt.hellhound.a.f.b.b.wov;
    localObject1 = com.tencent.mm.plugin.expt.hellhound.a.f.c.c.dfj();
    if (localObject1 == null) {}
    for (localObject1 = null; localObject1 == null; localObject1 = ((dhx)localObject1).sessionId)
    {
      Log.w("HABBYGE-MALI.FuzzyMatch", "_matchOnFinish: curSession == null");
      AppMethodBeat.o(184279);
      return;
    }
    Object localObject2 = d.wnT;
    localObject1 = d.a.ayf((String)localObject1);
    if (localObject1 == null)
    {
      Log.w("HABBYGE-MALI.FuzzyMatch", "_matchOnFinish: sessionMatch == null");
      AppMethodBeat.o(184279);
      return;
    }
    localObject2 = ((efg)localObject1).SXQ.iterator();
    while (((Iterator)localObject2).hasNext())
    {
      bnc localbnc = (bnc)((Iterator)localObject2).next();
      Object localObject3;
      if (localbnc.SXZ)
      {
        localObject3 = com.tencent.mm.plugin.expt.hellhound.core.b.awD(localbnc.SXX.fFe);
        if ((p.h(paramString, localbnc.SXX.fFe)) || (p.h(paramString, localObject3)))
        {
          localbnc.SXZ = false;
          localObject3 = e.wnU;
          e.a.a(localbnc, paramLong);
        }
      }
      else
      {
        int i = localbnc.SXY.size() - 1;
        label223:
        long l;
        if (i >= 0)
        {
          localObject3 = (bnb)localbnc.SXY.get(i);
          if (localObject3 != null)
          {
            String str = com.tencent.mm.plugin.expt.hellhound.core.b.awD(((bnb)localObject3).name);
            if (((p.h(paramString, ((bnb)localObject3).name)) || (p.h(paramString, str))) && (((bnb)localObject3).SXT <= 0L))
            {
              l = paramLong - ((bnb)localObject3).startTime;
              if (l < 0L) {
                break label321;
              }
            }
          }
        }
        for (;;)
        {
          ((bnb)localObject3).SXT = l;
          i -= 1;
          break label223;
          break;
          label321:
          l = 0L;
        }
      }
    }
    paramString = d.wnT;
    d.a.a((efg)localObject1);
    AppMethodBeat.o(184279);
  }
  
  private static void des()
  {
    AppMethodBeat.i(169392);
    Object localObject = d.wnT;
    d.a.reset();
    localObject = f.wnV;
    f.a.reset();
    localObject = j.woH;
    j.a.reset();
    AppMethodBeat.o(169392);
  }
  
  private static com.tencent.mm.vending.j.c<String, ArrayList<efm>> det()
  {
    AppMethodBeat.i(169393);
    Object localObject1 = com.tencent.mm.plugin.expt.hellhound.a.f.b.b.wov;
    localObject1 = b.a.deT();
    if (localObject1 == null)
    {
      AppMethodBeat.o(169393);
      return null;
    }
    Object localObject2 = com.tencent.mm.plugin.expt.hellhound.a.f.b.b.wov;
    localObject2 = b.a.ayn((String)localObject1);
    if (localObject2 == null)
    {
      AppMethodBeat.o(169393);
      return null;
    }
    c.a locala = c.wnS;
    localObject2 = c.a.aye((String)localObject2);
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
    localObject1 = com.tencent.mm.vending.j.a.J(localObject1, localObject2);
    AppMethodBeat.o(169393);
    return localObject1;
  }
  
  public static void deu()
  {
    AppMethodBeat.i(122571);
    Log.i("HABBYGE-MALI.FuzzyMatch", "resetReportCache");
    e.a locala = e.wnU;
    com.tencent.mm.plugin.expt.hellhound.core.a.b.r("mmkv_fuzzy_mc_rpt", new byte[0]);
    AppMethodBeat.o(122571);
  }
  
  public static bmz dev()
  {
    AppMethodBeat.i(122572);
    Object localObject = e.wnU;
    localObject = e.a.dey();
    AppMethodBeat.o(122572);
    return localObject;
  }
  
  public static Pair<efg, Integer> dew()
  {
    AppMethodBeat.i(251075);
    Object localObject1 = com.tencent.mm.plugin.expt.hellhound.a.f.b.deI();
    p.j(localObject1, "HellSessionMonitor.getInstance()");
    String str = ((com.tencent.mm.plugin.expt.hellhound.a.f.b)localObject1).deL();
    localObject1 = d.wnT;
    p.j(str, "curSessionid");
    p.k(str, "sessionId");
    localObject1 = d.a.dex();
    if (localObject1 == null) {
      localObject1 = new bna();
    }
    for (;;)
    {
      int i = ((bna)localObject1).SXR.size() - 1;
      while (i >= 0)
      {
        Object localObject2 = ((bna)localObject1).SXR.get(i);
        p.j(localObject2, "fuzzyMatchInfo.sessionFuzzyPaths[i]");
        localObject2 = (efg)localObject2;
        if (p.h(str, ((efg)localObject2).fLj))
        {
          localObject1 = Pair.create(localObject2, Integer.valueOf(i));
          AppMethodBeat.o(251075);
          return localObject1;
        }
        i -= 1;
      }
      AppMethodBeat.o(251075);
      return null;
    }
  }
  
  public final void a(String paramString, long paramLong, g paramg)
  {
    AppMethodBeat.i(184273);
    p.k(paramg, "state");
    if (paramString == null)
    {
      Log.i("HABBYGE-MALI.FuzzyMatch", "match: page is: ".concat(String.valueOf(paramString)));
      AppMethodBeat.o(184273);
      return;
    }
    b.a locala = com.tencent.mm.plugin.expt.hellhound.a.f.b.b.wov;
    if (b.a.deR())
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
          } while (!ayd(paramString));
          ah(paramString, paramLong);
          AppMethodBeat.o(184273);
          return;
        } while (!ayd(paramString));
        c(paramString, false, paramLong);
        AppMethodBeat.o(184273);
        return;
      } while (!ayd(paramString));
      c(paramString, false, paramLong);
      AppMethodBeat.o(184273);
      return;
    case 4: 
      c(paramString, true, paramLong);
      AppMethodBeat.o(184273);
      return;
    case 5: 
      wnQ = true;
      JD(paramLong);
      AppMethodBeat.o(184273);
      return;
    }
    des();
    AppMethodBeat.o(184273);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.expt.hellhound.a.d.a
 * JD-Core Version:    0.7.0.1
 */