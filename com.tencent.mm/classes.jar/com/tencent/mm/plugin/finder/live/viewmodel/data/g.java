package com.tencent.mm.plugin.finder.live.viewmodel.data;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.live.api.LiveConfig;
import com.tencent.mm.plugin.finder.feed.model.internal.k;
import com.tencent.mm.plugin.finder.live.model.FinderLiveBundle;
import com.tencent.mm.plugin.finder.live.model.context.a;
import com.tencent.mm.plugin.finder.live.viewmodel.data.business.b;
import com.tencent.mm.plugin.findersdk.a.ak;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.protocal.protobuf.awk;
import com.tencent.mm.protocal.protobuf.awq;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.o;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/live/viewmodel/data/FinderLiveDataModel;", "", "()V", "TAG", "", "getTAG", "()Ljava/lang/String;", "value", "", "curPos", "getCurPos", "()I", "setCurPos", "(I)V", "finderLiveConfig", "Lcom/tencent/mm/plugin/finder/live/model/FinderLiveBundle;", "getFinderLiveConfig", "()Lcom/tencent/mm/plugin/finder/live/model/FinderLiveBundle;", "setFinderLiveConfig", "(Lcom/tencent/mm/plugin/finder/live/model/FinderLiveBundle;)V", "liveDataList", "Ljava/util/ArrayList;", "Lcom/tencent/mm/plugin/finder/live/viewmodel/data/FinderLiveData;", "Lkotlin/collections/ArrayList;", "getLiveDataList", "()Ljava/util/ArrayList;", "setLiveDataList", "(Ljava/util/ArrayList;)V", "loaderParams", "Lcom/tencent/mm/plugin/finder/live/viewmodel/data/FinderLiveRelatedLoaderParam;", "getLoaderParams", "()Lcom/tencent/mm/plugin/finder/live/viewmodel/data/FinderLiveRelatedLoaderParam;", "setLoaderParams", "(Lcom/tencent/mm/plugin/finder/live/viewmodel/data/FinderLiveRelatedLoaderParam;)V", "canFlingUp", "", "canLoadMore", "flingUpTab", "info", "mergeLiveData", "remote", "", "parseLiveConfigList", "", "parseLoaderParams", "tabType", "commentScene", "pullMoreType", "lbsTabTipsInfo", "Lcom/tencent/mm/protocal/protobuf/FinderLbsTabTipsInfo;", "targetFeedObject", "Lcom/tencent/mm/protocal/protobuf/FinderObject;", "toString", "Companion", "plugin-finder-base_release"})
public final class g
{
  private static HashMap<Integer, com.tencent.mm.plugin.appbrand.api.g> zeC;
  public static final a zeD;
  private final String TAG;
  public j xVT;
  private int yeA;
  public ArrayList<f> zeA;
  public FinderLiveBundle zeB;
  
  static
  {
    AppMethodBeat.i(261804);
    zeD = new a((byte)0);
    zeC = new HashMap();
    AppMethodBeat.o(261804);
  }
  
  public g()
  {
    AppMethodBeat.i(261801);
    this.TAG = ("FinderLiveDataModel@" + hashCode());
    this.zeA = new ArrayList();
    AppMethodBeat.o(261801);
  }
  
  public final void NU(int paramInt)
  {
    AppMethodBeat.i(261783);
    this.yeA = paramInt;
    Log.i(this.TAG, "set curPos :" + this.yeA);
    AppMethodBeat.o(261783);
  }
  
