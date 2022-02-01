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
import com.tencent.mm.sdk.platformtools.ac;
import java.util.Iterator;
import java.util.List;

public final class c
  extends LinearLayout
{
  private View qUp;
  public View qUq;
  public View qUr;
  private a qUs;
  private boolean qUt;
  private boolean qUu;
  private int qUv;
  
  public c(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(107522);
    this.qUt = false;
    this.qUu = false;
    setOrientation(1);
    paramContext = new LinearLayout.LayoutParams(-1, -2);
    this.qUp = View.inflate(getContext(), 2131493972, null);
    View localView = View.inflate(getContext(), 2131493949, null);
    localView.findViewById(2131303002).setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(107520);
        if ((c.a(c.this) == 1) || (c.a(c.this) == 3))
        {
          ac.i("MicroMsg.FavHeaderView", "click clear fav item");
          if (c.b(c.this) != null) {
            c.b(c.this).cqO();
          }
        }
        AppMethodBeat.o(107520);
      }
    });
    this.qUq = localView;
    localView = View.inflate(getContext(), 2131493970, null);
    localView.findViewById(2131299857).setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(107521);
        ac.i("MicroMsg.FavHeaderView", "click retry item");
        paramAnonymousView = ((af)com.tencent.mm.kernel.g.ad(af.class)).getFavItemInfoStorage().cpL();
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
            ac.w("MicroMsg.FavHeaderView", "item id is %d, status is not upload fail", new Object[] { Integer.valueOf(localg.field_id) });
          } else {
            b.l(localg);
          }
        }
        c.c(c.this).setVisibility(8);
        c.d(c.this).setVisibility(8);
        AppMethodBeat.o(107521);
      }
    });
    this.qUr = localView;
    addView(this.qUp, new LinearLayout.LayoutParams(paramContext));
    addView(this.qUq, new LinearLayout.LayoutParams(paramContext));
    addView(this.qUr, new LinearLayout.LayoutParams(paramContext));
    AppMethodBeat.o(107522);
  }
  
  private void Dq(int paramInt)
  {
    AppMethodBeat.i(107524);
    this.qUv = paramInt;
    ac.i("MicroMsg.FavHeaderView", "showStatusBar status:".concat(String.valueOf(paramInt)));
    if (paramInt == 0)
    {
      this.qUr.setVisibility(8);
      this.qUq.setVisibility(8);
      AppMethodBeat.o(107524);
      return;
    }
    if (paramInt == 1)
    {
      if (!this.qUt) {
        h.wUl.f(14109, new Object[] { Integer.valueOf(1) });
      }
      this.qUt = true;
      this.qUr.setVisibility(8);
      this.qUq.setVisibility(0);
      this.qUq.findViewById(2131303006).setVisibility(0);
      this.qUq.findViewById(2131303007).setVisibility(8);
      AppMethodBeat.o(107524);
      return;
    }
    if (paramInt == 2)
    {
      this.qUr.setVisibility(0);
      this.qUq.setVisibility(8);
      AppMethodBeat.o(107524);
      return;
    }
    if (paramInt == 3)
    {
      if (!this.qUu) {
        h.wUl.f(14109, new Object[] { Integer.valueOf(0) });
      }
      this.qUu = true;
      this.qUr.setVisibility(8);
      this.qUq.setVisibility(0);
      this.qUq.findViewById(2131303006).setVisibility(8);
      this.qUq.findViewById(2131303007).setVisibility(0);
    }
    AppMethodBeat.o(107524);
  }
  
  public final void crB()
  {
    AppMethodBeat.i(107525);
    List localList = ((af)com.tencent.mm.kernel.g.ad(af.class)).getFavItemInfoStorage().cpL();
    long l;
    int i;
    if (localList != null)
    {
      Iterator localIterator = localList.iterator();
      l = 0L;
      for (i = 0; localIterator.hasNext(); i = 1) {
        l = b.a((com.tencent.mm.plugin.fav.a.g)localIterator.next()) + l;
      }
      ac.i("MicroMsg.FavHeaderView", "triggerStatusBar uploadFailedItemList size:%d,totalSize:%d", new Object[] { Integer.valueOf(localList.size()), Long.valueOf(l) });
    }
    for (;;)
    {
      if (i != 0)
      {
        if (l > b.coY())
        {
          Dq(1);
          AppMethodBeat.o(107525);
          return;
        }
        Dq(2);
        AppMethodBeat.o(107525);
        return;
      }
      if (b.cpb())
      {
        Dq(3);
        AppMethodBeat.o(107525);
        return;
      }
      Dq(0);
      AppMethodBeat.o(107525);
      return;
      l = 0L;
      i = 0;
    }
  }
  
  public final void lo(boolean paramBoolean)
  {
    AppMethodBeat.i(107523);
    View localView = this.qUp;
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
    this.qUs = parama;
  }
  
  public static abstract interface a
  {
    public abstract void cqO();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.ui.widget.c
 * JD-Core Version:    0.7.0.1
 */