package com.tencent.mm.plugin.finder.cgi.fetcher;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.cgi.f.a;
import com.tencent.mm.plugin.finder.cgi.l.c;
import com.tencent.mm.plugin.finder.feed.model.i.c;
import com.tencent.mm.plugin.finder.feed.s;
import com.tencent.mm.protocal.protobuf.alc;
import com.tencent.mm.protocal.protobuf.aml;
import com.tencent.mm.protocal.protobuf.anm;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.h;
import d.a.j;
import d.a.v;
import d.g.b.k;
import d.l;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/finder/cgi/fetcher/FinderLbsFeedFetcher;", "Lcom/tencent/mm/plugin/finder/life/SupportLifecycle;", "tabType", "", "contextObj", "Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "(ILcom/tencent/mm/protocal/protobuf/FinderReportContextObj;)V", "cgiSwitcher", "Lcom/tencent/mm/plugin/finder/cgi/fetcher/FinderLbsFeedFetcher$CgiSwitcher;", "getCgiSwitcher", "()Lcom/tencent/mm/plugin/finder/cgi/fetcher/FinderLbsFeedFetcher$CgiSwitcher;", "isGetHistory", "", "isHistoryFirstPage", "()Z", "setHistoryFirstPage", "(Z)V", "isShowHistoryTip", "setShowHistoryTip", "lifeCycleKeeper", "Lcom/tencent/mm/vending/lifecycle/LifeCycleKeeper;", "Lcom/tencent/mm/vending/lifecycle/ILifeCycle;", "getLifeCycleKeeper", "()Lcom/tencent/mm/vending/lifecycle/LifeCycleKeeper;", "setLifeCycleKeeper", "(Lcom/tencent/mm/vending/lifecycle/LifeCycleKeeper;)V", "check", "", "isNeedClear", "incrementSize", "retFlag", "pullType", "fetch", "request", "Lcom/tencent/mm/plugin/finder/feed/model/FinderLbsLoader$FinderLbsReuqest;", "callback", "Lcom/tencent/mm/plugin/finder/cgi/fetcher/FinderLbsFeedFetcher$Callback;", "consume", "Lcom/tencent/mm/plugin/finder/cgi/CgiFinderTimelineStream$ConsumeCallback;", "getHistory", "Lcom/tencent/mm/plugin/finder/cgi/CgiFinderTimelineStream$Callback;", "isFirstHistoryPage", "extraList", "", "Lcom/tencent/mm/protocal/protobuf/FinderObject;", "getStream", "originPullType", "showErrorToast", "tip", "", "Callback", "CgiSwitcher", "Companion", "plugin-finder_release"})
public final class a
  extends com.tencent.mm.plugin.finder.life.a
{
  public static final c qZa;
  public final anm contextObj;
  public final int diw;
  public com.tencent.mm.vending.e.c<com.tencent.mm.vending.e.a> qXf;
  public final b qYW;
  private volatile boolean qYX;
  public boolean qYY;
  public boolean qYZ;
  
  static
  {
    AppMethodBeat.i(201229);
    qZa = new c((byte)0);
    AppMethodBeat.o(201229);
  }
  
  public a(anm paramanm)
  {
    AppMethodBeat.i(201228);
    this.diw = 2;
    this.contextObj = paramanm;
    this.qYW = new b(this.diw);
    this.qXf = new com.tencent.mm.vending.e.c();
    this.qYY = true;
    this.qYZ = true;
    AppMethodBeat.o(201228);
  }
  
  private static void adn(String paramString)
  {
    AppMethodBeat.i(201227);
    ac.e("Finder.FinderLbsFeedFetcher", paramString);
    if ((h.IS_FLAVOR_PURPLE) || (h.DEBUG)) {
      com.tencent.mm.ac.c.g((d.g.a.a)new a.h(paramString));
    }
    AppMethodBeat.o(201227);
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/finder/cgi/fetcher/FinderLbsFeedFetcher$Callback;", "", "onFetchDone", "", "info", "Lcom/tencent/mm/plugin/finder/feed/model/FinderLbsLoader$FinderLbsResponse;", "plugin-finder_release"})
  public static abstract interface a
  {
    public abstract void a(i.c paramc);
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/finder/cgi/fetcher/FinderLbsFeedFetcher$CgiSwitcher;", "", "tabType", "", "(I)V", "curCgi", "getCurCgi", "()I", "setCurCgi", "lbsLastBuffer", "Lcom/tencent/mm/protobuf/ByteString;", "getLbsLastBuffer", "()Lcom/tencent/mm/protobuf/ByteString;", "setLbsLastBuffer", "(Lcom/tencent/mm/protobuf/ByteString;)V", "remainLbsData", "Ljava/util/LinkedList;", "Lcom/tencent/mm/plugin/finder/model/BaseMixFeed;", "getRemainLbsData", "()Ljava/util/LinkedList;", "setRemainLbsData", "(Ljava/util/LinkedList;)V", "streamLastBuffer", "getStreamLastBuffer", "setStreamLastBuffer", "getTabType", "switchToHistory", "", "switchToStream", "plugin-finder_release"})
  public static final class b
  {
    private final int diw;
    public int qZb;
    public com.tencent.mm.bw.b qZc;
    public com.tencent.mm.bw.b qZd;
    LinkedList<com.tencent.mm.plugin.finder.model.b> qZe;
    
    public b(int paramInt)
    {
      AppMethodBeat.i(201220);
      this.diw = paramInt;
      this.qZb = 1;
      this.qZe = new LinkedList();
      AppMethodBeat.o(201220);
    }
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/finder/cgi/fetcher/FinderLbsFeedFetcher$Companion;", "", "()V", "TAG", "", "plugin-finder_release"})
  public static final class c {}
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"com/tencent/mm/plugin/finder/cgi/fetcher/FinderLbsFeedFetcher$fetch$1", "Lcom/tencent/mm/plugin/finder/cgi/CgiFinderGetNearbyList$Callback;", "onFetchDone", "", "errType", "", "errCode", "errMsg", "", "resp", "Lcom/tencent/mm/protocal/protobuf/FinderGetNearbyListResp;", "pullType", "plugin-finder_release"})
  public static final class d
    implements f.a
  {
    public d(a.a parama, l.c paramc) {}
    
    public final void a(int paramInt1, int paramInt2, String paramString, alc paramalc, int paramInt3)
    {
      AppMethodBeat.i(201221);
      k.h(paramalc, "resp");
      i.c localc = new i.c(paramInt1, paramInt2, paramString);
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        this.qZf.qYW.qZc = paramalc.lastBuffer;
        paramString = paramalc.EEP;
        Object localObject1;
        if (paramString != null)
        {
          localObject1 = (Iterable)paramString;
          paramString = (Collection)new ArrayList(j.a((Iterable)localObject1, 10));
          localObject1 = ((Iterable)localObject1).iterator();
          while (((Iterator)localObject1).hasNext())
          {
            localObject2 = (aml)((Iterator)localObject1).next();
            s locals = s.rio;
            k.g(localObject2, "section");
            paramString.add(s.a((aml)localObject2));
          }
          paramString = (List)paramString;
          Object localObject2 = new StringBuilder("incrementList size: ");
          localObject1 = localc.getIncrementList();
          if (localObject1 == null) {
            break label263;
          }
          localObject1 = Integer.valueOf(((List)localObject1).size());
          label179:
          ac.i("Finder.FinderLbsFeedFetcher", localObject1);
          localc.setIncrementList(paramString);
          localc.setPullType(paramInt3);
          localc.setLastBuffer(paramalc.lastBuffer);
          if (paramalc.continueFlag != 1) {
            break label269;
          }
        }
        label263:
        label269:
        for (boolean bool = true;; bool = false)
        {
          localc.setHasMore(bool);
          this.qZg.a(localc);
          AppMethodBeat.o(201221);
          return;
          paramString = (List)v.KTF;
          break;
          localObject1 = null;
          break label179;
        }
      }
      localc.setHasMore(true);
      AppMethodBeat.o(201221);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.cgi.fetcher.a
 * JD-Core Version:    0.7.0.1
 */