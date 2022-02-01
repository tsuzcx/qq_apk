package com.tencent.mm.plugin.expt.hellhound.a.d;

import android.util.Pair;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.expt.hellhound.a.f.b.b.a;
import com.tencent.mm.plugin.expt.hellhound.a.f.c.j;
import com.tencent.mm.plugin.expt.hellhound.a.f.c.j.a;
import com.tencent.mm.protocal.protobuf.aup;
import com.tencent.mm.protocal.protobuf.auq;
import com.tencent.mm.protocal.protobuf.aur;
import com.tencent.mm.protocal.protobuf.aus;
import com.tencent.mm.protocal.protobuf.cie;
import com.tencent.mm.protocal.protobuf.dca;
import com.tencent.mm.protocal.protobuf.dcc;
import com.tencent.mm.protocal.protobuf.dcg;
import com.tencent.mm.sdk.platformtools.ae;
import d.g.b.p;
import d.l;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/expt/hellhound/ext/fuzzymatch/FuzzyMatch;", "", "()V", "TAG", "", "is8EventForFragment", "", "_addPage", "", "curSessionId", "curPageConfig", "Lcom/tencent/mm/protocal/protobuf/SessionPage;", "pathConfig", "Lcom/tencent/mm/protocal/protobuf/SessionPagePath;", "curPage", "timestamp", "", "_addPrePage", "prePageConfig", "expctPageConfig", "_addPrePage2", "prePagesConfig", "", "_doNewMatch", "curCloudConfig", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "matchingPathIds", "_doNewMatch1Page", "_getCloudConfig", "Lcom/tencent/mm/vending/tuple/Tuple2;", "_isPageLegal", "pageName", "_matchOn8Event", "_matchOnFinish", "onSessionClose", "_matchOnNot1stOnResume", "_matchOnResume", "_matchOnSessionNot1STOnResume", "sessionPath", "Lcom/tencent/mm/protocal/protobuf/SessionFuzzyPath;", "_updatePath", "getFuzzyPathOfCurSession", "Landroid/util/Pair;", "", "getMatchedFuzzyPaths", "Lcom/tencent/mm/protocal/protobuf/FuzzyPath;", "sessionId", "getMatchingFuzzyPaths", "getReportCache", "Lcom/tencent/mm/protocal/protobuf/FuzzyMatchCache;", "match", "state", "Lcom/tencent/mm/plugin/expt/hellhound/ext/fuzzymatch/MatchState;", "mmProcessRestartEvent", "resetFuzzyDaoOnSessionStart", "resetReportCache", "updateSessionFuzzyPath", "sessionFuzzyPath", "index", "plugin-expt_release"})
public final class a
{
  public static final a rgA;
  private static boolean rgz;
  
  static
  {
    AppMethodBeat.i(122574);
    rgA = new a();
    AppMethodBeat.o(122574);
  }
  
