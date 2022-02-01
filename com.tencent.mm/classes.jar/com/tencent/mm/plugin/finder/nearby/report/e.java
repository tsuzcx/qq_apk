package com.tencent.mm.plugin.finder.nearby.report;

import com.tencent.d.a.b.a.b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.cn;
import com.tencent.mm.plugin.finder.model.BaseFinderFeed;
import com.tencent.mm.plugin.finder.model.cc;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.protocal.protobuf.byg;
import com.tencent.mm.protocal.protobuf.dmk;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/nearby/report/NearbyReadFeedRecorder;", "Lcom/tencent/plugin/finder/nearby/api/INearbyReadFeedRecorder;", "()V", "TAG", "", "lastRspExposeStartListForLive", "Ljava/util/LinkedList;", "Lcom/tencent/mm/protocal/protobuf/MarkReadStat;", "lastRspExposeStartListForLiveMore", "lastRspExposeStartListForVideo", "lastRspListForLive", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "lastRspListForLiveMore", "lastRspListForVideo", "lastRspReadListForLive", "lastRspReadListForLiveMore", "lastRspReadListForVideo", "lastUnReadList", "Lcom/tencent/mm/protocal/protobuf/FinderUnreadItem;", "clear", "", "getExposeStartList", "", "commentScene", "", "getLastRspList", "", "getReadList", "getReadListByCommentScene", "getTabType", "getUnreadList", "tabTypeField", "isNearbyCommentScene", "", "onItemExposeStart", "item", "onItemExposed", "list", "printLastRspList", "printReadList", "printUnreadList", "recordLastRsp", "plugin-finder-nearby_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class e
  implements b
{
  public static final e EQU;
  private static final LinkedList<cc> EQV;
  private static final LinkedList<dmk> EQW;
  private static final LinkedList<dmk> EQX;
  private static final LinkedList<cc> EQY;
  private static final LinkedList<dmk> EQZ;
  private static final LinkedList<dmk> ERa;
  private static final LinkedList<cc> ERb;
  private static final LinkedList<dmk> ERc;
  private static final LinkedList<dmk> ERd;
  private static final LinkedList<byg> ERe;
  private static final String TAG;
  
  static
  {
    AppMethodBeat.i(339810);
    EQU = new e();
    TAG = "NearbyReadFeedRecorder";
    EQV = new LinkedList();
    EQW = new LinkedList();
    EQX = new LinkedList();
    EQY = new LinkedList();
    EQZ = new LinkedList();
    ERa = new LinkedList();
    ERb = new LinkedList();
    ERc = new LinkedList();
    ERd = new LinkedList();
    ERe = new LinkedList();
    AppMethodBeat.o(339810);
  }
  
  public static void F(int paramInt, List<? extends dmk> paramList)
  {
    AppMethodBeat.i(339738);
    s.u(paramList, "list");
    Iterator localIterator1 = ((Iterable)Rl(paramInt)).iterator();
    label145:
    if (localIterator1.hasNext())
    {
      cc localcc = (cc)localIterator1.next();
      Iterator localIterator2 = ((Iterable)paramList).iterator();
      label58:
      label189:
      label194:
      label201:
      label204:
      for (;;)
      {
        dmk localdmk;
        int i;
        label109:
        int j;
        if (localIterator2.hasNext())
        {
          localdmk = (dmk)localIterator2.next();
          if (localcc.bZA() != localdmk.hKN) {
            continue;
          }
          Iterator localIterator3 = Rj(paramInt).iterator();
          i = 0;
          if (!localIterator3.hasNext()) {
            break label201;
          }
          if (((dmk)localIterator3.next()).hKN != localcc.bZA()) {
            break label189;
          }
          j = 1;
          if (j == 0) {
            break label194;
          }
        }
        for (;;)
        {
          if (i >= 0) {
            break label204;
          }
          if ((localcc instanceof BaseFinderFeed)) {
            localdmk.sessionBuffer = ((BaseFinderFeed)localcc).getSessionBuffer();
          }
          Rj(paramInt).add(localdmk);
          break label58;
          break;
          j = 0;
          break label145;
          i += 1;
          break label109;
          i = -1;
        }
      }
    }
    AppMethodBeat.o(339738);
  }
  
  public static void G(int paramInt, List<? extends cc> paramList)
  {
    AppMethodBeat.i(339748);
    s.u(paramList, "list");
    Log.d(TAG, "recordLastRsp commentScene:" + paramInt + " size:" + paramList.size());
    switch (paramInt)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(339748);
      return;
      ERa.clear();
      EQZ.clear();
      EQY.clear();
      EQY.addAll((Collection)paramList);
      AppMethodBeat.o(339748);
      return;
      EQX.clear();
      EQW.clear();
      EQV.clear();
      EQV.addAll((Collection)paramList);
      AppMethodBeat.o(339748);
      return;
      ERd.clear();
      ERc.clear();
      ERb.clear();
      ERb.addAll((Collection)paramList);
    }
  }
  
  public static int Ri(int paramInt)
  {
    switch (paramInt)
    {
    case 76: 
    case 94: 
    default: 
      return 1001;
    case 15: 
      return 1002;
    }
    return 1004;
  }
  
  private static List<dmk> Rj(int paramInt)
  {
    AppMethodBeat.i(339772);
    switch (paramInt)
    {
    default: 
      localList = (List)new LinkedList();
      AppMethodBeat.o(339772);
      return localList;
    case 15: 
      localList = (List)ERa;
      AppMethodBeat.o(339772);
      return localList;
    case 76: 
    case 94: 
      localList = (List)EQX;
      AppMethodBeat.o(339772);
      return localList;
    }
    List localList = (List)ERd;
    AppMethodBeat.o(339772);
    return localList;
  }
  
  private static List<dmk> Rk(int paramInt)
  {
    AppMethodBeat.i(339777);
    switch (paramInt)
    {
    default: 
      localList = (List)new LinkedList();
      AppMethodBeat.o(339777);
      return localList;
    case 15: 
      localList = (List)EQZ;
      AppMethodBeat.o(339777);
      return localList;
    case 76: 
    case 94: 
      localList = (List)EQW;
      AppMethodBeat.o(339777);
      return localList;
    }
    List localList = (List)ERc;
    AppMethodBeat.o(339777);
    return localList;
  }
  
  private static List<cc> Rl(int paramInt)
  {
    AppMethodBeat.i(339784);
    switch (paramInt)
    {
    default: 
      localList = (List)new LinkedList();
      AppMethodBeat.o(339784);
      return localList;
    case 15: 
      localList = (List)EQY;
      AppMethodBeat.o(339784);
      return localList;
    case 76: 
    case 94: 
      localList = (List)EQV;
      AppMethodBeat.o(339784);
      return localList;
    }
    List localList = (List)ERb;
    AppMethodBeat.o(339784);
    return localList;
  }
  
  public static void a(int paramInt, dmk paramdmk)
  {
    AppMethodBeat.i(339726);
    s.u(paramdmk, "item");
    Rk(paramInt).add(paramdmk);
    AppMethodBeat.o(339726);
  }
  
  public static void clear()
  {
    AppMethodBeat.i(339764);
    EQV.clear();
    EQW.clear();
    EQX.clear();
    EQY.clear();
    EQZ.clear();
    ERa.clear();
    ERb.clear();
    ERc.clear();
    ERd.clear();
    ERe.clear();
    AppMethodBeat.o(339764);
  }
  
  private static void hf(List<? extends cc> paramList)
  {
    AppMethodBeat.i(339796);
    Log.d(TAG, s.X("printLastRspList size:", Integer.valueOf(paramList.size())));
    if (BuildInfo.DEBUG)
    {
      paramList = ((Iterable)paramList).iterator();
      while (paramList.hasNext())
      {
        cc localcc = (cc)paramList.next();
        Log.d(TAG, "printLastRspList: " + localcc.bZA() + ' ' + localcc.bZB());
      }
    }
    AppMethodBeat.o(339796);
  }
  
  private static void hg(List<? extends dmk> paramList)
  {
    AppMethodBeat.i(339800);
    Log.d(TAG, s.X("printReadList size:", Integer.valueOf(paramList.size())));
    if (BuildInfo.DEBUG)
    {
      paramList = ((Iterable)paramList).iterator();
      while (paramList.hasNext())
      {
        dmk localdmk = (dmk)paramList.next();
        Log.d(TAG, "printReadList: " + localdmk.aaSt + ' ' + localdmk.hKN + ' ' + localdmk.aaSu + ' ');
      }
    }
    AppMethodBeat.o(339800);
  }
  
  private static void hh(List<? extends byg> paramList)
  {
    AppMethodBeat.i(339804);
    Log.d(TAG, s.X("printUnreadList size:", Integer.valueOf(paramList.size())));
    if (BuildInfo.DEBUG)
    {
      paramList = ((Iterable)paramList).iterator();
      while (paramList.hasNext())
      {
        byg localbyg = (byg)paramList.next();
        Log.d(TAG, "printUnreadList: " + localbyg.hKN + ' ' + localbyg.hJx);
      }
    }
    AppMethodBeat.o(339804);
  }
  
  public final List<dmk> Rg(int paramInt)
  {
    AppMethodBeat.i(339815);
    List localList = Rj(paramInt);
    Iterator localIterator1 = ((Iterable)Rk(paramInt)).iterator();
    if (localIterator1.hasNext())
    {
      dmk localdmk = (dmk)localIterator1.next();
      Iterator localIterator2 = ((Iterable)Rl(paramInt)).iterator();
      label145:
      label290:
      label295:
      label302:
      label305:
      for (;;)
      {
        label62:
        cc localcc;
        int i;
        label111:
        int j;
        if (localIterator2.hasNext())
        {
          localcc = (cc)localIterator2.next();
          if (localdmk.hKN != localcc.bZA()) {
            continue;
          }
          Iterator localIterator3 = localList.iterator();
          i = 0;
          if (!localIterator3.hasNext()) {
            break label302;
          }
          if (((dmk)localIterator3.next()).hKN != localdmk.hKN) {
            break label290;
          }
          j = 1;
          if (j == 0) {
            break label295;
          }
        }
        for (;;)
        {
          if (i >= 0) {
            break label305;
          }
          i = localdmk.aaSu;
          long l = cn.bDw();
          localdmk.aaSu = ((int)(l - i));
          if ((localcc instanceof BaseFinderFeed)) {
            localdmk.sessionBuffer = ((BaseFinderFeed)localcc).getSessionBuffer();
          }
          Log.d(TAG, "expose id:" + localdmk.hKN + " expose[" + i + ", " + l + "] exposeTime:" + localdmk.aaSu + " seesion:" + localdmk.sessionBuffer + ' ');
          localList.add(localdmk);
          break label62;
          break;
          j = 0;
          break label145;
          i += 1;
          break label111;
          i = -1;
        }
      }
    }
    AppMethodBeat.o(339815);
    return localList;
  }
  
  public final boolean Rh(int paramInt)
  {
    boolean bool = true;
    switch (paramInt)
    {
    default: 
      bool = false;
    }
    return bool;
  }
  
  public final List<byg> hY(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(339829);
    ERe.clear();
    Object localObject1 = ((Iterable)Rl(paramInt1)).iterator();
    label76:
    label229:
    label239:
    while (((Iterator)localObject1).hasNext())
    {
      Object localObject2 = (cc)((Iterator)localObject1).next();
      if ((localObject2 instanceof BaseFinderFeed))
      {
        BaseFinderFeed localBaseFinderFeed = (BaseFinderFeed)localObject2;
        Iterator localIterator = Rj(paramInt1).iterator();
        int i = 0;
        int j;
        if (localIterator.hasNext()) {
          if (((dmk)localIterator.next()).hKN == ((cc)localObject2).bZA())
          {
            j = 1;
            label113:
            if (j == 0) {
              break label229;
            }
          }
        }
        for (;;)
        {
          if (i >= 0) {
            break label239;
          }
          localObject2 = new byg();
          ((byg)localObject2).hKN = localBaseFinderFeed.feedObject.getFeedObject().id;
          ((byg)localObject2).objectNonceId = localBaseFinderFeed.feedObject.getFeedObject().objectNonceId;
          ((byg)localObject2).hJx = paramInt2;
          ((byg)localObject2).sessionBuffer = localBaseFinderFeed.feedObject.getFeedObject().sessionBuffer;
          ((byg)localObject2).hKN = localBaseFinderFeed.feedObject.getId();
          ((byg)localObject2).objectNonceId = localBaseFinderFeed.feedObject.getObjectNonceId();
          ERe.add(localObject2);
          break;
          j = 0;
          break label113;
          i += 1;
          break label76;
          i = -1;
        }
      }
    }
    hf(Rl(paramInt1));
    hg(Rj(paramInt1));
    hh((List)ERe);
    localObject1 = (List)ERe;
    AppMethodBeat.o(339829);
    return localObject1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes13.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.nearby.report.e
 * JD-Core Version:    0.7.0.1
 */