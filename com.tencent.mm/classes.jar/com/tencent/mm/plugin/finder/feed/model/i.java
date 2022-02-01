package com.tencent.mm.plugin.finder.feed.model;

import android.arch.lifecycle.ViewModelProvider;
import android.content.Context;
import android.content.res.Resources;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.u;
import com.tencent.mm.plugin.finder.PluginFinder;
import com.tencent.mm.plugin.finder.cgi.fetcher.a.a;
import com.tencent.mm.plugin.finder.cgi.l.c;
import com.tencent.mm.plugin.finder.feed.model.internal.DataBuffer;
import com.tencent.mm.plugin.finder.feed.model.internal.IResponse;
import com.tencent.mm.plugin.finder.feed.model.internal.b.a;
import com.tencent.mm.plugin.finder.feed.model.internal.d;
import com.tencent.mm.plugin.finder.feed.model.internal.e;
import com.tencent.mm.plugin.finder.feed.model.internal.f;
import com.tencent.mm.plugin.finder.feed.model.internal.g;
import com.tencent.mm.plugin.finder.feed.s;
import com.tencent.mm.plugin.finder.storage.n;
import com.tencent.mm.plugin.finder.utils.q;
import com.tencent.mm.plugin.finder.utils.r;
import com.tencent.mm.plugin.finder.viewmodel.FinderHomeTabStateVM;
import com.tencent.mm.plugin.finder.viewmodel.FinderHomeTabStateVM.a;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.protocal.protobuf.ajr;
import com.tencent.mm.protocal.protobuf.aml;
import com.tencent.mm.protocal.protobuf.anm;
import com.tencent.mm.protocal.protobuf.cqk;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.view.RefreshLoadMoreLayout.c;
import d.y;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

