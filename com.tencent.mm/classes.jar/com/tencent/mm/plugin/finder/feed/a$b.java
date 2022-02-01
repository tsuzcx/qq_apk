package com.tencent.mm.plugin.finder.feed;

import android.content.Context;
import android.view.MenuItem;
import androidx.appcompat.app.AppCompatActivity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.f.a.hs;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.finder.b.i;
import com.tencent.mm.plugin.finder.b.j;
import com.tencent.mm.plugin.finder.event.base.c;
import com.tencent.mm.plugin.finder.feed.model.BaseFinderFeedLoader;
import com.tencent.mm.plugin.finder.feed.model.k;
import com.tencent.mm.plugin.finder.live.component.y;
import com.tencent.mm.plugin.finder.model.BaseFinderFeed;
import com.tencent.mm.plugin.finder.model.aw;
import com.tencent.mm.plugin.finder.model.bu;
import com.tencent.mm.plugin.finder.report.n;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.plugin.finder.viewmodel.component.aj;
import com.tencent.mm.plugin.finder.viewmodel.component.aj.a;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.protocal.protobuf.bid;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IEvent;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.o;
import com.tencent.mm.ui.component.g;
import com.tencent.mm.ui.component.g.a;
import com.tencent.mm.ui.widget.a.e;
import com.tencent.mm.view.RefreshLoadMoreLayout;
import java.util.LinkedList;
import kotlin.g.a.b;
import kotlin.g.a.m;
import kotlin.g.b.p;
import kotlin.g.b.q;
import org.json.JSONObject;

@kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/feed/FinderAtTimelineUIContract$Presenter;", "Lcom/tencent/mm/plugin/finder/feed/FinderLoaderFeedUIContract$Presenter;", "context", "Lcom/tencent/mm/ui/MMActivity;", "isSelfFlag", "", "username", "", "requestAtScene", "", "fromScene", "contextObj", "Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "(Lcom/tencent/mm/ui/MMActivity;ZLjava/lang/String;IILcom/tencent/mm/protocal/protobuf/FinderReportContextObj;)V", "commentPreloader", "Lcom/tencent/mm/plugin/finder/feed/model/FinderCommentPreloader;", "getCommentPreloader", "()Lcom/tencent/mm/plugin/finder/feed/model/FinderCommentPreloader;", "getContextObj", "()Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "finderLiveNoticePreLoader", "Lcom/tencent/mm/plugin/finder/feed/model/FinderLiveNoticePreLoader;", "getFinderLiveNoticePreLoader", "()Lcom/tencent/mm/plugin/finder/feed/model/FinderLiveNoticePreLoader;", "getFromScene", "()I", "()Z", "getRequestAtScene", "getUsername", "()Ljava/lang/String;", "createSecondMenu", "", "feed", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "menu", "Lcom/tencent/mm/ui/base/MMMenu;", "sheet", "Lcom/tencent/mm/ui/widget/dialog/MMBottomSheet;", "dealMenuClick", "menuItem", "Landroid/view/MenuItem;", "index", "from", "holder", "Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;", "loadMoreData", "onAttach", "model", "Lcom/tencent/mm/plugin/finder/feed/model/BaseFinderFeedLoader;", "callback", "Lcom/tencent/mm/plugin/finder/feed/FinderLoaderFeedUIContract$ViewCallback;", "onDetach", "reportMention", "eventCode", "feedId", "showValue", "requestRefresh", "plugin-finder_release"})
public final class a$b
  extends aa.a
{
  private final int fromScene;
  final String username;
  private final bid xbu;
  private final boolean xnY;
  private final com.tencent.mm.plugin.finder.feed.model.i xve;
  private final k xvf;
  private final int xvg;
  
  public a$b(MMActivity paramMMActivity, boolean paramBoolean, String paramString, int paramInt1, int paramInt2, bid parambid)
  {
    super(paramMMActivity);
    AppMethodBeat.i(270578);
    this.xnY = paramBoolean;
    this.username = paramString;
    this.xvg = paramInt1;
    this.fromScene = paramInt2;
    this.xbu = parambid;
    paramString = g.Xox;
    this.xve = ((com.tencent.mm.plugin.finder.viewmodel.component.l)g.b((AppCompatActivity)paramMMActivity).i(com.tencent.mm.plugin.finder.viewmodel.component.l.class)).xve;
    paramString = g.Xox;
    this.xvf = ((y)g.b((AppCompatActivity)paramMMActivity).i(y.class)).yci;
    AppMethodBeat.o(270578);
  }
  
  private final void m(int paramInt1, String paramString, int paramInt2)
  {
    AppMethodBeat.i(270576);
    Object localObject = new JSONObject();
    ((JSONObject)localObject).put("feedid", paramString);
    ((JSONObject)localObject).put("show_state", paramInt2);
    paramString = ((JSONObject)localObject).toString();
    p.j(paramString, "JSONObject().apply {\n   …\n            }.toString()");
    localObject = n.zWF;
    n.a(paramInt1, "if_show_mentionedfeed_icon", paramString, this.xbu);
    AppMethodBeat.o(270576);
  }
  
  public final void a(BaseFinderFeedLoader paramBaseFinderFeedLoader, aa.b paramb)
  {
    AppMethodBeat.i(270573);
    p.k(paramBaseFinderFeedLoader, "model");
    p.k(paramb, "callback");
    super.a(paramBaseFinderFeedLoader, paramb);
    this.xve.a(this.xvg, this.xkX, (b)new c(this));
    paramBaseFinderFeedLoader = aj.Bnu;
    paramBaseFinderFeedLoader = aj.a.fZ((Context)this.iXq);
    if (paramBaseFinderFeedLoader != null)
    {
      paramBaseFinderFeedLoader = aj.a(paramBaseFinderFeedLoader);
      if (paramBaseFinderFeedLoader != null) {
        paramBaseFinderFeedLoader.a((com.tencent.mm.plugin.finder.event.base.d)this.xve);
      }
    }
    paramb = this.xvf;
    m localm = (m)new d(this);
    paramBaseFinderFeedLoader = this.xvC;
    if (paramBaseFinderFeedLoader != null) {}
    for (paramBaseFinderFeedLoader = paramBaseFinderFeedLoader.xvJ.getRecyclerView();; paramBaseFinderFeedLoader = null)
    {
      paramb.a(localm, paramBaseFinderFeedLoader);
      paramBaseFinderFeedLoader = aj.Bnu;
      paramBaseFinderFeedLoader = aj.a.fZ((Context)this.iXq);
      if (paramBaseFinderFeedLoader == null) {
        break;
      }
      paramBaseFinderFeedLoader = aj.a(paramBaseFinderFeedLoader);
      if (paramBaseFinderFeedLoader == null) {
        break;
      }
      paramBaseFinderFeedLoader.a((com.tencent.mm.plugin.finder.event.base.d)this.xvf);
      AppMethodBeat.o(270573);
      return;
    }
    AppMethodBeat.o(270573);
  }
  
  public final void a(final BaseFinderFeed paramBaseFinderFeed, MenuItem paramMenuItem, int paramInt1, int paramInt2, com.tencent.mm.view.recyclerview.i parami)
  {
    AppMethodBeat.i(270575);
    p.k(paramBaseFinderFeed, "feed");
    p.k(paramMenuItem, "menuItem");
    p.k(parami, "holder");
    super.a(paramBaseFinderFeed, paramMenuItem, paramInt1, paramInt2, parami);
    if (paramMenuItem.getItemId() == this.xvp)
    {
      if (this.fromScene == 1)
      {
        paramMenuItem = h.IzE;
        if (!p.h(this.username, z.bdh())) {
          break label184;
        }
      }
      label184:
      for (paramInt1 = 1;; paramInt1 = 0)
      {
        paramMenuItem.a(21206, new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(3) });
        paramMenuItem = this.xnX;
        if (paramMenuItem != null) {
          paramMenuItem.remove(paramBaseFinderFeed.mf(), true);
        }
        new com.tencent.mm.plugin.finder.cgi.x(1, paramBaseFinderFeed.mf(), null, null, this.xbu, 12).bhW();
        paramMenuItem = new hs();
        paramMenuItem.fEJ.feedId = paramBaseFinderFeed.mf();
        EventCenter.instance.publish((IEvent)paramMenuItem);
        AppMethodBeat.o(270575);
        return;
      }
    }
    if (paramMenuItem.getItemId() == dso())
    {
      paramMenuItem = aw.zBj;
      aw.a((Context)this.iXq, paramBaseFinderFeed.feedObject.getId(), 1, (b)new a(this, paramBaseFinderFeed));
      AppMethodBeat.o(270575);
      return;
    }
    if (paramMenuItem.getItemId() == dsn())
    {
      paramMenuItem = aw.zBj;
      aw.a((Context)this.iXq, paramBaseFinderFeed.feedObject.getId(), 0, (b)new b(this, paramBaseFinderFeed));
    }
    AppMethodBeat.o(270575);
  }
  
  public final void a(BaseFinderFeed paramBaseFinderFeed, o paramo, e parame)
  {
    AppMethodBeat.i(270574);
    p.k(paramBaseFinderFeed, "feed");
    p.k(paramo, "menu");
    p.k(parame, "sheet");
    if (this.xnY)
    {
      if (paramBaseFinderFeed.feedObject.getMentionListSelected() != 2) {
        break label90;
      }
      paramo.aW(dso(), b.j.finder_mention_not_show_tip, b.i.icons_outlined_display_off);
      m(0, com.tencent.mm.ae.d.Fw(paramBaseFinderFeed.feedObject.getId()), 2);
    }
    for (;;)
    {
      super.a(paramBaseFinderFeed, paramo, parame);
      AppMethodBeat.o(270574);
      return;
      label90:
      if (paramBaseFinderFeed.feedObject.getMentionListSelected() == 3)
      {
        paramo.aW(dsn(), b.j.finder_mention_show_tip, b.i.icons_outlined_display_on);
        m(0, com.tencent.mm.ae.d.Fw(paramBaseFinderFeed.feedObject.getId()), 1);
      }
    }
  }
  
  public final void byN()
  {
    AppMethodBeat.i(270571);
    BaseFinderFeedLoader localBaseFinderFeedLoader = this.xnX;
    if (localBaseFinderFeedLoader != null)
    {
      localBaseFinderFeedLoader.requestLoadMore();
      AppMethodBeat.o(270571);
      return;
    }
    AppMethodBeat.o(270571);
  }
  
  public final void onDetach()
  {
    AppMethodBeat.i(270577);
    this.xve.onDetach();
    Object localObject = aj.Bnu;
    localObject = aj.a.fZ((Context)this.iXq);
    if (localObject != null)
    {
      localObject = aj.a((aj)localObject);
      if (localObject != null) {
        ((c)localObject).b((com.tencent.mm.plugin.finder.event.base.d)this.xve);
      }
    }
    this.xvf.onDetach();
    localObject = aj.Bnu;
    localObject = aj.a.fZ((Context)this.iXq);
    if (localObject != null)
    {
      localObject = aj.a((aj)localObject);
      if (localObject != null) {
        ((c)localObject).b((com.tencent.mm.plugin.finder.event.base.d)this.xvf);
      }
    }
    super.onDetach();
    AppMethodBeat.o(270577);
  }
  
  public final void requestRefresh()
  {
    AppMethodBeat.i(270570);
    BaseFinderFeedLoader localBaseFinderFeedLoader = this.xnX;
    if (localBaseFinderFeedLoader != null)
    {
      localBaseFinderFeedLoader.requestRefresh();
      AppMethodBeat.o(270570);
      return;
    }
    AppMethodBeat.o(270570);
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "result", "", "invoke"})
  static final class a
    extends q
    implements b<Boolean, kotlin.x>
  {
    a(a.b paramb, BaseFinderFeed paramBaseFinderFeed)
    {
      super();
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "result", "", "invoke"})
  static final class b
    extends q
    implements b<Boolean, kotlin.x>
  {
    b(a.b paramb, BaseFinderFeed paramBaseFinderFeed)
    {
      super();
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "pos", "", "invoke"})
  static final class c
    extends q
    implements b<Integer, bu>
  {
    c(a.b paramb)
    {
      super();
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "Ljava/util/LinkedList;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "firstItemPos", "", "lastItemPos", "invoke"})
  static final class d
    extends q
    implements m<Integer, Integer, LinkedList<bu>>
  {
    d(a.b paramb)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.feed.a.b
 * JD-Core Version:    0.7.0.1
 */