package com.tencent.mm.plugin.finder.view;

import android.app.Activity;
import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.f.a;
import com.tencent.mm.plugin.finder.feed.model.l;
import com.tencent.mm.plugin.finder.live.model.FinderLiveBundle;
import com.tencent.mm.plugin.finder.live.report.q.w;
import com.tencent.mm.plugin.finder.model.cc;
import com.tencent.mm.plugin.findersdk.a.ce;
import com.tencent.mm.plugin.g;
import com.tencent.mm.plugin.g.a;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.protocal.protobuf.FinderObjectDesc;
import com.tencent.mm.protocal.protobuf.bip;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.view.k;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.b.s;
import kotlin.g.b.u;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/view/FinderSnsHeaderPresenter;", "", "context", "Landroid/app/Activity;", "viewCallback", "Lcom/tencent/mm/view/IViewActionCallback;", "(Landroid/app/Activity;Lcom/tencent/mm/view/IViewActionCallback;)V", "TAG", "", "getContext", "()Landroid/app/Activity;", "dataList", "Ljava/util/ArrayList;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "Lkotlin/collections/ArrayList;", "getDataList", "()Ljava/util/ArrayList;", "dataLoader", "Lcom/tencent/mm/plugin/finder/feed/model/FinderSnsHeaderLoader;", "snsRefreshListener", "com/tencent/mm/plugin/finder/view/FinderSnsHeaderPresenter$snsRefreshListener$1", "Lcom/tencent/mm/plugin/finder/view/FinderSnsHeaderPresenter$snsRefreshListener$1;", "getViewCallback", "()Lcom/tencent/mm/view/IViewActionCallback;", "clearAll", "", "convertToVisitorData", "Lcom/tencent/mm/plugin/finder/live/model/FinderLiveBundle;", "Lcom/tencent/mm/plugin/finder/model/FinderFeedLiveListItem;", "position", "", "getListOfType", "E", "clazz", "Ljava/lang/Class;", "goSetting", "gotoLive", "item", "initData", "loadMore", "refresh", "release", "statsReport", "exposed", "commentScene", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class p
{
  private final k BiU;
  final l GCp;
  final FinderSnsHeaderPresenter.snsRefreshListener.1 GCq;
  private final String TAG;
  final Activity hHU;
  final ArrayList<cc> pUj;
  
  public p(Activity paramActivity, k paramk)
  {
    AppMethodBeat.i(344201);
    this.hHU = paramActivity;
    this.BiU = paramk;
    this.TAG = "Finder.FinderSnsHeaderPresenter";
    this.pUj = new ArrayList();
    this.GCp = new l(this.pUj, this.BiU);
    this.GCq = new FinderSnsHeaderPresenter.snsRefreshListener.1(this, com.tencent.mm.app.f.hfK);
    AppMethodBeat.o(344201);
  }
  
  public final <E> ArrayList<E> bg(Class<E> paramClass)
  {
    AppMethodBeat.i(344265);
    s.u(paramClass, "clazz");
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = ((Iterable)this.pUj).iterator();
    while (localIterator.hasNext())
    {
      cc localcc = (cc)localIterator.next();
      if (paramClass.isInstance(localcc)) {
        localArrayList.add(localcc);
      }
    }
    AppMethodBeat.o(344265);
    return localArrayList;
  }
  
  public final void i(cc paramcc)
  {
    AppMethodBeat.i(344254);
    s.u(paramcc, "item");
    if ((paramcc instanceof com.tencent.mm.plugin.finder.model.z))
    {
      Object localObject5;
      Object localObject6;
      Object localObject3;
      Object localObject4;
      if (Util.isEqual(((com.tencent.mm.plugin.finder.model.z)paramcc).ECN.username, com.tencent.mm.model.z.bAW()))
      {
        localObject1 = h.ax(com.tencent.mm.plugin.f.class);
        s.s(localObject1, "service(IActivityRouter::class.java)");
        localObject5 = (com.tencent.mm.plugin.f)localObject1;
        localObject6 = (Context)this.hHU;
        long l = ((com.tencent.mm.plugin.finder.model.z)paramcc).ECN.id;
        localObject1 = ((com.tencent.mm.plugin.finder.model.z)paramcc).ECN.objectNonceId;
        localObject2 = localObject1;
        if (localObject1 == null) {
          localObject2 = "";
        }
        localObject1 = ((com.tencent.mm.plugin.finder.model.z)paramcc).ECN.liveInfo;
        localObject3 = localObject1;
        if (localObject1 == null) {
          localObject3 = new bip();
        }
        localObject1 = ((com.tencent.mm.plugin.finder.model.z)paramcc).ECN.objectDesc;
        if (localObject1 == null) {
          localObject1 = "";
        }
        for (;;)
        {
          f.a.a((com.tencent.mm.plugin.f)localObject5, (Context)localObject6, l, (String)localObject2, (bip)localObject3, null, (String)localObject1, null, null, null, ((com.tencent.mm.plugin.finder.model.z)paramcc).ECN.sessionBuffer, null, null, 7088);
          AppMethodBeat.o(344254);
          return;
          localObject4 = ((FinderObjectDesc)localObject1).description;
          localObject1 = localObject4;
          if (localObject4 == null) {
            localObject1 = "";
          }
        }
      }
      Object localObject2 = bg(com.tencent.mm.plugin.finder.model.z.class);
      Object localObject1 = (List)localObject2;
      int i = 0;
      localObject1 = ((List)localObject1).iterator();
      int j;
      if (((Iterator)localObject1).hasNext()) {
        if (((com.tencent.mm.plugin.finder.model.z)((Iterator)localObject1).next()).ECN.id == paramcc.bZA())
        {
          j = 1;
          label282:
          if (j == 0) {
            break label516;
          }
          label286:
          Log.i(this.TAG, s.X("click item position:", Integer.valueOf(i)));
          if (i < 0) {
            break label675;
          }
          ((ce)h.ax(ce.class)).a((com.tencent.mm.plugin.finder.model.z)paramcc, ((com.tencent.mm.plugin.finder.model.z)paramcc).ECN.username, i, q.w.DwR, "61");
          localObject3 = (com.tencent.mm.plugin.f)com.tencent.mm.plugin.finder.utils.a.GfO;
          localObject4 = (Context)this.hHU;
          localObject5 = new FinderLiveBundle();
          ((FinderLiveBundle)localObject5).CEY = i;
          ((FinderLiveBundle)localObject5).hJx = 0;
          ((FinderLiveBundle)localObject5).AJo = 61;
          paramcc = (com.tencent.mm.plugin.finder.model.z)kotlin.a.p.ae((List)localObject2, i);
          if (paramcc != null) {
            break label528;
          }
          paramcc = "";
        }
      }
      for (;;)
      {
        ((FinderLiveBundle)localObject5).awv(paramcc);
        localObject1 = (Iterable)localObject2;
        paramcc = (Collection)new ArrayList(kotlin.a.p.a((Iterable)localObject1, 10));
        localObject1 = ((Iterable)localObject1).iterator();
        while (((Iterator)localObject1).hasNext())
        {
          localObject6 = (com.tencent.mm.plugin.finder.model.z)((Iterator)localObject1).next();
          com.tencent.mm.kernel.c.a locala = h.ax(g.class);
          s.s(locala, "service(IFinderCommonLiveService::class.java)");
          paramcc.add(g.a.a((g)locala, ((com.tencent.mm.plugin.finder.model.z)localObject6).ECN, 0, 6));
        }
        j = 0;
        break label282;
        label516:
        i += 1;
        break;
        i = -1;
        break label286;
        label528:
        paramcc = paramcc.ECN;
        if (paramcc == null)
        {
          paramcc = "";
        }
        else
        {
          localObject1 = paramcc.nickname;
          paramcc = (cc)localObject1;
          if (localObject1 == null) {
            paramcc = "";
          }
        }
      }
      ((FinderLiveBundle)localObject5).ag(new ArrayList((Collection)paramcc));
      paramcc = (com.tencent.mm.plugin.finder.model.z)kotlin.a.p.ae((List)localObject2, i);
      if (paramcc == null) {
        i = 0;
      }
      for (;;)
      {
        ((FinderLiveBundle)localObject5).extFlag = i;
        f.a.a((com.tencent.mm.plugin.f)localObject3, (Context)localObject4, (FinderLiveBundle)localObject5, null, null, null, false, 60);
        AppMethodBeat.o(344254);
        return;
        paramcc = paramcc.ECN;
        if (paramcc == null)
        {
          i = 0;
        }
        else
        {
          paramcc = paramcc.liveInfo;
          if (paramcc == null) {
            i = 0;
          } else {
            i = paramcc.ZRR;
          }
        }
      }
    }
    else
    {
      Log.i(this.TAG, "click not FinderFeedLiveListItem");
    }
    label675:
    AppMethodBeat.o(344254);
  }
  
  public final void release()
  {
    AppMethodBeat.i(344223);
    this.GCq.dead();
    this.GCp.release();
    AppMethodBeat.o(344223);
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class a
    extends u
    implements kotlin.g.a.a<ah>
  {
    a(ArrayList<com.tencent.mm.plugin.finder.model.z> paramArrayList)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.view.p
 * JD-Core Version:    0.7.0.1
 */