  private static ArrayList<Long> a(String paramString, dca paramdca, long paramLong)
  {
    AppMethodBeat.i(184277);
    ArrayList localArrayList = new ArrayList();
    int i = paramdca.GLy.size() - 1;
    if (i >= 0)
    {
      Object localObject = paramdca.GLy.get(i);
      p.g(localObject, "sessionPath.paths[i]");
      localObject = (aus)localObject;
      aur localaur;
      if (((aus)localObject).GLG.size() == 1) {
        if (((aus)localObject).GLE.isEmpty())
        {
          localaur = new aur();
          localaur.name = paramString;
          localaur.startTime = paramLong;
          ((aus)localObject).GLG.addLast(localaur);
          localArrayList.add(Long.valueOf(((aus)localObject).GLJ));
          ae.i("HABBYGE-MALI.FuzzyMatch", "_updatePath: " + ((aus)localObject).GLJ + ", " + paramString);
        }
      }
      for (;;)
      {
        i -= 1;
        break;
        if (((aus)localObject).GLE.size() == 1)
        {
          if (p.i(((aus)localObject).GLF.duQ, paramString))
          {
            localaur = new aur();
            localaur.name = paramString;
            localaur.startTime = paramLong;
            ((aus)localObject).GLG.addLast(localaur);
            localArrayList.add(Long.valueOf(((aus)localObject).GLJ));
            ae.i("HABBYGE-MALI.FuzzyMatch", "_updatePath, =1: " + ((aus)localObject).GLJ + ", " + paramString);
          }
          else if (p.i(((dcc)((aus)localObject).GLE.get(0)).duQ, paramString))
          {
            ((aus)localObject).GLG.clear();
            localaur = new aur();
            localaur.name = paramString;
            localaur.startTime = paramLong;
            ((aus)localObject).GLG.addLast(localaur);
            localArrayList.add(Long.valueOf(((aus)localObject).GLJ));
          }
          else
          {
            paramdca.GLy.remove(i);
          }
        }
        else if (p.i(((dcc)((aus)localObject).GLE.get(1)).duQ, paramString))
        {
          localaur = new aur();
          localaur.name = paramString;
          localaur.startTime = paramLong;
          ((aus)localObject).GLG.addLast(localaur);
          localArrayList.add(Long.valueOf(((aus)localObject).GLJ));
        }
        else if (p.i(((dcc)((aus)localObject).GLE.get(0)).duQ, paramString))
        {
          ((aus)localObject).GLG.clear();
          localaur = new aur();
          localaur.name = paramString;
          localaur.startTime = paramLong;
          ((aus)localObject).GLG.addLast(localaur);
          localArrayList.add(Long.valueOf(((aus)localObject).GLJ));
        }
        else
        {
          paramdca.GLy.remove(i);
          continue;
          if ((((aus)localObject).GLG.size() > 1) && (((aus)localObject).GLH)) {
            if (((aus)localObject).GLE.isEmpty())
            {
              localaur = new aur();
              localaur.name = paramString;
              localaur.startTime = paramLong;
              ((aus)localObject).GLG.addLast(localaur);
              ae.i("HABBYGE-MALI.FuzzyMatch", "_updatePath, =1: " + ((aus)localObject).GLJ + ", " + paramString);
              localArrayList.add(Long.valueOf(((aus)localObject).GLJ));
            }
            else if (((aus)localObject).GLE.size() == 1)
            {
              localaur = new aur();
              localaur.name = paramString;
              localaur.startTime = paramLong;
              ((aus)localObject).GLG.addLast(localaur);
              ae.i("HABBYGE-MALI.FuzzyMatch", "_updatePath, =2: " + ((aus)localObject).GLJ + ", " + paramString);
              localArrayList.add(Long.valueOf(((aus)localObject).GLJ));
            }
            else if (((aus)localObject).GLG.size() > ((aus)localObject).GLE.size())
            {
              localaur = new aur();
              localaur.name = paramString;
              localaur.startTime = paramLong;
              ((aus)localObject).GLG.addLast(localaur);
              ae.i("HABBYGE-MALI.FuzzyMatch", "_updatePath, >2: " + ((aus)localObject).GLJ + ", " + paramString);
              localArrayList.add(Long.valueOf(((aus)localObject).GLJ));
            }
            else if (((aus)localObject).GLG.size() == ((aus)localObject).GLE.size())
            {
              if (p.i(((aus)localObject).GLF.duQ, paramString))
              {
                localaur = new aur();
                localaur.name = paramString;
                localaur.startTime = paramLong;
                ((aus)localObject).GLG.addLast(localaur);
                localArrayList.add(Long.valueOf(((aus)localObject).GLJ));
                ae.i("HABBYGE-MALI.FuzzyMatch", "_updatePath, >=2: " + ((aus)localObject).GLJ + ", " + paramString);
              }
              else if (p.i(((dcc)((aus)localObject).GLE.get(0)).duQ, paramString))
              {
                ((aus)localObject).GLG.clear();
                localaur = new aur();
                localaur.name = paramString;
                localaur.startTime = paramLong;
                ((aus)localObject).GLG.addLast(localaur);
                localArrayList.add(Long.valueOf(((aus)localObject).GLJ));
              }
              else
              {
                paramdca.GLy.remove(i);
              }
            }
            else if (p.i(((dcc)((aus)localObject).GLE.get(((aus)localObject).GLG.size())).duQ, paramString))
            {
              localaur = new aur();
              localaur.name = paramString;
              localaur.startTime = paramLong;
              ((aus)localObject).GLG.addLast(localaur);
              localArrayList.add(Long.valueOf(((aus)localObject).GLJ));
            }
            else if (p.i(((dcc)((aus)localObject).GLE.get(0)).duQ, paramString))
            {
              ((aus)localObject).GLG.clear();
              localaur = new aur();
              localaur.name = paramString;
              localaur.startTime = paramLong;
              ((aus)localObject).GLG.addLast(localaur);
              localArrayList.add(Long.valueOf(((aus)localObject).GLJ));
            }
            else
            {
              paramdca.GLy.remove(i);
            }
          }
        }
      }
    }
    paramString = d.rgC;
    d.a.a(paramdca);
    AppMethodBeat.o(184277);
    return localArrayList;
  }
  
