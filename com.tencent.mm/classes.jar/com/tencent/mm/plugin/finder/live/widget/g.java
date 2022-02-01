package com.tencent.mm.plugin.finder.live.widget;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.live.c.b.b;
import com.tencent.mm.live.core.core.b.a.a;
import com.tencent.mm.live.core.core.model.h;
import com.tencent.mm.plugin.finder.b.e;
import com.tencent.mm.plugin.finder.b.f;
import com.tencent.mm.plugin.finder.b.i;
import com.tencent.mm.plugin.finder.b.j;
import com.tencent.mm.plugin.finder.live.model.ah;
import com.tencent.mm.plugin.finder.live.plugin.d;
import com.tencent.mm.plugin.finder.live.report.k;
import com.tencent.mm.plugin.finder.live.report.m;
import com.tencent.mm.plugin.finder.live.report.s.ae;
import com.tencent.mm.plugin.finder.live.viewmodel.data.business.f;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.au;
import com.tencent.mm.ui.base.o;
import com.tencent.mm.ui.base.q.f;
import com.tencent.mm.ui.base.q.g;
import com.tencent.mm.ui.base.w;
import com.tencent.mm.ui.widget.a.e;
import com.tencent.mm.ui.widget.a.e.b;
import java.util.Collection;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/live/widget/FinderLiveAnchorMicEntranceWidget;", "", "root", "Landroid/view/ViewGroup;", "statusMonitor", "Lcom/tencent/mm/live/plugin/ILiveStatus;", "basePlugin", "Lcom/tencent/mm/plugin/finder/live/plugin/FinderBaseLivePlugin;", "(Landroid/view/ViewGroup;Lcom/tencent/mm/live/plugin/ILiveStatus;Lcom/tencent/mm/plugin/finder/live/plugin/FinderBaseLivePlugin;)V", "SHEET_MORE_ACTION_STOP_LINK", "", "TAG", "", "getBasePlugin", "()Lcom/tencent/mm/plugin/finder/live/plugin/FinderBaseLivePlugin;", "linkBottomSheet", "Lcom/tencent/mm/ui/widget/dialog/MMBottomSheet;", "linkMicGroup", "Landroid/view/View;", "kotlin.jvm.PlatformType", "linkMicIcon", "Landroid/widget/ImageView;", "linkMicPkTip", "Landroid/widget/TextView;", "linkMicTip", "liveCore", "Lcom/tencent/mm/live/core/core/trtc/AbsLiveTRTCCore;", "getLiveCore", "()Lcom/tencent/mm/live/core/core/trtc/AbsLiveTRTCCore;", "menuItemClickListener", "Lcom/tencent/mm/ui/base/MMMenuListener$OnMMMenuItemSelectedListener;", "getRoot", "()Landroid/view/ViewGroup;", "getStatusMonitor", "()Lcom/tencent/mm/live/plugin/ILiveStatus;", "buildRequestLinkMicDialog", "", "checkLinkMicGroup", "checkVisible", "isVisible", "", "prepareLinkMenuItems", "menu", "Lcom/tencent/mm/ui/base/MMMenu;", "setVisible", "visible", "updateApplyLinkInfo", "plugin-finder_release"})
public final class g
{
  public final String TAG;
  final com.tencent.mm.live.c.b kCL;
  public final ViewGroup kiF;
  public final d xYq;
  q.g ybB;
  e ymL;
  final int yvu;
  private final View zlG;
  public final TextView zlH;
  private final ImageView zlI;
  public final TextView zlJ;
  
