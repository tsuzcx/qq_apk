package android.support.v7.widget;

import android.content.Context;
import android.util.DisplayMetrics;
import android.view.View;

final class at$2
  extends ae
{
  at$2(at paramat, Context paramContext)
  {
    super(paramContext);
  }
  
  protected final void a(View paramView, RecyclerView.r.a parama)
  {
    if (this.amB.adt == null) {}
    int i;
    int j;
    int k;
    do
    {
      return;
      paramView = this.amB.a(this.amB.adt.getLayoutManager(), paramView);
      i = paramView[0];
      j = paramView[1];
      k = bL(Math.max(Math.abs(i), Math.abs(j)));
    } while (k <= 0);
    parama.a(i, j, k, this.LP);
  }
  
  protected final float c(DisplayMetrics paramDisplayMetrics)
  {
    return 100.0F / paramDisplayMetrics.densityDpi;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     android.support.v7.widget.at.2
 * JD-Core Version:    0.7.0.1
 */