@d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/finder/feed/model/FinderLbsLoader;", "Lcom/tencent/mm/plugin/finder/feed/model/internal/BaseFeedLoader;", "Lcom/tencent/mm/plugin/finder/model/BaseMixFeed;", "contextObj", "Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "(Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;)V", "TAG", "", "getTAG", "()Ljava/lang/String;", "setTAG", "(Ljava/lang/String;)V", "fetchEndCallback", "Lkotlin/Function1;", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IResponse;", "", "getFetchEndCallback", "()Lkotlin/jvm/functions/Function1;", "setFetchEndCallback", "(Lkotlin/jvm/functions/Function1;)V", "createDataFetch", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IDataFetch;", "", "Lcom/tencent/mm/plugin/finder/feed/model/internal/ILoaderData;", "onFetchDone", "response", "onFetchRefreshDone", "requestLoadMore", "requestRefresh", "FinderLbsInit", "FinderLbsListData", "FinderLbsResponse", "FinderLbsReuqest", "plugin-finder_release"})
public final class i
  extends com.tencent.mm.plugin.finder.feed.model.internal.a<com.tencent.mm.plugin.finder.model.b>
{
  private String TAG = "Finder.FinderLbsLoader";
  public d.g.a.b<? super IResponse<com.tencent.mm.plugin.finder.model.b>, y> rmE;
  
  public i(anm paramanm)
  {
    super(paramanm);
  }
  
  public final e<Object, Object, com.tencent.mm.plugin.finder.feed.model.internal.h> createDataFetch(anm paramanm)
  {
    AppMethodBeat.i(202153);
    paramanm = (e)new b(paramanm);
    AppMethodBeat.o(202153);
    return paramanm;
  }
  
  public final String getTAG()
  {
    return this.TAG;
  }
  
  public final void onFetchDone(final IResponse<com.tencent.mm.plugin.finder.model.b> paramIResponse)
  {
    AppMethodBeat.i(202154);
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.bb(paramIResponse);
    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/feed/model/FinderLbsLoader", "com/tencent/mm/plugin/finder/feed/model/internal/BaseFeedLoader", "onFetchDone", "(Lcom/tencent/mm/plugin/finder/feed/model/internal/IResponse;)V", this, localb.aeE());
    d.g.b.k.h(paramIResponse, "response");
    super.onFetchDone(paramIResponse);
    com.tencent.mm.ac.c.g((d.g.a.a)new e(this, paramIResponse));
    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/feed/model/FinderLbsLoader", "com/tencent/mm/plugin/finder/feed/model/internal/BaseFeedLoader", "onFetchDone", "(Lcom/tencent/mm/plugin/finder/feed/model/internal/IResponse;)V");
    AppMethodBeat.o(202154);
  }
  
  public final void onFetchRefreshDone(IResponse<com.tencent.mm.plugin.finder.model.b> paramIResponse)
  {
    AppMethodBeat.i(202155);
    d.g.b.k.h(paramIResponse, "response");
    Object localObject = RefreshLoadMoreLayout.c.Jyi;
    localObject = new RefreshLoadMoreLayout.c(RefreshLoadMoreLayout.c.fyS());
    boolean bool;
    if ((paramIResponse.getErrType() == 0) && (paramIResponse.getErrCode() == 0))
    {
      ((RefreshLoadMoreLayout.c)localObject).JxZ = 1;
      if (paramIResponse.getPullType() == 0) {
        break label180;
      }
      bool = true;
      label54:
      ((RefreshLoadMoreLayout.c)localObject).isT = bool;
      ((RefreshLoadMoreLayout.c)localObject).Jyb = paramIResponse.getHasMore();
      if ((((RefreshLoadMoreLayout.c)localObject).actionType == 0) || (((RefreshLoadMoreLayout.c)localObject).actionType == 4) || (((RefreshLoadMoreLayout.c)localObject).actionType == 4)) {
        if ((((RefreshLoadMoreLayout.c)localObject).Jyc <= 0) && (getDataListJustForAdapter().size() > 0)) {
          break label185;
        }
      }
    }
    Context localContext;
    for (((RefreshLoadMoreLayout.c)localObject).Jya = null;; ((RefreshLoadMoreLayout.c)localObject).Jya = ((CharSequence)localContext.getResources().getString(2131766506)))
    {
      paramIResponse = new com.tencent.mm.plugin.finder.feed.model.internal.k(4, paramIResponse.getIncrementList(), false, 12);
      dispatcher().a(paramIResponse, (RefreshLoadMoreLayout.c)localObject);
      AppMethodBeat.o(202155);
      return;
      localContext = ai.getContext();
      d.g.b.k.g(localContext, "MMApplicationContext.getContext()");
      ((RefreshLoadMoreLayout.c)localObject).Jya = ((CharSequence)localContext.getResources().getString(2131766505));
      ((RefreshLoadMoreLayout.c)localObject).JxZ = -1;
      break;
      label180:
      bool = false;
      break label54;
      label185:
      localContext = ai.getContext();
      d.g.b.k.g(localContext, "MMApplicationContext.getContext()");
    }
  }
  
  public final void requestLoadMore()
  {
    AppMethodBeat.i(202152);
    d locald = new d(2);
    ac.i(getTAG(), "requestLoadMore ".concat(String.valueOf(locald)));
    fetchData((com.tencent.mm.plugin.finder.feed.model.internal.i)locald);
    AppMethodBeat.o(202152);
  }
  
  public final void requestRefresh()
  {
    AppMethodBeat.i(202151);
    d locald = new d(4);
    ac.i(getTAG(), "requestRefresh ".concat(String.valueOf(locald)));
    fetchData((com.tencent.mm.plugin.finder.feed.model.internal.i)locald);
    AppMethodBeat.o(202151);
  }
  
  public final void setTAG(String paramString)
  {
    AppMethodBeat.i(202150);
    d.g.b.k.h(paramString, "<set-?>");
    this.TAG = paramString;
    AppMethodBeat.o(202150);
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/finder/feed/model/FinderLbsLoader$FinderLbsInit;", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IInitRequest;", "initDone", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IInitDone;", "(Lcom/tencent/mm/plugin/finder/feed/model/internal/IInitDone;)V", "plugin-finder_release"})
  public static final class a
    extends g
  {
    public a(f paramf)
    {
      super();
      AppMethodBeat.i(202140);
      AppMethodBeat.o(202140);
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/finder/feed/model/FinderLbsLoader$FinderLbsListData;", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IDataFetch;", "Lcom/tencent/mm/plugin/finder/feed/model/FinderLbsLoader$FinderLbsInit;", "Lcom/tencent/mm/plugin/finder/feed/model/FinderLbsLoader$FinderLbsReuqest;", "Lcom/tencent/mm/plugin/finder/model/BaseMixFeed;", "contextObj", "Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "(Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;)V", "callBack", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IDataCallback;", "getCallBack", "()Lcom/tencent/mm/plugin/finder/feed/model/internal/IDataCallback;", "setCallBack", "(Lcom/tencent/mm/plugin/finder/feed/model/internal/IDataCallback;)V", "fetcher", "Lcom/tencent/mm/plugin/finder/cgi/fetcher/FinderLbsFeedFetcher;", "taskExecutor", "Lcom/tencent/mm/plugin/finder/utils/SingleTaskExecutor;", "alive", "", "call", "request", "callback", "callInitData", "", "init", "dead", "plugin-finder_release"})
  public static final class b
    extends e<i.a, i.d, com.tencent.mm.plugin.finder.model.b>
  {
    private r rgF;
    private com.tencent.mm.plugin.finder.cgi.fetcher.a rmR;
    
    public b(anm paramanm)
    {
      super();
    }
    
    private static List<com.tencent.mm.plugin.finder.model.b> a(i.a parama)
    {
      AppMethodBeat.i(202144);
      d.g.b.k.h(parama, "init");
      parama = new LinkedList();
      try
      {
        Object localObject1 = com.tencent.mm.ui.component.a.IrY;
        localObject1 = ((FinderHomeTabStateVM)com.tencent.mm.ui.component.a.bg(PluginFinder.class).get(FinderHomeTabStateVM.class)).EU(1000);
        if (((FinderHomeTabStateVM.a)localObject1).sbV.isEmpty())
        {
          localObject1 = com.tencent.mm.plugin.finder.storage.data.i.rEV;
          com.tencent.mm.plugin.finder.storage.data.i.a.Ek(9);
          Object localObject2 = (Iterable)com.tencent.mm.plugin.finder.storage.data.i.a.aeg("");
          localObject1 = (Collection)new ArrayList(d.a.j.a((Iterable)localObject2, 10));
          localObject2 = ((Iterable)localObject2).iterator();
          while (((Iterator)localObject2).hasNext())
          {
            aml localaml = (aml)((Iterator)localObject2).next();
            s locals = s.rio;
            ((Collection)localObject1).add(s.a(localaml));
            continue;
            parama = (List)parama;
          }
        }
      }
      catch (Throwable localThrowable)
      {
        ac.printErrStackTrace(e.TAG, localThrowable, "lxl FinderLbsLoader load init data exception", new Object[0]);
      }
      for (;;)
      {
        AppMethodBeat.o(202144);
        return parama;
        parama.addAll((Collection)localThrowable);
        ac.i(e.TAG, "lxl FinderLbsLoader load init data from FirstPage, size:" + parama.size());
        continue;
        parama.addAll((Collection)localThrowable.sbV);
        ac.i(e.TAG, "lxl FinderLbsLoader load init data from tlcache, size:" + parama.size());
      }
    }
    
    public final void alive()
    {
      AppMethodBeat.i(202147);
      this.rmR = new com.tencent.mm.plugin.finder.cgi.fetcher.a(this.contextObj);
      r localr = new r("FinderFollowTlSingleExecutor");
      localr.start();
      this.rgF = localr;
      new com.tencent.mm.plugin.finder.cgi.fetcher.a(this.contextObj);
      AppMethodBeat.o(202147);
    }
    
    public final void dead()
    {
      AppMethodBeat.i(202148);
      Object localObject = this.rmR;
      if (localObject != null)
      {
        localObject = ((com.tencent.mm.plugin.finder.cgi.fetcher.a)localObject).qXf;
        if (localObject != null) {
          ((com.tencent.mm.vending.e.c)localObject).dead();
        }
      }
      localObject = this.rgF;
      if (localObject != null) {
        ((r)localObject).reset();
      }
      this.rgF = null;
      AppMethodBeat.o(202148);
    }
    
    @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "task", "Lcom/tencent/mm/plugin/finder/utils/SingleTask;", "invoke"})
    static final class a
      extends d.g.b.l
      implements d.g.a.b<q, y>
    {
      a(i.b paramb, i.d paramd, d paramd1)
      {
        super();
      }
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/finder/feed/model/FinderLbsLoader$FinderLbsResponse;", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IResponse;", "Lcom/tencent/mm/plugin/finder/model/BaseMixFeed;", "errType", "", "errCode", "errMsg", "", "(IILjava/lang/String;)V", "plugin-finder_release"})
  public static final class c
    extends IResponse<com.tencent.mm.plugin.finder.model.b>
  {
    public c(int paramInt1, int paramInt2, String paramString)
    {
      super(paramInt2, paramString);
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/finder/feed/model/FinderLbsLoader$FinderLbsReuqest;", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IRequest;", "pullType", "", "(I)V", "getPullType", "()I", "plugin-finder_release"})
  public static final class d
    implements com.tencent.mm.plugin.finder.feed.model.internal.i
  {
    final int pullType;
    
    public d(int paramInt)
    {
      this.pullType = paramInt;
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "invoke"})
  static final class e
    extends d.g.b.l
    implements d.g.a.a<y>
  {
    e(i parami, IResponse paramIResponse)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.feed.model.i
 * JD-Core Version:    0.7.0.1
 */