  public static void a(dca paramdca, int paramInt)
  {
    AppMethodBeat.i(196627);
    d.a locala = d.rgC;
    d.a.b(paramdca, paramInt);
    AppMethodBeat.o(196627);
  }
  
  private static void a(String paramString1, dcc paramdcc1, dcc paramdcc2, long paramLong, dcg paramdcg, String paramString2)
  {
    AppMethodBeat.i(196624);
    aus localaus = new aus();
    localaus.dAa = paramString1;
    localaus.GLE.add(paramdcc1);
    localaus.GLF = paramdcc2;
    localaus.GLH = true;
    localaus.sDg = paramdcg.sDg;
    localaus.GLI = paramdcg.GLI;
    localaus.GLJ = paramdcg.GLJ;
    paramdcc1 = new aur();
    paramdcc1.name = paramString2;
    paramdcc1.startTime = paramLong;
    localaus.GLG.addLast(paramdcc1);
    paramdcc1 = d.rgC;
    paramdcc1 = d.a.afv(paramString1);
    ((dca)paramdcc1.first).GLy.addLast(localaus);
    ((dca)paramdcc1.first).dAa = paramString1;
    paramString1 = d.rgC;
    paramString1 = (dca)paramdcc1.first;
    paramdcc1 = paramdcc1.second;
    p.g(paramdcc1, "curSessionPathPair.second");
    d.a.b(paramString1, ((Number)paramdcc1).intValue());
    AppMethodBeat.o(196624);
  }
  
  private static void a(String paramString1, dcc paramdcc, dcg paramdcg, String paramString2, long paramLong)
  {
    AppMethodBeat.i(196623);
    aus localaus = new aus();
    localaus.dAa = paramString1;
    localaus.GLF = paramdcc;
    localaus.GLH = true;
    localaus.sDg = paramdcg.sDg;
    localaus.GLI = paramdcg.GLI;
    localaus.GLJ = paramdcg.GLJ;
    paramdcc = new aur();
    paramdcc.name = paramString2;
    paramdcc.startTime = paramLong;
    localaus.GLG.addLast(paramdcc);
    paramdcc = d.rgC;
    paramdcc = d.a.afv(paramString1);
    ((dca)paramdcc.first).GLy.addLast(localaus);
    ((dca)paramdcc.first).dAa = paramString1;
    paramString1 = d.rgC;
    paramString1 = (dca)paramdcc.first;
    paramdcc = paramdcc.second;
    p.g(paramdcc, "curSessionPathPair.second");
    d.a.b(paramString1, ((Number)paramdcc).intValue());
    AppMethodBeat.o(196623);
  }
  
  private static void a(String paramString1, String paramString2, long paramLong, ArrayList<dcg> paramArrayList)
  {
    AppMethodBeat.i(184275);
    Object localObject = d.rgC;
    localObject = d.a.afv(paramString2);
    if (((dca)((Pair)localObject).first).GLy.isEmpty())
    {
      a(paramString1, paramString2, paramLong, paramArrayList, new ArrayList());
      AppMethodBeat.o(184275);
      return;
    }
    localObject = ((Pair)localObject).first;
    p.g(localObject, "sessionPathPair.first");
    a(paramString1, paramString2, (dca)localObject, paramLong, paramArrayList);
    AppMethodBeat.o(184275);
  }
  
