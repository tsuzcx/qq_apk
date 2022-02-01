package com.tencent.mm.plugin.luckymoney.scaledLayout;

import android.content.Context;
import android.support.v7.widget.RecyclerView.i;
import android.support.v7.widget.RecyclerView.s;
import android.support.v7.widget.RecyclerView.s.a;
import android.support.v7.widget.RecyclerView.t;
import android.support.v7.widget.ae;
import android.support.v7.widget.aj;
import android.support.v7.widget.ak;
import android.util.DisplayMetrics;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ac;

public final class a
  extends ak
{
  public Context context;
  public View uos;
  public boolean uot = false;
  
  public static View h(RecyclerView.i parami)
  {
    Object localObject = null;
    AppMethodBeat.i(65323);
    int n = parami.getChildCount();
    if (n == 0)
    {
      AppMethodBeat.o(65323);
      return null;
    }
    aj localaj = aj.d(parami);
    int j;
    int k;
    if (parami.getClipToPadding())
    {
      j = localaj.kl() + localaj.kn() / 2;
      int i = 2147483647;
      k = 0;
      label58:
      if (k >= n) {
        break label126;
      }
      View localView = parami.getChildAt(k);
      int m = Math.abs(localaj.bn(localView) + localaj.br(localView) / 2 - j);
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
      AppMethodBeat.o(65323);
      return localObject;
    }
  }
  
  public final int a(RecyclerView.i parami, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(65322);
    if (parami.getItemCount() == 0)
    {
      AppMethodBeat.o(65322);
      return -1;
    }
    View localView2 = h(parami);
    if (localView2 == null)
    {
      AppMethodBeat.o(65322);
      return -1;
    }
    View localView1 = localView2;
    if (this.uos != null)
    {
      localView1 = localView2;
      if (this.uos != localView2) {
        localView1 = this.uos;
      }
    }
    paramInt2 = RecyclerView.i.bB(localView1);
    ac.d("CusPager", "pos: %s", new Object[] { Integer.valueOf(paramInt2) });
    if ((paramInt1 >= 100) && (paramInt2 + 1 < parami.getItemCount()))
    {
      AppMethodBeat.o(65322);
      return paramInt2 + 1;
    }
    if ((paramInt1 <= -100) && (paramInt2 - 1 >= 0))
    {
      AppMethodBeat.o(65322);
      return paramInt2 - 1;
    }
    AppMethodBeat.o(65322);
    return paramInt2;
  }
  
  public final View a(RecyclerView.i parami)
  {
    AppMethodBeat.i(65321);
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
      if (localView2 == this.uos) {
        k = i;
      }
      i += 1;
      break;
      if (j - k > 1)
      {
        parami = parami.bY(k + 1);
        AppMethodBeat.o(65321);
        return parami;
      }
      if (j - k < -1)
      {
        parami = parami.bY(k - 1);
        AppMethodBeat.o(65321);
        return parami;
      }
      AppMethodBeat.o(65321);
      return localView1;
    }
  }
  
  public final RecyclerView.s g(final RecyclerView.i parami)
  {
    AppMethodBeat.i(65324);
    if (this.uot)
    {
      parami = super.g(parami);
      AppMethodBeat.o(65324);
      return parami;
    }
    parami = new ae(this.context)
    {
      public final float a(DisplayMetrics paramAnonymousDisplayMetrics)
      {
        return 50.0F / paramAnonymousDisplayMetrics.densityDpi;
      }
      
      public final void a(View paramAnonymousView, RecyclerView.t paramAnonymoust, RecyclerView.s.a paramAnonymousa)
      {
        AppMethodBeat.i(65319);
        paramAnonymousView = a.this.a(parami, paramAnonymousView);
        int i = paramAnonymousView[0];
        int j = paramAnonymousView[1];
        int k = cd(Math.max(Math.abs(i), Math.abs(j)));
        if (k > 0) {
          paramAnonymousa.a(i, j, k, this.TN);
        }
        AppMethodBeat.o(65319);
      }
      
      public final int ce(int paramAnonymousInt)
      {
        AppMethodBeat.i(65320);
        paramAnonymousInt = Math.min(50, super.ce(paramAnonymousInt));
        AppMethodBeat.o(65320);
        return paramAnonymousInt;
      }
    };
    AppMethodBeat.o(65324);
    return parami;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.scaledLayout.a
 * JD-Core Version:    0.7.0.1
 */