package com.tencent.mm.plugin.fav.ui.widget;

import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.plugin.fav.a.af;
import com.tencent.mm.plugin.fav.a.x;
import com.tencent.mm.sdk.platformtools.ad;
import java.util.Iterator;
import java.util.List;

public final class c
  extends LinearLayout
{
  private View rED;
  public View rEE;
  public View rEF;
  private a rEG;
  private boolean rEH;
  private boolean rEI;
  private int rEJ;
  
  public c(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(107522);
    this.rEH = false;
    this.rEI = false;
    setOrientation(1);
    paramContext = new LinearLayout.LayoutParams(-1, -2);
    this.rED = View.inflate(getContext(), 2131493972, null);
    View localView = View.inflate(getContext(), 2131493949, null);
    localView.findViewById(2131303002).setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(107520);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bd(paramAnonymousView);
        a.b("com/tencent/mm/plugin/fav/ui/widget/FavHeaderView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
        if ((c.a(c.this) == 1) || (c.a(c.this) == 3))
        {
          ad.i("MicroMsg.FavHeaderView", "click clear fav item");
          if (c.b(c.this) != null) {
            c.b(c.this).cwy();
          }
        }
        a.a(this, "com/tencent/mm/plugin/fav/ui/widget/FavHeaderView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(107520);
      }
    });
    this.rEE = localView;
    localView = View.inflate(getContext(), 2131493970, null);
    localView.findViewById(2131299857).setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(107521);
        Object localObject = new com.tencent.mm.hellhoundlib.b.b();
        ((com.tencent.mm.hellhoundlib.b.b)localObject).bd(paramAnonymousView);
        a.b("com/tencent/mm/plugin/fav/ui/widget/FavHeaderView$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).ahq());
        ad.i("MicroMsg.FavHeaderView", "click retry item");
        paramAnonymousView = ((af)com.tencent.mm.kernel.g.ad(af.class)).getFavItemInfoStorage().cvq();
        if ((paramAnonymousView == null) || (paramAnonymousView.isEmpty()))
        {
          a.a(this, "com/tencent/mm/plugin/fav/ui/widget/FavHeaderView$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(107521);
          return;
        }
        paramAnonymousView = paramAnonymousView.iterator();
        while (paramAnonymousView.hasNext())
        {
          localObject = (com.tencent.mm.plugin.fav.a.g)paramAnonymousView.next();
          if (!((com.tencent.mm.plugin.fav.a.g)localObject).isUploadFailed()) {
            ad.w("MicroMsg.FavHeaderView", "item id is %d, status is not upload fail", new Object[] { Integer.valueOf(((com.tencent.mm.plugin.fav.a.g)localObject).field_id) });
          } else {
            com.tencent.mm.plugin.fav.a.b.l((com.tencent.mm.plugin.fav.a.g)localObject);
          }
        }
        c.c(c.this).setVisibility(8);
        c.d(c.this).setVisibility(8);
        a.a(this, "com/tencent/mm/plugin/fav/ui/widget/FavHeaderView$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(107521);
      }
    });
    this.rEF = localView;
    addView(this.rED, new LinearLayout.LayoutParams(paramContext));
    addView(this.rEE, new LinearLayout.LayoutParams(paramContext));
    addView(this.rEF, new LinearLayout.LayoutParams(paramContext));
    AppMethodBeat.o(107522);
  }
  
  private void Ej(int paramInt)
  {
    AppMethodBeat.i(107524);
    this.rEJ = paramInt;
    ad.i("MicroMsg.FavHeaderView", "showStatusBar status:".concat(String.valueOf(paramInt)));
    if (paramInt == 0)
    {
      this.rEF.setVisibility(8);
      this.rEE.setVisibility(8);
      AppMethodBeat.o(107524);
      return;
    }
    if (paramInt == 1)
    {
      if (!this.rEH) {
        com.tencent.mm.plugin.report.service.g.yhR.f(14109, new Object[] { Integer.valueOf(1) });
      }
      this.rEH = true;
      this.rEF.setVisibility(8);
      this.rEE.setVisibility(0);
      this.rEE.findViewById(2131303006).setVisibility(0);
      this.rEE.findViewById(2131303007).setVisibility(8);
      AppMethodBeat.o(107524);
      return;
    }
    if (paramInt == 2)
    {
      this.rEF.setVisibility(0);
      this.rEE.setVisibility(8);
      AppMethodBeat.o(107524);
      return;
    }
    if (paramInt == 3)
    {
      if (!this.rEI) {
        com.tencent.mm.plugin.report.service.g.yhR.f(14109, new Object[] { Integer.valueOf(0) });
      }
      this.rEI = true;
      this.rEF.setVisibility(8);
      this.rEE.setVisibility(0);
      this.rEE.findViewById(2131303006).setVisibility(8);
      this.rEE.findViewById(2131303007).setVisibility(0);
    }
    AppMethodBeat.o(107524);
  }
  
  public final void cxn()
  {
    AppMethodBeat.i(107525);
    List localList = ((af)com.tencent.mm.kernel.g.ad(af.class)).getFavItemInfoStorage().cvq();
    long l;
    int i;
    if (localList != null)
    {
      Iterator localIterator = localList.iterator();
      l = 0L;
      for (i = 0; localIterator.hasNext(); i = 1) {
        l = com.tencent.mm.plugin.fav.a.b.a((com.tencent.mm.plugin.fav.a.g)localIterator.next()) + l;
      }
      ad.i("MicroMsg.FavHeaderView", "triggerStatusBar uploadFailedItemList size:%d,totalSize:%d", new Object[] { Integer.valueOf(localList.size()), Long.valueOf(l) });
    }
    for (;;)
    {
      if (i != 0)
      {
        if (l > com.tencent.mm.plugin.fav.a.b.cuD())
        {
          Ej(1);
          AppMethodBeat.o(107525);
          return;
        }
        Ej(2);
        AppMethodBeat.o(107525);
        return;
      }
      if (com.tencent.mm.plugin.fav.a.b.cuG())
      {
        Ej(3);
        AppMethodBeat.o(107525);
        return;
      }
      Ej(0);
      AppMethodBeat.o(107525);
      return;
      l = 0L;
      i = 0;
    }
  }
  
  public final void lH(boolean paramBoolean)
  {
    AppMethodBeat.i(107523);
    View localView = this.rED;
    if (paramBoolean) {}
    for (int i = 0;; i = 8)
    {
      localView.setVisibility(i);
      AppMethodBeat.o(107523);
      return;
    }
  }
  
  public final void setCleanFavSpace(a parama)
  {
    this.rEG = parama;
  }
  
  public static abstract interface a
  {
    public abstract void cwy();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.ui.widget.c
 * JD-Core Version:    0.7.0.1
 */