  private static void a(String paramString1, String paramString2, long paramLong, ArrayList<dcg> paramArrayList, ArrayList<Long> paramArrayList1)
  {
    AppMethodBeat.i(184278);
    paramArrayList = paramArrayList.iterator();
    while (paramArrayList.hasNext())
    {
      dcg localdcg = (dcg)paramArrayList.next();
      if (!paramArrayList1.contains(Long.valueOf(localdcg.GLJ))) {
        if (localdcg.HKI.size() == 1)
        {
          p.g(localdcg, "pathConfig");
          a(paramString1, paramString2, localdcg, paramLong);
        }
        else
        {
          Object localObject1;
          Object localObject2;
          if (localdcg.HKI.size() == 2)
          {
            localObject1 = (dcc)localdcg.HKI.get(0);
            localObject2 = (dcc)localdcg.HKI.get(1);
            if (p.i(paramString1, ((dcc)localObject1).duQ))
            {
              p.g(localObject1, "prePageConfig");
              p.g(localObject2, "curPageConfig");
              p.g(localdcg, "pathConfig");
              a(paramString2, (dcc)localObject1, (dcc)localObject2, paramLong, localdcg, paramString1);
            }
          }
          else
          {
            localObject1 = localdcg.HKI.subList(0, localdcg.HKI.size() - 1);
            p.g(localObject1, "pathConfig.pagePathUnits…g.pagePathUnits.size - 1)");
            localObject2 = localdcg.HKI;
            p.g(localObject2, "pathConfig.pagePathUnits");
            localObject2 = (dcc)((LinkedList)localObject2).getLast();
            if (p.i(paramString1, ((dcc)((List)localObject1).get(0)).duQ))
            {
              p.g(localObject2, "curPageConfig");
              p.g(localdcg, "pathConfig");
              a(paramString2, (List)localObject1, paramLong, (dcc)localObject2, localdcg, paramString1);
            }
          }
        }
      }
    }
    AppMethodBeat.o(184278);
  }
  
  private static void a(String paramString1, String paramString2, dca paramdca, long paramLong, ArrayList<dcg> paramArrayList)
  {
    AppMethodBeat.i(184276);
    a(paramString1, paramString2, paramLong, paramArrayList, a(paramString1, paramdca, paramLong));
    AppMethodBeat.o(184276);
  }
  
  private static void a(String paramString1, String paramString2, dcg paramdcg, long paramLong)
  {
    AppMethodBeat.i(196622);
    dcc localdcc = (dcc)paramdcg.HKI.get(0);
    if (localdcc == null)
    {
      AppMethodBeat.o(196622);
      return;
    }
    if (p.i(paramString1, localdcc.duQ)) {
      a(paramString2, localdcc, paramdcg, paramString1, paramLong);
    }
    AppMethodBeat.o(196622);
  }
  
  private static void a(String paramString1, List<? extends dcc> paramList, long paramLong, dcc paramdcc, dcg paramdcg, String paramString2)
  {
    AppMethodBeat.i(196625);
    aus localaus = new aus();
    localaus.dAa = paramString1;
    localaus.GLE.addAll((Collection)paramList);
    localaus.GLF = paramdcc;
    localaus.GLH = true;
    localaus.sDg = paramdcg.sDg;
    localaus.GLI = paramdcg.GLI;
    localaus.GLJ = paramdcg.GLJ;
    paramList = new aur();
    paramList.name = paramString2;
    paramList.startTime = paramLong;
    localaus.GLG.addLast(paramList);
    paramList = d.rgC;
    paramList = d.a.afv(paramString1);
    ((dca)paramList.first).GLy.addLast(localaus);
    ((dca)paramList.first).dAa = paramString1;
    paramString1 = d.rgC;
    paramString1 = (dca)paramList.first;
    paramList = paramList.second;
    p.g(paramList, "curSessionPathPair.second");
    d.a.b(paramString1, ((Number)paramList).intValue());
    AppMethodBeat.o(196625);
  }
  
