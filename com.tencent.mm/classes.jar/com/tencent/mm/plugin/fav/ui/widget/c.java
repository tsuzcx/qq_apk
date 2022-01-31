package com.tencent.mm.plugin.fav.ui.widget;

import android.content.Context;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import com.tencent.mm.plugin.fav.a.ae;
import com.tencent.mm.plugin.fav.a.b;
import com.tencent.mm.plugin.fav.a.x;
import com.tencent.mm.plugin.fav.ui.n.e;
import com.tencent.mm.plugin.fav.ui.n.f;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.y;
import java.util.Iterator;
import java.util.List;

public final class c
  extends LinearLayout
{
  private View kjt;
  public View kju;
  public View kjv;
  private c.a kjw;
  private boolean kjx = false;
  private boolean kjy = false;
  private int kjz;
  
  public c(Context paramContext)
  {
    super(paramContext);
    setOrientation(1);
    paramContext = new LinearLayout.LayoutParams(-1, -2);
    this.kjt = View.inflate(getContext(), n.f.fav_oldversion_bar, null);
    View localView = View.inflate(getContext(), n.f.fav_full_bar, null);
    localView.findViewById(n.e.oldversion_container).setOnClickListener(new c.1(this));
    this.kju = localView;
    localView = View.inflate(getContext(), n.f.fav_netwarn_bar, null);
    localView.findViewById(n.e.fav_warn_retry_btn).setOnClickListener(new c.2(this));
    this.kjv = localView;
    addView(this.kjt, new LinearLayout.LayoutParams(paramContext));
    addView(this.kju, new LinearLayout.LayoutParams(paramContext));
    addView(this.kjv, new LinearLayout.LayoutParams(paramContext));
  }
  
  private void rh(int paramInt)
  {
    this.kjz = paramInt;
    y.i("MicroMsg.FavHeaderView", "showStatusBar status:" + paramInt);
    if (paramInt == 0)
    {
      this.kjv.setVisibility(8);
      this.kju.setVisibility(8);
    }
    do
    {
      return;
      if (paramInt == 1)
      {
        if (!this.kjx) {
          h.nFQ.f(14109, new Object[] { Integer.valueOf(1) });
        }
        this.kjx = true;
        this.kjv.setVisibility(8);
        this.kju.setVisibility(0);
        this.kju.findViewById(n.e.oldversion_title_full).setVisibility(0);
        this.kju.findViewById(n.e.oldversion_title_support).setVisibility(8);
        return;
      }
      if (paramInt == 2)
      {
        this.kjv.setVisibility(0);
        this.kju.setVisibility(8);
        return;
      }
    } while (paramInt != 3);
    if (!this.kjy) {
      h.nFQ.f(14109, new Object[] { Integer.valueOf(0) });
    }
    this.kjy = true;
    this.kjv.setVisibility(8);
    this.kju.setVisibility(0);
    this.kju.findViewById(n.e.oldversion_title_full).setVisibility(8);
    this.kju.findViewById(n.e.oldversion_title_support).setVisibility(0);
  }
  
  public final void aSa()
  {
    List localList = ((ae)com.tencent.mm.kernel.g.t(ae.class)).getFavItemInfoStorage().aQz();
    long l;
    int i;
    if (localList != null)
    {
      Iterator localIterator = localList.iterator();
      l = 0L;
      for (i = 0; localIterator.hasNext(); i = 1) {
        l = b.a((com.tencent.mm.plugin.fav.a.g)localIterator.next()) + l;
      }
      y.i("MicroMsg.FavHeaderView", "triggerStatusBar uploadFailedItemList size:%d,totalSize:%d", new Object[] { Integer.valueOf(localList.size()), Long.valueOf(l) });
    }
    for (;;)
    {
      if (i != 0)
      {
        if (l > b.aPL())
        {
          rh(1);
          return;
        }
        rh(2);
        return;
      }
      if (b.aPO())
      {
        rh(3);
        return;
      }
      rh(0);
      return;
      l = 0L;
      i = 0;
    }
  }
  
  public final void gd(boolean paramBoolean)
  {
    View localView = this.kjt;
    if (paramBoolean) {}
    for (int i = 0;; i = 8)
    {
      localView.setVisibility(i);
      return;
    }
  }
  
  public final void setCleanFavSpace(c.a parama)
  {
    this.kjw = parama;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.ui.widget.c
 * JD-Core Version:    0.7.0.1
 */