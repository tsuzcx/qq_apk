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

@d.l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/live/plugin/LiveAnchorClosePlugin;", "Lcom/tencent/mm/live/plugin/BaseLivePlugin;", "root", "Landroid/view/ViewGroup;", "statueMonitor", "Lcom/tencent/mm/live/plugin/ILiveStatus;", "(Landroid/view/ViewGroup;Lcom/tencent/mm/live/plugin/ILiveStatus;)V", "bottomSheet", "Lcom/tencent/mm/ui/widget/dialog/MMBottomSheet;", "bottomSheetItemClickListener", "Lcom/tencent/mm/ui/base/MMMenuListener$OnMMMenuItemSelectedListener;", "closeBtn", "Landroid/widget/TextView;", "kotlin.jvm.PlatformType", "value", "", "mNavigatorHeight", "setMNavigatorHeight", "(I)V", "resume", "", "showQuitBottomSheet", "statusChange", "status", "Lcom/tencent/mm/live/plugin/ILiveStatus$LiveStatus;", "param", "Landroid/os/Bundle;", "plugin-logic_release"})
public final class e
  extends a
{
  private final TextView gVA;
  com.tencent.mm.ui.widget.a.e gVB;
  private int gVC;
  private final n.e gVD;
  final b gVE;
  
  public e(final ViewGroup paramViewGroup, b paramb)
  {
    super(paramViewGroup, paramb);
    AppMethodBeat.i(215937);
    this.gVE = paramb;
    this.gVA = ((TextView)paramViewGroup.findViewById(2131307554));
    this.gVC = ar.en(paramViewGroup.getContext());
    this.gVD = ((n.e)new a(this, paramViewGroup));
    this.gVA.setOnClickListener((View.OnClickListener)new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(215931);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/live/plugin/LiveAnchorClosePlugin$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
        b.b.a(this.gVF.gVE, b.c.gUd);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/live/plugin/LiveAnchorClosePlugin$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(215931);
      }
    });
    if ((aoA()) && (paramViewGroup.getLayoutParams() != null) && ((paramViewGroup.getLayoutParams() instanceof ViewGroup.MarginLayoutParams))) {
      switch (getCurrentOrientation())
      {
      }
    }
    for (;;)
    {
      AppMethodBeat.o(215937);
      return;
      paramb = paramViewGroup.getLayoutParams();
      if (paramb == null)
      {
        paramViewGroup = new v("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
        AppMethodBeat.o(215937);
        throw paramViewGroup;
      }
      ((ViewGroup.MarginLayoutParams)paramb).setMarginEnd(ar.en(paramViewGroup.getContext()));
      AppMethodBeat.o(215937);
      return;
      paramb = paramViewGroup.getLayoutParams();
      if (paramb == null)
      {
        paramViewGroup = new v("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
        AppMethodBeat.o(215937);
        throw paramViewGroup;
      }
      ((ViewGroup.MarginLayoutParams)paramb).setMarginEnd(aq.fromDPToPix(paramViewGroup.getContext(), 16));
    }
  }
  
  public final void a(final b.c paramc, final Bundle paramBundle)
  {
    AppMethodBeat.i(215936);
    p.h(paramc, "status");
    switch (f.cqt[paramc.ordinal()])
    {
    }
    for (;;)
    {
      AppMethodBeat.o(215936);
      return;
      paramc = new ArrayList();
      paramBundle = new ArrayList();
      Object localObject = this.gJt.getContext();
      p.g(localObject, "root.context");
      paramc.add(((Context)localObject).getResources().getString(2131766641));
      localObject = f.f.gPX;
      paramBundle.add(Integer.valueOf(f.f.ant()));
      if (this.gVB == null) {
        this.gVB = new com.tencent.mm.ui.widget.a.e(this.gJt.getContext(), 1, false);
      }
      localObject = this.gVB;
      if (localObject != null) {
        ((com.tencent.mm.ui.widget.a.e)localObject).fQx();
      }
      localObject = this.gVB;
      if (localObject != null) {
        ((com.tencent.mm.ui.widget.a.e)localObject).a((n.d)new b(this, paramc, paramBundle));
      }
      paramc = this.gVB;
      if (paramc != null) {
        paramc.a(this.gVD);
      }
      paramc = this.gVB;
      if (paramc != null) {
        paramc.b((com.tencent.mm.ui.widget.a.e.b)new c(this));
      }
      paramc = this.gVB;
      if (paramc != null)
      {
        paramc.cPF();
        AppMethodBeat.o(215936);
        return;
      }
      AppMethodBeat.o(215936);
      return;
      nL(8);
      AppMethodBeat.o(215936);
      return;
      nL(0);
      AppMethodBeat.o(215936);
      return;
      if ((this.gJt.getLayoutParams() != null) && ((this.gJt.getLayoutParams() instanceof ViewGroup.MarginLayoutParams))) {
        switch (getCurrentOrientation())
        {
        case 2: 
        default: 
          break;
        case 1: 
          paramc = this.gJt.getLayoutParams();
          if (paramc == null)
          {
            paramc = new v("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
            AppMethodBeat.o(215936);
            throw paramc;
          }
        case 3: 
          paramc = this.gJt.getLayoutParams();
          if (paramc == null)
          {
            paramc = new v("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
            AppMethodBeat.o(215936);
            throw paramc;
          }
          ((ViewGroup.MarginLayoutParams)paramc).setMarginEnd(this.gVC);
          AppMethodBeat.o(215936);
          return;
          ((ViewGroup.MarginLayoutParams)paramc).setMarginEnd(aq.fromDPToPix(this.gJt.getContext(), 16));
        }
      }
    }
  }
  
  public final void resume()
  {
    AppMethodBeat.i(215935);
    super.resume();
    int j = ar.en(this.gJt.getContext());
    int i = j;
    if (j == 0) {
      i = aq.fromDPToPix(this.gJt.getContext(), 16);
    }
    this.gVC = i;
    AppMethodBeat.o(215935);
  }
  
  @d.l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "menuItem", "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", "index", "", "onMMMenuItemSelected"})
  static final class a
    implements n.e
  {
    a(e parame, ViewGroup paramViewGroup) {}
    
    public final void onMMMenuItemSelected(MenuItem paramMenuItem, int paramInt)
    {
      AppMethodBeat.i(215933);
      p.g(paramMenuItem, "menuItem");
      paramInt = paramMenuItem.getItemId();
      paramMenuItem = f.f.gPX;
      if (paramInt == f.f.ant())
      {
        paramMenuItem = paramViewGroup.getContext();
        if (paramMenuItem == null)
        {
          paramMenuItem = new v("null cannot be cast to non-null type android.app.Activity");
          AppMethodBeat.o(215933);
          throw paramMenuItem;
        }
        ((Activity)paramMenuItem).getIntent().putExtra("key_is_live_finished", true);
        b.b.a(this.gVF.gVE, b.c.gUw);
        com.tencent.mm.live.d.a.apC();
      }
      AppMethodBeat.o(215933);
    }
  }
  
  @d.l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "menu", "Lcom/tencent/mm/ui/base/MMMenu;", "kotlin.jvm.PlatformType", "onCreateMMMenu"})
  static final class b
    implements n.d
  {
    b(e parame, ArrayList paramArrayList1, ArrayList paramArrayList2) {}
    
    public final void onCreateMMMenu(com.tencent.mm.ui.base.l paraml)
    {
      AppMethodBeat.i(215934);
      Object localObject = this.gVF.gVB;
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
        localObject = this.gVF.gJt.getContext();
        p.g(localObject, "root.context");
        paraml.a(k, ((Context)localObject).getResources().getColor(2131101209), (CharSequence)paramc.get(i));
        i += 1;
      }
      AppMethodBeat.o(215934);
    }
  }
  
  @d.l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "onDismiss"})
  static final class c
    implements com.tencent.mm.ui.widget.a.e.b
  {
    c(e parame) {}
    
    public final void onDismiss()
    {
      this.gVF.gVB = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.live.c.e
 * JD-Core Version:    0.7.0.1
 */