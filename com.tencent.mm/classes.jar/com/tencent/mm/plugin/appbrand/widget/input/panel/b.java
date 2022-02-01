package com.tencent.mm.plugin.appbrand.widget.input.panel;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cg.e;
import com.tencent.mm.sdk.platformtools.aj;

public final class b
  extends a
{
  private static final int mfF;
  private static final int mfG;
  
  static
  {
    AppMethodBeat.i(49928);
    mfF = com.tencent.mm.cd.a.fromDPToPix(aj.getContext(), 48);
    mfG = com.tencent.mm.cd.a.fromDPToPix(aj.getContext(), 43);
    AppMethodBeat.o(49928);
  }
  
  private int btZ()
  {
    AppMethodBeat.i(49922);
    c localc = this.mfD;
    if (localc.mfX <= 1) {
      localc.mfX = c.bug()[0];
    }
    int i = localc.mfX;
    AppMethodBeat.o(49922);
    return i;
  }
  
  public final int btW()
  {
    AppMethodBeat.i(49923);
    int i = this.mfD.btP().btR();
    AppMethodBeat.o(49923);
    return i;
  }
  
  public final int btX()
  {
    AppMethodBeat.i(49924);
    int i = btY();
    int j = getRowCount();
    AppMethodBeat.o(49924);
    return i * j;
  }
  
  public final int btY()
  {
    AppMethodBeat.i(49926);
    if (this.mfD.mfS)
    {
      AppMethodBeat.o(49926);
      return 7;
    }
    int i = btZ() / mfG;
    AppMethodBeat.o(49926);
    return i;
  }
  
  public final int getPageCount()
  {
    AppMethodBeat.i(49925);
    if (btX() <= 0)
    {
      AppMethodBeat.o(49925);
      return 0;
    }
    int i = btW();
    int j = btX();
    i = (int)Math.ceil(i / j);
    AppMethodBeat.o(49925);
    return i;
  }
  
  public final int getRowCount()
  {
    int i = 3;
    int j = this.mfD.mfW / mfF;
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
    AppMethodBeat.i(49927);
    int i = (this.mfD.mfW - mfF * getRowCount()) / (getRowCount() + 1);
    AppMethodBeat.o(49927);
    return i;
  }
  
  public final View vg(int paramInt)
  {
    AppMethodBeat.i(49921);
    Object localObject1 = this.mfC;
    Object localObject2 = this.mfD;
    d locald = new d();
    locald.mIndex = paramInt;
    locald.mfY = this;
    locald.mContext = ((Context)localObject1);
    locald.mfD = ((c)localObject2);
    if ((locald.mContext == null) || (locald.mfY == null))
    {
      AppMethodBeat.o(49921);
      return null;
    }
    localObject1 = View.inflate(locald.mContext, 2131493107, null);
    if ((localObject1 instanceof AppBrandSmileyGrid))
    {
      ((AppBrandSmileyGrid)localObject1).setPanelManager(locald.mfD);
      localObject2 = (AppBrandSmileyGrid)localObject1;
      paramInt = locald.mIndex;
      int i = locald.mfY.btW();
      int j = locald.mfY.btX();
      int k = locald.mfY.btY();
      int m = locald.mfY.getRowCount();
      int n = locald.mfY.getRowSpacing();
      ((AppBrandSmileyGrid)localObject2).setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
      ((AppBrandSmileyGrid)localObject2).setBackgroundResource(0);
      ((AppBrandSmileyGrid)localObject2).setStretchMode(2);
      ((AppBrandSmileyGrid)localObject2).setOnItemClickListener(((AppBrandSmileyGrid)localObject2).atG);
      ((AppBrandSmileyGrid)localObject2).mfK = paramInt;
      ((AppBrandSmileyGrid)localObject2).mfI = i;
      ((AppBrandSmileyGrid)localObject2).mfJ = j;
      ((AppBrandSmileyGrid)localObject2).mfL = n;
      ((AppBrandSmileyGrid)localObject2).mfM = k;
      ((AppBrandSmileyGrid)localObject2).mfN = m;
      ((AppBrandSmileyGrid)localObject2).setNumColumns(k);
      i = ((AppBrandSmileyGrid)localObject2).getRowSpacing();
      j = com.tencent.mm.cd.a.fromDPToPix(((AppBrandSmileyGrid)localObject2).getContext(), 6);
      k = com.tencent.mm.cd.a.fromDPToPix(((AppBrandSmileyGrid)localObject2).getContext(), 6);
      paramInt = i;
      if (i == 0) {
        paramInt = com.tencent.mm.cd.a.fromDPToPix(((AppBrandSmileyGrid)localObject2).getContext(), 6);
      }
      ((AppBrandSmileyGrid)localObject2).setPadding(j, paramInt, k, 0);
      ((AppBrandSmileyGrid)localObject2).mfH = new AppBrandSmileyGrid.a((AppBrandSmileyGrid)localObject2, (byte)0);
      ((AppBrandSmileyGrid)localObject2).setAdapter(((AppBrandSmileyGrid)localObject2).mfH);
      ((AppBrandSmileyGrid)localObject2).mfH.notifyDataSetChanged();
    }
    AppMethodBeat.o(49921);
    return localObject1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.input.panel.b
 * JD-Core Version:    0.7.0.1
 */