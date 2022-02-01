package com.tencent.mm.plugin.appbrand.widget.input.panel;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ce.e;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;

public final class b
  extends a
{
  private static final int owR;
  private static final int owS;
  
  static
  {
    AppMethodBeat.i(49928);
    owR = com.tencent.mm.cb.a.fromDPToPix(MMApplicationContext.getContext(), 48);
    owS = com.tencent.mm.cb.a.fromDPToPix(MMApplicationContext.getContext(), 43);
    AppMethodBeat.o(49928);
  }
  
  private int cci()
  {
    AppMethodBeat.i(49922);
    c localc = this.owP;
    if (localc.oxi <= 1) {
      localc.oxi = c.ccp()[0];
    }
    int i = localc.oxi;
    AppMethodBeat.o(49922);
    return i;
  }
  
  public final View Ap(int paramInt)
  {
    AppMethodBeat.i(49921);
    Object localObject1 = this.owO;
    Object localObject2 = this.owP;
    d locald = new d();
    locald.mIndex = paramInt;
    locald.oxj = this;
    locald.mContext = ((Context)localObject1);
    locald.owP = ((c)localObject2);
    if ((locald.mContext == null) || (locald.oxj == null))
    {
      AppMethodBeat.o(49921);
      return null;
    }
    localObject1 = View.inflate(locald.mContext, 2131493149, null);
    if ((localObject1 instanceof AppBrandSmileyGrid))
    {
      ((AppBrandSmileyGrid)localObject1).setPanelManager(locald.owP);
      localObject2 = (AppBrandSmileyGrid)localObject1;
      paramInt = locald.mIndex;
      int i = locald.oxj.ccf();
      int j = locald.oxj.ccg();
      int k = locald.oxj.cch();
      int m = locald.oxj.getRowCount();
      int n = locald.oxj.getRowSpacing();
      ((AppBrandSmileyGrid)localObject2).setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
      ((AppBrandSmileyGrid)localObject2).setBackgroundResource(0);
      ((AppBrandSmileyGrid)localObject2).setStretchMode(2);
      ((AppBrandSmileyGrid)localObject2).setOnItemClickListener(((AppBrandSmileyGrid)localObject2).awr);
      ((AppBrandSmileyGrid)localObject2).owW = paramInt;
      ((AppBrandSmileyGrid)localObject2).owU = i;
      ((AppBrandSmileyGrid)localObject2).owV = j;
      ((AppBrandSmileyGrid)localObject2).owX = n;
      ((AppBrandSmileyGrid)localObject2).owY = k;
      ((AppBrandSmileyGrid)localObject2).gOF = m;
      ((AppBrandSmileyGrid)localObject2).setNumColumns(k);
      i = ((AppBrandSmileyGrid)localObject2).getRowSpacing();
      j = com.tencent.mm.cb.a.fromDPToPix(((AppBrandSmileyGrid)localObject2).getContext(), 6);
      k = com.tencent.mm.cb.a.fromDPToPix(((AppBrandSmileyGrid)localObject2).getContext(), 6);
      paramInt = i;
      if (i == 0) {
        paramInt = com.tencent.mm.cb.a.fromDPToPix(((AppBrandSmileyGrid)localObject2).getContext(), 6);
      }
      ((AppBrandSmileyGrid)localObject2).setPadding(j, paramInt, k, 0);
      ((AppBrandSmileyGrid)localObject2).owT = new AppBrandSmileyGrid.a((AppBrandSmileyGrid)localObject2, (byte)0);
      ((AppBrandSmileyGrid)localObject2).setAdapter(((AppBrandSmileyGrid)localObject2).owT);
      ((AppBrandSmileyGrid)localObject2).owT.notifyDataSetChanged();
    }
    AppMethodBeat.o(49921);
    return localObject1;
  }
  
  public final int ccf()
  {
    AppMethodBeat.i(49923);
    int i = this.owP.cbY().cca();
    AppMethodBeat.o(49923);
    return i;
  }
  
  public final int ccg()
  {
    AppMethodBeat.i(49924);
    int i = cch();
    int j = getRowCount();
    AppMethodBeat.o(49924);
    return i * j;
  }
  
  public final int cch()
  {
    AppMethodBeat.i(49926);
    if (this.owP.oxd)
    {
      AppMethodBeat.o(49926);
      return 7;
    }
    int i = cci() / owS;
    AppMethodBeat.o(49926);
    return i;
  }
  
  public final int getPageCount()
  {
    AppMethodBeat.i(49925);
    if (ccg() <= 0)
    {
      AppMethodBeat.o(49925);
      return 0;
    }
    int i = ccf();
    int j = ccg();
    i = (int)Math.ceil(i / j);
    AppMethodBeat.o(49925);
    return i;
  }
  
  public final int getRowCount()
  {
    int i = 3;
    int j = this.owP.oxh / owR;
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
    int i = (this.owP.oxh - owR * getRowCount()) / (getRowCount() + 1);
    AppMethodBeat.o(49927);
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.input.panel.b
 * JD-Core Version:    0.7.0.1
 */