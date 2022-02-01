package com.tencent.mm.plugin.finder.nearby.report;

import com.tencent.c.a.b.a.b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.cm;
import com.tencent.mm.plugin.finder.model.BaseFinderFeed;
import com.tencent.mm.plugin.finder.model.bu;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.protocal.protobuf.bku;
import com.tencent.mm.protocal.protobuf.cve;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/nearby/report/NearbyReadFeedRecorder;", "Lcom/tencent/plugin/finder/nearby/api/INearbyReadFeedRecorder;", "()V", "TAG", "", "lastRspExposeStartListForLive", "Ljava/util/LinkedList;", "Lcom/tencent/mm/protocal/protobuf/MarkReadStat;", "lastRspExposeStartListForLiveMore", "lastRspExposeStartListForVideo", "lastRspListForLive", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "lastRspListForLiveMore", "lastRspListForVideo", "lastRspReadListForLive", "lastRspReadListForLiveMore", "lastRspReadListForVideo", "lastUnReadList", "Lcom/tencent/mm/protocal/protobuf/FinderUnreadItem;", "clear", "", "getExposeStartList", "", "commentScene", "", "getLastRspList", "", "getReadList", "getReadListByCommentScene", "getTabType", "getUnreadList", "tabTypeField", "isNearbyCommentScene", "", "onItemExposeStart", "item", "onItemExposed", "list", "printLastRspList", "printReadList", "printUnreadList", "recordLastRsp", "plugin-finder-nearby_release"})
public final class d
  implements b
{
  private static final String TAG = "NearbyReadFeedRecorder";
  private static final LinkedList<bu> zJc;
  private static final LinkedList<cve> zJd;
  private static final LinkedList<cve> zJe;
  private static final LinkedList<bu> zJf;
  private static final LinkedList<cve> zJg;
  private static final LinkedList<cve> zJh;
  private static final LinkedList<bu> zJi;
  private static final LinkedList<cve> zJj;
  private static final LinkedList<cve> zJk;
  private static final LinkedList<bku> zJl;
  public static final d zJm;
  
  static
  {
    AppMethodBeat.i(199607);
    zJm = new d();
    TAG = "NearbyReadFeedRecorder";
    zJc = new LinkedList();
    zJd = new LinkedList();
    zJe = new LinkedList();
    zJf = new LinkedList();
    zJg = new LinkedList();
    zJh = new LinkedList();
    zJi = new LinkedList();
    zJj = new LinkedList();
    zJk = new LinkedList();
    zJl = new LinkedList();
    AppMethodBeat.o(199607);
  }
  
  public static int OH(int paramInt)
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
  
  private static List<cve> OI(int paramInt)
  {
    AppMethodBeat.i(199588);
    switch (paramInt)
    {
    default: 
      localList = (List)new LinkedList();
      AppMethodBeat.o(199588);
      return localList;
    case 15: 
      localList = (List)zJh;
      AppMethodBeat.o(199588);
      return localList;
    case 76: 
    case 94: 
      localList = (List)zJe;
      AppMethodBeat.o(199588);
      return localList;
    }
    List localList = (List)zJk;
    AppMethodBeat.o(199588);
    return localList;
  }
  
  private static List<cve> OJ(int paramInt)
  {
    AppMethodBeat.i(199593);
    switch (paramInt)
    {
    default: 
      localList = (List)new LinkedList();
      AppMethodBeat.o(199593);
      return localList;
    case 15: 
      localList = (List)zJg;
      AppMethodBeat.o(199593);
      return localList;
    case 76: 
    case 94: 
      localList = (List)zJd;
      AppMethodBeat.o(199593);
      return localList;
    }
    List localList = (List)zJj;
    AppMethodBeat.o(199593);
    return localList;
  }
  
  private static List<bu> OK(int paramInt)
  {
    AppMethodBeat.i(199595);
    switch (paramInt)
    {
    default: 
      localList = (List)new LinkedList();
      AppMethodBeat.o(199595);
      return localList;
    case 15: 
      localList = (List)zJf;
      AppMethodBeat.o(199595);
      return localList;
    case 76: 
    case 94: 
      localList = (List)zJc;
      AppMethodBeat.o(199595);
      return localList;
    }
    List localList = (List)zJi;
    AppMethodBeat.o(199595);
    return localList;
  }
  
  public static void a(int paramInt, cve paramcve)
  {
    AppMethodBeat.i(199556);
    p.k(paramcve, "item");
    OJ(paramInt).add(paramcve);
    AppMethodBeat.o(199556);
  }
  
  public static void clear()
  {
    AppMethodBeat.i(199584);
    zJc.clear();
    zJd.clear();
    zJe.clear();
    zJf.clear();
    zJg.clear();
    zJh.clear();
    zJi.clear();
    zJj.clear();
    zJk.clear();
    zJl.clear();
    AppMethodBeat.o(199584);
  }
  
  private static void eC(List<? extends bu> paramList)
  {
    AppMethodBeat.i(199598);
    Log.d(TAG, "printLastRspList size:" + paramList.size());
    if (BuildInfo.DEBUG)
    {
      paramList = ((Iterable)paramList).iterator();
      while (paramList.hasNext())
      {
        bu localbu = (bu)paramList.next();
        Log.d(TAG, "printLastRspList: " + localbu.mf() + ' ' + localbu.bAQ());
      }
    }
    AppMethodBeat.o(199598);
  }
  
  private static void eD(List<? extends cve> paramList)
  {
    AppMethodBeat.i(199600);
    Log.d(TAG, "printReadList size:" + paramList.size());
    if (BuildInfo.DEBUG)
    {
      paramList = ((Iterable)paramList).iterator();
      while (paramList.hasNext())
      {
        cve localcve = (cve)paramList.next();
        Log.d(TAG, "printReadList: " + localcve.TCM + ' ' + localcve.xbk + ' ' + localcve.TCN + ' ');
      }
    }
    AppMethodBeat.o(199600);
  }
  
  private static void eE(List<? extends bku> paramList)
  {
    AppMethodBeat.i(199604);
    Log.d(TAG, "printUnreadList size:" + paramList.size());
    if (BuildInfo.DEBUG)
    {
      paramList = ((Iterable)paramList).iterator();
      while (paramList.hasNext())
      {
        bku localbku = (bku)paramList.next();
        Log.d(TAG, "printUnreadList: " + localbku.xbk + ' ' + localbku.fEH);
      }
    }
    AppMethodBeat.o(199604);
  }
  
  public static void k(int paramInt, List<? extends cve> paramList)
  {
    AppMethodBeat.i(199558);
    p.k(paramList, "list");
    Iterator localIterator1 = ((Iterable)OK(paramInt)).iterator();
    label145:
    if (localIterator1.hasNext())
    {
      bu localbu = (bu)localIterator1.next();
      Iterator localIterator2 = ((Iterable)paramList).iterator();
      label58:
      label189:
      label194:
      label201:
      label204:
      for (;;)
      {
        cve localcve;
        int i;
        label109:
        int j;
        if (localIterator2.hasNext())
        {
          localcve = (cve)localIterator2.next();
          if (localbu.mf() != localcve.xbk) {
            continue;
          }
          Iterator localIterator3 = OI(paramInt).iterator();
          i = 0;
          if (!localIterator3.hasNext()) {
            break label201;
          }
          if (((cve)localIterator3.next()).xbk != localbu.mf()) {
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
          if ((localbu instanceof BaseFinderFeed)) {
            localcve.sessionBuffer = ((BaseFinderFeed)localbu).getSessionBuffer();
          }
          OI(paramInt).add(localcve);
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
    AppMethodBeat.o(199558);
  }
  
  public static void l(int paramInt, List<? extends bu> paramList)
  {
    AppMethodBeat.i(199560);
    p.k(paramList, "list");
    Log.d(TAG, "recordLastRsp commentScene:" + paramInt + " size:" + paramList.size());
    switch (paramInt)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(199560);
      return;
      zJh.clear();
      zJg.clear();
      zJf.clear();
      zJf.addAll((Collection)paramList);
      AppMethodBeat.o(199560);
      return;
      zJe.clear();
      zJd.clear();
      zJc.clear();
      zJc.addAll((Collection)paramList);
      AppMethodBeat.o(199560);
      return;
      zJk.clear();
      zJj.clear();
      zJi.clear();
      zJi.addAll((Collection)paramList);
    }
  }
  
  public final List<cve> OF(int paramInt)
  {
    AppMethodBeat.i(199567);
    List localList = OI(paramInt);
    Iterator localIterator1 = ((Iterable)OJ(paramInt)).iterator();
    if (localIterator1.hasNext())
    {
      cve localcve = (cve)localIterator1.next();
      Iterator localIterator2 = ((Iterable)OK(paramInt)).iterator();
      label145:
      label290:
      label295:
      label302:
      label305:
      for (;;)
      {
        label62:
        bu localbu;
        int i;
        label111:
        int j;
        if (localIterator2.hasNext())
        {
          localbu = (bu)localIterator2.next();
          if (localcve.xbk != localbu.mf()) {
            continue;
          }
          Iterator localIterator3 = localList.iterator();
          i = 0;
          if (!localIterator3.hasNext()) {
            break label302;
          }
          if (((cve)localIterator3.next()).xbk != localcve.xbk) {
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
          i = localcve.TCN;
          long l = cm.bfE();
          localcve.TCN = ((int)(l - i));
          if ((localbu instanceof BaseFinderFeed)) {
            localcve.sessionBuffer = ((BaseFinderFeed)localbu).getSessionBuffer();
          }
          Log.d(TAG, "expose id:" + localcve.xbk + " expose[" + i + ", " + l + "] exposeTime:" + localcve.TCN + " seesion:" + localcve.sessionBuffer + ' ');
          localList.add(localcve);
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
    AppMethodBeat.o(199567);
    return localList;
  }
  
  public final boolean OG(int paramInt)
  {
    boolean bool = true;
    switch (paramInt)
    {
    default: 
      bool = false;
    }
    return bool;
  }
  
  public final List<bku> gN(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(199576);
    zJl.clear();
    Object localObject1 = ((Iterable)OK(paramInt1)).iterator();
    label76:
    label229:
    label239:
    while (((Iterator)localObject1).hasNext())
    {
      Object localObject2 = (bu)((Iterator)localObject1).next();
      if ((localObject2 instanceof BaseFinderFeed))
      {
        BaseFinderFeed localBaseFinderFeed = (BaseFinderFeed)localObject2;
        Iterator localIterator = OI(paramInt1).iterator();
        int i = 0;
        int j;
        if (localIterator.hasNext()) {
          if (((cve)localIterator.next()).xbk == ((bu)localObject2).mf())
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
          localObject2 = new bku();
          ((bku)localObject2).xbk = localBaseFinderFeed.feedObject.getFeedObject().id;
          ((bku)localObject2).objectNonceId = localBaseFinderFeed.feedObject.getFeedObject().objectNonceId;
          ((bku)localObject2).fEH = paramInt2;
          ((bku)localObject2).sessionBuffer = localBaseFinderFeed.feedObject.getFeedObject().sessionBuffer;
          ((bku)localObject2).xbk = localBaseFinderFeed.feedObject.getId();
          ((bku)localObject2).objectNonceId = localBaseFinderFeed.feedObject.getObjectNonceId();
          zJl.add(localObject2);
          break;
          j = 0;
          break label113;
          i += 1;
          break label76;
          i = -1;
        }
      }
    }
    eC(OK(paramInt1));
    eD(OI(paramInt1));
    eE((List)zJl);
    localObject1 = (List)zJl;
    AppMethodBeat.o(199576);
    return localObject1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.nearby.report.d
 * JD-Core Version:    0.7.0.1
 */