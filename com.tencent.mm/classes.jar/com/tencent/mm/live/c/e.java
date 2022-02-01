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
import com.tencent.mm.ui.ao;
import com.tencent.mm.ui.ap;
import com.tencent.mm.ui.base.n.c;
import com.tencent.mm.ui.base.n.d;
import d.g.b.k;
import d.l;
import d.v;
import java.util.ArrayList;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/live/plugin/LiveAnchorClosePlugin;", "Lcom/tencent/mm/live/plugin/BaseLivePlugin;", "root", "Landroid/view/ViewGroup;", "statueMonitor", "Lcom/tencent/mm/live/plugin/ILiveStatus;", "(Landroid/view/ViewGroup;Lcom/tencent/mm/live/plugin/ILiveStatus;)V", "bottomSheet", "Lcom/tencent/mm/ui/widget/dialog/MMBottomSheet;", "bottomSheetItemClickListener", "Lcom/tencent/mm/ui/base/MMMenuListener$OnMMMenuItemSelectedListener;", "closeBtn", "Landroid/widget/TextView;", "kotlin.jvm.PlatformType", "value", "", "mNavigatorHeight", "setMNavigatorHeight", "(I)V", "resume", "", "showQuitBottomSheet", "statusChange", "status", "Lcom/tencent/mm/live/plugin/ILiveStatus$LiveStatus;", "param", "Landroid/os/Bundle;", "plugin-logic_release"})
public final class e
  extends a
{
  private final TextView gzg;
  com.tencent.mm.ui.widget.a.e gzh;
  private int gzi;
  private final n.d gzj;
  final b gzk;
  
  public e(final ViewGroup paramViewGroup, b paramb)
  {
    super(paramViewGroup, paramb);
    AppMethodBeat.i(190029);
    this.gzk = paramb;
    this.gzg = ((TextView)paramViewGroup.findViewById(2131307554));
    this.gzi = ap.ej(paramViewGroup.getContext());
    this.gzj = ((n.d)new a(this, paramViewGroup));
    this.gzg.setOnClickListener((View.OnClickListener)new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(190023);
        b.b.a(this.gzl.gzk, b.c.gxK);
        AppMethodBeat.o(190023);
      }
    });
    if ((aly()) && (paramViewGroup.getLayoutParams() != null) && ((paramViewGroup.getLayoutParams() instanceof ViewGroup.MarginLayoutParams))) {
      switch (getCurrentOrientation())
      {
      }
    }
    for (;;)
    {
      AppMethodBeat.o(190029);
      return;
      paramb = paramViewGroup.getLayoutParams();
      if (paramb == null)
      {
        paramViewGroup = new v("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
        AppMethodBeat.o(190029);
        throw paramViewGroup;
      }
      ((ViewGroup.MarginLayoutParams)paramb).setMarginEnd(ap.ej(paramViewGroup.getContext()));
      AppMethodBeat.o(190029);
      return;
      paramb = paramViewGroup.getLayoutParams();
      if (paramb == null)
      {
        paramViewGroup = new v("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
        AppMethodBeat.o(190029);
        throw paramViewGroup;
      }
      ((ViewGroup.MarginLayoutParams)paramb).setMarginEnd(ao.fromDPToPix(paramViewGroup.getContext(), 16));
    }
  }
  
  public final void a(b.c paramc, Bundle paramBundle)
  {
    AppMethodBeat.i(190028);
    k.h(paramc, "status");
    switch (f.cfA[paramc.ordinal()])
    {
    }
    for (;;)
    {
      AppMethodBeat.o(190028);
      return;
      paramc = new ArrayList();
      paramBundle = new ArrayList();
      Object localObject = this.gnb.getContext();
      k.g(localObject, "root.context");
      paramc.add(((Context)localObject).getResources().getString(2131766641));
      localObject = f.f.gtD;
      paramBundle.add(Integer.valueOf(f.f.akr()));
      if (this.gzh == null) {
        this.gzh = new com.tencent.mm.ui.widget.a.e(this.gnb.getContext(), 1, false);
      }
      localObject = this.gzh;
      if (localObject != null) {
        ((com.tencent.mm.ui.widget.a.e)localObject).fvr();
      }
      localObject = this.gzh;
      if (localObject != null) {
        ((com.tencent.mm.ui.widget.a.e)localObject).a((n.c)new e.b(this, paramc, paramBundle));
      }
      paramc = this.gzh;
      if (paramc != null) {
        paramc.a(this.gzj);
      }
      paramc = this.gzh;
      if (paramc != null) {
        paramc.b((com.tencent.mm.ui.widget.a.e.b)new e.c(this));
      }
      paramc = this.gzh;
      if (paramc != null)
      {
        paramc.cED();
        AppMethodBeat.o(190028);
        return;
      }
      AppMethodBeat.o(190028);
      return;
      nj(8);
      AppMethodBeat.o(190028);
      return;
      nj(0);
      AppMethodBeat.o(190028);
      return;
      if ((this.gnb.getLayoutParams() != null) && ((this.gnb.getLayoutParams() instanceof ViewGroup.MarginLayoutParams))) {
        switch (getCurrentOrientation())
        {
        case 2: 
        default: 
          break;
        case 1: 
          paramc = this.gnb.getLayoutParams();
          if (paramc == null)
          {
            paramc = new v("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
            AppMethodBeat.o(190028);
            throw paramc;
          }
        case 3: 
          paramc = this.gnb.getLayoutParams();
          if (paramc == null)
          {
            paramc = new v("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
            AppMethodBeat.o(190028);
            throw paramc;
          }
          ((ViewGroup.MarginLayoutParams)paramc).setMarginEnd(this.gzi);
          AppMethodBeat.o(190028);
          return;
          ((ViewGroup.MarginLayoutParams)paramc).setMarginEnd(ao.fromDPToPix(this.gnb.getContext(), 16));
        }
      }
    }
  }
  
  public final void resume()
  {
    AppMethodBeat.i(190027);
    super.resume();
    int j = ap.ej(this.gnb.getContext());
    int i = j;
    if (j == 0) {
      i = ao.fromDPToPix(this.gnb.getContext(), 16);
    }
    this.gzi = i;
    AppMethodBeat.o(190027);
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "menuItem", "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", "index", "", "onMMMenuItemSelected"})
  static final class a
    implements n.d
  {
    a(e parame, ViewGroup paramViewGroup) {}
    
    public final void onMMMenuItemSelected(MenuItem paramMenuItem, int paramInt)
    {
      AppMethodBeat.i(190025);
      k.g(paramMenuItem, "menuItem");
      paramInt = paramMenuItem.getItemId();
      paramMenuItem = f.f.gtD;
      if (paramInt == f.f.akr())
      {
        paramMenuItem = paramViewGroup.getContext();
        if (paramMenuItem == null)
        {
          paramMenuItem = new v("null cannot be cast to non-null type android.app.Activity");
          AppMethodBeat.o(190025);
          throw paramMenuItem;
        }
        ((Activity)paramMenuItem).getIntent().putExtra("key_is_live_finished", true);
        b.b.a(this.gzl.gzk, b.c.gyd);
        com.tencent.mm.live.d.a.amB();
      }
      AppMethodBeat.o(190025);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.live.c.e
 * JD-Core Version:    0.7.0.1
 */