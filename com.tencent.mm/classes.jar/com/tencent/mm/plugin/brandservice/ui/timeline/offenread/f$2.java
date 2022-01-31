package com.tencent.mm.plugin.brandservice.ui.timeline.offenread;

import android.content.Context;
import android.graphics.PointF;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.af;
import android.util.DisplayMetrics;
import com.tencent.mm.sdk.platformtools.y;

final class f$2
  extends af
{
  f$2(f paramf, Context paramContext)
  {
    super(paramContext);
  }
  
  protected final float a(DisplayMetrics paramDisplayMetrics)
  {
    return 40.0F / paramDisplayMetrics.densityDpi;
  }
  
  public final PointF bD(int paramInt)
  {
    return ((LinearLayoutManager)this.ihO.ihL.getLayoutManager()).bD(paramInt);
  }
  
  protected final int he()
  {
    return -1;
  }
  
  protected final void onStop()
  {
    super.onStop();
    y.i("MicroMsg.BizTimeLineViewPagerHelper", "alvinluo SmoothScrollerForFling onStop %d", new Object[] { Integer.valueOf(this.ihO.ihL.getScrollState()) });
    if (this.ihO.ihL.getScrollState() == 0) {
      this.ihO.ata();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.timeline.offenread.f.2
 * JD-Core Version:    0.7.0.1
 */