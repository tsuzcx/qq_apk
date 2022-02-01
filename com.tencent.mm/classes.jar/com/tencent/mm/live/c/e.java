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
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.live.b.e.f;
import com.tencent.mm.ui.base.n.c;
import com.tencent.mm.ui.base.n.d;
import d.g.b.k;
import d.v;
import java.util.ArrayList;
import java.util.Collection;

@d.l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/live/plugin/LiveAnchorClosePlugin;", "Lcom/tencent/mm/live/plugin/BaseLivePlugin;", "root", "Landroid/view/ViewGroup;", "statueMonitor", "Lcom/tencent/mm/live/plugin/ILiveStatus;", "(Landroid/view/ViewGroup;Lcom/tencent/mm/live/plugin/ILiveStatus;)V", "bottomSheet", "Lcom/tencent/mm/ui/widget/dialog/MMBottomSheet;", "bottomSheetItemClickListener", "Lcom/tencent/mm/ui/base/MMMenuListener$OnMMMenuItemSelectedListener;", "closeBtn", "Landroid/widget/TextView;", "kotlin.jvm.PlatformType", "showQuitBottomSheet", "", "statusChange", "status", "Lcom/tencent/mm/live/plugin/ILiveStatus$LiveStatus;", "param", "Landroid/os/Bundle;", "plugin-logic_release"})
public final class e
  extends a
{
  com.tencent.mm.ui.widget.a.e IIx;
  private final n.d IIy;
  final b IIz;
  private final TextView mut;
  
  public e(final ViewGroup paramViewGroup, b paramb)
  {
    super(paramViewGroup, paramb);
    AppMethodBeat.i(202827);
    this.IIz = paramb;
    this.mut = ((TextView)paramViewGroup.findViewById(2131307478));
    this.IIy = ((n.d)new a(this, paramViewGroup));
    this.mut.setOnClickListener((View.OnClickListener)new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(202822);
        b.b.a(this.IIA.IIz, b.c.FAW);
        AppMethodBeat.o(202822);
      }
    });
    AppMethodBeat.o(202827);
  }
  
  public final void a(final b.c paramc, final Bundle paramBundle)
  {
    AppMethodBeat.i(202826);
    k.h(paramc, "status");
    switch (f.ciE[paramc.ordinal()])
    {
    }
    for (;;)
    {
      AppMethodBeat.o(202826);
      return;
      paramc = new ArrayList();
      paramBundle = new ArrayList();
      Object localObject = this.pTc.getContext();
      k.g(localObject, "root.context");
      paramc.add(((Context)localObject).getResources().getString(2131766608));
      localObject = e.f.rDA;
      paramBundle.add(Integer.valueOf(e.f.euW()));
      if (this.IIx == null) {
        this.IIx = new com.tencent.mm.ui.widget.a.e(this.pTc.getContext(), 1, false);
      }
      localObject = this.IIx;
      if (localObject != null) {
        ((com.tencent.mm.ui.widget.a.e)localObject).a((n.c)new b(this, paramc, paramBundle));
      }
      paramc = this.IIx;
      if (paramc != null) {
        paramc.a(this.IIy);
      }
      paramc = this.IIx;
      if (paramc != null) {
        paramc.b((com.tencent.mm.ui.widget.a.e.b)new c(this));
      }
      paramc = this.IIx;
      if (paramc != null)
      {
        paramc.csG();
        AppMethodBeat.o(202826);
        return;
      }
      AppMethodBeat.o(202826);
      return;
      agK(8);
      AppMethodBeat.o(202826);
      return;
      agK(0);
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "menuItem", "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", "index", "", "onMMMenuItemSelected"})
  static final class a
    implements n.d
  {
    a(e parame, ViewGroup paramViewGroup) {}
    
    public final void onMMMenuItemSelected(MenuItem paramMenuItem, int paramInt)
    {
      AppMethodBeat.i(202824);
      k.g(paramMenuItem, "menuItem");
      paramInt = paramMenuItem.getItemId();
      paramMenuItem = e.f.rDA;
      if (paramInt == e.f.euW())
      {
        paramMenuItem = paramViewGroup.getContext();
        if (paramMenuItem == null)
        {
          paramMenuItem = new v("null cannot be cast to non-null type android.app.Activity");
          AppMethodBeat.o(202824);
          throw paramMenuItem;
        }
        ((Activity)paramMenuItem).getIntent().putExtra("key_is_live_finished", true);
        b.b.a(this.IIA.IIz, b.c.FBn);
        com.tencent.mm.live.d.a.fPp();
      }
      AppMethodBeat.o(202824);
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "menu", "Lcom/tencent/mm/ui/base/MMMenu;", "kotlin.jvm.PlatformType", "onCreateMMMenu"})
  static final class b
    implements n.c
  {
    b(e parame, ArrayList paramArrayList1, ArrayList paramArrayList2) {}
    
    public final void onCreateMMMenu(com.tencent.mm.ui.base.l paraml)
    {
      AppMethodBeat.i(202825);
      Object localObject = this.IIA.IIx;
      if (localObject != null) {
        ((com.tencent.mm.ui.widget.a.e)localObject).setFooterView(null);
      }
      paraml.clear();
      int i = 0;
      int j = ((Collection)paramc).size();
      while (i < j)
      {
        localObject = paramBundle.get(i);
        k.g(localObject, "ids[i]");
        int k = ((Number)localObject).intValue();
        localObject = this.IIA.pTc.getContext();
        k.g(localObject, "root.context");
        paraml.a(k, ((Context)localObject).getResources().getColor(2131101208), (CharSequence)paramc.get(i));
        i += 1;
      }
      AppMethodBeat.o(202825);
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "onDismiss"})
  static final class c
    implements com.tencent.mm.ui.widget.a.e.b
  {
    c(e parame) {}
    
    public final void onDismiss()
    {
      this.IIA.IIx = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.live.c.e
 * JD-Core Version:    0.7.0.1
 */