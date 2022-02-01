package com.tencent.mm.plugin.finder.view;

import android.app.Activity;
import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.f.a.xl;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.finder.live.model.FinderLiveBundle;
import com.tencent.mm.plugin.finder.live.report.k;
import com.tencent.mm.plugin.finder.live.report.s.t;
import com.tencent.mm.plugin.finder.model.bu;
import com.tencent.mm.plugin.finder.model.y;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.protocal.protobuf.FinderObjectDesc;
import com.tencent.mm.protocal.protobuf.bac;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.x;

@kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/view/FinderSnsHeaderPresenter;", "", "context", "Landroid/app/Activity;", "viewCallback", "Lcom/tencent/mm/view/IViewActionCallback;", "(Landroid/app/Activity;Lcom/tencent/mm/view/IViewActionCallback;)V", "TAG", "", "getContext", "()Landroid/app/Activity;", "dataList", "Ljava/util/ArrayList;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "Lkotlin/collections/ArrayList;", "getDataList", "()Ljava/util/ArrayList;", "dataLoader", "Lcom/tencent/mm/plugin/finder/feed/model/FinderSnsHeaderLoader;", "snsRefreshListener", "com/tencent/mm/plugin/finder/view/FinderSnsHeaderPresenter$snsRefreshListener$1", "Lcom/tencent/mm/plugin/finder/view/FinderSnsHeaderPresenter$snsRefreshListener$1;", "getViewCallback", "()Lcom/tencent/mm/view/IViewActionCallback;", "clearAll", "", "convertToVisitorData", "Lcom/tencent/mm/plugin/finder/live/model/FinderLiveBundle;", "Lcom/tencent/mm/plugin/finder/model/FinderFeedLiveListItem;", "position", "", "getListOfType", "E", "clazz", "Ljava/lang/Class;", "goSetting", "gotoLive", "item", "initData", "loadMore", "refresh", "release", "statsReport", "exposed", "commentScene", "plugin-finder_release"})
public final class m
{
  final com.tencent.mm.plugin.finder.feed.model.l AZS;
  final a AZT;
  private final String TAG;
  final Activity fDf;
  final ArrayList<bu> mXB;
  private final com.tencent.mm.view.j xJl;
  
  public m(Activity paramActivity, com.tencent.mm.view.j paramj)
  {
    AppMethodBeat.i(286231);
    this.fDf = paramActivity;
    this.xJl = paramj;
    this.TAG = "Finder.FinderSnsHeaderPresenter";
    this.mXB = new ArrayList();
    this.AZS = new com.tencent.mm.plugin.finder.feed.model.l(this.mXB, this.xJl);
    this.AZT = new a(this);
    AppMethodBeat.o(286231);
  }
  
  public final <E> ArrayList<E> aL(Class<E> paramClass)
  {
    AppMethodBeat.i(286230);
    p.k(paramClass, "clazz");
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = ((Iterable)this.mXB).iterator();
    while (localIterator.hasNext())
    {
      bu localbu = (bu)localIterator.next();
      if (paramClass.isInstance(localbu)) {
        localArrayList.add((Object)localbu);
      }
    }
    AppMethodBeat.o(286230);
    return localArrayList;
  }
  
