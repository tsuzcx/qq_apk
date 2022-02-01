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
import com.tencent.mm.ui.at;
import com.tencent.mm.ui.au;
import com.tencent.mm.ui.base.m;
import com.tencent.mm.ui.base.o.f;
import java.util.ArrayList;
import java.util.Collection;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/live/plugin/LiveAnchorClosePlugin;", "Lcom/tencent/mm/live/plugin/BaseLivePlugin;", "root", "Landroid/view/ViewGroup;", "statueMonitor", "Lcom/tencent/mm/live/plugin/ILiveStatus;", "(Landroid/view/ViewGroup;Lcom/tencent/mm/live/plugin/ILiveStatus;)V", "bottomSheet", "Lcom/tencent/mm/ui/widget/dialog/MMBottomSheet;", "bottomSheetItemClickListener", "Lcom/tencent/mm/ui/base/MMMenuListener$OnMMMenuItemSelectedListener;", "closeBtn", "Landroid/widget/TextView;", "kotlin.jvm.PlatformType", "value", "", "mNavigatorHeight", "setMNavigatorHeight", "(I)V", "resume", "", "showQuitBottomSheet", "statusChange", "status", "Lcom/tencent/mm/live/plugin/ILiveStatus$LiveStatus;", "param", "Landroid/os/Bundle;", "plugin-logic_release"})
public final class e
  extends a
{
  private final TextView hOu;
  com.tencent.mm.ui.widget.a.e hOv;
  private int hOw;
  private final com.tencent.mm.ui.base.o.g hOx;
  final b hOy;
  
  public e(final ViewGroup paramViewGroup, b paramb)
  {
    super(paramViewGroup, paramb);
    AppMethodBeat.i(207899);
    this.hOy = paramb;
    this.hOu = ((TextView)paramViewGroup.findViewById(2131303314));
    this.hOw = au.aD(paramViewGroup.getContext());
    this.hOx = ((com.tencent.mm.ui.base.o.g)new a(this, paramViewGroup));
    this.hOu.setOnClickListener((View.OnClickListener)new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(207893);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bm(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/live/plugin/LiveAnchorClosePlugin$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
        b.b.a(this.hOz.hOy, b.c.hLC);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/live/plugin/LiveAnchorClosePlugin$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(207893);
      }
    });
    if ((isLandscape()) && (paramViewGroup.getLayoutParams() != null) && ((paramViewGroup.getLayoutParams() instanceof ViewGroup.MarginLayoutParams))) {
      switch (getCurrentOrientation())
      {
      }
    }
    for (;;)
    {
      AppMethodBeat.o(207899);
      return;
      paramb = paramViewGroup.getLayoutParams();
      if (paramb == null)
      {
        paramViewGroup = new t("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
        AppMethodBeat.o(207899);
        throw paramViewGroup;
      }
      ((ViewGroup.MarginLayoutParams)paramb).setMarginEnd(au.aD(paramViewGroup.getContext()));
      AppMethodBeat.o(207899);
      return;
      paramb = paramViewGroup.getLayoutParams();
      if (paramb == null)
      {
        paramViewGroup = new t("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
        AppMethodBeat.o(207899);
        throw paramViewGroup;
      }
      ((ViewGroup.MarginLayoutParams)paramb).setMarginEnd(at.fromDPToPix(paramViewGroup.getContext(), 16));
    }
  }
  
  public final void resume()
  {
    AppMethodBeat.i(207897);
    super.resume();
    int j = au.aD(this.hwr.getContext());
    int i = j;
    if (j == 0) {
      i = at.fromDPToPix(this.hwr.getContext(), 16);
    }
    this.hOw = i;
    AppMethodBeat.o(207897);
  }
  
  public final void statusChange(final b.c paramc, final Bundle paramBundle)
  {
    AppMethodBeat.i(207898);
    p.h(paramc, "status");
    switch (f.$EnumSwitchMapping$0[paramc.ordinal()])
    {
    }
    for (;;)
    {
      AppMethodBeat.o(207898);
      return;
      paramc = new ArrayList();
      paramBundle = new ArrayList();
      Object localObject = this.hwr.getContext();
      p.g(localObject, "root.context");
      paramc.add(((Context)localObject).getResources().getString(2131762334));
      localObject = com.tencent.mm.live.b.o.g.hHa;
      paramBundle.add(Integer.valueOf(com.tencent.mm.live.b.o.g.aFE()));
      if (this.hOv == null) {
        this.hOv = new com.tencent.mm.ui.widget.a.e(this.hwr.getContext(), 1, false);
      }
      localObject = this.hOv;
      if (localObject != null) {
        ((com.tencent.mm.ui.widget.a.e)localObject).hbr();
      }
      localObject = this.hOv;
      if (localObject != null) {
        ((com.tencent.mm.ui.widget.a.e)localObject).a((o.f)new b(this, paramc, paramBundle));
      }
      paramc = this.hOv;
      if (paramc != null) {
        paramc.a(this.hOx);
      }
      paramc = this.hOv;
      if (paramc != null) {
        paramc.b((com.tencent.mm.ui.widget.a.e.b)new c(this));
      }
      paramc = this.hOv;
      if (paramc != null)
      {
        paramc.dGm();
        AppMethodBeat.o(207898);
        return;
      }
      AppMethodBeat.o(207898);
      return;
      rg(8);
      AppMethodBeat.o(207898);
      return;
      rg(0);
      AppMethodBeat.o(207898);
      return;
      if ((this.hwr.getLayoutParams() != null) && ((this.hwr.getLayoutParams() instanceof ViewGroup.MarginLayoutParams))) {
        switch (getCurrentOrientation())
        {
        case 2: 
        default: 
          break;
        case 1: 
          paramc = this.hwr.getLayoutParams();
          if (paramc == null)
          {
            paramc = new t("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
            AppMethodBeat.o(207898);
            throw paramc;
          }
        case 3: 
          paramc = this.hwr.getLayoutParams();
          if (paramc == null)
          {
            paramc = new t("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
            AppMethodBeat.o(207898);
            throw paramc;
          }
          ((ViewGroup.MarginLayoutParams)paramc).setMarginEnd(this.hOw);
          AppMethodBeat.o(207898);
          return;
          ((ViewGroup.MarginLayoutParams)paramc).setMarginEnd(at.fromDPToPix(this.hwr.getContext(), 16));
        }
      }
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "menuItem", "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", "index", "", "onMMMenuItemSelected"})
  static final class a
    implements com.tencent.mm.ui.base.o.g
  {
    a(e parame, ViewGroup paramViewGroup) {}
    
    public final void onMMMenuItemSelected(MenuItem paramMenuItem, int paramInt)
    {
      AppMethodBeat.i(207895);
      p.g(paramMenuItem, "menuItem");
      paramInt = paramMenuItem.getItemId();
      paramMenuItem = com.tencent.mm.live.b.o.g.hHa;
      if (paramInt == com.tencent.mm.live.b.o.g.aFE())
      {
        paramMenuItem = paramViewGroup.getContext();
        if (paramMenuItem == null)
        {
          paramMenuItem = new t("null cannot be cast to non-null type android.app.Activity");
          AppMethodBeat.o(207895);
          throw paramMenuItem;
        }
        ((Activity)paramMenuItem).getIntent().putExtra("key_is_live_finished", true);
        b.b.a(this.hOz.hOy, b.c.hLV);
        com.tencent.mm.live.d.a.aIb();
      }
      AppMethodBeat.o(207895);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "menu", "Lcom/tencent/mm/ui/base/MMMenu;", "kotlin.jvm.PlatformType", "onCreateMMMenu"})
  static final class b
    implements o.f
  {
    b(e parame, ArrayList paramArrayList1, ArrayList paramArrayList2) {}
    
    public final void onCreateMMMenu(m paramm)
    {
      AppMethodBeat.i(207896);
      Object localObject = this.hOz.hOv;
      if (localObject != null) {
        ((com.tencent.mm.ui.widget.a.e)localObject).setFooterView(null);
      }
      paramm.clear();
      int i = 0;
      int j = ((Collection)paramc).size();
      while (i < j)
      {
        localObject = paramBundle.get(i);
        p.g(localObject, "ids[i]");
        int k = ((Number)localObject).intValue();
        localObject = this.hOz.hwr.getContext();
        p.g(localObject, "root.context");
        paramm.a(k, ((Context)localObject).getResources().getColor(2131100712), (CharSequence)paramc.get(i));
        i += 1;
      }
      AppMethodBeat.o(207896);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "onDismiss"})
  static final class c
    implements com.tencent.mm.ui.widget.a.e.b
  {
    c(e parame) {}
    
    public final void onDismiss()
    {
      this.hOz.hOv = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.live.c.e
 * JD-Core Version:    0.7.0.1
 */