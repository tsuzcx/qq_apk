package com.tencent.mm.plugin.finder.live.viewmodel;

import android.arch.lifecycle.ViewModelProvider;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.live.api.LiveConfig;
import com.tencent.mm.plugin.appbrand.api.g;
import com.tencent.mm.plugin.finder.PluginFinder;
import com.tencent.mm.plugin.finder.feed.model.internal.i;
import com.tencent.mm.plugin.finder.live.model.FinderLiveConfig;
import com.tencent.mm.plugin.finder.viewmodel.FinderGlobalLocationVM;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.component.a;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import kotlin.a.j;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.o;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/live/viewmodel/FinderLiveDataModel;", "", "()V", "TAG", "", "getTAG", "()Ljava/lang/String;", "value", "", "initPos", "getInitPos", "()I", "setInitPos", "(I)V", "liveDataList", "Ljava/util/ArrayList;", "Lcom/tencent/mm/plugin/finder/live/viewmodel/FinderLiveData;", "Lkotlin/collections/ArrayList;", "getLiveDataList", "()Ljava/util/ArrayList;", "setLiveDataList", "(Ljava/util/ArrayList;)V", "loaderParams", "Lcom/tencent/mm/plugin/finder/live/viewmodel/FinderLiveRelatedLoaderParam;", "getLoaderParams", "()Lcom/tencent/mm/plugin/finder/live/viewmodel/FinderLiveRelatedLoaderParam;", "setLoaderParams", "(Lcom/tencent/mm/plugin/finder/live/viewmodel/FinderLiveRelatedLoaderParam;)V", "canLoadMore", "", "flingUpTab", "info", "mergeLiveData", "remote", "", "parseLiveConfigList", "", "finderLiveConfig", "Lcom/tencent/mm/plugin/finder/live/model/FinderLiveConfig;", "parseLoaderParams", "tabType", "commentScene", "pullMoreType", "toString", "Companion", "plugin-finder_release"})
public final class d
{
  private static HashMap<Integer, g> uCv;
  public static final a uCw;
  private final String TAG;
  private int uCt;
  public ArrayList<c> uCu;
  public f ufx;
  
  static
  {
    AppMethodBeat.i(247885);
    uCw = new a((byte)0);
    uCv = new HashMap();
    AppMethodBeat.o(247885);
  }
  
  public d()
  {
    AppMethodBeat.i(247884);
    this.TAG = ("FinderLiveDataModel@" + hashCode());
    this.uCu = new ArrayList();
    AppMethodBeat.o(247884);
  }
  
  public final void Jq(int paramInt)
  {
    AppMethodBeat.i(247879);
    this.uCt = paramInt;
    Log.i(this.TAG, "set initPos :" + this.uCt);
    AppMethodBeat.o(247879);
  }
  
  public final void a(FinderLiveConfig paramFinderLiveConfig)
  {
    AppMethodBeat.i(247881);
    p.h(paramFinderLiveConfig, "finderLiveConfig");
    Jq(paramFinderLiveConfig.uis);
    int i = paramFinderLiveConfig.dLS;
    int j = paramFinderLiveConfig.tCE;
    int k = paramFinderLiveConfig.uiy;
    Object localObject = a.PRN;
    a.bi(PluginFinder.class).get(FinderGlobalLocationVM.class);
    localObject = FinderGlobalLocationVM.dHP();
    f localf = new f();
    localf.uDl = ((Number)((o)localObject).first).floatValue();
    localf.iUY = ((Number)((o)localObject).second).floatValue();
    localf.scene = 7;
    localf.tCE = j;
    localf.dLS = i;
    localf.uiy = k;
    this.ufx = localf;
    localObject = (Iterable)paramFinderLiveConfig.uiu;
    paramFinderLiveConfig = (Collection)new ArrayList(j.a((Iterable)localObject, 10));
    localObject = ((Iterable)localObject).iterator();
    while (((Iterator)localObject).hasNext()) {
      paramFinderLiveConfig.add(new c((LiveConfig)((Iterator)localObject).next()));
    }
    this.uCu = new ArrayList((Collection)paramFinderLiveConfig);
    AppMethodBeat.o(247881);
  }
  
  public final void ad(ArrayList<c> paramArrayList)
  {
    AppMethodBeat.i(247880);
    p.h(paramArrayList, "<set-?>");
    this.uCu = paramArrayList;
    AppMethodBeat.o(247880);
  }
  
  public final boolean diM()
  {
    f localf = this.ufx;
    if ((localf == null) || (localf.dLS != 3))
    {
      localf = this.ufx;
      if ((localf == null) || (localf.dLS != 1))
      {
        localf = this.ufx;
        if ((localf == null) || (localf.dLS != 2)) {
          localf = this.ufx;
        }
      }
    }
    return (localf != null) && (localf.dLS == 1010);
  }
  
