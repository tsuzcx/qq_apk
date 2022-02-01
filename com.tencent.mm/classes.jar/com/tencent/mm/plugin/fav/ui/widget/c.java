package com.tencent.mm.plugin.fav.ui.widget;

import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.plugin.fav.a.ag;
import com.tencent.mm.plugin.fav.a.g;
import com.tencent.mm.plugin.fav.a.y;
import com.tencent.mm.plugin.fav.ui.s.e;
import com.tencent.mm.plugin.fav.ui.s.f;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.Iterator;
import java.util.List;

public final class c
  extends LinearLayout
{
  private View wSY;
  public View wSZ;
  public View wTa;
  private a wTb;
  private boolean wTc;
  private boolean wTd;
  private int wTe;
  
  public c(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(107522);
    this.wTc = false;
    this.wTd = false;
    setOrientation(1);
    paramContext = new LinearLayout.LayoutParams(-1, -2);
    this.wSY = View.inflate(getContext(), s.f.fav_oldversion_bar, null);
    View localView = View.inflate(getContext(), s.f.fav_full_bar, null);
    localView.findViewById(s.e.oldversion_container).setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(107520);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bn(paramAnonymousView);
        a.c("com/tencent/mm/plugin/fav/ui/widget/FavHeaderView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
        if ((c.a(c.this) == 1) || (c.a(c.this) == 3))
        {
          Log.i("MicroMsg.FavHeaderView", "click clear fav item");
          if (c.b(c.this) != null) {
            c.b(c.this).dlk();
          }
        }
        a.a(this, "com/tencent/mm/plugin/fav/ui/widget/FavHeaderView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(107520);
      }
    });
    this.wSZ = localView;
    localView = View.inflate(getContext(), s.f.fav_netwarn_bar, null);
    localView.findViewById(s.e.fav_warn_retry_btn).setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(107521);
        Object localObject = new com.tencent.mm.hellhoundlib.b.b();
        ((com.tencent.mm.hellhoundlib.b.b)localObject).bn(paramAnonymousView);
        a.c("com/tencent/mm/plugin/fav/ui/widget/FavHeaderView$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).aFi());
        Log.i("MicroMsg.FavHeaderView", "click retry item");
        paramAnonymousView = ((ag)com.tencent.mm.kernel.h.ag(ag.class)).getFavItemInfoStorage().dkb();
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
          if (!((g)localObject).djE()) {
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
    this.wTa = localView;
    addView(this.wSY, new LinearLayout.LayoutParams(paramContext));
    addView(this.wSZ, new LinearLayout.LayoutParams(paramContext));
    addView(this.wTa, new LinearLayout.LayoutParams(paramContext));
    AppMethodBeat.o(107522);
  }
  
  private void LR(int paramInt)
  {
    AppMethodBeat.i(107524);
    this.wTe = paramInt;
    Log.i("MicroMsg.FavHeaderView", "showStatusBar status:".concat(String.valueOf(paramInt)));
    if (paramInt == 0)
    {
      this.wTa.setVisibility(8);
      this.wSZ.setVisibility(8);
      AppMethodBeat.o(107524);
      return;
    }
    if (paramInt == 1)
    {
      if (!this.wTc) {
        com.tencent.mm.plugin.report.service.h.IzE.a(14109, new Object[] { Integer.valueOf(1) });
      }
      this.wTc = true;
      this.wTa.setVisibility(8);
      this.wSZ.setVisibility(0);
      this.wSZ.findViewById(s.e.oldversion_title_full).setVisibility(0);
      this.wSZ.findViewById(s.e.oldversion_title_support).setVisibility(8);
      AppMethodBeat.o(107524);
      return;
    }
    if (paramInt == 2)
    {
      this.wTa.setVisibility(0);
      this.wSZ.setVisibility(8);
      AppMethodBeat.o(107524);
      return;
    }
    if (paramInt == 3)
    {
      if (!this.wTd) {
        com.tencent.mm.plugin.report.service.h.IzE.a(14109, new Object[] { Integer.valueOf(0) });
      }
      this.wTd = true;
      this.wTa.setVisibility(8);
      this.wSZ.setVisibility(0);
      this.wSZ.findViewById(s.e.oldversion_title_full).setVisibility(8);
      this.wSZ.findViewById(s.e.oldversion_title_support).setVisibility(0);
    }
    AppMethodBeat.o(107524);
  }
  
  public final void dlZ()
  {
    AppMethodBeat.i(107525);
    List localList = ((ag)com.tencent.mm.kernel.h.ag(ag.class)).getFavItemInfoStorage().dkb();
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
        if (l > com.tencent.mm.plugin.fav.a.b.djn())
        {
          LR(1);
          AppMethodBeat.o(107525);
          return;
        }
        LR(2);
        AppMethodBeat.o(107525);
        return;
      }
      if (com.tencent.mm.plugin.fav.a.b.djq())
      {
        LR(3);
        AppMethodBeat.o(107525);
        return;
      }
      LR(0);
      AppMethodBeat.o(107525);
      return;
      l = 0L;
      i = 0;
    }
  }
  
  public final void nX(boolean paramBoolean)
  {
    AppMethodBeat.i(107523);
    View localView = this.wSY;
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
    this.wTb = parama;
  }
  
  public static abstract interface a
  {
    public abstract void dlk();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.ui.widget.c
 * JD-Core Version:    0.7.0.1
 */