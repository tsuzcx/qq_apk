package com.tencent.mm.plugin.appbrand.widget.recentview;

import android.content.Context;
import android.graphics.PointF;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.af;
import android.util.DisplayMetrics;
import com.tencent.mm.sdk.platformtools.y;

final class e$2
  extends af
{
  e$2(e parame, Context paramContext)
  {
    super(paramContext);
  }
  
  protected final float a(DisplayMetrics paramDisplayMetrics)
  {
    return 40.0F / paramDisplayMetrics.densityDpi;
  }
  
  public final PointF bD(int paramInt)
  {
    return ((LinearLayoutManager)this.hDD.hDp.getLayoutManager()).bD(paramInt);
  }
  
  protected final int he()
  {
    return -1;
  }
  
  protected final void onStop()
  {
    super.onStop();
    y.i("ViewPagerHelper", "alvinluo SmoothScrollerForFling onStop %d", new Object[] { Integer.valueOf(this.hDD.hDp.getScrollState()) });
    if (this.hDD.hDp.getScrollState() == 0) {
      this.hDD.ata();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.recentview.e.2
 * JD-Core Version:    0.7.0.1
 */