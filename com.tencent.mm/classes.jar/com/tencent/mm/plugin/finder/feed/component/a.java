package com.tencent.mm.plugin.finder.feed.component;

import android.content.Context;
import android.content.res.Resources;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.i;
import com.tencent.mm.an.q;
import com.tencent.mm.f.a.f;
import com.tencent.mm.f.a.ht;
import com.tencent.mm.f.a.hu;
import com.tencent.mm.model.cm;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.finder.b.c;
import com.tencent.mm.plugin.finder.b.i;
import com.tencent.mm.plugin.finder.b.j;
import com.tencent.mm.plugin.finder.cgi.bz;
import com.tencent.mm.plugin.finder.feed.model.BaseFinderFeedLoader;
import com.tencent.mm.plugin.finder.model.BaseFinderFeed;
import com.tencent.mm.plugin.finder.model.bu;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.plugin.finder.storage.data.e.a;
import com.tencent.mm.plugin.finder.viewmodel.component.aj;
import com.tencent.mm.plugin.finder.viewmodel.component.aj.a;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.protocal.protobuf.FinderObjectDesc;
import com.tencent.mm.protocal.protobuf.bfv;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IEvent;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.base.o;
import com.tencent.mm.ui.base.q.f;
import com.tencent.mm.ui.base.q.g;
import com.tencent.mm.ui.base.w;
import com.tencent.mm.ui.base.w.b;
import com.tencent.mm.ui.widget.a.e.b;
import com.tencent.mm.ui.widget.imageview.WeImageView;
import java.util.Iterator;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/feed/component/ActivityFeedHandler;", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "()V", "closeActivitySheet", "Lcom/tencent/mm/ui/widget/dialog/MMBottomSheet;", "context", "Landroid/content/Context;", "feedLoader", "Lcom/tencent/mm/plugin/finder/feed/model/BaseFinderFeedLoader;", "getFeedLoader", "()Lcom/tencent/mm/plugin/finder/feed/model/BaseFinderFeedLoader;", "setFeedLoader", "(Lcom/tencent/mm/plugin/finder/feed/model/BaseFinderFeedLoader;)V", "maxTopCount", "", "getMaxTopCount", "()I", "setMaxTopCount", "(I)V", "addTopPlaceMenu", "", "feed", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "menu", "Lcom/tencent/mm/ui/base/MMMenu;", "handleTopPlace", "isSticky", "", "objectId", "", "makeFeedSticky", "sticky", "onAttach", "onDetach", "onSceneEnd", "errType", "errCode", "errMsg", "", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "removeFeed", "showRemoveFeedDialog", "Companion", "plugin-finder_release"})
public final class a
  implements i
{
  public static final a xFa;
  private Context context;
  public com.tencent.mm.ui.widget.a.e wXa;
  public int xEZ;
  public BaseFinderFeedLoader xnX;
  
  static
  {
    AppMethodBeat.i(270108);
    xFa = new a((byte)0);
    AppMethodBeat.o(270108);
  }
  
  public static void a(Context paramContext, BaseFinderFeed paramBaseFinderFeed, o paramo)
  {
    AppMethodBeat.i(270102);
    p.k(paramContext, "context");
    p.k(paramBaseFinderFeed, "feed");
    p.k(paramo, "menu");
    if (paramBaseFinderFeed.feedObject.getStickyTime() > 0) {}
    for (int i = 1; i != 0; i = 0)
    {
      paramo.b(5003, (CharSequence)paramContext.getString(b.j.finder_cancel_sticky), b.i.icons_outlined_top_off);
      AppMethodBeat.o(270102);
      return;
    }
    paramo.b(5002, (CharSequence)paramContext.getString(b.j.finder_set_sticky), b.i.icons_outlined_top);
    AppMethodBeat.o(270102);
  }
  
  public final void a(Context paramContext, boolean paramBoolean, BaseFinderFeed paramBaseFinderFeed)
  {
    AppMethodBeat.i(270103);
    p.k(paramContext, "context");
    p.k(paramBaseFinderFeed, "feed");
    this.context = paramContext;
    String str = z.bdh();
    long l2 = paramBaseFinderFeed.feedObject.getId();
    paramBaseFinderFeed = paramBaseFinderFeed.feedObject.getFeedObject().objectDesc;
    long l1;
    int i;
    if (paramBaseFinderFeed != null)
    {
      paramBaseFinderFeed = paramBaseFinderFeed.event;
      if (paramBaseFinderFeed != null)
      {
        l1 = paramBaseFinderFeed.xdR;
        if (!paramBoolean) {
          break label156;
        }
        i = 3;
        label73:
        paramBaseFinderFeed = aj.Bnu;
        paramBaseFinderFeed = aj.a.fZ(paramContext);
        if (paramBaseFinderFeed == null) {
          break label162;
        }
      }
    }
    label156:
    label162:
    for (paramBaseFinderFeed = paramBaseFinderFeed.ekY();; paramBaseFinderFeed = null)
    {
      paramBaseFinderFeed = new bz(i, Long.valueOf(l1), str, Long.valueOf(l2), paramBaseFinderFeed);
      paramBaseFinderFeed.f(paramContext, paramContext.getResources().getString(b.j.finder_waiting), 500L);
      com.tencent.mm.kernel.h.aGY().b((q)paramBaseFinderFeed);
      AppMethodBeat.o(270103);
      return;
      l1 = 0L;
      break;
      i = 4;
      break label73;
    }
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, q paramq)
  {
    AppMethodBeat.i(270105);
    switch (paramInt2)
    {
    default: 
      paramString = "";
    }
    for (;;)
    {
      if (!Util.isNullOrNil(paramString)) {
        w.a(MMApplicationContext.getContext(), paramString, (w.b)d.xFd);
      }
      AppMethodBeat.o(270105);
      return;
      paramString = MMApplicationContext.getContext().getString(b.j.finder_sticky_feed_failed_beyond_limit_reason, new Object[] { Integer.valueOf(this.xEZ) });
      p.j(paramString, "MMApplicationContext.get…imit_reason, maxTopCount)");
      continue;
      paramString = MMApplicationContext.getContext().getString(b.j.finder_sticky_feed_failed_private_reason);
      p.j(paramString, "MMApplicationContext.get…ed_failed_private_reason)");
      continue;
      paramString = MMApplicationContext.getContext().getString(b.j.finder_sticky_feed_failed_reason1);
      p.j(paramString, "MMApplicationContext.get…icky_feed_failed_reason1)");
      continue;
      if ((!(paramq instanceof bz)) || ((((bz)paramq).scene != 3) && (((bz)paramq).scene != 4))) {
        break;
      }
      long l;
      if (((bz)paramq).scene == 3)
      {
        paramInt1 = 1;
        paramString = ((bz)paramq).xdt;
        if (paramString == null) {
          break label327;
        }
        l = paramString.longValue();
        label218:
        if (paramInt1 == 0) {
          break label333;
        }
      }
      bu localbu;
      label327:
      label333:
      for (paramInt2 = cm.bfF();; paramInt2 = 0)
      {
        paramString = com.tencent.mm.plugin.finder.storage.data.e.AmW;
        paramString = e.a.MH(l);
        if (paramString != null) {
          paramString.setStickyTime(paramInt2);
        }
        paramString = this.xnX;
        if (paramString == null) {
          break label417;
        }
        paramString = paramString.getDataListJustForAdapter();
        if (paramString == null) {
          break label417;
        }
        paramq = ((Iterable)paramString).iterator();
        if (!paramq.hasNext()) {
          break label398;
        }
        paramString = paramq.next();
        localbu = (bu)paramString;
        if (localbu != null) {
          break label338;
        }
        paramString = new kotlin.t("null cannot be cast to non-null type com.tencent.mm.plugin.finder.model.BaseFinderFeed");
        AppMethodBeat.o(270105);
        throw paramString;
        paramInt1 = 0;
        break;
        l = 0L;
        break label218;
      }
      label338:
      int i;
      if (((BaseFinderFeed)localbu).mf() == l)
      {
        i = 1;
        label355:
        if (i == 0) {
          break label396;
        }
      }
      for (;;)
      {
        paramString = (bu)paramString;
        if (paramString == null) {
          break label417;
        }
        if (paramString != null) {
          break label403;
        }
        paramString = new kotlin.t("null cannot be cast to non-null type com.tencent.mm.plugin.finder.model.BaseFinderFeed");
        AppMethodBeat.o(270105);
        throw paramString;
        i = 0;
        break label355;
        label396:
        break;
        label398:
        paramString = null;
      }
      label403:
      ((BaseFinderFeed)paramString).feedObject.getFinderObject().stickyTime = paramInt2;
      label417:
      paramString = new ht();
      paramString.fEK.type = 1001;
      paramString.fEK.id = l;
      paramString.fEK.stickyTime = paramInt2;
      EventCenter.instance.publish((IEvent)paramString);
      paramString = this.context;
      if (paramString == null) {
        break;
      }
      if (paramInt1 != 0)
      {
        w.a(paramString, paramString.getString(b.j.finder_sticky_feed_succ), (w.b)b.xFb);
        paramString = "";
      }
      else
      {
        w.a(paramString, paramString.getString(b.j.finder_cancel_sticky_feed_succ), (w.b)c.xFc);
        paramString = "";
      }
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/feed/component/ActivityFeedHandler$Companion;", "", "()V", "ACTIVITY_STICK_EVENT_TYPE", "", "MENU_ID_REMOVE_FEED", "TAG", "", "plugin-finder_release"})
  public static final class a {}
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onViewCustomize"})
  static final class b
    implements w.b
  {
    public static final b xFb;
    
    static
    {
      AppMethodBeat.i(288677);
      xFb = new b();
      AppMethodBeat.o(288677);
    }
    
    public final void eu(View paramView)
    {
      AppMethodBeat.i(288676);
      ((WeImageView)paramView.findViewById(com.tencent.mm.ah.a.g.toast_img)).setImageResource(b.i.icons_filled_done);
      AppMethodBeat.o(288676);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onViewCustomize"})
  static final class c
    implements w.b
  {
    public static final c xFc;
    
    static
    {
      AppMethodBeat.i(273203);
      xFc = new c();
      AppMethodBeat.o(273203);
    }
    
    public final void eu(View paramView)
    {
      AppMethodBeat.i(273202);
      ((WeImageView)paramView.findViewById(com.tencent.mm.ah.a.g.toast_img)).setImageResource(b.i.icons_filled_done);
      AppMethodBeat.o(273202);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onViewCustomize"})
  static final class d
    implements w.b
  {
    public static final d xFd;
    
    static
    {
      AppMethodBeat.i(253129);
      xFd = new d();
      AppMethodBeat.o(253129);
    }
    
    public final void eu(View paramView)
    {
      AppMethodBeat.i(253128);
      ((WeImageView)paramView.findViewById(com.tencent.mm.ah.a.g.toast_img)).setImageResource(b.i.icons_filled_top_off);
      AppMethodBeat.o(253128);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/finder/feed/component/ActivityFeedHandler$removeFeed$1", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "onSceneEnd", "", "errType", "", "errCode", "errMsg", "", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "plugin-finder_release"})
  public static final class e
    implements i
  {
    e(bz parambz, BaseFinderFeed paramBaseFinderFeed, long paramLong, Context paramContext) {}
    
    public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, q paramq)
    {
      AppMethodBeat.i(275132);
      if ((paramq instanceof bz))
      {
        com.tencent.mm.kernel.h.aGY().b(this.xFe.getType(), (i)this);
        if ((paramInt1 == 0) && (paramInt2 == 0))
        {
          paramString = new f();
          paramString.fuu.id = this.xno.feedObject.getId();
          paramString.fuu.localId = this.xno.feedObject.getLocalId();
          paramString.fuu.fuv = this.xFf;
          EventCenter.instance.publish((IEvent)paramString);
          paramq = new hu();
          paramq.fEL.id = this.xno.feedObject.getId();
          paramq.fEL.fEN = 1;
          paramq.fEL.type = 12;
          EventCenter.instance.publish((IEvent)paramq);
          "NetSceneFinderModEvent onSceneEnd publish ActivityFeedRemoveEvent:".concat(String.valueOf(paramString));
          com.tencent.d.f.h.ioq();
          AppMethodBeat.o(275132);
          return;
        }
        w.makeText(this.$context, b.j.finder_activity_remove_feed_failed_hint, 0).show();
      }
      AppMethodBeat.o(275132);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "menu", "Lcom/tencent/mm/ui/base/MMMenu;", "kotlin.jvm.PlatformType", "onCreateMMMenu", "com/tencent/mm/plugin/finder/feed/component/ActivityFeedHandler$showRemoveFeedDialog$1$1"})
  public static final class f
    implements q.f
  {
    public f(a parama, Context paramContext, BaseFinderFeed paramBaseFinderFeed) {}
    
    public final void onCreateMMMenu(o paramo)
    {
      AppMethodBeat.i(279891);
      p.j(paramo, "menu");
      if (paramo.hJO()) {
        paramo.a(2000, this.$context$inlined.getResources().getColor(b.c.Red), (CharSequence)this.$context$inlined.getResources().getString(b.j.finder_activity_remove_feed_text));
      }
      AppMethodBeat.o(279891);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "menuItem", "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", "index", "", "onMMMenuItemSelected", "com/tencent/mm/plugin/finder/feed/component/ActivityFeedHandler$showRemoveFeedDialog$1$2"})
  public static final class g
    implements q.g
  {
    public g(a parama, Context paramContext, BaseFinderFeed paramBaseFinderFeed) {}
    
    public final void onMMMenuItemSelected(MenuItem paramMenuItem, int paramInt)
    {
      AppMethodBeat.i(275082);
      p.j(paramMenuItem, "menuItem");
      switch (paramMenuItem.getItemId())
      {
      }
      for (;;)
      {
        AppMethodBeat.o(275082);
        return;
        a.a(this.$context$inlined, this.$feed$inlined);
      }
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "onDismiss", "com/tencent/mm/plugin/finder/feed/component/ActivityFeedHandler$showRemoveFeedDialog$1$3"})
  public static final class h
    implements e.b
  {
    public h(a parama, Context paramContext, BaseFinderFeed paramBaseFinderFeed) {}
    
    public final void onDismiss()
    {
      AppMethodBeat.i(287601);
      a.a(this.xFg);
      AppMethodBeat.o(287601);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.feed.component.a
 * JD-Core Version:    0.7.0.1
 */