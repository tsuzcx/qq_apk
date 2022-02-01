package com.tencent.mm.plugin.appbrand.widget.input.panel;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cf.e;
import com.tencent.mm.sdk.platformtools.aj;

public final class b
  extends a
{
  private static final int nic;
  private static final int nid;
  
  static
  {
    AppMethodBeat.i(49928);
    nic = com.tencent.mm.cc.a.fromDPToPix(aj.getContext(), 48);
    nid = com.tencent.mm.cc.a.fromDPToPix(aj.getContext(), 43);
    AppMethodBeat.o(49928);
  }
  
  private int bFa()
  {
    AppMethodBeat.i(49922);
    c localc = this.nia;
    if (localc.niu <= 1) {
      localc.niu = c.bFh()[0];
    }
    int i = localc.niu;
    AppMethodBeat.o(49922);
    return i;
  }
  
  public final int bEX()
  {
    AppMethodBeat.i(49923);
    int i = this.nia.bEQ().bES();
    AppMethodBeat.o(49923);
    return i;
  }
  
  public final int bEY()
  {
    AppMethodBeat.i(49924);
    int i = bEZ();
    int j = getRowCount();
    AppMethodBeat.o(49924);
    return i * j;
  }
  
  public final int bEZ()
  {
    AppMethodBeat.i(49926);
    if (this.nia.nip)
    {
      AppMethodBeat.o(49926);
      return 7;
    }
    int i = bFa() / nid;
    AppMethodBeat.o(49926);
    return i;
  }
  
  public final int getPageCount()
  {
    AppMethodBeat.i(49925);
    if (bEY() <= 0)
    {
      AppMethodBeat.o(49925);
      return 0;
    }
    int i = bEX();
    int j = bEY();
    i = (int)Math.ceil(i / j);
    AppMethodBeat.o(49925);
    return i;
  }
  
  public final int getRowCount()
  {
    int i = 3;
    int j = this.nia.nit / nic;
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
    int i = (this.nia.nit - nic * getRowCount()) / (getRowCount() + 1);
    AppMethodBeat.o(49927);
    return i;
  }
  
  public final View wC(int paramInt)
  {
    AppMethodBeat.i(49921);
    Object localObject1 = this.nhZ;
    Object localObject2 = this.nia;
    d locald = new d();
    locald.mIndex = paramInt;
    locald.niv = this;
    locald.mContext = ((Context)localObject1);
    locald.nia = ((c)localObject2);
    if ((locald.mContext == null) || (locald.niv == null))
    {
      AppMethodBeat.o(49921);
      return null;
    }
    localObject1 = View.inflate(locald.mContext, 2131493107, null);
    if ((localObject1 instanceof AppBrandSmileyGrid))
    {
      ((AppBrandSmileyGrid)localObject1).setPanelManager(locald.nia);
      localObject2 = (AppBrandSmileyGrid)localObject1;
      paramInt = locald.mIndex;
      int i = locald.niv.bEX();
      int j = locald.niv.bEY();
      int k = locald.niv.bEZ();
      int m = locald.niv.getRowCount();
      int n = locald.niv.getRowSpacing();
      ((AppBrandSmileyGrid)localObject2).setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
      ((AppBrandSmileyGrid)localObject2).setBackgroundResource(0);
      ((AppBrandSmileyGrid)localObject2).setStretchMode(2);
      ((AppBrandSmileyGrid)localObject2).setOnItemClickListener(((AppBrandSmileyGrid)localObject2).awt);
      ((AppBrandSmileyGrid)localObject2).nih = paramInt;
      ((AppBrandSmileyGrid)localObject2).nif = i;
      ((AppBrandSmileyGrid)localObject2).nig = j;
      ((AppBrandSmileyGrid)localObject2).nii = n;
      ((AppBrandSmileyGrid)localObject2).nij = k;
      ((AppBrandSmileyGrid)localObject2).nik = m;
      ((AppBrandSmileyGrid)localObject2).setNumColumns(k);
      i = ((AppBrandSmileyGrid)localObject2).getRowSpacing();
      j = com.tencent.mm.cc.a.fromDPToPix(((AppBrandSmileyGrid)localObject2).getContext(), 6);
      k = com.tencent.mm.cc.a.fromDPToPix(((AppBrandSmileyGrid)localObject2).getContext(), 6);
      paramInt = i;
      if (i == 0) {
        paramInt = com.tencent.mm.cc.a.fromDPToPix(((AppBrandSmileyGrid)localObject2).getContext(), 6);
      }
      ((AppBrandSmileyGrid)localObject2).setPadding(j, paramInt, k, 0);
      ((AppBrandSmileyGrid)localObject2).nie = new AppBrandSmileyGrid.a((AppBrandSmileyGrid)localObject2, (byte)0);
      ((AppBrandSmileyGrid)localObject2).setAdapter(((AppBrandSmileyGrid)localObject2).nie);
      ((AppBrandSmileyGrid)localObject2).nie.notifyDataSetChanged();
    }
    AppMethodBeat.o(49921);
    return localObject1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.input.panel.b
 * JD-Core Version:    0.7.0.1
 */