package com.tencent.mm.plugin.finder.live.viewmodel.data;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.live.api.LiveConfig;
import com.tencent.mm.plugin.finder.live.model.FinderLiveBundle;
import com.tencent.mm.plugin.finder.live.model.context.a;
import com.tencent.mm.plugin.finder.live.viewmodel.data.business.e;
import com.tencent.mm.plugin.findersdk.a.cn;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.protocal.protobuf.avb;
import com.tencent.mm.protocal.protobuf.bcb;
import com.tencent.mm.protocal.protobuf.bcl;
import com.tencent.mm.protocal.protobuf.bkt;
import com.tencent.mm.protocal.protobuf.bmx;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.component.k.b;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.a.p;
import kotlin.g.b.s;
import kotlin.r;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/viewmodel/data/FinderLiveDataModel;", "", "()V", "TAG", "", "getTAG", "()Ljava/lang/String;", "curLiveData", "Lcom/tencent/mm/plugin/finder/live/viewmodel/data/FinderLiveData;", "getCurLiveData", "()Lcom/tencent/mm/plugin/finder/live/viewmodel/data/FinderLiveData;", "setCurLiveData", "(Lcom/tencent/mm/plugin/finder/live/viewmodel/data/FinderLiveData;)V", "value", "", "curPos", "getCurPos", "()I", "setCurPos", "(I)V", "entranceReportInfo", "Landroid/os/Bundle;", "getEntranceReportInfo", "()Landroid/os/Bundle;", "setEntranceReportInfo", "(Landroid/os/Bundle;)V", "exportIdList", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "getExportIdList", "()Ljava/util/ArrayList;", "setExportIdList", "(Ljava/util/ArrayList;)V", "exportIdMap", "Ljava/util/HashMap;", "", "getExportIdMap", "()Ljava/util/HashMap;", "setExportIdMap", "(Ljava/util/HashMap;)V", "finderLiveConfig", "Lcom/tencent/mm/plugin/finder/live/model/FinderLiveBundle;", "getFinderLiveConfig", "()Lcom/tencent/mm/plugin/finder/live/model/FinderLiveBundle;", "setFinderLiveConfig", "(Lcom/tencent/mm/plugin/finder/live/model/FinderLiveBundle;)V", "historiesLiveDataList", "historiesLiveSize", "getHistoriesLiveSize", "liveDataList", "getLiveDataList", "setLiveDataList", "liveScene", "getLiveScene", "setLiveScene", "loaderParams", "Lcom/tencent/mm/plugin/finder/live/viewmodel/data/FinderLiveRelatedLoaderParam;", "getLoaderParams", "()Lcom/tencent/mm/plugin/finder/live/viewmodel/data/FinderLiveRelatedLoaderParam;", "setLoaderParams", "(Lcom/tencent/mm/plugin/finder/live/viewmodel/data/FinderLiveRelatedLoaderParam;)V", "preJoinTips", "Lcom/tencent/mm/protocal/protobuf/FinderLivePreloadCommentInfo;", "getPreJoinTips", "()Lcom/tencent/mm/protocal/protobuf/FinderLivePreloadCommentInfo;", "setPreJoinTips", "(Lcom/tencent/mm/protocal/protobuf/FinderLivePreloadCommentInfo;)V", "appendHistoriesLiveData", "histories", "", "appendLiveData", "remote", "appendOrderLiveData", "Lkotlin/Triple;", "canFlingUp", "", "canLoadMore", "dropTailLiveData", "", "lastVisibleItemPos", "fillupExportIdMap", "newList", "flingUpTab", "info", "isHistoryLive", "live", "lastPlayItemPos", "mergeDownFilter", "", "selectedLive", "mergeFilter", "sourceList", "mergeUpFilter", "parseLiveConfigList", "parseLiveConfigListWithCurLiveAhead", "curLiveId", "lastLiveData", "parseLoaderParams", "tabType", "commentScene", "pullMoreType", "lbsTabTipsInfo", "Lcom/tencent/mm/protocal/protobuf/FinderLbsTabTipsInfo;", "targetFeedObject", "Lcom/tencent/mm/protocal/protobuf/FinderObject;", "byPass", "Lcom/tencent/mm/protocal/protobuf/FinderCommByPass;", "enterScene", "contextId", "squareEntranceInfo", "Lcom/tencent/mm/protocal/protobuf/FinderLiveSquareEntranceInfo;", "replaceTailLiveData", "simpleLiveList", "liveList", "toString", "Companion", "plugin-finder-base_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class g
{
  private static HashMap<Integer, com.tencent.mm.plugin.appbrand.api.g> EbA;
  private static int EbB;
  public static final a Ebv;
  public j Bwy;
  private int CEY;
  private ArrayList<String> CFk;
  public HashMap<Long, String> CFl;
  public Bundle CFn;
  public ArrayList<f> Ebw;
  public ArrayList<f> Ebx;
  public FinderLiveBundle Eby;
  public bkt Ebz;
  public final String TAG;
  public int mRN;
  
  static
  {
    AppMethodBeat.i(356609);
    Ebv = new a((byte)0);
    EbA = new HashMap();
    EbB = 60000;
    AppMethodBeat.o(356609);
  }
  
  public g()
  {
    AppMethodBeat.i(356577);
    this.TAG = s.X("FinderLiveDataModel@", Integer.valueOf(hashCode()));
    this.Ebw = new ArrayList();
    this.Ebx = new ArrayList();
    this.CFl = new HashMap();
    this.CFk = new ArrayList();
    AppMethodBeat.o(356577);
  }
  
  public static String gV(List<f> paramList)
  {
    AppMethodBeat.i(356588);
    StringBuilder localStringBuilder = new StringBuilder();
    paramList = ((Iterable)paramList).iterator();
    int i = 0;
    while (paramList.hasNext())
    {
      Object localObject = paramList.next();
      if (i < 0) {
        p.kkW();
      }
      localObject = (f)localObject;
      localStringBuilder.append("******" + i + ':').append(((f)localObject).exV());
      i += 1;
    }
    paramList = localStringBuilder.toString();
    s.s(paramList, "sb.toString()");
    AppMethodBeat.o(356588);
    return paramList;
  }
  
  public static List<f> w(List<f> paramList1, List<f> paramList2)
  {
    AppMethodBeat.i(356584);
    LinkedList localLinkedList = new LinkedList();
    paramList2 = ((Iterable)paramList2).iterator();
    label55:
    label185:
    label191:
    label198:
    label201:
    while (paramList2.hasNext())
    {
      f localf = (f)paramList2.next();
      Iterator localIterator = paramList1.iterator();
      int i = 0;
      int j;
      label88:
      label94:
      label108:
      int k;
      if (localIterator.hasNext()) {
        if (((f)localIterator.next()).a((com.tencent.mm.plugin.finder.feed.model.internal.k)localf) == 0)
        {
          j = 1;
          if (j == 0) {
            break label173;
          }
          j = i;
          localIterator = ((List)localLinkedList).iterator();
          i = 0;
          if (!localIterator.hasNext()) {
            break label198;
          }
          if (((f)localIterator.next()).a((com.tencent.mm.plugin.finder.feed.model.internal.k)localf) != 0) {
            break label185;
          }
          k = 1;
          if (k == 0) {
            break label191;
          }
        }
      }
      for (;;)
      {
        if ((j != -1) || (i != -1)) {
          break label201;
        }
        localLinkedList.add(localf);
        break;
        j = 0;
        break label88;
        i += 1;
        break label55;
        j = -1;
        break label94;
        k = 0;
        break label142;
        i += 1;
        break label108;
        i = -1;
      }
    }
    label142:
    label173:
    paramList1 = (List)localLinkedList;
    AppMethodBeat.o(356584);
    return paramList1;
  }
  
  public final void PV(int paramInt)
  {
    AppMethodBeat.i(356621);
    this.CEY = paramInt;
    Log.i(this.TAG, s.X("set curPos :", Integer.valueOf(this.CEY)));
    AppMethodBeat.o(356621);
  }
  
  public final List<f> a(f paramf, List<f> paramList)
  {
    int k = 0;
    AppMethodBeat.i(356683);
    LinkedList localLinkedList1 = new LinkedList();
    LinkedList localLinkedList2 = new LinkedList();
    paramList = ((Iterable)paramList).iterator();
    label71:
    int j;
    label132:
    label142:
    while (paramList.hasNext())
    {
      f localf = (f)paramList.next();
      Iterator localIterator = ((List)localLinkedList2).iterator();
      i = 0;
      if (localIterator.hasNext()) {
        if (((f)localIterator.next()).a((com.tencent.mm.plugin.finder.feed.model.internal.k)localf) == 0)
        {
          j = 1;
          label105:
          if (j == 0) {
            break label132;
          }
        }
      }
      for (;;)
      {
        if (i != -1) {
          break label142;
        }
        localLinkedList2.add(localf);
        break;
        j = 0;
        break label105;
        i += 1;
        break label71;
        i = -1;
      }
    }
    paramList = ((List)localLinkedList2).iterator();
    int i = 0;
    if (paramList.hasNext()) {
      if (((f)paramList.next()).a((com.tencent.mm.plugin.finder.feed.model.internal.k)paramf) == 0)
      {
        j = 1;
        label188:
        if (j == 0) {
          break label278;
        }
      }
    }
    for (;;)
    {
      if ((i < 0) || (i >= localLinkedList2.size())) {
        break label290;
      }
      paramf = ((Iterable)localLinkedList2).iterator();
      j = k;
      while (paramf.hasNext())
      {
        paramList = paramf.next();
        if (j < 0) {
          p.kkW();
        }
        paramList = (f)paramList;
        if (j < i) {
          localLinkedList1.add(paramList);
        }
        j += 1;
      }
      j = 0;
      break label188;
      label278:
      i += 1;
      break;
      i = -1;
    }
    label290:
    Log.i(this.TAG, "mergeUpFilter initIndex:" + i + ", resultList.size:" + localLinkedList1.size());
    paramf = (List)localLinkedList1;
    AppMethodBeat.o(356683);
    return paramf;
  }
  
  public final void a(FinderLiveBundle paramFinderLiveBundle)
  {
    AppMethodBeat.i(356654);
    s.u(paramFinderLiveBundle, "finderLiveConfig");
    this.Eby = paramFinderLiveBundle;
    this.mRN = paramFinderLiveBundle.enterScene;
    this.CFl = paramFinderLiveBundle.CFl;
    this.CFk = paramFinderLiveBundle.CFk;
    this.CFn = paramFinderLiveBundle.CFn;
    PV(paramFinderLiveBundle.CEY);
    int i = paramFinderLiveBundle.hJx;
    int j = paramFinderLiveBundle.AJo;
    int k = paramFinderLiveBundle.CFf;
    Object localObject1 = paramFinderLiveBundle.ACt;
    Object localObject2 = paramFinderLiveBundle.CFj;
    avb localavb = paramFinderLiveBundle.ACu;
    int m = paramFinderLiveBundle.enterScene;
    String str = paramFinderLiveBundle.zIO;
    bmx localbmx = paramFinderLiveBundle.CFm;
    Object localObject3 = com.tencent.mm.ui.component.k.aeZF;
    localObject3 = ((com.tencent.mm.plugin.finder.api.g)com.tencent.mm.ui.component.k.cn(cn.class).cq(com.tencent.mm.plugin.finder.api.g.class)).dUh();
    j localj = new j();
    localj.EbM = ((Number)((r)localObject3).bsC).floatValue();
    localj.oDT = ((Number)((r)localObject3).bsD).floatValue();
    localj.scene = 7;
    localj.AJo = j;
    localj.hJx = i;
    localj.CFf = k;
    localj.ACt = ((bcl)localObject1);
    localj.zIO = str;
    localj.CFj = ((FinderObject)localObject2);
    localj.ACu = localavb;
    localj.enterScene = m;
    localj.ACw = localbmx;
    this.Bwy = localj;
    localObject2 = (Iterable)paramFinderLiveBundle.CFa;
    localObject1 = (Collection)new ArrayList(p.a((Iterable)localObject2, 10));
    localObject2 = ((Iterable)localObject2).iterator();
    while (((Iterator)localObject2).hasNext()) {
      ((Collection)localObject1).add(new f((LiveConfig)((Iterator)localObject2).next()));
    }
    an(new ArrayList((Collection)localObject1));
    long l;
    if ((this.Ebx.size() > 0) && (((f)this.Ebx.get(0)).Ebr.mIR) && (paramFinderLiveBundle.ACt != null))
    {
      localObject1 = new bcb();
      localObject2 = paramFinderLiveBundle.ACt;
      if (localObject2 != null) {
        break label524;
      }
      l = 0L;
      ((bcb)localObject1).ZNj = l;
      paramFinderLiveBundle = paramFinderLiveBundle.ACt;
      if (paramFinderLiveBundle != null) {
        break label534;
      }
    }
    label524:
    label534:
    for (paramFinderLiveBundle = null;; paramFinderLiveBundle = paramFinderLiveBundle.ZwY)
    {
      ((bcb)localObject1).ZwY = paramFinderLiveBundle;
      ((f)this.Ebx.get(0)).Ebs = ((bcb)localObject1);
      ((e)((f)this.Ebx.get(0)).BxG.business(e.class)).Ebs = ((bcb)localObject1);
      ((e)((f)this.Ebx.get(0)).BxG.business(e.class)).mIR = ((f)this.Ebx.get(0)).Ebr.mIR;
      AppMethodBeat.o(356654);
      return;
      l = ((bcl)localObject2).ZNj;
      break;
    }
  }
  
  public final void a(FinderLiveBundle paramFinderLiveBundle, long paramLong, g paramg)
  {
    Iterator localIterator = null;
    AppMethodBeat.i(356664);
    s.u(paramFinderLiveBundle, "finderLiveConfig");
    if (paramg == null)
    {
      paramg = localIterator;
      a(paramFinderLiveBundle);
      if (paramg == null) {
        AppMethodBeat.o(356664);
      }
    }
    else
    {
      localIterator = ((Iterable)paramg.Ebx).iterator();
      label57:
      int i;
      if (localIterator.hasNext())
      {
        paramg = localIterator.next();
        if (((f)paramg).Ebr.liveId == paramLong)
        {
          i = 1;
          label95:
          if (i == 0) {
            break label114;
          }
        }
      }
      for (;;)
      {
        paramg = (f)paramg;
        break;
        i = 0;
        break label95;
        label114:
        break label57;
        paramg = null;
      }
    }
    this.Ebx.add(0, paramg);
    AppMethodBeat.o(356664);
  }
  
  public final void an(ArrayList<f> paramArrayList)
  {
    AppMethodBeat.i(356638);
    s.u(paramArrayList, "value");
    this.Ebx = paramArrayList;
    this.Ebw.clear();
    AppMethodBeat.o(356638);
  }
  
  public final List<f> b(f paramf, List<f> paramList)
  {
    int k = 0;
    AppMethodBeat.i(356694);
    LinkedList localLinkedList1 = new LinkedList();
    LinkedList localLinkedList2 = new LinkedList();
    paramList = ((Iterable)paramList).iterator();
    label71:
    int j;
    label132:
    label142:
    while (paramList.hasNext())
    {
      f localf = (f)paramList.next();
      Iterator localIterator = ((List)localLinkedList2).iterator();
      i = 0;
      if (localIterator.hasNext()) {
        if (((f)localIterator.next()).a((com.tencent.mm.plugin.finder.feed.model.internal.k)localf) == 0)
        {
          j = 1;
          label105:
          if (j == 0) {
            break label132;
          }
        }
      }
      for (;;)
      {
        if (i != -1) {
          break label142;
        }
        localLinkedList2.add(localf);
        break;
        j = 0;
        break label105;
        i += 1;
        break label71;
        i = -1;
      }
    }
    paramList = ((List)localLinkedList2).iterator();
    int i = 0;
    if (paramList.hasNext()) {
      if (((f)paramList.next()).a((com.tencent.mm.plugin.finder.feed.model.internal.k)paramf) == 0)
      {
        j = 1;
        label188:
        if (j == 0) {
          break label278;
        }
      }
    }
    for (;;)
    {
      if ((i < 0) || (i >= localLinkedList2.size())) {
        break label290;
      }
      paramf = ((Iterable)localLinkedList2).iterator();
      j = k;
      while (paramf.hasNext())
      {
        paramList = paramf.next();
        if (j < 0) {
          p.kkW();
        }
        paramList = (f)paramList;
        if (j > i) {
          localLinkedList1.add(paramList);
        }
        j += 1;
      }
      j = 0;
      break label188;
      label278:
      i += 1;
      break;
      i = -1;
    }
    label290:
    Log.i(this.TAG, "mergeDownFilter initIndex:" + i + ", resultList.size:" + localLinkedList1.size());
    paramf = (List)localLinkedList1;
    AppMethodBeat.o(356694);
    return paramf;
  }
  
  public final f exW()
  {
    int j = 0;
    AppMethodBeat.i(356628);
    int k = this.Ebx.size();
    int m = getCurPos();
    int i = j;
    if (m >= 0)
    {
      i = j;
      if (m < k) {
        i = 1;
      }
    }
    if (i != 0)
    {
      f localf = (f)p.ae((List)this.Ebx, getCurPos());
      AppMethodBeat.o(356628);
      return localf;
    }
    AppMethodBeat.o(356628);
    return null;
  }
  
  public final int gT(List<f> paramList)
  {
    AppMethodBeat.i(356671);
    Object localObject2 = (List)this.Ebx;
    Object localObject1;
    StringBuilder localStringBuilder;
    if (paramList == null)
    {
      localObject1 = (List)new ArrayList();
      localObject1 = w((List)localObject2, (List)localObject1);
      this.Ebx.addAll((Collection)localObject1);
      localObject2 = this.TAG;
      localStringBuilder = new StringBuilder("#appendLiveData remoteSize=");
      if (paramList != null) {
        break label138;
      }
    }
    label138:
    for (paramList = null;; paramList = Integer.valueOf(paramList.size()))
    {
      Log.i((String)localObject2, paramList + ", after filter size " + ((List)localObject1).size() + ", now liveDataList.size=" + this.Ebx.size());
      int i = ((List)localObject1).size();
      AppMethodBeat.o(356671);
      return i;
      localObject1 = paramList;
      break;
    }
  }
  
  public final void gU(List<f> paramList)
  {
    AppMethodBeat.i(356703);
    int k;
    if (paramList != null)
    {
      k = kotlin.k.k.qv(paramList.size(), this.CFk.size());
      if (k <= 0) {}
    }
    int j;
    for (int i = 0;; i = j)
    {
      j = i + 1;
      Map localMap = (Map)this.CFl;
      long l = ((f)paramList.get(i)).Ebr.liveId;
      Object localObject = this.CFk.get(i);
      s.s(localObject, "exportIdList[i]");
      localMap.put(Long.valueOf(l), localObject);
      if (j >= k)
      {
        Log.i(this.TAG, "fillupExportIdMap " + this.CFl + " exportIdList.size:" + this.CFk.size() + " newList.size:" + paramList.size());
        AppMethodBeat.o(356703);
        return;
      }
    }
  }
  
  public final int getCurPos()
  {
    AppMethodBeat.i(356615);
    Log.i(this.TAG, s.X("get curPos:", Integer.valueOf(this.CEY)));
    int i = this.CEY;
    AppMethodBeat.o(356615);
    return i;
  }
  
  public final String toString()
  {
    int i = 0;
    Object localObject2 = null;
    AppMethodBeat.i(356713);
    StringBuilder localStringBuilder1 = new StringBuilder("FinderLiveDataModel(" + hashCode() + "):").append("init pos:" + getCurPos() + ';');
    StringBuilder localStringBuilder2 = new StringBuilder("loaderParams:tab:");
    Object localObject1 = this.Bwy;
    if (localObject1 == null)
    {
      localObject1 = null;
      localStringBuilder2 = localStringBuilder2.append(localObject1).append(",objectId:");
      localObject1 = this.Bwy;
      if (localObject1 != null) {
        break label245;
      }
      localObject1 = null;
      label129:
      localStringBuilder2 = localStringBuilder2.append(localObject1).append(",lastBuf is null:");
      localObject1 = this.Bwy;
      if (localObject1 != null) {
        break label258;
      }
      localObject1 = localObject2;
      label159:
      if (localObject1 != null) {
        break label268;
      }
    }
    int j;
    label258:
    label268:
    for (boolean bool = true;; bool = false)
    {
      localObject1 = localStringBuilder1.append(bool + ';');
      j = this.Ebx.size();
      if (j > 0) {
        break label273;
      }
      ((StringBuilder)localObject1).append("live data is empty");
      localObject1 = ((StringBuilder)localObject1).toString();
      s.s(localObject1, "msg.toString()");
      AppMethodBeat.o(356713);
      return localObject1;
      localObject1 = Integer.valueOf(((j)localObject1).hJx);
      break;
      label245:
      localObject1 = Long.valueOf(((j)localObject1).hKN);
      break label129;
      localObject1 = ((j)localObject1).AyB;
      break label159;
    }
    label273:
    while (i < j)
    {
      ((StringBuilder)localObject1).append("live_" + i + ':' + this.Ebx.get(i));
      i += 1;
    }
    localObject1 = ((StringBuilder)localObject1).toString();
    s.s(localObject1, "msg.toString()");
    AppMethodBeat.o(356713);
    return localObject1;
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/viewmodel/data/FinderLiveDataModel$Companion;", "", "()V", "miniProBundle", "Ljava/util/HashMap;", "", "Lcom/tencent/mm/plugin/appbrand/api/WeAppOpenBundle;", "getMiniProBundle", "()Ljava/util/HashMap;", "setMiniProBundle", "(Ljava/util/HashMap;)V", "visitorWatchLiveThresholdMS", "getVisitorWatchLiveThresholdMS", "()I", "setVisitorWatchLiveThresholdMS", "(I)V", "plugin-finder-base_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes13.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.viewmodel.data.g
 * JD-Core Version:    0.7.0.1
 */