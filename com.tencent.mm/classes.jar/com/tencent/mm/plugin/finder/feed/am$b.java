package com.tencent.mm.plugin.finder.feed;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.view.MenuItem;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.p;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.finder.cgi.bt;
import com.tencent.mm.plugin.finder.convert.q;
import com.tencent.mm.plugin.finder.convert.t;
import com.tencent.mm.plugin.finder.feed.model.BaseFinderFeedLoader;
import com.tencent.mm.plugin.finder.feed.model.internal.BaseFeedLoader;
import com.tencent.mm.plugin.finder.feed.ui.FinderPostPreviewUI;
import com.tencent.mm.plugin.finder.model.BaseFinderFeed;
import com.tencent.mm.plugin.finder.model.cc;
import com.tencent.mm.plugin.finder.publish.l.h;
import com.tencent.mm.plugin.finder.publish.l.i;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.plugin.finder.utils.av;
import com.tencent.mm.plugin.finder.utils.aw;
import com.tencent.mm.plugin.finder.viewmodel.component.as;
import com.tencent.mm.plugin.finder.viewmodel.component.as.a;
import com.tencent.mm.plugin.findersdk.a.bn;
import com.tencent.mm.protocal.protobuf.bui;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.aa;
import com.tencent.mm.ui.base.u.g;
import com.tencent.mm.ui.component.k.b;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.b.u;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/feed/FinderPreviewTimelineUIContract$Presenter;", "Lcom/tencent/mm/plugin/finder/feed/FinderLoaderFeedUIContract$Presenter;", "activity", "Lcom/tencent/mm/plugin/finder/feed/ui/FinderPostPreviewUI;", "isSelfFlag", "", "username", "", "requestAtScene", "", "fromScene", "contextObj", "Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "(Lcom/tencent/mm/plugin/finder/feed/ui/FinderPostPreviewUI;ZLjava/lang/String;IILcom/tencent/mm/protocal/protobuf/FinderReportContextObj;)V", "getActivity", "()Lcom/tencent/mm/plugin/finder/feed/ui/FinderPostPreviewUI;", "commentPreloader", "Lcom/tencent/mm/plugin/finder/feed/model/FinderCommentPreloader;", "getCommentPreloader", "()Lcom/tencent/mm/plugin/finder/feed/model/FinderCommentPreloader;", "getContextObj", "()Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "getFromScene", "()I", "()Z", "getRequestAtScene", "tipDialog", "Landroid/app/Dialog;", "getUsername", "()Ljava/lang/String;", "buildItemCoverts", "Lcom/tencent/mm/view/recyclerview/ItemConvertFactory;", "dealMenuClick", "", "feed", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "menuItem", "Landroid/view/MenuItem;", "index", "from", "holder", "Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;", "getCreateSecondMoreMenuListener", "Lcom/tencent/mm/ui/base/MMMenuListener$OnCreateMMMenuListener;", "sheet", "Lcom/tencent/mm/ui/widget/dialog/MMBottomSheet;", "loadMoreData", "onAttach", "model", "Lcom/tencent/mm/plugin/finder/feed/model/BaseFinderFeedLoader;", "callback", "Lcom/tencent/mm/plugin/finder/feed/FinderLoaderFeedUIContract$ViewCallback;", "onDetach", "requestRefresh", "plugin-finder-publish_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class am$b
  extends ae.a
{
  private final boolean ALI;
  private final int ASQ;
  final FinderPostPreviewUI AXU;
  private final bui Auc;
  private final com.tencent.mm.plugin.finder.feed.model.i Aye;
  private final int fromScene;
  private Dialog tipDialog;
  private final String username;
  
  public am$b(FinderPostPreviewUI paramFinderPostPreviewUI, boolean paramBoolean, String paramString, int paramInt1, int paramInt2, bui parambui)
  {
    super((MMActivity)paramFinderPostPreviewUI);
    AppMethodBeat.i(363855);
    this.AXU = paramFinderPostPreviewUI;
    this.ALI = paramBoolean;
    this.username = paramString;
    this.ASQ = paramInt1;
    this.fromScene = paramInt2;
    this.Auc = parambui;
    this.hJx = -2147483648;
    paramFinderPostPreviewUI = com.tencent.mm.ui.component.k.aeZF;
    this.Aye = ((com.tencent.mm.plugin.finder.viewmodel.component.j)com.tencent.mm.ui.component.k.d((AppCompatActivity)this.lzt).q(com.tencent.mm.plugin.finder.viewmodel.component.j.class)).Aye;
    AppMethodBeat.o(363855);
  }
  
  private static final void a(b paramb, BaseFinderFeed paramBaseFinderFeed, com.tencent.mm.ui.base.s params)
  {
    boolean bool = false;
    AppMethodBeat.i(363867);
    kotlin.g.b.s.u(paramb, "this$0");
    kotlin.g.b.s.u(paramBaseFinderFeed, "$feed");
    int i;
    if (paramb.AXU.Brb)
    {
      localObject = com.tencent.mm.plugin.finder.upload.action.c.GcH;
      if (com.tencent.mm.plugin.finder.upload.action.c.fee().s(paramBaseFinderFeed.feedObject.getFeedObject())) {
        break label260;
      }
      i = 1;
      localObject = com.tencent.mm.plugin.finder.storage.d.FAy;
      if (((Number)com.tencent.mm.plugin.finder.storage.d.eXJ().bmg()).intValue() == 0)
      {
        if (i == 0) {
          break label265;
        }
        params.a(paramb.ebq(), (CharSequence)paramb.lzt.getString(l.i.favorite), l.h.finder_icons_filled_star2);
      }
    }
    for (;;)
    {
      localObject = av.GiL;
      if (av.I(paramBaseFinderFeed.feedObject))
      {
        i = paramb.ebp();
        localObject = av.GiL;
        localObject = (CharSequence)av.r(paramBaseFinderFeed);
        int j = l.h.icons_outlined_bgm_play;
        if ((!paramBaseFinderFeed.feedObject.isPostFinish()) || (paramBaseFinderFeed.feedObject.isPostFailed())) {
          bool = true;
        }
        params.a(i, (CharSequence)localObject, j, bool);
      }
      localObject = av.GiL;
      if (av.e(paramBaseFinderFeed)) {
        break label293;
      }
      if ((paramb.hJx != 3) && (paramb.hJx != 1)) {
        params.a(paramb.ebj(), (CharSequence)paramb.lzt.getString(l.i.more_menu_unlike), l.h.finder_feed_dislike);
      }
      params.a(paramb.ebk(), (CharSequence)paramb.lzt.getString(l.i.more_menu_back), l.h.icons_outlined_report_problem);
      AppMethodBeat.o(363867);
      return;
      label260:
      i = 0;
      break;
      label265:
      params.a(paramb.ebr(), (CharSequence)paramb.lzt.getString(l.i.finder_cancel_fav_title), l.h.finder_icons_filled_unstar2);
    }
    label293:
    Object localObject = aw.Gjk;
    if (!aw.s(paramBaseFinderFeed))
    {
      params.bx(paramb.ebo(), l.i.app_delete, l.h.icons_outlined_delete);
      if (!paramBaseFinderFeed.feedObject.isCommentClose()) {
        break label412;
      }
      params.a(paramb.ebn(), (CharSequence)paramb.lzt.getString(l.i.finder_feed_open_comment), l.h.icons_outlined_comment);
    }
    for (;;)
    {
      if ((!paramb.AXU.Brb) && ((paramBaseFinderFeed.bZB() == 4) || (paramBaseFinderFeed.bZB() == 2))) {
        params.a(paramb.ebs(), (CharSequence)paramb.lzt.getString(l.i.finder_feed_open_in_full_window), l.h.finder_icons_outlined_max_window);
      }
      AppMethodBeat.o(363867);
      return;
      label412:
      params.a(paramb.ebm(), (CharSequence)paramb.lzt.getString(l.i.finder_feed_close_comment), l.h.finder_feed_discomment);
    }
  }
  
  private static final void a(BaseFinderFeed paramBaseFinderFeed, final b paramb, DialogInterface paramDialogInterface, int paramInt)
  {
    AppMethodBeat.i(363874);
    kotlin.g.b.s.u(paramBaseFinderFeed, "$feed");
    kotlin.g.b.s.u(paramb, "this$0");
    paramDialogInterface = z.bAW();
    kotlin.g.b.s.s(paramDialogInterface, "getMyFinderUsername()");
    paramDialogInterface = new bt(paramDialogInterface, paramBaseFinderFeed.feedObject.getFeedObject());
    paramBaseFinderFeed = paramb.tipDialog;
    if (paramBaseFinderFeed == null) {}
    for (paramBaseFinderFeed = null;; paramBaseFinderFeed = ah.aiuX)
    {
      if (paramBaseFinderFeed == null)
      {
        paramBaseFinderFeed = (Context)paramb.lzt;
        paramb.lzt.getString(l.i.app_tip);
        paramb.tipDialog = ((Dialog)com.tencent.mm.ui.base.k.a(paramBaseFinderFeed, paramb.lzt.getString(l.i.app_waiting), false, am.b..ExternalSyntheticLambda0.INSTANCE));
      }
      com.tencent.mm.kernel.h.aZW().a(paramDialogInterface.getType(), (com.tencent.mm.am.h)new b(paramDialogInterface, paramb));
      com.tencent.mm.kernel.h.aZW().a((p)paramDialogInterface, 0);
      AppMethodBeat.o(363874);
      return;
      paramBaseFinderFeed.show();
    }
  }
  
  private static final void h(DialogInterface paramDialogInterface) {}
  
  public final u.g a(BaseFinderFeed paramBaseFinderFeed, com.tencent.mm.ui.widget.a.f paramf, com.tencent.mm.view.recyclerview.j paramj)
  {
    AppMethodBeat.i(363918);
    kotlin.g.b.s.u(paramBaseFinderFeed, "feed");
    kotlin.g.b.s.u(paramf, "sheet");
    kotlin.g.b.s.u(paramj, "holder");
    paramBaseFinderFeed = new am.b..ExternalSyntheticLambda2(this, paramBaseFinderFeed);
    AppMethodBeat.o(363918);
    return paramBaseFinderFeed;
  }
  
  public final void a(BaseFinderFeedLoader paramBaseFinderFeedLoader, ae.b paramb)
  {
    AppMethodBeat.i(363914);
    kotlin.g.b.s.u(paramBaseFinderFeedLoader, "model");
    kotlin.g.b.s.u(paramb, "callback");
    super.a(paramBaseFinderFeedLoader, paramb);
    this.Aye.a(this.ASQ, this.AJo, (kotlin.g.a.b)new c(this));
    paramBaseFinderFeedLoader = as.GSQ;
    paramBaseFinderFeedLoader = as.a.hu((Context)this.lzt);
    if (paramBaseFinderFeedLoader != null)
    {
      paramBaseFinderFeedLoader = ((bn)paramBaseFinderFeedLoader).Vm(-1);
      if (paramBaseFinderFeedLoader != null) {
        paramBaseFinderFeedLoader.a((com.tencent.mm.plugin.finder.event.base.d)this.Aye);
      }
    }
    AppMethodBeat.o(363914);
  }
  
  public final void a(BaseFinderFeed paramBaseFinderFeed, MenuItem paramMenuItem, int paramInt1, int paramInt2, com.tencent.mm.view.recyclerview.j paramj)
  {
    AppMethodBeat.i(363923);
    kotlin.g.b.s.u(paramBaseFinderFeed, "feed");
    kotlin.g.b.s.u(paramMenuItem, "menuItem");
    kotlin.g.b.s.u(paramj, "holder");
    super.a(paramBaseFinderFeed, paramMenuItem, paramInt1, paramInt2, paramj);
    if ((paramMenuItem.getItemId() == ebo()) && (paramBaseFinderFeed.feedObject.isPostFinish()))
    {
      paramInt1 = l.i.finder_profile_confirm_del;
      com.tencent.mm.ui.base.k.a((Context)this.lzt, paramInt1, 0, new am.b..ExternalSyntheticLambda1(paramBaseFinderFeed, this), null);
    }
    AppMethodBeat.o(363923);
  }
  
  public final void bXB()
  {
    AppMethodBeat.i(363907);
    BaseFinderFeedLoader localBaseFinderFeedLoader = this.ALH;
    if (localBaseFinderFeedLoader != null) {
      BaseFeedLoader.requestLoadMore$default((BaseFeedLoader)localBaseFinderFeedLoader, false, 1, null);
    }
    AppMethodBeat.o(363907);
  }
  
  public final com.tencent.mm.view.recyclerview.g dUK()
  {
    AppMethodBeat.i(363935);
    com.tencent.mm.view.recyclerview.g localg = (com.tencent.mm.view.recyclerview.g)new a(this);
    AppMethodBeat.o(363935);
    return localg;
  }
  
  public final void onDetach()
  {
    AppMethodBeat.i(363929);
    this.Aye.onDetach();
    Object localObject = as.GSQ;
    localObject = as.a.hu((Context)this.lzt);
    if (localObject != null)
    {
      localObject = ((bn)localObject).Vm(-1);
      if (localObject != null) {
        ((com.tencent.mm.plugin.finder.event.base.c)localObject).b((com.tencent.mm.plugin.finder.event.base.d)this.Aye);
      }
    }
    super.onDetach();
    AppMethodBeat.o(363929);
  }
  
  public final void requestRefresh()
  {
    AppMethodBeat.i(363901);
    BaseFinderFeedLoader localBaseFinderFeedLoader = this.ALH;
    if (localBaseFinderFeedLoader != null) {
      localBaseFinderFeedLoader.requestRefresh();
    }
    AppMethodBeat.o(363901);
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/feed/FinderPreviewTimelineUIContract$Presenter$buildItemCoverts$1", "Lcom/tencent/mm/view/recyclerview/ItemConvertFactory;", "getItemConvert", "Lcom/tencent/mm/view/recyclerview/ItemConvert;", "type", "", "plugin-finder-publish_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a
    implements com.tencent.mm.view.recyclerview.g
  {
    a(am.b paramb) {}
    
    public final com.tencent.mm.view.recyclerview.f<?> yF(int paramInt)
    {
      AppMethodBeat.i(362584);
      switch (paramInt)
      {
      case 3: 
      default: 
        localf = (com.tencent.mm.view.recyclerview.f)new com.tencent.mm.plugin.finder.convert.g();
        AppMethodBeat.o(362584);
        return localf;
      case 4: 
        localf = (com.tencent.mm.view.recyclerview.f)new t(this.AXV.AJn, (i)this.AXV, this.AXV.ecb(), -2147483648);
        AppMethodBeat.o(362584);
        return localf;
      }
      com.tencent.mm.view.recyclerview.f localf = (com.tencent.mm.view.recyclerview.f)new q((i)this.AXV, this.AXV.ecb(), -2147483648);
      AppMethodBeat.o(362584);
      return localf;
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/feed/FinderPreviewTimelineUIContract$Presenter$dealMenuClick$1$3", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "onSceneEnd", "", "errType", "", "errCode", "errMsg", "", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "plugin-finder-publish_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class b
    implements com.tencent.mm.am.h
  {
    b(bt parambt, am.b paramb) {}
    
    public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, p paramp)
    {
      AppMethodBeat.i(362588);
      if (((paramp instanceof bt)) && (((bt)paramp).hKN == this.AVi.hKN)) {
        com.tencent.mm.kernel.h.aZW().b(this.AVi.getType(), (com.tencent.mm.am.h)this);
      }
      paramString = am.b.a(paramb);
      if (paramString != null) {
        paramString.dismiss();
      }
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        paramb.AXU.finish();
        AppMethodBeat.o(362588);
        return;
      }
      aa.makeText((Context)paramb.lzt, l.i.finder_profile_del_feed_failed, 0).show();
      AppMethodBeat.o(362588);
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "pos", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class c
    extends u
    implements kotlin.g.a.b<Integer, cc>
  {
    c(am.b paramb)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.feed.am.b
 * JD-Core Version:    0.7.0.1
 */