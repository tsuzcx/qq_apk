package com.tencent.mm.plugin.luckymoney.scaledLayout;

import android.content.Context;
import android.support.v7.widget.RecyclerView.i;
import android.support.v7.widget.RecyclerView.r.a;
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
  
  public final void a(View paramView, RecyclerView.r.a parama)
  {
    AppMethodBeat.i(42463);
    paramView = this.oqa.a(this.opZ, paramView);
    int i = paramView[0];
    int j = paramView[1];
    int k = bL(Math.max(Math.abs(i), Math.abs(j)));
    if (k > 0) {
      parama.a(i, j, k, this.LP);
    }
    AppMethodBeat.o(42463);
  }
  
  public final int bM(int paramInt)
  {
    AppMethodBeat.i(42464);
    paramInt = Math.min(50, super.bM(paramInt));
    AppMethodBeat.o(42464);
    return paramInt;
  }
  
  public final float c(DisplayMetrics paramDisplayMetrics)
  {
    return 50.0F / paramDisplayMetrics.densityDpi;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.scaledLayout.a.1
 * JD-Core Version:    0.7.0.1
 */