  public static void afp(String paramString)
  {
    AppMethodBeat.i(169394);
    ae.i("HABBYGE-MALI.FuzzyMatch", "resetFuzzyDaoOnStart: ".concat(String.valueOf(paramString)));
    if (paramString == null)
    {
      AppMethodBeat.o(169394);
      return;
    }
    Object localObject1 = d.rgC;
    p.h(paramString, "curSessionId");
    localObject1 = d.a.cqV();
    if (localObject1 != null)
    {
      int i = ((auq)localObject1).GLz.size() - 1;
      while (i >= 0)
      {
        Object localObject2 = ((auq)localObject1).GLz.get(i);
        p.g(localObject2, "matchInfo.sessionFuzzyPaths[i]");
        localObject2 = (dca)localObject2;
        if (!p.i(paramString, ((dca)localObject2).dAa))
        {
          ae.i("HABBYGE-MALI.FuzzyMatchDao", "resetOnStart, need remove: " + ((dca)localObject2).dAa);
          int j = ((dca)localObject2).GLy.size() - 1;
          while (j >= 0)
          {
            Object localObject3 = ((dca)localObject2).GLy.get(j);
            p.g(localObject3, "sessionPath.paths[j]");
            if (((aus)localObject3).GLH)
            {
              ae.i("HABBYGE-MALI.FuzzyMatchDao", "resetOnStart, real remove: " + ((dca)localObject2).dAa);
              ((dca)localObject2).GLy.remove(j);
            }
            j -= 1;
          }
          if (((dca)localObject2).GLy.isEmpty()) {
            ((auq)localObject1).GLz.remove(i);
          }
        }
        i -= 1;
      }
      d.a.a((auq)localObject1);
    }
    paramString = f.rgE;
    f.a.reset();
    paramString = j.rho;
    j.a.reset();
    AppMethodBeat.o(169394);
  }
  
  public static List<aus> afq(String paramString)
  {
    AppMethodBeat.i(122573);
    ArrayList localArrayList = new ArrayList();
    Object localObject = d.rgC;
    paramString = d.a.afu(paramString);
    if (paramString == null)
    {
      AppMethodBeat.o(122573);
      return null;
    }
    paramString = paramString.GLy.iterator();
    while (paramString.hasNext())
    {
      localObject = (aus)paramString.next();
      if (((aus)localObject).GLH) {
        localArrayList.add(localObject);
      }
    }
    paramString = (List)localArrayList;
    AppMethodBeat.o(122573);
    return paramString;
  }
  
  public static List<aus> afr(String paramString)
  {
    AppMethodBeat.i(185590);
    ArrayList localArrayList = new ArrayList();
    Object localObject = d.rgC;
    localObject = d.a.afu(paramString);
    aus localaus;
    if (localObject != null)
    {
      localObject = ((dca)localObject).GLy.iterator();
      while (((Iterator)localObject).hasNext())
      {
        localaus = (aus)((Iterator)localObject).next();
        if (!localaus.GLH) {
          localArrayList.add(localaus);
        }
      }
    }
    localObject = f.rgE;
    localObject = f.a.afw(paramString);
    if (localObject != null)
    {
      localObject = ((dca)localObject).GLy.iterator();
      while (((Iterator)localObject).hasNext())
      {
        localaus = (aus)((Iterator)localObject).next();
        if (!localaus.GLH) {
          localArrayList.add(localaus);
        }
      }
    }
    localObject = f.rgE;
    f.a.aaB(paramString);
    paramString = (List)localArrayList;
    AppMethodBeat.o(185590);
    return paramString;
  }
  
  private static boolean afs(String paramString)
  {
    AppMethodBeat.i(169395);
    boolean bool = p.i(paramString, "com.tencent.mm.ui.LauncherUI");
    AppMethodBeat.o(169395);
    return bool ^ true;
  }
  
