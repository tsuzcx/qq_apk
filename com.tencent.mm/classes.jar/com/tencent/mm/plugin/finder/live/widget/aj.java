package com.tencent.mm.plugin.finder.live.widget;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ad.i;
import com.tencent.mm.live.core.core.model.h;
import com.tencent.mm.plugin.finder.b.c;
import com.tencent.mm.plugin.finder.b.e;
import com.tencent.mm.plugin.finder.b.f;
import com.tencent.mm.plugin.finder.b.i;
import com.tencent.mm.plugin.finder.b.j;
import com.tencent.mm.plugin.finder.live.model.ah;
import com.tencent.mm.plugin.finder.live.model.an;
import com.tencent.mm.plugin.finder.live.model.e.a;
import com.tencent.mm.plugin.finder.live.plugin.ab;
import com.tencent.mm.plugin.finder.live.plugin.d;
import com.tencent.mm.plugin.finder.live.report.k;
import com.tencent.mm.plugin.finder.live.report.s.aj;
import com.tencent.mm.plugin.finder.live.report.s.c;
import com.tencent.mm.plugin.finder.live.viewmodel.data.business.f;
import com.tencent.mm.ui.au;
import com.tencent.mm.ui.base.o;
import com.tencent.mm.ui.base.q.f;
import com.tencent.mm.ui.base.q.g;
import com.tencent.mm.ui.base.w;
import com.tencent.mm.ui.widget.a.e.b;
import com.tencent.mm.ui.widget.imageview.WeImageView;
import java.util.Collection;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/live/widget/FinderLiveScreenShareEntranceWidget;", "", "root", "Landroid/view/ViewGroup;", "statusMonitor", "Lcom/tencent/mm/live/plugin/ILiveStatus;", "basePlugin", "Lcom/tencent/mm/plugin/finder/live/plugin/FinderBaseLivePlugin;", "(Landroid/view/ViewGroup;Lcom/tencent/mm/live/plugin/ILiveStatus;Lcom/tencent/mm/plugin/finder/live/plugin/FinderBaseLivePlugin;)V", "SHEET_ACTION_CHANGE_FILE", "", "SHEET_ACTION_CHANGE_IMAGE", "SHEET_ACTION_FINISH_SHARE", "SHEET_ACTION_SHARE_FILE", "SHEET_ACTION_SHARE_IMAGE", "TAG", "", "getBasePlugin", "()Lcom/tencent/mm/plugin/finder/live/plugin/FinderBaseLivePlugin;", "iconGroup", "Landroid/view/View;", "iconIv", "Lcom/tencent/mm/ui/widget/imageview/WeImageView;", "linkBottomSheet", "Lcom/tencent/mm/ui/widget/dialog/MMBottomSheet;", "liveCore", "Lcom/tencent/mm/live/core/core/trtc/AbsLiveTRTCCore;", "getLiveCore", "()Lcom/tencent/mm/live/core/core/trtc/AbsLiveTRTCCore;", "menuItemClickListener", "Lcom/tencent/mm/ui/base/MMMenuListener$OnMMMenuItemSelectedListener;", "getRoot", "()Landroid/view/ViewGroup;", "getStatusMonitor", "()Lcom/tencent/mm/live/plugin/ILiveStatus;", "buildRequestLinkMicDialog", "", "checkBtnGroup", "checkVisible", "prepareLinkMenuItems", "menu", "Lcom/tencent/mm/ui/base/MMMenu;", "plugin-finder_release"})
public final class aj
{
  private final String TAG;
  private final com.tencent.mm.live.c.b kCL;
  public final ViewGroup kiF;
  private WeImageView xQM;
  final d xYq;
  q.g ybB;
  com.tencent.mm.ui.widget.a.e ymL;
  final int zqN;
  final int zqO;
  final int zqP;
  final int zqQ;
  final int zqR;
  private View zqS;
  
