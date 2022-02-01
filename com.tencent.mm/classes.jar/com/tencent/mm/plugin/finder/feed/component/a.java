package com.tencent.mm.plugin.finder.feed.component;

import android.content.Context;
import android.content.res.Resources;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ah.a.g;
import com.tencent.mm.am.p;
import com.tencent.mm.autogen.a.g;
import com.tencent.mm.autogen.a.ie;
import com.tencent.mm.autogen.a.if;
import com.tencent.mm.model.cn;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.finder.cgi.cx;
import com.tencent.mm.plugin.finder.e.b;
import com.tencent.mm.plugin.finder.e.c;
import com.tencent.mm.plugin.finder.e.g;
import com.tencent.mm.plugin.finder.e.h;
import com.tencent.mm.plugin.finder.feed.model.BaseFinderFeedLoader;
import com.tencent.mm.plugin.finder.model.BaseFinderFeed;
import com.tencent.mm.plugin.finder.model.cc;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.plugin.finder.storage.data.e;
import com.tencent.mm.plugin.finder.storage.data.e.a;
import com.tencent.mm.plugin.finder.viewmodel.component.as;
import com.tencent.mm.plugin.finder.viewmodel.component.as.a;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.protocal.protobuf.FinderObjectDesc;
import com.tencent.mm.protocal.protobuf.brg;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.base.aa;
import com.tencent.mm.ui.widget.a.f;
import com.tencent.mm.ui.widget.imageview.WeImageView;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.ah;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/feed/component/ActivityFeedHandler;", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "()V", "closeActivitySheet", "Lcom/tencent/mm/ui/widget/dialog/MMBottomSheet;", "context", "Landroid/content/Context;", "feedLoader", "Lcom/tencent/mm/plugin/finder/feed/model/BaseFinderFeedLoader;", "getFeedLoader", "()Lcom/tencent/mm/plugin/finder/feed/model/BaseFinderFeedLoader;", "setFeedLoader", "(Lcom/tencent/mm/plugin/finder/feed/model/BaseFinderFeedLoader;)V", "maxTopCount", "", "getMaxTopCount", "()I", "setMaxTopCount", "(I)V", "addTopPlaceMenu", "", "feed", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "menu", "Lcom/tencent/mm/ui/base/MMMenu;", "handleTopPlace", "isSticky", "", "objectId", "", "makeFeedSticky", "sticky", "onAttach", "onDetach", "onSceneEnd", "errType", "errCode", "errMsg", "", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "removeFeed", "showRemoveFeedDialog", "Companion", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class a
  implements com.tencent.mm.am.h
{
  public static final a BbU;
  public BaseFinderFeedLoader ALH;
  private f AtU;
  public int BbV;
  private Context context;
  
  static
  {
    AppMethodBeat.i(364115);
    BbU = new a((byte)0);
    AppMethodBeat.o(364115);
  }
  
  public static void a(Context paramContext, BaseFinderFeed paramBaseFinderFeed, com.tencent.mm.ui.base.s params)
  {
    AppMethodBeat.i(364079);
    kotlin.g.b.s.u(paramContext, "context");
    kotlin.g.b.s.u(paramBaseFinderFeed, "feed");
    kotlin.g.b.s.u(params, "menu");
    if (paramBaseFinderFeed.feedObject.getStickyTime() > 0) {}
    for (int i = 1; i != 0; i = 0)
    {
      params.a(5003, (CharSequence)paramContext.getString(e.h.finder_cancel_sticky), e.g.icons_outlined_top_off);
      AppMethodBeat.o(364079);
      return;
    }
    params.a(5002, (CharSequence)paramContext.getString(e.h.finder_set_sticky), e.g.icons_outlined_top);
    AppMethodBeat.o(364079);
  }
  
  private static final void a(Context paramContext, com.tencent.mm.ui.base.s params)
  {
    AppMethodBeat.i(364099);
    kotlin.g.b.s.u(paramContext, "$context");
    if (params.jmw()) {
      params.a(2000, paramContext.getResources().getColor(e.b.Red), (CharSequence)paramContext.getResources().getString(e.h.finder_activity_remove_feed_text));
    }
    AppMethodBeat.o(364099);
  }
  
  private static final void a(a parama)
  {
    AppMethodBeat.i(364112);
    kotlin.g.b.s.u(parama, "this$0");
    parama.AtU = null;
    AppMethodBeat.o(364112);
  }
  
  private static final void a(a parama, Context paramContext, final BaseFinderFeed paramBaseFinderFeed, MenuItem paramMenuItem, int paramInt)
  {
    AppMethodBeat.i(364108);
    kotlin.g.b.s.u(parama, "this$0");
    kotlin.g.b.s.u(paramContext, "$context");
    kotlin.g.b.s.u(paramBaseFinderFeed, "$feed");
    long l2;
    final long l1;
    if (paramMenuItem.getItemId() == 2000)
    {
      paramMenuItem = z.bAW();
      l2 = paramBaseFinderFeed.feedObject.getId();
      parama = paramBaseFinderFeed.feedObject.getFeedObject().objectDesc;
      if (parama != null) {
        break label164;
      }
      l1 = 0L;
      parama = as.GSQ;
      parama = as.a.hu(paramContext);
      if (parama != null) {
        break label188;
      }
    }
    label164:
    label188:
    for (parama = null;; parama = parama.fou())
    {
      parama = new cx(2, Long.valueOf(l1), paramMenuItem, Long.valueOf(l2), parama);
      parama.f(paramContext, paramContext.getResources().getString(e.h.finder_waiting), 500L);
      com.tencent.mm.kernel.h.aZW().a(parama.getType(), (com.tencent.mm.am.h)new b(parama, paramBaseFinderFeed, l1, paramContext));
      com.tencent.mm.kernel.h.aZW().a((p)parama, 0);
      AppMethodBeat.o(364108);
      return;
      parama = parama.event;
      if (parama == null)
      {
        l1 = 0L;
        break;
      }
      l1 = parama.ocD;
      break;
    }
  }
  
  private static final void fD(View paramView)
  {
    AppMethodBeat.i(364084);
    ((WeImageView)paramView.findViewById(a.g.toast_img)).setImageResource(e.g.icons_filled_top_off);
    AppMethodBeat.o(364084);
  }
  
  private static final void fE(View paramView)
  {
    AppMethodBeat.i(364090);
    ((WeImageView)paramView.findViewById(a.g.toast_img)).setImageResource(e.g.icons_filled_done);
    AppMethodBeat.o(364090);
  }
  
  private static final void fF(View paramView)
  {
    AppMethodBeat.i(364092);
    ((WeImageView)paramView.findViewById(a.g.toast_img)).setImageResource(e.g.icons_filled_done);
    AppMethodBeat.o(364092);
  }
  
  public final void a(Context paramContext, BaseFinderFeed paramBaseFinderFeed)
  {
    AppMethodBeat.i(364178);
    kotlin.g.b.s.u(paramContext, "context");
    kotlin.g.b.s.u(paramBaseFinderFeed, "feed");
    if (this.AtU == null)
    {
      f localf = new f(paramContext, 1, true);
      localf.h((CharSequence)paramContext.getResources().getString(e.h.finder_activity_remove_feed_hint), 17, paramContext.getResources().getDimensionPixelSize(e.c.SmallestTextSize));
      localf.Vtg = new a..ExternalSyntheticLambda3(paramContext);
      localf.GAC = new a..ExternalSyntheticLambda4(this, paramContext, paramBaseFinderFeed);
      localf.aeLi = new a..ExternalSyntheticLambda5(this);
      paramContext = ah.aiuX;
      this.AtU = localf;
    }
    paramContext = this.AtU;
    if ((paramContext != null) && (!paramContext.isShowing())) {
      paramContext.dDn();
    }
    AppMethodBeat.o(364178);
  }
  
  public final void a(Context paramContext, boolean paramBoolean, BaseFinderFeed paramBaseFinderFeed)
  {
    AppMethodBeat.i(364155);
    kotlin.g.b.s.u(paramContext, "context");
    kotlin.g.b.s.u(paramBaseFinderFeed, "feed");
    this.context = paramContext;
    String str = z.bAW();
    long l2 = paramBaseFinderFeed.feedObject.getId();
    paramBaseFinderFeed = paramBaseFinderFeed.feedObject.getFeedObject().objectDesc;
    long l1;
    int i;
    if (paramBaseFinderFeed == null)
    {
      l1 = 0L;
      if (!paramBoolean) {
        break label162;
      }
      i = 3;
      label62:
      paramBaseFinderFeed = as.GSQ;
      paramBaseFinderFeed = as.a.hu(paramContext);
      if (paramBaseFinderFeed != null) {
        break label168;
      }
    }
    label162:
    label168:
    for (paramBaseFinderFeed = null;; paramBaseFinderFeed = paramBaseFinderFeed.fou())
    {
      paramBaseFinderFeed = new cx(i, Long.valueOf(l1), str, Long.valueOf(l2), paramBaseFinderFeed);
      paramBaseFinderFeed.f(paramContext, paramContext.getResources().getString(e.h.finder_waiting), 500L);
      com.tencent.mm.kernel.h.aZW().a((p)paramBaseFinderFeed, 0);
      AppMethodBeat.o(364155);
      return;
      paramBaseFinderFeed = paramBaseFinderFeed.event;
      if (paramBaseFinderFeed == null)
      {
        l1 = 0L;
        break;
      }
      l1 = paramBaseFinderFeed.ocD;
      break;
      i = 4;
      break label62;
    }
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, p paramp)
  {
    AppMethodBeat.i(364167);
    switch (paramInt2)
    {
    }
    for (;;)
    {
      paramString = "";
      for (;;)
      {
        label52:
        if (!Util.isNullOrNil(paramString)) {
          aa.a(MMApplicationContext.getContext(), paramString, a..ExternalSyntheticLambda0.INSTANCE);
        }
        AppMethodBeat.o(364167);
        return;
        paramString = MMApplicationContext.getContext().getString(e.h.finder_sticky_feed_failed_beyond_limit_reason, new Object[] { Integer.valueOf(this.BbV) });
        kotlin.g.b.s.s(paramString, "getContext().getString(R…imit_reason, maxTopCount)");
        continue;
        paramString = MMApplicationContext.getContext().getString(e.h.finder_sticky_feed_failed_private_reason);
        kotlin.g.b.s.s(paramString, "getContext().getString(R…ed_failed_private_reason)");
        continue;
        paramString = MMApplicationContext.getContext().getString(e.h.finder_sticky_feed_failed_reason1);
        kotlin.g.b.s.s(paramString, "getContext().getString(R…icky_feed_failed_reason1)");
      }
      if (((paramp instanceof cx)) && ((((cx)paramp).scene == 3) || (((cx)paramp).scene == 4)))
      {
        label196:
        long l;
        label212:
        label220:
        int i;
        if (((cx)paramp).scene == 3)
        {
          paramInt1 = 1;
          paramString = ((cx)paramp).ACP;
          if (paramString != null) {
            break label412;
          }
          l = 0L;
          if (paramInt1 == 0) {
            break label421;
          }
          paramInt2 = cn.getSyncServerTimeSecond();
          paramString = e.FMN;
          paramString = e.a.jn(l);
          if (paramString != null) {
            paramString.setStickyTime(paramInt2);
          }
          paramString = this.ALH;
          if (paramString != null)
          {
            paramString = paramString.getDataListJustForAdapter();
            if (paramString != null)
            {
              paramp = ((Iterable)paramString).iterator();
              label268:
              if (!paramp.hasNext()) {
                break label432;
              }
              paramString = paramp.next();
              if (((BaseFinderFeed)paramString).bZA() != l) {
                break label426;
              }
              i = 1;
              label305:
              if (i == 0) {
                break label430;
              }
            }
          }
        }
        for (;;)
        {
          paramString = (cc)paramString;
          if (paramString != null) {
            ((BaseFinderFeed)paramString).feedObject.getFinderObject().stickyTime = paramInt2;
          }
          paramString = new ie();
          paramString.hJA.type = 1001;
          paramString.hJA.id = l;
          paramString.hJA.stickyTime = paramInt2;
          paramString.publish();
          paramString = this.context;
          if (paramString == null) {
            break;
          }
          if (paramInt1 == 0) {
            break label437;
          }
          aa.a(paramString, paramString.getString(e.h.finder_sticky_feed_succ), a..ExternalSyntheticLambda1.INSTANCE);
          paramString = "";
          break label52;
          paramInt1 = 0;
          break label196;
          label412:
          l = paramString.longValue();
          break label212;
          label421:
          paramInt2 = 0;
          break label220;
          label426:
          i = 0;
          break label305;
          label430:
          break label268;
          label432:
          paramString = null;
        }
        label437:
        aa.a(paramString, paramString.getString(e.h.finder_cancel_sticky_feed_succ), a..ExternalSyntheticLambda2.INSTANCE);
      }
    }
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/feed/component/ActivityFeedHandler$Companion;", "", "()V", "ACTIVITY_STICK_EVENT_TYPE", "", "MENU_ID_REMOVE_FEED", "TAG", "", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a {}
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/feed/component/ActivityFeedHandler$removeFeed$1", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "onSceneEnd", "", "errType", "", "errCode", "errMsg", "", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class b
    implements com.tencent.mm.am.h
  {
    b(cx paramcx, BaseFinderFeed paramBaseFinderFeed, long paramLong, Context paramContext) {}
    
    public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, p paramp)
    {
      AppMethodBeat.i(364013);
      if ((paramp instanceof cx))
      {
        com.tencent.mm.kernel.h.aZW().b(this.BbW.getType(), (com.tencent.mm.am.h)this);
        if ((paramInt1 == 0) && (paramInt2 == 0))
        {
          paramString = new g();
          paramString.hyM.id = paramBaseFinderFeed.feedObject.getId();
          paramString.hyM.localId = paramBaseFinderFeed.feedObject.getLocalId();
          paramString.hyM.hyN = l1;
          paramString.publish();
          paramp = new if();
          BaseFinderFeed localBaseFinderFeed = paramBaseFinderFeed;
          paramp.hJB.id = localBaseFinderFeed.feedObject.getId();
          paramp.hJB.hJD = 1;
          paramp.hJB.type = 12;
          paramp.publish();
          kotlin.g.b.s.X("NetSceneFinderModEvent onSceneEnd publish ActivityFeedRemoveEvent:", paramString);
          com.tencent.e.f.h.jXD();
          AppMethodBeat.o(364013);
          return;
        }
        aa.makeText(this.$context, e.h.finder_activity_remove_feed_failed_hint, 0).show();
      }
      AppMethodBeat.o(364013);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes13.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.feed.component.a
 * JD-Core Version:    0.7.0.1
 */