  private final void ah(String paramString, long paramLong)
  {
    AppMethodBeat.i(184274);
    Object localObject1 = cqR();
    if (localObject1 == null)
    {
      AppMethodBeat.o(184274);
      return;
    }
    String str = (String)((com.tencent.mm.vending.j.c)localObject1).fSH();
    localObject1 = (ArrayList)((com.tencent.mm.vending.j.c)localObject1).fSI();
    if (localObject1 == null)
    {
      AppMethodBeat.o(184274);
      return;
    }
    Object localObject2 = d.rgC;
    localObject2 = d.a.cqV();
    if ((localObject2 == null) || (((auq)localObject2).GLz.isEmpty()))
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
    if (((paramBoolean) || (com.tencent.mm.plugin.expt.hellhound.core.b.aeF(paramString))) && (rgz))
    {
      rgz = false;
      AppMethodBeat.o(184279);
      return;
    }
    Object localObject1 = com.tencent.mm.plugin.expt.hellhound.a.f.b.b.rhc;
    localObject1 = com.tencent.mm.plugin.expt.hellhound.a.f.c.c.crH();
    if (localObject1 == null) {}
    for (localObject1 = null; localObject1 == null; localObject1 = ((cie)localObject1).sessionId)
    {
      ae.w("HABBYGE-MALI.FuzzyMatch", "_matchOnFinish: curSession == null");
      AppMethodBeat.o(184279);
      return;
    }
    Object localObject2 = d.rgC;
    localObject1 = d.a.afu((String)localObject1);
    if (localObject1 == null)
    {
      ae.w("HABBYGE-MALI.FuzzyMatch", "_matchOnFinish: sessionMatch == null");
      AppMethodBeat.o(184279);
      return;
    }
    localObject2 = ((dca)localObject1).GLy.iterator();
    while (((Iterator)localObject2).hasNext())
    {
      aus localaus = (aus)((Iterator)localObject2).next();
      Object localObject3;
      if (localaus.GLH)
      {
        localObject3 = com.tencent.mm.plugin.expt.hellhound.core.b.aer(localaus.GLF.duQ);
        if ((p.i(paramString, localaus.GLF.duQ)) || (p.i(paramString, localObject3)))
        {
          localaus.GLH = false;
          localObject3 = e.rgD;
          e.a.a(localaus, paramLong);
        }
      }
      else
      {
        int i = localaus.GLG.size() - 1;
        label223:
        long l;
        if (i >= 0)
        {
          localObject3 = (aur)localaus.GLG.get(i);
          if (localObject3 != null)
          {
            String str = com.tencent.mm.plugin.expt.hellhound.core.b.aer(((aur)localObject3).name);
            if (((p.i(paramString, ((aur)localObject3).name)) || (p.i(paramString, str))) && (((aur)localObject3).GLB <= 0L))
            {
              l = paramLong - ((aur)localObject3).startTime;
              if (l < 0L) {
                break label321;
              }
            }
          }
        }
        for (;;)
        {
          ((aur)localObject3).GLB = l;
          i -= 1;
          break label223;
          break;
          label321:
          l = 0L;
        }
      }
    }
    paramString = d.rgC;
    d.a.a((dca)localObject1);
    AppMethodBeat.o(184279);
  }
  
  private static void cqQ()
  {
    AppMethodBeat.i(169392);
    Object localObject = d.rgC;
    d.a.reset();
    localObject = f.rgE;
    f.a.reset();
    localObject = j.rho;
    j.a.reset();
    AppMethodBeat.o(169392);
  }
  
  private static com.tencent.mm.vending.j.c<String, ArrayList<dcg>> cqR()
  {
    AppMethodBeat.i(169393);
    Object localObject1 = com.tencent.mm.plugin.expt.hellhound.a.f.b.b.rhc;
    localObject1 = b.a.crr();
    if (localObject1 == null)
    {
      AppMethodBeat.o(169393);
      return null;
    }
    Object localObject2 = com.tencent.mm.plugin.expt.hellhound.a.f.b.b.rhc;
    localObject2 = b.a.afC((String)localObject1);
    if (localObject2 == null)
    {
      AppMethodBeat.o(169393);
      return null;
    }
    c.a locala = c.rgB;
    localObject2 = c.a.aft((String)localObject2);
    if (localObject2 == null)
    {
      AppMethodBeat.o(169393);
      return null;
    }
    if (((ArrayList)localObject2).isEmpty())
    {
      ae.w("HABBYGE-MALI.FuzzyMatch", "_getCloudConfig Empty!!");
      AppMethodBeat.o(169393);
      return null;
    }
    localObject1 = com.tencent.mm.vending.j.a.N(localObject1, localObject2);
    AppMethodBeat.o(169393);
    return localObject1;
  }
  
