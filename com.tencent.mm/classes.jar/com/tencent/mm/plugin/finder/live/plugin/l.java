package com.tencent.mm.plugin.finder.live.plugin;

import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.MarginLayoutParams;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.h;
import com.tencent.mm.live.b.e;
import com.tencent.mm.live.b.h;
import com.tencent.mm.live.c.b.c;
import com.tencent.mm.plugin.finder.b.f;
import com.tencent.mm.plugin.finder.b.g;
import com.tencent.mm.plugin.finder.b.j;
import com.tencent.mm.plugin.finder.live.viewmodel.data.business.c;
import com.tencent.mm.protocal.protobuf.bac;
import com.tencent.mm.ui.aw;
import com.tencent.mm.ui.ax;
import com.tencent.mm.ui.base.o;
import com.tencent.mm.ui.base.q.f;
import com.tencent.mm.ui.base.q.g;
import com.tencent.mm.ui.widget.a.e;
import com.tencent.mm.ui.widget.a.e.b;
import java.util.ArrayList;
import java.util.Collection;
import kotlin.g.b.p;
import kotlin.t;

@kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/live/plugin/FinderLiveAnchorClosePlugin;", "Lcom/tencent/mm/plugin/finder/live/plugin/FinderBaseLivePlugin;", "root", "Landroid/view/ViewGroup;", "statueMonitor", "Lcom/tencent/mm/live/plugin/ILiveStatus;", "(Landroid/view/ViewGroup;Lcom/tencent/mm/live/plugin/ILiveStatus;)V", "bottomSheet", "Lcom/tencent/mm/ui/widget/dialog/MMBottomSheet;", "bottomSheetItemClickListener", "Lcom/tencent/mm/ui/base/MMMenuListener$OnMMMenuItemSelectedListener;", "closeBtn", "Landroid/view/View;", "kotlin.jvm.PlatformType", "isSecondDaryDevice", "", "()Z", "setSecondDaryDevice", "(Z)V", "value", "", "mNavigatorHeight", "setMNavigatorHeight", "(I)V", "canClearScreen", "notifyCloseLive", "", "resume", "showQuitBottomSheet", "showSecondConfirmBottomSheet", "showSecondaryBottomSheet", "statusChange", "status", "Lcom/tencent/mm/live/plugin/ILiveStatus$LiveStatus;", "param", "Landroid/os/Bundle;", "plugin-finder_release"})
public final class l
  extends d
{
  private e kCR;
  private int kCS;
  private final q.g kCT;
  private final com.tencent.mm.live.c.b kCU;
  private final View kFA;
  public boolean ymg;
  
  public l(final ViewGroup paramViewGroup, com.tencent.mm.live.c.b paramb)
  {
    super(paramViewGroup, paramb);
    AppMethodBeat.i(289678);
    this.kCU = paramb;
    this.kFA = paramViewGroup.findViewById(b.e.live_visitor_close_btn_group);
    this.kCS = ax.aB(paramViewGroup.getContext());
    this.kCT = ((q.g)new a(this, paramViewGroup));
    this.kFA.setOnClickListener((View.OnClickListener)new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(265267);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bn(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/live/plugin/FinderLiveAnchorClosePlugin$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
        com.tencent.mm.live.c.b.b.a(l.e(this.ymh), b.c.kyV);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/live/plugin/FinderLiveAnchorClosePlugin$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(265267);
      }
    });
    if ((isLandscape()) && (paramViewGroup.getLayoutParams() != null) && ((paramViewGroup.getLayoutParams() instanceof ViewGroup.MarginLayoutParams))) {
      switch (getCurrentOrientation())
      {
      }
    }
    for (;;)
    {
      paramViewGroup = com.tencent.mm.plugin.finder.live.utils.a.yRm;
      com.tencent.mm.plugin.finder.live.utils.a.a((d)this, false);
      paramViewGroup = com.tencent.mm.plugin.finder.live.utils.a.yRm;
      com.tencent.mm.plugin.finder.live.utils.a.a((d)this);
      AppMethodBeat.o(289678);
      return;
      paramb = paramViewGroup.getLayoutParams();
      if (paramb == null)
      {
        paramViewGroup = new t("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
        AppMethodBeat.o(289678);
        throw paramViewGroup;
      }
      ((ViewGroup.MarginLayoutParams)paramb).setMarginEnd(ax.aB(paramViewGroup.getContext()));
      continue;
      paramb = paramViewGroup.getLayoutParams();
      if (paramb == null)
      {
        paramViewGroup = new t("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
        AppMethodBeat.o(289678);
        throw paramViewGroup;
      }
      ((ViewGroup.MarginLayoutParams)paramb).setMarginEnd(aw.fromDPToPix(paramViewGroup.getContext(), 16));
    }
  }
  
  public final boolean dAo()
  {
    return true;
  }
  
  public final void resume()
  {
    AppMethodBeat.i(289676);
    super.resume();
    int j = ax.aB(this.kiF.getContext());
    int i = j;
    if (j == 0) {
      i = aw.fromDPToPix(this.kiF.getContext(), 16);
    }
    this.kCS = i;
    AppMethodBeat.o(289676);
  }
  
  public final void statusChange(final b.c paramc, final Bundle paramBundle)
  {
    AppMethodBeat.i(289677);
    p.k(paramc, "status");
    switch (m.$EnumSwitchMapping$0[paramc.ordinal()])
    {
    }
    for (;;)
    {
      AppMethodBeat.o(289677);
      return;
      if (this.ymg)
      {
        paramc = new ArrayList();
        paramBundle = new ArrayList();
        localObject1 = this.kiF.getContext();
        p.j(localObject1, "root.context");
        localObject1 = ((Context)localObject1).getResources();
        if (((com.tencent.mm.plugin.finder.live.viewmodel.data.business.b)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.b.class)).zgy) {}
        for (int i = b.j.finder_live_pause_mini_game_action;; i = b.j.finder_live_quit_but_not_close)
        {
          paramc.add(((Resources)localObject1).getString(i));
          localObject1 = com.tencent.mm.live.b.l.f.kuF;
          paramBundle.add(Integer.valueOf(com.tencent.mm.live.b.l.f.aNN()));
          if (this.kCR == null)
          {
            this.kCR = new e(this.kiF.getContext(), 1, true);
            localObject1 = View.inflate(this.kiF.getContext(), b.g.live_bottom_sheet_title_view, null);
            Object localObject2 = (TextView)((View)localObject1).findViewById(b.f.live_bottom_sheet_title_tv);
            p.j(localObject2, "bottomSheetTitleTv");
            ((TextView)localObject2).setText((CharSequence)this.kiF.getContext().getString(b.j.finder_live_quit_but_not_close_sub_title));
            ((TextView)localObject2).setTextSize(1, 12.0F);
            localObject2 = this.kCR;
            if (localObject2 != null) {
              ((e)localObject2).Z((View)localObject1, true);
            }
            localObject1 = this.kCR;
            if (localObject1 != null) {
              ((e)localObject1).icy();
            }
            localObject1 = this.kCR;
            if (localObject1 != null) {
              ((e)localObject1).a((q.f)new f(this, paramc, paramBundle));
            }
            paramc = this.kCR;
            if (paramc != null) {
              paramc.a(this.kCT);
            }
            paramc = this.kCR;
            if (paramc != null) {
              paramc.b((e.b)new g(this));
            }
          }
          paramc = this.kCR;
          if (paramc == null) {
            break;
          }
          paramc.eik();
          AppMethodBeat.o(289677);
          return;
        }
        AppMethodBeat.o(289677);
        return;
      }
      paramc = new ArrayList();
      paramBundle = new ArrayList();
      Object localObject1 = this.kiF.getContext();
      p.j(localObject1, "root.context");
      paramc.add(((Context)localObject1).getResources().getString(b.h.live_menu_item_quit_live));
      localObject1 = com.tencent.mm.live.b.l.f.kuF;
      paramBundle.add(Integer.valueOf(com.tencent.mm.live.b.l.f.aNL()));
      if (this.kCR == null) {
        this.kCR = new e(this.kiF.getContext(), 1, false);
      }
      localObject1 = this.kCR;
      if (localObject1 != null) {
        ((e)localObject1).icy();
      }
      localObject1 = this.kCR;
      if (localObject1 != null) {
        ((e)localObject1).a((q.f)new b(this, paramc, paramBundle));
      }
      paramc = this.kCR;
      if (paramc != null) {
        paramc.a(this.kCT);
      }
      paramc = this.kCR;
      if (paramc != null) {
        paramc.b((e.b)new c(this));
      }
      paramc = this.kCR;
      if (paramc != null)
      {
        paramc.eik();
        AppMethodBeat.o(289677);
        return;
      }
      AppMethodBeat.o(289677);
      return;
      tU(8);
      AppMethodBeat.o(289677);
      return;
      tU(0);
      AppMethodBeat.o(289677);
      return;
      paramc = com.tencent.mm.plugin.finder.live.utils.a.yRm;
      com.tencent.mm.plugin.finder.live.utils.a.a((d)this, false);
      paramc = com.tencent.mm.plugin.finder.live.utils.a.yRm;
      com.tencent.mm.plugin.finder.live.utils.a.a((d)this);
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "menuItem", "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", "index", "", "onMMMenuItemSelected"})
  static final class a
    implements q.g
  {
    a(l paraml, ViewGroup paramViewGroup) {}
    
    public final void onMMMenuItemSelected(MenuItem paramMenuItem, int paramInt)
    {
      AppMethodBeat.i(273196);
      p.j(paramMenuItem, "menuItem");
      paramInt = paramMenuItem.getItemId();
      paramMenuItem = com.tencent.mm.live.b.l.f.kuF;
      if (paramInt == com.tencent.mm.live.b.l.f.aNL())
      {
        if (this.ymh.ymg)
        {
          l.d(this.ymh);
          AppMethodBeat.o(273196);
          return;
        }
        l.a(this.ymh);
        AppMethodBeat.o(273196);
        return;
      }
      paramMenuItem = com.tencent.mm.live.b.l.f.kuF;
      if (paramInt == com.tencent.mm.live.b.l.f.aNN())
      {
        if (((com.tencent.mm.plugin.finder.live.viewmodel.data.business.b)this.ymh.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.b.class)).zgy)
        {
          com.tencent.mm.plugin.gamelive.d locald = (com.tencent.mm.plugin.gamelive.d)h.ae(com.tencent.mm.plugin.gamelive.d.class);
          Context localContext = paramViewGroup.getContext();
          Object localObject = ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.b)this.ymh.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.b.class)).zgz;
          paramMenuItem = (MenuItem)localObject;
          if (localObject == null) {
            paramMenuItem = ((c)this.ymh.business(c.class)).liveInfo.CqZ;
          }
          localObject = paramMenuItem;
          if (paramMenuItem == null) {
            localObject = "";
          }
          paramInt = ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.b)this.ymh.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.b.class)).zgA;
          paramMenuItem = Boolean.FALSE;
          locald.a(localContext, (String)localObject, paramInt, paramMenuItem, paramMenuItem, Long.valueOf(((c)this.ymh.business(c.class)).liveInfo.liveId));
          localObject = paramViewGroup.getContext();
          paramMenuItem = (MenuItem)localObject;
          if (!(localObject instanceof AppCompatActivity)) {
            paramMenuItem = null;
          }
          paramMenuItem = (AppCompatActivity)paramMenuItem;
          if (paramMenuItem != null)
          {
            paramMenuItem.finish();
            AppMethodBeat.o(273196);
            return;
          }
          AppMethodBeat.o(273196);
          return;
        }
        paramMenuItem = new Bundle();
        paramMenuItem.putBoolean("PARAM_FINDER_LIVE_LIVE_FINISH_MANUAL", true);
        paramMenuItem.putBoolean("PARAM_FINDER_LIVE_LIVE_FINISH_IF_CLOSE_LIVE", false);
        l.e(this.ymh).statusChange(b.c.kzn, paramMenuItem);
      }
      AppMethodBeat.o(273196);
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "menu", "Lcom/tencent/mm/ui/base/MMMenu;", "kotlin.jvm.PlatformType", "onCreateMMMenu"})
  static final class b
    implements q.f
  {
    b(l paraml, ArrayList paramArrayList1, ArrayList paramArrayList2) {}
    
    public final void onCreateMMMenu(o paramo)
    {
      AppMethodBeat.i(281471);
      Object localObject = l.b(this.ymh);
      if (localObject != null) {
        ((e)localObject).setFooterView(null);
      }
      paramo.clear();
      int i = 0;
      int j = ((Collection)paramc).size();
      while (i < j)
      {
        localObject = paramBundle.get(i);
        p.j(localObject, "ids[i]");
        int k = ((Number)localObject).intValue();
        localObject = this.ymh.kiF.getContext();
        p.j(localObject, "root.context");
        paramo.a(k, ((Context)localObject).getResources().getColor(com.tencent.mm.live.b.b.live_title_host_close_btn_color), (CharSequence)paramc.get(i));
        i += 1;
      }
      AppMethodBeat.o(281471);
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "onDismiss"})
  static final class c
    implements e.b
  {
    c(l paraml) {}
    
    public final void onDismiss()
    {
      AppMethodBeat.i(289036);
      l.c(this.ymh);
      AppMethodBeat.o(289036);
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Lcom/tencent/mm/ui/base/MMMenu;", "kotlin.jvm.PlatformType", "onCreateMMMenu"})
  static final class d
    implements q.f
  {
    d(l paraml) {}
    
    public final void onCreateMMMenu(o paramo)
    {
      AppMethodBeat.i(249098);
      p.j(paramo, "it");
      if (paramo.hJO())
      {
        Object localObject = com.tencent.mm.live.b.l.f.kuF;
        int i = com.tencent.mm.live.b.l.f.aNL();
        localObject = this.ymh.kiF.getContext();
        p.j(localObject, "root.context");
        int j = ((Context)localObject).getResources().getColor(com.tencent.mm.live.b.b.Red);
        localObject = this.ymh.kiF.getContext();
        p.j(localObject, "root.context");
        paramo.a(i, j, (CharSequence)((Context)localObject).getResources().getString(b.h.live_menu_item_quit_live));
      }
      AppMethodBeat.o(249098);
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "menuItem", "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", "index", "", "onMMMenuItemSelected"})
  static final class e
    implements q.g
  {
    e(l paraml) {}
    
    public final void onMMMenuItemSelected(MenuItem paramMenuItem, int paramInt)
    {
      AppMethodBeat.i(248005);
      p.j(paramMenuItem, "menuItem");
      paramInt = paramMenuItem.getItemId();
      paramMenuItem = com.tencent.mm.live.b.l.f.kuF;
      if (paramInt == com.tencent.mm.live.b.l.f.aNL()) {
        l.a(this.ymh);
      }
      AppMethodBeat.o(248005);
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "menu", "Lcom/tencent/mm/ui/base/MMMenu;", "kotlin.jvm.PlatformType", "onCreateMMMenu"})
  static final class f
    implements q.f
  {
    f(l paraml, ArrayList paramArrayList1, ArrayList paramArrayList2) {}
    
    public final void onCreateMMMenu(o paramo)
    {
      AppMethodBeat.i(283577);
      Object localObject = l.b(this.ymh);
      if (localObject != null) {
        ((e)localObject).setFooterView(null);
      }
      paramo.clear();
      int i = 0;
      int j = ((Collection)paramc).size();
      while (i < j)
      {
        localObject = paramBundle.get(i);
        p.j(localObject, "ids[i]");
        paramo.d(((Number)localObject).intValue(), (CharSequence)paramc.get(i));
        i += 1;
      }
      AppMethodBeat.o(283577);
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "onDismiss"})
  static final class g
    implements e.b
  {
    g(l paraml) {}
    
    public final void onDismiss()
    {
      AppMethodBeat.i(279895);
      l.c(this.ymh);
      AppMethodBeat.o(279895);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.plugin.l
 * JD-Core Version:    0.7.0.1
 */