package com.tencent.mm.plugin.expt.hellhound.ext.d;

import android.util.Pair;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.expt.hellhound.ext.session.b.j;
import com.tencent.mm.plugin.expt.hellhound.ext.session.b.j.a;
import com.tencent.mm.protocal.protobuf.cat;
import com.tencent.mm.protocal.protobuf.cau;
import com.tencent.mm.protocal.protobuf.cav;
import com.tencent.mm.protocal.protobuf.caw;
import com.tencent.mm.protocal.protobuf.czw;
import com.tencent.mm.protocal.protobuf.eah;
import com.tencent.mm.protocal.protobuf.eyz;
import com.tencent.mm.protocal.protobuf.ezb;
import com.tencent.mm.protocal.protobuf.ezf;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/expt/hellhound/ext/fuzzymatch/FuzzyMatch;", "", "()V", "TAG", "", "is8EventForFragment", "", "_addPage", "", "curSessionId", "curPageConfig", "Lcom/tencent/mm/protocal/protobuf/SessionPage;", "pathConfig", "Lcom/tencent/mm/protocal/protobuf/SessionPagePath;", "curPage", "timestamp", "", "_addPrePage", "prePageConfig", "expctPageConfig", "_addPrePage2", "prePagesConfig", "", "_doNewMatch", "curCloudConfig", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "matchingPathIds", "_doNewMatch1Page", "_getCloudConfig", "Lcom/tencent/mm/vending/tuple/Tuple2;", "_isPageLegal", "pageName", "_matchOn8Event", "_matchOnFinish", "onSessionClose", "_matchOnNot1stOnResume", "_matchOnResume", "_matchOnSessionNot1STOnResume", "sessionPath", "Lcom/tencent/mm/protocal/protobuf/SessionFuzzyPath;", "_updatePath", "getFuzzyPathOfCurSession", "Landroid/util/Pair;", "", "getMatchedFuzzyPaths", "Lcom/tencent/mm/protocal/protobuf/FuzzyPath;", "sessionId", "getMatchingFuzzyPaths", "getReportCache", "Lcom/tencent/mm/protocal/protobuf/FuzzyMatchCache;", "match", "state", "Lcom/tencent/mm/plugin/expt/hellhound/ext/fuzzymatch/MatchState;", "mmProcessRestartEvent", "resetFuzzyDaoOnSessionStart", "resetReportCache", "updateSessionFuzzyPath", "sessionFuzzyPath", "index", "plugin-expt_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class a
{
  public static final a zJT;
  private static boolean zJU;
  
  static
  {
    AppMethodBeat.i(122574);
    zJT = new a();
    AppMethodBeat.o(122574);
  }
  
  private static ArrayList<Long> a(String paramString, eyz parameyz, long paramLong)
  {
    AppMethodBeat.i(184277);
    ArrayList localArrayList = new ArrayList();
    int i = parameyz.aajM.size() - 1;
    if (i >= 0) {}
    for (;;)
    {
      int j = i - 1;
      Object localObject = parameyz.aajM.get(i);
      s.s(localObject, "sessionPath.paths[i]");
      localObject = (caw)localObject;
      cav localcav;
      if (((caw)localObject).aajU.size() == 1) {
        if (((caw)localObject).aajS.isEmpty())
        {
          localcav = new cav();
          localcav.name = paramString;
          localcav.startTime = paramLong;
          ((caw)localObject).aajU.addLast(localcav);
          localArrayList.add(Long.valueOf(((caw)localObject).aajX));
          Log.i("HABBYGE-MALI.FuzzyMatch", "_updatePath: " + ((caw)localObject).aajX + ", " + paramString);
        }
      }
      while (j < 0)
      {
        paramString = c.zJW;
        c.a.a(parameyz);
        AppMethodBeat.o(184277);
        return localArrayList;
        if (((caw)localObject).aajS.size() == 1)
        {
          if (s.p(((caw)localObject).aajT.hJW, paramString))
          {
            localcav = new cav();
            localcav.name = paramString;
            localcav.startTime = paramLong;
            ((caw)localObject).aajU.addLast(localcav);
            localArrayList.add(Long.valueOf(((caw)localObject).aajX));
            Log.i("HABBYGE-MALI.FuzzyMatch", "_updatePath, =1: " + ((caw)localObject).aajX + ", " + paramString);
          }
          else if (s.p(((ezb)((caw)localObject).aajS.get(0)).hJW, paramString))
          {
            ((caw)localObject).aajU.clear();
            localcav = new cav();
            localcav.name = paramString;
            localcav.startTime = paramLong;
            ((caw)localObject).aajU.addLast(localcav);
            localArrayList.add(Long.valueOf(((caw)localObject).aajX));
          }
          else
          {
            parameyz.aajM.remove(i);
          }
        }
        else if (s.p(((ezb)((caw)localObject).aajS.get(1)).hJW, paramString))
        {
          localcav = new cav();
          localcav.name = paramString;
          localcav.startTime = paramLong;
          ((caw)localObject).aajU.addLast(localcav);
          localArrayList.add(Long.valueOf(((caw)localObject).aajX));
        }
        else if (s.p(((ezb)((caw)localObject).aajS.get(0)).hJW, paramString))
        {
          ((caw)localObject).aajU.clear();
          localcav = new cav();
          localcav.name = paramString;
          localcav.startTime = paramLong;
          ((caw)localObject).aajU.addLast(localcav);
          localArrayList.add(Long.valueOf(((caw)localObject).aajX));
        }
        else
        {
          parameyz.aajM.remove(i);
          continue;
          if ((((caw)localObject).aajU.size() > 1) && (((caw)localObject).aajV)) {
            if (((caw)localObject).aajS.isEmpty())
            {
              localcav = new cav();
              localcav.name = paramString;
              localcav.startTime = paramLong;
              ((caw)localObject).aajU.addLast(localcav);
              Log.i("HABBYGE-MALI.FuzzyMatch", "_updatePath, =1: " + ((caw)localObject).aajX + ", " + paramString);
              localArrayList.add(Long.valueOf(((caw)localObject).aajX));
            }
            else if (((caw)localObject).aajS.size() == 1)
            {
              localcav = new cav();
              localcav.name = paramString;
              localcav.startTime = paramLong;
              ((caw)localObject).aajU.addLast(localcav);
              Log.i("HABBYGE-MALI.FuzzyMatch", "_updatePath, =2: " + ((caw)localObject).aajX + ", " + paramString);
              localArrayList.add(Long.valueOf(((caw)localObject).aajX));
            }
            else if (((caw)localObject).aajU.size() > ((caw)localObject).aajS.size())
            {
              localcav = new cav();
              localcav.name = paramString;
              localcav.startTime = paramLong;
              ((caw)localObject).aajU.addLast(localcav);
              Log.i("HABBYGE-MALI.FuzzyMatch", "_updatePath, >2: " + ((caw)localObject).aajX + ", " + paramString);
              localArrayList.add(Long.valueOf(((caw)localObject).aajX));
            }
            else if (((caw)localObject).aajU.size() == ((caw)localObject).aajS.size())
            {
              if (s.p(((caw)localObject).aajT.hJW, paramString))
              {
                localcav = new cav();
                localcav.name = paramString;
                localcav.startTime = paramLong;
                ((caw)localObject).aajU.addLast(localcav);
                localArrayList.add(Long.valueOf(((caw)localObject).aajX));
                Log.i("HABBYGE-MALI.FuzzyMatch", "_updatePath, >=2: " + ((caw)localObject).aajX + ", " + paramString);
              }
              else if (s.p(((ezb)((caw)localObject).aajS.get(0)).hJW, paramString))
              {
                ((caw)localObject).aajU.clear();
                localcav = new cav();
                localcav.name = paramString;
                localcav.startTime = paramLong;
                ((caw)localObject).aajU.addLast(localcav);
                localArrayList.add(Long.valueOf(((caw)localObject).aajX));
              }
              else
              {
                parameyz.aajM.remove(i);
              }
            }
            else if (s.p(((ezb)((caw)localObject).aajS.get(((caw)localObject).aajU.size())).hJW, paramString))
            {
              localcav = new cav();
              localcav.name = paramString;
              localcav.startTime = paramLong;
              ((caw)localObject).aajU.addLast(localcav);
              localArrayList.add(Long.valueOf(((caw)localObject).aajX));
            }
            else if (s.p(((ezb)((caw)localObject).aajS.get(0)).hJW, paramString))
            {
              ((caw)localObject).aajU.clear();
              localcav = new cav();
              localcav.name = paramString;
              localcav.startTime = paramLong;
              ((caw)localObject).aajU.addLast(localcav);
              localArrayList.add(Long.valueOf(((caw)localObject).aajX));
            }
            else
            {
              parameyz.aajM.remove(i);
            }
          }
        }
      }
      i = j;
    }
  }
  
  public static void a(eyz parameyz, int paramInt)
  {
    AppMethodBeat.i(300190);
    c.a locala = c.zJW;
    c.a.b(parameyz, paramInt);
    AppMethodBeat.o(300190);
  }
  
  private static void a(String paramString1, ezb paramezb1, ezb paramezb2, long paramLong, ezf paramezf, String paramString2)
  {
    AppMethodBeat.i(300154);
    caw localcaw = new caw();
    localcaw.hQR = paramString1;
    localcaw.aajS.add(paramezb1);
    localcaw.aajT = paramezb2;
    localcaw.aajV = true;
    localcaw.lAr = paramezf.lAr;
    localcaw.aajW = paramezf.aajW;
    localcaw.aajX = paramezf.aajX;
    paramezb1 = new cav();
    paramezb1.name = paramString2;
    paramezb1.startTime = paramLong;
    localcaw.aajU.addLast(paramezb1);
    paramezb1 = c.zJW;
    paramezb1 = c.a.asl(paramString1);
    ((eyz)paramezb1.first).aajM.addLast(localcaw);
    ((eyz)paramezb1.first).hQR = paramString1;
    paramString1 = c.zJW;
    paramString1 = (eyz)paramezb1.first;
    paramezb1 = paramezb1.second;
    s.s(paramezb1, "curSessionPathPair.second");
    c.a.b(paramString1, ((Number)paramezb1).intValue());
    AppMethodBeat.o(300154);
  }
  
  private static void a(String paramString1, ezb paramezb, ezf paramezf, String paramString2, long paramLong)
  {
    AppMethodBeat.i(300152);
    caw localcaw = new caw();
    localcaw.hQR = paramString1;
    localcaw.aajT = paramezb;
    localcaw.aajV = true;
    localcaw.lAr = paramezf.lAr;
    localcaw.aajW = paramezf.aajW;
    localcaw.aajX = paramezf.aajX;
    paramezb = new cav();
    paramezb.name = paramString2;
    paramezb.startTime = paramLong;
    localcaw.aajU.addLast(paramezb);
    paramezb = c.zJW;
    paramezb = c.a.asl(paramString1);
    ((eyz)paramezb.first).aajM.addLast(localcaw);
    ((eyz)paramezb.first).hQR = paramString1;
    paramString1 = c.zJW;
    paramString1 = (eyz)paramezb.first;
    paramezb = paramezb.second;
    s.s(paramezb, "curSessionPathPair.second");
    c.a.b(paramString1, ((Number)paramezb).intValue());
    AppMethodBeat.o(300152);
  }
  
  private final void a(String paramString1, String paramString2, long paramLong, ArrayList<ezf> paramArrayList)
  {
    AppMethodBeat.i(184275);
    Object localObject = c.zJW;
    localObject = c.a.asl(paramString2);
    if (((eyz)((Pair)localObject).first).aajM.isEmpty())
    {
      a(paramString1, paramString2, paramLong, paramArrayList, new ArrayList());
      AppMethodBeat.o(184275);
      return;
    }
    localObject = ((Pair)localObject).first;
    s.s(localObject, "sessionPathPair.first");
    a(paramString1, paramString2, (eyz)localObject, paramLong, paramArrayList);
    AppMethodBeat.o(184275);
  }
  
  private static void a(String paramString1, String paramString2, long paramLong, ArrayList<ezf> paramArrayList, ArrayList<Long> paramArrayList1)
  {
    AppMethodBeat.i(184278);
    paramArrayList = paramArrayList.iterator();
    while (paramArrayList.hasNext())
    {
      ezf localezf = (ezf)paramArrayList.next();
      if (!paramArrayList1.contains(Long.valueOf(localezf.aajX))) {
        if (localezf.abAl.size() == 1)
        {
          s.s(localezf, "pathConfig");
          a(paramString1, paramString2, localezf, paramLong);
        }
        else
        {
          Object localObject;
          ezb localezb;
          if (localezf.abAl.size() == 2)
          {
            localObject = (ezb)localezf.abAl.get(0);
            localezb = (ezb)localezf.abAl.get(1);
            if (s.p(paramString1, ((ezb)localObject).hJW))
            {
              s.s(localezf, "pathConfig");
              a(paramString2, (ezb)localObject, localezb, paramLong, localezf, paramString1);
            }
          }
          else
          {
            localObject = localezf.abAl.subList(0, localezf.abAl.size() - 1);
            s.s(localObject, "pathConfig.pagePathUnits…g.pagePathUnits.size - 1)");
            localezb = (ezb)localezf.abAl.getLast();
            if (s.p(paramString1, ((ezb)((List)localObject).get(0)).hJW))
            {
              s.s(localezf, "pathConfig");
              a(paramString2, (List)localObject, paramLong, localezb, localezf, paramString1);
            }
          }
        }
      }
    }
    AppMethodBeat.o(184278);
  }
  
  private final void a(String paramString1, String paramString2, eyz parameyz, long paramLong, ArrayList<ezf> paramArrayList)
  {
    AppMethodBeat.i(184276);
    a(paramString1, paramString2, paramLong, paramArrayList, a(paramString1, parameyz, paramLong));
    AppMethodBeat.o(184276);
  }
  
  private static void a(String paramString1, String paramString2, ezf paramezf, long paramLong)
  {
    AppMethodBeat.i(300146);
    ezb localezb = (ezb)paramezf.abAl.get(0);
    if (localezb == null)
    {
      AppMethodBeat.o(300146);
      return;
    }
    if (s.p(paramString1, localezb.hJW)) {
      a(paramString2, localezb, paramezf, paramString1, paramLong);
    }
    AppMethodBeat.o(300146);
  }
  
  private static void a(String paramString1, List<? extends ezb> paramList, long paramLong, ezb paramezb, ezf paramezf, String paramString2)
  {
    AppMethodBeat.i(300157);
    caw localcaw = new caw();
    localcaw.hQR = paramString1;
    localcaw.aajS.addAll((Collection)paramList);
    localcaw.aajT = paramezb;
    localcaw.aajV = true;
    localcaw.lAr = paramezf.lAr;
    localcaw.aajW = paramezf.aajW;
    localcaw.aajX = paramezf.aajX;
    paramList = new cav();
    paramList.name = paramString2;
    paramList.startTime = paramLong;
    localcaw.aajU.addLast(paramList);
    paramList = c.zJW;
    paramList = c.a.asl(paramString1);
    ((eyz)paramList.first).aajM.addLast(localcaw);
    ((eyz)paramList.first).hQR = paramString1;
    paramString1 = c.zJW;
    paramString1 = (eyz)paramList.first;
    paramList = paramList.second;
    s.s(paramList, "curSessionPathPair.second");
    c.a.b(paramString1, ((Number)paramList).intValue());
    AppMethodBeat.o(300157);
  }
  
  private final void ap(String paramString, long paramLong)
  {
    AppMethodBeat.i(184274);
    Object localObject1 = dLi();
    if (localObject1 == null)
    {
      AppMethodBeat.o(184274);
      return;
    }
    String str = (String)((com.tencent.mm.vending.j.b)localObject1).get(0);
    localObject1 = (ArrayList)((com.tencent.mm.vending.j.c)localObject1).get(1);
    if (localObject1 == null)
    {
      AppMethodBeat.o(184274);
      return;
    }
    Object localObject2 = c.zJW;
    localObject2 = c.a.dLm();
    if ((localObject2 == null) || (((cau)localObject2).aajN.isEmpty()))
    {
      s.s(str, "curSessionId");
      a(paramString, str, paramLong, (ArrayList)localObject1, new ArrayList());
      AppMethodBeat.o(184274);
      return;
    }
    s.s(str, "curSessionId");
    a(paramString, str, paramLong, (ArrayList)localObject1);
    AppMethodBeat.o(184274);
  }
  
  public static void asf(String paramString)
  {
    AppMethodBeat.i(169394);
    Log.i("HABBYGE-MALI.FuzzyMatch", s.X("resetFuzzyDaoOnStart: ", paramString));
    if (paramString == null)
    {
      AppMethodBeat.o(169394);
      return;
    }
    Object localObject1 = c.zJW;
    s.u(paramString, "curSessionId");
    localObject1 = c.a.dLm();
    int i;
    int k;
    Object localObject2;
    int j;
    if (localObject1 != null)
    {
      i = ((cau)localObject1).aajN.size() - 1;
      if (i >= 0)
      {
        k = i - 1;
        localObject2 = ((cau)localObject1).aajN.get(i);
        s.s(localObject2, "matchInfo.sessionFuzzyPaths[i]");
        localObject2 = (eyz)localObject2;
        if (!s.p(paramString, ((eyz)localObject2).hQR))
        {
          Log.i("HABBYGE-MALI.FuzzyMatchDao", s.X("resetOnStart, need remove: ", ((eyz)localObject2).hQR));
          j = ((eyz)localObject2).aajM.size() - 1;
          if (j < 0) {}
        }
      }
    }
    for (;;)
    {
      int m = j - 1;
      Object localObject3 = ((eyz)localObject2).aajM.get(j);
      s.s(localObject3, "sessionPath.paths[j]");
      if (((caw)localObject3).aajV)
      {
        Log.i("HABBYGE-MALI.FuzzyMatchDao", s.X("resetOnStart, real remove: ", ((eyz)localObject2).hQR));
        ((eyz)localObject2).aajM.remove(j);
      }
      if (m < 0)
      {
        if (((eyz)localObject2).aajM.isEmpty()) {
          ((cau)localObject1).aajN.remove(i);
        }
        if (k < 0)
        {
          c.a.a((cau)localObject1);
          paramString = e.zJY;
          e.a.reset();
          paramString = j.zKM;
          j.a.reset();
          AppMethodBeat.o(169394);
          return;
        }
        i = k;
        break;
      }
      j = m;
    }
  }
  
  public static List<caw> asg(String paramString)
  {
    AppMethodBeat.i(122573);
    ArrayList localArrayList = new ArrayList();
    Object localObject = c.zJW;
    paramString = c.a.ask(paramString);
    if (paramString == null)
    {
      AppMethodBeat.o(122573);
      return null;
    }
    paramString = paramString.aajM.iterator();
    while (paramString.hasNext())
    {
      localObject = (caw)paramString.next();
      if (((caw)localObject).aajV) {
        localArrayList.add(localObject);
      }
    }
    paramString = (List)localArrayList;
    AppMethodBeat.o(122573);
    return paramString;
  }
  
  public static List<caw> ash(String paramString)
  {
    AppMethodBeat.i(185590);
    ArrayList localArrayList = new ArrayList();
    Object localObject = c.zJW;
    localObject = c.a.ask(paramString);
    caw localcaw;
    if (localObject != null)
    {
      localObject = ((eyz)localObject).aajM.iterator();
      while (((Iterator)localObject).hasNext())
      {
        localcaw = (caw)((Iterator)localObject).next();
        if (!localcaw.aajV) {
          localArrayList.add(localcaw);
        }
      }
    }
    localObject = e.zJY;
    localObject = e.a.asm(paramString);
    if (localObject != null)
    {
      localObject = ((eyz)localObject).aajM.iterator();
      while (((Iterator)localObject).hasNext())
      {
        localcaw = (caw)((Iterator)localObject).next();
        if (!localcaw.aajV) {
          localArrayList.add(localcaw);
        }
      }
    }
    localObject = e.zJY;
    e.a.ama(paramString);
    paramString = (List)localArrayList;
    AppMethodBeat.o(185590);
    return paramString;
  }
  
  private static boolean asi(String paramString)
  {
    AppMethodBeat.i(169395);
    if (!s.p(paramString, "com.tencent.mm.ui.LauncherUI"))
    {
      AppMethodBeat.o(169395);
      return true;
    }
    AppMethodBeat.o(169395);
    return false;
  }
  
  private static void c(String paramString, boolean paramBoolean, long paramLong)
  {
    AppMethodBeat.i(184279);
    if (((paramBoolean) || (com.tencent.mm.plugin.expt.hellhound.core.b.aqV(paramString))) && (zJU))
    {
      zJU = false;
      AppMethodBeat.o(184279);
      return;
    }
    Object localObject1 = com.tencent.mm.plugin.expt.hellhound.ext.session.config.b.zKz;
    localObject1 = com.tencent.mm.plugin.expt.hellhound.ext.session.b.c.dMa();
    if ((localObject1 == null) || (((czw)localObject1).aaFn.isEmpty()))
    {
      localObject1 = null;
      if (localObject1 != null) {
        break label136;
      }
    }
    label136:
    for (localObject1 = null;; localObject1 = ((eah)localObject1).sessionId)
    {
      if (localObject1 != null) {
        break label146;
      }
      Log.w("HABBYGE-MALI.FuzzyMatch", "_matchOnFinish: curSession == null");
      AppMethodBeat.o(184279);
      return;
      if (com.tencent.mm.plugin.expt.hellhound.ext.session.b.c.d((czw)localObject1))
      {
        localObject1 = (eah)((czw)localObject1).aaFn.get(((czw)localObject1).LSR);
        break;
      }
      localObject1 = (eah)((czw)localObject1).aaFn.getLast();
      break;
    }
    label146:
    Object localObject2 = c.zJW;
    localObject1 = c.a.ask((String)localObject1);
    if (localObject1 == null)
    {
      Log.w("HABBYGE-MALI.FuzzyMatch", "_matchOnFinish: sessionMatch == null");
      AppMethodBeat.o(184279);
      return;
    }
    localObject2 = ((eyz)localObject1).aajM.iterator();
    while (((Iterator)localObject2).hasNext())
    {
      caw localcaw = (caw)((Iterator)localObject2).next();
      Object localObject3;
      if (localcaw.aajV)
      {
        localObject3 = com.tencent.mm.plugin.expt.hellhound.core.b.aqH(localcaw.aajT.hJW);
        if ((s.p(paramString, localcaw.aajT.hJW)) || (s.p(paramString, localObject3)))
        {
          localcaw.aajV = false;
          localObject3 = d.zJX;
          d.a.a(localcaw, paramLong);
        }
      }
      else
      {
        int i = localcaw.aajU.size() - 1;
        if (i >= 0)
        {
          label292:
          int j = i - 1;
          localObject3 = (cav)localcaw.aajU.get(i);
          long l;
          if (localObject3 != null)
          {
            String str = com.tencent.mm.plugin.expt.hellhound.core.b.aqH(((cav)localObject3).name);
            if (((s.p(paramString, ((cav)localObject3).name)) || (s.p(paramString, str))) && (((cav)localObject3).aajP <= 0L))
            {
              l = paramLong - ((cav)localObject3).startTime;
              if (l < 0L) {
                break label394;
              }
            }
          }
          for (;;)
          {
            ((cav)localObject3).aajP = l;
            if (j < 0) {
              break;
            }
            i = j;
            break label292;
            label394:
            l = 0L;
          }
        }
      }
    }
    paramString = c.zJW;
    c.a.a((eyz)localObject1);
    AppMethodBeat.o(184279);
  }
  
  private static void dLh()
  {
    AppMethodBeat.i(169392);
    Object localObject = c.zJW;
    c.a.reset();
    localObject = e.zJY;
    e.a.reset();
    localObject = j.zKM;
    j.a.reset();
    AppMethodBeat.o(169392);
  }
  
  private static com.tencent.mm.vending.j.c<String, ArrayList<ezf>> dLi()
  {
    AppMethodBeat.i(169393);
    Object localObject1 = com.tencent.mm.plugin.expt.hellhound.ext.session.config.b.zKz;
    localObject1 = com.tencent.mm.plugin.expt.hellhound.ext.session.config.b.a.dLI();
    if (localObject1 == null)
    {
      AppMethodBeat.o(169393);
      return null;
    }
    Object localObject2 = com.tencent.mm.plugin.expt.hellhound.ext.session.config.b.zKz;
    localObject2 = com.tencent.mm.plugin.expt.hellhound.ext.session.config.b.a.ass((String)localObject1);
    if (localObject2 == null)
    {
      AppMethodBeat.o(169393);
      return null;
    }
    b.a locala = b.zJV;
    localObject2 = b.a.asj((String)localObject2);
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
    localObject1 = com.tencent.mm.vending.j.a.U(localObject1, localObject2);
    AppMethodBeat.o(169393);
    return localObject1;
  }
  
  public static void dLj()
  {
    AppMethodBeat.i(122571);
    Log.i("HABBYGE-MALI.FuzzyMatch", "resetReportCache");
    d.a locala = d.zJX;
    com.tencent.mm.plugin.expt.hellhound.core.a.b.u("mmkv_fuzzy_mc_rpt", new byte[0]);
    AppMethodBeat.o(122571);
  }
  
  public static cat dLk()
  {
    AppMethodBeat.i(122572);
    Object localObject = d.zJX;
    localObject = d.a.dLn();
    AppMethodBeat.o(122572);
    return localObject;
  }
  
  public static Pair<eyz, Integer> dLl()
  {
    AppMethodBeat.i(300187);
    String str = com.tencent.mm.plugin.expt.hellhound.ext.session.b.dLx().dLA();
    Object localObject1 = c.zJW;
    s.s(str, "curSessionid");
    s.u(str, "sessionId");
    localObject1 = c.a.dLm();
    if (localObject1 == null) {
      localObject1 = new cau();
    }
    for (;;)
    {
      int i = ((cau)localObject1).aajN.size() - 1;
      if (i >= 0) {}
      for (;;)
      {
        int j = i - 1;
        Object localObject2 = ((cau)localObject1).aajN.get(i);
        s.s(localObject2, "fuzzyMatchInfo.sessionFuzzyPaths[i]");
        localObject2 = (eyz)localObject2;
        if (s.p(str, ((eyz)localObject2).hQR))
        {
          localObject1 = Pair.create(localObject2, Integer.valueOf(i));
          AppMethodBeat.o(300187);
          return localObject1;
        }
        if (j < 0)
        {
          AppMethodBeat.o(300187);
          return null;
        }
        i = j;
      }
    }
  }
  
  private static void mb(long paramLong)
  {
    AppMethodBeat.i(184280);
    d.a locala = d.zJX;
    d.a.mc(paramLong);
    AppMethodBeat.o(184280);
  }
  
  public final void a(String paramString, long paramLong, f paramf)
  {
    AppMethodBeat.i(184273);
    s.u(paramf, "state");
    if (paramString == null)
    {
      Log.i("HABBYGE-MALI.FuzzyMatch", s.X("match: page is: ", paramString));
      AppMethodBeat.o(184273);
      return;
    }
    com.tencent.mm.plugin.expt.hellhound.ext.session.config.b.a locala = com.tencent.mm.plugin.expt.hellhound.ext.session.config.b.zKz;
    if (com.tencent.mm.plugin.expt.hellhound.ext.session.config.b.a.dLF())
    {
      Log.w("HABBYGE-MALI.FuzzyMatch", "match, doNotNeedSessionMonitor: TRUE");
      AppMethodBeat.o(184273);
      return;
    }
    Log.i("HABBYGE-MALI.FuzzyMatch", "match: " + paramString + ", " + paramf);
    switch (a.$EnumSwitchMapping$0[paramf.ordinal()])
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
          } while (!asi(paramString));
          ap(paramString, paramLong);
          AppMethodBeat.o(184273);
          return;
        } while (!asi(paramString));
        c(paramString, false, paramLong);
        AppMethodBeat.o(184273);
        return;
      } while (!asi(paramString));
      c(paramString, false, paramLong);
      AppMethodBeat.o(184273);
      return;
    case 4: 
      c(paramString, true, paramLong);
      AppMethodBeat.o(184273);
      return;
    case 5: 
      zJU = true;
      mb(paramLong);
      AppMethodBeat.o(184273);
      return;
    }
    dLh();
    AppMethodBeat.o(184273);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.expt.hellhound.ext.d.a
 * JD-Core Version:    0.7.0.1
 */