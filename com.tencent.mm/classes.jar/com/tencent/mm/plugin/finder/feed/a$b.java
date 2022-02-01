package com.tencent.mm.plugin.finder.feed;

import android.arch.lifecycle.ViewModelProvider;
import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.hl;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.finder.cgi.w;
import com.tencent.mm.plugin.finder.event.base.c;
import com.tencent.mm.plugin.finder.feed.model.BaseFinderFeedLoader;
import com.tencent.mm.plugin.finder.feed.model.f;
import com.tencent.mm.plugin.finder.model.BaseFinderFeed;
import com.tencent.mm.plugin.finder.model.bo;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderCommentPreloaderUIC;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderLiveNoticePreLoadUIC;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderReporterUIC;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderReporterUIC.a;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.protocal.protobuf.bbn;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IEvent;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.component.a;
import java.util.LinkedList;
import kotlin.g.a.b;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/feed/FinderAtTimelineUIContract$Presenter;", "Lcom/tencent/mm/plugin/finder/feed/FinderLoaderFeedUIContract$Presenter;", "context", "Lcom/tencent/mm/ui/MMActivity;", "isSelfFlag", "", "username", "", "requestAtScene", "", "fromScene", "contextObj", "Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "(Lcom/tencent/mm/ui/MMActivity;ZLjava/lang/String;IILcom/tencent/mm/protocal/protobuf/FinderReportContextObj;)V", "commentPreloader", "Lcom/tencent/mm/plugin/finder/feed/model/FinderCommentPreloader;", "getCommentPreloader", "()Lcom/tencent/mm/plugin/finder/feed/model/FinderCommentPreloader;", "getContextObj", "()Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "finderLiveNoticePreLoader", "Lcom/tencent/mm/plugin/finder/feed/model/FinderLiveNoticePreLoader;", "getFinderLiveNoticePreLoader", "()Lcom/tencent/mm/plugin/finder/feed/model/FinderLiveNoticePreLoader;", "getFromScene", "()I", "()Z", "getRequestAtScene", "getUsername", "()Ljava/lang/String;", "createSecondMenu", "", "feed", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "menu", "Lcom/tencent/mm/ui/base/MMMenu;", "dealMenuClick", "menuItem", "Landroid/view/MenuItem;", "index", "loadMoreData", "onAttach", "model", "Lcom/tencent/mm/plugin/finder/feed/model/BaseFinderFeedLoader;", "callback", "Lcom/tencent/mm/plugin/finder/feed/FinderLoaderFeedUIContract$ViewCallback;", "onDetach", "requestRefresh", "plugin-finder_release"})
public final class a$b
  extends v.a
{
  private final int fromScene;
  private final boolean tFN;
  private final int tLA;
  private final com.tencent.mm.plugin.finder.feed.model.d tLy;
  private final f tLz;
  private final bbn ttO;
  private final String username;
  
  public a$b(MMActivity paramMMActivity, boolean paramBoolean, String paramString, int paramInt1, int paramInt2, bbn parambbn)
  {
    super(paramMMActivity);
    AppMethodBeat.i(243669);
    this.tFN = paramBoolean;
    this.username = paramString;
    this.tLA = paramInt1;
    this.fromScene = paramInt2;
    this.ttO = parambbn;
    paramString = a.PRN;
    this.tLy = ((FinderCommentPreloaderUIC)a.b((AppCompatActivity)paramMMActivity).get(FinderCommentPreloaderUIC.class)).tLy;
    paramString = a.PRN;
    this.tLz = ((FinderLiveNoticePreLoadUIC)a.b((AppCompatActivity)paramMMActivity).get(FinderLiveNoticePreLoadUIC.class)).wyi;
    AppMethodBeat.o(243669);
  }
  
  public final void a(BaseFinderFeedLoader paramBaseFinderFeedLoader, v.b paramb)
  {
    AppMethodBeat.i(243665);
    p.h(paramBaseFinderFeedLoader, "model");
    p.h(paramb, "callback");
    super.a(paramBaseFinderFeedLoader, paramb);
    this.tLy.a(this.tLA, this.tCE, (b)new a(this));
    paramBaseFinderFeedLoader = FinderReporterUIC.wzC;
    paramBaseFinderFeedLoader = FinderReporterUIC.a.fH((Context)this.gte);
    if (paramBaseFinderFeedLoader != null)
    {
      paramBaseFinderFeedLoader = FinderReporterUIC.a(paramBaseFinderFeedLoader);
      if (paramBaseFinderFeedLoader != null) {
        paramBaseFinderFeedLoader.a((com.tencent.mm.plugin.finder.event.base.d)this.tLy);
      }
    }
    this.tLz.e((kotlin.g.a.m)new b(this));
    paramBaseFinderFeedLoader = FinderReporterUIC.wzC;
    paramBaseFinderFeedLoader = FinderReporterUIC.a.fH((Context)this.gte);
    if (paramBaseFinderFeedLoader != null)
    {
      paramBaseFinderFeedLoader = FinderReporterUIC.a(paramBaseFinderFeedLoader);
      if (paramBaseFinderFeedLoader != null)
      {
        paramBaseFinderFeedLoader.a((com.tencent.mm.plugin.finder.event.base.d)this.tLz);
        AppMethodBeat.o(243665);
        return;
      }
    }
    AppMethodBeat.o(243665);
  }
  
  public final void a(BaseFinderFeed paramBaseFinderFeed, MenuItem paramMenuItem, int paramInt)
  {
    AppMethodBeat.i(243667);
    p.h(paramBaseFinderFeed, "feed");
    p.h(paramMenuItem, "menuItem");
    super.a(paramBaseFinderFeed, paramMenuItem, paramInt);
    if (paramMenuItem.getItemId() == this.tLI) {
      if (this.fromScene == 1)
      {
        paramMenuItem = h.CyF;
        if (!p.j(this.username, z.aUg())) {
          break label163;
        }
      }
    }
    label163:
    for (paramInt = 1;; paramInt = 0)
    {
      paramMenuItem.a(21206, new Object[] { Integer.valueOf(paramInt), Integer.valueOf(3) });
      paramMenuItem = this.tFM;
      if (paramMenuItem != null) {
        paramMenuItem.remove(paramBaseFinderFeed.lT(), true);
      }
      new w(paramBaseFinderFeed.lT(), this.ttO).aYI();
      paramMenuItem = new hl();
      paramMenuItem.dLU.feedId = paramBaseFinderFeed.lT();
      EventCenter.instance.publish((IEvent)paramMenuItem);
      AppMethodBeat.o(243667);
      return;
    }
  }
  
  public final void a(BaseFinderFeed paramBaseFinderFeed, com.tencent.mm.ui.base.m paramm)
  {
    AppMethodBeat.i(243666);
    p.h(paramBaseFinderFeed, "feed");
    p.h(paramm, "menu");
    super.a(paramBaseFinderFeed, paramm);
    if (this.tFN) {
      paramm.aS(this.tLI, 2131759541, 2131690780);
    }
    AppMethodBeat.o(243666);
  }
  
  public final void boE()
  {
    AppMethodBeat.i(243664);
    BaseFinderFeedLoader localBaseFinderFeedLoader = this.tFM;
    if (localBaseFinderFeedLoader != null)
    {
      localBaseFinderFeedLoader.requestLoadMore();
      AppMethodBeat.o(243664);
      return;
    }
    AppMethodBeat.o(243664);
  }
  
  public final void onDetach()
  {
    AppMethodBeat.i(243668);
    this.tLy.onDetach();
    Object localObject = FinderReporterUIC.wzC;
    localObject = FinderReporterUIC.a.fH((Context)this.gte);
    if (localObject != null)
    {
      localObject = FinderReporterUIC.a((FinderReporterUIC)localObject);
      if (localObject != null) {
        ((c)localObject).b((com.tencent.mm.plugin.finder.event.base.d)this.tLy);
      }
    }
    this.tLz.onDetach();
    localObject = FinderReporterUIC.wzC;
    localObject = FinderReporterUIC.a.fH((Context)this.gte);
    if (localObject != null)
    {
      localObject = FinderReporterUIC.a((FinderReporterUIC)localObject);
      if (localObject != null) {
        ((c)localObject).b((com.tencent.mm.plugin.finder.event.base.d)this.tLz);
      }
    }
    super.onDetach();
    AppMethodBeat.o(243668);
  }
  
  public final void requestRefresh()
  {
    AppMethodBeat.i(243663);
    BaseFinderFeedLoader localBaseFinderFeedLoader = this.tFM;
    if (localBaseFinderFeedLoader != null)
    {
      localBaseFinderFeedLoader.requestRefresh();
      AppMethodBeat.o(243663);
      return;
    }
    AppMethodBeat.o(243663);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "pos", "", "invoke"})
  static final class a
    extends q
    implements b<Integer, bo>
  {
    a(a.b paramb)
    {
      super();
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "Ljava/util/LinkedList;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "firstItemPos", "", "lastItemPos", "invoke"})
  static final class b
    extends q
    implements kotlin.g.a.m<Integer, Integer, LinkedList<bo>>
  {
    b(a.b paramb)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.feed.a.b
 * JD-Core Version:    0.7.0.1
 */