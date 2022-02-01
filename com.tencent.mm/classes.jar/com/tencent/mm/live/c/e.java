package com.tencent.mm.live.c;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.MarginLayoutParams;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.live.b.e;
import com.tencent.mm.live.b.h;
import com.tencent.mm.live.b.l.f;
import com.tencent.mm.ui.aw;
import com.tencent.mm.ui.ax;
import com.tencent.mm.ui.base.o;
import com.tencent.mm.ui.base.q.f;
import com.tencent.mm.ui.base.q.g;
import java.util.ArrayList;
import java.util.Collection;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/live/plugin/LiveAnchorClosePlugin;", "Lcom/tencent/mm/live/plugin/BaseLivePlugin;", "root", "Landroid/view/ViewGroup;", "statueMonitor", "Lcom/tencent/mm/live/plugin/ILiveStatus;", "(Landroid/view/ViewGroup;Lcom/tencent/mm/live/plugin/ILiveStatus;)V", "bottomSheet", "Lcom/tencent/mm/ui/widget/dialog/MMBottomSheet;", "bottomSheetItemClickListener", "Lcom/tencent/mm/ui/base/MMMenuListener$OnMMMenuItemSelectedListener;", "closeBtn", "Landroid/widget/TextView;", "kotlin.jvm.PlatformType", "value", "", "mNavigatorHeight", "setMNavigatorHeight", "(I)V", "resume", "", "showQuitBottomSheet", "statusChange", "status", "Lcom/tencent/mm/live/plugin/ILiveStatus$LiveStatus;", "param", "Landroid/os/Bundle;", "plugin-logic_release"})
public final class e
  extends a
{
  private final TextView kCQ;
  private com.tencent.mm.ui.widget.a.e kCR;
  private int kCS;
  private final q.g kCT;
  private final b kCU;
  
  public e(final ViewGroup paramViewGroup, b paramb)
  {
    super(paramViewGroup, paramb);
    AppMethodBeat.i(200474);
    this.kCU = paramb;
    this.kCQ = ((TextView)paramViewGroup.findViewById(b.e.live_anchor_close_btn));
    this.kCS = ax.aB(paramViewGroup.getContext());
    this.kCT = ((q.g)new a(this, paramViewGroup));
    this.kCQ.setOnClickListener((View.OnClickListener)new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(188571);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bn(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/live/plugin/LiveAnchorClosePlugin$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
        b.b.a(e.c(this.kCV), b.c.kyV);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/live/plugin/LiveAnchorClosePlugin$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(188571);
      }
    });
    if ((isLandscape()) && (paramViewGroup.getLayoutParams() != null) && ((paramViewGroup.getLayoutParams() instanceof ViewGroup.MarginLayoutParams))) {
      switch (getCurrentOrientation())
      {
      }
    }
    for (;;)
    {
      AppMethodBeat.o(200474);
      return;
      paramb = paramViewGroup.getLayoutParams();
      if (paramb == null)
      {
        paramViewGroup = new t("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
        AppMethodBeat.o(200474);
        throw paramViewGroup;
      }
      ((ViewGroup.MarginLayoutParams)paramb).setMarginEnd(ax.aB(paramViewGroup.getContext()));
      AppMethodBeat.o(200474);
      return;
      paramb = paramViewGroup.getLayoutParams();
      if (paramb == null)
      {
        paramViewGroup = new t("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
        AppMethodBeat.o(200474);
        throw paramViewGroup;
      }
      ((ViewGroup.MarginLayoutParams)paramb).setMarginEnd(aw.fromDPToPix(paramViewGroup.getContext(), 16));
    }
  }
  
  public final void resume()
  {
    AppMethodBeat.i(200456);
    super.resume();
    int j = ax.aB(this.kiF.getContext());
    int i = j;
    if (j == 0) {
      i = aw.fromDPToPix(this.kiF.getContext(), 16);
    }
    this.kCS = i;
    AppMethodBeat.o(200456);
  }
  
  public final void statusChange(final b.c paramc, final Bundle paramBundle)
  {
    AppMethodBeat.i(200466);
    p.k(paramc, "status");
    switch (f.$EnumSwitchMapping$0[paramc.ordinal()])
    {
    }
    for (;;)
    {
      AppMethodBeat.o(200466);
      return;
      paramc = new ArrayList();
      paramBundle = new ArrayList();
      Object localObject = this.kiF.getContext();
      p.j(localObject, "root.context");
      paramc.add(((Context)localObject).getResources().getString(b.h.live_menu_item_quit_live));
      localObject = l.f.kuF;
      paramBundle.add(Integer.valueOf(l.f.aNL()));
      if (this.kCR == null) {
        this.kCR = new com.tencent.mm.ui.widget.a.e(this.kiF.getContext(), 1, false);
      }
      localObject = this.kCR;
      if (localObject != null) {
        ((com.tencent.mm.ui.widget.a.e)localObject).icy();
      }
      localObject = this.kCR;
      if (localObject != null) {
        ((com.tencent.mm.ui.widget.a.e)localObject).a((q.f)new b(this, paramc, paramBundle));
      }
      paramc = this.kCR;
      if (paramc != null) {
        paramc.a(this.kCT);
      }
      paramc = this.kCR;
      if (paramc != null) {
        paramc.b((com.tencent.mm.ui.widget.a.e.b)new c(this));
      }
      paramc = this.kCR;
      if (paramc != null)
      {
        paramc.eik();
        AppMethodBeat.o(200466);
        return;
      }
      AppMethodBeat.o(200466);
      return;
      tU(8);
      AppMethodBeat.o(200466);
      return;
      tU(0);
      AppMethodBeat.o(200466);
      return;
      if ((this.kiF.getLayoutParams() != null) && ((this.kiF.getLayoutParams() instanceof ViewGroup.MarginLayoutParams))) {
        switch (getCurrentOrientation())
        {
        case 2: 
        default: 
          break;
        case 1: 
          paramc = this.kiF.getLayoutParams();
          if (paramc == null)
          {
            paramc = new t("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
            AppMethodBeat.o(200466);
            throw paramc;
          }
        case 3: 
          paramc = this.kiF.getLayoutParams();
          if (paramc == null)
          {
            paramc = new t("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
            AppMethodBeat.o(200466);
            throw paramc;
          }
          ((ViewGroup.MarginLayoutParams)paramc).setMarginEnd(this.kCS);
          AppMethodBeat.o(200466);
          return;
          ((ViewGroup.MarginLayoutParams)paramc).setMarginEnd(aw.fromDPToPix(this.kiF.getContext(), 16));
        }
      }
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "menuItem", "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", "index", "", "onMMMenuItemSelected"})
  static final class a
    implements q.g
  {
    a(e parame, ViewGroup paramViewGroup) {}
    
    public final void onMMMenuItemSelected(MenuItem paramMenuItem, int paramInt)
    {
      AppMethodBeat.i(195516);
      p.j(paramMenuItem, "menuItem");
      paramInt = paramMenuItem.getItemId();
      paramMenuItem = l.f.kuF;
      if (paramInt == l.f.aNL())
      {
        paramMenuItem = paramViewGroup.getContext();
        if (paramMenuItem == null)
        {
          paramMenuItem = new t("null cannot be cast to non-null type android.app.Activity");
          AppMethodBeat.o(195516);
          throw paramMenuItem;
        }
        ((Activity)paramMenuItem).getIntent().putExtra("key_is_live_finished", true);
        b.b.a(e.c(this.kCV), b.c.kzn);
        com.tencent.mm.live.d.a.aPZ();
      }
      AppMethodBeat.o(195516);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "menu", "Lcom/tencent/mm/ui/base/MMMenu;", "kotlin.jvm.PlatformType", "onCreateMMMenu"})
  static final class b
    implements q.f
  {
    b(e parame, ArrayList paramArrayList1, ArrayList paramArrayList2) {}
    
    public final void onCreateMMMenu(o paramo)
    {
      AppMethodBeat.i(201974);
      Object localObject = e.a(this.kCV);
      if (localObject != null) {
        ((com.tencent.mm.ui.widget.a.e)localObject).setFooterView(null);
      }
      paramo.clear();
      int i = 0;
      int j = ((Collection)paramc).size();
      while (i < j)
      {
        localObject = paramBundle.get(i);
        p.j(localObject, "ids[i]");
        int k = ((Number)localObject).intValue();
        localObject = this.kCV.kiF.getContext();
        p.j(localObject, "root.context");
        paramo.a(k, ((Context)localObject).getResources().getColor(com.tencent.mm.live.b.b.live_title_host_close_btn_color), (CharSequence)paramc.get(i));
        i += 1;
      }
      AppMethodBeat.o(201974);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "onDismiss"})
  static final class c
    implements com.tencent.mm.ui.widget.a.e.b
  {
    c(e parame) {}
    
    public final void onDismiss()
    {
      AppMethodBeat.i(198722);
      e.b(this.kCV);
      AppMethodBeat.o(198722);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.live.c.e
 * JD-Core Version:    0.7.0.1
 */