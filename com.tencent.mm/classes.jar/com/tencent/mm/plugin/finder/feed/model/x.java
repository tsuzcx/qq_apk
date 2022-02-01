package com.tencent.mm.plugin.finder.feed.model;

import android.arch.lifecycle.ViewModelProvider;
import android.content.Context;
import android.content.res.Resources;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.u;
import com.tencent.mm.plugin.finder.PluginFinder;
import com.tencent.mm.plugin.finder.cgi.a.a.a;
import com.tencent.mm.plugin.finder.cgi.g.c;
import com.tencent.mm.plugin.finder.feed.model.internal.DataBuffer;
import com.tencent.mm.plugin.finder.feed.model.internal.IResponse;
import com.tencent.mm.plugin.finder.feed.model.internal.c.a;
import com.tencent.mm.plugin.finder.feed.model.internal.e;
import com.tencent.mm.plugin.finder.feed.model.internal.g;
import com.tencent.mm.plugin.finder.feed.model.internal.i;
import com.tencent.mm.plugin.finder.feed.z;
import com.tencent.mm.plugin.finder.model.v;
import com.tencent.mm.plugin.finder.storage.data.f.a;
import com.tencent.mm.plugin.finder.storage.p;
import com.tencent.mm.plugin.finder.storage.r;
import com.tencent.mm.plugin.finder.utils.m;
import com.tencent.mm.plugin.finder.viewmodel.FinderHomeTabStateVM;
import com.tencent.mm.plugin.finder.viewmodel.FinderHomeTabStateVM.a;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.protocal.protobuf.aih;
import com.tencent.mm.protocal.protobuf.cld;
import com.tencent.mm.protocal.protobuf.dzm;
import com.tencent.mm.protocal.protobuf.dzp;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.view.RefreshLoadMoreLayout.c;
import d.g.b.k;
import d.y;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

