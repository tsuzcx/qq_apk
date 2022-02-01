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
import com.tencent.mm.live.b.f.f;
import com.tencent.mm.ui.aq;
import com.tencent.mm.ui.ar;
import com.tencent.mm.ui.base.n.d;
import com.tencent.mm.ui.base.n.e;
import d.g.b.p;
import d.v;
import java.util.ArrayList;
import java.util.Collection;

@d.l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/live/plugin/LiveAnchorClosePlugin;", "Lcom/tencent/mm/live/plugin/BaseLivePlugin;", "root", "Landroid/view/ViewGroup;", "statueMonitor", "Lcom/tencent/mm/live/plugin/ILiveStatus;", "(Landroid/view/ViewGroup;Lcom/tencent/mm/live/plugin/ILiveStatus;)V", "bottomSheet", "Lcom/tencent/mm/ui/widget/dialog/MMBottomSheet;", "bottomSheetItemClickListener", "Lcom/tencent/mm/ui/base/MMMenuListener$OnMMMenuItemSelectedListener;", "closeBtn", "Landroid/widget/TextView;", "kotlin.jvm.PlatformType", "value", "", "mNavigatorHeight", "setMNavigatorHeight", "(I)V", "resume", "", "showQuitBottomSheet", "statusChange", "status", "Lcom/tencent/mm/live/plugin/ILiveStatus$LiveStatus;", "param", "Landroid/os/Bundle;", "plugin-logic_release"})
public final class e
  extends a
{
  private final TextView gSR;
  com.tencent.mm.ui.widget.a.e gSS;
  private int gST;
  private final n.e gSU;
  final b gSV;
  
  public e(final ViewGroup paramViewGroup, b paramb)
  {
    super(paramViewGroup, paramb);
    AppMethodBeat.i(212317);
    this.gSV = paramb;
    this.gSR = ((TextView)paramViewGroup.findViewById(2131307554));
    this.gST = ar.ej(paramViewGroup.getContext());
    this.gSU = ((n.e)new a(this, paramViewGroup));
    this.gSR.setOnClickListener((View.OnClickListener)new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(212311);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/live/plugin/LiveAnchorClosePlugin$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
        b.b.a(this.gSW.gSV, b.c.gRv);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/live/plugin/LiveAnchorClosePlugin$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(212311);
      }
    });
    if ((aol()) && (paramViewGroup.getLayoutParams() != null) && ((paramViewGroup.getLayoutParams() instanceof ViewGroup.MarginLayoutParams))) {
      switch (getCurrentOrientation())
      {
      }
    }
    for (;;)
    {
      AppMethodBeat.o(212317);
      return;
      paramb = paramViewGroup.getLayoutParams();
      if (paramb == null)
      {
        paramViewGroup = new v("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
        AppMethodBeat.o(212317);
        throw paramViewGroup;
      }
      ((ViewGroup.MarginLayoutParams)paramb).setMarginEnd(ar.ej(paramViewGroup.getContext()));
      AppMethodBeat.o(212317);
      return;
      paramb = paramViewGroup.getLayoutParams();
      if (paramb == null)
      {
        paramViewGroup = new v("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
        AppMethodBeat.o(212317);
        throw paramViewGroup;
      }
      ((ViewGroup.MarginLayoutParams)paramb).setMarginEnd(aq.fromDPToPix(paramViewGroup.getContext(), 16));
    }
  }
  
  public final void a(final b.c paramc, final Bundle paramBundle)
  {
    AppMethodBeat.i(212316);
    p.h(paramc, "status");
    switch (f.cpQ[paramc.ordinal()])
    {
    }
    for (;;)
    {
      AppMethodBeat.o(212316);
      return;
      paramc = new ArrayList();
      paramBundle = new ArrayList();
      Object localObject = this.gGK.getContext();
      p.g(localObject, "root.context");
      paramc.add(((Context)localObject).getResources().getString(2131766641));
      localObject = f.f.gNo;
      paramBundle.add(Integer.valueOf(f.f.and()));
      if (this.gSS == null) {
        this.gSS = new com.tencent.mm.ui.widget.a.e(this.gGK.getContext(), 1, false);
      }
      localObject = this.gSS;
      if (localObject != null) {
        ((com.tencent.mm.ui.widget.a.e)localObject).fMd();
      }
      localObject = this.gSS;
      if (localObject != null) {
        ((com.tencent.mm.ui.widget.a.e)localObject).a((n.d)new b(this, paramc, paramBundle));
      }
      paramc = this.gSS;
      if (paramc != null) {
        paramc.a(this.gSU);
      }
      paramc = this.gSS;
      if (paramc != null) {
        paramc.b((com.tencent.mm.ui.widget.a.e.b)new c(this));
      }
      paramc = this.gSS;
      if (paramc != null)
      {
        paramc.cMW();
        AppMethodBeat.o(212316);
        return;
      }
      AppMethodBeat.o(212316);
      return;
      nI(8);
      AppMethodBeat.o(212316);
      return;
      nI(0);
      AppMethodBeat.o(212316);
      return;
      if ((this.gGK.getLayoutParams() != null) && ((this.gGK.getLayoutParams() instanceof ViewGroup.MarginLayoutParams))) {
        switch (getCurrentOrientation())
        {
        case 2: 
        default: 
          break;
        case 1: 
          paramc = this.gGK.getLayoutParams();
          if (paramc == null)
          {
            paramc = new v("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
            AppMethodBeat.o(212316);
            throw paramc;
          }
        case 3: 
          paramc = this.gGK.getLayoutParams();
          if (paramc == null)
          {
            paramc = new v("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
            AppMethodBeat.o(212316);
            throw paramc;
          }
          ((ViewGroup.MarginLayoutParams)paramc).setMarginEnd(this.gST);
          AppMethodBeat.o(212316);
          return;
          ((ViewGroup.MarginLayoutParams)paramc).setMarginEnd(aq.fromDPToPix(this.gGK.getContext(), 16));
        }
      }
    }
  }
  
  public final void resume()
  {
    AppMethodBeat.i(212315);
    super.resume();
    int j = ar.ej(this.gGK.getContext());
    int i = j;
    if (j == 0) {
      i = aq.fromDPToPix(this.gGK.getContext(), 16);
    }
    this.gST = i;
    AppMethodBeat.o(212315);
  }
  
  @d.l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "menuItem", "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", "index", "", "onMMMenuItemSelected"})
  static final class a
    implements n.e
  {
    a(e parame, ViewGroup paramViewGroup) {}
    
    public final void onMMMenuItemSelected(MenuItem paramMenuItem, int paramInt)
    {
      AppMethodBeat.i(212313);
      p.g(paramMenuItem, "menuItem");
      paramInt = paramMenuItem.getItemId();
      paramMenuItem = f.f.gNo;
      if (paramInt == f.f.and())
      {
        paramMenuItem = paramViewGroup.getContext();
        if (paramMenuItem == null)
        {
          paramMenuItem = new v("null cannot be cast to non-null type android.app.Activity");
          AppMethodBeat.o(212313);
          throw paramMenuItem;
        }
        ((Activity)paramMenuItem).getIntent().putExtra("key_is_live_finished", true);
        b.b.a(this.gSW.gSV, b.c.gRO);
        com.tencent.mm.live.d.a.apo();
      }
      AppMethodBeat.o(212313);
    }
  }
  
  @d.l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "menu", "Lcom/tencent/mm/ui/base/MMMenu;", "kotlin.jvm.PlatformType", "onCreateMMMenu"})
  static final class b
    implements n.d
  {
    b(e parame, ArrayList paramArrayList1, ArrayList paramArrayList2) {}
    
    public final void onCreateMMMenu(com.tencent.mm.ui.base.l paraml)
    {
      AppMethodBeat.i(212314);
      Object localObject = this.gSW.gSS;
      if (localObject != null) {
        ((com.tencent.mm.ui.widget.a.e)localObject).setFooterView(null);
      }
      paraml.clear();
      int i = 0;
      int j = ((Collection)paramc).size();
      while (i < j)
      {
        localObject = paramBundle.get(i);
        p.g(localObject, "ids[i]");
        int k = ((Number)localObject).intValue();
        localObject = this.gSW.gGK.getContext();
        p.g(localObject, "root.context");
        paraml.a(k, ((Context)localObject).getResources().getColor(2131101209), (CharSequence)paramc.get(i));
        i += 1;
      }
      AppMethodBeat.o(212314);
    }
  }
  
  @d.l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "onDismiss"})
  static final class c
    implements com.tencent.mm.ui.widget.a.e.b
  {
    c(e parame) {}
    
    public final void onDismiss()
    {
      this.gSW.gSS = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.live.c.e
 * JD-Core Version:    0.7.0.1
 */