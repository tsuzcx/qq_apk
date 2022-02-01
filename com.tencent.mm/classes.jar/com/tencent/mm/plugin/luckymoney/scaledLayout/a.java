package com.tencent.mm.plugin.luckymoney.scaledLayout;

import android.content.Context;
import android.util.DisplayMetrics;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView.LayoutManager;
import androidx.recyclerview.widget.RecyclerView.r;
import androidx.recyclerview.widget.RecyclerView.r.a;
import androidx.recyclerview.widget.RecyclerView.s;
import androidx.recyclerview.widget.p;
import androidx.recyclerview.widget.u;
import androidx.recyclerview.widget.v;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;

public final class a
  extends v
{
  public View ECm;
  public boolean ECn = false;
  public Context context;
  
  public static View h(RecyclerView.LayoutManager paramLayoutManager)
  {
    Object localObject = null;
    AppMethodBeat.i(227496);
    int n = paramLayoutManager.getChildCount();
    if (n == 0)
    {
      AppMethodBeat.o(227496);
      return null;
    }
    u localu = u.d(paramLayoutManager);
    int j;
    int k;
    if (paramLayoutManager.getClipToPadding())
    {
      j = localu.kT() + localu.kV() / 2;
      int i = 2147483647;
      k = 0;
      label58:
      if (k >= n) {
        break label126;
      }
      View localView = paramLayoutManager.getChildAt(k);
      int m = Math.abs(localu.aZ(localView) + localu.bd(localView) / 2 - j);
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
      j = localu.getEnd() / 2;
      break;
      label126:
      AppMethodBeat.o(227496);
      return localObject;
    }
  }
  
  public final int a(RecyclerView.LayoutManager paramLayoutManager, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(227491);
    if (paramLayoutManager.getItemCount() == 0)
    {
      AppMethodBeat.o(227491);
      return -1;
    }
    View localView2 = h(paramLayoutManager);
    if (localView2 == null)
    {
      AppMethodBeat.o(227491);
      return -1;
    }
    View localView1 = localView2;
    if (this.ECm != null)
    {
      localView1 = localView2;
      if (this.ECm != localView2) {
        localView1 = this.ECm;
      }
    }
    paramInt2 = paramLayoutManager.getPosition(localView1);
    Log.d("CusPager", "pos: %s", new Object[] { Integer.valueOf(paramInt2) });
    if ((paramInt1 >= 100) && (paramInt2 + 1 < paramLayoutManager.getItemCount()))
    {
      AppMethodBeat.o(227491);
      return paramInt2 + 1;
    }
    if ((paramInt1 <= -100) && (paramInt2 - 1 >= 0))
    {
      AppMethodBeat.o(227491);
      return paramInt2 - 1;
    }
    AppMethodBeat.o(227491);
    return paramInt2;
  }
  
  public final View a(RecyclerView.LayoutManager paramLayoutManager)
  {
    AppMethodBeat.i(227484);
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
      if (localView2 == this.ECm) {
        k = i;
      }
      i += 1;
      break;
      if (j - k > 1)
      {
        paramLayoutManager = paramLayoutManager.findViewByPosition(k + 1);
        AppMethodBeat.o(227484);
        return paramLayoutManager;
      }
      if (j - k < -1)
      {
        paramLayoutManager = paramLayoutManager.findViewByPosition(k - 1);
        AppMethodBeat.o(227484);
        return paramLayoutManager;
      }
      AppMethodBeat.o(227484);
      return localView1;
    }
  }
  
  public final RecyclerView.r g(final RecyclerView.LayoutManager paramLayoutManager)
  {
    AppMethodBeat.i(227498);
    if (this.ECn)
    {
      paramLayoutManager = super.g(paramLayoutManager);
      AppMethodBeat.o(227498);
      return paramLayoutManager;
    }
    paramLayoutManager = new p(this.context)
    {
      public final float a(DisplayMetrics paramAnonymousDisplayMetrics)
      {
        return 50.0F / paramAnonymousDisplayMetrics.densityDpi;
      }
      
      public final void a(View paramAnonymousView, RecyclerView.s paramAnonymouss, RecyclerView.r.a paramAnonymousa)
      {
        AppMethodBeat.i(228389);
        paramAnonymousView = a.this.a(paramLayoutManager, paramAnonymousView);
        int i = paramAnonymousView[0];
        int j = paramAnonymousView[1];
        int k = cE(Math.max(Math.abs(i), Math.abs(j)));
        if (k > 0) {
          paramAnonymousa.a(i, j, k, this.aju);
        }
        AppMethodBeat.o(228389);
      }
      
      public final int cF(int paramAnonymousInt)
      {
        AppMethodBeat.i(65320);
        paramAnonymousInt = Math.min(50, super.cF(paramAnonymousInt));
        AppMethodBeat.o(65320);
        return paramAnonymousInt;
      }
    };
    AppMethodBeat.o(227498);
    return paramLayoutManager;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.scaledLayout.a
 * JD-Core Version:    0.7.0.1
 */