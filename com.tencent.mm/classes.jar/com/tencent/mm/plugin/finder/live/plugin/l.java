package com.tencent.mm.plugin.finder.live.plugin;

import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.MarginLayoutParams;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.live.c.b.b;
import com.tencent.mm.live.c.b.c;
import com.tencent.mm.ui.aa;
import com.tencent.mm.ui.at;
import com.tencent.mm.ui.au;
import com.tencent.mm.ui.base.o.f;
import com.tencent.mm.ui.widget.a.e;
import com.tencent.mm.ui.widget.a.e.b;
import java.util.ArrayList;
import java.util.Collection;
import kotlin.g.b.p;
import kotlin.t;

@kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/live/plugin/FinderLiveAnchorClosePlugin;", "Lcom/tencent/mm/plugin/finder/live/plugin/FinderBaseLivePlugin;", "root", "Landroid/view/ViewGroup;", "statueMonitor", "Lcom/tencent/mm/live/plugin/ILiveStatus;", "(Landroid/view/ViewGroup;Lcom/tencent/mm/live/plugin/ILiveStatus;)V", "bottomSheet", "Lcom/tencent/mm/ui/widget/dialog/MMBottomSheet;", "bottomSheetItemClickListener", "Lcom/tencent/mm/ui/base/MMMenuListener$OnMMMenuItemSelectedListener;", "closeBtn", "Landroid/view/View;", "kotlin.jvm.PlatformType", "isSecondDaryDevice", "", "()Z", "setSecondDaryDevice", "(Z)V", "value", "", "mNavigatorHeight", "setMNavigatorHeight", "(I)V", "canClearScreen", "notifyCloseLive", "", "resume", "showQuitBottomSheet", "showSecondConfirmBottomSheet", "showSecondaryBottomSheet", "statusChange", "status", "Lcom/tencent/mm/live/plugin/ILiveStatus$LiveStatus;", "param", "Landroid/os/Bundle;", "plugin-finder_release"})
public final class l
  extends d
{
  e hOv;
  private int hOw;
  private final com.tencent.mm.ui.base.o.g hOx;
  final com.tencent.mm.live.c.b hOy;
  private final View hRd;
  public boolean umP;
  
  public l(ViewGroup paramViewGroup, com.tencent.mm.live.c.b paramb)
  {
    super(paramViewGroup, paramb);
    AppMethodBeat.i(246450);
    this.hOy = paramb;
    this.hRd = paramViewGroup.findViewById(2131303624);
    this.hOw = au.aD(paramViewGroup.getContext());
    this.hOx = ((com.tencent.mm.ui.base.o.g)new a(this));
    this.hRd.setOnClickListener((View.OnClickListener)new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(246441);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bm(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/live/plugin/FinderLiveAnchorClosePlugin$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
        b.b.a(this.umQ.hOy, b.c.hLC);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/live/plugin/FinderLiveAnchorClosePlugin$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(246441);
      }
    });
    if ((isLandscape()) && (paramViewGroup.getLayoutParams() != null) && ((paramViewGroup.getLayoutParams() instanceof ViewGroup.MarginLayoutParams))) {
      switch (getCurrentOrientation())
      {
      }
    }
    for (;;)
    {
      paramViewGroup = com.tencent.mm.plugin.finder.utils.m.vVH;
      com.tencent.mm.plugin.finder.utils.m.a((d)this, false);
      paramViewGroup = com.tencent.mm.plugin.finder.utils.m.vVH;
      com.tencent.mm.plugin.finder.utils.m.a((d)this);
      AppMethodBeat.o(246450);
      return;
      paramb = paramViewGroup.getLayoutParams();
      if (paramb == null)
      {
        paramViewGroup = new t("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
        AppMethodBeat.o(246450);
        throw paramViewGroup;
      }
      ((ViewGroup.MarginLayoutParams)paramb).setMarginEnd(au.aD(paramViewGroup.getContext()));
      continue;
      paramb = paramViewGroup.getLayoutParams();
      if (paramb == null)
      {
        paramViewGroup = new t("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
        AppMethodBeat.o(246450);
        throw paramViewGroup;
      }
      ((ViewGroup.MarginLayoutParams)paramb).setMarginEnd(at.fromDPToPix(paramViewGroup.getContext(), 16));
    }
  }
  
  public final boolean dgK()
  {
    return true;
  }
  
  public final void resume()
  {
    AppMethodBeat.i(246448);
    super.resume();
    int j = au.aD(this.hwr.getContext());
    int i = j;
    if (j == 0) {
      i = at.fromDPToPix(this.hwr.getContext(), 16);
    }
    this.hOw = i;
    AppMethodBeat.o(246448);
  }
  
  public final void statusChange(final b.c paramc, final Bundle paramBundle)
  {
    AppMethodBeat.i(246449);
    p.h(paramc, "status");
    switch (m.$EnumSwitchMapping$0[paramc.ordinal()])
    {
    }
    for (;;)
    {
      AppMethodBeat.o(246449);
      return;
      if (this.umP)
      {
        paramc = new ArrayList();
        paramBundle = new ArrayList();
        localObject1 = this.hwr.getContext();
        p.g(localObject1, "root.context");
        paramc.add(((Context)localObject1).getResources().getString(2131760166));
        localObject1 = com.tencent.mm.live.b.o.g.hHa;
        paramBundle.add(Integer.valueOf(com.tencent.mm.live.b.o.g.aFG()));
        if (this.hOv == null)
        {
          this.hOv = new e(this.hwr.getContext(), 1, true);
          localObject1 = View.inflate(this.hwr.getContext(), 2131495244, null);
          Object localObject2 = (TextView)((View)localObject1).findViewById(2131303357);
          p.g(localObject2, "bottomSheetTitleTv");
          ((TextView)localObject2).setText((CharSequence)this.hwr.getContext().getString(2131760167));
          ((TextView)localObject2).setTextSize(1, 12.0F);
          localObject2 = this.hOv;
          if (localObject2 != null) {
            ((e)localObject2).V((View)localObject1, true);
          }
          localObject1 = this.hOv;
          if (localObject1 != null) {
            ((e)localObject1).hbr();
          }
          localObject1 = this.hOv;
          if (localObject1 != null) {
            ((e)localObject1).a((o.f)new f(this, paramc, paramBundle));
          }
          paramc = this.hOv;
          if (paramc != null) {
            paramc.a(this.hOx);
          }
          paramc = this.hOv;
          if (paramc != null) {
            paramc.b((e.b)new g(this));
          }
        }
        paramc = this.hOv;
        if (paramc != null)
        {
          paramc.dGm();
          AppMethodBeat.o(246449);
          return;
        }
        AppMethodBeat.o(246449);
        return;
      }
      paramc = new ArrayList();
      paramBundle = new ArrayList();
      Object localObject1 = this.hwr.getContext();
      p.g(localObject1, "root.context");
      paramc.add(((Context)localObject1).getResources().getString(2131762334));
      localObject1 = com.tencent.mm.live.b.o.g.hHa;
      paramBundle.add(Integer.valueOf(com.tencent.mm.live.b.o.g.aFE()));
      if (this.hOv == null) {
        this.hOv = new e(this.hwr.getContext(), 1, false);
      }
      localObject1 = this.hOv;
      if (localObject1 != null) {
        ((e)localObject1).hbr();
      }
      localObject1 = this.hOv;
      if (localObject1 != null) {
        ((e)localObject1).a((o.f)new b(this, paramc, paramBundle));
      }
      paramc = this.hOv;
      if (paramc != null) {
        paramc.a(this.hOx);
      }
      paramc = this.hOv;
      if (paramc != null) {
        paramc.b((e.b)new c(this));
      }
      paramc = this.hOv;
      if (paramc != null)
      {
        paramc.dGm();
        AppMethodBeat.o(246449);
        return;
      }
      AppMethodBeat.o(246449);
      return;
      rg(8);
      AppMethodBeat.o(246449);
      return;
      rg(0);
      AppMethodBeat.o(246449);
      return;
      paramc = com.tencent.mm.plugin.finder.utils.m.vVH;
      com.tencent.mm.plugin.finder.utils.m.a((d)this, false);
      paramc = com.tencent.mm.plugin.finder.utils.m.vVH;
      com.tencent.mm.plugin.finder.utils.m.a((d)this);
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "menuItem", "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", "index", "", "onMMMenuItemSelected"})
  static final class a
    implements com.tencent.mm.ui.base.o.g
  {
    a(l paraml) {}
    
    public final void onMMMenuItemSelected(MenuItem paramMenuItem, int paramInt)
    {
      AppMethodBeat.i(246443);
      p.g(paramMenuItem, "menuItem");
      paramInt = paramMenuItem.getItemId();
      paramMenuItem = com.tencent.mm.live.b.o.g.hHa;
      if (paramInt == com.tencent.mm.live.b.o.g.aFE())
      {
        if (this.umQ.umP)
        {
          paramMenuItem = this.umQ;
          e locale = new e(paramMenuItem.hwr.getContext(), 1, true);
          locale.hbr();
          locale.setTitleView(aa.jQ(paramMenuItem.hwr.getContext()).inflate(2131494455, null));
          locale.a((o.f)new l.d(paramMenuItem));
          locale.a((com.tencent.mm.ui.base.o.g)new l.e(paramMenuItem));
          locale.dGm();
          AppMethodBeat.o(246443);
          return;
        }
        l.a(this.umQ);
        AppMethodBeat.o(246443);
        return;
      }
      paramMenuItem = com.tencent.mm.live.b.o.g.hHa;
      if (paramInt == com.tencent.mm.live.b.o.g.aFG())
      {
        paramMenuItem = new Bundle();
        paramMenuItem.putBoolean("PARAM_FINDER_LIVE_LIVE_FINISH_MANUAL", true);
        paramMenuItem.putBoolean("PARAM_FINDER_LIVE_LIVE_FINISH_IF_CLOSE_LIVE", false);
        this.umQ.hOy.statusChange(b.c.hLV, paramMenuItem);
      }
      AppMethodBeat.o(246443);
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "menu", "Lcom/tencent/mm/ui/base/MMMenu;", "kotlin.jvm.PlatformType", "onCreateMMMenu"})
  static final class b
    implements o.f
  {
    b(l paraml, ArrayList paramArrayList1, ArrayList paramArrayList2) {}
    
    public final void onCreateMMMenu(com.tencent.mm.ui.base.m paramm)
    {
      AppMethodBeat.i(246444);
      Object localObject = this.umQ.hOv;
      if (localObject != null) {
        ((e)localObject).setFooterView(null);
      }
      paramm.clear();
      int i = 0;
      int j = ((Collection)paramc).size();
      while (i < j)
      {
        localObject = paramBundle.get(i);
        p.g(localObject, "ids[i]");
        int k = ((Number)localObject).intValue();
        localObject = this.umQ.hwr.getContext();
        p.g(localObject, "root.context");
        paramm.a(k, ((Context)localObject).getResources().getColor(2131100712), (CharSequence)paramc.get(i));
        i += 1;
      }
      AppMethodBeat.o(246444);
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "onDismiss"})
  static final class c
    implements e.b
  {
    c(l paraml) {}
    
    public final void onDismiss()
    {
      this.umQ.hOv = null;
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Lcom/tencent/mm/ui/base/MMMenu;", "kotlin.jvm.PlatformType", "onCreateMMMenu"})
  static final class d
    implements o.f
  {
    d(l paraml) {}
    
    public final void onCreateMMMenu(com.tencent.mm.ui.base.m paramm)
    {
      AppMethodBeat.i(246445);
      p.g(paramm, "it");
      if (paramm.gKQ())
      {
        Object localObject = com.tencent.mm.live.b.o.g.hHa;
        int i = com.tencent.mm.live.b.o.g.aFE();
        localObject = this.umQ.hwr.getContext();
        p.g(localObject, "root.context");
        int j = ((Context)localObject).getResources().getColor(2131099818);
        localObject = this.umQ.hwr.getContext();
        p.g(localObject, "root.context");
        paramm.a(i, j, (CharSequence)((Context)localObject).getResources().getString(2131762334));
      }
      AppMethodBeat.o(246445);
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "menuItem", "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", "index", "", "onMMMenuItemSelected"})
  static final class e
    implements com.tencent.mm.ui.base.o.g
  {
    e(l paraml) {}
    
    public final void onMMMenuItemSelected(MenuItem paramMenuItem, int paramInt)
    {
      AppMethodBeat.i(246446);
      p.g(paramMenuItem, "menuItem");
      paramInt = paramMenuItem.getItemId();
      paramMenuItem = com.tencent.mm.live.b.o.g.hHa;
      if (paramInt == com.tencent.mm.live.b.o.g.aFE()) {
        l.a(this.umQ);
      }
      AppMethodBeat.o(246446);
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "menu", "Lcom/tencent/mm/ui/base/MMMenu;", "kotlin.jvm.PlatformType", "onCreateMMMenu"})
  static final class f
    implements o.f
  {
    f(l paraml, ArrayList paramArrayList1, ArrayList paramArrayList2) {}
    
    public final void onCreateMMMenu(com.tencent.mm.ui.base.m paramm)
    {
      AppMethodBeat.i(246447);
      Object localObject = this.umQ.hOv;
      if (localObject != null) {
        ((e)localObject).setFooterView(null);
      }
      paramm.clear();
      int i = 0;
      int j = ((Collection)paramc).size();
      while (i < j)
      {
        localObject = paramBundle.get(i);
        p.g(localObject, "ids[i]");
        paramm.d(((Number)localObject).intValue(), (CharSequence)paramc.get(i));
        i += 1;
      }
      AppMethodBeat.o(246447);
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "onDismiss"})
  static final class g
    implements e.b
  {
    g(l paraml) {}
    
    public final void onDismiss()
    {
      this.umQ.hOv = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.plugin.l
 * JD-Core Version:    0.7.0.1
 */