  public final void f(bu parambu)
  {
    AppMethodBeat.i(286229);
    p.k(parambu, "item");
    if ((parambu instanceof y))
    {
      Object localObject5;
      Object localObject3;
      Object localObject4;
      if (Util.isEqual(((y)parambu).zAF.username, z.bdh()))
      {
        localObject1 = com.tencent.mm.plugin.finder.utils.a.ACH;
        localObject5 = (Context)this.fDf;
        long l = ((y)parambu).zAF.id;
        localObject2 = ((y)parambu).zAF.objectNonceId;
        localObject1 = localObject2;
        if (localObject2 == null) {
          localObject1 = "";
        }
        localObject3 = ((y)parambu).zAF.liveInfo;
        localObject2 = localObject3;
        if (localObject3 == null) {
          localObject2 = new bac();
        }
        localObject3 = ((y)parambu).zAF.objectDesc;
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
        com.tencent.mm.plugin.finder.utils.a.a((Context)localObject5, l, (String)localObject1, (bac)localObject2, null, (String)localObject3, null, null, null, ((y)parambu).zAF.sessionBuffer, null, null, 7088);
        AppMethodBeat.o(286229);
        return;
      }
      Object localObject2 = aL(y.class);
      Object localObject1 = (List)localObject2;
      int i = 0;
      localObject1 = ((List)localObject1).iterator();
      int j;
      if (((Iterator)localObject1).hasNext()) {
        if (((y)((Iterator)localObject1).next()).zAF.id == parambu.mf())
        {
          j = 1;
          label257:
          if (j == 0) {
            break label487;
          }
        }
      }
      for (;;)
      {
        Log.i(this.TAG, "click item position:".concat(String.valueOf(i)));
        if (i < 0) {
          break label577;
        }
        k.yBj.a((y)parambu, ((y)parambu).zAF.username, i, s.t.yGP, "61");
        parambu = com.tencent.mm.plugin.finder.utils.a.ACH;
        localObject3 = (Context)this.fDf;
        localObject4 = new FinderLiveBundle();
        ((FinderLiveBundle)localObject4).yeA = i;
        ((FinderLiveBundle)localObject4).fEH = 0;
        ((FinderLiveBundle)localObject4).xkX = 61;
        parambu = (y)kotlin.a.j.M((List)localObject2, i);
        if (parambu != null)
        {
          parambu = parambu.zAF;
          if (parambu != null)
          {
            localObject1 = parambu.nickname;
            parambu = (bu)localObject1;
            if (localObject1 != null) {
              break label393;
            }
          }
        }
        parambu = "";
        label393:
        ((FinderLiveBundle)localObject4).aCa(parambu);
        localObject1 = (Iterable)localObject2;
        parambu = (Collection)new ArrayList(kotlin.a.j.a((Iterable)localObject1, 10));
        localObject1 = ((Iterable)localObject1).iterator();
        while (((Iterator)localObject1).hasNext())
        {
          localObject5 = (y)((Iterator)localObject1).next();
          com.tencent.mm.plugin.finder.live.utils.a locala = com.tencent.mm.plugin.finder.live.utils.a.yRm;
          parambu.add(com.tencent.mm.plugin.finder.live.utils.a.a(((y)localObject5).zAF, 0, false, 6));
        }
        j = 0;
        break label257;
        label487:
        i += 1;
        break;
        i = -1;
      }
      ((FinderLiveBundle)localObject4).ae(new ArrayList((Collection)parambu));
      parambu = (y)kotlin.a.j.M((List)localObject2, i);
      if (parambu != null)
      {
        parambu = parambu.zAF;
        if (parambu != null)
        {
          parambu = parambu.liveInfo;
          if (parambu == null) {}
        }
      }
      for (i = parambu.SLO;; i = 0)
      {
        ((FinderLiveBundle)localObject4).extFlag = i;
        com.tencent.mm.plugin.finder.utils.a.a((Context)localObject3, (FinderLiveBundle)localObject4, null, null, null, 28);
        label577:
        AppMethodBeat.o(286229);
        return;
      }
    }
    Log.i(this.TAG, "click not FinderFeedLiveListItem");
    AppMethodBeat.o(286229);
  }
  
  public final void release()
  {
    AppMethodBeat.i(286228);
    this.AZT.dead();
    this.AZS.release();
    AppMethodBeat.o(286228);
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/finder/view/FinderSnsHeaderPresenter$snsRefreshListener$1", "Lcom/tencent/mm/sdk/event/IListener;", "Lcom/tencent/mm/autogen/events/SnsTimelineRefreshEvent;", "callback", "", "event", "plugin-finder_release"})
  public static final class a
    extends IListener<xl>
  {}
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
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
 * Qualified Name:     com.tencent.mm.plugin.finder.view.m
 * JD-Core Version:    0.7.0.1
 */