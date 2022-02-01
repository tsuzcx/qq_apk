package com.tencent.mm.plugin.finder.live.olympic;

import android.view.View;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView.LayoutManager;
import androidx.recyclerview.widget.RecyclerView.a;
import com.tencent.luggage.l.c;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.feed.model.internal.BaseFeedLoader;
import com.tencent.mm.plugin.finder.feed.model.internal.DataBuffer;
import com.tencent.mm.plugin.finder.feed.model.internal.IResponse;
import com.tencent.mm.plugin.finder.live.olympic.loader.FinderLiveOlympicRunnerPannelLoader;
import com.tencent.mm.plugin.finder.model.cc;
import com.tencent.mm.protocal.protobuf.bp;
import com.tencent.mm.protocal.protobuf.fgz;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.view.RefreshLoadMoreLayout;
import com.tencent.mm.view.RefreshLoadMoreLayout.b;
import com.tencent.mm.view.recyclerview.WxRecyclerAdapter;
import com.tencent.mm.view.recyclerview.WxRecyclerView;
import com.tencent.mm.view.recyclerview.g;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.b.s;
import kotlin.g.b.u;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/olympic/FinderLiveOlympicRunnerPannelContract$OlympicRunnerPresenter;", "Lcom/tencent/mm/plugin/finder/presenter/base/IPresenter;", "Lcom/tencent/mm/plugin/finder/live/olympic/FinderLiveOlympicRunnerPannelContract$OlympicRunnerViewCallback;", "boardScene", "", "activity", "Lcom/tencent/mm/protocal/protobuf/SportActivity;", "loader", "Lcom/tencent/mm/plugin/finder/feed/model/internal/BaseFeedLoader;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "locationPermissionReq", "Lkotlin/Function0;", "", "(ILcom/tencent/mm/protocal/protobuf/SportActivity;Lcom/tencent/mm/plugin/finder/feed/model/internal/BaseFeedLoader;Lkotlin/jvm/functions/Function0;)V", "getActivity", "()Lcom/tencent/mm/protocal/protobuf/SportActivity;", "adapter", "Lcom/tencent/mm/view/recyclerview/WxRecyclerAdapter;", "getAdapter", "()Lcom/tencent/mm/view/recyclerview/WxRecyclerAdapter;", "setAdapter", "(Lcom/tencent/mm/view/recyclerview/WxRecyclerAdapter;)V", "getBoardScene", "()I", "hasMore", "", "getHasMore", "()Z", "setHasMore", "(Z)V", "getLoader", "()Lcom/tencent/mm/plugin/finder/feed/model/internal/BaseFeedLoader;", "getLocationPermissionReq", "()Lkotlin/jvm/functions/Function0;", "viewCallback", "getViewCallback", "()Lcom/tencent/mm/plugin/finder/live/olympic/FinderLiveOlympicRunnerPannelContract$OlympicRunnerViewCallback;", "setViewCallback", "(Lcom/tencent/mm/plugin/finder/live/olympic/FinderLiveOlympicRunnerPannelContract$OlympicRunnerViewCallback;)V", "addSelfItem", "selfItem", "Lcom/tencent/mm/protocal/protobuf/ActivityBoardItem;", "selfBlured", "dataList", "Lcom/tencent/mm/plugin/finder/feed/model/internal/DataBuffer;", "Lcom/tencent/mm/plugin/finder/live/olympic/data/RunnerPannelFeed;", "loadMore", "onAttach", "callback", "onDetach", "refresh", "showProgess", "delay", "", "showLocationPermissionUI", "show", "showProgress", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class g$a
  implements com.tencent.mm.plugin.finder.presenter.base.a<g.b>
{
  public WxRecyclerAdapter<cc> ALE;
  final int CNG;
  final fgz CNI;
  final BaseFeedLoader<cc> CNJ;
  final kotlin.g.a.a<ah> CNK;
  public g.b CNL;
  boolean hasMore;
  
  public g$a(int paramInt, fgz paramfgz, BaseFeedLoader<cc> paramBaseFeedLoader, kotlin.g.a.a<ah> parama)
  {
    AppMethodBeat.i(360407);
    this.CNG = paramInt;
    this.CNI = paramfgz;
    this.CNJ = paramBaseFeedLoader;
    this.CNK = parama;
    AppMethodBeat.o(360407);
  }
  
  private static final void a(boolean paramBoolean, DataBuffer<com.tencent.mm.plugin.finder.live.olympic.data.b> paramDataBuffer, bp parambp, a parama, String paramString)
  {
    AppMethodBeat.i(360427);
    int i;
    label61:
    label75:
    label95:
    int j;
    if (paramBoolean)
    {
      localObject = (List)paramDataBuffer;
      localObject = ((List)localObject).listIterator(((List)localObject).size());
      if (((ListIterator)localObject).hasPrevious()) {
        if (((com.tencent.mm.plugin.finder.live.olympic.data.b)((ListIterator)localObject).previous()).type == 0)
        {
          i = 1;
          if (i == 0) {
            break label217;
          }
          i = ((ListIterator)localObject).nextIndex();
          if (i != -1) {
            break label246;
          }
          localObject = ((List)paramDataBuffer).iterator();
          i = 0;
          if (!((Iterator)localObject).hasNext()) {
            break label240;
          }
          if (((com.tencent.mm.plugin.finder.live.olympic.data.b)((Iterator)localObject).next()).type != 1) {
            break label225;
          }
          j = 1;
          label125:
          if (j == 0) {
            break label231;
          }
        }
      }
      for (;;)
      {
        paramDataBuffer.add(i + 1, new com.tencent.mm.plugin.finder.live.olympic.data.b(parambp, 0, null, parama.CNI, paramBoolean, 6));
        Log.i("FinderLiveOlympicRunnerPannelContract", paramString + " case1, self item rank:" + parambp.YDk + " ,add selfItem to pos:" + (i + 1) + '!');
        AppMethodBeat.o(360427);
        return;
        i = 0;
        break label61;
        label217:
        break;
        i = -1;
        break label75;
        label225:
        j = 0;
        break label125;
        label231:
        i += 1;
        break label95;
        label240:
        i = -1;
      }
      label246:
      paramDataBuffer.add(i + 1, new com.tencent.mm.plugin.finder.live.olympic.data.b(parambp, 0, null, parama.CNI, paramBoolean, 6));
      Log.i("FinderLiveOlympicRunnerPannelContract", paramString + " case1, self item rank:" + parambp.YDk + " ,add selfItem to pos:" + (i + 1) + '!');
      AppMethodBeat.o(360427);
      return;
    }
    Object localObject = (List)paramDataBuffer;
    localObject = ((List)localObject).listIterator(((List)localObject).size());
    if (((ListIterator)localObject).hasPrevious()) {
      if (((com.tencent.mm.plugin.finder.live.olympic.data.b)((ListIterator)localObject).previous()).CRz.YDk <= parambp.YDk)
      {
        i = 1;
        label387:
        if (i == 0) {
          break label543;
        }
        i = ((ListIterator)localObject).nextIndex();
        label401:
        if (i != -1) {
          break label572;
        }
        localObject = ((List)paramDataBuffer).iterator();
        i = 0;
        label421:
        if (!((Iterator)localObject).hasNext()) {
          break label566;
        }
        if (((com.tencent.mm.plugin.finder.live.olympic.data.b)((Iterator)localObject).next()).type != 1) {
          break label551;
        }
        j = 1;
        label451:
        if (j == 0) {
          break label557;
        }
      }
    }
    for (;;)
    {
      paramDataBuffer.add(i + 1, new com.tencent.mm.plugin.finder.live.olympic.data.b(parambp, 0, null, parama.CNI, false, 22));
      Log.i("FinderLiveOlympicRunnerPannelContract", paramString + " case2, self item rank:" + parambp.YDk + " ,add selfItem to pos:" + (i + 1) + '!');
      AppMethodBeat.o(360427);
      return;
      i = 0;
      break label387;
      label543:
      break;
      i = -1;
      break label401;
      label551:
      j = 0;
      break label451;
      label557:
      i += 1;
      break label421;
      label566:
      i = -1;
    }
    label572:
    paramDataBuffer.add(i + 1, new com.tencent.mm.plugin.finder.live.olympic.data.b(parambp, 0, null, parama.CNI, false, 22));
    Log.i("FinderLiveOlympicRunnerPannelContract", paramString + " case2, self item rank:" + parambp.YDk + " ,add selfItem to pos:" + (i + 1) + '!');
    AppMethodBeat.o(360427);
  }
  
  public final void a(g.b paramb)
  {
    AppMethodBeat.i(360467);
    s.u(paramb, "callback");
    Log.i("FinderLiveOlympicRunnerPannelContract", s.X("onAttach :", Integer.valueOf(paramb.hashCode())));
    s.u(paramb, "<set-?>");
    this.CNL = paramb;
    Object localObject = new WxRecyclerAdapter((g)new a(this), (ArrayList)this.CNJ.getDataListJustForAdapter());
    s.u(localObject, "<set-?>");
    this.ALE = ((WxRecyclerAdapter)localObject);
    localObject = paramb.getRecyclerView();
    ((WxRecyclerView)localObject).getRootView().getContext();
    ((WxRecyclerView)localObject).setLayoutManager((RecyclerView.LayoutManager)new LinearLayoutManager());
    ((WxRecyclerView)localObject).setAdapter((RecyclerView.a)paramb.CNN.getAdapter());
    paramb.enz().setVisibility(4);
    paramb.enx().setEnableRefresh(false);
    paramb.enx().setActionCallback((RefreshLoadMoreLayout.b)new g.b.b(paramb));
    ((FinderLiveOlympicRunnerPannelLoader)this.CNJ).fetchEndCallback = ((kotlin.g.a.b)new b(this));
    this.CNJ.register(enw().ATF);
    AppMethodBeat.o(360467);
  }
  
  public final g.b enw()
  {
    AppMethodBeat.i(360449);
    g.b localb = this.CNL;
    if (localb != null)
    {
      AppMethodBeat.o(360449);
      return localb;
    }
    s.bIx("viewCallback");
    AppMethodBeat.o(360449);
    return null;
  }
  
  public final WxRecyclerAdapter<cc> getAdapter()
  {
    AppMethodBeat.i(360453);
    WxRecyclerAdapter localWxRecyclerAdapter = this.ALE;
    if (localWxRecyclerAdapter != null)
    {
      AppMethodBeat.o(360453);
      return localWxRecyclerAdapter;
    }
    s.bIx("adapter");
    AppMethodBeat.o(360453);
    return null;
  }
  
  public final void j(boolean paramBoolean, long paramLong)
  {
    AppMethodBeat.i(360484);
    Log.i("FinderLiveOlympicRunnerPannelContract", "boardScene:" + this.CNG + ", loader:" + this.CNJ.hashCode() + " refresh");
    if (paramBoolean) {
      enw().pZ(true);
    }
    c.a(paramLong, (kotlin.g.a.a)new c(this));
    AppMethodBeat.o(360484);
  }
  
  public final void onDetach()
  {
    AppMethodBeat.i(360477);
    this.CNJ.unregister(enw().ATF);
    g.b localb = enw();
    localb.CNV = 2147483647;
    localb.CNW = 2147483647;
    AppMethodBeat.o(360477);
  }
  
  public final void qO(boolean paramBoolean)
  {
    AppMethodBeat.i(360490);
    enw().qP(paramBoolean);
    AppMethodBeat.o(360490);
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/live/olympic/FinderLiveOlympicRunnerPannelContract$OlympicRunnerPresenter$onAttach$1", "Lcom/tencent/mm/view/recyclerview/ItemConvertFactory;", "getItemConvert", "Lcom/tencent/mm/view/recyclerview/ItemConvert;", "type", "", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a
    implements g
  {
    a(g.a parama) {}
    
    public final com.tencent.mm.view.recyclerview.f<?> yF(int paramInt)
    {
      AppMethodBeat.i(360401);
      switch (paramInt)
      {
      default: 
        localf = (com.tencent.mm.view.recyclerview.f)new e(this.CNM.CNG);
        AppMethodBeat.o(360401);
        return localf;
      case 1: 
        localf = (com.tencent.mm.view.recyclerview.f)new f();
        AppMethodBeat.o(360401);
        return localf;
      }
      com.tencent.mm.view.recyclerview.f localf = (com.tencent.mm.view.recyclerview.f)new d();
      AppMethodBeat.o(360401);
      return localf;
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "resp", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IResponse;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class b
    extends u
    implements kotlin.g.a.b<IResponse<cc>, ah>
  {
    b(g.a parama)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class c
    extends u
    implements kotlin.g.a.a<ah>
  {
    c(g.a parama)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.olympic.g.a
 * JD-Core Version:    0.7.0.1
 */