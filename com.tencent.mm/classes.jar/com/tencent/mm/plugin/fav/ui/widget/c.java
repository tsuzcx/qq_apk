package com.tencent.mm.plugin.fav.ui.widget;

import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.plugin.fav.a.ah;
import com.tencent.mm.plugin.fav.a.g;
import com.tencent.mm.plugin.fav.a.y;
import com.tencent.mm.plugin.fav.ui.q.e;
import com.tencent.mm.plugin.fav.ui.q.f;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.Iterator;
import java.util.List;

public final class c
  extends LinearLayout
{
  private View ApB;
  public View ApC;
  public View ApD;
  private a ApE;
  private boolean ApF;
  private boolean ApG;
  private int ApH;
  
  public c(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(107522);
    this.ApF = false;
    this.ApG = false;
    setOrientation(1);
    paramContext = new LinearLayout.LayoutParams(-1, -2);
    this.ApB = View.inflate(getContext(), q.f.fav_oldversion_bar, null);
    View localView = View.inflate(getContext(), q.f.fav_full_bar, null);
    localView.findViewById(q.e.oldversion_container).setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(107520);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.cH(paramAnonymousView);
        a.c("com/tencent/mm/plugin/fav/ui/widget/FavHeaderView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
        if ((c.a(c.this) == 1) || (c.a(c.this) == 3))
        {
          Log.i("MicroMsg.FavHeaderView", "click clear fav item");
          if (c.b(c.this) != null) {
            c.b(c.this).dSa();
          }
        }
        a.a(this, "com/tencent/mm/plugin/fav/ui/widget/FavHeaderView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(107520);
      }
    });
    this.ApC = localView;
    localView = View.inflate(getContext(), q.f.fav_netwarn_bar, null);
    localView.findViewById(q.e.fav_warn_retry_btn).setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(107521);
        Object localObject = new com.tencent.mm.hellhoundlib.b.b();
        ((com.tencent.mm.hellhoundlib.b.b)localObject).cH(paramAnonymousView);
        a.c("com/tencent/mm/plugin/fav/ui/widget/FavHeaderView$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).aYj());
        Log.i("MicroMsg.FavHeaderView", "click retry item");
        paramAnonymousView = ((ah)com.tencent.mm.kernel.h.az(ah.class)).getFavItemInfoStorage().dQL();
        if ((paramAnonymousView == null) || (paramAnonymousView.isEmpty()))
        {
          a.a(this, "com/tencent/mm/plugin/fav/ui/widget/FavHeaderView$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(107521);
          return;
        }
        paramAnonymousView = paramAnonymousView.iterator();
        while (paramAnonymousView.hasNext())
        {
          localObject = (g)paramAnonymousView.next();
          if (!((g)localObject).dQp()) {
            Log.w("MicroMsg.FavHeaderView", "item id is %d, status is not upload fail", new Object[] { Integer.valueOf(((g)localObject).field_id) });
          } else {
            com.tencent.mm.plugin.fav.a.b.l((g)localObject);
          }
        }
        c.c(c.this).setVisibility(8);
        c.d(c.this).setVisibility(8);
        a.a(this, "com/tencent/mm/plugin/fav/ui/widget/FavHeaderView$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(107521);
      }
    });
    this.ApD = localView;
    addView(this.ApB, new LinearLayout.LayoutParams(paramContext));
    addView(this.ApC, new LinearLayout.LayoutParams(paramContext));
    addView(this.ApD, new LinearLayout.LayoutParams(paramContext));
    AppMethodBeat.o(107522);
  }
  
  private void MO(int paramInt)
  {
    AppMethodBeat.i(107524);
    this.ApH = paramInt;
    Log.i("MicroMsg.FavHeaderView", "showStatusBar status:".concat(String.valueOf(paramInt)));
    if (paramInt == 0)
    {
      this.ApD.setVisibility(8);
      this.ApC.setVisibility(8);
      AppMethodBeat.o(107524);
      return;
    }
    if (paramInt == 1)
    {
      if (!this.ApF) {
        com.tencent.mm.plugin.report.service.h.OAn.b(14109, new Object[] { Integer.valueOf(1) });
      }
      this.ApF = true;
      this.ApD.setVisibility(8);
      this.ApC.setVisibility(0);
      this.ApC.findViewById(q.e.oldversion_title_full).setVisibility(0);
      this.ApC.findViewById(q.e.oldversion_title_support).setVisibility(8);
      AppMethodBeat.o(107524);
      return;
    }
    if (paramInt == 2)
    {
      this.ApD.setVisibility(0);
      this.ApC.setVisibility(8);
      AppMethodBeat.o(107524);
      return;
    }
    if (paramInt == 3)
    {
      if (!this.ApG) {
        com.tencent.mm.plugin.report.service.h.OAn.b(14109, new Object[] { Integer.valueOf(0) });
      }
      this.ApG = true;
      this.ApD.setVisibility(8);
      this.ApC.setVisibility(0);
      this.ApC.findViewById(q.e.oldversion_title_full).setVisibility(8);
      this.ApC.findViewById(q.e.oldversion_title_support).setVisibility(0);
    }
    AppMethodBeat.o(107524);
  }
  
  public final void dSP()
  {
    AppMethodBeat.i(107525);
    List localList = ((ah)com.tencent.mm.kernel.h.az(ah.class)).getFavItemInfoStorage().dQL();
    long l;
    int i;
    if (localList != null)
    {
      Iterator localIterator = localList.iterator();
      l = 0L;
      for (i = 0; localIterator.hasNext(); i = 1) {
        l = com.tencent.mm.plugin.fav.a.b.a((g)localIterator.next()) + l;
      }
      Log.i("MicroMsg.FavHeaderView", "triggerStatusBar uploadFailedItemList size:%d,totalSize:%d", new Object[] { Integer.valueOf(localList.size()), Long.valueOf(l) });
    }
    for (;;)
    {
      if (i != 0)
      {
        if (l > com.tencent.mm.plugin.fav.a.b.dPY())
        {
          MO(1);
          AppMethodBeat.o(107525);
          return;
        }
        MO(2);
        AppMethodBeat.o(107525);
        return;
      }
      if (com.tencent.mm.plugin.fav.a.b.dQb())
      {
        MO(3);
        AppMethodBeat.o(107525);
        return;
      }
      MO(0);
      AppMethodBeat.o(107525);
      return;
      l = 0L;
      i = 0;
    }
  }
  
  public final void px(boolean paramBoolean)
  {
    AppMethodBeat.i(107523);
    View localView = this.ApB;
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
    this.ApE = parama;
  }
  
  public static abstract interface a
  {
    public abstract void dSa();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.ui.widget.c
 * JD-Core Version:    0.7.0.1
 */