  public final void a(FinderLiveBundle paramFinderLiveBundle)
  {
    AppMethodBeat.i(261790);
    p.k(paramFinderLiveBundle, "finderLiveConfig");
    this.zeB = paramFinderLiveBundle;
    NU(paramFinderLiveBundle.yeA);
    int i = paramFinderLiveBundle.fEH;
    int j = paramFinderLiveBundle.xkX;
    int k = paramFinderLiveBundle.yeH;
    Object localObject1 = paramFinderLiveBundle.xdb;
    Object localObject2 = paramFinderLiveBundle.yeL;
    Object localObject3 = com.tencent.mm.ui.component.g.Xox;
    localObject3 = ((com.tencent.mm.plugin.finder.api.f)com.tencent.mm.ui.component.g.bD(ak.class).bE(com.tencent.mm.plugin.finder.api.f.class)).dnl();
    j localj = new j();
    localj.zeN = ((Number)((o)localObject3).Mx).floatValue();
    localj.lLr = ((Number)((o)localObject3).My).floatValue();
    localj.scene = 7;
    localj.xkX = j;
    localj.fEH = i;
    localj.yeH = k;
    localj.xdb = ((awq)localObject1);
    localj.wmL = localj.wmL;
    localj.yeL = ((FinderObject)localObject2);
    this.xVT = localj;
    localObject2 = (Iterable)paramFinderLiveBundle.yeC;
    localObject1 = (Collection)new ArrayList(kotlin.a.j.a((Iterable)localObject2, 10));
    localObject2 = ((Iterable)localObject2).iterator();
    while (((Iterator)localObject2).hasNext()) {
      ((Collection)localObject1).add(new f((LiveConfig)((Iterator)localObject2).next()));
    }
    this.zeA = new ArrayList((Collection)localObject1);
    long l;
    if ((this.zeA.size() > 0) && (((f)this.zeA.get(0)).zey.aJp()) && (paramFinderLiveBundle.xdb != null))
    {
      localObject1 = new awk();
      localObject2 = paramFinderLiveBundle.xdb;
      if (localObject2 == null) {
        break label436;
      }
      l = ((awq)localObject2).SJc;
      ((awk)localObject1).SJc = l;
      paramFinderLiveBundle = paramFinderLiveBundle.xdb;
      if (paramFinderLiveBundle == null) {
        break label442;
      }
    }
    label436:
    label442:
    for (paramFinderLiveBundle = paramFinderLiveBundle.SJd;; paramFinderLiveBundle = null)
    {
      ((awk)localObject1).SJd = paramFinderLiveBundle;
      ((b)((f)this.zeA.get(0)).xWR.business(b.class)).zgG = ((awk)localObject1);
      ((b)((f)this.zeA.get(0)).xWR.business(b.class)).kis = ((f)this.zeA.get(0)).zey.aJp();
      AppMethodBeat.o(261790);
      return;
      l = 0L;
      break;
    }
  }
  
  public final void aj(ArrayList<f> paramArrayList)
  {
    AppMethodBeat.i(261785);
    p.k(paramArrayList, "<set-?>");
    this.zeA = paramArrayList;
    AppMethodBeat.o(261785);
  }
  
