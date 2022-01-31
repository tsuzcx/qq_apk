package com.tencent.mm.plugin.fav.ui.widget;

import android.content.Context;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.fav.a.ae;
import com.tencent.mm.plugin.fav.a.b;
import com.tencent.mm.plugin.fav.a.x;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.ab;
import java.util.Iterator;
import java.util.List;

public final class c
  extends LinearLayout
{
  private View mDZ;
  public View mEa;
  public View mEb;
  private c.a mEc;
  private boolean mEd;
  private boolean mEe;
  private int mEf;
  
  public c(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(74678);
    this.mEd = false;
    this.mEe = false;
    setOrientation(1);
    paramContext = new LinearLayout.LayoutParams(-1, -2);
    this.mDZ = View.inflate(getContext(), 2130969554, null);
    View localView = View.inflate(getContext(), 2130969533, null);
    localView.findViewById(2131824009).setOnClickListener(new c.1(this));
    this.mEa = localView;
    localView = View.inflate(getContext(), 2130969553, null);
    localView.findViewById(2131824064).setOnClickListener(new c.2(this));
    this.mEb = localView;
    addView(this.mDZ, new LinearLayout.LayoutParams(paramContext));
    addView(this.mEa, new LinearLayout.LayoutParams(paramContext));
    addView(this.mEb, new LinearLayout.LayoutParams(paramContext));
    AppMethodBeat.o(74678);
  }
  
  private void wd(int paramInt)
  {
    AppMethodBeat.i(74680);
    this.mEf = paramInt;
    ab.i("MicroMsg.FavHeaderView", "showStatusBar status:".concat(String.valueOf(paramInt)));
    if (paramInt == 0)
    {
      this.mEb.setVisibility(8);
      this.mEa.setVisibility(8);
      AppMethodBeat.o(74680);
      return;
    }
    if (paramInt == 1)
    {
      if (!this.mEd) {
        h.qsU.e(14109, new Object[] { Integer.valueOf(1) });
      }
      this.mEd = true;
      this.mEb.setVisibility(8);
      this.mEa.setVisibility(0);
      this.mEa.findViewById(2131824012).setVisibility(0);
      this.mEa.findViewById(2131824013).setVisibility(8);
      AppMethodBeat.o(74680);
      return;
    }
    if (paramInt == 2)
    {
      this.mEb.setVisibility(0);
      this.mEa.setVisibility(8);
      AppMethodBeat.o(74680);
      return;
    }
    if (paramInt == 3)
    {
      if (!this.mEe) {
        h.qsU.e(14109, new Object[] { Integer.valueOf(0) });
      }
      this.mEe = true;
      this.mEb.setVisibility(8);
      this.mEa.setVisibility(0);
      this.mEa.findViewById(2131824012).setVisibility(8);
      this.mEa.findViewById(2131824013).setVisibility(0);
    }
    AppMethodBeat.o(74680);
  }
  
  public final void byr()
  {
    AppMethodBeat.i(74681);
    List localList = ((ae)com.tencent.mm.kernel.g.G(ae.class)).getFavItemInfoStorage().bwO();
    long l;
    int i;
    if (localList != null)
    {
      Iterator localIterator = localList.iterator();
      l = 0L;
      for (i = 0; localIterator.hasNext(); i = 1) {
        l = b.a((com.tencent.mm.plugin.fav.a.g)localIterator.next()) + l;
      }
      ab.i("MicroMsg.FavHeaderView", "triggerStatusBar uploadFailedItemList size:%d,totalSize:%d", new Object[] { Integer.valueOf(localList.size()), Long.valueOf(l) });
    }
    for (;;)
    {
      if (i != 0)
      {
        if (l > b.bvZ())
        {
          wd(1);
          AppMethodBeat.o(74681);
          return;
        }
        wd(2);
        AppMethodBeat.o(74681);
        return;
      }
      if (b.bwc())
      {
        wd(3);
        AppMethodBeat.o(74681);
        return;
      }
      wd(0);
      AppMethodBeat.o(74681);
      return;
      l = 0L;
      i = 0;
    }
  }
  
  public final void hE(boolean paramBoolean)
  {
    AppMethodBeat.i(74679);
    View localView = this.mDZ;
    if (paramBoolean) {}
    for (int i = 0;; i = 8)
    {
      localView.setVisibility(i);
      AppMethodBeat.o(74679);
      return;
    }
  }
  
  public final void setCleanFavSpace(c.a parama)
  {
    this.mEc = parama;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.ui.widget.c
 * JD-Core Version:    0.7.0.1
 */