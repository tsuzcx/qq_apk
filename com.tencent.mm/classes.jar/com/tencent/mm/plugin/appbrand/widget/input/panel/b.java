package com.tencent.mm.plugin.appbrand.widget.input.panel;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import com.tencent.mm.cd.e;
import com.tencent.mm.plugin.appbrand.y.h;
import com.tencent.mm.sdk.platformtools.ae;

public final class b
  extends a
{
  private static final int hxC = com.tencent.mm.cb.a.fromDPToPix(ae.getContext(), 48);
  private static final int hxD = com.tencent.mm.cb.a.fromDPToPix(ae.getContext(), 43);
  
  public final int asC()
  {
    return this.hxA.asu().asw();
  }
  
  public final int asD()
  {
    return asE() * getRowCount();
  }
  
  public final int asE()
  {
    if (this.hxA.hxQ) {
      return 7;
    }
    c localc = this.hxA;
    if (localc.hxV <= 1) {
      localc.hxV = c.api()[0];
    }
    return localc.hxV / hxD;
  }
  
  public final int getPageCount()
  {
    if (asD() <= 0) {
      return 0;
    }
    int i = asC();
    int j = asD();
    return (int)Math.ceil(i / j);
  }
  
  public final int getRowCount()
  {
    int i = 3;
    int j = this.hxA.hxU / hxC;
    if (j > 3) {}
    for (;;)
    {
      j = i;
      if (i <= 0) {
        j = 1;
      }
      return j;
      i = j;
    }
  }
  
  public final int getRowSpacing()
  {
    return (this.hxA.hxU - hxC * getRowCount()) / (getRowCount() + 1);
  }
  
  public final View na(int paramInt)
  {
    View localView = null;
    Object localObject = this.hxz;
    c localc = this.hxA;
    d locald = new d();
    locald.mIndex = paramInt;
    locald.hxW = this;
    locald.mContext = ((Context)localObject);
    locald.hxA = localc;
    localObject = localView;
    if (locald.mContext != null)
    {
      if (locald.hxW != null) {
        break label77;
      }
      localObject = localView;
    }
    label77:
    do
    {
      return localObject;
      localView = View.inflate(locald.mContext, y.h.appbrand_smiley_panel_page, null);
      localObject = localView;
    } while (!(localView instanceof AppBrandSmileyGrid));
    ((AppBrandSmileyGrid)localView).setPanelManager(locald.hxA);
    localObject = (AppBrandSmileyGrid)localView;
    paramInt = locald.mIndex;
    int i = locald.hxW.asC();
    int j = locald.hxW.asD();
    int k = locald.hxW.asE();
    int m = locald.hxW.getRowCount();
    int n = locald.hxW.getRowSpacing();
    ((AppBrandSmileyGrid)localObject).setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
    ((AppBrandSmileyGrid)localObject).setBackgroundResource(0);
    ((AppBrandSmileyGrid)localObject).setStretchMode(2);
    ((AppBrandSmileyGrid)localObject).setOnItemClickListener(((AppBrandSmileyGrid)localObject).ajR);
    ((AppBrandSmileyGrid)localObject).hxH = paramInt;
    ((AppBrandSmileyGrid)localObject).hxF = i;
    ((AppBrandSmileyGrid)localObject).hxG = j;
    ((AppBrandSmileyGrid)localObject).hxI = n;
    ((AppBrandSmileyGrid)localObject).hxJ = k;
    ((AppBrandSmileyGrid)localObject).hxK = m;
    ((AppBrandSmileyGrid)localObject).setNumColumns(k);
    i = ((AppBrandSmileyGrid)localObject).getRowSpacing();
    j = com.tencent.mm.cb.a.fromDPToPix(((AppBrandSmileyGrid)localObject).getContext(), 6);
    k = com.tencent.mm.cb.a.fromDPToPix(((AppBrandSmileyGrid)localObject).getContext(), 6);
    paramInt = i;
    if (i == 0) {
      paramInt = com.tencent.mm.cb.a.fromDPToPix(((AppBrandSmileyGrid)localObject).getContext(), 6);
    }
    ((AppBrandSmileyGrid)localObject).setPadding(j, paramInt, k, 0);
    ((AppBrandSmileyGrid)localObject).hxE = new AppBrandSmileyGrid.a((AppBrandSmileyGrid)localObject, (byte)0);
    ((AppBrandSmileyGrid)localObject).setAdapter(((AppBrandSmileyGrid)localObject).hxE);
    ((AppBrandSmileyGrid)localObject).hxE.notifyDataSetChanged();
    return localView;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.input.panel.b
 * JD-Core Version:    0.7.0.1
 */