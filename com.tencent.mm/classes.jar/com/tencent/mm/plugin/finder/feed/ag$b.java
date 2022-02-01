package com.tencent.mm.plugin.finder.feed;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.view.MenuItem;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.t;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.finder.b.i;
import com.tencent.mm.plugin.finder.b.j;
import com.tencent.mm.plugin.finder.cgi.ay;
import com.tencent.mm.plugin.finder.convert.am;
import com.tencent.mm.plugin.finder.convert.r;
import com.tencent.mm.plugin.finder.convert.u;
import com.tencent.mm.plugin.finder.convert.v;
import com.tencent.mm.plugin.finder.event.base.d;
import com.tencent.mm.plugin.finder.feed.model.BaseFinderFeedLoader;
import com.tencent.mm.plugin.finder.feed.ui.FinderPostPreviewUI;
import com.tencent.mm.plugin.finder.model.BaseFinderFeed;
import com.tencent.mm.plugin.finder.model.bu;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.plugin.finder.viewmodel.component.aj.a;
import com.tencent.mm.protocal.protobuf.bid;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.o;
import com.tencent.mm.ui.base.q.f;
import com.tencent.mm.ui.base.w;
import com.tencent.mm.ui.component.g;
import com.tencent.mm.ui.component.g.a;
import kotlin.g.a.b;
import kotlin.g.b.p;

@kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/feed/FinderPreviewTimelineUIContract$Presenter;", "Lcom/tencent/mm/plugin/finder/feed/FinderLoaderFeedUIContract$Presenter;", "activity", "Lcom/tencent/mm/plugin/finder/feed/ui/FinderPostPreviewUI;", "isSelfFlag", "", "username", "", "requestAtScene", "", "fromScene", "contextObj", "Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "(Lcom/tencent/mm/plugin/finder/feed/ui/FinderPostPreviewUI;ZLjava/lang/String;IILcom/tencent/mm/protocal/protobuf/FinderReportContextObj;)V", "getActivity", "()Lcom/tencent/mm/plugin/finder/feed/ui/FinderPostPreviewUI;", "commentPreloader", "Lcom/tencent/mm/plugin/finder/feed/model/FinderCommentPreloader;", "getCommentPreloader", "()Lcom/tencent/mm/plugin/finder/feed/model/FinderCommentPreloader;", "getContextObj", "()Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "getFromScene", "()I", "()Z", "getRequestAtScene", "tipDialog", "Landroid/app/Dialog;", "getUsername", "()Ljava/lang/String;", "buildItemCoverts", "Lcom/tencent/mm/view/recyclerview/ItemConvertFactory;", "dealMenuClick", "", "feed", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "menuItem", "Landroid/view/MenuItem;", "index", "from", "holder", "Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;", "getCreateSecondMoreMenuListener", "Lcom/tencent/mm/ui/base/MMMenuListener$OnCreateMMMenuListener;", "sheet", "Lcom/tencent/mm/ui/widget/dialog/MMBottomSheet;", "loadMoreData", "onAttach", "model", "Lcom/tencent/mm/plugin/finder/feed/model/BaseFinderFeedLoader;", "callback", "Lcom/tencent/mm/plugin/finder/feed/FinderLoaderFeedUIContract$ViewCallback;", "onDetach", "requestRefresh", "plugin-finder_release"})
public final class ag$b
  extends aa.a
{
  private final int fromScene;
  private Dialog tipDialog;
  private final String username;
  final FinderPostPreviewUI xAi;
  private final bid xbu;
  private final boolean xnY;
  private final com.tencent.mm.plugin.finder.feed.model.i xve;
  private final int xvg;
  
  public ag$b(FinderPostPreviewUI paramFinderPostPreviewUI, boolean paramBoolean, String paramString, int paramInt1, int paramInt2, bid parambid)
  {
    super((MMActivity)paramFinderPostPreviewUI);
    AppMethodBeat.i(278349);
    this.xAi = paramFinderPostPreviewUI;
    this.xnY = paramBoolean;
    this.username = paramString;
    this.xvg = paramInt1;
    this.fromScene = paramInt2;
    this.xbu = parambid;
    this.fEH = -2147483648;
    paramFinderPostPreviewUI = g.Xox;
    this.xve = ((com.tencent.mm.plugin.finder.viewmodel.component.l)g.b((AppCompatActivity)this.iXq).i(com.tencent.mm.plugin.finder.viewmodel.component.l.class)).xve;
    AppMethodBeat.o(278349);
  }
  
  public final q.f a(final BaseFinderFeed paramBaseFinderFeed, com.tencent.mm.ui.widget.a.e parame)
  {
    AppMethodBeat.i(278345);
    p.k(paramBaseFinderFeed, "feed");
    p.k(parame, "sheet");
    paramBaseFinderFeed = (q.f)new c(this, paramBaseFinderFeed);
    AppMethodBeat.o(278345);
    return paramBaseFinderFeed;
  }
  
  public final void a(BaseFinderFeedLoader paramBaseFinderFeedLoader, aa.b paramb)
  {
    AppMethodBeat.i(278343);
    p.k(paramBaseFinderFeedLoader, "model");
    p.k(paramb, "callback");
    super.a(paramBaseFinderFeedLoader, paramb);
    this.xve.a(this.xvg, this.xkX, (b)new d(this));
    paramBaseFinderFeedLoader = com.tencent.mm.plugin.finder.viewmodel.component.aj.Bnu;
    paramBaseFinderFeedLoader = aj.a.fZ((Context)this.iXq);
    if (paramBaseFinderFeedLoader != null)
    {
      paramBaseFinderFeedLoader = com.tencent.mm.plugin.finder.viewmodel.component.aj.a(paramBaseFinderFeedLoader);
      if (paramBaseFinderFeedLoader != null)
      {
        paramBaseFinderFeedLoader.a((d)this.xve);
        AppMethodBeat.o(278343);
        return;
      }
    }
    AppMethodBeat.o(278343);
  }
  
  public final void a(final BaseFinderFeed paramBaseFinderFeed, MenuItem paramMenuItem, int paramInt1, int paramInt2, com.tencent.mm.view.recyclerview.i parami)
  {
    AppMethodBeat.i(278346);
    p.k(paramBaseFinderFeed, "feed");
    p.k(paramMenuItem, "menuItem");
    p.k(parami, "holder");
    super.a(paramBaseFinderFeed, paramMenuItem, paramInt1, paramInt2, parami);
    if ((paramMenuItem.getItemId() == this.xvp) && (paramBaseFinderFeed.feedObject.isPostFinish()))
    {
      paramInt1 = b.j.finder_profile_confirm_del;
      com.tencent.mm.ui.base.h.a((Context)this.iXq, paramInt1, 0, (DialogInterface.OnClickListener)new b(this, paramBaseFinderFeed), null);
    }
    AppMethodBeat.o(278346);
  }
  
  public final void byN()
  {
    AppMethodBeat.i(278341);
    BaseFinderFeedLoader localBaseFinderFeedLoader = this.xnX;
    if (localBaseFinderFeedLoader != null)
    {
      localBaseFinderFeedLoader.requestLoadMore();
      AppMethodBeat.o(278341);
      return;
    }
    AppMethodBeat.o(278341);
  }
  
  public final com.tencent.mm.view.recyclerview.f dsu()
  {
    AppMethodBeat.i(278348);
    com.tencent.mm.view.recyclerview.f localf = (com.tencent.mm.view.recyclerview.f)new a(this);
    AppMethodBeat.o(278348);
    return localf;
  }
  
  public final void onDetach()
  {
    AppMethodBeat.i(278347);
    this.xve.onDetach();
    Object localObject = com.tencent.mm.plugin.finder.viewmodel.component.aj.Bnu;
    localObject = aj.a.fZ((Context)this.iXq);
    if (localObject != null)
    {
      localObject = com.tencent.mm.plugin.finder.viewmodel.component.aj.a((com.tencent.mm.plugin.finder.viewmodel.component.aj)localObject);
      if (localObject != null) {
        ((com.tencent.mm.plugin.finder.event.base.c)localObject).b((d)this.xve);
      }
    }
    super.onDetach();
    AppMethodBeat.o(278347);
  }
  
  public final void requestRefresh()
  {
    AppMethodBeat.i(278340);
    BaseFinderFeedLoader localBaseFinderFeedLoader = this.xnX;
    if (localBaseFinderFeedLoader != null)
    {
      localBaseFinderFeedLoader.requestRefresh();
      AppMethodBeat.o(278340);
      return;
    }
    AppMethodBeat.o(278340);
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/finder/feed/FinderPreviewTimelineUIContract$Presenter$buildItemCoverts$1", "Lcom/tencent/mm/view/recyclerview/ItemConvertFactory;", "getItemConvert", "Lcom/tencent/mm/view/recyclerview/ItemConvert;", "type", "", "plugin-finder_release"})
  public static final class a
    implements com.tencent.mm.view.recyclerview.f
  {
    public final com.tencent.mm.view.recyclerview.e<?> yx(int paramInt)
    {
      AppMethodBeat.i(271622);
      switch (paramInt)
      {
      case 3: 
      default: 
        locale = (com.tencent.mm.view.recyclerview.e)new com.tencent.mm.plugin.finder.convert.f();
        AppMethodBeat.o(271622);
        return locale;
      case 4: 
        if (this.xAj.xAi.xRB)
        {
          locale = (com.tencent.mm.view.recyclerview.e)new u(this.xAj.xkW, (i)this.xAj, this.xAj.dsZ(), -2147483648);
          AppMethodBeat.o(271622);
          return locale;
        }
        locale = (com.tencent.mm.view.recyclerview.e)new am(this.xAj.xkW, (i)this.xAj, this.xAj.dsZ(), 2147483647);
        AppMethodBeat.o(271622);
        return locale;
      }
      if (this.xAj.xAi.xRB)
      {
        locale = (com.tencent.mm.view.recyclerview.e)new r((i)this.xAj, this.xAj.dsZ(), -2147483648);
        AppMethodBeat.o(271622);
        return locale;
      }
      com.tencent.mm.view.recyclerview.e locale = (com.tencent.mm.view.recyclerview.e)new v((i)this.xAj, this.xAj.dsZ(), 2147483647);
      AppMethodBeat.o(271622);
      return locale;
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "dialog", "Landroid/content/DialogInterface;", "kotlin.jvm.PlatformType", "which", "", "onClick"})
  static final class b
    implements DialogInterface.OnClickListener
  {
    b(ag.b paramb, BaseFinderFeed paramBaseFinderFeed) {}
    
    public final void onClick(final DialogInterface paramDialogInterface, int paramInt)
    {
      AppMethodBeat.i(274826);
      paramDialogInterface = z.bdh();
      p.j(paramDialogInterface, "ConfigStorageLogic.getMyFinderUsername()");
      paramDialogInterface = new ay(paramDialogInterface, paramBaseFinderFeed.feedObject.getFeedObject());
      Object localObject = ag.b.a(this.xAj);
      if (localObject != null) {
        ((Dialog)localObject).show();
      }
      for (;;)
      {
        com.tencent.mm.kernel.h.aGY().a(paramDialogInterface.getType(), (com.tencent.mm.an.i)new com.tencent.mm.an.i()
        {
          public final void onSceneEnd(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, com.tencent.mm.an.q paramAnonymousq)
          {
            AppMethodBeat.i(290431);
            if (((paramAnonymousq instanceof ay)) && (((ay)paramAnonymousq).xbk == paramDialogInterface.xbk)) {
              com.tencent.mm.kernel.h.aGY().b(paramDialogInterface.getType(), (com.tencent.mm.an.i)this);
            }
            paramAnonymousString = ag.b.a(this.xAl.xAj);
            if (paramAnonymousString != null) {
              paramAnonymousString.dismiss();
            }
            if ((paramAnonymousInt1 == 0) && (paramAnonymousInt2 == 0))
            {
              this.xAl.xAj.xAi.finish();
              AppMethodBeat.o(290431);
              return;
            }
            w.makeText((Context)this.xAl.xAj.iXq, b.j.finder_profile_del_feed_failed, 0).show();
            AppMethodBeat.o(290431);
          }
        });
        com.tencent.mm.kernel.h.aGY().b((com.tencent.mm.an.q)paramDialogInterface);
        AppMethodBeat.o(274826);
        return;
        localObject = this.xAj;
        Context localContext = (Context)((b.a)localObject).iXq;
        ((b.a)localObject).iXq.getString(b.j.app_tip);
        ag.b.a((ag.b)localObject, (Dialog)com.tencent.mm.ui.base.h.a(localContext, ((b.a)localObject).iXq.getString(b.j.app_waiting), false, (DialogInterface.OnCancelListener)a.xAk));
      }
    }
    
    @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/content/DialogInterface;", "kotlin.jvm.PlatformType", "onCancel"})
    static final class a
      implements DialogInterface.OnCancelListener
    {
      public static final a xAk;
      
      static
      {
        AppMethodBeat.i(278785);
        xAk = new a();
        AppMethodBeat.o(278785);
      }
      
      public final void onCancel(DialogInterface paramDialogInterface) {}
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "menu", "Lcom/tencent/mm/ui/base/MMMenu;", "kotlin.jvm.PlatformType", "onCreateMMMenu"})
  static final class c
    implements q.f
  {
    c(ag.b paramb, BaseFinderFeed paramBaseFinderFeed) {}
    
    public final void onCreateMMMenu(o paramo)
    {
      boolean bool = false;
      AppMethodBeat.i(275756);
      int i;
      if (this.xAj.xAi.xRB)
      {
        localObject = com.tencent.mm.plugin.finder.upload.action.c.ABD;
        if (com.tencent.mm.plugin.finder.upload.action.c.ecy().p(paramBaseFinderFeed.feedObject.getFeedObject())) {
          break label274;
        }
        i = 1;
        if (i == 0) {
          break label279;
        }
        paramo.b(this.xAj.xvr, (CharSequence)this.xAj.iXq.getString(b.j.favorite), b.i.finder_icons_filled_star2);
      }
      for (;;)
      {
        localObject = com.tencent.mm.plugin.finder.utils.aj.AGc;
        if (com.tencent.mm.plugin.finder.utils.aj.D(paramBaseFinderFeed.feedObject))
        {
          i = this.xAj.xvq;
          localObject = com.tencent.mm.plugin.finder.utils.aj.AGc;
          localObject = (CharSequence)com.tencent.mm.plugin.finder.utils.aj.x(paramBaseFinderFeed);
          int j = b.i.icons_outlined_bgm_play;
          if ((!paramBaseFinderFeed.feedObject.isPostFinish()) || (paramBaseFinderFeed.feedObject.isPostFailed())) {
            bool = true;
          }
          paramo.a(i, (CharSequence)localObject, j, bool);
        }
        localObject = com.tencent.mm.plugin.finder.utils.aj.AGc;
        if (com.tencent.mm.plugin.finder.utils.aj.j(paramBaseFinderFeed)) {
          break label313;
        }
        if ((this.xAj.fEH != 3) && (this.xAj.fEH != 1)) {
          paramo.b(this.xAj.xvj, (CharSequence)this.xAj.iXq.getString(b.j.more_menu_unlike), b.i.finder_feed_dislike);
        }
        paramo.b(this.xAj.xvk, (CharSequence)this.xAj.iXq.getString(b.j.more_menu_back), b.i.icons_outlined_report_problem);
        AppMethodBeat.o(275756);
        return;
        label274:
        i = 0;
        break;
        label279:
        paramo.b(this.xAj.xvs, (CharSequence)this.xAj.iXq.getString(b.j.finder_cancel_fav_title), b.i.finder_icons_filled_unstar2);
      }
      label313:
      Object localObject = com.tencent.mm.plugin.finder.utils.aj.AGc;
      if (!com.tencent.mm.plugin.finder.utils.aj.w(paramBaseFinderFeed))
      {
        paramo.aW(this.xAj.xvp, b.j.app_delete, b.i.icons_outlined_delete);
        if (!paramBaseFinderFeed.feedObject.isCommentClose()) {
          break label473;
        }
        paramo.b(this.xAj.xvo, (CharSequence)this.xAj.iXq.getString(b.j.finder_feed_open_comment), b.i.icons_outlined_comment);
      }
      for (;;)
      {
        if (!this.xAj.xAi.xRB)
        {
          localObject = com.tencent.mm.plugin.finder.utils.aj.AGc;
          if ((com.tencent.mm.plugin.finder.utils.aj.isAnyEnableFullScreenEnjoy()) && ((paramBaseFinderFeed.bAQ() == 4) || (paramBaseFinderFeed.bAQ() == 2))) {
            paramo.b(this.xAj.xvt, (CharSequence)this.xAj.iXq.getString(b.j.finder_feed_open_in_full_window), b.i.finder_icons_outlined_max_window);
          }
        }
        AppMethodBeat.o(275756);
        return;
        label473:
        paramo.b(this.xAj.xvn, (CharSequence)this.xAj.iXq.getString(b.j.finder_feed_close_comment), b.i.finder_feed_discomment);
      }
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "pos", "", "invoke"})
  static final class d
    extends kotlin.g.b.q
    implements b<Integer, bu>
  {
    d(ag.b paramb)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.feed.ag.b
 * JD-Core Version:    0.7.0.1
 */