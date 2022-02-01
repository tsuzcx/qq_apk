package com.tencent.mm.plugin.finder.nearby.report;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.cl;
import com.tencent.mm.plugin.finder.model.BaseFinderFeed;
import com.tencent.mm.plugin.finder.model.bo;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.protocal.protobuf.bdv;
import com.tencent.mm.protocal.protobuf.cmm;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/nearby/report/NearbyReadFeedRecorder;", "", "()V", "TAG", "", "lastRspExposeStartListForLive", "Ljava/util/LinkedList;", "Lcom/tencent/mm/protocal/protobuf/MarkReadStat;", "lastRspExposeStartListForLiveMore", "lastRspExposeStartListForVideo", "lastRspListForLive", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "lastRspListForLiveMore", "lastRspListForVideo", "lastRspReadListForLive", "lastRspReadListForLiveMore", "lastRspReadListForVideo", "lastUnReadList", "Lcom/tencent/mm/protocal/protobuf/FinderUnreadItem;", "clear", "", "getExposeStartList", "", "commentScene", "", "getLastRspList", "", "getReadList", "getReadListByCommentScene", "getTabType", "getUnreadList", "tabTypeField", "isNearbyCommentScene", "", "onItemExposeStart", "item", "onItemExposed", "list", "printLastRspList", "printReadList", "printUnreadList", "recordLastRsp", "plugin-finder_release"})
public final class c
{
  private static final String TAG = "NearbyReadFeedRecorder";
  private static final LinkedList<bo> uTa;
  private static final LinkedList<cmm> uTb;
  private static final LinkedList<cmm> uTc;
  private static final LinkedList<bo> uTd;
  private static final LinkedList<cmm> uTe;
  private static final LinkedList<cmm> uTf;
  private static final LinkedList<bo> uTg;
  private static final LinkedList<cmm> uTh;
  private static final LinkedList<cmm> uTi;
  private static final LinkedList<bdv> uTj;
  public static final c uTk;
  
  static
  {
    AppMethodBeat.i(249348);
    uTk = new c();
    TAG = "NearbyReadFeedRecorder";
    uTa = new LinkedList();
    uTb = new LinkedList();
    uTc = new LinkedList();
    uTd = new LinkedList();
    uTe = new LinkedList();
    uTf = new LinkedList();
    uTg = new LinkedList();
    uTh = new LinkedList();
    uTi = new LinkedList();
    uTj = new LinkedList();
    AppMethodBeat.o(249348);
  }
  
  public static List<cmm> JF(int paramInt)
  {
    AppMethodBeat.i(249340);
    List localList = JI(paramInt);
    Iterator localIterator1 = ((Iterable)JJ(paramInt)).iterator();
    if (localIterator1.hasNext())
    {
      cmm localcmm = (cmm)localIterator1.next();
      Iterator localIterator2 = ((Iterable)JK(paramInt)).iterator();
      label144:
      label281:
      label286:
      label293:
      label296:
      for (;;)
      {
        label61:
        bo localbo;
        int i;
        label110:
        int j;
        if (localIterator2.hasNext())
        {
          localbo = (bo)localIterator2.next();
          if (localcmm.hFK != localbo.lT()) {
            continue;
          }
          Iterator localIterator3 = localList.iterator();
          i = 0;
          if (!localIterator3.hasNext()) {
            break label293;
          }
          if (((cmm)localIterator3.next()).hFK != localcmm.hFK) {
            break label281;
          }
          j = 1;
          if (j == 0) {
            break label286;
          }
        }
        for (;;)
        {
          if (i >= 0) {
            break label296;
          }
          i = localcmm.MrJ;
          long l = cl.aWA();
          localcmm.MrJ = ((int)(l - i));
          if ((localbo instanceof BaseFinderFeed)) {
            localcmm.sessionBuffer = ((BaseFinderFeed)localbo).getSessionBuffer();
          }
          Log.d(TAG, "expose id:" + localcmm.hFK + " expose[" + i + ", " + l + "] exposeTime:" + localcmm.MrJ + " seesion:" + localcmm.sessionBuffer + ' ');
          localList.add(localcmm);
          break label61;
          break;
          j = 0;
          break label144;
          i += 1;
          break label110;
          i = -1;
        }
      }
    }
    AppMethodBeat.o(249340);
    return localList;
  }
  