  public g(ViewGroup paramViewGroup, com.tencent.mm.live.c.b paramb, d paramd)
  {
    AppMethodBeat.i(291161);
    this.kiF = paramViewGroup;
    this.kCL = paramb;
    this.xYq = paramd;
    this.TAG = "Finder.FinderLiveAnchorMicEntranceWidget";
    this.zlG = this.kiF.findViewById(b.f.finder_live_anchor_link_entrance_icon_group);
    this.zlH = ((TextView)this.kiF.findViewById(b.f.finder_live_anchor_link_entrance_tip));
    this.zlI = ((ImageView)this.kiF.findViewById(b.f.finder_live_anchor_link_entrance_icon));
    this.zlJ = ((TextView)this.kiF.findViewById(b.f.finder_live_anchor_link_entrance_pk_tip));
    this.ybB = ((q.g)new c(this));
    paramViewGroup = this.zlI;
    paramb = this.kiF.getContext();
    p.j(paramb, "root.context");
    paramViewGroup.setImageDrawable(au.e(paramb.getResources().getDrawable(b.i.finder_icons_filled_link_mic), -1));
    this.zlG.setOnClickListener((View.OnClickListener)new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(228129);
        Object localObject = new com.tencent.mm.hellhoundlib.b.b();
        ((com.tencent.mm.hellhoundlib.b.b)localObject).bn(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/live/widget/FinderLiveAnchorMicEntranceWidget$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).aFi());
        paramAnonymousView = com.tencent.mm.live.core.core.b.a.knj;
        if (a.a.aLi())
        {
          w.makeText(this.zlK.kiF.getContext(), b.j.finder_live_opt_invalid_tips, 0).show();
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/live/widget/FinderLiveAnchorMicEntranceWidget$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(228129);
          return;
        }
        paramAnonymousView = ah.yhC;
        paramAnonymousView = (com.tencent.mm.live.core.core.trtc.a)ah.dzB();
        if (paramAnonymousView != null)
        {
          paramAnonymousView = paramAnonymousView.knA;
          if ((paramAnonymousView != null) && (paramAnonymousView.kmG == true))
          {
            paramAnonymousView = this.zlK.kiF.getContext();
            localObject = this.zlK.kiF.getContext();
            p.j(localObject, "root.context");
            w.cS(paramAnonymousView, ((Context)localObject).getResources().getString(b.j.finder_live_mic_screen_share_tip));
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/live/widget/FinderLiveAnchorMicEntranceWidget$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(228129);
            return;
          }
        }
        paramAnonymousView = ((f)this.zlK.xYq.business(f.class)).zhl;
        Log.i(this.zlK.TAG, "click mic entrance, curLinkUser:" + paramAnonymousView + " enableBattle:" + ((f)this.zlK.xYq.business(f.class)).zhy);
        if (paramAnonymousView == null)
        {
          b.b.a(this.zlK.kCL, com.tencent.mm.live.c.b.c.kAX);
          paramAnonymousView = this.zlK.zlH;
          p.j(paramAnonymousView, "linkMicTip");
          if (paramAnonymousView.getVisibility() != 0) {
            break label550;
          }
          paramAnonymousView = this.zlK.zlH;
          p.j(paramAnonymousView, "linkMicTip");
          localObject = paramAnonymousView.getText();
          paramAnonymousView = (View)localObject;
          if (!(localObject instanceof String)) {
            paramAnonymousView = null;
          }
          localObject = (String)paramAnonymousView;
          paramAnonymousView = (View)localObject;
          if (localObject != null) {}
        }
        for (;;)
        {
          label324:
          paramAnonymousView = "";
          label550:
          do
          {
            localObject = k.yBj;
            k.a(s.ae.yHW, paramAnonymousView, -1, -1);
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/live/widget/FinderLiveAnchorMicEntranceWidget$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(228129);
            return;
            if (((f)this.zlK.xYq.business(f.class)).zhy)
            {
              b.b.a(this.zlK.kCL, com.tencent.mm.live.c.b.c.kBy);
              break;
            }
            paramAnonymousView = this.zlK;
            if (paramAnonymousView.ymL == null)
            {
              paramAnonymousView.ymL = new e(paramAnonymousView.kiF.getContext(), 1, true);
              localObject = paramAnonymousView.ymL;
              if (localObject != null) {
                ((e)localObject).icA();
              }
            }
            localObject = paramAnonymousView.ymL;
            if (localObject != null) {
              ((e)localObject).icy();
            }
            localObject = paramAnonymousView.ymL;
            if (localObject != null) {
              ((e)localObject).HK(true);
            }
            localObject = paramAnonymousView.ymL;
            if (localObject != null) {
              ((e)localObject).a((q.f)new g.a(paramAnonymousView));
            }
            localObject = paramAnonymousView.ymL;
            if (localObject != null) {
              ((e)localObject).a(paramAnonymousView.ybB);
            }
            localObject = paramAnonymousView.ymL;
            if (localObject != null) {
              ((e)localObject).b((e.b)new g.b(paramAnonymousView));
            }
            paramAnonymousView = paramAnonymousView.ymL;
            if (paramAnonymousView == null) {
              break;
            }
            paramAnonymousView.eik();
            break;
            paramAnonymousView = this.zlK.zlJ;
            p.j(paramAnonymousView, "linkMicPkTip");
            if (paramAnonymousView.getVisibility() != 0) {
              break label324;
            }
            paramAnonymousView = this.zlK.zlJ;
            p.j(paramAnonymousView, "linkMicPkTip");
            localObject = paramAnonymousView.getText();
            paramAnonymousView = (View)localObject;
            if (!(localObject instanceof String)) {
              paramAnonymousView = null;
            }
            localObject = (String)paramAnonymousView;
            paramAnonymousView = (View)localObject;
          } while (localObject != null);
        }
      }
    });
    AppMethodBeat.o(291161);
  }
  
  public final void dAH()
  {
    AppMethodBeat.i(291159);
    if (!((com.tencent.mm.plugin.finder.live.viewmodel.data.business.b)this.xYq.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.b.class)).zgy)
    {
      a.a locala = com.tencent.mm.live.core.core.b.a.knj;
      if (a.a.aLi())
      {
        this.kiF.setVisibility(0);
        AppMethodBeat.o(291159);
        return;
      }
      if ((((f)this.xYq.business(f.class)).dHd()) && (!((com.tencent.mm.plugin.finder.live.viewmodel.data.business.b)this.xYq.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.b.class)).dGP()) && (((com.tencent.mm.plugin.finder.live.viewmodel.data.business.b)this.xYq.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.b.class)).isLiveStarted()))
      {
        this.kiF.setVisibility(0);
        AppMethodBeat.o(291159);
        return;
      }
    }
    this.kiF.setVisibility(8);
    AppMethodBeat.o(291159);
  }
  
  public final void dHN()
  {
    AppMethodBeat.i(291160);
    Object localObject1 = ((f)this.xYq.business(f.class)).zhj;
    p.j(localObject1, "basePlugin.business(Live…ass.java).linkMicUserList");
    if (!((Collection)localObject1).isEmpty()) {}
    for (int i = 1; (i != 0) || (((f)this.xYq.business(f.class)).dHg()) || (((f)this.xYq.business(f.class)).dHf()); i = 0)
    {
      localObject1 = this.zlI;
      localObject2 = this.kiF.getContext();
      p.j(localObject2, "root.context");
      localObject2 = ((Context)localObject2).getResources().getDrawable(b.i.finder_icons_filled_link_mic);
      Context localContext = this.kiF.getContext();
      p.j(localContext, "root.context");
      ((ImageView)localObject1).setImageDrawable(au.e((Drawable)localObject2, localContext.getResources().getColor(com.tencent.mm.plugin.finder.b.c.UN_BW_0_Alpha_0_9)));
      localObject1 = this.zlG;
      p.j(localObject1, "linkMicGroup");
      localObject2 = this.kiF.getContext();
      p.j(localObject2, "root.context");
      ((View)localObject1).setBackground(((Context)localObject2).getResources().getDrawable(b.e.finder_live_panel_btn_white_bg));
      AppMethodBeat.o(291160);
      return;
    }
    localObject1 = this.zlI;
    Object localObject2 = this.kiF.getContext();
    p.j(localObject2, "root.context");
    ((ImageView)localObject1).setImageDrawable(au.e(((Context)localObject2).getResources().getDrawable(b.i.finder_icons_filled_link_mic), -1));
    localObject1 = this.zlG;
    p.j(localObject1, "linkMicGroup");
    localObject2 = this.kiF.getContext();
    p.j(localObject2, "root.context");
    ((View)localObject1).setBackground(((Context)localObject2).getResources().getDrawable(b.e.finder_live_panel_btn_bg));
    AppMethodBeat.o(291160);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "menu", "Lcom/tencent/mm/ui/base/MMMenu;", "kotlin.jvm.PlatformType", "onCreateMMMenu"})
  static final class a
    implements q.f
  {
    a(g paramg) {}
    
    public final void onCreateMMMenu(o paramo)
    {
      AppMethodBeat.i(291087);
      Object localObject = this.zlK.ymL;
      if (localObject != null) {
        ((e)localObject).setFooterView(null);
      }
      paramo.clear();
      localObject = this.zlK;
      p.j(paramo, "menu");
      int i = ((g)localObject).yvu;
      Context localContext = ((g)localObject).kiF.getContext();
      p.j(localContext, "root.context");
      int j = localContext.getResources().getColor(com.tencent.mm.plugin.finder.b.c.live_title_host_close_btn_color);
      localObject = ((g)localObject).kiF.getContext();
      p.j(localObject, "root.context");
      paramo.a(i, j, (CharSequence)((Context)localObject).getResources().getString(b.j.finder_live_link_mic_close));
      AppMethodBeat.o(291087);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "onDismiss"})
  static final class b
    implements e.b
  {
    b(g paramg) {}
    
    public final void onDismiss()
    {
      this.zlK.ymL = null;
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "menuItem", "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", "<anonymous parameter 1>", "", "onMMMenuItemSelected"})
  static final class c
    implements q.g
  {
    c(g paramg) {}
    
    public final void onMMMenuItemSelected(MenuItem paramMenuItem, int paramInt)
    {
      AppMethodBeat.i(270262);
      if (paramMenuItem != null) {}
      for (paramMenuItem = Integer.valueOf(paramMenuItem.getItemId());; paramMenuItem = null)
      {
        paramInt = this.zlK.yvu;
        if (paramMenuItem != null) {
          break;
        }
        AppMethodBeat.o(270262);
        return;
      }
      if (paramMenuItem.intValue() == paramInt)
      {
        Log.i(this.zlK.TAG, "SHEET_MORE_ACTION_STOP_LINK");
        if (this.zlK.kCL.getLiveRole() == 0)
        {
          paramMenuItem = m.yCt;
          m.ps(true);
        }
        b.b.a(this.zlK.kCL, com.tencent.mm.live.c.b.c.kBa);
        paramMenuItem = this.zlK.ymL;
        if (paramMenuItem != null)
        {
          paramMenuItem.bYF();
          AppMethodBeat.o(270262);
          return;
        }
      }
      AppMethodBeat.o(270262);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.widget.g
 * JD-Core Version:    0.7.0.1
 */