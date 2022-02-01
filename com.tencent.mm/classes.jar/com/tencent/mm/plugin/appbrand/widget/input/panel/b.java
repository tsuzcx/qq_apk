package com.tencent.mm.plugin.appbrand.widget.input.panel;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cf.e;
import com.tencent.mm.sdk.platformtools.ai;

public final class b
  extends a
{
  private static final int mHE;
  private static final int mHF;
  
  static
  {
    AppMethodBeat.i(49928);
    mHE = com.tencent.mm.cc.a.fromDPToPix(ai.getContext(), 48);
    mHF = com.tencent.mm.cc.a.fromDPToPix(ai.getContext(), 43);
    AppMethodBeat.o(49928);
  }
  
  private int bAY()
  {
    AppMethodBeat.i(49922);
    c localc = this.mHC;
    if (localc.mHW <= 1) {
      localc.mHW = c.bBf()[0];
    }
    int i = localc.mHW;
    AppMethodBeat.o(49922);
    return i;
  }
  
  public final int bAV()
  {
    AppMethodBeat.i(49923);
    int i = this.mHC.bAO().bAQ();
    AppMethodBeat.o(49923);
    return i;
  }
  
  public final int bAW()
  {
    AppMethodBeat.i(49924);
    int i = bAX();
    int j = getRowCount();
    AppMethodBeat.o(49924);
    return i * j;
  }
  
  public final int bAX()
  {
    AppMethodBeat.i(49926);
    if (this.mHC.mHR)
    {
      AppMethodBeat.o(49926);
      return 7;
    }
    int i = bAY() / mHF;
    AppMethodBeat.o(49926);
    return i;
  }
  
  public final int getPageCount()
  {
    AppMethodBeat.i(49925);
    if (bAW() <= 0)
    {
      AppMethodBeat.o(49925);
      return 0;
    }
    int i = bAV();
    int j = bAW();
    i = (int)Math.ceil(i / j);
    AppMethodBeat.o(49925);
    return i;
  }
  
  public final int getRowCount()
  {
    int i = 3;
    int j = this.mHC.mHV / mHE;
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
    int i = (this.mHC.mHV - mHE * getRowCount()) / (getRowCount() + 1);
    AppMethodBeat.o(49927);
    return i;
  }
  
  public final View vX(int paramInt)
  {
    AppMethodBeat.i(49921);
    Object localObject1 = this.mHB;
    Object localObject2 = this.mHC;
    d locald = new d();
    locald.mIndex = paramInt;
    locald.mHX = this;
    locald.mContext = ((Context)localObject1);
    locald.mHC = ((c)localObject2);
    if ((locald.mContext == null) || (locald.mHX == null))
    {
      AppMethodBeat.o(49921);
      return null;
    }
    localObject1 = View.inflate(locald.mContext, 2131493107, null);
    if ((localObject1 instanceof AppBrandSmileyGrid))
    {
      ((AppBrandSmileyGrid)localObject1).setPanelManager(locald.mHC);
      localObject2 = (AppBrandSmileyGrid)localObject1;
      paramInt = locald.mIndex;
      int i = locald.mHX.bAV();
      int j = locald.mHX.bAW();
      int k = locald.mHX.bAX();
      int m = locald.mHX.getRowCount();
      int n = locald.mHX.getRowSpacing();
      ((AppBrandSmileyGrid)localObject2).setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
      ((AppBrandSmileyGrid)localObject2).setBackgroundResource(0);
      ((AppBrandSmileyGrid)localObject2).setStretchMode(2);
      ((AppBrandSmileyGrid)localObject2).setOnItemClickListener(((AppBrandSmileyGrid)localObject2).auB);
      ((AppBrandSmileyGrid)localObject2).mHJ = paramInt;
      ((AppBrandSmileyGrid)localObject2).mHH = i;
      ((AppBrandSmileyGrid)localObject2).mHI = j;
      ((AppBrandSmileyGrid)localObject2).mHK = n;
      ((AppBrandSmileyGrid)localObject2).mHL = k;
      ((AppBrandSmileyGrid)localObject2).mHM = m;
      ((AppBrandSmileyGrid)localObject2).setNumColumns(k);
      i = ((AppBrandSmileyGrid)localObject2).getRowSpacing();
      j = com.tencent.mm.cc.a.fromDPToPix(((AppBrandSmileyGrid)localObject2).getContext(), 6);
      k = com.tencent.mm.cc.a.fromDPToPix(((AppBrandSmileyGrid)localObject2).getContext(), 6);
      paramInt = i;
      if (i == 0) {
        paramInt = com.tencent.mm.cc.a.fromDPToPix(((AppBrandSmileyGrid)localObject2).getContext(), 6);
      }
      ((AppBrandSmileyGrid)localObject2).setPadding(j, paramInt, k, 0);
      ((AppBrandSmileyGrid)localObject2).mHG = new AppBrandSmileyGrid.a((AppBrandSmileyGrid)localObject2, (byte)0);
      ((AppBrandSmileyGrid)localObject2).setAdapter(((AppBrandSmileyGrid)localObject2).mHG);
      ((AppBrandSmileyGrid)localObject2).mHG.notifyDataSetChanged();
    }
    AppMethodBeat.o(49921);
    return localObject1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.input.panel.b
 * JD-Core Version:    0.7.0.1
 */