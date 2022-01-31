package com.tencent.mm.plugin.luckymoney.scaledLayout;

import android.content.Context;
import android.support.v7.widget.RecyclerView.i;
import android.support.v7.widget.RecyclerView.r;
import android.support.v7.widget.aj;
import android.support.v7.widget.ak;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;

public final class a
  extends ak
{
  public Context context;
  public View opY;
  
  public static View h(RecyclerView.i parami)
  {
    Object localObject = null;
    AppMethodBeat.i(42467);
    int n = parami.getChildCount();
    if (n == 0)
    {
      AppMethodBeat.o(42467);
      return null;
    }
    aj localaj = aj.d(parami);
    int j;
    int k;
    if (parami.getClipToPadding())
    {
      j = localaj.iI() + localaj.iK() / 2;
      int i = 2147483647;
      k = 0;
      label58:
      if (k >= n) {
        break label126;
      }
      View localView = parami.getChildAt(k);
      int m = Math.abs(localaj.bh(localView) + localaj.bl(localView) / 2 - j);
      if (m >= i) {
        break label134;
      }
      localObject = localView;
      i = m;
    }
    label134:
    for (;;)
    {
      k += 1;
      break label58;
      j = localaj.getEnd() / 2;
      break;
      label126:
      AppMethodBeat.o(42467);
      return localObject;
    }
  }
  
  public final int a(RecyclerView.i parami, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(42466);
    if (parami.getItemCount() == 0)
    {
      AppMethodBeat.o(42466);
      return -1;
    }
    View localView2 = h(parami);
    if (localView2 == null)
    {
      AppMethodBeat.o(42466);
      return -1;
    }
    View localView1 = localView2;
    if (this.opY != null)
    {
      localView1 = localView2;
      if (this.opY != localView2) {
        localView1 = this.opY;
      }
    }
    paramInt2 = RecyclerView.i.bv(localView1);
    ab.d("CusPager", "pos: %s", new Object[] { Integer.valueOf(paramInt2) });
    if ((paramInt1 >= 100) && (paramInt2 + 1 < parami.getItemCount()))
    {
      AppMethodBeat.o(42466);
      return paramInt2 + 1;
    }
    if ((paramInt1 <= -100) && (paramInt2 - 1 >= 0))
    {
      AppMethodBeat.o(42466);
      return paramInt2 - 1;
    }
    AppMethodBeat.o(42466);
    return paramInt2;
  }
  
  public final View a(RecyclerView.i parami)
  {
    AppMethodBeat.i(42465);
    View localView1 = super.a(parami);
    int i = 0;
    int j = 0;
    int k = 0;
    View localView2;
    if (i < parami.getChildCount())
    {
      localView2 = parami.getChildAt(i);
      if (localView2 != localView1) {
        break label118;
      }
      j = i;
    }
    label118:
    for (;;)
    {
      if (localView2 == this.opY) {
        k = i;
      }
      i += 1;
      break;
      if (j - k > 1)
      {
        parami = parami.bH(k + 1);
        AppMethodBeat.o(42465);
        return parami;
      }
      if (j - k < -1)
      {
        parami = parami.bH(k - 1);
        AppMethodBeat.o(42465);
        return parami;
      }
      AppMethodBeat.o(42465);
      return localView1;
    }
  }
  
  public final RecyclerView.r g(RecyclerView.i parami)
  {
    AppMethodBeat.i(42468);
    parami = new a.1(this, this.context, parami);
    AppMethodBeat.o(42468);
    return parami;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.scaledLayout.a
 * JD-Core Version:    0.7.0.1
 */