package com.tencent.mm.plugin.appbrand.widget.input.panel;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ce.e;
import com.tencent.mm.sdk.platformtools.ak;

public final class b
  extends a
{
  private static final int nnk;
  private static final int nnl;
  
  static
  {
    AppMethodBeat.i(49928);
    nnk = com.tencent.mm.cb.a.fromDPToPix(ak.getContext(), 48);
    nnl = com.tencent.mm.cb.a.fromDPToPix(ak.getContext(), 43);
    AppMethodBeat.o(49928);
  }
  
  private int bFS()
  {
    AppMethodBeat.i(49922);
    c localc = this.nni;
    if (localc.nnC <= 1) {
      localc.nnC = c.bFZ()[0];
    }
    int i = localc.nnC;
    AppMethodBeat.o(49922);
    return i;
  }
  
  public final int bFP()
  {
    AppMethodBeat.i(49923);
    int i = this.nni.bFI().bFK();
    AppMethodBeat.o(49923);
    return i;
  }
  
  public final int bFQ()
  {
    AppMethodBeat.i(49924);
    int i = bFR();
    int j = getRowCount();
    AppMethodBeat.o(49924);
    return i * j;
  }
  
  public final int bFR()
  {
    AppMethodBeat.i(49926);
    if (this.nni.nnx)
    {
      AppMethodBeat.o(49926);
      return 7;
    }
    int i = bFS() / nnl;
    AppMethodBeat.o(49926);
    return i;
  }
  
  public final int getPageCount()
  {
    AppMethodBeat.i(49925);
    if (bFQ() <= 0)
    {
      AppMethodBeat.o(49925);
      return 0;
    }
    int i = bFP();
    int j = bFQ();
    i = (int)Math.ceil(i / j);
    AppMethodBeat.o(49925);
    return i;
  }
  
  public final int getRowCount()
  {
    int i = 3;
    int j = this.nni.nnB / nnk;
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
    int i = (this.nni.nnB - nnk * getRowCount()) / (getRowCount() + 1);
    AppMethodBeat.o(49927);
    return i;
  }
  
  public final View wH(int paramInt)
  {
    AppMethodBeat.i(49921);
    Object localObject1 = this.nnh;
    Object localObject2 = this.nni;
    d locald = new d();
    locald.mIndex = paramInt;
    locald.nnD = this;
    locald.mContext = ((Context)localObject1);
    locald.nni = ((c)localObject2);
    if ((locald.mContext == null) || (locald.nnD == null))
    {
      AppMethodBeat.o(49921);
      return null;
    }
    localObject1 = View.inflate(locald.mContext, 2131493107, null);
    if ((localObject1 instanceof AppBrandSmileyGrid))
    {
      ((AppBrandSmileyGrid)localObject1).setPanelManager(locald.nni);
      localObject2 = (AppBrandSmileyGrid)localObject1;
      paramInt = locald.mIndex;
      int i = locald.nnD.bFP();
      int j = locald.nnD.bFQ();
      int k = locald.nnD.bFR();
      int m = locald.nnD.getRowCount();
      int n = locald.nnD.getRowSpacing();
      ((AppBrandSmileyGrid)localObject2).setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
      ((AppBrandSmileyGrid)localObject2).setBackgroundResource(0);
      ((AppBrandSmileyGrid)localObject2).setStretchMode(2);
      ((AppBrandSmileyGrid)localObject2).setOnItemClickListener(((AppBrandSmileyGrid)localObject2).awt);
      ((AppBrandSmileyGrid)localObject2).nnp = paramInt;
      ((AppBrandSmileyGrid)localObject2).nnn = i;
      ((AppBrandSmileyGrid)localObject2).nno = j;
      ((AppBrandSmileyGrid)localObject2).nnq = n;
      ((AppBrandSmileyGrid)localObject2).nnr = k;
      ((AppBrandSmileyGrid)localObject2).nns = m;
      ((AppBrandSmileyGrid)localObject2).setNumColumns(k);
      i = ((AppBrandSmileyGrid)localObject2).getRowSpacing();
      j = com.tencent.mm.cb.a.fromDPToPix(((AppBrandSmileyGrid)localObject2).getContext(), 6);
      k = com.tencent.mm.cb.a.fromDPToPix(((AppBrandSmileyGrid)localObject2).getContext(), 6);
      paramInt = i;
      if (i == 0) {
        paramInt = com.tencent.mm.cb.a.fromDPToPix(((AppBrandSmileyGrid)localObject2).getContext(), 6);
      }
      ((AppBrandSmileyGrid)localObject2).setPadding(j, paramInt, k, 0);
      ((AppBrandSmileyGrid)localObject2).nnm = new AppBrandSmileyGrid.a((AppBrandSmileyGrid)localObject2, (byte)0);
      ((AppBrandSmileyGrid)localObject2).setAdapter(((AppBrandSmileyGrid)localObject2).nnm);
      ((AppBrandSmileyGrid)localObject2).nnm.notifyDataSetChanged();
    }
    AppMethodBeat.o(49921);
    return localObject1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.input.panel.b
 * JD-Core Version:    0.7.0.1
 */