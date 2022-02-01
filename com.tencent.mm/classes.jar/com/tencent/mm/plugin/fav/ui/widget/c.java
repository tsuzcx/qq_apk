package com.tencent.mm.plugin.fav.ui.widget;

import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.fav.a.af;
import com.tencent.mm.plugin.fav.a.b;
import com.tencent.mm.plugin.fav.a.x;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.ad;
import java.util.Iterator;
import java.util.List;

public final class c
  extends LinearLayout
{
  private View qlN;
  public View qlO;
  public View qlP;
  private a qlQ;
  private boolean qlR;
  private boolean qlS;
  private int qlT;
  
  public c(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(107522);
    this.qlR = false;
    this.qlS = false;
    setOrientation(1);
    paramContext = new LinearLayout.LayoutParams(-1, -2);
    this.qlN = View.inflate(getContext(), 2131493972, null);
    View localView = View.inflate(getContext(), 2131493949, null);
    localView.findViewById(2131303002).setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(107520);
        if ((c.a(c.this) == 1) || (c.a(c.this) == 3))
        {
          ad.i("MicroMsg.FavHeaderView", "click clear fav item");
          if (c.b(c.this) != null) {
            c.b(c.this).cjh();
          }
        }
        AppMethodBeat.o(107520);
      }
    });
    this.qlO = localView;
    localView = View.inflate(getContext(), 2131493970, null);
    localView.findViewById(2131299857).setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(107521);
        ad.i("MicroMsg.FavHeaderView", "click retry item");
        paramAnonymousView = ((af)com.tencent.mm.kernel.g.ad(af.class)).getFavItemInfoStorage().cie();
        if ((paramAnonymousView == null) || (paramAnonymousView.isEmpty()))
        {
          AppMethodBeat.o(107521);
          return;
        }
        paramAnonymousView = paramAnonymousView.iterator();
        while (paramAnonymousView.hasNext())
        {
          com.tencent.mm.plugin.fav.a.g localg = (com.tencent.mm.plugin.fav.a.g)paramAnonymousView.next();
          if (!localg.isUploadFailed()) {
            ad.w("MicroMsg.FavHeaderView", "item id is %d, status is not upload fail", new Object[] { Integer.valueOf(localg.field_id) });
          } else {
            b.l(localg);
          }
        }
        c.c(c.this).setVisibility(8);
        c.d(c.this).setVisibility(8);
        AppMethodBeat.o(107521);
      }
    });
    this.qlP = localView;
    addView(this.qlN, new LinearLayout.LayoutParams(paramContext));
    addView(this.qlO, new LinearLayout.LayoutParams(paramContext));
    addView(this.qlP, new LinearLayout.LayoutParams(paramContext));
    AppMethodBeat.o(107522);
  }
  
  private void Cv(int paramInt)
  {
    AppMethodBeat.i(107524);
    this.qlT = paramInt;
    ad.i("MicroMsg.FavHeaderView", "showStatusBar status:".concat(String.valueOf(paramInt)));
    if (paramInt == 0)
    {
      this.qlP.setVisibility(8);
      this.qlO.setVisibility(8);
      AppMethodBeat.o(107524);
      return;
    }
    if (paramInt == 1)
    {
      if (!this.qlR) {
        h.vKh.f(14109, new Object[] { Integer.valueOf(1) });
      }
      this.qlR = true;
      this.qlP.setVisibility(8);
      this.qlO.setVisibility(0);
      this.qlO.findViewById(2131303006).setVisibility(0);
      this.qlO.findViewById(2131303007).setVisibility(8);
      AppMethodBeat.o(107524);
      return;
    }
    if (paramInt == 2)
    {
      this.qlP.setVisibility(0);
      this.qlO.setVisibility(8);
      AppMethodBeat.o(107524);
      return;
    }
    if (paramInt == 3)
    {
      if (!this.qlS) {
        h.vKh.f(14109, new Object[] { Integer.valueOf(0) });
      }
      this.qlS = true;
      this.qlP.setVisibility(8);
      this.qlO.setVisibility(0);
      this.qlO.findViewById(2131303006).setVisibility(8);
      this.qlO.findViewById(2131303007).setVisibility(0);
    }
    AppMethodBeat.o(107524);
  }
  
  public final void cjU()
  {
    AppMethodBeat.i(107525);
    List localList = ((af)com.tencent.mm.kernel.g.ad(af.class)).getFavItemInfoStorage().cie();
    long l;
    int i;
    if (localList != null)
    {
      Iterator localIterator = localList.iterator();
      l = 0L;
      for (i = 0; localIterator.hasNext(); i = 1) {
        l = b.a((com.tencent.mm.plugin.fav.a.g)localIterator.next()) + l;
      }
      ad.i("MicroMsg.FavHeaderView", "triggerStatusBar uploadFailedItemList size:%d,totalSize:%d", new Object[] { Integer.valueOf(localList.size()), Long.valueOf(l) });
    }
    for (;;)
    {
      if (i != 0)
      {
        if (l > b.chr())
        {
          Cv(1);
          AppMethodBeat.o(107525);
          return;
        }
        Cv(2);
        AppMethodBeat.o(107525);
        return;
      }
      if (b.chu())
      {
        Cv(3);
        AppMethodBeat.o(107525);
        return;
      }
      Cv(0);
      AppMethodBeat.o(107525);
      return;
      l = 0L;
      i = 0;
    }
  }
  
  public final void kK(boolean paramBoolean)
  {
    AppMethodBeat.i(107523);
    View localView = this.qlN;
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
    this.qlQ = parama;
  }
  
  public static abstract interface a
  {
    public abstract void cjh();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.ui.widget.c
 * JD-Core Version:    0.7.0.1
 */