@d.l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/finder/feed/model/FinderLbsLoader;", "Lcom/tencent/mm/plugin/finder/feed/model/internal/BaseFeedLoader;", "Lcom/tencent/mm/plugin/finder/model/BaseMixFeed;", "contextObj", "Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "(Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;)V", "TAG", "", "getTAG", "()Ljava/lang/String;", "setTAG", "(Ljava/lang/String;)V", "fetchEndCallback", "Lkotlin/Function1;", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IResponse;", "", "getFetchEndCallback", "()Lkotlin/jvm/functions/Function1;", "setFetchEndCallback", "(Lkotlin/jvm/functions/Function1;)V", "createDataFetch", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IDataFetch;", "", "Lcom/tencent/mm/plugin/finder/feed/model/internal/ILoaderData;", "onFetchDone", "response", "onFetchRefreshDone", "requestLoadMore", "requestRefresh", "FinderLbsInit", "FinderLbsListData", "FinderLbsResponse", "FinderLbsReuqest", "plugin-finder_release"})
public final class x
  extends com.tencent.mm.plugin.finder.feed.model.internal.a<v>
{
  public d.g.a.b<? super IResponse<v>, y> KPL;
  private String TAG = "Finder.FinderLbsLoader";
  
  public x(dzp paramdzp)
  {
    super(paramdzp);
  }
  
  public final com.tencent.mm.plugin.finder.feed.model.internal.f<Object, Object, i> createDataFetch(dzp paramdzp)
  {
    AppMethodBeat.i(198243);
    paramdzp = (com.tencent.mm.plugin.finder.feed.model.internal.f)new b(paramdzp);
    AppMethodBeat.o(198243);
    return paramdzp;
  }
  
  public final String getTAG()
  {
    return this.TAG;
  }
  
  public final void onFetchDone(final IResponse<v> paramIResponse)
  {
    AppMethodBeat.i(198244);
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.be(paramIResponse);
    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/feed/model/FinderLbsLoader", "com/tencent/mm/plugin/finder/feed/model/internal/BaseFeedLoader", "onFetchDone", "(Lcom/tencent/mm/plugin/finder/feed/model/internal/IResponse;)V", this, localb.ado());
    k.h(paramIResponse, "response");
    super.onFetchDone(paramIResponse);
    com.tencent.mm.ad.c.g((d.g.a.a)new e(this, paramIResponse));
    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/feed/model/FinderLbsLoader", "com/tencent/mm/plugin/finder/feed/model/internal/BaseFeedLoader", "onFetchDone", "(Lcom/tencent/mm/plugin/finder/feed/model/internal/IResponse;)V");
    AppMethodBeat.o(198244);
  }
  
  public final void onFetchRefreshDone(IResponse<v> paramIResponse)
  {
    AppMethodBeat.i(198245);
    k.h(paramIResponse, "response");
    Object localObject = RefreshLoadMoreLayout.c.HXu;
    localObject = new RefreshLoadMoreLayout.c(RefreshLoadMoreLayout.c.fiH());
    boolean bool;
    if ((paramIResponse.getErrType() == 0) && (paramIResponse.getErrCode() == 0))
    {
      ((RefreshLoadMoreLayout.c)localObject).HXo = 1;
      if (paramIResponse.getPullType() == 0) {
        break label180;
      }
      bool = true;
      label54:
      ((RefreshLoadMoreLayout.c)localObject).hSO = bool;
      ((RefreshLoadMoreLayout.c)localObject).HXq = paramIResponse.getHasMore();
      if ((((RefreshLoadMoreLayout.c)localObject).actionType == 0) || (((RefreshLoadMoreLayout.c)localObject).actionType == 4) || (((RefreshLoadMoreLayout.c)localObject).actionType == 4)) {
        if ((((RefreshLoadMoreLayout.c)localObject).HXr <= 0) && (getDataListJustForAdapter().size() > 0)) {
          break label185;
        }
      }
    }
    Context localContext;
    for (((RefreshLoadMoreLayout.c)localObject).HXp = null;; ((RefreshLoadMoreLayout.c)localObject).HXp = ((CharSequence)localContext.getResources().getString(2131766492)))
    {
      paramIResponse = new com.tencent.mm.plugin.finder.feed.model.internal.l(4, paramIResponse.getIncrementList(), false, 12);
      dispatcher().a(paramIResponse, (RefreshLoadMoreLayout.c)localObject);
      AppMethodBeat.o(198245);
      return;
      localContext = aj.getContext();
      k.g(localContext, "MMApplicationContext.getContext()");
      ((RefreshLoadMoreLayout.c)localObject).HXp = ((CharSequence)localContext.getResources().getString(2131766491));
      ((RefreshLoadMoreLayout.c)localObject).HXo = -1;
      break;
      label180:
      bool = false;
      break label54;
      label185:
      localContext = aj.getContext();
      k.g(localContext, "MMApplicationContext.getContext()");
    }
  }
  
  public final void requestLoadMore()
  {
    AppMethodBeat.i(198242);
    d locald = new d(2);
    ad.i(getTAG(), "requestLoadMore ".concat(String.valueOf(locald)));
    fetchData((com.tencent.mm.plugin.finder.feed.model.internal.j)locald);
    AppMethodBeat.o(198242);
  }
  
  public final void requestRefresh()
  {
    AppMethodBeat.i(198241);
    d locald = new d(4);
    ad.i(getTAG(), "requestRefresh ".concat(String.valueOf(locald)));
    fetchData((com.tencent.mm.plugin.finder.feed.model.internal.j)locald);
    AppMethodBeat.o(198241);
  }
  
  public final void setTAG(String paramString)
  {
    AppMethodBeat.i(198240);
    k.h(paramString, "<set-?>");
    this.TAG = paramString;
    AppMethodBeat.o(198240);
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/finder/feed/model/FinderLbsLoader$FinderLbsInit;", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IInitRequest;", "initDone", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IInitDone;", "(Lcom/tencent/mm/plugin/finder/feed/model/internal/IInitDone;)V", "plugin-finder_release"})
  public static final class a
    extends com.tencent.mm.plugin.finder.feed.model.internal.h
  {
    public a(g paramg)
    {
      super();
      AppMethodBeat.i(198230);
      AppMethodBeat.o(198230);
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/finder/feed/model/FinderLbsLoader$FinderLbsListData;", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IDataFetch;", "Lcom/tencent/mm/plugin/finder/feed/model/FinderLbsLoader$FinderLbsInit;", "Lcom/tencent/mm/plugin/finder/feed/model/FinderLbsLoader$FinderLbsReuqest;", "Lcom/tencent/mm/plugin/finder/model/BaseMixFeed;", "contextObj", "Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "(Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;)V", "callBack", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IDataCallback;", "getCallBack", "()Lcom/tencent/mm/plugin/finder/feed/model/internal/IDataCallback;", "setCallBack", "(Lcom/tencent/mm/plugin/finder/feed/model/internal/IDataCallback;)V", "fetcher", "Lcom/tencent/mm/plugin/finder/cgi/fetcher/FinderLbsFeedFetcher;", "taskExecutor", "Lcom/tencent/mm/plugin/finder/utils/SingleTaskExecutor;", "alive", "", "call", "request", "callback", "callInitData", "", "init", "dead", "plugin-finder_release"})
  public static final class b
    extends com.tencent.mm.plugin.finder.feed.model.internal.f<x.a, x.d, v>
  {
    private com.tencent.mm.plugin.finder.cgi.a.a KPX;
    private m quD;
    
    public b(dzp paramdzp)
    {
      super();
    }
    
    private static List<v> a(x.a parama)
    {
      AppMethodBeat.i(198234);
      k.h(parama, "init");
      parama = new LinkedList();
      try
      {
        Object localObject1 = com.tencent.mm.ui.component.a.LCX;
        localObject1 = ((FinderHomeTabStateVM)com.tencent.mm.ui.component.a.bE(PluginFinder.class).get(FinderHomeTabStateVM.class)).ahO(1000);
        if (((FinderHomeTabStateVM.a)localObject1).Lhj.isEmpty())
        {
          localObject1 = com.tencent.mm.plugin.finder.storage.data.f.qKv;
          f.a.ahz(9);
          Object localObject2 = (Iterable)f.a.aVz("");
          localObject1 = (Collection)new ArrayList(d.a.j.a((Iterable)localObject2, 10));
          localObject2 = ((Iterable)localObject2).iterator();
          while (((Iterator)localObject2).hasNext())
          {
            dzm localdzm = (dzm)((Iterator)localObject2).next();
            z localz = z.KNQ;
            ((Collection)localObject1).add(z.a(localdzm));
            continue;
            parama = (List)parama;
          }
        }
      }
      catch (Throwable localThrowable)
      {
        ad.printErrStackTrace(com.tencent.mm.plugin.finder.feed.model.internal.f.TAG, localThrowable, "lxl FinderLbsLoader load init data exception", new Object[0]);
      }
      for (;;)
      {
        AppMethodBeat.o(198234);
        return parama;
        parama.addAll((Collection)localThrowable);
        ad.i(com.tencent.mm.plugin.finder.feed.model.internal.f.TAG, "lxl FinderLbsLoader load init data from FirstPage, size:" + parama.size());
        continue;
        parama.addAll((Collection)localThrowable.Lhj);
        ad.i(com.tencent.mm.plugin.finder.feed.model.internal.f.TAG, "lxl FinderLbsLoader load init data from tlcache, size:" + parama.size());
      }
    }
    
    public final void alive()
    {
      AppMethodBeat.i(198237);
      this.KPX = new com.tencent.mm.plugin.finder.cgi.a.a(this.contextObj);
      m localm = new m("FinderFollowTlSingleExecutor");
      localm.start();
      this.quD = localm;
      new com.tencent.mm.plugin.finder.cgi.a.a(this.contextObj);
      AppMethodBeat.o(198237);
    }
    
    public final void dead()
    {
      AppMethodBeat.i(198238);
      Object localObject = this.KPX;
      if (localObject != null)
      {
        localObject = ((com.tencent.mm.plugin.finder.cgi.a.a)localObject).KJT;
        if (localObject != null) {
          ((com.tencent.mm.vending.e.c)localObject).dead();
        }
      }
      localObject = this.quD;
      if (localObject != null) {
        ((m)localObject).reset();
      }
      this.quD = null;
      AppMethodBeat.o(198238);
    }
    
    @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "task", "Lcom/tencent/mm/plugin/finder/utils/SingleTask;", "invoke"})
    static final class a
      extends d.g.b.l
      implements d.g.a.b<com.tencent.mm.plugin.finder.utils.l, y>
    {
      a(x.b paramb, x.d paramd, e parame)
      {
        super();
      }
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/finder/feed/model/FinderLbsLoader$FinderLbsResponse;", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IResponse;", "Lcom/tencent/mm/plugin/finder/model/BaseMixFeed;", "errType", "", "errCode", "errMsg", "", "(IILjava/lang/String;)V", "plugin-finder_release"})
  public static final class c
    extends IResponse<v>
  {
    public c(int paramInt1, int paramInt2, String paramString)
    {
      super(paramInt2, paramString);
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/finder/feed/model/FinderLbsLoader$FinderLbsReuqest;", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IRequest;", "pullType", "", "(I)V", "getPullType", "()I", "plugin-finder_release"})
  public static final class d
    implements com.tencent.mm.plugin.finder.feed.model.internal.j
  {
    final int pullType;
    
    public d(int paramInt)
    {
      this.pullType = paramInt;
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "invoke"})
  static final class e
    extends d.g.b.l
    implements d.g.a.a<y>
  {
    e(x paramx, IResponse paramIResponse)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.feed.model.x
 * JD-Core Version:    0.7.0.1
 */