  public aj(ViewGroup paramViewGroup, com.tencent.mm.live.c.b paramb, d paramd)
  {
    AppMethodBeat.i(286317);
    this.kiF = paramViewGroup;
    this.kCL = paramb;
    this.xYq = paramd;
    this.TAG = "Finder.FinderLiveAnchorDocCastWidget";
    this.zqO = 1;
    this.zqP = 2;
    this.zqQ = 3;
    this.zqR = 4;
    this.ybB = ((q.g)new c(this));
    this.xQM = ((WeImageView)this.kiF.findViewById(b.f.screen_share_entrance_img));
    this.zqS = this.kiF.findViewById(b.f.screen_share_entrance_container);
    this.kiF.setOnClickListener((View.OnClickListener)new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(290045);
        Object localObject = new com.tencent.mm.hellhoundlib.b.b();
        ((com.tencent.mm.hellhoundlib.b.b)localObject).bn(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/live/widget/FinderLiveScreenShareEntranceWidget$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).aFi());
        paramAnonymousView = new i();
        paramAnonymousView.h("type", Integer.valueOf(s.aj.yIT.action));
        localObject = k.yBj;
        k.a(s.c.yEI, paramAnonymousView.toString());
        paramAnonymousView = ah.yhC;
        paramAnonymousView = (f)ah.business(f.class);
        if (paramAnonymousView != null)
        {
          paramAnonymousView = paramAnonymousView.zhl;
          if (paramAnonymousView == null)
          {
            paramAnonymousView = ah.yhC;
            paramAnonymousView = (f)ah.business(f.class);
            if (paramAnonymousView == null) {
              break label213;
            }
            paramAnonymousView = paramAnonymousView.zhm;
            if (paramAnonymousView == null) {
              break label213;
            }
            if (((Collection)paramAnonymousView).isEmpty()) {
              break label208;
            }
          }
        }
        label208:
        for (int i = 1;; i = 0)
        {
          if (i != 1) {
            break label213;
          }
          paramAnonymousView = this.zqT.kiF.getContext();
          localObject = this.zqT.kiF.getContext();
          p.j(localObject, "root.context");
          w.cS(paramAnonymousView, ((Context)localObject).getResources().getString(b.j.finder_live_pause_refuse_tips));
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/live/widget/FinderLiveScreenShareEntranceWidget$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(290045);
          return;
          paramAnonymousView = null;
          break;
        }
        label213:
        paramAnonymousView = this.zqT;
        if (paramAnonymousView.ymL == null)
        {
          paramAnonymousView.ymL = new com.tencent.mm.ui.widget.a.e(paramAnonymousView.kiF.getContext(), 1, true);
          localObject = paramAnonymousView.ymL;
          if (localObject != null) {
            ((com.tencent.mm.ui.widget.a.e)localObject).icA();
          }
        }
        localObject = paramAnonymousView.ymL;
        if (localObject != null) {
          ((com.tencent.mm.ui.widget.a.e)localObject).icy();
        }
        localObject = paramAnonymousView.ymL;
        if (localObject != null) {
          ((com.tencent.mm.ui.widget.a.e)localObject).HK(true);
        }
        localObject = paramAnonymousView.ymL;
        if (localObject != null) {
          ((com.tencent.mm.ui.widget.a.e)localObject).a((q.f)new aj.a(paramAnonymousView));
        }
        localObject = paramAnonymousView.ymL;
        if (localObject != null) {
          ((com.tencent.mm.ui.widget.a.e)localObject).a(paramAnonymousView.ybB);
        }
        localObject = paramAnonymousView.ymL;
        if (localObject != null) {
          ((com.tencent.mm.ui.widget.a.e)localObject).b((e.b)new aj.b(paramAnonymousView));
        }
        paramAnonymousView = paramAnonymousView.ymL;
        if (paramAnonymousView != null) {
          paramAnonymousView.eik();
        }
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/live/widget/FinderLiveScreenShareEntranceWidget$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(290045);
      }
    });
    AppMethodBeat.o(286317);
  }
  
  static com.tencent.mm.live.core.core.trtc.a getLiveCore()
  {
    AppMethodBeat.i(286314);
    Object localObject = ah.yhC;
    localObject = (com.tencent.mm.live.core.core.trtc.a)ah.dzB();
    AppMethodBeat.o(286314);
    return localObject;
  }
  
  public final void dIE()
  {
    AppMethodBeat.i(286316);
    Object localObject1 = getLiveCore();
    Object localObject2;
    if (localObject1 != null)
    {
      localObject1 = ((com.tencent.mm.live.core.core.trtc.a)localObject1).knA;
      if ((localObject1 != null) && (((h)localObject1).kmG == true))
      {
        localObject1 = this.xQM;
        if (localObject1 != null)
        {
          localObject2 = this.kiF.getContext();
          p.j(localObject2, "root.context");
          localObject2 = ((Context)localObject2).getResources().getDrawable(b.i.icons_filled_live_screencast);
          Context localContext = this.kiF.getContext();
          p.j(localContext, "root.context");
          ((WeImageView)localObject1).setImageDrawable(au.e((Drawable)localObject2, localContext.getResources().getColor(b.c.UN_BW_0_Alpha_0_9)));
        }
        localObject1 = this.zqS;
        if (localObject1 != null)
        {
          localObject2 = this.kiF.getContext();
          p.j(localObject2, "root.context");
          ((View)localObject1).setBackground(((Context)localObject2).getResources().getDrawable(b.e.finder_live_panel_btn_white_bg));
          AppMethodBeat.o(286316);
          return;
        }
        AppMethodBeat.o(286316);
        return;
      }
    }
    localObject1 = this.xQM;
    if (localObject1 != null)
    {
      localObject2 = this.kiF.getContext();
      p.j(localObject2, "root.context");
      ((WeImageView)localObject1).setImageDrawable(au.e(((Context)localObject2).getResources().getDrawable(b.i.icons_filled_live_screencast), -1));
    }
    localObject1 = this.zqS;
    if (localObject1 != null)
    {
      localObject2 = this.kiF.getContext();
      p.j(localObject2, "root.context");
      ((View)localObject1).setBackground(((Context)localObject2).getResources().getDrawable(b.e.finder_live_panel_btn_bg));
      AppMethodBeat.o(286316);
      return;
    }
    AppMethodBeat.o(286316);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "menu", "Lcom/tencent/mm/ui/base/MMMenu;", "kotlin.jvm.PlatformType", "onCreateMMMenu"})
  static final class a
    implements q.f
  {
    a(aj paramaj) {}
    
    public final void onCreateMMMenu(o paramo)
    {
      AppMethodBeat.i(223080);
      Object localObject1 = this.zqT.ymL;
      if (localObject1 != null) {
        ((com.tencent.mm.ui.widget.a.e)localObject1).setFooterView(null);
      }
      paramo.clear();
      localObject1 = this.zqT;
      p.j(paramo, "menu");
      Object localObject2 = aj.getLiveCore();
      if (localObject2 != null)
      {
        localObject2 = ((com.tencent.mm.live.core.core.trtc.a)localObject2).knA;
        if ((localObject2 != null) && (((h)localObject2).kmG == true))
        {
          i = ((aj)localObject1).zqQ;
          localObject2 = ((aj)localObject1).kiF.getContext();
          p.j(localObject2, "root.context");
          paramo.d(i, (CharSequence)((Context)localObject2).getResources().getString(b.j.finder_live_action_screen_share_change_file));
          i = ((aj)localObject1).zqR;
          localObject2 = ((aj)localObject1).kiF.getContext();
          p.j(localObject2, "root.context");
          paramo.d(i, (CharSequence)((Context)localObject2).getResources().getString(b.j.finder_live_action_screen_share_change_image));
          i = ((aj)localObject1).zqP;
          localObject2 = ((aj)localObject1).kiF.getContext();
          p.j(localObject2, "root.context");
          int j = ((Context)localObject2).getResources().getColor(b.c.live_title_host_close_btn_color);
          localObject1 = ((aj)localObject1).kiF.getContext();
          p.j(localObject1, "root.context");
          paramo.a(i, j, (CharSequence)((Context)localObject1).getResources().getString(b.j.finder_live_action_finish_screen_share));
          AppMethodBeat.o(223080);
          return;
        }
      }
      int i = ((aj)localObject1).zqN;
      localObject2 = ((aj)localObject1).kiF.getContext();
      p.j(localObject2, "root.context");
      paramo.d(i, (CharSequence)((Context)localObject2).getResources().getString(b.j.finder_live_action_screen_share_select_file));
      i = ((aj)localObject1).zqO;
      localObject1 = ((aj)localObject1).kiF.getContext();
      p.j(localObject1, "root.context");
      paramo.d(i, (CharSequence)((Context)localObject1).getResources().getString(b.j.finder_live_action_screen_share_select_image));
      AppMethodBeat.o(223080);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "onDismiss"})
  static final class b
    implements e.b
  {
    b(aj paramaj) {}
    
    public final void onDismiss()
    {
      this.zqT.ymL = null;
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "menuItem", "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", "<anonymous parameter 1>", "", "onMMMenuItemSelected"})
  static final class c
    implements q.g
  {
    c(aj paramaj) {}
    
    public final void onMMMenuItemSelected(MenuItem paramMenuItem, int paramInt)
    {
      AppMethodBeat.i(284965);
      if (paramMenuItem != null)
      {
        paramMenuItem = Integer.valueOf(paramMenuItem.getItemId());
        paramInt = this.zqT.zqQ;
        if (paramMenuItem != null) {
          break label90;
        }
        label31:
        paramInt = this.zqT.zqN;
        if (paramMenuItem != null) {
          break label166;
        }
        label43:
        paramInt = this.zqT.zqR;
        if (paramMenuItem != null) {
          break label242;
        }
        label55:
        paramInt = this.zqT.zqO;
        if (paramMenuItem != null) {
          break label318;
        }
      }
      label90:
      Context localContext;
      e.a locala;
      label166:
      label242:
      while (paramMenuItem.intValue() != paramInt)
      {
        paramInt = this.zqT.zqP;
        if (paramMenuItem != null) {
          break label394;
        }
        AppMethodBeat.o(284965);
        return;
        paramMenuItem = null;
        break;
        if (paramMenuItem.intValue() != paramInt) {
          break label31;
        }
        paramMenuItem = d.getFinderLiveAssistant();
        if (paramMenuItem != null)
        {
          localContext = this.zqT.kiF.getContext();
          p.j(localContext, "root.context");
          locala = com.tencent.mm.plugin.finder.live.model.e.ydF;
          paramMenuItem.ai(localContext, com.tencent.mm.plugin.finder.live.model.e.dyb());
        }
        paramMenuItem = this.zqT.ymL;
        if (paramMenuItem != null)
        {
          paramMenuItem.bYF();
          AppMethodBeat.o(284965);
          return;
        }
        AppMethodBeat.o(284965);
        return;
        if (paramMenuItem.intValue() != paramInt) {
          break label43;
        }
        paramMenuItem = d.getFinderLiveAssistant();
        if (paramMenuItem != null)
        {
          localContext = this.zqT.kiF.getContext();
          p.j(localContext, "root.context");
          locala = com.tencent.mm.plugin.finder.live.model.e.ydF;
          paramMenuItem.ai(localContext, com.tencent.mm.plugin.finder.live.model.e.dxZ());
        }
        paramMenuItem = this.zqT.ymL;
        if (paramMenuItem != null)
        {
          paramMenuItem.bYF();
          AppMethodBeat.o(284965);
          return;
        }
        AppMethodBeat.o(284965);
        return;
        if (paramMenuItem.intValue() != paramInt) {
          break label55;
        }
        paramMenuItem = d.getFinderLiveAssistant();
        if (paramMenuItem != null)
        {
          localContext = this.zqT.kiF.getContext();
          p.j(localContext, "root.context");
          locala = com.tencent.mm.plugin.finder.live.model.e.ydF;
          paramMenuItem.aj(localContext, com.tencent.mm.plugin.finder.live.model.e.dyc());
        }
        paramMenuItem = this.zqT.ymL;
        if (paramMenuItem != null)
        {
          paramMenuItem.bYF();
          AppMethodBeat.o(284965);
          return;
        }
        AppMethodBeat.o(284965);
        return;
      }
      label318:
      paramMenuItem = d.getFinderLiveAssistant();
      if (paramMenuItem != null)
      {
        localContext = this.zqT.kiF.getContext();
        p.j(localContext, "root.context");
        locala = com.tencent.mm.plugin.finder.live.model.e.ydF;
        paramMenuItem.aj(localContext, com.tencent.mm.plugin.finder.live.model.e.dya());
      }
      paramMenuItem = this.zqT.ymL;
      if (paramMenuItem != null)
      {
        paramMenuItem.bYF();
        AppMethodBeat.o(284965);
        return;
      }
      AppMethodBeat.o(284965);
      return;
      label394:
      if (paramMenuItem.intValue() == paramInt)
      {
        paramMenuItem = (ab)this.zqT.xYq.getPlugin(ab.class);
        if (paramMenuItem != null) {
          paramMenuItem.dAP();
        }
        this.zqT.dIE();
        paramMenuItem = this.zqT.ymL;
        if (paramMenuItem != null)
        {
          paramMenuItem.bYF();
          AppMethodBeat.o(284965);
          return;
        }
      }
      AppMethodBeat.o(284965);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.widget.aj
 * JD-Core Version:    0.7.0.1
 */