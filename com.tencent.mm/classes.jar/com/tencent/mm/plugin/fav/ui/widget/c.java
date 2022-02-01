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
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.Iterator;
import java.util.List;

public final class c
  extends LinearLayout
{
  private View tmA;
  public View tmB;
  public View tmC;
  private a tmD;
  private boolean tmE;
  private boolean tmF;
  private int tmG;
  
  public c(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(107522);
    this.tmE = false;
    this.tmF = false;
    setOrientation(1);
    paramContext = new LinearLayout.LayoutParams(-1, -2);
    this.tmA = View.inflate(getContext(), 2131494142, null);
    View localView = View.inflate(getContext(), 2131494117, null);
    localView.findViewById(2131305595).setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(107520);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bm(paramAnonymousView);
        a.b("com/tencent/mm/plugin/fav/ui/widget/FavHeaderView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
        if ((c.a(c.this) == 1) || (c.a(c.this) == 3))
        {
          Log.i("MicroMsg.FavHeaderView", "click clear fav item");
          if (c.b(c.this) != null) {
            c.b(c.this).cWd();
          }
        }
        a.a(this, "com/tencent/mm/plugin/fav/ui/widget/FavHeaderView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(107520);
      }
    });
    this.tmB = localView;
    localView = View.inflate(getContext(), 2131494140, null);
    localView.findViewById(2131300537).setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(107521);
        Object localObject = new com.tencent.mm.hellhoundlib.b.b();
        ((com.tencent.mm.hellhoundlib.b.b)localObject).bm(paramAnonymousView);
        a.b("com/tencent/mm/plugin/fav/ui/widget/FavHeaderView$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).axR());
        Log.i("MicroMsg.FavHeaderView", "click retry item");
        paramAnonymousView = ((af)com.tencent.mm.kernel.g.ah(af.class)).getFavItemInfoStorage().cUV();
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
          if (!((com.tencent.mm.plugin.fav.a.g)localObject).cUy()) {
            Log.w("MicroMsg.FavHeaderView", "item id is %d, status is not upload fail", new Object[] { Integer.valueOf(((com.tencent.mm.plugin.fav.a.g)localObject).field_id) });
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
    this.tmC = localView;
    addView(this.tmA, new LinearLayout.LayoutParams(paramContext));
    addView(this.tmB, new LinearLayout.LayoutParams(paramContext));
    addView(this.tmC, new LinearLayout.LayoutParams(paramContext));
    AppMethodBeat.o(107522);
  }
  
  private void Ih(int paramInt)
  {
    AppMethodBeat.i(107524);
    this.tmG = paramInt;
    Log.i("MicroMsg.FavHeaderView", "showStatusBar status:".concat(String.valueOf(paramInt)));
    if (paramInt == 0)
    {
      this.tmC.setVisibility(8);
      this.tmB.setVisibility(8);
      AppMethodBeat.o(107524);
      return;
    }
    if (paramInt == 1)
    {
      if (!this.tmE) {
        h.CyF.a(14109, new Object[] { Integer.valueOf(1) });
      }
      this.tmE = true;
      this.tmC.setVisibility(8);
      this.tmB.setVisibility(0);
      this.tmB.findViewById(2131305599).setVisibility(0);
      this.tmB.findViewById(2131305600).setVisibility(8);
      AppMethodBeat.o(107524);
      return;
    }
    if (paramInt == 2)
    {
      this.tmC.setVisibility(0);
      this.tmB.setVisibility(8);
      AppMethodBeat.o(107524);
      return;
    }
    if (paramInt == 3)
    {
      if (!this.tmF) {
        h.CyF.a(14109, new Object[] { Integer.valueOf(0) });
      }
      this.tmF = true;
      this.tmC.setVisibility(8);
      this.tmB.setVisibility(0);
      this.tmB.findViewById(2131305599).setVisibility(8);
      this.tmB.findViewById(2131305600).setVisibility(0);
    }
    AppMethodBeat.o(107524);
  }
  
  public final void cWR()
  {
    AppMethodBeat.i(107525);
    List localList = ((af)com.tencent.mm.kernel.g.ah(af.class)).getFavItemInfoStorage().cUV();
    long l;
    int i;
    if (localList != null)
    {
      Iterator localIterator = localList.iterator();
      l = 0L;
      for (i = 0; localIterator.hasNext(); i = 1) {
        l = com.tencent.mm.plugin.fav.a.b.a((com.tencent.mm.plugin.fav.a.g)localIterator.next()) + l;
      }
      Log.i("MicroMsg.FavHeaderView", "triggerStatusBar uploadFailedItemList size:%d,totalSize:%d", new Object[] { Integer.valueOf(localList.size()), Long.valueOf(l) });
    }
    for (;;)
    {
      if (i != 0)
      {
        if (l > com.tencent.mm.plugin.fav.a.b.cUh())
        {
          Ih(1);
          AppMethodBeat.o(107525);
          return;
        }
        Ih(2);
        AppMethodBeat.o(107525);
        return;
      }
      if (com.tencent.mm.plugin.fav.a.b.cUk())
      {
        Ih(3);
        AppMethodBeat.o(107525);
        return;
      }
      Ih(0);
      AppMethodBeat.o(107525);
      return;
      l = 0L;
      i = 0;
    }
  }
  
  public final void mJ(boolean paramBoolean)
  {
    AppMethodBeat.i(107523);
    View localView = this.tmA;
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
    this.tmD = parama;
  }
  
  public static abstract interface a
  {
    public abstract void cWd();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.ui.widget.c
 * JD-Core Version:    0.7.0.1
 */