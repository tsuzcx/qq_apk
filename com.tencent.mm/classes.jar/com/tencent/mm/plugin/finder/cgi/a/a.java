package com.tencent.mm.plugin.finder.cgi.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.feed.model.x.c;
import com.tencent.mm.protocal.protobuf.dzp;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.h;
import d.l;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/finder/cgi/fetcher/FinderLbsFeedFetcher;", "Lcom/tencent/mm/plugin/finder/life/SupportLifecycle;", "tabType", "", "contextObj", "Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "(ILcom/tencent/mm/protocal/protobuf/FinderReportContextObj;)V", "cgiSwitcher", "Lcom/tencent/mm/plugin/finder/cgi/fetcher/FinderLbsFeedFetcher$CgiSwitcher;", "getCgiSwitcher", "()Lcom/tencent/mm/plugin/finder/cgi/fetcher/FinderLbsFeedFetcher$CgiSwitcher;", "isGetHistory", "", "isHistoryFirstPage", "()Z", "setHistoryFirstPage", "(Z)V", "isShowHistoryTip", "setShowHistoryTip", "lifeCycleKeeper", "Lcom/tencent/mm/vending/lifecycle/LifeCycleKeeper;", "Lcom/tencent/mm/vending/lifecycle/ILifeCycle;", "getLifeCycleKeeper", "()Lcom/tencent/mm/vending/lifecycle/LifeCycleKeeper;", "setLifeCycleKeeper", "(Lcom/tencent/mm/vending/lifecycle/LifeCycleKeeper;)V", "check", "", "isNeedClear", "incrementSize", "retFlag", "pullType", "fetch", "request", "Lcom/tencent/mm/plugin/finder/feed/model/FinderLbsLoader$FinderLbsReuqest;", "callback", "Lcom/tencent/mm/plugin/finder/cgi/fetcher/FinderLbsFeedFetcher$Callback;", "consume", "Lcom/tencent/mm/plugin/finder/cgi/CgiFinderTimelineStream$ConsumeCallback;", "getHistory", "Lcom/tencent/mm/plugin/finder/cgi/CgiFinderTimelineStream$Callback;", "isFirstHistoryPage", "extraList", "", "Lcom/tencent/mm/protocal/protobuf/FinderObject;", "getStream", "originPullType", "showErrorToast", "tip", "", "Callback", "CgiSwitcher", "Companion", "plugin-finder_release"})
public final class a
  extends com.tencent.mm.plugin.finder.life.a
{
  public static final a.c KJX;
  public final int IoU;
  public final a.b KJS;
  public com.tencent.mm.vending.e.c<com.tencent.mm.vending.e.a> KJT;
  private volatile boolean KJU;
  public boolean KJV;
  public boolean KJW;
  public final dzp contextObj;
  
  static
  {
    AppMethodBeat.i(197351);
    KJX = new a.c((byte)0);
    AppMethodBeat.o(197351);
  }
  
  public a(dzp paramdzp)
  {
    AppMethodBeat.i(197350);
    this.IoU = 2;
    this.contextObj = paramdzp;
    this.KJS = new a.b(this.IoU);
    this.KJT = new com.tencent.mm.vending.e.c();
    this.KJV = true;
    this.KJW = true;
    AppMethodBeat.o(197350);
  }
  
  private static void aVf(String paramString)
  {
    AppMethodBeat.i(197349);
    ad.e("Finder.FinderLbsFeedFetcher", paramString);
    if ((h.IS_FLAVOR_PURPLE) || (h.DEBUG)) {
      com.tencent.mm.ad.c.g((d.g.a.a)new a.h(paramString));
    }
    AppMethodBeat.o(197349);
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/finder/cgi/fetcher/FinderLbsFeedFetcher$Callback;", "", "onFetchDone", "", "info", "Lcom/tencent/mm/plugin/finder/feed/model/FinderLbsLoader$FinderLbsResponse;", "plugin-finder_release"})
  public static abstract interface a
  {
    public abstract void a(x.c paramc);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.cgi.a.a
 * JD-Core Version:    0.7.0.1
 */