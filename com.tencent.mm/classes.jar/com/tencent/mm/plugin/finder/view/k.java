package com.tencent.mm.plugin.finder.view;

import android.app.Activity;
import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.wg;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.finder.feed.model.g;
import com.tencent.mm.plugin.finder.live.model.FinderLiveConfig;
import com.tencent.mm.plugin.finder.model.bo;
import com.tencent.mm.plugin.finder.model.y;
import com.tencent.mm.plugin.finder.report.live.s.p;
import com.tencent.mm.plugin.finder.utils.m;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.protocal.protobuf.FinderObjectDesc;
import com.tencent.mm.protocal.protobuf.awe;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.x;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/view/FinderSnsHeaderPresenter;", "", "context", "Landroid/app/Activity;", "viewCallback", "Lcom/tencent/mm/view/IViewActionCallback;", "(Landroid/app/Activity;Lcom/tencent/mm/view/IViewActionCallback;)V", "TAG", "", "getContext", "()Landroid/app/Activity;", "dataList", "Ljava/util/ArrayList;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "Lkotlin/collections/ArrayList;", "getDataList", "()Ljava/util/ArrayList;", "dataLoader", "Lcom/tencent/mm/plugin/finder/feed/model/FinderSnsHeaderLoader;", "snsRefreshListener", "com/tencent/mm/plugin/finder/view/FinderSnsHeaderPresenter$snsRefreshListener$1", "Lcom/tencent/mm/plugin/finder/view/FinderSnsHeaderPresenter$snsRefreshListener$1;", "getViewCallback", "()Lcom/tencent/mm/view/IViewActionCallback;", "clearAll", "", "convertToVisitorData", "Lcom/tencent/mm/plugin/finder/live/model/FinderLiveConfig;", "Lcom/tencent/mm/plugin/finder/model/FinderFeedLiveListItem;", "position", "", "getListOfType", "E", "clazz", "Ljava/lang/Class;", "goSetting", "gotoLive", "item", "initData", "loadMore", "refresh", "release", "statsReport", "exposed", "commentScene", "plugin-finder_release"})
public final class k
{
  private final String TAG;
  final Activity dKq;
  final ArrayList<bo> kgc;
  private final com.tencent.mm.view.j tXl;
  final g woJ;
  final a woK;
  
  public k(Activity paramActivity, com.tencent.mm.view.j paramj)
  {
    AppMethodBeat.i(254920);
    this.dKq = paramActivity;
    this.tXl = paramj;
    this.TAG = "Finder.FinderSnsHeaderPresenter";
    this.kgc = new ArrayList();
    this.woJ = new g(this.kgc, this.tXl);
    this.woK = new a(this);
    AppMethodBeat.o(254920);
  }
  
  public final <E> ArrayList<E> aO(Class<E> paramClass)
  {
    AppMethodBeat.i(254919);
    p.h(paramClass, "clazz");
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = ((Iterable)this.kgc).iterator();
    while (localIterator.hasNext())
    {
      bo localbo = (bo)localIterator.next();
      if (paramClass.isInstance(localbo)) {
        localArrayList.add((Object)localbo);
      }
    }
    AppMethodBeat.o(254919);
    return localArrayList;
  }
  
  public final void c(bo parambo)
  {
    AppMethodBeat.i(254918);
    p.h(parambo, "item");
    if ((parambo instanceof y))
    {
      Object localObject5;
      Object localObject3;
      Object localObject4;
      if (Util.isEqual(((y)parambo).uOo.username, z.aUg()))
      {
        localObject1 = com.tencent.mm.plugin.finder.utils.a.vUU;
        localObject5 = (Context)this.dKq;
        long l = ((y)parambo).uOo.id;
        localObject2 = ((y)parambo).uOo.objectNonceId;
        localObject1 = localObject2;
        if (localObject2 == null) {
          localObject1 = "";
        }
        localObject3 = ((y)parambo).uOo.liveInfo;
        localObject2 = localObject3;
        if (localObject3 == null) {
          localObject2 = new awe();
        }
        localObject3 = ((y)parambo).uOo.objectDesc;
        if (localObject3 != null)
        {
          localObject4 = ((FinderObjectDesc)localObject3).description;
          localObject3 = localObject4;
          if (localObject4 != null) {}
        }
        else
        {
          localObject3 = "";
        }
        com.tencent.mm.plugin.finder.utils.a.a((Context)localObject5, l, (String)localObject1, (awe)localObject2, false, null, (String)localObject3, null, null, null, ((y)parambo).uOo.sessionBuffer, null, 6000);
        AppMethodBeat.o(254918);
        return;
      }
      Object localObject2 = aO(y.class);
      Object localObject1 = (List)localObject2;
      int i = 0;
      localObject1 = ((List)localObject1).iterator();
      int j;
      if (((Iterator)localObject1).hasNext()) {
        if (((y)((Iterator)localObject1).next()).uOo.id == parambo.lT())
        {
          j = 1;
          label257:
          if (j == 0) {
            break label435;
          }
        }
      }
      for (;;)
      {
        Log.i(this.TAG, "click item position:".concat(String.valueOf(i)));
        if (i < 0) {
          break label478;
        }
        com.tencent.mm.plugin.finder.report.live.k.vkd.a((y)parambo, ((y)parambo).uOo.username, i, s.p.voC, "61");
        parambo = com.tencent.mm.plugin.finder.utils.a.vUU;
        parambo = (Context)this.dKq;
        localObject1 = new FinderLiveConfig();
        ((FinderLiveConfig)localObject1).uis = i;
        ((FinderLiveConfig)localObject1).dLS = 0;
        ((FinderLiveConfig)localObject1).tCE = 61;
        localObject3 = (Iterable)localObject2;
        localObject2 = (Collection)new ArrayList(kotlin.a.j.a((Iterable)localObject3, 10));
        localObject3 = ((Iterable)localObject3).iterator();
        while (((Iterator)localObject3).hasNext())
        {
          localObject4 = (y)((Iterator)localObject3).next();
          localObject5 = m.vVH;
          ((Collection)localObject2).add(m.q(((y)localObject4).uOo));
        }
        j = 0;
        break label257;
        label435:
        i += 1;
        break;
        i = -1;
      }
      ((FinderLiveConfig)localObject1).ac(new ArrayList((Collection)localObject2));
      com.tencent.mm.plugin.finder.utils.a.a(parambo, (FinderLiveConfig)localObject1, null, null, null, 28);
      label478:
      AppMethodBeat.o(254918);
      return;
    }
    Log.i(this.TAG, "click not FinderFeedLiveListItem");
    AppMethodBeat.o(254918);
  }
  
  public final void release()
  {
    AppMethodBeat.i(254917);
    this.woK.dead();
    this.woJ.release();
    AppMethodBeat.o(254917);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/finder/view/FinderSnsHeaderPresenter$snsRefreshListener$1", "Lcom/tencent/mm/sdk/event/IListener;", "Lcom/tencent/mm/autogen/events/SnsTimelineRefreshEvent;", "callback", "", "event", "plugin-finder_release"})
  public static final class a
    extends IListener<wg>
  {}
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "invoke"})
  static final class b
    extends q
    implements kotlin.g.a.a<x>
  {
    b(ArrayList paramArrayList)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.view.k
 * JD-Core Version:    0.7.0.1
 */