  public static boolean JG(int paramInt)
  {
    boolean bool = true;
    switch (paramInt)
    {
    default: 
      bool = false;
    }
    return bool;
  }
  
  public static int JH(int paramInt)
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
  
  private static List<cmm> JI(int paramInt)
  {
    AppMethodBeat.i(249343);
    switch (paramInt)
    {
    default: 
      localList = (List)new LinkedList();
      AppMethodBeat.o(249343);
      return localList;
    case 15: 
      localList = (List)uTf;
      AppMethodBeat.o(249343);
      return localList;
    case 76: 
    case 94: 
      localList = (List)uTc;
      AppMethodBeat.o(249343);
      return localList;
    }
    List localList = (List)uTi;
    AppMethodBeat.o(249343);
    return localList;
  }
  
  private static List<cmm> JJ(int paramInt)
  {
    AppMethodBeat.i(249344);
    switch (paramInt)
    {
    default: 
      localList = (List)new LinkedList();
      AppMethodBeat.o(249344);
      return localList;
    case 15: 
      localList = (List)uTe;
      AppMethodBeat.o(249344);
      return localList;
    case 76: 
    case 94: 
      localList = (List)uTb;
      AppMethodBeat.o(249344);
      return localList;
    }
    List localList = (List)uTh;
    AppMethodBeat.o(249344);
    return localList;
  }
  
  private static List<bo> JK(int paramInt)
  {
    AppMethodBeat.i(249345);
    switch (paramInt)
    {
    default: 
      localList = (List)new LinkedList();
      AppMethodBeat.o(249345);
      return localList;
    case 15: 
      localList = (List)uTd;
      AppMethodBeat.o(249345);
      return localList;
    case 76: 
    case 94: 
      localList = (List)uTa;
      AppMethodBeat.o(249345);
      return localList;
    }
    List localList = (List)uTg;
    AppMethodBeat.o(249345);
    return localList;
  }
  
  public static void a(int paramInt, cmm paramcmm)
  {
    AppMethodBeat.i(249337);
    p.h(paramcmm, "item");
    JJ(paramInt).add(paramcmm);
    AppMethodBeat.o(249337);
  }
  
  public static void clear()
  {
    AppMethodBeat.i(249342);
    uTa.clear();
    uTb.clear();
    uTc.clear();
    uTd.clear();
    uTe.clear();
    uTf.clear();
    uTg.clear();
    uTh.clear();
    uTi.clear();
    uTj.clear();
    AppMethodBeat.o(249342);
  }
  
  private static void em(List<? extends cmm> paramList)
  {
    AppMethodBeat.i(249346);
    Log.d(TAG, "printReadList size:" + paramList.size());
    if (BuildInfo.DEBUG)
    {
      paramList = ((Iterable)paramList).iterator();
      while (paramList.hasNext())
      {
        cmm localcmm = (cmm)paramList.next();
        Log.d(TAG, "printReadList: " + localcmm.MrI + ' ' + localcmm.hFK + ' ' + localcmm.MrJ + ' ');
      }
    }
    AppMethodBeat.o(249346);
  }
  
  private static void en(List<? extends bdv> paramList)
  {
    AppMethodBeat.i(249347);
    Log.d(TAG, "printUnreadList size:" + paramList.size());
    if (BuildInfo.DEBUG)
    {
      paramList = ((Iterable)paramList).iterator();
      while (paramList.hasNext())
      {
        bdv localbdv = (bdv)paramList.next();
        Log.d(TAG, "printUnreadList: " + localbdv.hFK + ' ' + localbdv.dLS);
      }
    }
    AppMethodBeat.o(249347);
  }
  