  public static void cqS()
  {
    AppMethodBeat.i(122571);
    ae.i("HABBYGE-MALI.FuzzyMatch", "resetReportCache");
    e.a locala = e.rgD;
    com.tencent.mm.plugin.expt.hellhound.core.a.b.p("mmkv_fuzzy_mc_rpt", new byte[0]);
    AppMethodBeat.o(122571);
  }
  
  public static aup cqT()
  {
    AppMethodBeat.i(122572);
    Object localObject = e.rgD;
    localObject = e.a.cqW();
    AppMethodBeat.o(122572);
    return localObject;
  }
  
  public static Pair<dca, Integer> cqU()
  {
    AppMethodBeat.i(196626);
    Object localObject1 = com.tencent.mm.plugin.expt.hellhound.a.f.b.crg();
    p.g(localObject1, "HellSessionMonitor.getInstance()");
    String str = ((com.tencent.mm.plugin.expt.hellhound.a.f.b)localObject1).crj();
    localObject1 = d.rgC;
    p.g(str, "curSessionid");
    p.h(str, "sessionId");
    localObject1 = d.a.cqV();
    if (localObject1 == null) {
      localObject1 = new auq();
    }
    for (;;)
    {
      int i = ((auq)localObject1).GLz.size() - 1;
      while (i >= 0)
      {
        Object localObject2 = ((auq)localObject1).GLz.get(i);
        p.g(localObject2, "fuzzyMatchInfo.sessionFuzzyPaths[i]");
        localObject2 = (dca)localObject2;
        if (p.i(str, ((dca)localObject2).dAa))
        {
          localObject1 = Pair.create(localObject2, Integer.valueOf(i));
          AppMethodBeat.o(196626);
          return localObject1;
        }
        i -= 1;
      }
      AppMethodBeat.o(196626);
      return null;
    }
  }
  
  private static void vl(long paramLong)
  {
    AppMethodBeat.i(184280);
    e.a locala = e.rgD;
    e.a.vm(paramLong);
    AppMethodBeat.o(184280);
  }
  
  public final void a(String paramString, long paramLong, g paramg)
  {
    AppMethodBeat.i(184273);
    p.h(paramg, "state");
    if (paramString == null)
    {
      ae.i("HABBYGE-MALI.FuzzyMatch", "match: page is: ".concat(String.valueOf(paramString)));
      AppMethodBeat.o(184273);
      return;
    }
    b.a locala = com.tencent.mm.plugin.expt.hellhound.a.f.b.b.rhc;
    if (b.a.crp())
    {
      ae.w("HABBYGE-MALI.FuzzyMatch", "match, doNotNeedSessionMonitor: TRUE");
      AppMethodBeat.o(184273);
      return;
    }
    ae.i("HABBYGE-MALI.FuzzyMatch", "match: " + paramString + ", " + paramg);
    switch (b.cqt[paramg.ordinal()])
    {
    default: 
      ae.e("HABBYGE-MALI.FuzzyMatch", "match ~");
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
          } while (!afs(paramString));
          ah(paramString, paramLong);
          AppMethodBeat.o(184273);
          return;
        } while (!afs(paramString));
        c(paramString, false, paramLong);
        AppMethodBeat.o(184273);
        return;
      } while (!afs(paramString));
      c(paramString, false, paramLong);
      AppMethodBeat.o(184273);
      return;
    case 4: 
      c(paramString, true, paramLong);
      AppMethodBeat.o(184273);
      return;
    case 5: 
      rgz = true;
      vl(paramLong);
      AppMethodBeat.o(184273);
      return;
    }
    cqQ();
    AppMethodBeat.o(184273);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.expt.hellhound.a.d.a
 * JD-Core Version:    0.7.0.1
 */