package com.tencent.mm.plugin.appbrand.widget.input.panel;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cd.e;
import com.tencent.mm.sdk.platformtools.ah;

public final class b
  extends a
{
  private static final int jpM;
  private static final int jpN;
  
  static
  {
    AppMethodBeat.i(134306);
    jpM = com.tencent.mm.cb.a.fromDPToPix(ah.getContext(), 48);
    jpN = com.tencent.mm.cb.a.fromDPToPix(ah.getContext(), 43);
    AppMethodBeat.o(134306);
  }
  
  private int aRI()
  {
    AppMethodBeat.i(134300);
    c localc = this.jpK;
    if (localc.jqf <= 1) {
      localc.jqf = c.aMu()[0];
    }
    int i = localc.jqf;
    AppMethodBeat.o(134300);
    return i;
  }
  
  public final int aRF()
  {
    AppMethodBeat.i(134301);
    int i = this.jpK.aRy().aRA();
    AppMethodBeat.o(134301);
    return i;
  }
  
  public final int aRG()
  {
    AppMethodBeat.i(134302);
    int i = aRH();
    int j = getRowCount();
    AppMethodBeat.o(134302);
    return i * j;
  }
  
  public final int aRH()
  {
    AppMethodBeat.i(134304);
    if (this.jpK.jqa)
    {
      AppMethodBeat.o(134304);
      return 7;
    }
    int i = aRI() / jpN;
    AppMethodBeat.o(134304);
    return i;
  }
  
  public final int getPageCount()
  {
    AppMethodBeat.i(134303);
    if (aRG() <= 0)
    {
      AppMethodBeat.o(134303);
      return 0;
    }
    int i = aRF();
    int j = aRG();
    i = (int)Math.ceil(i / j);
    AppMethodBeat.o(134303);
    return i;
  }
  
  public final int getRowCount()
  {
    int i = 3;
    int j = this.jpK.jqe / jpM;
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
    AppMethodBeat.i(134305);
    int i = (this.jpK.jqe - jpM * getRowCount()) / (getRowCount() + 1);
    AppMethodBeat.o(134305);
    return i;
  }
  
  public final View qE(int paramInt)
  {
    AppMethodBeat.i(134299);
    Object localObject1 = this.jpJ;
    Object localObject2 = this.jpK;
    d locald = new d();
    locald.mIndex = paramInt;
    locald.jqg = this;
    locald.mContext = ((Context)localObject1);
    locald.jpK = ((c)localObject2);
    if ((locald.mContext == null) || (locald.jqg == null))
    {
      AppMethodBeat.o(134299);
      return null;
    }
    localObject1 = View.inflate(locald.mContext, 2130968778, null);
    if ((localObject1 instanceof AppBrandSmileyGrid))
    {
      ((AppBrandSmileyGrid)localObject1).setPanelManager(locald.jpK);
      localObject2 = (AppBrandSmileyGrid)localObject1;
      paramInt = locald.mIndex;
      int i = locald.jqg.aRF();
      int j = locald.jqg.aRG();
      int k = locald.jqg.aRH();
      int m = locald.jqg.getRowCount();
      int n = locald.jqg.getRowSpacing();
      ((AppBrandSmileyGrid)localObject2).setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
      ((AppBrandSmileyGrid)localObject2).setBackgroundResource(0);
      ((AppBrandSmileyGrid)localObject2).setStretchMode(2);
      ((AppBrandSmileyGrid)localObject2).setOnItemClickListener(((AppBrandSmileyGrid)localObject2).amh);
      ((AppBrandSmileyGrid)localObject2).jpR = paramInt;
      ((AppBrandSmileyGrid)localObject2).jpP = i;
      ((AppBrandSmileyGrid)localObject2).jpQ = j;
      ((AppBrandSmileyGrid)localObject2).jpS = n;
      ((AppBrandSmileyGrid)localObject2).jpT = k;
      ((AppBrandSmileyGrid)localObject2).jpU = m;
      ((AppBrandSmileyGrid)localObject2).setNumColumns(k);
      i = ((AppBrandSmileyGrid)localObject2).getRowSpacing();
      j = com.tencent.mm.cb.a.fromDPToPix(((AppBrandSmileyGrid)localObject2).getContext(), 6);
      k = com.tencent.mm.cb.a.fromDPToPix(((AppBrandSmileyGrid)localObject2).getContext(), 6);
      paramInt = i;
      if (i == 0) {
        paramInt = com.tencent.mm.cb.a.fromDPToPix(((AppBrandSmileyGrid)localObject2).getContext(), 6);
      }
      ((AppBrandSmileyGrid)localObject2).setPadding(j, paramInt, k, 0);
      ((AppBrandSmileyGrid)localObject2).jpO = new AppBrandSmileyGrid.a((AppBrandSmileyGrid)localObject2, (byte)0);
      ((AppBrandSmileyGrid)localObject2).setAdapter(((AppBrandSmileyGrid)localObject2).jpO);
      ((AppBrandSmileyGrid)localObject2).jpO.notifyDataSetChanged();
    }
    AppMethodBeat.o(134299);
    return localObject1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.input.panel.b
 * JD-Core Version:    0.7.0.1
 */