  public static List<bdv> gb(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(249341);
    uTj.clear();
    Object localObject1 = ((Iterable)JK(paramInt1)).iterator();
    Object localObject2;
    label76:
    label226:
    label236:
    while (((Iterator)localObject1).hasNext())
    {
      Object localObject3 = (bo)((Iterator)localObject1).next();
      if ((localObject3 instanceof BaseFinderFeed))
      {
        localObject2 = (BaseFinderFeed)localObject3;
        Iterator localIterator = JI(paramInt1).iterator();
        int i = 0;
        int j;
        if (localIterator.hasNext()) {
          if (((cmm)localIterator.next()).hFK == ((bo)localObject3).lT())
          {
            j = 1;
            label112:
            if (j == 0) {
              break label226;
            }
          }
        }
        for (;;)
        {
          if (i >= 0) {
            break label236;
          }
          localObject3 = new bdv();
          ((bdv)localObject3).hFK = ((BaseFinderFeed)localObject2).feedObject.getFeedObject().id;
          ((bdv)localObject3).objectNonceId = ((BaseFinderFeed)localObject2).feedObject.getFeedObject().objectNonceId;
          ((bdv)localObject3).dLS = paramInt2;
          ((bdv)localObject3).sessionBuffer = ((BaseFinderFeed)localObject2).feedObject.getFeedObject().sessionBuffer;
          ((bdv)localObject3).hFK = ((BaseFinderFeed)localObject2).feedObject.getId();
          ((bdv)localObject3).objectNonceId = ((BaseFinderFeed)localObject2).feedObject.getObjectNonceId();
          uTj.add(localObject3);
          break;
          j = 0;
          break label112;
          i += 1;
          break label76;
          i = -1;
        }
      }
    }
    localObject1 = JK(paramInt1);
    Log.d(TAG, "printLastRspList size:" + ((List)localObject1).size());
    if (BuildInfo.DEBUG)
    {
      localObject1 = ((Iterable)localObject1).iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (bo)((Iterator)localObject1).next();
        Log.d(TAG, "printLastRspList: " + ((bo)localObject2).lT() + ' ' + ((bo)localObject2).cxn());
      }
    }
    em(JI(paramInt1));
    en((List)uTj);
    localObject1 = (List)uTj;
    AppMethodBeat.o(249341);
    return localObject1;
  }
  
  public static void i(int paramInt, List<? extends cmm> paramList)
  {
    AppMethodBeat.i(249338);
    p.h(paramList, "list");
    Iterator localIterator1 = ((Iterable)JK(paramInt)).iterator();
    label147:
    if (localIterator1.hasNext())
    {
      bo localbo = (bo)localIterator1.next();
      Iterator localIterator2 = ((Iterable)paramList).iterator();
      label60:
      label191:
      label196:
      label203:
      label206:
      for (;;)
      {
        cmm localcmm;
        int i;
        label111:
        int j;
        if (localIterator2.hasNext())
        {
          localcmm = (cmm)localIterator2.next();
          if (localbo.lT() != localcmm.hFK) {
            continue;
          }
          Iterator localIterator3 = JI(paramInt).iterator();
          i = 0;
          if (!localIterator3.hasNext()) {
            break label203;
          }
          if (((cmm)localIterator3.next()).hFK != localbo.lT()) {
            break label191;
          }
          j = 1;
          if (j == 0) {
            break label196;
          }
        }
        for (;;)
        {
          if (i >= 0) {
            break label206;
          }
          if ((localbo instanceof BaseFinderFeed)) {
            localcmm.sessionBuffer = ((BaseFinderFeed)localbo).getSessionBuffer();
          }
          JI(paramInt).add(localcmm);
          break label60;
          break;
          j = 0;
          break label147;
          i += 1;
          break label111;
          i = -1;
        }
      }
    }
    AppMethodBeat.o(249338);
  }
  
  public static void j(int paramInt, List<? extends bo> paramList)
  {
    AppMethodBeat.i(249339);
    p.h(paramList, "list");
    Log.d(TAG, "recordLastRsp commentScene:" + paramInt + " size:" + paramList.size());
    switch (paramInt)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(249339);
      return;
      uTf.clear();
      uTe.clear();
      uTd.clear();
      uTd.addAll((Collection)paramList);
      AppMethodBeat.o(249339);
      return;
      uTc.clear();
      uTb.clear();
      uTa.clear();
      uTa.addAll((Collection)paramList);
      AppMethodBeat.o(249339);
      return;
      uTi.clear();
      uTh.clear();
      uTg.clear();
      uTg.addAll((Collection)paramList);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.nearby.report.c
 * JD-Core Version:    0.7.0.1
 */