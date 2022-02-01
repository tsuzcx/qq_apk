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
import com.tencent.mm.sdk.platformtools.ae;
import java.util.Iterator;
import java.util.List;

public final class c
  extends LinearLayout
{
  private View rMO;
  public View rMP;
  public View rMQ;
  private a rMR;
  private boolean rMS;
  private boolean rMT;
  private int rMU;
  
  public c(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(107522);
    this.rMS = false;
    this.rMT = false;
    setOrientation(1);
    paramContext = new LinearLayout.LayoutParams(-1, -2);
    this.rMO = View.inflate(getContext(), 2131493972, null);
    View localView = View.inflate(getContext(), 2131493949, null);
    localView.findViewById(2131303002).setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(107520);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bd(paramAnonymousView);
        a.b("com/tencent/mm/plugin/fav/ui/widget/FavHeaderView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
        if ((c.a(c.this) == 1) || (c.a(c.this) == 3))
        {
          ae.i("MicroMsg.FavHeaderView", "click clear fav item");
          if (c.b(c.this) != null) {
            c.b(c.this).cxZ();
          }
        }
        a.a(this, "com/tencent/mm/plugin/fav/ui/widget/FavHeaderView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(107520);
      }
    });
    this.rMP = localView;
    localView = View.inflate(getContext(), 2131493970, null);
    localView.findViewById(2131299857).setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(107521);
        Object localObject = new com.tencent.mm.hellhoundlib.b.b();
        ((com.tencent.mm.hellhoundlib.b.b)localObject).bd(paramAnonymousView);
        a.b("com/tencent/mm/plugin/fav/ui/widget/FavHeaderView$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).ahF());
        ae.i("MicroMsg.FavHeaderView", "click retry item");
        paramAnonymousView = ((af)com.tencent.mm.kernel.g.ad(af.class)).getFavItemInfoStorage().cwR();
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
            ae.w("MicroMsg.FavHeaderView", "item id is %d, status is not upload fail", new Object[] { Integer.valueOf(((com.tencent.mm.plugin.fav.a.g)localObject).field_id) });
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
    this.rMQ = localView;
    addView(this.rMO, new LinearLayout.LayoutParams(paramContext));
    addView(this.rMP, new LinearLayout.LayoutParams(paramContext));
    addView(this.rMQ, new LinearLayout.LayoutParams(paramContext));
    AppMethodBeat.o(107522);
  }
  
  private void Ew(int paramInt)
  {
    AppMethodBeat.i(107524);
    this.rMU = paramInt;
    ae.i("MicroMsg.FavHeaderView", "showStatusBar status:".concat(String.valueOf(paramInt)));
    if (paramInt == 0)
    {
      this.rMQ.setVisibility(8);
      this.rMP.setVisibility(8);
      AppMethodBeat.o(107524);
      return;
    }
    if (paramInt == 1)
    {
      if (!this.rMS) {
        com.tencent.mm.plugin.report.service.g.yxI.f(14109, new Object[] { Integer.valueOf(1) });
      }
      this.rMS = true;
      this.rMQ.setVisibility(8);
      this.rMP.setVisibility(0);
      this.rMP.findViewById(2131303006).setVisibility(0);
      this.rMP.findViewById(2131303007).setVisibility(8);
      AppMethodBeat.o(107524);
      return;
    }
    if (paramInt == 2)
    {
      this.rMQ.setVisibility(0);
      this.rMP.setVisibility(8);
      AppMethodBeat.o(107524);
      return;
    }
    if (paramInt == 3)
    {
      if (!this.rMT) {
        com.tencent.mm.plugin.report.service.g.yxI.f(14109, new Object[] { Integer.valueOf(0) });
      }
      this.rMT = true;
      this.rMQ.setVisibility(8);
      this.rMP.setVisibility(0);
      this.rMP.findViewById(2131303006).setVisibility(8);
      this.rMP.findViewById(2131303007).setVisibility(0);
    }
    AppMethodBeat.o(107524);
  }
  
  public final void cyO()
  {
    AppMethodBeat.i(107525);
    List localList = ((af)com.tencent.mm.kernel.g.ad(af.class)).getFavItemInfoStorage().cwR();
    long l;
    int i;
    if (localList != null)
    {
      Iterator localIterator = localList.iterator();
      l = 0L;
      for (i = 0; localIterator.hasNext(); i = 1) {
        l = com.tencent.mm.plugin.fav.a.b.a((com.tencent.mm.plugin.fav.a.g)localIterator.next()) + l;
      }
      ae.i("MicroMsg.FavHeaderView", "triggerStatusBar uploadFailedItemList size:%d,totalSize:%d", new Object[] { Integer.valueOf(localList.size()), Long.valueOf(l) });
    }
    for (;;)
    {
      if (i != 0)
      {
        if (l > com.tencent.mm.plugin.fav.a.b.cwe())
        {
          Ew(1);
          AppMethodBeat.o(107525);
          return;
        }
        Ew(2);
        AppMethodBeat.o(107525);
        return;
      }
      if (com.tencent.mm.plugin.fav.a.b.cwh())
      {
        Ew(3);
        AppMethodBeat.o(107525);
        return;
      }
      Ew(0);
      AppMethodBeat.o(107525);
      return;
      l = 0L;
      i = 0;
    }
  }
  
  public final void lH(boolean paramBoolean)
  {
    AppMethodBeat.i(107523);
    View localView = this.rMO;
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
    this.rMR = parama;
  }
  
  public static abstract interface a
  {
    public abstract void cxZ();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.ui.widget.c
 * JD-Core Version:    0.7.0.1
 */