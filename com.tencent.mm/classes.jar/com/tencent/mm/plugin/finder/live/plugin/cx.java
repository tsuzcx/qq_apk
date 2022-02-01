package com.tencent.mm.plugin.finder.live.plugin;

import android.graphics.Rect;
import android.os.Bundle;
import android.view.ViewGroup;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.animation.AnimationUtils;
import android.widget.RelativeLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.live.c.b.c;
import com.tencent.mm.plugin.finder.b.a;
import com.tencent.mm.plugin.finder.b.f;
import com.tencent.mm.plugin.finder.live.viewmodel.data.business.c;
import com.tencent.mm.plugin.finder.live.viewmodel.data.business.j;
import com.tencent.mm.plugin.finder.live.widget.ao;
import com.tencent.mm.plugin.finder.live.widget.ao.a;
import com.tencent.mm.plugin.finder.live.widget.ao.g;
import com.tencent.mm.plugin.finder.live.widget.ap;
import com.tencent.mm.plugin.finder.live.widget.aq;
import com.tencent.mm.plugin.finder.live.widget.ar;
import com.tencent.mm.plugin.finder.live.widget.as;
import com.tencent.mm.plugin.finder.live.widget.at;
import com.tencent.mm.plugin.finder.view.e;
import com.tencent.mm.protocal.protobuf.axc;
import com.tencent.mm.protocal.protobuf.azh;
import com.tencent.mm.protocal.protobuf.bac;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.ax;
import java.util.Iterator;
import java.util.LinkedHashMap;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.t;
import kotlin.x;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/live/plugin/FinderLiveVisitorBottomOptionPlugin;", "Lcom/tencent/mm/plugin/finder/live/plugin/FinderBaseLivePlugin;", "root", "Landroid/view/ViewGroup;", "statusMonitor", "Lcom/tencent/mm/live/plugin/ILiveStatus;", "(Landroid/view/ViewGroup;Lcom/tencent/mm/live/plugin/ILiveStatus;)V", "TAG", "", "gameTeamWidget", "Lcom/tencent/mm/plugin/finder/live/widget/FinderLiveVisitorGameTeamWidget;", "giftWidget", "Lcom/tencent/mm/plugin/finder/live/widget/FinderLiveVisitorGiftWidget;", "likeWidget", "Lcom/tencent/mm/plugin/finder/live/widget/FinderLiveVisitorLikeWidget;", "linkMicWidget", "Lcom/tencent/mm/plugin/finder/live/widget/FinderLiveVisitorMicEntranceWidget;", "luckyMoneyWidget", "Lcom/tencent/mm/plugin/finder/live/widget/FinderLiveVisitorLuckyMoneyEntranceWidget;", "shoppingWidget", "Lcom/tencent/mm/plugin/finder/live/widget/FinderLiveVisitorShoppingEntranceWidget;", "canClearScreen", "", "checkLinkMicGroupState", "", "checkOptionsVisible", "printLog", "checkRequestLinkMic", "gameEntranceView", "getGameWidgetPlugin", "hideOption", "option", "", "onMicUserChanged", "micUserMap", "Ljava/util/LinkedHashMap;", "Landroid/graphics/Rect;", "Lkotlin/collections/LinkedHashMap;", "isPkAnchor", "refreshLikeCount", "shoppingEntranceView", "showMicBottomSheet", "showOption", "statusChange", "status", "Lcom/tencent/mm/live/plugin/ILiveStatus$LiveStatus;", "param", "Landroid/os/Bundle;", "updateGameTeamUI", "Companion", "plugin-finder_release"})
public final class cx
  extends d
{
  private static final int ylB = 2;
  private static final int ylC = 1;
  private static final int yyR = 0;
  public static final a yyS;
  public final String TAG;
  private final com.tencent.mm.live.c.b kCL;
  public final at yyL;
  public final as yyM;
  public final aq yyN;
  private final ap yyO;
  private final ar yyP;
  public final ao yyQ;
  
  static
  {
    AppMethodBeat.i(269000);
    yyS = new a((byte)0);
    ylC = 1;
    ylB = 2;
    AppMethodBeat.o(269000);
  }
  
  public cx(ViewGroup paramViewGroup, com.tencent.mm.live.c.b paramb)
  {
    super(paramViewGroup, paramb);
    AppMethodBeat.i(268999);
    this.kCL = paramb;
    this.TAG = "Finder.FinderLiveVisitorBottomOptionPlugin";
    paramb = paramViewGroup.findViewById(b.f.shopping_entrance_container);
    p.j(paramb, "root.findViewById(R.id.s…pping_entrance_container)");
    this.yyL = new at((ViewGroup)paramb, this.kCL, (d)this);
    paramb = paramViewGroup.findViewById(b.f.link_entrance_container);
    p.j(paramb, "root.findViewById(R.id.link_entrance_container)");
    this.yyM = new as((ViewGroup)paramb, this.kCL, (d)this);
    paramb = paramViewGroup.findViewById(b.f.like_entrance_container);
    p.j(paramb, "root.findViewById(R.id.like_entrance_container)");
    this.yyN = new aq((ViewGroup)paramb, this.kCL, (d)this);
    paramb = paramViewGroup.findViewById(b.f.gift_entrance_container);
    p.j(paramb, "root.findViewById(R.id.gift_entrance_container)");
    this.yyO = new ap((ViewGroup)paramb, this.kCL, (d)this);
    paramb = paramViewGroup.findViewById(b.f.lucky_money_entrance_container);
    p.j(paramb, "root.findViewById(R.id.l…money_entrance_container)");
    this.yyP = new ar((ViewGroup)paramb, this.kCL, (d)this);
    paramb = paramViewGroup.findViewById(b.f.game_team_entrance_container);
    p.j(paramb, "root.findViewById(R.id.g…_team_entrance_container)");
    this.yyQ = new ao((ViewGroup)paramb, this.kCL, (d)this);
    if (isLandscape())
    {
      paramViewGroup = com.tencent.mm.plugin.finder.live.utils.a.yRm;
      com.tencent.mm.plugin.finder.live.utils.a.a((d)this, false);
      AppMethodBeat.o(268999);
      return;
    }
    paramb = paramViewGroup.getLayoutParams();
    if (paramb == null)
    {
      paramViewGroup = new t("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
      AppMethodBeat.o(268999);
      throw paramViewGroup;
    }
    paramb = (ViewGroup.MarginLayoutParams)paramb;
    paramb.bottomMargin += ax.aB(paramViewGroup.getContext());
    AppMethodBeat.o(268999);
  }
  
  public final void NC(int paramInt)
  {
    AppMethodBeat.i(268995);
    if (paramInt == yyR)
    {
      this.yyN.tU(0);
      AppMethodBeat.o(268995);
      return;
    }
    if (paramInt == ylC)
    {
      this.yyL.tU(0);
      AppMethodBeat.o(268995);
      return;
    }
    if (paramInt == ylB) {
      this.yyM.tU(0);
    }
    AppMethodBeat.o(268995);
  }
  
  public final void a(LinkedHashMap<String, Rect> paramLinkedHashMap, boolean paramBoolean)
  {
    AppMethodBeat.i(268998);
    p.k(paramLinkedHashMap, "micUserMap");
    paramLinkedHashMap = ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.f)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.f.class)).zhm;
    p.j(paramLinkedHashMap, "business(LiveLinkMicSlic…).audienceLinkMicUserList");
    synchronized ((Iterable)paramLinkedHashMap)
    {
      Iterator localIterator = ???.iterator();
      while (localIterator.hasNext())
      {
        paramLinkedHashMap = localIterator.next();
        paramBoolean = Util.isEqual(((com.tencent.mm.plugin.finder.live.viewmodel.data.h)paramLinkedHashMap).ktR, ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.b)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.b.class)).dGU());
        if (paramBoolean)
        {
          if (paramLinkedHashMap == null) {
            break label184;
          }
          if ((!((com.tencent.mm.plugin.finder.live.viewmodel.data.business.b)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.b.class)).dGG()) || (((com.tencent.mm.plugin.finder.live.viewmodel.data.business.b)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.b.class)).zfS.SJy != 1)) {
            break label168;
          }
          this.yyP.tU(0);
          AppMethodBeat.o(268998);
          return;
        }
      }
      paramLinkedHashMap = null;
    }
    label168:
    this.yyP.tU(8);
    AppMethodBeat.o(268998);
    return;
    label184:
    this.yyP.tU(8);
    AppMethodBeat.o(268998);
  }
  
  public final boolean dAo()
  {
    return true;
  }
  
  public final void dAu()
  {
    AppMethodBeat.i(268996);
    com.tencent.mm.ae.d.uiThread((kotlin.g.a.a)new b(this));
    AppMethodBeat.o(268996);
  }
  
  public final void pp(boolean paramBoolean)
  {
    AppMethodBeat.i(268992);
    Object localObject = this.yyL;
    if (((j)((at)localObject).xYq.business(j.class)).ziH)
    {
      ((at)localObject).tU(0);
      this.yyM.dAH();
      this.yyO.dAH();
      localObject = this.yyN;
      if (!((com.tencent.mm.plugin.finder.live.viewmodel.data.business.b)((aq)localObject).xYq.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.b.class)).zff) {
        break label226;
      }
      ((aq)localObject).tU(0);
      label78:
      if ((!this.yyL.isVisible()) && (!this.yyM.isVisible()) && (!this.yyN.isVisible()) && (!this.yyO.isVisible())) {
        break label235;
      }
      tU(0);
    }
    for (;;)
    {
      if (paramBoolean) {
        Log.i(this.TAG, "bottom options [shopping:" + this.yyL.isVisible() + ", linkMic:" + this.yyM.isVisible() + ", gift:" + this.yyO.isVisible() + ", like:" + this.yyN.isVisible() + ']');
      }
      AppMethodBeat.o(268992);
      return;
      ((at)localObject).tU(8);
      break;
      label226:
      ((aq)localObject).tU(8);
      break label78;
      label235:
      tU(8);
    }
  }
  
  public final void statusChange(b.c paramc, Bundle paramBundle)
  {
    AppMethodBeat.i(268997);
    p.k(paramc, "status");
    switch (cy.$EnumSwitchMapping$0[paramc.ordinal()])
    {
    }
    for (;;)
    {
      AppMethodBeat.o(268997);
      return;
      this.yyM.dAH();
      this.yyO.dAH();
      paramc = this.yyQ;
      paramc.aDj("updateBottomSheet");
      paramBundle = paramc.zrN;
      if (paramBundle != null)
      {
        if (paramBundle.isShowing() != true) {
          AppMethodBeat.o(268997);
        }
      }
      else
      {
        AppMethodBeat.o(268997);
        return;
      }
      paramBundle = ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.b)paramc.xYq.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.b.class)).zfE;
      Object localObject = ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.b)paramc.xYq.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.b.class)).zfD;
      if ((localObject == null) || (paramBundle == null))
      {
        Log.i(ao.TAG, "updateBottomSheet gameteam " + localObject + ", " + paramBundle);
        AppMethodBeat.o(268997);
        return;
      }
      com.tencent.mm.pluginsdk.model.app.h.a(((azh)localObject).CqZ, ((azh)localObject).ufq, null);
      paramc.c(paramBundle);
      paramc.d(paramBundle);
      AppMethodBeat.o(268997);
      return;
      paramc = com.tencent.mm.plugin.finder.live.utils.a.yRm;
      com.tencent.mm.plugin.finder.live.utils.a.a((d)this, false);
      AppMethodBeat.o(268997);
      return;
      paramBundle = this.yyN;
      paramc = AnimationUtils.loadAnimation(paramBundle.kiF.getContext(), b.a.anim_scale_shake);
      paramBundle = paramBundle.zss;
      if (paramBundle != null)
      {
        paramBundle.startAnimation(paramc);
        AppMethodBeat.o(268997);
        return;
      }
      AppMethodBeat.o(268997);
      return;
      paramc = ao.zrX;
      ao.a.aDl("STARTLIVE");
      this.yyQ.dAH();
      AppMethodBeat.o(268997);
      return;
      this.yyQ.Ob(4);
      AppMethodBeat.o(268997);
      return;
      this.yyQ.Ob(5);
      AppMethodBeat.o(268997);
      return;
      this.yyQ.Ob(3);
      AppMethodBeat.o(268997);
      return;
      this.yyQ.Ob(2);
      AppMethodBeat.o(268997);
      return;
      localObject = this.yyQ;
      if (paramBundle != null)
      {
        paramc = Long.valueOf(paramBundle.getLong("PARAM_FINDER_LIVE_SEND_MSG_SESSION_ID", 0L));
        Log.i(ao.TAG, "ljd notifySendMsgResult sessionId:%d", new Object[] { paramc });
        l1 = ((ao)localObject).sessionId;
        if (paramc != null) {
          break label491;
        }
      }
      label491:
      while (paramc.longValue() != l1)
      {
        Log.e(ao.TAG, "sessionId error, not match, current sessionId:%s", new Object[] { Long.valueOf(((ao)localObject).sessionId) });
        AppMethodBeat.o(268997);
        return;
        paramc = null;
        break;
      }
      ((ao)localObject).sessionId = 0L;
      if (paramBundle != null)
      {
        paramBundle = paramBundle.getString("PARAM_FINDER_LIVE_NOTIFY_SEND_MSG_CONTENT");
        paramc = paramBundle;
        if (paramBundle != null) {}
      }
      else
      {
        paramc = "";
      }
      p.j(paramc, "bundle?.getString(ILiveS…FY_SEND_MSG_CONTENT)?: \"\"");
      long l1 = ((c)((ao)localObject).xYq.business(c.class)).xbk;
      long l2 = ((c)((ao)localObject).xYq.business(c.class)).liveInfo.liveId;
      paramBundle = com.tencent.mm.cd.b.cU(((c)((ao)localObject).xYq.business(c.class)).kvN);
      p.j(paramBundle, "ByteString.copyFrom(base…:class.java).liveCookies)");
      new com.tencent.mm.plugin.finder.cgi.a(l1, l2, paramBundle, paramc, ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.b)((ao)localObject).xYq.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.b.class)).kig).bhW().g((com.tencent.mm.vending.c.a)ao.g.zse);
      AppMethodBeat.o(268997);
      return;
      paramc = this.yyQ;
      paramc.zrP = false;
      paramc.zrQ = false;
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/live/plugin/FinderLiveVisitorBottomOptionPlugin$Companion;", "", "()V", "OPTION_LIKE", "", "getOPTION_LIKE", "()I", "OPTION_MIC", "getOPTION_MIC", "OPTION_SHOPPING", "getOPTION_SHOPPING", "plugin-finder_release"})
  public static final class a {}
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
  static final class b
    extends q
    implements kotlin.g.a.a<x>
  {
    b(cx paramcx)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.plugin.cx
 * JD-Core Version:    0.7.0.1
 */