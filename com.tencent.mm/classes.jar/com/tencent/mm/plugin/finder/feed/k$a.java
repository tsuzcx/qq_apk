package com.tencent.mm.plugin.finder.feed;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.view.MenuItem;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.t;
import com.tencent.mm.f.a.hu;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.finder.b.i;
import com.tencent.mm.plugin.finder.b.j;
import com.tencent.mm.plugin.finder.cgi.ay;
import com.tencent.mm.plugin.finder.convert.am;
import com.tencent.mm.plugin.finder.convert.r;
import com.tencent.mm.plugin.finder.convert.u;
import com.tencent.mm.plugin.finder.convert.v;
import com.tencent.mm.plugin.finder.event.base.c;
import com.tencent.mm.plugin.finder.feed.model.internal.DataBuffer;
import com.tencent.mm.plugin.finder.model.BaseFinderFeed;
import com.tencent.mm.plugin.finder.model.aw;
import com.tencent.mm.plugin.finder.model.bu;
import com.tencent.mm.plugin.finder.report.ak;
import com.tencent.mm.plugin.finder.report.ak.b;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.plugin.finder.viewmodel.component.aj.a;
import com.tencent.mm.plugin.finder.viewmodel.component.s;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.o;
import com.tencent.mm.ui.base.w;
import com.tencent.mm.ui.component.g;
import com.tencent.mm.ui.component.g.a;
import com.tencent.mm.view.RefreshLoadMoreLayout;
import java.util.ArrayList;
import java.util.List;
import kotlin.g.a.a;
import kotlin.g.a.b;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.x;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/feed/FinderFeedDetailUIContract$Presenter;", "Lcom/tencent/mm/plugin/finder/feed/FinderBaseFeedUIContract$Presenter;", "scene", "", "context", "Lcom/tencent/mm/ui/MMActivity;", "safeMode", "", "isSelf", "(ILcom/tencent/mm/ui/MMActivity;ZZ)V", "feedChangeListener", "com/tencent/mm/plugin/finder/feed/FinderFeedDetailUIContract$Presenter$feedChangeListener$1", "Lcom/tencent/mm/plugin/finder/feed/FinderFeedDetailUIContract$Presenter$feedChangeListener$1;", "feedList", "Ljava/util/ArrayList;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "Lkotlin/collections/ArrayList;", "()Z", "getSafeMode", "getScene", "()I", "tipDialog", "Landroid/app/Dialog;", "getTipDialog", "()Landroid/app/Dialog;", "setTipDialog", "(Landroid/app/Dialog;)V", "buildItemCoverts", "Lcom/tencent/mm/view/recyclerview/ItemConvertFactory;", "createSecondMenu", "", "feed", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "menu", "Lcom/tencent/mm/ui/base/MMMenu;", "sheet", "Lcom/tencent/mm/ui/widget/dialog/MMBottomSheet;", "dealMenuClick", "menuItem", "Landroid/view/MenuItem;", "index", "from", "holder", "Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;", "getDataAt", "getDataIndex", "getFeed", "getFeedList", "getVideoData", "Lcom/tencent/mm/plugin/finder/feed/model/internal/DataBuffer;", "initViewCallback", "isFinderSelfScene", "loadMoreData", "onAttach", "callback", "Lcom/tencent/mm/plugin/finder/feed/FinderBaseFeedUIContract$ViewCallback;", "onDetach", "removeDataAt", "requestRefresh", "updateFeed", "plugin-finder_release"})
public class k$a
  extends b.a
{
  private final boolean fCB;
  public ArrayList<bu> feedList;
  final boolean safeMode;
  private final int scene;
  Dialog tipDialog;
  private final e xxW;
  
  private k$a(int paramInt, MMActivity paramMMActivity, boolean paramBoolean1, boolean paramBoolean2)
  {
    super(paramMMActivity);
    AppMethodBeat.i(285948);
    this.scene = paramInt;
    this.safeMode = paramBoolean1;
    this.fCB = paramBoolean2;
    this.feedList = new ArrayList();
    this.xxW = new e(this);
    AppMethodBeat.o(285948);
  }
  
  public final bu Mv(int paramInt)
  {
    AppMethodBeat.i(285945);
    bu localbu = dtc();
    AppMethodBeat.o(285945);
    return localbu;
  }
  
  public final void a(b.b paramb)
  {
    AppMethodBeat.i(165714);
    p.k(paramb, "callback");
    super.a(paramb);
    this.xxW.alive();
    g localg = g.Xox;
    ((s)g.b((AppCompatActivity)this.iXq).i(s.class)).u(paramb.xvJ.getRecyclerView());
    AppMethodBeat.o(165714);
  }
  
  public final void a(final BaseFinderFeed paramBaseFinderFeed, MenuItem paramMenuItem, int paramInt1, int paramInt2, com.tencent.mm.view.recyclerview.i parami)
  {
    AppMethodBeat.i(285947);
    p.k(paramBaseFinderFeed, "feed");
    p.k(paramMenuItem, "menuItem");
    p.k(parami, "holder");
    super.a(paramBaseFinderFeed, paramMenuItem, paramInt1, paramInt2, parami);
    if (paramMenuItem.getItemId() == this.xvp)
    {
      paramInt1 = b.j.finder_profile_confirm_del;
      com.tencent.mm.ui.base.h.a((Context)this.iXq, paramInt1, 0, (DialogInterface.OnClickListener)new b(this, paramBaseFinderFeed), null);
      AppMethodBeat.o(285947);
      return;
    }
    if (paramMenuItem.getItemId() == dso())
    {
      paramMenuItem = aw.zBj;
      aw.a((Context)this.iXq, paramBaseFinderFeed.feedObject.getId(), 1, (b)new c(this, paramBaseFinderFeed));
      AppMethodBeat.o(285947);
      return;
    }
    if (paramMenuItem.getItemId() == dsn())
    {
      paramMenuItem = aw.zBj;
      aw.a((Context)this.iXq, paramBaseFinderFeed.feedObject.getId(), 0, (b)new d(this, paramBaseFinderFeed));
    }
    AppMethodBeat.o(285947);
  }
  
  public final void a(BaseFinderFeed paramBaseFinderFeed, o paramo, com.tencent.mm.ui.widget.a.e parame)
  {
    AppMethodBeat.i(285946);
    p.k(paramBaseFinderFeed, "feed");
    p.k(paramo, "menu");
    p.k(parame, "sheet");
    if (this.iXq.getIntent().getBooleanExtra("force_show_ad_tip", false))
    {
      if (paramBaseFinderFeed.feedObject.getMentionListSelected() == 2) {
        paramo.aW(dso(), b.j.finder_mention_not_show_tip, b.i.icons_outlined_display_off);
      }
    }
    else
    {
      super.a(paramBaseFinderFeed, paramo, parame);
      if (this.fCB)
      {
        paramo.aW(this.xvp, b.j.app_delete, b.i.icons_outlined_delete);
        if (!paramBaseFinderFeed.feedObject.isCommentClose()) {
          break label199;
        }
        paramo.b(this.xvo, (CharSequence)this.iXq.getString(b.j.finder_feed_open_comment), b.i.icons_outlined_comment);
      }
    }
    for (;;)
    {
      Log.i(getTAG(), "createSecond MenumentionListSelected : " + paramBaseFinderFeed.feedObject.getMentionListSelected());
      AppMethodBeat.o(285946);
      return;
      if (paramBaseFinderFeed.feedObject.getMentionListSelected() != 3) {
        break;
      }
      paramo.aW(dsn(), b.j.finder_mention_show_tip, b.i.icons_outlined_display_on);
      break;
      label199:
      paramo.b(this.xvn, (CharSequence)this.iXq.getString(b.j.finder_feed_close_comment), b.i.finder_feed_discomment);
    }
  }
  
  public final void byN() {}
  
  public final boolean dsp()
  {
    return this.fCB;
  }
  
  public final void dsr()
  {
    AppMethodBeat.i(165708);
    b.b localb = this.xvC;
    if (localb != null)
    {
      localb.ab(this.feedList);
      AppMethodBeat.o(165708);
      return;
    }
    AppMethodBeat.o(165708);
  }
  
  public final DataBuffer<bu> dss()
  {
    AppMethodBeat.i(285944);
    Object localObject = dtc();
    if (localObject != null)
    {
      localObject = new DataBuffer(localObject, null, 2, null);
      AppMethodBeat.o(285944);
      return localObject;
    }
    localObject = new DataBuffer(null, 1, null);
    AppMethodBeat.o(285944);
    return localObject;
  }
  
  public com.tencent.mm.view.recyclerview.f dsu()
  {
    AppMethodBeat.i(165713);
    com.tencent.mm.view.recyclerview.f localf = (com.tencent.mm.view.recyclerview.f)new a(this);
    AppMethodBeat.o(165713);
    return localf;
  }
  
  public final ArrayList<bu> dta()
  {
    return this.feedList;
  }
  
  public final bu dtc()
  {
    AppMethodBeat.i(285942);
    if (Util.isNullOrNil((List)this.feedList))
    {
      AppMethodBeat.o(285942);
      return null;
    }
    bu localbu = (bu)this.feedList.get(0);
    AppMethodBeat.o(285942);
    return localbu;
  }
  
  public final int m(BaseFinderFeed paramBaseFinderFeed)
  {
    AppMethodBeat.i(165710);
    p.k(paramBaseFinderFeed, "feed");
    long l = paramBaseFinderFeed.mf();
    paramBaseFinderFeed = dtc();
    if ((paramBaseFinderFeed != null) && (l == paramBaseFinderFeed.mf()))
    {
      AppMethodBeat.o(165710);
      return 0;
    }
    AppMethodBeat.o(165710);
    return -1;
  }
  
  public void onDetach()
  {
    AppMethodBeat.i(165716);
    super.onDetach();
    this.xxW.dead();
    AppMethodBeat.o(165716);
  }
  
  public final void requestRefresh() {}
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/finder/feed/FinderFeedDetailUIContract$Presenter$buildItemCoverts$1", "Lcom/tencent/mm/view/recyclerview/ItemConvertFactory;", "getItemConvert", "Lcom/tencent/mm/view/recyclerview/ItemConvert;", "type", "", "plugin-finder_release"})
  public static final class a
    implements com.tencent.mm.view.recyclerview.f
  {
    public final com.tencent.mm.view.recyclerview.e<?> yx(int paramInt)
    {
      AppMethodBeat.i(165706);
      switch (paramInt)
      {
      default: 
        localObject = com.tencent.mm.plugin.finder.utils.aj.AGc;
        com.tencent.mm.plugin.finder.utils.aj.em(this.xxX.getTAG(), paramInt);
        localObject = (com.tencent.mm.view.recyclerview.e)new com.tencent.mm.plugin.finder.convert.f();
        AppMethodBeat.o(165706);
        return localObject;
      case 4: 
      case 3002: 
        localObject = com.tencent.mm.plugin.finder.utils.aj.AGc;
        if (com.tencent.mm.plugin.finder.utils.aj.isOtherEnableFullScreenEnjoy())
        {
          localObject = (com.tencent.mm.view.recyclerview.e)new u(this.xxX.xkW, (i)this.xxX, this.xxX.safeMode, 0, 8);
          AppMethodBeat.o(165706);
          return localObject;
        }
        localObject = (com.tencent.mm.view.recyclerview.e)new am(this.xxX.xkW, (i)this.xxX, this.xxX.safeMode, 0, 8);
        AppMethodBeat.o(165706);
        return localObject;
      }
      Object localObject = com.tencent.mm.plugin.finder.utils.aj.AGc;
      if (com.tencent.mm.plugin.finder.utils.aj.isOtherEnableFullScreenEnjoy())
      {
        localObject = (com.tencent.mm.view.recyclerview.e)new r((i)this.xxX, this.xxX.safeMode, 0, 4);
        AppMethodBeat.o(165706);
        return localObject;
      }
      localObject = (com.tencent.mm.view.recyclerview.e)new v((i)this.xxX, this.xxX.safeMode, 0, 4);
      AppMethodBeat.o(165706);
      return localObject;
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "dialog", "Landroid/content/DialogInterface;", "kotlin.jvm.PlatformType", "which", "", "onClick"})
  static final class b
    implements DialogInterface.OnClickListener
  {
    b(k.a parama, BaseFinderFeed paramBaseFinderFeed) {}
    
    public final void onClick(final DialogInterface paramDialogInterface, int paramInt)
    {
      AppMethodBeat.i(268829);
      paramDialogInterface = z.bdh();
      p.j(paramDialogInterface, "ConfigStorageLogic.getMyFinderUsername()");
      paramDialogInterface = new ay(paramDialogInterface, paramBaseFinderFeed.feedObject.getFeedObject());
      Object localObject = this.xxX.tipDialog;
      if (localObject != null) {
        ((Dialog)localObject).show();
      }
      for (;;)
      {
        com.tencent.mm.kernel.h.aGY().a(paramDialogInterface.getType(), (com.tencent.mm.an.i)new com.tencent.mm.an.i()
        {
          public final void onSceneEnd(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, com.tencent.mm.an.q paramAnonymousq)
          {
            AppMethodBeat.i(285849);
            if (((paramAnonymousq instanceof ay)) && (((ay)paramAnonymousq).xbk == paramDialogInterface.xbk)) {
              com.tencent.mm.kernel.h.aGY().b(paramDialogInterface.getType(), (com.tencent.mm.an.i)this);
            }
            paramAnonymousString = this.xxZ.xxX.tipDialog;
            if (paramAnonymousString != null) {
              paramAnonymousString.dismiss();
            }
            if ((paramAnonymousInt1 == 0) && (paramAnonymousInt2 == 0))
            {
              this.xxZ.xxX.iXq.finish();
              AppMethodBeat.o(285849);
              return;
            }
            w.makeText((Context)this.xxZ.xxX.iXq, b.j.finder_profile_del_feed_failed, 0).show();
            AppMethodBeat.o(285849);
          }
        });
        com.tencent.mm.kernel.h.aGY().b((com.tencent.mm.an.q)paramDialogInterface);
        AppMethodBeat.o(268829);
        return;
        localObject = this.xxX;
        Context localContext = (Context)((b.a)localObject).iXq;
        ((b.a)localObject).iXq.getString(b.j.app_tip);
        ((k.a)localObject).tipDialog = ((Dialog)com.tencent.mm.ui.base.h.a(localContext, ((b.a)localObject).iXq.getString(b.j.app_waiting), false, (DialogInterface.OnCancelListener)a.xxY));
      }
    }
    
    @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/content/DialogInterface;", "kotlin.jvm.PlatformType", "onCancel"})
    static final class a
      implements DialogInterface.OnCancelListener
    {
      public static final a xxY;
      
      static
      {
        AppMethodBeat.i(251510);
        xxY = new a();
        AppMethodBeat.o(251510);
      }
      
      public final void onCancel(DialogInterface paramDialogInterface) {}
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "result", "", "invoke"})
  static final class c
    extends kotlin.g.b.q
    implements b<Boolean, x>
  {
    c(k.a parama, BaseFinderFeed paramBaseFinderFeed)
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "result", "", "invoke"})
  static final class d
    extends kotlin.g.b.q
    implements b<Boolean, x>
  {
    d(k.a parama, BaseFinderFeed paramBaseFinderFeed)
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/finder/feed/FinderFeedDetailUIContract$Presenter$feedChangeListener$1", "Lcom/tencent/mm/sdk/event/IListener;", "Lcom/tencent/mm/autogen/events/FeedUpdateEvent;", "callback", "", "event", "plugin-finder_release"})
  public static final class e
    extends IListener<hu>
  {
    @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
    static final class a
      extends kotlin.g.b.q
      implements a<x>
    {
      a(k.a.e parame, hu paramhu)
      {
        super();
      }
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "run"})
  public static final class f
    implements Runnable
  {
    public f(k.a parama) {}
    
    public final void run()
    {
      AppMethodBeat.i(165707);
      Object localObject = com.tencent.mm.plugin.finder.viewmodel.component.aj.Bnu;
      localObject = aj.a.fZ((Context)this.xxX.iXq);
      if (localObject != null)
      {
        localObject = com.tencent.mm.plugin.finder.viewmodel.component.aj.a((com.tencent.mm.plugin.finder.viewmodel.component.aj)localObject);
        if (localObject != null)
        {
          new ak((c)localObject).dQz().PO(0);
          AppMethodBeat.o(165707);
          return;
        }
      }
      AppMethodBeat.o(165707);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.feed.k.a
 * JD-Core Version:    0.7.0.1
 */