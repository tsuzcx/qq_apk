package android.support.v7.widget;

import android.content.Context;
import android.util.DisplayMetrics;
import android.view.View;

final class ak$1
  extends ae
{
  ak$1(ak paramak, Context paramContext)
  {
    super(paramContext);
  }
  
  protected final float a(DisplayMetrics paramDisplayMetrics)
  {
    return 100.0F / paramDisplayMetrics.densityDpi;
  }
  
  protected final void a(View paramView, RecyclerView.s params, RecyclerView.r.a parama)
  {
    paramView = this.aoK.a(this.aoK.akA.getLayoutManager(), paramView);
    int i = paramView[0];
    int j = paramView[1];
    int k = cd(Math.max(Math.abs(i), Math.abs(j)));
    if (k > 0) {
      parama.a(i, j, k, this.SS);
    }
  }
  
  protected final int ce(int paramInt)
  {
    return Math.min(100, super.ce(paramInt));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     android.support.v7.widget.ak.1
 * JD-Core Version:    0.7.0.1
 */