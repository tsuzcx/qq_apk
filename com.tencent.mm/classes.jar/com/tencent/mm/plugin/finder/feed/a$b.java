package com.tencent.mm.plugin.finder.feed;

import android.content.Context;
import android.view.MenuItem;
import androidx.appcompat.app.AppCompatActivity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.a.id;
import com.tencent.mm.plugin.finder.cgi.aj;
import com.tencent.mm.plugin.finder.e.g;
import com.tencent.mm.plugin.finder.e.h;
import com.tencent.mm.plugin.finder.event.base.c;
import com.tencent.mm.plugin.finder.feed.model.BaseFinderFeedLoader;
import com.tencent.mm.plugin.finder.feed.model.i;
import com.tencent.mm.plugin.finder.feed.model.internal.BaseFeedLoader;
import com.tencent.mm.plugin.finder.model.BaseFinderFeed;
import com.tencent.mm.plugin.finder.model.ba;
import com.tencent.mm.plugin.finder.model.cc;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.plugin.finder.viewmodel.component.as.a;
import com.tencent.mm.plugin.findersdk.a.ar;
import com.tencent.mm.plugin.findersdk.a.bn;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.protocal.protobuf.bui;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.component.k;
import com.tencent.mm.ui.component.k.b;
import com.tencent.mm.ui.widget.a.f;
import com.tencent.mm.view.RefreshLoadMoreLayout;
import java.util.LinkedList;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.a.b;
import kotlin.g.a.m;
import kotlin.g.b.u;
import org.json.JSONObject;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/feed/FinderAtTimelineUIContract$Presenter;", "Lcom/tencent/mm/plugin/finder/feed/FinderLoaderFeedUIContract$Presenter;", "context", "Lcom/tencent/mm/ui/MMActivity;", "isSelfFlag", "", "username", "", "requestAtScene", "", "fromScene", "contextObj", "Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "(Lcom/tencent/mm/ui/MMActivity;ZLjava/lang/String;IILcom/tencent/mm/protocal/protobuf/FinderReportContextObj;)V", "commentPreloader", "Lcom/tencent/mm/plugin/finder/feed/model/FinderCommentPreloader;", "getCommentPreloader", "()Lcom/tencent/mm/plugin/finder/feed/model/FinderCommentPreloader;", "getContextObj", "()Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "finderLiveNoticePreLoader", "Lcom/tencent/mm/plugin/findersdk/api/IFinderLiveNoticePreLoader;", "getFinderLiveNoticePreLoader", "()Lcom/tencent/mm/plugin/findersdk/api/IFinderLiveNoticePreLoader;", "getFromScene", "()I", "()Z", "getRequestAtScene", "getUsername", "()Ljava/lang/String;", "createSecondMenu", "", "feed", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "menu", "Lcom/tencent/mm/ui/base/MMMenu;", "sheet", "Lcom/tencent/mm/ui/widget/dialog/MMBottomSheet;", "holder", "Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;", "dealMenuClick", "menuItem", "Landroid/view/MenuItem;", "index", "from", "loadMoreData", "onAttach", "model", "Lcom/tencent/mm/plugin/finder/feed/model/BaseFinderFeedLoader;", "callback", "Lcom/tencent/mm/plugin/finder/feed/FinderLoaderFeedUIContract$ViewCallback;", "onDetach", "reportMention", "eventCode", "feedId", "showValue", "requestRefresh", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class a$b
  extends ae.a
{
  private final boolean ALI;
  private final int ASQ;
  private final bui Auc;
  private final i Aye;
  private final com.tencent.mm.plugin.findersdk.a.as Ayf;
  private final int fromScene;
  final String username;
  
  public a$b(MMActivity paramMMActivity, boolean paramBoolean, String paramString, int paramInt1, int paramInt2, bui parambui)
  {
    super(paramMMActivity);
    AppMethodBeat.i(362568);
    this.ALI = paramBoolean;
    this.username = paramString;
    this.ASQ = paramInt1;
    this.fromScene = paramInt2;
    this.Auc = parambui;
    paramString = k.aeZF;
    this.Aye = ((com.tencent.mm.plugin.finder.viewmodel.component.j)k.d((AppCompatActivity)paramMMActivity).q(com.tencent.mm.plugin.finder.viewmodel.component.j.class)).Aye;
    paramString = k.aeZF;
    this.Ayf = ((ar)k.d((AppCompatActivity)paramMMActivity).cq(ar.class)).eiJ();
    AppMethodBeat.o(362568);
  }
  
  private final void o(int paramInt1, String paramString, int paramInt2)
  {
    AppMethodBeat.i(362577);
    Object localObject = new JSONObject();
    ((JSONObject)localObject).put("feedid", paramString);
    ((JSONObject)localObject).put("show_state", paramInt2);
    paramString = ((JSONObject)localObject).toString();
    kotlin.g.b.s.s(paramString, "JSONObject().apply {\n   …\n            }.toString()");
    localObject = com.tencent.mm.plugin.finder.report.z.FrZ;
    com.tencent.mm.plugin.finder.report.z.a(paramInt1, "if_show_mentionedfeed_icon", paramString, this.Auc);
    AppMethodBeat.o(362577);
  }
  
  public final void a(BaseFinderFeedLoader paramBaseFinderFeedLoader, ae.b paramb)
  {
    AppMethodBeat.i(362599);
    kotlin.g.b.s.u(paramBaseFinderFeedLoader, "model");
    kotlin.g.b.s.u(paramb, "callback");
    super.a(paramBaseFinderFeedLoader, paramb);
    this.Aye.a(this.ASQ, this.AJo, (b)new c(this));
    paramBaseFinderFeedLoader = com.tencent.mm.plugin.finder.viewmodel.component.as.GSQ;
    paramBaseFinderFeedLoader = as.a.hu((Context)this.lzt);
    if (paramBaseFinderFeedLoader != null)
    {
      paramBaseFinderFeedLoader = ((bn)paramBaseFinderFeedLoader).Vm(-1);
      if (paramBaseFinderFeedLoader != null) {
        paramBaseFinderFeedLoader.a((com.tencent.mm.plugin.finder.event.base.d)this.Aye);
      }
    }
    paramb = this.Ayf;
    m localm = (m)new d(this);
    paramBaseFinderFeedLoader = this.ATo;
    if (paramBaseFinderFeedLoader == null) {}
    for (paramBaseFinderFeedLoader = null;; paramBaseFinderFeedLoader = paramBaseFinderFeedLoader.ATx.getRecyclerView())
    {
      paramb.a(localm, paramBaseFinderFeedLoader);
      paramBaseFinderFeedLoader = com.tencent.mm.plugin.finder.viewmodel.component.as.GSQ;
      paramBaseFinderFeedLoader = as.a.hu((Context)this.lzt);
      if (paramBaseFinderFeedLoader != null)
      {
        paramBaseFinderFeedLoader = ((bn)paramBaseFinderFeedLoader).Vm(-1);
        if (paramBaseFinderFeedLoader != null) {
          paramBaseFinderFeedLoader.a(this.Ayf.edV());
        }
      }
      AppMethodBeat.o(362599);
      return;
    }
  }
  
  public final void a(BaseFinderFeed paramBaseFinderFeed, MenuItem paramMenuItem, int paramInt1, int paramInt2, com.tencent.mm.view.recyclerview.j paramj)
  {
    AppMethodBeat.i(362626);
    kotlin.g.b.s.u(paramBaseFinderFeed, "feed");
    kotlin.g.b.s.u(paramMenuItem, "menuItem");
    kotlin.g.b.s.u(paramj, "holder");
    super.a(paramBaseFinderFeed, paramMenuItem, paramInt1, paramInt2, paramj);
    if (paramMenuItem.getItemId() == ebo())
    {
      if (this.fromScene == 1)
      {
        paramMenuItem = h.OAn;
        if (!kotlin.g.b.s.p(this.username, com.tencent.mm.model.z.bAW())) {
          break label178;
        }
      }
      label178:
      for (paramInt1 = 1;; paramInt1 = 0)
      {
        paramMenuItem.b(21206, new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(3) });
        paramMenuItem = this.ALH;
        if (paramMenuItem != null) {
          paramMenuItem.remove(paramBaseFinderFeed.bZA(), true);
        }
        new aj(1, paramBaseFinderFeed.bZA(), null, null, this.Auc, 12).bFJ();
        paramMenuItem = new id();
        paramMenuItem.hJz.feedId = paramBaseFinderFeed.bZA();
        paramMenuItem.publish();
        AppMethodBeat.o(362626);
        return;
      }
    }
    if (paramMenuItem.getItemId() == ebu())
    {
      paramMenuItem = ba.EDs;
      ba.a((Context)this.lzt, paramBaseFinderFeed.feedObject.getId(), 1, (b)new a(paramBaseFinderFeed, this));
      AppMethodBeat.o(362626);
      return;
    }
    if (paramMenuItem.getItemId() == ebt())
    {
      paramMenuItem = ba.EDs;
      ba.a((Context)this.lzt, paramBaseFinderFeed.feedObject.getId(), 0, (b)new b(paramBaseFinderFeed, this));
    }
    AppMethodBeat.o(362626);
  }
  
  public final void a(BaseFinderFeed paramBaseFinderFeed, com.tencent.mm.ui.base.s params, f paramf, com.tencent.mm.view.recyclerview.j paramj)
  {
    AppMethodBeat.i(362609);
    kotlin.g.b.s.u(paramBaseFinderFeed, "feed");
    kotlin.g.b.s.u(params, "menu");
    kotlin.g.b.s.u(paramf, "sheet");
    kotlin.g.b.s.u(paramj, "holder");
    if (this.ALI)
    {
      if (paramBaseFinderFeed.feedObject.getMentionListSelected() != 2) {
        break label100;
      }
      params.bx(ebu(), e.h.finder_mention_not_show_tip, e.g.icons_outlined_display_off);
      o(0, com.tencent.mm.ae.d.hF(paramBaseFinderFeed.feedObject.getId()), 2);
    }
    for (;;)
    {
      super.a(paramBaseFinderFeed, params, paramf, paramj);
      AppMethodBeat.o(362609);
      return;
      label100:
      if (paramBaseFinderFeed.feedObject.getMentionListSelected() == 3)
      {
        params.bx(ebt(), e.h.finder_mention_show_tip, e.g.icons_outlined_display_on);
        o(0, com.tencent.mm.ae.d.hF(paramBaseFinderFeed.feedObject.getId()), 1);
      }
    }
  }
  
  public final void bXB()
  {
    AppMethodBeat.i(362589);
    BaseFinderFeedLoader localBaseFinderFeedLoader = this.ALH;
    if (localBaseFinderFeedLoader != null) {
      BaseFeedLoader.requestLoadMore$default((BaseFeedLoader)localBaseFinderFeedLoader, false, 1, null);
    }
    AppMethodBeat.o(362589);
  }
  
  public final void onDetach()
  {
    AppMethodBeat.i(362634);
    this.Aye.onDetach();
    Object localObject = com.tencent.mm.plugin.finder.viewmodel.component.as.GSQ;
    localObject = as.a.hu((Context)this.lzt);
    if (localObject != null)
    {
      localObject = ((bn)localObject).Vm(-1);
      if (localObject != null) {
        ((c)localObject).b((com.tencent.mm.plugin.finder.event.base.d)this.Aye);
      }
    }
    this.Ayf.onDetach();
    localObject = com.tencent.mm.plugin.finder.viewmodel.component.as.GSQ;
    localObject = as.a.hu((Context)this.lzt);
    if (localObject != null)
    {
      localObject = ((bn)localObject).Vm(-1);
      if (localObject != null) {
        ((c)localObject).b(this.Ayf.edV());
      }
    }
    super.onDetach();
    AppMethodBeat.o(362634);
  }
  
  public final void requestRefresh()
  {
    AppMethodBeat.i(362583);
    BaseFinderFeedLoader localBaseFinderFeedLoader = this.ALH;
    if (localBaseFinderFeedLoader != null) {
      localBaseFinderFeedLoader.requestRefresh();
    }
    AppMethodBeat.o(362583);
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "result", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class a
    extends u
    implements b<Boolean, ah>
  {
    a(BaseFinderFeed paramBaseFinderFeed, a.b paramb)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "result", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class b
    extends u
    implements b<Boolean, ah>
  {
    b(BaseFinderFeed paramBaseFinderFeed, a.b paramb)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "pos", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class c
    extends u
    implements b<Integer, cc>
  {
    c(a.b paramb)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Ljava/util/LinkedList;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "firstItemPos", "", "lastItemPos"}, k=3, mv={1, 5, 1}, xi=48)
  static final class d
    extends u
    implements m<Integer, Integer, LinkedList<cc>>
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