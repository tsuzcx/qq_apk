package com.tencent.mm.plugin.luckymoney.scaledLayout;

import android.content.Context;
import android.support.v7.widget.RecyclerView.i;
import android.support.v7.widget.RecyclerView.r.a;
import android.support.v7.widget.RecyclerView.s;
import android.support.v7.widget.ae;
import android.util.DisplayMetrics;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class a$1
  extends ae
{
  a$1(a parama, Context paramContext, RecyclerView.i parami)
  {
    super(paramContext);
  }
  
  public final float a(DisplayMetrics paramDisplayMetrics)
  {
    return 50.0F / paramDisplayMetrics.densityDpi;
  }
  
  public final void a(View paramView, RecyclerView.s params, RecyclerView.r.a parama)
  {
    AppMethodBeat.i(65319);
    paramView = this.tgg.a(this.tgf, paramView);
    int i = paramView[0];
    int j = paramView[1];
    int k = cd(Math.max(Math.abs(i), Math.abs(j)));
    if (k > 0) {
      parama.a(i, j, k, this.SS);
    }
    AppMethodBeat.o(65319);
  }
  
  public final int ce(int paramInt)
  {
    AppMethodBeat.i(65320);
    paramInt = Math.min(50, super.ce(paramInt));
    AppMethodBeat.o(65320);
    return paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.scaledLayout.a.1
 * JD-Core Version:    0.7.0.1
 */