package com.tencent.mm.plugin.finder.replay.plugin;

import android.content.Context;
import android.content.res.Resources;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.app.AppCompatActivity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ae.d;
import com.tencent.mm.am.b.a;
import com.tencent.mm.plugin.finder.live.model.cgi.aj;
import com.tencent.mm.plugin.finder.live.p.b;
import com.tencent.mm.plugin.finder.live.p.e;
import com.tencent.mm.plugin.finder.live.p.g;
import com.tencent.mm.plugin.finder.live.p.h;
import com.tencent.mm.plugin.finder.live.report.q.bj;
import com.tencent.mm.plugin.finder.live.viewmodel.data.business.e;
import com.tencent.mm.plugin.finder.model.BaseFinderFeed;
import com.tencent.mm.plugin.finder.model.x;
import com.tencent.mm.plugin.finder.replay.FinderLiveReplayPluginLayout;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.plugin.finder.storage.FinderItem.a;
import com.tencent.mm.plugin.finder.utils.aw;
import com.tencent.mm.plugin.findersdk.a.ce;
import com.tencent.mm.protocal.protobuf.auw;
import com.tencent.mm.protocal.protobuf.bip;
import com.tencent.mm.protocal.protobuf.bjr;
import com.tencent.mm.protocal.protobuf.bjt;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.ui.base.u.i;
import com.tencent.mm.ui.base.w;
import com.tencent.mm.ui.bb;
import com.tencent.mm.ui.widget.imageview.WeImageView;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.b.u;
import org.json.JSONObject;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/replay/plugin/FinderLiveReplayMoreActionPlugin;", "Lcom/tencent/mm/plugin/finder/live/plugin/FinderBaseLivePlugin;", "root", "Landroid/view/ViewGroup;", "statusMonitor", "Lcom/tencent/mm/live/plugin/ILiveStatus;", "(Landroid/view/ViewGroup;Lcom/tencent/mm/live/plugin/ILiveStatus;)V", "canClearScreen", "", "openMoreActionDialog", "", "context", "Landroid/content/Context;", "prepareReplayMenuItems", "menu", "Lcom/tencent/mm/ui/base/MMMenu;", "prepareReplaySecondMenuItems", "Companion", "MoreActionListener", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class c
  extends com.tencent.mm.plugin.finder.live.plugin.b
{
  public static final a FlZ;
  private final com.tencent.mm.live.b.b nfT;
  
  static
  {
    AppMethodBeat.i(332999);
    FlZ = new a((byte)0);
    AppMethodBeat.o(332999);
  }
  
  public c(ViewGroup paramViewGroup, com.tencent.mm.live.b.b paramb)
  {
    super(paramViewGroup, paramb);
    AppMethodBeat.i(332938);
    this.nfT = paramb;
    paramViewGroup.setOnClickListener(new c..ExternalSyntheticLambda0(this, paramViewGroup));
    ((WeImageView)paramViewGroup.findViewById(p.e.BOP)).setImageDrawable(bb.m(paramViewGroup.getContext(), p.g.icons_filled_more, -1));
    paramViewGroup = com.tencent.mm.plugin.finder.live.utils.a.DJT;
    com.tencent.mm.plugin.finder.live.utils.a.a((com.tencent.mm.plugin.finder.live.plugin.b)this);
    AppMethodBeat.o(332938);
  }
  
  private static final void a(c paramc, ViewGroup paramViewGroup, View paramView)
  {
    AppMethodBeat.i(332972);
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(paramc);
    localb.cH(paramViewGroup);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/replay/plugin/FinderLiveReplayMoreActionPlugin", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    kotlin.g.b.s.u(paramc, "this$0");
    kotlin.g.b.s.u(paramViewGroup, "$root");
    paramViewGroup = paramViewGroup.getContext();
    kotlin.g.b.s.s(paramViewGroup, "root.context");
    paramc.gM(paramViewGroup);
    com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/finder/replay/plugin/FinderLiveReplayMoreActionPlugin", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(332972);
  }
  
  private static final void a(com.tencent.mm.ui.widget.a.f paramf, c paramc, Context paramContext, com.tencent.mm.ui.base.s params)
  {
    AppMethodBeat.i(332986);
    kotlin.g.b.s.u(paramf, "$bottomSheet");
    kotlin.g.b.s.u(paramc, "this$0");
    kotlin.g.b.s.u(paramContext, "$context");
    paramf.setFooterView(null);
    params.clear();
    kotlin.g.b.s.s(params, "menu");
    paramf = aw.Gjk;
    if (aw.A(((e)paramc.business(e.class)).Eco))
    {
      params.a(1, (CharSequence)MMApplicationContext.getResources().getString(p.h.Cot), p.g.finder_icons_filled_share, paramContext.getResources().getColor(p.b.Brand));
      params.a(2, (CharSequence)MMApplicationContext.getResources().getString(p.h.Cou), p.g.bottomsheet_icon_moment, 0);
    }
    AppMethodBeat.o(332986);
  }
  
  private static final void a(com.tencent.mm.ui.widget.a.f paramf, c paramc, com.tencent.mm.ui.base.s params)
  {
    AppMethodBeat.i(332992);
    kotlin.g.b.s.u(paramf, "$bottomSheet");
    kotlin.g.b.s.u(paramc, "this$0");
    paramf.setFooterView(null);
    params.clear();
    kotlin.g.b.s.s(params, "menu");
    if (((com.tencent.mm.plugin.finder.replay.viewmodel.c)paramc.business(com.tencent.mm.plugin.finder.replay.viewmodel.c.class)).eLX())
    {
      params.a(5, (CharSequence)paramc.mJe.getContext().getResources().getString(p.h.CiV), p.g.icons_outlined_delete);
      AppMethodBeat.o(332992);
      return;
    }
    params.a(4, (CharSequence)paramc.mJe.getContext().getResources().getString(p.h.finder_live_more_action_report), p.g.icons_outlined_report_problem);
    AppMethodBeat.o(332992);
  }
  
  private final void gM(Context paramContext)
  {
    AppMethodBeat.i(332956);
    com.tencent.mm.ui.widget.a.f localf = new com.tencent.mm.ui.widget.a.f(paramContext, 0, true);
    localf.sRz = true;
    localf.NyV = true;
    localf.NE(true);
    localf.agfb = false;
    localf.Vtg = new c..ExternalSyntheticLambda2(localf, this, paramContext);
    localf.GAz = new c..ExternalSyntheticLambda1(localf, this);
    paramContext = new b(localf, paramContext, getBuContext(), eoH());
    localf.GAC = ((u.i)paramContext);
    localf.agem = ((u.i)paramContext);
    localf.dDn();
    AppMethodBeat.o(332956);
  }
  
  public final boolean eoI()
  {
    return true;
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/replay/plugin/FinderLiveReplayMoreActionPlugin$Companion;", "", "()V", "EXPOSE_URL", "", "SHEET_MORE_ACTION_DELETE", "", "SHEET_MORE_ACTION_MINI_WINDOW", "SHEET_MORE_ACTION_REPORT", "SHEET_MORE_ACTION_SHARE_2_FRIEMD", "SHEET_MORE_ACTION_SHARE_2_SNS", "TAG", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a {}
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/replay/plugin/FinderLiveReplayMoreActionPlugin$MoreActionListener;", "Lcom/tencent/mm/ui/base/MMMenuListener$OnMMMenuItemSelectedListener;", "bottomSheet", "Lcom/tencent/mm/ui/widget/dialog/MMBottomSheet;", "context", "Landroid/content/Context;", "buContext", "Lcom/tencent/mm/plugin/finder/live/model/context/LiveBuContext;", "basePluginLayout", "Lcom/tencent/mm/plugin/finder/live/view/FinderBaseLivePluginLayout;", "(Lcom/tencent/mm/ui/widget/dialog/MMBottomSheet;Landroid/content/Context;Lcom/tencent/mm/plugin/finder/live/model/context/LiveBuContext;Lcom/tencent/mm/plugin/finder/live/view/FinderBaseLivePluginLayout;)V", "getBasePluginLayout", "()Lcom/tencent/mm/plugin/finder/live/view/FinderBaseLivePluginLayout;", "getBottomSheet", "()Lcom/tencent/mm/ui/widget/dialog/MMBottomSheet;", "getBuContext", "()Lcom/tencent/mm/plugin/finder/live/model/context/LiveBuContext;", "getContext", "()Landroid/content/Context;", "deleteReplay", "", "onMMMenuItemSelected", "menuItem", "Landroid/view/MenuItem;", "index", "", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class b
    implements u.i
  {
    private final com.tencent.mm.plugin.finder.live.view.a CvV;
    final com.tencent.mm.plugin.finder.live.model.context.a buContext;
    private final Context context;
    private final com.tencent.mm.ui.widget.a.f ngn;
    
    public b(com.tencent.mm.ui.widget.a.f paramf, Context paramContext, com.tencent.mm.plugin.finder.live.model.context.a parama, com.tencent.mm.plugin.finder.live.view.a parama1)
    {
      AppMethodBeat.i(332900);
      this.ngn = paramf;
      this.context = paramContext;
      this.buContext = parama;
      this.CvV = parama1;
      AppMethodBeat.o(332900);
    }
    
    public final void onMMMenuItemSelected(MenuItem paramMenuItem, int paramInt)
    {
      AppMethodBeat.i(332914);
      if (paramMenuItem == null)
      {
        paramMenuItem = null;
        if (paramMenuItem != null) {
          break label50;
        }
        label15:
        if (paramMenuItem != null) {
          break label218;
        }
        label19:
        if (paramMenuItem != null) {
          break label395;
        }
        label23:
        if (paramMenuItem != null) {
          break label479;
        }
      }
      label50:
      Object localObject1;
      Object localObject2;
      for (;;)
      {
        if (paramMenuItem == null)
        {
          AppMethodBeat.o(332914);
          return;
          paramMenuItem = Integer.valueOf(paramMenuItem.getItemId());
          break;
          if (paramMenuItem.intValue() != 1) {
            break label15;
          }
          paramMenuItem = ((e)this.buContext.business(e.class)).Eco;
          if (paramMenuItem != null)
          {
            localObject1 = FinderItem.Companion;
            paramMenuItem = FinderItem.a.e(paramMenuItem, 16384);
            paramMenuItem.setEcSource(((e)this.buContext.business(e.class)).Edn);
            localObject1 = com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.f.class);
            kotlin.g.b.s.s(localObject1, "service(IActivityRouter::class.java)");
            com.tencent.mm.plugin.f.a.a((com.tencent.mm.plugin.f)localObject1, (AppCompatActivity)this.context, paramMenuItem, null, 0, null, 28);
            localObject2 = new JSONObject();
            ((JSONObject)localObject2).put("share_des", "chat");
            paramMenuItem = (ce)com.tencent.mm.kernel.h.ax(ce.class);
            localObject1 = q.bj.DBj.event;
            localObject2 = ((JSONObject)localObject2).toString();
            kotlin.g.b.s.s(localObject2, "this.toString()");
            paramMenuItem.hP((String)localObject1, (String)localObject2);
          }
          paramMenuItem = this.ngn;
          if (paramMenuItem == null) {
            break label712;
          }
          paramMenuItem.cyW();
          AppMethodBeat.o(332914);
          return;
          label218:
          if (paramMenuItem.intValue() != 2) {
            break label19;
          }
          paramMenuItem = ((e)this.buContext.business(e.class)).Eco;
          if (paramMenuItem != null)
          {
            localObject1 = FinderItem.Companion;
            paramMenuItem = FinderItem.a.e(paramMenuItem, 16384);
            paramMenuItem.setEcSource(((e)this.buContext.business(e.class)).Edn);
            localObject1 = com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.f.class);
            kotlin.g.b.s.s(localObject1, "service(IActivityRouter::class.java)");
            com.tencent.mm.plugin.f.a.a((com.tencent.mm.plugin.f)localObject1, (AppCompatActivity)this.context, (BaseFinderFeed)new x(paramMenuItem), null, 0, 28);
            localObject2 = new JSONObject();
            ((JSONObject)localObject2).put("share_des", "moment");
            paramMenuItem = (ce)com.tencent.mm.kernel.h.ax(ce.class);
            localObject1 = q.bj.DBj.event;
            localObject2 = ((JSONObject)localObject2).toString();
            kotlin.g.b.s.s(localObject2, "this.toString()");
            paramMenuItem.hP((String)localObject1, (String)localObject2);
          }
          paramMenuItem = this.ngn;
          if (paramMenuItem == null) {
            break label712;
          }
          paramMenuItem.cyW();
          AppMethodBeat.o(332914);
          return;
          label395:
          if (paramMenuItem.intValue() != 3) {
            break label23;
          }
          ((com.tencent.mm.plugin.finder.replay.viewmodel.c)this.buContext.business(com.tencent.mm.plugin.finder.replay.viewmodel.c.class)).tx(true);
          paramMenuItem = this.ngn;
          if (paramMenuItem != null) {
            paramMenuItem.cyW();
          }
          paramMenuItem = this.CvV;
          if ((paramMenuItem instanceof FinderLiveReplayPluginLayout)) {}
          for (paramMenuItem = (FinderLiveReplayPluginLayout)paramMenuItem; paramMenuItem != null; paramMenuItem = null)
          {
            paramMenuItem = paramMenuItem.getUiClickListener();
            if (paramMenuItem == null) {
              break;
            }
            paramMenuItem.eLH();
            AppMethodBeat.o(332914);
            return;
          }
          label479:
          if (paramMenuItem.intValue() == 4)
          {
            ((com.tencent.mm.plugin.h)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.h.class)).a(this.context, "https://weixin110.qq.com/security/readtemplate?t=weixin_report/w_type&scene=80", ((com.tencent.mm.plugin.finder.replay.viewmodel.c)this.buContext.business(com.tencent.mm.plugin.finder.replay.viewmodel.c.class)).getLiveInfo().liveId, ((com.tencent.mm.plugin.finder.replay.viewmodel.c)this.buContext.business(com.tencent.mm.plugin.finder.replay.viewmodel.c.class)).eyh());
            paramMenuItem = this.ngn;
            if (paramMenuItem == null) {
              break label712;
            }
            paramMenuItem.cyW();
            AppMethodBeat.o(332914);
            return;
          }
        }
      }
      if (paramMenuItem.intValue() == 5)
      {
        paramMenuItem = w.a(this.context, (CharSequence)this.context.getString(p.h.app_waiting), false, 3, null);
        localObject1 = new auw();
        ((auw)localObject1).cmdId = 0;
        localObject2 = new bjt();
        ((bjt)localObject2).ZTi = 0;
        ah localah = ah.aiuX;
        ((auw)localObject1).ZFn = com.tencent.mm.bx.b.cX(((bjt)localObject2).toByteArray());
        d.b((com.tencent.mm.vending.g.c)new aj(((com.tencent.mm.plugin.finder.replay.viewmodel.c)this.buContext.business(com.tencent.mm.plugin.finder.replay.viewmodel.c.class)).getLiveInfo().liveId, ((com.tencent.mm.plugin.finder.replay.viewmodel.c)this.buContext.business(com.tencent.mm.plugin.finder.replay.viewmodel.c.class)).ecI(), 1, (auw)localObject1).bFJ(), (kotlin.g.a.b)new a(paramMenuItem, this));
        paramMenuItem = this.ngn;
        if (paramMenuItem != null) {
          paramMenuItem.cyW();
        }
      }
      label712:
      AppMethodBeat.o(332914);
    }
    
    @Metadata(d1={""}, d2={"<anonymous>", "", "it", "Lcom/tencent/mm/modelbase/Cgi$CgiBack;", "Lcom/tencent/mm/protocal/protobuf/FinderLiveModBasicInfoResponse;"}, k=3, mv={1, 5, 1}, xi=48)
    static final class a
      extends u
      implements kotlin.g.a.b<b.a<bjr>, ah>
    {
      a(w paramw, c.b paramb)
      {
        super();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes13.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.replay.plugin.c
 * JD-Core Version:    0.7.0.1
 */