  public final int ew(List<f> paramList)
  {
    AppMethodBeat.i(261795);
    ArrayList localArrayList = this.zeA;
    LinkedList localLinkedList = new LinkedList();
    int i;
    if (paramList != null)
    {
      localObject1 = ((Iterable)paramList).iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (f)((Iterator)localObject1).next();
        Iterator localIterator = ((List)localArrayList).iterator();
        i = 0;
        label72:
        int j;
        label105:
        label111:
        label125:
        int k;
        if (localIterator.hasNext()) {
          if (((f)localIterator.next()).a((k)localObject2) == 0)
          {
            j = 1;
            if (j == 0) {
              break label190;
            }
            j = i;
            localIterator = ((List)localLinkedList).iterator();
            i = 0;
            if (!localIterator.hasNext()) {
              break label215;
            }
            if (((f)localIterator.next()).a((k)localObject2) != 0) {
              break label202;
            }
            k = 1;
            label159:
            if (k == 0) {
              break label208;
            }
          }
        }
        for (;;)
        {
          if ((j != -1) || (i != -1)) {
            break label220;
          }
          localLinkedList.add(localObject2);
          break;
          j = 0;
          break label105;
          label190:
          i += 1;
          break label72;
          j = -1;
          break label111;
          label202:
          k = 0;
          break label159;
          label208:
          i += 1;
          break label125;
          label215:
          i = -1;
        }
        label220:
        if (j != -1) {
          Log.i(this.TAG, "[mergeLiveData] localList same feed:[" + (f)this.zeA.get(j) + "], just ignore this feed=" + localObject2 + " existIndex=" + j + " existIndexInIncrementList=" + i);
        } else {
          Log.i(this.TAG, "[mergeLiveData] newList same feed:[" + (f)localLinkedList.get(i) + "], just ignore this feed=" + localObject2 + " existIndex=" + j + " existIndexInIncrementList=" + i);
        }
      }
    }
    Object localObject1 = this.TAG;
    Object localObject2 = new StringBuilder("remote size:");
    if (paramList != null) {}
    for (paramList = Integer.valueOf(paramList.size());; paramList = null)
    {
      Log.i((String)localObject1, paramList + ",locate size:" + this.zeA.size() + ",incrementList size:" + localLinkedList.size());
      localArrayList.addAll((Collection)localLinkedList);
      i = localLinkedList.size();
      AppMethodBeat.o(261795);
      return i;
    }
  }
  
  public final int getCurPos()
  {
    AppMethodBeat.i(261780);
    Log.i(this.TAG, "get curPos:" + this.yeA);
    int i = this.yeA;
    AppMethodBeat.o(261780);
    return i;
  }
  
  public final String toString()
  {
    int i = 0;
    Object localObject2 = null;
    AppMethodBeat.i(261798);
    StringBuilder localStringBuilder1 = new StringBuilder("FinderLiveDataModel(" + hashCode() + "):").append("init pos:" + getCurPos() + ';');
    StringBuilder localStringBuilder2 = new StringBuilder("loaderParams:tab:");
    Object localObject1 = this.xVT;
    label143:
    boolean bool;
    label187:
    int j;
    if (localObject1 != null)
    {
      localObject1 = Integer.valueOf(((j)localObject1).fEH);
      localStringBuilder2 = localStringBuilder2.append(localObject1).append(",objectId:");
      localObject1 = this.xVT;
      if (localObject1 == null) {
        break label267;
      }
      localObject1 = Long.valueOf(((j)localObject1).xbk);
      localStringBuilder2 = localStringBuilder2.append(localObject1).append(",lastBuf is null:");
      j localj = this.xVT;
      localObject1 = localObject2;
      if (localj != null) {
        localObject1 = localj.xaw;
      }
      if (localObject1 != null) {
        break label273;
      }
      bool = true;
      localObject1 = localStringBuilder1.append(bool + ';');
      p.j(localObject1, "StringBuilder(\"FinderLiv…rams?.lastBuf == null};\")");
      j = this.zeA.size();
      if (j > 0) {
        break label278;
      }
      ((StringBuilder)localObject1).append("live data is empty");
    }
    for (;;)
    {
      localObject1 = ((StringBuilder)localObject1).toString();
      p.j(localObject1, "msg.toString()");
      AppMethodBeat.o(261798);
      return localObject1;
      localObject1 = null;
      break;
      label267:
      localObject1 = null;
      break label143;
      label273:
      bool = false;
      break label187;
      label278:
      while (i < j)
      {
        ((StringBuilder)localObject1).append("live_" + i + ':' + (f)this.zeA.get(i));
        i += 1;
      }
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/live/viewmodel/data/FinderLiveDataModel$Companion;", "", "()V", "miniProBundle", "Ljava/util/HashMap;", "", "Lcom/tencent/mm/plugin/appbrand/api/WeAppOpenBundle;", "getMiniProBundle", "()Ljava/util/HashMap;", "setMiniProBundle", "(Ljava/util/HashMap;)V", "plugin-finder-base_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.viewmodel.data.g
 * JD-Core Version:    0.7.0.1
 */