  public final int ee(List<c> paramList)
  {
    AppMethodBeat.i(247882);
    ArrayList localArrayList = this.uCu;
    LinkedList localLinkedList = new LinkedList();
    Object localObject1 = com.tencent.mm.plugin.finder.storage.c.vCb;
    boolean bool = com.tencent.mm.plugin.finder.storage.c.duP();
    int i;
    if (paramList != null)
    {
      localObject1 = ((Iterable)paramList).iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (c)((Iterator)localObject1).next();
        Iterator localIterator = ((List)localArrayList).iterator();
        i = 0;
        label82:
        int j;
        label115:
        label121:
        int k;
        if (localIterator.hasNext()) {
          if (((c)localIterator.next()).a((i)localObject2) == 0)
          {
            j = 1;
            if (j == 0) {
              break label205;
            }
            j = i;
            localIterator = ((List)localLinkedList).iterator();
            i = 0;
            label135:
            if (!localIterator.hasNext()) {
              break label230;
            }
            if (((c)localIterator.next()).a((i)localObject2) != 0) {
              break label217;
            }
            k = 1;
            label169:
            if (k == 0) {
              break label223;
            }
          }
        }
        for (;;)
        {
          if ((!bool) && ((j != -1) || (i != -1))) {
            break label235;
          }
          localLinkedList.add(localObject2);
          break;
          j = 0;
          break label115;
          label205:
          i += 1;
          break label82;
          j = -1;
          break label121;
          label217:
          k = 0;
          break label169;
          label223:
          i += 1;
          break label135;
          label230:
          i = -1;
        }
        label235:
        if (j != -1) {
          Log.i(this.TAG, "[mergeLiveData] localList same feed:[" + (c)this.uCu.get(j) + "], just ignore this feed=" + localObject2 + " existIndex=" + j + " existIndexInIncrementList=" + i);
        } else {
          Log.i(this.TAG, "[mergeLiveData] newList same feed:[" + (c)localLinkedList.get(i) + "], just ignore this feed=" + localObject2 + " existIndex=" + j + " existIndexInIncrementList=" + i);
        }
      }
    }
    localObject1 = this.TAG;
    Object localObject2 = new StringBuilder("remote size:");
    if (paramList != null) {}
    for (paramList = Integer.valueOf(paramList.size());; paramList = null)
    {
      Log.i((String)localObject1, paramList + ",locate size:" + this.uCu.size() + ",incrementList size:" + localLinkedList.size() + " enable repeat(for test):" + bool);
      localArrayList.addAll((Collection)localLinkedList);
      i = localLinkedList.size();
      AppMethodBeat.o(247882);
      return i;
    }
  }
  
  public final int getInitPos()
  {
    AppMethodBeat.i(247878);
    Log.i(this.TAG, "get initPos:" + this.uCt);
    int i = this.uCt;
    AppMethodBeat.o(247878);
    return i;
  }
  
  public final String toString()
  {
    int i = 0;
    Object localObject2 = null;
    AppMethodBeat.i(247883);
    StringBuilder localStringBuilder1 = new StringBuilder("FinderLiveDataModel(" + hashCode() + "):").append("init pos:" + getInitPos() + ';');
    StringBuilder localStringBuilder2 = new StringBuilder("loaderParams:tab:");
    Object localObject1 = this.ufx;
    label143:
    boolean bool;
    label187:
    int j;
    if (localObject1 != null)
    {
      localObject1 = Integer.valueOf(((f)localObject1).dLS);
      localStringBuilder2 = localStringBuilder2.append(localObject1).append(",objectId:");
      localObject1 = this.ufx;
      if (localObject1 == null) {
        break label267;
      }
      localObject1 = Long.valueOf(((f)localObject1).hFK);
      localStringBuilder2 = localStringBuilder2.append(localObject1).append(",lastBuf is null:");
      f localf = this.ufx;
      localObject1 = localObject2;
      if (localf != null) {
        localObject1 = localf.tsO;
      }
      if (localObject1 != null) {
        break label273;
      }
      bool = true;
      localObject1 = localStringBuilder1.append(bool + ';');
      p.g(localObject1, "StringBuilder(\"FinderLiv…rams?.lastBuf == null};\")");
      j = this.uCu.size();
      if (j > 0) {
        break label278;
      }
      ((StringBuilder)localObject1).append("live data is empty");
    }
    for (;;)
    {
      localObject1 = ((StringBuilder)localObject1).toString();
      p.g(localObject1, "msg.toString()");
      AppMethodBeat.o(247883);
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
        ((StringBuilder)localObject1).append("live_" + i + ':' + (c)this.uCu.get(i));
        i += 1;
      }
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/live/viewmodel/FinderLiveDataModel$Companion;", "", "()V", "miniProBundle", "Ljava/util/HashMap;", "", "Lcom/tencent/mm/plugin/appbrand/api/WeAppOpenBundle;", "getMiniProBundle", "()Ljava/util/HashMap;", "setMiniProBundle", "(Ljava/util/HashMap;)V", "plugin-finder_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.viewmodel.d
 * JD-Core Version:    0.7.0.1
 */