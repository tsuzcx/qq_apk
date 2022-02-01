package com.tencent.mm.plugin.luckymoney.scaledLayout;

import android.content.Context;
import android.support.v7.widget.RecyclerView.LayoutManager;
import android.support.v7.widget.RecyclerView.r;
import android.support.v7.widget.RecyclerView.r.a;
import android.support.v7.widget.RecyclerView.s;
import android.support.v7.widget.ae;
import android.support.v7.widget.aj;
import android.support.v7.widget.ak;
import android.util.DisplayMetrics;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;

public final class a
  extends ak
{
  public Context context;
  public View yYd;
  public boolean yYe = false;
  
  public static View h(RecyclerView.LayoutManager paramLayoutManager)
  {
    Object localObject = null;
    AppMethodBeat.i(65323);
    int n = paramLayoutManager.getChildCount();
    if (n == 0)
    {
      AppMethodBeat.o(65323);
      return null;
    }
    aj localaj = aj.d(paramLayoutManager);
    int j;
    int k;
    if (paramLayoutManager.getClipToPadding())
    {
      j = localaj.kH() + localaj.kJ() / 2;
      int i = 2147483647;
      k = 0;
      label58:
      if (k >= n) {
        break label126;
      }
      View localView = paramLayoutManager.getChildAt(k);
      int m = Math.abs(localaj.bo(localView) + localaj.bs(localView) / 2 - j);
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
  
  public final int a(RecyclerView.LayoutManager paramLayoutManager, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(65322);
    if (paramLayoutManager.getItemCount() == 0)
    {
      AppMethodBeat.o(65322);
      return -1;
    }
    View localView2 = h(paramLayoutManager);
    if (localView2 == null)
    {
      AppMethodBeat.o(65322);
      return -1;
    }
    View localView1 = localView2;
    if (this.yYd != null)
    {
      localView1 = localView2;
      if (this.yYd != localView2) {
        localView1 = this.yYd;
      }
    }
    paramInt2 = paramLayoutManager.getPosition(localView1);
    Log.d("CusPager", "pos: %s", new Object[] { Integer.valueOf(paramInt2) });
    if ((paramInt1 >= 100) && (paramInt2 + 1 < paramLayoutManager.getItemCount()))
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
  
  public final View a(RecyclerView.LayoutManager paramLayoutManager)
  {
    AppMethodBeat.i(65321);
    View localView1 = super.a(paramLayoutManager);
    int i = 0;
    int j = 0;
    int k = 0;
    View localView2;
    if (i < paramLayoutManager.getChildCount())
    {
      localView2 = paramLayoutManager.getChildAt(i);
      if (localView2 != localView1) {
        break label118;
      }
      j = i;
    }
    label118:
    for (;;)
    {
      if (localView2 == this.yYd) {
        k = i;
      }
      i += 1;
      break;
      if (j - k > 1)
      {
        paramLayoutManager = paramLayoutManager.findViewByPosition(k + 1);
        AppMethodBeat.o(65321);
        return paramLayoutManager;
      }
      if (j - k < -1)
      {
        paramLayoutManager = paramLayoutManager.findViewByPosition(k - 1);
        AppMethodBeat.o(65321);
        return paramLayoutManager;
      }
      AppMethodBeat.o(65321);
      return localView1;
    }
  }
  
  public final RecyclerView.r g(final RecyclerView.LayoutManager paramLayoutManager)
  {
    AppMethodBeat.i(65324);
    if (this.yYe)
    {
      paramLayoutManager = super.g(paramLayoutManager);
      AppMethodBeat.o(65324);
      return paramLayoutManager;
    }
    paramLayoutManager = new ae(this.context)
    {
      public final float a(DisplayMetrics paramAnonymousDisplayMetrics)
      {
        return 50.0F / paramAnonymousDisplayMetrics.densityDpi;
      }
      
      public final void a(View paramAnonymousView, RecyclerView.s paramAnonymouss, RecyclerView.r.a paramAnonymousa)
      {
        AppMethodBeat.i(65319);
        paramAnonymousView = a.this.a(paramLayoutManager, paramAnonymousView);
        int i = paramAnonymousView[0];
        int j = paramAnonymousView[1];
        int k = cc(Math.max(Math.abs(i), Math.abs(j)));
        if (k > 0) {
          paramAnonymousa.a(i, j, k, this.VQ);
        }
        AppMethodBeat.o(65319);
      }
      
      public final int cd(int paramAnonymousInt)
      {
        AppMethodBeat.i(65320);
        paramAnonymousInt = Math.min(50, super.cd(paramAnonymousInt));
        AppMethodBeat.o(65320);
        return paramAnonymousInt;
      }
    };
    AppMethodBeat.o(65324);
    return paramLayoutManager;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.scaledLayout.a
 * JD-Core Version:    0.7.0.1
 */