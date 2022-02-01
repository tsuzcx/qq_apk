package com.tencent.mm.plugin.luckymoney.scaledLayout;

import android.content.Context;
import android.util.DisplayMetrics;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView.LayoutManager;
import androidx.recyclerview.widget.RecyclerView.r;
import androidx.recyclerview.widget.RecyclerView.r.a;
import androidx.recyclerview.widget.RecyclerView.s;
import androidx.recyclerview.widget.o;
import androidx.recyclerview.widget.s;
import androidx.recyclerview.widget.t;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;

public final class a
  extends t
{
  public boolean Kvr = false;
  public Context context;
  public View startView;
  
  public static View j(RecyclerView.LayoutManager paramLayoutManager)
  {
    Object localObject = null;
    AppMethodBeat.i(283863);
    int n = paramLayoutManager.getChildCount();
    if (n == 0)
    {
      AppMethodBeat.o(283863);
      return null;
    }
    s locals = s.d(paramLayoutManager);
    int j;
    int k;
    if (paramLayoutManager.getClipToPadding())
    {
      j = locals.JE() + locals.JG() / 2;
      int i = 2147483647;
      k = 0;
      label58:
      if (k >= n) {
        break label126;
      }
      View localView = paramLayoutManager.getChildAt(k);
      int m = Math.abs(locals.bs(localView) + locals.bw(localView) / 2 - j);
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
      j = locals.getEnd() / 2;
      break;
      label126:
      AppMethodBeat.o(283863);
      return localObject;
    }
  }
  
  public final int a(RecyclerView.LayoutManager paramLayoutManager, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(283867);
    if (paramLayoutManager.getItemCount() == 0)
    {
      AppMethodBeat.o(283867);
      return -1;
    }
    View localView2 = j(paramLayoutManager);
    if (localView2 == null)
    {
      AppMethodBeat.o(283867);
      return -1;
    }
    View localView1 = localView2;
    if (this.startView != null)
    {
      localView1 = localView2;
      if (this.startView != localView2) {
        localView1 = this.startView;
      }
    }
    paramInt2 = paramLayoutManager.getPosition(localView1);
    Log.d("CusPager", "pos: %s", new Object[] { Integer.valueOf(paramInt2) });
    if ((paramInt1 >= 100) && (paramInt2 + 1 < paramLayoutManager.getItemCount()))
    {
      AppMethodBeat.o(283867);
      return paramInt2 + 1;
    }
    if ((paramInt1 <= -100) && (paramInt2 - 1 >= 0))
    {
      AppMethodBeat.o(283867);
      return paramInt2 - 1;
    }
    AppMethodBeat.o(283867);
    return paramInt2;
  }
  
  public final View a(RecyclerView.LayoutManager paramLayoutManager)
  {
    AppMethodBeat.i(283865);
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
      if (localView2 == this.startView) {
        k = i;
      }
      i += 1;
      break;
      if (j - k > 1)
      {
        paramLayoutManager = paramLayoutManager.findViewByPosition(k + 1);
        AppMethodBeat.o(283865);
        return paramLayoutManager;
      }
      if (j - k < -1)
      {
        paramLayoutManager = paramLayoutManager.findViewByPosition(k - 1);
        AppMethodBeat.o(283865);
        return paramLayoutManager;
      }
      AppMethodBeat.o(283865);
      return localView1;
    }
  }
  
  public final RecyclerView.r g(final RecyclerView.LayoutManager paramLayoutManager)
  {
    AppMethodBeat.i(283868);
    if (this.Kvr)
    {
      paramLayoutManager = super.g(paramLayoutManager);
      AppMethodBeat.o(283868);
      return paramLayoutManager;
    }
    paramLayoutManager = new o(this.context)
    {
      public final void a(View paramAnonymousView, RecyclerView.s paramAnonymouss, RecyclerView.r.a paramAnonymousa)
      {
        AppMethodBeat.i(283862);
        paramAnonymousView = a.this.a(paramLayoutManager, paramAnonymousView);
        int i = paramAnonymousView[0];
        int j = paramAnonymousView[1];
        int k = fO(Math.max(Math.abs(i), Math.abs(j)));
        if (k > 0) {
          paramAnonymousa.a(i, j, k, this.bXY);
        }
        AppMethodBeat.o(283862);
      }
      
      public final float c(DisplayMetrics paramAnonymousDisplayMetrics)
      {
        return 50.0F / paramAnonymousDisplayMetrics.densityDpi;
      }
      
      public final int fP(int paramAnonymousInt)
      {
        AppMethodBeat.i(65320);
        paramAnonymousInt = Math.min(50, super.fP(paramAnonymousInt));
        AppMethodBeat.o(65320);
        return paramAnonymousInt;
      }
    };
    AppMethodBeat.o(283868);
    return paramLayoutManager;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.scaledLayout.a
 * JD-Core Version:    0.7.0.1
 */